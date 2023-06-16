#!/bin/bash
set -m

/entrypoint.sh couchbase-server &

sleep 15

# Setup initial cluster
couchbase-cli cluster-init -c 127.0.0.1 --cluster-username admin --cluster-password password --services data,index,query,fts,analytics,eventing --cluster-ramsize 512 --cluster-index-ramsize 256 --cluster-fts-ramsize 256 --cluster-eventing-ramsize 256 --cluster-analytics-ramsize 1024

# Create the bucket
couchbase-cli bucket-create -c 127.0.0.1 -u admin -p password --bucket my_bucket_name --bucket-type couchbase --bucket-ramsize 256

# Create user
couchbase-cli user-manage -c 127.0.0.1:8091 -u admin -p password --set --rbac-username myApp --rbac-password myAppPassword --rbac-name "myApp" --roles admin --auth-domain local

# Wait for N1QL service to be up
sleep 30

# Wait for the bucket to be ready
until $(couchbase-cli bucket-list -c 127.0.0.1:8091 -u admin -p password | grep -q "my_bucket_name"); do
  sleep 5
done

# Create primary index on the bucket using HTTP request
curl -v -X POST -u myApp:myAppPassword -d 'statement=CREATE PRIMARY INDEX ON `my_bucket_name` USING GSI' http://localhost:8093/query/service

fg 1

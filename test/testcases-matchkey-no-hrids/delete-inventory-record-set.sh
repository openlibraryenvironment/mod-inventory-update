tenant=diku
username=diku_admin
password=admin
protocol=http
host=localhost:9130
file=$1

token=$(curl -s -X POST -D - -H "Content-type: application/json" -H "X-Okapi-Tenant: $tenant"  -d "{ \"username\": \"$username\", \"password\": \"$password\"}" "$protocol://$host/authn/login" | grep x-okapi-token | tr -d '\r' | cut -d " " -f2)

curl -X DELETE -D - \
  -H "Content-type: application/json" \
  -H "X-Okapi-Tenant: $tenant" \
  -H "X-Okapi-Token: $token" \
  -d @$file $protocol://$host/shared-inventory-upsert-matchkey

echo 
echo `date`
echo


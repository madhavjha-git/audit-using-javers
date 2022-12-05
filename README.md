# audit-using-javers
Data Auditing using Javers for NO-SQL MongoDb


# Sample Payload:
POST: http://localhost:8081/audit/api/save
{
    "id": "6389e117fa05ff2ecfc05461",
    "trxId": "123YY",
    "product": {
        "attributes": {
            "type": "Color",
            "data": {
                "id": 1,
                "value": "Yellow"
            }
        }
    }
}

# APIs
Get Shadow(*Fails for nested generic types*)
GET:http://localhost:8081/audit/api/last-update/6389e117fa05ff2ecfc05461

Get Changes
GET: http://localhost:8081/audit/api/changes/6389e117fa05ff2ecfc05461

Get Changes(Pretty Format)
http://localhost:8081/audit/api/changes-pretty/6389e117fa05ff2ecfc05461

## Create Meeting
### POST com.codeforcommunity.api/v1/meeting

##### Body
```json
{
  "meetingName": "Meeting Name"
}
```

##### Return
```json
{
  "status": "SUCCESS"
}
```

## Check in
### POST com.codeforcommunity.api/v1/meeting/:meetingId

##### Body
```json
{
  "email": "email"
}
```

##### Return
If the member is already registered:
```json
{
  "status": "SUCCESS"
}
```

If this is the first time the member is attending:
```json
{
  "status": "NEED_INFO"
}
```

## Create Member
### POST com.codeforcommunity.api/v1/member

##### Body
```json
{
  "firstName": "First Name",
  "lastName": "Last Name",
  "major": "Major",
  "graduationYear": 2020
}
```

##### Return
```json
{
  "status": "SUCCESS"
}
```

## Close Meeting
### PUT com.codeforcommunity.api/v1/meeting/:meetingId/

##### Return
```json
{
  "status": "SUCCESS"
}
```

## Get Attendees
### GET com.codeforcommunity.api/v1/meeting/:meetingId

##### Return
```json
{
  "attendees": [
    {
      "firstName": "First Name",
      "lastName": "Last Name"
    }
  ]
}
```


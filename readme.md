### ****This project Developed By Hibernate Spetial ,Postgis,Postgresql****

Main goal of this project is location based rest api.Use Observer  and  Builder design pattern.
Use spesific distance calculation query with long and lat and postgis methods


_If you want run my project on locally follow this steps in project directory;_

`docker-compose up`

and run **schema.sql** and **data.sql** script in postgres db with ordered

**Our api has 2 end point** 

First is  **/saveCourierLog**  this endpoint support POST method and give 4 spesific input

logTime:2020-08-16 23:17:47 -> logTime parameter must be yyyy-mm-dd hh:mm:ss format such as 2020-08-16 23:17:47

courierId:1 ->If create new courier insert to courier table

lng:29.124422 

lat:40.992330

Then Return response as 

{

    "httpStatus": "OK",
    "operationMessage": "Courier log insert with success",
    "success": true,
    "insertedLog": {
        "courierLogId": "6ffee27b-f4af-421d-9fc1-78c29732e7b0",
        "courierId": 1,
        "activateDate": "2020-08-16T23:17:47.000+00:00",
        "notify": true
    }





Second  is  **/getTotalTravelDistance**  this endpoint support GET method and give an spesific input


courierId:1

Then Return response as 


{

    "httpStatus": "OK",
    "operationMessage": "Courier total distance get with success",
    "success": true,
    "courierId": 1,
    "totalDistance": 0.3544275164814566
}
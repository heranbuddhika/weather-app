# weather-app
This is an example for REST API built with pure servlet.

1. **Weather service:**  
Endpoint(GET) -  http://localhost:8080/WeatherApp/weather-service?cityCode=KU  
Sample parameters for 'cityCode' - CMB, KY, KU

2. **Geo Location Service:**
Endpoint(POST) - http://localhost:8080/WeatherApp/geo-service  
Sample POST body -  
      `{
          "zipCode": "65046"
      }`  
Sample parameters for 'zipCode' - 47578, 83870, 65046

package com.example.producingwebservice;


import io.spring.guides.gs_producing_web_service3.ArrayOfWeatherData;
import io.spring.guides.gs_producing_web_service3.GetWeatherByPlaceName;
import io.spring.guides.gs_producing_web_service3.GetWeatherByPlaceNameResponse;
import io.spring.guides.gs_producing_web_service3.WeatherForecasts;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class WeatherEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service3";

@PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetWeatherByPlaceName")
@ResponsePayload
   public GetWeatherByPlaceNameResponse GetWeatherByPlaceName(@RequestPayload GetWeatherByPlaceName request){
        GetWeatherByPlaceNameResponse response = new GetWeatherByPlaceNameResponse();
       WeatherForecasts weatherForecasts = new WeatherForecasts();
       weatherForecasts.setLatitude(1.0f);
         weatherForecasts.setLongitude(1.0f);

            weatherForecasts.setAllocationFactor(1.0f);
            weatherForecasts.setFipsCode("fipsCode");
            weatherForecasts.setPlaceName(request.getPlaceName());
            weatherForecasts.setStateCode("stateCode");
            weatherForecasts.setStatus("status");
            weatherForecasts.setDetails(new ArrayOfWeatherData());


        response.setGetWeatherByPlaceNameResult(weatherForecasts);
       return response;
   }
}

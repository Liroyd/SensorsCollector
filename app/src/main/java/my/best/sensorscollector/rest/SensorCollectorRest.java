package my.best.sensorscollector.rest;


import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

import my.best.sensorscollector.model.Sensor;

public interface SensorCollectorRest {
    @GET("json")
    Call<List<Sensor>> getData();
}

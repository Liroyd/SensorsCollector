package my.best.sensorscollector.model;

public class Sensor {

    private String id;
    private Float temperature;

    public Sensor(String id, Float temperature) {
        this.id = id;
        this.temperature = temperature;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Float getTemperature() {
        return temperature;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }
}

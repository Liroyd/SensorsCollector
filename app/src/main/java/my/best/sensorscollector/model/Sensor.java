package my.best.sensorscollector.model;

public class Sensor {

    private String id;
    private Float value;

    public Sensor(String id, Float temperature) {
        this.id = id;
        this.value = temperature;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Float getValue() {
        return value;
    }

    public void setValue(Float value) {
        this.value = value;
    }
}

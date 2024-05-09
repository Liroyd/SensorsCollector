package my.best.sensorscollector;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;
import java.util.Objects;

import my.best.sensorscollector.model.Sensor;
import my.best.sensorscollector.rest.RetrofitInstance;
import my.best.sensorscollector.rest.SensorCollectorRest;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Button refresh;
    TextView sensorOne;
    TextView sensorTwo;
    TextView sensorThree;

    EditText addressInput;

    String SensorOneId = "26";
    String SensorTwoId = "27";
    String SensorThreeId = "28";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initElements();
        setDummyValues();

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SensorCollectorRest restClient = RetrofitInstance.getRetrofitInstance().create(SensorCollectorRest.class);

                Call<List<Sensor>> call = restClient.getData();
                // on below line adding an enqueue to parse the data from api.
                call.enqueue(new Callback<List<Sensor>>() {
                    // on below line calling on response method.
                    @Override
                    public void onResponse(@NonNull Call<List<Sensor>> call, @NonNull Response<List<Sensor>> response) {
                        // inside on response method setting text from our api response.
                        for (Sensor sensor : Objects.requireNonNull(response.body())) {
                            if (SensorOneId.equals(sensor.getId())) {
                                sensorOne.setText(String.valueOf(sensor.getValue()));
                            } else if (SensorTwoId.equals(sensor.getId())) {
                                sensorTwo.setText(String.valueOf(sensor.getValue()));
                            } else if (SensorThreeId.equals(sensor.getId())) {
                                sensorThree.setText(String.valueOf(sensor.getValue()));
                            }
                        }
                    }
                    // on below line calling on failure method.
                    @Override
                    public void onFailure(Call<List<Sensor>> call, Throwable t) {

                        System.out.println("error " + t.getMessage());
                        // displaying a toast message when as error is received.
                        ///Toast.makeText(MainActivity.this, "Fail to get the data..", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    public void initElements() {
        refresh = findViewById(R.id.buttonRefresh);

        sensorOne = findViewById(R.id.sensorTemperature1);
        sensorTwo = findViewById(R.id.sensorTemperature2);
        sensorThree = findViewById(R.id.sensorTemperature3);

        addressInput = findViewById(R.id.addressInput);
    }

    public void setDummyValues() {
        sensorOne.setText("1");
        sensorTwo.setText("5");
        sensorThree.setText("10");
    }
}
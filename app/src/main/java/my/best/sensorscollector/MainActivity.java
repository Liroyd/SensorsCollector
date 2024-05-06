package my.best.sensorscollector;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button refresh;
    TextView sensorOne;
    TextView sensorTwo;
    TextView sensorThree;

    EditText addressInput;

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
                sensorOne.setText(String.valueOf(Integer.parseInt(sensorOne.getText().toString())+1));
                sensorTwo.setText(String.valueOf(Integer.parseInt(sensorTwo.getText().toString())+5));
                sensorThree.setText(String.valueOf(Integer.parseInt(sensorThree.getText().toString())+10));
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
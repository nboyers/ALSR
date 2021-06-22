package frent.nobos.stratApex.views;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import com.google.firebase.FirebaseApp;

import frent.nobos.stratApex.R;

//TODO: Work on passing the data (Duos or not) from Main activity to Roulette View

/**
 * When the app starts
 * this is the Starting UI the
 * user sees
 * Last Edited: 2021-05-01
 * @author Noah Boyers
 */
public class MainActivity extends AppCompatActivity {

    public static final String TEXT_TO_SEND = "frent.nobos.stratApex";
    public static final String BOOL_TO_SEND = "frent.nobos.duos";
    private Button Oly_btm,worldEdge_btn;
    SwitchCompat duo_Toggle;
    private String sendToActivity;
    private boolean sendToGame = false; // Default Value


    /**
     *
     * @param savedInstanceState - mapping from String keys to various Parcelable values.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(this);

        setContentView(R.layout.activity_main);
    //   King_btn = findViewById(R.id.kingsCanyon_button);
        Oly_btm = findViewById(R.id.olympus_Button);
        duo_Toggle = findViewById(R.id.duoSwitch);
        worldEdge_btn = findViewById(R.id.worldsEdge_Button);


        //THIS LINE DOESNT NEED TO BE IN THE ACTIVE CODE
/*
        King_btn.setOnClickListener(v -> {
            sendToActivity = King_btn.getText().toString();
            duo_State = duo_Toggle.isChecked();
            goToActivity();
        });
        */
        Oly_btm.setOnClickListener(v -> {
            sendToActivity = Oly_btm.getText().toString();
            sendToGame = duo_Toggle.isChecked();
            goToActivity();
        });
        worldEdge_btn.setOnClickListener(v -> {
            sendToActivity = worldEdge_btn.getText().toString();
            sendToGame = duo_Toggle.isChecked();
            goToActivity();
        });
    }


    /**
     * Method that takes the user to the next activity
     * while passing which map they are on and if
     * the gamemode is duos or trios
     */
    private void goToActivity() {
        Intent intent = new Intent(this, RouletteGUI.class); // Sends what map
        intent.putExtra(TEXT_TO_SEND, sendToActivity);
        intent.putExtra(BOOL_TO_SEND, sendToGame);
        startActivity(intent);
    }
}

package frent.nobos.stratApex.views;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Debug;
import android.os.StrictMode;
import android.widget.Button;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import com.google.firebase.FirebaseApp;

import java.util.concurrent.Executors;

import frent.nobos.stratApex.R;



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
    private Button Oly_btm,worldEdge_btn, king_btn;
    SwitchCompat duo_Toggle;
    private String sendToActivity;
    private boolean sendToGame = false; // Default Value


    /**
     *
     * @param savedInstanceState - mapping from String keys to various Parcelable values.
     */
    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(this);

        if (Debug.isDebuggerConnected()) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                    .detectDiskReads()
                    .detectDiskWrites()
                    .detectNetwork()   // or .detectAll() for all detectable problems
                    .penaltyLog()
                    .build());

            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                    .detectNonSdkApiUsage()
                    .penaltyListener( Executors.newSingleThreadExecutor() , v -> {

                    })
                    .detectLeakedSqlLiteObjects()
                    .detectLeakedClosableObjects()
                    .penaltyLog()
                    .penaltyDeath()
                    .build());
        }

        setContentView(R.layout.activity_main);
    //   King_btn = findViewById(R.id.kingsCanyon_button);
        Oly_btm = findViewById(R.id.olympus_Button);
        duo_Toggle = findViewById(R.id.duoSwitch);
        king_btn = findViewById(R.id.kingsCanyon_button);
        worldEdge_btn = findViewById(R.id.worldsEdge_Button);


        //THIS LINE DOESNT NEED TO BE IN THE ACTIVE CODE
        king_btn.setOnClickListener(v -> {
            sendToActivity =  king_btn.getText().toString();
            sendToGame = duo_Toggle.isChecked();
            goToActivity();
        });

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

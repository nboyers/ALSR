package frent.nobos.stratApex.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import frent.nobos.stratApex.R;
import frent.nobos.stratApex.databinding.ActivityMainBinding;

/**
 * When the app starts
 * this is the Starting UI the
 * user sees
 * Last Edited: 2021-05-01
 * @author Noah Boyers
 */
public class MainActivity extends AppCompatActivity {

    public static final String TEXT_TO_SEND = "frent.nobos.stratApex";
    private Button King_btn,Oly_btm,worldEdge_btn;
    private String sendToActivity;

    /**
     *
     * @param savedInstanceState - mapping from String keys to various Parcelable values.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        King_btn = findViewById(R.id.kingsCanyon_button);
        Oly_btm = findViewById(R.id.olympus_Button);
        worldEdge_btn = findViewById(R.id.worldsEdge_Button);

        King_btn.setOnClickListener(v -> {
            sendToActivity = King_btn.getText().toString();
            goToActivity();
        });
        Oly_btm.setOnClickListener(v -> {
            sendToActivity = Oly_btm.getText().toString();
            goToActivity();
        });
        worldEdge_btn.setOnClickListener(v -> {
            sendToActivity = worldEdge_btn.getText().toString();
            goToActivity();
        });
        MobileAds.initialize(this, initializationStatus -> {
        });
        
    }

    /**
     * Method that takes the user to the next activity
     * while passing which map they are on
     */
    private void goToActivity() {
        Intent intent = new Intent(this, RouletteGUI.class);
         intent.putExtra(TEXT_TO_SEND, sendToActivity);
         startActivity(intent);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
    }

}

package frent.nobos.stratApex.views;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
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
    private Button Oly_btm,worldEdge_btn;
    private SwitchCompat duo_Toggle;
    private Boolean duo_State = false;
    private String sendToActivity;
    private AdView adView;


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
            duo_State = duo_Toggle.isChecked();
            goToActivity();
        });
        worldEdge_btn.setOnClickListener(v -> {
            sendToActivity = worldEdge_btn.getText().toString();
            duo_State = duo_Toggle.isChecked();
            goToActivity();
        });

        //THINGY FOR ADS
        FrameLayout adContainerView = findViewById(R.id.ad_view_container_main);
        adView = new AdView(this);
        adView.setAdUnitId("ca-app-pub-7542723422099323/1201073201");
        adContainerView.addView(adView);
        loadBanner();
    }

    @Override
    public void onResume() {
        super.onResume();
        // Resume the AdView.
        adView.resume();
    }

    @Override
    public void onPause() {
        // Pause the AdView.
        adView.pause();
        super.onPause();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        adView.destroy();
    }

    /**
     * Method that takes the user to the next activity
     * while passing which map they are on and if
     * the gamemode is duos or trios
     */
    private void goToActivity() {

        Intent intent = new Intent(this, RouletteGUI.class); // Sends what map
        Intent intent1 = new Intent(this,RouletteGUI.class); //sends duos or trios
        intent1.putExtra(TEXT_TO_SEND,duo_State);
        intent.putExtra(TEXT_TO_SEND, sendToActivity);
        startActivity(intent);
        startActivity(intent1);
    }



    /**
     * Load the View with ads
     */
    public void loadBanner() {

        AdRequest adRequest = new AdRequest.Builder().build();
        AdSize adSize = getAdSize();

        // Set the adaptive ad size on the ad view.
        adView.setAdSize(adSize);

        //  Start loading the ad in the background.
        adView.loadAd(adRequest);
    }

    /**
     * Method that makes the ads fit in the user's screen
     * @return - size of the screen for ads
     */
    private AdSize getAdSize() {
        //  Determine the screen width (less decorations) to use for the ad width.
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);

        float widthPixels = outMetrics.widthPixels;
        float density = outMetrics.density;

        int adWidth = (int) (widthPixels / density);

        //  Get adaptive ad size and return for setting on the ad view.
        return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(this, adWidth);
    }
}

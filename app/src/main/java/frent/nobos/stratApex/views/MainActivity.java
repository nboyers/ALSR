package frent.nobos.stratApex.views;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.FirebaseApp;

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
    private Button King_btn,Oly_btm,worldEdge_btn;
    private String sendToActivity;
    private String FAIL = "FAILED";

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
            //THINGY FOR ADS
            FrameLayout adContainerView = findViewById(R.id.ad_view_container_main);
            adView = new AdView(this);
            adView.setAdUnitId("ca-app-pub-7542723422099323/7148228987");
            adContainerView.addView(adView);
            loadBanner();
    }


    /**
     * Load the View with ads
     */
    private void loadBanner() {

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
     * while passing which map they are on
     */
    private void goToActivity() {
        Intent intent = new Intent(this, RouletteGUI.class);
         intent.putExtra(TEXT_TO_SEND, sendToActivity);
         startActivity(intent);
    }
}

package frent.nobos.stratApex.views;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

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
    //THINGY FOR ADS
    private AdView mAdView;

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

        // ADS
        //ADS
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        // Create a banner ad. The ad size and ad unit ID must be set before calling loadAd.
        mAdView = new AdView(this);
        mAdView.setAdSize(AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(this, 2));
        mAdView.setAdUnitId("ca-app-pub-7542723422099323/4137916678");

        // Create an ad request.
        AdRequest.Builder adRequestBuilder = new AdRequest.Builder();

        // Add the AdView to the view hierarchy.
        layout.addView(mAdView);

        // Start loading the ad.
        mAdView.loadAd(adRequestBuilder.build());
        MobileAds.initialize(this, initializationStatus -> {
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
    @Override
    public void onResume() {
        super.onResume();
        // Resume the AdView.
        mAdView.resume();
    }

    @Override
    public void onPause() {
        // Pause the AdView.
        mAdView.pause();
        super.onPause();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        mAdView.destroy();
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

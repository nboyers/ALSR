package frent.nobos.stratApex.views;


import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.firebase.FirebaseApp;

import java.util.Arrays;

import frent.nobos.stratApex.ViewModels.rouletteLogic;
import frent.nobos.stratApex.databinding.StratMenuBinding;

/**
 * Strat Roulette Class that controls the GUI
 * Last Edited: 2021-05-11
 * @author Noah Boyers
 */
public class RouletteGUI extends AppCompatActivity {

    //name of the map they want to do the strat on
    private  String mapChoice;
    
    // Main menu but binding so we can update the GUI
    private StratMenuBinding STR_BIND;

    private boolean isDuosChecked;

    private AdView adView;
    private InterstitialAd mInterstitialAd;
    private final String TAG = "InterstitialAd";

    /**
     * Method that runs on the creation of
     * the start of the app
     *
     * @param savedInstanceState - idk not used(?)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        STR_BIND = StratMenuBinding.inflate(getLayoutInflater());
        View view = STR_BIND.getRoot();
        setContentView(view);
        FirebaseApp.initializeApp(this);

        //Starts all the weapon switches to be on
        STR_BIND.weaponsSwitch.setChecked(true);
        STR_BIND.medicalsSwitch.setChecked(true);
        STR_BIND.characterSwitch.setChecked(true);
        STR_BIND.dropzoneSwitch.setChecked(true);
        STR_BIND.gearSwitch.setChecked(true);
        STR_BIND.specialSwitch.setChecked(true);

        Intent intent = getIntent();
        mapChoice = intent.getStringExtra(MainActivity.TEXT_TO_SEND);
        isDuosChecked = intent.getBooleanExtra(MainActivity.BOOL_TO_SEND, false);



        //THINGY FOR ADS
        FrameLayout adContainerView = STR_BIND.adViewContainer;
        adView = new AdView(this);
        adView.setAdUnitId("ca-app-pub-7542723422099323/1201073201");
        adContainerView.addView(adView);
        loadBanner();

        MobileAds.initialize(this, initializationStatus -> {});
        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(this,"ca-app-pub-7542723422099323/4500795281", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;
                        Log.i(TAG, "onAdLoaded");
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        Log.i(TAG, loadAdError.getMessage());
                        mInterstitialAd = null;
                    }
                });

    }


    /**
     * Load the View with ads
     */
     void loadBanner() {

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

        double widthPixels = outMetrics.widthPixels;
        double density = outMetrics.density;

        int adWidth = (int) (widthPixels / density);

        //  Get adaptive ad size and return for setting on the ad view.
        return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(this, adWidth);
    }


    /**
     * Updates the GUI for the user once
     * they hit the "Randomizer" Button
     * @param view - the Thing they see
     */
    public void updateGUI(View view) {
        rouletteLogic rL = new rouletteLogic();
                rL.startGame(
                        getMapChoice(),
                        getWeaponSwitch(),
                        getMedicalSwitch(),
                        getDropzoneSwitch(),
                        getGearSwitch(),
                        getCharacterSwitch(),
                        getSpecialSwitch(),
                        getDuoChecked()
                );

        //UPDATES THE GUI
                STR_BIND.weaponView.setText(rL.getWeaponsString());
                STR_BIND.medicalView.setText(rL.getMedString());
                STR_BIND.dropzoneView.setText(rL.getDropzoneString());
                STR_BIND.gearView.setText(rL.getGearString());


                if(!STR_BIND.characterSwitch.isChecked()){
                    STR_BIND.charcterView.setText("");
                } else {
                    STR_BIND.charcterView.setText(Arrays.toString(rL.getCharacterArray()));
                }

                STR_BIND.specialView.setText(rL.getSpecialString());
    }



    /**
     * Method that resets the view
     * @param view - The strat menu
     */
    public void resetButton(View view) {
        int number = (int)(Math.random() * 10);
        // Will Fire ~33% of the time assuming an ad is ready
        if (number % 3 == 0){
            if (mInterstitialAd != null) {
                mInterstitialAd.show(RouletteGUI.this);
            } else {
                Log.d(TAG, "The interstitial ad wasn't ready yet.");
            }
        }

        // sets the text to blank strings
        STR_BIND.weaponView.setText("");
        STR_BIND.medicalView.setText("");
        STR_BIND.dropzoneView.setText("");
        STR_BIND.gearView.setText("");
        STR_BIND.charcterView.setText("");
        STR_BIND.specialView.setText("");

        // Makes all the switches to true
        STR_BIND.weaponsSwitch.setChecked(true);
        STR_BIND.medicalsSwitch.setChecked(true);
        STR_BIND.characterSwitch.setChecked(true);
        STR_BIND.dropzoneSwitch.setChecked(true);
        STR_BIND.gearSwitch.setChecked(true);
        STR_BIND.specialSwitch.setChecked(true);
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

    // GETTERS
    /**
     * Map Choice from the Main activity
     * @return - map choice
     */
     String getMapChoice() {
        return mapChoice;
    }
    /**
     * Method for weapon switch
     * @return - on or off
     */
    boolean getWeaponSwitch() { return STR_BIND.weaponsSwitch.isChecked(); }
    /**
     * Medical switch
     * @return - on or off
     */
     boolean getMedicalSwitch() { return STR_BIND.medicalsSwitch.isChecked(); }
    /**
     * Switch for the drop zone inside a map
     * @return - on or off drop zone in a map
     */
     boolean getDropzoneSwitch() { return STR_BIND.dropzoneSwitch.isChecked(); }
    /**
     *  Switch for gear rules
     * @return - on or off for gear
     */
     boolean getGearSwitch() { return STR_BIND.gearSwitch.isChecked(); }
    /**
     *  Switch for character rules
     * @return - on or off
     */
     boolean getCharacterSwitch() { return STR_BIND.characterSwitch.isChecked(); }
    /**
     * Switch for special rules
     * @return - on or off for special rules
     */
      boolean getSpecialSwitch() {return STR_BIND.specialSwitch.isChecked(); }

    /**
     * Returns if the game mode is duos or trios
     * @return - true for duos, false for trios
     */
    boolean getDuoChecked() { return isDuosChecked; }

    @Override
    public void onDestroy(){
        super.onDestroy();
        adView.destroy();
    }
}
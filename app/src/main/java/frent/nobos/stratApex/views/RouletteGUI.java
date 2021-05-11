package frent.nobos.stratApex.views;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

import java.util.Arrays;
import frent.nobos.stratApex.ViewModels.rouletteLogic;
import frent.nobos.stratApex.databinding.StratMenuBinding;

/**
 * Strat Roulette Class that controls the GUI
 * Last Edited: 2021-05-11
 * @author Noah Boyers
 */
public class RouletteGUI extends AppCompatActivity {

    // Main menu but binding so we can update the GUI
    private StratMenuBinding STR_BIND;

    //name of the map they want to do the strat on
    private String mapChoice;

    //THINGY FOR ADS
    private InterstitialAd mInterstitialAd;

    private final String TAG = "ADS LOADER";

    /**
     * Default constructor
     */
    public RouletteGUI(){}


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

        //Starts all the weapon switches to be on
        STR_BIND.weaponsSwitch.setChecked(true);
        STR_BIND.medicalsSwitch.setChecked(true);
        STR_BIND.characterSwitch.setChecked(true);
        STR_BIND.dropzoneSwitch.setChecked(true);
        STR_BIND.gearSwitch.setChecked(true);
        STR_BIND.specialSwitch.setChecked(true);

        Intent intent = getIntent();
        mapChoice = intent.getStringExtra(MainActivity.TEXT_TO_SEND);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {}
        });
        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(this,"ca-app-pub-7542723422099323/2300638122", adRequest, new InterstitialAdLoadCallback() {
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
                    getSpecialSwitch());

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

    // GETTERS
    /**
     * Map Choice from the Main activity
     * @return - map choice
     */
    private String getMapChoice() {
        return mapChoice;
    }
    /**
     * Method for weapon switch
     * @return - on or off
     */
    public Boolean getWeaponSwitch() {
        return STR_BIND.weaponsSwitch.isChecked();
    }
    /**
     * Medical switch
     * @return - on or off
     */
    public Boolean getMedicalSwitch() {
        return STR_BIND.medicalsSwitch.isChecked();
    }
    /**
     * Switch for the drop zone inside a map
     * @return - on or off drop zone in a map
     */
    public Boolean getDropzoneSwitch() {
        return STR_BIND.dropzoneSwitch.isChecked();
    }
    /**
     *  Switch for gear rules
     * @return - on or off for gear
     */
    public Boolean getGearSwitch() {
        return STR_BIND.gearSwitch.isChecked();
    }
    /**
     *  Switch for character rules
     * @return - on or off
     */
    public Boolean getCharacterSwitch() {
        return STR_BIND.characterSwitch.isChecked();
    }
    /**
     * Switch for special rules
     * @return - on or off for special rules
     */
    public Boolean getSpecialSwitch() {
        return STR_BIND.specialSwitch.isChecked();
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
    }


}
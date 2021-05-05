package frent.nobos.stratApex.views;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import frent.nobos.stratApex.R;
import frent.nobos.stratApex.ViewModels.rouletteLogic;

/**
 * Strat Roulette Class that controls the GUI
 * Last Edited: 2021-05-01
 * @author Noah Boyers
 */
public class RouletteGUI extends AppCompatActivity {

    // Switches for the app
    private SwitchCompat weaponSwitch, medicalSwitch, dropzoneSwitch, gearSwitch,
            characterSwitch, specialSwitch;
    private final TextViewUpdater textViewUpdater = new TextViewUpdater();
    private final Handler textViewUpdaterHandler = new Handler(Looper.getMainLooper());
    private String weapons, medicals, dropZone,
            gear, character, specials;


    //Views where the user sees the strats
    private TextView weaponsView, medicalsView, dropZoneView,
            gearView, characterView, specialsView;

    //name of the map they want to do the strat on
    private String mapChoice;

    /**
     * Method that runs on the creation of
     * the start of the app
     *
     * @param savedInstanceState - idk not used(?)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.strat_menu);

        Intent intent = getIntent();
        mapChoice = intent.getStringExtra(MainActivity.TEXT_TO_SEND);

        //Switches
        weaponSwitch = findViewById(R.id.weaponsSwitch);
        medicalSwitch = findViewById(R.id.medicalsSwitch);
        dropzoneSwitch = findViewById(R.id.dropzoneSwitch);
        gearSwitch = findViewById(R.id.gearSwitch);
        characterSwitch = findViewById(R.id.characterSwitch);
        specialSwitch = findViewById(R.id.specialSwitch);

        // Text View(s)
        weaponsView = (TextView) findViewById(R.id.weaponView);
        medicalsView = (TextView) findViewById(R.id.medicalView);
        dropZoneView = (TextView) findViewById(R.id.dropzoneView);
        gearView = (TextView) findViewById(R.id.gearView);
        characterView = (TextView) findViewById(R.id.charcterView);
        specialsView = (TextView) findViewById(R.id.specialView);

    }


    public void gameUpdate(String weapon, String med, String map, String gear, String character,
                           String sped) {
        this.weapons = weapon;
        this.medicals = med;
        this.dropZone = map;
        this.gear = gear;
        this.character = character;
        this.specials = sped;
    }

    /**
     * Method that resets the view
     *
     * @param view - The strat menu
     */
    public void resetButton(View view) {
        weaponsView.setText(" ");
        medicalsView.setText(" ");
        dropZoneView.setText(" ");
        gearView.setText(" ");
        characterView.setText(" ");
        specialsView.setText(" ");

        // Makes all the switches to true
        weaponSwitch.setChecked(true);
        medicalSwitch.setChecked(true);
        characterSwitch.setChecked(true);
        dropzoneSwitch.setChecked(true);
        gearSwitch.setChecked(true);
        specialSwitch.setChecked(true);
    }


    public void updateGUI(View view) {

        rouletteLogic rl = new rouletteLogic();

        rl.startGame(mapChoice, weaponSwitch.isChecked(), medicalSwitch.isChecked(),
                gearSwitch.isChecked(), characterSwitch.isChecked(), specialSwitch.isChecked());

        textViewUpdater.setWeapons(weapons);
        textViewUpdater.setMedicals(medicals);
        textViewUpdater.setDropZone(dropZone);
        textViewUpdater.setGear(gear);
        textViewUpdater.setCharacter(character);
        textViewUpdater.setSpecials(specials);

        textViewUpdaterHandler.post(textViewUpdater);
    }

    private class TextViewUpdater implements Runnable{

        private String weapons,medicals, dropZone,
                gear, character, specials;
        @Override
        public void run() {
            ((TextView) findViewById(R.id.weaponView)).setText(weapons);
            ((TextView) findViewById(R.id.medicalView)).setText(medicals);
            ((TextView) findViewById(R.id.dropzoneView)).setText(dropZone);
            ((TextView) findViewById(R.id.gearView)).setText(gear);
            ((TextView) findViewById(R.id.charcterView)).setText(character);
            ((TextView) findViewById(R.id.specialView)).setText(specials);
        }

        // SETTERS
        public void setWeapons(String weapons) {
            this.weapons = weapons;
        }
        public void setMedicals(String medicals) {
            this.medicals = medicals;
        }
        public void setDropZone(String dropZone) {
            this.dropZone = dropZone;
        }
        public void setGear(String gear) {
            this.gear = gear;
        }
        public void setCharacter(String character) {
            this.character = character;
        }
        public void setSpecials(String specials) {
            this.specials = specials;
        }
    }
}
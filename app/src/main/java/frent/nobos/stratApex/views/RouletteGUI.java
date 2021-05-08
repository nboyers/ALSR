package frent.nobos.stratApex.views;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import frent.nobos.stratApex.ViewModels.rouletteLogic;
import frent.nobos.stratApex.databinding.StratMenuBinding;

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
    private final StratMenuBinding STR_BIND = StratMenuBinding.inflate(getLayoutInflater());


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
        setContentView(STR_BIND.getRoot());

        Intent intent = getIntent();
        mapChoice = intent.getStringExtra(MainActivity.TEXT_TO_SEND);

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
        STR_BIND.weaponView.setText("");
        STR_BIND.medicalView.setText("");
        STR_BIND.dropzoneView.setText("");
        STR_BIND.gearView.setText("");
        STR_BIND.charcterView.setText("");
        STR_BIND.specialView.setText("");

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
            STR_BIND.weaponView.setText(weapons);
            STR_BIND.medicalView.setText(medicals);
            STR_BIND.dropzoneView.setText(dropZone);
            STR_BIND.gearView.setText(gear);
            STR_BIND.charcterView.setText(character);
            STR_BIND.specialView.setText(specials);
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
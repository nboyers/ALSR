package frent.nobos.stratApex.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import frent.nobos.stratApex.R;
import frent.nobos.stratApex.ViewModels.rouletteLogic;

/**
 * Strat Roulette Class that controls the GUI
 * Last Edited: 2021-05-01
 * @author Noah Boyers
 */
public class RouletteGUI extends AppCompatActivity {

    // Switches for the app
    private SwitchCompat weaponSwitch,medicalSwitch ,dropzoneSwitch, gearSwitch,
                   characterSwitch,specialSwitch;

    //Views where the user sees the strats
    private TextView weaponsView, medicalsView,dropZoneView, gearView, characterView,specialsView;

    //name of the map they want to do the strat on
    private  String mapChoice;

    /**
     * Method that runs on the creation of
     * the start of the app
     * @param savedInstanceState - idk not used(?)
     */
    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.strat_menu);

            Intent intent = getIntent();
            mapChoice = intent.getStringExtra(MainActivity.TEXT_TO_SEND);

            //Switches
            weaponSwitch       =  findViewById(R.id.weaponsSwitch);
            medicalSwitch      =  findViewById(R.id.medicalsSwitch);
            dropzoneSwitch     =  findViewById(R.id.dropzoneSwitch);
            gearSwitch         =  findViewById(R.id.gearSwitch);
            characterSwitch    =  findViewById(R.id.characterSwitch);
            specialSwitch      =  findViewById(R.id.specialSwitch);

            // Text View(s)
            weaponsView        = findViewById(R.id.weaponsView);
            medicalsView       = findViewById(R.id.medicalView);
            dropZoneView       = findViewById(R.id.dropzoneView);
            gearView           = findViewById(R.id.gearView);
            characterView      = findViewById(R.id.charcterView);
            specialsView       = findViewById(R.id.specialView);

        Button random_btn      = findViewById(R.id.randomButton);

            random_btn.setOnClickListener(v -> {
                rouletteLogic rl = new rouletteLogic();
                rl.startGame(mapChoice, weaponSwitch.isChecked(), medicalSwitch.isChecked(),
                        gearSwitch.isChecked(), characterSwitch.isChecked(), specialSwitch.isChecked());
            });
    }


    /**
     * Method that updates tbe GUI from
     * that came from the rouletteLogic.java
     *
     * @param weapons - random weapons string
     * @param medicals - random medical string
     * @param dropZone -  random dropZone string
     * @param gear - random gear string
     * @param character - random character string
     * @param specials - Specials string to be placed
     */

    //FIXME - The scene needs to be updated with a recycler instead of a new "scene"
    // every time. Fix me and this app 'should' work
    public void updateUI(String weapons, String medicals,String dropZone,
                         String gear, String character,String specials){
        // FIXME - Crashes
        runOnUiThread(() -> {
            weaponsView.setText(weapons);
            medicalsView.setText(medicals);
            dropZoneView.setText(dropZone);
            gearView.setText(gear);
            characterView.setText(character);
            specialsView.setText(specials);
        });
    }

    /**
     * Method that resets the view
     * @param view - The strat menu
     */
    public void resetButton(View view){

        weaponsView.setText("");
        medicalsView.setText("");
        dropZoneView.setText("");
        gearView.setText("");
        characterView.setText("");
        specialsView.setText("");

        // Makes all the switches to true
        weaponSwitch.setChecked(true);
        medicalSwitch.setChecked(true);
        characterSwitch.setChecked(true);
        dropzoneSwitch.setChecked(true);
        gearSwitch.setChecked(true);
        specialSwitch.setChecked(true);
    }
}
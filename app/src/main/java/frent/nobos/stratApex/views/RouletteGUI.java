package frent.nobos.stratApex.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import frent.nobos.stratApex.R;
import frent.nobos.stratApex.ViewModels.rouletteLogic;

public class RouletteGUI extends AppCompatActivity {

    private SwitchCompat weaponSwitch,medicalSwitch ,dropzoneSwitch, gearSwitch,
                   characterSwitch,specialSwitch ;
    private TextView weaponsView, medicalsView,dropZoneView, gearView, characterView,specialsView;
    private  String mapChoice;

    /**
     * Method that runs on the creation of
     * the start of the app
     * @param savedInstanceState
     */
    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.strat_menu);

            //Switches
            weaponSwitch       =  findViewById(R.id.weapons);
            medicalSwitch      =  findViewById(R.id.medicals);
            dropzoneSwitch     =  findViewById(R.id.dropzone);
            gearSwitch         =  findViewById(R.id.gear);
            characterSwitch    =  findViewById(R.id.character);
            specialSwitch      =  findViewById(R.id.specials);

            // Text View(s)
            weaponsView        = findViewById(R.id.weaponsView);
            medicalsView       = findViewById(R.id.medicalView);
            dropZoneView       = findViewById(R.id.dropzoneView);
            gearView           = findViewById(R.id.gearView);
            characterView      = findViewById(R.id.charcterView);
            specialsView       = findViewById(R.id.specialView);

            Intent intent = getIntent();
            mapChoice = intent.getStringExtra(MainActivity.TEXT_TO_SEND);
    }


    /**
     * Method that updates tbe GUI from
     * that came from the rouletteLogic.java
     * @param weapons
     * @param medicals
     * @param dropZone
     * @param gear
     * @param character
     * @param specials
     */

    //FIXME - The scene needs to be updated with a recycler instead of a new "scene"
    // every time. Fix me and this app 'should' work
    public void updateUI(String weapons, String medicals,String dropZone,
                         String gear, String character,String specials){
        weaponsView        = findViewById(R.id.weaponsView);
        medicalsView       = findViewById(R.id.medicalView);
        dropZoneView       = findViewById(R.id.dropzoneView);
        gearView           = findViewById(R.id.gearView);
        characterView      = findViewById(R.id.charcterView);
        specialsView       = findViewById(R.id.specialView);

        this.runOnUiThread(() -> {
            weaponsView.setText(weapons);
            weaponsView.invalidate();

            medicalsView.setText(medicals);
            medicalsView.invalidate();

            dropZoneView.setText(dropZone);
            dropZoneView.invalidate();

            gearView.setText(gear);
            gearView.invalidate();

            characterView.setText(character);
            characterView.invalidate();

            specialsView.setText(specials);
            specialsView.invalidate();
        });
    }

    /**
     * Method That starts the generator
     * the random outcomes
     * @param view - not used
     */
    public void onClick(View view ){
        rouletteLogic rl = new rouletteLogic();
        rl.startGame(mapChoice, weaponSwitch.isChecked(), medicalSwitch.isChecked(),
                gearSwitch.isChecked(), characterSwitch.isChecked(), specialSwitch.isChecked());
    }

    /**
     * Method that resets the view
     * @param view - The strat menu
     */
    public void resetButton(View view){

        // Makes the challenges go away
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
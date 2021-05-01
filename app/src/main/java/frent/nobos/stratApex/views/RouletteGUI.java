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

    private Switch weaponSwitch,medicalSwitch ,dropzoneSwitch, gearSwitch,
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
            medicalSwitch       =  findViewById(R.id.medicals);
            dropzoneSwitch       =  findViewById(R.id.dropzone);
            gearSwitch           =  findViewById(R.id.gear);
            characterSwitch      =  findViewById(R.id.character);
            specialSwitch       =  findViewById(R.id.specials);

            // Text View(s)
            weaponsView    = findViewById(R.id.weaponsView);
            medicalsView   = findViewById(R.id.medicalView);
            dropZoneView   = findViewById(R.id.dropzoneView);
            gearView       = findViewById(R.id.gearView);
            characterView  = findViewById(R.id.charcterView);
            specialsView   = findViewById(R.id.specialView);


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
    public void updateUI(String weapons, String medicals,String dropZone,
                         String gear, String character,String specials){
        onCheckedChanged(weaponSwitch,true);
        weaponsView.setText(weapons);
        medicalsView.setText(medicals);
        dropZoneView.setText(dropZone);
        gearView.setText(gear);
        characterView.setText(character);
        specialsView.setText(specials);

    }

    //FIXME - make a check or not method work better
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        Toast.makeText(this, "The Switch is " + (isChecked ? "on" : "off"),
                Toast.LENGTH_SHORT).show();
        if(isChecked) {
            //do stuff when Switch is ON
        } else {
            //do stuff when Switch if OFF
        }
    }

    //FIXME - needs to define logic for RANDOMIZER BUTTON
    public void onClick(View view ){
        rouletteLogic rl = new rouletteLogic();

    }
}
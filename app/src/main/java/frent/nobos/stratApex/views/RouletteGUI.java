package frent.nobos.stratApex.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;

import frent.nobos.stratApex.R;

public class RouletteGUI extends AppCompatActivity {

    private SwitchCompat weapons, medicals, dropzone, gear,character,specials;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.strat_roulette_choice);
        weapons.findViewById(R.id.weapons);
        medicals.findViewById(R.id.medicals);
        dropzone.findViewById(R.id.dropzone);
        gear.findViewById(R.id.gear);
        character.findViewById(R.id.character);
        specials.findViewById(R.id.specials);
    }

}
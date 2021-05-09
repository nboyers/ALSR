package frent.nobos.stratApex.views;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import frent.nobos.stratApex.ViewModels.rouletteLogic;
import frent.nobos.stratApex.databinding.StratMenuBinding;

/**
 * Strat Roulette Class that controls the GUI
 * Last Edited: 2021-05-01
 * @author Noah Boyers
 */
public class RouletteGUI extends AppCompatActivity {

    // String of strats
    private String weapons, medicals, dropZone,
            gear, character, specials;

    // Main menu but binding so we can update the GUI
    private StratMenuBinding STR_BIND;

    //name of the map they want to do the strat on
    private String mapChoice;

    /**
     * Default constructor
     */
    public RouletteGUI(){}

    /**
     *  Overloaded constructor
     * @param weapons - weapon rule
     * @param medicals - medicals rules
     * @param dropZone - location to drop
     * @param gear - gear to use
     * @param character - character to play
     * @param specials - special rule set
     */
    public RouletteGUI(String weapons,
                       String medicals,
                       String dropZone,
                       String gear,
                       String character,
                       String specials){
        setWeapons(weapons);
        setMedicals(medicals);
        setDropZone(dropZone);
        setGear(gear);
        setCharacter(character);
        setSpecials(specials);
    }

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
                    getCharacterSwitch(),
                    getDropzoneSwitch(),
                    getGearSwitch(),
                    getSpecialSwitch()
            );

            STR_BIND.weaponView.setText(weapons);
            STR_BIND.medicalView.setText(medicals);
            STR_BIND.dropzoneView.setText(dropZone);
            STR_BIND.gearView.setText(gear);
            STR_BIND.charcterView.setText(character);
            STR_BIND.specialView.setText(specials);
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






    // SETTERS
    /**
     *  Sets the character
     * @param character - sets which character to use
     */
    public void setCharacter(String character) {
        this.character = character;
    }
    /**
     * Sets the weapon loadout
     * @param weapons - sets rules for weapons
     */
    public void setWeapons(String weapons) {
        this.weapons = weapons;
    }
    /**
     * sets the medical rules
     * @param medicals - sets rules for medical items
     */
    public void setMedicals(String medicals) {
        this.medicals = medicals;
    }
    /**
     * Sets where the user needs to land
     * @param dropZone - sets where to land in a map
     */
    public void setDropZone(String dropZone) {
        this.dropZone = dropZone;
    }
    /**
     * sets what gear to use
     * @param gear - sets gear rules
     */
    public void setGear(String gear) {
        this.gear = gear;
    }
    /**
     * Sets the special rules
     * @param specials - sets the special rules
     */
    public void setSpecials(String specials) {
        this.specials = specials;
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
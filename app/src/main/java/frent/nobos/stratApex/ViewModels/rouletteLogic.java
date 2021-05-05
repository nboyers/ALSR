package frent.nobos.stratApex.ViewModels;

import android.util.Log;

import java.util.Random;

import frent.nobos.stratApex.R;
import frent.nobos.stratApex.models.GameModel;
import frent.nobos.stratApex.views.RouletteGUI;

/**
 * Viewmodel class
 * that controls all the game logic
 * Last Edited: 2021-05-01
 * @author Noah Boyers
 */
public class rouletteLogic extends RouletteGUI{
    private String mapChoice = "hey";
    private boolean weapons,medicals,gear, character, specials;
    private String BROKE = "ERROR";

    private String weaponsString ,medString,gearString,
            charcterString,specialString;

    private final GameModel gm = new GameModel();

    /**
     * Default constructor
     */
    public rouletteLogic() {}
    /**
     * Method that gets the map choice
     * @return -the map choice
     */
    private String getMapChoice() {
        return mapChoice;
    }
    /**
     * Method that sets the map choice
     * @param map - takes in a map type
     */
    private void setMapChoice(String map) {
        this.mapChoice = map;
    }
    /**
     * Sets the weapon boolean
     * @param weapons true if user wants to include weapons otherwise false
     */
    private void setWeapons(boolean weapons) {
        this.weapons = weapons;
    }
    /**
     *
     * @param medicals true if user wants to include meds otherwise false
     */
    private void setMedicals(boolean medicals) {
        this.medicals = medicals;
    }
    /**
     *
     * @param gear true if user wants to include gear otherwise false
     */
    private void setGear(boolean gear) {
        this.gear = gear;
    }
    /**
     * Sets the boolean if the user wanted to
     * use characters in the random loadouts
     * @param character - true or false for yes or no
     */
    private void setCharacter(boolean character) {
        this.character = character;
    }
    /**
     * Sets boolean if the user wants to use
     * special rules in their random loadouts
     * @param specials true or false for yes or no
     */
    private void setSpecials(boolean specials) {
        this.specials = specials;
    }
    /**
     * getter for the weapons
     * @return weapon string
     */
    private String getWeaponsString() {
        return weaponsString;
    }
    /**
     * Getter for medical
     * @return medical string
     */
    private String getMedString() {
        return medString;
    }
    /**
     * Getter for Gear
     * @return gear String
     */
    private String getGearString() {
        return gearString;
    }
    /**
     * Getter for Character
     * @return - character as string
     */
    private String getCharcterString() {
        return charcterString;
    }
    /**
     * Getter for special Rules
     * @return Special Rule string
     */
    private String getSpecialString() {
        return specialString;
    }
    private void setWeaponsString(String weaponsString) {
        this.weaponsString = weaponsString;
    }
    private void setMedString(String medString) {
        this.medString = medString;
    }
    private void setGearString(String gearString) {
        this.gearString = gearString;
    }
    private void setCharcterString(String charcterString) {
        this.charcterString = charcterString;
    }
    private void setSpecialString(String specialString) {
        this.specialString = specialString;
    }

//ACTUALY GAME
    /**
     * Method that gets the info from the GUI to start logic
     * @param weapons - true / false to weapon option
     * @param medicals - true / false to medical option
     * @param gear - true / false to gear option
     * @param character - true / false to character option
     * @param specials - true / false to special rule option
     */
    public void startGame(String mapChoice, boolean weapons,boolean medicals, boolean gear, boolean character,
                          boolean specials) {

        //Gets the boolean logic
        setMapChoice(mapChoice);
        setWeapons(weapons);
        setMedicals(medicals);
        setGear(gear);
        setCharacter(character);
        setSpecials(specials);
        randomLoadouts();
    }

    /**
     * Method thatupdates all the Strings
     */
    private void randomLoadouts(){

        // Determines the map the user is playing on for drop areas
        switch(mapChoice) {
            case "Kings Canyon":
                mapChoice = getRandom(gm.KINGS_CANYON);
                break;
            case "Olympus":
                mapChoice = getRandom(gm.OLYMPUS);
                break;
            case "Worlds Edge":
                mapChoice = getRandom(gm.WORLDS_EDGE);
                break;
            default:
                mapChoice = "Drop in the middle of the map";
        }

        // Controls the logic for each category.
        if(weapons) {
            setWeaponsString(getRandom(gm.WEAPONS));
        } else {
            setMapChoice(" ");
        }
        if(medicals){
            setMedString(getRandom(gm.MEDICALS));
        } else {
            setMedString(" ");
        }
        if(gear){
            setGearString(getRandom(gm.GEAR));
        } else {
            setGearString(" ");
        }
        if(character){
            setCharcterString(getRandom(gm.CHARACTERS));
        } else {
            setCharcterString(" ");
        }
        if(specials){
            setSpecialString(getRandom(gm.SPECIALS));
        } else {
            setSpecialString(" ");
        }

        // Sends the random strings back to the GUI for the user
        gameUpdate(getWeaponsString(), getMedString(), getMapChoice(),
                    getGearString(), getCharcterString(), getSpecialString());
    }

    /**
     * Method that returns the string at the random nth place
     * @param array - catagory from what to choose from
     * @return - the random String from the model arrays
     */
    private static String getRandom(String[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }
}

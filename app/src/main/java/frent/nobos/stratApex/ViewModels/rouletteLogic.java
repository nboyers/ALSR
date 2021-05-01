package frent.nobos.stratApex.ViewModels;

import java.util.Random;

import frent.nobos.stratApex.models.GameModel;
import frent.nobos.stratApex.views.RouletteGUI;

/**
 * Viewmodel class
 * that controls all the game logic
 */
public class rouletteLogic {
    private String mapChoice;
    private boolean weapons,medicals,gear, character, specials;
    private String weaponsString,medString,gearString,charcterString,specialString;
    private final GameModel gm = new GameModel();
    private final RouletteGUI rGUI = new RouletteGUI();


    /**
     * Default constructor
     */
    public rouletteLogic() {}

    /**
     * Constructor that takes what map is being used
     * @param map - what map the user is playing on
     */
    public rouletteLogic(String map){
        setMapChoice(map);
    }

    /**
     * Method that gets the map choice
     * @return -the map choice
     */
    public String getMapChoice() {
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
    public void setWeapons(boolean weapons) {
        this.weapons = weapons;
    }

    /**
     *
     * @param medicals true if user wants to include meds otherwise false
     */
    public void setMedicals(boolean medicals) {
        this.medicals = medicals;
    }

    /**
     *
     * @param gear true if user wants to include gear otherwise false
     */
    public void setGear(boolean gear) {
        this.gear = gear;
    }

    /**
     * Sets the boolean if the user wanted to
     * use characters in the random loadouts
     * @param character - true or false for yes or no
     */

    public void setCharacter(boolean character) {
        this.character = character;
    }

    /**
     * Sets boolean if the user wants to use
     * special rules in their random loadouts
     * @param specials true or false for yes or no
     */
    public void setSpecials(boolean specials) {
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
     * @return
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

    /**
     * Method that gets the info from the GUI to start logic
     * @param weapons
     * @param medicals
     * @param gear
     * @param character
     * @param specials
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

        // Deterimes the map the user is playing on for drop areas
        switch(mapChoice) {
            case "Kings Wold":
               // mapChoice = getRandom(gm.KINGS_WORLD);
                break;
            case "Worlds Edge":
             //   mapChoice = getRandom(gm.WORLDS_EDGE);
                break;
            case "olympus":
             //   mapChoice = getRandom(gm.OLYMPUS);
                break;
            default:
                mapChoice = "Drop in the middle of the map";
        }

        // Controls the logic for each catagory.
        if(weapons) {
         weaponsString = getRandom(gm.WEAPONS);
        } else {
            weaponsString = "";
        }
        if(medicals){
           medString = getRandom(gm.MEDICALS);
        } else {
            medString = "";
        }
        if(gear){
           gearString = getRandom(gm.GEAR);
        } else {
            gearString = "";
        }
        if(character){
           charcterString = getRandom(gm.CHARACTERS);
        } else {
            charcterString = "";
        }
        if(specials){
           specialString = getRandom(gm.SPECIALS);
        } else {
            specialString = "";
        }

        // Sends the random streings back to the GUI for the user
       rGUI.updateUI(getWeaponsString(), getMedString(),getMapChoice(), getGearString(), getCharcterString(), getSpecialString());
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
package frent.nobos.stratApex.ViewModels;

import java.util.Random;

import frent.nobos.stratApex.models.GameModel;
import frent.nobos.stratApex.views.RouletteGUI;

/**
 * Viewmodel class
 * that controls all the game logic
 * Last Edited: 2021-05-09
 * @author Noah Boyers
 */
public class rouletteLogic extends RouletteGUI{
    private String mapChoice;
    private boolean weapons,dropZone,medicals,gear, character, specials;

    private String weaponsString ,medString,gearString,
            charcterString,specialString;

    private final GameModel gm = new GameModel();

    public rouletteLogic(){}

    /**
     * Method that gets the info from the GUI to start logic
     * @param weapons - true / false to weapon option
     * @param medicals - true / false to medical option
     * @param gear - true / false to gear option
     * @param character - true / false to character option
     * @param specials - true / false to special rule option
     */
    public  void startGame(String mapChoice, boolean weapons, boolean medicals,
                                 boolean dropZone, boolean gear,
                                 boolean character, boolean specials) {

        //Gets the boolean logic
        setMapChoice(mapChoice);
        setDropZone(dropZone);
        setWeapons(weapons);
        setMedicals(medicals);
        setGear(gear);
        setCharacter(character);
        setSpecials(specials);

        //Assigns the random loadouts
        randomLoadouts();

        //Updates the strings to the GUI
        gameUpdate();
    }

    /**
     * Method thatupdates all the Strings
     */
    private  void randomLoadouts(){


        if(dropZone) {
            switch (mapChoice) {
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
    }

    /**
     * Method that returns the string at the random nth place
     * @param array - catagory from what to choose from
     * @return - the random String from the model arrays
     */
    private  String getRandom(String[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }

    public  void gameUpdate() {
        new RouletteGUI(getWeaponsString(),
                getMedString(),
                getDropzoneString(),
                getGearString(),
                getCharcterString(),
                getSpecialString());
    }


    //BOOLEANS

    /**
     * Sets the dropzone boolean
     * @param dropZone - yes or no for drop
     */
    private  void setDropZone(boolean dropZone) {
        this.dropZone = dropZone;
    }
    /**
     * Sets the weapon boolean
     * @param weapons true if user wants to include weapons otherwise false
     */
    private  void setWeapons(boolean weapons) {
        this.weapons = weapons;
    }
    /**
     * Sets the medical boolean
     * @param medicals true if user wants to include meds otherwise false
     */
    private  void setMedicals(boolean medicals) {
        this.medicals = medicals;
    }
    /**
     *sets the gear boolean
     * @param gear true if user wants to include gear otherwise false
     */
    private  void setGear(boolean gear) {
        this.gear = gear;
    }
    /**
     * Sets the boolean if the user wanted to
     * use characters in the random loadouts
     * @param character - true or false for yes or no
     */
    private  void setCharacter(boolean character) {
        this.character = character;
    }
    /**
     * Sets boolean if the user wants to use
     * special rules in their random loadouts
     * @param specials true or false for yes or no
     */
    private  void setSpecials(boolean specials) {
        this.specials = specials;
    }

    //GETTERS FOR STRINGS

    /**
     * getter for the weapons
     * @return weapon string
     */
    public String getWeaponsString() {
        return weaponsString;
    }
    /**
     * Getter for medical
     * @return medical string
     */
    public String getMedString() {
        return medString;
    }
    /**
     * Getter for Gear
     * @return gear String
     */
    public String getGearString() {
        return gearString;
    }
    /**
     * Getter for Character
     * @return - character as string
     */
    public String getCharcterString() {
        return charcterString;
    }
    /**
     * Getter for special Rules
     * @return Special Rule string
     */
    public String getSpecialString() {
        return specialString;
    }
    public String getDropzoneString(){
        return mapChoice;
    }


    //SETTERS FOR STRINGS

    /**
     * SEtting the weapon string
     * @param weaponsString - what weapon to use
     */
    private void setWeaponsString(String weaponsString) {
        this.weaponsString = weaponsString;
    }
    /**
     * Setter for medicals
     * @param medString - medical items
     */
    private void setMedString(String medString) {
        this.medString = medString;
    }
    /**
     * SETTER FOR GEAR
     * @param gearString - what gear to use
     */
    private void setGearString(String gearString) {
        this.gearString = gearString;
    }
    /**
     * Setter for character
     * @param charcterString - what character to play
     */
    private void setCharcterString(String charcterString) {
        this.charcterString = charcterString;
    }
    /**
     * Setter for special rule set
     * @param specialString - the rule to be played
     */
    private void setSpecialString(String specialString) {
        this.specialString = specialString;
    }
    /**
     * Method that sets the map choice
     * @param map - takes in a map type
     */
    public  void setMapChoice(String map) {
        this.mapChoice = map;
    }

}

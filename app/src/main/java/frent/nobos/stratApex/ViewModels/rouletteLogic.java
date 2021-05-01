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


    // 1 or 0 to decide if you use it or not
   private byte weapons;
   private byte medicals;
    private byte gear;
    private byte character;
   private  byte specials;
    private String weaponsString;
    private String medString;;
    private String gearString;
    private String charcterString;
    private String specialString;
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
    private void setWeapons(byte weapons) {
        this.weapons = weapons;
    }
    private void setMedicals(byte medicals) {
        this.medicals = medicals;
    }
    private void setGear(byte gear) {
        this.gear = gear;
    }
    private void setCharacter(byte character) {
        this.character = character;
    }
    private void setSpecials(byte specials) {
        this.specials = specials;
    }

    /**
     * Method that gets the info from the GUI to start logic
     * @param weapons
     * @param medicals
     * @param gear
     * @param character
     * @param specials
     */
    public void startGame(String mapChoice,String weapons, String medicals, String gear, String character,
                          String specials) {

        //FIXME - Start game needs to be reworked
        //Gets the boolean logic
        setMapChoice(mapChoice);
        setWeapons(Byte.parseByte(weapons));
        setMedicals(Byte.parseByte(medicals));
        setGear(Byte.parseByte(gear));
        setCharacter(Byte.parseByte(character));
        setSpecials(Byte.parseByte(specials));


        //
        randomLoadouts();
    }

    /**
     * Method thatupdates all the Strings
     */
    private void randomLoadouts(){

        //FIXME - This just needs help
        //ZERO MEANS FALSE
        if(weapons != 0) {
         weaponsString = getRandom(gm.WEAPONS);
        }
        if(medicals!=0){
           medString = getRandom(gm.MEDICALS);
        }
        if(gear != 0){
           gearString = getRandom(gm.GEAR);
        }
        if(character != 0){
           charcterString = getRandom(gm.CHARACTERS);
        }
        if(specials != 0){
           specialString = getRandom(gm.SPECIALS);
        }
       rGUI.updateUI(weaponsString, medString,mapChoice, gearString, charcterString, specialString);
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

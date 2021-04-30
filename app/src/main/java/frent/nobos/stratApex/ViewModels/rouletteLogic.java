package frent.nobos.stratApex.ViewModels;

/**
 * Viewmodel class
 * that controls all the game logic
 */
public class rouletteLogic {
    private String mapChoice;

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
    public void setMapChoice(String map) {
        this.mapChoice = map;
    }
}

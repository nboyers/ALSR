package frent.nobos.stratApex;

public class RandomGeneratorModel {

    private  final String[] weapons = {"Light Ammo Only", "Heavy Ammo Only", "Mozambique Only",
            "No Shotguns", "ARs Only", "No Ars", "Snipers Only", "Energy Ammo Only",
            "Shotguns Only", "Pistols Only","Guns with Hop Ups Only", "LMGs Only", "Bow Only",
            "Can't use attachments on weapons", "P2020/Mozambique Only", "Fists Only"};

    private String[] medicals;

    private String[] dropzone;

    private  String[] gear;

    private final String[] character = {"Bloodhound","Pathfinder","Bangalore", "Caustic","Crypto",
    "Fuse", "Gibraltar", "Horizon", "Lifeline","Loba", "Mirage", "Octane", "Rampart", "Revenant",
            "Wattson", "Wraith"};

    private final String[] specials = {"Bloodthirsty. You cannot heal until you kill.",
            "Sole Survivor. Everyone in the squad must solo queue.",
            "Time's Up! Jumpmaster lands somewhere else to others. " +
            "If the Jumpmaster dies before the meetup, or after 5 minutes, all must die! ",
    "Jump Off the Map! Random teammate must jump separate across the map, and jump off.",
    "Boxing Match. You must drop your weapons, throw hands and punch the final squad to death.",
            "No Purples! You are not allowed to use anything graded purple or higher. "
                    + "Purple Evo Shields earned must be dropped immediately!",
    "Fire in the Hole! You must use grenades on the final squad.",
    "No Respawns or Revives! Pretty self explanatory. No golden knockdown either.",
    "Ironman Challenge. You are only allowed to use Mozambique's without hammerpoint!" +
            " No higher than blue shields and no more than 2 stacks of healable. GL HF." ,
            "Hot Switch. " + "When you kill someone you must swap your weapons for theirs. " +
            "You must thirst any downed player and swap before attacking another player.",
    "Sticks and Stones! Only use grenades and bows for a whole game. GLHF",
    "Protect the President! Jumpmaster is president. Protect them at all cost. " +
            "Failure to do means you forfeit and you must die!"};
}

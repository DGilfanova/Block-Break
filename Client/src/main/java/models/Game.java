package models;

import lombok.Getter;
import lombok.Setter;
import models.characters.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class Game {

    private ArrayList<AbstractCharacter> characters = new ArrayList<>();
    private ArrayList<AbstractCharacter> chosenCharacters = new ArrayList<>();

    HashMap<Integer, Integer> colors = new HashMap<>();

    private int[][] startBlock;
    private int[][] currentBlock;

    private int pointsMy;
    private int pointsOpponent;

    public Game() {
        characters.add(new ItadoriSukunaCharacter());
        characters.add(new MegumiCharacter());
        characters.add(new TaranCharacter());
        characters.add(new CroshCharacter());
        characters.add(new SpiderCharacter());
        characters.add(new GojoCharacter());
    }
}

package models;

import lombok.Getter;
import lombok.Setter;
import models.characters.*;

import java.util.ArrayList;

@Getter
@Setter
public class Game {

    private ArrayList<AbstractCharacter> characters = new ArrayList<>();

    private int[][] startBlock;

    public Game() {
        characters.add(new ItadoriSukunaCharacter());
        characters.add(new MegumiCharacter());
        characters.add(new TaranCharacter());
        characters.add(new CroshCharacter());
        characters.add(new SpiderCharacter());
        characters.add(new GojoCharacter());
    }
}

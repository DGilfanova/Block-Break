package models;

import lombok.Getter;
import lombok.Setter;
import models.characters.*;

import java.util.ArrayList;

@Getter
@Setter
public class Game {

    private ArrayList<AbstractCharacter> characters = new ArrayList<>();

    public Game() {
        //добавление для тестирования, думаю, нужно как-то полегче добавлять, а не менять данные везде...open-closed уехал
        characters.add(new SukunaCharacter());
        characters.add(new MegumiCharacter());
        characters.add(new HamsterCharacter());
        characters.add(new CroshCharacter());
    }
}

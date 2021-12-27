package models.characters;

import java.util.HashMap;
import java.util.Map;

public class GojoCharacter extends AbstractCharacter {

    private Map<Integer,Integer> cells = new HashMap<>();

    public GojoCharacter() {
        id = 6L;
        name = "Gojo Satoru";
        normalSkill = "Skewer";
        specialSkill = "Lightning bolt";
        specialSkillImage = "/images/skills/lightning_bolt.png";
        imagePath = "/images/characters/gojo.png";
        //изменить
        damageImage = "/images/damages/itadoriSukuna.PNG";
        normalSkillImage = "/images/skills/skewer.png";
    }

    @Override
    public Map<Integer, Integer> processBlock(Integer x, Integer y) {
        return null;
    }
}

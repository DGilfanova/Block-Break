package models.characters;

import java.util.HashMap;
import java.util.Map;

public class GojoCharacter extends AbstractCharacter {

    public GojoCharacter() {
        id = 6L;
        name = "Gojo Satoru";
        normalSkill = "Skewer";
        specialSkill = "Lightning bolt";
        specialSkillImage = "/images/skills/lightning_bolt.png";
        imagePath = "/images/characters/gojo.png";
        damageImage = "/images/damages/gojo.PNG";
        normalSkillImage = "/images/skills/skewer.png";
        cells = new int[][]{{0,0},{1,0},{2,0},{3,0},{4,0}};
    }
}

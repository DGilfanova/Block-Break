package models.characters;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@EqualsAndHashCode
public class CroshCharacter extends AbstractCharacter {


    public CroshCharacter() {
        id = 1L;
        name = "Crosh (30)";
        normalSkill = "Fire Shield";
        specialSkill = "Heavenly Grace";
        specialSkillImage = "/images/skills/heavenly_grace.png";
        imagePath = "/images/characters/crosh.png";
        damageImage = "/images/damages/crosh.PNG";
        normalSkillImage = "/images/skills/fire_shield.png";
        cells = new int[][]{{0,0},{0,1},{0,2},{1,2},{2,2}};
    }

}

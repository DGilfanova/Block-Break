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
    private Map<Integer,Integer> cells = new HashMap<>();

    public CroshCharacter() {
        id = 1L;
        name = "Crosh";
        normalSkill = "Fire Shield";
        specialSkill = "Heavenly Grace";
        specialSkillImage = "/images/skills/heavenly_grace.png";
        imagePath = "/images/characters/crosh.png";
        damageImage = "/images/damages/crosh.PNG";
        normalSkillImage = "/images/skills/fire_shield.png";
    }

    @Override
    public Map<Integer, Integer> processBlock(Integer x, Integer y) {
        cells.put(1,1);
        cells.put(1,2);
        cells.put(2,1);
        cells.put(2,2);
        return cells;
    }
}

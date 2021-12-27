package models.characters;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@EqualsAndHashCode
public class SpiderCharacter extends AbstractCharacter {
    private Map<Integer,Integer> cells = new HashMap<>();

    public SpiderCharacter() {
        id = 4L;
        name = "Spider-Man";
        normalSkill = "Dispersion";
        specialSkill = "Refraction";
        specialSkillImage = "/images/skills/refraction.png";
        imagePath = "/images/characters/spider.png";
        damageImage = "/images/damages/spider.PNG";
        normalSkillImage = "/images/skills/dispersion.png";
    }



    @Override
    public Map<Integer, Integer> processBlock(Integer x, Integer y) {
        cells.put(1,1);
        cells.put(2,1);
        cells.put(3,1);
        return cells;
    }
}

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

    public SpiderCharacter() {
        id = 4L;
        name = "Spider-Man";
        normalSkill = "Dispersion";
        specialSkill = "Refraction";
        specialSkillImage = "/images/skills/refraction.png";
        imagePath = "/images/characters/spider.png";
        damageImage = "/images/damages/spider.PNG";
        normalSkillImage = "/images/skills/dispersion.png";
        cells = new int[][]{{0,0},{1,1},{2,2},{3,3}};
    }

}

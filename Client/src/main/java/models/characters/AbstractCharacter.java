package models.characters;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public abstract class AbstractCharacter {
    Long id;
    String name;
    String imagePath;
    String normalSkill;
    String specialSkill;
    String specialSkillImage;
    String damageImage;
    String normalSkillImage;

    public abstract Map<Integer, Integer> processBlock(Integer x, Integer y);
}

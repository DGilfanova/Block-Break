package models.characters;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@EqualsAndHashCode
public class MegumiCharacter extends AbstractCharacter {

    public MegumiCharacter() {
        id = 3L;
        name = "Megumi";
        normalSkill = "God Strength";
        specialSkill = "Dark Pact";
        specialSkillImage = "/images/skills/dark_pact.png";
        imagePath = "/images/characters/megumi.png";
        damageImage = "/images/damages/megumi.png";
        normalSkillImage = "/images/skills/god_strength.png";
        cells = new int[][]{{0,0},{0,-1},{0,1},{-1,0},{1,0}};
    }
}

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
    private Map<Integer,Integer> cells = new HashMap<>();

    public MegumiCharacter() {
        id = 3L;
        name = "Megumi";
        normalSkill = "God Strength";
        specialSkill = "Dark Pact";
        specialSkillImage = "/images/skills/dark_pact.png";
        imagePath = "/images/characters/megumi.png";
        damageImage = "/images/damages/megumi.png";
        normalSkillImage = "/images/skills/god_strength.png";
    }

    @Override
    public Map<Integer, Integer> processBlock(Integer x, Integer y) {
        cells.put(1,1);
        cells.put(1,2);
        cells.put(1,3);
        cells.put(2,3);
        return cells;
    }
}

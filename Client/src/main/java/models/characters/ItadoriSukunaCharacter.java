package models.characters;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@EqualsAndHashCode
public class ItadoriSukunaCharacter extends AbstractCharacter {

    private Map<Integer,Integer> cells = new HashMap<>();

    public ItadoriSukunaCharacter() {
        id = 2L;
        name = "Itadori Sukuna";
        normalSkill = "Skewer";
        specialSkill = "Lightning bolt";
        specialSkillImage = "/images/skills/lightning_bolt.png";
        imagePath = "/images/characters/itadoriSukuna.png";
        damageImage = "/images/damages/itadoriSukuna.PNG";
        normalSkillImage = "/images/skills/skewer.png";
    }

    @Override
    public Map<Integer, Integer> processBlock(Integer x, Integer y) {
        cells.put(1,1);
        cells.put(1,2);
        cells.put(1,3);
        cells.put(1,4);
        return cells;
    }
}

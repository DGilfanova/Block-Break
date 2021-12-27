package models.characters;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@EqualsAndHashCode
public class TaranCharacter extends AbstractCharacter {
    private Map<Integer,Integer> cells = new HashMap<>();

    public TaranCharacter() {
        id = 5L;
        name = "Taran";
        normalSkill = "Corrosive haze";
        specialSkill = "Vampiric hit";
        specialSkillImage = "/images/skills/vampiric_aura.png";
        imagePath = "/images/characters/taran.png";
        damageImage = "/images/damages/taran.png";
        normalSkillImage = "/images/skills/corrosive_haze.png";
    }

    @Override
    public Map<Integer, Integer> processBlock(Integer x, Integer y) {
        cells.put(1,1);
        cells.put(2,1);
        cells.put(2,2);
        return cells;
    }
}

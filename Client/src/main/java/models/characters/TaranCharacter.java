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

    public TaranCharacter() {
        id = 5L;
        name = "Taran";
        normalSkill = "Corrosive haze";
        specialSkill = "Vampiric hit";
        specialSkillImage = "/images/skills/vampiric_aura.png";
        imagePath = "/images/characters/taran.png";
        damageImage = "/images/damages/taran.png";
        normalSkillImage = "/images/skills/corrosive_haze.png";
        cells = new int[][]{{0,0},{-1,0},{1,0},{0,1},{0,2}};
    }

}

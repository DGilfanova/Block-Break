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

    public ItadoriSukunaCharacter() {
        id = 2L;
        name = "Itadori Sukuna";
        normalSkill = "Skewer";
        specialSkill = "Lightning bolt";
        specialSkillImage = "/images/skills/lightning_bolt.png";
        imagePath = "/images/characters/itadoriSukuna.png";
        damageImage = "/images/damages/itadoriSukuna.PNG";
        normalSkillImage = "/images/skills/skewer.png";
        cells = new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 1}};
    }

}

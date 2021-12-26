package models.characters;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class SukunaCharacter extends AbstractCharacter {

    Integer id = 1;

    @Override
    public Map<Integer, Integer> processBlock(Integer x, Integer y) {
        return null;
    }
}

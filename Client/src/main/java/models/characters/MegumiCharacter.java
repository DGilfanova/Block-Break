package models.characters;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class MegumiCharacter extends AbstractCharacter{

    Integer id = 2;

    @Override
    public Map<Integer, Integer> processBlock(Integer x, Integer y) {
        return null;
    }
}

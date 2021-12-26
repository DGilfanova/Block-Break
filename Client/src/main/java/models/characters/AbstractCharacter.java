package models.characters;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public abstract class AbstractCharacter {
    Integer id;

    public abstract Map<Integer, Integer> processBlock(Integer x, Integer y);
}

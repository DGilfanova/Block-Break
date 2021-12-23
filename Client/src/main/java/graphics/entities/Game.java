package graphics.entities;

import fertdt.ClientMain;
import fertdt.entities.Character;
import fertdt.entities.Field;
import fertdt.entities.PassiveSkill;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Game {

    public static final int RANDOM_ROOM_ID = 0;

    public static final int AWAIT = 1;
    public static final int CHARACTERS_SELECTING = 2;
    public static final int IN_PROGRESS = 3;
    public static final int FINISHED = 4;

    private Integer roomId, firstPlayer, secondPlayer, status, currentTurn, firstTurns, secondTurns;
    private Field firstField, secondField;
    private Character[] firstCharacters, secondCharacters;
    private PassiveSkill[] firstSkills, secondSkills;
    private int[] firstPoints, secondPoints;

    public Game(Integer roomId, Integer firstPlayer, Integer status) {
        this.roomId = roomId;
        this.firstPlayer = firstPlayer;
        this.status = status;
        firstTurns = 1;
        secondTurns = 1;
        firstPoints = new int[]{0, 0};
        secondPoints = new int[]{0, 0};
    }
}

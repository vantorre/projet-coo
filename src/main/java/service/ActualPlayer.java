package service;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by vantorre on 04/11/17.
 */
@Getter
@Setter
public class ActualPlayer {
    private static ActualPlayer ACTUAL_PLAYER =new ActualPlayer();
    private ActualPlayer(){}
    public static ActualPlayer getInstance(){
        return ACTUAL_PLAYER;
    }
    private String login;
}

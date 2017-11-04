package service;

/**
 * Created by vantorre on 04/11/17.
 */
public class ActualPlayer {
    private static ActualPlayer ACTUAL_PLAYER =new ActualPlayer();
    private ActualPlayer(){}
    public ActualPlayer getInstance(){
        return ACTUAL_PLAYER;
    }



    private String login;
    public String getActualPlayerLogin() {
        return login;
    }
    public void setActualPlayerLogin(String login) {
        this.login = login;
    }
}

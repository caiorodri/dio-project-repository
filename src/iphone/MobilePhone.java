package iphone;

public interface MobilePhone {

    public void call(Iphone iphone);

    public void callOff();

    public void answerCall();

    public void readMessages();
    
    public void sendMessage(Iphone iphone, String message);

}

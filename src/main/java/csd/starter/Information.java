package csd.starter;

/**
 * Created by CK on 2017/3/6.
 */
public class Information {
    private String sender;
    private String receiver;
    private Court court;

    public Information(String sender, String receiver, Court court) {
        this.sender = sender;
        this.receiver = receiver;
        this.court = court;
    }

    public String getMessage() {
        return getSender() + " sends to " + getReceiver() + ", court: " + getCourt().getId();
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public Court getCourt() {
        return court;
    }

    public void setCourt(Court court) {
        this.court = court;
    }
}

package Module2dot1.TelevisionPackage;

public class Television {
    private int channel;
    private boolean on;

    public Television() {
        this.channel = 0;
        this.on = false;
    }

    public int getChannel() {
        return channel;
    }

    public boolean isOn() {
        return on;
    }

    public void pressOnOff() {
        this.on = !this.on;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }
}

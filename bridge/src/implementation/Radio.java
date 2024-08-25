package implementation;

import static java.lang.StringTemplate.STR;

public class Radio implements Device{
    private boolean on;
    private int volume;
    private int channel;

    @Override
    public boolean isEnabled() {
        return on;
    }

    @Override
    public void enable() {
        on = true;
    }

    @Override
    public void disable() {
        on = false;
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public int getChannel() {
        return channel;
    }

    @Override
    public void setChannel(int channel) {
        this.channel = channel;
    }

    @Override
    public void printStatus() {
        System.out.println("--------------------------");
        System.out.println("| Io sono una televisione ");
        System.out.println(STR."| Io sono \{(on ? "collegato" : "spento")}");
        System.out.println(STR."| Volume corrente è \{volume}");
        System.out.println(STR."| Canale corrente è \{channel}");
        System.out.println("--------------------------");
    }
}

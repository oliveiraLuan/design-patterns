package abstraction;

import implementation.Device;

public class AdvancedRemote extends BasicRemote{
    public AdvancedRemote(Device device){
        this.device = device;
    }
    public void mute(){
        System.out.println("Remote: mute");
        device.setVolume(0);
    }
}
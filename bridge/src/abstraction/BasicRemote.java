package abstraction;

import implementation.Device;

public class BasicRemote implements Remote{
    protected Device device;

    public BasicRemote(Device device) {
        this.device = device;
    }

    public BasicRemote() {
    }

    @Override
    public void power() {
        System.out.println("Remote: Aggiunto pulsante di chiamata");
        if(device.isEnabled()){
            device.disable();
        }
        else device.enable();
    }

    @Override
    public void volumeDown() {
        System.out.println("Remote: Pulsante di spegnimento premuto");
        device.setVolume(device.getVolume() - 10);
    }

    @Override
    public void volumeUp() {
        System.out.println("Remote: Premi il pulsante di aumento del volume");
        device.setVolume(device.getVolume() + 10);
    }

    @Override
    public void channelDown() {
        System.out.println("Remote: Canale precedente");
        device.setChannel(device.getChannel() - 1);
    }

    @Override
    public void channelUp() {
        System.out.println("Remote: Canale successivo");
        device.setChannel(device.getChannel() + 1);
    }
}

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
        System.out.println("Remote: Acionado botão ligar");
        if(device.isEnabled()){
            device.disable();
        }
        else device.enable();
    }

    @Override
    public void volumeDown() {
        System.out.println("Remote: Acionado botão diminuir volume");
        device.setVolume(device.getVolume() - 10);
    }

    @Override
    public void volumeUp() {
        System.out.println("Remote: Acionado botão aumentar volume");
        device.setVolume(device.getVolume() + 10);
    }

    @Override
    public void channelDown() {
        System.out.println("Remote: Canal anterior");
        device.setChannel(device.getChannel() - 1);
    }

    @Override
    public void channelUp() {
        System.out.println("Remote: Próximo canal");
        device.setChannel(device.getChannel() + 1);
    }
}

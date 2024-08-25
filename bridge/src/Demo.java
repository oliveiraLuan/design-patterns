import abstraction.AdvancedRemote;
import abstraction.BasicRemote;
import implementation.Device;
import implementation.Radio;
import implementation.TV;

public static void main(String[] args) {
    testDevice(new TV(true, 15, 5));
    testDevice(new Radio(false, 50, 89));
}

private static void testDevice(Device device) {
    System.out.println("Test con controllo di base");
    BasicRemote basicRemote = new BasicRemote(device);
    basicRemote.power();
    device.printStatus();

    System.out.println("Test con controllo avanzato");
    AdvancedRemote advancedRemote = new AdvancedRemote(device);
    advancedRemote.power();
    advancedRemote.mute();
    device.printStatus();
}

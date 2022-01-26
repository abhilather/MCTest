package core.applicationController;

import core.models.Device;
import core.models.User;
import core.services.DeviceService;
import core.services.UserService;

public class Controller {

    public static void main(String[] args) {
        UserService userService = new UserService();
        DeviceService deviceService = new DeviceService();

        User hamilton = new User("'Lewis'", "Hamilton", "lh@meredes.com");
        User maxVerstappen = new User("Max", "Verstappen", "mv@redbull.com");

        Device mercedes = new Device("w12", "mercedes", hamilton.getEmailId(), "f1Turbo");
        Device redBull = new Device("rb16B", "redBull", maxVerstappen.getEmailId(), "f1TurboRB");

        System.out.println(userService.registerUser(hamilton));
        System.out.println(userService.registerUser(maxVerstappen));

        deviceService.registerDevice(mercedes, hamilton);
        deviceService.registerDevice(redBull, maxVerstappen);

        System.out.println(userService.getUserIds());
        System.out.println(deviceService.getDeviceIds());

//        update device with correct permission
        mercedes.setDeviceName("mercedesTH");
        String udpatedResponseForMercedes = deviceService.updateDeviceInformation(mercedes, hamilton.getEmailId());
        System.out.println(udpatedResponseForMercedes);

        redBull.setDeviceName("RB");
        String udpatedResponseForRedBull = deviceService.updateDeviceInformation(redBull, maxVerstappen.getEmailId());
        System.out.println(udpatedResponseForRedBull);

        mercedes.setDeviceName("mercedes");
        redBull.setDeviceName("redBull");

//        update device without correct permission
        mercedes.setDeviceName("mercedesTHIncorrect");
        String failureResponseForMercedes = deviceService.updateDeviceInformation(mercedes, maxVerstappen.getEmailId());
        System.out.println(failureResponseForMercedes);

        redBull.setDeviceName("redBullTHIncorrect");
        String failureResponseForRedbull = deviceService.updateDeviceInformation(redBull, hamilton.getEmailId());
        System.out.println(failureResponseForRedbull);


//        removing device without permission
        String failureToRemoveMercedes = deviceService.removeDevice(mercedes, maxVerstappen.getEmailId(), maxVerstappen);
        System.out.println(failureToRemoveMercedes);

        String failureToRemoveRedbull = deviceService.removeDevice(redBull, hamilton.getEmailId(), hamilton);
        System.out.println(failureToRemoveRedbull);

//        removing device with correct permission
        String successMessageForRemovingMercedes = deviceService.removeDevice(mercedes, hamilton.getEmailId(), hamilton);
        System.out.println(successMessageForRemovingMercedes);
        System.out.println("Device ids for hamilton " + hamilton.getDeviceIds());

        String successMessageForRemovingRedbull = deviceService.removeDevice(redBull, maxVerstappen.getEmailId(), maxVerstappen);
        System.out.println(successMessageForRemovingRedbull);
        System.out.println("Device ids for verstappen " + maxVerstappen.getDeviceIds());

    }
}

package core.models;

public class Device {

    String deviceId;
    String deviceName;
    String userEmail;
    String deviceType;

    public Device(String deviceId, String deviceName, String userEmail, String deviceType) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.userEmail = userEmail;
        this.deviceType = deviceType;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceInformation() {
        return "deviceName = " + this.deviceName + ", deviceId = " + this.deviceId + ", deviceType = " + this.deviceType;
    }
}

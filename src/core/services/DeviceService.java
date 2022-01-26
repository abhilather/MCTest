package core.services;

import core.models.Device;
import core.models.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class DeviceService {
    Map<String, Device> devices;

    public DeviceService() {
        this.devices = new HashMap<>();
    }

    public String registerDevice(Device device, User user) {
        if (this.devices.containsKey(device.getDeviceId())) {
            return "This device is already registered.";
        } else {
            this.devices.put(device.getDeviceId(), device);
            user.getDeviceIds().add(device.getDeviceId());
            return "Device successfully registered for user " + user.getEmailId();
        }
    }

    public String updateDeviceInformation(Device updatedDeviceInformation, String email) {
        if (!this.devices.containsKey(updatedDeviceInformation.getDeviceId())) {
            return "This device is not registered.";
        } else {
            String registeredUserEmailForDevice = this.devices.get(updatedDeviceInformation.getDeviceId()).getUserEmail();
            if (registeredUserEmailForDevice != email) {
                return "You do not have the permission to update the device information for device " + updatedDeviceInformation.getDeviceId();
            } else {
                Device deviceToUpdate = this.devices.get(updatedDeviceInformation.getDeviceId());
                deviceToUpdate.setDeviceName(updatedDeviceInformation.getDeviceName());
                return "Device information successfully updated " + updatedDeviceInformation.getDeviceInformation();
            }
        }
    }

    public String removeDevice(Device device, String email, User user) {
        if (!this.devices.containsKey(device.getDeviceId())) {
            return "This device is not registered.";
        } else {
            String registeredUserEmailForDevice = this.devices.get(device.getDeviceId()).getUserEmail();
            if (registeredUserEmailForDevice != email) {
                return "You do not have the permission to remove this device";
            } else {
                Device deviceToRemove = this.devices.get(device.getDeviceId());
                this.devices.remove(deviceToRemove.getDeviceId());
                List<String> updatedDeviceListForUser = user.getDeviceIds().stream()
                        .filter(deviceId -> deviceId != deviceToRemove.getDeviceId())
                        .collect(Collectors.toList());
                user.setDeviceIds(updatedDeviceListForUser);
                return "Device successfully unregistered";
            }
        }
    }

    public Set<String> getDeviceIds() {
        return this.devices.keySet();
    }
}

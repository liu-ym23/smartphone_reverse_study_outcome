package android.hardware.usb.flags;

/* JADX INFO: loaded from: classes.dex */
public final class FeatureFlagsImpl implements FeatureFlags {
    @Override // android.hardware.usb.flags.FeatureFlags
    public boolean enableInputPowerLimitedWarning() {
        return true;
    }

    @Override // android.hardware.usb.flags.FeatureFlags
    public boolean enableInterfaceNameDeviceFilter() {
        return false;
    }

    @Override // android.hardware.usb.flags.FeatureFlags
    public boolean enableIsModeChangeSupportedApi() {
        return true;
    }

    @Override // android.hardware.usb.flags.FeatureFlags
    public boolean enableIsPdCompliantApi() {
        return true;
    }

    @Override // android.hardware.usb.flags.FeatureFlags
    public boolean enableReportUsbDataComplianceWarning() {
        return true;
    }

    @Override // android.hardware.usb.flags.FeatureFlags
    public boolean enableUsbDataComplianceWarning() {
        return true;
    }

    @Override // android.hardware.usb.flags.FeatureFlags
    public boolean enableUsbDataSignalStaking() {
        return true;
    }

    @Override // android.hardware.usb.flags.FeatureFlags
    public boolean enableUsbSysfsMidiIdentification() {
        return false;
    }

    public FeatureFlagsImpl() {
    }
}

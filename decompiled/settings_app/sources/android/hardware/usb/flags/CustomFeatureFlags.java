package android.hardware.usb.flags;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes.dex */
public class CustomFeatureFlags implements FeatureFlags {
    private BiPredicate<String, Predicate<FeatureFlags>> mGetValueImpl;
    private Set<String> mReadOnlyFlagsSet;

    private boolean isOptimizationEnabled() {
        return false;
    }

    public CustomFeatureFlags(BiPredicate<String, Predicate<FeatureFlags>> r11) {
        this.mReadOnlyFlagsSet = new HashSet(Arrays.asList(new String[]{Flags.FLAG_ENABLE_INPUT_POWER_LIMITED_WARNING, Flags.FLAG_ENABLE_INTERFACE_NAME_DEVICE_FILTER, Flags.FLAG_ENABLE_IS_MODE_CHANGE_SUPPORTED_API, Flags.FLAG_ENABLE_IS_PD_COMPLIANT_API, Flags.FLAG_ENABLE_REPORT_USB_DATA_COMPLIANCE_WARNING, Flags.FLAG_ENABLE_USB_DATA_COMPLIANCE_WARNING, Flags.FLAG_ENABLE_USB_DATA_SIGNAL_STAKING, Flags.FLAG_ENABLE_USB_SYSFS_MIDI_IDENTIFICATION, ""}));
        this.mGetValueImpl = r11;
    }

    @Override // android.hardware.usb.flags.FeatureFlags
    public boolean enableInputPowerLimitedWarning() {
        return getValue(Flags.FLAG_ENABLE_INPUT_POWER_LIMITED_WARNING, new CustomFeatureFlags$$ExternalSyntheticLambda5());
    }

    @Override // android.hardware.usb.flags.FeatureFlags
    public boolean enableInterfaceNameDeviceFilter() {
        return getValue(Flags.FLAG_ENABLE_INTERFACE_NAME_DEVICE_FILTER, new CustomFeatureFlags$$ExternalSyntheticLambda3());
    }

    @Override // android.hardware.usb.flags.FeatureFlags
    public boolean enableIsModeChangeSupportedApi() {
        return getValue(Flags.FLAG_ENABLE_IS_MODE_CHANGE_SUPPORTED_API, new CustomFeatureFlags$$ExternalSyntheticLambda2());
    }

    @Override // android.hardware.usb.flags.FeatureFlags
    public boolean enableIsPdCompliantApi() {
        return getValue(Flags.FLAG_ENABLE_IS_PD_COMPLIANT_API, new CustomFeatureFlags$$ExternalSyntheticLambda4());
    }

    @Override // android.hardware.usb.flags.FeatureFlags
    public boolean enableReportUsbDataComplianceWarning() {
        return getValue(Flags.FLAG_ENABLE_REPORT_USB_DATA_COMPLIANCE_WARNING, new CustomFeatureFlags$$ExternalSyntheticLambda1());
    }

    @Override // android.hardware.usb.flags.FeatureFlags
    public boolean enableUsbDataComplianceWarning() {
        return getValue(Flags.FLAG_ENABLE_USB_DATA_COMPLIANCE_WARNING, new CustomFeatureFlags$$ExternalSyntheticLambda7());
    }

    @Override // android.hardware.usb.flags.FeatureFlags
    public boolean enableUsbDataSignalStaking() {
        return getValue(Flags.FLAG_ENABLE_USB_DATA_SIGNAL_STAKING, new CustomFeatureFlags$$ExternalSyntheticLambda0());
    }

    @Override // android.hardware.usb.flags.FeatureFlags
    public boolean enableUsbSysfsMidiIdentification() {
        return getValue(Flags.FLAG_ENABLE_USB_SYSFS_MIDI_IDENTIFICATION, new CustomFeatureFlags$$ExternalSyntheticLambda6());
    }

    public boolean isFlagReadOnlyOptimized(String r2) {
        if (this.mReadOnlyFlagsSet.contains(r2) == true) goto L5;
        return false;
    L5:
        if (isOptimizationEnabled() == false) goto L10;
        return true;
    L10:
        return false;
    }

    protected boolean getValue(String r1, Predicate<FeatureFlags> r2) {
        return this.mGetValueImpl.test(r1, r2);
    }

    public List<String> getFlagNames() {
        return Arrays.asList(new String[]{Flags.FLAG_ENABLE_INPUT_POWER_LIMITED_WARNING, Flags.FLAG_ENABLE_INTERFACE_NAME_DEVICE_FILTER, Flags.FLAG_ENABLE_IS_MODE_CHANGE_SUPPORTED_API, Flags.FLAG_ENABLE_IS_PD_COMPLIANT_API, Flags.FLAG_ENABLE_REPORT_USB_DATA_COMPLIANCE_WARNING, Flags.FLAG_ENABLE_USB_DATA_COMPLIANCE_WARNING, Flags.FLAG_ENABLE_USB_DATA_SIGNAL_STAKING, Flags.FLAG_ENABLE_USB_SYSFS_MIDI_IDENTIFICATION});
    }
}

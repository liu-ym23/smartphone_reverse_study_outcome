package com.android.settingslib.enterprise;

import android.app.admin.DevicePolicyManager;
import android.content.Context;
import android.hardware.biometrics.ParentalControlsUtilsInternal;
import android.os.UserHandle;
import android.provider.DeviceConfig;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class ActionDisabledByAdminControllerFactory {
    public static ActionDisabledByAdminController createInstance(Context r1, String r2, DeviceAdminStringProvider r3, UserHandle r4) {
        if (doesBiometricRequireParentalConsent(r1, r2) == false) goto L7;
        return new BiometricActionDisabledByAdminController(r3);
    L7:
        if (isFinancedDevice(r1) == false) goto L11;
        return new FinancedDeviceActionDisabledByAdminController(r3);
    L11:
        if (isSupervisedDevice(r1) == false) goto L15;
        return new SupervisedDeviceActionDisabledByAdminController(r3, r2);
    L15:
        return new ManagedDeviceActionDisabledByAdminController(r3, r4, ManagedDeviceActionDisabledByAdminController.DEFAULT_FOREGROUND_USER_CHECKER, ActionDisabledLearnMoreButtonLauncher.DEFAULT_RESOLVE_ACTIVITY_CHECKER);
    }

    private static boolean isSupervisedDevice(Context r2) {
        if (((DevicePolicyManager) r2.getSystemService(DevicePolicyManager.class)).getProfileOwnerOrDeviceOwnerSupervisionComponent(new UserHandle(UserHandle.myUserId())) == null) goto L5;
        return true;
    L5:
        return false;
    }

    private static boolean doesBiometricRequireParentalConsent(Context r2, String r3) {
        if (TextUtils.equals("disallow_biometric", r3) == true) goto L7;
        return false;
    L7:
        return ParentalControlsUtilsInternal.parentConsentRequired(r2, (DevicePolicyManager) r2.getSystemService(DevicePolicyManager.class), 14, new UserHandle(UserHandle.myUserId()));
    }

    private static boolean isFinancedDevice(Context r3) {
        DevicePolicyManager r4 = (DevicePolicyManager) r3.getSystemService(DevicePolicyManager.class);
        if (DeviceConfig.getBoolean("device_policy_manager", "add-isfinanced-device", true) == false) goto L7;
        return r4.isFinancedDevice();
    L7:
        if (r4.isDeviceManaged() == true) goto L9;
    L11:
        return false;
    L9:
        if (r4.getDeviceOwnerType(r4.getDeviceOwnerComponentOnAnyUser()) != 1) goto L11;
        return true;
    }

    private ActionDisabledByAdminControllerFactory() {
        throw new UnsupportedOperationException("provides only static methods");
    }
}

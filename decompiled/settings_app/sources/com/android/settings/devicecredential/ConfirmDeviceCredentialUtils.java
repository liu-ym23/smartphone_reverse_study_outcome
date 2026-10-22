package com.android.settings.devicecredential;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityOptions;
import android.app.admin.DevicePolicyManager;
import android.content.IntentSender;
import android.content.pm.UserInfo;
import android.os.Flags;
import android.os.RemoteException;
import android.os.UserManager;
import android.view.View;
import android.view.WindowInsets;
import com.android.internal.widget.LockPatternUtils;

/* JADX INFO: loaded from: classes2.dex */
public class ConfirmDeviceCredentialUtils {
    public ConfirmDeviceCredentialUtils() {
    }

    public static void checkForPendingIntent(Activity r9) {
        int r0 = r9.getIntent().getIntExtra("android.intent.extra.TASK_ID", -1);
        if (r0 != (-1)) goto L12;
    L6:
        IntentSender r2 = (IntentSender) r9.getIntent().getParcelableExtra("android.intent.extra.INTENT");
        if (r2 == null) goto L16;
        r9.startIntentSenderForResult(r2, -1, null, 0, 0, 0, ActivityOptions.makeBasic().setPendingIntentBackgroundActivityStartMode(1).toBundle());     // Catch: IntentSender.SendIntentException -> L11
        return;
    L17:
        return;
    L16:
        return;
    L12:
        ActivityManager.getService().startActivityFromRecents(r0, ActivityOptions.makeBasic().toBundle());     // Catch: RemoteException -> L10
    }

    public static void reportSuccessfulAttempt(LockPatternUtils r0, UserManager r1, DevicePolicyManager r2, int r3, boolean r4) {
        if (r4 == false) goto L12;
        r0.reportSuccessfulPasswordAttempt(r3);
        if (isBiometricUnlockEnabledForPrivateSpace() == false) goto L14;
        UserInfo r5 = r1.getUserInfo(r3);
        if (r5 == null) goto L14;
        if (isProfileThatAlwaysRequiresAuthToDisableQuietMode(r1, r5) == false) goto L10;
    L11:
        r0.userPresent(r3);
        goto L14
    L10:
        if (r5.isManagedProfile() == true) goto L11;
    L14:
        if (isBiometricUnlockEnabledForPrivateSpace() == false) goto L16;
        return;
    L16:
        if (r1.isManagedProfile(r3) == false) goto L20;
        r0.userPresent(r3);
        return;
    L20:
        return;
    L12:
        r2.reportSuccessfulBiometricAttempt(r3);
        goto L14
    }

    private static boolean isProfileThatAlwaysRequiresAuthToDisableQuietMode(UserManager r1, UserInfo r2) {
        if (r1.getUserProperties(r2.getUserHandle()).isAuthAlwaysRequiredToDisableQuietMode() == true) goto L5;
    L7:
        return false;
    L5:
        if (r2.isProfile() == false) goto L7;
        return true;
    }

    private static boolean isBiometricUnlockEnabledForPrivateSpace() {
        if (Flags.allowPrivateProfile() == true) goto L5;
    L9:
        return false;
    L5:
        if (android.multiuser.Flags.enableBiometricsToUnlockPrivateSpace() == false) goto L9;
        if (android.multiuser.Flags.enablePrivateSpaceFeatures() == false) goto L9;
        return true;
    }

    public static void hideImeImmediately(View r2) {
        if (r2.isAttachedToWindow() == true) goto L5;
        return;
    L5:
        if (r2.getRootWindowInsets().isVisible(WindowInsets.Type.ime()) == false) goto L9;
        r2.getWindowInsetsController().hide(WindowInsets.Type.ime());
        return;
    }
}

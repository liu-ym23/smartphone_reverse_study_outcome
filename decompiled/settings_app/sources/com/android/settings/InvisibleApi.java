package com.android.settings;

import android.app.admin.PasswordMetrics;
import android.hardware.fingerprint.Fingerprint;
import android.os.PowerManager;
import com.android.internal.widget.LockPatternUtils;
import com.android.internal.widget.LockPatternView;
import com.android.internal.widget.LockscreenCredential;
import com.android.internal.widget.VerifyCredentialResponse;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class InvisibleApi {
    public static final String ACTION_DISAPPEARED = "android.bluetooth.device.action.DISAPPEARED";
    public static final int INVALID_STACK_ID = -1;
    public static final int MOVE_FAILED_FORWARD_LOCKED = -4;
    public static final String USB_FUNCTION_CHARGE_ONLY = "charge_only";

    public InvisibleApi() {
    }

    public static void clearLock(LockPatternUtils r0, String r1) {
        LockPatternUtilsOnly.clearLock(r0, r1);
    }

    public static void clearLock2(LockPatternUtils r0, LockscreenCredential r1) {
        LockPatternUtilsOnly.clearLock2(r0, r1);
    }

    public static void clearLock2(LockPatternUtils r0, LockscreenCredential r1, int r2) {
        LockPatternUtilsOnly.clearLock2(r0, r1, r2);
    }

    public static VerifyCredentialResponse verifyPassword(LockPatternUtils r0, String r1, long r2, int r4) {
        return LockPatternUtilsOnly.verifyPassword(r0, r1.getBytes(), r2, r4);
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static boolean saveLockPattern(LockPatternUtils r0, List<LockPatternView.Cell> r1, String r2, int r3) {
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        return LockPatternUtilsOnly.saveLockPassword(r0, r1, r2, r3);
    }

    public static void setSeparateProfileChallengeEnabled(LockPatternUtils r0, int r1, boolean r2, String r3) {
        LockPatternUtilsOnly.setSeparateProfileChallengeEnabled(r0, r1, r2, r3);
    }

    public static void setSeparateProfileChallengeEnabled2(LockPatternUtils r0, int r1, boolean r2, LockscreenCredential r3) {
        LockPatternUtilsOnly.setSeparateProfileChallengeEnabled2(r0, r1, r2, r3);
    }

    public static int maxLengthSequence(String r6) {
        if (r6 != null) goto L10;
        r6 = "";
    L10:
        PasswordMetrics.class.getDeclaredMethod("maxLengthSequence", new Class[]{byte[].class}).invoke(PasswordMetrics.class, new Object[]{r6.getBytes()});     // Catch: Exception -> L7
    L9:
        return 0;
    L7:
        e = move-exception;
        e.printStackTrace();
        goto L9
    }

    public static boolean checkPasswordHistory(LockPatternUtils r8, String r9, String r10, int r11) {
        byte[] r12 = getPasswordHistoryHashFactor(r8, r10, r11);
        if (r9 != null) goto L13;
        r9 = "";
    L13:
        Object r13 = r8.getClass().getDeclaredMethod("checkPasswordHistory", new Class[]{byte[].class, byte[].class, Integer.TYPE}).invoke(r8, new Object[]{r9.getBytes(), r12, Integer.valueOf(r11)});     // Catch: Exception -> L10
        if ((r13 instanceof Boolean) == false) goto L12;
        return ((Boolean) r13).booleanValue();
    L12:
        return false;
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    public static byte[] getPasswordHistoryHashFactor(LockPatternUtils r7, String r8, int r9) {
        if (r8 != null) goto L12;
        r8 = "";
    L12:
        Object r10 = r7.getClass().getDeclaredMethod("getPasswordHistoryHashFactor", new Class[]{byte[].class, Integer.TYPE}).invoke(r7, new Object[]{r8.getBytes(), Integer.valueOf(r9)});     // Catch: Exception -> L8
        if ((r10 instanceof byte[]) == false) goto L14;
        return (byte[]) r10;
    L14:
        return null;
    L8:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static int getFingerId(Fingerprint r4) {
        Object r5 = r4.getClass().getMethod("getBiometricId", new Class[0]).invoke(r4, new Object[0]);     // Catch: Exception -> L7
        if ((r5 instanceof Integer) == false) goto L12;
        return ((Integer) r5).intValue();
    L12:
        return 0;
    L7:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }

    public static boolean setPowerSaveMode(PowerManager r3, boolean r4) {
        Object r5 = r3.getClass().getDeclaredMethod("setPowerSaveModeEnabled", new Class[0]).invoke(r3, new Object[0]);     // Catch: Exception -> L7
        if ((r5 instanceof Boolean) == false) goto L12;
        return ((Boolean) r5).booleanValue();
    L12:
        return false;
    L7:
        e = move-exception;
        e.printStackTrace();
        return false;
    }
}

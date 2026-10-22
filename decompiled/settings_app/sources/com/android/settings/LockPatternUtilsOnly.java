package com.android.settings;

import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import android.os.UserHandle;
import android.text.TextUtils;
import com.android.internal.widget.LockPatternUtils;
import com.android.internal.widget.LockPatternView;
import com.android.internal.widget.LockscreenCredential;
import com.android.internal.widget.VerifyCredentialResponse;
import com.obric.olog.OLog;
import java.lang.reflect.Field;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class LockPatternUtilsOnly {
    public LockPatternUtilsOnly() {
    }

    private static void throwIfCalledOnMainThread() {
        if (Looper.getMainLooper().isCurrentThread() == true) goto L6;
        return;
    L6:
        throw new IllegalStateException("should not be called from the main thread.");
    }

    private static Context getContext(LockPatternUtils r2) {
        Field r0 = r2.getClass().getDeclaredField("mContext");     // Catch: Throwable -> L4
        r0.setAccessible(true);     // Catch: Throwable -> L4
        return (Context) r0.get(r2);
    L4:
        e = move-exception;
        OLog.d("getContext", e.getClass().getSimpleName() + " ->> " + e.getMessage());
        return null;
    }

    public static VerifyCredentialResponse verifyPattern(LockPatternUtils r0, List<LockPatternView.Cell> r1, long r2, int r4) throws LockPatternUtils.RequestThrottledException {
        throwIfCalledOnMainThread();
        return r0.verifyCredential(LockscreenCredential.createPattern(r1), r4, 1);
    }

    public static VerifyCredentialResponse verifyPattern2(LockPatternUtils r0, LockscreenCredential r1, long r2, int r4) throws LockPatternUtils.RequestThrottledException {
        throwIfCalledOnMainThread();
        return r0.verifyCredential(r1, r4, 1);
    }

    public static boolean checkPattern(LockPatternUtils r2, List<LockPatternView.Cell> r3, int r4) throws LockPatternUtils.RequestThrottledException {
        LockPatternUtils.CheckCredentialProgressCallback r1 = (LockPatternUtils.CheckCredentialProgressCallback) null;
        return checkPattern(r2, r3, r4, null);
    }

    public static boolean checkPattern(LockPatternUtils r0, List<LockPatternView.Cell> r1, int r2, LockPatternUtils.CheckCredentialProgressCallback r3) throws LockPatternUtils.RequestThrottledException {
        throwIfCalledOnMainThread();
        return r0.checkCredential(LockscreenCredential.createPattern(r1), r2, r3);
    }

    public static VerifyCredentialResponse verifyPassword(LockPatternUtils r0, byte[] r1, long r2, int r4) throws LockPatternUtils.RequestThrottledException {
        return r0.verifyCredential(getLockScreenSavedPassword(r0, new String(r1), r4), r4, 1);
    }

    public static VerifyCredentialResponse verifyPassword2(LockPatternUtils r0, LockscreenCredential r1, long r2, int r4) throws LockPatternUtils.RequestThrottledException {
        return r0.verifyCredential(r1, r4, 1);
    }

    public static boolean checkPassword(LockPatternUtils r2, String r3, int r4) throws LockPatternUtils.RequestThrottledException {
        if (r3 == null) goto L5;
        byte[] r5 = r3.getBytes();
    L6:
        LockPatternUtils.CheckCredentialProgressCallback r1 = (LockPatternUtils.CheckCredentialProgressCallback) null;
        return checkPassword(r2, r5, r4, null);
    L5:
        r5 = null;
        goto L6
    }

    public static boolean checkPassword(LockPatternUtils r2, byte[] r3, int r4) throws LockPatternUtils.RequestThrottledException {
        LockPatternUtils.CheckCredentialProgressCallback r1 = (LockPatternUtils.CheckCredentialProgressCallback) null;
        return checkPassword(r2, r3, r4, null);
    }

    public static boolean checkPassword(LockPatternUtils r0, String r1, int r2, LockPatternUtils.CheckCredentialProgressCallback r3) throws LockPatternUtils.RequestThrottledException {
        if (r1 == null) goto L4;
        byte[] r4 = r1.getBytes();
    L6:
        return r0.checkCredential(getLockScreenSavedPassword(r0, r4.toString(), r2), r2, r3);
    L4:
        r4 = null;
        goto L6
    }

    public static boolean checkPassword(LockPatternUtils r1, byte[] r2, int r3, LockPatternUtils.CheckCredentialProgressCallback r4) throws LockPatternUtils.RequestThrottledException {
        return r1.checkCredential(getLockScreenSavedPassword(r1, new String(r2), r3), r3, r4);
    }

    public static long getPasswordLengthBytedance(LockPatternUtils r4, int r5) {
        return getLong(r4, "lockscreen.passwordlength_settings", android.provider.Settings.System.getLong(getContext(r4).getContentResolver(), "pin_password_length_type", -1), r5);
    }

    private static long getLong(LockPatternUtils r0, String r1, long r2, int r4) {
        return r0.getLockSettings().getLong(r1, r2, r4);
    L4:
        return r2;
    }

    private static void setLong(LockPatternUtils r0, String r1, long r2, int r4) {
        r0.getLockSettings().setLong(r1, r2, r4);     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        OLog.e("LockPatternUtils", "Couldn't write long " + r1 + e);
    }

    public static void setPasswordLengthBytedance(LockPatternUtils r1, long r2, int r4) {
        setLong(r1, "lockscreen.passwordlength_settings", r2, r4);
    }

    private static void setKeyguardStoredPasswordQuality(LockPatternUtils r3, int r4, int r5) {
        setLong(r3, "lockscreen.password_type", r4, r5);
    }

    public static boolean saveLockPassword(LockPatternUtils r9, String r10, String r11, int r12, int r13) {
        if (r9.hasSecureLockScreen() == false) goto L40;
        if (r10 == null) goto L38;
        if (r10.length() < 4) goto L38;
        if (r12 < 131072) goto L36;
        int r2 = r9.getKeyguardStoredPasswordQuality(r13);
        setKeyguardStoredPasswordQuality(r9, computeKeyguardQuality(2, r12, 0), r13);
        int r3 = r10.length();     // Catch: Exception -> L32
        if (r3 != 6) goto L14;
        if (r12 != 131072) goto L14;
        r12 = 196608;
    L14:
        if (r12 == 131072) goto L16;
        if (r12 == 196608) goto L16;
    L25:
        if (r12 == 131072) goto L28;
        if (r12 == 196608) goto L28;
        LockscreenCredential r14 = LockscreenCredential.createPassword(r10);     // Catch: Exception -> L32
    L29:
        LockscreenCredential r15 = getLockScreenSavedPassword(r9, r11, r13);     // Catch: Exception -> L32
        setKeyguardStoredPasswordQuality(r9, r12, r13);     // Catch: Exception -> L32
        r9.setLockCredential(r14, r15, r13);     // Catch: Exception -> L32
        return true;
    L28:
        r14 = LockscreenCredential.createPin(r10);     // Catch: Exception -> L32
    L16:
        if (r10 == null) goto L25;
        if (getContext(r9) == null) goto L25;
        if (r3 == 4) goto L24;
        if (r3 == 6) goto L24;
        throw new IllegalArgumentException("easy password length must be 4 or 6");     // Catch: Exception -> L32
    L24:
        setPasswordLengthBytedance(r9, r3, r13);     // Catch: Exception -> L32
    L32:
        e = move-exception;
        OLog.e("LockPatternUtils", "Unable to save lock password", e);
        setKeyguardStoredPasswordQuality(r9, r2, r13);
        return false;
    L36:
        throw new IllegalArgumentException("quality must be at least NUMERIC, but was " + r12);
    L38:
        throw new IllegalArgumentException("password must not be null and at least of length 4");
    L40:
        throw new UnsupportedOperationException("This operation requires the lock screen feature.");
    }

    public static boolean saveLockPassword(LockPatternUtils r0, List<LockPatternView.Cell> r1, String r2, int r3) {
        return r0.setLockCredential(LockscreenCredential.createPattern(r1), getLockScreenSavedPassword(r0, r2, r3), r3);
    }

    public static LockscreenCredential getLockScreenSavedPassword(LockPatternUtils r2, String r3, int r4) {
        LockscreenCredential r0 = LockscreenCredential.createNone();
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return r0;
    L5:
        int r5 = r2.getKeyguardStoredPasswordQuality(r4);
        if (r5 != 65536) goto L8;
        if (r3 != null) goto L24;
        byte[] r6 = null;
    L26:
        return LockscreenCredential.createPattern(LockPatternUtils.byteArrayToPattern(r6));
    L24:
        r6 = r3.getBytes();
        goto L26
    L8:
        if (r5 == 131072) goto L28;
        if (r5 == 196608) goto L28;
        if (r5 == 262144) goto L27;
        if (r5 == 327680) goto L27;
        if (r5 == 393216) goto L27;
        if (r5 == 524288) goto L27;
        return r0;
    L27:
        return LockscreenCredential.createPasswordOrNone(r3);
    L28:
        return LockscreenCredential.createPinOrNone(r3);
    }

    public static void clearLock(LockPatternUtils r2, String r3) {
        if (r3 != null) goto L4;
        r3 = "";
    L4:
        int r0 = UserHandle.myUserId();
        LockscreenCredential r4 = getLockScreenSavedPassword(r2, r3, r0);
        setKeyguardStoredPasswordQuality(r2, 0, r0);
        r2.setLockCredential(LockscreenCredential.createNone(), r4, r0);
    }

    public static void clearLock2(LockPatternUtils r2, LockscreenCredential r3) {
        if (r3 != null) goto L4;
        r3 = LockscreenCredential.createNone();
    L4:
        int r0 = UserHandle.myUserId();
        setKeyguardStoredPasswordQuality(r2, 0, r0);
        r2.setLockCredential(LockscreenCredential.createNone(), r3, r0);
    }

    public static void clearLock2(LockPatternUtils r1, LockscreenCredential r2, int r3) {
        if (r2 != null) goto L4;
        r2 = LockscreenCredential.createNone();
    L4:
        setKeyguardStoredPasswordQuality(r1, 0, r3);
        r1.setLockCredential(LockscreenCredential.createNone(), r2, r3);
    }

    public static void setSeparateProfileChallengeEnabled(LockPatternUtils r0, int r1, boolean r2, String r3) {
        r0.setSeparateProfileChallengeEnabled(r1, r2, getLockScreenSavedPassword(r0, r3, r1));
    }

    public static void setSeparateProfileChallengeEnabled2(LockPatternUtils r0, int r1, boolean r2, LockscreenCredential r3) {
        r0.setSeparateProfileChallengeEnabled(r1, r2, r3);
    }

    private static int computeKeyguardQuality(int r1, int r2, int r3) {
        if (r1 == 2) goto L5;
        return r3;
    L5:
        return Math.max(r3, r2);
    }
}

package com.android.settings.riskcontrol;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ApplicationInfoEx;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.UserHandle;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.GlobalProxyLancet;
import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.utils.DisplayUtils;
import com.obric.oui.dialog.v2.alert.OAlertDialogBuilder;

/* JADX INFO: loaded from: classes2.dex */
public final class RiskPermissionControlGuard {
    private static final String TAG = "RiskPermissionGuard";

    private RiskPermissionControlGuard() {
    }

    public static boolean isNotificationBlocked(Context r1, String r2, int r3) {
        return isPermissionChangeBlocked(r1, r2, r3, 64);
    }

    public static boolean isAccessibilityBlocked(Context r1, String r2, int r3) {
        return isPermissionChangeBlocked(r1, r2, r3, 32);
    }

    public static boolean isInstallPackagesBlocked(Context r1, String r2, int r3) {
        return isPermissionChangeBlocked(r1, r2, r3, 16);
    }

    public static boolean isNetworkBlocked(Context r1, String r2, int r3) {
        return isPermissionChangeBlocked(r1, r2, r3, 3);
    }

    public static boolean intercept(Context r3, String r4, int r5, int r6) {
        if (isPermissionChangeBlocked(r3, r4, r5, r6) == true) goto L5;
        return false;
    L5:
        Drawable r7 = null;
        PackageManager r0 = r3.getPackageManager();     // Catch: Throwable -> L11
        ApplicationInfo r8 = r0.getApplicationInfo(r4, 0);     // Catch: Throwable -> L11
        CharSequence r1 = r8.loadLabel(r0);     // Catch: Throwable -> L11
        r7 = r8.loadIcon(r0);     // Catch: Throwable -> L9
    L14:
        showBlockedDialog(r3, r1, r7);
        return true;
    L9:
        th = th;
    L13:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "load app info failed, pkg=" + r4, th);
    L11:
        th = th;
        r1 = null;
        goto L13
    }

    public static boolean interceptOnActionUp(Context r1, String r2, int r3, int r4, MotionEvent r5) {
        if (r5 != null) goto L4;
    L8:
        return false;
    L4:
        if (r5.getAction() != 1) goto L8;
        if (intercept(r1, r2, r3, r4) == false) goto L8;
        return true;
    }

    public static boolean isPermissionChangeBlocked(Context r5, String r6, int r7, int r8) {
        if (r5 != null) goto L5;
    L13:
        return false;
    L5:
        if (TextUtils.isEmpty(r6) == true) goto L13;
        if (isWhiteApp(r5, r6) == false) goto L11;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_i(TAG, "isPermissionChangeBlocked false, white app, pkg=" + r6 + ", userId=" + r7 + ", flag=" + r8);
        return false;
    L11:
        boolean r9 = RiskControlSettingsSnapshotStore.isFlagControlled(r5, r6, r7, r8);
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_i(TAG, "isPermissionChangeBlocked result=" + r9 + ", pkg=" + r6 + ", userId=" + r7 + ", flag=" + r8);
        return r9;
    }

    private static boolean isWhiteApp(Context r3, String r4) {
        ApplicationInfo r5 = r3.getPackageManager().getApplicationInfo(r4, 0);     // Catch: Throwable -> L9 PackageManager.NameNotFoundException -> L12
        if (Utils.isSystemPackage(r5) == true) goto L7;
        if (ApplicationInfoEx.isObricApp(r5) == true) goto L7;
        return false;
    L7:
        return true;
    L9:
        th = move-exception;
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_w(TAG, "isWhiteApp error, pkg=" + r4, th);
    L11:
        return false;
    }

    public static void showBlockedDialog(Context r3, CharSequence r4, Drawable r5) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r4) == true) goto L7;
        String r6 = r4.toString();
    L8:
        OAlertDialogBuilder r7 = new OAlertDialogBuilder(r3).title(r3.getString(R.string.risk_app_feature_limited_title, new Object[]{r6}), false).message(R.string.risk_app_feature_limited_message).negativeButton(R.string.ok2, new AnonymousClass1());
        if (r5 == null) goto L11;
        r7.icon(r5).imageSize((int) DisplayUtils.dip2px(56.0f), (int) DisplayUtils.dip2px(56.0f));
    L11:
        r7.createDialog().show();
        return;
    L7:
        r6 = r3.getString(R.string.app_name);
        goto L8
    }

    public static int getUserId(int r0) {
        return UserHandle.getUserId(r0);
    }
}

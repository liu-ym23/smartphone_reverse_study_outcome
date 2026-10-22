package com.android.settings;

import android.app.SmtPCUtils;
import android.app.backup.IBackupManager;
import android.content.Context;
import android.debug.IAdbManager;
import android.net.VpnManager;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemProperties;
import android.os.UserHandle;
import android.os.UserManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.IWebViewUpdateService;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SpinnerAdapter;
import com.android.internal.telephony.dataconnection.ApnSettingUtils;
import com.android.internal.telephony.uicc.IccRecords;
import com.android.org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import com.android.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import com.android.settingslib.RestrictedLockUtils;
import com.android.settingslib.RestrictedLockUtilsInternal;
import com.android.settingslib.location.RecentLocationApps;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import obric.widget.SettingItemText;

/* JADX INFO: loaded from: classes2.dex */
public class MultiSDKAdapterNew {
    private static final String HOT_KEY = "hot_key";
    public static final int SYSTEM_FLAG_HIDE_NON_SYSTEM_OVERLAY_WINDOWS = 524288;
    private static final String TAG = "MultiSDKAdapterNew";

    public static int getLteNwMode(boolean r0) {
        if (r0 == false) goto L4;
        return 10;
    L4:
        return 20;
    }

    public static int getModeLteOnly() {
        return 11;
    }

    public static int getNwMode(boolean r0) {
        if (r0 == false) goto L4;
        return 7;
    L4:
        return 18;
    }

    public static int getOverlayWindowsFlag() {
        return 524288;
    }

    public static String getSmtOpsService() {
        return "smtops";
    }

    public static int getWapiCertValue() {
        return 14;
    }

    public static int getWapiPskValue() {
        return 13;
    }

    public static boolean isFallbackPackage(IWebViewUpdateService r0, String r1) {
        return false;
    }

    private static boolean isKeyBoardMacStyle(int r1) {
        if (r1 == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static boolean isSupportNetworkType(int r1) {
        if (r1 != 22) goto L5;
    L24:
        return true;
    L5:
        if (r1 == 20) goto L24;
        if (r1 == 19) goto L24;
        if (r1 == 17) goto L24;
        if (r1 == 16) goto L24;
        if (r1 == 12) goto L24;
        if (r1 == 11) goto L24;
        if (r1 == 10) goto L24;
        if (r1 == 9) goto L24;
        if (r1 == 8) goto L24;
        return false;
    }

    public MultiSDKAdapterNew() {
    }

    public static boolean mvnoMatches(IccRecords r2, String r3, String r4) {
        if (r2 != null) goto L5;
    L10:
        return false;
    L5:
        if (TextUtils.isEmpty(r3) == true) goto L10;
        return ApnSettingUtils.mvnoMatches(r2, Integer.parseInt(r3), r4);
    }

    public static boolean hasBaseUserRestriction(Context r0, String r1, int r2) {
        return RestrictedLockUtilsInternal.hasBaseUserRestriction(r0, r1, r2);
    }

    public static RestrictedLockUtils.EnforcedAdmin checkIfRestrictionEnforced(Context r0, String r1, int r2) {
        return RestrictedLockUtilsInternal.checkIfRestrictionEnforced(r0, r1, r2);
    }

    public static boolean setAlwaysOnVpnPackage(VpnManager r0, int r1, String r2, boolean r3, List<String> r4) {
        if (r0 != null) goto L6;
        return false;
    L6:
        return r0.setAlwaysOnVpnPackageForUser(r1, r2, r3, r4);
    }

    public static SpinnerAdapter createUserSpinnerAdapter(UserManager r0, Context r1) {
        return UserAdapter.createUserSpinnerAdapter(r0, r1);
    }

    public static RestrictedLockUtils.EnforcedAdmin checkIfKeyguardFeaturesDisabled(Context r0, int r1, int r2) {
        return RestrictedLockUtilsInternal.checkIfKeyguardFeaturesDisabled(r0, r1, r2);
    }

    public static RestrictedLockUtils.EnforcedAdmin checkIfInputMethodDisallowed(Context r0, String r1, int r2) {
        return RestrictedLockUtilsInternal.checkIfInputMethodDisallowed(r0, r1, r2);
    }

    public static RestrictedLockUtils.EnforcedAdmin checkIfAccountManagementDisabled(Context r0, String r1, int r2) {
        return RestrictedLockUtilsInternal.checkIfAccountManagementDisabled(r0, r1, r2);
    }

    public static RestrictedLockUtils.EnforcedAdmin checkIfRemoteContactSearchDisallowed(Context r0, int r1) {
        return RestrictedLockUtilsInternal.checkIfRemoteContactSearchDisallowed(r0, r1);
    }

    public static RestrictedLockUtils.EnforcedAdmin checkIfAccessibilityServiceDisallowed(Context r0, String r1, int r2) {
        return RestrictedLockUtilsInternal.checkIfAccessibilityServiceDisallowed(r0, r1, r2);
    }

    public static RestrictedLockUtils.EnforcedAdmin checkIfUninstallBlocked(Context r0, String r1, int r2) {
        return RestrictedLockUtilsInternal.checkIfUninstallBlocked(r0, r1, r2);
    }

    public static UserHandle getUserId(int r0) {
        return UserHandle.of(r0);
    }

    public static AlgorithmIdentifier getPrivateKeyAlgorithm(PrivateKeyInfo r0) {
        return r0.getPrivateKeyAlgorithm();
    }

    public static void setDebugLayoutProperty(boolean r0) {
        debug_layout(Boolean.valueOf(r0));
    }

    public static boolean getDebugLayoutProperty() {
        return debug_layout().orElse(false).booleanValue();
    }

    public static Optional<Boolean> debug_layout() {
        return Optional.ofNullable(tryParseBoolean(SystemProperties.get("debug.layout")));
    }

    public static void debug_layout(Boolean r1) {
        if (r1 != null) goto L4;
        String r2 = "";
    L5:
        SystemProperties.set("debug.layout", r2);
        return;
    L4:
        r2 = r1.toString();
        goto L5
    }

    public static String getDataManagementLabel(IBackupManager r0, int r1, String r2) {
        return r0.getDataManagementLabelForUser(r1, r2).toString();
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public static UserHandle getUserHandle(SpinnerAdapter r0, int r1) {
        return ((UserAdapter) r0).getUserHandle(r1);
    }

    public static int getColorAccent(Context r0) {
        return Utils.getColorAccent(r0).getDefaultColor();
    }

    public static List<RecentLocationApps.Request> getAppList(RecentLocationApps r1) {
        return r1.getAppList(true);
    }

    private static Boolean tryParseBoolean(String r2) {
        String r0 = r2.toLowerCase(Locale.US);
        if ("1".equals(r0) == true) goto L17;
        if ("true".equals(r2) == true) goto L17;
        if ("0".equals(r0) == true) goto L15;
        if ("false".equals(r0) == true) goto L15;
        return null;
    L15:
        return Boolean.FALSE;
    L17:
        return Boolean.TRUE;
    }

    public static boolean customKeyBoardSettings(int r2, KeyEvent r3, EditText r4, Button r5, SettingItemText r6, Context r7, int r8, HashMap<String, String> r9) {
        Bundle r10 = new Bundle();
        boolean r0 = SmtPCUtils.generateHotKeys(r3, r10);
        String r11 = r10.getString("hot_key");
        if (TextUtils.isEmpty(r11) == false) goto L5;
        return r0;
    L5:
        r4.setText(r11);
        if (SmtPCUtils.shouldNotOK(r3, isKeyBoardMacStyle(r8)) == false) goto L8;
    L11:
        r5.setEnabled(false);
    L12:
        return true;
    L8:
        if (isCurrentKeyConflict(r11, r6, r7, r8, r9) == true) goto L11;
        r5.setEnabled(true);
        goto L12
    }

    public static boolean isCurrentKeyConflict(String r0, SettingItemText r1, Context r2, int r3, HashMap<String, String> r4) {
        boolean r5 = SmtPCUtils.isCurrentKeyConflict(r0, (String) r1.getTag(), isKeyBoardMacStyle(r3));
        if (r5 == false) goto L5;
        ToastUtils.showInView(r2, R.string.key_hold_by_others);
    L5:
        return r5;
    }

    public static void clearUsbDebuggingKeys(IAdbManager r1) {
        r1.clearDebuggingKeys();     // Catch: RemoteException -> L4
        return;
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }
}

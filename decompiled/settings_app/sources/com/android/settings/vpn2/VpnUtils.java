package com.android.settings.vpn2;

import android.content.Context;
import android.net.VpnManager;
import android.os.RemoteException;
import android.provider.Settings;
import android.security.LegacyVpnProfileStore;
import com.android.internal.net.VpnConfig;

/* JADX INFO: loaded from: classes2.dex */
public class VpnUtils {
    public VpnUtils() {
    }

    public static String getLockdownVpn() {
        byte[] r0 = LegacyVpnProfileStore.get("LOCKDOWN_VPN");
        if (r0 != null) goto L6;
        return null;
    L6:
        return new String(r0);
    }

    public static void clearLockdownVpn(Context r1) {
        LegacyVpnProfileStore.remove("LOCKDOWN_VPN");
        ((VpnManager) r1.getSystemService(VpnManager.class)).updateLockdownVpn();
    }

    public static void setLockdownVpn(Context r1, String r2) {
        LegacyVpnProfileStore.put("LOCKDOWN_VPN", r2.getBytes());
        ((VpnManager) r1.getSystemService(VpnManager.class)).updateLockdownVpn();
    }

    public static boolean isVpnLockdown(String r1) {
        return r1.equals(getLockdownVpn());
    }

    public static boolean isAnyLockdownActive(Context r4) {
        int r0 = r4.getUserId();
        if (getLockdownVpn() == null) goto L6;
        return true;
    L6:
        if (getVpnManager(r4).getAlwaysOnVpnPackageForUser(r0) == null) goto L11;
        if (Settings.Secure.getIntForUser(r4.getContentResolver(), "always_on_vpn_lockdown", 0, r0) == 0) goto L11;
        return true;
    L11:
        return false;
    }

    public static boolean isVpnActive(Context r1) throws RemoteException {
        if (getVpnManager(r1).getVpnConfig(r1.getUserId()) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static String getConnectedPackage(VpnManager r0, int r1) {
        VpnConfig r2 = r0.getVpnConfig(r1);
        if (r2 != null) goto L7;
        return null;
    L7:
        return r2.user;
    }

    private static VpnManager getVpnManager(Context r1) {
        return (VpnManager) r1.getSystemService(VpnManager.class);
    }

    public static boolean isAlwaysOnVpnSet(VpnManager r0, int r1) {
        if (r0.getAlwaysOnVpnPackageForUser(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean disconnectLegacyVpn(Context r3) {
        int r0 = r3.getUserId();
        if (getVpnManager(r3).getLegacyVpnInfo(r0) == null) goto L6;
        clearLockdownVpn(r3);
        getVpnManager(r3).prepareVpn(null, "[Legacy VPN]", r0);
        return true;
    L6:
        return false;
    }
}

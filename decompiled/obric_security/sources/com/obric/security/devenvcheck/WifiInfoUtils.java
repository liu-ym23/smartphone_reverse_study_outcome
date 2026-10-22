package com.obric.security.devenvcheck;

import android.content.Context;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: WifiInfoUtils.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\bJ\u0014\u0010\f\u001a\u0004\u0018\u00010\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0002J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/security/devenvcheck/WifiInfoUtils;", "", "()V", "INVALID_BSSID", "", "UNKNOWN_SSID", "getCurrentBssid", "context", "Landroid/content/Context;", "getCurrentSsid", "getCurrentWifiInfo", "Lcom/obric/security/devenvcheck/WifiInfoUtils$WifiInfoResult;", "normalizeBssid", "rawBssid", "normalizeSsid", "rawSsid", "unquoteSsid", "WifiInfoResult", "devenvcheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class WifiInfoUtils {
    public static final WifiInfoUtils INSTANCE = null;
    private static final String INVALID_BSSID = "02:00:00:00:00:00";
    private static final String UNKNOWN_SSID = "<unknown ssid>";

    /* JADX INFO: compiled from: WifiInfoUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/obric/security/devenvcheck/WifiInfoUtils$WifiInfoResult;", "", "ssid", "", "bssid", "(Ljava/lang/String;Ljava/lang/String;)V", "getBssid", "()Ljava/lang/String;", "getSsid", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "devenvcheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class WifiInfoResult {
        private final String bssid;
        private final String ssid;

        public static /* synthetic */ WifiInfoResult copy$default(WifiInfoResult r0, String r1, String r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.ssid;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.bssid;
        L9:
            return r0.copy(r1, r2);
        }

        public final String component1() {
            return this.ssid;
        }

        public final String component2() {
            return this.bssid;
        }

        public final WifiInfoResult copy(String r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, "ssid");
            Intrinsics.checkNotNullParameter(r2, "bssid");
            return new WifiInfoResult(r1, r2);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof WifiInfoResult) == false) goto L10;
            WifiInfoResult r4 = (WifiInfoResult) r3;
            if (Intrinsics.areEqual(this.ssid, r4.ssid) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.bssid, r4.bssid) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public int hashCode() {
            String r0 = this.ssid;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.bssid;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return "WifiInfoResult(ssid=" + this.ssid + ", bssid=" + this.bssid + ")";
        }

        public WifiInfoResult(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "ssid");
            Intrinsics.checkNotNullParameter(r3, "bssid");
            this.ssid = r2;
            this.bssid = r3;
        }

        public final String getSsid() {
            return this.ssid;
        }

        public final String getBssid() {
            return this.bssid;
        }
    }

    static {
        INSTANCE = new WifiInfoUtils();
    }

    private WifiInfoUtils() {
    }

    public final WifiInfoResult getCurrentWifiInfo(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        WifiManager r5 = (WifiManager) r4.getApplicationContext().getSystemService(WifiManager.class);
        if (r5 != null) goto L5;
        return null;
    L5:
        WifiInfo r6 = r5.getConnectionInfo();
        if (r6 != null) goto L9;
        return null;
    L9:
        if (r6.getSupplicantState() == SupplicantState.COMPLETED) goto L11;
        return null;
    L11:
        String r1 = normalizeSsid(r6.getSSID());
        if (r1 != null) goto L14;
        return null;
    L14:
        String r3 = normalizeBssid(r6.getBSSID());
        if (r3 != null) goto L18;
        return null;
    L18:
        return new WifiInfoResult(r1, r3);
    }

    public final String getCurrentSsid(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        WifiInfoResult r1 = getCurrentWifiInfo(r2);
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.getSsid();
    }

    public final String getCurrentBssid(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        WifiInfoResult r1 = getCurrentWifiInfo(r2);
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.getBssid();
    }

    private final String normalizeSsid(String r3) {
        String r2 = r3;
        if (r2 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        String r1 = null;
        if (r0 == false) goto L12;
        return null;
    L12:
        if (Intrinsics.areEqual(r3, UNKNOWN_SSID) == true) goto L21;
        String r4 = StringsKt.removeSurrounding(StringsKt.trim(r2).toString(), "\"");
        if (StringsKt.isBlank(r4) == true) goto L19;
        r1 = r4;
    L19:
        return r1;
    L21:
        return null;
    L5:
        if (StringsKt.isBlank(r2) == true) goto L8;
        r0 = false;
        goto L9
    }

    public final String unquoteSsid(String r1) {
        return normalizeSsid(r1);
    }

    private final String normalizeBssid(String r1) {
        String r0 = r1;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        return null;
    L11:
        if (Intrinsics.areEqual(r1, INVALID_BSSID) == true) goto L16;
        return r1;
    L16:
        return null;
    L5:
        if (StringsKt.isBlank(r0) == true) goto L8;
        r2 = false;
        goto L9
    }
}

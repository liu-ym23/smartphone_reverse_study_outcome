package com.android.settings.wifi;

import android.icu.text.PluralRules;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WlanRiskInfo.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 $2\u00020\u0001:\u0001$B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u001c\b\u0002\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u001b\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003JE\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u001c\b\u0002\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR.\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006%"}, d2 = {"Lcom/android/settings/wifi/WlanRiskInfo;", "", "ssid", "", WlanRiskInfo.EXTRA_BSSID, WlanRiskInfo.EXTRA_RISKS, "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "timestamp", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;J)V", "getBssid", "()Ljava/lang/String;", "setBssid", "(Ljava/lang/String;)V", "getRisks", "()Ljava/util/ArrayList;", "setRisks", "(Ljava/util/ArrayList;)V", "getSsid", "setSsid", "getTimestamp", "()J", "setTimestamp", "(J)V", "component1", "component2", "component3", "component4", "copy", "equals", "", PluralRules.KEYWORD_OTHER, "hashCode", "", "toString", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class WlanRiskInfo {
    public static final Companion Companion = null;
    public static final String EXTRA_BSSID = "bssid";
    public static final String EXTRA_RISKS = "risks";
    public static final String EXTRA_SSID = "ssid";
    public static final String EXTRA_TIMESTAMP = "timestamp";
    private String bssid;
    private ArrayList<String> risks;
    private String ssid;
    private long timestamp;

    /* JADX INFO: compiled from: WlanRiskInfo.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/android/settings/wifi/WlanRiskInfo$Companion;", "", "()V", "EXTRA_BSSID", "", "EXTRA_RISKS", "EXTRA_SSID", "EXTRA_TIMESTAMP", "isWlanRisk", "", "wlanRiskInfo", "Lcom/android/settings/wifi/WlanRiskInfo;", "ssid", WlanRiskInfo.EXTRA_BSSID, "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final boolean isWlanRisk(WlanRiskInfo r3, String r4, String r5) {
            Intrinsics.checkNotNullParameter(r3, "wlanRiskInfo");
            Intrinsics.checkNotNullParameter(r4, "ssid");
            ArrayList<String> r2 = r3.getRisks();
            if (r2 != null) goto L5;
        L8:
            boolean r6 = true;
        L9:
            if (r6 == false) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(r3.getSsid(), r4) == false) goto L17;
            if (Intrinsics.areEqual(r3.getBssid(), r5) == false) goto L17;
            return true;
        L17:
            return false;
        L5:
            if (r2.isEmpty() == true) goto L8;
            r6 = false;
            goto L9
        }
    }

    static {
        Companion = new Companion(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WlanRiskInfo copy$default(WlanRiskInfo r3, String r4, String r5, ArrayList r6, long r7, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.ssid;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.bssid;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.risks;
    L11:
        ArrayList r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.timestamp;
    L14:
        String r8 = r4;
        return r3.copy(r8, r11, r0, r7);
    }

    public final String component1() {
        return this.ssid;
    }

    public final String component2() {
        return this.bssid;
    }

    public final ArrayList<String> component3() {
        return this.risks;
    }

    public final long component4() {
        return this.timestamp;
    }

    public final WlanRiskInfo copy(String r7, String r8, ArrayList<String> r9, long r10) {
        Intrinsics.checkNotNullParameter(r7, "ssid");
        Intrinsics.checkNotNullParameter(r8, EXTRA_BSSID);
        return new WlanRiskInfo(r7, r8, r9, r10);
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L6;
        return true;
    L6:
        if ((r6 instanceof WlanRiskInfo) == true) goto L8;
        return false;
    L8:
        WlanRiskInfo r7 = (WlanRiskInfo) r6;
        if (Intrinsics.areEqual(this.ssid, r7.ssid) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.bssid, r7.bssid) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.risks, r7.risks) == true) goto L18;
        return false;
    L18:
        if (this.timestamp == r7.timestamp) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.ssid.hashCode() * 31) + this.bssid.hashCode()) * 31;
        ArrayList<String> r1 = this.risks;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((r0 + r2) * 31) + Long.hashCode(this.timestamp);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "WlanRiskInfo(ssid=" + this.ssid + ", bssid=" + this.bssid + ", risks=" + this.risks + ", timestamp=" + this.timestamp + ')';
    }

    public WlanRiskInfo(String r2, String r3, ArrayList<String> r4, long r5) {
        Intrinsics.checkNotNullParameter(r2, "ssid");
        Intrinsics.checkNotNullParameter(r3, EXTRA_BSSID);
        this.ssid = r2;
        this.bssid = r3;
        this.risks = r4;
        this.timestamp = r5;
    }

    public /* synthetic */ WlanRiskInfo(String r7, String r8, ArrayList r9, long r10, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 4) == 0) goto L5;
        r9 = null;
    L5:
        this(r7, r8, r9, r10);
    }

    public final String getSsid() {
        return this.ssid;
    }

    public final void setSsid(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.ssid = r2;
    }

    public final String getBssid() {
        return this.bssid;
    }

    public final void setBssid(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.bssid = r2;
    }

    public final ArrayList<String> getRisks() {
        return this.risks;
    }

    public final void setRisks(ArrayList<String> r1) {
        this.risks = r1;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final void setTimestamp(long r1) {
        this.timestamp = r1;
    }
}

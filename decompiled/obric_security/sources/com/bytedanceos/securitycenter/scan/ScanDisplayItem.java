package com.bytedanceos.securitycenter.scan;

import com.bytedanceos.securitycenter.appBgBatteryControl.AppBgBatteryControlDataHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ScanPlan.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/bytedanceos/securitycenter/scan/ScanDisplayItem;", "", "key", "", "displayName", AppBgBatteryControlDataHelper.ItemColumns.REASON, "Lcom/bytedanceos/securitycenter/scan/SkippedReason;", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedanceos/securitycenter/scan/SkippedReason;)V", "getDisplayName", "()Ljava/lang/String;", "getKey", "getReason", "()Lcom/bytedanceos/securitycenter/scan/SkippedReason;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class ScanDisplayItem {
    private final String displayName;
    private final String key;
    private final SkippedReason reason;

    public static /* synthetic */ ScanDisplayItem copy$default(ScanDisplayItem r0, String r1, String r2, SkippedReason r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.key;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.displayName;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.reason;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.key;
    }

    public final String component2() {
        return this.displayName;
    }

    public final SkippedReason component3() {
        return this.reason;
    }

    public final ScanDisplayItem copy(String r1, String r2, SkippedReason r3) {
        Intrinsics.checkNotNullParameter(r1, "key");
        Intrinsics.checkNotNullParameter(r2, "displayName");
        Intrinsics.checkNotNullParameter(r3, AppBgBatteryControlDataHelper.ItemColumns.REASON);
        return new ScanDisplayItem(r1, r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ScanDisplayItem) == false) goto L12;
        ScanDisplayItem r4 = (ScanDisplayItem) r3;
        if (Intrinsics.areEqual(this.key, r4.key) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.displayName, r4.displayName) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.reason, r4.reason) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r0 = this.key;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.displayName;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        SkippedReason r7 = this.reason;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "ScanDisplayItem(key=" + this.key + ", displayName=" + this.displayName + ", reason=" + this.reason + ")";
    }

    public ScanDisplayItem(String r2, String r3, SkippedReason r4) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "displayName");
        Intrinsics.checkNotNullParameter(r4, AppBgBatteryControlDataHelper.ItemColumns.REASON);
        this.key = r2;
        this.displayName = r3;
        this.reason = r4;
    }

    public final String getKey() {
        return this.key;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final SkippedReason getReason() {
        return this.reason;
    }
}

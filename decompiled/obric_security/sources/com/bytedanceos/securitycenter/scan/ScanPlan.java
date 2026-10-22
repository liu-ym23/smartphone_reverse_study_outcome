package com.bytedanceos.securitycenter.scan;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tmsdk.common.module.qscanner.QScanResultEntity;

/* JADX INFO: compiled from: ScanPlan.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003¢\u0006\u0002\u0010\nJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u0003HÆ\u0003JI\u0010\u0014\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/bytedanceos/securitycenter/scan/ScanPlan;", "", "installedPkgs", "", "", "skippedItems", "Lcom/bytedanceos/securitycenter/scan/ScanDisplayItem;", "preRiskItems", "preRiskResults", "Ltmsdk/common/module/qscanner/QScanResultEntity;", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getInstalledPkgs", "()Ljava/util/List;", "getPreRiskItems", "getPreRiskResults", "getSkippedItems", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class ScanPlan {
    private final List<String> installedPkgs;
    private final List<ScanDisplayItem> preRiskItems;
    private final List<QScanResultEntity> preRiskResults;
    private final List<ScanDisplayItem> skippedItems;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ScanPlan copy$default(ScanPlan r0, List r1, List r2, List r3, List r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.installedPkgs;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.skippedItems;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.preRiskItems;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.preRiskResults;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final List<String> component1() {
        return this.installedPkgs;
    }

    public final List<ScanDisplayItem> component2() {
        return this.skippedItems;
    }

    public final List<ScanDisplayItem> component3() {
        return this.preRiskItems;
    }

    public final List<QScanResultEntity> component4() {
        return this.preRiskResults;
    }

    public final ScanPlan copy(List<String> r1, List<ScanDisplayItem> r2, List<ScanDisplayItem> r3, List<? extends QScanResultEntity> r4) {
        Intrinsics.checkNotNullParameter(r1, "installedPkgs");
        Intrinsics.checkNotNullParameter(r2, "skippedItems");
        Intrinsics.checkNotNullParameter(r3, "preRiskItems");
        Intrinsics.checkNotNullParameter(r4, "preRiskResults");
        return new ScanPlan(r1, r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof ScanPlan) == false) goto L14;
        ScanPlan r4 = (ScanPlan) r3;
        if (Intrinsics.areEqual(this.installedPkgs, r4.installedPkgs) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.skippedItems, r4.skippedItems) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.preRiskItems, r4.preRiskItems) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.preRiskResults, r4.preRiskResults) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        List<String> r0 = this.installedPkgs;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<ScanDisplayItem> r4 = this.skippedItems;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        List<ScanDisplayItem> r7 = this.preRiskItems;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        List<QScanResultEntity> r10 = this.preRiskResults;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "ScanPlan(installedPkgs=" + this.installedPkgs + ", skippedItems=" + this.skippedItems + ", preRiskItems=" + this.preRiskItems + ", preRiskResults=" + this.preRiskResults + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ScanPlan(List<String> r2, List<ScanDisplayItem> r3, List<ScanDisplayItem> r4, List<? extends QScanResultEntity> r5) {
        Intrinsics.checkNotNullParameter(r2, "installedPkgs");
        Intrinsics.checkNotNullParameter(r3, "skippedItems");
        Intrinsics.checkNotNullParameter(r4, "preRiskItems");
        Intrinsics.checkNotNullParameter(r5, "preRiskResults");
        this.installedPkgs = r2;
        this.skippedItems = r3;
        this.preRiskItems = r4;
        this.preRiskResults = r5;
    }

    public final List<String> getInstalledPkgs() {
        return this.installedPkgs;
    }

    public final List<ScanDisplayItem> getSkippedItems() {
        return this.skippedItems;
    }

    public final List<ScanDisplayItem> getPreRiskItems() {
        return this.preRiskItems;
    }

    public final List<QScanResultEntity> getPreRiskResults() {
        return this.preRiskResults;
    }
}

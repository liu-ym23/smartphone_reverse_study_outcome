package com.obric.security.health.model;

import com.bytedanceos.securitycenter.appBgBatteryControl.AppBgBatteryControlDataHelper;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: HealthModels.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\bHÆ\u0003J?\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/obric/security/health/model/HealthCheckResult;", "", "itemId", "", "status", "Lcom/obric/security/health/model/HealthCheckStatus;", AppBgBatteryControlDataHelper.ItemColumns.REASON, "evidence", "", "(Ljava/lang/String;Lcom/obric/security/health/model/HealthCheckStatus;Ljava/lang/String;Ljava/util/Map;)V", "getEvidence", "()Ljava/util/Map;", "getItemId", "()Ljava/lang/String;", "getReason", "getStatus", "()Lcom/obric/security/health/model/HealthCheckStatus;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class HealthCheckResult {
    private final Map<String, String> evidence;
    private final String itemId;
    private final String reason;
    private final HealthCheckStatus status;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ HealthCheckResult copy$default(HealthCheckResult r0, String r1, HealthCheckStatus r2, String r3, Map r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.itemId;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.status;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.reason;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.evidence;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.itemId;
    }

    public final HealthCheckStatus component2() {
        return this.status;
    }

    public final String component3() {
        return this.reason;
    }

    public final Map<String, String> component4() {
        return this.evidence;
    }

    public final HealthCheckResult copy(String r1, HealthCheckStatus r2, String r3, Map<String, String> r4) {
        Intrinsics.checkNotNullParameter(r1, "itemId");
        Intrinsics.checkNotNullParameter(r2, "status");
        Intrinsics.checkNotNullParameter(r4, "evidence");
        return new HealthCheckResult(r1, r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof HealthCheckResult) == false) goto L14;
        HealthCheckResult r4 = (HealthCheckResult) r3;
        if (Intrinsics.areEqual(this.itemId, r4.itemId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.status, r4.status) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.reason, r4.reason) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.evidence, r4.evidence) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        String r0 = this.itemId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        HealthCheckStatus r4 = this.status;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.reason;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        Map<String, String> r10 = this.evidence;
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
        return "HealthCheckResult(itemId=" + this.itemId + ", status=" + this.status + ", reason=" + this.reason + ", evidence=" + this.evidence + ")";
    }

    public HealthCheckResult(String r2, HealthCheckStatus r3, String r4, Map<String, String> r5) {
        Intrinsics.checkNotNullParameter(r2, "itemId");
        Intrinsics.checkNotNullParameter(r3, "status");
        Intrinsics.checkNotNullParameter(r5, "evidence");
        this.itemId = r2;
        this.status = r3;
        this.reason = r4;
        this.evidence = r5;
    }

    public final String getItemId() {
        return this.itemId;
    }

    public final HealthCheckStatus getStatus() {
        return this.status;
    }

    public /* synthetic */ HealthCheckResult(String r1, HealthCheckStatus r2, String r3, Map r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = null;
        String r7 = (String) null;
    L6:
        if ((r5 & 8) == 0) goto L8;
        r4 = MapsKt.emptyMap();
    L8:
        this(r1, r2, r3, r4);
    }

    public final String getReason() {
        return this.reason;
    }

    public final Map<String, String> getEvidence() {
        return this.evidence;
    }
}

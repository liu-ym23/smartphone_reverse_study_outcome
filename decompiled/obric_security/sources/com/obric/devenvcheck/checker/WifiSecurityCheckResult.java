package com.obric.devenvcheck.checker;

import com.obric.securitycenter.api.WifiDetectResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WifiSecurityCheckResult.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\bHÆ\u0003J/\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/obric/devenvcheck/checker/WifiSecurityCheckResult;", "", "isSafe", "", "riskReasons", "", "", "raw", "Lcom/obric/securitycenter/api/WifiDetectResult;", "(ZLjava/util/List;Lcom/obric/securitycenter/api/WifiDetectResult;)V", "()Z", "getRaw", "()Lcom/obric/securitycenter/api/WifiDetectResult;", "getRiskReasons", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "devenvcheck_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class WifiSecurityCheckResult {
    private final boolean isSafe;
    private final WifiDetectResult raw;
    private final List<String> riskReasons;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WifiSecurityCheckResult copy$default(WifiSecurityCheckResult r0, boolean r1, List r2, WifiDetectResult r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.isSafe;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.riskReasons;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.raw;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final boolean component1() {
        return this.isSafe;
    }

    public final List<String> component2() {
        return this.riskReasons;
    }

    public final WifiDetectResult component3() {
        return this.raw;
    }

    public final WifiSecurityCheckResult copy(boolean r1, List<String> r2, WifiDetectResult r3) {
        Intrinsics.checkNotNullParameter(r2, "riskReasons");
        return new WifiSecurityCheckResult(r1, r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof WifiSecurityCheckResult) == false) goto L12;
        WifiSecurityCheckResult r4 = (WifiSecurityCheckResult) r3;
        if (this.isSafe == r4.isSafe) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.riskReasons, r4.riskReasons) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.raw, r4.raw) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean r0 = this.isSafe;
        ?? r1 = r0;
        if (r0 == false) goto L5;
        r1 = 1;
    L5:
        int r2 = r1 * 31;
        List<String> r3 = this.riskReasons;
        int r4 = 0;
        if (r3 == null) goto L8;
        int r5 = r3.hashCode();
    L9:
        int r6 = (r2 + r5) * 31;
        WifiDetectResult r7 = this.raw;
        if (r7 == null) goto L13;
        r4 = r7.hashCode();
    L13:
        return r6 + r4;
    L8:
        r5 = 0;
        goto L9
    }

    public String toString() {
        return "WifiSecurityCheckResult(isSafe=" + this.isSafe + ", riskReasons=" + this.riskReasons + ", raw=" + this.raw + ")";
    }

    public WifiSecurityCheckResult(boolean r2, List<String> r3, WifiDetectResult r4) {
        Intrinsics.checkNotNullParameter(r3, "riskReasons");
        this.isSafe = r2;
        this.riskReasons = r3;
        this.raw = r4;
    }

    public final boolean isSafe() {
        return this.isSafe;
    }

    public /* synthetic */ WifiSecurityCheckResult(boolean r1, List r2, WifiDetectResult r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = CollectionsKt.emptyList();
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = null;
        WifiDetectResult r6 = (WifiDetectResult) null;
    L8:
        this(r1, r2, r3);
    }

    public final List<String> getRiskReasons() {
        return this.riskReasons;
    }

    public final WifiDetectResult getRaw() {
        return this.raw;
    }
}

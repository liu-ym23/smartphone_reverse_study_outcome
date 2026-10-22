package com.obric.securitycenter.api;

import com.obric.matrix.platform.sdk.ones.account.AccountConst;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: UrlCheckResult.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/obric/securitycenter/api/VirusDbCheckResult;", "", "success", "", "hasUpdate", AccountConst.KEY_ERROR_CODE, "", "(ZZI)V", "getErrorCode", "()I", "getHasUpdate", "()Z", "getSuccess", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class VirusDbCheckResult {
    private final int errorCode;
    private final boolean hasUpdate;
    private final boolean success;

    public static /* synthetic */ VirusDbCheckResult copy$default(VirusDbCheckResult r0, boolean r1, boolean r2, int r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.success;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.hasUpdate;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.errorCode;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final boolean component1() {
        return this.success;
    }

    public final boolean component2() {
        return this.hasUpdate;
    }

    public final int component3() {
        return this.errorCode;
    }

    public final VirusDbCheckResult copy(boolean r1, boolean r2, int r3) {
        return new VirusDbCheckResult(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof VirusDbCheckResult) == true) goto L8;
        return false;
    L8:
        VirusDbCheckResult r6 = (VirusDbCheckResult) r5;
        if (this.success == r6.success) goto L12;
        return false;
    L12:
        if (this.hasUpdate == r6.hasUpdate) goto L15;
        return false;
    L15:
        if (this.errorCode == r6.errorCode) goto L17;
        return false;
    L17:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    public int hashCode() {
        boolean r0 = this.success;
        ?? r1 = 1;
        ?? r2 = r0;
        if (r0 == false) goto L5;
        r2 = 1;
    L5:
        int r3 = r2 * 31;
        boolean r4 = this.hasUpdate;
        if (r4 == true) goto L10;
        r1 = r4;
    L10:
        return ((r3 + r1) * 31) + Integer.hashCode(this.errorCode);
    }

    public String toString() {
        return "VirusDbCheckResult(success=" + this.success + ", hasUpdate=" + this.hasUpdate + ", errorCode=" + this.errorCode + ")";
    }

    public VirusDbCheckResult(boolean r1, boolean r2, int r3) {
        this.success = r1;
        this.hasUpdate = r2;
        this.errorCode = r3;
    }

    public /* synthetic */ VirusDbCheckResult(boolean r2, boolean r3, int r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 2) == 0) goto L6;
        r3 = false;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r2, r3, r4);
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final boolean getHasUpdate() {
        return this.hasUpdate;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }
}

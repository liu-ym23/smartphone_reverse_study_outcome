package com.obric.securitycenter.api;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UrlCheckResult.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/obric/securitycenter/api/UrlCheckResult;", "", "isHarm", "", "message", "", "url", "(ZLjava/lang/String;Ljava/lang/String;)V", "()Z", "setHarm", "(Z)V", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "getUrl", "setUrl", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class UrlCheckResult {
    private boolean isHarm;
    private String message;
    private String url;

    public UrlCheckResult() {
        this(false, null, null, 7, null);
    }

    public static /* synthetic */ UrlCheckResult copy$default(UrlCheckResult r0, boolean r1, String r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.isHarm;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.message;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.url;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final boolean component1() {
        return this.isHarm;
    }

    public final String component2() {
        return this.message;
    }

    public final String component3() {
        return this.url;
    }

    public final UrlCheckResult copy(boolean r1, String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "message");
        Intrinsics.checkNotNullParameter(r3, "url");
        return new UrlCheckResult(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof UrlCheckResult) == true) goto L8;
        return false;
    L8:
        UrlCheckResult r6 = (UrlCheckResult) r5;
        if (this.isHarm == r6.isHarm) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.message, r6.message) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.url, r6.url) == true) goto L17;
        return false;
    L17:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean r0 = this.isHarm;
        ?? r1 = r0;
        if (r0 == false) goto L6;
        r1 = 1;
    L6:
        return (((r1 * 31) + this.message.hashCode()) * 31) + this.url.hashCode();
    }

    public String toString() {
        return "UrlCheckResult(isHarm=" + this.isHarm + ", message=" + this.message + ", url=" + this.url + ")";
    }

    public UrlCheckResult(boolean r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "message");
        Intrinsics.checkNotNullParameter(r4, "url");
        this.isHarm = r2;
        this.message = r3;
        this.url = r4;
    }

    public /* synthetic */ UrlCheckResult(boolean r2, String r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = "";
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = "";
    L11:
        this(r2, r3, r4);
    }

    public final boolean isHarm() {
        return this.isHarm;
    }

    public final void setHarm(boolean r1) {
        this.isHarm = r1;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.message = r2;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.url = r2;
    }
}

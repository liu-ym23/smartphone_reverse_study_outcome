package com.obric.securitycenter.api;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WifiDetect.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/obric/securitycenter/api/WifiDetectResult;", "", "dnsAndPhishingResult", "", "arpResult", "sslStripResult", "message", "", "(IIILjava/lang/String;)V", "getArpResult", "()I", "setArpResult", "(I)V", "getDnsAndPhishingResult", "setDnsAndPhishingResult", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "getSslStripResult", "setSslStripResult", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class WifiDetectResult {
    private int arpResult;
    private int dnsAndPhishingResult;
    private String message;
    private int sslStripResult;

    public WifiDetectResult() {
        this(0, 0, 0, null, 15, null);
    }

    public static /* synthetic */ WifiDetectResult copy$default(WifiDetectResult r0, int r1, int r2, int r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.dnsAndPhishingResult;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.arpResult;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.sslStripResult;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.message;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final int component1() {
        return this.dnsAndPhishingResult;
    }

    public final int component2() {
        return this.arpResult;
    }

    public final int component3() {
        return this.sslStripResult;
    }

    public final String component4() {
        return this.message;
    }

    public final WifiDetectResult copy(int r1, int r2, int r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, "message");
        return new WifiDetectResult(r1, r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof WifiDetectResult) == true) goto L8;
        return false;
    L8:
        WifiDetectResult r6 = (WifiDetectResult) r5;
        if (this.dnsAndPhishingResult == r6.dnsAndPhishingResult) goto L12;
        return false;
    L12:
        if (this.arpResult == r6.arpResult) goto L15;
        return false;
    L15:
        if (this.sslStripResult == r6.sslStripResult) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.message, r6.message) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.dnsAndPhishingResult) * 31) + Integer.hashCode(this.arpResult)) * 31) + Integer.hashCode(this.sslStripResult)) * 31) + this.message.hashCode();
    }

    public String toString() {
        return "WifiDetectResult(dnsAndPhishingResult=" + this.dnsAndPhishingResult + ", arpResult=" + this.arpResult + ", sslStripResult=" + this.sslStripResult + ", message=" + this.message + ")";
    }

    public WifiDetectResult(int r2, int r3, int r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "message");
        this.dnsAndPhishingResult = r2;
        this.arpResult = r3;
        this.sslStripResult = r4;
        this.message = r5;
    }

    public /* synthetic */ WifiDetectResult(int r2, int r3, int r4, String r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = -1;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = -1;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = -1;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = "";
    L14:
        this(r2, r3, r4, r5);
    }

    public final int getDnsAndPhishingResult() {
        return this.dnsAndPhishingResult;
    }

    public final void setDnsAndPhishingResult(int r1) {
        this.dnsAndPhishingResult = r1;
    }

    public final int getArpResult() {
        return this.arpResult;
    }

    public final void setArpResult(int r1) {
        this.arpResult = r1;
    }

    public final int getSslStripResult() {
        return this.sslStripResult;
    }

    public final void setSslStripResult(int r1) {
        this.sslStripResult = r1;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.message = r2;
    }
}

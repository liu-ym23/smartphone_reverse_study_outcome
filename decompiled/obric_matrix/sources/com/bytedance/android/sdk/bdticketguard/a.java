package com.bytedance.android.sdk.bdticketguard;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\u000f\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\u001c\u0010\u0012\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u0004R\u001c\u0010\u0015\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u0004R\u001c\u0010\u0018\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\r\u001a\u0004\b\u0017\u0010\u0004R\u001c\u0010\u001b\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\r\u001a\u0004\b\u001a\u0010\u0004¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/a;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "getAttestKey", "attestKey", "e", "getSecTs", "secTs", "c", "getRequestContent", "requestContent", "b", "getAttestTsSign", "attestTsSign", "d", "getRequestSign", "requestSign", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 1, 15})
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.google.gson.y.c("attestkey")
    private final String f636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @com.google.gson.y.c("attestkey_ts_sign")
    private final String f637b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @com.google.gson.y.c("req_content")
    private final String f638c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @com.google.gson.y.c("req_sign")
    private final String f639d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @com.google.gson.y.c("sec_ts")
    private final String f640e;

    public a() {
        this(null, null, null, null, null, 31, null);
    }

    public a(String r2, String r3, String r4, String r5, String r6) {
        kotlin.n0.d.o.g(r2, "attestKey");
        kotlin.n0.d.o.g(r3, "attestTsSign");
        kotlin.n0.d.o.g(r4, "requestContent");
        kotlin.n0.d.o.g(r5, "requestSign");
        kotlin.n0.d.o.g(r6, "secTs");
        this.f636a = r2;
        this.f637b = r3;
        this.f638c = r4;
        this.f639d = r5;
        this.f640e = r6;
    }

    public /* synthetic */ a(String r2, String r3, String r4, String r5, String r6, int r7, kotlin.n0.d.g r8) {
        if ((r7 & 1) == 0) goto L6;
        r2 = "";
    L6:
        if ((r7 & 2) == 0) goto L9;
        r3 = "";
    L9:
        if ((r7 & 4) == 0) goto L12;
        r4 = "";
    L12:
        if ((r7 & 8) == 0) goto L15;
        r5 = "";
    L15:
        if ((r7 & 16) == 0) goto L17;
        r6 = "";
    L17:
        this(r2, r3, r4, r5, r6);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L16;
        a r4 = (a) r3;
        if (kotlin.n0.d.o.a(this.f636a, r4.f636a) == true) goto L8;
        return false;
    L8:
        if (kotlin.n0.d.o.a(this.f637b, r4.f637b) == true) goto L10;
        return false;
    L10:
        if (kotlin.n0.d.o.a(this.f638c, r4.f638c) == true) goto L12;
        return false;
    L12:
        if (kotlin.n0.d.o.a(this.f639d, r4.f639d) == true) goto L14;
        return false;
    L14:
        if (kotlin.n0.d.o.a(this.f640e, r4.f640e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        String r0 = this.f636a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.f637b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.f638c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.f639d;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.f640e;
        if (r13 == null) goto L22;
        r1 = r13.hashCode();
    L22:
        return r12 + r1;
    L17:
        r11 = 0;
        goto L18
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
        return "AttestClientData(attestKey=" + this.f636a + ", attestTsSign=" + this.f637b + ", requestContent=" + this.f638c + ", requestSign=" + this.f639d + ", secTs=" + this.f640e + ")";
    }
}

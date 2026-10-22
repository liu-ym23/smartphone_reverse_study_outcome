package com.bytedance.android.sdk.bdticketguard;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u0004\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u0004\"\u0004\b\u0013\u0010\u000fR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0011\u0010\u0004\"\u0004\b\u0015\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/l0;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "setCertString", "(Ljava/lang/String;)V", "certString", "b", "c", "setSerialNumber", "serialNumber", "setPublicKey", "publicKey", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 1, 15})
public final class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.google.gson.y.c("cert_string")
    private String f840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @com.google.gson.y.c("serial_number")
    private String f841b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @com.google.gson.y.c("public_key")
    private String f842c;

    public l0(String r2, String r3, String r4) {
        kotlin.n0.d.o.g(r2, "certString");
        kotlin.n0.d.o.g(r3, "serialNumber");
        kotlin.n0.d.o.g(r4, "publicKey");
        this.f840a = r2;
        this.f841b = r3;
        this.f842c = r4;
    }

    public final String a() {
        return this.f840a;
    }

    public final String b() {
        return this.f842c;
    }

    public final String c() {
        return this.f841b;
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof l0) == false) goto L12;
        l0 r4 = (l0) r3;
        if (kotlin.n0.d.o.a(this.f840a, r4.f840a) == true) goto L8;
        return false;
    L8:
        if (kotlin.n0.d.o.a(this.f841b, r4.f841b) == true) goto L10;
        return false;
    L10:
        if (kotlin.n0.d.o.a(this.f842c, r4.f842c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r0 = this.f840a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.f841b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.f842c;
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
        return "ServerCert(certString=" + this.f840a + ", serialNumber=" + this.f841b + ", publicKey=" + this.f842c + ")";
    }
}

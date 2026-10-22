package com.bytedance.android.sdk.bdticketguard;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0010\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0004R\u001c\u0010\u0012\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\r\u0010\u0004R\u001c\u0010\u0013\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u000e\u001a\u0004\b\u0011\u0010\u0004¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/n0;", "Lcom/bytedance/android/sdk/bdticketguard/m0;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "b", "Ljava/lang/String;", "c", "tsSign", "a", "ticket", "clientCert", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 1, 15})
public final class n0 implements m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.google.gson.y.c("ticket")
    private final String f865a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @com.google.gson.y.c("ts_sign")
    private final String f866b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @com.google.gson.y.c("client_cert")
    private final String f867c;

    public final String a() {
        return this.f867c;
    }

    public final String b() {
        return this.f865a;
    }

    public final String c() {
        return this.f866b;
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof n0) == false) goto L12;
        n0 r4 = (n0) r3;
        if (kotlin.n0.d.o.a(this.f865a, r4.f865a) == true) goto L8;
        return false;
    L8:
        if (kotlin.n0.d.o.a(this.f866b, r4.f866b) == true) goto L10;
        return false;
    L10:
        if (kotlin.n0.d.o.a(this.f867c, r4.f867c) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r0 = this.f865a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.f866b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.f867c;
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
        return "ServerDataV1(ticket=" + this.f865a + ", tsSign=" + this.f866b + ", clientCert=" + this.f867c + ")";
    }
}

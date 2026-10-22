package com.bytedance.android.sdk.bdticketguard;

import com.bytedance.common.wschannel.WsConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\u000f\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0004R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u0004R\u001c\u0010\u0014\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\r\u001a\u0004\b\f\u0010\u0004R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/v0;", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "getType", WsConstants.KEY_CONNECTION_TYPE, "d", "getCert", "cert", "b", "ticket", "c", "ts_sign", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 1, 15})
public final class v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.google.gson.y.c(WsConstants.KEY_CONNECTION_TYPE)
    private final String f1075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @com.google.gson.y.c("ticket")
    private final String f1076b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @com.google.gson.y.c("ts_sign")
    private final String f1077c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @com.google.gson.y.c("cert")
    private final String f1078d;

    public v0(String r2, String r3, String r4, String r5) {
        kotlin.n0.d.o.g(r2, WsConstants.KEY_CONNECTION_TYPE);
        kotlin.n0.d.o.g(r3, "ticket");
        this.f1075a = r2;
        this.f1076b = r3;
        this.f1077c = r4;
        this.f1078d = r5;
    }

    public final String a() {
        return this.f1076b;
    }

    public final String b() {
        return this.f1077c;
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof v0) == false) goto L14;
        v0 r4 = (v0) r3;
        if (kotlin.n0.d.o.a(this.f1075a, r4.f1075a) == true) goto L8;
        return false;
    L8:
        if (kotlin.n0.d.o.a(this.f1076b, r4.f1076b) == true) goto L10;
        return false;
    L10:
        if (kotlin.n0.d.o.a(this.f1077c, r4.f1077c) == true) goto L12;
        return false;
    L12:
        if (kotlin.n0.d.o.a(this.f1078d, r4.f1078d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        String r0 = this.f1075a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.f1076b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.f1077c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.f1078d;
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
        return "TicketData(type=" + this.f1075a + ", ticket=" + this.f1076b + ", ts_sign=" + this.f1077c + ", cert=" + this.f1078d + ")";
    }
}

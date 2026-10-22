package com.bytedance.android.sdk.bdticketguard;

import com.bytedance.common.wschannel.WsConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0014B5\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u0011\u001a\u00020\u00058\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0007R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0010\u001a\u0004\b\u0012\u0010\u0007R\u001c\u0010\u0016\u001a\u00020\u00058\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0007R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0014\u0010\u0007R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0018\u0010\u0007¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/w0;", "", "Lcom/bytedance/android/sdk/bdticketguard/v0;", "f", "()Lcom/bytedance/android/sdk/bdticketguard/v0;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "b", "Ljava/lang/String;", "ticket", "c", "ts_sign", "a", "e", WsConstants.KEY_CONNECTION_TYPE, "cert", "d", "ts_sign_ree", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 1, 15})
public final class w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @com.google.gson.y.c(WsConstants.KEY_CONNECTION_TYPE)
    private final String f1079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @com.google.gson.y.c("ticket")
    private final String f1080b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @com.google.gson.y.c("ts_sign")
    private final String f1081c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @com.google.gson.y.c("ts_sign_ree")
    private final String f1082d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @com.google.gson.y.c("cert")
    private final String f1083e;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u0004R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\r\u001a\u0004\b\u000f\u0010\u0004¨\u0006\u0013"}, d2 = {"com/bytedance/android/sdk/bdticketguard/w0$a", "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "a", "Ljava/lang/String;", "ts_sign", "b", "ts_sign_ree", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 1, 15})
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @com.google.gson.y.c("ts_sign")
        private final String f1084a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @com.google.gson.y.c("ts_sign_ree")
        private final String f1085b;

        public a(String r1, String r2) {
            this.f1084a = r1;
            this.f1085b = r2;
        }

        public final String a() {
            return this.f1084a;
        }

        public final String b() {
            return this.f1085b;
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L10;
            a r4 = (a) r3;
            if (kotlin.n0.d.o.a(this.f1084a, r4.f1084a) == true) goto L8;
            return false;
        L8:
            if (kotlin.n0.d.o.a(this.f1085b, r4.f1085b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public int hashCode() {
            String r0 = this.f1084a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.f1085b;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return "CombineTsSign(ts_sign=" + this.f1084a + ", ts_sign_ree=" + this.f1085b + ")";
        }
    }

    public w0(String r2, String r3, String r4, String r5, String r6) {
        kotlin.n0.d.o.g(r2, WsConstants.KEY_CONNECTION_TYPE);
        kotlin.n0.d.o.g(r3, "ticket");
        this.f1079a = r2;
        this.f1080b = r3;
        this.f1081c = r4;
        this.f1082d = r5;
        this.f1083e = r6;
    }

    public final String a() {
        return this.f1083e;
    }

    public final String b() {
        return this.f1080b;
    }

    public final String c() {
        return this.f1081c;
    }

    public final String d() {
        return this.f1082d;
    }

    public final String e() {
        return this.f1079a;
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof w0) == false) goto L16;
        w0 r4 = (w0) r3;
        if (kotlin.n0.d.o.a(this.f1079a, r4.f1079a) == true) goto L8;
        return false;
    L8:
        if (kotlin.n0.d.o.a(this.f1080b, r4.f1080b) == true) goto L10;
        return false;
    L10:
        if (kotlin.n0.d.o.a(this.f1081c, r4.f1081c) == true) goto L12;
        return false;
    L12:
        if (kotlin.n0.d.o.a(this.f1082d, r4.f1082d) == true) goto L14;
        return false;
    L14:
        if (kotlin.n0.d.o.a(this.f1083e, r4.f1083e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final v0 f() {
        return new v0(this.f1079a, this.f1080b, y0.a().v(new a(this.f1081c, this.f1082d)), this.f1083e);
    }

    public int hashCode() {
        String r0 = this.f1079a;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.f1080b;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.f1081c;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.f1082d;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.f1083e;
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
        return "TicketDataBean(type=" + this.f1079a + ", ticket=" + this.f1080b + ", ts_sign=" + this.f1081c + ", ts_sign_ree=" + this.f1082d + ", cert=" + this.f1083e + ")";
    }
}

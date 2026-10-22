package com.obric.matrix.opush.d.g;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001Bg\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b¢\u0006\u0002\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\bHÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0005HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0005HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003Jm\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\bHÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020\u0003HÖ\u0001J\t\u0010,\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\u000e\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011¨\u0006-"}, d2 = {"Lcom/obric/matrix/opush/base/message/ReceiptContext;", "", "version", "", "env", "", "did", "sessionId", "", "appId", "msgId", "reqId", "pushToken", LocationMonitorConst.TAG, "reqTs", "(ILjava/lang/String;Ljava/lang/String;JILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V", "getAppId", "()I", "getDid", "()Ljava/lang/String;", "getEnv", "getMsgId", "getPushToken", "getReqId", "getReqTs", "()J", "getSessionId", "getTag", "getVersion", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "o_push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f9349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9350b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f9351c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f9352d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f9353e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f9354f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f9355g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f9356h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f9357i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final long f9358j;

    public f(int r2, String r3, String r4, long r5, int r7, String r8, String r9, String r10, String r11, long r12) {
        o.f(r3, "env");
        o.f(r4, "did");
        o.f(r8, "msgId");
        o.f(r9, "reqId");
        o.f(r10, "pushToken");
        o.f(r11, LocationMonitorConst.TAG);
        this.f9349a = r2;
        this.f9350b = r3;
        this.f9351c = r4;
        this.f9352d = r5;
        this.f9353e = r7;
        this.f9354f = r8;
        this.f9355g = r9;
        this.f9356h = r10;
        this.f9357i = r11;
        this.f9358j = r12;
    }

    public /* synthetic */ f(int r16, String r17, String r18, long r19, int r21, String r22, String r23, String r24, String r25, long r26, int r28, kotlin.n0.d.g r29) {
        if ((r28 & 1) == 0) goto L5;
        int r3 = 1;
    L7:
        if ((r28 & 2) == 0) goto L9;
        String r4 = "";
    L11:
        if ((r28 & 4) == 0) goto L13;
        String r5 = "";
    L15:
        if ((r28 & 8) == 0) goto L17;
        long r8 = 0;
    L19:
        if ((r28 & 16) == 0) goto L21;
        int r1 = 0;
    L23:
        if ((r28 & 64) == 0) goto L25;
        String r10 = "";
    L27:
        if ((r28 & 128) == 0) goto L29;
        String r11 = "";
    L31:
        if ((r28 & 256) == 0) goto L33;
        String r12 = "";
    L35:
        if ((r28 & 512) == 0) goto L37;
        long r13 = 0;
    L38:
        this(r3, r4, r5, r8, r1, r22, r10, r11, r12, r13);
        return;
    L37:
        r13 = r26;
        goto L38
    L33:
        r12 = r25;
        goto L35
    L29:
        r11 = r24;
        goto L31
    L25:
        r10 = r23;
        goto L27
    L21:
        r1 = r21;
        goto L23
    L17:
        r8 = r19;
        goto L19
    L13:
        r5 = r18;
        goto L15
    L9:
        r4 = r17;
        goto L11
    L5:
        r3 = r16;
        goto L7
    }

    public final int a() {
        return this.f9353e;
    }

    public final String b() {
        return this.f9351c;
    }

    public final String c() {
        return this.f9350b;
    }

    public final String d() {
        return this.f9354f;
    }

    public final String e() {
        return this.f9356h;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof f) == true) goto L8;
        return false;
    L8:
        f r9 = (f) r8;
        if (this.f9349a == r9.f9349a) goto L12;
        return false;
    L12:
        if (o.a(this.f9350b, r9.f9350b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f9351c, r9.f9351c) == true) goto L18;
        return false;
    L18:
        if (this.f9352d == r9.f9352d) goto L21;
        return false;
    L21:
        if (this.f9353e == r9.f9353e) goto L24;
        return false;
    L24:
        if (o.a(this.f9354f, r9.f9354f) == true) goto L27;
        return false;
    L27:
        if (o.a(this.f9355g, r9.f9355g) == true) goto L30;
        return false;
    L30:
        if (o.a(this.f9356h, r9.f9356h) == true) goto L33;
        return false;
    L33:
        if (o.a(this.f9357i, r9.f9357i) == true) goto L36;
        return false;
    L36:
        if (this.f9358j == r9.f9358j) goto L38;
        return false;
    L38:
        return true;
    }

    public final String f() {
        return this.f9355g;
    }

    public final long g() {
        return this.f9358j;
    }

    public final long h() {
        return this.f9352d;
    }

    public int hashCode() {
        return (((((((((((((((((Integer.hashCode(this.f9349a) * 31) + this.f9350b.hashCode()) * 31) + this.f9351c.hashCode()) * 31) + Long.hashCode(this.f9352d)) * 31) + Integer.hashCode(this.f9353e)) * 31) + this.f9354f.hashCode()) * 31) + this.f9355g.hashCode()) * 31) + this.f9356h.hashCode()) * 31) + this.f9357i.hashCode()) * 31) + Long.hashCode(this.f9358j);
    }

    public final String i() {
        return this.f9357i;
    }

    public final int j() {
        return this.f9349a;
    }

    public String toString() {
        return "ReceiptContext(version=" + this.f9349a + ", env=" + this.f9350b + ", did=" + this.f9351c + ", sessionId=" + this.f9352d + ", appId=" + this.f9353e + ", msgId=" + this.f9354f + ", reqId=" + this.f9355g + ", pushToken=" + this.f9356h + ", tag=" + this.f9357i + ", reqTs=" + this.f9358j + ')';
    }
}

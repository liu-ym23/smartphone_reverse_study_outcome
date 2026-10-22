package com.obric.matrix.opush.d.g;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b5\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001B¡\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0005¢\u0006\u0002\u0010\u0016J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0005HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\t\u00104\u001a\u00020\u0005HÆ\u0003J\t\u00105\u001a\u00020\u0005HÆ\u0003J\t\u00106\u001a\u00020\bHÆ\u0003J\t\u00107\u001a\u00020\bHÆ\u0003J\t\u00108\u001a\u00020\u0005HÆ\u0003J\t\u00109\u001a\u00020\u0005HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\bHÆ\u0003J³\u0001\u0010<\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u0005HÆ\u0001J\u0013\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010@\u001a\u00020\bH\u0016J\t\u0010A\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0014\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0015\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0011\u0010\r\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001aR\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001aR\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001fR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001fR\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001aR\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001fR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0018¨\u0006B"}, d2 = {"Lcom/obric/matrix/opush/base/message/ReceiptInfo;", "", "id", "", "receiptId", "", "msgId", "appId", "", "version", "env", "did", "sessionId", "receiptCode", "receiptStatus", "reqId", "pushToken", LocationMonitorConst.TAG, "timestamp", "reqTs", "clientVer", "deviceModel", "(JLjava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;JILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;)V", "getAppId", "()I", "getClientVer", "()Ljava/lang/String;", "getDeviceModel", "getDid", "getEnv", "getId", "()J", "getMsgId", "getPushToken", "getReceiptCode", "getReceiptId", "getReceiptStatus", "getReqId", "getReqTs", "getSessionId", "getTag", "getTimestamp", "getVersion", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "o_push_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f9363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f9365c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f9366d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f9367e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f9368f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f9369g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long f9370h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f9371i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f9372j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f9373k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final String f9374l;
    private final String m;
    private final long n;
    private final long o;
    private final String p;
    private final String q;

    public i(long r14, String r16, String r17, int r18, int r19, String r20, String r21, long r22, int r24, String r25, String r26, String r27, String r28, long r29, long r31, String r33, String r34) {
        o.f(r16, "receiptId");
        o.f(r17, "msgId");
        o.f(r20, "env");
        o.f(r21, "did");
        o.f(r25, "receiptStatus");
        o.f(r26, "reqId");
        o.f(r27, "pushToken");
        o.f(r28, LocationMonitorConst.TAG);
        o.f(r33, "clientVer");
        o.f(r34, "deviceModel");
        this.f9363a = r14;
        this.f9364b = r16;
        this.f9365c = r17;
        this.f9366d = r18;
        this.f9367e = r19;
        this.f9368f = r20;
        this.f9369g = r21;
        this.f9370h = r22;
        this.f9371i = r24;
        this.f9372j = r25;
        this.f9373k = r26;
        this.f9374l = r27;
        this.m = r28;
        this.n = r29;
        this.o = r31;
        this.p = r33;
        this.q = r34;
    }

    public /* synthetic */ i(long r27, String r29, String r30, int r31, int r32, String r33, String r34, long r35, int r37, String r38, String r39, String r40, String r41, long r42, long r44, String r46, String r47, int r48, kotlin.n0.d.g r49) {
        if ((r48 & 1) == 0) goto L5;
        long r5 = 0;
    L7:
        if ((r48 & 256) == 0) goto L9;
        int r15 = 1;
    L11:
        if ((r48 & 512) == 0) goto L13;
        String r16 = "";
    L15:
        if ((r48 & 1024) == 0) goto L17;
        String r17 = "";
    L19:
        if ((r48 & 2048) == 0) goto L21;
        String r18 = "";
    L23:
        if ((r48 & 4096) == 0) goto L25;
        String r19 = "";
    L27:
        if ((r48 & 8192) == 0) goto L29;
        long r20 = 0;
    L31:
        if ((r48 & 16384) == 0) goto L33;
        long r22 = 0;
    L35:
        if ((32768 & r48) == 0) goto L37;
        String r24 = "";
    L39:
        if ((r48 & 65536) == 0) goto L41;
        String r25 = "";
    L42:
        this(r5, r29, r30, r31, r32, r33, r34, r35, r15, r16, r17, r18, r19, r20, r22, r24, r25);
        return;
    L41:
        r25 = r47;
        goto L42
    L37:
        r24 = r46;
        goto L39
    L33:
        r22 = r44;
        goto L35
    L29:
        r20 = r42;
        goto L31
    L25:
        r19 = r41;
        goto L27
    L21:
        r18 = r40;
        goto L23
    L17:
        r17 = r39;
        goto L19
    L13:
        r16 = r38;
        goto L15
    L9:
        r15 = r37;
        goto L11
    L5:
        r5 = r27;
        goto L7
    }

    public final int a() {
        return this.f9366d;
    }

    public final String b() {
        return this.p;
    }

    public final String c() {
        return this.q;
    }

    public final String d() {
        return this.f9369g;
    }

    public final String e() {
        return this.f9368f;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if (r8 == null) goto L8;
        Class<?> r2 = r8.getClass();
    L10:
        if (o.a(i.class, r2) == true) goto L12;
        return false;
    L12:
        Objects.requireNonNull(r8, "null cannot be cast to non-null type com.obric.matrix.opush.base.message.ReceiptInfo");
        i r9 = (i) r8;
        if (this.f9363a == r9.f9363a) goto L16;
        return false;
    L16:
        if (o.a(this.f9364b, r9.f9364b) == true) goto L18;
        return false;
    L18:
        return true;
    L8:
        r2 = null;
        goto L10
    }

    public final String f() {
        return this.f9365c;
    }

    public final String g() {
        return this.f9374l;
    }

    public final int h() {
        return this.f9371i;
    }

    public int hashCode() {
        return (Long.hashCode(this.f9363a) * 31) + this.f9364b.hashCode();
    }

    public final String i() {
        return this.f9364b;
    }

    public final String j() {
        return this.f9372j;
    }

    public final String k() {
        return this.f9373k;
    }

    public final long l() {
        return this.o;
    }

    public final long m() {
        return this.f9370h;
    }

    public final String n() {
        return this.m;
    }

    public final long o() {
        return this.n;
    }

    public final int p() {
        return this.f9367e;
    }

    public String toString() {
        return "ReceiptInfo(id=" + this.f9363a + ", receiptId=" + this.f9364b + ", msgId=" + this.f9365c + ", appId=" + this.f9366d + ", version=" + this.f9367e + ", env=" + this.f9368f + ", did=" + this.f9369g + ", sessionId=" + this.f9370h + ", receiptCode=" + this.f9371i + ", receiptStatus=" + this.f9372j + ", reqId=" + this.f9373k + ", pushToken=" + this.f9374l + ", tag=" + this.m + ", timestamp=" + this.n + ", reqTs=" + this.o + ", clientVer=" + this.p + ", deviceModel=" + this.q + ')';
    }
}

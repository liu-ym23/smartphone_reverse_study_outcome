package com.loc;

import com.ttnet.org.chromium.net.NetError;

/* JADX INFO: loaded from: classes2.dex */
public final class i3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f7373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f7374b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f7375c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f7376d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f7377e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f7378f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public short f7379g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f7380h;

    public i3(boolean r3) {
        this.f7375c = NetError.ERR_SSL_VERSION_OR_CIPHER_MISMATCH;
        this.f7378f = 0;
        this.f7380h = r3;
    }

    public static long a(String r15) {
        if (r15 != null) goto L5;
    L35:
        return 0;
    L5:
        if (r15.length() == 0) goto L35;
        int r2 = 0;
        int r3 = r15.length() - 1;
        long r4 = 0;
    L8:
        if (r3 < 0) goto L32;
        long r6 = r15.charAt(r3);
        if (r6 >= 48) goto L12;
    L15:
        long r8 = 97;
        if (r6 >= 97) goto L18;
    L20:
        r8 = 65;
        if (r6 < 65) goto L26;
        if (r6 > 70) goto L26;
    L19:
        long r7 = (r6 - r8) + 10;
    L14:
        r4 = r4 + (r7 << r2);
        r2 = r2 + 4;
    L30:
        r3 = r3 - 1;
    L26:
        if (r6 == 58) goto L30;
        if (r6 == 124) goto L30;
        return 0;
    L18:
        if (r6 > 102) goto L20;
    L12:
        if (r6 > 57) goto L15;
        r7 = r6 - 48;
        goto L14
    L32:
        if (r2 == 48) goto L34;
        return 0;
    L34:
        return r4;
    }

    public static String c(long r2) {
        if (r2 >= 0) goto L5;
        return null;
    L5:
        if (r2 <= 281474976710655L) goto L8;
        return null;
    L8:
        return q3.a(q3.b(r2), ":");
    }

    private i3 d() {
        boolean r1 = this.f7380h;
        i3 r0 = new i3(r1);
        r0.f7373a = this.f7373a;
        r0.f7374b = this.f7374b;
        r0.f7375c = this.f7375c;
        r0.f7376d = this.f7376d;
        r0.f7377e = this.f7377e;
        r0.f7378f = this.f7378f;
        r0.f7379g = this.f7379g;
        r0.f7380h = r1;
        return r0;
    }

    public final String b() {
        return this.f7380h + "#" + this.f7373a;
    }

    public final /* synthetic */ Object clone() {
        return d();
    }

    public final String toString() {
        return "AmapWifi{mac=" + this.f7373a + ", ssid='" + this.f7374b + "', rssi=" + this.f7375c + ", frequency=" + this.f7376d + ", timestamp=" + this.f7377e + ", lastUpdateUtcMills=" + this.f7378f + ", freshness=" + this.f7379g + ", connected=" + this.f7380h + '}';
    }
}

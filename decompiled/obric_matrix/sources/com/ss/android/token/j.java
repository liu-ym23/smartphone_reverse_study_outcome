package com.ss.android.token;

import android.content.Context;
import android.os.SystemClock;
import kotlin.a0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f12217f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f12219b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f12220c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f12221d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f12222e;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.n0.d.g r1) {
            this();
        }

        public final j a(String r11) {
            kotlin.n0.d.o.g(r11, "json");
            JSONObject r10 = new JSONObject(r11);     // Catch: Exception -> L6
            String r1 = r10.optString("secTime", "");
            kotlin.n0.d.o.b(r1, "jsonObject.optString(\"secTime\", \"\")");
            return new j(r1, r10.optLong("serverTime", 0), r10.optLong("systemTime", 0), r10.optLong("elapsedRealTimeMs", 0), r10.optInt("rebootTimes", 0));
        L6:
            return null;
        }
    }

    static {
        f12217f = new a(null);
    }

    public j(String r2, long r3, long r5, long r7, int r9) {
        kotlin.n0.d.o.g(r2, "secTime");
        this.f12218a = r2;
        this.f12219b = r3;
        this.f12220c = r5;
        this.f12221d = r7;
        this.f12222e = r9;
    }

    public final long a() {
        return this.f12221d;
    }

    public final String b() {
        return this.f12218a;
    }

    public final long c() {
        return this.f12219b;
    }

    public final long d() {
        return this.f12220c;
    }

    public final boolean e(Context r10, long r11) {
        kotlin.n0.d.o.g(r10, "context");
        long r0 = SystemClock.elapsedRealtime();
        long r2 = System.currentTimeMillis();
        if (this.f12222e != d.b.s.a.i0.f.f14823d.a(r10)) goto L10;
        long r7 = this.f12221d;
        if (r0 <= r7) goto L10;
        if ((r0 - r7) > r11) goto L9;
        return false;
    L9:
        return true;
    L10:
        long r3 = r2 - this.f12220c;
        if (r3 > r11) goto L15;
        if (r3 < 0) goto L15;
        return false;
    L15:
        return true;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L5;
    L30:
        return true;
    L5:
        if ((r8 instanceof j) == false) goto L29;
        j r9 = (j) r8;
        if (kotlin.n0.d.o.a(this.f12218a, r9.f12218a) == false) goto L29;
        if (this.f12219b != r9.f12219b) goto L11;
        boolean r1 = true;
    L12:
        if (r1 == false) goto L29;
        if (this.f12220c != r9.f12220c) goto L16;
        boolean r2 = true;
    L17:
        if (r2 == false) goto L29;
        if (this.f12221d != r9.f12221d) goto L21;
        boolean r3 = true;
    L22:
        if (r3 == false) goto L29;
        if (this.f12222e != r9.f12222e) goto L26;
        boolean r7 = true;
    L27:
        if (r7 == false) goto L29;
    L26:
        r7 = false;
        goto L27
    L21:
        r3 = false;
        goto L22
    L16:
        r2 = false;
        goto L17
    L11:
        r1 = false;
    L29:
        return false;
    }

    public final String f() {
        int r3 = 0;
        kotlin.u[] r1 = {a0.a("secTime", this.f12218a), a0.a("serverTime", Long.valueOf(this.f12219b)), a0.a("systemTime", Long.valueOf(this.f12220c)), a0.a("elapsedRealTimeMs", Long.valueOf(this.f12221d)), a0.a("rebootTimes", Integer.valueOf(this.f12222e))};
        JSONObject r6 = new JSONObject();
    L3:
        if (r3 >= 5) goto L5;
        kotlin.u r2 = r1[r3];
        r6.putOpt((String) r2.c(), r2.d());
        r3 = r3 + 1;
        goto L3
    L5:
        String r7 = r6.toString();
        kotlin.n0.d.o.b(r7, "jsonObjectOfSafe (\n     …imes\n        ).toString()");
        return r7;
    }

    public int hashCode() {
        String r0 = this.f12218a;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode();
    L7:
        return (((((((r1 * 31) + Long.hashCode(this.f12219b)) * 31) + Long.hashCode(this.f12220c)) * 31) + Long.hashCode(this.f12221d)) * 31) + Integer.hashCode(this.f12222e);
    L5:
        r1 = 0;
        goto L7
    }

    public String toString() {
        return "SecTimeStruct(secTime=" + this.f12218a + ", serverTime=" + this.f12219b + ", systemTime=" + this.f12220c + ", elapsedRealTimeMs=" + this.f12221d + ", rebootTimes=" + this.f12222e + ")";
    }
}

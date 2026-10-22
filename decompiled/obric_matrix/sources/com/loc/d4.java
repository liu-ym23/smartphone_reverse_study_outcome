package com.loc;

import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class d4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7240a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f7241b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public double f7242c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f7243d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f7244e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f7245f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f7246g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f7247h;

    public d4() {
        this.f7240a = 0;
        this.f7241b = 0.0d;
        this.f7242c = 0.0d;
        this.f7243d = 0;
        this.f7244e = 0;
        this.f7245f = 0;
        this.f7246g = 63;
        this.f7247h = 0;
    }

    public final String a() {
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L4
        r0.put("time", this.f7243d);     // Catch: Throwable -> L4
        r0.put("lon", this.f7242c);     // Catch: Throwable -> L4
        r0.put("lat", this.f7241b);     // Catch: Throwable -> L4
        r0.put("radius", this.f7244e);     // Catch: Throwable -> L4
        r0.put("locationType", this.f7240a);     // Catch: Throwable -> L4
        r0.put("reType", this.f7246g);     // Catch: Throwable -> L4
        r0.put("reSubType", this.f7247h);     // Catch: Throwable -> L4
    L5:
        if (r0 != null) goto L9;
        return "";
    L9:
        return r0.toString();
    L4:
        r0 = null;
        goto L5
    }

    public final void b(JSONObject r4) {
        this.f7241b = r4.optDouble("lat", this.f7241b);     // Catch: Throwable -> L4
        this.f7242c = r4.optDouble("lon", this.f7242c);     // Catch: Throwable -> L4
        this.f7240a = r4.optInt("locationType", this.f7240a);     // Catch: Throwable -> L4
        this.f7246g = r4.optInt("reType", this.f7246g);     // Catch: Throwable -> L4
        this.f7247h = r4.optInt("reSubType", this.f7247h);     // Catch: Throwable -> L4
        this.f7244e = r4.optInt("radius", this.f7244e);     // Catch: Throwable -> L4
        this.f7243d = r4.optLong("time", this.f7243d);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        s4.h(th, "CoreUtil", "transformLocation");
    }

    public final boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (r7 != null) goto L8;
    L27:
        return false;
    L8:
        if (d4.class != r7.getClass()) goto L27;
        d4 r8 = (d4) r7;
        if (this.f7240a != r8.f7240a) goto L27;
        if (Double.compare(r8.f7241b, this.f7241b) != 0) goto L27;
        if (Double.compare(r8.f7242c, this.f7242c) != 0) goto L27;
        if (this.f7243d != r8.f7243d) goto L27;
        if (this.f7244e != r8.f7244e) goto L27;
        if (this.f7245f != r8.f7245f) goto L27;
        if (this.f7246g != r8.f7246g) goto L27;
        if (this.f7247h != r8.f7247h) goto L27;
        return true;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.f7240a), Double.valueOf(this.f7241b), Double.valueOf(this.f7242c), Long.valueOf(this.f7243d), Integer.valueOf(this.f7244e), Integer.valueOf(this.f7245f), Integer.valueOf(this.f7246g), Integer.valueOf(this.f7247h)});
    }
}

package com.obric.matrix.opush.d.f;

import android.graphics.Bitmap;
import android.net.Uri;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Uri f9296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f9297b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9298c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Bitmap.Config f9299d;

    public g(Uri r1, int r2, int r3, Bitmap.Config r4) {
        this.f9296a = r1;
        this.f9297b = r2;
        this.f9298c = r3;
        this.f9299d = r4;
    }

    public String a() {
        Uri r0 = this.f9296a;
        if (r0 == null) goto L5;
        String r1 = r0.toString();
    L6:
        Bitmap.Config r2 = this.f9299d;
        if (r2 != null) goto L11;
        r2 = Bitmap.Config.ARGB_8888;
    L11:
        return r1 + "|" + this.f9297b + "x" + this.f9298c + "|" + r2.name();
    L5:
        r1 = "";
        goto L6
    }

    public boolean b() {
        if (this.f9297b > 0) goto L5;
    L7:
        return false;
    L5:
        if (this.f9298c <= 0) goto L7;
        return true;
    }

    public String toString() {
        return a();
    }
}

package com.bytedance.bdinstall;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.bdlocation.client.LocationInfoConst;

/* JADX INFO: loaded from: classes.dex */
public class k0 implements Cloneable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f2838f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f2839g;

    public k0(String r1, String r2) {
        c(r1);
        this.f2838f = r1;
        c(r2);
        this.f2839g = r2;
    }

    public static k0 a(String r2) {
        return new k0(r2 + "/service/2/device_register/", r2 + "/service/2/app_alert_check/");
    }

    private String c(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L5;
    L9:
        return r1;
    L5:
        if (r1.startsWith(LocationInfoConst.HTTPS) == true) goto L9;
        throw new IllegalArgumentException("url protocol should be https");
    }

    public String d() {
        return this.f2839g;
    }

    public String e() {
        return this.f2838f;
    }

    public boolean equals(@Nullable Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof k0) == false) goto L14;
        k0 r6 = (k0) r5;
        if (TextUtils.equals(this.f2839g, r6.f2839g) == false) goto L13;
        if (TextUtils.equals(this.f2838f, r6.f2838f) == false) goto L13;
        return true;
    L13:
        return false;
    L14:
        return false;
    }

    public String toString() {
        return "{r='" + this.f2838f + "', a='" + this.f2839g + "'}";
    }
}

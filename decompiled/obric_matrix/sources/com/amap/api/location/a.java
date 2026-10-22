package com.amap.api.location;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.loc.a2;
import com.loc.q5;
import com.loc.r5;
import com.loc.s4;
import com.loc.u4;
import com.loc.y4;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Context f509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    a2 f510b;

    public a(Context r3) {
        a(r3);
        if (r3 == null) goto L9;
        Context r0 = r3.getApplicationContext();     // Catch: Throwable -> L6
        this.f509a = r0;     // Catch: Throwable -> L6
        u4.b(r0);     // Catch: Throwable -> L6
        this.f510b = new a2(r3, null, null);     // Catch: Throwable -> L6
        return;
    L9:
        throw new IllegalArgumentException("Context参数不能为null");     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        s4.h(th, "AMClt", "ne1");
    }

    private static void a(Context r2) {
        r5 r3 = q5.a(r2, s4.q());
        if (r3.f7743a != q5.e.f7675g) goto L5;
        return;
    L5:
        Log.e("AMapLocationClient", r3.f7744b);
        throw new Exception(r3.f7744b);
    }

    public static void i(Context r1, boolean r2) {
        q5.i(r1, r2, s4.q());
    }

    public static void j(Context r1, boolean r2, boolean r3) {
        q5.j(r1, r2, r3, s4.q());
    }

    public void b(boolean r2) {
        a2 r1 = this.f510b;     // Catch: Throwable -> L6
        if (r1 == null) goto L11;
        r1.z(r2);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        s4.h(th, "AMClt", "dBackL");
    }

    public String c() {
        return "6.4.0";
    }

    public void d(b r2) {
        if (r2 == null) goto L10;
        a2 r1 = this.f510b;     // Catch: Throwable -> L7
        if (r1 == null) goto L14;
        r1.p(r2);     // Catch: Throwable -> L7
        return;
    L14:
        return;
    L10:
        throw new IllegalArgumentException("listener参数不能为null");     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        s4.h(th, "AMClt", "sLocL");
    }

    public void e(AMapLocationClientOption r3) {
        if (r3 == null) goto L16;
        a2 r0 = this.f510b;     // Catch: Throwable -> L13
        if (r0 == null) goto L7;
        r0.o(r3);     // Catch: Throwable -> L13
    L7:
        if (r3.E == false) goto L20;
        r3.E = false;     // Catch: Throwable -> L13
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r3.F) == true) goto L11;
        r1.put("amap_loc_scenes_type", r3.F);     // Catch: Throwable -> L13
    L11:
        y4.n(this.f509a, "O019", r1);     // Catch: Throwable -> L13
        return;
    L20:
        return;
    L16:
        throw new IllegalArgumentException("LocationManagerOption参数不能为null");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        s4.h(th, "AMClt", "sLocnO");
    }

    public void f() {
        a2 r2 = this.f510b;     // Catch: Throwable -> L6
        if (r2 == null) goto L11;
        r2.E();     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        s4.h(th, "AMClt", "stl");
    }

    public void g() {
        a2 r2 = this.f510b;     // Catch: Throwable -> L6
        if (r2 == null) goto L11;
        r2.P();     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        s4.h(th, "AMClt", "stl");
    }

    public void h(b r2) {
        a2 r1 = this.f510b;     // Catch: Throwable -> L6
        if (r1 == null) goto L11;
        r1.I(r2);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        s4.h(th, "AMClt", "unRL");
    }
}

package com.obric.olog;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class OLog extends ContentProvider {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static volatile boolean f10696f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static volatile boolean f10697g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile int f10698h = 3;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static volatile boolean f10699i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static Context f10700j;

    static {
    }

    public OLog() {
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences a(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    private static boolean b(int r1) {
        if (r1 < f10698h) goto L5;
        return true;
    L5:
        return false;
    }

    public static void c(String r1, String r2) {
        if (f10699i == true) goto L6;
        h();
    L6:
        if (f10697g == false) goto L11;
        if (b(3) == false) goto L11;
        Log.d(r1, r2);
    L11:
        if (f10696f == false) goto L14;
        d.g.a.a.a.h(r1, r2);
        return;
    }

    public static void d(String r1, String r2) {
        if (f10699i == true) goto L6;
        h();
    L6:
        if (f10697g == false) goto L11;
        if (b(6) == false) goto L11;
        Log.e(r1, r2);
    L11:
        if (f10696f == false) goto L14;
        d.g.a.a.a.i(r1, r2);
        return;
    }

    public static void e(String r1, String r2) {
        if (f10699i == true) goto L6;
        h();
    L6:
        if (f10697g == false) goto L11;
        if (b(4) == false) goto L11;
        Log.i(r1, r2);
    L11:
        if (f10696f == false) goto L14;
        d.g.a.a.a.n(r1, r2);
        return;
    }

    public static void f(b r5) {
        r5.f();
        f10696f = r5.g();
        f10698h = r5.b();
        SharedPreferences r0 = a(r5.a(), "olog_config", 0);
        if (r0.contains("report") == false) goto L6;
        r0.getBoolean("report", false);
    L6:
        if (r0.contains("save_to_disk") == false) goto L9;
        f10696f = r0.getBoolean("save_to_disk", true);
    L9:
        if (r0.contains("output_to_logd") == false) goto L12;
        f10697g = r0.getBoolean("output_to_logd", false);
    L12:
        if (r0.contains("log_level") == false) goto L15;
        f10698h = r0.getInt("log_level", 3);
        r5.i(f10698h);
    L15:
        if (r0.contains("max_dir_size") == false) goto L18;
        r5.l(r0.getInt("max_dir_size", r5.e()));
    L18:
        if (r0.contains("log_expired_days") == false) goto L21;
        r5.k(r0.getInt("log_expired_days", r5.d()));
    L21:
        if (f10696f == false) goto L23;
        g(r5);
    L23:
        f10699i = true;
    }

    private static boolean g(b r2) {
        d.g.a.a.b.C0439b r0 = new d.g.a.a.b.C0439b(r2.a());
        r0.h(true);
        r0.c(false);
        r0.b(false);
        r0.d(r2.b());
        r0.e(r2.c());
        r0.g(r2.e());
        r0.f(r2.d());
        return d.g.a.a.a.o(r0.a());
    }

    private static void h() {
        f(new b.C0290b(f10700j).a());
    }

    static boolean i() {
        return f10699i;
    }

    static void j(int r0) {
        f10698h = r0;
        d.g.a.a.a.f(r0);
    }

    public static void k(boolean r3) {
        f10697g = r3;
        SharedPreferences r4 = a(f10700j, "olog_config", 0);
        if (r4.contains("output_to_logd") == false) goto L6;
        f10697g = r4.getBoolean("output_to_logd", false);
        return;
    }

    static void l(boolean r0) {
    }

    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri r1, @Nullable String r2, @Nullable String[] r3) {
        return 0;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NonNull Uri r1) {
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri r1, @Nullable ContentValues r2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        f10700j = getContext();
        return true;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NonNull Uri r1, @Nullable String[] r2, @Nullable String r3, @Nullable String[] r4, @Nullable String r5) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(@NonNull Uri r1, @Nullable ContentValues r2, @Nullable String r3, @Nullable String[] r4) {
        return 0;
    }
}

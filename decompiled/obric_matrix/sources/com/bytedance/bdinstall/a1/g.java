package com.bytedance.bdinstall.a1;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.bytedance.bdinstall.v0;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SharedPreferences f2666a;

    @WorkerThread
    g(Context r3) {
        this.f2666a = a(r3, "device_register_oaid_refine", 0);
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences a(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    public void b() {
        v0.m(this.f2666a, new String[]{"oaid"});
    }

    @Nullable
    @WorkerThread
    e c() {
        return e.a(this.f2666a.getString("oaid", ""));
    }

    @WorkerThread
    void d(@Nullable e r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        this.f2666a.edit().putString("oaid", r2.c().toString()).apply();
    }
}

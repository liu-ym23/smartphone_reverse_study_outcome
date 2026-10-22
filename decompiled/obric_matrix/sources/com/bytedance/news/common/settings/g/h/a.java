package com.bytedance.news.common.settings.g.h;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import com.obric.matrix.r.b;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile a f5314b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SharedPreferences f5315a;

    private a(Context r3) {
        this.f5315a = a(r3, "__ctx_info.sp", 0);
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences a(Context r0, String r1, int r2) {
        return b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    public static a c(Context r2) {
        if (f5314b != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f5314b != null) goto L9;
        f5314b = new a(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f5314b;
    }

    public String b() {
        return this.f5315a.getString("key_ctx_info", "");
    }

    public synchronized void d(@Nullable String r3) {
        monitor-enter(this);
        this.f5315a.edit().putString("key_ctx_info", r3).apply();     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}

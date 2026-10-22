package com.bytedance.apm.internal;

import android.content.SharedPreferences;
import com.bytedance.apm.core.e;
import com.bytedance.apm.d;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SharedPreferences f1639a;

    static /* synthetic */ class a {
    }

    /* JADX INFO: renamed from: com.bytedance.apm.internal.b$b, reason: collision with other inner class name */
    private static class C0048b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final b f1640a = null;

        static {
            f1640a = new b(null);
        }

        static /* synthetic */ b a() {
            return f1640a;
        }
    }

    private b() {
        this.f1639a = e.h(d.h(), "monitor_config");
    }

    /* synthetic */ b(a r1) {
        this();
    }

    public static b a() {
        return C0048b.a();
    }

    public int b(String r2) {
        return this.f1639a.getInt(r2, -1);
    }

    public long c(String r3) {
        return this.f1639a.getLong(r3, 0);
    }

    public String d(String r2) {
        return this.f1639a.getString(r2, null);
    }

    public void e(String r1, int r2) {
        this.f1639a.edit().putInt(r1, r2).apply();
    }

    public void f(String r1, long r2) {
        this.f1639a.edit().putLong(r1, r2).apply();
    }

    public void g(String r1, String r2) {
        this.f1639a.edit().putString(r1, r2).apply();
    }
}

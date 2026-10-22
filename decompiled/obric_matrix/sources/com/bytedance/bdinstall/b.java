package com.bytedance.bdinstall;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public abstract class b implements Cloneable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f2667f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private k0 f2668g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f2669h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f2670i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final com.bytedance.bdinstall.d1.n<SharedPreferences> f2671j;

    class a extends com.bytedance.bdinstall.d1.n<SharedPreferences> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f2672b;

        a(b r1) {
            this.f2672b = r1;
        }

        @Proxy("getSharedPreferences")
        @TargetClass(scope = Scope.SELF, value = "android.content.Context")
        public static SharedPreferences c(Context r0, String r1, int r2) {
            return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
        }

        @Override // com.bytedance.bdinstall.d1.n
        protected /* bridge */ /* synthetic */ SharedPreferences a(Object[] r1) {
            return d(r1);
        }

        protected SharedPreferences d(Object... r3) {
            String r2 = com.bytedance.bdinstall.d1.h.c(this.f2672b);
            if (TextUtils.equals(r2, "ug_install_settings_pref") == false) goto L7;
            return com.bytedance.bdinstall.d1.h.a((Context) r3[0]);
        L7:
            return c((Context) r3[0], r2, 0);
        }
    }

    b(k0 r2, boolean r3, boolean r4, boolean r5) {
        this.f2671j = new a(this);
        this.f2668g = r2;
        this.f2669h = r3;
        this.f2670i = r4;
        this.f2667f = r5;
    }

    public k0 a() {
        return this.f2668g;
    }

    public SharedPreferences c(Context r3) {
        return this.f2671j.b(new Object[]{r3});
    }

    public Object clone() {
        return super.clone();
    }

    public boolean d() {
        return this.f2670i;
    }

    public boolean e() {
        return this.f2667f;
    }

    public boolean equals(@Nullable Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == false) goto L18;
        b r6 = (b) r5;
        if (this.f2668g.equals(r6.f2668g) == false) goto L17;
        if (this.f2670i != r6.f2670i) goto L17;
        if (this.f2669h != r6.f2669h) goto L17;
        if (this.f2667f != r6.e()) goto L17;
        return true;
    L17:
        return false;
    L18:
        return false;
    }

    public boolean f() {
        return this.f2669h;
    }

    public String toString() {
        return "AbsEnv{isChildMode=" + this.f2667f + ", config=" + this.f2668g + ", isI18n=" + this.f2669h + ", isBoe=" + this.f2670i + '}';
    }
}

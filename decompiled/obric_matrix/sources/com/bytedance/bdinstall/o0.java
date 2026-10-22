package com.bytedance.bdinstall;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
final class o0 implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f2852a;

    class a implements u0.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f2853a;

        a(o0 r1, b r2) {
            this.f2853a = r2;
        }

        @Override // com.bytedance.bdinstall.u0.d
        public void b(String r3) {
            q.a("install_info onUpdate " + r3);
            h0 r4 = h0.h(r3);
            if (r4 != null) goto L5;
        L13:
            q.a("install_info onUpdate invalid value " + r4);
            return;
        L5:
            if (TextUtils.isEmpty(r4.c()) == true) goto L13;
            if (TextUtils.isEmpty(r4.d()) == true) goto L13;
            b r2 = this.f2853a;
            if (r2 == null) goto L15;
            r2.b(r4);
            return;
        }
    }

    interface b {
        void b(h0 r1);
    }

    o0(Context r1) {
        this.f2852a = r1;
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences b(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    @Override // com.bytedance.bdinstall.b0
    public void a(@NonNull h0 r2) {
        u0.d(this.f2852a).i("install_info", r2.o().toString());
    }

    h0 c() {
        return h0.h(b(this.f2852a, "ug_install_op_pref", 0).getString("install_info", null));
    L5:
        return null;
    }

    void d(Context r2, b r3) {
        u0.d(r2).g("install_info", new a(this, r3));
    }

    void e() {
        i.b(true, this);
    }
}

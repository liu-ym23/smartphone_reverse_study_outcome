package com.bytedance.bdinstall.d1;

import android.content.Context;
import android.content.SharedPreferences;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final n<SharedPreferences> f2727a = null;

    /* JADX INFO: renamed from: com.bytedance.bdinstall.d1.a$a, reason: collision with other inner class name */
    class C0080a extends n<SharedPreferences> {
        C0080a() {
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

        protected SharedPreferences d(Object... r2) {
            return c((Context) r2[0], "ug_install_settings_pref", 0);
        }
    }

    static {
        f2727a = new C0080a();
    }

    public static SharedPreferences a(Context r3) {
        return f2727a.b(new Object[]{r3});
    }

    public static String b(String r1, com.bytedance.bdinstall.b r2) {
        if (r2.f() == false) goto L6;
        r1 = r1 + "_i18n";
    L6:
        if (r2.d() == false) goto L9;
        r1 = r1 + "_boe";
    L9:
        if (r2.e() == true) goto L11;
        return r1;
    L11:
        return r1 + "_cm";
    }

    public static String c(com.bytedance.bdinstall.b r1) {
        return b("ug_install_settings_pref", r1);
    }
}

package com.bytedance.common.utility.o;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final b f3319a = null;

    /* JADX INFO: renamed from: com.bytedance.common.utility.o.a$a, reason: collision with other inner class name */
    static class C0092a implements b {
        C0092a() {
        }

        @Override // com.bytedance.common.utility.o.a.b
        public void a(SharedPreferences.Editor r1) {
            r1.commit();
        }
    }

    interface b {
        void a(SharedPreferences.Editor r1);
    }

    static class c implements b {
        c() {
        }

        @Override // com.bytedance.common.utility.o.a.b
        @TargetApi(9)
        public void a(SharedPreferences.Editor r1) {
            r1.apply();
        }
    }

    static {
        if (Build.VERSION.SDK_INT < 9) goto L5;
        b r0 = new c();
    L6:
        f3319a = r0;
        return;
    L5:
        r0 = new C0092a();
        goto L6
    }

    public static void a(SharedPreferences.Editor r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        f3319a.a(r1);
    }
}

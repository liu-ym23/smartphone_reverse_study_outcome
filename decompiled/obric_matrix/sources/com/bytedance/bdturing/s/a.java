package com.bytedance.bdturing.s;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.bdturing.BdTuringConfig;
import com.bytedance.bdturing.e;
import com.bytedance.bdturing.q;
import com.bytedance.bdturing.v.f;
import com.bytedance.bdturing.v.g;
import com.bytedance.bdturing.v.h;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static g.a f3138a;

    /* JADX INFO: renamed from: com.bytedance.bdturing.s.a$a, reason: collision with other inner class name */
    static class C0085a implements g.a {
        C0085a() {
        }

        @Override // com.bytedance.bdturing.v.g.a
        public void a(int r1, String r2, long r3) {
            if (r1 != 200) goto L5;
            a.b();
        L5:
            if (r1 != 200) goto L7;
            int r0 = 0;
        L8:
            e.r(r3, r0);
            return;
        L7:
            r0 = 1;
            goto L8
        }
    }

    static class b implements com.bytedance.bdturing.v.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BdTuringConfig f3139a;

        b(BdTuringConfig r1) {
            this.f3139a = r1;
        }

        @Override // com.bytedance.bdturing.v.a
        public String a() {
            return this.f3139a.getAppVersion();
        }

        @Override // com.bytedance.bdturing.v.a
        @Nullable
        public String b() {
            return this.f3139a.getAppVersionCode();
        }

        @Override // com.bytedance.bdturing.v.a
        public Looper c() {
            return q.c().d();
        }

        @Override // com.bytedance.bdturing.v.a
        public com.bytedance.bdturing.ttnet.b d() {
            return this.f3139a.getHttpClient();
        }

        @Override // com.bytedance.bdturing.v.a
        public f e() {
            return this.f3139a.getServiceInterceptor();
        }

        @Override // com.bytedance.bdturing.v.a
        public String f() {
            return "3.2.0.cn";
        }

        @Override // com.bytedance.bdturing.v.a
        public String g() {
            return this.f3139a.getLanguage();
        }

        @Override // com.bytedance.bdturing.v.a
        public String getAppId() {
            return this.f3139a.getAppId();
        }

        @Override // com.bytedance.bdturing.v.a
        public String getAppName() {
            return this.f3139a.getAppName();
        }

        @Override // com.bytedance.bdturing.v.a
        public String getChannel() {
            return this.f3139a.getChannel();
        }

        @Override // com.bytedance.bdturing.v.a
        public String getDeviceId() {
            return this.f3139a.getDeviceId();
        }

        @Override // com.bytedance.bdturing.v.a
        public String getInstallId() {
            return this.f3139a.getInstallId();
        }

        @Override // com.bytedance.bdturing.v.a
        public String getRegion() {
            if (this.f3139a.getRegionType() == null) goto L5;
            BdTuringConfig.c r1 = this.f3139a.getRegionType();
        L7:
            return r1.a();
        L5:
            r1 = BdTuringConfig.c.f3010g;
            goto L7
        }
    }

    static {
        f3138a = new C0085a();
    }

    @Proxy("getSharedPreferences")
    @TargetClass(scope = Scope.SELF, value = "android.content.Context")
    public static SharedPreferences a(Context r0, String r1, int r2) {
        return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
    }

    static /* synthetic */ void b() {
        d();
    }

    public static void c(@NonNull BdTuringConfig r3) {
        h r0 = h.f3217l;
        r0.w(r3.getApplicationContext(), new b(r3));
        r0.c(f3138a);
    }

    private static void d() {
        if (com.bytedance.bdturing.b.f().e() == null) goto L5;
        Context r0 = com.bytedance.bdturing.b.f().e().getApplicationContext();     // Catch: Exception -> L9
    L6:
        if (r0 == null) goto L12;
        SharedPreferences.Editor r1 = a(r0, "bd_turning_settings_init", 0).edit();     // Catch: Exception -> L9
        r1.putBoolean("inited", true);     // Catch: Exception -> L9
        r1.commit();     // Catch: Exception -> L9
        return;
    L12:
        return;
    L5:
        r0 = null;
    }
}

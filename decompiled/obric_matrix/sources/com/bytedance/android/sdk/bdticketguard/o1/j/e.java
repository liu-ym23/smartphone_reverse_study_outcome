package com.bytedance.android.sdk.bdticketguard.o1.j;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.bytedance.android.sdk.bdticketguard.d1;
import com.bytedance.android.sdk.bdticketguard.f1;
import com.bytedance.android.sdk.bdticketguard.s0;
import com.google.gson.Gson;
import kotlin.n0.d.e0;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import kotlin.n0.d.y;
import kotlin.s0.l;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ l[] f990a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final kotlin.h f991b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile com.bytedance.android.sdk.bdticketguard.g f992c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final kotlin.h f993d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final e f994e = null;

    static final class a extends q implements kotlin.n0.c.a<Gson> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f995f = null;

        static {
            f995f = new a();
        }

        a() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.n0.c.a
        public final Gson invoke() {
            return new Gson();
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Gson invoke() {
            return invoke();
        }
    }

    static final class b extends q implements kotlin.n0.c.a<SharedPreferences> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final b f996f = null;

        static {
            f996f = new b();
        }

        b() {
            super(0);
        }

        @Proxy("getSharedPreferences")
        @TargetClass(scope = Scope.SELF, value = "android.content.Context")
        public static SharedPreferences a(Context r0, String r1, int r2) {
            return com.obric.matrix.r.b.g(com.bytedance.mpaas.app.a.a()).getSharedPreferences(r1, r2);
        }

        public final SharedPreferences b() {
            f1 r2 = d1.f706b.a();
            if (r2 != null) goto L5;
            o.p();
            throw null;
        L5:
            return a(r2.G().e(), "sp_TicketGuardManager", 0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ SharedPreferences invoke() {
            return b();
        }
    }

    static {
        f990a = new l[]{e0.g(new y(e0.b(e.class), "gson", "getGson()Lcom/google/gson/Gson;")), e0.g(new y(e0.b(e.class), "sp", "getSp()Landroid/content/SharedPreferences;"))};
        f994e = new e();
        f991b = kotlin.i.b(a.f995f);
        f993d = kotlin.i.b(b.f996f);
    }

    private e() {
    }

    private final Gson c() {
        kotlin.h r2 = f991b;
        l r0 = f990a[0];
        return (Gson) r2.getValue();
    }

    private final SharedPreferences d() {
        kotlin.h r2 = f993d;
        l r0 = f990a[1];
        return (SharedPreferences) r2.getValue();
    }

    private final com.bytedance.android.sdk.bdticketguard.g e() {
        com.bytedance.android.sdk.bdticketguard.g r2 = null;
        String r0 = d().getString("bd_ticket_guard_attestation_result", null);
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L17;
        return null;
    L17:
        r2 = (com.bytedance.android.sdk.bdticketguard.g) c().m(r0, com.bytedance.android.sdk.bdticketguard.g.class);     // Catch: Exception -> L13
    L15:
        f992c = r2;
        return r2;
    L13:
        e = move-exception;
        s0.f1065a.e("AttestResultHolder", "loadAttestationResult fail, " + Log.getStackTraceString(e));
        goto L15
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public final void a() {
        s0.f1065a.e("AttestResultHolder", "clearAttestationResult");
        f992c = null;
        d().edit().remove("bd_ticket_guard_attestation_result").apply();
    }

    public final com.bytedance.android.sdk.bdticketguard.g b() {
        com.bytedance.android.sdk.bdticketguard.g r0 = f992c;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return e();
    }

    public final void f(com.bytedance.android.sdk.bdticketguard.g r2) {
        o.g(r2, "attestationResult");
        f992c = r2;
        d().edit().putString("bd_ticket_guard_attestation_result", c().v(r2)).apply();
    }
}

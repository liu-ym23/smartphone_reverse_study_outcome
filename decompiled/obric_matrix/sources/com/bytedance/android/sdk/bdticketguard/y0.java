package com.bytedance.android.sdk.bdticketguard;

import com.google.gson.Gson;

/* JADX INFO: loaded from: classes.dex */
public final class y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ kotlin.s0.l[] f1090a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final kotlin.h f1091b = null;

    static final class a extends kotlin.n0.d.q implements kotlin.n0.c.a<Gson> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f1092f = null;

        static {
            f1092f = new a();
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

    static {
        f1090a = new kotlin.s0.l[]{kotlin.n0.d.e0.f(new kotlin.n0.d.w(kotlin.n0.d.e0.d(y0.class, "bd_ticket_guard_api_release"), "gson", "getGson()Lcom/google/gson/Gson;"))};
        f1091b = kotlin.i.b(a.f1092f);
    }

    public static final Gson a() {
        kotlin.h r0 = f1091b;
        kotlin.s0.l r1 = f1090a[0];
        return (Gson) r0.getValue();
    }
}

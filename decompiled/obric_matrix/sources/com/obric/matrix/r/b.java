package com.obric.matrix.r;

import android.content.Context;
import android.os.Build;
import android.os.UserManager;
import kotlin.Metadata;
import kotlin.h;
import kotlin.i;
import kotlin.n0.d.o;
import kotlin.n0.d.q;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0013\u001a\u00020\u0011J\f\u0010\u0014\u001a\u00020\u0004*\u00020\u0004H\u0007R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR#\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/obric/matrix/common_utils/DCContextUtils;", "", "()V", "originApplicationContext", "Landroid/content/Context;", "getOriginApplicationContext", "()Landroid/content/Context;", "setOriginApplicationContext", "(Landroid/content/Context;)V", "userManager", "Landroid/os/UserManager;", "kotlin.jvm.PlatformType", "getUserManager", "()Landroid/os/UserManager;", "userManager$delegate", "Lkotlin/Lazy;", "isP", "", "isUnlocked", "shouldUseDCContextGlobal", "wrapDCContext", "common_utils_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f9910a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final h f9911b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile Context f9912c;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/os/UserManager;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class a extends q implements kotlin.n0.c.a<UserManager> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f9913f = null;

        static {
            f9913f = new a();
        }

        a() {
            super(0);
        }

        public final UserManager a() {
            return (UserManager) com.bytedance.mpaas.app.a.a().getSystemService(UserManager.class);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ UserManager invoke() {
            return a();
        }
    }

    static {
        f9910a = new b();
        f9911b = i.b(a.f9913f);
    }

    private b() {
    }

    private final UserManager b() {
        return (UserManager) f9911b.getValue();
    }

    public static final Context g(Context r2) {
        o.f(r2, "<this>");
        b r0 = f9910a;
        if (r0.b().isUserUnlocked() == false) goto L7;
        if (r0.f() == true) goto L7;
    L10:
        return r2;
    L7:
        if (r2.isDeviceProtectedStorage() == true) goto L9;
        r2 = r2.createDeviceProtectedStorageContext();
    L9:
        o.e(r2, "{\n            if (!isDev…s\n            }\n        }");
        goto L10
    }

    public final Context a() {
        return f9912c;
    }

    public final boolean c() {
        String r1 = Build.MODEL;
        if (o.a(r1, "Ashe") == false) goto L5;
    L8:
        return true;
    L5:
        if (o.a(r1, "P0110") == true) goto L8;
        return false;
    }

    public final boolean d() {
        return b().isUserUnlocked();
    }

    public final void e(Context r1) {
        f9912c = r1;
    }

    public final boolean f() {
        return !c();
    }
}

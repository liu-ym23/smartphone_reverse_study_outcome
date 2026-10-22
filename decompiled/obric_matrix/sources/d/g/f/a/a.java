package d.g.f.a;

import android.app.Application;
import android.content.Context;
import com.obric.matrix.r.c.c;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.h;
import kotlin.i;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u000bJ\u0006\u0010\u0012\u001a\u00020\u0004J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0016J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000bR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/utilsLib/context/AppGlobals;", "", "()V", "app", "Landroid/app/Application;", "getApp", "()Landroid/app/Application;", "app$delegate", "Lkotlin/Lazy;", "globalTime", "Lkotlin/Pair;", "", "lastLocaleLanguage", "", "kotlin.jvm.PlatformType", "checkLanguageChanged", "", "currentTimeMillis", "getApplication", "getApplicationContext", "Landroid/content/Context;", "getResource", "Landroid/content/res/Resources;", "updateTimestamp", "", "timestampMillis", "ObricUtilsSDK_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f16974a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final h f16975b = null;

    /* JADX INFO: renamed from: d.g.f.a.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/app/Application;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    static final class C0447a extends q implements kotlin.n0.c.a<Application> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final C0447a f16976f = null;

        static {
            f16976f = new C0447a();
        }

        C0447a() {
            super(0);
        }

        public final Application a() {
            Object r3 = Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);
            o.d(r3, "null cannot be cast to non-null type android.app.Application");
            return (Application) r3;
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ Application invoke() {
            return a();
        }
    }

    static {
        f16974a = new a();
        f16975b = i.b(C0447a.f16976f);
        Locale.getDefault().getLanguage();
    }

    private a() {
    }

    @Proxy("getApplicationContext")
    @TargetClass(scope = Scope.ALL, value = "android.content.Context")
    public static Context a(Application r2) {
        return r2.getApplicationContext();
    L4:
        e = move-exception;
        c.g("hookGetApplicationContext", "getApplicationContext error", e);
        return com.bytedance.mpaas.app.a.a();
    }

    private final Application b() {
        return (Application) f16975b.getValue();
    }

    public final Application c() {
        return b();
    }

    public final Context d() {
        Context r1 = a(c());
        o.e(r1, "getApplication().applicationContext");
        return r1;
    }
}

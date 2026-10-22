package com.obric.matrix.ostracker_api;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.bytedance.news.common.service.manager.d;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.h;
import kotlin.i;
import kotlin.n0.d.o;
import kotlin.n0.d.q;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J,\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\n\u0010\u0016\u001a\u0004\u0018\u00010\u000fH\u0007J\n\u0010\u0017\u001a\u0004\u0018\u00010\u000fH\u0007J\b\u0010\u0018\u001a\u00020\nH\u0007J\u001a\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007J6\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u001e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0012\u0010\u001f\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0010\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\u0013H\u0007R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\""}, d2 = {"Lcom/obric/matrix/ostracker_api/OSTracker;", "", "()V", "impl", "Lcom/obric/matrix/ostracker_api/IOSTracker;", "getImpl", "()Lcom/obric/matrix/ostracker_api/IOSTracker;", "impl$delegate", "Lkotlin/Lazy;", "addTeaTrackerListener", "", "listener", "Lcom/obric/matrix/ostracker_api/IOSTrackerListener;", "getCommonParams", "", "", "context", "Landroid/content/Context;", "isApi", "", "level", "", "getDeviceId", "getInstallId", "init", "onEvent", NotificationCompat.CATEGORY_EVENT, "params", "Lorg/json/JSONObject;", "putCommonParams", "", "removeTeaTrackerListener", "setBoe", "isBoe", "ostracker_api_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f9463a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final h f9464b = null;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/obric/matrix/ostracker_api/IOSTracker;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class a extends q implements kotlin.n0.c.a<IOSTracker> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f9465f = null;

        static {
            f9465f = new a();
        }

        a() {
            super(0);
        }

        public final IOSTracker a() {
            return (IOSTracker) d.a(IOSTracker.class);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ IOSTracker invoke() {
            return a();
        }
    }

    static {
        f9463a = new b();
        f9464b = i.b(a.f9465f);
    }

    private b() {
    }

    public static final void a(com.obric.matrix.ostracker_api.a r1) {
        f9463a.d().addTeaTrackerListener(r1);
    }

    public static final Map<String, String> b(Context r2, boolean r3, int r4) {
        o.f(r2, "context");
        LinkedHashMap r0 = new LinkedHashMap();
        f9463a.d().putCommonParams(r2, r0, r3, r4);
        return r0;
    }

    public static final String c() {
        return f9463a.d().getDeviceId();
    }

    private final IOSTracker d() {
        Object r1 = f9464b.getValue();
        o.e(r1, "<get-impl>(...)");
        return (IOSTracker) r1;
    }

    public static final String e() {
        return f9463a.d().getInstallId();
    }

    public static final void f() {
        f9463a.d().init();
    }

    public static final void g(String r1, JSONObject r2) {
        o.f(r1, NotificationCompat.CATEGORY_EVENT);
        f9463a.d().onEvent(r1, r2);
    }

    public static final void h(com.obric.matrix.ostracker_api.a r1) {
        f9463a.d().removeTeaTrackerListener(r1);
    }

    public static final void i(boolean r1) {
        f9463a.d().setBoe(r1);
    }
}

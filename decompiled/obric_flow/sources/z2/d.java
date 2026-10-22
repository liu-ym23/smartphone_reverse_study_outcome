package z2;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f23373a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Handler f23374b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CopyOnWriteArrayList f23375c = null;

    static {
        f23373a = new AtomicBoolean(false);
        HandlerThread r5 = new HandlerThread("AppletReportingThread");
        f23375c = new CopyOnWriteArrayList();
        r5.start();
        f23374b = new Handler(r5.getLooper());
    }

    public static void a(Runnable r5) {
        com.bytedance.ai.resource.core.db.b r10 = new com.bytedance.ai.resource.core.db.b(r5, 4);
        Intrinsics.checkNotNullParameter(r10, "task");
        com.bytedance.ai.multiprocess.a r11 = com.bytedance.ai.multiprocess.d.f2406a;
        if (r11 == null) goto L8;
        Intrinsics.checkNotNullParameter(r10, "task");
        Function1 r12 = r11.f2401b;
        if (r12 == null) goto L7;
        r12.invoke(r10);
        return;
    L7:
        r10.invoke();
        return;
    L8:
        r10.invoke();
    }

    public static void b(String r10, g r11) {
        Intrinsics.checkNotNullParameter(r10, "name");
        Intrinsics.checkNotNullParameter(r11, "builder");
        a(new b(r10, r11, System.currentTimeMillis(), 0));
    }

    public static void c(f r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        if (r5.g() == false) goto L18;
        JSONObject r10 = r5.h();
        String r11 = r5.f23384b;
        if (Intrinsics.areEqual(r11, "jsb_event") == false) goto L9;
        return;
    L9:
        if (Intrinsics.areEqual(r11, "error_event") == false) goto L13;
        Intrinsics.checkNotNullParameter(r10, "event");
        return;
    L13:
        if (r5.d == false) goto L16;
        io.reactivex.exceptions.a.g(r10, r5.a());
        io.reactivex.exceptions.a.g(r10, r5.f23388j);
        Intrinsics.checkNotNullParameter(r10, "event");
        return;
    L16:
        Intrinsics.checkNotNullParameter(r10, "event");
        return;
    }

    public static void d(String r10, g r11) {
        Intrinsics.checkNotNullParameter(r10, "name");
        Intrinsics.checkNotNullParameter(r11, "builder");
        a(new b(r10, r11, System.currentTimeMillis(), 2));
    }

    public static void e(String r10, g r11) {
        Intrinsics.checkNotNullParameter(r10, "name");
        Intrinsics.checkNotNullParameter(r11, "builder");
        a(new b(r10, r11, System.currentTimeMillis(), 1));
    }
}

package d.b.h.a.a.h.o.b.x.k;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.bytedance.common.utility.collection.WeakHandler;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class e implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f13623c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static WeakHandler f13624d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f13625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Runnable f13626b;

    class a implements WeakHandler.IHandler {
        a() {
        }

        @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
        public void handleMsg(Message r1) {
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ e f13627f;

        b(e r1) {
            this.f13627f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.a() == false) goto L8;
            e.b(false);
            if (e.c(this.f13627f) == null) goto L9;
            e.c(this.f13627f).onEnterToBackground();
            return;
        L9:
            return;
        }
    }

    public interface c {
        void onEnterToBackground();

        void onEnterToForeground();
    }

    static {
        f13624d = new WeakHandler(Looper.getMainLooper(), new a());
    }

    public e() {
        this.f13626b = new b(this);
        if (d() == null) goto L6;
        f13623c = true;
        return;
    }

    static /* synthetic */ boolean a() {
        return f13623c;
    }

    static /* synthetic */ boolean b(boolean r0) {
        f13623c = r0;
        return r0;
    }

    static /* synthetic */ c c(e r0) {
        return r0.f13625a;
    }

    private static Activity d() {
        Class<?> r1 = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L14
        Object r2 = r1.getMethod("currentActivityThread", new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L14
        Field r3 = r1.getDeclaredField("mActivities");     // Catch: Throwable -> L14
        r3.setAccessible(true);     // Catch: Throwable -> L14
        Map r4 = (Map) r3.get(r2);     // Catch: Throwable -> L14
        if (r4 != null) goto L6;
        return null;
    L6:
        Iterator r5 = r4.values().iterator();     // Catch: Throwable -> L14
    L8:
        if (r5.hasNext() == false) goto L13;
        Object r6 = r5.next();     // Catch: Throwable -> L14
        Class<?> r7 = r6.getClass();     // Catch: Throwable -> L14
        Field r8 = r7.getDeclaredField("paused");     // Catch: Throwable -> L14
        r8.setAccessible(true);     // Catch: Throwable -> L14
        if (r8.getBoolean(r6) == true) goto L8;
        Field r9 = r7.getDeclaredField("activity");     // Catch: Throwable -> L14
        r9.setAccessible(true);     // Catch: Throwable -> L14
        return (Activity) r9.get(r6);
    L13:
        return null;
    }

    public void e(c r1) {
        this.f13625a = r1;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity r1, Bundle r2) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity r1) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity r3) {
        if (f13623c == false) goto L6;
        f13624d.postDelayed(this.f13626b, 30000);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity r1) {
        if (f13623c == true) goto L7;
        f13623c = true;
        c r2 = this.f13625a;
        if (r2 == null) goto L7;
        r2.onEnterToForeground();
    L7:
        f13624d.removeCallbacks(this.f13626b);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity r1, Bundle r2) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity r1) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity r1) {
    }
}

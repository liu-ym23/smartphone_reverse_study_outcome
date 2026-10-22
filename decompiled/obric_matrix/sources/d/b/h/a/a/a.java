package d.b.h.a.a;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.common.utility.collection.WeakHandler;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class a implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f13205b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static WeakHandler f13206c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<b> f13207a;

    /* JADX INFO: renamed from: d.b.h.a.a.a$a, reason: collision with other inner class name */
    class C0351a implements WeakHandler.IHandler {
        C0351a() {
        }

        @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
        public void handleMsg(Message r1) {
        }
    }

    public static abstract class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f13208a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Runnable f13209b;

        /* JADX INFO: renamed from: d.b.h.a.a.a$b$a, reason: collision with other inner class name */
        class RunnableC0352a implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ b f13210f;

            RunnableC0352a(b r1) {
                this.f13210f = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (a.a() == false) goto L6;
                a.b(false);
                this.f13210f.c();
                return;
            }
        }

        public b() {
            this.f13208a = LocationInfoConst.HALF_MINUTES;
            this.f13209b = new RunnableC0352a(this);
        }

        public b(int r2) {
            this.f13208a = LocationInfoConst.HALF_MINUTES;
            this.f13209b = new RunnableC0352a(this);
            this.f13208a = r2;
        }

        public Runnable a() {
            return this.f13209b;
        }

        public int b() {
            return this.f13208a;
        }

        public abstract void c();

        public abstract void d();

        public void e(int r1) {
            this.f13208a = r1;
        }
    }

    static {
        f13206c = new WeakHandler(Looper.getMainLooper(), new C0351a());
    }

    public a() {
        this.f13207a = new CopyOnWriteArrayList();
        if (d() == null) goto L6;
        f13205b = true;
        return;
    }

    static /* synthetic */ boolean a() {
        return f13205b;
    }

    static /* synthetic */ boolean b(boolean r0) {
        f13205b = r0;
        return r0;
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

    public void c(b r1) {
        this.f13207a.add(r1);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity r1, Bundle r2) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity r1) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity r5) {
        if (f13205b == false) goto L8;
        Iterator<b> r4 = this.f13207a.iterator();
    L6:
        if (r4.hasNext() == false) goto L10;
        b r6 = r4.next();
        f13206c.postDelayed(r6.a(), r6.b());
        goto L6
    L10:
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity r1) {
        if (f13205b == true) goto L8;
        f13205b = true;
        Iterator<b> r0 = this.f13207a.iterator();
    L6:
        if (r0.hasNext() == false) goto L8;
        r0.next().d();
    L8:
        f13206c.removeCallbacksAndMessages(null);
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

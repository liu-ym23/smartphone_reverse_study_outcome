package tmsdkobf;

import android.app.Activity;
import android.view.ViewTreeObserver;
import android.view.Window;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public abstract class wk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final WeakHashMap f606a = null;
    public static final AtomicReference b = null;

    public static class a extends yh implements pj, g2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicBoolean f607a;
        public final ph b;

        public a(ph r3) {
            this.f607a = new AtomicBoolean(false);
            this.b = r3;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity r1) {
            this.f607a.set(true);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity r5) {
            if (r5 == null) goto L22;
            Window r0 = r5.getWindow();
            if (r0 == null) goto L22;
            String r1 = r5.getClass().getName();
            WeakHashMap r2 = wk.f606a;     // Catch: Throwable -> L24
            if (r2.containsKey(r5) == true) goto L22;
            r2.put(r5, null);     // Catch: Throwable -> L24
            Window.Callback r6 = r0.getCallback();     // Catch: Throwable -> L24
            if (r6 != null) goto L15;
        L18:
            ViewTreeObserver r7 = r0.getDecorView().getViewTreeObserver();     // Catch: Throwable -> L24
            if (r7 == null) goto L22;
            r7.addOnPreDrawListener(new pk(r0, this, r1));     // Catch: Throwable -> L24
            goto L22
        L15:
            if ((r6 instanceof t8) == true) goto L18;
            r0.setCallback(new t8(r6, r1, this));     // Catch: Throwable -> L24
        L22:
            this.f607a.set(false);
        }
    }

    static {
        f606a = new WeakHashMap();
        b = new AtomicReference(null);
    }
}

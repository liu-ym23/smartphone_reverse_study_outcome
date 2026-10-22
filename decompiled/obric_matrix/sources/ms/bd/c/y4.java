package ms.bd.c;

import android.app.Application;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.view.Display;

/* JADX INFO: loaded from: classes2.dex */
public class y4 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static y4 f22558f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final HandlerThread f22559a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f22560b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f22561c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private DisplayManager f22562d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private w4 f22563e;

    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ y4 f22564f;

        a(y4 r1) {
            this.f22564f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Build.VERSION.SDK_INT >= 17) goto L5;
            return;
        L5:
            if (y4.b(this.f22564f) == null) goto L24;
            y4.f(this.f22564f).start();     // Catch: Throwable -> L20
            Handler r0 = new Handler(y4.f(this.f22564f).getLooper());     // Catch: Throwable -> L20
            y4 r1 = this.f22564f;     // Catch: Throwable -> L20
            y4.c(r1, (DisplayManager) y4.b(r1).getApplicationContext().getSystemService((String) m.a(16777217, 0, 0, "0dba17", new byte[]{37, 111, 2, 5, 2, 33, 42})));     // Catch: Throwable -> L20
            if (y4.h(this.f22564f) == null) goto L25;
            Display[] r2 = y4.h(this.f22564f).getDisplays();     // Catch: Throwable -> L20
            int r3 = r2.length;     // Catch: Throwable -> L20
            if (r3 <= 1) goto L18;
            x4 r4 = x4.c();     // Catch: Throwable -> L20
            String r5 = r4.h(r2);     // Catch: Throwable -> L20
            String r6 = r4.b(r2);     // Catch: Throwable -> L20
            r4.d(r3);     // Catch: Throwable -> L20
            r4.g(true);     // Catch: Throwable -> L20
            if (TextUtils.isEmpty(r5) == true) goto L16;
            r4.k(r5);     // Catch: Throwable -> L20
        L16:
            if (TextUtils.isEmpty(r6) == true) goto L18;
            r4.f(r6);     // Catch: Throwable -> L20
        L18:
            y4 r7 = this.f22564f;     // Catch: Throwable -> L20
            y4.d(r7, new w4(y4.h(r7)));     // Catch: Throwable -> L20
            y4.h(this.f22564f).registerDisplayListener(y4.i(this.f22564f), r0);     // Catch: Throwable -> L20
            return;
        L25:
            return;
        L24:
            return;
        }
    }

    private y4(Context r8) {
        this.f22561c = false;
        Context r9 = r8.getApplicationContext();
        this.f22560b = r9;
        if ((r9 instanceof Application) == true) goto L8;
        Context r10 = a();
        if (r10 != null) goto L7;
        r10 = this.f22560b;
    L7:
        this.f22560b = r10;
    L8:
        this.f22559a = new HandlerThread((String) m.a(16777217, 0, 0, "c218f2", new byte[]{95, 3, 113, 126}));
    }

    private Application a() {
        return (Application) Class.forName((String) m.a(16777217, 0, 0, "c8855f", new byte[]{115, 52, 79, 83, 5, 120, 100, 87, 104, 117, 98, 116, 106, 66, 30, 120, 118, 16, 125, 124, 70, 50, 89, 68, 11, 117})).getMethod((String) m.a(16777217, 0, 0, "39fde5", new byte[]{33, 46, 7, 2, 95, 44, 36, 57, 39, 36, 46, 50, 22, 17, 78, 43, 63, 22}), new Class[0]).invoke(null, null);
    L11:
        return null;
    }

    static /* synthetic */ Context b(y4 r0) {
        return r0.f22560b;
    }

    static /* synthetic */ DisplayManager c(y4 r0, DisplayManager r1) {
        r0.f22562d = r1;
        return r1;
    }

    static /* synthetic */ w4 d(y4 r0, w4 r1) {
        r0.f22563e = r1;
        return r1;
    }

    public static y4 e(Context r2) {
        monitor-enter(y4.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f22558f != null) goto L7;
        f22558f = new y4(r2);     // Catch: Throwable -> L10
    L7:
        y4 r3 = f22558f;     // Catch: Throwable -> L10
        monitor-exit(y4.class);     // Catch: Throwable -> L10
        return r3;
    }

    static /* synthetic */ HandlerThread f(y4 r0) {
        return r0.f22559a;
    }

    static /* synthetic */ DisplayManager h(y4 r0) {
        return r0.f22562d;
    }

    static /* synthetic */ w4 i(y4 r0) {
        return r0.f22563e;
    }

    protected void finalize() {
        int r0 = Build.VERSION.SDK_INT;
        monitor-enter(this);
        if (r0 < 17) goto L30;
        DisplayManager r1 = this.f22562d;     // Catch: Throwable -> L23
        if (r1 == null) goto L30;
        w4 r2 = this.f22563e;     // Catch: Throwable -> L23
        if (r2 == null) goto L30;
        r1.unregisterDisplayListener(r2);     // Catch: Throwable -> L23
    L30:
        HandlerThread r3 = this.f22559a;     // Catch: Throwable -> L20
        if (r3 != null) goto L26;
    L17:
        monitor-exit(this);
        super.finalize();
        return;
    L26:
        if (r0 < 18) goto L16;
        r3.quitSafely();     // Catch: Throwable -> L24
    L25:
        goto L17
    L16:
        r3.quit();     // Catch: Throwable -> L24
    L20:
        th = move-exception;
        throw th;
    }

    public synchronized void g() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.f22561c == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.f22561c = true;     // Catch: Throwable -> L11
        new Thread(new a(this)).start();     // Catch: Throwable -> L11
        monitor-exit(this);
    }
}

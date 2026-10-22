package d.b.h.a.a.f;

import android.net.TrafficStats;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bytedance.common.utility.Logger;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static long f13288g = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d.b.h.a.a.f.b f13289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AtomicInteger f13290b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private b f13291c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private HandlerThread f13292d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f13293e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f13294f;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f13295a = null;

        static {
            f13295a = new d(d.b.h.a.a.f.b.c());
        }
    }

    private class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f13296a;

        public b(d r1, Looper r2) {
            this.f13296a = r1;
            super(r2);
        }

        public void a() {
            sendEmptyMessage(1);
        }

        public void b() {
            removeMessages(1);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r4) {
            if (r4.what != 1) goto L10;
            this.f13296a.b();     // Catch: Throwable -> L7
            sendEmptyMessageDelayed(1, 1000);     // Catch: Throwable -> L7
            return;
        L10:
            return;
        }
    }

    static {
    }

    protected d(d.b.h.a.a.f.b r2) {
        this.f13293e = false;
        this.f13289a = r2;
        this.f13290b = new AtomicInteger();     // Catch: Throwable -> L5
        HandlerThread r3 = d.b.h.a.a.l.a.a("ParseThread");     // Catch: Throwable -> L5
        this.f13292d = r3;     // Catch: Throwable -> L5
        r3.start();     // Catch: Throwable -> L5
        this.f13291c = new b(this, this.f13292d.getLooper());     // Catch: Throwable -> L5
        return;
    L5:
        this.f13293e = true;
    }

    public static d c() {
        return a.f13295a;
    }

    protected void a() {
        b();
        f13288g = -1;
    }

    protected void b() {
        long r0 = TrafficStats.getTotalRxBytes();     // Catch: Throwable -> L13
        long r2 = f13288g;     // Catch: Throwable -> L13
        long r4 = r0 - r2;     // Catch: Throwable -> L13
        if (r2 < 0) goto L11;
        monitor-enter(this);     // Catch: Throwable -> L13
        long r3 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L8
        this.f13289a.a(r4, r3 - this.f13294f);     // Catch: Throwable -> L8
        this.f13294f = r3;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L11:
        f13288g = r0;     // Catch: Throwable -> L13
        return;
    }

    public void d() {
        if (this.f13293e == false) goto L6;
        return;
    L6:
        if (this.f13290b.getAndIncrement() != 0) goto L12;
        Logger.debug();     // Catch: Throwable -> L9
        this.f13291c.a();     // Catch: Throwable -> L9
        this.f13294f = SystemClock.elapsedRealtime();     // Catch: Throwable -> L9
        return;
    L12:
        return;
    }

    public void e() {
        if (this.f13293e == false) goto L6;
        return;
    L6:
        if (this.f13290b.decrementAndGet() != 0) goto L12;
        Logger.debug();     // Catch: Throwable -> L9
        this.f13291c.b();     // Catch: Throwable -> L9
        a();     // Catch: Throwable -> L9
        return;
    L12:
        return;
    }
}

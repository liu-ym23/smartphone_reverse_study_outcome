package d.b.h.a.a.l;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static HashMap<String, HandlerThread> f13812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static List<String> f13813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static List<String> f13814c;

    /* JADX INFO: renamed from: d.b.h.a.a.l.a$a, reason: collision with other inner class name */
    public static class HandlerThreadC0364a extends HandlerThread {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private volatile boolean f13815f;

        public HandlerThreadC0364a(String r1, int r2) {
            super(r1, r2);
            this.f13815f = false;
        }

        @Override // java.lang.Thread
        public synchronized void start() {
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L4:
            if (this.f13815f == false) goto L8;
            monitor-exit(this);
            return;
        L8:
            this.f13815f = true;     // Catch: Throwable -> L11
            super.start();     // Catch: Throwable -> L11
            monitor-exit(this);
        }
    }

    static {
        new Handler(Looper.getMainLooper());
        f13812a = new HashMap();
        f13813b = Arrays.asList(new String[]{"NpthHandlerThread", "NewVideo-HandlerThread", "trace_time_update_thread"});
        f13814c = Arrays.asList(new String[]{"DBHelper-AsyncOp-New"});
        new HashMap();
    }

    public static HandlerThread a(String r2) {
        return b(r2, 0, "");
    }

    public static HandlerThread b(String r1, int r2, String r3) {
        Iterator<Map.Entry<String, HandlerThread>> r4 = f13812a.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        if (r4.next().getValue().isAlive() == true) goto L4;
        r4.remove();
        goto L4
    L8:
        HandlerThread r5 = f13812a.get(r1);
        if (r5 != null) goto L17;
        HandlerThreadC0364a r6 = new HandlerThreadC0364a(r1, r2);
        r6.start();
        f13812a.put(r1, r6);
        return r6;
    L17:
        return r5;
    }
}

package w5;

import com.bytedance.monitor.util.thread.AsyncTaskType;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import oo.j;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements mg.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f22717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f22718b;

    public /* synthetic */ b(Object r5, int r10) {
        this.f22717a = r10;
        this.f22718b = r5;
    }

    @Override // mg.d
    public final AsyncTaskType p() {
        switch(this.f22717a) {
            case 0: goto L9;
            case 1: goto L7;
            default: goto L5;
        };
    L5:
        return AsyncTaskType.LIGHT_WEIGHT;
    L7:
        return AsyncTaskType.LIGHT_WEIGHT;
    L9:
        return AsyncTaskType.LIGHT_WEIGHT;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f22717a) {
            case 0: goto L32;
            case 1: goto L34;
            default: goto L4;
        };
    L4:
        z6.e r5 = (z6.e) this.f22718b;
        Iterator r10 = ((CopyOnWriteArraySet) r5.d).iterator();
    L6:
        if (r10.hasNext() == false) goto L8;
        ((z6.c) r10.next()).a(System.currentTimeMillis());
        goto L6
    L8:
        mg.b r11 = (mg.b) r5.f23411b;
        if (r11 == null) goto L37;
        r11.g(this, 30000);
        return;
    L37:
        return;
    L32:
        ((d) this.f22718b).i();
        return;
    L34:
        d.l((d) this.f22718b);     // Catch: Throwable -> L17
        if (((d) this.f22718b).f22721h == false) goto L21;
        if (((d) this.f22718b).s.containsKey("cpu_monitor_thread_front_capture_period") == false) goto L19;
        int r12 = ((Integer) ((d) this.f22718b).s.get("cpu_monitor_thread_front_capture_period")).intValue();     // Catch: Throwable -> L17
    L24:
        z6.e r13 = z6.b.f23409a;     // Catch: Throwable -> L17
        b r14 = ((d) this.f22718b).f22733u;     // Catch: Throwable -> L17
        long r15 = r12 * 1000;     // Catch: Throwable -> L17
        mg.b r16 = (mg.b) r13.f23411b;     // Catch: Throwable -> L17
        if (r16 == null) goto L38;
        if (r14 == null) goto L39;
        r16.g(r14, r15);     // Catch: Throwable -> L17
        return;
    L39:
        return;
    L38:
        return;
    L19:
        r12 = 5;
        goto L24
    L21:
        if (((d) this.f22718b).s.containsKey("cpu_monitor_thread_background_capture_period") == false) goto L23;
        r12 = ((Integer) ((d) this.f22718b).s.get("cpu_monitor_thread_background_capture_period")).intValue();     // Catch: Throwable -> L17
        goto L24
    L23:
        r12 = 20;
    L17:
        th = move-exception;
        j.h(th, "mUpdateThreadRecordRunnable");
    }
}

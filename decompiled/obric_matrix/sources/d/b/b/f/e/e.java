package d.b.b.f.e;

import com.bytedance.monitor.collector.k;

/* JADX INFO: loaded from: classes.dex */
public class e {
    public static double a() {
        long r0 = System.currentTimeMillis();
        long r2 = k.n().c();
        Thread.sleep(360);     // Catch: InterruptedException -> L6
    L5:
        return (((k.n().c() - r2) * 1000.0d) / (System.currentTimeMillis() - r0)) / com.bytedance.apm.util.b.j(100);
    }
}

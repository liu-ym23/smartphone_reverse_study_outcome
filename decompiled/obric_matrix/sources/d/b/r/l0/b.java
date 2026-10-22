package d.b.r.l0;

import d.b.r.y;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public interface b {
    void a(d.b.r.h0.c r1, y r2);

    boolean b(d.b.r.h0.c r1, y r2, Executor r3, Runnable r4);

    void c(d.b.r.h0.c r1);

    default d.b.r.h0.c d(d.b.r.h0.c r1) {
        return r1;
    }
}

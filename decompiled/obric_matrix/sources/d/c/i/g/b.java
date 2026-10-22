package d.c.i.g;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes2.dex */
public class b implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private c f16034a;

    public b(c r1) {
        this.f16034a = r1;
    }

    public static d.c.b.b.e b(d.c.b.b.c r1, d.c.b.b.d r2) {
        return c(r1, r2, Executors.newSingleThreadExecutor());
    }

    public static d.c.b.b.e c(d.c.b.b.c r11, d.c.b.b.d r12, Executor r13) {
        d.c.b.b.e.c r7 = new d.c.b.b.e.c(r11.m(), r11.l(), r11.h());
        return new d.c.b.b.e(r12, r11.j(), r7, r11.d(), r11.c(), r11.i(), r11.g(), r13, r11.k());
    }

    @Override // d.c.i.g.f
    public d.c.b.b.j a(d.c.b.b.c r1) {
        return b(r1, this.f16034a.a(r1));
    }
}

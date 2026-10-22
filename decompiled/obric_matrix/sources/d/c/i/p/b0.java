package d.c.i.p;

import java.io.FileInputStream;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class b0 extends a0 {
    public b0(Executor r1, d.c.c.g.i r2) {
        super(r1, r2);
    }

    @Override // d.c.i.p.a0
    protected d.c.i.l.e d(d.c.i.q.b r4) {
        return e(new FileInputStream(r4.u().toString()), (int) r4.u().length());
    }

    @Override // d.c.i.p.a0
    protected String f() {
        return "LocalFileFetchProducer";
    }
}

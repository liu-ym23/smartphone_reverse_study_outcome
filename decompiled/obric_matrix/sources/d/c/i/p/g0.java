package d.c.i.p;

import d.c.i.p.t;
import java.io.InputStream;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public interface g0<FETCH_STATE extends t> {

    public interface a {
        void a(Throwable r1);

        void b();

        void c(InputStream r1, int r2);
    }

    void a(FETCH_STATE r1, int r2);

    boolean b(FETCH_STATE r1);

    Map<String, String> c(FETCH_STATE r1, int r2);

    void d(FETCH_STATE r1, a r2);

    FETCH_STATE e(k<d.c.i.l.e> r1, l0 r2);
}

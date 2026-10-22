package d.c.b.b;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface d {

    public interface a {
        long a();

        long b();

        String getId();
    }

    public interface b {
        boolean a();

        void b(d.c.b.a.k r1, Object r2);

        d.c.a.a c(Object r1);
    }

    long a(String r1);

    void b();

    b c(String r1, Object r2);

    Collection<a> d();

    boolean e(String r1, Object r2);

    Map<String, String> f(String r1, Object r2);

    d.c.a.a g(String r1, Object r2);

    Collection<a> h();

    void i();

    boolean isExternal();

    List<a> j();

    long k(a r1);

    long remove(String r1);
}

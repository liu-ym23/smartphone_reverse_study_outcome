package d.c.i.i;

import d.c.c.d.i;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class h implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f16168a;

    static /* synthetic */ class a {
    }

    private static class b implements c {
        private b() {
        }

        /* synthetic */ b(a r1) {
            this();
        }

        @Override // d.c.i.i.h.c
        public List<Integer> a() {
            return Collections.EMPTY_LIST;
        }

        @Override // d.c.i.i.h.c
        public int b() {
            return 0;
        }
    }

    public interface c {
        List<Integer> a();

        int b();
    }

    public h() {
        this(new b(null));
    }

    public h(c r1) {
        i.g(r1);
        this.f16168a = r1;
    }

    @Override // d.c.i.i.f
    public d.c.i.l.i a(int r2) {
        if (r2 < this.f16168a.b()) goto L5;
        boolean r1 = true;
    L7:
        return d.c.i.l.g.d(r2, r1, false);
    L5:
        r1 = false;
        goto L7
    }

    @Override // d.c.i.i.f
    public int b(int r3) {
        List<Integer> r2 = this.f16168a.a();
        if (r2 == null) goto L18;
        if (r2.isEmpty() == true) goto L18;
        int r0 = 0;
    L9:
        if (r0 >= r2.size()) goto L15;
        if (r2.get(r0).intValue() > r3) goto L13;
        r0 = r0 + 1;
        goto L9
    L13:
        return r2.get(r0).intValue();
    L15:
        return Integer.MAX_VALUE;
    L18:
        return r3 + 1;
    }
}

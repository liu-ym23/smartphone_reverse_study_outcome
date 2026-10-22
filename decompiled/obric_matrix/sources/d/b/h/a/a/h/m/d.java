package d.b.h.a.a.h.m;

import java.net.URI;

/* JADX INFO: loaded from: classes.dex */
public interface d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f13429a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f13430b = null;

    class a implements d {
        a() {
        }

        @Override // d.b.h.a.a.h.m.d
        public boolean a(URI r1, g r2) {
            return true;
        }
    }

    class b implements d {
        b() {
        }

        @Override // d.b.h.a.a.h.m.d
        public boolean a(URI r1, g r2) {
            return g.v(r2.y(), r1.getHost());
        }
    }

    static {
        f13429a = new a();
        f13430b = new b();
    }

    boolean a(URI r1, g r2);
}

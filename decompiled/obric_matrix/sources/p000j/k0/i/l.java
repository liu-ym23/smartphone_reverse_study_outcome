package p000j.k0.i;

import java.util.List;
import k.g;

/* JADX INFO: loaded from: classes2.dex */
public interface l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f18074a = null;

    static class a implements l {
        a() {
        }

        @Override // p000j.k0.i.l
        public boolean a(int r1, List<c> r2) {
            return true;
        }

        @Override // p000j.k0.i.l
        public boolean b(int r1, List<c> r2, boolean r3) {
            return true;
        }

        @Override // p000j.k0.i.l
        public void c(int r1, b r2) {
        }

        @Override // p000j.k0.i.l
        public boolean d(int r1, g r2, int r3, boolean r4) {
            r2.skip(r3);
            return true;
        }
    }

    static {
        f18074a = new a();
    }

    boolean a(int r1, List<c> r2);

    boolean b(int r1, List<c> r2, boolean r3);

    void c(int r1, b r2);

    boolean d(int r1, g r2, int r3, boolean r4);
}

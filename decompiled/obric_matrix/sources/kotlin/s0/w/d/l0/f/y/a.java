package kotlin.s0.w.d.l0.f.y;

import java.io.DataInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.i0.j0;
import kotlin.i0.r;
import kotlin.n0.d.g;
import kotlin.n0.d.o;
import kotlin.r0.d;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends kotlin.s0.w.d.l0.f.z.a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final C0548a f20210f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f20211g = null;

    /* JADX INFO: renamed from: kotlin.s0.w.d.l0.f.y.a$a, reason: collision with other inner class name */
    public static final class C0548a {
        private C0548a() {
        }

        public /* synthetic */ C0548a(g r1) {
            this();
        }

        public final a a(InputStream r3) {
            o.f(r3, "stream");
            DataInputStream r2 = new DataInputStream(r3);
            d r4 = new d(1, r2.readInt());
            ArrayList r0 = new ArrayList(r.q(r4, 10));
            Iterator<Integer> r5 = r4.iterator();
        L4:
            if (r5.hasNext() == false) goto L6;
            ((j0) r5).nextInt();
            r0.add(Integer.valueOf(r2.readInt()));
            goto L4
        L6:
            int[] r6 = r.y0(r0);
            return new a(Arrays.copyOf(r6, r6.length));
        }
    }

    static {
        f20210f = new C0548a(null);
        f20211g = new a(new int[]{1, 0, 7});
        new a(new int[0]);
    }

    public a(int... r2) {
        o.f(r2, "numbers");
        super(Arrays.copyOf(r2, r2.length));
    }

    public boolean h() {
        return f(f20211g);
    }
}

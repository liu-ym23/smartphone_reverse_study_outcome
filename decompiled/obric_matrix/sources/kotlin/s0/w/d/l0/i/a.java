package kotlin.s0.w.d.l0.i;

import java.io.FilterInputStream;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements q {

    /* JADX INFO: renamed from: kotlin.s0.w.d.l0.i.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0550a<BuilderType extends AbstractC0550a> implements q.a {

        /* JADX INFO: renamed from: kotlin.s0.w.d.l0.i.a$a$a, reason: collision with other inner class name */
        static final class C0551a extends FilterInputStream {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private int f20299f;

            C0551a(InputStream r1, int r2) {
                super(r1);
                this.f20299f = r2;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int available() {
                return Math.min(super.available(), this.f20299f);
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read() {
                if (this.f20299f > 0) goto L6;
                return -1;
            L6:
                int r0 = super.read();
                if (r0 < 0) goto L9;
                this.f20299f--;
            L9:
                return r0;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public int read(byte[] r2, int r3, int r4) {
                int r0 = this.f20299f;
                if (r0 > 0) goto L6;
                return -1;
            L6:
                int r5 = super.read(r2, r3, Math.min(r4, r0));
                if (r5 < 0) goto L9;
                this.f20299f -= r5;
            L9:
                return r5;
            }

            @Override // java.io.FilterInputStream, java.io.InputStream
            public long skip(long r3) {
                long r4 = super.skip(Math.min(r3, this.f20299f));
                if (r4 < 0) goto L5;
                this.f20299f = (int) (((long) this.f20299f) - r4);
            L5:
                return r4;
            }
        }

        public AbstractC0550a() {
        }

        protected static w j(q r1) {
            return new w(r1);
        }

        public abstract BuilderType i(e r1, g r2);

        @Override // kotlin.s0.w.d.l0.i.q.a
        public /* bridge */ /* synthetic */ q.a x(e r1, g r2) {
            return i(r1, r2);
        }
    }

    public a() {
    }

    w b() {
        return new w(this);
    }

    public void g(OutputStream r3) {
        int r0 = e();
        f r4 = f.J(r3, f.u(f.v(r0) + r0));
        r4.o0(r0);
        d(r4);
        r4.I();
    }
}

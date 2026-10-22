package kotlin.s0.w.d.l0.i;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d implements Iterable<Byte> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final d f20305f = null;

    public interface a extends Iterator<Byte> {
        byte a();
    }

    public static final class b extends OutputStream {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private static final byte[] f20306k = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f20307f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final ArrayList<d> f20308g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f20309h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private byte[] f20310i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f20311j;

        static {
            f20306k = new byte[0];
        }

        b(int r2) {
            if (r2 < 0) goto L7;
            this.f20307f = r2;
            this.f20308g = new ArrayList();
            this.f20310i = new byte[r2];
            return;
        L7:
            throw new IllegalArgumentException("Buffer size < 0");
        }

        private byte[] a(byte[] r2, int r3) {
            byte[] r1 = new byte[r3];
            System.arraycopy(r2, 0, r1, 0, Math.min(r2.length, r3));
            return r1;
        }

        private void b(int r4) {
            this.f20308g.add(new p(this.f20310i));
            int r0 = this.f20309h + this.f20310i.length;
            this.f20309h = r0;
            this.f20310i = new byte[Math.max(this.f20307f, Math.max(r4, r0 >>> 1))];
            this.f20311j = 0;
        }

        private void g() {
            int r0 = this.f20311j;
            byte[] r1 = this.f20310i;
            if (r0 >= r1.length) goto L6;
            if (r0 <= 0) goto L7;
            this.f20308g.add(new p(a(r1, r0)));
        L7:
            this.f20309h += this.f20311j;
            this.f20311j = 0;
            return;
        L6:
            this.f20308g.add(new p(this.f20310i));
            this.f20310i = f20306k;
            goto L7
        }

        public synchronized d l() {
            monitor-enter(this);
            g();     // Catch: Throwable -> L6
            d r0 = d.c(this.f20308g);     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        public synchronized int size() {
            monitor-enter(this);
            int r0 = this.f20309h + this.f20311j;
            monitor-exit(this);
            return r0;
        L7:
            th = move-exception;
            throw th;
        }

        public String toString() {
            return String.format("<ByteString.Output@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())});
        }

        @Override // java.io.OutputStream
        public synchronized void write(int r4) {
            monitor-enter(this);
        L9:
            th = move-exception;
            throw th;
        L4:
            if (this.f20311j != this.f20310i.length) goto L6;
            b(1);     // Catch: Throwable -> L9
        L6:
            byte[] r0 = this.f20310i;     // Catch: Throwable -> L9
            int r1 = this.f20311j;     // Catch: Throwable -> L9
            this.f20311j = r1 + 1;     // Catch: Throwable -> L9
            r0[r1] = (byte) r4;     // Catch: Throwable -> L9
            monitor-exit(this);
        }

        @Override // java.io.OutputStream
        public synchronized void write(byte[] r4, int r5, int r6) {
            monitor-enter(this);
            byte[] r0 = this.f20310i;     // Catch: Throwable -> L9
            int r1 = r0.length;     // Catch: Throwable -> L9
            int r2 = this.f20311j;     // Catch: Throwable -> L9
            if (r6 > (r1 - r2)) goto L6;
            System.arraycopy(r4, r5, r0, r2, r6);     // Catch: Throwable -> L9
            this.f20311j += r6;     // Catch: Throwable -> L9
        L7:
            monitor-exit(this);
            return;
        L6:
            int r3 = r0.length - r2;     // Catch: Throwable -> L9
            System.arraycopy(r4, r5, r0, r2, r3);     // Catch: Throwable -> L9
            int r7 = r6 - r3;     // Catch: Throwable -> L9
            b(r7);     // Catch: Throwable -> L9
            System.arraycopy(r4, r5 + r3, this.f20310i, 0, r7);     // Catch: Throwable -> L9
            this.f20311j = r7;     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            throw th;
        }
    }

    static {
        f20305f = new p(new byte[0]);
    }

    d() {
    }

    private static d a(Iterator<d> r2, int r3) {
        if (r3 == 1) goto L7;
        int r0 = r3 >>> 1;
        return a(r2, r0).b(a(r2, r3 - r0));
    L7:
        return r2.next();
    }

    public static d c(Iterable<d> r2) {
        if ((r2 instanceof Collection) == true) goto L8;
        Collection r0 = new ArrayList();
        Iterator<d> r3 = r2.iterator();
    L6:
        if (r3.hasNext() == false) goto L10;
        r0.add(r3.next());
    L10:
        if (r0.isEmpty() == false) goto L13;
        return f20305f;
    L13:
        return a(r0.iterator(), r0.size());
    L8:
        r0 = (Collection) r2;
        goto L10
    }

    public static d d(byte[] r2) {
        return g(r2, 0, r2.length);
    }

    public static d g(byte[] r2, int r3, int r4) {
        byte[] r0 = new byte[r4];
        System.arraycopy(r2, r3, r0, 0, r4);
        return new p(r0);
    }

    public static d l(String r2) {
        return new p(r2.getBytes("UTF-8"));
    L4:
        e = move-exception;
        throw new RuntimeException("UTF-8 not supported?", e);
    }

    public static b t() {
        return new b(128);
    }

    void A(OutputStream r3, int r4, int r5) {
        if (r4 < 0) goto L13;
        if (r5 < 0) goto L11;
        int r0 = r4 + r5;
        if (r0 > size()) goto L9;
        if (r5 <= 0) goto L15;
        B(r3, r4, r5);
        return;
    L15:
        return;
    L9:
        StringBuilder r6 = new StringBuilder(39);
        r6.append("Source end offset exceeded: ");
        r6.append(r0);
        throw new IndexOutOfBoundsException(r6.toString());
    L11:
        StringBuilder r7 = new StringBuilder(23);
        r7.append("Length < 0: ");
        r7.append(r5);
        throw new IndexOutOfBoundsException(r7.toString());
    L13:
        StringBuilder r8 = new StringBuilder(30);
        r8.append("Source offset < 0: ");
        r8.append(r4);
        throw new IndexOutOfBoundsException(r8.toString());
    }

    abstract void B(OutputStream r1, int r2, int r3);

    public d b(d r7) {
        int r0 = size();
        int r1 = r7.size();
        if ((((long) r0) + ((long) r1)) < 2147483647L) goto L5;
        StringBuilder r8 = new StringBuilder(53);
        r8.append("ByteString would be too long: ");
        r8.append(r0);
        r8.append("+");
        r8.append(r1);
        throw new IllegalArgumentException(r8.toString());
    L5:
        return u.F(this, r7);
    }

    public boolean isEmpty() {
        if (size() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator<Byte> iterator() {
        return r();
    }

    public void m(byte[] r4, int r5, int r6, int r7) {
        if (r5 < 0) goto L21;
        if (r6 < 0) goto L19;
        if (r7 < 0) goto L17;
        int r0 = r5 + r7;
        if (r0 > size()) goto L15;
        int r1 = r6 + r7;
        if (r1 > r4.length) goto L13;
        if (r7 <= 0) goto L23;
        n(r4, r5, r6, r7);
        return;
    L23:
        return;
    L13:
        StringBuilder r8 = new StringBuilder(34);
        r8.append("Target end offset < 0: ");
        r8.append(r1);
        throw new IndexOutOfBoundsException(r8.toString());
    L15:
        StringBuilder r9 = new StringBuilder(34);
        r9.append("Source end offset < 0: ");
        r9.append(r0);
        throw new IndexOutOfBoundsException(r9.toString());
    L17:
        StringBuilder r10 = new StringBuilder(23);
        r10.append("Length < 0: ");
        r10.append(r7);
        throw new IndexOutOfBoundsException(r10.toString());
    L19:
        StringBuilder r11 = new StringBuilder(30);
        r11.append("Target offset < 0: ");
        r11.append(r6);
        throw new IndexOutOfBoundsException(r11.toString());
    L21:
        StringBuilder r12 = new StringBuilder(30);
        r12.append("Source offset < 0: ");
        r12.append(r5);
        throw new IndexOutOfBoundsException(r12.toString());
    }

    protected abstract void n(byte[] r1, int r2, int r3, int r4);

    protected abstract int o();

    protected abstract boolean p();

    public abstract boolean q();

    public abstract a r();

    public abstract e s();

    public abstract int size();

    public String toString() {
        return String.format("<ByteString@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())});
    }

    protected abstract int u(int r1, int r2, int r3);

    protected abstract int v(int r1, int r2, int r3);

    protected abstract int w();

    public byte[] x() {
        int r0 = size();
        if (r0 == 0) goto L5;
        byte[] r1 = new byte[r0];
        n(r1, 0, 0, r0);
        return r1;
    L5:
        return j.f20358a;
    }

    public abstract String y(String r1);

    public String z() {
        return y("UTF-8");
    L4:
        e = move-exception;
        throw new RuntimeException("UTF-8 not supported?", e);
    }
}

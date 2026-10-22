package com.google.gson.internal.bind;

import com.google.gson.a0.d;
import com.google.gson.g;
import com.google.gson.j;
import com.google.gson.l;
import com.google.gson.m;
import com.google.gson.p;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends com.google.gson.a0.a {
    private static final Reader y = null;
    private static final Object z = null;
    private Object[] u;
    private int v;
    private String[] w;
    private int[] x;

    /* JADX INFO: renamed from: com.google.gson.internal.bind.a$a, reason: collision with other inner class name */
    class C0211a extends Reader {
        C0211a() {
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }

        @Override // java.io.Reader
        public int read(char[] r1, int r2, int r3) {
            throw new AssertionError();
        }
    }

    static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7023a = null;

        static {
            int[] r0 = new int[com.google.gson.a0.b.values().length];
            f7023a = r0;
            r0[com.google.gson.a0.b.f6873j.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f7023a[com.google.gson.a0.b.f6870g.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f7023a[com.google.gson.a0.b.f6872i.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f7023a[com.google.gson.a0.b.o.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    static {
        y = new C0211a();
        z = new Object();
    }

    public a(j r3) {
        super(y);
        this.u = new Object[32];
        this.v = 0;
        this.w = new String[32];
        this.x = new int[32];
        C0(r3);
    }

    private Object A0() {
        Object[] r0 = this.u;
        int r1 = this.v - 1;
        this.v = r1;
        Object r3 = r0[r1];
        r0[r1] = null;
        return r3;
    }

    private void C0(Object r4) {
        int r0 = this.v;
        Object[] r1 = this.u;
        if (r0 != r1.length) goto L5;
        int r2 = r0 * 2;
        this.u = Arrays.copyOf(r1, r2);
        this.x = Arrays.copyOf(this.x, r2);
        this.w = (String[]) Arrays.copyOf(this.w, r2);
    L5:
        Object[] r3 = this.u;
        int r5 = this.v;
        this.v = r5 + 1;
        r3[r5] = r4;
    }

    private String E(boolean r6) {
        StringBuilder r0 = new StringBuilder();
        r0.append('$');
        int r1 = 0;
    L3:
        int r2 = this.v;
        if (r1 >= r2) goto L31;
        Object[] r3 = this.u;
        if ((r3[r1] instanceof g) == false) goto L21;
        r1 = r1 + 1;
        if (r1 >= r2) goto L29;
        if ((r3[r1] instanceof Iterator) == false) goto L29;
        int r4 = this.x[r1];
        if (r6 == false) goto L19;
        if (r4 <= 0) goto L19;
        if (r1 != (r2 - 1)) goto L17;
    L18:
        r4 = r4 - 1;
        goto L19
    L17:
        if (r1 == (r2 - 2)) goto L18;
    L19:
        r0.append('[');
        r0.append(r4);
        r0.append(']');
    L29:
        r1 = r1 + 1;
        goto L3
    L21:
        if ((r3[r1] instanceof m) == false) goto L29;
        r1 = r1 + 1;
        if (r1 >= r2) goto L29;
        if ((r3[r1] instanceof Iterator) == false) goto L29;
        r0.append('.');
        String[] r5 = this.w;
        if (r5[r1] == null) goto L29;
        r0.append(r5[r1]);
        goto L29
    L31:
        return r0.toString();
    }

    private String O() {
        return " at path " + getPath();
    }

    private void w0(com.google.gson.a0.b r4) {
        if (k0() != r4) goto L6;
        return;
    L6:
        throw new IllegalStateException("Expected " + r4 + " but was " + k0() + O());
    }

    private String y0(boolean r5) {
        w0(com.google.gson.a0.b.f6873j);
        Map.Entry r0 = (Map.Entry) ((Iterator) z0()).next();
        String r1 = (String) r0.getKey();
        String[] r2 = this.w;
        int r3 = this.v - 1;
        if (r5 == false) goto L5;
        String r6 = "<skipped>";
    L6:
        r2[r3] = r6;
        C0(r0.getValue());
        return r1;
    L5:
        r6 = r1;
        goto L6
    }

    private Object z0() {
        return this.u[this.v - 1];
    }

    @Override // com.google.gson.a0.a
    public void A() {
        w0(com.google.gson.a0.b.f6872i);
        this.w[this.v - 1] = null;
        A0();
        A0();
        int r0 = this.v;
        if (r0 <= 0) goto L6;
        int[] r3 = this.x;
        int r1 = r0 - 1;
        r3[r1] = r3[r1] + 1;
        return;
    }

    public void B0() {
        w0(com.google.gson.a0.b.f6873j);
        Map.Entry r0 = (Map.Entry) ((Iterator) z0()).next();
        C0(r0.getValue());
        C0(new p((String) r0.getKey()));
    }

    @Override // com.google.gson.a0.a
    public String F() {
        return E(true);
    }

    @Override // com.google.gson.a0.a
    public boolean L() {
        com.google.gson.a0.b r1 = k0();
        if (r1 != com.google.gson.a0.b.f6872i) goto L5;
    L9:
        return false;
    L5:
        if (r1 == com.google.gson.a0.b.f6870g) goto L9;
        if (r1 == com.google.gson.a0.b.o) goto L9;
        return true;
    }

    @Override // com.google.gson.a0.a
    public boolean Q() {
        w0(com.google.gson.a0.b.m);
        boolean r0 = ((p) A0()).q();
        int r1 = this.v;
        if (r1 <= 0) goto L5;
        int[] r3 = this.x;
        int r2 = r1 - 1;
        r3[r2] = r3[r2] + 1;
    L5:
        return r0;
    }

    @Override // com.google.gson.a0.a
    public double S() {
        com.google.gson.a0.b r0 = k0();
        com.google.gson.a0.b r1 = com.google.gson.a0.b.f6875l;
        if (r0 != r1) goto L5;
    L9:
        double r2 = ((p) z0()).r();
        if (M() == false) goto L12;
    L18:
        A0();
        int r3 = this.v;
        if (r3 <= 0) goto L21;
        int[] r5 = this.x;
        int r4 = r3 - 1;
        r5[r4] = r5[r4] + 1;
    L21:
        return r2;
    L12:
        if (Double.isNaN(r2) == true) goto L17;
        if (Double.isInfinite(r2) == false) goto L18;
    L17:
        throw new d("JSON forbids NaN and infinities: " + r2);
    L5:
        if (r0 == com.google.gson.a0.b.f6874k) goto L9;
        throw new IllegalStateException("Expected " + r1 + " but was " + r0 + O());
    }

    @Override // com.google.gson.a0.a
    public int V() {
        com.google.gson.a0.b r0 = k0();
        com.google.gson.a0.b r1 = com.google.gson.a0.b.f6875l;
        if (r0 != r1) goto L5;
    L9:
        int r2 = ((p) z0()).a();
        A0();
        int r3 = this.v;
        if (r3 <= 0) goto L12;
        int[] r5 = this.x;
        int r4 = r3 - 1;
        r5[r4] = r5[r4] + 1;
    L12:
        return r2;
    L5:
        if (r0 == com.google.gson.a0.b.f6874k) goto L9;
        throw new IllegalStateException("Expected " + r1 + " but was " + r0 + O());
    }

    @Override // com.google.gson.a0.a
    public long X() {
        com.google.gson.a0.b r0 = k0();
        com.google.gson.a0.b r1 = com.google.gson.a0.b.f6875l;
        if (r0 != r1) goto L5;
    L9:
        long r2 = ((p) z0()).g();
        A0();
        int r3 = this.v;
        if (r3 <= 0) goto L12;
        int[] r5 = this.x;
        int r4 = r3 - 1;
        r5[r4] = r5[r4] + 1;
    L12:
        return r2;
    L5:
        if (r0 == com.google.gson.a0.b.f6874k) goto L9;
        throw new IllegalStateException("Expected " + r1 + " but was " + r0 + O());
    }

    @Override // com.google.gson.a0.a
    public String Y() {
        return y0(false);
    }

    @Override // com.google.gson.a0.a
    public void a() {
        w0(com.google.gson.a0.b.f6869f);
        C0(((g) z0()).iterator());
        this.x[this.v - 1] = 0;
    }

    @Override // com.google.gson.a0.a
    public void b() {
        w0(com.google.gson.a0.b.f6871h);
        C0(((m) z0()).u().iterator());
    }

    @Override // com.google.gson.a0.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.u = new Object[]{z};
        this.v = 1;
    }

    @Override // com.google.gson.a0.a
    public void g0() {
        w0(com.google.gson.a0.b.n);
        A0();
        int r0 = this.v;
        if (r0 <= 0) goto L6;
        int[] r2 = this.x;
        int r1 = r0 - 1;
        r2[r1] = r2[r1] + 1;
        return;
    }

    @Override // com.google.gson.a0.a
    public String getPath() {
        return E(false);
    }

    @Override // com.google.gson.a0.a
    public String i0() {
        com.google.gson.a0.b r0 = k0();
        com.google.gson.a0.b r1 = com.google.gson.a0.b.f6874k;
        if (r0 != r1) goto L5;
    L9:
        String r2 = ((p) A0()).l();
        int r3 = this.v;
        if (r3 <= 0) goto L12;
        int[] r5 = this.x;
        int r4 = r3 - 1;
        r5[r4] = r5[r4] + 1;
    L12:
        return r2;
    L5:
        if (r0 == com.google.gson.a0.b.f6875l) goto L9;
        throw new IllegalStateException("Expected " + r1 + " but was " + r0 + O());
    }

    @Override // com.google.gson.a0.a
    public com.google.gson.a0.b k0() {
        if (this.v == 0) goto L5;
        Object r0 = z0();
        if ((r0 instanceof Iterator) == false) goto L20;
        boolean r1 = this.u[this.v - 2] instanceof m;
        Iterator r2 = (Iterator) r0;
        if (r2.hasNext() == false) goto L15;
        if (r1 == true) goto L12;
        C0(r2.next());
        return k0();
    L12:
        return com.google.gson.a0.b.f6873j;
    L15:
        if (r1 == false) goto L18;
        return com.google.gson.a0.b.f6872i;
    L18:
        return com.google.gson.a0.b.f6870g;
    L20:
        if ((r0 instanceof m) == false) goto L24;
        return com.google.gson.a0.b.f6871h;
    L24:
        if ((r0 instanceof g) == false) goto L28;
        return com.google.gson.a0.b.f6869f;
    L28:
        if ((r0 instanceof p) == false) goto L44;
        p r3 = (p) r0;
        if (r3.x() == false) goto L34;
        return com.google.gson.a0.b.f6874k;
    L34:
        if (r3.u() == false) goto L38;
        return com.google.gson.a0.b.m;
    L38:
        if (r3.w() == false) goto L42;
        return com.google.gson.a0.b.f6875l;
    L42:
        throw new AssertionError();
    L44:
        if ((r0 instanceof l) == false) goto L48;
        return com.google.gson.a0.b.n;
    L48:
        if (r0 != z) goto L52;
        throw new IllegalStateException("JsonReader is closed");
    L52:
        throw new d("Custom JsonElement subclass " + r0.getClass().getName() + " is not supported");
    L5:
        return com.google.gson.a0.b.o;
    }

    @Override // com.google.gson.a0.a
    public String toString() {
        return a.class.getSimpleName() + O();
    }

    @Override // com.google.gson.a0.a
    public void u0() {
        com.google.gson.a0.b r0 = k0();
        int r1 = b.f7023a[r0.ordinal()];
        if (r1 != 1) goto L5;
        y0(true);
        return;
    L5:
        if (r1 != 2) goto L7;
        x();
        return;
    L7:
        if (r1 != 3) goto L9;
        A();
        return;
    L9:
        if (r1 == 4) goto L17;
        A0();
        int r2 = this.v;
        if (r2 <= 0) goto L18;
        int[] r3 = this.x;
        int r4 = r2 - 1;
        r3[r4] = r3[r4] + 1;
        return;
    L18:
        return;
    }

    @Override // com.google.gson.a0.a
    public void x() {
        w0(com.google.gson.a0.b.f6870g);
        A0();
        A0();
        int r0 = this.v;
        if (r0 <= 0) goto L6;
        int[] r2 = this.x;
        int r1 = r0 - 1;
        r2[r1] = r2[r1] + 1;
        return;
    }

    j x0() {
        com.google.gson.a0.b r0 = k0();
        if (r0 == com.google.gson.a0.b.f6873j) goto L13;
        if (r0 == com.google.gson.a0.b.f6870g) goto L13;
        if (r0 == com.google.gson.a0.b.f6872i) goto L13;
        if (r0 == com.google.gson.a0.b.o) goto L13;
        j r1 = (j) z0();
        u0();
        return r1;
    L13:
        throw new IllegalStateException("Unexpected " + r0 + " when reading a JsonElement.");
    }
}

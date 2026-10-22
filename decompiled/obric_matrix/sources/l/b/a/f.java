package l.b.a;

import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final e[] f21555d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private e[] f21556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f21557b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f21558c;

    static {
        f21555d = new e[0];
    }

    public f() {
        this(10);
    }

    public f(int r1) {
        if (r1 < 0) goto L10;
        if (r1 != 0) goto L6;
        e[] r2 = f21555d;
    L7:
        this.f21556a = r2;
        this.f21557b = 0;
        this.f21558c = false;
        return;
    L6:
        r2 = new e[r1];
        goto L7
    L10:
        throw new IllegalArgumentException("'initialCapacity' must not be negative");
    }

    static e[] b(e[] r2) {
        if (r2.length >= 1) goto L6;
        return f21555d;
    L6:
        return (e[]) r2.clone();
    }

    private void e(int r4) {
        e[] r5 = new e[Math.max(this.f21556a.length, r4 + (r4 >> 1))];
        System.arraycopy(this.f21556a, 0, r5, 0, this.f21557b);
        this.f21556a = r5;
        this.f21558c = false;
    }

    public void a(e r4) {
        Objects.requireNonNull(r4, "'element' cannot be null");
        int r0 = this.f21556a.length;
        boolean r2 = true;
        int r1 = this.f21557b + 1;
        if (r1 > r0) goto L7;
        r2 = false;
    L7:
        if ((this.f21558c | r2) == false) goto L9;
        e(r1);
    L9:
        this.f21556a[this.f21557b] = r4;
        this.f21557b = r1;
    }

    e[] c() {
        int r0 = this.f21557b;
        if (r0 == 0) goto L5;
        e[] r1 = new e[r0];
        System.arraycopy(this.f21556a, 0, r1, 0, r0);
        return r1;
    L5:
        return f21555d;
    }

    public e d(int r3) {
        if (r3 >= this.f21557b) goto L7;
        return this.f21556a[r3];
    L7:
        throw new ArrayIndexOutOfBoundsException(r3 + " >= " + this.f21557b);
    }

    public int f() {
        return this.f21557b;
    }

    e[] g() {
        int r0 = this.f21557b;
        if (r0 == 0) goto L5;
        e[] r1 = this.f21556a;
        if (r1.length != r0) goto L10;
        this.f21558c = true;
        return r1;
    L10:
        e[] r3 = new e[r0];
        System.arraycopy(r1, 0, r3, 0, r0);
        return r3;
    L5:
        return f21555d;
    }
}

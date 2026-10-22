package d.c.h;

import d.c.c.d.g;
import d.c.c.d.i;

/* JADX INFO: loaded from: classes.dex */
public class b implements d.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final byte[] f15807b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f15808c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final byte[] f15809d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f15810e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final byte[] f15811f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final byte[] f15812g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final byte[] f15813h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f15814i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final byte[] f15815j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f15816k = 0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final String[] f15817l = null;
    private static final int m = 0;
    private static final byte[] n = null;
    private static final byte[] o = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f15818a;

    static {
        byte[] r0 = {-1, -40, -1};
        f15807b = r0;
        f15808c = r0.length;
        byte[] r1 = {-119, 80, 78, 71, 13, 10, 26, 10};
        f15809d = r1;
        f15810e = r1.length;
        f15811f = f.a("GIF87a");
        f15812g = f.a("GIF89a");
        byte[] r2 = f.a("BM");
        f15813h = r2;
        f15814i = r2.length;
        byte[] r3 = {0, 0, 1, 0};
        f15815j = r3;
        f15816k = r3.length;
        String[] r4 = {"heic", "heix", "hevc", "hevx", "mif1", "msf1"};
        f15817l = r4;
        m = f.a("ftyp" + r4[0]).length;
        n = new byte[]{73, 73, 42, 0};
        o = new byte[]{77, 77, 0, 42};
    }

    public b() {
        this.f15818a = g.a(new int[]{21, 20, f15808c, f15810e, 6, f15814i, f15816k, m});
    }

    private static d c(byte[] r2, int r3) {
        i.b(d.c.c.l.c.h(r2, 0, r3));
        if (d.c.c.l.c.g(r2, 0) == false) goto L7;
        return c.f15824f;
    L7:
        if (d.c.c.l.c.f(r2, 0) == false) goto L11;
        return c.f15825g;
    L11:
        if (d.c.c.l.c.c(r2, 0, r3) == false) goto L23;
        if (d.c.c.l.c.b(r2, 0) == false) goto L17;
        return c.f15828j;
    L17:
        if (d.c.c.l.c.d(r2, 0) == false) goto L21;
        return c.f15827i;
    L21:
        return c.f15826h;
    L23:
        return d.f15831b;
    }

    private static boolean d(byte[] r2, int r3) {
        byte[] r0 = f15813h;
        if (r3 >= r0.length) goto L7;
        return false;
    L7:
        return f.c(r2, r0);
    }

    private static boolean e(byte[] r3, int r4) {
        byte[] r0 = n;
        if (r4 >= r0.length) goto L8;
        if (r4 >= o.length) goto L8;
        return false;
    L8:
        if (f.c(r3, r0) == false) goto L10;
    L11:
        return true;
    L10:
        if (f.c(r3, o) == true) goto L11;
        return false;
    }

    private static boolean f(byte[] r2, int r3) {
        if (r3 >= 6) goto L6;
        return false;
    L6:
        if (f.c(r2, f15811f) == false) goto L8;
    L9:
        return true;
    L8:
        if (f.c(r2, f15812g) == true) goto L9;
        return false;
    }

    private static boolean g(byte[] r7, int r8) {
        if (r8 >= m) goto L6;
        return false;
    L6:
        if (r7[3] >= 8) goto L8;
        return false;
    L8:
        String[] r9 = f15817l;
        int r0 = r9.length;
        int r2 = 0;
    L9:
        if (r2 >= r0) goto L15;
        String r3 = r9[r2];
        if (f.b(r7, r7.length, f.a("ftyp" + r3), m) > (-1)) goto L12;
        r2 = r2 + 1;
        goto L9
    L12:
        return true;
    L15:
        return false;
    }

    private static boolean h(byte[] r2, int r3) {
        byte[] r0 = f15815j;
        if (r3 >= r0.length) goto L7;
        return false;
    L7:
        return f.c(r2, r0);
    }

    private static boolean i(byte[] r2, int r3) {
        byte[] r0 = f15807b;
        if (r3 >= r0.length) goto L5;
    L7:
        return false;
    L5:
        if (f.c(r2, r0) == false) goto L7;
        return true;
    }

    private static boolean j(byte[] r2, int r3) {
        byte[] r0 = f15809d;
        if (r3 >= r0.length) goto L5;
    L7:
        return false;
    L5:
        if (f.c(r2, r0) == false) goto L7;
        return true;
    }

    @Override // d.c.h.d.a
    public int a() {
        return this.f15818a;
    }

    @Override // d.c.h.d.a
    public final d b(byte[] r1, int r2) {
        i.g(r1);
        if (d.c.c.l.c.h(r1, 0, r2) == false) goto L7;
        return c(r1, r2);
    L7:
        if (i(r1, r2) == false) goto L11;
        return c.f15819a;
    L11:
        if (j(r1, r2) == false) goto L15;
        return c.f15820b;
    L15:
        if (f(r1, r2) == false) goto L19;
        return c.f15821c;
    L19:
        if (d(r1, r2) == false) goto L23;
        return c.f15822d;
    L23:
        if (h(r1, r2) == false) goto L27;
        return c.f15823e;
    L27:
        if (g(r1, r2) == false) goto L31;
        return c.f15829k;
    L31:
        if (e(r1, r2) == false) goto L35;
        return c.m;
    L35:
        return d.f15831b;
    }
}

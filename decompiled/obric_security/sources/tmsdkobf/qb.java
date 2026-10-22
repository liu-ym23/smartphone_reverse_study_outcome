package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* JADX INFO: loaded from: classes5.dex */
public final class qb extends JceStruct {
    static byte[] r;
    static byte[] s;
    static ze t;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f440a;
    public int b;
    public int c;
    public int d;
    public int e;
    public byte[] f;
    public int g;
    public int h;
    public long i;
    public byte[] j;
    public int k;
    public int l;
    public ze m;
    public g8 n;
    public uf o;
    public a p;
    public String q;

    static {
        r = new byte[]{0};
        s = new byte[]{0};
        t = new ze();
    }

    public qb() {
        this.f440a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = null;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = null;
        this.k = 0;
        this.l = 0;
        this.m = null;
        this.o = null;
        this.p = null;
        this.q = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r5) {
        this.f440a = r5.read(this.f440a, 0, false);
        this.b = r5.read(this.b, 1, false);
        this.c = r5.read(this.c, 2, false);
        this.d = r5.read(this.d, 3, false);
        this.e = r5.read(this.e, 4, false);
        this.f = r5.read(r, 5, false);
        this.g = r5.read(this.g, 6, false);
        this.h = r5.read(this.h, 7, false);
        this.i = r5.read(this.i, 8, false);
        this.j = r5.read(s, 9, false);
        this.k = r5.read(this.k, 10, false);
        this.l = r5.read(this.l, 11, false);
        this.m = (ze) r5.read(t, 12, false);
        this.n = (g8) r5.read(this.n, 16, false);
        this.o = (uf) r5.read(this.o, 17, false);
        this.p = (a) r5.read(this.p, 18, false);
        this.q = r5.read(this.q, 19, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r5) {
        int r0 = this.f440a;
        if (r0 == 0) goto L5;
        r5.write(r0, 0);
    L5:
        r5.write(this.b, 1);
        r5.write(this.c, 2);
        int r1 = this.d;
        if (r1 == 0) goto L8;
        r5.write(r1, 3);
    L8:
        int r2 = this.e;
        if (r2 == 0) goto L11;
        r5.write(r2, 4);
    L11:
        byte[] r3 = this.f;
        if (r3 == null) goto L14;
        r5.write(r3, 5);
    L14:
        int r4 = this.g;
        if (r4 == 0) goto L17;
        r5.write(r4, 6);
    L17:
        int r6 = this.h;
        if (r6 == 0) goto L20;
        r5.write(r6, 7);
    L20:
        long r7 = this.i;
        if (r7 == 0) goto L23;
        r5.write(r7, 8);
    L23:
        byte[] r8 = this.j;
        if (r8 == null) goto L26;
        r5.write(r8, 9);
    L26:
        int r9 = this.k;
        if (r9 == 0) goto L29;
        r5.write(r9, 10);
    L29:
        int r10 = this.l;
        if (r10 == 0) goto L32;
        r5.write(r10, 11);
    L32:
        ze r11 = this.m;
        if (r11 == null) goto L35;
        r5.write(r11, 12);
    L35:
        g8 r12 = this.n;
        if (r12 == null) goto L38;
        r5.write(r12, 16);
    L38:
        uf r13 = this.o;
        if (r13 == null) goto L41;
        r5.write(r13, 17);
    L41:
        a r14 = this.p;
        if (r14 == null) goto L44;
        r5.write(r14, 18);
    L44:
        String r15 = this.q;
        if (r15 == null) goto L48;
        r5.write(r15, 19);
        return;
    }
}

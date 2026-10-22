package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* JADX INFO: loaded from: classes5.dex */
public final class a3 extends JceStruct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f85a;
    public String b;
    public int c;
    public String d;
    public byte e;
    public int f;
    public int g;
    public int h;
    public byte i;
    public int j;
    public int k;
    public String l;
    public int m;
    public String n;
    public String o;
    public int p;
    public int q;
    public int r;
    public String s;
    public int t;
    public int u;

    public a3() {
        this.f85a = 0;
        this.b = "";
        this.c = -1;
        this.d = "";
        this.e = 1;
        this.f = -1;
        this.g = -1;
        this.h = -1;
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.l = "";
        this.m = 0;
        this.n = "";
        this.o = "";
        this.p = -1;
        this.q = -1;
        this.r = 0;
        this.s = "";
        this.t = -1;
        this.u = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new a3();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r4) {
        this.f85a = r4.read(this.f85a, 0, true);
        this.b = r4.readString(1, false);
        this.c = r4.read(this.c, 2, false);
        this.d = r4.readString(3, false);
        this.e = r4.read(this.e, 4, false);
        this.f = r4.read(this.f, 5, false);
        this.g = r4.read(this.g, 6, false);
        this.h = r4.read(this.h, 7, false);
        this.i = r4.read(this.i, 8, false);
        this.j = r4.read(this.j, 9, false);
        this.k = r4.read(this.k, 10, false);
        this.l = r4.readString(11, false);
        this.m = r4.read(this.m, 12, false);
        this.n = r4.readString(13, false);
        this.o = r4.readString(14, false);
        this.p = r4.read(this.p, 15, false);
        this.q = r4.read(this.q, 16, false);
        this.r = r4.read(this.r, 17, false);
        this.s = r4.readString(18, false);
        this.t = r4.read(this.t, 19, false);
        this.u = r4.read(this.u, 20, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r5) {
        r5.write(this.f85a, 0);
        String r0 = this.b;
        if (r0 == null) goto L5;
        r5.write(r0, 1);
    L5:
        int r1 = this.c;
        if (r1 == (-1)) goto L8;
        r5.write(r1, 2);
    L8:
        String r2 = this.d;
        if (r2 == null) goto L11;
        r5.write(r2, 3);
    L11:
        byte r3 = this.e;
        if (r3 == 1) goto L14;
        r5.write(r3, 4);
    L14:
        int r4 = this.f;
        if (r4 == (-1)) goto L17;
        r5.write(r4, 5);
    L17:
        int r6 = this.g;
        if (r6 == (-1)) goto L20;
        r5.write(r6, 6);
    L20:
        int r7 = this.h;
        if (r7 == (-1)) goto L23;
        r5.write(r7, 7);
    L23:
        byte r8 = this.i;
        if (r8 == 0) goto L26;
        r5.write(r8, 8);
    L26:
        int r9 = this.j;
        if (r9 == 0) goto L29;
        r5.write(r9, 9);
    L29:
        int r10 = this.k;
        if (r10 == 0) goto L32;
        r5.write(r10, 10);
    L32:
        String r11 = this.l;
        if (r11 == null) goto L35;
        r5.write(r11, 11);
    L35:
        int r12 = this.m;
        if (r12 == 0) goto L38;
        r5.write(r12, 12);
    L38:
        String r13 = this.n;
        if (r13 == null) goto L41;
        r5.write(r13, 13);
    L41:
        String r14 = this.o;
        if (r14 == null) goto L44;
        r5.write(r14, 14);
    L44:
        int r15 = this.p;
        if (r15 == (-1)) goto L47;
        r5.write(r15, 15);
    L47:
        int r16 = this.q;
        if (r16 == (-1)) goto L50;
        r5.write(r16, 16);
    L50:
        int r17 = this.r;
        if (r17 == 0) goto L53;
        r5.write(r17, 17);
    L53:
        String r18 = this.s;
        if (r18 == null) goto L56;
        r5.write(r18, 18);
    L56:
        int r19 = this.t;
        if (r19 == (-1)) goto L59;
        r5.write(r19, 19);
    L59:
        int r20 = this.u;
        if (r20 == 0) goto L63;
        r5.write(r20, 20);
        return;
    }
}

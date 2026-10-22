package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public final class ag extends JceStruct {
    static ArrayList A;
    static ArrayList B;
    static ArrayList C;
    static ArrayList D;
    static ArrayList z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f100a;
    public String b;
    public int c;
    public byte d;
    public String e;
    public ArrayList f;
    public int g;
    public int h;
    public String i;
    public int j;
    public int k;
    public int l;
    public int m;
    public String n;
    public int o;
    public int p;
    public ArrayList q;
    public int r;
    public int s;
    public int t;
    public ArrayList u;
    public ArrayList v;
    public ArrayList w;
    public int x;
    public int y;

    public ag() {
        this.f100a = 0;
        this.b = "";
        this.c = 0;
        this.d = 0;
        this.e = "";
        this.f = null;
        this.g = 0;
        this.h = 0;
        this.i = "";
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = "";
        this.o = 0;
        this.p = 0;
        this.q = null;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = 0;
        this.y = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r5) {
        this.f100a = r5.read(this.f100a, 0, true);
        this.b = r5.readString(1, true);
        this.c = r5.read(this.c, 2, true);
        this.d = r5.read(this.d, 3, true);
        this.e = r5.readString(4, true);
        if (z != null) goto L5;
        z = new ArrayList();
        zf r0 = new zf();
        z.add(r0);
    L5:
        this.f = (ArrayList) r5.read(z, 5, true);
        this.g = r5.read(this.g, 6, false);
        this.h = r5.read(this.h, 7, false);
        this.i = r5.readString(8, false);
        this.j = r5.read(this.j, 9, false);
        this.k = r5.read(this.k, 10, false);
        this.l = r5.read(this.l, 11, false);
        this.m = r5.read(this.m, 12, false);
        this.n = r5.readString(13, false);
        this.o = r5.read(this.o, 14, false);
        this.p = r5.read(this.p, 15, false);
        if (A != null) goto L8;
        A = new ArrayList();
        b2 r1 = new b2();
        A.add(r1);
    L8:
        this.q = (ArrayList) r5.read(A, 16, false);
        this.r = r5.read(this.r, 17, false);
        this.s = r5.read(this.s, 18, false);
        this.t = r5.read(this.t, 19, false);
        if (B != null) goto L11;
        ArrayList r2 = new ArrayList();
        B = r2;
        r2.add("");
    L11:
        this.u = (ArrayList) r5.read(B, 20, false);
        if (C != null) goto L14;
        ArrayList r3 = new ArrayList();
        C = r3;
        r3.add("");
    L14:
        this.v = (ArrayList) r5.read(C, 21, false);
        if (D != null) goto L17;
        D = new ArrayList();
        D.add(0);
    L17:
        this.w = (ArrayList) r5.read(D, 22, false);
        this.x = r5.read(this.x, 23, false);
        this.y = r5.read(this.y, 24, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        r3.write(this.f100a, 0);
        r3.write(this.b, 1);
        r3.write(this.c, 2);
        r3.write(this.d, 3);
        r3.write(this.e, 4);
        r3.write(this.f, 5);
        r3.write(this.g, 6);
        r3.write(this.h, 7);
        String r0 = this.i;
        if (r0 == null) goto L5;
        r3.write(r0, 8);
    L5:
        r3.write(this.j, 9);
        r3.write(this.k, 10);
        r3.write(this.l, 11);
        r3.write(this.m, 12);
        String r1 = this.n;
        if (r1 == null) goto L8;
        r3.write(r1, 13);
    L8:
        r3.write(this.o, 14);
        r3.write(this.p, 15);
        ArrayList r2 = this.q;
        if (r2 == null) goto L11;
        r3.write(r2, 16);
    L11:
        r3.write(this.r, 17);
        r3.write(this.s, 18);
        r3.write(this.t, 19);
        ArrayList r4 = this.u;
        if (r4 == null) goto L14;
        r3.write(r4, 20);
    L14:
        ArrayList r5 = this.v;
        if (r5 == null) goto L17;
        r3.write(r5, 21);
    L17:
        ArrayList r6 = this.w;
        if (r6 == null) goto L20;
        r3.write(r6, 22);
    L20:
        r3.write(this.x, 23);
        r3.write(this.y, 24);
    }
}

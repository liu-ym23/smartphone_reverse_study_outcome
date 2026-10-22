package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public final class xb extends JceStruct {
    static ArrayList u;
    static pb v;
    static ArrayList w;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f618a;
    public int b;
    public int c;
    public int d;
    public ArrayList e;
    public int f;
    public boolean g;
    public int h;
    public int i;
    public String j;
    public String k;
    public int l;
    public String m;
    public String n;
    public String o;
    public int p;
    public pb q;
    public ArrayList r;
    public int s;
    public int t;

    static {
        u = new ArrayList();
        u.add(0);
        v = new pb();
        w = new ArrayList();
        w.add(0);
    }

    public xb() {
        this.f618a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = null;
        this.f = 0;
        this.g = false;
        this.h = 0;
        this.i = 0;
        this.j = "";
        this.k = "";
        this.l = 0;
        this.m = "";
        this.n = "";
        this.o = "";
        this.p = 0;
        this.q = null;
        this.r = null;
        this.s = 0;
        this.t = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r4) {
        this.f618a = r4.read(this.f618a, 0, true);
        this.b = r4.read(this.b, 1, false);
        this.c = r4.read(this.c, 2, false);
        this.d = r4.read(this.d, 3, false);
        this.e = (ArrayList) r4.read(u, 4, false);
        this.f = r4.read(this.f, 5, false);
        this.g = r4.read(this.g, 6, false);
        this.h = r4.read(this.h, 7, false);
        this.i = r4.read(this.i, 8, false);
        this.j = r4.readString(9, false);
        this.k = r4.readString(10, false);
        this.l = r4.read(this.l, 11, false);
        this.m = r4.readString(12, false);
        this.n = r4.readString(13, false);
        this.o = r4.readString(14, false);
        this.p = r4.read(this.p, 15, false);
        this.q = (pb) r4.read(v, 16, false);
        this.r = (ArrayList) r4.read(w, 17, false);
        this.s = r4.read(this.s, 18, false);
        this.t = r4.read(this.t, 19, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r4) {
        r4.write(this.f618a, 0);
        r4.write(this.b, 1);
        int r0 = this.c;
        if (r0 == 0) goto L5;
        r4.write(r0, 2);
    L5:
        int r1 = this.d;
        if (r1 == 0) goto L8;
        r4.write(r1, 3);
    L8:
        ArrayList r2 = this.e;
        if (r2 == null) goto L11;
        r4.write(r2, 4);
    L11:
        int r3 = this.f;
        if (r3 == 0) goto L15;
        r4.write(r3, 5);
    L15:
        if (this.g == false) goto L17;
        r4.write(true, 6);
    L17:
        int r5 = this.h;
        if (r5 == 0) goto L20;
        r4.write(r5, 7);
    L20:
        r4.write(this.i, 8);
        String r6 = this.j;
        if (r6 == null) goto L23;
        r4.write(r6, 9);
    L23:
        String r7 = this.k;
        if (r7 == null) goto L26;
        r4.write(r7, 10);
    L26:
        r4.write(this.l, 11);
        String r8 = this.m;
        if (r8 == null) goto L29;
        r4.write(r8, 12);
    L29:
        String r9 = this.n;
        if (r9 == null) goto L32;
        r4.write(r9, 13);
    L32:
        String r10 = this.o;
        if (r10 == null) goto L35;
        r4.write(r10, 14);
    L35:
        r4.write(this.p, 15);
        pb r11 = this.q;
        if (r11 == null) goto L38;
        r4.write(r11, 16);
    L38:
        ArrayList r12 = this.r;
        if (r12 == null) goto L41;
        r4.write(r12, 17);
    L41:
        int r13 = this.s;
        if (r13 == 0) goto L44;
        r4.write(r13, 18);
    L44:
        int r14 = this.t;
        if (r14 == 0) goto L48;
        r4.write(r14, 19);
        return;
    }
}

package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class pb extends JceStruct {
    static byte[] E;
    static byte[] F;
    static ArrayList G;
    static ArrayList H;
    static ArrayList I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    static byte[] f415J;
    static Map K;
    static ArrayList L;
    public String A;
    public String B;
    public ArrayList C;
    public String D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f416a;
    public byte[] b;
    public String c;
    public byte[] d;
    public long e;
    public String f;
    public int g;
    public String h;
    public int i;
    public String j;
    public int k;
    public int l;
    public int m;
    public ArrayList n;
    public int o;
    public boolean p;
    public int q;
    public int r;
    public ArrayList s;
    public int t;
    public ArrayList u;
    public byte[] v;
    public Map w;
    public String x;
    public long y;
    public long z;

    static {
        E = new byte[]{0};
        F = new byte[]{0};
        G = new ArrayList();
        G.add(0);
        ArrayList r1 = new ArrayList();
        H = r1;
        r1.add(new byte[]{0});
        I = new ArrayList();
        ArrayList r2 = new ArrayList();
        r2.add(new byte[]{0});
        I.add(r2);
        f415J = new byte[]{0};
        K = new HashMap();
        K.put(0L, new p4());
        L = new ArrayList();
        L.add(new d2());
    }

    public pb() {
        this.f416a = 0;
        this.b = null;
        this.c = "";
        this.d = null;
        this.e = 0;
        this.f = "";
        this.g = 0;
        this.h = "";
        this.i = 0;
        this.j = "";
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = null;
        this.o = 0;
        this.p = false;
        this.q = 0;
        this.r = 0;
        this.s = null;
        this.t = -1;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = "";
        this.y = 0;
        this.z = 0;
        this.A = "";
        this.B = "";
        this.C = null;
        this.D = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r5) {
        this.f416a = r5.read(this.f416a, 0, true);
        this.b = r5.read(E, 1, false);
        this.c = r5.readString(2, false);
        this.d = r5.read(F, 3, false);
        this.e = r5.read(this.e, 4, false);
        this.f = r5.readString(5, false);
        this.g = r5.read(this.g, 6, false);
        this.h = r5.readString(7, false);
        this.i = r5.read(this.i, 8, false);
        this.j = r5.readString(9, false);
        this.k = r5.read(this.k, 10, false);
        this.l = r5.read(this.l, 11, false);
        this.m = r5.read(this.m, 12, false);
        this.n = (ArrayList) r5.read(G, 13, false);
        this.o = r5.read(this.o, 14, false);
        this.p = r5.read(this.p, 15, false);
        this.q = r5.read(this.q, 16, false);
        this.r = r5.read(this.r, 17, false);
        this.s = (ArrayList) r5.read(H, 18, false);
        this.t = r5.read(this.t, 20, false);
        this.u = (ArrayList) r5.read(I, 21, false);
        this.v = r5.read(f415J, 22, false);
        this.w = (Map) r5.read(K, 23, false);
        this.x = r5.readString(24, false);
        this.y = r5.read(this.y, 28, false);
        this.z = r5.read(this.z, 29, false);
        this.A = r5.readString(99, false);
        this.B = r5.readString(30, false);
        this.C = (ArrayList) r5.read(L, 31, false);
        this.D = r5.readString(32, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r6) {
        r6.write(this.f416a, 0);
        byte[] r0 = this.b;
        if (r0 == null) goto L5;
        r6.write(r0, 1);
    L5:
        String r1 = this.c;
        if (r1 == null) goto L8;
        r6.write(r1, 2);
    L8:
        byte[] r2 = this.d;
        if (r2 == null) goto L11;
        r6.write(r2, 3);
    L11:
        long r3 = this.e;
        if (r3 == 0) goto L14;
        r6.write(r3, 4);
    L14:
        String r4 = this.f;
        if (r4 == null) goto L17;
        r6.write(r4, 5);
    L17:
        int r5 = this.g;
        if (r5 == 0) goto L20;
        r6.write(r5, 6);
    L20:
        String r7 = this.h;
        if (r7 == null) goto L23;
        r6.write(r7, 7);
    L23:
        int r8 = this.i;
        if (r8 == 0) goto L26;
        r6.write(r8, 8);
    L26:
        String r9 = this.j;
        if (r9 == null) goto L29;
        r6.write(r9, 9);
    L29:
        r6.write(this.k, 10);
        int r10 = this.l;
        if (r10 == 0) goto L32;
        r6.write(r10, 11);
    L32:
        int r11 = this.m;
        if (r11 == 0) goto L35;
        r6.write(r11, 12);
    L35:
        ArrayList r12 = this.n;
        if (r12 == null) goto L38;
        r6.write(r12, 13);
    L38:
        int r13 = this.o;
        if (r13 == 0) goto L41;
        r6.write(r13, 14);
    L41:
        boolean r14 = this.p;
        if (r14 == false) goto L44;
        r6.write(r14, 15);
    L44:
        int r15 = this.q;
        if (r15 == 0) goto L47;
        r6.write(r15, 16);
    L47:
        r6.write(this.r, 17);
        ArrayList r16 = this.s;
        if (r16 == null) goto L50;
        r6.write(r16, 18);
    L50:
        int r17 = this.t;
        if (r17 == (-1)) goto L53;
        r6.write(r17, 20);
    L53:
        ArrayList r18 = this.u;
        if (r18 == null) goto L56;
        r6.write(r18, 21);
    L56:
        byte[] r19 = this.v;
        if (r19 == null) goto L59;
        r6.write(r19, 22);
    L59:
        Map r20 = this.w;
        if (r20 == null) goto L62;
        r6.write(r20, 23);
    L62:
        String r21 = this.x;
        if (r21 == null) goto L65;
        r6.write(r21, 24);
    L65:
        long r22 = this.y;
        if (r22 == 0) goto L68;
        r6.write(r22, 28);
    L68:
        long r23 = this.z;
        if (r23 == 0) goto L71;
        r6.write(r23, 29);
    L71:
        String r24 = this.A;
        if (r24 == null) goto L74;
        r6.write(r24, 99);
    L74:
        String r25 = this.B;
        if (r25 == null) goto L77;
        r6.write(r25, 30);
    L77:
        ArrayList r26 = this.C;
        if (r26 == null) goto L80;
        r6.write(r26, 31);
    L80:
        String r27 = this.D;
        if (r27 == null) goto L84;
        r6.write(r27, 32);
        return;
    }
}

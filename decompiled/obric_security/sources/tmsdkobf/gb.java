package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public final class gb extends JceStruct {
    static l q;
    static ArrayList r;
    static ArrayList s;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l f216a;
    public int b;
    public String c;
    public String d;
    public int e;
    public int f;
    public String g;
    public String h;
    public int i;
    public int j;
    public int k;
    public String l;
    public ArrayList m;
    public ArrayList n;
    public int o;
    public int p;

    public gb() {
        this.f216a = null;
        this.b = 0;
        this.c = "";
        this.d = "";
        this.e = 0;
        this.f = 0;
        this.g = "";
        this.h = "";
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.l = "";
        this.m = null;
        this.n = null;
        this.o = 0;
        this.p = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r4) {
        if (q != null) goto L5;
        q = new l();
    L5:
        this.f216a = (l) r4.read(q, 0, true);
        this.b = r4.read(this.b, 1, true);
        this.c = r4.readString(2, false);
        this.d = r4.readString(3, false);
        this.e = r4.read(this.e, 4, false);
        this.f = r4.read(this.f, 5, false);
        this.g = r4.readString(6, false);
        this.h = r4.readString(7, false);
        this.i = r4.read(this.i, 8, false);
        this.j = r4.read(this.j, 9, false);
        this.k = r4.read(this.k, 10, false);
        this.l = r4.readString(11, false);
        if (r != null) goto L8;
        r = new ArrayList();
        g r0 = new g();
        r.add(r0);
    L8:
        this.m = (ArrayList) r4.read(r, 12, false);
        if (s != null) goto L11;
        s = new ArrayList();
        s.add(0);
    L11:
        this.n = (ArrayList) r4.read(s, 13, false);
        this.o = r4.read(this.o, 14, false);
        this.p = r4.read(this.p, 15, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        r3.write(this.f216a, 0);
        r3.write(this.b, 1);
        String r0 = this.c;
        if (r0 == null) goto L5;
        r3.write(r0, 2);
    L5:
        String r1 = this.d;
        if (r1 == null) goto L8;
        r3.write(r1, 3);
    L8:
        r3.write(this.e, 4);
        r3.write(this.f, 5);
        String r2 = this.g;
        if (r2 == null) goto L11;
        r3.write(r2, 6);
    L11:
        String r4 = this.h;
        if (r4 == null) goto L14;
        r3.write(r4, 7);
    L14:
        r3.write(this.i, 8);
        r3.write(this.j, 9);
        r3.write(this.k, 10);
        String r5 = this.l;
        if (r5 == null) goto L17;
        r3.write(r5, 11);
    L17:
        ArrayList r6 = this.m;
        if (r6 == null) goto L20;
        r3.write(r6, 12);
    L20:
        ArrayList r7 = this.n;
        if (r7 == null) goto L23;
        r3.write(r7, 13);
    L23:
        r3.write(this.o, 14);
        r3.write(this.p, 15);
    }
}

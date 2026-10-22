package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class sc extends JceStruct {
    static ArrayList j;
    static Map k;
    static Map l;
    static Map m;
    static x3 n;
    static Map o;
    static jf p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList f509a;
    public Map b;
    public Map c;
    public int d;
    public Map e;
    public int f;
    public x3 g;
    public Map h;
    public jf i;

    static {
        j = new ArrayList();
        xb r0 = new xb();
        j.add(r0);
        k = new HashMap();
        bg r1 = new bg();
        k.put(0, r1);
        l = new HashMap();
        b r2 = new b();
        l.put(0, r2);
        m = new HashMap();
        r4 r3 = new r4();
        m.put(0, r3);
        n = new x3();
        o = new HashMap();
        ea r4 = new ea();
        o.put(0, r4);
        p = new jf();
    }

    public sc() {
        this.f509a = null;
        this.b = null;
        this.c = null;
        this.d = 0;
        this.e = null;
        this.f = 0;
        this.g = null;
        this.h = null;
        this.i = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r4) {
        this.f509a = (ArrayList) r4.read(j, 0, false);
        this.b = (Map) r4.read(k, 1, false);
        this.c = (Map) r4.read(l, 2, false);
        this.d = r4.read(this.d, 3, false);
        this.e = (Map) r4.read(m, 4, false);
        this.f = r4.read(this.f, 5, false);
        this.g = (x3) r4.read(n, 6, false);
        this.h = (Map) r4.read(o, 7, false);
        this.i = (jf) r4.read(p, 8, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        ArrayList r0 = this.f509a;
        if (r0 == null) goto L5;
        r3.write(r0, 0);
    L5:
        Map r1 = this.b;
        if (r1 == null) goto L8;
        r3.write(r1, 1);
    L8:
        Map r2 = this.c;
        if (r2 == null) goto L11;
        r3.write(r2, 2);
    L11:
        int r4 = this.d;
        if (r4 == 0) goto L14;
        r3.write(r4, 3);
    L14:
        Map r5 = this.e;
        if (r5 == null) goto L17;
        r3.write(r5, 4);
    L17:
        r3.write(this.f, 5);
        x3 r6 = this.g;
        if (r6 == null) goto L20;
        r3.write(r6, 6);
    L20:
        Map r7 = this.h;
        if (r7 == null) goto L23;
        r3.write(r7, 7);
    L23:
        jf r8 = this.i;
        if (r8 == null) goto L27;
        r3.write(r8, 8);
        return;
    }
}

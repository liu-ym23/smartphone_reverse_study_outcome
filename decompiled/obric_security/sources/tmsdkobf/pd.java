package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class pd extends JceStruct {
    static byte[] o;
    static byte[] p;
    static byte[] q;
    static Map r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f418a;
    public byte[] b;
    public int c;
    public String d;
    public boolean e;
    public byte[] f;
    public byte[] g;
    public int h;
    public int i;
    public long j;
    public int k;
    public int l;
    public String m;
    public Map n;

    static {
        o = new byte[]{0};
        p = new byte[]{0};
        q = new byte[]{0};
        HashMap r0 = new HashMap();
        r = r0;
        r0.put("", "");
    }

    public pd() {
        this.f418a = 0;
        this.b = null;
        this.c = 0;
        this.d = "";
        this.e = false;
        this.f = null;
        this.g = null;
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = "";
        this.n = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new pd();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r5) {
        this.f418a = r5.read(this.f418a, 0, true);
        this.b = r5.read(o, 1, true);
        this.c = r5.read(this.c, 2, true);
        this.d = r5.readString(3, false);
        this.e = r5.read(this.e, 4, false);
        this.f = r5.read(p, 5, false);
        this.g = r5.read(q, 6, false);
        this.h = r5.read(this.h, 7, false);
        this.i = r5.read(this.i, 8, false);
        this.j = r5.read(this.j, 9, false);
        this.k = r5.read(this.k, 10, false);
        this.l = r5.read(this.l, 11, false);
        this.m = r5.readString(12, false);
        this.n = (Map) r5.read(r, 13, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r5) {
        r5.write(this.f418a, 0);
        r5.write(this.b, 1);
        r5.write(this.c, 2);
        String r0 = this.d;
        if (r0 == null) goto L5;
        r5.write(r0, 3);
    L5:
        boolean r1 = this.e;
        if (r1 == false) goto L8;
        r5.write(r1, 4);
    L8:
        byte[] r2 = this.f;
        if (r2 == null) goto L11;
        r5.write(r2, 5);
    L11:
        byte[] r3 = this.g;
        if (r3 == null) goto L14;
        r5.write(r3, 6);
    L14:
        int r4 = this.h;
        if (r4 == 0) goto L17;
        r5.write(r4, 7);
    L17:
        int r6 = this.i;
        if (r6 == 0) goto L20;
        r5.write(r6, 8);
    L20:
        long r7 = this.j;
        if (r7 == 0) goto L23;
        r5.write(r7, 9);
    L23:
        int r8 = this.k;
        if (r8 == 0) goto L26;
        r5.write(r8, 10);
    L26:
        int r9 = this.l;
        if (r9 == 0) goto L29;
        r5.write(r9, 11);
    L29:
        String r10 = this.m;
        if (r10 == null) goto L32;
        r5.write(r10, 12);
    L32:
        Map r11 = this.n;
        if (r11 == null) goto L36;
        r5.write(r11, 13);
        return;
    }
}

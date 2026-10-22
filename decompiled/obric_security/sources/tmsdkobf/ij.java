package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* JADX INFO: loaded from: classes5.dex */
public final class ij extends JceStruct {
    static byte[] k;
    static fk l;
    static byte[] m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f276a;
    public int b;
    public int c;
    public int d;
    public int e;
    public byte[] f;
    public fk g;
    public byte[] h;
    public int i;
    public String j;

    static {
        k = new byte[]{0};
        l = new fk();
        m = new byte[]{0};
    }

    public ij() {
        this.f276a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = 0;
        this.j = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new ij();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r4) {
        this.f276a = r4.read(this.f276a, 0, true);
        this.b = r4.read(this.b, 1, false);
        this.c = r4.read(this.c, 2, false);
        this.d = r4.read(this.d, 3, false);
        this.e = r4.read(this.e, 4, false);
        this.f = r4.read(k, 5, false);
        this.g = (fk) r4.read(l, 6, false);
        this.h = r4.read(m, 7, false);
        this.i = r4.read(this.i, 8, false);
        this.j = r4.readString(9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        r3.write(this.f276a, 0);
        int r0 = this.b;
        if (r0 == 0) goto L5;
        r3.write(r0, 1);
    L5:
        int r1 = this.c;
        if (r1 == 0) goto L8;
        r3.write(r1, 2);
    L8:
        r3.write(this.d, 3);
        int r2 = this.e;
        if (r2 == 0) goto L11;
        r3.write(r2, 4);
    L11:
        byte[] r4 = this.f;
        if (r4 == null) goto L14;
        r3.write(r4, 5);
    L14:
        fk r5 = this.g;
        if (r5 == null) goto L17;
        r3.write(r5, 6);
    L17:
        byte[] r6 = this.h;
        if (r6 == null) goto L20;
        r3.write(r6, 7);
    L20:
        int r7 = this.i;
        if (r7 == 0) goto L23;
        r3.write(r7, 8);
    L23:
        String r8 = this.j;
        if (r8 == null) goto L27;
        r3.write(r8, 9);
        return;
    }
}

package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* JADX INFO: loaded from: classes5.dex */
public final class pi extends JceStruct {
    static byte[] h;
    static gj i;
    static byte[] j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f422a;
    public int b;
    public int c;
    public byte[] d;
    public gj e;
    public byte[] f;
    public int g;

    static {
        h = new byte[]{0};
        i = new gj();
        j = new byte[]{0};
    }

    public pi() {
        this.f422a = 0;
        this.b = 0;
        this.c = 0;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new pi();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r4) {
        this.f422a = r4.read(this.f422a, 0, true);
        this.b = r4.read(this.b, 1, false);
        this.c = r4.read(this.c, 2, false);
        this.d = r4.read(h, 3, false);
        this.e = (gj) r4.read(i, 4, false);
        this.f = r4.read(j, 5, false);
        this.g = r4.read(this.g, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        r3.write(this.f422a, 0);
        int r0 = this.b;
        if (r0 == 0) goto L5;
        r3.write(r0, 1);
    L5:
        int r1 = this.c;
        if (r1 == 0) goto L8;
        r3.write(r1, 2);
    L8:
        byte[] r2 = this.d;
        if (r2 == null) goto L11;
        r3.write(r2, 3);
    L11:
        gj r4 = this.e;
        if (r4 == null) goto L14;
        r3.write(r4, 4);
    L14:
        byte[] r5 = this.f;
        if (r5 == null) goto L17;
        r3.write(r5, 5);
    L17:
        int r6 = this.g;
        if (r6 == 0) goto L21;
        r3.write(r6, 6);
        return;
    }
}

package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* JADX INFO: loaded from: classes5.dex */
public final class e2 extends JceStruct {
    static byte[] g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f170a;
    public byte[] b;
    public int c;
    public int d;
    public int e;
    public int f;

    static {
        g = new byte[]{0};
    }

    public e2() {
        this.f170a = 0;
        this.b = null;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new e2();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r5) {
        this.f170a = r5.read(this.f170a, 0, true);
        this.b = r5.read(g, 1, true);
        this.c = r5.read(this.c, 2, true);
        this.d = r5.read(this.d, 3, false);
        this.e = r5.read(this.e, 4, false);
        this.f = r5.read(this.f, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        r3.write(this.f170a, 0);
        r3.write(this.b, 1);
        r3.write(this.c, 2);
        int r0 = this.d;
        if (r0 == 0) goto L5;
        r3.write(r0, 3);
    L5:
        int r1 = this.e;
        if (r1 == 0) goto L8;
        r3.write(r1, 4);
    L8:
        int r2 = this.f;
        if (r2 == 0) goto L12;
        r3.write(r2, 5);
        return;
    }
}

package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* JADX INFO: loaded from: classes5.dex */
public final class sj extends JceStruct {
    static nj d;
    static byte[] e;
    static byte[] f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public nj f515a;
    public byte[] b;
    public byte[] c;

    static {
        d = new nj();
        e = new byte[]{0};
        f = new byte[]{0};
    }

    public sj() {
        this.f515a = null;
        this.b = null;
        this.c = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new sj();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r4) {
        this.f515a = (nj) r4.read(d, 0, false);
        this.b = r4.read(e, 1, false);
        this.c = r4.read(f, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        nj r0 = this.f515a;
        if (r0 == null) goto L5;
        r3.write(r0, 0);
    L5:
        byte[] r1 = this.b;
        if (r1 == null) goto L8;
        r3.write(r1, 1);
    L8:
        byte[] r2 = this.c;
        if (r2 == null) goto L12;
        r3.write(r2, 2);
        return;
    }
}

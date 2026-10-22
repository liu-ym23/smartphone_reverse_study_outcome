package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* JADX INFO: loaded from: classes5.dex */
public final class wd extends JceStruct {
    static byte[] d;
    static vj e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f600a;
    public vj b;
    public int c;

    static {
        d = new byte[]{0};
        e = new vj();
    }

    public wd() {
        this.f600a = null;
        this.b = null;
        this.c = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new wd();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r4) {
        this.f600a = r4.read(d, 0, false);
        this.b = (vj) r4.read(e, 1, false);
        this.c = r4.read(this.c, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        byte[] r0 = this.f600a;
        if (r0 == null) goto L5;
        r3.write(r0, 0);
    L5:
        vj r1 = this.b;
        if (r1 == null) goto L8;
        r3.write(r1, 1);
    L8:
        int r2 = this.c;
        if (r2 == 0) goto L12;
        r3.write(r2, 2);
        return;
    }
}

package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* JADX INFO: loaded from: classes5.dex */
public final class r2 extends JceStruct {
    static byte[] f;
    static cf g;
    static ef h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f465a;
    public byte[] b;
    public int c;
    public cf d;
    public ef e;

    static {
        f = new byte[]{0};
        g = new cf();
        h = new ef();
    }

    public r2() {
        this.f465a = 0;
        this.b = null;
        this.c = 0;
        this.d = null;
        this.e = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new r2();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r4) {
        this.f465a = r4.read(this.f465a, 0, false);
        this.b = r4.read(f, 1, false);
        this.c = r4.read(this.c, 2, false);
        this.d = (cf) r4.read(g, 3, false);
        this.e = (ef) r4.read(h, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        r3.write(this.f465a, 0);
        byte[] r0 = this.b;
        if (r0 == null) goto L5;
        r3.write(r0, 1);
    L5:
        int r1 = this.c;
        if (r1 == 0) goto L8;
        r3.write(r1, 2);
    L8:
        cf r2 = this.d;
        if (r2 == null) goto L11;
        r3.write(r2, 3);
    L11:
        ef r4 = this.e;
        if (r4 == null) goto L15;
        r3.write(r4, 4);
        return;
    }
}

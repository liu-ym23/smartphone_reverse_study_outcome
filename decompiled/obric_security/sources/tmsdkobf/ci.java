package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* JADX INFO: loaded from: classes5.dex */
public final class ci extends JceStruct {
    static byte[] g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f134a;
    public byte[] b;
    public String c;
    public int d;
    public int e;
    public String f;

    static {
        g = new byte[]{0};
    }

    public ci() {
        this.f134a = 0;
        this.b = null;
        this.c = "";
        this.d = 0;
        this.e = 1;
        this.f = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new ci();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r4) {
        this.f134a = r4.read(this.f134a, 0, false);
        this.b = r4.read(g, 1, false);
        this.c = r4.readString(2, false);
        this.d = r4.read(this.d, 3, false);
        this.e = r4.read(this.e, 4, false);
        this.f = r4.readString(5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        int r0 = this.f134a;
        if (r0 == 0) goto L5;
        r3.write(r0, 0);
    L5:
        byte[] r1 = this.b;
        if (r1 == null) goto L8;
        r3.write(r1, 1);
    L8:
        String r2 = this.c;
        if (r2 == null) goto L11;
        r3.write(r2, 2);
    L11:
        int r4 = this.d;
        if (r4 == 0) goto L14;
        r3.write(r4, 3);
    L14:
        r3.write(this.e, 4);
        r3.write(this.f, 5);
    }
}

package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* JADX INFO: loaded from: classes5.dex */
public final class vh extends JceStruct {
    static byte[] d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f584a;
    public byte[] b;
    public int c;

    static {
        d = new byte[]{0};
    }

    public vh() {
        this.f584a = 0;
        this.b = null;
        this.c = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new vh();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r4) {
        this.f584a = r4.read(this.f584a, 0, true);
        this.b = r4.read(d, 1, false);
        this.c = r4.read(this.c, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        r3.write(this.f584a, 0);
        byte[] r0 = this.b;
        if (r0 == null) goto L5;
        r3.write(r0, 1);
    L5:
        int r2 = this.c;
        if (r2 == 0) goto L9;
        r3.write(r2, 2);
        return;
    }
}

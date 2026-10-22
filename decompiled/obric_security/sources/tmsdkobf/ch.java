package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* JADX INFO: loaded from: classes5.dex */
public final class ch extends JceStruct {
    static byte[] c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f133a;
    public byte[] b;

    static {
        c = new byte[]{0};
    }

    public ch() {
        this.f133a = 0;
        this.b = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new ch();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r4) {
        this.f133a = r4.read(this.f133a, 0, true);
        this.b = r4.read(c, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        r3.write(this.f133a, 0);
        byte[] r2 = this.b;
        if (r2 == null) goto L6;
        r3.write(r2, 1);
        return;
    }
}

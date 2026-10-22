package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* JADX INFO: loaded from: classes5.dex */
public final class nl extends JceStruct {
    static byte[] c;
    static ck d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f377a;
    public ck b;

    static {
        c = new byte[]{0};
        d = new ck();
    }

    public nl() {
        this.f377a = null;
        this.b = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new nl();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r4) {
        this.f377a = r4.read(c, 0, false);
        this.b = (ck) r4.read(d, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        byte[] r0 = this.f377a;
        if (r0 == null) goto L5;
        r3.write(r0, 0);
    L5:
        ck r2 = this.b;
        if (r2 == null) goto L9;
        r3.write(r2, 1);
        return;
    }
}

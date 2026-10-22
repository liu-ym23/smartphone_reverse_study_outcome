package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* JADX INFO: loaded from: classes5.dex */
public final class h1 extends JceStruct {
    static yf b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public yf f235a;

    static {
        b = new yf();
    }

    public h1() {
        this.f235a = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new h1();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r4) {
        this.f235a = (yf) r4.read(b, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r2) {
        yf r1 = this.f235a;
        if (r1 == null) goto L6;
        r2.write(r1, 0);
        return;
    }
}

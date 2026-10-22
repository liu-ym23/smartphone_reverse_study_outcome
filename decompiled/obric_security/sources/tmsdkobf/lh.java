package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* JADX INFO: loaded from: classes5.dex */
public final class lh extends JceStruct {
    static wh c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f332a;
    public wh b;

    static {
        c = new wh();
    }

    public lh() {
        this.f332a = 0;
        this.b = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new lh();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r4) {
        this.f332a = r4.read(this.f332a, 0, true);
        this.b = (wh) r4.read(c, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        r3.write(this.f332a, 0);
        wh r2 = this.b;
        if (r2 == null) goto L6;
        r3.write(r2, 1);
        return;
    }
}

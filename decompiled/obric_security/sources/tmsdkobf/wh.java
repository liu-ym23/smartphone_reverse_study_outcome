package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* JADX INFO: loaded from: classes5.dex */
public final class wh extends JceStruct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f603a;
    public long b;

    public wh() {
        this.f603a = 0;
        this.b = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new wh();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r5) {
        this.f603a = r5.read(this.f603a, 0, false);
        this.b = r5.read(this.b, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r6) {
        long r0 = this.f603a;
        if (r0 == 0) goto L5;
        r6.write(r0, 0);
    L5:
        long r1 = this.b;
        if (r1 == 0) goto L9;
        r6.write(r1, 1);
        return;
    }
}

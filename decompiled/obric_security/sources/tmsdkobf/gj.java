package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* JADX INFO: loaded from: classes5.dex */
public final class gj extends JceStruct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f232a;

    public gj() {
        this.f232a = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new gj();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r4) {
        this.f232a = r4.read(this.f232a, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r5) {
        long r0 = this.f232a;
        if (r0 == 0) goto L6;
        r5.write(r0, 0);
        return;
    }
}

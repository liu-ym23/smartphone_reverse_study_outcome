package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* JADX INFO: loaded from: classes5.dex */
public final class lc extends JceStruct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f328a;

    public lc() {
        this.f328a = 1;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r3) {
        this.f328a = r3.read(this.f328a, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r2) {
        int r1 = this.f328a;
        if (1 == r1) goto L6;
        r2.write(r1, 0);
        return;
    }
}

package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* JADX INFO: loaded from: classes5.dex */
public final class cf extends JceStruct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f131a;

    public cf() {
        this.f131a = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new cf();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r3) {
        this.f131a = r3.read(this.f131a, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r2) {
        int r1 = this.f131a;
        if (r1 == 0) goto L6;
        r2.write(r1, 0);
        return;
    }
}

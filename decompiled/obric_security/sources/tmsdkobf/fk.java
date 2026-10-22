package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* JADX INFO: loaded from: classes5.dex */
public final class fk extends JceStruct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f206a;
    public String b;

    public fk() {
        this.f206a = 0;
        this.b = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new fk();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r4) {
        this.f206a = r4.read(this.f206a, 0, false);
        this.b = r4.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r5) {
        long r0 = this.f206a;
        if (r0 == 0) goto L5;
        r5.write(r0, 0);
    L5:
        String r4 = this.b;
        if (r4 == null) goto L9;
        r5.write(r4, 1);
        return;
    }
}

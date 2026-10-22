package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* JADX INFO: loaded from: classes5.dex */
public final class oc extends JceStruct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f395a;
    public int b;

    public oc() {
        this.f395a = "";
        this.b = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new oc();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r4) {
        this.f395a = r4.readString(0, false);
        this.b = r4.read(this.b, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        String r0 = this.f395a;
        if (r0 == null) goto L5;
        r3.write(r0, 0);
    L5:
        int r2 = this.b;
        if (r2 == 0) goto L9;
        r3.write(r2, 1);
        return;
    }
}

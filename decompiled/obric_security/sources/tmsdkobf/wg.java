package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* JADX INFO: loaded from: classes5.dex */
public final class wg extends JceStruct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f602a;
    public int b;

    public wg() {
        this.f602a = "";
        this.b = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new wg();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r4) {
        this.f602a = r4.readString(0, true);
        this.b = r4.read(this.b, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        r3.write(this.f602a, 0);
        int r2 = this.b;
        if (r2 == 0) goto L6;
        r3.write(r2, 1);
        return;
    }
}

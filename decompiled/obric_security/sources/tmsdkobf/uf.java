package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* JADX INFO: loaded from: classes5.dex */
public final class uf extends JceStruct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f558a;

    static {
    }

    public uf(int r1) {
        this.f558a = r1;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r3) {
        this.f558a = r3.read(this.f558a, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r2) {
        r2.write(this.f558a, 0);
    }
}

package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* JADX INFO: loaded from: classes5.dex */
public final class mc extends JceStruct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f350a;
    public int b;

    public mc() {
        this.f350a = 0;
        this.b = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new mc();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r4) {
        this.f350a = r4.read(this.f350a, 0, false);
        this.b = r4.read(this.b, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        r3.write(this.f350a, 0);
        r3.write(this.b, 1);
    }
}

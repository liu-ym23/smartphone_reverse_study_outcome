package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* JADX INFO: loaded from: classes5.dex */
public final class ff extends JceStruct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f202a;
    public String b;
    public int c;
    public int d;

    public ff() {
        this.f202a = "";
        this.b = "";
        this.c = 0;
        this.d = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r4) {
        this.f202a = r4.readString(0, true);
        this.b = r4.readString(1, true);
        this.c = r4.read(this.c, 2, true);
        this.d = r4.read(this.d, 3, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        r3.write(this.f202a, 0);
        r3.write(this.b, 1);
        r3.write(this.c, 2);
        r3.write(this.d, 3);
    }
}

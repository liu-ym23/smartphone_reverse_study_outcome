package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* JADX INFO: loaded from: classes5.dex */
public final class ug extends JceStruct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f559a;
    public String b;

    public ug() {
        this.f559a = 0;
        this.b = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new ug();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r4) {
        this.f559a = r4.read(this.f559a, 0, true);
        this.b = r4.readString(1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        r3.write(this.f559a, 0);
        r3.write(this.b, 1);
    }
}

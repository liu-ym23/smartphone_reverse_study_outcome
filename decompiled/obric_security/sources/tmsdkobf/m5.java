package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* JADX INFO: loaded from: classes5.dex */
public final class m5 extends JceStruct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f346a;
    public String b;
    public int c;
    public int d;

    public m5() {
        this.f346a = "";
        this.b = "";
        this.c = 1;
        this.d = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new m5();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r5) {
        this.f346a = r5.readString(0, true);
        this.b = r5.readString(1, true);
        this.c = r5.read(this.c, 2, false);
        this.d = r5.read(this.d, 3, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        r3.write(this.f346a, 0);
        r3.write(this.b, 1);
        int r0 = this.c;
        if (1 == r0) goto L5;
        r3.write(r0, 2);
    L5:
        r3.write(this.d, 3);
    }
}

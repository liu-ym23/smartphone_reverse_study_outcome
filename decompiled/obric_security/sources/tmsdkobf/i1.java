package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* JADX INFO: loaded from: classes5.dex */
public final class i1 extends JceStruct {
    static bd d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f258a;
    public int b;
    public bd c;

    static {
        d = new bd();
    }

    public i1() {
        this.f258a = 0;
        this.b = 0;
        this.c = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new i1();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r4) {
        this.f258a = r4.read(this.f258a, 0, true);
        this.b = r4.read(this.b, 1, true);
        this.c = (bd) r4.read(d, 2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        r3.write(this.f258a, 0);
        r3.write(this.b, 1);
        r3.write(this.c, 2);
    }
}

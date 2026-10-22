package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* JADX INFO: loaded from: classes5.dex */
public final class nj extends JceStruct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f375a;
    public int b;
    public int c;
    public int d;

    public nj() {
        this.f375a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new nj();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r4) {
        this.f375a = r4.read(this.f375a, 0, false);
        this.b = r4.read(this.b, 1, false);
        this.c = r4.read(this.c, 2, false);
        this.d = r4.read(this.d, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        int r0 = this.f375a;
        if (r0 == 0) goto L5;
        r3.write(r0, 0);
    L5:
        r3.write(this.b, 1);
        int r1 = this.c;
        if (r1 == 0) goto L8;
        r3.write(r1, 2);
    L8:
        int r2 = this.d;
        if (r2 == 0) goto L12;
        r3.write(r2, 3);
        return;
    }
}

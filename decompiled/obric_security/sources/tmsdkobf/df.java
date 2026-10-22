package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* JADX INFO: loaded from: classes5.dex */
public final class df extends JceStruct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f154a;
    public boolean b;
    public int c;
    public int d;

    public df() {
        this.f154a = 0;
        this.b = true;
        this.c = 0;
        this.d = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r4) {
        this.f154a = r4.read(this.f154a, 0, true);
        this.b = r4.read(this.b, 1, true);
        this.c = r4.read(this.c, 2, false);
        this.d = r4.read(this.d, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        r3.write(this.f154a, 0);
        r3.write(this.b, 1);
        int r0 = this.c;
        if (r0 == 0) goto L5;
        r3.write(r0, 2);
    L5:
        int r2 = this.d;
        if (r2 == 0) goto L9;
        r3.write(r2, 3);
        return;
    }
}

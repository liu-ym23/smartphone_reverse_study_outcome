package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* JADX INFO: loaded from: classes5.dex */
public final class ze extends JceStruct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f664a;
    public int b;
    public int c;

    public ze() {
        this.f664a = 0;
        this.b = 0;
        this.c = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r4) {
        this.f664a = r4.read(this.f664a, 0, false);
        this.b = r4.read(this.b, 1, false);
        this.c = r4.read(this.c, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        int r0 = this.f664a;
        if (r0 == 0) goto L5;
        r3.write(r0, 0);
    L5:
        int r1 = this.b;
        if (r1 == 0) goto L8;
        r3.write(r1, 1);
    L8:
        int r2 = this.c;
        if (r2 == 0) goto L12;
        r3.write(r2, 2);
        return;
    }
}

package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* JADX INFO: loaded from: classes5.dex */
public final class t2 extends JceStruct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f522a;
    public long b;
    public int c;
    public int d;
    public int e;

    public t2() {
        this.f522a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new t2();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r5) {
        this.f522a = r5.read(this.f522a, 0, false);
        this.b = r5.read(this.b, 1, false);
        this.c = r5.read(this.c, 2, false);
        this.d = r5.read(this.d, 3, false);
        this.e = r5.read(this.e, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r6) {
        long r0 = this.f522a;
        if (r0 == 0) goto L5;
        r6.write(r0, 0);
    L5:
        long r1 = this.b;
        if (r1 == 0) goto L8;
        r6.write(r1, 1);
    L8:
        int r2 = this.c;
        if (r2 == 0) goto L11;
        r6.write(r2, 2);
    L11:
        r6.write(this.d, 3);
        int r5 = this.e;
        if (r5 == 0) goto L15;
        r6.write(r5, 4);
        return;
    }
}

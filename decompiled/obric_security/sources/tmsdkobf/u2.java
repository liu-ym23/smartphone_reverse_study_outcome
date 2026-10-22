package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* JADX INFO: loaded from: classes5.dex */
public final class u2 extends JceStruct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f546a;
    public long b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;

    public u2() {
        this.f546a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new u2();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r5) {
        this.f546a = r5.read(this.f546a, 0, false);
        this.b = r5.read(this.b, 1, false);
        this.c = r5.read(this.c, 2, false);
        this.d = r5.read(this.d, 3, false);
        this.e = r5.read(this.e, 4, false);
        this.f = r5.read(this.f, 5, false);
        this.g = r5.read(this.g, 6, false);
        this.h = r5.read(this.h, 7, false);
        this.i = r5.read(this.i, 8, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r6) {
        long r0 = this.f546a;
        if (r0 == 0) goto L5;
        r6.write(r0, 0);
    L5:
        long r1 = this.b;
        if (r1 == 0) goto L8;
        r6.write(r1, 1);
    L8:
        r6.write(this.c, 2);
        int r2 = this.d;
        if (r2 == 0) goto L11;
        r6.write(r2, 3);
    L11:
        r6.write(this.e, 4);
        r6.write(this.f, 5);
        r6.write(this.g, 6);
        r6.write(this.h, 7);
        int r5 = this.i;
        if (r5 == 0) goto L15;
        r6.write(r5, 8);
        return;
    }
}

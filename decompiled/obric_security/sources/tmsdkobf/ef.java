package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* JADX INFO: loaded from: classes5.dex */
public final class ef extends JceStruct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f182a;
    public String b;
    public int c;
    public int d;
    public int e;
    public int f;

    public ef() {
        this.f182a = "";
        this.b = "";
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new ef();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r4) {
        this.f182a = r4.readString(0, false);
        this.b = r4.readString(1, false);
        this.c = r4.read(this.c, 2, false);
        this.d = r4.read(this.d, 3, false);
        this.e = r4.read(this.e, 4, false);
        this.f = r4.read(this.f, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        String r0 = this.f182a;
        if (r0 == null) goto L5;
        r3.write(r0, 0);
    L5:
        String r1 = this.b;
        if (r1 == null) goto L8;
        r3.write(r1, 1);
    L8:
        int r2 = this.c;
        if (r2 == 0) goto L11;
        r3.write(r2, 2);
    L11:
        int r4 = this.d;
        if (r4 == 0) goto L14;
        r3.write(r4, 3);
    L14:
        int r5 = this.e;
        if (r5 == 0) goto L17;
        r3.write(r5, 4);
    L17:
        int r6 = this.f;
        if (r6 == 0) goto L21;
        r3.write(r6, 5);
        return;
    }
}

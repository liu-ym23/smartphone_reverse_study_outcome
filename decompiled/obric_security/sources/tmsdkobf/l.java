package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* JADX INFO: loaded from: classes5.dex */
public final class l extends JceStruct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f313a;
    public String b;
    public String c;
    public String d;
    public int e;
    public int f;
    public String g;
    public int h;

    public l() {
        this.f313a = "";
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = 0;
        this.f = 0;
        this.g = "";
        this.h = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r5) {
        this.f313a = r5.readString(0, true);
        this.b = r5.readString(1, true);
        this.c = r5.readString(2, true);
        this.d = r5.readString(3, true);
        this.e = r5.read(this.e, 4, true);
        this.f = r5.read(this.f, 5, true);
        this.g = r5.readString(6, false);
        this.h = r5.read(this.h, 7, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        r3.write(this.f313a, 0);
        r3.write(this.b, 1);
        r3.write(this.c, 2);
        r3.write(this.d, 3);
        r3.write(this.e, 4);
        r3.write(this.f, 5);
        String r0 = this.g;
        if (r0 == null) goto L5;
        r3.write(r0, 6);
    L5:
        r3.write(this.h, 7);
    }

    public l(String r1, String r2, String r3, String r4, int r5, int r6, String r7, int r8) {
        this.f313a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
    }
}

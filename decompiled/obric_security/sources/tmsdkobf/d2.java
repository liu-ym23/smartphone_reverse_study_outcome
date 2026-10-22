package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* JADX INFO: loaded from: classes5.dex */
public final class d2 extends JceStruct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f142a;
    public String b;
    public long c;
    public long d;
    public String e;

    public d2() {
        this.f142a = "";
        this.b = "";
        this.c = 0;
        this.d = 0;
        this.e = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r5) {
        this.f142a = r5.readString(0, false);
        this.b = r5.readString(1, false);
        this.c = r5.read(this.c, 2, false);
        this.d = r5.read(this.d, 3, false);
        this.e = r5.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r4) {
        String r0 = this.f142a;
        if (r0 == null) goto L5;
        r4.write(r0, 0);
    L5:
        String r1 = this.b;
        if (r1 == null) goto L8;
        r4.write(r1, 1);
    L8:
        r4.write(this.c, 2);
        r4.write(this.d, 3);
        String r3 = this.e;
        if (r3 == null) goto L12;
        r4.write(r3, 4);
        return;
    }

    public d2(String r1, String r2, long r3, long r5, String r7) {
        this.f142a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
        this.e = r7;
    }
}

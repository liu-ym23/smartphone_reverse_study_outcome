package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* JADX INFO: loaded from: classes5.dex */
public final class j1 extends JceStruct {
    static d1 f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d1 f280a;
    public String b;
    public String c;
    public int d;
    public String e;

    static {
        f = new d1();
    }

    public j1() {
        this.f280a = null;
        this.b = "";
        this.c = "";
        this.d = 0;
        this.e = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r4) {
        this.f280a = (d1) r4.read(f, 0, false);
        this.b = r4.readString(1, false);
        this.c = r4.readString(2, false);
        this.d = r4.read(this.d, 3, false);
        this.e = r4.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        d1 r0 = this.f280a;
        if (r0 == null) goto L5;
        r3.write(r0, 0);
    L5:
        String r1 = this.b;
        if (r1 == null) goto L8;
        r3.write(r1, 1);
    L8:
        String r2 = this.c;
        if (r2 == null) goto L11;
        r3.write(r2, 2);
    L11:
        r3.write(this.d, 3);
        String r4 = this.e;
        if (r4 == null) goto L15;
        r3.write(r4, 4);
        return;
    }
}

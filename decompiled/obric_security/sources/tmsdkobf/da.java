package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* JADX INFO: loaded from: classes5.dex */
public final class da extends JceStruct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f150a;
    public String b;
    public int c;
    public String d;
    public String e;

    public da() {
        this.f150a = 0;
        this.b = "";
        this.c = 0;
        this.d = "";
        this.e = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r4) {
        this.f150a = r4.read(this.f150a, 0, true);
        this.b = r4.readString(1, false);
        this.c = r4.read(this.c, 2, false);
        this.d = r4.readString(3, false);
        this.e = r4.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        r3.write(this.f150a, 0);
        String r0 = this.b;
        if (r0 == null) goto L5;
        r3.write(r0, 1);
    L5:
        int r1 = this.c;
        if (r1 == 0) goto L8;
        r3.write(r1, 2);
    L8:
        String r2 = this.d;
        if (r2 == null) goto L11;
        r3.write(r2, 3);
    L11:
        String r4 = this.e;
        if (r4 == null) goto L15;
        r3.write(r4, 4);
        return;
    }
}

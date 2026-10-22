package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* JADX INFO: loaded from: classes5.dex */
public final class g8 extends JceStruct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f215a;
    public String b;
    public String c;

    public g8() {
        this.f215a = "";
        this.b = "";
        this.c = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r3) {
        this.f215a = r3.readString(0, false);
        this.b = r3.readString(1, false);
        this.c = r3.readString(2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        String r0 = this.f215a;
        if (r0 == null) goto L5;
        r3.write(r0, 0);
    L5:
        String r1 = this.b;
        if (r1 == null) goto L8;
        r3.write(r1, 1);
    L8:
        String r2 = this.c;
        if (r2 == null) goto L12;
        r3.write(r2, 2);
        return;
    }
}

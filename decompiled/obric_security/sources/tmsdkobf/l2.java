package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* JADX INFO: loaded from: classes5.dex */
public final class l2 extends JceStruct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f322a;
    public String b;
    public String c;
    public String d;
    public String e;

    public l2() {
        this.f322a = "";
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new l2();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r3) {
        this.f322a = r3.readString(0, false);
        this.b = r3.readString(1, false);
        this.c = r3.readString(2, false);
        this.d = r3.readString(3, false);
        this.e = r3.readString(4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        String r0 = this.f322a;
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
        String r4 = this.d;
        if (r4 == null) goto L14;
        r3.write(r4, 3);
    L14:
        String r5 = this.e;
        if (r5 == null) goto L18;
        r3.write(r5, 4);
        return;
    }
}

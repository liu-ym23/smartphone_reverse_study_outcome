package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* JADX INFO: loaded from: classes5.dex */
public final class tg extends JceStruct {
    static d1 e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d1 f530a;
    public String b;
    public String c;
    public String d;

    static {
        e = new d1();
    }

    public tg() {
        this.f530a = null;
        this.b = "";
        this.c = "";
        this.d = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new tg();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r4) {
        this.f530a = (d1) r4.read(e, 0, true);
        this.b = r4.readString(1, true);
        this.c = r4.readString(2, false);
        this.d = r4.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        r3.write(this.f530a, 0);
        r3.write(this.b, 1);
        String r0 = this.c;
        if (r0 == null) goto L5;
        r3.write(r0, 2);
    L5:
        String r2 = this.d;
        if (r2 == null) goto L9;
        r3.write(r2, 3);
        return;
    }
}

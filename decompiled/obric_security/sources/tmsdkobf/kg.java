package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* JADX INFO: loaded from: classes5.dex */
public final class kg extends JceStruct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f308a;
    public String b;
    public int c;

    public kg() {
        this.f308a = "";
        this.b = "";
        this.c = 1;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r4) {
        this.f308a = r4.readString(0, false);
        this.b = r4.readString(1, false);
        this.c = r4.read(this.c, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        String r0 = this.f308a;
        if (r0 == null) goto L5;
        r3.write(r0, 0);
    L5:
        String r1 = this.b;
        if (r1 == null) goto L8;
        r3.write(r1, 1);
    L8:
        int r2 = this.c;
        if (r2 == 1) goto L12;
        r3.write(r2, 2);
        return;
    }
}

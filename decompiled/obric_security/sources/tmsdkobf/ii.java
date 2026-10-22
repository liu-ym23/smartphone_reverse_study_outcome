package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* JADX INFO: loaded from: classes5.dex */
public final class ii extends JceStruct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f275a;
    public int b;
    public byte[] c;

    public ii() {
        this.f275a = "";
        this.b = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new ii();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r4) {
        this.f275a = r4.readString(0, false);
        this.b = r4.read(this.b, 1, false);
        this.c = r4.read(this.c, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        String r0 = this.f275a;
        if (r0 == null) goto L5;
        r3.write(r0, 0);
    L5:
        int r1 = this.b;
        if (r1 == 0) goto L8;
        r3.write(r1, 1);
    L8:
        byte[] r2 = this.c;
        if (r2 == null) goto L12;
        r3.write(r2, 2);
        return;
    }
}

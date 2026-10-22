package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* JADX INFO: loaded from: classes5.dex */
public final class vg extends JceStruct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f583a;
    public String b;

    public vg() {
        this.f583a = 0;
        this.b = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new vg();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r3) {
        this.f583a = r3.read(this.f583a, 0, false);
        this.b = r3.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        int r0 = this.f583a;
        if (r0 == 0) goto L5;
        r3.write(r0, 0);
    L5:
        String r2 = this.b;
        if (r2 == null) goto L9;
        r3.write(r2, 1);
        return;
    }
}

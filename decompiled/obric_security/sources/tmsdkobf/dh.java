package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* JADX INFO: loaded from: classes5.dex */
public final class dh extends JceStruct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f156a;
    public String b;

    public dh() {
        this.f156a = 0;
        this.b = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new dh();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r3) {
        this.f156a = r3.read(this.f156a, 0, false);
        this.b = r3.readString(1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        r3.write(this.f156a, 0);
        String r2 = this.b;
        if (r2 == null) goto L6;
        r3.write(r2, 1);
        return;
    }
}

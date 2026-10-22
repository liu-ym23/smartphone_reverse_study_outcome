package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* JADX INFO: loaded from: classes5.dex */
public final class bd extends JceStruct {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f118a;

    public bd() {
        this.f118a = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new bd();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r2) {
        this.f118a = r2.readString(0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r2) {
        String r1 = this.f118a;
        if (r1 == null) goto L6;
        r2.write(r1, 0);
        return;
    }
}

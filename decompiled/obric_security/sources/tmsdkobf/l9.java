package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public final class l9 extends JceStruct {
    static ArrayList b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList f325a;

    static {
        ArrayList r0 = new ArrayList();
        b = r0;
        r0.add("");
    }

    public l9() {
        this.f325a = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new l9();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r3) {
        this.f325a = (ArrayList) r3.read(b, 0, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r2) {
        ArrayList r1 = this.f325a;
        if (r1 == null) goto L6;
        r2.write(r1, 0);
        return;
    }
}

package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public final class g1 extends JceStruct {
    static ArrayList c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList f208a;
    public g8 b;

    static {
        ArrayList r0 = new ArrayList();
        c = r0;
        r0.add("");
    }

    public g1() {
        this.f208a = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new g1();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r4) {
        this.f208a = (ArrayList) r4.read(c, 0, true);
        this.b = (g8) r4.read(this.b, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        r3.write(this.f208a, 0);
        g8 r2 = this.b;
        if (r2 == null) goto L6;
        r3.write(r2, 1);
        return;
    }
}

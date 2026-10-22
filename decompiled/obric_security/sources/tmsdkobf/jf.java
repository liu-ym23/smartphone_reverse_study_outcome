package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class jf extends JceStruct {
    static Map c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map f288a;
    public int b;

    static {
        c = new HashMap();
        p4 r1 = new p4();
        c.put(0, r1);
    }

    public jf() {
        this.f288a = null;
        this.b = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r4) {
        this.f288a = (Map) r4.read(c, 0, true);
        this.b = r4.read(this.b, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        r3.write(this.f288a, 0);
        int r2 = this.b;
        if (r2 == 0) goto L6;
        r3.write(r2, 1);
        return;
    }
}

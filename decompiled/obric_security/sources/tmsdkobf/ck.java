package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class ck extends JceStruct {
    static Map c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map f136a;
    public int b;

    static {
        HashMap r0 = new HashMap();
        c = r0;
        r0.put("", "");
    }

    public ck() {
        this.f136a = null;
        this.b = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new ck();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r4) {
        this.f136a = (Map) r4.read(c, 0, false);
        this.b = r4.read(this.b, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        Map r0 = this.f136a;
        if (r0 == null) goto L5;
        r3.write(r0, 0);
    L5:
        int r2 = this.b;
        if (r2 == 0) goto L9;
        r3.write(r2, 1);
        return;
    }
}

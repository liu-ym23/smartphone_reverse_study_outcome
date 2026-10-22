package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class vj extends JceStruct {
    static Map e;
    static Map f;
    static Map g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map f586a;
    public Map b;
    public Map c;
    public String d;

    static {
        HashMap r0 = new HashMap();
        e = r0;
        r0.put("", "");
        HashMap r1 = new HashMap();
        f = r1;
        r1.put("", "");
        HashMap r2 = new HashMap();
        g = r2;
        r2.put("", "");
    }

    public vj() {
        this.f586a = null;
        this.b = null;
        this.c = null;
        this.d = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new vj();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r4) {
        this.f586a = (Map) r4.read(e, 0, false);
        this.b = (Map) r4.read(f, 1, false);
        this.c = (Map) r4.read(g, 2, false);
        this.d = r4.readString(3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        Map r0 = this.f586a;
        if (r0 == null) goto L5;
        r3.write(r0, 0);
    L5:
        Map r1 = this.b;
        if (r1 == null) goto L8;
        r3.write(r1, 1);
    L8:
        Map r2 = this.c;
        if (r2 == null) goto L11;
        r3.write(r2, 2);
    L11:
        String r4 = this.d;
        if (r4 == null) goto L15;
        r3.write(r4, 3);
        return;
    }
}

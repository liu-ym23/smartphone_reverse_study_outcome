package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class kc extends JceStruct {
    static ArrayList e;
    static Map f;
    static Map g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList f305a;
    public Map b;
    public Map c;
    public int d;

    static {
        e = new ArrayList();
        zb r0 = new zb();
        e.add(r0);
        f = new HashMap();
        bg r1 = new bg();
        f.put(0, r1);
        g = new HashMap();
        b r2 = new b();
        g.put(0, r2);
    }

    public kc() {
        this.f305a = null;
        this.b = null;
        this.c = null;
        this.d = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new kc();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r4) {
        this.f305a = (ArrayList) r4.read(e, 0, false);
        this.b = (Map) r4.read(f, 1, false);
        this.c = (Map) r4.read(g, 2, false);
        this.d = r4.read(this.d, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        ArrayList r0 = this.f305a;
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
        int r4 = this.d;
        if (r4 == 0) goto L15;
        r3.write(r4, 3);
        return;
    }
}

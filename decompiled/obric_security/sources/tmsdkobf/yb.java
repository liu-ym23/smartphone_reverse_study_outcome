package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class yb extends JceStruct {
    static Map e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f638a;
    public Map b;
    public int c;
    public int d;

    static {
        e = new HashMap();
        ArrayList r2 = new ArrayList();
        r2.add(new byte[]{0});
        e.put(0, r2);
    }

    public yb() {
        this.f638a = 2;
        this.b = null;
        this.c = 0;
        this.d = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new yb();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r4) {
        this.f638a = r4.read(this.f638a, 0, true);
        this.b = (Map) r4.read(e, 1, false);
        this.c = r4.read(this.c, 2, false);
        this.d = r4.read(this.d, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        r3.write(this.f638a, 0);
        Map r0 = this.b;
        if (r0 == null) goto L5;
        r3.write(r0, 1);
    L5:
        int r1 = this.c;
        if (r1 == 0) goto L8;
        r3.write(r1, 2);
    L8:
        int r2 = this.d;
        if (r2 == 0) goto L12;
        r3.write(r2, 3);
        return;
    }
}

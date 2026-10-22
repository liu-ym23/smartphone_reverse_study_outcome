package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class x3 extends JceStruct {
    static Map d;
    static ArrayList e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f611a;
    public Map b;
    public ArrayList c;

    static {
        d = new HashMap();
        d.put(0, "");
        ArrayList r0 = new ArrayList();
        e = r0;
        r0.add("");
    }

    public x3() {
        this.f611a = 0;
        this.b = null;
        this.c = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r4) {
        this.f611a = r4.read(this.f611a, 0, true);
        this.b = (Map) r4.read(d, 1, false);
        this.c = (ArrayList) r4.read(e, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        r3.write(this.f611a, 0);
        Map r0 = this.b;
        if (r0 == null) goto L5;
        r3.write(r0, 1);
    L5:
        ArrayList r2 = this.c;
        if (r2 == null) goto L9;
        r3.write(r2, 2);
        return;
    }
}

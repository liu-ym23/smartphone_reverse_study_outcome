package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class rb extends JceStruct {
    static Map e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f477a;
    public Map b;
    public int c;
    public int d;

    static {
        e = new HashMap();
        e.put(0, 0);
    }

    public rb() {
        this.f477a = "";
        this.b = null;
        this.c = 0;
        this.d = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new rb();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r4) {
        this.f477a = r4.readString(0, false);
        this.b = (Map) r4.read(e, 1, false);
        this.c = r4.read(this.c, 2, false);
        this.d = r4.read(this.d, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        String r0 = this.f477a;
        if (r0 == null) goto L5;
        r3.write(r0, 0);
    L5:
        Map r1 = this.b;
        if (r1 == null) goto L8;
        r3.write(r1, 1);
    L8:
        int r2 = this.c;
        if (r2 == 0) goto L11;
        r3.write(r2, 2);
    L11:
        int r4 = this.d;
        if (r4 == 0) goto L15;
        r3.write(r4, 3);
        return;
    }
}

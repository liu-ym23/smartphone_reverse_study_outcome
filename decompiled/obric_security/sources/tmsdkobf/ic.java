package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public final class ic extends JceStruct {
    static df f;
    static ff g;
    static ff h;
    static ArrayList i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f270a;
    public df b;
    public ff c;
    public ff d;
    public ArrayList e;

    static {
        f = new df();
        g = new ff();
        h = new ff();
        i = new ArrayList();
        pd r0 = new pd();
        i.add(r0);
    }

    public ic() {
        this.f270a = "";
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new ic();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r4) {
        this.f270a = r4.readString(0, true);
        this.b = (df) r4.read(f, 1, false);
        this.c = (ff) r4.read(g, 2, false);
        this.d = (ff) r4.read(h, 3, false);
        this.e = (ArrayList) r4.read(i, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        r3.write(this.f270a, 0);
        df r0 = this.b;
        if (r0 == null) goto L5;
        r3.write(r0, 1);
    L5:
        ff r1 = this.c;
        if (r1 == null) goto L8;
        r3.write(r1, 2);
    L8:
        ff r2 = this.d;
        if (r2 == null) goto L11;
        r3.write(r2, 3);
    L11:
        ArrayList r4 = this.e;
        if (r4 == null) goto L15;
        r3.write(r4, 4);
        return;
    }
}

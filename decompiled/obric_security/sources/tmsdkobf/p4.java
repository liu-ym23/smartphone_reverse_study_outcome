package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public final class p4 extends JceStruct {
    static ArrayList e;
    static ArrayList f;
    static ArrayList g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f407a;
    public ArrayList b;
    public ArrayList c;
    public ArrayList d;

    static {
        e = new ArrayList();
        e.add(0);
        ArrayList r1 = new ArrayList();
        f = r1;
        r1.add(new byte[]{0});
        ArrayList r0 = new ArrayList();
        g = r0;
        r0.add("");
    }

    public p4() {
        this.f407a = 1;
        this.b = null;
        this.c = null;
        this.d = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r4) {
        this.f407a = r4.read(this.f407a, 0, true);
        this.b = (ArrayList) r4.read(e, 1, false);
        this.c = (ArrayList) r4.read(f, 2, false);
        this.d = (ArrayList) r4.read(g, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        r3.write(this.f407a, 0);
        ArrayList r0 = this.b;
        if (r0 == null) goto L5;
        r3.write(r0, 1);
    L5:
        ArrayList r1 = this.c;
        if (r1 == null) goto L8;
        r3.write(r1, 2);
    L8:
        ArrayList r2 = this.d;
        if (r2 == null) goto L12;
        r3.write(r2, 3);
        return;
    }
}

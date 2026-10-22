package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public final class q4 extends JceStruct {
    static ArrayList h;
    static ArrayList i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f432a;
    public int b;
    public int c;
    public ArrayList d;
    public ArrayList e;
    public int f;
    public int g;

    public q4() {
        this.f432a = 0;
        this.b = 0;
        this.c = 1;
        this.d = null;
        this.e = null;
        this.f = 0;
        this.g = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r4) {
        this.f432a = r4.read(this.f432a, 0, true);
        this.b = r4.read(this.b, 1, true);
        this.c = r4.read(this.c, 2, false);
        if (h != null) goto L5;
        h = new ArrayList();
        h.add(0);
    L5:
        this.d = (ArrayList) r4.read(h, 3, false);
        if (i != null) goto L8;
        ArrayList r0 = new ArrayList();
        i = r0;
        r0.add("");
    L8:
        this.e = (ArrayList) r4.read(i, 4, false);
        this.f = r4.read(this.f, 5, false);
        this.g = r4.read(this.g, 6, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        r3.write(this.f432a, 0);
        r3.write(this.b, 1);
        int r0 = this.c;
        if (r0 == 1) goto L5;
        r3.write(r0, 2);
    L5:
        ArrayList r1 = this.d;
        if (r1 == null) goto L8;
        r3.write(r1, 3);
    L8:
        ArrayList r2 = this.e;
        if (r2 == null) goto L11;
        r3.write(r2, 4);
    L11:
        int r4 = this.f;
        if (r4 == 0) goto L14;
        r3.write(r4, 5);
    L14:
        int r5 = this.g;
        if (r5 == 0) goto L18;
        r3.write(r5, 6);
        return;
    }
}

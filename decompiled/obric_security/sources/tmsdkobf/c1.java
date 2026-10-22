package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public final class c1 extends JceStruct {
    static kg j;
    static ArrayList k;
    static ArrayList l;
    static ArrayList m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public kg f122a;
    public ArrayList b;
    public ArrayList c;
    public ArrayList d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;

    static {
        j = new kg();
        ArrayList r0 = new ArrayList();
        k = r0;
        r0.add("");
        ArrayList r1 = new ArrayList();
        l = r1;
        r1.add("");
        ArrayList r2 = new ArrayList();
        m = r2;
        r2.add("");
    }

    public c1() {
        this.f122a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r4) {
        this.f122a = (kg) r4.read(j, 0, false);
        this.b = (ArrayList) r4.read(k, 1, false);
        this.c = (ArrayList) r4.read(l, 2, false);
        this.d = (ArrayList) r4.read(m, 3, false);
        this.e = r4.read(this.e, 4, false);
        this.f = r4.read(this.f, 5, false);
        this.g = r4.read(this.g, 6, false);
        this.h = r4.read(this.h, 7, false);
        this.i = r4.read(this.i, 8, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        kg r0 = this.f122a;
        if (r0 == null) goto L5;
        r3.write(r0, 0);
    L5:
        ArrayList r1 = this.b;
        if (r1 == null) goto L8;
        r3.write(r1, 1);
    L8:
        ArrayList r2 = this.c;
        if (r2 == null) goto L11;
        r3.write(r2, 2);
    L11:
        ArrayList r4 = this.d;
        if (r4 == null) goto L14;
        r3.write(r4, 3);
    L14:
        int r5 = this.e;
        if (r5 == 0) goto L17;
        r3.write(r5, 4);
    L17:
        int r6 = this.f;
        if (r6 == 0) goto L20;
        r3.write(r6, 5);
    L20:
        int r7 = this.g;
        if (r7 == 0) goto L23;
        r3.write(r7, 6);
    L23:
        int r8 = this.h;
        if (r8 == 0) goto L26;
        r3.write(r8, 7);
    L26:
        int r9 = this.i;
        if (r9 == 0) goto L30;
        r3.write(r9, 8);
        return;
    }
}

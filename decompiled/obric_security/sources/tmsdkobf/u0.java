package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public final class u0 extends JceStruct {
    static ArrayList i;
    static ArrayList j;
    static ArrayList k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList f541a;
    public ArrayList b;
    public ArrayList c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;

    static {
        i = new ArrayList();
        kg r0 = new kg();
        i.add(r0);
        ArrayList r1 = new ArrayList();
        j = r1;
        r1.add("");
        ArrayList r2 = new ArrayList();
        k = r2;
        r2.add("");
    }

    public u0() {
        this.f541a = null;
        this.b = null;
        this.c = null;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r4) {
        this.f541a = (ArrayList) r4.read(i, 0, false);
        this.b = (ArrayList) r4.read(j, 2, false);
        this.c = (ArrayList) r4.read(k, 3, false);
        this.d = r4.read(this.d, 4, false);
        this.e = r4.read(this.e, 5, false);
        this.f = r4.read(this.f, 6, false);
        this.g = r4.read(this.g, 7, false);
        this.h = r4.read(this.h, 8, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        ArrayList r0 = this.f541a;
        if (r0 == null) goto L5;
        r3.write(r0, 0);
    L5:
        ArrayList r1 = this.b;
        if (r1 == null) goto L8;
        r3.write(r1, 2);
    L8:
        ArrayList r2 = this.c;
        if (r2 == null) goto L11;
        r3.write(r2, 3);
    L11:
        int r4 = this.d;
        if (r4 == 0) goto L14;
        r3.write(r4, 4);
    L14:
        int r5 = this.e;
        if (r5 == 0) goto L17;
        r3.write(r5, 5);
    L17:
        int r6 = this.f;
        if (r6 == 0) goto L20;
        r3.write(r6, 6);
    L20:
        int r7 = this.g;
        if (r7 == 0) goto L23;
        r3.write(r7, 7);
    L23:
        int r8 = this.h;
        if (r8 == 0) goto L27;
        r3.write(r8, 8);
        return;
    }
}

package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public final class zb extends JceStruct {
    static ArrayList j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f661a;
    public int b;
    public int c;
    public int d;
    public ArrayList e;
    public int f;
    public int g;
    public String h;
    public int i;

    static {
        j = new ArrayList();
        j.add(0);
    }

    public zb() {
        this.f661a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = null;
        this.f = 0;
        this.g = 0;
        this.h = "";
        this.i = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new zb();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r4) {
        this.f661a = r4.read(this.f661a, 0, true);
        this.b = r4.read(this.b, 1, false);
        this.c = r4.read(this.c, 2, false);
        this.d = r4.read(this.d, 3, false);
        this.e = (ArrayList) r4.read(j, 4, false);
        this.f = r4.read(this.f, 5, false);
        this.g = r4.read(this.g, 6, false);
        this.h = r4.readString(7, false);
        this.i = r4.read(this.i, 8, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        r3.write(this.f661a, 0);
        r3.write(this.b, 1);
        int r0 = this.c;
        if (r0 == 0) goto L5;
        r3.write(r0, 2);
    L5:
        int r1 = this.d;
        if (r1 == 0) goto L8;
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
        r3.write(this.g, 6);
        String r5 = this.h;
        if (r5 == null) goto L17;
        r3.write(r5, 7);
    L17:
        r3.write(this.i, 8);
    }
}

package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public final class pc extends JceStruct {
    static ArrayList k;
    static ArrayList l;
    static wh m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f417a;
    public int b;
    public ArrayList c;
    public ArrayList d;
    public int e;
    public boolean f;
    public boolean g;
    public int h;
    public int i;
    public wh j;

    static {
        k = new ArrayList();
        k.add(0);
        l = new ArrayList();
        di r0 = new di();
        l.add(r0);
        m = new wh();
    }

    public pc() {
        this.f417a = 0;
        this.b = 0;
        this.c = null;
        this.d = null;
        this.e = 0;
        this.f = true;
        this.g = true;
        this.h = 120;
        this.i = 10;
        this.j = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new pc();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r4) {
        this.f417a = r4.read(this.f417a, 0, true);
        this.b = r4.read(this.b, 1, false);
        this.c = (ArrayList) r4.read(k, 2, false);
        this.d = (ArrayList) r4.read(l, 3, false);
        this.e = r4.read(this.e, 4, false);
        this.f = r4.read(this.f, 5, false);
        this.g = r4.read(this.g, 6, false);
        this.h = r4.read(this.h, 7, false);
        this.i = r4.read(this.i, 8, false);
        this.j = (wh) r4.read(m, 9, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        r3.write(this.f417a, 0);
        int r0 = this.b;
        if (r0 == 0) goto L5;
        r3.write(r0, 1);
    L5:
        ArrayList r1 = this.c;
        if (r1 == null) goto L8;
        r3.write(r1, 2);
    L8:
        ArrayList r2 = this.d;
        if (r2 == null) goto L11;
        r3.write(r2, 3);
    L11:
        int r4 = this.e;
        if (r4 == 0) goto L14;
        r3.write(r4, 4);
    L14:
        r3.write(this.f, 5);
        r3.write(this.g, 6);
        int r5 = this.h;
        if (r5 == 120) goto L17;
        r3.write(r5, 7);
    L17:
        int r6 = this.i;
        if (r6 == 10) goto L20;
        r3.write(r6, 8);
    L20:
        wh r7 = this.j;
        if (r7 == null) goto L24;
        r3.write(r7, 9);
        return;
    }
}

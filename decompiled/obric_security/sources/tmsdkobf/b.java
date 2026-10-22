package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public final class b extends JceStruct {
    static ArrayList g;
    static ArrayList h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f104a;
    public int b;
    public int c;
    public ArrayList d;
    public ArrayList e;
    public String f;

    static {
        ArrayList r0 = new ArrayList();
        g = r0;
        r0.add("");
        ArrayList r1 = new ArrayList();
        h = r1;
        r1.add("");
    }

    public b() {
        this.f104a = 0;
        this.b = 0;
        this.c = 0;
        this.d = null;
        this.e = null;
        this.f = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new b();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r4) {
        this.f104a = r4.read(this.f104a, 0, false);
        this.b = r4.read(this.b, 1, false);
        this.c = r4.read(this.c, 2, false);
        this.d = (ArrayList) r4.read(g, 3, false);
        this.e = (ArrayList) r4.read(h, 4, false);
        this.f = r4.readString(5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        r3.write(this.f104a, 0);
        int r0 = this.b;
        if (r0 == 0) goto L5;
        r3.write(r0, 1);
    L5:
        int r1 = this.c;
        if (r1 == 0) goto L8;
        r3.write(r1, 2);
    L8:
        ArrayList r2 = this.d;
        if (r2 == null) goto L11;
        r3.write(r2, 3);
    L11:
        ArrayList r4 = this.e;
        if (r4 == null) goto L14;
        r3.write(r4, 4);
    L14:
        String r5 = this.f;
        if (r5 == null) goto L18;
        r3.write(r5, 5);
        return;
    }
}

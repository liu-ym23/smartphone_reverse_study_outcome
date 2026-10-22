package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public final class g extends JceStruct {
    static ArrayList h;
    static ArrayList i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f207a;
    public int b;
    public int c;
    public int d;
    public ArrayList e;
    public ArrayList f;
    public String g;

    public g() {
        this.f207a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = null;
        this.f = null;
        this.g = "";
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r5) {
        this.f207a = r5.read(this.f207a, 0, true);
        this.b = r5.read(this.b, 1, true);
        this.c = r5.read(this.c, 2, true);
        this.d = r5.read(this.d, 3, true);
        if (h != null) goto L5;
        ArrayList r0 = new ArrayList();
        h = r0;
        r0.add("");
    L5:
        this.e = (ArrayList) r5.read(h, 4, true);
        if (i != null) goto L8;
        ArrayList r1 = new ArrayList();
        i = r1;
        r1.add("");
    L8:
        this.f = (ArrayList) r5.read(i, 5, true);
        this.g = r5.readString(6, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        r3.write(this.f207a, 0);
        r3.write(this.b, 1);
        r3.write(this.c, 2);
        r3.write(this.d, 3);
        r3.write(this.e, 4);
        r3.write(this.f, 5);
        r3.write(this.g, 6);
    }
}

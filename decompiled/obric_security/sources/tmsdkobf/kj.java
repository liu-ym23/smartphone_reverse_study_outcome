package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public final class kj extends JceStruct {
    static ArrayList d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f311a;
    public int b;
    public ArrayList c;

    static {
        d = new ArrayList();
        ij r0 = new ij();
        d.add(r0);
    }

    public kj() {
        this.f311a = 0;
        this.b = 0;
        this.c = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new kj();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r4) {
        this.f311a = r4.read(this.f311a, 0, false);
        this.b = r4.read(this.b, 1, false);
        this.c = (ArrayList) r4.read(d, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        int r0 = this.f311a;
        if (r0 == 0) goto L5;
        r3.write(r0, 0);
    L5:
        int r1 = this.b;
        if (r1 == 0) goto L8;
        r3.write(r1, 1);
    L8:
        ArrayList r2 = this.c;
        if (r2 == null) goto L12;
        r3.write(r2, 2);
        return;
    }
}

package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public final class f1 extends JceStruct {
    static ArrayList g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f193a;
    public int b;
    public int c;
    public ArrayList d;
    public int e;
    public boolean f;

    static {
        ArrayList r0 = new ArrayList();
        g = r0;
        r0.add(new byte[]{0});
    }

    public f1() {
        this.f193a = 0;
        this.b = 0;
        this.c = 0;
        this.d = null;
        this.e = 0;
        this.f = false;
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new f1();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r5) {
        this.f193a = r5.read(this.f193a, 0, true);
        this.b = r5.read(this.b, 1, true);
        this.c = r5.read(this.c, 2, true);
        this.d = (ArrayList) r5.read(g, 3, true);
        this.e = r5.read(this.e, 4, false);
        this.f = r5.read(this.f, 5, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        r3.write(this.f193a, 0);
        r3.write(this.b, 1);
        r3.write(this.c, 2);
        r3.write(this.d, 3);
        int r0 = this.e;
        if (r0 == 0) goto L5;
        r3.write(r0, 4);
    L5:
        boolean r2 = this.f;
        if (r2 == false) goto L9;
        r3.write(r2, 5);
        return;
    }
}

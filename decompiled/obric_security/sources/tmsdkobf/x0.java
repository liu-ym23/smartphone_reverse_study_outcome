package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public final class x0 extends JceStruct {
    static ArrayList d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList f609a;
    public int b;
    public g8 c;

    static {
        d = new ArrayList();
        e2 r0 = new e2();
        d.add(r0);
    }

    public x0() {
        this.f609a = null;
        this.b = 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r4) {
        this.f609a = (ArrayList) r4.read(d, 0, true);
        this.b = r4.read(this.b, 1, false);
        this.c = (g8) r4.read(this.c, 4, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        ArrayList r0 = this.f609a;
        if (r0 == null) goto L5;
        r3.write(r0, 0);
    L5:
        int r1 = this.b;
        if (r1 == 0) goto L8;
        r3.write(r1, 1);
    L8:
        g8 r2 = this.c;
        if (r2 == null) goto L12;
        r3.write(r2, 4);
        return;
    }
}

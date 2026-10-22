package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public final class a1 extends JceStruct {
    static ArrayList c;
    static da d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList f83a;
    public da b;

    public a1() {
        this.f83a = null;
        this.b = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r4) {
        if (c != null) goto L5;
        c = new ArrayList();
        q4 r0 = new q4();
        c.add(r0);
    L5:
        this.f83a = (ArrayList) r4.read(c, 0, true);
        if (d != null) goto L8;
        d = new da();
    L8:
        this.b = (da) r4.read(d, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        r3.write(this.f83a, 0);
        da r2 = this.b;
        if (r2 == null) goto L6;
        r3.write(r2, 1);
        return;
    }
}

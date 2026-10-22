package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public final class si extends JceStruct {
    static sg e;
    static ArrayList f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f514a;
    public int b;
    public sg c;
    public ArrayList d;

    static {
        e = new sg();
        f = new ArrayList();
        pi r0 = new pi();
        f.add(r0);
    }

    public si() {
        this.f514a = 0;
        this.b = 0;
        this.c = null;
        this.d = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new si();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r4) {
        this.f514a = r4.read(this.f514a, 0, false);
        this.b = r4.read(this.b, 1, false);
        this.c = (sg) r4.read(e, 2, false);
        this.d = (ArrayList) r4.read(f, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        int r0 = this.f514a;
        if (r0 == 0) goto L5;
        r3.write(r0, 0);
    L5:
        int r1 = this.b;
        if (r1 == 0) goto L8;
        r3.write(r1, 1);
    L8:
        sg r2 = this.c;
        if (r2 == null) goto L11;
        r3.write(r2, 2);
    L11:
        ArrayList r4 = this.d;
        if (r4 == null) goto L15;
        r3.write(r4, 3);
        return;
    }
}

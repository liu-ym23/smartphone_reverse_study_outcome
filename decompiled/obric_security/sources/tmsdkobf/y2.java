package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public final class y2 extends JceStruct {
    static ArrayList d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f630a;
    public long b;
    public ArrayList c;

    static {
        d = new ArrayList();
        r2 r0 = new r2();
        d.add(r0);
    }

    public y2() {
        this.f630a = 0;
        this.b = 0;
        this.c = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new y2();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r5) {
        this.f630a = r5.read(this.f630a, 0, false);
        this.b = r5.read(this.b, 1, false);
        this.c = (ArrayList) r5.read(d, 2, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r6) {
        long r0 = this.f630a;
        if (r0 == 0) goto L5;
        r6.write(r0, 0);
    L5:
        long r1 = this.b;
        if (r1 == 0) goto L8;
        r6.write(r1, 1);
    L8:
        ArrayList r5 = this.c;
        if (r5 == null) goto L12;
        r6.write(r5, 2);
        return;
    }
}

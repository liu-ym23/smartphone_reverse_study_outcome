package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public final class qc extends JceStruct {
    static cg c;
    static ArrayList d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public cg f441a;
    public ArrayList b;

    static {
        c = new cg();
        d = new ArrayList();
        ag r0 = new ag();
        d.add(r0);
    }

    public qc() {
        this.f441a = null;
        this.b = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new qc();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r4) {
        this.f441a = (cg) r4.read(c, 0, true);
        this.b = (ArrayList) r4.read(d, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        cg r0 = this.f441a;
        if (r0 == null) goto L5;
        r3.write(r0, 0);
    L5:
        ArrayList r2 = this.b;
        if (r2 == null) goto L9;
        r3.write(r2, 1);
        return;
    }
}

package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public final class k1 extends JceStruct {
    static qb c;
    static ArrayList d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public qb f298a;
    public ArrayList b;

    static {
        c = new qb();
        d = new ArrayList();
        pb r0 = new pb();
        d.add(r0);
    }

    public k1() {
        this.f298a = null;
        this.b = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new k1();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r4) {
        this.f298a = (qb) r4.read(c, 0, false);
        this.b = (ArrayList) r4.read(d, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        qb r0 = this.f298a;
        if (r0 == null) goto L5;
        r3.write(r0, 0);
    L5:
        ArrayList r2 = this.b;
        if (r2 == null) goto L9;
        r3.write(r2, 1);
        return;
    }
}

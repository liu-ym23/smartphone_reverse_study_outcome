package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public final class fc extends JceStruct {
    static ArrayList b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList f198a;

    static {
        b = new ArrayList();
        mk r0 = new mk();
        b.add(r0);
    }

    public fc() {
        this.f198a = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new fc();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r4) {
        this.f198a = (ArrayList) r4.read(b, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r2) {
        r2.write(this.f198a, 0);
    }
}

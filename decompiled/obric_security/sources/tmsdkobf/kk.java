package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes5.dex */
public final class kk extends JceStruct {
    static ArrayList b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList f312a;

    static {
        b = new ArrayList();
        HashMap r0 = new HashMap();
        r0.put(0, "");
        b.add(r0);
    }

    public kk() {
        this.f312a = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new kk();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r4) {
        this.f312a = (ArrayList) r4.read(b, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r2) {
        r2.write(this.f312a, 0);
    }
}

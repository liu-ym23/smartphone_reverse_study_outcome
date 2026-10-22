package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public final class gc extends JceStruct {
    static ArrayList b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList f217a;

    static {
        b = new ArrayList();
        mk r0 = new mk();
        b.add(r0);
    }

    public gc() {
        this.f217a = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r4) {
        this.f217a = (ArrayList) r4.read(b, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r2) {
        r2.write(this.f217a, 0);
    }
}

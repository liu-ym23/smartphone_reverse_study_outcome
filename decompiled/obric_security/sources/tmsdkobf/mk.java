package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes5.dex */
public final class mk extends JceStruct {
    static ArrayList c;
    static byte[] d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList f357a;
    public byte[] b;

    static {
        c = new ArrayList();
        HashMap r0 = new HashMap();
        r0.put(0, "");
        c.add(r0);
        d = new byte[]{0};
    }

    public mk() {
        this.f357a = null;
        this.b = null;
    }

    @Override // com.qq.taf.jce.JceStruct
    public JceStruct newInit() {
        return new mk();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r4) {
        this.f357a = (ArrayList) r4.read(c, 0, true);
        this.b = r4.read(d, 1, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        r3.write(this.f357a, 0);
        byte[] r2 = this.b;
        if (r2 == null) goto L6;
        r3.write(r2, 1);
        return;
    }
}

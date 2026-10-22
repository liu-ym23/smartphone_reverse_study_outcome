package tmsdkobf;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class ob extends JceStruct implements Cloneable {
    static Map b = null;
    static final /* synthetic */ boolean c = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map f394a;

    static {
        b = new HashMap();
        b.put(0, "");
    }

    public ob() {
        this.f394a = null;
    }

    public Object clone() {
        return super.clone();
    L5:
        if (c == false) goto L9;
        return null;
    L9:
        throw new AssertionError();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void display(StringBuilder r2, int r3) {
        new JceDisplayer(r2, r3).display(this.f394a, "mapRecord");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(StringBuilder r2, int r3) {
        new JceDisplayer(r2, r3).displaySimple(this.f394a, false);
    }

    public boolean equals(Object r1) {
        if (r1 != null) goto L6;
        return false;
    L6:
        return a8.a(this.f394a, ((ob) r1).f394a);
    }

    public int hashCode() {
    L4:
        e = move-exception;
        e.printStackTrace();
        return 0;
    L3:
        throw new Exception("Need define key first!");     // Catch: Exception -> L4
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream r4) {
        this.f394a = (Map) r4.read(b, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r2) {
        r2.write(this.f394a, 0);
    }

    public ob(Map r1) {
        this.f394a = r1;
    }
}

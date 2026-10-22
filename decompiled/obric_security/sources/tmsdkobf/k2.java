package tmsdkobf;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public final class k2 extends JceStruct implements Cloneable {
    static ArrayList b = null;
    static final /* synthetic */ boolean c = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ArrayList f299a;

    static {
    }

    public k2() {
        this.f299a = null;
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
        new JceDisplayer(r2, r3).display(this.f299a, "vctCommList");
    }

    public boolean equals(Object r1) {
        if (r1 != null) goto L6;
        return false;
    L6:
        return a8.a(this.f299a, ((k2) r1).f299a);
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
        if (b != null) goto L5;
        b = new ArrayList();
        j2 r0 = new j2();
        b.add(r0);
    L5:
        this.f299a = (ArrayList) r4.read(b, 0, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r2) {
        r2.write(this.f299a, 0);
    }
}

package tmsdkobf;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public final class e1 extends JceStruct implements Cloneable {
    static ArrayList c = null;
    static final /* synthetic */ boolean d = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f169a;
    public ArrayList b;

    static {
        c = new ArrayList();
        ob r0 = new ob();
        c.add(r0);
    }

    public e1(int r1, ArrayList r2) {
        this.f169a = r1;
        this.b = r2;
    }

    public Object clone() {
        return super.clone();
    L5:
        if (d == false) goto L9;
        return null;
    L9:
        throw new AssertionError();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void display(StringBuilder r2, int r3) {
        JceDisplayer r0 = new JceDisplayer(r2, r3);
        r0.display(this.f169a, "reportID");
        r0.display(this.b, "vecReportInfo");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(StringBuilder r2, int r3) {
        JceDisplayer r0 = new JceDisplayer(r2, r3);
        r0.displaySimple(this.f169a, true);
        r0.displaySimple(this.b, false);
    }

    public boolean equals(Object r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        e1 r5 = (e1) r4;
        if (a8.a(this.f169a, r5.f169a) == true) goto L8;
        return false;
    L8:
        if (a8.a(this.b, r5.b) == false) goto L12;
        return true;
    L12:
        return false;
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
        this.f169a = r4.read(this.f169a, 0, true);
        this.b = (ArrayList) r4.read(c, 1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        r3.write(this.f169a, 0);
        r3.write(this.b, 1);
    }
}

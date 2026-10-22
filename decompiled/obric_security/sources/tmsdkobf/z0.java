package tmsdkobf;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* JADX INFO: loaded from: classes5.dex */
public final class z0 extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean c = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f650a;
    public String b;

    static {
    }

    public z0() {
        this.f650a = "";
        this.b = "";
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
        JceDisplayer r0 = new JceDisplayer(r2, r3);
        r0.display(this.f650a, "channelId");
        r0.display(this.b, "pkgSignatureMd5");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(StringBuilder r2, int r3) {
        JceDisplayer r0 = new JceDisplayer(r2, r3);
        r0.displaySimple(this.f650a, true);
        r0.displaySimple(this.b, false);
    }

    public boolean equals(Object r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        z0 r5 = (z0) r4;
        if (a8.a(this.f650a, r5.f650a) == true) goto L8;
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
    public void readFrom(JceInputStream r3) {
        this.f650a = r3.readString(0, true);
        this.b = r3.readString(1, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        r3.write(this.f650a, 0);
        r3.write(this.b, 1);
    }
}

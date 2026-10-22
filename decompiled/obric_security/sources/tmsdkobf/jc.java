package tmsdkobf;

import com.bytedance.apm.constant.SlardarConfigConsts;
import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* JADX INFO: loaded from: classes5.dex */
public final class jc extends JceStruct implements Cloneable {
    static int d = 0;
    static final /* synthetic */ boolean e = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f287a;
    public long b;
    public String c;

    static {
    }

    public jc() {
        this.f287a = 0;
        this.b = 0;
        this.c = "";
    }

    public Object clone() {
        return super.clone();
    L5:
        if (e == false) goto L9;
        return null;
    L9:
        throw new AssertionError();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void display(StringBuilder r3, int r4) {
        JceDisplayer r0 = new JceDisplayer(r3, r4);
        r0.display(this.f287a, SlardarConfigConsts.CONFIG_RET);
        r0.display(this.b, "invalidTime");
        r0.display(this.c, "invalidTime_sec");
    }

    @Override // com.qq.taf.jce.JceStruct
    public void displaySimple(StringBuilder r4, int r5) {
        JceDisplayer r0 = new JceDisplayer(r4, r5);
        r0.displaySimple(this.f287a, true);
        r0.displaySimple(this.b, true);
        r0.displaySimple(this.c, false);
    }

    public boolean equals(Object r6) {
        if (r6 != null) goto L5;
        return false;
    L5:
        jc r7 = (jc) r6;
        if (a8.a(this.f287a, r7.f287a) == true) goto L8;
        return false;
    L8:
        if (a8.a(this.b, r7.b) == true) goto L10;
        return false;
    L10:
        if (a8.a(this.c, r7.c) == false) goto L15;
        return true;
    L15:
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
        this.f287a = r4.read(this.f287a, 0, true);
        this.b = r4.read(this.b, 1, true);
        this.c = r4.readString(2, true);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r4) {
        r4.write(this.f287a, 0);
        r4.write(this.b, 1);
        r4.write(this.c, 2);
    }
}

package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* JADX INFO: loaded from: classes5.dex */
public final class zf extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean c = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public short f665a;
    public String b;

    static {
    }

    public zf() {
        this.f665a = 0;
        this.b = "";
        a(0);
        a(this.b);
    }

    public void a(String r1) {
        this.b = r1;
    }

    public Object clone() {
        return super.clone();
    L5:
        if (c == false) goto L9;
        return null;
    L9:
        throw new AssertionError();
    }

    public boolean equals(Object r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        zf r5 = (zf) r4;
        if (a8.a(this.f665a, r5.f665a) == true) goto L8;
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
        a(r4.read(this.f665a, 0, true));
        a(r4.readString(1, true));
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        r3.write(this.f665a, 0);
        r3.write(this.b, 1);
    }

    public void a(short r1) {
        this.f665a = r1;
    }
}

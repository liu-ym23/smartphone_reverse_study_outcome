package tmsdkobf;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* JADX INFO: loaded from: classes5.dex */
public final class b2 extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean e = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f107a;
    public float b;
    public String c;
    public int d;

    static {
    }

    public b2() {
        this.f107a = 0;
        this.b = 0.0f;
        this.c = "";
        this.d = 0;
    }

    public Object clone() {
        return super.clone();
    L5:
        if (e == false) goto L9;
        return null;
    L9:
        throw new AssertionError();
    }

    public boolean equals(Object r6) {
        if (r6 != null) goto L5;
        return false;
    L5:
        b2 r7 = (b2) r6;
        if (a8.a(this.f107a, r7.f107a) == true) goto L8;
        return false;
    L8:
        if (a8.a(this.b, r7.b) == true) goto L10;
        return false;
    L10:
        if (a8.a(this.c, r7.c) == true) goto L12;
        return false;
    L12:
        if (a8.a(this.d, r7.d) == false) goto L18;
        return true;
    L18:
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
    public void readFrom(JceInputStream r5) {
        this.f107a = r5.read(this.f107a, 0, true);
        this.b = r5.read(this.b, 1, true);
        this.c = r5.readString(2, true);
        this.d = r5.read(this.d, 3, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r4) {
        r4.write(this.f107a, 0);
        r4.write(this.b, 1);
        r4.write(this.c, 2);
        r4.write(this.d, 3);
    }
}

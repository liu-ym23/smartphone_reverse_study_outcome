package tmsdkobf;

import com.bytedance.framwork.core.sdklib.DBHelper;
import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* JADX INFO: loaded from: classes5.dex */
public final class j2 extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean i = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f281a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;

    static {
    }

    public j2() {
        this.f281a = "";
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = "";
    }

    public Object clone() {
        return super.clone();
    L5:
        if (i == false) goto L9;
        return null;
    L9:
        throw new AssertionError();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void display(StringBuilder r2, int r3) {
        JceDisplayer r0 = new JceDisplayer(r2, r3);
        r0.display(this.f281a, "data1");
        r0.display(this.b, DBHelper.COL_DATA2);
        r0.display(this.c, DBHelper.COL_DATA3);
        r0.display(this.d, "data4");
        r0.display(this.e, "data5");
        r0.display(this.f, "data6");
        r0.display(this.g, "data7");
        r0.display(this.h, "data8");
    }

    public boolean equals(Object r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        j2 r5 = (j2) r4;
        if (a8.a(this.f281a, r5.f281a) == true) goto L8;
        return false;
    L8:
        if (a8.a(this.b, r5.b) == true) goto L10;
        return false;
    L10:
        if (a8.a(this.c, r5.c) == true) goto L12;
        return false;
    L12:
        if (a8.a(this.d, r5.d) == true) goto L14;
        return false;
    L14:
        if (a8.a(this.e, r5.e) == true) goto L16;
        return false;
    L16:
        if (a8.a(this.f, r5.f) == true) goto L18;
        return false;
    L18:
        if (a8.a(this.g, r5.g) == true) goto L20;
        return false;
    L20:
        if (a8.a(this.h, r5.h) == false) goto L30;
        return true;
    L30:
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
        this.f281a = r3.readString(0, false);
        this.b = r3.readString(1, false);
        this.c = r3.readString(3, false);
        this.d = r3.readString(4, false);
        this.e = r3.readString(5, false);
        this.f = r3.readString(6, false);
        this.g = r3.readString(7, false);
        this.h = r3.readString(8, false);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream r3) {
        String r0 = this.f281a;
        if (r0 == null) goto L5;
        r3.write(r0, 0);
    L5:
        String r1 = this.b;
        if (r1 == null) goto L8;
        r3.write(r1, 1);
    L8:
        String r2 = this.c;
        if (r2 == null) goto L11;
        r3.write(r2, 3);
    L11:
        String r4 = this.d;
        if (r4 == null) goto L14;
        r3.write(r4, 4);
    L14:
        String r5 = this.e;
        if (r5 == null) goto L17;
        r3.write(r5, 5);
    L17:
        String r6 = this.f;
        if (r6 == null) goto L20;
        r3.write(r6, 6);
    L20:
        String r7 = this.g;
        if (r7 == null) goto L23;
        r3.write(r7, 7);
    L23:
        String r8 = this.h;
        if (r8 == null) goto L27;
        r3.write(r8, 8);
        return;
    }
}

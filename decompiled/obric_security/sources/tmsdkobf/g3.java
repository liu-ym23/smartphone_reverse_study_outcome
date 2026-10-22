package tmsdkobf;

import android.os.Process;

/* JADX INFO: loaded from: classes5.dex */
public abstract class g3 {
    public static String a() {
        StringBuilder r0 = new StringBuilder();
        int r1 = Process.myPid();
        af.a r2 = af.b(r1);
        if (r2 == null) goto L5;
        int r3 = r2.e;
        if (r3 == 0) goto L9;
        if (r3 == r1) goto L12;
        r0.append(r1);
        r0.append(",");
        r0.append(r2.b);
        r0.append(",");
        r0.append(r2.c);
        r0.append(",");
        r0.append(r3);
        r0.append(",");
        af.a r4 = af.b(r3);
        if (r4 == null) goto L17;
        r0.append(r4.d);
        r0.append(",");
        r0.append(r4.c);
        r0.append(",");
        r0.append(r4.b);
    L17:
        return r0.toString();
    L12:
        return r0.toString();
    L9:
        return r0.toString();
    L5:
        return r0.toString();
    }
}

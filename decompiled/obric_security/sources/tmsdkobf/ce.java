package tmsdkobf;

import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;
import tmsdk.common.tcc.DeepCleanSAFEngine;

/* JADX INFO: loaded from: classes5.dex */
public class ce implements Comparable {
    private static int s;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f130a;
    public List b;
    public int c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public int k;
    public String l;
    public String m;
    public int n;
    public List o;
    public String p;
    public String q;
    public boolean r;

    static {
    }

    public ce() {
        this.r = false;
        int r0 = s + 1;
        s = r0;
        this.f130a = r0;
    }

    public int a(ce r4) {
        if (r4 != null) goto L5;
        return 1;
    L5:
        int r0 = e3.a(this.e, r4.e);
        if (r0 == 0) goto L8;
        return r0;
    L8:
        List r1 = this.b;
        if (r1 == null) goto L20;
        if (r1.isEmpty() == true) goto L20;
        List r2 = r4.b;
        if (r2 == null) goto L20;
        if (r2.isEmpty() == true) goto L20;
        int r3 = e3.a((String) this.b.get(0), (String) r4.b.get(0));
        if (r3 == 0) goto L20;
        return r3;
    L20:
        return e3.a(this.d, r4.d);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object r1) {
        return a((ce) r1);
    }

    public static void a() {
        s = 0;
    }

    public static void a(StringBuilder r4, ce r5, boolean r6, boolean r7) {
        Iterator r8 = r5.b.iterator();
    L4:
        if (r8.hasNext() == false) goto L27;
        String r0 = (String) r8.next();
        char r1 = DeepCleanSAFEngine.DetailPath.KEY;
        r4.append(DeepCleanSAFEngine.DetailPath.KEY);
        r4.append(r5.f130a);
        r4.append(':');
        r4.append(DeepCleanSAFEngine.DetailPath.IMPORTANT);
        if (r7 == false) goto L8;
        r1 = '1';
    L8:
        r4.append(r1);
        if (TextUtils.isEmpty(r0) == true) goto L12;
        r4.append(':');
        r4.append(DeepCleanSAFEngine.DetailPath.DETAIL_PATH);
        r4.append(r0);
    L12:
        if (TextUtils.isEmpty(r5.f) == true) goto L15;
        r4.append(':');
        r4.append(DeepCleanSAFEngine.DetailPath.FILENAME);
        r4.append(r5.f);
    L15:
        if (TextUtils.isEmpty(r5.g) == true) goto L18;
        r4.append(':');
        r4.append(DeepCleanSAFEngine.DetailPath.FILESIZE);
        r4.append(r5.g);
    L18:
        if (TextUtils.isEmpty(r5.h) == true) goto L21;
        r4.append(':');
        r4.append(DeepCleanSAFEngine.DetailPath.CTIME);
        r4.append(r5.h);
    L21:
        if (TextUtils.isEmpty(r5.i) == true) goto L24;
        r4.append(':');
        r4.append(DeepCleanSAFEngine.DetailPath.MTIME);
        r4.append(r5.i);
    L24:
        if (TextUtils.isEmpty(r5.j) == true) goto L26;
        r4.append(':');
        r4.append(DeepCleanSAFEngine.DetailPath.ATIME);
        r4.append(r5.j);
    L26:
        r4.append(';');
        goto L4
    }
}

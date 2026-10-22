package tmsdkobf;

import android.text.TextUtils;
import tmsdk.common.tcc.DeepCleanSAFEngine;

/* JADX INFO: loaded from: classes5.dex */
public class kd {
    private static int l;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f306a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public boolean k;

    static {
    }

    public kd() {
        StringBuilder r0 = new StringBuilder("");
        int r1 = l + 1;
        l = r1;
        this.f306a = r0.append(r1).toString();
    }

    public static void a(StringBuilder r2, kd r3) {
        r2.append(DeepCleanSAFEngine.DetailPath.KEY);
        r2.append(r3.f306a);
        if (TextUtils.isEmpty(r3.b) == true) goto L6;
        r2.append(':');
        r2.append(DeepCleanSAFEngine.DetailPath.DETAIL_PATH);
        r2.append(r3.b);
    L6:
        if (TextUtils.isEmpty(r3.c) == true) goto L9;
        r2.append(':');
        r2.append(DeepCleanSAFEngine.DetailPath.FILENAME);
        r2.append(r3.c);
    L9:
        if (TextUtils.isEmpty(r3.d) == true) goto L12;
        r2.append(':');
        r2.append(DeepCleanSAFEngine.DetailPath.FILESIZE);
        r2.append(r3.d);
    L12:
        if (TextUtils.isEmpty(r3.e) == true) goto L15;
        r2.append(':');
        r2.append(DeepCleanSAFEngine.DetailPath.CTIME);
        r2.append(r3.e);
    L15:
        if (TextUtils.isEmpty(r3.f) == true) goto L18;
        r2.append(':');
        r2.append(DeepCleanSAFEngine.DetailPath.MTIME);
        r2.append(r3.f);
    L18:
        if (TextUtils.isEmpty(r3.g) == true) goto L20;
        r2.append(':');
        r2.append(DeepCleanSAFEngine.DetailPath.ATIME);
        r2.append(r3.g);
    L20:
        r2.append(':');
        r2.append('8');
        r2.append(r3.h);
    }
}

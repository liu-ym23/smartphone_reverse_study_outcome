package tmsdkobf;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class u5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f548a;
    public List b;
    public boolean c;

    public u5(long r3, List r5, boolean r6) {
        ArrayList r0 = new ArrayList();
        this.b = r0;
        this.c = false;
        this.f548a = r3;
        if (r5 == null) goto L5;
        r0.addAll(r5);
    L5:
        this.c = r6;
    }

    private static boolean a(String r1) {
        if (tk.a(r1) == false) goto L5;
    L8:
        return true;
    L5:
        if (tk.b(r1) == true) goto L8;
        return false;
    }

    public String toString() {
        return "";
    }

    public static String a(String r6, boolean r7) {
        if (TextUtils.isEmpty(r6) == false) goto L5;
        return null;
    L5:
        int r2 = r6.lastIndexOf(":");
        if (r2 > 0) goto L8;
    L23:
        return null;
    L8:
        if (r2 == (r6.length() - 1)) goto L23;
        String r3 = r6.substring(0, r2);
        if (r3.startsWith("[") == true) goto L13;
    L15:
        String r8 = r6.substring(r2 + 1);
        if (r7 == true) goto L20;
        if (a(r3) == false) goto L23;
    L20:
        if (TextUtils.isDigitsOnly(r8) == false) goto L23;
        return r3 + ":" + r8;
    L13:
        if (r3.endsWith("]") == false) goto L15;
        r3 = r3.substring(1, r3.length() - 1);
        goto L15
    }

    public static List a(List r2, boolean r3) {
        ArrayList r0 = new ArrayList();
        if (r2 != null) goto L5;
    L12:
        return r0;
    L5:
        if (r2.size() <= 0) goto L12;
        Iterator r4 = r2.iterator();
    L8:
        if (r4.hasNext() == false) goto L12;
        String r1 = a((String) r4.next(), r3);
        if (r1 == null) goto L8;
        r0.add(r1);
        goto L8
    }

    public boolean a() {
        if (this.c == true) goto L7;
        if (System.currentTimeMillis() <= this.f548a) goto L7;
    L9:
        return false;
    L7:
        if (this.b.size() <= 0) goto L9;
        return true;
    }
}

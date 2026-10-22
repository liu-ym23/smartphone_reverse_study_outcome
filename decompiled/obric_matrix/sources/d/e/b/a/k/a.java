package d.e.b.a.k;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class a {
    public static boolean a(int r1) {
        List<String> r2 = d.e.b.a.a.a().get(Integer.valueOf(r1));
        if (r2 != null) goto L5;
    L7:
        return false;
    L5:
        if (r2.contains("001") == true) goto L7;
        return true;
    }

    public static boolean b(String r1) {
        return !r1.equals("001");
    }
}

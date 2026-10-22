package d.b.b.o;

import android.util.Pair;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class f {
    public static String a(Object[] r6, String r7) {
        if (r6 != null) goto L5;
        return "";
    L5:
        StringBuilder r0 = new StringBuilder();
        int r1 = r6.length;
        boolean r3 = true;
        int r4 = 0;
    L6:
        if (r4 >= r1) goto L13;
        Object r5 = r6[r4];
        if (r3 == false) goto L10;
        r3 = false;
    L11:
        r0.append(r5.toString());
        r4 = r4 + 1;
        goto L6
    L10:
        r0.append(r7);
        goto L11
    L13:
        return r0.toString();
    }

    public static boolean b(List<?> r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.size() == 0) goto L7;
        return false;
    }

    public static Map<String, String> c(List<Pair<String, String>> r3) {
        if (b(r3) == true) goto L5;
        HashMap r0 = new HashMap();
        Iterator<Pair<String, String>> r4 = r3.iterator();
    L8:
        if (r4.hasNext() == false) goto L15;
        Pair<String, String> r1 = r4.next();
        if (r1 == null) goto L8;
        Object r2 = r1.first;
        if (r2 == null) goto L8;
        r0.put(r2, r1.second);
        goto L8
    L15:
        return r0;
    L5:
        return Collections.emptyMap();
    }

    public static String d(Collection r3, String r4) {
        if (r3 != null) goto L5;
        return null;
    L5:
        StringBuilder r0 = new StringBuilder();
        boolean r1 = true;
        Iterator r5 = r3.iterator();
    L7:
        if (r5.hasNext() == false) goto L14;
        Object r2 = r5.next();
        if (r1 == false) goto L11;
        r1 = false;
    L12:
        r0.append(r2.toString());
        goto L7
    L11:
        r0.append(r4);
        goto L12
    L14:
        return r0.toString();
    }
}

package d.b.s.a.l0;

import android.text.TextUtils;
import android.util.Pair;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class p {
    public static Map<String, String> a(List<Pair<String, String>> r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        HashMap r0 = new HashMap();
        Iterator<Pair<String, String>> r4 = r3.iterator();
    L7:
        if (r4.hasNext() == false) goto L13;
        Pair<String, String> r1 = r4.next();
        if (TextUtils.isEmpty((CharSequence) r1.first) == true) goto L7;
        if (TextUtils.isEmpty((CharSequence) r1.second) == true) goto L7;
        r0.put(r1.first, r1.second);
        goto L7
    L13:
        return r0;
    }
}

package ms.bd.c;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class h0 {
    protected static String LIBNAME;

    public h0() {
    }

    public static synchronized void a(Context r7, int r8, Map<String, String> r9) {
        monitor-enter(h0.class);
        p2.c(r7, LIBNAME, false);     // Catch: Throwable -> L18
        ArrayList r10 = new ArrayList();     // Catch: Throwable -> L18
        String[] r1 = null;
        if (r9 == null) goto L15;
        Iterator<Map.Entry<String, String>> r11 = r9.entrySet().iterator();     // Catch: Throwable -> L18
    L8:
        if (r11.hasNext() == false) goto L14;
        Map.Entry<String, String> r2 = r11.next();     // Catch: Throwable -> L18
        String r3 = r2.getKey();     // Catch: Throwable -> L18
        String r4 = r2.getValue();     // Catch: Throwable -> L18
        if (TextUtils.isEmpty(r3) == true) goto L8;
        if (TextUtils.isEmpty(r4) == true) goto L8;
        r10.add(r3);     // Catch: Throwable -> L18
        r10.add(r4);     // Catch: Throwable -> L18
        goto L8
    L14:
        r1 = (String[]) r10.toArray(new String[0]);     // Catch: Throwable -> L18
    L15:
        int r12 = b.f22318b;     // Catch: Throwable -> L18
        m.a(83886081, r8, 0, null, r1);     // Catch: Throwable -> L18
        monitor-exit(h0.class);
        return;
    L18:
        th = move-exception;
        throw th;
    }
}

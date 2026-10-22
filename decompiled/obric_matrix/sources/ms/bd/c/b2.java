package ms.bd.c;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.view.accessibility.AccessibilityManager;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
final class b2 extends b.a {
    b2() {
    }

    @Override // ms.bd.c.b.a
    public Object b(int r21, long r22, String r24, Object r25) {
        Context r0 = a.a().c();
        JSONArray r1 = new JSONArray();
        AccessibilityManager r2 = (AccessibilityManager) r0.getSystemService((String) m.a(16777217, 0, 0, "d9dae5", new byte[]{116, 56, 20, 16, 73, 49, 110, 26, 60, 61, 124, 47, 14}));
        if (r2 == null) goto L24;
        List r3 = null;
        Method r4 = r2.getClass().getDeclaredMethod((String) m.a(16777217, 0, 0, "102a06", new byte[]{39, 55, 85, 60, 1, 50, 38, 16, 111, 61, 37, 54, 96, 22, 12, 36, 33, 2, 106, 51, 41, 62, 72, 1, 22, 18, 55, 3, 117, 56, 35, 55, 109, 28, 28, 53}), new Class[0]);     // Catch: Throwable -> L25
        if (r4 == null) goto L9;
        r3 = (List) r4.invoke(r2, new Object[0]);     // Catch: Throwable -> L25
    L9:
        if (r3 == null) goto L22;
        if (r3.size() == 0) goto L22;
        Iterator r5 = r3.iterator();
    L15:
        if (r5.hasNext() == false) goto L24;
        AccessibilityServiceInfo r6 = (AccessibilityServiceInfo) r5.next();
        JSONObject r7 = new JSONObject();
        r7.put((String) m.a(16777217, 0, 0, "8be24f", new byte[]{44, 118}), r6.eventTypes);     // Catch: Throwable -> L26
        r7.put((String) m.a(16777217, 0, 0, "b61d38", new byte[]{122, 48}), r6.getId());     // Catch: Throwable -> L26
        r1.put(r7);     // Catch: Throwable -> L26
    L22:
        return r1.toString();
    L24:
        return r1.toString();
    }
}

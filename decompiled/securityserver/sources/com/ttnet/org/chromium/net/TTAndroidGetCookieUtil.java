package com.ttnet.org.chromium.net;

import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import java.net.CookieHandler;
import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace(ApmTrafficStats.KEY_TRAFFIC_STATUS_NET)
public class TTAndroidGetCookieUtil {
    public TTAndroidGetCookieUtil() {
    }

    @CalledByNative
    public static String getCookieHeader(String r5) {
        HashMap r0 = new HashMap();
        StringBuilder r1 = new StringBuilder();
        CookieHandler r2 = CookieHandler.getDefault();     // Catch: Exception -> L27
        if (r2 == null) goto L7;
        Map<String, List<String>> r6 = r2.get(new URI(r5), r0);     // Catch: Exception -> L27
    L8:
        if (r6 == null) goto L26;
        if (r6.size() <= 0) goto L26;
        Iterator<Map.Entry<String, List<String>>> r7 = r6.entrySet().iterator();
    L13:
        if (r7.hasNext() == false) goto L26;
        Map.Entry<String, List<String>> r3 = r7.next();
        if ("Cookie".equalsIgnoreCase(r3.getKey()) == false) goto L13;
        if (r3.getValue().isEmpty() == true) goto L13;
        Iterator<String> r4 = r3.getValue().iterator();
        int r8 = 0;
    L20:
        if (r4.hasNext() == false) goto L13;
        String r9 = r4.next();
        if (r8 <= 0) goto L24;
        r1.append("; ");
    L24:
        r1.append(r9);
        r8 = r8 + 1;
    L26:
        return r1.toString();
    L7:
        r6 = null;
    L28:
        return r1.toString();
    }
}

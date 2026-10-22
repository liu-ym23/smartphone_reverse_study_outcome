package com.android.volley;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public class NetworkResponse {
    public final List<Header> allHeaders;
    public final byte[] data;
    public final Map<String, String> headers;
    public final long networkTimeMs;
    public final boolean notModified;
    public final int statusCode;

    @Deprecated
    public NetworkResponse(int r9, byte[] r10, Map<String, String> r11, boolean r12, long r13) {
        this(r9, r10, r11, toAllHeaderList(r11), r12, r13);
    }

    public NetworkResponse(int r9, byte[] r10, boolean r11, long r12, List<Header> r14) {
        this(r9, r10, toHeaderMap(r14), r14, r11, r12);
    }

    @Deprecated
    public NetworkResponse(int r8, byte[] r9, Map<String, String> r10, boolean r11) {
        this(r8, r9, r10, r11, 0);
    }

    public NetworkResponse(byte[] r8) {
        this(200, r8, false, 0, Collections.emptyList());
    }

    @Deprecated
    public NetworkResponse(byte[] r8, Map<String, String> r9) {
        this(200, r8, r9, false, 0);
    }

    private NetworkResponse(int r1, byte[] r2, Map<String, String> r3, List<Header> r4, boolean r5, long r6) {
        this.statusCode = r1;
        this.data = r2;
        this.headers = r3;
        if (r4 != null) goto L5;
        this.allHeaders = null;
    L6:
        this.notModified = r5;
        this.networkTimeMs = r6;
        return;
    L5:
        this.allHeaders = Collections.unmodifiableList(r4);
        goto L6
    }

    private static Map<String, String> toHeaderMap(List<Header> r3) {
        if (r3 != null) goto L6;
        return null;
    L6:
        if (r3.isEmpty() == true) goto L8;
        TreeMap r0 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        Iterator<Header> r4 = r3.iterator();
    L11:
        if (r4.hasNext() == false) goto L13;
        Header r1 = r4.next();
        r0.put(r1.getName(), r1.getValue());
        goto L11
    L13:
        return r0;
    L8:
        return Collections.emptyMap();
    }

    private static List<Header> toAllHeaderList(Map<String, String> r4) {
        if (r4 != null) goto L6;
        return null;
    L6:
        if (r4.isEmpty() == true) goto L8;
        ArrayList r0 = new ArrayList(r4.size());
        Iterator<Map.Entry<String, String>> r5 = r4.entrySet().iterator();
    L11:
        if (r5.hasNext() == false) goto L13;
        Map.Entry<String, String> r1 = r5.next();
        r0.add(new Header(r1.getKey(), r1.getValue()));
        goto L11
    L13:
        return r0;
    L8:
        return Collections.emptyList();
    }
}

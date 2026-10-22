package com.bytedance.ttnet.diagnosis;

import com.bytedance.frameworks.baselib.network.http.cronet.e.j;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class TTNetDiagnosisService {
    public static final int ACCELERATE_TARGET = 2;
    public static final int ACTION_FORCE_CELLULAR = 1;
    public static final int ACTION_FORCE_DEFAULT = 3;
    public static final int ACTION_FORCE_WIFI = 2;
    public static final int ACTION_UNSPECIFIED = 0;
    public static final int DIAGNOSE_TARGET = 3;
    public static final int DIAGNOSE_V2_TARGET = 4;
    public static final int DNS_RESOLVE_TARGET = 0;
    public static final int NET_DETECT_ALL = -1;
    public static final int NET_DETECT_FULL_DNS = 128;
    public static final int NET_DETECT_HTTP_GET = 1;
    public static final int NET_DETECT_HTTP_ISP = 4096;
    public static final int NET_DETECT_ICMP_PING = 2;
    public static final int NET_DETECT_LOCAL_DNS = 8;
    public static final int NET_DETECT_TCP_CONNECT = 256;
    public static final int NET_DETECT_TCP_ECHO = 512;
    public static final int NET_DETECT_TCP_PERF = 2048;
    public static final int NET_DETECT_TRACEROUTE = 4;
    public static final int NET_DETECT_UDP_PERF = 1024;
    public static final int NET_DETECT_UDP_PING = 64;
    public static final int RACE_TARGETS = 1;
    public static final int RAW_DETECT_TARGETS = 5;
    private static final Map<Integer, String> sTypeStringMap = null;

    static {
        HashMap r0 = new HashMap();
        sTypeStringMap = r0;
        r0.put(0, "DNS_RESOLVE_TARGET");
        r0.put(1, "RACE_TARGETS");
        r0.put(2, "ACCELERATE_TARGET");
        r0.put(3, "DIAGNOSE_TARGET");
        r0.put(4, "DIAGNOSE_V2_TARGET");
        r0.put(5, "RAW_DETECT_TARGETS");
    }

    public TTNetDiagnosisService() {
    }

    public static IDiagnosisRequest createRequest(int r1, String r2, int r3, int r4) {
        return createRequest(r1, r2, r3, 0, r4);
    }

    public static IDiagnosisRequest createRequest(int r6, String r7, int r8, int r9, int r10) {
        if (isOneTargetRequestType(r6) == false) goto L20;
        if (isValidNetDetect(r6, r8) == false) goto L18;
        if (r6 != 0) goto L8;
    L15:
        ArrayList r2 = new ArrayList();
        r2.add(r7);
        return new b(r6, r2, r8, r9, r10);
    L8:
        if (r6 == 2) goto L15;
        if (r6 == 3) goto L15;
        if (r6 == 4) goto L15;
        return null;
    L18:
        throw new IllegalArgumentException("Illegal netDetectType: " + r8);
    L20:
        throw new IllegalArgumentException("Type " + requestTypeToString(r6) + " of request should be created with multiple targets.");
    }

    public static IDiagnosisRequest createRequest(int r7, List<String> r8, int r9, int r10) {
        if (isOneTargetRequestType(r7) == true) goto L17;
        if (isValidNetDetect(r7, r9) == false) goto L15;
        if (r7 == 1) goto L13;
        if (r7 == 5) goto L13;
        return null;
    L13:
        return new b(r7, r8, r9, 0, r10);
    L15:
        throw new IllegalArgumentException("Illegal netDetectType: " + r9);
    L17:
        throw new IllegalArgumentException("Type " + requestTypeToString(r7) + " of request should be created with only one target.");
    }

    private static j getCronetHttpClient() {
        if (d.c() == false) goto L7;
        return j.w(TTNetInit.getTTNetDepend().getContext());
    L7:
        throw new UnsupportedOperationException("Cronet is not enabled");
    }

    private static boolean isOneTargetRequestType(int r3) {
        if (r3 == 0) goto L18;
        if (r3 != 1) goto L6;
        return false;
    L6:
        if (r3 == 2) goto L18;
        if (r3 == 3) goto L18;
        if (r3 == 4) goto L18;
        if (r3 != 5) goto L15;
        return false;
    L15:
        throw new IllegalArgumentException("Illegal request type: " + r3);
    L18:
        return true;
    }

    private static boolean isValidNetDetect(int r6, long r7) {
        if (r6 != 0) goto L5;
        return true;
    L5:
        if (r6 == 1) goto L28;
        if (r6 == 2) goto L19;
        if (r6 != 3) goto L11;
    L17:
        return true;
    L11:
        if (r6 == 4) goto L17;
        if (r6 == 5) goto L28;
        throw new IllegalArgumentException("Illegal request type: " + r6);
    L19:
        if (r7 != 1) goto L21;
    L26:
        return true;
    L21:
        if (r7 == 2) goto L26;
        if (r7 == 64) goto L26;
        return false;
    L28:
        if (((-1) & r7) != 0) goto L30;
    L32:
        return false;
    L30:
        if ((r7 & 0) != 0) goto L32;
        return true;
    }

    public static void reportUserLog(String r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r1.isEmpty() == true) goto L15;
        j r0 = getCronetHttpClient();     // Catch: Exception -> L10
        if (r0 == null) goto L14;
        r0.H(r1);     // Catch: Exception -> L10
        return;
    L14:
        return;
    L16:
        return;
    }

    private static String requestTypeToString(int r1) {
        return sTypeStringMap.get(Integer.valueOf(r1));
    }
}

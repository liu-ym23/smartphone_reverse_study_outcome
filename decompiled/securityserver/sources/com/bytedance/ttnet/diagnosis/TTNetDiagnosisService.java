package com.bytedance.ttnet.diagnosis;

import a.a;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient;
import com.bytedance.ttnet.HttpClient;
import com.bytedance.ttnet.TTNetInit;
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

    private static SsCronetHttpClient getCronetHttpClient() {
        if (HttpClient.isCronetClientEnable() == false) goto L7;
        return SsCronetHttpClient.inst(TTNetInit.getTTNetDepend().getContext());
    L7:
        throw new UnsupportedOperationException("Cronet is not enabled");
    }

    private static boolean isOneTargetRequestType(int r2) {
        if (r2 == 0) goto L18;
        if (r2 != 1) goto L6;
        return false;
    L6:
        if (r2 == 2) goto L18;
        if (r2 == 3) goto L18;
        if (r2 == 4) goto L18;
        if (r2 != 5) goto L15;
        return false;
    L15:
        throw new IllegalArgumentException(a.e(r2, "Illegal request type: "));
    L18:
        return true;
    }

    private static boolean isValidNetDetect(int r4, long r5) {
        if (r4 != 0) goto L5;
        return true;
    L5:
        if (r4 == 1) goto L28;
        if (r4 == 2) goto L19;
        if (r4 != 3) goto L11;
    L17:
        return true;
    L11:
        if (r4 == 4) goto L17;
        if (r4 == 5) goto L28;
        throw new IllegalArgumentException(a.e(r4, "Illegal request type: "));
    L19:
        if (r5 != 1) goto L21;
    L26:
        return true;
    L21:
        if (r5 == 2) goto L26;
        if (r5 == 64) goto L26;
        return false;
    L28:
        if (r5 != 0) goto L30;
    L32:
        return false;
    L30:
        if (0 != 0) goto L32;
        return true;
    }

    public static void reportUserLog(String r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r1.isEmpty() == true) goto L17;
        SsCronetHttpClient r0 = getCronetHttpClient();     // Catch: Exception -> L10
        if (r0 == null) goto L16;
        r0.reportNetDiagnosisUserLog(r1);     // Catch: Exception -> L10
        return;
    L16:
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    private static String requestTypeToString(int r1) {
        return sTypeStringMap.get(Integer.valueOf(r1));
    }

    public static IDiagnosisRequest createRequest(int r6, String r7, int r8, int r9, int r10) {
        if (isOneTargetRequestType(r6) == false) goto L20;
        if (isValidNetDetect(r6, r8) == false) goto L18;
        if (r6 != 0) goto L8;
    L15:
        ArrayList r2 = new ArrayList();
        r2.add(r7);
        return new TTNetDiagnosisRequest(r6, r2, r8, r9, r10);
    L8:
        if (r6 == 2) goto L15;
        if (r6 == 3) goto L15;
        if (r6 == 4) goto L15;
        return null;
    L18:
        throw new IllegalArgumentException(a.e(r8, "Illegal netDetectType: "));
    L20:
        throw new IllegalArgumentException(a.o(new StringBuilder("Type "), requestTypeToString(r6), " of request should be created with multiple targets."));
    }

    public static IDiagnosisRequest createRequest(int r7, List<String> r8, int r9, int r10) {
        if (isOneTargetRequestType(r7) == true) goto L17;
        if (isValidNetDetect(r7, r9) == false) goto L15;
        if (r7 == 1) goto L13;
        if (r7 == 5) goto L13;
        return null;
    L13:
        return new TTNetDiagnosisRequest(r7, r8, r9, 0, r10);
    L15:
        throw new IllegalArgumentException(a.e(r9, "Illegal netDetectType: "));
    L17:
        throw new IllegalArgumentException(a.o(new StringBuilder("Type "), requestTypeToString(r7), " of request should be created with only one target."));
    }
}

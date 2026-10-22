package com.bytedance.common.utility;

import android.util.Pair;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes.dex */
public abstract class NetworkClient {
    private static final int BYTE_ARRAY_OUTPUT_STREAM_SIZE = 8192;
    private static NetworkClient sDefault;

    public static class ReqContext {
        public boolean addCommonParams;
        public boolean fetchResponseHeaders;
        public Map<String, String> responseHeaders;

        public ReqContext() {
        }
    }

    static {
        sDefault = new DummyNetworkClient();
    }

    public NetworkClient() {
    }

    public static byte[] compressWithgzip(byte[] r3) {
        GZIPOutputStream r0 = null;
        ByteArrayOutputStream r1 = new ByteArrayOutputStream(8192);     // Catch: Throwable -> L7
        GZIPOutputStream r2 = new GZIPOutputStream(r1);     // Catch: Throwable -> L7
        r2.write(r3);     // Catch: Throwable -> L9
        r2.close();     // Catch: Throwable -> L9
        return r1.toByteArray();
    L9:
        th = th;
        r0 = r2;
    L11:
        if (r0 == null) goto L13;
        r0.close();
    L13:
        throw th;
    L7:
        th = th;
        goto L11
    }

    public static NetworkClient getDefault() {
        return sDefault;
    }

    public static void setDefault(NetworkClient r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r1 == sDefault) goto L8;
        sDefault = r1;
        return;
    }

    public String get(String r3) {
        ReqContext r0 = new ReqContext();
        r0.addCommonParams = true;
        return get(r3, null, r0);
    }

    public abstract String get(String r1, Map<String, String> r2, ReqContext r3);

    public String post(String r3, List<Pair<String, String>> r4) {
        ReqContext r0 = new ReqContext();
        r0.addCommonParams = true;
        return post(r3, r4, null, r0);
    }

    public abstract String post(String r1, List<Pair<String, String>> r2, Map<String, String> r3, ReqContext r4);

    public abstract String post(String r1, byte[] r2, Map<String, String> r3, ReqContext r4);

    public byte[] postDataStream(String r1, byte[] r2, Map<String, String> r3, ReqContext r4) {
        return null;
    }

    public String post(String r3, byte[] r4, boolean r5, String r6, boolean r7) {
        HashMap r0 = new HashMap();
        if (r5 == false) goto L10;
        r4 = compressWithgzip(r4);     // Catch: Exception -> L6
        r0.put("Content-Encoding", "gzip");     // Catch: Exception -> L6
    L6:
        e = move-exception;
        throw new CommonHttpException(0, e.getMessage());
    L10:
        if (StringUtils.isEmpty(r6) == true) goto L12;
        r0.put("Content-Type", r6);
    L12:
        ReqContext r8 = new ReqContext();
        r8.addCommonParams = r7;
        return post(r3, r4, r0, r8);
    }
}

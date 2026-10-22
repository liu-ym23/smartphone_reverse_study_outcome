package com.bytedance.bdinstall;

import android.text.TextUtils;
import android.util.Pair;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultClient implements INetworkClient {
    private static final String CONTENT_TYPE = "application/json; charset=utf-8";
    private static final String[] HTTP_METHOD = null;
    private static final int LENGTH_MAX = 10240;
    private static final int METHOD_GET = 0;
    private static final int METHOD_POST = 1;

    private static class HttpResp {
        byte[] mRespByteArray;
        String mRespStr;
        int mType;

        HttpResp(int r1) {
            this.mType = r1;
        }
    }

    public DefaultClient() {
    }

    static {
        HTTP_METHOD = new String[]{"GET", "POST"};
    }

    @Override // com.bytedance.bdinstall.INetworkClient
    public String get(String r2, Map<String, String> r3) throws Exception {
        return http(0, r2, (HashMap) r3, null);
    }

    @Override // com.bytedance.bdinstall.INetworkClient
    public String post(String r1, byte[] r2, Map<String, String> r3) throws Exception {
        return http(1, r1, (HashMap) r3, r2);
    }

    @Override // com.bytedance.bdinstall.INetworkClient
    public String post(String r3, byte[] r4, String r5) throws Exception {
        HashMap r0 = new HashMap();
        if (TextUtils.isEmpty(r5) == true) goto L6;
        r0.put("Content-Type", r5);
    L6:
        return post(r3, r4, r0);
    }

    @Override // com.bytedance.bdinstall.INetworkClient
    public String post(String r4, List<Pair<String, String>> r5) throws Exception {
        JSONObject r0 = new JSONObject();
        if (r5 == null) goto L9;
        Iterator<Pair<String, String>> r6 = r5.iterator();
    L6:
        if (r6.hasNext() == false) goto L9;
        Pair<String, String> r1 = r6.next();
        r0.put((String) r1.first, r1.second);
    L9:
        return post(r4, r0.toString().getBytes(), "application/json; charset=utf-8");
    }

    @Override // com.bytedance.bdinstall.INetworkClient
    public byte[] postStream(String r1, byte[] r2, Map<String, String> r3) throws RangersHttpException {
        return httpRequestInner(1, r1, r3, r2, 1).mRespByteArray;
    }

    private static HttpResp httpRequestInner(int r7, String r8, Map<String, String> r9, byte[] r10, int r11) throws RangersHttpException {
        if (DrLog.DEBUG == false) goto L16;
        DrLog.d("http: " + r8);
        if (r9 == null) goto L14;
        Iterator<Map.Entry<String, String>> r2 = r9.entrySet().iterator();
    L8:
        if (r2.hasNext() == false) goto L14;
        Map.Entry<String, String> r3 = r2.next();
        if (TextUtils.isEmpty(r3.getKey()) == true) goto L8;
        if (TextUtils.isEmpty(r3.getValue()) == true) goto L8;
        DrLog.d("http headers key:" + r3.getKey() + " value:" + r3.getValue());
    L14:
        if (r10 == null) goto L16;
        DrLog.d("http data length:" + r10.length);
    L16:
        HttpResp r4 = new HttpResp(r11);
        Closeable r5 = null;
        HttpURLConnection r12 = (HttpURLConnection) new URL(r8).openConnection();     // Catch: Throwable -> L84
        if (r7 != 0) goto L21;
        r12.setDoOutput(false);     // Catch: Throwable -> L84
    L24:
        r12.setRequestMethod(HTTP_METHOD[r7]);     // Catch: Throwable -> L84
        if (r9 != null) goto L27;
    L37:
        r12.setRequestProperty("Accept-Encoding", "gzip");     // Catch: Throwable -> L84
        if (r10 != null) goto L40;
    L43:
        DataOutputStream r13 = null;
    L44:
        int r14 = r12.getResponseCode();     // Catch: Throwable -> L81
        if (r14 != 200) goto L80;
        if (r11 == 0) goto L48;
        InputStream r15 = r12.getInputStream();     // Catch: Throwable -> L81
        if ("gzip".equalsIgnoreCase(r12.getContentEncoding()) == true) goto L66;
    L105:
        ByteArrayOutputStream r16 = new ByteArrayOutputStream();     // Catch: Throwable -> L77
        byte[] r17 = new byte[1024];     // Catch: Throwable -> L75
    L70:
        int r18 = r15.read(r17);     // Catch: Throwable -> L75
        if (r18 == (-1)) goto L73;
        r16.write(r17, 0, r18);     // Catch: Throwable -> L75
        goto L70
    L73:
        r4.mRespByteArray = r16.toByteArray();     // Catch: Throwable -> L75
        ByteArrayOutputStream r19 = r16;
    L74:
        Utils.closeSafely(r13);
        Utils.closeSafely(r5);
        Closeable r20 = r19;
    L89:
        Utils.closeSafely(r15);
        Utils.closeSafely(r20);
        return r4;
    L75:
        th = move-exception;
        r5 = r13;
        th = th;
        BufferedReader r110 = null;
        Closeable r21 = r16;
    L103:
        DrLog.ysnp(th);     // Catch: Throwable -> L93
        if ((th instanceof RangersHttpException) == true) goto L92;
        Utils.closeSafely(r5);
        Utils.closeSafely(r110);
        r20 = r21;
        goto L89
    L92:
        throw th;     // Catch: Throwable -> L93
    L93:
        th = move-exception;
        Utils.closeSafely(r5);
        Utils.closeSafely(r110);
        Utils.closeSafely(r15);
        Utils.closeSafely(r21);
        throw th;
    L77:
        RangersHttpException th = th;
        r110 = null;
    L83:
        r5 = r13;
        th = th;
        r21 = r110;
        goto L103
    L66:
        r15 = new GZIPInputStream(r15);     // Catch: Throwable -> L81
        goto L105
    L48:
        if (r12.getContentLength() >= LENGTH_MAX) goto L61;
        InputStream r22 = r12.getInputStream();     // Catch: Throwable -> L81
        if ("gzip".equalsIgnoreCase(r12.getContentEncoding()) == false) goto L52;
        r110 = new BufferedReader(new InputStreamReader(new GZIPInputStream(r22)));     // Catch: Throwable -> L81
    L98:
        StringBuilder r111 = new StringBuilder(r22.available());     // Catch: Throwable -> L59
    L54:
        String r23 = r110.readLine();     // Catch: Throwable -> L59
        if (r23 == null) goto L57;
        r111.append(r23).append("\n");     // Catch: Throwable -> L59
        goto L54
    L57:
        r4.mRespStr = r111.toString();     // Catch: Throwable -> L59
        JSONObject r24 = new JSONObject(r4.mRespStr);     // Catch: Throwable -> L59
        r24.put("Set-Cookie", r12.getHeaderField("Set-Cookie"));     // Catch: Throwable -> L59
        r4.mRespStr = r24.toString();     // Catch: Throwable -> L59
    L62:
        r19 = null;
        r15 = null;
        r5 = r110;
    L59:
        th = move-exception;
        r15 = null;
        r5 = r13;
        th = th;
        r21 = null;
        goto L103
    L52:
        r110 = new BufferedReader(new InputStreamReader(r22));     // Catch: Throwable -> L81
        goto L98
    L61:
        DrLog.ysnp(null);     // Catch: Throwable -> L81
        r110 = null;
        goto L62
    L80:
        throw new RangersHttpException(r14, r12.getResponseMessage());     // Catch: Throwable -> L81
    L40:
        if (r10.length <= 0) goto L43;
        r13 = new DataOutputStream(r12.getOutputStream());     // Catch: Throwable -> L84
        r13.write(r10);     // Catch: Throwable -> L81
        r13.flush();     // Catch: Throwable -> L81
        r13.close();     // Catch: Throwable -> L81
    L81:
        th = th;
        r15 = null;
        r110 = null;
        goto L83
    L27:
        if (r9.isEmpty() == true) goto L37;
        Iterator<Map.Entry<String, String>> r25 = r9.entrySet().iterator();     // Catch: Throwable -> L84
    L30:
        if (r25.hasNext() == false) goto L37;
        Map.Entry<String, String> r26 = r25.next();     // Catch: Throwable -> L84
        if (TextUtils.isEmpty(r26.getKey()) == true) goto L36;
        if (TextUtils.isEmpty(r26.getValue()) == true) goto L36;
        r12.addRequestProperty(r26.getKey(), r26.getValue());     // Catch: Throwable -> L84
    L36:
        DrLog.ysnp(null);     // Catch: Throwable -> L84
        goto L30
    L21:
        if (r7 != 1) goto L23;
        r12.setDoOutput(true);     // Catch: Throwable -> L84
        goto L24
    L23:
        DrLog.ysnp(null);     // Catch: Throwable -> L84
    L84:
        th = th;
        r21 = null;
        r15 = null;
        r110 = null;
        goto L103
    }

    public static String http(int r7, String r8, HashMap<String, String> r9, byte[] r10) throws RangersHttpException {
        if (DrLog.debug() == false) goto L16;
        DrLog.d("http: " + r8);
        if (r9 == null) goto L14;
        Iterator<Map.Entry<String, String>> r2 = r9.entrySet().iterator();
    L8:
        if (r2.hasNext() == false) goto L14;
        Map.Entry<String, String> r3 = r2.next();
        if (TextUtils.isEmpty(r3.getKey()) == true) goto L8;
        if (TextUtils.isEmpty(r3.getValue()) == true) goto L8;
        DrLog.d("http headers key:" + r3.getKey() + " value:" + r3.getValue());
    L14:
        if (r10 == null) goto L16;
        DrLog.d("http data length:" + r10.length);
    L16:
        DataOutputStream r4 = null;
        BufferedReader r5 = null;
        HttpURLConnection r11 = (HttpURLConnection) new URL(r8).openConnection();     // Catch: Throwable -> L71
        if (r7 != 0) goto L21;
        r11.setDoOutput(false);     // Catch: Throwable -> L71
    L24:
        r11.setRequestMethod(HTTP_METHOD[r7]);     // Catch: Throwable -> L71
        if (r9 != null) goto L27;
    L37:
        r11.setRequestProperty("Accept-Encoding", "gzip");     // Catch: Throwable -> L71
        if (r10 != null) goto L40;
    L43:
        DataOutputStream r12 = null;
    L44:
        int r13 = r11.getResponseCode();     // Catch: Throwable -> L69
        if (r13 != 200) goto L68;
        if (r11.getContentLength() >= LENGTH_MAX) goto L60;
        InputStream r14 = r11.getInputStream();     // Catch: Throwable -> L69
        if ("gzip".equalsIgnoreCase(r11.getContentEncoding()) == false) goto L51;
        BufferedReader r1 = new BufferedReader(new InputStreamReader(new GZIPInputStream(r14)));     // Catch: Throwable -> L69
    L111:
        StringBuilder r6 = new StringBuilder(r14.available());     // Catch: Throwable -> L58
    L53:
        String r15 = r1.readLine();     // Catch: Throwable -> L58
        if (r15 == null) goto L56;
        r6.append(r15).append("\n");     // Catch: Throwable -> L58
        goto L53
    L56:
        JSONObject r16 = new JSONObject(r6.toString());     // Catch: Throwable -> L58
        r16.put(Api.KEY_HTTP_CODE, 200);     // Catch: Throwable -> L58
        r16.put("Set-Cookie", r11.getHeaderField("Set-Cookie"));     // Catch: Throwable -> L58
        r8 = r16.toString();     // Catch: Throwable -> L58
        r5 = r1;
    L62:
        if (r12 != null) goto L108;
    L64:
        if (r5 == null) goto L80;
        r5.close();     // Catch: IOException -> L92
    L98:
        goto L80
    L108:
        r12.close();     // Catch: IOException -> L91
    L58:
        th = move-exception;
        r4 = r12;
        th = th;
        r8 = null;
    L101:
        DrLog.ysnp(th);     // Catch: Throwable -> L85
        if ((th instanceof RangersHttpException) == true) goto L84;
        if (r4 != null) goto L104;
    L77:
        if (r1 == null) goto L80;
        r1.close();     // Catch: IOException -> L92
        goto L98
    L104:
        r4.close();     // Catch: IOException -> L93
        goto L77
    L84:
        throw th;     // Catch: Throwable -> L85
    L85:
        th = move-exception;
        if (r4 != null) goto L96;
    L88:
        if (r1 == null) goto L128;
        r1.close();     // Catch: IOException -> L95
        throw th;
    L129:
        throw th;
    L128:
        throw th;
    L96:
        r4.close();     // Catch: IOException -> L94
        goto L88
    L51:
        r1 = new BufferedReader(new InputStreamReader(r14));     // Catch: Throwable -> L69
        goto L111
    L60:
        DrLog.ysnp(null);     // Catch: Throwable -> L69
        r8 = null;
        goto L62
    L68:
        throw new RangersHttpException(r13, r11.getResponseMessage());     // Catch: Throwable -> L69
    L40:
        if (r10.length <= 0) goto L43;
        r12 = new DataOutputStream(r11.getOutputStream());     // Catch: Throwable -> L71
        r12.write(r10);     // Catch: Throwable -> L69
        r12.flush();     // Catch: Throwable -> L69
        r12.close();     // Catch: Throwable -> L69
    L69:
        th = move-exception;
        r1 = null;
        r4 = r12;
        th = th;
        r8 = null;
        goto L101
    L27:
        if (r9.isEmpty() == true) goto L37;
        Iterator<Map.Entry<String, String>> r17 = r9.entrySet().iterator();     // Catch: Throwable -> L71
    L30:
        if (r17.hasNext() == false) goto L37;
        Map.Entry<String, String> r18 = r17.next();     // Catch: Throwable -> L71
        if (TextUtils.isEmpty(r18.getKey()) == true) goto L36;
        if (TextUtils.isEmpty(r18.getValue()) == true) goto L36;
        r11.addRequestProperty(r18.getKey(), r18.getValue());     // Catch: Throwable -> L71
    L36:
        DrLog.ysnp(null);     // Catch: Throwable -> L71
        goto L30
    L21:
        if (r7 != 1) goto L23;
        r11.setDoOutput(true);     // Catch: Throwable -> L71
        goto L24
    L23:
        DrLog.ysnp(null);     // Catch: Throwable -> L71
    L71:
        th = th;
        r8 = null;
        r1 = null;
    L80:
        if (DrLog.debug() == false) goto L82;
        DrLog.d("http response: " + r8);
    L82:
        return r8;
    }
}

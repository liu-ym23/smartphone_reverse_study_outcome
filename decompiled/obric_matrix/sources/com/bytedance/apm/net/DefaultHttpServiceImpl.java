package com.bytedance.apm.net;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.apm.util.d;
import com.bytedance.apm.util.i;
import com.bytedance.apm.util.l;
import com.bytedance.apm.util.u;
import com.bytedance.services.apm.api.HttpResponse;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedance.services.apm.api.IMultipartUploader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: classes.dex */
public class DefaultHttpServiceImpl implements IHttpService {
    private static String METHOD_GET = "GET";
    private static String METHOD_POST = "POST";

    static {
    }

    public DefaultHttpServiceImpl() {
    }

    private HttpResponse doRequest(String r8, byte[] r9, String r10, Map<String, String> r11) {
        if (r10 == null) goto L72;
        HttpURLConnection r12 = l.a(r8);     // Catch: Throwable -> L57
        r12.setConnectTimeout(5000);     // Catch: Throwable -> L55
        r12.setReadTimeout(5000);     // Catch: Throwable -> L55
        if (r11 == null) goto L18;
        if (r11.isEmpty() == true) goto L18;
        Iterator<Map.Entry<String, String>> r13 = r11.entrySet().iterator();     // Catch: Throwable -> L55
    L12:
        if (r13.hasNext() == false) goto L18;
        Map.Entry<String, String> r0 = r13.next();     // Catch: Throwable -> L55
        if (r0 == null) goto L12;
        r12.setRequestProperty(r0.getKey(), r0.getValue());     // Catch: Throwable -> L55
    L18:
        if (TextUtils.equals(r10, METHOD_POST) == false) goto L20;
        r12.setDoOutput(true);     // Catch: Throwable -> L55
    L21:
        r12.setRequestMethod(r10);     // Catch: Throwable -> L55
        if (r9 != null) goto L24;
    L26:
        int r14 = r12.getResponseCode();     // Catch: Throwable -> L55
        if (r14 != 200) goto L51;
        InputStream r15 = r12.getInputStream();     // Catch: Throwable -> L55
        String r16 = r12.getContentEncoding();     // Catch: Throwable -> L49
        if (TextUtils.isEmpty(r16) == false) goto L32;
    L34:
        byte[] r1 = toByteArray(r15);     // Catch: Throwable -> L49
    L35:
        Map<String, List<String>> r17 = r12.getHeaderFields();     // Catch: Throwable -> L49
        HashMap r2 = new HashMap();     // Catch: Throwable -> L49
        Iterator<String> r3 = r17.keySet().iterator();     // Catch: Throwable -> L49
    L37:
        if (r3.hasNext() == false) goto L43;
        String r4 = r3.next();     // Catch: Throwable -> L49
        List<String> r5 = r17.get(r4);     // Catch: Throwable -> L49
        if (r5 == null) goto L37;
        if (i.b(r5) == true) goto L37;
        r2.put(r4, r5.get(0));     // Catch: Throwable -> L49
        goto L37
    L43:
        HttpResponse r18 = new HttpResponse(r14, r2, r1);     // Catch: Throwable -> L49
        if (r15 != null) goto L95;
    L46:
        if (r12 != null) goto L88;
    L48:
        return r18;
    L88:
        r12.disconnect();     // Catch: Exception -> L74
        goto L48
    L95:
        r15.close();     // Catch: Exception -> L73
        goto L46
    L32:
        if (r16.equalsIgnoreCase("gzip") == false) goto L34;
        GZIPInputStream r19 = new GZIPInputStream(r15);     // Catch: Throwable -> L49
        r1 = toByteArray(r19);     // Catch: Throwable -> L49
        r19.close();     // Catch: Throwable -> L49
    L49:
        th = th;
    L82:
        com.bytedance.apm.x.a.d("apm_debug", "http request msg: " + th.getMessage() + " ,stack: " + u.b(th, 10));     // Catch: Throwable -> L65
        if (r15 != null) goto L86;
    L62:
        if (r12 != null) goto L80;
    L64:
        return null;
    L80:
        r12.disconnect();     // Catch: Exception -> L76
        goto L64
    L86:
        r15.close();     // Catch: Exception -> L75
    L65:
        th = move-exception;
        if (r15 != null) goto L93;
    L68:
        if (r12 == null) goto L114;
        r12.disconnect();     // Catch: Exception -> L78
        throw th;
    L115:
        throw th;
    L114:
        throw th;
    L93:
        r15.close();     // Catch: Exception -> L77
        goto L68
    L51:
        HttpResponse r110 = new HttpResponse(r14, null);     // Catch: Throwable -> L55
        if (r12 != null) goto L91;
    L54:
        return r110;
    L91:
        r12.disconnect();     // Catch: Exception -> L79
        goto L54
    L24:
        if (r9.length <= 0) goto L26;
        DataOutputStream r111 = new DataOutputStream(r12.getOutputStream());     // Catch: Throwable -> L55
        r111.write(r9);     // Catch: Throwable -> L55
        r111.flush();     // Catch: Throwable -> L55
        r111.close();     // Catch: Throwable -> L55
        goto L26
    L20:
        r12.setDoOutput(false);     // Catch: Throwable -> L55
    L55:
        th = th;
        r15 = null;
    L57:
        th = th;
        r12 = null;
        r15 = null;
        goto L82
    L72:
        throw new IllegalArgumentException("request method is not null");
    }

    public static byte[] toByteArray(InputStream r4) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        byte[] r1 = new byte[8192];
    L3:
        int r3 = r4.read(r1);
        if ((-1) == r3) goto L6;
        r0.write(r1, 0, r3);
        goto L3
    L6:
        if (r4 == null) goto L9;
        r4.close();
    L9:
        return r0.toByteArray();
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public IMultipartUploader buildMultipartUpload(String r2, String r3, boolean r4) {
        return new b(r2, r3, r4, null);
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public IMultipartUploader buildMultipartUpload(String r1, String r2, boolean r3, Map<String, String> r4) {
        return new b(r1, r2, r3, r4);
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public HttpResponse doGet(String r3, Map<String, String> r4) {
        return doRequest(r3, null, METHOD_GET, r4);
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public HttpResponse doPost(String r2, byte[] r3, Map<String, String> r4) {
        return doRequest(r2, r3, METHOD_POST, r4);
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    @Nullable
    public HttpResponse uploadFiles(String r1, List<File> r2, Map<String, String> r3) {
        return d.a(r1, r2, r3);
    }
}

package com.bytedance.apm.net;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.apm.logging.ApmAlogHelper;
import com.bytedance.apm.util.FileUploadUtils;
import com.bytedance.apm.util.ListUtils;
import com.bytedance.apm.util.StackUtils;
import com.bytedance.frameworks.baselib.log.SlardarLogConstants;
import com.bytedance.services.apm.api.HttpResponse;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedance.services.apm.api.IMultipartUploader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: classes.dex */
public class DefaultHttpServiceImpl implements IHttpService {
    private static String METHOD_GET = "GET";
    private static String METHOD_POST = "POST";

    public DefaultHttpServiceImpl() {
    }

    private HttpResponse doRequest(String r8, byte[] r9, String r10, Map<String, String> r11) {
        if (r10 == null) goto L70;
        HttpURLConnection r12 = (HttpURLConnection) new URL(r8).openConnection();     // Catch: Throwable -> L55
        r12.setConnectTimeout(5000);     // Catch: Throwable -> L17
        r12.setReadTimeout(5000);     // Catch: Throwable -> L17
        if (r11 == null) goto L20;
        if (r11.isEmpty() == true) goto L20;
        Iterator<Map.Entry<String, String>> r13 = r11.entrySet().iterator();     // Catch: Throwable -> L17
    L12:
        if (r13.hasNext() == false) goto L20;
        Map.Entry<String, String> r0 = r13.next();     // Catch: Throwable -> L17
        if (r0 == null) goto L12;
        r12.setRequestProperty(r0.getKey(), r0.getValue());     // Catch: Throwable -> L17
    L20:
        if (TextUtils.equals(r10, METHOD_POST) == false) goto L22;
        r12.setDoOutput(true);     // Catch: Throwable -> L17
    L23:
        r12.setRequestMethod(r10);     // Catch: Throwable -> L17
        if (r9 != null) goto L26;
    L28:
        int r14 = r12.getResponseCode();     // Catch: Throwable -> L17
        if (r14 != 200) goto L52;
        InputStream r15 = r12.getInputStream();     // Catch: Throwable -> L17
        String r16 = r12.getContentEncoding();     // Catch: Throwable -> L36
        if (TextUtils.isEmpty(r16) == false) goto L34;
    L38:
        byte[] r1 = toByteArray(r15);     // Catch: Throwable -> L36
    L39:
        Map<String, List<String>> r17 = r12.getHeaderFields();     // Catch: Throwable -> L36
        HashMap r2 = new HashMap();     // Catch: Throwable -> L36
        Iterator<String> r3 = r17.keySet().iterator();     // Catch: Throwable -> L36
    L41:
        if (r3.hasNext() == false) goto L47;
        String r4 = r3.next();     // Catch: Throwable -> L36
        List<String> r5 = r17.get(r4);     // Catch: Throwable -> L36
        if (r5 == null) goto L41;
        if (ListUtils.isEmpty(r5) == true) goto L41;
        r2.put(r4, r5.get(0));     // Catch: Throwable -> L36
        goto L41
    L47:
        HttpResponse r18 = new HttpResponse(r14, r2, r1);     // Catch: Throwable -> L36
        if (r15 != null) goto L93;
    L89:
        r12.disconnect();     // Catch: Exception -> L72
    L51:
        return r18;
    L93:
        r15.close();     // Catch: Exception -> L71
        goto L89
    L34:
        if (r16.equalsIgnoreCase("gzip") == false) goto L38;
        GZIPInputStream r19 = new GZIPInputStream(r15);     // Catch: Throwable -> L36
        r1 = toByteArray(r19);     // Catch: Throwable -> L36
        r19.close();     // Catch: Throwable -> L36
    L36:
        th = th;
    L86:
        ApmAlogHelper.i(SlardarLogConstants.TAG_ALOG, "http request msg: " + th.getMessage() + " ,stack: " + StackUtils.getStackLimit(th, 10));     // Catch: Throwable -> L63
        if (r15 != null) goto L80;
    L60:
        if (r12 != null) goto L91;
    L62:
        return null;
    L91:
        r12.disconnect();     // Catch: Exception -> L74
        goto L62
    L80:
        r15.close();     // Catch: Exception -> L73
    L63:
        th = move-exception;
        if (r15 != null) goto L84;
    L66:
        if (r12 == null) goto L112;
        r12.disconnect();     // Catch: Exception -> L76
        throw th;
    L113:
        throw th;
    L112:
        throw th;
    L84:
        r15.close();     // Catch: Exception -> L75
        goto L66
    L52:
        HttpResponse r110 = new HttpResponse(r14, null);     // Catch: Throwable -> L17
        r12.disconnect();     // Catch: Exception -> L77
    L54:
        return r110;
    L26:
        if (r9.length <= 0) goto L28;
        DataOutputStream r111 = new DataOutputStream(r12.getOutputStream());     // Catch: Throwable -> L17
        r111.write(r9);     // Catch: Throwable -> L17
        r111.flush();     // Catch: Throwable -> L17
        r111.close();     // Catch: Throwable -> L17
        goto L28
    L22:
        r12.setDoOutput(false);     // Catch: Throwable -> L17
    L17:
        th = th;
        r15 = null;
    L55:
        th = th;
        r12 = null;
        r15 = null;
        goto L86
    L70:
        throw new IllegalArgumentException("request method is not null");
    }

    public static byte[] toByteArray(InputStream r4) {
        ByteArrayOutputStream r0 = new ByteArrayOutputStream();
        byte[] r1 = new byte[8192];
    L3:
        int r2 = r4.read(r1);
        if ((-1) == r2) goto L6;
        r0.write(r1, 0, r2);
        goto L3
    L6:
        r4.close();
        return r0.toByteArray();
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public IMultipartUploader buildMultipartUpload(String r2, String r3, boolean r4) {
        return new MultipartUtility(r2, r3, r4, null);
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
        return FileUploadUtils.uploadFiles(r1, r2, r3);
    }

    @Override // com.bytedance.services.apm.api.IHttpService
    public IMultipartUploader buildMultipartUpload(String r1, String r2, boolean r3, Map<String, String> r4) {
        return new MultipartUtility(r1, r2, r3, r4);
    }
}

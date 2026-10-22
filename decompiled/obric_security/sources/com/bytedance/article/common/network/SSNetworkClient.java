package com.bytedance.article.common.network;

import android.net.Uri;
import android.util.Pair;
import com.bytedance.common.utility.CommonHttpException;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.ttnet.utils.RetrofitUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class SSNetworkClient extends NetworkClient {
    public SSNetworkClient() {
    }

    private static List<Header> convertHeaders(Map<String, String> r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        ArrayList r0 = new ArrayList();
        Iterator<Map.Entry<String, String>> r5 = r4.entrySet().iterator();
    L7:
        if (r5.hasNext() == false) goto L9;
        Map.Entry<String, String> r1 = r5.next();
        r0.add(new Header(r1.getKey(), r1.getValue()));
        goto L7
    L9:
        return r0;
    }

    private static Pair<String, String> parseUrl(String r4) throws Exception {
        Uri r5 = Uri.parse(r4);
        StringBuilder r0 = new StringBuilder();
        String r1 = r5.getScheme();
        String r2 = r5.getHost();
        int r3 = r5.getPort();
        if (r2 == null) goto L9;
        if (r1 == null) goto L6;
        r0.append(r1);
        r0.append("://");
    L6:
        r0.append(r2);
        if (r3 <= 0) goto L9;
        r0.append(':');
        r0.append(r3);
    L9:
        String r6 = r0.toString();
        String r7 = r5.getPath();
        String r8 = r5.getQuery();
        if (r8 == null) goto L13;
        r7 = r7 + "?" + r8;
    L13:
        return new Pair(r6, r7);
    }

    @Override // com.bytedance.common.utility.NetworkClient
    public String get(String r2, Map<String, String> r3, NetworkClient.ReqContext r4) throws Exception {
        Pair<String, String> r1 = parseUrl(r2);
        String r5 = (String) r1.first;
        String r6 = (String) r1.second;
        ICommonApi r7 = (ICommonApi) RetrofitUtils.createSsService(r5, ICommonApi.class);
        List<Header> r8 = convertHeaders(r3);
        if (r4 == null) goto L5;
        boolean r9 = r4.addCommonParams;
    L7:
        return r7.get(-1, r6, r8, r9).execute().body();
    L5:
        r9 = false;
        goto L7
    }

    @Override // com.bytedance.common.utility.NetworkClient
    public String post(String r8, List<Pair<String, String>> r9, Map<String, String> r10, NetworkClient.ReqContext r11) throws CommonHttpException {
        Pair<String, String> r12 = parseUrl(r8);     // Catch: Exception -> L14
        String r0 = (String) r12.first;     // Catch: Exception -> L14
        String r3 = (String) r12.second;     // Catch: Exception -> L14
        ICommonApi r1 = (ICommonApi) RetrofitUtils.createSsService(r0, ICommonApi.class);     // Catch: Exception -> L14
        List<Header> r5 = convertHeaders(r10);     // Catch: Exception -> L14
        LinkedHashMap r4 = new LinkedHashMap();     // Catch: Exception -> L14
        if (r9 == null) goto L9;
        Iterator<Pair<String, String>> r13 = r9.iterator();     // Catch: Exception -> L14
    L7:
        if (r13.hasNext() == false) goto L9;
        Pair<String, String> r14 = r13.next();     // Catch: Exception -> L14
        r4.put(r14.first, r14.second);     // Catch: Exception -> L14
    L9:
        if (r11 == null) goto L11;
        boolean r6 = r11.addCommonParams;     // Catch: Exception -> L14
    L12:
        return r1.postForm(-1, r3, r4, r5, r6).execute().body();
    L11:
        r6 = false;
    L14:
        e = move-exception;
        if ((e instanceof HttpResponseException) == false) goto L20;
        throw new CommonHttpException(((HttpResponseException) e).getStatusCode(), e.getMessage());
    L20:
        throw new CommonHttpException(0, e.getMessage());
    }

    @Override // com.bytedance.common.utility.NetworkClient
    public String post(String r8, byte[] r9, Map<String, String> r10, NetworkClient.ReqContext r11) throws CommonHttpException {
        Pair<String, String> r12 = parseUrl(r8);     // Catch: Exception -> L13
        String r0 = (String) r12.first;     // Catch: Exception -> L13
        String r3 = (String) r12.second;     // Catch: Exception -> L13
        ICommonApi r1 = (ICommonApi) RetrofitUtils.createSsService(r0, ICommonApi.class);     // Catch: Exception -> L13
        if (r10 == null) goto L6;
        String r2 = r10.get("Content-Type");     // Catch: Exception -> L13
        r10.remove("Content-Type");     // Catch: Exception -> L13
    L7:
        List<Header> r5 = convertHeaders(r10);     // Catch: Exception -> L13
        if (r11 == null) goto L10;
        boolean r6 = r11.addCommonParams;     // Catch: Exception -> L13
    L11:
        return r1.postData(-1, r3, new TypedByteArray(r2, r9, new String[0]), r5, r6).execute().body();
    L10:
        r6 = false;
        goto L11
    L6:
        r2 = null;
    L13:
        e = move-exception;
        if ((e instanceof HttpResponseException) == false) goto L19;
        throw new CommonHttpException(((HttpResponseException) e).getStatusCode(), e.getMessage());
    L19:
        throw new CommonHttpException(0, e.getMessage());
    }

    @Override // com.bytedance.common.utility.NetworkClient
    public byte[] postDataStream(String r10, byte[] r11, Map<String, String> r12, NetworkClient.ReqContext r13) throws CommonHttpException {
        InputStream r0 = null;
        Pair<String, String> r14 = parseUrl(r10);     // Catch: Throwable -> L38 Exception -> L40
        String r1 = (String) r14.first;     // Catch: Throwable -> L38 Exception -> L40
        String r4 = (String) r14.second;     // Catch: Throwable -> L38 Exception -> L40
        ICommonApi r2 = (ICommonApi) RetrofitUtils.createSsService(r1, ICommonApi.class);     // Catch: Throwable -> L38 Exception -> L40
        if (r12 == null) goto L6;
        String r3 = r12.get("Content-Type");     // Catch: Throwable -> L38 Exception -> L40
        r12.remove("Content-Type");     // Catch: Throwable -> L38 Exception -> L40
    L7:
        List<Header> r6 = convertHeaders(r12);     // Catch: Throwable -> L38 Exception -> L40
        if (r13 == null) goto L10;
        boolean r7 = r13.addCommonParams;     // Catch: Throwable -> L38 Exception -> L40
    L11:
        InputStream r15 = r2.postDataStream(-1, r4, new TypedByteArray(r3, r11, new String[0]), r6, r7).execute().body().in();     // Catch: Throwable -> L38 Exception -> L40
    L73:
        ByteArrayOutputStream r16 = new ByteArrayOutputStream();     // Catch: Throwable -> L33 Exception -> L36
    L71:
        byte[] r17 = new byte[1024];     // Catch: Throwable -> L29 Exception -> L31
    L15:
        int r18 = r15.read(r17);     // Catch: Throwable -> L29 Exception -> L31
        if (r18 == (-1)) goto L18;
        r16.write(r17, 0, r18);     // Catch: Throwable -> L29 Exception -> L31
        goto L15
    L18:
        byte[] r9 = r16.toByteArray();     // Catch: Throwable -> L29 Exception -> L31
        if (r15 == null) goto L64;
        r15.close();     // Catch: IOException -> L22
    L22:
        e = move-exception;
        e.printStackTrace();
    L64:
        r16.close();     // Catch: IOException -> L26
    L28:
        return r9;
    L26:
        e = move-exception;
        e.printStackTrace();
        goto L28
    L31:
        e = move-exception;
        r0 = r15;
        e = e;
    L66:
    L48:
        th = th;
    L49:
        if (r0 != null) goto L62;
    L54:
        if (r16 == null) goto L76;
        r16.close();     // Catch: IOException -> L57
        throw th;
    L57:
        e = move-exception;
        e.printStackTrace();
        throw th;
    L76:
        throw th;
    L62:
        r0.close();     // Catch: IOException -> L52
    L52:
        e = move-exception;
        e.printStackTrace();
        goto L54
    L43:
        if ((e instanceof HttpResponseException) == false) goto L47;
        throw new CommonHttpException(((HttpResponseException) e).getStatusCode(), e.getMessage());     // Catch: Throwable -> L48
    L47:
        throw new CommonHttpException(0, e.getMessage());     // Catch: Throwable -> L48
    L29:
        th = th;
    L35:
        r0 = r15;
    L36:
        e = move-exception;
        r0 = r15;
        e = e;
        r16 = null;
    L33:
        th = th;
        r16 = null;
        goto L35
    L10:
        r7 = false;
        goto L11
    L6:
        r3 = null;
    L40:
        e = e;
        r16 = null;
    L38:
        th = th;
        r16 = null;
        goto L49
    }
}

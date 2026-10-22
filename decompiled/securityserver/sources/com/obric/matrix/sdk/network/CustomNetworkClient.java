package com.obric.matrix.sdk.network;

import android.net.Uri;
import android.util.Pair;
import ccom.obric.matrix.sdk.network.CustomHttpException;
import com.bytedance.article.common.network.ICommonApi;
import com.bytedance.common.utility.CommonHttpException;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.CronetIOException;
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

/* JADX INFO: loaded from: classes2.dex */
class CustomNetworkClient extends NetworkClient {
    public CustomNetworkClient() {
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

    private static Pair<String, String> parseUrl(String r4) {
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
        r7 = a.a.B(r7, "?", r8);
    L13:
        return new Pair(r6, r7);
    }

    @Override // com.bytedance.common.utility.NetworkClient
    public String get(String r2, Map<String, String> r3, NetworkClient.ReqContext r4) {
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
    public String post(String r8, List<Pair<String, String>> r9, Map<String, String> r10, NetworkClient.ReqContext r11) {
        Pair<String, String> r12 = parseUrl(r8);     // Catch: Exception -> L9
        String r0 = (String) r12.first;     // Catch: Exception -> L9
        String r3 = (String) r12.second;     // Catch: Exception -> L9
        ICommonApi r1 = (ICommonApi) RetrofitUtils.createSsService(r0, ICommonApi.class);     // Catch: Exception -> L9
        List<Header> r5 = convertHeaders(r10);     // Catch: Exception -> L9
        LinkedHashMap r4 = new LinkedHashMap();     // Catch: Exception -> L9
        if (r9 == null) goto L11;
        Iterator<Pair<String, String>> r13 = r9.iterator();     // Catch: Exception -> L9
    L7:
        if (r13.hasNext() == false) goto L11;
        Pair<String, String> r14 = r13.next();     // Catch: Exception -> L9
        r4.put((String) r14.first, (String) r14.second);     // Catch: Exception -> L9
    L11:
        if (r11 == null) goto L13;
        boolean r6 = r11.addCommonParams;     // Catch: Exception -> L9
    L14:
        return r1.postForm(-1, r3, r4, r5, r6).execute().body();
    L13:
        r6 = false;
    L9:
        e = move-exception;
        if ((e instanceof HttpResponseException) == true) goto L25;
        if ((e instanceof CronetIOException) == false) goto L23;
        throw new CommonHttpException(((CronetIOException) e).getStatusCode(), e.getMessage());
    L23:
        throw new CommonHttpException(0, e.getMessage());
    L25:
        throw new CommonHttpException(((HttpResponseException) e).getStatusCode(), e.getMessage());
    }

    @Override // com.bytedance.common.utility.NetworkClient
    public byte[] postDataStream(String r10, byte[] r11, Map<String, String> r12, NetworkClient.ReqContext r13) {
        InputStream r0 = null;
        Pair<String, String> r14 = parseUrl(r10);     // Catch: Throwable -> L6 Exception -> L8
        String r1 = (String) r14.first;     // Catch: Throwable -> L6 Exception -> L8
        String r4 = (String) r14.second;     // Catch: Throwable -> L6 Exception -> L8
        ICommonApi r2 = (ICommonApi) RetrofitUtils.createSsService(r1, ICommonApi.class);     // Catch: Throwable -> L6 Exception -> L8
        if (r12 == null) goto L10;
        String r3 = r12.get("Content-Type");     // Catch: Throwable -> L6 Exception -> L8
        r12.remove("Content-Type");     // Catch: Throwable -> L6 Exception -> L8
    L11:
        List<Header> r6 = convertHeaders(r12);     // Catch: Throwable -> L6 Exception -> L8
        if (r13 == null) goto L14;
        boolean r7 = r13.addCommonParams;     // Catch: Throwable -> L6 Exception -> L8
    L15:
        InputStream r15 = r2.postDataStream(-1, r4, new TypedByteArray(r3, r11, new String[0]), r6, r7).execute().body().in();     // Catch: Throwable -> L6 Exception -> L8
        ByteArrayOutputStream r16 = new ByteArrayOutputStream();     // Catch: Throwable -> L36 Exception -> L38
    L74:
        byte[] r17 = new byte[1024];     // Catch: Throwable -> L22 Exception -> L24
    L19:
        int r18 = r15.read(r17);     // Catch: Throwable -> L22 Exception -> L24
        if (r18 == (-1)) goto L26;
        r16.write(r17, 0, r18);     // Catch: Throwable -> L22 Exception -> L24
        goto L19
    L26:
        byte[] r9 = r16.toByteArray();     // Catch: Throwable -> L22 Exception -> L24
        r15.close();     // Catch: IOException -> L29
    L70:
        r16.close();     // Catch: IOException -> L33
    L35:
        return r9;
    L33:
        e = move-exception;
        e.printStackTrace();
    L29:
        e = move-exception;
        e.printStackTrace();
        goto L70
    L24:
        e = move-exception;
        r0 = r15;
        e = e;
    L67:
    L46:
        th = th;
    L52:
        if (r0 != null) goto L65;
    L57:
        if (r16 == null) goto L79;
        r16.close();     // Catch: IOException -> L60
        throw th;
    L60:
        e = move-exception;
        e.printStackTrace();
        throw th;
    L79:
        throw th;
    L65:
        r0.close();     // Catch: IOException -> L55
    L55:
        e = move-exception;
        e.printStackTrace();
        goto L57
    L41:
        if ((e instanceof HttpResponseException) == true) goto L51;
        if ((e instanceof CronetIOException) == false) goto L49;
        throw new CommonHttpException(((CronetIOException) e).getStatusCode(), e.getMessage());     // Catch: Throwable -> L46
    L49:
        throw new CommonHttpException(0, e.getMessage());     // Catch: Throwable -> L46
    L51:
        throw new CommonHttpException(((HttpResponseException) e).getStatusCode(), e.getMessage());     // Catch: Throwable -> L46
    L22:
        th = th;
    L23:
        r0 = r15;
    L38:
        e = move-exception;
        r0 = r15;
        e = e;
        r16 = null;
    L36:
        th = th;
        r16 = null;
        goto L23
    L14:
        r7 = false;
        goto L15
    L10:
        r3 = null;
    L8:
        e = e;
        r16 = null;
    L6:
        th = th;
        r16 = null;
        goto L52
    }

    @Override // com.bytedance.common.utility.NetworkClient
    public String post(String r8, byte[] r9, Map<String, String> r10, NetworkClient.ReqContext r11) {
        Pair<String, String> r12 = parseUrl(r8);     // Catch: Exception -> L6
        String r0 = (String) r12.first;     // Catch: Exception -> L6
        String r3 = (String) r12.second;     // Catch: Exception -> L6
        ICommonApi r1 = (ICommonApi) RetrofitUtils.createSsService(r0, ICommonApi.class);     // Catch: Exception -> L6
        if (r10 == null) goto L8;
        String r2 = r10.get("Content-Type");     // Catch: Exception -> L6
        r10.remove("Content-Type");     // Catch: Exception -> L6
    L9:
        List<Header> r5 = convertHeaders(r10);     // Catch: Exception -> L6
        if (r11 == null) goto L12;
        boolean r6 = r11.addCommonParams;     // Catch: Exception -> L6
    L13:
        return r1.postData(-1, r3, new TypedByteArray(r2, r9, new String[0]), r5, r6).execute().body();
    L12:
        r6 = false;
        goto L13
    L8:
        r2 = null;
    L6:
        e = move-exception;
        if ((e instanceof HttpResponseException) == true) goto L24;
        if ((e instanceof CronetIOException) == false) goto L22;
        CronetIOException r13 = (CronetIOException) e;
        int r14 = r13.getStatusCode();
        r13.getCronetInternalErrorCode();
        throw new CustomHttpException(r14, e.getMessage());
    L22:
        throw new CustomHttpException(0, e.getMessage());
    L24:
        throw new CustomHttpException(((HttpResponseException) e).getStatusCode(), e.getMessage());
    }
}

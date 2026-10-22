package com.bytedance.ttnet.http;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.parser.StreamParser;
import com.bytedance.frameworks.baselib.network.http.storeregion.StoreRegionManager;
import com.bytedance.retrofit2.HttpMethodContrants;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.utils.RetrofitUtils;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class HttpURLConnClient {
    public HttpURLConnClient() {
    }

    public static String executeGet(final String r11, Map<String, String> r12, Map<String, List<String>> r13, GetDomainContext r14) {
        HttpURLConnection r4 = null;
        if (StringUtils.isEmpty(r11) == true) goto L90;
        if (r14 == null) goto L90;
        if (NetworkUtils.isNetworkAvailable(TTNetInit.getTTNetDepend().getContext()) == true) goto L98;
        return null;
    L98:
    L18:
        th = th;
    L94:
        th.printStackTrace();     // Catch: Throwable -> L86
        throw th;     // Catch: Throwable -> L86
    L86:
        th = move-exception;
        if (r4 != null) goto L96;
    L89:
        throw th;
    L96:
        r4.disconnect();     // Catch: Exception -> L93
        goto L89
    L10:
        if (r14.addCommonParam == false) goto L26;
        String r3 = NetworkParams.addCommonParams(r11, true);     // Catch: Throwable -> L18
        if (TextUtils.isEmpty(r3) == true) goto L26;
        if (r3.equals(r11) == false) goto L25;
        StringBuilder r15 = new StringBuilder(r3);     // Catch: Throwable -> L18
        if (r3.indexOf(63) >= 0) goto L20;
        r15.append("?");     // Catch: Throwable -> L18
    L21:
        r15.append("aid=");     // Catch: Throwable -> L18
        r15.append(TTNetInit.getTTNetDepend().getAppId());     // Catch: Throwable -> L18
        r15.append("&device_platform=android");     // Catch: Throwable -> L18
        if (TTNetInit.getCronetProvider() == null) goto L24;
        r15.append("&version_code=");     // Catch: Throwable -> L18
        r15.append(TTNetInit.getCronetProvider().getVersionCode());     // Catch: Throwable -> L18
        r15.append("&channel=");     // Catch: Throwable -> L18
        r15.append(TTNetInit.getCronetProvider().getChannel());     // Catch: Throwable -> L18
        r15.append("device_id");     // Catch: Throwable -> L18
        r15.append(TTNetInit.getCronetProvider().getDeviceId());     // Catch: Throwable -> L18
    L24:
        r11 = r15.toString();     // Catch: Throwable -> L18
        goto L26
    L20:
        r15.append("&");     // Catch: Throwable -> L18
        goto L21
    L25:
        r11 = r3;
    L26:
        final HttpURLConnection r2 = (HttpURLConnection) new URL(r11).openConnection();     // Catch: Throwable -> L18
        r2.setRequestMethod(HttpMethodContrants.GET);     // Catch: Throwable -> L30
        r2.setConnectTimeout(NetworkParams.getConnectTimeout());     // Catch: Throwable -> L30
        r2.setReadTimeout(NetworkParams.getIoTimeout());     // Catch: Throwable -> L30
        r2.setInstanceFollowRedirects(true);     // Catch: Throwable -> L30
        r2.setRequestProperty("Accept-Encoding", "gzip");     // Catch: Throwable -> L30
        if (r14.useHttps == false) goto L32;
        String r5 = " HttpsURLConnection";
    L33:
        r2.setRequestProperty("User-Agent", ApmTrafficStats.KEY_TRAFFIC_SOURCE_TTNET.concat(r5));     // Catch: Throwable -> L30
        if (r12 != null) goto L36;
    L41:
        int r16 = r2.getResponseCode();     // Catch: Throwable -> L30
        r14.status = r16;     // Catch: Throwable -> L30
        if (r13 == null) goto L54;
        if (r2.getHeaderFields() == null) goto L54;
        Map<String, List<String>> r1 = r2.getHeaderFields();     // Catch: Throwable -> L30
        if (r1 == null) goto L54;
        Iterator<Map.Entry<String, List<String>>> r6 = r1.entrySet().iterator();     // Catch: Throwable -> L30
    L49:
        if (r6.hasNext() == false) goto L54;
        Map.Entry<String, List<String>> r7 = r6.next();     // Catch: Throwable -> L30
        String r8 = r7.getKey();     // Catch: Throwable -> L30
        if (TextUtils.isEmpty(r8) == true) goto L49;
        r13.put(r8.toLowerCase(), r7.getValue());     // Catch: Throwable -> L30
    L54:
        if (r14.useHttps == true) goto L56;
        r14.rawSign = r2.getHeaderField("X-SS-SIGN");     // Catch: Throwable -> L30
    L56:
        r14.tncEtag = r2.getHeaderField(StoreRegionManager.TNC_ETAG_HEADER);     // Catch: Throwable -> L30
        r14.tncAbTest = r2.getHeaderField("x-tt-tnc-abtest");     // Catch: Throwable -> L30
        r14.tncControl = r2.getHeaderField("x-tt-tnc-control");     // Catch: Throwable -> L30
        r14.tncConfigId = r2.getHeaderField(StoreRegionManager.TNC_CONFIG_HEADER);     // Catch: Throwable -> L30
        r14.tncCanary = r2.getHeaderField("x-ss-canary");     // Catch: Throwable -> L30
        r14.tncQueryRegion = r2.getHeaderField("x-tt-tnc-query-region");     // Catch: Throwable -> L30
        r14.logid = r2.getHeaderField("x-tt-logid");     // Catch: Throwable -> L30
        if (r16 != 200) goto L83;
        InputStream r9 = r2.getInputStream();     // Catch: Throwable -> L30
        boolean r10 = "gzip".equals(r2.getHeaderField("Content-Encoding"));     // Catch: Throwable -> L30
        String r17 = r2.getHeaderField("Content-Type");     // Catch: Throwable -> L30
        boolean r18 = StreamParser.testIsSSBinary(r17);     // Catch: Throwable -> L30
        Pair<String, String> r19 = RetrofitUtils.parseContentType(r17);     // Catch: Throwable -> L30
        if (r19 == null) goto L65;
        Object r110 = r19.second;     // Catch: Throwable -> L30
        if (r110 == null) goto L65;
        if (Charset.isSupported((String) r110) == false) goto L65;
        String r111 = (String) r19.second;     // Catch: Throwable -> L30
    L66:
        if (r111 != null) goto L68;
        r111 = "UTF-8";
    L68:
        int[] r0 = {0};     // Catch: Throwable -> L30
        byte[] r112 = StreamParser.response2buf(r10, r2.getHeaderFields(), -1, r9, r0, new AnonymousClass1(r11, r2));     // Catch: Throwable -> L30
        if (r112 == null) goto L100;
        int r20 = r0[0];     // Catch: Throwable -> L30
        if (r20 <= 0) goto L100;
        if (r20 > r112.length) goto L100;
        if (r18 == false) goto L77;
        StreamParser.decodeSSBinary(r112, r20);     // Catch: Throwable -> L30
    L77:
        String r113 = new String(r112, 0, r0[0], r111);     // Catch: Throwable -> L30
        r2.disconnect();     // Catch: Exception -> L91
    L79:
        return r113;
    L100:
        r2.disconnect();     // Catch: Exception -> L92
    L81:
        return null;
    L65:
        r111 = null;
        goto L66
    L83:
        throw new IOException("err status = " + r16);     // Catch: Throwable -> L30
    L36:
        if (r12.size() <= 0) goto L41;
        Iterator<Map.Entry<String, String>> r114 = r12.entrySet().iterator();     // Catch: Throwable -> L30
    L39:
        if (r114.hasNext() == false) goto L41;
        Map.Entry<String, String> r21 = r114.next();     // Catch: Throwable -> L30
        r2.setRequestProperty(r21.getKey(), r21.getValue());     // Catch: Throwable -> L30
        goto L39
    L32:
        r5 = " HttpURLConnection";
    L30:
        th = th;
        r4 = r2;
    L90:
        return null;
    }
}

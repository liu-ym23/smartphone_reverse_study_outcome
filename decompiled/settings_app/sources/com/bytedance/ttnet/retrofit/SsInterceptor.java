package com.bytedance.ttnet.retrofit;

import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.bytedance.frameworks.baselib.network.http.parser.CookieParser;
import com.bytedance.frameworks.baselib.network.http.retrofit.BaseSsInterceptor;
import com.bytedance.frameworks.baselib.network.http.util.UrlBuilder;
import com.bytedance.frameworks.baselib.network.http.util.UrlUtils;
import com.bytedance.frameworks.core.encrypt.RequestEncryptUtils;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.ttnet.AppConsts;
import com.bytedance.ttnet.clientkey.ClientKeyManager;
import com.bytedance.ttnet.http.HttpRequestInfo;
import com.bytedance.ttnet.http.RequestContext;
import com.bytedance.ttnet.utils.CdnCacheVerifyUtils;
import com.bytedance.ttnet.utils.RequestTicketUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class SsInterceptor extends BaseSsInterceptor {
    private static final String SET_COOKIE = "Set-Cookie";
    private static volatile boolean sEncryptQueryEnabled = false;

    static {
    }

    public SsInterceptor() {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.retrofit.BaseSsInterceptor
    protected Request intercept(Request r9) throws IOException {
        Request r10 = super.intercept(r9);
        if (r10 != null) goto L6;
        return null;
    L6:
        long r0 = SystemClock.uptimeMillis();
        Request.Builder r2 = r10.newBuilder();
        String r8 = tryFilterDupQuery(r10.getUrl());
        r2.url(r8);
        if (r10.getMetrics() == null) goto L9;
        RetrofitMetrics r3 = r10.getMetrics();
        r3.filterDupQueryDuration = SystemClock.uptimeMillis() - r0;
    L9:
        Long r1 = Long.valueOf(SystemClock.uptimeMillis());
        ArrayList r4 = new ArrayList();
        if (r10.getHeaders() == null) goto L13;
        r4.addAll(r10.getHeaders());
    L13:
        if (sEncryptQueryEnabled == false) goto L30;
        LinkedList r5 = new LinkedList();     // Catch: Throwable -> L27
        String r6 = RequestEncryptUtils.tryEncryptRequest(r8, r5);     // Catch: Throwable -> L27
        if (r6 == null) goto L18;
        r2.url(r6);     // Catch: Throwable -> L27
    L18:
        if (r5.isEmpty() == true) goto L30;
        Iterator r7 = r5.iterator();     // Catch: Throwable -> L27
    L20:
        if (r7.hasNext() == false) goto L30;
        Pair r11 = (Pair) r7.next();     // Catch: Throwable -> L27
        if (r11 == null) goto L20;
        r4.add(new Header((String) r11.first, (String) r11.second));     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        th.printStackTrace();
    L30:
        if (r10.getMetrics() == null) goto L32;
        RetrofitMetrics r12 = r10.getMetrics();
        r12.encryptRequestDuration = SystemClock.uptimeMillis() - r1.longValue();
    L32:
        Long r13 = Long.valueOf(SystemClock.uptimeMillis());
        String r14 = RequestTicketUtil.tryGenReqTicket(r8);     // Catch: Throwable -> L37
        if (StringUtils.isEmpty(r14) == true) goto L40;
        r4.add(new Header(RequestTicketUtil.HNAME_X_REQ_TICKET, r14));     // Catch: Throwable -> L37
    L40:
        if (r10.getMetrics() == null) goto L42;
        RetrofitMetrics r15 = r10.getMetrics();
        r15.genReqTicketDuration = SystemClock.uptimeMillis() - r13.longValue();
    L42:
        Long r16 = Long.valueOf(SystemClock.uptimeMillis());
        CdnCacheVerifyUtils.preProcessing(r8, r4);
        if (r10.getMetrics() == null) goto L45;
        RetrofitMetrics r17 = r10.getMetrics();
        r17.preCdnCacheVerifyDuration = SystemClock.uptimeMillis() - r16.longValue();
    L45:
        ClientKeyManager.inst().AddClientKeyHeader(r4, r10.getMetrics());
        r2.headers(r4);
        return r2.build();
    L37:
        th = move-exception;
        th.printStackTrace();
        goto L40
    }

    @Override // com.bytedance.frameworks.baselib.network.http.retrofit.BaseSsInterceptor
    protected void intercept(Request r14, SsResponse r15) throws Exception {
        super.intercept(r14, r15);
        if (r14 == null) goto L127;
        if (r15 == null) goto L129;
        Response r13 = r15.raw();
        Long r16 = Long.valueOf(SystemClock.uptimeMillis());
    L21:
        th = move-exception;
        th.printStackTrace();
    L24:
        if (r14.getMetrics() == null) goto L26;
        r14.getMetrics().commandListenerDuration = SystemClock.uptimeMillis() - r16.longValue();
    L26:
        ClientKeyManager.inst().UpdateClientKeyAndSessionInfo(r14, r13);
        Long r17 = Long.valueOf(SystemClock.uptimeMillis());
        Object r1 = r13.getExtraInfo();
        String r4 = null;
        if ((r1 instanceof HttpRequestInfo) == false) goto L47;
        HttpRequestInfo r2 = (HttpRequestInfo) r1;
        if (r2.reqContext == 0) goto L107;
        JSONObject r3 = new JSONObject();
        List<Header> r5 = r13.getHeaders();
        int r6 = 0;
    L32:
        if (r6 >= r5.size()) goto L44;
        Header r7 = r5.get(r6);     // Catch: Exception -> L40
        if (r7 == null) goto L42;
        if (TextUtils.isEmpty(r7.getName()) == true) goto L42;
        r3.put(r7.getName().toUpperCase(), r7.getValue());     // Catch: Exception -> L40
    L42:
        r6 = r6 + 1;
    L40:
        e = move-exception;
        e.printStackTrace();
        goto L42
    L44:
        if ((r2.reqContext instanceof RequestContext) == false) goto L46;
        ((RequestContext) r2.reqContext).headers = r3;
    L46:
        ((RequestContext) r2.reqContext).status = r13.getStatus();
        ((RequestContext) r2.reqContext).remoteIp = r2.remoteIp;
    L107:
        String r8 = r13.getUrl();     // Catch: Throwable -> L60
        Header r9 = r14.getFirstHeader(RequestTicketUtil.HNAME_X_REQ_TICKET);     // Catch: Throwable -> L60
        if (r9 == null) goto L51;
        String r10 = r9.getValue();     // Catch: Throwable -> L60
    L52:
        Header r0 = r13.getFirstHeader(RequestTicketUtil.HNAME_X_REQ_TICKET);     // Catch: Throwable -> L60
        if (r0 == null) goto L55;
        String r11 = r0.getValue();     // Catch: Throwable -> L60
    L56:
        if (r11 == null) goto L58;
        r4 = r11;
    L58:
        RequestTicketUtil.checkReqTicket(r8, r10, r4, r2);     // Catch: Throwable -> L60
    L115:
        String r12 = r14.getUrl();     // Catch: Throwable -> L97
        Uri r18 = Uri.parse(r12);     // Catch: Throwable -> L97
        if (r18.getHost().endsWith(AppConsts.getHostSuffix()) == true) goto L65;
        return;
    L65:
        String[] r19 = {"sessionid", "tt_sessionid"};     // Catch: Throwable -> L97
        List<Header> r20 = r13.headers(new String[]{"Set-Cookie"}[0]);     // Catch: Throwable -> L97
        if (r20 == null) goto L100;
        if (r20.size() <= 0) goto L100;
        Iterator<Header> r21 = r20.iterator();     // Catch: Throwable -> L97
    L71:
        if (r21.hasNext() == false) goto L100;
        Header r22 = r21.next();     // Catch: Throwable -> L97
        int r23 = 0;
    L75:
        if (r23 >= 2) goto L71;
        String r24 = CookieParser.getSpecialCookie(r22.getValue(), r19[r23]);     // Catch: Throwable -> L97
        if (Logger.debug() == false) goto L80;
        Logger.d("SsOkHttpClient", r24);     // Catch: Throwable -> L97
    L80:
        if (StringUtils.isEmpty(r24) == true) goto L96;
        int r25 = r13.getStatus();     // Catch: Throwable -> L97
        boolean r26 = r2.reqTicketUnmatch;     // Catch: Throwable -> L97
        JSONObject r110 = new JSONObject();     // Catch: Throwable -> L97
        String r111 = r18.getEncodedQuery();     // Catch: Throwable -> L106
        if (StringUtils.isEmpty(r111) == true) goto L87;
        r110.put("url_query", r111);     // Catch: Throwable -> L106
    L87:
        if (StringUtils.isEmpty(r2.remoteIp) == true) goto L90;
        r110.put(ICronetClient.KEY_REMOTE_IP, r2.remoteIp);     // Catch: Throwable -> L97
    L90:
        if (r13.getHeaders() == null) goto L92;
        r110.put("header_list", r13.getHeaders().toString());     // Catch: Throwable -> L97
    L92:
        int r112 = r12.indexOf("?");     // Catch: Throwable -> L97
        if (r112 != (-1)) goto L95;
        r112 = r12.length();     // Catch: Throwable -> L97
    L95:
        RequestTicketUtil.sendSetCookieEvent("set_cookie", r12.substring(0, r112), r25, r26, r110);     // Catch: Throwable -> L97
    L96:
        r23 = r23 + 1;
    L100:
        if (r14.getMetrics() == null) goto L102;
        r14.getMetrics().checkReqTicketDuration = SystemClock.uptimeMillis() - r17.longValue();
    L102:
        Long r113 = Long.valueOf(SystemClock.uptimeMillis());
        CdnCacheVerifyUtils.postProcessing(r14, r13, r2);
        if (r14.getMetrics() == null) goto L128;
        r14.getMetrics().postCdnCacheVerifyDuration = SystemClock.uptimeMillis() - r113.longValue();
        return;
    L128:
        return;
    L97:
        th = move-exception;
        th.printStackTrace();
        goto L100
    L55:
        r11 = null;
        goto L56
    L51:
        r10 = null;
    L60:
        th = move-exception;
        th.printStackTrace();
        goto L115
    L47:
        r2 = null;
        goto L107
    L8:
        if (NetworkParams.getCommandListener() == null) goto L24;
        String r27 = NetworkParams.getCommandListener().getHeaderKey();     // Catch: Throwable -> L21
        if (StringUtils.isEmpty(r27) == true) goto L24;
        List<Header> r28 = r13.headers(r27);     // Catch: Throwable -> L21
        if (r28 == null) goto L24;
        if (r28.size() <= 0) goto L24;
        ArrayList r29 = new ArrayList();     // Catch: Throwable -> L21
        Iterator<Header> r30 = r28.iterator();     // Catch: Throwable -> L21
    L17:
        if (r30.hasNext() == false) goto L19;
        r29.add(r30.next().getValue());     // Catch: Throwable -> L21
        goto L17
    L19:
        NetworkParams.getCommandListener().onCommandReceived(r29);     // Catch: Throwable -> L21
        goto L24
    L129:
        return;
    }

    private String tryFilterDupQuery(String r7) {
        if (StringUtils.isEmpty(r7) == false) goto L53;
        return r7;
    L53:
        LinkedHashMap r6 = new LinkedHashMap();     // Catch: Throwable -> L50
        Pair<String, String> r0 = UrlUtils.parseUrlWithValueList(r7, r6);     // Catch: Throwable -> L50
        if (r0 != null) goto L9;
        return r7;
    L9:
        if (r6.isEmpty() == true) goto L28;
        Iterator r1 = r6.entrySet().iterator();     // Catch: Throwable -> L50
    L12:
        if (r1.hasNext() == false) goto L28;
        Map.Entry r2 = (Map.Entry) r1.next();     // Catch: Throwable -> L50
        if (r2 == null) goto L12;
        List r3 = (List) r2.getValue();     // Catch: Throwable -> L50
        if (r3 == null) goto L12;
        if (r3.isEmpty() == true) goto L12;
        LinkedHashSet r4 = new LinkedHashSet();     // Catch: Throwable -> L50
        Iterator r5 = r3.iterator();     // Catch: Throwable -> L50
    L23:
        if (r5.hasNext() == false) goto L12;
        String r8 = (String) r5.next();     // Catch: Throwable -> L50
        if (r4.contains(r8) == true) goto L26;
        r4.add(r8);     // Catch: Throwable -> L50
        goto L23
    L26:
        r5.remove();     // Catch: Throwable -> L50
    L28:
        UrlBuilder r9 = new UrlBuilder(((String) r0.first) + ((String) r0.second));     // Catch: Throwable -> L50
        if (r6.isEmpty() == true) goto L48;
        Iterator r10 = r6.entrySet().iterator();     // Catch: Throwable -> L50
    L32:
        if (r10.hasNext() == false) goto L48;
        Map.Entry r11 = (Map.Entry) r10.next();     // Catch: Throwable -> L50
        if (r11 == null) goto L32;
        if (r11.getKey() == null) goto L32;
        List r12 = (List) r11.getValue();     // Catch: Throwable -> L50
        if (r12 == null) goto L32;
        if (r12.isEmpty() == true) goto L32;
        Iterator r13 = r12.iterator();     // Catch: Throwable -> L50
    L46:
        if (r13.hasNext() == false) goto L32;
        r9.addParam((String) r11.getKey(), (String) r13.next());     // Catch: Throwable -> L50
    L48:
        return r9.build();
    L50:
        th = move-exception;
        th.printStackTrace();
        return r7;
    }

    public static void EnableEncryptQuery(boolean r0) {
        sEncryptQueryEnabled = r0;
    }
}

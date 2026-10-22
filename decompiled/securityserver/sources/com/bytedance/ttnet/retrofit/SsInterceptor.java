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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class SsInterceptor extends BaseSsInterceptor {
    private static final String SET_COOKIE = "Set-Cookie";
    private static volatile boolean sEncryptQueryEnabled = false;
    private static volatile boolean sHttpInfoInjectedByInterceptor = false;

    public SsInterceptor() {
    }

    public static void EnableEncryptQuery(boolean r0) {
        sEncryptQueryEnabled = r0;
    }

    private String tryFilterDupQuery(String r7) {
        if (StringUtils.isEmpty(r7) == false) goto L54;
        return r7;
    L54:
        LinkedHashMap r6 = new LinkedHashMap();     // Catch: Throwable -> L27
        Pair<String, String> r0 = UrlUtils.parseUrlWithValueList(r7, r6);     // Catch: Throwable -> L27
        if (r0 != null) goto L9;
        return r7;
    L9:
        if (r6.isEmpty() == true) goto L30;
        Iterator r1 = r6.entrySet().iterator();     // Catch: Throwable -> L27
    L12:
        if (r1.hasNext() == false) goto L30;
        Map.Entry r2 = (Map.Entry) r1.next();     // Catch: Throwable -> L27
        if (r2 == null) goto L12;
        List r3 = (List) r2.getValue();     // Catch: Throwable -> L27
        if (r3 == null) goto L12;
        if (r3.isEmpty() == true) goto L12;
        LinkedHashSet r4 = new LinkedHashSet();     // Catch: Throwable -> L27
        Iterator r5 = r3.iterator();     // Catch: Throwable -> L27
    L23:
        if (r5.hasNext() == false) goto L12;
        String r8 = (String) r5.next();     // Catch: Throwable -> L27
        if (r4.contains(r8) == true) goto L26;
        r4.add(r8);     // Catch: Throwable -> L27
        goto L23
    L26:
        r5.remove();     // Catch: Throwable -> L27
    L30:
        UrlBuilder r9 = new UrlBuilder(((String) r0.first) + ((String) r0.second));     // Catch: Throwable -> L27
        if (r6.isEmpty() == true) goto L50;
        Iterator r10 = r6.entrySet().iterator();     // Catch: Throwable -> L27
    L34:
        if (r10.hasNext() == false) goto L50;
        Map.Entry r11 = (Map.Entry) r10.next();     // Catch: Throwable -> L27
        if (r11 == null) goto L34;
        if (r11.getKey() == null) goto L34;
        List r12 = (List) r11.getValue();     // Catch: Throwable -> L27
        if (r12 == null) goto L34;
        if (r12.isEmpty() == true) goto L34;
        Iterator r13 = r12.iterator();     // Catch: Throwable -> L27
    L48:
        if (r13.hasNext() == false) goto L34;
        r9.addParam((String) r11.getKey(), (String) r13.next());     // Catch: Throwable -> L27
    L50:
        return r9.build();
    L27:
        th = move-exception;
        th.printStackTrace();
        return r7;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.retrofit.BaseSsInterceptor
    public Request intercept(Request r9) {
        Request r10 = super.intercept(r9);
        if (r10 != null) goto L7;
        return null;
    L7:
        if (sHttpInfoInjectedByInterceptor == true) goto L9;
        HttpRequestInfo.injectCreate();
        sHttpInfoInjectedByInterceptor = true;
    L9:
        long r0 = SystemClock.uptimeMillis();
        Request.Builder r2 = r10.newBuilder();
        String r8 = tryFilterDupQuery(r10.getUrl());
        r2.url(r8);
        if (r10.getMetrics() == null) goto L12;
        RetrofitMetrics r3 = r10.getMetrics();
        r3.filterDupQueryDuration = SystemClock.uptimeMillis() - r0;
    L12:
        long r1 = SystemClock.uptimeMillis();
        ArrayList r4 = new ArrayList();
        if (r10.getHeaders() == null) goto L16;
        r4.addAll(r10.getHeaders());
    L16:
        if (sEncryptQueryEnabled == false) goto L34;
        LinkedList r5 = new LinkedList();     // Catch: Throwable -> L20
        String r6 = RequestEncryptUtils.tryEncryptRequest(r8, r5);     // Catch: Throwable -> L20
        if (r6 == null) goto L23;
        r2.url(r6);     // Catch: Throwable -> L20
    L23:
        if (r5.isEmpty() == true) goto L34;
        Iterator r7 = r5.iterator();     // Catch: Throwable -> L20
    L25:
        if (r7.hasNext() == false) goto L34;
        Pair r11 = (Pair) r7.next();     // Catch: Throwable -> L20
        if (r11 == null) goto L25;
        r4.add(new Header((String) r11.first, (String) r11.second));     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        th.printStackTrace();
    L34:
        if (r10.getMetrics() == null) goto L36;
        RetrofitMetrics r12 = r10.getMetrics();
        r12.encryptRequestDuration = SystemClock.uptimeMillis() - r1;
    L36:
        long r13 = SystemClock.uptimeMillis();
        String r14 = RequestTicketUtil.tryGenReqTicket(r8);     // Catch: Throwable -> L41
        if (StringUtils.isEmpty(r14) == true) goto L44;
        r4.add(new Header(RequestTicketUtil.HNAME_X_REQ_TICKET, r14));     // Catch: Throwable -> L41
    L44:
        if (r10.getMetrics() == null) goto L46;
        RetrofitMetrics r15 = r10.getMetrics();
        r15.genReqTicketDuration = SystemClock.uptimeMillis() - r13;
    L46:
        long r16 = SystemClock.uptimeMillis();
        CdnCacheVerifyUtils.preProcessing(r8, r4);
        if (r10.getMetrics() == null) goto L49;
        RetrofitMetrics r17 = r10.getMetrics();
        r17.preCdnCacheVerifyDuration = SystemClock.uptimeMillis() - r16;
    L49:
        ClientKeyManager.inst().AddClientKeyHeader(r4, r10.getMetrics());
        r2.headers(r4);
        return r2.build();
    L41:
        th = move-exception;
        th.printStackTrace();
        goto L44
    }

    @Override // com.bytedance.frameworks.baselib.network.http.retrofit.BaseSsInterceptor
    public void intercept(Request r18, SsResponse r19) {
        super.intercept(r18, r19);
        if (r18 == null) goto L130;
        if (r19 == null) goto L132;
        Response r3 = r19.raw();
        long r4 = SystemClock.uptimeMillis();
    L19:
        th = move-exception;
        th.printStackTrace();
    L25:
        if (r18.getMetrics() == null) goto L27;
        r18.getMetrics().commandListenerDuration = SystemClock.uptimeMillis() - r4;
    L27:
        ClientKeyManager.inst().UpdateClientKeyAndSessionInfo(r18, r3);
        long r5 = SystemClock.uptimeMillis();
        Object r0 = r3.getExtraInfo();
        int r7 = 0;
        String r8 = null;
        if ((r0 instanceof HttpRequestInfo) == false) goto L48;
        HttpRequestInfo r6 = (HttpRequestInfo) r0;
        if (r6.reqContext == 0) goto L112;
        JSONObject r9 = new JSONObject();
        List<Header> r10 = r3.getHeaders();
        int r11 = 0;
    L33:
        if (r11 >= r10.size()) goto L44;
        Header r1 = r10.get(r11);     // Catch: Exception -> L41
        if (r1 == null) goto L43;
        if (TextUtils.isEmpty(r1.getName()) == true) goto L43;
        r9.put(r1.getName().toUpperCase(), r1.getValue());     // Catch: Exception -> L41
    L43:
        r11 = r11 + 1;
    L41:
        e = move-exception;
        e.printStackTrace();
        goto L43
    L44:
        T r2 = r6.reqContext;
        if ((r2 instanceof RequestContext) == false) goto L47;
        ((RequestContext) r2).headers = r9;
    L47:
        ((RequestContext) r2).status = r3.getStatus();
        ((RequestContext) r6.reqContext).remoteIp = r6.remoteIp;
    L112:
        String r12 = r3.getUrl();     // Catch: Throwable -> L52
        Header r13 = r18.getFirstHeader(RequestTicketUtil.HNAME_X_REQ_TICKET);     // Catch: Throwable -> L52
        if (r13 == null) goto L54;
        String r14 = r13.getValue();     // Catch: Throwable -> L52
    L55:
        Header r15 = r3.getFirstHeader(RequestTicketUtil.HNAME_X_REQ_TICKET);     // Catch: Throwable -> L52
        if (r15 == null) goto L58;
        String r16 = r15.getValue();     // Catch: Throwable -> L52
    L59:
        if (r16 == null) goto L61;
        r8 = r16;
    L61:
        RequestTicketUtil.checkReqTicket(r12, r14, r8, r6);     // Catch: Throwable -> L52
    L116:
        String r17 = r18.getUrl();     // Catch: Throwable -> L81
        Uri r20 = Uri.parse(r17);     // Catch: Throwable -> L81
        if (r20.getHost().endsWith(AppConsts.getHostSuffix()) == true) goto L67;
        return;
    L67:
        String[] r21 = {"sessionid", "tt_sessionid"};     // Catch: Throwable -> L81
        List<Header> r22 = r3.headers(new String[]{"Set-Cookie"}[0]);     // Catch: Throwable -> L81
        if (r22 == null) goto L103;
        if (r22.size() <= 0) goto L103;
        Iterator<Header> r23 = r22.iterator();     // Catch: Throwable -> L81
    L73:
        if (r23.hasNext() == false) goto L103;
        Header r110 = r23.next();     // Catch: Throwable -> L81
        int r111 = r7;
    L77:
        if (r111 >= 2) goto L73;
        String r112 = CookieParser.getSpecialCookie(r110.getValue(), r21[r111]);     // Catch: Throwable -> L81
        if (Logger.debug() == false) goto L84;
        Logger.d("SsOkHttpClient", r112);     // Catch: Throwable -> L81
    L84:
        if (StringUtils.isEmpty(r112) == true) goto L100;
        int r113 = r3.getStatus();     // Catch: Throwable -> L81
        boolean r114 = r6.reqTicketUnmatch;     // Catch: Throwable -> L81
        JSONObject r115 = new JSONObject();     // Catch: Throwable -> L81
        String r116 = r20.getEncodedQuery();     // Catch: Throwable -> L109
        if (StringUtils.isEmpty(r116) == true) goto L91;
        r115.put("url_query", r116);     // Catch: Throwable -> L109
    L91:
        if (StringUtils.isEmpty(r6.remoteIp) == true) goto L94;
        r115.put(ICronetClient.KEY_REMOTE_IP, r6.remoteIp);     // Catch: Throwable -> L81
    L94:
        if (r3.getHeaders() == null) goto L96;
        r115.put("header_list", r3.getHeaders().toString());     // Catch: Throwable -> L81
    L96:
        int r24 = r17.indexOf("?");     // Catch: Throwable -> L81
        if (r24 != (-1)) goto L99;
        r24 = r17.length();     // Catch: Throwable -> L81
    L99:
        RequestTicketUtil.sendSetCookieEvent("set_cookie", r17.substring(0, r24), r113, r114, r115);     // Catch: Throwable -> L81
    L100:
        r111 = r111 + 1;
        r7 = 0;
    L103:
        if (r18.getMetrics() == null) goto L105;
        r18.getMetrics().checkReqTicketDuration = SystemClock.uptimeMillis() - r5;
    L105:
        long r25 = SystemClock.uptimeMillis();
        CdnCacheVerifyUtils.postProcessing(r18, r3, r6);
        if (r18.getMetrics() == null) goto L131;
        r18.getMetrics().postCdnCacheVerifyDuration = SystemClock.uptimeMillis() - r25;
        return;
    L131:
        return;
    L81:
        th = move-exception;
        th.printStackTrace();
        goto L103
    L58:
        r16 = null;
        goto L59
    L54:
        r14 = null;
    L52:
        th = move-exception;
        th.printStackTrace();
        goto L116
    L48:
        r6 = null;
        goto L112
    L8:
        if (NetworkParams.getCommandListener() == null) goto L25;
        String r26 = NetworkParams.getCommandListener().getHeaderKey();     // Catch: Throwable -> L19
        if (StringUtils.isEmpty(r26) == true) goto L25;
        List<Header> r27 = r3.headers(r26);     // Catch: Throwable -> L19
        if (r27 == null) goto L25;
        if (r27.size() <= 0) goto L25;
        ArrayList r28 = new ArrayList();     // Catch: Throwable -> L19
        Iterator<Header> r29 = r27.iterator();     // Catch: Throwable -> L19
    L17:
        if (r29.hasNext() == false) goto L21;
        r28.add(r29.next().getValue());     // Catch: Throwable -> L19
        goto L17
    L21:
        NetworkParams.getCommandListener().onCommandReceived(r28);     // Catch: Throwable -> L19
        goto L25
    L132:
        return;
    }
}

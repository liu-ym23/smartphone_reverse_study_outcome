package u9;

import ai.i0;
import ai.j0;
import android.content.Context;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.CookieManager;
import com.bytedance.ai.event.MessageIndication;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.frameworks.baselib.network.http.exception.NetworkNotAvailabeException;
import com.bytedance.frameworks.baselib.network.http.parser.MimeType;
import com.bytedance.retrofit2.client.Request;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import kotlin.jvm.internal.ByteCompanionObject;
import org.json.JSONObject;
import ym.p;

/* JADX INFO: loaded from: classes2.dex */
public final class l implements bi.b, ICronetClient.ICronetBootFailureChecker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f22315a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ICronetClient f22316b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile l f22317c = null;
    public static volatile boolean d = false;
    public static volatile int e;
    public static Object f;
    public static Object g;

    public static void a(String r5) {
        if (d == true) goto L12;
        Context r10 = f22315a;
        if (r10 == null) goto L12;
        if (com.bytedance.common.utility.f.c(r10) == true) goto L12;
        throw new NetworkNotAvailabeException("network not available");
    L12:
        if (d == true) goto L14;
        return;
    L14:
        if (TextUtils.isEmpty(r5) == false) goto L16;
        return;
    L16:
        if (r5.contains("net::ERR_INTERNET_DISCONNECTED") == true) goto L19;
        return;
    L19:
        throw new NetworkNotAvailabeException("network not available");
    }

    /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.Object, u9.k] */
    public static HttpURLConnection c(String r10, Request r11, s9.b r12, long r13) {
        sj.d r5 = s9.h.f21879a;
        Object r14 = r11.getExtraInfo();
        if (r14 != null) goto L5;
    L7:
        Object r15 = s9.h.d;
        monitor-enter(r15);
    L17:
        th = move-exception;
        throw th;
    L10:
        if (s9.h.f21881c.get() == false) goto L90;
    L20:
        monitor-exit(r15);     // Catch: Throwable -> L17
        CookieManager r16 = CookieManager.getInstance();     // Catch: Throwable -> L88
        if (r16.acceptCookie() == true) goto L24;
        r16.setAcceptCookie(true);     // Catch: Throwable -> L88
    L24:
        Logger.d("l", "newCookieBlockPositionEnabled false:" + r11.getUrl());
        s();
        ICronetClient r17 = f22316b;
        if (r17 == null) goto L85;
        r17.setCronetBootFailureChecker(f22317c);
        ICronetClient r18 = f22316b;
        Context r19 = f22315a;
        ?? r20 = g;
        boolean r21 = false;
        if (r20 != 0) goto L29;
        boolean r22 = false;
    L30:
        HttpURLConnection r23 = r18.openConnection(r19, r10, r22, s9.h.f21880b, new h.a(3));
        r23.setConnectTimeout(15000);
        r23.setReadTimeout(15000);
        int r24 = e;
        if (r24 < 8192) goto L34;
        if (r24 > 20971520) goto L34;
        boolean r25 = true;
    L36:
        if (r25 == true) goto L100;
    L41:
        r23.setInstanceFollowRedirects(true);
        vj.b r26 = r12.f21859b;
        if (r26 == null) goto L94;
        r26.getClass();
        int r27 = e;
    L94:
        Reflect.on(r23).call("setRequestPriority", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r11.getRequestPriorityLevel())});     // Catch: Throwable -> L46
    L49:
        if (r13 > 0) goto L98;
    L54:
        r23.setRequestMethod(r11.getMethod());
        r23.setDoInput(true);
        Iterator<bi.c> r110 = r11.getHeaders().iterator();
    L56:
        if (r110.hasNext() == false) goto L66;
        bi.c r111 = r110.next();
        if (com.bytedance.common.utility.b.b(r111.f915a) == true) goto L56;
        String r28 = r111.f916b;
        if (com.bytedance.common.utility.b.b(r28) == true) goto L56;
        String r112 = r111.f915a;
        if ("User-Agent".equalsIgnoreCase(r112) == false) goto L65;
        r21 = true;
    L65:
        r23.setRequestProperty(r112, r28);
        goto L56
    L66:
        if (r21 == true) goto L73;
        String r113 = s9.h.f21880b;
        if (com.bytedance.common.utility.b.b(r113) == true) goto L73;
        if (f22316b == null) goto L72;
        StringBuilder r114 = j0.w(r113, " cronet/");
        r114.append(f22316b.getCronetVersion());
        r113 = r114.toString();
    L72:
        r23.setRequestProperty("User-Agent", r113);
    L73:
        fi.j r115 = r11.getBody();
        if (r115 == null) goto L82;
        r23.setDoOutput(true);
        r23.setRequestProperty("Content-Type", r115.a());
        String r116 = r115.d();
        if (r116 == null) goto L78;
        r23.setRequestProperty("X-SS-STUB", r116);
    L78:
        long r117 = r115.length();
        if (r117 == (-1)) goto L81;
        r23.setFixedLengthStreamingMode((int) r117);
        r23.setRequestProperty("Content-Length", String.valueOf(r117));
        goto L82
    L81:
        r23.setChunkedStreamingMode(4096);
    L82:
        r12.f21869p = d(r23);
        return r23;
    L98:
        Reflect.on(r23).call("setThrottleNetSpeed", new Class[]{Integer.TYPE}, new Object[]{Long.valueOf(r13)});     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        th.printStackTrace();
    L46:
        th = move-exception;
        th.printStackTrace();
        goto L49
    L100:
        Reflect.on(r23).call("setInputStreamBufferSize", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(e)});     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        th.printStackTrace();
    L34:
        r25 = false;
        goto L36
    L29:
        r22 = r20.g();
        goto L30
    L85:
        throw new IllegalArgumentException("CronetClient is null");
    L90:
        CountDownLatch r29 = s9.h.e;     // Catch: Throwable -> L17 Exception -> L89
        if (r29 == null) goto L19;
        r29.await(5000, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L17 Exception -> L89
        if (s9.h.e.getCount() != 1) goto L19;
        s9.h.e.countDown();     // Catch: Throwable -> L17 Exception -> L89
    L19:
        s9.h.f21881c.getAndSet(true);     // Catch: Throwable -> L17
        goto L20
    L5:
        if ((r14 instanceof vj.b) == false) goto L7;
        vj.b r30 = (vj.b) r14;
        goto L7
    }

    public static JSONObject d(HttpURLConnection r5) {
        JSONObject r10 = new JSONObject();
        if (r5 != null) goto L14;
        return r10;
    L14:
        r10.put("hc", "SsCronetHttpClient");     // Catch: Exception -> L8
        ICronetClient r11 = f22316b;     // Catch: Exception -> L8
        if (r11 == null) goto L10;
        r10.put("hcv", r11.getCronetVersion());     // Catch: Exception -> L8
    L10:
        r10.put("ua", r5.getRequestProperty("User-Agent"));     // Catch: Exception -> L8
    L13:
        return r10;
    L8:
        e = move-exception;
        e.printStackTrace();
        goto L13
    }

    public static ArrayList e(HttpURLConnection r5, boolean r10) {
        if (r5 != null) goto L5;
        return null;
    L5:
        ArrayList r11 = new ArrayList();
        Iterator<Map.Entry<String, List<String>>> r12 = r5.getHeaderFields().entrySet().iterator();
    L7:
        if (r12.hasNext() == false) goto L18;
        Map.Entry<String, List<String>> r13 = r12.next();
        String r14 = r13.getKey();
        if (r14 == null) goto L14;
        if (r14.equalsIgnoreCase("bdturing-verify") == false) goto L14;
        if (r10 == true) goto L7;
    L14:
        Iterator<String> r15 = r13.getValue().iterator();
    L16:
        if (r15.hasNext() == false) goto L7;
        r11.add(new bi.c(r14, r15.next()));
        goto L16
    L18:
        return r11;
    }

    public static void f(boolean r10, String r11, String r12, String r13, boolean r14, String r15) {
        ICronetClient r5 = f22316b;
        if (r5 == null) goto L7;
        Reflect r16 = Reflect.on(r5);
        Class r17 = Boolean.TYPE;
        r16.call("enableTTBizHttpDns", new Class[]{r17, String.class, String.class, String.class, r17, String.class}, new Object[]{Boolean.valueOf(r10), r11, r12, r13, Boolean.valueOf(r14), r15}).get();
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public static String g(HttpURLConnection r10) {
        if (r10 != null) goto L42;
        return "";
    L42:
        Map<String, List<String>> r11 = r10.getHeaderFields();     // Catch: Throwable -> L32
        if (r11 != null) goto L8;
    L39:
        return "";
    L8:
        if (r11.isEmpty() == true) goto L39;
        JSONObject r5 = new JSONObject();     // Catch: Throwable -> L32
        Iterator<Map.Entry<String, List<String>>> r12 = r11.entrySet().iterator();     // Catch: Throwable -> L32
    L12:
        if (r12.hasNext() == false) goto L37;
        Map.Entry<String, List<String>> r13 = r12.next();     // Catch: Throwable -> L32
        if (r13 == null) goto L12;
        String r14 = r13.getKey();     // Catch: Throwable -> L32
        if (com.bytedance.common.utility.b.b(r14) == true) goto L12;
        List<String> r15 = r13.getValue();     // Catch: Throwable -> L32
        if (r15 == null) goto L12;
        if (r15.isEmpty() == true) goto L12;
        StringBuilder r16 = new StringBuilder();     // Catch: Throwable -> L32
        Iterator<String> r17 = r15.iterator();     // Catch: Throwable -> L32
        int r18 = 0;
    L26:
        if (r17.hasNext() == false) goto L36;
        String r19 = r17.next();     // Catch: Throwable -> L32
        if (com.bytedance.common.utility.b.b(r19) == true) goto L26;
        if (r18 != 0) goto L34;
        r16.append(r19);     // Catch: Throwable -> L32
    L35:
        r18 = r18 + 1;     // Catch: Throwable -> L32
        goto L26
    L34:
        r16.append("; ");     // Catch: Throwable -> L32
        r16.append(r19);     // Catch: Throwable -> L32
        goto L35
    L36:
        r5.put(r14, r16.toString());     // Catch: Throwable -> L32
        goto L12
    L37:
        return r5.toString();
    L32:
        th = move-exception;
        th.printStackTrace();
        return "";
    }

    public static String h(String r5) {
    L7:
        e = move-exception;
        e.printStackTrace();
        return "";
    L4:
        if (com.bytedance.common.utility.b.b(r5) == true) goto L12;
        return new MimeType(r5).getBaseType();
    L12:
        return "";
    }

    public static String i(HttpURLConnection r5, String r10) {
        if (r5 != null) goto L4;
        return null;
    L4:
        if (TextUtils.isEmpty(r10) == true) goto L13;
        String r11 = r5.getHeaderField(r10);
        if (TextUtils.isEmpty(r11) == true) goto L9;
        return r11;
    L9:
        return r5.getHeaderField(r10.toLowerCase());
    L13:
        return null;
    }

    public static void j(String r5, s9.b r10) {
        if (com.bytedance.common.utility.b.b(r5) == true) goto L16;
        if (r10 == null) goto L18;
        if (Logger.debug() == false) goto L9;
        Logger.d("l", "getRequestInfo remoteIp = " + r5);     // Catch: Throwable -> L13
    L9:
        r10.f21858a = r5;     // Catch: Throwable -> L13
        vj.b r11 = r10.f21859b;     // Catch: Throwable -> L13
        if (r11 == null) goto L17;
        r11.getClass();     // Catch: Throwable -> L13
        return;
    L17:
        return;
    L19:
        return;
    L18:
        return;
    }

    public static void k(HttpURLConnection r10, s9.b r11, i0 r12) {
        if (r11 != null) goto L23;
        return;
    L23:
    L10:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (f22316b == null) goto L12;
        LinkedHashMap r5 = new LinkedHashMap();     // Catch: Throwable -> L10
        f22316b.getRequestMetrics(r10, r5);     // Catch: Throwable -> L10
        if (r5.isEmpty() == true) goto L12;
        r11.f21858a = (String) l(r5.get(ICronetClient.KEY_REMOTE_IP), String.class, "");     // Catch: Throwable -> L10
        r11.f21860c = ((Long) l(r5.get(ICronetClient.KEY_DNS_TIME), Long.class, -1L)).longValue();     // Catch: Throwable -> L10
        r11.d = ((Long) l(r5.get(ICronetClient.KEY_CONNECT_TIME), Long.class, -1L)).longValue();     // Catch: Throwable -> L10
        r11.e = ((Long) l(r5.get(ICronetClient.KEY_SSL_TIME), Long.class, -1L)).longValue();     // Catch: Throwable -> L10
        r11.f = ((Long) l(r5.get(ICronetClient.KEY_SEND_TIME), Long.class, -1L)).longValue();     // Catch: Throwable -> L10
        Long r13 = (Long) l(r5.get(ICronetClient.KEY_PUSH_TIME), Long.class, -1L);     // Catch: Throwable -> L10
        r11.g = ((Long) l(r5.get(ICronetClient.KEY_RECEIVE_TIME), Long.class, -1L)).longValue();     // Catch: Throwable -> L10
        r11.f21861h = ((Boolean) l(r5.get(ICronetClient.KEY_SOCKET_REUSED), Boolean.class, Boolean.FALSE)).booleanValue();     // Catch: Throwable -> L10
        r11.f21862i = ((Long) l(r5.get(ICronetClient.KEY_TTFB), Long.class, -1L)).longValue();     // Catch: Throwable -> L10
        r11.f21863j = ((Long) l(r5.get(ICronetClient.KEY_TOTAL_TIME), Long.class, -1L)).longValue();     // Catch: Throwable -> L10
        r11.f21864k = ((Long) l(r5.get(ICronetClient.KEY_SEND_BYTE_COUNT), Long.class, -1L)).longValue();     // Catch: Throwable -> L10
        r11.f21865l = ((Long) l(r5.get(ICronetClient.KEY_RECEIVED_BYTE_COUNT), Long.class, -1L)).longValue();     // Catch: Throwable -> L10
        r11.f21868o = (String) l(r5.get("request_log"), String.class, "");     // Catch: Throwable -> L10
        Long r14 = (Long) l(r5.get(ICronetClient.KEY_RETRY_ATTEMPTS), Long.class, -1L);     // Catch: Throwable -> L10
        r11.f21871r = (String) l(r5.get(ICronetClient.KEY_REQUEST_HEADERS), String.class, "");     // Catch: Throwable -> L10
        r11.s = (String) l(r5.get(ICronetClient.KEY_RESPONSE_HEADERS), String.class, "");     // Catch: Throwable -> L10
        Long r15 = (Long) l(r5.get(ICronetClient.KEY_POST_TASK_START), Long.class, -1L);     // Catch: Throwable -> L10
        Long r16 = (Long) l(r5.get(ICronetClient.KEY_REQUEST_START), Long.class, -1L);     // Catch: Throwable -> L10
        Long r17 = (Long) l(r5.get(ICronetClient.KEY_WAIT_CONTEXT), Long.class, -1L);     // Catch: Throwable -> L10
    L12:
        if (r12 == null) goto L25;
        HashMap r18 = r12.M;     // Catch: Throwable -> L10
        r12.f217a = r11.f21867n;     // Catch: Throwable -> L10
        r12.f231t = SystemClock.uptimeMillis();     // Catch: Throwable -> L10
        r12.f222j = System.currentTimeMillis();     // Catch: Throwable -> L10
        r12.N = "4.1.79.42-pico";     // Catch: Throwable -> L10
        r18.put("sentByteCount", Long.valueOf(r11.f21864k));     // Catch: Throwable -> L10
        r18.put("receivedByteCount", Long.valueOf(r11.f21865l));     // Catch: Throwable -> L10
        JSONObject r19 = r11.f21869p;     // Catch: Throwable -> L10
        if (r11.f21872t == false) goto L17;
        r19.put("turing_callback", r11.f21873u);     // Catch: Throwable -> L10
    L17:
        if (r11.f21874v == false) goto L19;
        r19.put("turing_retry", IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST);     // Catch: Throwable -> L10
    L19:
        r19.put("retrofit", r12.d());     // Catch: Throwable -> L10
        return;
    }

    public static Object l(Object r5, Class r10, Object r11) {
        if (r5 != null) goto L4;
    L6:
        return r11;
    L4:
        if (r5.getClass().equals(r10) == false) goto L6;
        return r5;
    }

    public static l m(Context r5) {
        if (f22317c != null) goto L16;
        monitor-enter(l.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (f22317c != null) goto L11;
        l r10 = new l();     // Catch: Throwable -> L9
        f22315a = r5.getApplicationContext();     // Catch: Throwable -> L9
        f22317c = r10;     // Catch: Throwable -> L9
        s();     // Catch: Throwable -> L9
    L11:
        monitor-exit(l.class);     // Catch: Throwable -> L9
    L16:
        return f22317c;
    }

    public static void n(String r10, String r11, String r12, String r13, String r14, String r15, String r16, String r17) {
        ICronetClient r5 = f22316b;
        if (r5 == null) goto L7;
        Reflect.on(r5).call("notifyStoreRegionUpdated", new Class[]{String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class}, new Object[]{r10, r11, r12, r13, r14, r15, r16, r17}).get();
        return;
    L7:
        throw new UnsupportedOperationException("CronetEngine has not been initialized.");
    }

    public static void o(String r5, s9.b r10, Exception r11, HttpURLConnection r12, i0 r13) {
        if (r5 == null) goto L44;
        if (r10 == null) goto L46;
    L8:
        th = move-exception;
        th.printStackTrace();
    L16:
        if (com.bytedance.common.utility.b.b(r10.f21858a) == false) goto L34;
        String r14 = "";
        String r15 = r11.getMessage();     // Catch: Throwable -> L28
        if (r15 == null) goto L33;
        String[] r16 = r15.split("\\|");     // Catch: Throwable -> L28
        if (r16 == null) goto L33;
        if (r16.length < 2) goto L33;
        if (Logger.debug() == false) goto L30;
        Logger.d("l", "getHostAddress remoteIp = " + r16[0]);     // Catch: Throwable -> L28
    L30:
        r14 = r16[0];     // Catch: Throwable -> L28
    L33:
        j(r14, r10);
    L28:
        th = move-exception;
        th.printStackTrace();
    L34:
        System.currentTimeMillis();
        System.currentTimeMillis();
        k(r12, r10, r13);
        sj.d r17 = s9.h.f21879a;
        if (r10.f21870q == false) goto L37;
        r10.f21875w.set(true);
    L37:
        if (r12 == null) goto L45;
        r12.disconnect();
        return;
    L45:
        return;
    L6:
        if (r10.f21869p != null) goto L10;
        r10.f21869p = d(r12);     // Catch: Throwable -> L8
    L10:
        r10.f21869p.put("ex", r11.getMessage());     // Catch: Throwable -> L8
        String r18 = g(r12);     // Catch: Throwable -> L8
        if (com.bytedance.common.utility.b.b(r18) == true) goto L16;
        r10.f21869p.put("response-headers", r18);     // Catch: Throwable -> L8
        goto L16
    L46:
        return;
    }

    public static void p(boolean r5, int r10, InputStream r11, String r12, String r13, i0 r14) {
        if (r11 != null) goto L5;
        return;
    L5:
        int[] r15 = new int[1];
        r15[0] = 0;     // Catch: Throwable -> L33
        byte[] r16 = com.lynx.tasm.utils.g.m(r5, r10, r11, r15, r14);     // Catch: Throwable -> L33
        com.lynx.tasm.utils.g.n(r11);
        int r17 = r15[0];
        byte[] r18 = new byte[r17];
        if (r16 == null) goto L11;
        if (r17 <= 0) goto L11;
        System.arraycopy(r16, 0, r18, 0, r17);
    L11:
        if (r17 > 0) goto L13;
        return;
    L13:
        if (com.bytedance.common.utility.b.b(r12) == false) goto L15;
        return;
    L15:
        if (Logger.debug() == false) goto L42;
        MimeType r19 = new MimeType(r12);     // Catch: Throwable -> L21
        if (MessageIndication.CONTENT_TYPE_TEXT.equalsIgnoreCase(r19.getPrimaryType()) == false) goto L19;
    L23:
        String r20 = r19.getParameter("charset");     // Catch: Throwable -> L21
        if (com.bytedance.common.utility.b.b(r20) == false) goto L26;
        r20 = "utf-8";
    L26:
        StringBuilder r21 = new StringBuilder(" response body = ");     // Catch: Throwable -> L21
        r21.append(new String(r18, r20));     // Catch: Throwable -> L21
        r21.append(" for url = ");     // Catch: Throwable -> L21
        if (r13 != null) goto L29;
        r13 = "";
    L29:
        r21.append(r13);     // Catch: Throwable -> L21
        Logger.d("l", r21.toString());     // Catch: Throwable -> L21
        return;
    L19:
        if ("application/json".equalsIgnoreCase(r19.getBaseType()) == true) goto L23;
        return;
    L21:
        th = move-exception;
        th.printStackTrace();
        return;
    L42:
        return;
    L33:
        th = move-exception;
        com.lynx.tasm.utils.g.n(r11);
        throw th;
    }

    public static byte[] q(String r11, int r12, HttpURLConnection r13, s9.b r14, int r15, i0 r16) {
        int r5 = 0;
        if (r13 == null) goto L5;
        boolean r10 = "gzip".equals(i(r13, "Content-Encoding"));
        ICronetClient r17 = f22316b;
        if (r17 != null) goto L9;
    L11:
        String r18 = i(r13, "Content-Type");
        if (r15 != 200) goto L14;
        System.currentTimeMillis();
        r14.getClass();
        InputStream r19 = r13.getInputStream();
        int[] r20 = new int[1];
        r20[0] = 0;     // Catch: Throwable -> L52
        r13.getHeaderFields();     // Catch: Throwable -> L52
        byte[] r21 = com.lynx.tasm.utils.g.m(r10, r12, r19, r20, r16);     // Catch: Throwable -> L52
        com.lynx.tasm.utils.g.n(r19);
        int r22 = r20[0];
        byte[] r23 = new byte[r22];
        if (r21 == null) goto L36;
        if (r22 <= 0) goto L36;
        System.arraycopy(r21, 0, r23, 0, r22);
    L36:
        if (r18 != null) goto L38;
    L37:
        boolean r24 = false;
    L43:
        if (r24 == false) goto L49;
        if (r22 <= 0) goto L49;
        byte[] r25 = {-99, -114, ByteCompanionObject.MAX_VALUE, 90};
    L47:
        if (r5 >= r22) goto L49;
        r23[r5] = (byte) (r23[r5] ^ r25[r5 % 4]);
        r5 = r5 + 1;
    L49:
        System.currentTimeMillis();
        System.currentTimeMillis();
        k(r13, r14, r16);
        sj.d r26 = s9.h.f21879a;
        ba.a.f().h(r13, r23, new com.bytedance.ai.resource.core.net.a(19));     // Catch: Throwable -> L55
    L51:
        return r23;
    L38:
        int r27 = r18.indexOf("application/octet-stream");
        if (r27 < 0) goto L41;
        r27 = r18.indexOf("ssmix=", r27 + 24);
    L41:
        if (r27 <= 0) goto L37;
        r24 = true;
    L52:
        th = move-exception;
        com.lynx.tasm.utils.g.n(r19);
        throw th;
    L14:
        if (r15 != 304) goto L16;
        System.currentTimeMillis();
        r14.getClass();
        System.currentTimeMillis();
        System.currentTimeMillis();
        k(r13, r14, r16);
        sj.d r28 = s9.h.f21879a;
    L16:
        String r29 = r13.getResponseMessage();
        InputStream r30 = r13.getInputStream();     // Catch: Throwable -> L19 Exception -> L21
    L18:
        InputStream r31 = r30;
        r13.getHeaderFields();     // Catch: Throwable -> L19
        p(r10, r12, r31, r18, r11, r16);     // Catch: Throwable -> L19
    L28:
        r13.disconnect();
        throw new HttpResponseException(r15, r29);
    L21:
        r30 = r13.getErrorStream();     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        th.printStackTrace();
        StringBuilder r32 = new StringBuilder("reason = ");
        if (r29 != null) goto L27;
        r29 = "";
    L27:
        r32.append(r29);
        r32.append("  exception = ");
        r32.append(th.getMessage());
        r29 = r32.toString();
        goto L28
    L9:
        if (r17.isCronetHttpURLConnection(r13) == false) goto L11;
        r10 = false;
        goto L11
    L5:
        return new byte[0];
    }

    public static void r(HttpURLConnection r10, s9.b r11, int r12) {
        Map<String, List<String>> r5 = r10.getHeaderFields();
        if (r5 != null) goto L5;
        return;
    L5:
        if (r5.containsKey("bdturing-verify") == false) goto L21;
        String r13 = r10.getRequestProperty("x-tt-bypass-bdturing");
        if (TextUtils.isEmpty(r13) == false) goto L10;
    L12:
        TreeMap r14 = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        r14.putAll(r5);
        long r15 = SystemClock.uptimeMillis();
        sj.d r16 = s9.h.f21879a;
        if (r12 != 200) goto L15;
        Looper.getMainLooper();
        Looper.myLooper();
    L15:
        r11.f21873u = SystemClock.uptimeMillis() - r15;
        if (r14.containsKey("bdturing-verify") == true) goto L20;
        r11.f21872t = true;
        return;
    L20:
        return;
    L10:
        if (r13.equalsIgnoreCase(IIvyAIPackageResourceService.SHOULD_INTERCEPT_REQUEST) == false) goto L12;
        return;
    }

    public static void s() {
        if (f22316b != null) goto L18;
        String r5 = "";
        if (com.bytedance.common.utility.b.b("") == false) goto L8;
        r5 = "org.chromium.CronetClient";
    L8:
        Logger.w("l", "tryResolveImpl:".concat(r5));
        Object r10 = Class.forName(r5).newInstance();     // Catch: Throwable -> L13
        if ((r10 instanceof ICronetClient) == false) goto L19;
        f22316b = (ICronetClient) r10;     // Catch: Throwable -> L13
        return;
    L19:
        return;
    L13:
        th = move-exception;
        Logger.w("l", "load CronetClient exception: " + th);
        return;
    }

    @Override // bi.b
    public final bi.f b(Request r11) {
        long r5 = SystemClock.uptimeMillis();
        ca.e r10 = ca.e.b();
        if (r10.f1157b == true) goto L6;
        Logger.d("e", "Query filter engine is not enabled");
    L5:
        Request r12 = null;
    L50:
        if (r11.getMetrics() == null) goto L52;
        r11.getMetrics().K = SystemClock.uptimeMillis() - r5;
    L52:
        if (r12 == null) goto L55;
        r11 = r12;
    L55:
        if (g.a().f22313a > 0) goto L57;
    L130:
        ICronetClient r13 = f22316b;
        e r14 = new e();
        s9.b r15 = s9.b.f21857y.mo98create();
        r14.f22298b = r15;
        r14.f22299c = null;
        r14.e = false;
        r14.g = 0;
        r14.d = r11;
        e.f22296j = r13;
        String r16 = r11.getUrl();
        r14.f22297a = null;
        r14.f = r11.getMetrics();
        System.currentTimeMillis();
        r15.f21866m = 0;
        if (r11.isResponseStreaming() == false) goto L133;
        r15.f21870q = true;
    L135:
        if ((r11.getExtraInfo() instanceof vj.b) == false) goto L148;
        vj.b r17 = (vj.b) r11.getExtraInfo();
        r15.f21859b = r17;
        r17.getClass();
    L148:
        r14.f22297a = c(r16, r11, r15, r14.g);     // Catch: Exception -> L139
        return r14;
    L139:
        e = move-exception;
        o(r16, r14.f22298b, e, r14.f22297a, r14.f);
        r14.e = true;
        if ((e instanceof IOException) == false) goto L145;
        throw ((IOException) e);
    L145:
        throw new IOException(e.getMessage(), e.getCause());
    L133:
        r15.f21870q = false;
        goto L135
    L57:
        if (r11.getUrl().contains("no_retry=1") == true) goto L130;
        g r18 = g.a();
        Iterator r19 = r18.f22314b.iterator();
    L60:
        if (r19.hasNext() == false) goto L69;
        f r20 = (f) r19.next();
        if (r20.f22308l == false) goto L60;
        long r21 = SystemClock.uptimeMillis() - r20.f22307k;
        if (r21 <= (r20.g * 1000)) goto L67;
        r20.f22308l = false;
    L67:
        if (Logger.debug() == false) goto L60;
        Logger.d("g", "Rule id: " + r20.f22305i + " has forbidden duration: " + r21 + " fail count: " + r20.f22306j + " forbidden duration: " + (r20.g * 1000));
        goto L60
    L69:
        Iterator r22 = r18.f22314b.iterator();
    L71:
        if (r22.hasNext() == false) goto L124;
        f r23 = (f) r22.next();
        if (r23.g <= 0) goto L77;
        if (r23.f22308l == true) goto L71;
    L77:
        String r24 = r11.getUrl();
        if (TextUtils.isEmpty(r24) == true) goto L71;
        Iterator r25 = r23.f22301a.iterator();
    L82:
        if (r25.hasNext() == false) goto L123;
        if (com.bytedance.frameworks.baselib.network.http.util.c.b(r11.getHost(), (String) r25.next()) == false) goto L82;
        String r26 = r11.getPath();
        if (TextUtils.isEmpty(r26) == true) goto L71;
        ArrayList r27 = r23.f22303c;
        if (r27 != null) goto L91;
    L99:
        ArrayList r28 = r23.d;
        if (r28 != null) goto L102;
    L110:
        ArrayList r29 = r23.e;
        if (r29 == null) goto L71;
        if (r29.isEmpty() == true) goto L71;
        Iterator r30 = r23.e.iterator();
    L117:
        if (r30.hasNext() == false) goto L71;
        Pattern r31 = (Pattern) r30.next();
        if (r31 == null) goto L117;
        if (r31.matcher(r26).matches() == false) goto L117;
    L125:
        if (r23 == null) goto L130;
        if (r23.f22302b.size() < 2) goto L130;
        return new c(r11, r23);
    L102:
        if (r28.isEmpty() == true) goto L110;
        Iterator r32 = r23.d.iterator();
    L106:
        if (r32.hasNext() == false) goto L110;
        if (r26.startsWith((String) r32.next()) == false) goto L106;
    L91:
        if (r27.isEmpty() == true) goto L99;
        Iterator r33 = r23.f22303c.iterator();
    L95:
        if (r33.hasNext() == false) goto L99;
        if (r26.equals((String) r33.next()) == false) goto L95;
    L123:
        kotlin.collections.a.n("host not match: ", r24, "g");
        goto L71
    L124:
        r23 = null;
        goto L125
    L6:
        String r34 = r11.getUrl();
        if (TextUtils.isEmpty(r34) == true) goto L5;
        LinkedHashMap r35 = new LinkedHashMap();     // Catch: Throwable -> L24
        Pair r36 = com.bytedance.frameworks.baselib.network.http.util.c.d(r34, r35);     // Catch: Throwable -> L24
        if (r35.isEmpty() == true) goto L5;
        if (r10.a(r11, r35) == false) goto L5;
        if (r11.isQueryEncryptEnabled() == true) goto L18;
    L26:
        String r37 = null;
    L27:
        p r38 = new p(((String) r36.first) + ((String) r36.second), 3);     // Catch: Throwable -> L24
        if (r35.isEmpty() == true) goto L46;
        Iterator r39 = r35.entrySet().iterator();     // Catch: Throwable -> L24
    L31:
        if (r39.hasNext() == false) goto L46;
        Map.Entry r40 = (Map.Entry) r39.next();     // Catch: Throwable -> L24
        if (r40 == null) goto L31;
        if (r40.getKey() == null) goto L31;
        List r41 = (List) r40.getValue();     // Catch: Throwable -> L24
        if (r41 == null) goto L31;
        if (r41.isEmpty() == true) goto L31;
        Iterator r42 = r41.iterator();     // Catch: Throwable -> L24
    L44:
        if (r42.hasNext() == false) goto L31;
        r38.l((String) r40.getKey(), (String) r42.next());     // Catch: Throwable -> L24
    L46:
        bi.d r43 = r11.newBuilder();     // Catch: Throwable -> L24
        ca.e.f(r43, r11, r37);     // Catch: Throwable -> L24
        r43.b(r38.m());     // Catch: Throwable -> L24
        r12 = r43.a();     // Catch: Throwable -> L24
        goto L50
    L18:
        if (r35.containsKey("x-tt-encrypt-queries") == false) goto L26;
        List r44 = (List) r35.get("x-tt-encrypt-queries");     // Catch: Throwable -> L24
        if (r44 == null) goto L26;
        if (r44.size() <= 0) goto L26;
        r37 = (String) r44.get(0);     // Catch: Throwable -> L24
        r35.remove("x-tt-encrypt-queries");     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        th.printStackTrace();
        goto L5
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, u9.j] */
    @Override // com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient.ICronetBootFailureChecker
    public final boolean isCronetBootFailureExpected() {
        ?? r5 = f;
        if (r5 != 0) goto L6;
        return false;
    L6:
        return r5.isCronetBootFailureExpected();
    }
}

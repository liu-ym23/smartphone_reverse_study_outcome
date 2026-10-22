package wa;

import ai.i0;
import ai.j0;
import ai.q0;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import bi.c;
import com.bumptech.glide.load.engine.bitmap_recycle.f;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.exception.CdnCacheVerifyException;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.clientkey.ClientKeyManager;
import com.ivy.ivykit.api.plugin.IIvyAIPackageResourceService;
import com.lynx.tasm.behavior.ui.utils.e;
import ei.b;
import fi.i;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONObject;
import s9.h;
import sj.d;
import ym.p;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f22819b = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f22820a;

    public /* synthetic */ a(int r5) {
        this.f22820a = r5;
    }

    @Override // ei.b
    public q0 intercept(ei.a r18) {
        int r5 = 0;
        switch(this.f22820a) {
            case 1: goto L21;
            default: goto L4;
        };
    L4:
        f r10 = (f) r18;
        i0 r11 = (i0) r10.f;
        long r12 = SystemClock.uptimeMillis();
        Request r13 = (Request) r10.d;
        if (r13 != null) goto L8;
    L17:
        if (r11 == null) goto L20;
        r11.f234w.put("RequestVerifyInterceptor", Long.valueOf(SystemClock.uptimeMillis() - r12));
    L20:
        return r10.g(r13);
    L8:
        if (r13.isResponseStreaming() == true) goto L17;
        String r14 = r13.getUrl();     // Catch: Throwable -> L12
        long r15 = SystemClock.uptimeMillis();     // Catch: Throwable -> L12
        r13.isAddCommonParam();     // Catch: Throwable -> L12
        r13.getBody();     // Catch: Throwable -> L12
        d r16 = h.f21879a;     // Catch: Throwable -> L12
        if (r13.getMetrics() == null) goto L14;
        r13.getMetrics().A = SystemClock.uptimeMillis() - r15;     // Catch: Throwable -> L12
    L14:
        bi.d r17 = r13.newBuilder();     // Catch: Throwable -> L12
        r17.b(r14);     // Catch: Throwable -> L12
        r13 = r17.a();     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        th.printStackTrace();
        goto L17
    L21:
        long r19 = SystemClock.uptimeMillis();
        f r20 = (f) r18;
        Request r21 = (Request) r20.d;
        URL r22 = new URL(r21.getUrl());     // Catch: MalformedURLException -> L346
        if (r22.getProtocol().equals("http") == false) goto L25;
        h.b(r22.getHost(), r22.getPath(), false);     // Catch: MalformedURLException -> L346
    L25:
        d r23 = h.f21879a;
        long r24 = SystemClock.uptimeMillis();
        String r110 = r21.getUrl();
        if ((r21.getExtraInfo() instanceof vj.b) == false) goto L28;
        vj.b r25 = (vj.b) r21.getExtraInfo();
        h.a(r110);
    L30:
        if (r21.getMetrics() == null) goto L33;
        r21.getMetrics().f236y = SystemClock.uptimeMillis() - r24;
    L33:
        if (r21.getUrl().startsWith("https:") == true) goto L35;
    L37:
        long r26 = SystemClock.uptimeMillis();
        if (r21.isAddCommonParam() == false) goto L45;
        t9.a.i().getClass();
        d r27 = h.f21879a;     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        th.printStackTrace();
    L45:
        if (r21.getMetrics() == null) goto L47;
        r21.getMetrics().f237z = SystemClock.uptimeMillis() - r26;
    L47:
        bi.d r28 = r21.newBuilder();
        r28.b(r110);
        Request r29 = r28.a();
        long r30 = SystemClock.uptimeMillis();
        bi.d r111 = r29.newBuilder();
        String r112 = r29.getUrl();
        if (com.bytedance.common.utility.b.b(r112) == false) goto L369;
    L96:
        r111.b(r112);
        if (r29.getMetrics() == null) goto L99;
        r29.getMetrics().B = SystemClock.uptimeMillis() - r30;
    L99:
        long r31 = SystemClock.uptimeMillis();
        ArrayList r32 = new ArrayList();
        if (r29.getHeaders() == null) goto L103;
        r32.addAll(r29.getHeaders());
    L103:
        if (f22819b == false) goto L120;
        LinkedList r33 = new LinkedList();     // Catch: Throwable -> L117
        String r113 = e.r(r112, r33);     // Catch: Throwable -> L117
        if (r113 == null) goto L108;
        r111.f918b = r113;     // Catch: Throwable -> L117
    L108:
        if (r33.isEmpty() == true) goto L120;
        Iterator r34 = r33.iterator();     // Catch: Throwable -> L117
    L110:
        if (r34.hasNext() == false) goto L120;
        Pair r114 = (Pair) r34.next();     // Catch: Throwable -> L117
        if (r114 == null) goto L110;
        r32.add(new c((String) r114.first, (String) r114.second));     // Catch: Throwable -> L117
    L117:
        th = move-exception;
        th.printStackTrace();
    L120:
        if (r29.getMetrics() == null) goto L122;
        r29.getMetrics().C = SystemClock.uptimeMillis() - r31;
    L122:
        long r35 = SystemClock.uptimeMillis();
        com.lynx.tasm.utils.e.j(r112).getHost();     // Catch: Throwable -> L125
        TTNetInit.getTTNetDepend();     // Catch: Throwable -> L125
        throw null;     // Catch: Throwable -> L125
    L126:
        if (r29.getMetrics() == null) goto L128;
        r29.getMetrics().D = SystemClock.uptimeMillis() - r35;
    L128:
        long r36 = SystemClock.uptimeMillis();
        if (com.bytedance.ttnet.utils.b.f7537a == false) goto L163;
        URI r37 = com.lynx.tasm.utils.e.j(r112);     // Catch: Throwable -> L157
        ReentrantReadWriteLock.ReadLock r115 = com.bytedance.ttnet.utils.b.f7539c;     // Catch: Throwable -> L157
        r115.lock();     // Catch: Throwable -> L151
        Iterator r116 = com.bytedance.ttnet.utils.b.f7538b.iterator();     // Catch: Throwable -> L151
    L133:
        if (r116.hasNext() == false) goto L153;
        com.bytedance.ttnet.utils.a r117 = (com.bytedance.ttnet.utils.a) r116.next();     // Catch: Throwable -> L151
        r117.getClass();     // Catch: Throwable -> L151
        if (r37 != null) goto L138;
    L147:
        boolean r38 = false;
    L148:
        if (r38 == false) goto L133;
        r115.unlock();     // Catch: Throwable -> L157
        String r39 = UUID.randomUUID().toString();     // Catch: Throwable -> L157
    L155:
        if (TextUtils.isEmpty(r39) == true) goto L163;
        r32.add(new c("X-TT-VERIFY-ID", r39));     // Catch: Throwable -> L157
        goto L163
    L138:
        if (TextUtils.isEmpty(r37.getHost()) == true) goto L147;
        if (r117.f7536a == null) goto L147;
        String r118 = r37.getHost();     // Catch: Throwable -> L151
        if (TextUtils.isEmpty(r37.getPath()) == true) goto L145;
        StringBuilder r119 = j0.u(r118);     // Catch: Throwable -> L151
        r119.append(r37.getPath());     // Catch: Throwable -> L151
        r118 = r119.toString();     // Catch: Throwable -> L151
    L145:
        r38 = r117.f7536a.matcher(r118).matches();     // Catch: Throwable -> L151
        goto L148
    L153:
        r115.unlock();     // Catch: Throwable -> L157
        r39 = null;
        goto L155
    L151:
        th = move-exception;
        r115.unlock();     // Catch: Throwable -> L157
        throw th;     // Catch: Throwable -> L157
    L157:
        th = move-exception;
        th.printStackTrace();
    L163:
        if (r29.getMetrics() == null) goto L165;
        r29.getMetrics().F = SystemClock.uptimeMillis() - r36;
    L165:
        ClientKeyManager r40 = ClientKeyManager.d();
        i0 r41 = r29.getMetrics();
        r40.getClass();
        if (ClientKeyManager.f7527h != null) goto L168;
    L177:
        r111.f919c = r32;
        Request r42 = r111.a();
        if (r42.getMetrics() == null) goto L180;
        r42.getMetrics().f234w.put("BaseSsInterceptor", Long.valueOf(SystemClock.uptimeMillis() - r19));
    L180:
        q0 r43 = r20.g(r42);
        long r44 = SystemClock.uptimeMillis();
        bi.e r45 = r43.f290a;
        long r46 = SystemClock.uptimeMillis();
        d r47 = h.f21879a;     // Catch: Throwable -> L183
    L186:
        if (r42.getMetrics() == null) goto L188;
        r42.getMetrics().J = SystemClock.uptimeMillis() - r46;
    L188:
        ClientKeyManager r48 = ClientKeyManager.d();
        monitor-enter(r48);
    L211:
        th = move-exception;
        throw th;
    L191:
        if (ClientKeyManager.f7527h != null) goto L193;
    L274:
        long r49 = SystemClock.uptimeMillis();
        Object r50 = r45.f;
        if ((r50 instanceof vj.a) == false) goto L292;
        vj.a r51 = (vj.a) r50;
        if (r51.f21859b == null) goto L379;
        JSONObject r120 = new JSONObject();
        List r121 = (List) r45.d;
    L280:
        if (r5 >= r121.size()) goto L291;
        c r52 = (c) r121.get(r5);     // Catch: Exception -> L288
        if (r52 == null) goto L290;
        if (TextUtils.isEmpty(r52.f915a) == true) goto L290;
        r120.put(r52.f915a.toUpperCase(), r52.f916b);     // Catch: Exception -> L288
    L290:
        r5 = r5 + 1;
    L288:
        e = move-exception;
        e.printStackTrace();
        goto L290
    L291:
        r51.f21859b.getClass();
        r51.f21859b.getClass();
    L379:
        r42.getUrl();     // Catch: Throwable -> L295
        r42.getFirstHeader("X-SS-REQ-TICKET");     // Catch: Throwable -> L295
        r45.t("X-SS-REQ-TICKET");     // Catch: Throwable -> L295
    L367:
        Uri.parse(r42.getUrl()).getHost();     // Catch: Throwable -> L302
        TTNetInit.getTTNetDepend();     // Catch: Throwable -> L302
        String r53 = null;
        throw null;     // Catch: Throwable -> L300
    L300:
        th = th;
    L304:
        th.printStackTrace();
        if (r42.getMetrics() == null) goto L307;
        r42.getMetrics().E = SystemClock.uptimeMillis() - r49;
    L307:
        long r54 = SystemClock.uptimeMillis();
        if (com.bytedance.ttnet.utils.b.f7537a == false) goto L338;
        if (r51 != null) goto L313;
        Logger.w("CDN_CACHE_VERIFY", "Req info is null");
        goto L338
    L313:
        c r122 = r42.getFirstHeader("X-TT-VERIFY-ID");
        if (r122 == null) goto L316;
        String r123 = r122.f916b;
    L317:
        c r55 = r45.t("X-TT-VERIFY-ID");
        if (r55 == null) goto L320;
        String r124 = r55.f916b;
    L321:
        if (r123 == null) goto L338;
        if (r124 != null) goto L325;
        r51.f22584z = 1;
        Logger.w("CDN_CACHE_VERIFY", "Cdn cache verify accessible");
    L333:
        if (r51.f22584z != 3) goto L338;
        throw new CdnCacheVerifyException("Fail to verify cdn cache");
    L325:
        if (r123.equals(r124) == false) goto L327;
        r51.f22584z = 2;
        Logger.w("CDN_CACHE_VERIFY", "Cdn cache verify success");
        goto L333
    L327:
        r51.f22584z = 3;
        Logger.w("CDN_CACHE_VERIFY", "Cdn cache verify fail");
        ((i) r45.e).c().close();     // Catch: Throwable -> L330
    L330:
        th = move-exception;
        th.printStackTrace();
        Logger.w("CDN_CACHE_VERIFY", "Cdn cache verify stream close fail:" + th.toString());
        goto L333
    L320:
        r124 = r53;
        goto L321
    L316:
        r123 = r53;
    L338:
        if (r42.getMetrics() == null) goto L341;
        r42.getMetrics().I = SystemClock.uptimeMillis() - r54;
    L341:
        if (r42.getMetrics() == null) goto L343;
        r42.getMetrics().f235x.put("BaseSsInterceptor", Long.valueOf(SystemClock.uptimeMillis() - r44));
    L343:
        return r43;
    L302:
        th = th;
        r53 = null;
    L295:
        th = move-exception;
        th.printStackTrace();
        goto L367
    L292:
        r51 = null;
        goto L379
    L193:
        if (ClientKeyManager.f7528i == false) goto L274;
        long r56 = SystemClock.uptimeMillis();     // Catch: Throwable -> L211
        URI r57 = com.lynx.tasm.utils.e.j(r42.getUrl());     // Catch: Throwable -> L198
    L199:
        if (r57 == null) goto L274;
        if (r57.getScheme().equals(IIvyAIPackageResourceService.SCHEMA) == false) goto L274;
        if (r48.f7531a.isEmpty() == true) goto L216;
        Iterator r125 = r48.f7531a.iterator();     // Catch: Throwable -> L211
    L207:
        if (r125.hasNext() == false) goto L274;
        if (com.bytedance.frameworks.baselib.network.http.util.c.b(r57.getHost(), (String) r125.next()) == false) goto L207;
    L216:
        if (r48.f7532b.isEmpty() == true) goto L274;
        Iterator r126 = r48.f7532b.iterator();     // Catch: Throwable -> L211
    L219:
        if (r126.hasNext() == false) goto L274;
        if (com.bytedance.frameworks.baselib.network.http.util.c.b(r57.getPath(), (String) r126.next()) == false) goto L219;
        String r58 = "";
        String r127 = "";
        List r128 = (List) r45.d;     // Catch: Throwable -> L211
        if (r128 != null) goto L225;
        ArrayList r129 = null;
    L234:
        if (r129 != null) goto L236;
    L243:
        String[] r130 = r58.split(";");     // Catch: Throwable -> L211
        if (r130 == null) goto L249;
        if (r130.length <= 0) goto L249;
        r127 = r130[0].trim();     // Catch: Throwable -> L211
    L249:
        if (TextUtils.isEmpty(r127) == true) goto L274;
        Logger.d("ClientKeyManager", "original sessionid: " + r48.d + " new sessionid: " + r127);     // Catch: Throwable -> L211
        String r131 = "";
        String r132 = "";
        c r133 = r45.t("x-bd-lanusk");     // Catch: Throwable -> L211
        c r134 = r45.t("x-bd-lanusv");     // Catch: Throwable -> L211
        if (r133 == null) goto L261;
        if (r134 == null) goto L261;
        r131 = r133.f916b;     // Catch: Throwable -> L211
        r132 = r134.f916b;     // Catch: Throwable -> L211
        if (TextUtils.isEmpty(r131) == false) goto L258;
    L259:
        r48.f7533c = "";     // Catch: Throwable -> L211
        r48.f = "";     // Catch: Throwable -> L211
    L263:
        r48.f7533c = r131;     // Catch: Throwable -> L211
        r48.f = r132;     // Catch: Throwable -> L211
        String r135 = r42.getUrl();     // Catch: Throwable -> L211
        r48.e = r135;     // Catch: Throwable -> L211
        r48.d = r127;     // Catch: Throwable -> L211
        ClientKeyManager.f7527h.storeString("session_url", r135);     // Catch: Throwable -> L211
        ClientKeyManager.f7527h.storeString("session_id", r58);     // Catch: Throwable -> L211
        ClientKeyManager.f7527h.storeString("client_key", r48.f7533c);     // Catch: Throwable -> L211
        ClientKeyManager.f7527h.storeString("kms_version", r48.f);     // Catch: Throwable -> L211
        ClientKeyManager.f7527h.storeLong("session_time", System.currentTimeMillis());     // Catch: Throwable -> L211
        ClientKeyManager.f7530k = ClientKeyManager.c(r48.f7533c, r48.f);     // Catch: Throwable -> L211
        if (r42.getMetrics() == null) goto L266;
        r42.getMetrics().H = SystemClock.uptimeMillis() - r56;     // Catch: Throwable -> L211
    L266:
        Logger.d("ClientKeyManager", "save session url: " + r48.e + " session cookie: " + r58 + " client key: " + r48.f7533c + " kms version: " + r48.f);     // Catch: Throwable -> L211
        goto L274
    L258:
        if (TextUtils.isEmpty(r132) == false) goto L263;
    L261:
        if (r127.equals(r48.d) == false) goto L263;
        r131 = r48.f7533c;     // Catch: Throwable -> L211
        r132 = r48.f;     // Catch: Throwable -> L211
        goto L263
    L236:
        if (r129.isEmpty() == true) goto L243;
        Iterator r136 = r129.iterator();     // Catch: Throwable -> L211
    L239:
        if (r136.hasNext() == false) goto L243;
        String r137 = ((c) r136.next()).f916b.trim();     // Catch: Throwable -> L211
        if (r137.toLowerCase().startsWith("sessionid=") == false) goto L239;
        r58 = r137;
        goto L243
    L225:
        Iterator r138 = r128.iterator();     // Catch: Throwable -> L211
        r129 = null;
    L227:
        if (r138.hasNext() == false) goto L234;
        c r139 = (c) r138.next();     // Catch: Throwable -> L211
        if ("Set-Cookie".equalsIgnoreCase(r139.f915a) == false) goto L227;
        if (r129 != null) goto L232;
        r129 = new ArrayList();     // Catch: Throwable -> L211
    L232:
        r129.add(r139);     // Catch: Throwable -> L211
    L198:
        r57 = null;
    L183:
        th = move-exception;
        th.printStackTrace();
        goto L186
    L168:
        if (ClientKeyManager.f7528i == false) goto L177;
        if (TextUtils.isEmpty(r40.f7533c) == true) goto L177;
        if (TextUtils.isEmpty(r40.f) == true) goto L177;
        long r59 = SystemClock.uptimeMillis();
        r32.add(new c("x-bd-client-key", r40.f7533c));
        r32.add(new c("x-bd-kmsv", r40.f));
        if (r41 == null) goto L177;
        r41.G = SystemClock.uptimeMillis() - r59;
        goto L177
    L369:
        LinkedHashMap r60 = new LinkedHashMap();     // Catch: Throwable -> L70
        Pair r140 = com.bytedance.frameworks.baselib.network.http.util.c.d(r112, r60);     // Catch: Throwable -> L70
        if (r60.isEmpty() == true) goto L73;
        Iterator r141 = r60.entrySet().iterator();     // Catch: Throwable -> L70
    L54:
        if (r141.hasNext() == false) goto L73;
        Map.Entry r142 = (Map.Entry) r141.next();     // Catch: Throwable -> L70
        if (r142 == null) goto L54;
        List r143 = (List) r142.getValue();     // Catch: Throwable -> L70
        if (r143 == null) goto L54;
        if (r143.isEmpty() == true) goto L54;
        LinkedHashSet r144 = new LinkedHashSet();     // Catch: Throwable -> L70
        Iterator r145 = r143.iterator();     // Catch: Throwable -> L70
    L65:
        if (r145.hasNext() == false) goto L54;
        String r61 = (String) r145.next();     // Catch: Throwable -> L70
        if (r144.contains(r61) == false) goto L72;
        r145.remove();     // Catch: Throwable -> L70
        goto L65
    L72:
        r144.add(r61);     // Catch: Throwable -> L70
    L73:
        p r62 = new p(((String) r140.first) + ((String) r140.second), 3);     // Catch: Throwable -> L70
        if (r60.isEmpty() == true) goto L93;
        Iterator r63 = r60.entrySet().iterator();     // Catch: Throwable -> L70
    L77:
        if (r63.hasNext() == false) goto L93;
        Map.Entry r146 = (Map.Entry) r63.next();     // Catch: Throwable -> L70
        if (r146 == null) goto L77;
        if (r146.getKey() == null) goto L77;
        List r147 = (List) r146.getValue();     // Catch: Throwable -> L70
        if (r147 == null) goto L77;
        if (r147.isEmpty() == true) goto L77;
        Iterator r148 = r147.iterator();     // Catch: Throwable -> L70
    L91:
        if (r148.hasNext() == false) goto L77;
        r62.l((String) r146.getKey(), (String) r148.next());     // Catch: Throwable -> L70
    L93:
        r112 = r62.m();     // Catch: Throwable -> L70
    L70:
        th = move-exception;
        th.printStackTrace();
        goto L96
    L35:
        if (r110.startsWith("http:") == false) goto L37;
        URL r64 = new URL(r110);     // Catch: Throwable -> L347
        h.b(r64.getHost(), r64.getPath(), true);     // Catch: Throwable -> L347
        goto L37
    L28:
        h.a(r110);
        goto L30
    }
}

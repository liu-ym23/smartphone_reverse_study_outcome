package com.bytedance.ttnet.m;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.i;
import com.bytedance.common.utility.k;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.ttnet.TTNetInit;
import com.obric.matrix.common_api.INetworkApi;
import d.b.h.a.a.h.g;
import d.b.h.a.a.h.h;
import d.b.h.a.a.h.p.f;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class c {

    class a implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ HttpURLConnection f6484a;

        a(String r1, HttpURLConnection r2) {
            this.f6484a = r2;
        }

        @Override // d.b.h.a.a.h.h
        public void a() {
            HttpURLConnection r0 = this.f6484a;     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.disconnect();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        }
    }

    public static String a(String r10, Map<String, String> r11, Map<String, List<String>> r12, com.bytedance.ttnet.m.a r13) {
        HttpURLConnection r2 = null;
        if (k.c(r10) == true) goto L91;
        if (r13 == null) goto L91;
        if (i.o(TTNetInit.getTTNetDepend().getContext()) == true) goto L95;
        return null;
    L95:
    L85:
        th = th;
    L99:
        throw th;     // Catch: Throwable -> L87
    L87:
        th = move-exception;
        if (r2 != null) goto L101;
    L90:
        throw th;
    L101:
        r2.disconnect();     // Catch: Exception -> L94
        goto L90
    L10:
        if (r13.f6476e == false) goto L25;
        String r1 = g.c(r10, true);     // Catch: Throwable -> L85
        if (TextUtils.isEmpty(r1) == true) goto L25;
        if (r1.equals(r10) == false) goto L24;
        StringBuilder r14 = new StringBuilder(r1);     // Catch: Throwable -> L85
        if (r1.indexOf(63) >= 0) goto L19;
        String r3 = "?";
    L18:
        r14.append(r3);     // Catch: Throwable -> L85
        r14.append("aid=");     // Catch: Throwable -> L85
        r14.append(TTNetInit.getTTNetDepend().getAppId());     // Catch: Throwable -> L85
        r14.append("&device_platform=");     // Catch: Throwable -> L85
        r14.append("android");     // Catch: Throwable -> L85
        if (TTNetInit.getCronetProvider() == null) goto L23;
        r14.append("&version_code=");     // Catch: Throwable -> L85
        r14.append(TTNetInit.getCronetProvider().getVersionCode());     // Catch: Throwable -> L85
        r14.append("&channel=");     // Catch: Throwable -> L85
        r14.append(TTNetInit.getCronetProvider().getChannel());     // Catch: Throwable -> L85
        r14.append(WsConstants.KEY_DEVICE_ID);     // Catch: Throwable -> L85
        r14.append(TTNetInit.getCronetProvider().getDeviceId());     // Catch: Throwable -> L85
    L23:
        r10 = r14.toString();     // Catch: Throwable -> L85
        goto L25
    L19:
        r3 = "&";
        goto L18
    L24:
        r10 = r1;
    L25:
        HttpURLConnection r4 = (HttpURLConnection) new URL(r10).openConnection();     // Catch: Throwable -> L85
        r4.setRequestMethod("GET");     // Catch: Throwable -> L83
        r4.setConnectTimeout(g.i());     // Catch: Throwable -> L83
        r4.setReadTimeout(g.o());     // Catch: Throwable -> L83
        r4.setInstanceFollowRedirects(true);     // Catch: Throwable -> L83
        r4.setRequestProperty("Accept-Encoding", "gzip");     // Catch: Throwable -> L83
        if (r13.f6475d == false) goto L29;
        String r5 = " HttpsURLConnection";
    L30:
        r4.setRequestProperty("User-Agent", "ttnet" + r5);     // Catch: Throwable -> L83
        if (r11 != null) goto L33;
    L38:
        int r15 = r4.getResponseCode();     // Catch: Throwable -> L83
        r13.f6472a = r15;     // Catch: Throwable -> L83
        if (r12 == null) goto L51;
        if (r4.getHeaderFields() == null) goto L51;
        Map<String, List<String>> r6 = r4.getHeaderFields();     // Catch: Throwable -> L83
        if (r6 == null) goto L51;
        Iterator<Map.Entry<String, List<String>>> r7 = r6.entrySet().iterator();     // Catch: Throwable -> L83
    L46:
        if (r7.hasNext() == false) goto L51;
        Map.Entry<String, List<String>> r8 = r7.next();     // Catch: Throwable -> L83
        String r9 = r8.getKey();     // Catch: Throwable -> L83
        if (TextUtils.isEmpty(r9) == true) goto L46;
        r12.put(r9.toLowerCase(), r8.getValue());     // Catch: Throwable -> L83
    L51:
        if (r13.f6475d == true) goto L53;
        r13.f6474c = r4.getHeaderField("X-SS-SIGN");     // Catch: Throwable -> L83
    L53:
        r13.f6477f = r4.getHeaderField("x-ss-etag");     // Catch: Throwable -> L83
        r13.f6478g = r4.getHeaderField("x-tt-tnc-abtest");     // Catch: Throwable -> L83
        r13.f6481j = r4.getHeaderField("x-tt-tnc-control");     // Catch: Throwable -> L83
        r13.f6482k = r4.getHeaderField("x-tt-tnc-config");     // Catch: Throwable -> L83
        r13.f6483l = r4.getHeaderField("x-ss-canary");     // Catch: Throwable -> L83
        r13.f6479h = r4.getHeaderField("x-tt-tnc-query-region");     // Catch: Throwable -> L83
        r13.f6480i = r4.getHeaderField("x-tt-logid");     // Catch: Throwable -> L83
        if (r15 != 200) goto L82;
        InputStream r16 = r4.getInputStream();     // Catch: Throwable -> L83
        boolean r17 = "gzip".equals(r4.getHeaderField("Content-Encoding"));     // Catch: Throwable -> L83
        String r18 = r4.getHeaderField(INetworkApi.CONTENT_TYPE);     // Catch: Throwable -> L83
        boolean r19 = f.n(r18);     // Catch: Throwable -> L83
        Pair<String, String> r110 = com.bytedance.ttnet.s.d.i(r18);     // Catch: Throwable -> L83
        if (r110 == null) goto L62;
        Object r111 = r110.second;     // Catch: Throwable -> L83
        if (r111 == null) goto L62;
        if (Charset.isSupported((String) r111) == false) goto L62;
        String r112 = (String) r110.second;     // Catch: Throwable -> L83
    L63:
        if (r112 != null) goto L65;
        r112 = "UTF-8";
    L65:
        int[] r113 = {0};     // Catch: Throwable -> L83
        byte[] r114 = f.k(r17, r4.getHeaderFields(), -1, r16, r113, new a(r10, r4));     // Catch: Throwable -> L83
        if (r114 != null) goto L68;
    L78:
        if (r4 != null) goto L103;
    L80:
        return null;
    L103:
        r4.disconnect();     // Catch: Exception -> L93
        goto L80
    L68:
        if (r113[0] <= 0) goto L78;
        if (r113[0] > r114.length) goto L78;
        if (r19 == false) goto L74;
        f.a(r114, r113[0]);     // Catch: Throwable -> L83
    L74:
        String r115 = new String(r114, 0, r113[0], r112);     // Catch: Throwable -> L83
        if (r4 != null) goto L97;
    L77:
        return r115;
    L97:
        r4.disconnect();     // Catch: Exception -> L92
    L62:
        r112 = null;
        goto L63
    L82:
        throw new IOException("err status = " + r15);     // Catch: Throwable -> L83
    L33:
        if (r11.size() <= 0) goto L38;
        Iterator<Map.Entry<String, String>> r116 = r11.entrySet().iterator();     // Catch: Throwable -> L83
    L36:
        if (r116.hasNext() == false) goto L38;
        Map.Entry<String, String> r20 = r116.next();     // Catch: Throwable -> L83
        r4.setRequestProperty(r20.getKey(), r20.getValue());     // Catch: Throwable -> L83
        goto L36
    L29:
        r5 = " HttpURLConnection";
    L83:
        th = th;
        r2 = r4;
    L91:
        return null;
    }
}

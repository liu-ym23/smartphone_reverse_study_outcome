package com.bytedance.ttnet.config;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient;
import com.bytedance.frameworks.baselib.network.http.util.UrlBuilder;
import com.bytedance.retrofit2.HttpMethodContrants;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.http.GetDomainContext;
import com.bytedance.ttnet.http.HttpURLConnClient;
import com.bytedance.ttnet.tnc.TNCManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class CronetRetryEventHandler {
    private static final String TAG = "CronetRetryEventHandler";
    private static final String TNC_ABTEST = "x-tt-tnc-abtest";
    private static final String TNC_CANARY = "x-ss-canary";
    private static final String TNC_CONFIG = "x-tt-tnc-config";
    private static final String TNC_CONTROL = "x-tt-tnc-control";
    private static final String TNC_ETAG = "x-ss-etag";
    private static final String TNC_SUMMARY = "x-tt-tnc-summary";
    private static volatile CronetRetryEventHandler sInstance;

    private CronetRetryEventHandler() {
    }

    public static CronetRetryEventHandler inst() {
        if (sInstance != null) goto L16;
        monitor-enter(CronetRetryEventHandler.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L11;
        sInstance = new CronetRetryEventHandler();     // Catch: Throwable -> L9
    L11:
        monitor-exit(CronetRetryEventHandler.class);     // Catch: Throwable -> L9
    L16:
        return sInstance;
    }

    public void updateConfigOnCronetFailed(ArrayList<String> r27, String r28) {
        String r1 = HttpMethodContrants.GET;
        String r3 = TNC_ABTEST;
        String r4 = "x-tt-tnc-config";
        if (r27 != null) goto L5;
        return;
    L5:
        if (r27.isEmpty() == true) goto L129;
        Context r8 = TTNetInit.getTTNetDepend().getContext();
        if (r8 != null) goto L11;
        return;
    L11:
        if (Logger.debug() == false) goto L13;
        Logger.d(TAG, "start get-domain request.");
    L13:
        Iterator<String> r10 = r27.iterator();
    L15:
        if (r10.hasNext() == false) goto L130;
        String r0 = r10.next();
        GetDomainContext r11 = new GetDomainContext();     // Catch: Throwable -> L24
        r11.useHttps = true;     // Catch: Throwable -> L24
        r11.addCommonParam = false;     // Catch: Throwable -> L24
        UrlBuilder r2 = new UrlBuilder(r0);     // Catch: Throwable -> L24
        r2.addParam("tnc_src", "7");     // Catch: Throwable -> L24
        String r5 = r2.toString();     // Catch: Throwable -> L24
        HashMap r13 = new HashMap();     // Catch: Throwable -> L24
        HashMap r14 = new HashMap();     // Catch: Throwable -> L24
        if (TextUtils.isEmpty(r28) == true) goto L28;
        r14.put(TNC_SUMMARY, r28);     // Catch: Throwable -> L22
    L22:
        th = th;
    L23:
        String r23 = r1;
        String r25 = r3;
        String r24 = r4;
    L100:
        th.printStackTrace();
        r1 = r23;
        r4 = r24;
        r3 = r25;
    L28:
        if (TNCManager.getInstance().isTncRequestProceed(r1, r5, r14, "") == false) goto L29;
        String r12 = HttpURLConnClient.executeGet(r5, r14, r13, r11);     // Catch: Throwable -> L22
        if (Logger.debug() == false) goto L34;
        Logger.d(TAG, "response: " + r12);     // Catch: Throwable -> L22
    L34:
        if (TNCManager.getInstance().isTncResponseProceed(r1, r5, r13, r12) == false) goto L35;
        if (StringUtils.isEmpty(r12) == true) goto L15;
        if ("success".equals(new JSONObject(r12).getString("message")) == false) goto L15;
    L47:
        th = th;
        r23 = r1;
    L49:
        r25 = r3;
        r24 = r4;
    L114:
        th.printStackTrace();     // Catch: Throwable -> L99
        return;
    L99:
        th = th;
        goto L100
    L43:
        if (r13.get("x-ss-etag") != null) goto L45;
    L50:
        String r6 = "";
    L52:
        if (r13.get(TNC_CANARY) != null) goto L54;
    L56:
        String r15 = "";
    L58:
        if (r13.get(r4) == null) goto L66;
        r23 = r1;
    L64:
        th = th;
        goto L49
    L62:
        if (TextUtils.isEmpty((CharSequence) ((List) r13.get(r4)).get(0)) == true) goto L67;
        String r16 = (String) ((List) r13.get(r4)).get(0);     // Catch: Throwable -> L64
    L68:
        if (r13.get(r3) != null) goto L102;
        r24 = r4;
    L80:
        String r7 = "";
    L82:
        if (r13.get(TNC_CONTROL) == null) goto L90;
        r25 = r3;
    L88:
        th = th;
        goto L114
    L86:
        if (TextUtils.isEmpty((CharSequence) ((List) r13.get(TNC_CONTROL)).get(0)) == true) goto L91;
        String r21 = (String) ((List) r13.get(TNC_CONTROL)).get(0);     // Catch: Throwable -> L88
    L93:
        if (Logger.debug() == false) goto L95;
        Logger.d(TAG, "tnc verion: " + r6 + " canary: " + r15 + " configid: " + r16 + " abtest: " + r7);     // Catch: Throwable -> L88
    L95:
        SsCronetHttpClient.inst(r8).notifyTNCConfigUpdated(r6, r15, r16, r7, r21, r12);     // Catch: Throwable -> L88
        return;
    L91:
        r21 = "";
    L75:
        th = th;
    L76:
        r25 = r3;
        goto L114
    L90:
        r25 = r3;
        goto L91
    L102:
        r24 = r4;
        if (TextUtils.isEmpty((CharSequence) ((List) r13.get(r3)).get(0)) == true) goto L80;
        r7 = (String) ((List) r13.get(r3)).get(0);     // Catch: Throwable -> L75
    L77:
        th = th;
        r24 = r4;
    L67:
        r16 = "";
        goto L68
    L66:
        r23 = r1;
        goto L67
    L54:
        if (TextUtils.isEmpty((CharSequence) ((List) r13.get(TNC_CANARY)).get(0)) == true) goto L56;
        r15 = (String) ((List) r13.get(TNC_CANARY)).get(0);     // Catch: Throwable -> L47
        goto L58
    L45:
        if (TextUtils.isEmpty((CharSequence) ((List) r13.get("x-ss-etag")).get(0)) == true) goto L50;
        r6 = (String) ((List) r13.get("x-ss-etag")).get(0);     // Catch: Throwable -> L47
        goto L52
    L35:
        return;
    L29:
        return;
    L24:
        th = th;
        goto L23
    L130:
        return;
    }
}

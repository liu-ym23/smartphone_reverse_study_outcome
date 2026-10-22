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
import com.bytedanceos.preventdisturb.EventUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class CronetRetryEventHandler {
    private static final String TAG = "CronetRetryEventHandler";
    private static final String TNC_ABTEST = "x-tt-tnc-abtest";
    private static final String TNC_CANARY = "x-ss-canary";
    private static final String TNC_CONFIG = "x-tt-tnc-config";
    private static final String TNC_CONTROL = "x-tt-tnc-control";
    private static final String TNC_ETAG = "x-ss-etag";
    private static final String TNC_SUMMARY = "x-tt-tnc-summary";
    private static volatile CronetRetryEventHandler sInstance;

    public static CronetRetryEventHandler inst() {
        if (sInstance != null) goto L15;
        monitor-enter(CronetRetryEventHandler.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new CronetRetryEventHandler();     // Catch: Throwable -> L11
    L9:
        monitor-exit(CronetRetryEventHandler.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private CronetRetryEventHandler() {
    }

    public void updateConfigOnCronetFailed(ArrayList<String> r27, String r28) {
        String r1 = HttpMethodContrants.GET;
        String r3 = TNC_ABTEST;
        String r4 = "x-tt-tnc-config";
        if (r27 != null) goto L5;
        return;
    L5:
        if (r27.isEmpty() == true) goto L131;
        Context r8 = TTNetInit.getTTNetDepend().getContext();
        if (r8 != null) goto L11;
        return;
    L11:
        if (Logger.debug() == false) goto L13;
        Logger.d(TAG, "start get-domain request.");
    L13:
        Iterator<String> r10 = r27.iterator();
    L15:
        if (r10.hasNext() == false) goto L132;
        String r0 = r10.next();
        GetDomainContext r11 = new GetDomainContext();     // Catch: Throwable -> L99
        r11.useHttps = true;     // Catch: Throwable -> L99
        r11.addCommonParam = false;     // Catch: Throwable -> L99
        UrlBuilder r2 = new UrlBuilder(r0);     // Catch: Throwable -> L99
        r2.addParam("tnc_src", EventUtils.TO_STORAGE);     // Catch: Throwable -> L99
        String r5 = r2.toString();     // Catch: Throwable -> L99
        HashMap r13 = new HashMap();     // Catch: Throwable -> L99
        HashMap r14 = new HashMap();     // Catch: Throwable -> L99
        if (TextUtils.isEmpty(r28) == true) goto L24;
        r14.put(TNC_SUMMARY, r28);     // Catch: Throwable -> L97
    L97:
        th = th;
    L101:
        String r23 = r1;
        String r25 = r3;
        String r24 = r4;
    L102:
        th.printStackTrace();
        r1 = r23;
        r4 = r24;
        r3 = r25;
    L24:
        if (TNCManager.getInstance().isTncRequestProceed(r1, r5, r14, "") == false) goto L25;
        String r12 = HttpURLConnClient.executeGet(r5, r14, r13, r11);     // Catch: Throwable -> L97
        if (Logger.debug() == false) goto L30;
        Logger.d(TAG, "response: " + r12);     // Catch: Throwable -> L97
    L30:
        if (TNCManager.getInstance().isTncResponseProceed(r1, r5, r13, r12) == false) goto L31;
        if (StringUtils.isEmpty(r12) == true) goto L15;
        if ("success".equals(new JSONObject(r12).getString("message")) == false) goto L15;
        if (r13.get("x-ss-etag") != null) goto L41;
    L43:
        String r6 = "";
    L45:
        if (r13.get(TNC_CANARY) != null) goto L47;
    L49:
        String r15 = "";
    L51:
        if (r13.get(r4) != null) goto L53;
        r23 = r1;
    L58:
        String r7 = "";
    L60:
        if (r13.get(r3) != null) goto L104;
        r24 = r4;
    L69:
        String r9 = "";
    L71:
        if (r13.get(TNC_CONTROL) == null) goto L77;
        r25 = r3;
    L84:
        th = th;
    L110:
        th.printStackTrace();     // Catch: Throwable -> L95
        return;
    L95:
        th = th;
        goto L102
    L75:
        if (TextUtils.isEmpty((CharSequence) ((List) r13.get(TNC_CONTROL)).get(0)) == true) goto L78;
        String r21 = (String) ((List) r13.get(TNC_CONTROL)).get(0);     // Catch: Throwable -> L84
    L80:
        if (Logger.debug() == false) goto L82;
        Logger.d(TAG, "tnc verion: " + r6 + " canary: " + r15 + " configid: " + r7 + " abtest: " + r9);     // Catch: Throwable -> L84
    L82:
        SsCronetHttpClient.inst(r8).notifyTNCConfigUpdated(r6, r15, r7, r9, r21, r12);     // Catch: Throwable -> L84
        return;
    L78:
        r21 = "";
    L86:
        th = th;
    L87:
        r25 = r3;
        goto L110
    L77:
        r25 = r3;
        goto L78
    L104:
        r24 = r4;
        if (TextUtils.isEmpty((CharSequence) ((List) r13.get(r3)).get(0)) == true) goto L69;
        r9 = (String) ((List) r13.get(r3)).get(0);     // Catch: Throwable -> L86
    L66:
        th = th;
        r24 = r4;
        goto L87
    L53:
        r23 = r1;
        if (TextUtils.isEmpty((CharSequence) ((List) r13.get(r4)).get(0)) == true) goto L58;
        r7 = (String) ((List) r13.get(r4)).get(0);     // Catch: Throwable -> L88
    L88:
        th = th;
    L92:
        r25 = r3;
        r24 = r4;
        goto L110
    L47:
        if (TextUtils.isEmpty((CharSequence) ((List) r13.get(TNC_CANARY)).get(0)) == true) goto L49;
        r15 = (String) ((List) r13.get(TNC_CANARY)).get(0);     // Catch: Throwable -> L90
        goto L51
    L41:
        if (TextUtils.isEmpty((CharSequence) ((List) r13.get("x-ss-etag")).get(0)) == true) goto L43;
        r6 = (String) ((List) r13.get("x-ss-etag")).get(0);     // Catch: Throwable -> L90
    L90:
        th = th;
        r23 = r1;
        goto L92
    L31:
        return;
    L25:
        return;
    L99:
        th = th;
        goto L101
    L132:
        return;
    }
}

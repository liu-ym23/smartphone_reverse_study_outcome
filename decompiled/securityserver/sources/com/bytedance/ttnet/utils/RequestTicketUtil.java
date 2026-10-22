package com.bytedance.ttnet.utils;

import com.bytedance.frameworks.baselib.network.http.util.URIUtils;
import com.bytedance.ttnet.AppConsts;
import com.bytedance.ttnet.http.HttpRequestInfo;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class RequestTicketUtil {
    public static final String HNAME_X_REQ_TICKET = "X-SS-REQ-TICKET";
    private static ICdnCacheVerifyCallback sCdnCacheVerifyProcessor = null;
    private static volatile boolean sEnabled = true;
    private static IRequestTicketProcessor sTicketProcessor;

    public interface ICdnCacheVerifyCallback {
        void onCallback(String r1, HttpRequestInfo r2);
    }

    public interface IRequestTicketProcessor {
        void checkReqTicket(String r1, String r2, String r3, HttpRequestInfo r4);

        void sendSetCookieEvent(String r1, String r2, int r3, boolean r4, JSONObject r5);
    }

    public RequestTicketUtil() {
    }

    public static void checkReqTicket(String r1, String r2, String r3, HttpRequestInfo r4) {
        IRequestTicketProcessor r0 = sTicketProcessor;
        if (r0 == null) goto L6;
        r0.checkReqTicket(r1, r2, r3, r4);
        return;
    }

    public static ICdnCacheVerifyCallback getCdnCacheVerifyProcessor() {
        return sCdnCacheVerifyProcessor;
    }

    public static IRequestTicketProcessor getRequestTicketProcessor() {
        return sTicketProcessor;
    }

    public static void sendSetCookieEvent(String r6, String r7, int r8, boolean r9, JSONObject r10) {
        IRequestTicketProcessor r0 = sTicketProcessor;
        if (r0 == null) goto L6;
        r0.sendSetCookieEvent(r6, r7, r8, r9, r10);
        return;
    }

    public static void setCdnCacheVerifyProcessor(ICdnCacheVerifyCallback r0) {
        sCdnCacheVerifyProcessor = r0;
    }

    public static void setEnable(boolean r0) {
        sEnabled = r0;
    }

    public static void setRequestTicketProcessor(IRequestTicketProcessor r0) {
        sTicketProcessor = r0;
    }

    public static String tryGenReqTicket(String r4) {
        if (sEnabled == true) goto L11;
        return null;
    L11:
        if (URIUtils.safeCreateUri(r4).getHost().endsWith(AppConsts.getHostSuffix()) == false) goto L9;
        return String.valueOf(System.currentTimeMillis());
    L9:
        return null;
    }
}

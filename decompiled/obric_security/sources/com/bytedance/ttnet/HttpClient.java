package com.bytedance.ttnet;

import android.content.Context;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.TTNetInitMetrics;
import com.bytedance.frameworks.baselib.network.http.IHttpClient;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.SsOkHttp3Client;
import com.bytedance.frameworks.baselib.network.http.util.ProcessUtils;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.SsCall;
import com.bytedance.ttnet.config.ExperimentalSwitches;
import com.bytedance.ttnet.tnc.TNCManager;
import com.bytedance.ttnet.utils.TtnetUtil;
import java.io.IOException;
import java.net.MalformedURLException;

/* JADX INFO: loaded from: classes2.dex */
public class HttpClient {
    static final CronetImpl CRONET_IMPL = null;
    static final OK3Impl OK3_IMPL = null;
    private static final String TAG = "HttpClient";
    static volatile boolean sCronetBootSucceed = false;
    static String sCronetExceptionMessage = null;
    private static volatile IHttpClientConfig sHttpClientConfig = null;
    static boolean sIsCronetException = false;

    /* JADX INFO: renamed from: com.bytedance.ttnet.HttpClient$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class CronetImpl extends OK3Impl {
        private CronetImpl() {
            super(null);
        }

        /* synthetic */ CronetImpl(AnonymousClass1 r1) {
            this();
        }

        @Override // com.bytedance.ttnet.HttpClient.OK3Impl
        public IHttpClient getHttpClient() {
            return SsCronetHttpClientWrap.inst(SsCronetHttpClient.inst(TTNetInit.getTTNetDepend().getContext()));
        }
    }

    public interface IHttpClientConfig {
        boolean isChromiumOpen();
    }

    private static class OK3Impl {
        private OK3Impl() {
        }

        /* synthetic */ OK3Impl(AnonymousClass1 r1) {
            this();
        }

        public IHttpClient getHttpClient() {
            Context r1 = TTNetInit.getTTNetDepend().getContext();
            SsOkHttp3Client r0 = SsOkHttp3Client.inst(r1);
            if (ProcessUtils.isMainProcessByProcessFlag(r1) == false) goto L5;
            r0.setOk3TncBridge(TNCManager.getInstance());
        L5:
            return r0;
        }
    }

    private static class SsCronetHttpClientWrap implements IHttpClient {
        private static final int CRONET_EXCEPTION_LIMIT_TIMES = 3;
        private static volatile SsCronetHttpClientWrap sInstance;
        private volatile int mCronetExceptionTimes;
        private SsCronetHttpClient ssCronetHttpClient;

        public static SsCronetHttpClientWrap inst(SsCronetHttpClient r2) {
            if (sInstance != null) goto L15;
            monitor-enter(SsCronetHttpClientWrap.class);
        L11:
            th = move-exception;
            throw th;
        L7:
            if (sInstance != null) goto L9;
            sInstance = new SsCronetHttpClientWrap(r2);     // Catch: Throwable -> L11
        L9:
            monitor-exit(SsCronetHttpClientWrap.class);     // Catch: Throwable -> L11
        L15:
            return sInstance;
        }

        private SsCronetHttpClientWrap(SsCronetHttpClient r1) {
            this.ssCronetHttpClient = r1;
        }

        private void shouldFallbackWhenCronetException(Throwable r4) {
            if ((r4 instanceof MalformedURLException) == false) goto L6;
            return;
        L6:
            if (r4.getMessage() == null) goto L11;
            if (r4.getMessage().contains("MalformedURLException") == false) goto L11;
            return;
        L11:
            if (Logger.debug() == false) goto L14;
            Logger.d(HttpClient.TAG, "init mode is " + TTNetInitMetrics.inst().isPreOrForceInitCronet());
            Logger.d(HttpClient.TAG, "exception times is " + this.mCronetExceptionTimes);
        L14:
            if (TTNetInitMetrics.inst().isPreOrForceInitCronet() == false) goto L27;
            int r0 = this.mCronetExceptionTimes + 1;
            this.mCronetExceptionTimes = r0;
            if (r0 > 3) goto L18;
            return;
        L18:
            if (ExperimentalSwitches.isDisableFallbackReasonCronetException() == false) goto L20;
        L23:
            HttpClient.sCronetExceptionMessage = TtnetUtil.outputThrowableStackTrace(r4);
            if (HttpClient.sCronetExceptionMessage.length() <= 256) goto L29;
            HttpClient.sCronetExceptionMessage = HttpClient.sCronetExceptionMessage.substring(0, 256);
            return;
        L29:
            return;
        L20:
            if (Logger.debug() == false) goto L22;
            Logger.d(HttpClient.TAG, "set sIsCronetException true");
        L22:
            HttpClient.sIsCronetException = true;
            goto L23
        }

        @Override // com.bytedance.retrofit2.client.Client
        public SsCall newSsCall(Request r4) throws IOException {
            return this.ssCronetHttpClient.newSsCall(r4);
        L4:
            th = move-exception;
            shouldFallbackWhenCronetException(th);
            TTNetInit.notifyColdStartFinish();
            if (r4.getMetrics() == null) goto L14;
            String r0 = TtnetUtil.outputThrowableStackTrace(th);
            if (r0.length() <= 1024) goto L10;
            r0 = r0.substring(0, 1024);
        L10:
            r4.getMetrics().requestFallbackMessage = r0;
            r4.getMetrics().requestFallbackReason = 10;
            if (Logger.debug() == false) goto L14;
            Logger.d(HttpClient.TAG, "new CronetSscall failed " + this.mCronetExceptionTimes + " for " + r4.getPath());
            Logger.d(HttpClient.TAG, "new CronetSscall failed message " + r0);
        L14:
            return HttpClient.OK3_IMPL.getHttpClient().newSsCall(r4);
        }
    }

    public HttpClient() {
    }

    public static void setHttpClientConfig(IHttpClientConfig r0) {
        sHttpClientConfig = r0;
    }

    static {
        AnonymousClass1 r1 = null;
        OK3_IMPL = new OK3Impl(r1);
        CRONET_IMPL = new CronetImpl(r1);
    }

    public static void setCronetBootSucceed(boolean r0) {
        sCronetBootSucceed = r0;
    }

    public static String getCronetExceptionMessage() {
        return sCronetExceptionMessage;
    }

    public static boolean isCronetClientEnable() {
        if (sHttpClientConfig == null) goto L11;
        if (SsOkHttp3Client.getFallbackReason() != 9) goto L11;
        if (Logger.debug() == false) goto L9;
        Logger.d(TAG, "reset null config fallback");
    L9:
        SsOkHttp3Client.setFallbackReason(-1);
    L11:
        if (sHttpClientConfig != null) goto L20;
        if (ExperimentalSwitches.isDisableFallbackReasonNullAppconfig() == true) goto L20;
        if (Logger.debug() == false) goto L17;
        Logger.d(TAG, "check null config and fallback");
    L17:
        TNCManager.getInstance().handleCronetInitFailed();
        SsOkHttp3Client.setFallbackReason(9);
        return false;
    L20:
        if (sHttpClientConfig == null) goto L25;
        if (sHttpClientConfig.isChromiumOpen() == true) goto L25;
        return false;
    L25:
        if (sIsCronetException == true) goto L27;
        return true;
    L27:
        if (sCronetBootSucceed == true) goto L32;
        SsOkHttp3Client.setFallbackReason(7);
        SsOkHttp3Client.setFallbackMessage(sCronetExceptionMessage);
        return false;
    L32:
        return true;
    }

    public static IHttpClient getHttpClient(String r0, boolean r1) {
        if (isCronetClientEnable() == false) goto L8;
        if (r1 == true) goto L8;
        return CRONET_IMPL.getHttpClient();
    L8:
        return OK3_IMPL.getHttpClient();
    }

    public static IHttpClient getHttpClient(String r0) {
        if (isCronetClientEnable() == false) goto L7;
        return CRONET_IMPL.getHttpClient();
    L7:
        return OK3_IMPL.getHttpClient();
    }
}

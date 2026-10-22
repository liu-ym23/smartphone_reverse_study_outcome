package com.bytedance.ttnet;

import android.content.Context;
import com.bytedance.frameworks.baselib.network.http.IHttpClient;
import com.bytedance.frameworks.baselib.network.http.cronet.TTNetInitMetrics;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.SsOkHttp3Client;
import com.bytedance.frameworks.baselib.network.http.util.ProcessUtils;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.SsCall;
import com.bytedance.ttnet.tnc.TNCManager;
import com.bytedance.ttnet.utils.TtnetUtil;
import java.io.IOException;
import java.net.MalformedURLException;

/* JADX INFO: loaded from: classes3.dex */
public class HttpClient {
    static final CronetImpl CRONET_IMPL = null;
    static final OK3Impl OK3_IMPL = null;
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

        private void shouldFallbackWhenCronetException(Throwable r3) {
            if ((r3 instanceof MalformedURLException) == false) goto L6;
            return;
        L6:
            if (r3.getMessage() == null) goto L11;
            if (r3.getMessage().contains("MalformedURLException") == false) goto L11;
            return;
        L11:
            if (TTNetInitMetrics.inst().isPreOrForceInitCronet() == false) goto L18;
            int r0 = this.mCronetExceptionTimes + 1;
            this.mCronetExceptionTimes = r0;
            if (r0 <= 3) goto L19;
            HttpClient.sIsCronetException = true;
            HttpClient.sCronetExceptionMessage = TtnetUtil.outputThrowableStackTrace(r3);
            if (HttpClient.sCronetExceptionMessage.length() <= 256) goto L20;
            HttpClient.sCronetExceptionMessage = HttpClient.sCronetExceptionMessage.substring(0, 256);
            return;
        L20:
            return;
        L19:
            return;
        }

        @Override // com.bytedance.retrofit2.client.Client
        public SsCall newSsCall(Request r2) throws IOException {
            return this.ssCronetHttpClient.newSsCall(r2);
        L4:
            th = move-exception;
            shouldFallbackWhenCronetException(th);
            TTNetInit.notifyColdStartFinish();
            return HttpClient.OK3_IMPL.getHttpClient().newSsCall(r2);
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
        if (sHttpClientConfig != null) goto L7;
        SsOkHttp3Client.setFallbackReason(9);
        return false;
    L7:
        if (sHttpClientConfig.isChromiumOpen() == true) goto L10;
        return false;
    L10:
        if (TTNetInit.getTTNetDepend().isCronetPluginInstalled() == true) goto L14;
        SsOkHttp3Client.setFallbackReason(6);
        return false;
    L14:
        if (sIsCronetException == true) goto L16;
        return true;
    L16:
        if (sCronetBootSucceed == true) goto L21;
        SsOkHttp3Client.setFallbackReason(7);
        SsOkHttp3Client.setFallbackMessage(sCronetExceptionMessage);
        return false;
    L21:
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

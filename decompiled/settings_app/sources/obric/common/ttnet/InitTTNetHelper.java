package obric.common.ttnet;

import android.app.Application;
import android.content.Context;
import android.icu.text.DateFormat;
import android.provider.Settings;
import com.android.settings.SettingsApplication;
import com.bytedance.article.common.network.SSNetworkClient;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.http.HttpRequestInfo;
import com.bytedance.ttnet.http.RequestContext;
import com.bytedance.ttnet.utils.RetrofitUtils;
import com.obric.olog.OLog;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import obric.common.security.ssl.BDKeyManagerRef;
import org.json.JSONObject;

/* JADX INFO: compiled from: InitTTNetHelper.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0004J\u0016\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\bJ\u0006\u0010\u001e\u001a\u00020\u001fJ>\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u001f2\b\u0010\"\u001a\u0004\u0018\u00010\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u00062\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\b\u0010%\u001a\u0004\u0018\u00010\u0011H\u0002J\u000e\u0010&\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cJ\f\u0010'\u001a\u00020\u0017*\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010\t\u001a\n \n*\u0004\u0018\u00010\u00060\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lobric/common/ttnet/InitTTNetHelper;", "", "()V", "DEFAULT_TIMEOUT_MILLISECONDS", "", "TAG", "", "mContext", "Landroid/app/Application;", "ppe", "kotlin.jvm.PlatformType", "getPpe", "()Ljava/lang/String;", "ppe$delegate", "Lkotlin/Lazy;", "sApiProcessHook", "Lcom/bytedance/frameworks/baselib/network/http/NetworkParams$ApiProcessHook;", "Lcom/bytedance/ttnet/http/HttpRequestInfo;", "sMonitorProcessHook", "Lcom/bytedance/frameworks/baselib/network/http/NetworkParams$MonitorProcessHook;", "timeoutConfig", "Ljava/util/concurrent/ConcurrentHashMap;", "addTimeoutConfig", "", "url", "timeout", "init", "context", "Landroid/content/Context;", "application", "isUseSandbox", "", "logApiRequest", "isError", "traceCode", "duration", "sendTime", "info", "setTLSAuth", "printNecessaryHeader", "app_neridaCnRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class InitTTNetHelper {
    private static final long DEFAULT_TIMEOUT_MILLISECONDS = 60000;
    public static final InitTTNetHelper INSTANCE = null;
    private static final String TAG = "TTNetInitHelper";
    private static Application mContext;
    private static final Lazy ppe$delegate = null;
    private static final NetworkParams.ApiProcessHook<HttpRequestInfo> sApiProcessHook = null;
    private static final NetworkParams.MonitorProcessHook<HttpRequestInfo> sMonitorProcessHook = null;
    private static final ConcurrentHashMap<String, Long> timeoutConfig = null;

    public static /* synthetic */ SsResponse $r8$lambda$tB9HlW4Oq10ty_MEs2Cwt7wZunQ(Interceptor.Chain r0) {
        return init$lambda$1(r0);
    }

    private InitTTNetHelper() {
    }

    public static final /* synthetic */ void access$logApiRequest(InitTTNetHelper r0, boolean r1, String r2, String r3, long r4, long r6, HttpRequestInfo r8) {
        r0.logApiRequest(r1, r2, r3, r4, r6, r8);
    }

    static {
        INSTANCE = new InitTTNetHelper();
        timeoutConfig = new ConcurrentHashMap(4, 0.9f, 1);
        ppe$delegate = LazyKt.lazy(InitTTNetHelper$ppe$2.INSTANCE);
        sMonitorProcessHook = new InitTTNetHelper$sMonitorProcessHook$1();
        sApiProcessHook = new InitTTNetHelper$sApiProcessHook$1();
    }

    public final void addTimeoutConfig(String r1, long r2) {
        Intrinsics.checkNotNullParameter(r1, "url");
        timeoutConfig.put(r1, Long.valueOf(r2));
    }

    private final String getPpe() {
        return (String) ppe$delegate.getValue();
    }

    public final void init(Context r10, Application r11) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Intrinsics.checkNotNullParameter(r11, "application");
        OLog.i(TAG, "initTTNet start");     // Catch: Throwable -> L5
        mContext = r11;     // Catch: Throwable -> L5
        TTNetCronetDependAdapter.INSTANCE.inJect();     // Catch: Throwable -> L5
        TTNetInit.setTTNetDepend(new TTNetDepend(r10));     // Catch: Throwable -> L5
        TTNetInit.tryInitTTNet(r10, r11, sApiProcessHook, sMonitorProcessHook, null, true, new boolean[]{false});     // Catch: Throwable -> L5
        TTNetInit.setCronetDepend(TTNetCronetDependAdapter.INSTANCE);     // Catch: Throwable -> L5
        TTNetInit.preInitCronetKernel();     // Catch: Throwable -> L5
        setTLSAuth(r10);     // Catch: Throwable -> L5
        RetrofitUtils.addInterceptor(new InitTTNetHelper$$ExternalSyntheticLambda0());     // Catch: Throwable -> L5
        SSNetworkClient.setDefault(new CustomNetworkClient());     // Catch: Throwable -> L5
        OLog.i(TAG, "initTTNet end");     // Catch: Throwable -> L5
    L7:
        NetworkClient.setDefault(new SSNetworkClient());
        return;
    L5:
        th = move-exception;
        OLog.e(TAG, "initTTNet error", th);
        goto L7
    }

    private static final SsResponse init$lambda$1(Interceptor.Chain r10) {
        Request r0 = r10.request();
        ArrayList r1 = new ArrayList();
        InitTTNetHelper r2 = INSTANCE;
        String r3 = r2.getPpe();
        if (r3 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == true) goto L11;
        r1.add(new Header("x-tt-env", r2.getPpe()));
        r1.add(new Header("x-use-ppe", "1"));
    L11:
        String r5 = r0.getUrl().toString();
        Iterator<Map.Entry<String, Long>> r6 = timeoutConfig.entrySet().iterator();
    L13:
        if (r6.hasNext() == false) goto L17;
        Map.Entry<String, Long> r7 = r6.next();
        if (StringsKt.startsWith$default(r5, r7.getKey(), false, 2, null) == false) goto L13;
        long r8 = r7.getValue().longValue();
    L18:
        OLog.d(TAG, "TimeoutSetting Interceptor works. Timeout: " + r8 + DateFormat.MINUTE_SECOND);
        RequestContext r9 = new RequestContext();
        r9.timeout_connect = r8;
        r9.timeout_read = r8;
        r9.timeout_write = r8;
        r9.socket_connect_timeout = r8;
        r9.socket_read_timeout = r8;
        r9.socket_write_timeout = r8;
        r9.protect_timeout = r8;
        r9.bypassCookie = true;
        Request.Builder r11 = r0.newBuilder();
        List<Header> r12 = r0.getHeaders();
        Intrinsics.checkNotNullExpressionValue(r12, "getHeaders(...)");
        r1.addAll(r12);
        r11.headers(r1);
        r11.setExtraInfo(r9);
        return r10.proceed(r11.build());
    L17:
        r8 = 60000;
        goto L18
    L5:
        if (r3.length() == 0) goto L8;
        r4 = false;
        goto L9
    }

    private final void printNecessaryHeader(String r6) {
        JSONObject r5 = new JSONObject(r6);     // Catch: Throwable -> L10
        Iterator<String> r7 = r5.keys();     // Catch: Throwable -> L10
        Intrinsics.checkNotNullExpressionValue(r7, "keys(...)");     // Catch: Throwable -> L10
    L4:
        if (r7.hasNext() == false) goto L18;
        String r0 = r7.next();     // Catch: Throwable -> L10
        Object r1 = r5.get(r0);     // Catch: Throwable -> L10
        Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L10
        if (StringsKt.startsWith(r0, "x-tt", true) == false) goto L4;
        OLog.i(TAG, " - [header] `" + r0 + "` = " + r1);     // Catch: Throwable -> L10
    L18:
        return;
    }

    private final void logApiRequest(boolean r1, String r2, String r3, long r4, long r6, HttpRequestInfo r8) {
        OLog.i(TAG, "[TTNet headers - isError=" + r1 + ']');
        if (r8 == null) goto L7;
        String r5 = r8.requestHeaders;
        if (r5 == null) goto L7;
        printNecessaryHeader(r5);
    L7:
        if (r8 == null) goto L12;
        String r7 = r8.responseHeaders;
        if (r7 == null) goto L13;
        printNecessaryHeader(r7);
        return;
    L13:
        return;
    }

    public final void setTLSAuth(Context r12) {
        Intrinsics.checkNotNullParameter(r12, "context");
        String[] r2 = {"mtls-ota.obriccloud.com"};
        BDKeyManagerRef r0 = BDKeyManagerRef.getInstance();
        if (isUseSandbox() == false) goto L5;
        String r1 = BDKeyManagerRef.TLS_TEST_CERT;
    L6:
        X509Certificate r3 = r0.getCertChain(r1).get(0);
        boolean r4 = isUseSandbox();     // Catch: Throwable -> L25
        String r5 = BDKeyManagerRef.TLS_TEST_PKEY;
        if (r4 == false) goto L11;
        String r6 = BDKeyManagerRef.TLS_TEST_PKEY;
    L13:
        if (r0.isContainsKey(r6) == false) goto L19;
        byte[] r7 = r3.getEncoded();     // Catch: Throwable -> L25
        long r8 = r0.getAlgorithmAddress();     // Catch: Throwable -> L25
        if (isUseSandbox() == true) goto L18;
        r5 = BDKeyManagerRef.TLS_PRO_PKEY;
    L18:
        TTNetInit.addClientOpaqueData(r12, r2, r7, null, r8, r0.getDoSignAddress(r5));     // Catch: Throwable -> L25
    L28:
        return;
    L19:
        byte[] r9 = r3.getEncoded();     // Catch: Throwable -> L25
        if (isUseSandbox() == true) goto L23;
        r5 = BDKeyManagerRef.TLS_PRO_PKEY;
    L23:
        TTNetInit.addClientOpaqueData(r12, r2, r9, r0.getPrivateKey(r5).getEncoded());     // Catch: Throwable -> L25
        goto L28
    L11:
        r6 = BDKeyManagerRef.TLS_PRO_PKEY;
    L25:
        th = move-exception;
        th.printStackTrace();
        return;
    L5:
        r1 = BDKeyManagerRef.TLS_PRO_CERT;
        goto L6
    }

    public final boolean isUseSandbox() {
        boolean r1 = false;
        if (Settings.Global.getInt(SettingsApplication.getContext().getContentResolver(), "ota.local_test.use_sandbox", 0) != 1) goto L5;
        r1 = true;
    L5:
        OLog.w(TAG, "isUseSandbox, " + r1);
        return r1;
    }
}

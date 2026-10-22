package com.bytedance.ttnet.config;

import android.webkit.CookieManager;
import com.bytedance.common.utility.Lists;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient;
import com.bytedance.frameworks.baselib.network.http.impl.CookieManagerWrap;
import com.bytedance.frameworks.baselib.network.http.impl.SSCookieHandler;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.SsOkHttp3Client;
import com.bytedance.frameworks.baselib.network.queryfilter.QueryFilterEngine;
import com.bytedance.frameworks.core.encrypt.RequestEncryptUtils;
import com.bytedance.ttnet.HttpClient;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.retrofit.SsInterceptor;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class SyncMultiProcessConfig implements NetworkParams.CookieShareInterceptor, RequestEncryptUtils.IEncryptConfig, HttpClient.IHttpClientConfig, SsCronetHttpClient.ICronetHttpDnsConfig, SsCronetHttpClient.ICronetBootFailureChecker {
    private static final String TAG = "SyncMainProcessConfig";
    private static volatile SyncMultiProcessConfig mInstance;
    private int mAddSsQueriesHeaderOpen;
    private int mAddSsQueriesOpen;
    private int mAddSsQueriesPlaintextOpen;
    private int mChromiumBootFailures;
    private int mHttpDnsEnabled;
    private String mShareCookieHostList;

    private SyncMultiProcessConfig() {
        SyncMainProcessConfig();
    }

    private boolean inCookieHostList(String r2, List<String> r3) {
        if (StringUtils.isEmpty(r2) == false) goto L5;
    L14:
        return false;
    L5:
        if (Lists.isEmpty(r3) == true) goto L14;
        Iterator<String> r1 = r3.iterator();
    L9:
        if (r1.hasNext() == false) goto L14;
        if (r2.endsWith(r1.next()) == false) goto L9;
        return true;
    }

    public static SyncMultiProcessConfig inst() {
        if (mInstance != null) goto L16;
        monitor-enter(SyncMultiProcessConfig.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L11;
        mInstance = new SyncMultiProcessConfig();     // Catch: Throwable -> L9
    L11:
        monitor-exit(SyncMultiProcessConfig.class);     // Catch: Throwable -> L9
    L16:
        return mInstance;
    }

    public void SyncMainProcessConfig() {
        TTNetInit.getTTNetDepend();     // Catch: Throwable -> L23
        Logger.w(TAG, "Sync main process config in current process.");
        this.mShareCookieHostList = TTNetInit.getTTNetDepend().getProviderString(TTNetInit.getTTNetDepend().getContext(), "share_cookie_host_list", "");
        TTNetInit.getTTNetDepend().onShareCookieConfigUpdated(this.mShareCookieHostList);
        boolean r4 = false;
        this.mAddSsQueriesOpen = TTNetInit.getTTNetDepend().getProviderInt(TTNetInit.getTTNetDepend().getContext(), "add_ss_queries_open", 0);
        int r0 = TTNetInit.getTTNetDepend().getProviderInt(TTNetInit.getTTNetDepend().getContext(), "add_ss_queries_header_open", 0);
        this.mAddSsQueriesHeaderOpen = r0;
        if (this.mAddSsQueriesOpen > 0) goto L6;
        if (r0 > 0) goto L6;
    L7:
        this.mAddSsQueriesPlaintextOpen = TTNetInit.getTTNetDepend().getProviderInt(TTNetInit.getTTNetDepend().getContext(), "add_ss_queries_plaintext_open", 1);
        this.mHttpDnsEnabled = TTNetInit.getTTNetDepend().getProviderInt(TTNetInit.getTTNetDepend().getContext(), "http_dns_enabled", 0);
        this.mChromiumBootFailures = TTNetInit.getTTNetDepend().getProviderInt(TTNetInit.getTTNetDepend().getContext(), "chromium_boot_failures", 0);
        int r8 = TTNetInit.getTTNetDepend().getProviderInt(TTNetInit.getTTNetDepend().getContext(), QueryFilterEngine.KEY_QUERY_FILTER_ENABLED, Integer.MIN_VALUE);
        String r1 = TTNetInit.getTTNetDepend().getProviderString(TTNetInit.getTTNetDepend().getContext(), QueryFilterEngine.KEY_QUERY_FILTER_CONFIG, "");
        QueryFilterEngine.inst().parseL0ParamsString(TTNetInit.getTTNetDepend().getProviderString(TTNetInit.getTTNetDepend().getContext(), QueryFilterEngine.KEY_L0_PARAMS, ""));
        if (r8 == Integer.MIN_VALUE) goto L15;
        QueryFilterEngine r2 = QueryFilterEngine.inst();
        if (r8 <= 0) goto L12;
        boolean r9 = true;
    L13:
        r2.enableQueryFilterEngine(r9);
        QueryFilterEngine.inst().onNetConfigChanged(r1);
        goto L15
    L12:
        r9 = false;
    L15:
        if (TTNetInit.getTTNetDepend().getProviderInt(TTNetInit.getTTNetDepend().getContext(), "private_protocol_enabled", 1) < 1) goto L17;
        boolean r10 = true;
    L18:
        NetworkParams.setPrivateProtocolEnabled(r10);
        if (TTNetInit.getTTNetDepend().getProviderInt(TTNetInit.getTTNetDepend().getContext(), "disable_rotating_host_path_retry", -1) < 1) goto L21;
        r4 = true;
    L21:
        NetworkParams.setDisableRotationHostRetryByTnc(r4);
        return;
    L17:
        r10 = false;
    L6:
        SsInterceptor.EnableEncryptQuery(true);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.NetworkParams.CookieShareInterceptor
    public List<String> getShareCookie(CookieManager r10, CookieManagerWrap r11, URI r12) {
        if (r12 == null) goto L47;
        if (r10 != null) goto L48;
        if (r11 == null) goto L47;
    L48:
        String r1 = r12.getHost();     // Catch: Exception -> L9
    L10:
        ArrayList r2 = new ArrayList();
        String[] r3 = this.mShareCookieHostList.split(",");
        int r4 = r3.length;
        int r5 = 0;
    L11:
        if (r5 >= r4) goto L17;
        String r6 = r3[r5];
        if (StringUtils.isEmpty(r6) == true) goto L15;
        r2.add(r6);
    L15:
        r5 = r5 + 1;
        goto L11
    L17:
        if (StringUtils.isEmpty(r1) == true) goto L47;
        if (inCookieHostList(r1, r2) == false) goto L47;
        if (StringUtils.isEmpty(TTNetInit.getTTNetDepend().getShareCookieMainDomain()) == false) goto L24;
        return null;
    L24:
        ArrayList r9 = new ArrayList();
        if (r10 == null) goto L30;
        String r13 = r10.getCookie(TTNetInit.getTTNetDepend().getShareCookieMainDomain());
        if (StringUtils.isEmpty(r13) == true) goto L30;
        r9.add(r13);
    L30:
        if (Lists.isEmpty(r9) == false) goto L57;
        if (r11 == null) goto L58;
        Map<String, List<String>> r14 = r11.get(URI.create(r12.getScheme() + "://" + TTNetInit.getTTNetDepend().getShareCookieMainDomain()), new LinkedHashMap());     // Catch: Throwable -> L42
        if (r14 != null) goto L35;
        return r9;
    L35:
        if (r14.isEmpty() == true) goto L60;
        List<String> r15 = r14.get("Cookie");     // Catch: Throwable -> L42
        if (r15 == null) goto L46;
        r15.add(SSCookieHandler.REQUEST_COOKIE_SOURCE_INTERCEPT_BACKUP_FLAG);     // Catch: Throwable -> L40
    L40:
        Throwable th = th;
    L44:
        th.printStackTrace();
    L46:
        return r15;
    L60:
        return r9;
    L42:
        th = move-exception;
        r15 = r9;
        th = th;
        goto L44
    L58:
        return r9;
    L57:
        return r9;
    L9:
        r1 = null;
    L47:
        return null;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.NetworkParams.CookieShareInterceptor
    public List<String> getShareCookieHostList(String r7) {
        ArrayList r0 = new ArrayList();
        String[] r1 = this.mShareCookieHostList.split(",");
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L8;
        String r4 = r1[r3];
        if (StringUtils.isEmpty(r4) == true) goto L7;
        r0.add(r4);
    L7:
        r3 = r3 + 1;
        goto L3
    L8:
        String r5 = TTNetInit.getTTNetDepend().getShareCookieMainDomain();
        if (StringUtils.isEmpty(r5) == true) goto L14;
        if (inCookieHostList(r5, r0) == true) goto L14;
        r0.add(r5);
    L14:
        if (inCookieHostList(r7, r0) == false) goto L16;
        return r0;
    L16:
        return null;
    }

    @Override // com.bytedance.ttnet.HttpClient.IHttpClientConfig
    public boolean isChromiumOpen() {
        if (AppConfig.sForceNotUseCronet == false) goto L7;
        SsOkHttp3Client.setFallbackReason(0);
        return false;
    L7:
        if (AppConfig.sCronetUnsupportedModel == false) goto L11;
        SsOkHttp3Client.setFallbackReason(8);
        return false;
    L11:
        if (AppConfig.isCronetUnsupportedABI() == false) goto L14;
        return false;
    L14:
        if (AppConfig.sDisableFallbackReasonBoot == true) goto L20;
        if (this.mChromiumBootFailures <= 5) goto L20;
        SsOkHttp3Client.setFallbackReason(3);
        Logger.e(TAG, "After five consecutive crashes of cronet on subprocess, you must reinstall app to enable cronet, or wait until several hours");
        return false;
    L20:
        if (TTNetInit.getTTNetDepend().isCronetPluginInstalled() == true) goto L23;
        SsOkHttp3Client.setFallbackReason(6);
        return false;
    L23:
        return true;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient.ICronetBootFailureChecker
    public boolean isCronetBootFailureExpected() {
        if (AppConfig.sDisableFallbackReasonBoot == false) goto L6;
        return true;
    L6:
        if (TTNetInit.getTTNetDepend().getProviderInt(TTNetInit.getTTNetDepend().getContext(), "chromium_boot_failures", 0) > 5) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient.ICronetHttpDnsConfig
    public boolean isCronetHttpDnsOpen() {
        if (AppConfig.sForceNotUseCronet == false) goto L6;
        return false;
    L6:
        if (this.mHttpDnsEnabled <= 0) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.frameworks.core.encrypt.RequestEncryptUtils.IEncryptConfig
    public boolean isSsQueriesHeaderOpen() {
        if (this.mAddSsQueriesHeaderOpen <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.frameworks.core.encrypt.RequestEncryptUtils.IEncryptConfig
    public boolean isSsQueriesOpen() {
        if (this.mAddSsQueriesOpen <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.frameworks.core.encrypt.RequestEncryptUtils.IEncryptConfig
    public boolean isSsQueriesPlaintextOpen() {
        if (this.mAddSsQueriesPlaintextOpen <= 0) goto L5;
        return true;
    L5:
        return false;
    }
}

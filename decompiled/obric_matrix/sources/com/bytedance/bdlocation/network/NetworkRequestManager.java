package com.bytedance.bdlocation.network;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.network.request.RequestUtil;
import com.bytedance.ttnet.INetworkApi;
import com.bytedance.ttnet.s.d;
import d.b.r.d0;
import d.b.r.k0.k;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class NetworkRequestManager {
    public NetworkRequestManager() {
    }

    public static String get(String r8, Map<String, String> r9, int r10) {
        Logger.i("NetworkRequest get Path:" + r8);     // Catch: Exception -> L4
        String r11 = ((INetworkApiInner) d.f(getBaseUrl(), INetworkApiInner.class)).doGet(true, -1, r8, r9, RequestUtil.headerList(null, r10), null).execute().a();     // Catch: Exception -> L4
        Logger.i("NetworkRequestManager post networkResponse:" + r11);     // Catch: Exception -> L4
        return r11;
    L4:
        e = move-exception;
        Logger.e("NetworkRequestManager get exception:" + e.getMessage());
        return "";
    }

    private static String getBaseUrl() {
        String r0 = BDLocationConfig.getBaseUrl();
        if (TextUtils.isEmpty(r0) == true) goto L5;
        return r0;
    L5:
        Logger.e("需要初始化时设置业务自身域名:BDLocationConfig.setBaseUrl(\"xxxx\")");
        return "";
    }

    public static String post(String r14, Map<String, String> r15, Map<String, String> r16, int r17) {
        if (BDLocationConfig.isPrivacyConfirmed() == true) goto L17;
        Logger.i("The upload of data is allowed after user confirmed the privacy!");
        return "";
    L17:
        long r3 = System.currentTimeMillis();     // Catch: Exception -> L14
        Logger.i("NetworkRequest post Path:" + r14);     // Catch: Exception -> L14
        ICustomNetworkApi r6 = BDLocationConfig.getNetworkApi();     // Catch: Exception -> L14
        if (r6 == null) goto L9;
        d0<String> r0 = r6.doPost(getBaseUrl(), r14, r16, r15, RequestUtil.headerList(null, r17), true);     // Catch: Exception -> L14
    L10:
        if (r0 != null) goto L12;
        return "";
    L12:
        String r1 = r0.a();     // Catch: Exception -> L14
        Logger.i("NetworkRequestManager post intervalTime:" + (System.currentTimeMillis() - r3) + "--networkResponse:" + r1);     // Catch: Exception -> L14
        return r1;
    L9:
        r0 = ((INetworkApiInner) d.f(getBaseUrl(), INetworkApiInner.class)).doPost(-1, r14, r16, r15, RequestUtil.headerList(null, r17), null, true).execute();     // Catch: Exception -> L14
    L14:
        e = move-exception;
        Logger.e("NetworkRequestManager post exception:" + e.getMessage());
        return "";
    }

    public static String postJson(String r11, k r12, Map<String, String> r13) {
        if (BDLocationConfig.isPrivacyConfirmed() == true) goto L15;
        Logger.i("The upload of data is allowed after user confirmed the privacy!");
        return "";
    L15:
        long r2 = System.currentTimeMillis();     // Catch: Exception -> L12
        Logger.i("NetworkRequest post Path:" + r11);     // Catch: Exception -> L12
        ICustomNetworkApi r4 = BDLocationConfig.getNetworkApi();     // Catch: Exception -> L12
        if (r4 == null) goto L9;
        String r14 = r4.doPostJson(getBaseUrl(), r11, r13, r12, RequestUtil.overseaHeaderList(null), true);     // Catch: Exception -> L12
    L10:
        Logger.i("NetworkRequestManager post intervalTime:" + (System.currentTimeMillis() - r2) + "--networkResponse:" + r14);     // Catch: Exception -> L12
        return r14;
    L9:
        r14 = ((INetworkApi) d.f(getBaseUrl(), INetworkApi.class)).postBody(-1, r11, r13, r12, RequestUtil.overseaHeaderList(null)).execute().a();     // Catch: Exception -> L12
    L12:
        e = move-exception;
        Logger.e("NetworkRequestManager post exception:" + e.getMessage());
        return "";
    }

    @Nullable
    public static d0<String> submitPost(String r12, Map<String, String> r13, Map<String, String> r14, int r15) {
        if (BDLocationConfig.isPrivacyConfirmed() == true) goto L17;
        Logger.i("The upload of data is allowed after user confirmed the privacy!");
        return null;
    L17:
        long r2 = System.currentTimeMillis();     // Catch: Exception -> L14
        Logger.i("NetworkRequest post Path:" + r12);     // Catch: Exception -> L14
        ICustomNetworkApi r4 = BDLocationConfig.getNetworkApi();     // Catch: Exception -> L14
        if (r4 == null) goto L9;
        d0<String> r16 = r4.doPost(getBaseUrl(), r12, r14, r13, RequestUtil.headerList(null, r15), true);     // Catch: Exception -> L14
    L10:
        if (r16 != null) goto L12;
        return null;
    L12:
        Logger.i("NetworkRequestManager post intervalTime:" + (System.currentTimeMillis() - r2));     // Catch: Exception -> L14
        return r16;
    L9:
        r16 = ((INetworkApiInner) d.f(getBaseUrl(), INetworkApiInner.class)).doPost(-1, r12, r14, r13, RequestUtil.headerList(null, r15), null, true).execute();     // Catch: Exception -> L14
    L14:
        e = move-exception;
        Logger.e("NetworkRequestManager post exception:" + e.getMessage());
        return null;
    }
}

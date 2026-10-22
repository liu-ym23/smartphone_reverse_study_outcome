package org.chromium;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.frameworks.baselib.network.http.storeregion.StoreRegionManager;
import com.bytedance.frameworks.baselib.network.http.util.URIUtils;
import com.bytedance.ttnet.TTNetInit;
import com.ttnet.org.chromium.net.TTAppInfoProvider;
import java.net.CookieHandler;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import org.apache.commons.io.IOUtils;

/* JADX INFO: loaded from: classes5.dex */
public class CronetAppInfoProvider extends TTAppInfoProvider {
    private static final String COOKIE_HEADER_KEY = "Cookie";
    private static final int MAX_ABSDK_VERSION_LENGTH = 5;
    private static CronetAppInfoProvider sInstance;
    private TTAppInfoProvider.AppInfo mAppInfo;
    private Context mContext;

    public static CronetAppInfoProvider inst(Context r2) {
        if (sInstance != null) goto L15;
        monitor-enter(CronetAppInfoProvider.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new CronetAppInfoProvider(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(CronetAppInfoProvider.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private CronetAppInfoProvider(Context r1) {
        this.mContext = r1.getApplicationContext();
    }

    private String getCookieHeaderForTncRequest(String r5) {
        CookieHandler r0 = CookieHandler.getDefault();
        if (TextUtils.isEmpty(r5) == true) goto L26;
        if (r0 == null) goto L26;
        Map<String, List<String>> r4 = r0.get(URIUtils.createUriWithOutQuery("https://" + r5), null);     // Catch: Throwable -> L27
        if (r4 == null) goto L26;
        if (r4.size() <= 0) goto L26;
        Iterator<Map.Entry<String, List<String>>> r6 = r4.entrySet().iterator();     // Catch: Throwable -> L27
    L12:
        if (r6.hasNext() == false) goto L26;
        Map.Entry<String, List<String>> r7 = r6.next();     // Catch: Throwable -> L27
        if ("Cookie".equalsIgnoreCase(r7.getKey()) == false) goto L12;
        if (r7.getValue().isEmpty() == true) goto L12;
        StringBuilder r8 = new StringBuilder();     // Catch: Throwable -> L27
        Iterator<String> r9 = r7.getValue().iterator();     // Catch: Throwable -> L27
        int r1 = 0;
    L19:
        if (r9.hasNext() == false) goto L24;
        String r2 = r9.next();     // Catch: Throwable -> L27
        if (r1 <= 0) goto L23;
        r8.append("; ");     // Catch: Throwable -> L27
    L23:
        r8.append(r2);     // Catch: Throwable -> L27
        r1 = r1 + 1;     // Catch: Throwable -> L27
        goto L19
    L24:
        return r8.toString();
    L26:
        return null;
    }

    @Nullable
    private static String toLowerCase(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L6;
        return r1;
    L6:
        return r1.toLowerCase();
    }

    @Override // com.ttnet.org.chromium.net.TTAppInfoProvider
    public TTAppInfoProvider.AppInfo getAppInfo() {
        monitor-enter(CronetAppInfoProvider.class);     // Catch: Throwable -> L64
    L61:
        th = move-exception;
        throw th;     // Catch: Throwable -> L64
    L5:
        if (this.mAppInfo != null) goto L7;
        this.mAppInfo = new TTAppInfoProvider.AppInfo();     // Catch: Throwable -> L61
    L7:
        monitor-exit(CronetAppInfoProvider.class);     // Catch: Throwable -> L61
        this.mAppInfo.setAppId(CronetAppProviderManager.inst().getAppId());     // Catch: Throwable -> L64
        this.mAppInfo.setAppName(CronetAppProviderManager.inst().getAppName());     // Catch: Throwable -> L64
        this.mAppInfo.setSdkAppID(CronetAppProviderManager.inst().getSdkAppId());     // Catch: Throwable -> L64
        this.mAppInfo.setSdkVersion(CronetAppProviderManager.inst().getSdkVersion());     // Catch: Throwable -> L64
        this.mAppInfo.setChannel(CronetAppProviderManager.inst().getChannel());     // Catch: Throwable -> L64
        this.mAppInfo.setDeviceId(CronetAppProviderManager.inst().getDeviceId());     // Catch: Throwable -> L64
        this.mAppInfo.setIsDropFirstTnc(CronetAppProviderManager.inst().getIsDropFirstTnc());     // Catch: Throwable -> L64
        this.mAppInfo.setAbi(CronetAppProviderManager.inst().getAbi());     // Catch: Throwable -> L64
        this.mAppInfo.setDevicePlatform(CronetAppProviderManager.inst().getDevicePlatform());     // Catch: Throwable -> L64
        this.mAppInfo.setDeviceType(CronetAppProviderManager.inst().getDeviceType());     // Catch: Throwable -> L64
        this.mAppInfo.setDeviceBrand(CronetAppProviderManager.inst().getDeviceBrand());     // Catch: Throwable -> L64
        this.mAppInfo.setDeviceModel(CronetAppProviderManager.inst().getDeviceModel());     // Catch: Throwable -> L64
        this.mAppInfo.setNetAccessType(CronetAppProviderManager.inst().getNetAccessType());     // Catch: Throwable -> L64
        this.mAppInfo.setOSApi(CronetAppProviderManager.inst().getOSApi());     // Catch: Throwable -> L64
        this.mAppInfo.setOSVersion(CronetAppProviderManager.inst().getOSVersion());     // Catch: Throwable -> L64
        this.mAppInfo.setUserId(CronetAppProviderManager.inst().getUserId());     // Catch: Throwable -> L64
        this.mAppInfo.setVersionCode(CronetAppProviderManager.inst().getVersionCode());     // Catch: Throwable -> L64
        this.mAppInfo.setVersionName(CronetAppProviderManager.inst().getVersionName());     // Catch: Throwable -> L64
        this.mAppInfo.setUpdateVersionCode(CronetAppProviderManager.inst().getUpdateVersionCode());     // Catch: Throwable -> L64
        this.mAppInfo.setManifestVersionCode(CronetAppProviderManager.inst().getManifestVersionCode());     // Catch: Throwable -> L64
        this.mAppInfo.setStoreIdc(CronetAppProviderManager.inst().getStoreIdc());     // Catch: Throwable -> L64
        this.mAppInfo.setRegion(toLowerCase(CronetAppProviderManager.inst().getRegion()));     // Catch: Throwable -> L64
        this.mAppInfo.setSysRegion(toLowerCase(CronetAppProviderManager.inst().getSysRegion()));     // Catch: Throwable -> L64
        this.mAppInfo.setCarrierRegion(toLowerCase(CronetAppProviderManager.inst().getCarrierRegion()));     // Catch: Throwable -> L64
        this.mAppInfo.setInitRegion(CronetAppProviderManager.inst().getInitRegion());     // Catch: Throwable -> L64
        this.mAppInfo.setTNCRequestFlags(CronetAppProviderManager.inst().getTNCRequestFlags());     // Catch: Throwable -> L64
        this.mAppInfo.setHttpDnsRequestFlags(CronetAppProviderManager.inst().getHttpDnsRequestFlags());     // Catch: Throwable -> L64
        TTAppInfoProvider.AppInfo r0 = this.mAppInfo;     // Catch: Throwable -> L64
        if (StoreRegionManager.isDomesticStoreRegion() == false) goto L11;
        String r1 = "1";
    L12:
        r0.setIsDomestic(r1);     // Catch: Throwable -> L64
        Map<String, String> r2 = CronetAppProviderManager.inst().getGetDomainDependHostMap();     // Catch: Throwable -> L64
        if (r2 != null) goto L15;
    L17:
        Map<String, String> r3 = CronetAppProviderManager.inst().getTNCRequestHeader();     // Catch: Throwable -> L64
        String r4 = "";
        if (r3 != null) goto L20;
    L25:
        String r5 = "";
        if (r2 == null) goto L31;
        if (r2.isEmpty() == true) goto L31;
        r5 = getCookieHeaderForTncRequest(r2.get("first"));     // Catch: Throwable -> L64
    L31:
        if (TextUtils.isEmpty(r5) == true) goto L33;
        r4 = "Cookie:" + r5 + IOUtils.LINE_SEPARATOR_WINDOWS + r4;     // Catch: Throwable -> L64
    L33:
        this.mAppInfo.setTNCRequestHeader(r4);     // Catch: Throwable -> L64
        Map<String, String> r6 = CronetAppProviderManager.inst().getTNCRequestQuery();     // Catch: Throwable -> L64
        String r7 = "";
        if (r6 != null) goto L36;
    L41:
        this.mAppInfo.setTNCRequestQuery(r7);     // Catch: Throwable -> L64
        List<String> r8 = CronetAppProviderManager.inst().getAbSdkVersion();     // Catch: Throwable -> L64
        String r9 = "";
        if (r8 != null) goto L44;
    L57:
        this.mAppInfo.setAbSdkVersion(r9);     // Catch: Throwable -> L64
        if (CronetDependManager.inst().loggerDebug() == false) goto L67;
        CronetDependManager.inst().loggerD("CronetAppInfoProvider", "get appinfo = " + ("AppInfo{, mUserId='" + this.mAppInfo.getUserId() + "', mAppId='" + this.mAppInfo.getAppId() + "', mOSApi='" + this.mAppInfo.getOSApi() + "', mDeviceId='" + this.mAppInfo.getDeviceId() + "', mNetAccessType='" + this.mAppInfo.getNetAccessType() + "', mVersionCode='" + this.mAppInfo.getVersionCode() + "', mDeviceType='" + this.mAppInfo.getDeviceType() + "', mAppName='" + this.mAppInfo.getAppName() + "', mSdkAppID='" + this.mAppInfo.getSdkAppID() + "', mSdkVersion='" + this.mAppInfo.getSdkVersion() + "', mChannel='" + this.mAppInfo.getChannel() + "', mOSVersion='" + this.mAppInfo.getOSVersion() + "', mAbi='" + this.mAppInfo.getAbi() + "', mDevicePlatform='" + this.mAppInfo.getDevicePlatform() + "', mDeviceBrand='" + this.mAppInfo.getDeviceBrand() + "', mDeviceModel='" + this.mAppInfo.getDeviceModel() + "', mVersionName='" + this.mAppInfo.getVersionName() + "', mUpdateVersionCode='" + this.mAppInfo.getUpdateVersionCode() + "', mManifestVersionCode='" + this.mAppInfo.getManifestVersionCode() + "'}"));     // Catch: Throwable -> L64
    L67:
        return this.mAppInfo;
    L44:
        if (r8.size() > 5) goto L46;
    L48:
        Iterator<String> r10 = r8.iterator();     // Catch: Throwable -> L64
        int r11 = 0;
    L50:
        if (r10.hasNext() == false) goto L57;
        String r12 = r10.next();     // Catch: Throwable -> L64
        r11 = r11 + 1;     // Catch: Throwable -> L64
        if (r11 > 5) goto L57;
        if (TextUtils.isEmpty(r12) == true) goto L50;
        r9 = r9 + r12 + ",";     // Catch: Throwable -> L64
        goto L50
    L46:
        if (CronetDependManager.inst().loggerDebug() == false) goto L48;
        CronetDependManager.inst().loggerD("CronetAppInfoProvider", "ab sdk version count must less than 5");     // Catch: Throwable -> L64
        goto L48
    L36:
        if (r6.isEmpty() == true) goto L41;
        Iterator<Map.Entry<String, String>> r13 = r6.entrySet().iterator();     // Catch: Throwable -> L64
    L39:
        if (r13.hasNext() == false) goto L41;
        Map.Entry<String, String> r14 = r13.next();     // Catch: Throwable -> L64
        r7 = r14.getKey() + ":" + r14.getValue() + IOUtils.LINE_SEPARATOR_WINDOWS + r7;     // Catch: Throwable -> L64
        goto L39
    L20:
        if (r3.isEmpty() == true) goto L25;
        Iterator<Map.Entry<String, String>> r15 = r3.entrySet().iterator();     // Catch: Throwable -> L64
    L23:
        if (r15.hasNext() == false) goto L25;
        Map.Entry<String, String> r16 = r15.next();     // Catch: Throwable -> L64
        r4 = r16.getKey() + ":" + r16.getValue() + IOUtils.LINE_SEPARATOR_WINDOWS + r4;     // Catch: Throwable -> L64
        goto L23
    L15:
        if (r2.isEmpty() == true) goto L17;
        this.mAppInfo.setHostFirst(r2.get("first"));     // Catch: Throwable -> L64
        this.mAppInfo.setHostSecond(r2.get("second"));     // Catch: Throwable -> L64
        this.mAppInfo.setHostThird(r2.get("third"));     // Catch: Throwable -> L64
        this.mAppInfo.setDomainHttpDns(r2.get(TTNetInit.DOMAIN_HTTPDNS_KEY));     // Catch: Throwable -> L64
        this.mAppInfo.setDomainBoe(r2.get(TTNetInit.DOMAIN_BOE_KEY));     // Catch: Throwable -> L64
        this.mAppInfo.setDomainBoeHttps(r2.get(TTNetInit.DOMAIN_BOE_HTTPS_KEY));     // Catch: Throwable -> L64
        goto L17
    L11:
        r1 = "0";
        goto L12
    L64:
        th = move-exception;
        th.printStackTrace();
        goto L67
    }
}

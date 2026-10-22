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

/* JADX INFO: loaded from: classes2.dex */
public class CronetAppInfoProvider extends TTAppInfoProvider {
    private static final String COOKIE_HEADER_KEY = "Cookie";
    private static final int MAX_ABSDK_VERSION_LENGTH = 5;
    private static CronetAppInfoProvider sInstance;
    private TTAppInfoProvider.AppInfo mAppInfo;
    private Context mContext;

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

    public static CronetAppInfoProvider inst(Context r2) {
        if (sInstance != null) goto L16;
        monitor-enter(CronetAppInfoProvider.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L11;
        sInstance = new CronetAppInfoProvider(r2);     // Catch: Throwable -> L9
    L11:
        monitor-exit(CronetAppInfoProvider.class);     // Catch: Throwable -> L9
    L16:
        return sInstance;
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
        monitor-enter(CronetAppInfoProvider.class);     // Catch: Throwable -> L13
    L7:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L5:
        if (this.mAppInfo != null) goto L9;
        this.mAppInfo = new TTAppInfoProvider.AppInfo();     // Catch: Throwable -> L7
    L9:
        monitor-exit(CronetAppInfoProvider.class);     // Catch: Throwable -> L7
        this.mAppInfo.setAppId(CronetAppProviderManager.inst().getAppId());     // Catch: Throwable -> L13
        this.mAppInfo.setAppName(CronetAppProviderManager.inst().getAppName());     // Catch: Throwable -> L13
        this.mAppInfo.setSdkAppID(CronetAppProviderManager.inst().getSdkAppId());     // Catch: Throwable -> L13
        this.mAppInfo.setSdkVersion(CronetAppProviderManager.inst().getSdkVersion());     // Catch: Throwable -> L13
        this.mAppInfo.setChannel(CronetAppProviderManager.inst().getChannel());     // Catch: Throwable -> L13
        this.mAppInfo.setDeviceId(CronetAppProviderManager.inst().getDeviceId());     // Catch: Throwable -> L13
        this.mAppInfo.setIsDropFirstTnc(CronetAppProviderManager.inst().getIsDropFirstTnc());     // Catch: Throwable -> L13
        this.mAppInfo.setAbi(CronetAppProviderManager.inst().getAbi());     // Catch: Throwable -> L13
        this.mAppInfo.setDevicePlatform(CronetAppProviderManager.inst().getDevicePlatform());     // Catch: Throwable -> L13
        this.mAppInfo.setDeviceType(CronetAppProviderManager.inst().getDeviceType());     // Catch: Throwable -> L13
        this.mAppInfo.setDeviceBrand(CronetAppProviderManager.inst().getDeviceBrand());     // Catch: Throwable -> L13
        this.mAppInfo.setDeviceModel(CronetAppProviderManager.inst().getDeviceModel());     // Catch: Throwable -> L13
        this.mAppInfo.setNetAccessType(CronetAppProviderManager.inst().getNetAccessType());     // Catch: Throwable -> L13
        this.mAppInfo.setOSApi(CronetAppProviderManager.inst().getOSApi());     // Catch: Throwable -> L13
        this.mAppInfo.setOSVersion(CronetAppProviderManager.inst().getOSVersion());     // Catch: Throwable -> L13
        this.mAppInfo.setUserId(CronetAppProviderManager.inst().getUserId());     // Catch: Throwable -> L13
        this.mAppInfo.setVersionCode(CronetAppProviderManager.inst().getVersionCode());     // Catch: Throwable -> L13
        this.mAppInfo.setVersionName(CronetAppProviderManager.inst().getVersionName());     // Catch: Throwable -> L13
        this.mAppInfo.setUpdateVersionCode(CronetAppProviderManager.inst().getUpdateVersionCode());     // Catch: Throwable -> L13
        this.mAppInfo.setManifestVersionCode(CronetAppProviderManager.inst().getManifestVersionCode());     // Catch: Throwable -> L13
        this.mAppInfo.setStoreIdc(CronetAppProviderManager.inst().getStoreIdc());     // Catch: Throwable -> L13
        this.mAppInfo.setRegion(toLowerCase(CronetAppProviderManager.inst().getRegion()));     // Catch: Throwable -> L13
        this.mAppInfo.setSysRegion(toLowerCase(CronetAppProviderManager.inst().getSysRegion()));     // Catch: Throwable -> L13
        this.mAppInfo.setCarrierRegion(toLowerCase(CronetAppProviderManager.inst().getCarrierRegion()));     // Catch: Throwable -> L13
        this.mAppInfo.setInitRegion(CronetAppProviderManager.inst().getInitRegion());     // Catch: Throwable -> L13
        this.mAppInfo.setTNCRequestFlags(CronetAppProviderManager.inst().getTNCRequestFlags());     // Catch: Throwable -> L13
        this.mAppInfo.setHttpDnsRequestFlags(CronetAppProviderManager.inst().getHttpDnsRequestFlags());     // Catch: Throwable -> L13
        TTAppInfoProvider.AppInfo r0 = this.mAppInfo;     // Catch: Throwable -> L13
        if (StoreRegionManager.isDomesticStoreRegion() == false) goto L15;
        String r1 = "1";
    L16:
        r0.setIsDomestic(r1);     // Catch: Throwable -> L13
        Map<String, String> r2 = CronetAppProviderManager.inst().getGetDomainDependHostMap();     // Catch: Throwable -> L13
        if (r2 != null) goto L19;
    L21:
        Map<String, String> r3 = CronetAppProviderManager.inst().getTNCRequestHeader();     // Catch: Throwable -> L13
        String r4 = "";
        if (r3 != null) goto L24;
    L29:
        String r5 = "";
        if (r2 == null) goto L35;
        if (r2.isEmpty() == true) goto L35;
        r5 = getCookieHeaderForTncRequest(r2.get("first"));     // Catch: Throwable -> L13
    L35:
        if (TextUtils.isEmpty(r5) == true) goto L37;
        r4 = "Cookie:" + r5 + "\r\n" + r4;     // Catch: Throwable -> L13
    L37:
        this.mAppInfo.setTNCRequestHeader(r4);     // Catch: Throwable -> L13
        Map<String, String> r6 = CronetAppProviderManager.inst().getTNCRequestQuery();     // Catch: Throwable -> L13
        String r7 = "";
        if (r6 != null) goto L40;
    L45:
        this.mAppInfo.setTNCRequestQuery(r7);     // Catch: Throwable -> L13
        List<String> r8 = CronetAppProviderManager.inst().getAbSdkVersion();     // Catch: Throwable -> L13
        String r9 = "";
        if (r8 != null) goto L48;
    L61:
        this.mAppInfo.setAbSdkVersion(r9);     // Catch: Throwable -> L13
        if (CronetDependManager.inst().loggerDebug() == false) goto L69;
        String r10 = "AppInfo{, mUserId='" + this.mAppInfo.getUserId() + "', mAppId='" + this.mAppInfo.getAppId() + "', mOSApi='" + this.mAppInfo.getOSApi() + "', mDeviceId='" + this.mAppInfo.getDeviceId() + "', mNetAccessType='" + this.mAppInfo.getNetAccessType() + "', mVersionCode='" + this.mAppInfo.getVersionCode() + "', mDeviceType='" + this.mAppInfo.getDeviceType() + "', mAppName='" + this.mAppInfo.getAppName() + "', mSdkAppID='" + this.mAppInfo.getSdkAppID() + "', mSdkVersion='" + this.mAppInfo.getSdkVersion() + "', mChannel='" + this.mAppInfo.getChannel() + "', mOSVersion='" + this.mAppInfo.getOSVersion() + "', mAbi='" + this.mAppInfo.getAbi() + "', mDevicePlatform='" + this.mAppInfo.getDevicePlatform() + "', mDeviceBrand='" + this.mAppInfo.getDeviceBrand() + "', mDeviceModel='" + this.mAppInfo.getDeviceModel() + "', mVersionName='" + this.mAppInfo.getVersionName() + "', mUpdateVersionCode='" + this.mAppInfo.getUpdateVersionCode() + "', mManifestVersionCode='" + this.mAppInfo.getManifestVersionCode() + "'}";     // Catch: Throwable -> L13
        CronetDependManager.inst().loggerD("CronetAppInfoProvider", "get appinfo = " + r10);     // Catch: Throwable -> L13
    L69:
        return this.mAppInfo;
    L48:
        if (r8.size() > 5) goto L50;
    L52:
        Iterator<String> r11 = r8.iterator();     // Catch: Throwable -> L13
        int r12 = 0;
    L54:
        if (r11.hasNext() == false) goto L61;
        String r13 = r11.next();     // Catch: Throwable -> L13
        r12 = r12 + 1;     // Catch: Throwable -> L13
        if (r12 > 5) goto L61;
        if (TextUtils.isEmpty(r13) == true) goto L54;
        r9 = r9 + r13 + ",";     // Catch: Throwable -> L13
        goto L54
    L50:
        if (CronetDependManager.inst().loggerDebug() == false) goto L52;
        CronetDependManager.inst().loggerD("CronetAppInfoProvider", "ab sdk version count must less than 5");     // Catch: Throwable -> L13
        goto L52
    L40:
        if (r6.isEmpty() == true) goto L45;
        Iterator<Map.Entry<String, String>> r14 = r6.entrySet().iterator();     // Catch: Throwable -> L13
    L43:
        if (r14.hasNext() == false) goto L45;
        Map.Entry<String, String> r15 = r14.next();     // Catch: Throwable -> L13
        r7 = r15.getKey() + ":" + r15.getValue() + "\r\n" + r7;     // Catch: Throwable -> L13
        goto L43
    L24:
        if (r3.isEmpty() == true) goto L29;
        Iterator<Map.Entry<String, String>> r16 = r3.entrySet().iterator();     // Catch: Throwable -> L13
    L27:
        if (r16.hasNext() == false) goto L29;
        Map.Entry<String, String> r17 = r16.next();     // Catch: Throwable -> L13
        r4 = r17.getKey() + ":" + r17.getValue() + "\r\n" + r4;     // Catch: Throwable -> L13
        goto L27
    L19:
        if (r2.isEmpty() == true) goto L21;
        this.mAppInfo.setHostFirst(r2.get("first"));     // Catch: Throwable -> L13
        this.mAppInfo.setHostSecond(r2.get("second"));     // Catch: Throwable -> L13
        this.mAppInfo.setHostThird(r2.get("third"));     // Catch: Throwable -> L13
        this.mAppInfo.setDomainHttpDns(r2.get("httpdns"));     // Catch: Throwable -> L13
        this.mAppInfo.setDomainBoe(r2.get(TTNetInit.DOMAIN_BOE_KEY));     // Catch: Throwable -> L13
        this.mAppInfo.setDomainBoeHttps(r2.get(TTNetInit.DOMAIN_BOE_HTTPS_KEY));     // Catch: Throwable -> L13
        goto L21
    L15:
        r1 = "0";
        goto L16
    L13:
        th = move-exception;
        th.printStackTrace();
        goto L69
    }
}

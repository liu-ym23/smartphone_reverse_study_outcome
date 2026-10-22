package org.chromium;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.ttnet.TTNetInit;
import com.ttnet.org.chromium.net.TTAppInfoProvider;
import d.b.h.a.a.h.s.j;
import java.net.CookieHandler;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class a extends TTAppInfoProvider {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f22660b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private TTAppInfoProvider.AppInfo f22661a;

    private a(Context r1) {
        r1.getApplicationContext();
    }

    private String a(String r5) {
        CookieHandler r4 = CookieHandler.getDefault();
        if (TextUtils.isEmpty(r5) == true) goto L26;
        if (r4 == null) goto L26;
        Map<String, List<String>> r6 = r4.get(j.a("https://" + r5), null);     // Catch: Throwable -> L27
        if (r6 == null) goto L26;
        if (r6.size() <= 0) goto L26;
        Iterator<Map.Entry<String, List<String>>> r7 = r6.entrySet().iterator();     // Catch: Throwable -> L27
    L12:
        if (r7.hasNext() == false) goto L26;
        Map.Entry<String, List<String>> r8 = r7.next();     // Catch: Throwable -> L27
        if ("Cookie".equalsIgnoreCase(r8.getKey()) == false) goto L12;
        if (r8.getValue().isEmpty() == true) goto L12;
        StringBuilder r9 = new StringBuilder();     // Catch: Throwable -> L27
        int r0 = 0;
        Iterator<String> r10 = r8.getValue().iterator();     // Catch: Throwable -> L27
    L19:
        if (r10.hasNext() == false) goto L24;
        String r2 = r10.next();     // Catch: Throwable -> L27
        if (r0 <= 0) goto L23;
        r9.append("; ");     // Catch: Throwable -> L27
    L23:
        r9.append(r2);     // Catch: Throwable -> L27
        r0 = r0 + 1;     // Catch: Throwable -> L27
        goto L19
    L24:
        return r9.toString();
    L26:
        return null;
    }

    public static a b(Context r2) {
        if (f22660b != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f22660b != null) goto L9;
        f22660b = new a(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f22660b;
    }

    private static String c(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L6;
        return r1;
    L6:
        return r1.toLowerCase();
    }

    @Override // com.ttnet.org.chromium.net.TTAppInfoProvider
    public TTAppInfoProvider.AppInfo getAppInfo() {
        monitor-enter(a.class);     // Catch: Throwable -> L64
    L61:
        th = move-exception;
        throw th;     // Catch: Throwable -> L64
    L5:
        if (this.f22661a != null) goto L7;
        this.f22661a = new TTAppInfoProvider.AppInfo();     // Catch: Throwable -> L61
    L7:
        monitor-exit(a.class);     // Catch: Throwable -> L61
        this.f22661a.setAppId(c.W().d());     // Catch: Throwable -> L64
        this.f22661a.setAppName(c.W().e());     // Catch: Throwable -> L64
        this.f22661a.setSdkAppID(c.W().E());     // Catch: Throwable -> L64
        this.f22661a.setSdkVersion(c.W().F());     // Catch: Throwable -> L64
        this.f22661a.setChannel(c.W().i());     // Catch: Throwable -> L64
        this.f22661a.setDeviceId(c.W().m());     // Catch: Throwable -> L64
        this.f22661a.setIsDropFirstTnc(c.W().u());     // Catch: Throwable -> L64
        this.f22661a.setAbi(c.W().c());     // Catch: Throwable -> L64
        this.f22661a.setDevicePlatform(c.W().o());     // Catch: Throwable -> L64
        this.f22661a.setDeviceType(c.W().p());     // Catch: Throwable -> L64
        this.f22661a.setDeviceBrand(c.W().l());     // Catch: Throwable -> L64
        this.f22661a.setDeviceModel(c.W().n());     // Catch: Throwable -> L64
        this.f22661a.setNetAccessType(c.W().w());     // Catch: Throwable -> L64
        this.f22661a.setOSApi(c.W().y());     // Catch: Throwable -> L64
        this.f22661a.setOSVersion(c.W().z());     // Catch: Throwable -> L64
        this.f22661a.setUserId(c.W().P());     // Catch: Throwable -> L64
        this.f22661a.setVersionCode(c.W().Q());     // Catch: Throwable -> L64
        this.f22661a.setVersionName(c.W().R());     // Catch: Throwable -> L64
        this.f22661a.setUpdateVersionCode(c.W().O());     // Catch: Throwable -> L64
        this.f22661a.setManifestVersionCode(c.W().v());     // Catch: Throwable -> L64
        this.f22661a.setStoreIdc(c.W().H());     // Catch: Throwable -> L64
        this.f22661a.setRegion(c(c.W().D()));     // Catch: Throwable -> L64
        this.f22661a.setSysRegion(c(c.W().K()));     // Catch: Throwable -> L64
        this.f22661a.setCarrierRegion(c(c.W().h()));     // Catch: Throwable -> L64
        this.f22661a.setInitRegion(c.W().t());     // Catch: Throwable -> L64
        this.f22661a.setTNCRequestFlags(c.W().L());     // Catch: Throwable -> L64
        this.f22661a.setHttpDnsRequestFlags(c.W().s());     // Catch: Throwable -> L64
        TTAppInfoProvider.AppInfo r0 = this.f22661a;     // Catch: Throwable -> L64
        if (d.b.h.a.a.h.r.b.o() == false) goto L11;
        String r1 = LocationInfoConst.ALLOW_USE_LOCATION;
    L12:
        r0.setIsDomestic(r1);     // Catch: Throwable -> L64
        Map<String, String> r2 = c.W().r();     // Catch: Throwable -> L64
        if (r2 != null) goto L15;
    L17:
        Map<String, String> r3 = c.W().M();     // Catch: Throwable -> L64
        String r4 = "";
        if (r3 != null) goto L20;
    L25:
        String r5 = "";
        if (r2 == null) goto L31;
        if (r2.isEmpty() == true) goto L31;
        r5 = a(r2.get("first"));     // Catch: Throwable -> L64
    L31:
        if (TextUtils.isEmpty(r5) == true) goto L33;
        r4 = "Cookie:" + r5 + "\r\n" + r4;     // Catch: Throwable -> L64
    L33:
        this.f22661a.setTNCRequestHeader(r4);     // Catch: Throwable -> L64
        Map<String, String> r6 = c.W().N();     // Catch: Throwable -> L64
        String r7 = "";
        if (r6 != null) goto L36;
    L41:
        this.f22661a.setTNCRequestQuery(r7);     // Catch: Throwable -> L64
        List<String> r8 = c.W().b();     // Catch: Throwable -> L64
        String r9 = "";
        if (r8 != null) goto L44;
    L57:
        this.f22661a.setAbSdkVersion(r9);     // Catch: Throwable -> L64
        if (d.a().loggerDebug() == false) goto L67;
        String r10 = "AppInfo{, mUserId='" + this.f22661a.getUserId() + "', mAppId='" + this.f22661a.getAppId() + "', mOSApi='" + this.f22661a.getOSApi() + "', mDeviceId='" + this.f22661a.getDeviceId() + "', mNetAccessType='" + this.f22661a.getNetAccessType() + "', mVersionCode='" + this.f22661a.getVersionCode() + "', mDeviceType='" + this.f22661a.getDeviceType() + "', mAppName='" + this.f22661a.getAppName() + "', mSdkAppID='" + this.f22661a.getSdkAppID() + "', mSdkVersion='" + this.f22661a.getSdkVersion() + "', mChannel='" + this.f22661a.getChannel() + "', mOSVersion='" + this.f22661a.getOSVersion() + "', mAbi='" + this.f22661a.getAbi() + "', mDevicePlatform='" + this.f22661a.getDevicePlatform() + "', mDeviceBrand='" + this.f22661a.getDeviceBrand() + "', mDeviceModel='" + this.f22661a.getDeviceModel() + "', mVersionName='" + this.f22661a.getVersionName() + "', mUpdateVersionCode='" + this.f22661a.getUpdateVersionCode() + "', mManifestVersionCode='" + this.f22661a.getManifestVersionCode() + "'}";     // Catch: Throwable -> L64
        d.a().loggerD("CronetAppInfoProvider", "get appinfo = " + r10);     // Catch: Throwable -> L64
    L67:
        return this.f22661a;
    L44:
        if (r8.size() > 5) goto L46;
    L48:
        int r11 = 0;
        Iterator<String> r12 = r8.iterator();     // Catch: Throwable -> L64
    L50:
        if (r12.hasNext() == false) goto L57;
        String r13 = r12.next();     // Catch: Throwable -> L64
        r11 = r11 + 1;     // Catch: Throwable -> L64
        if (r11 > 5) goto L57;
        if (TextUtils.isEmpty(r13) == true) goto L50;
        r9 = r9 + r13 + ",";     // Catch: Throwable -> L64
        goto L50
    L46:
        if (d.a().loggerDebug() == false) goto L48;
        d.a().loggerD("CronetAppInfoProvider", "ab sdk version count must less than 5");     // Catch: Throwable -> L64
        goto L48
    L36:
        if (r6.isEmpty() == true) goto L41;
        Iterator<Map.Entry<String, String>> r14 = r6.entrySet().iterator();     // Catch: Throwable -> L64
    L39:
        if (r14.hasNext() == false) goto L41;
        Map.Entry<String, String> r15 = r14.next();     // Catch: Throwable -> L64
        r7 = r15.getKey() + ":" + r15.getValue() + "\r\n" + r7;     // Catch: Throwable -> L64
        goto L39
    L20:
        if (r3.isEmpty() == true) goto L25;
        Iterator<Map.Entry<String, String>> r16 = r3.entrySet().iterator();     // Catch: Throwable -> L64
    L23:
        if (r16.hasNext() == false) goto L25;
        Map.Entry<String, String> r17 = r16.next();     // Catch: Throwable -> L64
        r4 = r17.getKey() + ":" + r17.getValue() + "\r\n" + r4;     // Catch: Throwable -> L64
        goto L23
    L15:
        if (r2.isEmpty() == true) goto L17;
        this.f22661a.setHostFirst(r2.get("first"));     // Catch: Throwable -> L64
        this.f22661a.setHostSecond(r2.get("second"));     // Catch: Throwable -> L64
        this.f22661a.setHostThird(r2.get("third"));     // Catch: Throwable -> L64
        this.f22661a.setDomainHttpDns(r2.get(TTNetInit.DOMAIN_HTTPDNS_KEY));     // Catch: Throwable -> L64
        this.f22661a.setDomainBoe(r2.get(TTNetInit.DOMAIN_BOE_KEY));     // Catch: Throwable -> L64
        this.f22661a.setDomainBoeHttps(r2.get(TTNetInit.DOMAIN_BOE_HTTPS_KEY));     // Catch: Throwable -> L64
        goto L17
    L11:
        r1 = BDLocationException.ERROR_TIMEOUT;
        goto L12
    L64:
        th = move-exception;
        th.printStackTrace();
        goto L67
    }
}

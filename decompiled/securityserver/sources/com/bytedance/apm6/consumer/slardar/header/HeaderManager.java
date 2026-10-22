package com.bytedance.apm6.consumer.slardar.header;

import android.os.Build;
import android.text.TextUtils;
import com.bytedance.apm.listener.INtpTimeService;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.consumer.slardar.SlardarProperties;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.foundation.context.ApmContextAdapter;
import com.bytedance.apm6.util.ApmBaseContext;
import com.bytedance.apm6.util.JsonUtils;
import com.bytedance.apm6.util.RomUtils;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.apm6.util.timetask.AsyncTask;
import com.bytedance.apm6.util.timetask.AsyncTaskManager;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class HeaderManager {
    private static volatile HeaderManager sInstance;
    private HeaderInfo currentHeaderInfo;
    private Map<String, HeaderInfo> headers;
    private long nptOffset;
    private long nptTime;
    private AsyncTask ntpAsyncTask;

    public HeaderManager() {
        this.headers = new ConcurrentHashMap();
        this.nptOffset = -1;
        this.nptTime = -1;
    }

    public static /* synthetic */ long access$002(HeaderManager r0, long r1) {
        r0.nptTime = r1;
        return r1;
    }

    public static /* synthetic */ long access$102(HeaderManager r0, long r1) {
        r0.nptOffset = r1;
        return r1;
    }

    public static /* synthetic */ AsyncTask access$200(HeaderManager r0) {
        return r0.ntpAsyncTask;
    }

    public static /* synthetic */ AsyncTask access$202(HeaderManager r0, AsyncTask r1) {
        r0.ntpAsyncTask = r1;
        return r1;
    }

    public static HeaderManager getInstance() {
        if (sInstance != null) goto L16;
        monitor-enter(HeaderManager.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L11;
        sInstance = new HeaderManager();     // Catch: Throwable -> L9
    L11:
        monitor-exit(HeaderManager.class);     // Catch: Throwable -> L9
    L16:
        return sInstance;
    }

    private void saveHeaderInfo(HeaderInfo r3) {
        String r0 = String.valueOf(HeaderUtils.getUniqueHeaderId());
        this.headers.put(r0, r3);
        this.currentHeaderInfo = r3;
        HeaderStoreManager.getInstance().saveHeaderInfo(r0, r3);
    }

    private void updateHeaderInfo(HeaderInfo r5) {
        if (r5 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r5.getDeviceId()) == false) goto L7;
        r5.setDeviceId(ApmContext.getDeviceId());
    L7:
        ApmContextAdapter r0 = ApmContext.getApmContextAdapter();
        if (r0 == null) goto L10;
        r5.setDynamicExtra(r0.getDynamicHeaderExtras());
    L10:
        long r1 = this.nptTime;
        if (r1 == (-1)) goto L13;
        r5.setNtpTime(r1);
        r5.setNtpOffset(this.nptOffset);
    L26:
        if (ApmBaseContext.isDebugMode() == false) goto L28;
        Logger.d(Constants.TAG, "nptTime:" + this.nptTime + " nptOffset:" + this.nptOffset);
    L28:
        r5.setUid(ApmContext.getUserID());
        r5.setConfigTime(ApmContext.getConfigTime());
        HeaderInfo r4 = this.currentHeaderInfo;
        if (r4 == null) goto L34;
        r5.setCurrentUpdateVersionCode(r4.getUpdateVersionCode());
        return;
    L34:
        return;
    L13:
        final INtpTimeService r2 = ApmContext.getNtpTimeService();
        if (r2 == null) goto L26;
        if (this.ntpAsyncTask != null) goto L26;
        monitor-enter(HeaderManager.class);
        this.ntpAsyncTask = new AnonymousClass1(this, r2);     // Catch: Throwable -> L22
        AsyncTaskManager.getInstance(AsyncTaskManagerType.LIGHT_WEIGHT).sendTask(this.ntpAsyncTask);     // Catch: Throwable -> L22
        monitor-exit(HeaderManager.class);     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    }

    public HeaderInfo getHeaderInfo(String r3) {
        if (this.headers.containsKey(r3) == false) goto L5;
        HeaderInfo r4 = this.headers.get(r3);
    L8:
        updateHeaderInfo(r4);
        return r4;
    L5:
        HeaderInfo r0 = HeaderStoreManager.getInstance().getHeaderInfo(r3);
        if (r0 == null) goto L11;
        this.headers.put(r3, r0);
        r4 = r0;
        goto L8
    L11:
        return this.currentHeaderInfo;
    }

    public void init() {
        HeaderInfo r5 = new HeaderInfo();
        r5.setOs("Android");
        r5.setDevicePlatform("android");
        r5.setOsVersion(Build.VERSION.RELEASE);
        r5.setApiVersion(Build.VERSION.SDK_INT);
        r5.setDeviceModel(Build.MODEL);
        r5.setDeviceBrand(Build.BRAND);
        r5.setDeviceManufacturer(Build.MANUFACTURER);
        r5.setProcessName(ApmContext.getCurrentProcessName());
        r5.setSid(ApmContext.getStartId());
        r5.setRomVersion(RomUtils.getRomInfo());
        r5.setVerifyInfo(SlardarProperties.getReleaseBuild());
        r5.setPhoneStartTime(ApmContext.getInitTimeStamp());
        r5.setChannel(ApmContext.getChannel());
        r5.setAid(ApmContext.getAid());
        r5.setUid(ApmContext.getUserID());
        r5.setUpdateVersionCode(String.valueOf(ApmContext.getUpdateVersionCode()));
        r5.setVersionName(ApmContext.getVersionName());
        r5.setVersionCode(String.valueOf(ApmContext.getVersionCode()));
        r5.setAppVersion(ApmContext.getAppVersion());
        r5.setReleaseBuild(ApmContext.getReleaseBuild());
        r5.setPackageName(ApmBaseContext.getContext().getPackageName());
        r5.setCurrentUpdateVersionCode(r5.getUpdateVersionCode());
        r5.setManifestVersionCode(ApmContext.getManifestVersionCode());
        r5.setConfigTime(ApmContext.getConfigTime());
        JSONObject r6 = new JSONObject();
        JsonUtils.copyJson2(r6, ApmContext.getStableHeaderExtras());     // Catch: Exception -> L6
        if (r6.has("version_code") == false) goto L9;
        r6.remove("version_code");     // Catch: Exception -> L6
    L9:
        if (r6.has("app_version") == false) goto L12;
        r6.remove("app_version");     // Catch: Exception -> L6
    L12:
        if (r6.has("uid") == false) goto L15;
        r6.remove("uid");     // Catch: Exception -> L6
    L15:
        if (r6.has("update_version_code") == false) goto L18;
        r6.remove("update_version_code");     // Catch: Exception -> L6
    L18:
        if (r6.has("manifest_version_code") == false) goto L22;
        r6.remove("manifest_version_code");     // Catch: Exception -> L6
    L22:
        r5.setStableExtra(r6);
        r5.setMonitorVersion("5.0.21.5");
        if (ApmContext.isMainProcess() == false) goto L25;
        HeaderStoreManager.getInstance().deleteExpireFile();
    L25:
        saveHeaderInfo(r5);
        return;
    L6:
        e = move-exception;
        Logger.e("APM", "header json exception" + e.toString());
        goto L22
    }
}

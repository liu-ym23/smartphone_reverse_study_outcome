package com.bytedance.bdinstall;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import com.android.settings.SettingsTracker;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.bdinstall.appstate.AppStateListener;
import com.bytedance.bdinstall.callback.RegisterResultListener;
import com.bytedance.bdinstall.loader.DeviceManager;
import com.bytedance.bdinstall.service.IInstallParameters;
import com.bytedance.bdinstall.service.ServiceManager;
import com.bytedance.bdinstall.util.EventUtils;
import com.bytedance.bdinstall.util.RequestIdGenerator;
import com.bytedance.sremlib.LibUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
class Register extends BaseWorker {
    private static final int REFRESH_BG = 43200000;
    private static final int REFRESH_UI = 21600000;
    static final long[] RETRY_DIFF = null;
    private static final long[] RETRY_EMPTY = null;
    private static final long[] RETRY_SAME = null;
    private final AppStateListener mAppStateListener;
    private final InstallOptions mConfig;
    private final Env mEnv;
    private final DeviceManager mManager;
    private final RegisterResultListener mRegisterResultListener;
    private final IInstallParameters provider;

    @Override // com.bytedance.bdinstall.BaseWorker
    protected String getName() {
        return "r";
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    public boolean needListenNetChange() {
        return true;
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    protected boolean needNet() {
        return true;
    }

    static {
        RETRY_DIFF = new long[]{10000, 30000, 60000, 120000, 120000, 120000, 180000, 180000};
        RETRY_SAME = new long[]{180000, 360000, 540000, 540000, 900000, 1800000};
        RETRY_EMPTY = new long[]{100, 15000, TraceStatsConsts.PAGE_LOAD_MAX_LIMIT_MS, TraceStatsConsts.PAGE_LOAD_MAX_LIMIT_MS, 60000, 60000, 180000, 180000, 540000, 540000};
    }

    Register(InstallOptions r4, DeviceManager r5, Env r6, AppStateListener r7) {
        super(r4.getContext(), getLastRegisterTime(r4.getContext(), r5, r6));
        this.mManager = r5;
        this.mConfig = r4;
        this.mAppStateListener = r7;
        this.mEnv = r6;
        this.mRegisterResultListener = r5;
        this.provider = (IInstallParameters) ServiceManager.getService(IInstallParameters.class);
    }

    private static long getLastRegisterTime(Context r5, DeviceManager r6, Env r7) {
        SharedPreferences r8 = r7.getEnvIsolateSp(r5);
        long r2 = r8.getLong(Api.KEY_REGISTER_TIME, 0);
        InstallInfo r9 = r6.getInstallInfo();
        if (r9 == null) goto L9;
        if (Utils.checkId(r9.getDid()) == false) goto L9;
        if (Utils.checkId(r9.getIid()) == false) goto L9;
    L12:
        return r2;
    L9:
        if (r2 == 0) goto L12;
        r8.edit().putLong(Api.KEY_REGISTER_TIME, 0).apply();
        return 0;
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    protected long nextInterval() {
        if (this.mAppStateListener.isForeground() == false) goto L5;
        return LibUtil.DEFAULT_LIVETIME_SUBMIT_INTERVAL;
    L5:
        return SettingsTracker.PERIOD_UPLOAD_TRACK;
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    protected long[] getRetryIntervals() {
        int r1 = this.mManager.getRegisterState();
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L14;
        DrLog.ysnp(null);
        return RETRY_SAME;
    L14:
        return RETRY_DIFF;
    L15:
        return RETRY_SAME;
    L12:
        return RETRY_EMPTY;
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    protected boolean doWork() throws JSONException {
        DrLog.d("Register#doRegister");
        JSONObject r0 = doRequest();
        DrLog.d("Register#doRegister result = " + r0);
        if (r0 == null) goto L8;
        boolean r1 = this.mRegisterResultListener.onRegisterResult(r0, this.mEnv, this.provider);
        if (r1 == false) goto L7;
        doSaveRequestTime(System.currentTimeMillis());
    L7:
        return r1;
    L8:
        return false;
    }

    private void doSaveRequestTime(long r2) {
        this.mEnv.getEnvIsolateSp(this.mApp).edit().putLong(Api.KEY_REGISTER_TIME, r2).apply();
    }

    protected JSONObject doRequest() throws JSONException {
        JSONObject r0 = buildHeader();
        if (r0 != null) goto L5;
        return null;
    L5:
        JSONObject r4 = new JSONObject();
        r4.put("header", r0);
        r4.put(Api.KEY_MAGIC, Api.MSG_MAGIC);
        r4.put("_gen_time", System.currentTimeMillis());
        DrLog.d("register request header = " + r4);
        String r3 = Uri.parse(this.mEnv.getConfig().getRegisterUri()).buildUpon().appendQueryParameter("req_id", RequestIdGenerator.getRequestId()).build().toString();
        InstallWaitingLock.setRequestingRegister(true);
        if (TextUtils.isEmpty(r0.optString("device_id")) == false) goto L8;
    L10:
        boolean r7 = false;
    L17:
        JSONObject r1 = Api.register(this.mConfig.getNetworkClient(), r3, r4, this.mConfig.encryptAndCompress(), this.mConfig.getEncryptor(), r7);     // Catch: Throwable -> L14
        InstallWaitingLock.setRequestingRegister(false);
        EventUtils.onDidFetchResult(this.mConfig, r0, r1);
        return r1;
    L14:
        th = move-exception;
        InstallWaitingLock.setRequestingRegister(false);
        EventUtils.onDidFetchResult(this.mConfig, r0, null);
        throw th;
    L8:
        if (TextUtils.isEmpty(r0.optString(Api.KEY_INSTALL_ID)) == true) goto L10;
        r7 = true;
        goto L17
    }

    JSONObject buildHeader() {
        JSONObject r0 = this.mManager.getConstHeader();
        JSONObject r1 = new JSONObject();
        Utils.copy(r1, r0);
        this.mManager.updateDrSpecialHeader(r1, this.mEnv);
        return r1;
    }
}

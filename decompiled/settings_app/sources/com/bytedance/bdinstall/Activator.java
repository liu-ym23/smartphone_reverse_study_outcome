package com.bytedance.bdinstall;

import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.android.settings.MultiSimAdapter;
import com.bytedance.bdinstall.intf.IAppTraitCallback;
import com.bytedance.bdinstall.util.RequestIdGenerator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TimeZone;

/* JADX INFO: loaded from: classes3.dex */
class Activator extends BaseWorker {
    private static boolean sHasSucceed = false;
    private final InstallOptions mConfig;
    private final Env mEnv;

    static {
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    protected String getName() {
        return "ac";
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    public boolean needListenNetChange() {
        return true;
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    protected boolean needNet() {
        return true;
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    protected long nextInterval() {
        return 0;
    }

    Activator(InstallOptions r2, Env r3) {
        super(r2.getContext());
        this.mConfig = r2;
        this.mEnv = r3;
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    protected long[] getRetryIntervals() {
        return Register.RETRY_DIFF;
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    protected boolean doWork() {
        String r0 = buildUri();
        InstallWaitingLock.setRequestingActive(true);     // Catch: Throwable -> L10
        boolean r1 = Api.active(this.mConfig.getNetworkClient(), r0, this.mConfig.encryptAndCompress(), this.mConfig.getEncryptor(), sHasSucceed);     // Catch: Throwable -> L10
        if (r1 == false) goto L6;
        sHasSucceed = true;     // Catch: Throwable -> L10
    L6:
        InstallWaitingLock.setRequestingActive(false);
        if (r1 == false) goto L9;
        stop();
    L9:
        return r1;
    L10:
        th = move-exception;
        InstallWaitingLock.setRequestingActive(false);
        throw th;
    }

    private String buildUri() {
        StringBuilder r1 = new StringBuilder(ApiParamsUtil.appendNetParams(this.mApp, new StringBuilder(this.mEnv.getConfig().getActiveUri()), null, true, Level.L0));
        float r0 = getTimeZoneOffset();     // Catch: Throwable -> L23
        Api.addParams(r1, "req_id", RequestIdGenerator.getRequestId());     // Catch: Throwable -> L23
        IAppTraitCallback r2 = this.mConfig.getAppTraitCallback();     // Catch: Throwable -> L23
        if (r2 == null) goto L6;
        Api.addParams(r1, "app_trait", r2.get(this.mConfig.getContext()));     // Catch: Throwable -> L23
    L6:
        Api.addParams(r1, Api.KEY_TIMEZONE, r0 + "");     // Catch: Throwable -> L23
        String r3 = this.mConfig.getZijiePackage();     // Catch: Throwable -> L23
        if (TextUtils.isEmpty(r3) == true) goto L26;
        Api.addParams(r1, "package", r3);     // Catch: Throwable -> L23
        Api.addParams(r1, Api.KEY_REAL_PACKAGE_NAME, this.mApp.getPackageName());     // Catch: Throwable -> L23
    L26:
        TelephonyManager r4 = (TelephonyManager) this.mApp.getSystemService(MultiSimAdapter.PHONE_KEY);     // Catch: Exception -> L11 Throwable -> L23
        Api.addParams(r1, Api.KEY_CARRIER, r4.getNetworkOperatorName());     // Catch: Exception -> L11 Throwable -> L23
        Api.addParams(r1, Api.KEY_MCC_MNC, r4.getNetworkOperator());     // Catch: Exception -> L11 Throwable -> L23
        Api.addParams(r1, Api.KEY_SIM_REGION, r4.getSimCountryIso());     // Catch: Exception -> L11 Throwable -> L23
    L13:
        ApiParamsForFlavor.addActiveParams(this.mApp, this.mConfig, r1);     // Catch: Throwable -> L23
        Api.addParams(r1, Api.KEY_APP_VERSION_MINOR, this.mConfig.getVersionMinor());     // Catch: Throwable -> L23
        Api.addParams(r1, "custom_bt", String.valueOf(getBootTime()));     // Catch: Throwable -> L23
        IExtraParams r5 = this.mConfig.getActiveParam();     // Catch: Throwable -> L23
        if (r5 == null) goto L21;
        HashMap<String, String> r6 = r5.getExtraParams(Level.L0);     // Catch: Throwable -> L23
        if (r6 == null) goto L21;
        Iterator<Map.Entry<String, String>> r7 = r6.entrySet().iterator();     // Catch: Throwable -> L23
    L19:
        if (r7.hasNext() == false) goto L21;
        Map.Entry<String, String> r8 = r7.next();     // Catch: Throwable -> L23
        Api.addParams(r1, r8.getKey(), r8.getValue());     // Catch: Throwable -> L23
    L21:
        return r1.toString();
    L11:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        DrLog.ysnp(th);
        return r1.toString();
    }

    private long getBootTime() {
        return System.currentTimeMillis() - SystemClock.elapsedRealtime();
    }

    private float getTimeZoneOffset() {
        float r2 = (TimeZone.getDefault().getRawOffset() * 1.0f) / 3600000.0f;
        if (r2 >= (-12.0f)) goto L6;
        r2 = -12.0f;
    L6:
        if (r2 > 12.0f) goto L8;
        return r2;
    L8:
        return 12.0f;
    }
}

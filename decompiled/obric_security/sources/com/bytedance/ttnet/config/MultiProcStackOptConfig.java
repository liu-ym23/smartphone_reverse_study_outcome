package com.bytedance.ttnet.config;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.frameworks.baselib.network.http.cronet.TTNetThreadConfig;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient;
import com.bytedance.frameworks.baselib.network.http.util.ProcessUtils;
import com.bytedance.keva.Keva;
import com.bytedance.keva.KevaBuilder;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class MultiProcStackOptConfig implements SsCronetHttpClient.ICronetThreadStackOptFailureChecker {
    static final long DEFAULT_STACK_OPT_FALLBACK_FIX_INTERVAL_SECONDS = 10800;
    static final String KEVA_STACK_CONFIG_REPO_KEY = "tt_stack_config";
    static final String KEY_ENABLE_STACK_OPT = "enable_stack_opt";
    static final String KEY_ENABLE_STACK_OPT_FALLBACK_FIX = "enable_stack_opt_fallback_fix";
    static final String KEY_STACK_OPT_FAILURES = "stack_opt_failures";
    static final String KEY_STACK_OPT_FAILURE_TIMESTAMP = "stack_opt_failure_timestamp";
    static final String KEY_STACK_OPT_FALLBACK_FIX_INTERVAL_SECONDS = "stack_opt_fallback_fix_interval_s";
    static final String TAG = "MultiProcStackOptConfig";
    private static volatile MultiProcStackOptConfig mInstance;
    private long mChromiumThreadStackOptFailureTimestamp;
    private volatile int mChromiumThreadStackOptFailures;
    private long mChromiumThreadStackOptFallbackFixIntervalSeconds;
    private Context mContext;
    private boolean mEnableChromiumThreadStackOpt;
    private boolean mEnableThreadStackOptFallbackFix;
    private boolean mHasChecked;
    private boolean mIsCronetThreadStackOptFailureExpected;
    private final boolean mIsMainProcess;
    private Keva mKeva;
    private String mProcessName;
    private TTNetThreadConfig.ThreadStackInitReason mThreadStackInitReason;

    public static MultiProcStackOptConfig inst(Context r2) {
        if (mInstance != null) goto L15;
        monitor-enter(MultiProcStackOptConfig.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L9;
        mInstance = new MultiProcStackOptConfig(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(MultiProcStackOptConfig.class);     // Catch: Throwable -> L11
    L15:
        return mInstance;
    }

    private MultiProcStackOptConfig(Context r5) {
        this.mEnableChromiumThreadStackOpt = false;
        this.mEnableThreadStackOptFallbackFix = true;
        this.mChromiumThreadStackOptFailures = -1;
        this.mChromiumThreadStackOptFailureTimestamp = 0;
        this.mChromiumThreadStackOptFallbackFixIntervalSeconds = DEFAULT_STACK_OPT_FALLBACK_FIX_INTERVAL_SECONDS;
        this.mHasChecked = false;
        this.mIsCronetThreadStackOptFailureExpected = false;
        this.mThreadStackInitReason = TTNetThreadConfig.ThreadStackInitReason.TNC_DISABLED;
        KevaBuilder.getInstance().setContext(r5);
        this.mIsMainProcess = ProcessUtils.isMainProcessByProcessFlag(r5);
        this.mKeva = Keva.getRepo(KEVA_STACK_CONFIG_REPO_KEY, 1);
        this.mContext = r5;
    }

    private String addPrefixToString(String r2) {
        return this.mProcessName + "_" + r2;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient.ICronetThreadStackOptFailureChecker
    public String getThreadStackInitReason() {
        return this.mThreadStackInitReason.toString();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient.ICronetThreadStackOptFailureChecker
    public boolean isCronetThreadStackOptFailureExpected() {
    L31:
        e = move-exception;
        e.printStackTrace();
        this.mThreadStackInitReason = TTNetThreadConfig.ThreadStackInitReason.HAS_EXCEPTION;
        return false;
    L4:
        if (this.mHasChecked == false) goto L7;
        this.mThreadStackInitReason = TTNetThreadConfig.ThreadStackInitReason.CALLED_MULIT_TIMES;     // Catch: Exception -> L31
        return false;
    L7:
        String r3 = ProcessUtils.getCurProcessName(this.mContext);     // Catch: Exception -> L31
        this.mProcessName = r3;     // Catch: Exception -> L31
        if (TextUtils.isEmpty(r3) == false) goto L11;
        this.mThreadStackInitReason = TTNetThreadConfig.ThreadStackInitReason.PROCESS_NAME_NULL;     // Catch: Exception -> L31
        return false;
    L11:
        this.mHasChecked = true;     // Catch: Exception -> L31
        this.mEnableChromiumThreadStackOpt = this.mKeva.getBoolean(KEY_ENABLE_STACK_OPT, false);     // Catch: Exception -> L31
        this.mEnableThreadStackOptFallbackFix = this.mKeva.getBoolean(KEY_ENABLE_STACK_OPT_FALLBACK_FIX, true);     // Catch: Exception -> L31
        this.mChromiumThreadStackOptFallbackFixIntervalSeconds = this.mKeva.getLong(KEY_STACK_OPT_FALLBACK_FIX_INTERVAL_SECONDS, DEFAULT_STACK_OPT_FALLBACK_FIX_INTERVAL_SECONDS);     // Catch: Exception -> L31
        this.mChromiumThreadStackOptFailures = this.mKeva.getInt(addPrefixToString(KEY_STACK_OPT_FAILURES), 0);     // Catch: Exception -> L31
        this.mChromiumThreadStackOptFailureTimestamp = this.mKeva.getLong(addPrefixToString(KEY_STACK_OPT_FAILURE_TIMESTAMP), 0);     // Catch: Exception -> L31
        if (this.mEnableThreadStackOptFallbackFix == false) goto L19;
        if (this.mChromiumThreadStackOptFailures <= 0) goto L19;
        if ((System.currentTimeMillis() - this.mChromiumThreadStackOptFailureTimestamp) <= TimeUnit.SECONDS.toMillis(this.mChromiumThreadStackOptFallbackFixIntervalSeconds)) goto L19;
        this.mThreadStackInitReason = TTNetThreadConfig.ThreadStackInitReason.FALLBACK_FIX;     // Catch: Exception -> L31
        this.mChromiumThreadStackOptFailures = 0;     // Catch: Exception -> L31
    L19:
        if (this.mEnableChromiumThreadStackOpt == false) goto L27;
        if (this.mChromiumThreadStackOptFailures != 0) goto L27;
        this.mKeva.storeInt(addPrefixToString(KEY_STACK_OPT_FAILURES), this.mChromiumThreadStackOptFailures + 1);     // Catch: Exception -> L31
        this.mKeva.storeLong(addPrefixToString(KEY_STACK_OPT_FAILURE_TIMESTAMP), System.currentTimeMillis());     // Catch: Exception -> L31
        this.mIsCronetThreadStackOptFailureExpected = true;     // Catch: Exception -> L31
        if (this.mThreadStackInitReason == TTNetThreadConfig.ThreadStackInitReason.FALLBACK_FIX) goto L25;
        this.mThreadStackInitReason = TTNetThreadConfig.ThreadStackInitReason.OPT_EFFECTIVE;     // Catch: Exception -> L31
    L25:
        return true;
    L27:
        if (this.mEnableChromiumThreadStackOpt == true) goto L29;
        this.mThreadStackInitReason = TTNetThreadConfig.ThreadStackInitReason.TNC_DISABLED;     // Catch: Exception -> L31
    L30:
        return false;
    L29:
        this.mThreadStackInitReason = TTNetThreadConfig.ThreadStackInitReason.CRASH_HAPPENED;     // Catch: Exception -> L31
        goto L30
    }

    public void onTncRequestSucceeded(boolean r3, boolean r4, int r5) {
    L11:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (this.mIsMainProcess == false) goto L6;
        this.mKeva.storeBoolean(KEY_ENABLE_STACK_OPT, r3);     // Catch: Exception -> L11
        this.mKeva.storeBoolean(KEY_ENABLE_STACK_OPT_FALLBACK_FIX, r4);     // Catch: Exception -> L11
        this.mKeva.storeLong(KEY_STACK_OPT_FALLBACK_FIX_INTERVAL_SECONDS, Long.valueOf(r5).longValue());     // Catch: Exception -> L11
    L6:
        if (this.mHasChecked == true) goto L8;
        return;
    L8:
        if (this.mIsCronetThreadStackOptFailureExpected == false) goto L17;
        this.mKeva.storeInt(addPrefixToString(KEY_STACK_OPT_FAILURES), 0);     // Catch: Exception -> L11
        this.mKeva.storeLong(addPrefixToString(KEY_STACK_OPT_FAILURE_TIMESTAMP), 0);     // Catch: Exception -> L11
        return;
    }
}

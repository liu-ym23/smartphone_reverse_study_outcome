package com.bytedance.ttnet.config;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.frameworks.baselib.network.http.cronet.TTNetThreadConfig;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient;
import com.bytedance.frameworks.baselib.network.http.util.ProcessUtils;
import com.bytedance.keva.Keva;
import com.bytedance.keva.KevaBuilder;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
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

    public static MultiProcStackOptConfig inst(Context r2) {
        if (mInstance != null) goto L16;
        monitor-enter(MultiProcStackOptConfig.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (mInstance != null) goto L11;
        mInstance = new MultiProcStackOptConfig(r2);     // Catch: Throwable -> L9
    L11:
        monitor-exit(MultiProcStackOptConfig.class);     // Catch: Throwable -> L9
    L16:
        return mInstance;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient.ICronetThreadStackOptFailureChecker
    public String getThreadStackInitReason() {
        return this.mThreadStackInitReason.toString();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient.ICronetThreadStackOptFailureChecker
    public boolean isCronetThreadStackOptFailureExpected() {
    L7:
        e = move-exception;
        e.printStackTrace();
        this.mThreadStackInitReason = TTNetThreadConfig.ThreadStackInitReason.HAS_EXCEPTION;
        return false;
    L4:
        if (this.mHasChecked == false) goto L9;
        this.mThreadStackInitReason = TTNetThreadConfig.ThreadStackInitReason.CALLED_MULIT_TIMES;     // Catch: Exception -> L7
        return false;
    L9:
        String r3 = ProcessUtils.getCurProcessName(this.mContext);     // Catch: Exception -> L7
        this.mProcessName = r3;     // Catch: Exception -> L7
        if (TextUtils.isEmpty(r3) == false) goto L13;
        this.mThreadStackInitReason = TTNetThreadConfig.ThreadStackInitReason.PROCESS_NAME_NULL;     // Catch: Exception -> L7
        return false;
    L13:
        this.mHasChecked = true;     // Catch: Exception -> L7
        this.mEnableChromiumThreadStackOpt = this.mKeva.getBoolean(KEY_ENABLE_STACK_OPT, false);     // Catch: Exception -> L7
        this.mEnableThreadStackOptFallbackFix = this.mKeva.getBoolean(KEY_ENABLE_STACK_OPT_FALLBACK_FIX, true);     // Catch: Exception -> L7
        this.mChromiumThreadStackOptFallbackFixIntervalSeconds = this.mKeva.getLong(KEY_STACK_OPT_FALLBACK_FIX_INTERVAL_SECONDS, DEFAULT_STACK_OPT_FALLBACK_FIX_INTERVAL_SECONDS);     // Catch: Exception -> L7
        this.mChromiumThreadStackOptFailures = this.mKeva.getInt(addPrefixToString(KEY_STACK_OPT_FAILURES), 0);     // Catch: Exception -> L7
        this.mChromiumThreadStackOptFailureTimestamp = this.mKeva.getLong(addPrefixToString(KEY_STACK_OPT_FAILURE_TIMESTAMP), 0);     // Catch: Exception -> L7
        if (this.mEnableThreadStackOptFallbackFix == false) goto L21;
        if (this.mChromiumThreadStackOptFailures <= 0) goto L21;
        if ((System.currentTimeMillis() - this.mChromiumThreadStackOptFailureTimestamp) <= TimeUnit.SECONDS.toMillis(this.mChromiumThreadStackOptFallbackFixIntervalSeconds)) goto L21;
        this.mThreadStackInitReason = TTNetThreadConfig.ThreadStackInitReason.FALLBACK_FIX;     // Catch: Exception -> L7
        this.mChromiumThreadStackOptFailures = 0;     // Catch: Exception -> L7
    L21:
        if (this.mEnableChromiumThreadStackOpt == false) goto L29;
        if (this.mChromiumThreadStackOptFailures != 0) goto L29;
        this.mKeva.storeInt(addPrefixToString(KEY_STACK_OPT_FAILURES), this.mChromiumThreadStackOptFailures + 1);     // Catch: Exception -> L7
        this.mKeva.storeLong(addPrefixToString(KEY_STACK_OPT_FAILURE_TIMESTAMP), System.currentTimeMillis());     // Catch: Exception -> L7
        this.mIsCronetThreadStackOptFailureExpected = true;     // Catch: Exception -> L7
        if (this.mThreadStackInitReason == TTNetThreadConfig.ThreadStackInitReason.FALLBACK_FIX) goto L27;
        this.mThreadStackInitReason = TTNetThreadConfig.ThreadStackInitReason.OPT_EFFECTIVE;     // Catch: Exception -> L7
    L27:
        return true;
    L29:
        if (this.mEnableChromiumThreadStackOpt == true) goto L31;
        this.mThreadStackInitReason = TTNetThreadConfig.ThreadStackInitReason.TNC_DISABLED;     // Catch: Exception -> L7
    L32:
        return false;
    L31:
        this.mThreadStackInitReason = TTNetThreadConfig.ThreadStackInitReason.CRASH_HAPPENED;     // Catch: Exception -> L7
        goto L32
    }

    public void onTncRequestSucceeded(boolean r3, boolean r4, int r5) {
    L5:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (this.mIsMainProcess == false) goto L8;
        this.mKeva.storeBoolean(KEY_ENABLE_STACK_OPT, r3);     // Catch: Exception -> L5
        this.mKeva.storeBoolean(KEY_ENABLE_STACK_OPT_FALLBACK_FIX, r4);     // Catch: Exception -> L5
        this.mKeva.storeLong(KEY_STACK_OPT_FALLBACK_FIX_INTERVAL_SECONDS, r5);     // Catch: Exception -> L5
    L8:
        if (this.mHasChecked == true) goto L10;
        return;
    L10:
        if (this.mIsCronetThreadStackOptFailureExpected == false) goto L18;
        this.mKeva.storeInt(addPrefixToString(KEY_STACK_OPT_FAILURES), 0);     // Catch: Exception -> L5
        this.mKeva.storeLong(addPrefixToString(KEY_STACK_OPT_FAILURE_TIMESTAMP), 0);     // Catch: Exception -> L5
        return;
    }
}

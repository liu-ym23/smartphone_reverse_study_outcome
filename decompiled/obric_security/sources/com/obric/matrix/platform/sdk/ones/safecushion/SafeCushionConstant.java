package com.obric.matrix.platform.sdk.ones.safecushion;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.ss.android.message.log.PushLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SafeCushionConstant.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00042\b\u0010*\u001a\u0004\u0018\u00010+R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0015X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/safecushion/SafeCushionConstant;", "", "()V", "CRASH_INFO_FILE_NAME_PREFIX", "", "DIR_NAME", "ENABLE_LOG", "", "FINISH_STATE", "INIT_STATE", "KEY_CRASH_COUNT", "KEY_CRASH_HASH", "KEY_CRASH_INFO_FILE_NAME", "KEY_CRASH_MSG", "KEY_CRASH_TYPE", "KEY_SAFE_MODE_FAIL_NAME", "KEY_SUPPOSE_CRASH_FILE_NAME", "KEY_THREAD", "KEY_TIMESTAMP", "LAUNCH_CRASH", "MINE_LAUNCH_INTERVAL", "", "MIN_SAFE_MODE_CRASH_COUNT", "MIN_SUPPOSE_CRASH_COUNT", "MMY_NORMAL_START_FILE_NAME_PREFIX", "NETWORK_UNAVAILABLE_TIPS", "NORMAL_DIR_NAME", "NPTH_NORMAL_INIT_FILE_NAME_PREFIX", "REPAIR_MODE", "SAFE_CUSHION_REPAIR_THREAD", "SAFE_MODE_FLAG_FILE_NAME_PREFIX", "START_SAFE_MODE_FLAG_FILE_NAME_PREFIX", "START_SAFE_MODE_PROCESS_FILE_NAME_PREFIX", "START_UP_CRASH", "SUPPOSE_CRASH_FILE_NAME_LENGTH", "SUPPOSE_CRASH_FILE_NAME_PREFIX", "TEMP_CRASH_INFO_FILE_NAME_PREFIX", "UPGRADE_MODE", "logd", "", PushLog.KEY_TAG, NotificationCompat.CATEGORY_MESSAGE, "tr", "", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SafeCushionConstant {
    public static final String CRASH_INFO_FILE_NAME_PREFIX = "crashInfo";
    public static final String DIR_NAME = "safeCushionCrashInfo";
    private static final boolean ENABLE_LOG = true;
    public static final String FINISH_STATE = "finish";
    public static final String INIT_STATE = "init";
    public static final SafeCushionConstant INSTANCE = null;
    public static final String KEY_CRASH_COUNT = "crash_count";
    public static final String KEY_CRASH_HASH = "crash_hash";
    public static final String KEY_CRASH_INFO_FILE_NAME = "crash_info_file_name";
    public static final String KEY_CRASH_MSG = "crash_msg";
    public static final String KEY_CRASH_TYPE = "crash_type";
    public static final String KEY_SAFE_MODE_FAIL_NAME = "safe_mode_file_name";
    public static final String KEY_SUPPOSE_CRASH_FILE_NAME = "suppose_crash_file_name";
    public static final String KEY_THREAD = "thread";
    public static final String KEY_TIMESTAMP = "timestamp";
    public static final String LAUNCH_CRASH = "launch";
    public static final int MINE_LAUNCH_INTERVAL = 1000;
    public static final int MIN_SAFE_MODE_CRASH_COUNT = 3;
    public static final int MIN_SUPPOSE_CRASH_COUNT = 4;
    public static final String MMY_NORMAL_START_FILE_NAME_PREFIX = "mmyNormalStart";
    public static final String NETWORK_UNAVAILABLE_TIPS = "当前网络不可用，请检查网络设置后重试";
    public static final String NORMAL_DIR_NAME = "safeCushionNormalInfo";
    public static final String NPTH_NORMAL_INIT_FILE_NAME_PREFIX = "npthNormalInit";
    public static final String REPAIR_MODE = "repair";
    public static final String SAFE_CUSHION_REPAIR_THREAD = "SafeCushionRepairThread";
    public static final String SAFE_MODE_FLAG_FILE_NAME_PREFIX = "safeModeFlag";
    public static final String START_SAFE_MODE_FLAG_FILE_NAME_PREFIX = "startSafeModeFlag";
    public static final String START_SAFE_MODE_PROCESS_FILE_NAME_PREFIX = "startSafeModeProcess";
    public static final String START_UP_CRASH = "StartUp";
    public static final int SUPPOSE_CRASH_FILE_NAME_LENGTH = 3;
    public static final String SUPPOSE_CRASH_FILE_NAME_PREFIX = "supposeCrash";
    public static final String TEMP_CRASH_INFO_FILE_NAME_PREFIX = "tempCrashInfo";
    public static final String UPGRADE_MODE = "upgrade";

    static {
        INSTANCE = new SafeCushionConstant();
    }

    private SafeCushionConstant() {
    }

    public final void logd(String r1, String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r1, PushLog.KEY_TAG);
        Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        Log.d(r1, r2, r3);
    }
}

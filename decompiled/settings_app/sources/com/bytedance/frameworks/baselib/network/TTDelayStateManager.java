package com.bytedance.frameworks.baselib.network;

import com.bytedance.common.utility.Logger;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class TTDelayStateManager {
    private static final String TAG = "TTDelayStateManager";
    private static volatile AppStartState sAppStartState;
    private static final AtomicLong sAppStateChangeTimeSec = null;
    private static final AtomicLong sColdStartDurationSec = null;
    private static final AtomicLong sHotStartDurationSec = null;
    private static final AtomicBoolean sRequestTagDelayEnabled = null;
    private static final AtomicLong sWarmStartDurationSec = null;

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.TTDelayStateManager$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$frameworks$baselib$network$TTDelayStateManager$AppStartState = null;

        static {
            int[] r0 = new int[AppStartState.values().length];
            $SwitchMap$com$bytedance$frameworks$baselib$network$TTDelayStateManager$AppStartState = r0;
            r0[AppStartState.ColdStart.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$bytedance$frameworks$baselib$network$TTDelayStateManager$AppStartState[AppStartState.HotStart.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$bytedance$frameworks$baselib$network$TTDelayStateManager$AppStartState[AppStartState.WarmStart.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public static final enum AppStartState extends Enum<AppStartState> {
        private static final /* synthetic */ AppStartState[] $VALUES = null;
        public static final AppStartState ColdStart = null;
        public static final AppStartState HotStart = null;
        public static final AppStartState NormalStart = null;
        public static final AppStartState WarmStart = null;
        final int state;

        public static AppStartState valueOf(String r1) {
            return (AppStartState) Enum.valueOf(AppStartState.class, r1);
        }

        public static AppStartState[] values() {
            return (AppStartState[]) $VALUES.clone();
        }

        static {
            AppStartState r0 = new AppStartState("NormalStart", 0, -1);
            NormalStart = r0;
            AppStartState r1 = new AppStartState("ColdStart", 1, 0);
            ColdStart = r1;
            AppStartState r2 = new AppStartState("HotStart", 2, 1);
            HotStart = r2;
            AppStartState r5 = new AppStartState("WarmStart", 3, 2);
            WarmStart = r5;
            $VALUES = new AppStartState[]{r0, r1, r2, r5};
        }

        private AppStartState(String r1, int r2, int r3) {
            super(r1, r2);
            this.state = r3;
        }

        public int getValue() {
            return this.state;
        }
    }

    public TTDelayStateManager() {
    }

    static {
        sAppStartState = AppStartState.NormalStart;
        sRequestTagDelayEnabled = new AtomicBoolean(false);
        sAppStateChangeTimeSec = new AtomicLong(0);
        sColdStartDurationSec = new AtomicLong(0);
        sHotStartDurationSec = new AtomicLong(0);
        sWarmStartDurationSec = new AtomicLong(0);
    }

    public static AppStartState getCurrentStartUpState() {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "get coldDuration hostDuration warmDuration " + sColdStartDurationSec.get() + sHotStartDurationSec.get() + sWarmStartDurationSec.get());
    L5:
        int r0 = AnonymousClass1.$SwitchMap$com$bytedance$frameworks$baselib$network$TTDelayStateManager$AppStartState[sAppStartState.ordinal()];
        if (r0 == 1) goto L24;
        if (r0 == 2) goto L19;
        if (r0 == 3) goto L14;
        return sAppStartState;
    L14:
        if (isCurrentAppStateExpired(sAppStateChangeTimeSec.get(), sWarmStartDurationSec.get()) == false) goto L17;
        sAppStartState = AppStartState.NormalStart;
    L17:
        return sAppStartState;
    L19:
        if (isCurrentAppStateExpired(sAppStateChangeTimeSec.get(), sHotStartDurationSec.get()) == false) goto L22;
        sAppStartState = AppStartState.NormalStart;
    L22:
        return sAppStartState;
    L24:
        if (isCurrentAppStateExpired(sAppStateChangeTimeSec.get(), sColdStartDurationSec.get()) == false) goto L27;
        sAppStartState = AppStartState.NormalStart;
    L27:
        return sAppStartState;
    }

    public static AppStartState getAppStartUpState() {
        return sAppStartState;
    }

    public static boolean getRequestTagDelayEnabled() {
        return sRequestTagDelayEnabled.get();
    }

    private static boolean isCurrentAppStateExpired(long r4, long r6) {
        if (((System.currentTimeMillis() / 1000) - r4) <= r6) goto L5;
        return true;
    L5:
        return false;
    }

    public static void onServerConfigChanged(JSONObject r6) {
        AtomicBoolean r0 = sRequestTagDelayEnabled;
        if (r6.optInt("request_tag_enabled") <= 0) goto L5;
        boolean r1 = true;
    L6:
        r0.set(r1);
        AtomicLong r2 = sColdStartDurationSec;
        r2.set(r6.optInt("cold_start_seconds"));
        AtomicLong r3 = sHotStartDurationSec;
        r3.set(r6.optInt("hot_start_seconds"));
        AtomicLong r4 = sWarmStartDurationSec;
        r4.set(r6.optInt("warm_start_seconds"));
        if (Logger.debug() == false) goto L10;
        Logger.d(TAG, "set coldDuration hostDuration warmDuration " + r2.get() + r3.get() + r4.get());
        return;
    L10:
        return;
    L5:
        r1 = false;
        goto L6
    }

    public static void setAppStartUpState(int r5) {
        sAppStateChangeTimeSec.set(System.currentTimeMillis() / 1000);
        if (r5 != 0) goto L5;
        sAppStartState = AppStartState.ColdStart;
        return;
    L5:
        if (r5 != 1) goto L7;
        sAppStartState = AppStartState.HotStart;
        return;
    L7:
        if (r5 == 2) goto L9;
        sAppStartState = AppStartState.NormalStart;
        return;
    L9:
        sAppStartState = AppStartState.WarmStart;
    }
}

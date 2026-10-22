package com.bytedance.frameworks.baselib.network.http.cronet;

import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.frameworks.baselib.network.TTDelayStateManager;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient;

/* JADX INFO: loaded from: classes.dex */
public class TTAppStateManager {
    private static final String TAG = "TTAppStateManager";
    private static volatile AppStartState sAppDelayState;
    private static volatile AppStartState sAppStartState;

    public static final enum AppStartState extends Enum<AppStartState> {
        private static final /* synthetic */ AppStartState[] $VALUES = null;
        public static final AppStartState ColdStart = null;
        public static final AppStartState Default = null;
        public static final AppStartState HotStart = null;
        public static final AppStartState NormalStart = null;
        public static final AppStartState WarmStart = null;
        public static final AppStartState WeakNet = null;
        final int state;

        static {
            AppStartState r0 = new AppStartState("NormalStart", 0, -1);
            NormalStart = r0;
            AppStartState r1 = new AppStartState("ColdStart", 1, 0);
            ColdStart = r1;
            AppStartState r2 = new AppStartState("HotStart", 2, 1);
            HotStart = r2;
            AppStartState r3 = new AppStartState("WarmStart", 3, 2);
            WarmStart = r3;
            AppStartState r4 = new AppStartState("WeakNet", 4, 3);
            WeakNet = r4;
            AppStartState r5 = new AppStartState("Default", 5, 4);
            Default = r5;
            $VALUES = new AppStartState[]{r0, r1, r2, r3, r4, r5};
        }

        private AppStartState(String r1, int r2, int r3) {
            super(r1, r2);
            this.state = r3;
        }

        public static AppStartState valueOf(String r1) {
            return (AppStartState) Enum.valueOf(AppStartState.class, r1);
        }

        public static AppStartState[] values() {
            return (AppStartState[]) $VALUES.clone();
        }

        public int getValue() {
            return this.state;
        }
    }

    static {
        sAppStartState = AppStartState.NormalStart;
        sAppDelayState = AppStartState.Default;
    }

    public TTAppStateManager() {
    }

    public static AppStartState getAppDelayState() {
        return sAppDelayState;
    }

    public static int getAppStartUpState() {
        return sAppStartState.state;
    }

    public static void setAppDelayState(AppStartState r0) {
        sAppDelayState = r0;
    }

    public static void setAppStartUpState(AppStartState r4) {
        sAppStartState = r4;     // Catch: Exception -> L8
        TTDelayStateManager.setAppStartUpState(r4.getValue());     // Catch: Exception -> L8
        ICronetClient r1 = SsCronetHttpClient.getCronetClient();     // Catch: Exception -> L8
        if (r1 == null) goto L19;
        int r5 = r4.state;     // Catch: Exception -> L8
        if (Logger.debug() == false) goto L10;
        Logger.d(TAG, "Set app start-up state: " + r5);     // Catch: Exception -> L8
    L10:
        if (r5 >= 0) goto L12;
        return;
    L12:
        if (r5 > 2) goto L21;
        Reflect.on(r1).call("setAppStartUpState", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r5)}).get();     // Catch: Exception -> L8
        return;
    L21:
        return;
    L19:
        return;
    L8:
        e = move-exception;
        e.printStackTrace();
    }
}

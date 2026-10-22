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
            AppStartState r7 = new AppStartState("WeakNet", 4, 3);
            WeakNet = r7;
            AppStartState r9 = new AppStartState("Default", 5, 4);
            Default = r9;
            $VALUES = new AppStartState[]{r0, r1, r2, r5, r7, r9};
        }

        private AppStartState(String r1, int r2, int r3) {
            super(r1, r2);
            this.state = r3;
        }

        public int getValue() {
            return this.state;
        }
    }

    public TTAppStateManager() {
    }

    static {
        sAppStartState = AppStartState.NormalStart;
        sAppDelayState = AppStartState.Default;
    }

    public static int getAppStartUpState() {
        return sAppStartState.state;
    }

    public static AppStartState getAppDelayState() {
        return sAppDelayState;
    }

    public static void setAppStartUpState(AppStartState r6) {
        sAppStartState = r6;     // Catch: Exception -> L13
        TTDelayStateManager.setAppStartUpState(r6.getValue());     // Catch: Exception -> L13
        ICronetClient r1 = SsCronetHttpClient.getCronetClient();     // Catch: Exception -> L13
        if (r1 == null) goto L18;
        int r7 = r6.state;     // Catch: Exception -> L13
        if (Logger.debug() == false) goto L8;
        Logger.d(TAG, "Set app start-up state: " + r7);     // Catch: Exception -> L13
    L8:
        if (r7 >= 0) goto L10;
        return;
    L10:
        if (r7 > 2) goto L20;
        Reflect.on(r1).call("setAppStartUpState", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r7)}).get();     // Catch: Exception -> L13
        return;
    L20:
        return;
    L18:
        return;
    L13:
        e = move-exception;
        e.printStackTrace();
    }

    public static void setAppDelayState(AppStartState r0) {
        sAppDelayState = r0;
    }
}

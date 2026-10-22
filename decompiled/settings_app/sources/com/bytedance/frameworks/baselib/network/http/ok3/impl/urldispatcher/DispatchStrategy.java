package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

import android.net.Uri;
import com.bytedance.common.utility.Logger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class DispatchStrategy {
    private static final String TAG = "DispatchStrategy";
    private DispatchStrategyType mDispatchStrategyType;

    /* JADX INFO: renamed from: com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchStrategy$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$bytedance$frameworks$baselib$network$http$ok3$impl$urldispatcher$DispatchStrategy$DispatchStrategyType = null;

        static {
            int[] r0 = new int[DispatchStrategyType.values().length];
            $SwitchMap$com$bytedance$frameworks$baselib$network$http$ok3$impl$urldispatcher$DispatchStrategy$DispatchStrategyType = r0;
            r0[DispatchStrategyType.STATIC_DISPATCH_STRATEGY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L8:
            $SwitchMap$com$bytedance$frameworks$baselib$network$http$ok3$impl$urldispatcher$DispatchStrategy$DispatchStrategyType[DispatchStrategyType.REQUEST_HEADER_DISPATCH_STRATEGY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L7
            return;
        }
    }

    public static final enum DispatchStrategyType extends Enum<DispatchStrategyType> {
        private static final /* synthetic */ DispatchStrategyType[] $VALUES = null;
        public static final DispatchStrategyType CONSERVATIVE_DISPATCH_STRATEGY = null;
        public static final DispatchStrategyType DISPATCH_STRATEGY_SUPPORTED_LAST = null;
        public static final DispatchStrategyType OPTIMIZED_DISPATCH_STRATEGY = null;
        public static final DispatchStrategyType REQUEST_HEADER_DISPATCH_STRATEGY = null;
        public static final DispatchStrategyType ROUTE_SELECTION_DISPATCH_STRATEGY = null;
        public static final DispatchStrategyType STATIC_DISPATCH_STRATEGY = null;
        public static final DispatchStrategyType UNKNOWN_DISPATCH_STRATEGY = null;
        public static final DispatchStrategyType WRR_DISPATCH_STRATEGY = null;

        private DispatchStrategyType(String r1, int r2) {
            super(r1, r2);
        }

        public static DispatchStrategyType valueOf(String r1) {
            return (DispatchStrategyType) Enum.valueOf(DispatchStrategyType.class, r1);
        }

        public static DispatchStrategyType[] values() {
            return (DispatchStrategyType[]) $VALUES.clone();
        }

        static {
            DispatchStrategyType r0 = new DispatchStrategyType("UNKNOWN_DISPATCH_STRATEGY", 0);
            UNKNOWN_DISPATCH_STRATEGY = r0;
            DispatchStrategyType r1 = new DispatchStrategyType("STATIC_DISPATCH_STRATEGY", 1);
            STATIC_DISPATCH_STRATEGY = r1;
            DispatchStrategyType r3 = new DispatchStrategyType("WRR_DISPATCH_STRATEGY", 2);
            WRR_DISPATCH_STRATEGY = r3;
            DispatchStrategyType r5 = new DispatchStrategyType("CONSERVATIVE_DISPATCH_STRATEGY", 3);
            CONSERVATIVE_DISPATCH_STRATEGY = r5;
            DispatchStrategyType r7 = new DispatchStrategyType("OPTIMIZED_DISPATCH_STRATEGY", 4);
            OPTIMIZED_DISPATCH_STRATEGY = r7;
            DispatchStrategyType r9 = new DispatchStrategyType("ROUTE_SELECTION_DISPATCH_STRATEGY", 5);
            ROUTE_SELECTION_DISPATCH_STRATEGY = r9;
            DispatchStrategyType r11 = new DispatchStrategyType("REQUEST_HEADER_DISPATCH_STRATEGY", 6);
            REQUEST_HEADER_DISPATCH_STRATEGY = r11;
            DispatchStrategyType r13 = new DispatchStrategyType("DISPATCH_STRATEGY_SUPPORTED_LAST", 7);
            DISPATCH_STRATEGY_SUPPORTED_LAST = r13;
            $VALUES = new DispatchStrategyType[]{r0, r1, r3, r5, r7, r9, r11, r13};
        }
    }

    static {
    }

    public abstract void dispatchRequestHeaders(URLRequest r1);

    public abstract String getTargetUrl(Uri r1);

    public abstract boolean needRequestResultFeedback();

    public abstract void notifyRequestResult(String r1, boolean r2, int r3);

    public DispatchStrategy(DispatchStrategyType r1) {
        this.mDispatchStrategyType = r1;
    }

    public DispatchStrategyType getDispatchStrategyType() {
        return this.mDispatchStrategyType;
    }

    public static DispatchStrategy factory(DispatchStrategyType r0, JSONObject r1, String r2, long r3, int r5) {
        int r4 = AnonymousClass1.$SwitchMap$com$bytedance$frameworks$baselib$network$http$ok3$impl$urldispatcher$DispatchStrategy$DispatchStrategyType[r0.ordinal()];
        if (r4 == 1) goto L14;
        if (r4 == 2) goto L12;
        if (Logger.debug() == false) goto L10;
        Logger.d(TAG, "dispatch strategy " + r0 + " is not supported, fallback to default strategy");
    L10:
        return new DefaultDispatchStrategy();
    L12:
        return new RequestHeaderDispatchStrategy(r1);
    L14:
        return new StaticDispatchStrategy(r1);
    }
}

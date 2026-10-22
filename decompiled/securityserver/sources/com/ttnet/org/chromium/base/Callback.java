package com.ttnet.org.chromium.base;

import com.ttnet.org.chromium.base.annotations.CalledByNative;

/* JADX INFO: loaded from: classes2.dex */
@FunctionalInterface
public interface Callback<T> {

    public static abstract class Helper {
        public Helper() {
        }

        @CalledByNative("Helper")
        public static void onBooleanResultFromNative(Callback r0, boolean r1) {
            r0.onResult(Boolean.valueOf(r1));
        }

        @CalledByNative("Helper")
        public static void onIntResultFromNative(Callback r0, int r1) {
            r0.onResult(Integer.valueOf(r1));
        }

        @CalledByNative("Helper")
        public static void onLongResultFromNative(Callback r0, long r1) {
            r0.onResult(Long.valueOf(r1));
        }

        @CalledByNative("Helper")
        public static void onObjectResultFromNative(Callback r0, Object r1) {
            r0.onResult(r1);
        }

        @CalledByNative("Helper")
        public static void onTimeResultFromNative(Callback r0, long r1) {
            r0.onResult(Long.valueOf(r1));
        }

        @CalledByNative("Helper")
        public static void runRunnable(Runnable r0) {
            r0.run();
        }
    }

    static /* synthetic */ void a(Callback r0, Object r1) {
        r0.lambda$bind$0(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private /* synthetic */ default void lambda$bind$0(Object r1) {
        onResult(r1);
    }

    default Runnable bind(T r3) {
        return new androidx.constraintlayout.motion.widget.a(9, this, r3);
    }

    void onResult(T r1);
}

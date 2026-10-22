package com.ttnet.org.chromium.base;

/* JADX INFO: loaded from: classes5.dex */
@FunctionalInterface
public interface Callback<T> {

    public static abstract class Helper {
        public Helper() {
        }

        static void onObjectResultFromNative(Callback r0, Object r1) {
            r0.onResult(r1);
        }

        static void onBooleanResultFromNative(Callback r0, boolean r1) {
            r0.onResult(Boolean.valueOf(r1));
        }

        static void onIntResultFromNative(Callback r0, int r1) {
            r0.onResult(Integer.valueOf(r1));
        }

        static void onLongResultFromNative(Callback r0, long r1) {
            r0.onResult(Long.valueOf(r1));
        }

        static void onTimeResultFromNative(Callback r0, long r1) {
            r0.onResult(Long.valueOf(r1));
        }

        static void runRunnable(Runnable r0) {
            r0.run();
        }
    }

    void onResult(T r1);

    static /* synthetic */ void lambda$bind$0(Callback _this, Object r1) {
        _this.onResult(r1);
    }

    default Runnable bind(final T r2) {
        return new Callback$$ExternalSyntheticLambda0(this, r2);
    }
}

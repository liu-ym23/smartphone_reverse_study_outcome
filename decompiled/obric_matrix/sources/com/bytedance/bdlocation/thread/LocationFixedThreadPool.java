package com.bytedance.bdlocation.thread;

import android.os.Build;
import com.bytedance.bdlocation.log.Logger;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class LocationFixedThreadPool extends ThreadPoolExecutor {
    private static final String STACK_CLASS = "android.telephony.TelephonyManager$1";
    private static final String STACK_METHOD = "lambda$onError$2";
    private static final RejectedExecutionHandler defaultHandler = null;

    private class LocationFixedThreadPoolRunnable implements Runnable {
        private Runnable mRunnable;
        final /* synthetic */ LocationFixedThreadPool this$0;

        public LocationFixedThreadPoolRunnable(LocationFixedThreadPool r1, Runnable r2) {
            this.this$0 = r1;
            this.mRunnable = r2;
        }

        private boolean doInterceptThrowable(Throwable r6) {
            if (r6 != null) goto L5;
            return false;
        L5:
            int r0 = Build.VERSION.SDK_INT;
            if (r0 == 29) goto L9;
            Logger.i("LocationFixedThreadPool versioncode:" + r0);
            return false;
        L9:
            StringBuilder r1 = new StringBuilder();
            r1.append("LocationFixedThreadPool throwable instanceof NullPointerException:");
            boolean r2 = r6 instanceof NullPointerException;
            r1.append(r2);
            Logger.i(r1.toString());
            if (r2 == false) goto L30;
            StackTraceElement[] r7 = r6.getStackTrace();
            StringBuilder r3 = new StringBuilder();
            r3.append("LocationFixedThreadPool elements:");
            if (r7 != null) goto L14;
            int r4 = 0;
        L15:
            r3.append(r4);
            Logger.i(r3.toString());
            if (r7 == null) goto L30;
            if (r7.length <= 0) goto L30;
            int r5 = r7.length;
            int r8 = 0;
        L20:
            if (r8 >= r5) goto L30;
            StackTraceElement r9 = r7[r8];
            if (r9 == null) goto L29;
            Logger.i("LocationFixedThreadPool element ClassName:" + r9.getClassName() + "--MethodName:" + r9.getMethodName());
            if (LocationFixedThreadPool.STACK_CLASS.equals(r9.getClassName()) == false) goto L29;
            if (LocationFixedThreadPool.STACK_METHOD.equals(r9.getMethodName()) == false) goto L29;
            Logger.i("LocationFixedThreadPool doInterceptThrowable return true");
            return true;
        L29:
            r8 = r8 + 1;
            goto L20
        L14:
            r4 = r7.length;
        L30:
            Logger.i("LocationFixedThreadPool doInterceptThrowable return false");
            return false;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.mRunnable.run();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (doInterceptThrowable(th) == false) goto L8;
            return;
        L8:
            Logger.i("LocationFixedThreadPool doInterceptThrowable throw throwable");
            throw th;
        }
    }

    static {
        defaultHandler = new ThreadPoolExecutor.AbortPolicy();
    }

    public LocationFixedThreadPool(int r10, int r11, long r12, TimeUnit r14, BlockingQueue<Runnable> r15) {
        super(r10, r11, r12, r14, r15, Executors.defaultThreadFactory(), defaultHandler);
    }

    public static ExecutorService newFixedThreadPool(int r8) {
        return new LocationFixedThreadPool(r8, r8, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable r2) {
        super.execute(new LocationFixedThreadPoolRunnable(this, r2));
    }
}

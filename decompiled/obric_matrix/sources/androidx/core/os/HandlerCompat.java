package androidx.core.os;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public final class HandlerCompat {
    private static final String TAG = "HandlerCompat";

    @RequiresApi(28)
    private static class Api28Impl {
        private Api28Impl() {
        }

        public static Handler createAsync(Looper r0) {
            return Handler.createAsync(r0);
        }

        public static Handler createAsync(Looper r0, Handler.Callback r1) {
            return Handler.createAsync(r0, r1);
        }

        public static boolean postDelayed(Handler r0, Runnable r1, Object r2, long r3) {
            return r0.postDelayed(r1, r2, r3);
        }
    }

    @RequiresApi(29)
    private static class Api29Impl {
        private Api29Impl() {
        }

        public static boolean hasCallbacks(Handler r0, Runnable r1) {
            return r0.hasCallbacks(r1);
        }
    }

    private HandlerCompat() {
    }

    @NonNull
    public static Handler createAsync(@NonNull Looper r7) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 28) goto L7;
        return Api28Impl.createAsync(r7);
    L7:
        if (r0 < 17) goto L24;
        return (Handler) Handler.class.getDeclaredConstructor(new Class[]{Looper.class, Handler.Callback.class, Boolean.TYPE}).newInstance(new Object[]{r7, null, Boolean.TRUE});
    L21:
        e = move-exception;
        Log.w(TAG, "Unable to invoke Handler(Looper, Callback, boolean) constructor", e);
    L10:
        e = move-exception;
        Throwable r8 = e.getCause();
        if ((r8 instanceof RuntimeException) == true) goto L20;
        if ((r8 instanceof Error) == false) goto L18;
        throw ((Error) r8);
    L18:
        throw new RuntimeException(r8);
    L20:
        throw ((RuntimeException) r8);
    L24:
        return new Handler(r7);
    }

    @NonNull
    public static Handler createAsync(@NonNull Looper r7, @NonNull Handler.Callback r8) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 28) goto L7;
        return Api28Impl.createAsync(r7, r8);
    L7:
        if (r0 < 17) goto L24;
        return (Handler) Handler.class.getDeclaredConstructor(new Class[]{Looper.class, Handler.Callback.class, Boolean.TYPE}).newInstance(new Object[]{r7, r8, Boolean.TRUE});
    L21:
        e = move-exception;
        Log.w(TAG, "Unable to invoke Handler(Looper, Callback, boolean) constructor", e);
    L10:
        e = move-exception;
        Throwable r9 = e.getCause();
        if ((r9 instanceof RuntimeException) == true) goto L20;
        if ((r9 instanceof Error) == false) goto L18;
        throw ((Error) r9);
    L18:
        throw new RuntimeException(r9);
    L20:
        throw ((RuntimeException) r9);
    L24:
        return new Handler(r7, r8);
    }

    @RequiresApi(16)
    public static boolean hasCallbacks(@NonNull Handler r6, @NonNull Runnable r7) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 29) goto L7;
        return Api29Impl.hasCallbacks(r6, r7);
    L7:
        if (r0 >= 16) goto L26;
        e = null;
    L25:
        throw new UnsupportedOperationException("Failed to call Handler.hasCallbacks(), but there is no safe failure mode for this method. Raising exception.", e);
    L26:
        return ((Boolean) Handler.class.getMethod("hasCallbacks", new Class[]{Runnable.class}).invoke(r6, new Object[]{r7})).booleanValue();
    L10:
        e = e;
    L12:
        e = move-exception;
        Throwable r8 = e.getCause();
        if ((r8 instanceof RuntimeException) == true) goto L22;
        if ((r8 instanceof Error) == false) goto L20;
        throw ((Error) r8);
    L20:
        throw new RuntimeException(r8);
    L22:
        throw ((RuntimeException) r8);
    }

    public static boolean postDelayed(@NonNull Handler r2, @NonNull Runnable r3, @Nullable Object r4, long r5) {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        Message r6 = Message.obtain(r2, r3);
        r6.obj = r4;
        return r2.sendMessageDelayed(r6, r5);
    L5:
        return Api28Impl.postDelayed(r2, r3, r4, r5);
    }
}

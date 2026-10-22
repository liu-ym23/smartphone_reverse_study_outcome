package androidx.core.os;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Message;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public final class MessageCompat {
    private static boolean sTryIsAsynchronous = true;
    private static boolean sTrySetAsynchronous = true;

    @RequiresApi(22)
    static class Api22Impl {
        private Api22Impl() {
        }

        @DoNotInline
        static boolean isAsynchronous(Message r0) {
            return r0.isAsynchronous();
        }

        @DoNotInline
        static void setAsynchronous(Message r0, boolean r1) {
            r0.setAsynchronous(r1);
        }
    }

    static {
    }

    private MessageCompat() {
    }

    @SuppressLint({"NewApi"})
    public static boolean isAsynchronous(@NonNull Message r3) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 22) goto L7;
        return Api22Impl.isAsynchronous(r3);
    L7:
        if (sTryIsAsynchronous == true) goto L9;
    L13:
        return false;
    L9:
        if (r0 < 16) goto L13;
        return Api22Impl.isAsynchronous(r3);
    L12:
        sTryIsAsynchronous = false;
        goto L13
    }

    @SuppressLint({"NewApi"})
    public static void setAsynchronous(@NonNull Message r2, boolean r3) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 22) goto L7;
        Api22Impl.setAsynchronous(r2, r3);
        return;
    L7:
        if (sTrySetAsynchronous == true) goto L9;
        return;
    L9:
        if (r0 < 16) goto L17;
        Api22Impl.setAsynchronous(r2, r3);     // Catch: NoSuchMethodError -> L12
        return;
    L12:
        sTrySetAsynchronous = false;
        return;
    }
}

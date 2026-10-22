package androidx.core.os;

import android.os.Message;

/* JADX INFO: loaded from: classes.dex */
public final class MessageCompat {
    private static boolean sTryIsAsynchronous = true;
    private static boolean sTrySetAsynchronous = true;

    static class Api22Impl {
        private Api22Impl() {
        }

        static boolean isAsynchronous(Message r0) {
            return r0.isAsynchronous();
        }

        static void setAsynchronous(Message r0, boolean r1) {
            r0.setAsynchronous(r1);
        }
    }

    static {
    }

    public static void setAsynchronous(Message r0, boolean r1) {
        Api22Impl.setAsynchronous(r0, r1);
    }

    public static boolean isAsynchronous(Message r0) {
        return Api22Impl.isAsynchronous(r0);
    }

    private MessageCompat() {
    }
}

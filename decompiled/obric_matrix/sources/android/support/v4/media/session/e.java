package android.support.v4.media.session;

import android.media.session.PlaybackState;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
class e {

    static final class a {
        public static String a(Object r0) {
            return ((PlaybackState.CustomAction) r0).getAction();
        }

        public static Bundle b(Object r0) {
            return ((PlaybackState.CustomAction) r0).getExtras();
        }

        public static int c(Object r0) {
            return ((PlaybackState.CustomAction) r0).getIcon();
        }

        public static CharSequence d(Object r0) {
            return ((PlaybackState.CustomAction) r0).getName();
        }
    }

    public static long a(Object r2) {
        return ((PlaybackState) r2).getActions();
    }

    public static long b(Object r2) {
        return ((PlaybackState) r2).getActiveQueueItemId();
    }

    public static long c(Object r2) {
        return ((PlaybackState) r2).getBufferedPosition();
    }

    public static List<Object> d(Object r0) {
        return ((PlaybackState) r0).getCustomActions();
    }

    public static CharSequence e(Object r0) {
        return ((PlaybackState) r0).getErrorMessage();
    }

    public static long f(Object r2) {
        return ((PlaybackState) r2).getLastPositionUpdateTime();
    }

    public static float g(Object r0) {
        return ((PlaybackState) r0).getPlaybackSpeed();
    }

    public static long h(Object r2) {
        return ((PlaybackState) r2).getPosition();
    }

    public static int i(Object r0) {
        return ((PlaybackState) r0).getState();
    }
}

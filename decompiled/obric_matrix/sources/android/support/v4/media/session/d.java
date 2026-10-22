package android.support.v4.media.session;

import android.media.session.MediaSession;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
class d {

    static class a {
        public static Object a(Object r0) {
            return ((MediaSession.QueueItem) r0).getDescription();
        }

        public static long b(Object r2) {
            return ((MediaSession.QueueItem) r2).getQueueId();
        }
    }

    public static Object a(Object r1) {
        if ((r1 instanceof MediaSession.Token) == false) goto L6;
        return r1;
    L6:
        throw new IllegalArgumentException("token is not a valid MediaSession.Token object");
    }
}

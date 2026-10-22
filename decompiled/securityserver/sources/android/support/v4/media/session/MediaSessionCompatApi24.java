package android.support.v4.media.session;

import android.media.session.MediaSession;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(24)
class MediaSessionCompatApi24 {
    private static final String TAG = "MediaSessionCompatApi24";

    public interface Callback extends MediaSessionCompatApi23.Callback {
        void onPrepare();

        void onPrepareFromMediaId(String r1, Bundle r2);

        void onPrepareFromSearch(String r1, Bundle r2);

        void onPrepareFromUri(Uri r1, Bundle r2);
    }

    public static class CallbackProxy<T extends Callback> extends MediaSessionCompatApi23.CallbackProxy<T> {
        public CallbackProxy(T r1) {
            super(r1);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPrepare() {
            ((Callback) this.mCallback).onPrepare();
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPrepareFromMediaId(String r1, Bundle r2) {
            MediaSessionCompat.ensureClassLoader(r2);
            ((Callback) this.mCallback).onPrepareFromMediaId(r1, r2);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPrepareFromSearch(String r1, Bundle r2) {
            MediaSessionCompat.ensureClassLoader(r2);
            ((Callback) this.mCallback).onPrepareFromSearch(r1, r2);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPrepareFromUri(Uri r1, Bundle r2) {
            MediaSessionCompat.ensureClassLoader(r2);
            ((Callback) this.mCallback).onPrepareFromUri(r1, r2);
        }
    }

    private MediaSessionCompatApi24() {
    }

    public static Object createCallback(Callback r1) {
        return new CallbackProxy(r1);
    }

    public static String getCallingPackage(Object r3) {
        MediaSession r4 = (MediaSession) r3;
        return (String) r4.getClass().getMethod("getCallingPackage", null).invoke(r4, null);
    L5:
        e = move-exception;
        Log.e(TAG, "Cannot execute MediaSession.getCallingPackage()", e);
        return null;
    }
}

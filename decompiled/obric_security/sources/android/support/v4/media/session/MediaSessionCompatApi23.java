package android.support.v4.media.session;

import android.net.Uri;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
class MediaSessionCompatApi23 {

    public interface Callback extends MediaSessionCompatApi21.Callback {
        void onPlayFromUri(Uri r1, Bundle r2);
    }

    static class CallbackProxy<T extends Callback> extends MediaSessionCompatApi21.CallbackProxy<T> {
        public CallbackProxy(T r1) {
            super(r1);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPlayFromUri(Uri r1, Bundle r2) {
            MediaSessionCompat.ensureClassLoader(r2);
            ((Callback) this.mCallback).onPlayFromUri(r1, r2);
        }
    }

    public static Object createCallback(Callback r1) {
        return new CallbackProxy(r1);
    }

    private MediaSessionCompatApi23() {
    }
}

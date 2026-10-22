package android.support.v4.media.session;

import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(23)
class MediaSessionCompatApi23 {

    public interface Callback extends MediaSessionCompatApi21.Callback {
        void onPlayFromUri(Uri r1, Bundle r2);
    }

    public static class CallbackProxy<T extends Callback> extends MediaSessionCompatApi21.CallbackProxy<T> {
        public CallbackProxy(T r1) {
            super(r1);
        }

        @Override // android.media.session.MediaSession.Callback
        public void onPlayFromUri(Uri r1, Bundle r2) {
            MediaSessionCompat.ensureClassLoader(r2);
            ((Callback) this.mCallback).onPlayFromUri(r1, r2);
        }
    }

    private MediaSessionCompatApi23() {
    }

    public static Object createCallback(Callback r1) {
        return new CallbackProxy(r1);
    }
}

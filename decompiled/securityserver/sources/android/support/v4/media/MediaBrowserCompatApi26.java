package android.support.v4.media;

import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(26)
class MediaBrowserCompatApi26 {

    public interface SubscriptionCallback extends MediaBrowserCompatApi21.SubscriptionCallback {
        void onChildrenLoaded(@NonNull String r1, List<?> r2, @NonNull Bundle r3);

        void onError(@NonNull String r1, @NonNull Bundle r2);
    }

    public static class SubscriptionCallbackProxy<T extends SubscriptionCallback> extends MediaBrowserCompatApi21.SubscriptionCallbackProxy<T> {
        public SubscriptionCallbackProxy(T r1) {
            super(r1);
        }

        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onChildrenLoaded(@NonNull String r1, List<MediaBrowser.MediaItem> r2, @NonNull Bundle r3) {
            MediaSessionCompat.ensureClassLoader(r3);
            ((SubscriptionCallback) this.mSubscriptionCallback).onChildrenLoaded(r1, r2, r3);
        }

        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onError(@NonNull String r1, @NonNull Bundle r2) {
            MediaSessionCompat.ensureClassLoader(r2);
            ((SubscriptionCallback) this.mSubscriptionCallback).onError(r1, r2);
        }
    }

    private MediaBrowserCompatApi26() {
    }

    public static Object createSubscriptionCallback(SubscriptionCallback r1) {
        return new SubscriptionCallbackProxy(r1);
    }

    public static void subscribe(Object r0, String r1, Bundle r2, Object r3) {
        ((MediaBrowser) r0).subscribe(r1, r2, (MediaBrowser.SubscriptionCallback) r3);
    }

    public static void unsubscribe(Object r0, String r1, Object r2) {
        ((MediaBrowser) r0).unsubscribe(r1, (MediaBrowser.SubscriptionCallback) r2);
    }
}

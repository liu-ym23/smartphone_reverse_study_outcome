package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
class MediaBrowserCompatApi21 {
    static final String NULL_MEDIA_ITEM_ID = "android.support.v4.media.MediaBrowserCompat.NULL_MEDIA_ITEM";

    public interface ConnectionCallback {
        void onConnected();

        void onConnectionFailed();

        void onConnectionSuspended();
    }

    public static class ConnectionCallbackProxy<T extends ConnectionCallback> extends MediaBrowser.ConnectionCallback {
        protected final T mConnectionCallback;

        public ConnectionCallbackProxy(T r1) {
            this.mConnectionCallback = r1;
        }

        @Override // android.media.browse.MediaBrowser.ConnectionCallback
        public void onConnected() {
            this.mConnectionCallback.onConnected();
        }

        @Override // android.media.browse.MediaBrowser.ConnectionCallback
        public void onConnectionFailed() {
            this.mConnectionCallback.onConnectionFailed();
        }

        @Override // android.media.browse.MediaBrowser.ConnectionCallback
        public void onConnectionSuspended() {
            this.mConnectionCallback.onConnectionSuspended();
        }
    }

    public static class MediaItem {
        private MediaItem() {
        }

        public static Object getDescription(Object r0) {
            return ((MediaBrowser.MediaItem) r0).getDescription();
        }

        public static int getFlags(Object r0) {
            return ((MediaBrowser.MediaItem) r0).getFlags();
        }
    }

    public interface SubscriptionCallback {
        void onChildrenLoaded(@NonNull String r1, List<?> r2);

        void onError(@NonNull String r1);
    }

    public static class SubscriptionCallbackProxy<T extends SubscriptionCallback> extends MediaBrowser.SubscriptionCallback {
        protected final T mSubscriptionCallback;

        public SubscriptionCallbackProxy(T r1) {
            this.mSubscriptionCallback = r1;
        }

        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onChildrenLoaded(@NonNull String r1, List<MediaBrowser.MediaItem> r2) {
            this.mSubscriptionCallback.onChildrenLoaded(r1, r2);
        }

        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onError(@NonNull String r1) {
            this.mSubscriptionCallback.onError(r1);
        }
    }

    private MediaBrowserCompatApi21() {
    }

    public static void connect(Object r0) {
        ((MediaBrowser) r0).connect();
    }

    public static Object createBrowser(Context r1, ComponentName r2, Object r3, Bundle r4) {
        return new MediaBrowser(r1, r2, (MediaBrowser.ConnectionCallback) r3, r4);
    }

    public static Object createConnectionCallback(ConnectionCallback r1) {
        return new ConnectionCallbackProxy(r1);
    }

    public static Object createSubscriptionCallback(SubscriptionCallback r1) {
        return new SubscriptionCallbackProxy(r1);
    }

    public static void disconnect(Object r0) {
        ((MediaBrowser) r0).disconnect();
    }

    public static Bundle getExtras(Object r0) {
        return ((MediaBrowser) r0).getExtras();
    }

    public static String getRoot(Object r0) {
        return ((MediaBrowser) r0).getRoot();
    }

    public static ComponentName getServiceComponent(Object r0) {
        return ((MediaBrowser) r0).getServiceComponent();
    }

    public static Object getSessionToken(Object r0) {
        return ((MediaBrowser) r0).getSessionToken();
    }

    public static boolean isConnected(Object r0) {
        return ((MediaBrowser) r0).isConnected();
    }

    public static void subscribe(Object r0, String r1, Object r2) {
        ((MediaBrowser) r0).subscribe(r1, (MediaBrowser.SubscriptionCallback) r2);
    }

    public static void unsubscribe(Object r0, String r1) {
        ((MediaBrowser) r0).unsubscribe(r1);
    }
}

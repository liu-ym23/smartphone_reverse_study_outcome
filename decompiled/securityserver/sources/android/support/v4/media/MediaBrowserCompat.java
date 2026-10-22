package android.support.v4.media;

import a.a;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.core.app.BundleCompat;
import androidx.media.MediaBrowserCompatUtils;
import androidx.media.MediaBrowserProtocol;
import androidx.media.MediaBrowserServiceCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class MediaBrowserCompat {
    public static final String CUSTOM_ACTION_DOWNLOAD = "android.support.v4.media.action.DOWNLOAD";
    public static final String CUSTOM_ACTION_REMOVE_DOWNLOADED_FILE = "android.support.v4.media.action.REMOVE_DOWNLOADED_FILE";
    static final boolean DEBUG = false;
    public static final String EXTRA_DOWNLOAD_PROGRESS = "android.media.browse.extra.DOWNLOAD_PROGRESS";
    public static final String EXTRA_MEDIA_ID = "android.media.browse.extra.MEDIA_ID";
    public static final String EXTRA_PAGE = "android.media.browse.extra.PAGE";
    public static final String EXTRA_PAGE_SIZE = "android.media.browse.extra.PAGE_SIZE";
    static final String TAG = "MediaBrowserCompat";
    private final MediaBrowserImpl mImpl;

    public static class CallbackHandler extends Handler {
        private final WeakReference<MediaBrowserServiceCallbackImpl> mCallbackImplRef;
        private WeakReference<Messenger> mCallbacksMessengerRef;

        public CallbackHandler(MediaBrowserServiceCallbackImpl r2) {
            this.mCallbackImplRef = new WeakReference(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r13) {
            WeakReference<Messenger> r3 = this.mCallbacksMessengerRef;
            if (r3 != null) goto L5;
            return;
        L5:
            if (r3.get() != null) goto L7;
            return;
        L7:
            if (this.mCallbackImplRef.get() == null) goto L33;
            Bundle r4 = r13.getData();
            MediaSessionCompat.ensureClassLoader(r4);
            MediaBrowserServiceCallbackImpl r5 = this.mCallbackImplRef.get();
            Messenger r12 = this.mCallbacksMessengerRef.get();
            int r6 = r13.what;     // Catch: BadParcelableException -> L22
            if (r6 != 1) goto L14;
            Bundle r1 = r4.getBundle(MediaBrowserProtocol.DATA_ROOT_HINTS);     // Catch: BadParcelableException -> L22
            MediaSessionCompat.ensureClassLoader(r1);     // Catch: BadParcelableException -> L22
            r5.onServiceConnected(r12, r4.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), (MediaSessionCompat.Token) r4.getParcelable(MediaBrowserProtocol.DATA_MEDIA_SESSION_TOKEN), r1);     // Catch: BadParcelableException -> L22
        L26:
            return;
        L14:
            if (r6 != 2) goto L16;
            r5.onConnectionFailed(r12);     // Catch: BadParcelableException -> L22
            goto L26
        L16:
            if (r6 == 3) goto L18;
            Log.w(MediaBrowserCompat.TAG, "Unhandled message: " + r13 + "\n  Client version: 1\n  Service version: " + r13.arg1);     // Catch: BadParcelableException -> L22
            goto L26
        L18:
            Bundle r9 = r4.getBundle(MediaBrowserProtocol.DATA_OPTIONS);     // Catch: BadParcelableException -> L22
            MediaSessionCompat.ensureClassLoader(r9);     // Catch: BadParcelableException -> L22
            Bundle r10 = r4.getBundle(MediaBrowserProtocol.DATA_NOTIFY_CHILDREN_CHANGED_OPTIONS);     // Catch: BadParcelableException -> L22
            MediaSessionCompat.ensureClassLoader(r10);     // Catch: BadParcelableException -> L22
            r5.onLoadChildren(r12, r4.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), r4.getParcelableArrayList(MediaBrowserProtocol.DATA_MEDIA_ITEM_LIST), r9, r10);     // Catch: BadParcelableException -> L22
        L22:
            Log.e(MediaBrowserCompat.TAG, "Could not unparcel the data.");
            if (r13.what != 1) goto L32;
            r5.onConnectionFailed(r12);
            return;
        L32:
            return;
        }

        public void setCallbacksMessenger(Messenger r2) {
            this.mCallbacksMessengerRef = new WeakReference(r2);
        }
    }

    public static class ConnectionCallback {
        ConnectionCallbackInternal mConnectionCallbackInternal;
        final Object mConnectionCallbackObj;

        public interface ConnectionCallbackInternal {
            void onConnected();

            void onConnectionFailed();

            void onConnectionSuspended();
        }

        public class StubApi21 implements MediaBrowserCompatApi21.ConnectionCallback {
            final /* synthetic */ ConnectionCallback this$0;

            public StubApi21(ConnectionCallback r1) {
                this.this$0 = r1;
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi21.ConnectionCallback
            public void onConnected() {
                ConnectionCallbackInternal r0 = this.this$0.mConnectionCallbackInternal;
                if (r0 == null) goto L5;
                r0.onConnected();
            L5:
                this.this$0.onConnected();
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi21.ConnectionCallback
            public void onConnectionFailed() {
                ConnectionCallbackInternal r0 = this.this$0.mConnectionCallbackInternal;
                if (r0 == null) goto L5;
                r0.onConnectionFailed();
            L5:
                this.this$0.onConnectionFailed();
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi21.ConnectionCallback
            public void onConnectionSuspended() {
                ConnectionCallbackInternal r0 = this.this$0.mConnectionCallbackInternal;
                if (r0 == null) goto L5;
                r0.onConnectionSuspended();
            L5:
                this.this$0.onConnectionSuspended();
            }
        }

        public ConnectionCallback() {
            this.mConnectionCallbackObj = MediaBrowserCompatApi21.createConnectionCallback(new StubApi21(this));
        }

        public void onConnected() {
        }

        public void onConnectionFailed() {
        }

        public void onConnectionSuspended() {
        }

        public void setInternalConnectionCallback(ConnectionCallbackInternal r1) {
            this.mConnectionCallbackInternal = r1;
        }
    }

    public static abstract class CustomActionCallback {
        public CustomActionCallback() {
        }

        public void onError(String r1, Bundle r2, Bundle r3) {
        }

        public void onProgressUpdate(String r1, Bundle r2, Bundle r3) {
        }

        public void onResult(String r1, Bundle r2, Bundle r3) {
        }
    }

    public static class CustomActionResultReceiver extends ResultReceiver {
        private final String mAction;
        private final CustomActionCallback mCallback;
        private final Bundle mExtras;

        public CustomActionResultReceiver(String r1, Bundle r2, CustomActionCallback r3, Handler r4) {
            super(r4);
            this.mAction = r1;
            this.mExtras = r2;
            this.mCallback = r3;
        }

        @Override // android.support.v4.os.ResultReceiver
        public void onReceiveResult(int r3, Bundle r4) {
            if (this.mCallback != null) goto L5;
            return;
        L5:
            MediaSessionCompat.ensureClassLoader(r4);
            if (r3 == (-1)) goto L13;
            if (r3 != 0) goto L9;
            this.mCallback.onResult(this.mAction, this.mExtras, r4);
            return;
        L9:
            if (r3 == 1) goto L11;
            StringBuilder r5 = a.p(r3, "Unknown result code: ", " (extras=");
            r5.append(this.mExtras);
            r5.append(", resultData=");
            r5.append(r4);
            r5.append(")");
            Log.w(MediaBrowserCompat.TAG, r5.toString());
            return;
        L11:
            this.mCallback.onProgressUpdate(this.mAction, this.mExtras, r4);
            return;
        L13:
            this.mCallback.onError(this.mAction, this.mExtras, r4);
        }
    }

    public static abstract class ItemCallback {
        final Object mItemCallbackObj;

        public class StubApi23 implements MediaBrowserCompatApi23.ItemCallback {
            final /* synthetic */ ItemCallback this$0;

            public StubApi23(ItemCallback r1) {
                this.this$0 = r1;
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi23.ItemCallback
            public void onError(@NonNull String r1) {
                this.this$0.onError(r1);
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi23.ItemCallback
            public void onItemLoaded(Parcel r2) {
                if (r2 != null) goto L4;
                this.this$0.onItemLoaded(null);
                return;
            L4:
                r2.setDataPosition(0);
                MediaItem r0 = MediaItem.CREATOR.createFromParcel(r2);
                r2.recycle();
                this.this$0.onItemLoaded(r0);
            }
        }

        public ItemCallback() {
            this.mItemCallbackObj = MediaBrowserCompatApi23.createItemCallback(new StubApi23(this));
        }

        public void onError(@NonNull String r1) {
        }

        public void onItemLoaded(MediaItem r1) {
        }
    }

    public static class ItemReceiver extends ResultReceiver {
        private final ItemCallback mCallback;
        private final String mMediaId;

        public ItemReceiver(String r1, ItemCallback r2, Handler r3) {
            super(r3);
            this.mMediaId = r1;
            this.mCallback = r2;
        }

        @Override // android.support.v4.os.ResultReceiver
        public void onReceiveResult(int r2, Bundle r3) {
            MediaSessionCompat.ensureClassLoader(r3);
            if (r2 != 0) goto L16;
            if (r3 == null) goto L16;
            if (r3.containsKey(MediaBrowserServiceCompat.KEY_MEDIA_ITEM) == false) goto L16;
            Parcelable r4 = r3.getParcelable(MediaBrowserServiceCompat.KEY_MEDIA_ITEM);
            if (r4 != null) goto L11;
        L14:
            this.mCallback.onItemLoaded((MediaItem) r4);
            return;
        L11:
            if ((r4 instanceof MediaItem) == true) goto L14;
            this.mCallback.onError(this.mMediaId);
            return;
        L16:
            this.mCallback.onError(this.mMediaId);
        }
    }

    public interface MediaBrowserImpl {
        void connect();

        void disconnect();

        @Nullable
        Bundle getExtras();

        void getItem(@NonNull String r1, @NonNull ItemCallback r2);

        @Nullable
        Bundle getNotifyChildrenChangedOptions();

        @NonNull
        String getRoot();

        ComponentName getServiceComponent();

        @NonNull
        MediaSessionCompat.Token getSessionToken();

        boolean isConnected();

        void search(@NonNull String r1, Bundle r2, @NonNull SearchCallback r3);

        void sendCustomAction(@NonNull String r1, Bundle r2, @Nullable CustomActionCallback r3);

        void subscribe(@NonNull String r1, @Nullable Bundle r2, @NonNull SubscriptionCallback r3);

        void unsubscribe(@NonNull String r1, SubscriptionCallback r2);
    }

    @RequiresApi(21)
    public static class MediaBrowserImplApi21 implements MediaBrowserImpl, MediaBrowserServiceCallbackImpl, ConnectionCallback.ConnectionCallbackInternal {
        protected final Object mBrowserObj;
        protected Messenger mCallbacksMessenger;
        final Context mContext;
        protected final CallbackHandler mHandler;
        private MediaSessionCompat.Token mMediaSessionToken;
        private Bundle mNotifyChildrenChangedOptions;
        protected final Bundle mRootHints;
        protected ServiceBinderWrapper mServiceBinderWrapper;
        protected int mServiceVersion;
        private final ArrayMap<String, Subscription> mSubscriptions;

        public MediaBrowserImplApi21(Context r3, ComponentName r4, ConnectionCallback r5, Bundle r6) {
            this.mHandler = new CallbackHandler(this);
            this.mSubscriptions = new ArrayMap();
            this.mContext = r3;
            if (r6 == null) goto L5;
            Bundle r0 = new Bundle(r6);
        L6:
            this.mRootHints = r0;
            r0.putInt(MediaBrowserProtocol.EXTRA_CLIENT_VERSION, 1);
            r5.setInternalConnectionCallback(this);
            this.mBrowserObj = MediaBrowserCompatApi21.createBrowser(r3, r4, r5.mConnectionCallbackObj, r0);
            return;
        L5:
            r0 = new Bundle();
            goto L6
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void connect() {
            MediaBrowserCompatApi21.connect(this.mBrowserObj);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void disconnect() {
            ServiceBinderWrapper r0 = this.mServiceBinderWrapper;
            if (r0 == null) goto L9;
            Messenger r1 = this.mCallbacksMessenger;
            if (r1 == null) goto L9;
            r0.unregisterCallbackMessenger(r1);     // Catch: RemoteException -> L8
        L8:
            Log.i(MediaBrowserCompat.TAG, "Remote error unregistering client messenger.");
        L9:
            MediaBrowserCompatApi21.disconnect(this.mBrowserObj);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        @Nullable
        public Bundle getExtras() {
            return MediaBrowserCompatApi21.getExtras(this.mBrowserObj);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void getItem(@NonNull final String r5, @NonNull final ItemCallback r6) {
            if (TextUtils.isEmpty(r5) == true) goto L21;
            if (r6 == null) goto L19;
            if (MediaBrowserCompatApi21.isConnected(this.mBrowserObj) == true) goto L10;
            Log.i(MediaBrowserCompat.TAG, "Not connected, unable to retrieve the MediaItem.");
            this.mHandler.post(new AnonymousClass1(this, r6, r5));
            return;
        L10:
            if (this.mServiceBinderWrapper != null) goto L22;
            this.mHandler.post(new AnonymousClass2(this, r6, r5));
            return;
        L22:
            this.mServiceBinderWrapper.getMediaItem(r5, new ItemReceiver(r5, r6, this.mHandler), this.mCallbacksMessenger);     // Catch: RemoteException -> L16
            return;
        L16:
            Log.i(MediaBrowserCompat.TAG, "Remote error getting media item: " + r5);
            this.mHandler.post(new AnonymousClass3(this, r6, r5));
            return;
        L19:
            throw new IllegalArgumentException("cb is null");
        L21:
            throw new IllegalArgumentException("mediaId is empty");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public Bundle getNotifyChildrenChangedOptions() {
            return this.mNotifyChildrenChangedOptions;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        @NonNull
        public String getRoot() {
            return MediaBrowserCompatApi21.getRoot(this.mBrowserObj);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public ComponentName getServiceComponent() {
            return MediaBrowserCompatApi21.getServiceComponent(this.mBrowserObj);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        @NonNull
        public MediaSessionCompat.Token getSessionToken() {
            if (this.mMediaSessionToken != null) goto L6;
            this.mMediaSessionToken = MediaSessionCompat.Token.fromToken(MediaBrowserCompatApi21.getSessionToken(this.mBrowserObj));
        L6:
            return this.mMediaSessionToken;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public boolean isConnected() {
            return MediaBrowserCompatApi21.isConnected(this.mBrowserObj);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal
        public void onConnected() {
            Bundle r0 = MediaBrowserCompatApi21.getExtras(this.mBrowserObj);
            if (r0 != null) goto L5;
            return;
        L5:
            this.mServiceVersion = r0.getInt(MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 0);
            IBinder r1 = BundleCompat.getBinder(r0, MediaBrowserProtocol.EXTRA_MESSENGER_BINDER);
            if (r1 == null) goto L11;
            this.mServiceBinderWrapper = new ServiceBinderWrapper(r1, this.mRootHints);
            Messenger r2 = new Messenger(this.mHandler);
            this.mCallbacksMessenger = r2;
            this.mHandler.setCallbacksMessenger(r2);
            this.mServiceBinderWrapper.registerCallbackMessenger(this.mContext, this.mCallbacksMessenger);     // Catch: RemoteException -> L10
        L10:
            Log.i(MediaBrowserCompat.TAG, "Remote error registering client messenger.");
        L11:
            IMediaSession r3 = IMediaSession.Stub.asInterface(BundleCompat.getBinder(r0, MediaBrowserProtocol.EXTRA_SESSION_BINDER));
            if (r3 == null) goto L17;
            this.mMediaSessionToken = MediaSessionCompat.Token.fromToken(MediaBrowserCompatApi21.getSessionToken(this.mBrowserObj), r3);
            return;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal
        public void onConnectionFailed() {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.ConnectionCallback.ConnectionCallbackInternal
        public void onConnectionSuspended() {
            this.mServiceBinderWrapper = null;
            this.mCallbacksMessenger = null;
            this.mMediaSessionToken = null;
            this.mHandler.setCallbacksMessenger(null);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onLoadChildren(Messenger r2, String r3, List r4, Bundle r5, Bundle r6) {
            if (this.mCallbacksMessenger == r2) goto L5;
            return;
        L5:
            Subscription r7 = this.mSubscriptions.get(r3);
            if (r7 == null) goto L8;
            SubscriptionCallback r8 = r7.getCallback(r5);
            if (r8 != null) goto L14;
            return;
        L14:
            if (r5 != null) goto L18;
            if (r4 != null) goto L17;
            r8.onError(r3);
            return;
        L17:
            this.mNotifyChildrenChangedOptions = r6;
            r8.onChildrenLoaded(r3, r4);
            this.mNotifyChildrenChangedOptions = null;
            return;
        L18:
            if (r4 != null) goto L20;
            r8.onError(r3, r5);
            return;
        L20:
            this.mNotifyChildrenChangedOptions = r6;
            r8.onChildrenLoaded(r3, r4, r5);
            this.mNotifyChildrenChangedOptions = null;
            return;
        L8:
            if (MediaBrowserCompat.DEBUG == false) goto L22;
            Log.d(MediaBrowserCompat.TAG, "onLoadChildren for id that isn't subscribed id=" + r3);
            return;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onServiceConnected(Messenger r1, String r2, MediaSessionCompat.Token r3, Bundle r4) {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void search(@NonNull final String r5, final Bundle r6, @NonNull final SearchCallback r7) {
            if (isConnected() == false) goto L15;
            if (this.mServiceBinderWrapper != null) goto L16;
            Log.i(MediaBrowserCompat.TAG, "The connected service doesn't support search.");
            this.mHandler.post(new AnonymousClass4(this, r7, r5, r6));
            return;
        L16:
            this.mServiceBinderWrapper.search(r5, r6, new SearchResultReceiver(r5, r6, r7, this.mHandler), this.mCallbacksMessenger);     // Catch: RemoteException -> L11
            return;
        L11:
            e = move-exception;
            Log.i(MediaBrowserCompat.TAG, "Remote error searching items with query: " + r5, e);
            this.mHandler.post(new AnonymousClass5(this, r7, r5, r6));
            return;
        L15:
            throw new IllegalStateException("search() called while not connected");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void sendCustomAction(@NonNull final String r5, final Bundle r6, @Nullable final CustomActionCallback r7) {
            if (isConnected() == false) goto L18;
            if (this.mServiceBinderWrapper != null) goto L19;
            Log.i(MediaBrowserCompat.TAG, "The connected service doesn't support sendCustomAction.");
            if (r7 == null) goto L19;
            this.mHandler.post(new AnonymousClass6(this, r7, r5, r6));
        L19:
            this.mServiceBinderWrapper.sendCustomAction(r5, r6, new CustomActionResultReceiver(r5, r6, r7, this.mHandler), this.mCallbacksMessenger);     // Catch: RemoteException -> L12
            return;
        L12:
            e = move-exception;
            Log.i(MediaBrowserCompat.TAG, "Remote error sending a custom action: action=" + r5 + ", extras=" + r6, e);
            if (r7 == null) goto L21;
            this.mHandler.post(new AnonymousClass7(this, r7, r5, r6));
            return;
        L21:
            return;
        L18:
            throw new IllegalStateException("Cannot send a custom action (" + r5 + ") with extras " + r6 + " because the browser is not connected to the service.");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void subscribe(@NonNull String r3, Bundle r4, @NonNull SubscriptionCallback r5) {
            Subscription r0 = this.mSubscriptions.get(r3);
            if (r0 != null) goto L5;
            r0 = new Subscription();
            this.mSubscriptions.put(r3, r0);
        L5:
            r5.setSubscription(r0);
            if (r4 != null) goto L8;
            Bundle r6 = null;
        L9:
            r0.putCallback(r6, r5);
            ServiceBinderWrapper r1 = this.mServiceBinderWrapper;
            if (r1 != null) goto L16;
            MediaBrowserCompatApi21.subscribe(this.mBrowserObj, r3, r5.mSubscriptionCallbackObj);
            return;
        L16:
            r1.addSubscription(r3, r5.mToken, r6, this.mCallbacksMessenger);     // Catch: RemoteException -> L14
            return;
        L14:
            Log.i(MediaBrowserCompat.TAG, "Remote error subscribing media item: " + r3);
            return;
        L8:
            r6 = new Bundle(r4);
            goto L9
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void unsubscribe(@NonNull String r8, SubscriptionCallback r9) {
            Subscription r0 = this.mSubscriptions.get(r8);
            if (r0 != null) goto L5;
            return;
        L5:
            ServiceBinderWrapper r1 = this.mServiceBinderWrapper;
            if (r1 != null) goto L32;
            if (r9 != null) goto L9;
            MediaBrowserCompatApi21.unsubscribe(this.mBrowserObj, r8);
        L28:
            if (r0.isEmpty() == true) goto L30;
            if (r9 == null) goto L30;
            return;
        L30:
            this.mSubscriptions.remove(r8);
            return;
        L9:
            List<SubscriptionCallback> r2 = r0.getCallbacks();
            List<Bundle> r3 = r0.getOptionsList();
            int r4 = r2.size() - 1;
        L10:
            if (r4 < 0) goto L16;
            if (r2.get(r4) != r9) goto L14;
            r2.remove(r4);
            r3.remove(r4);
        L14:
            r4 = r4 - 1;
            goto L10
        L16:
            if (r2.size() != 0) goto L28;
            MediaBrowserCompatApi21.unsubscribe(this.mBrowserObj, r8);
            goto L28
        L32:
            if (r9 != null) goto L20;
            r1.removeSubscription(r8, null, this.mCallbacksMessenger);     // Catch: RemoteException -> L26
            goto L28
        L20:
            List<SubscriptionCallback> r5 = r0.getCallbacks();     // Catch: RemoteException -> L26
            List<Bundle> r6 = r0.getOptionsList();     // Catch: RemoteException -> L26
            int r7 = r5.size() - 1;     // Catch: RemoteException -> L26
        L21:
            if (r7 < 0) goto L28;
            if (r5.get(r7) != r9) goto L25;
            this.mServiceBinderWrapper.removeSubscription(r8, r9.mToken, this.mCallbacksMessenger);     // Catch: RemoteException -> L26
            r5.remove(r7);     // Catch: RemoteException -> L26
            r6.remove(r7);     // Catch: RemoteException -> L26
        L25:
            r7 = r7 - 1;
        L26:
            Log.d(MediaBrowserCompat.TAG, "removeSubscription failed with RemoteException parentId=" + r8);
            goto L28
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onConnectionFailed(Messenger r1) {
        }
    }

    @RequiresApi(23)
    public static class MediaBrowserImplApi23 extends MediaBrowserImplApi21 {
        public MediaBrowserImplApi23(Context r1, ComponentName r2, ConnectionCallback r3, Bundle r4) {
            super(r1, r2, r3, r4);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21, android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void getItem(@NonNull String r2, @NonNull ItemCallback r3) {
            if (this.mServiceBinderWrapper != null) goto L5;
            MediaBrowserCompatApi23.getItem(this.mBrowserObj, r2, r3.mItemCallbackObj);
            return;
        L5:
            super.getItem(r2, r3);
        }
    }

    @RequiresApi(26)
    public static class MediaBrowserImplApi26 extends MediaBrowserImplApi23 {
        public MediaBrowserImplApi26(Context r1, ComponentName r2, ConnectionCallback r3, Bundle r4) {
            super(r1, r2, r3, r4);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21, android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void subscribe(@NonNull String r3, @Nullable Bundle r4, @NonNull SubscriptionCallback r5) {
            if (this.mServiceBinderWrapper != null) goto L5;
        L8:
            if (r4 != null) goto L10;
            MediaBrowserCompatApi21.subscribe(this.mBrowserObj, r3, r5.mSubscriptionCallbackObj);
            return;
        L10:
            MediaBrowserCompatApi26.subscribe(this.mBrowserObj, r3, r4, r5.mSubscriptionCallbackObj);
            return;
        L5:
            if (this.mServiceVersion < 2) goto L8;
            super.subscribe(r3, r4, r5);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImplApi21, android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void unsubscribe(@NonNull String r3, SubscriptionCallback r4) {
            if (this.mServiceBinderWrapper != null) goto L5;
        L8:
            if (r4 != null) goto L10;
            MediaBrowserCompatApi21.unsubscribe(this.mBrowserObj, r3);
            return;
        L10:
            MediaBrowserCompatApi26.unsubscribe(this.mBrowserObj, r3, r4.mSubscriptionCallbackObj);
            return;
        L5:
            if (this.mServiceVersion < 2) goto L8;
            super.unsubscribe(r3, r4);
        }
    }

    public static class MediaBrowserImplBase implements MediaBrowserImpl, MediaBrowserServiceCallbackImpl {
        static final int CONNECT_STATE_CONNECTED = 3;
        static final int CONNECT_STATE_CONNECTING = 2;
        static final int CONNECT_STATE_DISCONNECTED = 1;
        static final int CONNECT_STATE_DISCONNECTING = 0;
        static final int CONNECT_STATE_SUSPENDED = 4;
        final ConnectionCallback mCallback;
        Messenger mCallbacksMessenger;
        final Context mContext;
        private Bundle mExtras;
        final CallbackHandler mHandler;
        private MediaSessionCompat.Token mMediaSessionToken;
        private Bundle mNotifyChildrenChangedOptions;
        final Bundle mRootHints;
        private String mRootId;
        ServiceBinderWrapper mServiceBinderWrapper;
        final ComponentName mServiceComponent;
        MediaServiceConnection mServiceConnection;
        int mState;
        private final ArrayMap<String, Subscription> mSubscriptions;

        public class MediaServiceConnection implements ServiceConnection {
            final /* synthetic */ MediaBrowserImplBase this$0;

            public MediaServiceConnection(MediaBrowserImplBase r1) {
                this.this$0 = r1;
            }

            private void postOrRun(Runnable r3) {
                if (Thread.currentThread() != this.this$0.mHandler.getLooper().getThread()) goto L5;
                r3.run();
                return;
            L5:
                this.this$0.mHandler.post(r3);
            }

            public boolean isCurrent(String r4) {
                MediaBrowserImplBase r0 = this.this$0;
                if (r0.mServiceConnection != this) goto L9;
                int r1 = r0.mState;
                if (r1 == 0) goto L9;
                if (r1 == 1) goto L9;
                return true;
            L9:
                int r2 = r0.mState;
                if (r2 == 0) goto L15;
                if (r2 == 1) goto L16;
                StringBuilder r5 = a.t(r4, " for ");
                r5.append(this.this$0.mServiceComponent);
                r5.append(" with mServiceConnection=");
                r5.append(this.this$0.mServiceConnection);
                r5.append(" this=");
                r5.append(this);
                Log.i(MediaBrowserCompat.TAG, r5.toString());
                return false;
            L16:
                return false;
            L15:
                return false;
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(final ComponentName r2, final IBinder r3) {
                postOrRun(new AnonymousClass1(this, r2, r3));
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(final ComponentName r2) {
                postOrRun(new AnonymousClass2(this, r2));
            }
        }

        public MediaBrowserImplBase(Context r2, ComponentName r3, ConnectionCallback r4, Bundle r5) {
            this.mHandler = new CallbackHandler(this);
            this.mSubscriptions = new ArrayMap();
            this.mState = 1;
            if (r2 == null) goto L17;
            if (r3 == null) goto L15;
            if (r4 == null) goto L13;
            this.mContext = r2;
            this.mServiceComponent = r3;
            this.mCallback = r4;
            if (r5 != null) goto L9;
            Bundle r6 = null;
        L10:
            this.mRootHints = r6;
            return;
        L9:
            r6 = new Bundle(r5);
            goto L10
        L13:
            throw new IllegalArgumentException("connection callback must not be null");
        L15:
            throw new IllegalArgumentException("service component must not be null");
        L17:
            throw new IllegalArgumentException("context must not be null");
        }

        private static String getStateLabel(int r1) {
            if (r1 != 0) goto L4;
            return "CONNECT_STATE_DISCONNECTING";
        L4:
            if (r1 != 1) goto L6;
            return "CONNECT_STATE_DISCONNECTED";
        L6:
            if (r1 != 2) goto L8;
            return "CONNECT_STATE_CONNECTING";
        L8:
            if (r1 != 3) goto L10;
            return "CONNECT_STATE_CONNECTED";
        L10:
            if (r1 != 4) goto L12;
            return "CONNECT_STATE_SUSPENDED";
        L12:
            return a.e(r1, "UNKNOWN/");
        }

        private boolean isCurrent(Messenger r3, String r4) {
            if (this.mCallbacksMessenger != r3) goto L9;
            int r5 = this.mState;
            if (r5 == 0) goto L9;
            if (r5 == 1) goto L9;
            return true;
        L9:
            int r6 = this.mState;
            if (r6 == 0) goto L15;
            if (r6 == 1) goto L16;
            StringBuilder r7 = a.t(r4, " for ");
            r7.append(this.mServiceComponent);
            r7.append(" with mCallbacksMessenger=");
            r7.append(this.mCallbacksMessenger);
            r7.append(" this=");
            r7.append(this);
            Log.i(MediaBrowserCompat.TAG, r7.toString());
            return false;
        L16:
            return false;
        L15:
            return false;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void connect() {
            int r0 = this.mState;
            if (r0 != 0) goto L5;
        L9:
            this.mState = 2;
            this.mHandler.post(new AnonymousClass1(this));
            return;
        L5:
            if (r0 == 1) goto L9;
            throw new IllegalStateException(a.o(new StringBuilder("connect() called while neigther disconnecting nor disconnected (state="), getStateLabel(this.mState), ")"));
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void disconnect() {
            this.mState = 0;
            this.mHandler.post(new AnonymousClass2(this));
        }

        public void dump() {
            Log.d(MediaBrowserCompat.TAG, "MediaBrowserCompat...");
            Log.d(MediaBrowserCompat.TAG, "  mServiceComponent=" + this.mServiceComponent);
            Log.d(MediaBrowserCompat.TAG, "  mCallback=" + this.mCallback);
            Log.d(MediaBrowserCompat.TAG, "  mRootHints=" + this.mRootHints);
            Log.d(MediaBrowserCompat.TAG, "  mState=" + getStateLabel(this.mState));
            Log.d(MediaBrowserCompat.TAG, "  mServiceConnection=" + this.mServiceConnection);
            Log.d(MediaBrowserCompat.TAG, "  mServiceBinderWrapper=" + this.mServiceBinderWrapper);
            Log.d(MediaBrowserCompat.TAG, "  mCallbacksMessenger=" + this.mCallbacksMessenger);
            Log.d(MediaBrowserCompat.TAG, "  mRootId=" + this.mRootId);
            Log.d(MediaBrowserCompat.TAG, "  mMediaSessionToken=" + this.mMediaSessionToken);
        }

        public void forceCloseConnection() {
            MediaServiceConnection r0 = this.mServiceConnection;
            if (r0 == null) goto L5;
            this.mContext.unbindService(r0);
        L5:
            this.mState = 1;
            this.mServiceConnection = null;
            this.mServiceBinderWrapper = null;
            this.mCallbacksMessenger = null;
            this.mHandler.setCallbacksMessenger(null);
            this.mRootId = null;
            this.mMediaSessionToken = null;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        @Nullable
        public Bundle getExtras() {
            if (isConnected() == false) goto L7;
            return this.mExtras;
        L7:
            throw new IllegalStateException(a.o(new StringBuilder("getExtras() called while not connected (state="), getStateLabel(this.mState), ")"));
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void getItem(@NonNull final String r5, @NonNull final ItemCallback r6) {
            if (TextUtils.isEmpty(r5) == true) goto L17;
            if (r6 == null) goto L15;
            if (isConnected() == true) goto L18;
            Log.i(MediaBrowserCompat.TAG, "Not connected, unable to retrieve the MediaItem.");
            this.mHandler.post(new AnonymousClass3(this, r6, r5));
            return;
        L18:
            this.mServiceBinderWrapper.getMediaItem(r5, new ItemReceiver(r5, r6, this.mHandler), this.mCallbacksMessenger);     // Catch: RemoteException -> L12
            return;
        L12:
            Log.i(MediaBrowserCompat.TAG, "Remote error getting media item: " + r5);
            this.mHandler.post(new AnonymousClass4(this, r6, r5));
            return;
        L15:
            throw new IllegalArgumentException("cb is null");
        L17:
            throw new IllegalArgumentException("mediaId is empty");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public Bundle getNotifyChildrenChangedOptions() {
            return this.mNotifyChildrenChangedOptions;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        @NonNull
        public String getRoot() {
            if (isConnected() == false) goto L7;
            return this.mRootId;
        L7:
            throw new IllegalStateException(a.o(new StringBuilder("getRoot() called while not connected(state="), getStateLabel(this.mState), ")"));
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        @NonNull
        public ComponentName getServiceComponent() {
            if (isConnected() == false) goto L7;
            return this.mServiceComponent;
        L7:
            throw new IllegalStateException(a.n(new StringBuilder("getServiceComponent() called while not connected (state="), ")", this.mState));
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        @NonNull
        public MediaSessionCompat.Token getSessionToken() {
            if (isConnected() == false) goto L7;
            return this.mMediaSessionToken;
        L7:
            throw new IllegalStateException(a.n(new StringBuilder("getSessionToken() called while not connected(state="), ")", this.mState));
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public boolean isConnected() {
            if (this.mState != 3) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onConnectionFailed(Messenger r3) {
            Log.e(MediaBrowserCompat.TAG, "onConnectFailed for " + this.mServiceComponent);
            if (isCurrent(r3, "onConnectFailed") == true) goto L6;
            return;
        L6:
            if (this.mState == 2) goto L9;
            Log.w(MediaBrowserCompat.TAG, "onConnect from service while mState=" + getStateLabel(this.mState) + "... ignoring");
            return;
        L9:
            forceCloseConnection();
            this.mCallback.onConnectionFailed();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onLoadChildren(Messenger r4, String r5, List r6, Bundle r7, Bundle r8) {
            if (isCurrent(r4, "onLoadChildren") == true) goto L5;
            return;
        L5:
            boolean r9 = MediaBrowserCompat.DEBUG;
            if (r9 == false) goto L8;
            Log.d(MediaBrowserCompat.TAG, "onLoadChildren for " + this.mServiceComponent + " id=" + r5);
        L8:
            Subscription r1 = this.mSubscriptions.get(r5);
            if (r1 != null) goto L13;
            if (r9 == false) goto L24;
            Log.d(MediaBrowserCompat.TAG, "onLoadChildren for id that isn't subscribed id=" + r5);
            return;
        L24:
            return;
        L13:
            SubscriptionCallback r10 = r1.getCallback(r7);
            if (r10 != null) goto L16;
            return;
        L16:
            if (r7 != null) goto L20;
            if (r6 != null) goto L19;
            r10.onError(r5);
            return;
        L19:
            this.mNotifyChildrenChangedOptions = r8;
            r10.onChildrenLoaded(r5, r6);
            this.mNotifyChildrenChangedOptions = null;
            return;
        L20:
            if (r6 != null) goto L22;
            r10.onError(r5, r7);
            return;
        L22:
            this.mNotifyChildrenChangedOptions = r8;
            r10.onChildrenLoaded(r5, r6, r7);
            this.mNotifyChildrenChangedOptions = null;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserServiceCallbackImpl
        public void onServiceConnected(Messenger r7, String r8, MediaSessionCompat.Token r9, Bundle r10) {
            if (isCurrent(r7, "onConnect") == true) goto L6;
            return;
        L6:
            if (this.mState == 2) goto L9;
            Log.w(MediaBrowserCompat.TAG, "onConnect from service while mState=" + getStateLabel(this.mState) + "... ignoring");
            return;
        L9:
            this.mRootId = r8;
            this.mMediaSessionToken = r9;
            this.mExtras = r10;
            this.mState = 3;
            if (MediaBrowserCompat.DEBUG == false) goto L12;
            Log.d(MediaBrowserCompat.TAG, "ServiceCallbacks.onConnect...");
            dump();
        L12:
            this.mCallback.onConnected();
            Iterator<Map.Entry<String, Subscription>> r11 = this.mSubscriptions.entrySet().iterator();     // Catch: RemoteException -> L21
        L15:
            if (r11.hasNext() == false) goto L27;
            Map.Entry<String, Subscription> r12 = r11.next();     // Catch: RemoteException -> L21
            String r13 = r12.getKey();     // Catch: RemoteException -> L21
            Subscription r14 = r12.getValue();     // Catch: RemoteException -> L21
            List<SubscriptionCallback> r15 = r14.getCallbacks();     // Catch: RemoteException -> L21
            List<Bundle> r16 = r14.getOptionsList();     // Catch: RemoteException -> L21
            int r0 = 0;
        L18:
            if (r0 >= r15.size()) goto L15;
            this.mServiceBinderWrapper.addSubscription(r13, r15.get(r0).mToken, r16.get(r0), this.mCallbacksMessenger);     // Catch: RemoteException -> L21
            r0 = r0 + 1;
            goto L18
        L27:
            return;
        L21:
            Log.d(MediaBrowserCompat.TAG, "addSubscription failed with RemoteException.");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void search(@NonNull final String r4, final Bundle r5, @NonNull final SearchCallback r6) {
            if (isConnected() == false) goto L11;
            this.mServiceBinderWrapper.search(r4, r5, new SearchResultReceiver(r4, r5, r6, this.mHandler), this.mCallbacksMessenger);     // Catch: RemoteException -> L7
            return;
        L7:
            e = move-exception;
            Log.i(MediaBrowserCompat.TAG, "Remote error searching items with query: " + r4, e);
            this.mHandler.post(new AnonymousClass5(this, r6, r4, r5));
            return;
        L11:
            throw new IllegalStateException(a.o(new StringBuilder("search() called while not connected (state="), getStateLabel(this.mState), ")"));
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void sendCustomAction(@NonNull final String r4, final Bundle r5, @Nullable final CustomActionCallback r6) {
            if (isConnected() == false) goto L13;
            this.mServiceBinderWrapper.sendCustomAction(r4, r5, new CustomActionResultReceiver(r4, r5, r6, this.mHandler), this.mCallbacksMessenger);     // Catch: RemoteException -> L7
            return;
        L7:
            e = move-exception;
            Log.i(MediaBrowserCompat.TAG, "Remote error sending a custom action: action=" + r4 + ", extras=" + r5, e);
            if (r6 == null) goto L16;
            this.mHandler.post(new AnonymousClass6(this, r6, r4, r5));
            return;
        L16:
            return;
        L13:
            throw new IllegalStateException("Cannot send a custom action (" + r4 + ") with extras " + r5 + " because the browser is not connected to the service.");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void subscribe(@NonNull String r3, Bundle r4, @NonNull SubscriptionCallback r5) {
            Subscription r0 = this.mSubscriptions.get(r3);
            if (r0 != null) goto L5;
            r0 = new Subscription();
            this.mSubscriptions.put(r3, r0);
        L5:
            if (r4 != null) goto L7;
            Bundle r6 = null;
        L8:
            r0.putCallback(r6, r5);
            if (isConnected() == false) goto L16;
            this.mServiceBinderWrapper.addSubscription(r3, r5.mToken, r6, this.mCallbacksMessenger);     // Catch: RemoteException -> L12
            return;
        L12:
            Log.d(MediaBrowserCompat.TAG, "addSubscription failed with RemoteException parentId=" + r3);
            return;
        L16:
            return;
        L7:
            r6 = new Bundle(r4);
            goto L8
        }

        @Override // android.support.v4.media.MediaBrowserCompat.MediaBrowserImpl
        public void unsubscribe(@NonNull String r8, SubscriptionCallback r9) {
            Subscription r0 = this.mSubscriptions.get(r8);
            if (r0 != null) goto L24;
            return;
        L24:
            if (r9 == null) goto L7;
            List<SubscriptionCallback> r1 = r0.getCallbacks();     // Catch: RemoteException -> L18
            List<Bundle> r2 = r0.getOptionsList();     // Catch: RemoteException -> L18
            int r3 = r1.size() - 1;     // Catch: RemoteException -> L18
        L10:
            if (r3 < 0) goto L20;
            if (r1.get(r3) != r9) goto L17;
            if (isConnected() == false) goto L16;
            this.mServiceBinderWrapper.removeSubscription(r8, r9.mToken, this.mCallbacksMessenger);     // Catch: RemoteException -> L18
        L16:
            r1.remove(r3);     // Catch: RemoteException -> L18
            r2.remove(r3);     // Catch: RemoteException -> L18
        L17:
            r3 = r3 - 1;
        L20:
            if (r0.isEmpty() == true) goto L22;
            if (r9 == null) goto L22;
            return;
        L22:
            this.mSubscriptions.remove(r8);
            return;
        L7:
            if (isConnected() == false) goto L20;
            this.mServiceBinderWrapper.removeSubscription(r8, null, this.mCallbacksMessenger);     // Catch: RemoteException -> L18
        L18:
            Log.d(MediaBrowserCompat.TAG, "removeSubscription failed with RemoteException parentId=" + r8);
            goto L20
        }
    }

    public interface MediaBrowserServiceCallbackImpl {
        void onConnectionFailed(Messenger r1);

        void onLoadChildren(Messenger r1, String r2, List r3, Bundle r4, Bundle r5);

        void onServiceConnected(Messenger r1, String r2, MediaSessionCompat.Token r3, Bundle r4);
    }

    public static class MediaItem implements Parcelable {
        public static final Parcelable.Creator<MediaItem> CREATOR = null;
        public static final int FLAG_BROWSABLE = 1;
        public static final int FLAG_PLAYABLE = 2;
        private final MediaDescriptionCompat mDescription;
        private final int mFlags;

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public @interface Flags {
        }

        static {
            CREATOR = new AnonymousClass1();
        }

        public MediaItem(@NonNull MediaDescriptionCompat r2, int r3) {
            if (r2 == null) goto L11;
            if (TextUtils.isEmpty(r2.getMediaId()) == true) goto L9;
            this.mFlags = r3;
            this.mDescription = r2;
            return;
        L9:
            throw new IllegalArgumentException("description must have a non-empty media id");
        L11:
            throw new IllegalArgumentException("description cannot be null");
        }

        public static MediaItem fromMediaItem(Object r2) {
            if (r2 == null) goto L5;
            int r0 = MediaBrowserCompatApi21.MediaItem.getFlags(r2);
            return new MediaItem(MediaDescriptionCompat.fromMediaDescription(MediaBrowserCompatApi21.MediaItem.getDescription(r2)), r0);
        L5:
            return null;
        }

        public static List<MediaItem> fromMediaItemList(List<?> r2) {
            if (r2 == null) goto L8;
            ArrayList r0 = new ArrayList(r2.size());
            Iterator<?> r3 = r2.iterator();
        L5:
            if (r3.hasNext() == false) goto L7;
            r0.add(fromMediaItem(r3.next()));
            goto L5
        L7:
            return r0;
        L8:
            return null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NonNull
        public MediaDescriptionCompat getDescription() {
            return this.mDescription;
        }

        public int getFlags() {
            return this.mFlags;
        }

        @Nullable
        public String getMediaId() {
            return this.mDescription.getMediaId();
        }

        public boolean isBrowsable() {
            if ((this.mFlags & 1) != 0) goto L7;
            return false;
        L7:
            return true;
        }

        public boolean isPlayable() {
            if ((this.mFlags & 2) == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public String toString() {
            return "MediaItem{mFlags=" + this.mFlags + ", mDescription=" + this.mDescription + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r2, int r3) {
            r2.writeInt(this.mFlags);
            this.mDescription.writeToParcel(r2, r3);
        }

        public MediaItem(Parcel r2) {
            this.mFlags = r2.readInt();
            this.mDescription = MediaDescriptionCompat.CREATOR.createFromParcel(r2);
        }
    }

    public static abstract class SearchCallback {
        public SearchCallback() {
        }

        public void onError(@NonNull String r1, Bundle r2) {
        }

        public void onSearchResult(@NonNull String r1, Bundle r2, @NonNull List<MediaItem> r3) {
        }
    }

    public static class SearchResultReceiver extends ResultReceiver {
        private final SearchCallback mCallback;
        private final Bundle mExtras;
        private final String mQuery;

        public SearchResultReceiver(String r1, Bundle r2, SearchCallback r3, Handler r4) {
            super(r4);
            this.mQuery = r1;
            this.mExtras = r2;
            this.mCallback = r3;
        }

        @Override // android.support.v4.os.ResultReceiver
        public void onReceiveResult(int r4, Bundle r5) {
            MediaSessionCompat.ensureClassLoader(r5);
            if (r4 != 0) goto L16;
            if (r5 == null) goto L16;
            if (r5.containsKey(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS) == false) goto L16;
            Parcelable[] r6 = r5.getParcelableArray(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS);
            if (r6 == null) goto L13;
            ArrayList r7 = new ArrayList();
            int r0 = r6.length;
            int r1 = 0;
        L11:
            if (r1 >= r0) goto L14;
            r7.add((MediaItem) r6[r1]);
            r1 = r1 + 1;
        L14:
            this.mCallback.onSearchResult(this.mQuery, this.mExtras, r7);
            return;
        L13:
            r7 = null;
        L16:
            this.mCallback.onError(this.mQuery, this.mExtras);
        }
    }

    public static class ServiceBinderWrapper {
        private Messenger mMessenger;
        private Bundle mRootHints;

        public ServiceBinderWrapper(IBinder r2, Bundle r3) {
            this.mMessenger = new Messenger(r2);
            this.mRootHints = r3;
        }

        private void sendRequest(int r2, Bundle r3, Messenger r4) {
            Message r0 = Message.obtain();
            r0.what = r2;
            r0.arg1 = 1;
            r0.setData(r3);
            r0.replyTo = r4;
            this.mMessenger.send(r0);
        }

        public void addSubscription(String r3, IBinder r4, Bundle r5, Messenger r6) {
            Bundle r0 = new Bundle();
            r0.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, r3);
            BundleCompat.putBinder(r0, MediaBrowserProtocol.DATA_CALLBACK_TOKEN, r4);
            r0.putBundle(MediaBrowserProtocol.DATA_OPTIONS, r5);
            sendRequest(3, r0, r6);
        }

        public void connect(Context r3, Messenger r4) {
            Bundle r0 = new Bundle();
            r0.putString(MediaBrowserProtocol.DATA_PACKAGE_NAME, r3.getPackageName());
            r0.putBundle(MediaBrowserProtocol.DATA_ROOT_HINTS, this.mRootHints);
            sendRequest(1, r0, r4);
        }

        public void disconnect(Messenger r3) {
            sendRequest(2, null, r3);
        }

        public void getMediaItem(String r3, ResultReceiver r4, Messenger r5) {
            Bundle r0 = new Bundle();
            r0.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, r3);
            r0.putParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER, r4);
            sendRequest(5, r0, r5);
        }

        public void registerCallbackMessenger(Context r3, Messenger r4) {
            Bundle r0 = new Bundle();
            r0.putString(MediaBrowserProtocol.DATA_PACKAGE_NAME, r3.getPackageName());
            r0.putBundle(MediaBrowserProtocol.DATA_ROOT_HINTS, this.mRootHints);
            sendRequest(6, r0, r4);
        }

        public void removeSubscription(String r3, IBinder r4, Messenger r5) {
            Bundle r0 = new Bundle();
            r0.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, r3);
            BundleCompat.putBinder(r0, MediaBrowserProtocol.DATA_CALLBACK_TOKEN, r4);
            sendRequest(4, r0, r5);
        }

        public void search(String r3, Bundle r4, ResultReceiver r5, Messenger r6) {
            Bundle r0 = new Bundle();
            r0.putString(MediaBrowserProtocol.DATA_SEARCH_QUERY, r3);
            r0.putBundle(MediaBrowserProtocol.DATA_SEARCH_EXTRAS, r4);
            r0.putParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER, r5);
            sendRequest(8, r0, r6);
        }

        public void sendCustomAction(String r3, Bundle r4, ResultReceiver r5, Messenger r6) {
            Bundle r0 = new Bundle();
            r0.putString(MediaBrowserProtocol.DATA_CUSTOM_ACTION, r3);
            r0.putBundle(MediaBrowserProtocol.DATA_CUSTOM_ACTION_EXTRAS, r4);
            r0.putParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER, r5);
            sendRequest(9, r0, r6);
        }

        public void unregisterCallbackMessenger(Messenger r3) {
            sendRequest(7, null, r3);
        }
    }

    public static class Subscription {
        private final List<SubscriptionCallback> mCallbacks;
        private final List<Bundle> mOptionsList;

        public Subscription() {
            this.mCallbacks = new ArrayList();
            this.mOptionsList = new ArrayList();
        }

        public SubscriptionCallback getCallback(Bundle r3) {
            int r0 = 0;
        L4:
            if (r0 >= this.mOptionsList.size()) goto L10;
            if (MediaBrowserCompatUtils.areSameOptions(this.mOptionsList.get(r0), r3) == true) goto L8;
            r0 = r0 + 1;
            goto L4
        L8:
            return this.mCallbacks.get(r0);
        L10:
            return null;
        }

        public List<SubscriptionCallback> getCallbacks() {
            return this.mCallbacks;
        }

        public List<Bundle> getOptionsList() {
            return this.mOptionsList;
        }

        public boolean isEmpty() {
            return this.mCallbacks.isEmpty();
        }

        public void putCallback(Bundle r3, SubscriptionCallback r4) {
            int r0 = 0;
        L4:
            if (r0 >= this.mOptionsList.size()) goto L10;
            if (MediaBrowserCompatUtils.areSameOptions(this.mOptionsList.get(r0), r3) == true) goto L7;
            r0 = r0 + 1;
            goto L4
        L7:
            this.mCallbacks.set(r0, r4);
            return;
        L10:
            this.mCallbacks.add(r4);
            this.mOptionsList.add(r3);
        }
    }

    public static abstract class SubscriptionCallback {
        final Object mSubscriptionCallbackObj;
        WeakReference<Subscription> mSubscriptionRef;
        final IBinder mToken;

        public class StubApi21 implements MediaBrowserCompatApi21.SubscriptionCallback {
            final /* synthetic */ SubscriptionCallback this$0;

            public StubApi21(SubscriptionCallback r1) {
                this.this$0 = r1;
            }

            public List<MediaItem> applyOptions(List<MediaItem> r3, Bundle r4) {
                if (r3 != null) goto L5;
                return null;
            L5:
                int r2 = r4.getInt(MediaBrowserCompat.EXTRA_PAGE, -1);
                int r5 = r4.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
                if (r2 != (-1)) goto L9;
                if (r5 != (-1)) goto L9;
                return r3;
            L9:
                int r0 = r5 * r2;
                int r1 = r0 + r5;
                if (r2 < 0) goto L22;
                if (r5 < 1) goto L22;
                if (r0 >= r3.size()) goto L22;
                if (r1 <= r3.size()) goto L20;
                r1 = r3.size();
            L20:
                return r3.subList(r0, r1);
            L22:
                return Collections.emptyList();
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi21.SubscriptionCallback
            public void onChildrenLoaded(@NonNull String r7, List<?> r8) {
                WeakReference<Subscription> r0 = this.this$0.mSubscriptionRef;
                if (r0 != null) goto L5;
                Subscription r1 = null;
            L6:
                if (r1 != null) goto L8;
                this.this$0.onChildrenLoaded(r7, MediaItem.fromMediaItemList(r8));
                return;
            L8:
                List<MediaItem> r9 = MediaItem.fromMediaItemList(r8);
                List<SubscriptionCallback> r2 = r1.getCallbacks();
                List<Bundle> r3 = r1.getOptionsList();
                int r4 = 0;
            L10:
                if (r4 >= r2.size()) goto L20;
                Bundle r5 = r3.get(r4);
                if (r5 != null) goto L14;
                this.this$0.onChildrenLoaded(r7, r9);
            L15:
                r4 = r4 + 1;
                goto L10
            L14:
                this.this$0.onChildrenLoaded(r7, applyOptions(r9, r5), r5);
                goto L15
            L20:
                return;
            L5:
                r1 = r0.get();
                goto L6
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi21.SubscriptionCallback
            public void onError(@NonNull String r1) {
                this.this$0.onError(r1);
            }
        }

        public class StubApi26 extends StubApi21 implements MediaBrowserCompatApi26.SubscriptionCallback {
            final /* synthetic */ SubscriptionCallback this$0;

            public StubApi26(SubscriptionCallback r1) {
                this.this$0 = r1;
                super(r1);
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi26.SubscriptionCallback
            public void onChildrenLoaded(@NonNull String r1, List<?> r2, @NonNull Bundle r3) {
                this.this$0.onChildrenLoaded(r1, MediaItem.fromMediaItemList(r2), r3);
            }

            @Override // android.support.v4.media.MediaBrowserCompatApi26.SubscriptionCallback
            public void onError(@NonNull String r1, @NonNull Bundle r2) {
                this.this$0.onError(r1, r2);
            }
        }

        public SubscriptionCallback() {
            this.mToken = new Binder();
            this.mSubscriptionCallbackObj = MediaBrowserCompatApi26.createSubscriptionCallback(new StubApi26(this));
        }

        public void onChildrenLoaded(@NonNull String r1, @NonNull List<MediaItem> r2) {
        }

        public void onError(@NonNull String r1) {
        }

        public void setSubscription(Subscription r2) {
            this.mSubscriptionRef = new WeakReference(r2);
        }

        public void onChildrenLoaded(@NonNull String r1, @NonNull List<MediaItem> r2, @NonNull Bundle r3) {
        }

        public void onError(@NonNull String r1, @NonNull Bundle r2) {
        }
    }

    static {
        DEBUG = Log.isLoggable(TAG, 3);
    }

    public MediaBrowserCompat(Context r2, ComponentName r3, ConnectionCallback r4, Bundle r5) {
        this.mImpl = new MediaBrowserImplApi26(r2, r3, r4, r5);
    }

    public void connect() {
        this.mImpl.connect();
    }

    public void disconnect() {
        this.mImpl.disconnect();
    }

    @Nullable
    public Bundle getExtras() {
        return this.mImpl.getExtras();
    }

    public void getItem(@NonNull String r1, @NonNull ItemCallback r2) {
        this.mImpl.getItem(r1, r2);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Bundle getNotifyChildrenChangedOptions() {
        return this.mImpl.getNotifyChildrenChangedOptions();
    }

    @NonNull
    public String getRoot() {
        return this.mImpl.getRoot();
    }

    @NonNull
    public ComponentName getServiceComponent() {
        return this.mImpl.getServiceComponent();
    }

    @NonNull
    public MediaSessionCompat.Token getSessionToken() {
        return this.mImpl.getSessionToken();
    }

    public boolean isConnected() {
        return this.mImpl.isConnected();
    }

    public void search(@NonNull String r2, Bundle r3, @NonNull SearchCallback r4) {
        if (TextUtils.isEmpty(r2) == true) goto L10;
        if (r4 == null) goto L8;
        this.mImpl.search(r2, r3, r4);
        return;
    L8:
        throw new IllegalArgumentException("callback cannot be null");
    L10:
        throw new IllegalArgumentException("query cannot be empty");
    }

    public void sendCustomAction(@NonNull String r2, Bundle r3, @Nullable CustomActionCallback r4) {
        if (TextUtils.isEmpty(r2) == true) goto L7;
        this.mImpl.sendCustomAction(r2, r3, r4);
        return;
    L7:
        throw new IllegalArgumentException("action cannot be empty");
    }

    public void subscribe(@NonNull String r2, @NonNull SubscriptionCallback r3) {
        if (TextUtils.isEmpty(r2) == true) goto L10;
        if (r3 == null) goto L8;
        this.mImpl.subscribe(r2, null, r3);
        return;
    L8:
        throw new IllegalArgumentException("callback is null");
    L10:
        throw new IllegalArgumentException("parentId is empty");
    }

    public void unsubscribe(@NonNull String r2) {
        if (TextUtils.isEmpty(r2) == true) goto L7;
        this.mImpl.unsubscribe(r2, null);
        return;
    L7:
        throw new IllegalArgumentException("parentId is empty");
    }

    public void unsubscribe(@NonNull String r2, @NonNull SubscriptionCallback r3) {
        if (TextUtils.isEmpty(r2) == true) goto L10;
        if (r3 == null) goto L8;
        this.mImpl.unsubscribe(r2, r3);
        return;
    L8:
        throw new IllegalArgumentException("callback is null");
    L10:
        throw new IllegalArgumentException("parentId is empty");
    }

    public void subscribe(@NonNull String r2, @NonNull Bundle r3, @NonNull SubscriptionCallback r4) {
        if (TextUtils.isEmpty(r2) == true) goto L13;
        if (r4 == null) goto L11;
        if (r3 == null) goto L9;
        this.mImpl.subscribe(r2, r3, r4);
        return;
    L9:
        throw new IllegalArgumentException("options are null");
    L11:
        throw new IllegalArgumentException("callback is null");
    L13:
        throw new IllegalArgumentException("parentId is empty");
    }
}

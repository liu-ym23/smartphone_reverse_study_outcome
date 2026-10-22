package android.support.v4.media.session;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import androidx.core.app.BundleCompat;
import androidx.core.app.ComponentActivity;
import com.bytedance.librarian.LibrarianImpl;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class MediaControllerCompat {
    public static final String COMMAND_ADD_QUEUE_ITEM = "android.support.v4.media.session.command.ADD_QUEUE_ITEM";
    public static final String COMMAND_ADD_QUEUE_ITEM_AT = "android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT";
    public static final String COMMAND_ARGUMENT_INDEX = "android.support.v4.media.session.command.ARGUMENT_INDEX";
    public static final String COMMAND_ARGUMENT_MEDIA_DESCRIPTION = "android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION";
    public static final String COMMAND_GET_EXTRA_BINDER = "android.support.v4.media.session.command.GET_EXTRA_BINDER";
    public static final String COMMAND_REMOVE_QUEUE_ITEM = "android.support.v4.media.session.command.REMOVE_QUEUE_ITEM";
    public static final String COMMAND_REMOVE_QUEUE_ITEM_AT = "android.support.v4.media.session.command.REMOVE_QUEUE_ITEM_AT";
    static final String TAG = "MediaControllerCompat";
    private final MediaControllerImpl mImpl;
    private final HashSet<Callback> mRegisteredCallbacks;
    private final MediaSessionCompat.Token mToken;

    public static abstract class Callback implements IBinder.DeathRecipient {
        final Object mCallbackObj;
        MessageHandler mHandler;
        IMediaControllerCallback mIControllerCallback;

        private class MessageHandler extends Handler {
            private static final int MSG_DESTROYED = 8;
            private static final int MSG_EVENT = 1;
            private static final int MSG_SESSION_READY = 13;
            private static final int MSG_UPDATE_CAPTIONING_ENABLED = 11;
            private static final int MSG_UPDATE_EXTRAS = 7;
            private static final int MSG_UPDATE_METADATA = 3;
            private static final int MSG_UPDATE_PLAYBACK_STATE = 2;
            private static final int MSG_UPDATE_QUEUE = 5;
            private static final int MSG_UPDATE_QUEUE_TITLE = 6;
            private static final int MSG_UPDATE_REPEAT_MODE = 9;
            private static final int MSG_UPDATE_SHUFFLE_MODE = 12;
            private static final int MSG_UPDATE_VOLUME = 4;
            boolean mRegistered;
            final /* synthetic */ Callback this$0;

            MessageHandler(Callback r1, Looper r2) {
                this.this$0 = r1;
                super(r2);
                this.mRegistered = false;
            }

            @Override // android.os.Handler
            public void handleMessage(Message r2) {
                if (this.mRegistered == true) goto L6;
                return;
            L6:
                switch(r2.what) {
                    case 1: goto L19;
                    case 2: goto L18;
                    case 3: goto L17;
                    case 4: goto L16;
                    case 5: goto L15;
                    case 6: goto L14;
                    case 7: goto L13;
                    case 8: goto L12;
                    case 9: goto L11;
                    case 10: goto L32;
                    case 11: goto L10;
                    case 12: goto L9;
                    case 13: goto L8;
                    default: goto L32;
                };
            L8:
                this.this$0.onSessionReady();
                return;
            L9:
                this.this$0.onShuffleModeChanged(((Integer) r2.obj).intValue());
                return;
            L10:
                this.this$0.onCaptioningEnabledChanged(((Boolean) r2.obj).booleanValue());
                return;
            L11:
                this.this$0.onRepeatModeChanged(((Integer) r2.obj).intValue());
                return;
            L12:
                this.this$0.onSessionDestroyed();
                return;
            L13:
                Bundle r3 = (Bundle) r2.obj;
                MediaSessionCompat.ensureClassLoader(r3);
                this.this$0.onExtrasChanged(r3);
                return;
            L14:
                this.this$0.onQueueTitleChanged((CharSequence) r2.obj);
                return;
            L15:
                this.this$0.onQueueChanged((List) r2.obj);
                return;
            L16:
                this.this$0.onAudioInfoChanged((PlaybackInfo) r2.obj);
                return;
            L17:
                this.this$0.onMetadataChanged((MediaMetadataCompat) r2.obj);
                return;
            L18:
                this.this$0.onPlaybackStateChanged((PlaybackStateCompat) r2.obj);
                return;
            L19:
                Bundle r0 = r2.getData();
                MediaSessionCompat.ensureClassLoader(r0);
                this.this$0.onSessionEvent((String) r2.obj, r0);
                return;
            }
        }

        private static class StubApi21 implements MediaControllerCompatApi21.Callback {
            private final WeakReference<Callback> mCallback;

            StubApi21(Callback r2) {
                this.mCallback = new WeakReference(r2);
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void onSessionDestroyed() {
                Callback r0 = this.mCallback.get();
                if (r0 == null) goto L6;
                r0.onSessionDestroyed();
                return;
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void onSessionEvent(String r2, Bundle r3) {
                Callback r1 = this.mCallback.get();
                if (r1 == null) goto L6;
                IMediaControllerCallback r0 = r1.mIControllerCallback;
                r1.onSessionEvent(r2, r3);
                return;
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void onPlaybackStateChanged(Object r2) {
                Callback r1 = this.mCallback.get();
                if (r1 != null) goto L5;
                return;
            L5:
                if (r1.mIControllerCallback != null) goto L10;
                r1.onPlaybackStateChanged(PlaybackStateCompat.fromPlaybackState(r2));
                return;
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void onMetadataChanged(Object r1) {
                Callback r0 = this.mCallback.get();
                if (r0 == null) goto L6;
                r0.onMetadataChanged(MediaMetadataCompat.fromMediaMetadata(r1));
                return;
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void onQueueChanged(List<?> r1) {
                Callback r0 = this.mCallback.get();
                if (r0 == null) goto L6;
                r0.onQueueChanged(MediaSessionCompat.QueueItem.fromQueueItemList(r1));
                return;
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void onQueueTitleChanged(CharSequence r1) {
                Callback r0 = this.mCallback.get();
                if (r0 == null) goto L6;
                r0.onQueueTitleChanged(r1);
                return;
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void onExtrasChanged(Bundle r1) {
                Callback r0 = this.mCallback.get();
                if (r0 == null) goto L6;
                r0.onExtrasChanged(r1);
                return;
            }

            @Override // android.support.v4.media.session.MediaControllerCompatApi21.Callback
            public void onAudioInfoChanged(int r8, int r9, int r10, int r11, int r12) {
                Callback r7 = this.mCallback.get();
                if (r7 == null) goto L6;
                r7.onAudioInfoChanged(new PlaybackInfo(r8, r9, r10, r11, r12));
                return;
            }
        }

        private static class StubCompat extends IMediaControllerCallback.Stub {
            private final WeakReference<Callback> mCallback;

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onShuffleModeChangedRemoved(boolean r1) throws RemoteException {
            }

            StubCompat(Callback r2) {
                this.mCallback = new WeakReference(r2);
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onEvent(String r2, Bundle r3) throws RemoteException {
                Callback r1 = this.mCallback.get();
                if (r1 == null) goto L6;
                r1.postToHandler(1, r2, r3);
                return;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onSessionDestroyed() throws RemoteException {
                Callback r2 = this.mCallback.get();
                if (r2 == null) goto L6;
                r2.postToHandler(8, null, null);
                return;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onPlaybackStateChanged(PlaybackStateCompat r3) throws RemoteException {
                Callback r2 = this.mCallback.get();
                if (r2 == null) goto L6;
                r2.postToHandler(2, r3, null);
                return;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onMetadataChanged(MediaMetadataCompat r3) throws RemoteException {
                Callback r2 = this.mCallback.get();
                if (r2 == null) goto L6;
                r2.postToHandler(3, r3, null);
                return;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onQueueChanged(List<MediaSessionCompat.QueueItem> r3) throws RemoteException {
                Callback r2 = this.mCallback.get();
                if (r2 == null) goto L6;
                r2.postToHandler(5, r3, null);
                return;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onQueueTitleChanged(CharSequence r3) throws RemoteException {
                Callback r2 = this.mCallback.get();
                if (r2 == null) goto L6;
                r2.postToHandler(6, r3, null);
                return;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onCaptioningEnabledChanged(boolean r3) throws RemoteException {
                Callback r2 = this.mCallback.get();
                if (r2 == null) goto L6;
                r2.postToHandler(11, Boolean.valueOf(r3), null);
                return;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onRepeatModeChanged(int r3) throws RemoteException {
                Callback r2 = this.mCallback.get();
                if (r2 == null) goto L6;
                r2.postToHandler(9, Integer.valueOf(r3), null);
                return;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onShuffleModeChanged(int r3) throws RemoteException {
                Callback r2 = this.mCallback.get();
                if (r2 == null) goto L6;
                r2.postToHandler(12, Integer.valueOf(r3), null);
                return;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onExtrasChanged(Bundle r3) throws RemoteException {
                Callback r2 = this.mCallback.get();
                if (r2 == null) goto L6;
                r2.postToHandler(7, r3, null);
                return;
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onVolumeInfoChanged(ParcelableVolumeInfo r9) throws RemoteException {
                Callback r8 = this.mCallback.get();
                if (r8 != null) goto L5;
                return;
            L5:
                if (r9 == null) goto L7;
                PlaybackInfo r7 = new PlaybackInfo(r9.volumeType, r9.audioStream, r9.controlType, r9.maxVolume, r9.currentVolume);
            L8:
                r8.postToHandler(4, r7, null);
                return;
            L7:
                r7 = null;
                goto L8
            }

            @Override // android.support.v4.media.session.IMediaControllerCallback
            public void onSessionReady() throws RemoteException {
                Callback r2 = this.mCallback.get();
                if (r2 == null) goto L6;
                r2.postToHandler(13, null, null);
                return;
            }
        }

        public void onAudioInfoChanged(PlaybackInfo r1) {
        }

        public void onCaptioningEnabledChanged(boolean r1) {
        }

        public void onExtrasChanged(Bundle r1) {
        }

        public void onMetadataChanged(MediaMetadataCompat r1) {
        }

        public void onPlaybackStateChanged(PlaybackStateCompat r1) {
        }

        public void onQueueChanged(List<MediaSessionCompat.QueueItem> r1) {
        }

        public void onQueueTitleChanged(CharSequence r1) {
        }

        public void onRepeatModeChanged(int r1) {
        }

        public void onSessionDestroyed() {
        }

        public void onSessionEvent(String r1, Bundle r2) {
        }

        public void onSessionReady() {
        }

        public void onShuffleModeChanged(int r1) {
        }

        public Callback() {
            this.mCallbackObj = MediaControllerCompatApi21.createCallback(new StubApi21(this));
        }

        public IMediaControllerCallback getIControllerCallback() {
            return this.mIControllerCallback;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            postToHandler(8, null, null);
        }

        void setHandler(Handler r2) {
            if (r2 != null) goto L6;
            MessageHandler r3 = this.mHandler;
            if (r3 == null) goto L8;
            r3.mRegistered = false;
            this.mHandler.removeCallbacksAndMessages(null);
            this.mHandler = null;
            return;
        L8:
            return;
        L6:
            MessageHandler r0 = new MessageHandler(this, r2.getLooper());
            this.mHandler = r0;
            r0.mRegistered = true;
        }

        void postToHandler(int r1, Object r2, Bundle r3) {
            MessageHandler r0 = this.mHandler;
            if (r0 == null) goto L6;
            Message r4 = r0.obtainMessage(r1, r2);
            r4.setData(r3);
            r4.sendToTarget();
            return;
        }
    }

    private static class MediaControllerExtraData extends ComponentActivity.ExtraData {
        private final MediaControllerCompat mMediaController;

        MediaControllerExtraData(MediaControllerCompat r1) {
            this.mMediaController = r1;
        }

        MediaControllerCompat getMediaController() {
            return this.mMediaController;
        }
    }

    interface MediaControllerImpl {
        void addQueueItem(MediaDescriptionCompat r1);

        void addQueueItem(MediaDescriptionCompat r1, int r2);

        void adjustVolume(int r1, int r2);

        boolean dispatchMediaButtonEvent(KeyEvent r1);

        Bundle getExtras();

        long getFlags();

        Object getMediaController();

        MediaMetadataCompat getMetadata();

        String getPackageName();

        PlaybackInfo getPlaybackInfo();

        PlaybackStateCompat getPlaybackState();

        List<MediaSessionCompat.QueueItem> getQueue();

        CharSequence getQueueTitle();

        int getRatingType();

        int getRepeatMode();

        PendingIntent getSessionActivity();

        int getShuffleMode();

        TransportControls getTransportControls();

        boolean isCaptioningEnabled();

        boolean isSessionReady();

        void registerCallback(Callback r1, Handler r2);

        void removeQueueItem(MediaDescriptionCompat r1);

        void sendCommand(String r1, Bundle r2, ResultReceiver r3);

        void setVolumeTo(int r1, int r2);

        void unregisterCallback(Callback r1);
    }

    static class MediaControllerImplApi21 implements MediaControllerImpl {
        private HashMap<Callback, ExtraCallback> mCallbackMap;
        protected final Object mControllerObj;
        final Object mLock;
        private final List<Callback> mPendingCallbacks;
        final MediaSessionCompat.Token mSessionToken;

        private static class ExtraBinderRequestResultReceiver extends ResultReceiver {
            private WeakReference<MediaControllerImplApi21> mMediaControllerImpl;

            ExtraBinderRequestResultReceiver(MediaControllerImplApi21 r2) {
                super(null);
                this.mMediaControllerImpl = new WeakReference(r2);
            }

            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int r3, Bundle r4) {
                MediaControllerImplApi21 r2 = this.mMediaControllerImpl.get();
                if (r2 == null) goto L14;
                if (r4 == null) goto L17;
                Object r5 = r2.mLock;
                monitor-enter(r5);
                r2.mSessionToken.setExtraBinder(IMediaSession.Stub.asInterface(BundleCompat.getBinder(r4, MediaSessionCompat.KEY_EXTRA_BINDER)));     // Catch: Throwable -> L11
                r2.mSessionToken.setSessionToken2Bundle(r4.getBundle(MediaSessionCompat.KEY_SESSION_TOKEN2_BUNDLE));     // Catch: Throwable -> L11
                r2.processPendingCallbacksLocked();     // Catch: Throwable -> L11
                monitor-exit(r5);     // Catch: Throwable -> L11
                return;
            L11:
                th = move-exception;
                throw th;
            L17:
                return;
            }
        }

        private static class ExtraCallback extends Callback.StubCompat {
            ExtraCallback(Callback r1) {
                super(r1);
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void onSessionDestroyed() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void onMetadataChanged(MediaMetadataCompat r1) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void onQueueChanged(List<MediaSessionCompat.QueueItem> r1) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void onQueueTitleChanged(CharSequence r1) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void onExtrasChanged(Bundle r1) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback.StubCompat, android.support.v4.media.session.IMediaControllerCallback
            public void onVolumeInfoChanged(ParcelableVolumeInfo r1) throws RemoteException {
                throw new AssertionError();
            }
        }

        public MediaControllerImplApi21(Context r2, MediaSessionCompat.Token r3) throws RemoteException {
            this.mLock = new Object();
            this.mPendingCallbacks = new ArrayList();
            this.mCallbackMap = new HashMap();
            this.mSessionToken = r3;
            Object r4 = MediaControllerCompatApi21.fromToken(r2, r3.getToken());
            this.mControllerObj = r4;
            if (r4 == null) goto L9;
            if (r3.getExtraBinder() != null) goto L10;
            requestExtraBinder();
            return;
        L10:
            return;
        L9:
            throw new RemoteException();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public final void registerCallback(Callback r4, Handler r5) {
            MediaControllerCompatApi21.registerCallback(this.mControllerObj, r4.mCallbackObj, r5);
            Object r6 = this.mLock;
            monitor-enter(r6);
        L14:
            th = move-exception;
            throw th;
        L5:
            if (this.mSessionToken.getExtraBinder() == null) goto L11;
            ExtraCallback r0 = new ExtraCallback(r4);     // Catch: Throwable -> L14
            this.mCallbackMap.put(r4, r0);     // Catch: Throwable -> L14
            r4.mIControllerCallback = r0;     // Catch: Throwable -> L14
            this.mSessionToken.getExtraBinder().registerCallbackListener(r0);     // Catch: RemoteException -> L9 Throwable -> L14
            r4.postToHandler(13, null, null);     // Catch: RemoteException -> L9 Throwable -> L14
        L12:
            monitor-exit(r6);     // Catch: Throwable -> L14
            return;
        L9:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in registerCallback.", e);     // Catch: Throwable -> L14
            goto L12
        L11:
            r4.mIControllerCallback = null;     // Catch: Throwable -> L14
            this.mPendingCallbacks.add(r4);     // Catch: Throwable -> L14
            goto L12
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public final void unregisterCallback(Callback r4) {
            MediaControllerCompatApi21.unregisterCallback(this.mControllerObj, r4.mCallbackObj);
            Object r0 = this.mLock;
            monitor-enter(r0);
        L15:
            th = move-exception;
            throw th;
        L5:
            if (this.mSessionToken.getExtraBinder() != null) goto L18;
            this.mPendingCallbacks.remove(r4);     // Catch: Throwable -> L15
        L13:
            monitor-exit(r0);     // Catch: Throwable -> L15
            return;
        L18:
            ExtraCallback r1 = this.mCallbackMap.remove(r4);     // Catch: RemoteException -> L10 Throwable -> L15
            if (r1 == null) goto L13;
            r4.mIControllerCallback = null;     // Catch: RemoteException -> L10 Throwable -> L15
            this.mSessionToken.getExtraBinder().unregisterCallbackListener(r1);     // Catch: RemoteException -> L10 Throwable -> L15
        L10:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in unregisterCallback.", e);     // Catch: Throwable -> L15
            goto L13
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public boolean dispatchMediaButtonEvent(KeyEvent r1) {
            return MediaControllerCompatApi21.dispatchMediaButtonEvent(this.mControllerObj, r1);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public TransportControls getTransportControls() {
            Object r1 = MediaControllerCompatApi21.getTransportControls(this.mControllerObj);
            if (r1 != null) goto L7;
            return null;
        L7:
            return new TransportControlsApi21(r1);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public PlaybackStateCompat getPlaybackState() {
            if (this.mSessionToken.getExtraBinder() != null) goto L13;
        L8:
            Object r3 = MediaControllerCompatApi21.getPlaybackState(this.mControllerObj);
            if (r3 != null) goto L15;
            return null;
        L15:
            return PlaybackStateCompat.fromPlaybackState(r3);
        L13:
            return this.mSessionToken.getExtraBinder().getPlaybackState();
        L6:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in getPlaybackState.", e);
            goto L8
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public MediaMetadataCompat getMetadata() {
            Object r0 = MediaControllerCompatApi21.getMetadata(this.mControllerObj);
            if (r0 != null) goto L7;
            return null;
        L7:
            return MediaMetadataCompat.fromMediaMetadata(r0);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public List<MediaSessionCompat.QueueItem> getQueue() {
            List<Object> r0 = MediaControllerCompatApi21.getQueue(this.mControllerObj);
            if (r0 != null) goto L7;
            return null;
        L7:
            return MediaSessionCompat.QueueItem.fromQueueItemList(r0);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void addQueueItem(MediaDescriptionCompat r5) {
            if ((getFlags() & 4) == 0) goto L7;
            Bundle r0 = new Bundle();
            r0.putParcelable(MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION, r5);
            sendCommand(MediaControllerCompat.COMMAND_ADD_QUEUE_ITEM, r0, null);
            return;
        L7:
            throw new UnsupportedOperationException("This session doesn't support queue management operations");
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void addQueueItem(MediaDescriptionCompat r5, int r6) {
            if ((getFlags() & 4) == 0) goto L7;
            Bundle r0 = new Bundle();
            r0.putParcelable(MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION, r5);
            r0.putInt(MediaControllerCompat.COMMAND_ARGUMENT_INDEX, r6);
            sendCommand(MediaControllerCompat.COMMAND_ADD_QUEUE_ITEM_AT, r0, null);
            return;
        L7:
            throw new UnsupportedOperationException("This session doesn't support queue management operations");
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void removeQueueItem(MediaDescriptionCompat r5) {
            if ((getFlags() & 4) == 0) goto L7;
            Bundle r0 = new Bundle();
            r0.putParcelable(MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION, r5);
            sendCommand(MediaControllerCompat.COMMAND_REMOVE_QUEUE_ITEM, r0, null);
            return;
        L7:
            throw new UnsupportedOperationException("This session doesn't support queue management operations");
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public CharSequence getQueueTitle() {
            return MediaControllerCompatApi21.getQueueTitle(this.mControllerObj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public Bundle getExtras() {
            return MediaControllerCompatApi21.getExtras(this.mControllerObj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public int getRatingType() {
            return MediaControllerCompatApi21.getRatingType(this.mControllerObj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public boolean isCaptioningEnabled() {
            if (this.mSessionToken.getExtraBinder() == null) goto L12;
            return this.mSessionToken.getExtraBinder().isCaptioningEnabled();
        L6:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in isCaptioningEnabled.", e);
            return false;
        L12:
            return false;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public int getRepeatMode() {
            if (this.mSessionToken.getExtraBinder() == null) goto L12;
            return this.mSessionToken.getExtraBinder().getRepeatMode();
        L6:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in getRepeatMode.", e);
            return -1;
        L12:
            return -1;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public int getShuffleMode() {
            if (this.mSessionToken.getExtraBinder() == null) goto L12;
            return this.mSessionToken.getExtraBinder().getShuffleMode();
        L6:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in getShuffleMode.", e);
            return -1;
        L12:
            return -1;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public long getFlags() {
            return MediaControllerCompatApi21.getFlags(this.mControllerObj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public PlaybackInfo getPlaybackInfo() {
            Object r7 = MediaControllerCompatApi21.getPlaybackInfo(this.mControllerObj);
            if (r7 != null) goto L7;
            return null;
        L7:
            return new PlaybackInfo(MediaControllerCompatApi21.PlaybackInfo.getPlaybackType(r7), MediaControllerCompatApi21.PlaybackInfo.getLegacyAudioStream(r7), MediaControllerCompatApi21.PlaybackInfo.getVolumeControl(r7), MediaControllerCompatApi21.PlaybackInfo.getMaxVolume(r7), MediaControllerCompatApi21.PlaybackInfo.getCurrentVolume(r7));
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public PendingIntent getSessionActivity() {
            return MediaControllerCompatApi21.getSessionActivity(this.mControllerObj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void setVolumeTo(int r1, int r2) {
            MediaControllerCompatApi21.setVolumeTo(this.mControllerObj, r1, r2);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void adjustVolume(int r1, int r2) {
            MediaControllerCompatApi21.adjustVolume(this.mControllerObj, r1, r2);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void sendCommand(String r1, Bundle r2, ResultReceiver r3) {
            MediaControllerCompatApi21.sendCommand(this.mControllerObj, r1, r2, r3);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public boolean isSessionReady() {
            if (this.mSessionToken.getExtraBinder() == null) goto L5;
            return true;
        L5:
            return false;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public String getPackageName() {
            return MediaControllerCompatApi21.getPackageName(this.mControllerObj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public Object getMediaController() {
            return this.mControllerObj;
        }

        private void requestExtraBinder() {
            sendCommand(MediaControllerCompat.COMMAND_GET_EXTRA_BINDER, null, new ExtraBinderRequestResultReceiver(this));
        }

        void processPendingCallbacksLocked() {
            if (this.mSessionToken.getExtraBinder() != null) goto L5;
            return;
        L5:
            Iterator<Callback> r0 = this.mPendingCallbacks.iterator();
        L7:
            if (r0.hasNext() == false) goto L13;
            Callback r1 = r0.next();
            ExtraCallback r2 = new ExtraCallback(r1);
            this.mCallbackMap.put(r1, r2);
            r1.mIControllerCallback = r2;
            this.mSessionToken.getExtraBinder().registerCallbackListener(r2);     // Catch: RemoteException -> L11
            r1.postToHandler(13, null, null);
        L11:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in registerCallback.", e);
        L13:
            this.mPendingCallbacks.clear();
        }
    }

    static class MediaControllerImplApi23 extends MediaControllerImplApi21 {
        public MediaControllerImplApi23(Context r1, MediaSessionCompat.Token r2) throws RemoteException {
            super(r1, r2);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImplApi21, android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public TransportControls getTransportControls() {
            Object r1 = MediaControllerCompatApi21.getTransportControls(this.mControllerObj);
            if (r1 != null) goto L7;
            return null;
        L7:
            return new TransportControlsApi23(r1);
        }
    }

    static class MediaControllerImplApi24 extends MediaControllerImplApi23 {
        public MediaControllerImplApi24(Context r1, MediaSessionCompat.Token r2) throws RemoteException {
            super(r1, r2);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImplApi23, android.support.v4.media.session.MediaControllerCompat.MediaControllerImplApi21, android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public TransportControls getTransportControls() {
            Object r1 = MediaControllerCompatApi21.getTransportControls(this.mControllerObj);
            if (r1 != null) goto L7;
            return null;
        L7:
            return new TransportControlsApi24(r1);
        }
    }

    static class MediaControllerImplBase implements MediaControllerImpl {
        private IMediaSession mBinder;
        private TransportControls mTransportControls;

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public Object getMediaController() {
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public boolean isSessionReady() {
            return true;
        }

        public MediaControllerImplBase(MediaSessionCompat.Token r1) {
            this.mBinder = IMediaSession.Stub.asInterface((IBinder) r1.getToken());
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void registerCallback(Callback r3, Handler r4) {
            if (r3 == null) goto L10;
            this.mBinder.asBinder().linkToDeath(r3, 0);     // Catch: RemoteException -> L6
            this.mBinder.registerCallbackListener((IMediaControllerCallback) r3.mCallbackObj);     // Catch: RemoteException -> L6
            r3.postToHandler(13, null, null);     // Catch: RemoteException -> L6
            return;
        L6:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in registerCallback.", e);
            r3.postToHandler(8, null, null);
            return;
        L10:
            throw new IllegalArgumentException("callback may not be null.");
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void unregisterCallback(Callback r3) {
            if (r3 == null) goto L9;
            this.mBinder.unregisterCallbackListener((IMediaControllerCallback) r3.mCallbackObj);     // Catch: RemoteException -> L5
            this.mBinder.asBinder().unlinkToDeath(r3, 0);     // Catch: RemoteException -> L5
            return;
        L5:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in unregisterCallback.", e);
            return;
        L9:
            throw new IllegalArgumentException("callback may not be null.");
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public boolean dispatchMediaButtonEvent(KeyEvent r2) {
            if (r2 == null) goto L10;
            this.mBinder.sendMediaButton(r2);     // Catch: RemoteException -> L5
            return false;
        L5:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in dispatchMediaButtonEvent.", e);
            return false;
        L10:
            throw new IllegalArgumentException("event may not be null.");
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public TransportControls getTransportControls() {
            if (this.mTransportControls != null) goto L6;
            this.mTransportControls = new TransportControlsBase(this.mBinder);
        L6:
            return this.mTransportControls;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public PlaybackStateCompat getPlaybackState() {
            return this.mBinder.getPlaybackState();
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in getPlaybackState.", e);
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public MediaMetadataCompat getMetadata() {
            return this.mBinder.getMetadata();
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in getMetadata.", e);
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public List<MediaSessionCompat.QueueItem> getQueue() {
            return this.mBinder.getQueue();
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in getQueue.", e);
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void addQueueItem(MediaDescriptionCompat r5) {
        L7:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in addQueueItem.", e);
            return;
        L3:
            if ((this.mBinder.getFlags() & 4) == 0) goto L6;
            this.mBinder.addQueueItem(r5);     // Catch: RemoteException -> L7
            return;
        L6:
            throw new UnsupportedOperationException("This session doesn't support queue management operations");     // Catch: RemoteException -> L7
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void addQueueItem(MediaDescriptionCompat r5, int r6) {
        L7:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in addQueueItemAt.", e);
            return;
        L3:
            if ((this.mBinder.getFlags() & 4) == 0) goto L6;
            this.mBinder.addQueueItemAt(r5, r6);     // Catch: RemoteException -> L7
            return;
        L6:
            throw new UnsupportedOperationException("This session doesn't support queue management operations");     // Catch: RemoteException -> L7
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void removeQueueItem(MediaDescriptionCompat r5) {
        L7:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in removeQueueItem.", e);
            return;
        L3:
            if ((this.mBinder.getFlags() & 4) == 0) goto L6;
            this.mBinder.removeQueueItem(r5);     // Catch: RemoteException -> L7
            return;
        L6:
            throw new UnsupportedOperationException("This session doesn't support queue management operations");     // Catch: RemoteException -> L7
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public CharSequence getQueueTitle() {
            return this.mBinder.getQueueTitle();
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in getQueueTitle.", e);
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public Bundle getExtras() {
            return this.mBinder.getExtras();
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in getExtras.", e);
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public int getRatingType() {
            return this.mBinder.getRatingType();
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in getRatingType.", e);
            return 0;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public boolean isCaptioningEnabled() {
            return this.mBinder.isCaptioningEnabled();
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in isCaptioningEnabled.", e);
            return false;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public int getRepeatMode() {
            return this.mBinder.getRepeatMode();
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in getRepeatMode.", e);
            return -1;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public int getShuffleMode() {
            return this.mBinder.getShuffleMode();
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in getShuffleMode.", e);
            return -1;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public long getFlags() {
            return this.mBinder.getFlags();
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in getFlags.", e);
            return 0;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public PlaybackInfo getPlaybackInfo() {
            ParcelableVolumeInfo r7 = this.mBinder.getVolumeAttributes();     // Catch: RemoteException -> L4
            return new PlaybackInfo(r7.volumeType, r7.audioStream, r7.controlType, r7.maxVolume, r7.currentVolume);
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in getPlaybackInfo.", e);
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public PendingIntent getSessionActivity() {
            return this.mBinder.getLaunchPendingIntent();
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in getSessionActivity.", e);
            return null;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void setVolumeTo(int r2, int r3) {
            this.mBinder.setVolumeTo(r2, r3, null);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in setVolumeTo.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void adjustVolume(int r2, int r3) {
            this.mBinder.adjustVolume(r2, r3, null);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in adjustVolume.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public void sendCommand(String r2, Bundle r3, ResultReceiver r4) {
            this.mBinder.sendCommand(r2, r3, new MediaSessionCompat.ResultReceiverWrapper(r4));     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in sendCommand.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.MediaControllerImpl
        public String getPackageName() {
            return this.mBinder.getPackageName();
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in getPackageName.", e);
            return null;
        }
    }

    public static final class PlaybackInfo {
        public static final int PLAYBACK_TYPE_LOCAL = 1;
        public static final int PLAYBACK_TYPE_REMOTE = 2;
        private final int mAudioStream;
        private final int mCurrentVolume;
        private final int mMaxVolume;
        private final int mPlaybackType;
        private final int mVolumeControl;

        PlaybackInfo(int r1, int r2, int r3, int r4, int r5) {
            this.mPlaybackType = r1;
            this.mAudioStream = r2;
            this.mVolumeControl = r3;
            this.mMaxVolume = r4;
            this.mCurrentVolume = r5;
        }

        public int getPlaybackType() {
            return this.mPlaybackType;
        }

        public int getAudioStream() {
            return this.mAudioStream;
        }

        public int getVolumeControl() {
            return this.mVolumeControl;
        }

        public int getMaxVolume() {
            return this.mMaxVolume;
        }

        public int getCurrentVolume() {
            return this.mCurrentVolume;
        }
    }

    public static abstract class TransportControls {
        public static final String EXTRA_LEGACY_STREAM_TYPE = "android.media.session.extra.LEGACY_STREAM_TYPE";

        public abstract void fastForward();

        public abstract void pause();

        public abstract void play();

        public abstract void playFromMediaId(String r1, Bundle r2);

        public abstract void playFromSearch(String r1, Bundle r2);

        public abstract void playFromUri(Uri r1, Bundle r2);

        public abstract void prepare();

        public abstract void prepareFromMediaId(String r1, Bundle r2);

        public abstract void prepareFromSearch(String r1, Bundle r2);

        public abstract void prepareFromUri(Uri r1, Bundle r2);

        public abstract void rewind();

        public abstract void seekTo(long r1);

        public abstract void sendCustomAction(PlaybackStateCompat.CustomAction r1, Bundle r2);

        public abstract void sendCustomAction(String r1, Bundle r2);

        public abstract void setCaptioningEnabled(boolean r1);

        public abstract void setRating(RatingCompat r1);

        public abstract void setRating(RatingCompat r1, Bundle r2);

        public abstract void setRepeatMode(int r1);

        public abstract void setShuffleMode(int r1);

        public abstract void skipToNext();

        public abstract void skipToPrevious();

        public abstract void skipToQueueItem(long r1);

        public abstract void stop();

        TransportControls() {
        }
    }

    static class TransportControlsApi21 extends TransportControls {
        protected final Object mControlsObj;

        public TransportControlsApi21(Object r1) {
            this.mControlsObj = r1;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepare() {
            sendCustomAction(MediaSessionCompat.ACTION_PREPARE, null);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromMediaId(String r3, Bundle r4) {
            Bundle r0 = new Bundle();
            r0.putString(MediaSessionCompat.ACTION_ARGUMENT_MEDIA_ID, r3);
            r0.putBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS, r4);
            sendCustomAction(MediaSessionCompat.ACTION_PREPARE_FROM_MEDIA_ID, r0);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromSearch(String r3, Bundle r4) {
            Bundle r0 = new Bundle();
            r0.putString(MediaSessionCompat.ACTION_ARGUMENT_QUERY, r3);
            r0.putBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS, r4);
            sendCustomAction(MediaSessionCompat.ACTION_PREPARE_FROM_SEARCH, r0);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromUri(Uri r3, Bundle r4) {
            Bundle r0 = new Bundle();
            r0.putParcelable(MediaSessionCompat.ACTION_ARGUMENT_URI, r3);
            r0.putBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS, r4);
            sendCustomAction(MediaSessionCompat.ACTION_PREPARE_FROM_URI, r0);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void play() {
            MediaControllerCompatApi21.TransportControls.play(this.mControlsObj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void pause() {
            MediaControllerCompatApi21.TransportControls.pause(this.mControlsObj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void stop() {
            MediaControllerCompatApi21.TransportControls.stop(this.mControlsObj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void seekTo(long r1) {
            MediaControllerCompatApi21.TransportControls.seekTo(this.mControlsObj, r1);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void fastForward() {
            MediaControllerCompatApi21.TransportControls.fastForward(this.mControlsObj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void rewind() {
            MediaControllerCompatApi21.TransportControls.rewind(this.mControlsObj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void skipToNext() {
            MediaControllerCompatApi21.TransportControls.skipToNext(this.mControlsObj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void skipToPrevious() {
            MediaControllerCompatApi21.TransportControls.skipToPrevious(this.mControlsObj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setRating(RatingCompat r1) {
            Object r0 = this.mControlsObj;
            if (r1 == null) goto L5;
            Object r2 = r1.getRating();
        L6:
            MediaControllerCompatApi21.TransportControls.setRating(r0, r2);
            return;
        L5:
            r2 = null;
            goto L6
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setRating(RatingCompat r3, Bundle r4) {
            Bundle r0 = new Bundle();
            r0.putParcelable(MediaSessionCompat.ACTION_ARGUMENT_RATING, r3);
            r0.putBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS, r4);
            sendCustomAction(MediaSessionCompat.ACTION_SET_RATING, r0);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setCaptioningEnabled(boolean r3) {
            Bundle r0 = new Bundle();
            r0.putBoolean(MediaSessionCompat.ACTION_ARGUMENT_CAPTIONING_ENABLED, r3);
            sendCustomAction(MediaSessionCompat.ACTION_SET_CAPTIONING_ENABLED, r0);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setRepeatMode(int r3) {
            Bundle r0 = new Bundle();
            r0.putInt(MediaSessionCompat.ACTION_ARGUMENT_REPEAT_MODE, r3);
            sendCustomAction(MediaSessionCompat.ACTION_SET_REPEAT_MODE, r0);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setShuffleMode(int r3) {
            Bundle r0 = new Bundle();
            r0.putInt(MediaSessionCompat.ACTION_ARGUMENT_SHUFFLE_MODE, r3);
            sendCustomAction(MediaSessionCompat.ACTION_SET_SHUFFLE_MODE, r0);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromMediaId(String r1, Bundle r2) {
            MediaControllerCompatApi21.TransportControls.playFromMediaId(this.mControlsObj, r1, r2);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromSearch(String r1, Bundle r2) {
            MediaControllerCompatApi21.TransportControls.playFromSearch(this.mControlsObj, r1, r2);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromUri(Uri r3, Bundle r4) {
            if (r3 == null) goto L8;
            if (Uri.EMPTY.equals(r3) == true) goto L8;
            Bundle r0 = new Bundle();
            r0.putParcelable(MediaSessionCompat.ACTION_ARGUMENT_URI, r3);
            r0.putBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS, r4);
            sendCustomAction(MediaSessionCompat.ACTION_PLAY_FROM_URI, r0);
            return;
        L8:
            throw new IllegalArgumentException("You must specify a non-empty Uri for playFromUri.");
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void skipToQueueItem(long r1) {
            MediaControllerCompatApi21.TransportControls.skipToQueueItem(this.mControlsObj, r1);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void sendCustomAction(PlaybackStateCompat.CustomAction r2, Bundle r3) {
            MediaControllerCompat.validateCustomAction(r2.getAction(), r3);
            MediaControllerCompatApi21.TransportControls.sendCustomAction(this.mControlsObj, r2.getAction(), r3);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void sendCustomAction(String r1, Bundle r2) {
            MediaControllerCompat.validateCustomAction(r1, r2);
            MediaControllerCompatApi21.TransportControls.sendCustomAction(this.mControlsObj, r1, r2);
        }
    }

    static class TransportControlsApi23 extends TransportControlsApi21 {
        public TransportControlsApi23(Object r1) {
            super(r1);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControlsApi21, android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromUri(Uri r1, Bundle r2) {
            MediaControllerCompatApi23.TransportControls.playFromUri(this.mControlsObj, r1, r2);
        }
    }

    static class TransportControlsApi24 extends TransportControlsApi23 {
        public TransportControlsApi24(Object r1) {
            super(r1);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControlsApi21, android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepare() {
            MediaControllerCompatApi24.TransportControls.prepare(this.mControlsObj);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControlsApi21, android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromMediaId(String r1, Bundle r2) {
            MediaControllerCompatApi24.TransportControls.prepareFromMediaId(this.mControlsObj, r1, r2);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControlsApi21, android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromSearch(String r1, Bundle r2) {
            MediaControllerCompatApi24.TransportControls.prepareFromSearch(this.mControlsObj, r1, r2);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControlsApi21, android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromUri(Uri r1, Bundle r2) {
            MediaControllerCompatApi24.TransportControls.prepareFromUri(this.mControlsObj, r1, r2);
        }
    }

    static class TransportControlsBase extends TransportControls {
        private IMediaSession mBinder;

        public TransportControlsBase(IMediaSession r1) {
            this.mBinder = r1;
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepare() {
            this.mBinder.prepare();     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in prepare.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromMediaId(String r1, Bundle r2) {
            this.mBinder.prepareFromMediaId(r1, r2);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in prepareFromMediaId.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromSearch(String r1, Bundle r2) {
            this.mBinder.prepareFromSearch(r1, r2);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in prepareFromSearch.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void prepareFromUri(Uri r1, Bundle r2) {
            this.mBinder.prepareFromUri(r1, r2);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in prepareFromUri.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void play() {
            this.mBinder.play();     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in play.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromMediaId(String r1, Bundle r2) {
            this.mBinder.playFromMediaId(r1, r2);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in playFromMediaId.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromSearch(String r1, Bundle r2) {
            this.mBinder.playFromSearch(r1, r2);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in playFromSearch.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void playFromUri(Uri r1, Bundle r2) {
            this.mBinder.playFromUri(r1, r2);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in playFromUri.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void skipToQueueItem(long r1) {
            this.mBinder.skipToQueueItem(r1);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in skipToQueueItem.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void pause() {
            this.mBinder.pause();     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in pause.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void stop() {
            this.mBinder.stop();     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in stop.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void seekTo(long r1) {
            this.mBinder.seekTo(r1);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in seekTo.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void fastForward() {
            this.mBinder.fastForward();     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in fastForward.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void skipToNext() {
            this.mBinder.next();     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in skipToNext.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void rewind() {
            this.mBinder.rewind();     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in rewind.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void skipToPrevious() {
            this.mBinder.previous();     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in skipToPrevious.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setRating(RatingCompat r2) {
            this.mBinder.rate(r2);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in setRating.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setRating(RatingCompat r1, Bundle r2) {
            this.mBinder.rateWithExtras(r1, r2);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in setRating.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setCaptioningEnabled(boolean r2) {
            this.mBinder.setCaptioningEnabled(r2);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in setCaptioningEnabled.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setRepeatMode(int r2) {
            this.mBinder.setRepeatMode(r2);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in setRepeatMode.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void setShuffleMode(int r2) {
            this.mBinder.setShuffleMode(r2);     // Catch: RemoteException -> L4
            return;
        L4:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in setShuffleMode.", e);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void sendCustomAction(PlaybackStateCompat.CustomAction r1, Bundle r2) {
            sendCustomAction(r1.getAction(), r2);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.TransportControls
        public void sendCustomAction(String r1, Bundle r2) {
            MediaControllerCompat.validateCustomAction(r1, r2);
            this.mBinder.sendCustomAction(r1, r2);     // Catch: RemoteException -> L5
            return;
        L5:
            e = move-exception;
            Log.e(MediaControllerCompat.TAG, "Dead object in sendCustomAction.", e);
        }
    }

    public static void setMediaController(Activity r2, MediaControllerCompat r3) {
        if ((r2 instanceof ComponentActivity) == false) goto L5;
        ((ComponentActivity) r2).putExtraData(new MediaControllerExtraData(r3));
    L5:
        if (r3 == null) goto L7;
        Object r4 = MediaControllerCompatApi21.fromToken(r2, r3.getSessionToken().getToken());
    L8:
        MediaControllerCompatApi21.setMediaController(r2, r4);
        return;
    L7:
        r4 = null;
        goto L8
    }

    public static MediaControllerCompat getMediaController(Activity r3) {
        if ((r3 instanceof ComponentActivity) == false) goto L8;
        MediaControllerExtraData r4 = (MediaControllerExtraData) ((ComponentActivity) r3).getExtraData(MediaControllerExtraData.class);
        if (r4 != null) goto L7;
        return null;
    L7:
        return r4.getMediaController();
    L8:
        Object r0 = MediaControllerCompatApi21.getMediaController(r3);
        if (r0 != null) goto L17;
        return null;
    L17:
        return new MediaControllerCompat(r3, MediaSessionCompat.Token.fromToken(MediaControllerCompatApi21.getSessionToken(r0)));
    L14:
        e = move-exception;
        Log.e(TAG, "Dead object in getMediaController.", e);
        return null;
    }

    static void validateCustomAction(String r2, Bundle r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        r2.hashCode();
        if (r2.equals(MediaSessionCompat.ACTION_FOLLOW) == false) goto L7;
    L9:
        if (r3 == null) goto L14;
        if (r3.containsKey(MediaSessionCompat.ARGUMENT_MEDIA_ATTRIBUTE) == false) goto L14;
        return;
    L14:
        throw new IllegalArgumentException("An extra field android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE is required for this action " + r2 + LibrarianImpl.Constants.DOT);
    L7:
        if (r2.equals(MediaSessionCompat.ACTION_UNFOLLOW) == true) goto L9;
    }

    public MediaControllerCompat(Context r2, MediaSessionCompat r3) {
        this.mRegisteredCallbacks = new HashSet();
        if (r3 == null) goto L12;
        MediaSessionCompat.Token r4 = r3.getSessionToken();
        this.mToken = r4;
        MediaControllerImplApi24 r0 = new MediaControllerImplApi24(r2, r4);     // Catch: RemoteException -> L7
    L9:
        this.mImpl = r0;
        return;
    L7:
        e = move-exception;
        Log.w(TAG, "Failed to create MediaControllerImpl.", e);
        r0 = null;
        goto L9
    L12:
        throw new IllegalArgumentException("session must not be null");
    }

    public MediaControllerCompat(Context r2, MediaSessionCompat.Token r3) throws RemoteException {
        this.mRegisteredCallbacks = new HashSet();
        if (r3 == null) goto L7;
        this.mToken = r3;
        this.mImpl = new MediaControllerImplApi24(r2, r3);
        return;
    L7:
        throw new IllegalArgumentException("sessionToken must not be null");
    }

    public TransportControls getTransportControls() {
        return this.mImpl.getTransportControls();
    }

    public boolean dispatchMediaButtonEvent(KeyEvent r1) {
        if (r1 == null) goto L6;
        return this.mImpl.dispatchMediaButtonEvent(r1);
    L6:
        throw new IllegalArgumentException("KeyEvent may not be null");
    }

    public PlaybackStateCompat getPlaybackState() {
        return this.mImpl.getPlaybackState();
    }

    public MediaMetadataCompat getMetadata() {
        return this.mImpl.getMetadata();
    }

    public List<MediaSessionCompat.QueueItem> getQueue() {
        return this.mImpl.getQueue();
    }

    public void addQueueItem(MediaDescriptionCompat r1) {
        this.mImpl.addQueueItem(r1);
    }

    public void addQueueItem(MediaDescriptionCompat r1, int r2) {
        this.mImpl.addQueueItem(r1, r2);
    }

    public void removeQueueItem(MediaDescriptionCompat r1) {
        this.mImpl.removeQueueItem(r1);
    }

    @Deprecated
    public void removeQueueItemAt(int r3) {
        List<MediaSessionCompat.QueueItem> r0 = getQueue();
        if (r0 == null) goto L11;
        if (r3 >= 0) goto L6;
        return;
    L6:
        if (r3 >= r0.size()) goto L13;
        MediaSessionCompat.QueueItem r4 = r0.get(r3);
        if (r4 == null) goto L14;
        removeQueueItem(r4.getDescription());
        return;
    L14:
        return;
    L13:
        return;
    }

    public CharSequence getQueueTitle() {
        return this.mImpl.getQueueTitle();
    }

    public Bundle getExtras() {
        return this.mImpl.getExtras();
    }

    public int getRatingType() {
        return this.mImpl.getRatingType();
    }

    public boolean isCaptioningEnabled() {
        return this.mImpl.isCaptioningEnabled();
    }

    public int getRepeatMode() {
        return this.mImpl.getRepeatMode();
    }

    public int getShuffleMode() {
        return this.mImpl.getShuffleMode();
    }

    public long getFlags() {
        return this.mImpl.getFlags();
    }

    public PlaybackInfo getPlaybackInfo() {
        return this.mImpl.getPlaybackInfo();
    }

    public PendingIntent getSessionActivity() {
        return this.mImpl.getSessionActivity();
    }

    public MediaSessionCompat.Token getSessionToken() {
        return this.mToken;
    }

    public Bundle getSessionToken2Bundle() {
        return this.mToken.getSessionToken2Bundle();
    }

    public void setVolumeTo(int r1, int r2) {
        this.mImpl.setVolumeTo(r1, r2);
    }

    public void adjustVolume(int r1, int r2) {
        this.mImpl.adjustVolume(r1, r2);
    }

    public void registerCallback(Callback r2) {
        registerCallback(r2, null);
    }

    public void registerCallback(Callback r2, Handler r3) {
        if (r2 == null) goto L8;
        if (r3 != null) goto L5;
        r3 = new Handler();
    L5:
        r2.setHandler(r3);
        this.mImpl.registerCallback(r2, r3);
        this.mRegisteredCallbacks.add(r2);
        return;
    L8:
        throw new IllegalArgumentException("callback must not be null");
    }

    public void unregisterCallback(Callback r3) {
        if (r3 == null) goto L11;
        this.mRegisteredCallbacks.remove(r3);     // Catch: Throwable -> L7
        this.mImpl.unregisterCallback(r3);     // Catch: Throwable -> L7
        r3.setHandler(null);
        return;
    L7:
        th = move-exception;
        r3.setHandler(null);
        throw th;
    L11:
        throw new IllegalArgumentException("callback must not be null");
    }

    public void sendCommand(String r2, Bundle r3, ResultReceiver r4) {
        if (TextUtils.isEmpty(r2) == true) goto L7;
        this.mImpl.sendCommand(r2, r3, r4);
        return;
    L7:
        throw new IllegalArgumentException("command must neither be null nor empty");
    }

    public boolean isSessionReady() {
        return this.mImpl.isSessionReady();
    }

    public String getPackageName() {
        return this.mImpl.getPackageName();
    }

    public Object getMediaController() {
        return this.mImpl.getMediaController();
    }
}

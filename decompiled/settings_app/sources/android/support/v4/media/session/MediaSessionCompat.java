package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.media.RemoteControlClient;
import android.media.session.MediaSession;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import androidx.core.app.BundleCompat;
import androidx.media.MediaSessionManager;
import androidx.media.VolumeProviderCompat;
import androidx.media.session.MediaButtonReceiver;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MediaSessionCompat {
    public static final String ACTION_ARGUMENT_CAPTIONING_ENABLED = "android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED";
    public static final String ACTION_ARGUMENT_EXTRAS = "android.support.v4.media.session.action.ARGUMENT_EXTRAS";
    public static final String ACTION_ARGUMENT_MEDIA_ID = "android.support.v4.media.session.action.ARGUMENT_MEDIA_ID";
    public static final String ACTION_ARGUMENT_QUERY = "android.support.v4.media.session.action.ARGUMENT_QUERY";
    public static final String ACTION_ARGUMENT_RATING = "android.support.v4.media.session.action.ARGUMENT_RATING";
    public static final String ACTION_ARGUMENT_REPEAT_MODE = "android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE";
    public static final String ACTION_ARGUMENT_SHUFFLE_MODE = "android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE";
    public static final String ACTION_ARGUMENT_URI = "android.support.v4.media.session.action.ARGUMENT_URI";
    public static final String ACTION_FLAG_AS_INAPPROPRIATE = "android.support.v4.media.session.action.FLAG_AS_INAPPROPRIATE";
    public static final String ACTION_FOLLOW = "android.support.v4.media.session.action.FOLLOW";
    public static final String ACTION_PLAY_FROM_URI = "android.support.v4.media.session.action.PLAY_FROM_URI";
    public static final String ACTION_PREPARE = "android.support.v4.media.session.action.PREPARE";
    public static final String ACTION_PREPARE_FROM_MEDIA_ID = "android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID";
    public static final String ACTION_PREPARE_FROM_SEARCH = "android.support.v4.media.session.action.PREPARE_FROM_SEARCH";
    public static final String ACTION_PREPARE_FROM_URI = "android.support.v4.media.session.action.PREPARE_FROM_URI";
    public static final String ACTION_SET_CAPTIONING_ENABLED = "android.support.v4.media.session.action.SET_CAPTIONING_ENABLED";
    public static final String ACTION_SET_RATING = "android.support.v4.media.session.action.SET_RATING";
    public static final String ACTION_SET_REPEAT_MODE = "android.support.v4.media.session.action.SET_REPEAT_MODE";
    public static final String ACTION_SET_SHUFFLE_MODE = "android.support.v4.media.session.action.SET_SHUFFLE_MODE";
    public static final String ACTION_SKIP_AD = "android.support.v4.media.session.action.SKIP_AD";
    public static final String ACTION_UNFOLLOW = "android.support.v4.media.session.action.UNFOLLOW";
    public static final String ARGUMENT_MEDIA_ATTRIBUTE = "android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE";
    public static final String ARGUMENT_MEDIA_ATTRIBUTE_VALUE = "android.support.v4.media.session.ARGUMENT_MEDIA_ATTRIBUTE_VALUE";
    private static final String DATA_CALLING_PACKAGE = "data_calling_pkg";
    private static final String DATA_CALLING_PID = "data_calling_pid";
    private static final String DATA_CALLING_UID = "data_calling_uid";
    private static final String DATA_EXTRAS = "data_extras";
    public static final int FLAG_HANDLES_MEDIA_BUTTONS = 1;
    public static final int FLAG_HANDLES_QUEUE_COMMANDS = 4;
    public static final int FLAG_HANDLES_TRANSPORT_CONTROLS = 2;
    public static final String KEY_EXTRA_BINDER = "android.support.v4.media.session.EXTRA_BINDER";
    public static final String KEY_SESSION_TOKEN2_BUNDLE = "android.support.v4.media.session.SESSION_TOKEN2_BUNDLE";
    public static final String KEY_TOKEN = "android.support.v4.media.session.TOKEN";
    private static final int MAX_BITMAP_SIZE_IN_DP = 320;
    public static final int MEDIA_ATTRIBUTE_ALBUM = 1;
    public static final int MEDIA_ATTRIBUTE_ARTIST = 0;
    public static final int MEDIA_ATTRIBUTE_PLAYLIST = 2;
    static final String TAG = "MediaSessionCompat";
    static int sMaxBitmapSize;
    private final ArrayList<OnActiveChangeListener> mActiveListeners;
    private final MediaControllerCompat mController;
    private final MediaSessionImpl mImpl;

    /* JADX INFO: renamed from: android.support.v4.media.session.MediaSessionCompat$2, reason: invalid class name */
    class AnonymousClass2 extends Callback {
        final /* synthetic */ MediaSessionCompat this$0;

        AnonymousClass2(MediaSessionCompat r1) {
            this.this$0 = r1;
        }
    }

    public static abstract class Callback {
        private CallbackHandler mCallbackHandler;
        final Object mCallbackObj;
        private boolean mMediaPlayPauseKeyPending;
        WeakReference<MediaSessionImpl> mSessionImpl;

        private class CallbackHandler extends Handler {
            private static final int MSG_MEDIA_PLAY_PAUSE_KEY_DOUBLE_TAP_TIMEOUT = 1;
            final /* synthetic */ Callback this$0;

            CallbackHandler(Callback r1, Looper r2) {
                this.this$0 = r1;
                super(r2);
            }

            @Override // android.os.Handler
            public void handleMessage(Message r3) {
                if (r3.what != 1) goto L6;
                this.this$0.handleMediaPlayPauseKeySingleTapIfPending((MediaSessionManager.RemoteUserInfo) r3.obj);
                return;
            }
        }

        private class StubApi21 implements MediaSessionCompatApi21.Callback {
            final /* synthetic */ Callback this$0;

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onSetRating(Object r1, Bundle r2) {
            }

            StubApi21(Callback r1) {
                this.this$0 = r1;
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onCommand(String r5, Bundle r6, ResultReceiver r7) {
                QueueItem r1 = null;
                IBinder r2 = null;
                r1 = null;
                if (r5.equals(MediaControllerCompat.COMMAND_GET_EXTRA_BINDER) == false) goto L13;
                MediaSessionImplApi21 r4 = (MediaSessionImplApi21) this.this$0.mSessionImpl.get();     // Catch: BadParcelableException -> L37
                if (r4 == null) goto L40;
                Bundle r8 = new Bundle();     // Catch: BadParcelableException -> L37
                Token r9 = r4.getSessionToken();     // Catch: BadParcelableException -> L37
                IMediaSession r10 = r9.getExtraBinder();     // Catch: BadParcelableException -> L37
                if (r10 == null) goto L10;
                r2 = r10.asBinder();     // Catch: BadParcelableException -> L37
            L10:
                BundleCompat.putBinder(r8, MediaSessionCompat.KEY_EXTRA_BINDER, r2);     // Catch: BadParcelableException -> L37
                r8.putBundle(MediaSessionCompat.KEY_SESSION_TOKEN2_BUNDLE, r9.getSessionToken2Bundle());     // Catch: BadParcelableException -> L37
                r7.send(0, r8);     // Catch: BadParcelableException -> L37
                return;
            L40:
                return;
            L13:
                if (r5.equals(MediaControllerCompat.COMMAND_ADD_QUEUE_ITEM) == false) goto L17;
                this.this$0.onAddQueueItem((MediaDescriptionCompat) r6.getParcelable(MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION));     // Catch: BadParcelableException -> L37
                return;
            L17:
                if (r5.equals(MediaControllerCompat.COMMAND_ADD_QUEUE_ITEM_AT) == false) goto L20;
                this.this$0.onAddQueueItem((MediaDescriptionCompat) r6.getParcelable(MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION), r6.getInt(MediaControllerCompat.COMMAND_ARGUMENT_INDEX));     // Catch: BadParcelableException -> L37
                return;
            L20:
                if (r5.equals(MediaControllerCompat.COMMAND_REMOVE_QUEUE_ITEM) == false) goto L23;
                this.this$0.onRemoveQueueItem((MediaDescriptionCompat) r6.getParcelable(MediaControllerCompat.COMMAND_ARGUMENT_MEDIA_DESCRIPTION));     // Catch: BadParcelableException -> L37
                return;
            L23:
                if (r5.equals(MediaControllerCompat.COMMAND_REMOVE_QUEUE_ITEM_AT) == false) goto L35;
                MediaSessionImplApi21 r11 = (MediaSessionImplApi21) this.this$0.mSessionImpl.get();     // Catch: BadParcelableException -> L37
                if (r11 != null) goto L27;
                return;
            L27:
                if (r11.mQueue == null) goto L46;
                int r12 = r6.getInt(MediaControllerCompat.COMMAND_ARGUMENT_INDEX, -1);     // Catch: BadParcelableException -> L37
                if (r12 >= 0) goto L31;
            L33:
                if (r1 == null) goto L47;
                this.this$0.onRemoveQueueItem(r1.getDescription());     // Catch: BadParcelableException -> L37
                return;
            L47:
                return;
            L31:
                if (r12 >= r11.mQueue.size()) goto L33;
                r1 = r11.mQueue.get(r12);     // Catch: BadParcelableException -> L37
                goto L33
            L46:
                return;
            L35:
                this.this$0.onCommand(r5, r6, r7);     // Catch: BadParcelableException -> L37
                return;
            L37:
                Log.e(MediaSessionCompat.TAG, "Could not unparcel the extra data.");
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public boolean onMediaButtonEvent(Intent r1) {
                return this.this$0.onMediaButtonEvent(r1);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onPlay() {
                this.this$0.onPlay();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onPlayFromMediaId(String r1, Bundle r2) {
                this.this$0.onPlayFromMediaId(r1, r2);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onPlayFromSearch(String r1, Bundle r2) {
                this.this$0.onPlayFromSearch(r1, r2);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onSkipToQueueItem(long r1) {
                this.this$0.onSkipToQueueItem(r1);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onPause() {
                this.this$0.onPause();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onSkipToNext() {
                this.this$0.onSkipToNext();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onSkipToPrevious() {
                this.this$0.onSkipToPrevious();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onFastForward() {
                this.this$0.onFastForward();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onRewind() {
                this.this$0.onRewind();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onStop() {
                this.this$0.onStop();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onSeekTo(long r1) {
                this.this$0.onSeekTo(r1);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onSetRating(Object r1) {
                this.this$0.onSetRating(RatingCompat.fromRating(r1));
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi21.Callback
            public void onCustomAction(String r4, Bundle r5) {
                Bundle r0 = r5.getBundle(MediaSessionCompat.ACTION_ARGUMENT_EXTRAS);
                MediaSessionCompat.ensureClassLoader(r0);
                if (r4.equals(MediaSessionCompat.ACTION_PLAY_FROM_URI) == false) goto L6;
                Uri r6 = (Uri) r5.getParcelable(MediaSessionCompat.ACTION_ARGUMENT_URI);
                this.this$0.onPlayFromUri(r6, r0);
                return;
            L6:
                if (r4.equals(MediaSessionCompat.ACTION_PREPARE) == false) goto L9;
                this.this$0.onPrepare();
                return;
            L9:
                if (r4.equals(MediaSessionCompat.ACTION_PREPARE_FROM_MEDIA_ID) == false) goto L12;
                String r7 = r5.getString(MediaSessionCompat.ACTION_ARGUMENT_MEDIA_ID);
                this.this$0.onPrepareFromMediaId(r7, r0);
                return;
            L12:
                if (r4.equals(MediaSessionCompat.ACTION_PREPARE_FROM_SEARCH) == false) goto L15;
                String r8 = r5.getString(MediaSessionCompat.ACTION_ARGUMENT_QUERY);
                this.this$0.onPrepareFromSearch(r8, r0);
                return;
            L15:
                if (r4.equals(MediaSessionCompat.ACTION_PREPARE_FROM_URI) == false) goto L18;
                Uri r9 = (Uri) r5.getParcelable(MediaSessionCompat.ACTION_ARGUMENT_URI);
                this.this$0.onPrepareFromUri(r9, r0);
                return;
            L18:
                if (r4.equals(MediaSessionCompat.ACTION_SET_CAPTIONING_ENABLED) == false) goto L21;
                boolean r10 = r5.getBoolean(MediaSessionCompat.ACTION_ARGUMENT_CAPTIONING_ENABLED);
                this.this$0.onSetCaptioningEnabled(r10);
                return;
            L21:
                if (r4.equals(MediaSessionCompat.ACTION_SET_REPEAT_MODE) == false) goto L24;
                int r11 = r5.getInt(MediaSessionCompat.ACTION_ARGUMENT_REPEAT_MODE);
                this.this$0.onSetRepeatMode(r11);
                return;
            L24:
                if (r4.equals(MediaSessionCompat.ACTION_SET_SHUFFLE_MODE) == false) goto L27;
                int r12 = r5.getInt(MediaSessionCompat.ACTION_ARGUMENT_SHUFFLE_MODE);
                this.this$0.onSetShuffleMode(r12);
                return;
            L27:
                if (r4.equals(MediaSessionCompat.ACTION_SET_RATING) == false) goto L29;
                RatingCompat r13 = (RatingCompat) r5.getParcelable(MediaSessionCompat.ACTION_ARGUMENT_RATING);
                this.this$0.onSetRating(r13, r0);
                return;
            L29:
                this.this$0.onCustomAction(r4, r5);
            }
        }

        private class StubApi23 extends StubApi21 implements MediaSessionCompatApi23.Callback {
            final /* synthetic */ Callback this$0;

            StubApi23(Callback r1) {
                this.this$0 = r1;
                super(r1);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi23.Callback
            public void onPlayFromUri(Uri r1, Bundle r2) {
                this.this$0.onPlayFromUri(r1, r2);
            }
        }

        private class StubApi24 extends StubApi23 implements MediaSessionCompatApi24.Callback {
            final /* synthetic */ Callback this$0;

            StubApi24(Callback r1) {
                this.this$0 = r1;
                super(r1);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi24.Callback
            public void onPrepare() {
                this.this$0.onPrepare();
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi24.Callback
            public void onPrepareFromMediaId(String r1, Bundle r2) {
                this.this$0.onPrepareFromMediaId(r1, r2);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi24.Callback
            public void onPrepareFromSearch(String r1, Bundle r2) {
                this.this$0.onPrepareFromSearch(r1, r2);
            }

            @Override // android.support.v4.media.session.MediaSessionCompatApi24.Callback
            public void onPrepareFromUri(Uri r1, Bundle r2) {
                this.this$0.onPrepareFromUri(r1, r2);
            }
        }

        public void onAddQueueItem(MediaDescriptionCompat r1) {
        }

        public void onAddQueueItem(MediaDescriptionCompat r1, int r2) {
        }

        public void onCommand(String r1, Bundle r2, ResultReceiver r3) {
        }

        public void onCustomAction(String r1, Bundle r2) {
        }

        public void onFastForward() {
        }

        public boolean onMediaButtonEvent(Intent r1) {
            return false;
        }

        public void onPause() {
        }

        public void onPlay() {
        }

        public void onPlayFromMediaId(String r1, Bundle r2) {
        }

        public void onPlayFromSearch(String r1, Bundle r2) {
        }

        public void onPlayFromUri(Uri r1, Bundle r2) {
        }

        public void onPrepare() {
        }

        public void onPrepareFromMediaId(String r1, Bundle r2) {
        }

        public void onPrepareFromSearch(String r1, Bundle r2) {
        }

        public void onPrepareFromUri(Uri r1, Bundle r2) {
        }

        public void onRemoveQueueItem(MediaDescriptionCompat r1) {
        }

        @Deprecated
        public void onRemoveQueueItemAt(int r1) {
        }

        public void onRewind() {
        }

        public void onSeekTo(long r1) {
        }

        public void onSetCaptioningEnabled(boolean r1) {
        }

        public void onSetRating(RatingCompat r1) {
        }

        public void onSetRating(RatingCompat r1, Bundle r2) {
        }

        public void onSetRepeatMode(int r1) {
        }

        public void onSetShuffleMode(int r1) {
        }

        public void onSkipToNext() {
        }

        public void onSkipToPrevious() {
        }

        public void onSkipToQueueItem(long r1) {
        }

        public void onStop() {
        }

        public Callback() {
            this.mCallbackHandler = null;
            this.mCallbackObj = MediaSessionCompatApi24.createCallback(new StubApi24(this));
        }

        void setSessionImpl(MediaSessionImpl r2, Handler r3) {
            this.mSessionImpl = new WeakReference(r2);
            CallbackHandler r4 = this.mCallbackHandler;
            if (r4 == null) goto L5;
            r4.removeCallbacksAndMessages(null);
        L5:
            this.mCallbackHandler = new CallbackHandler(this, r3.getLooper());
        }

        void handleMediaPlayPauseKeySingleTapIfPending(MediaSessionManager.RemoteUserInfo r12) {
            if (this.mMediaPlayPauseKeyPending == true) goto L5;
            return;
        L5:
            boolean r0 = false;
            this.mMediaPlayPauseKeyPending = false;
            this.mCallbackHandler.removeMessages(1);
            MediaSessionImpl r1 = this.mSessionImpl.get();
            if (r1 != null) goto L8;
            return;
        L8:
            PlaybackStateCompat r3 = r1.getPlaybackState();
            if (r3 != null) goto L11;
            long r6 = 0;
        L12:
            if (r3 != null) goto L14;
        L16:
            boolean r4 = false;
        L18:
            if ((516 & r6) == 0) goto L20;
            boolean r8 = true;
        L22:
            if ((r6 & 514) == 0) goto L24;
            r0 = true;
        L24:
            r1.setCurrentControllerInfo(r12);
            if (r4 == false) goto L28;
            if (r0 == false) goto L28;
            onPause();
        L31:
            r1.setCurrentControllerInfo(null);
            return;
        L28:
            if (r4 == true) goto L31;
            if (r8 == false) goto L31;
            onPlay();
            goto L31
        L20:
            r8 = false;
            goto L22
        L14:
            if (r3.getState() != 3) goto L16;
            r4 = true;
            goto L18
        L11:
            r6 = r3.getActions();
            goto L12
        }
    }

    interface MediaSessionImpl {
        String getCallingPackage();

        MediaSessionManager.RemoteUserInfo getCurrentControllerInfo();

        Object getMediaSession();

        PlaybackStateCompat getPlaybackState();

        Object getRemoteControlClient();

        Token getSessionToken();

        boolean isActive();

        void release();

        void sendSessionEvent(String r1, Bundle r2);

        void setActive(boolean r1);

        void setCallback(Callback r1, Handler r2);

        void setCaptioningEnabled(boolean r1);

        void setCurrentControllerInfo(MediaSessionManager.RemoteUserInfo r1);

        void setExtras(Bundle r1);

        void setFlags(int r1);

        void setMediaButtonReceiver(PendingIntent r1);

        void setMetadata(MediaMetadataCompat r1);

        void setPlaybackState(PlaybackStateCompat r1);

        void setPlaybackToLocal(int r1);

        void setPlaybackToRemote(VolumeProviderCompat r1);

        void setQueue(List<QueueItem> r1);

        void setQueueTitle(CharSequence r1);

        void setRatingType(int r1);

        void setRepeatMode(int r1);

        void setSessionActivity(PendingIntent r1);

        void setShuffleMode(int r1);
    }

    static class MediaSessionImplApi18 extends MediaSessionImplBase {
        private static boolean sIsMbrPendingIntentSupported = true;

        static {
        }

        MediaSessionImplApi18(Context r1, String r2, ComponentName r3, PendingIntent r4) {
            super(r1, r2, r3, r4);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase, android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCallback(Callback r1, Handler r2) {
            super.setCallback(r1, r2);
            if (r1 != null) goto L5;
            this.mRcc.setPlaybackPositionUpdateListener(null);
            return;
        L5:
            RemoteControlClient.OnPlaybackPositionUpdateListener r3 = new AnonymousClass1(this);
            this.mRcc.setPlaybackPositionUpdateListener(r3);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase
        void setRccState(PlaybackStateCompat r11) {
            long r0 = r11.getPosition();
            float r2 = r11.getPlaybackSpeed();
            long r3 = r11.getLastPositionUpdateTime();
            long r5 = SystemClock.elapsedRealtime();
            if (r11.getState() != 3) goto L14;
            long r7 = 0;
            if (r0 <= 0) goto L14;
            if (r3 <= 0) goto L13;
            r7 = r5 - r3;
            if (r2 <= 0.0f) goto L13;
            if (r2 == 1.0f) goto L13;
            r7 = (long) (r7 * r2);
        L13:
            r0 = r0 + r7;
        L14:
            this.mRcc.setPlaybackState(getRccStateFromState(r11.getState()), r0, r2);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase
        int getRccTransportControlFlagsFromActions(long r3) {
            int r2 = super.getRccTransportControlFlagsFromActions(r3);
            if ((r3 & 256) != 0) goto L5;
            return r2;
        L5:
            return r2 | 256;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase
        void registerMediaButtonEventReceiver(PendingIntent r3, ComponentName r4) {
            if (sIsMbrPendingIntentSupported == false) goto L8;
            this.mAudioManager.registerMediaButtonEventReceiver(r3);     // Catch: NullPointerException -> L6
        L6:
            Log.w(MediaSessionCompat.TAG, "Unable to register media button event receiver with PendingIntent, falling back to ComponentName.");
            sIsMbrPendingIntentSupported = false;
        L8:
            if (sIsMbrPendingIntentSupported == true) goto L13;
            super.registerMediaButtonEventReceiver(r3, r4);
            return;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase
        void unregisterMediaButtonEventReceiver(PendingIntent r2, ComponentName r3) {
            if (sIsMbrPendingIntentSupported == false) goto L5;
            this.mAudioManager.unregisterMediaButtonEventReceiver(r2);
            return;
        L5:
            super.unregisterMediaButtonEventReceiver(r2, r3);
        }
    }

    static class MediaSessionImplApi19 extends MediaSessionImplApi18 {
        MediaSessionImplApi19(Context r1, String r2, ComponentName r3, PendingIntent r4) {
            super(r1, r2, r3, r4);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi18, android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase, android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCallback(Callback r1, Handler r2) {
            super.setCallback(r1, r2);
            if (r1 != null) goto L5;
            this.mRcc.setMetadataUpdateListener(null);
            return;
        L5:
            RemoteControlClient.OnMetadataUpdateListener r3 = new AnonymousClass1(this);
            this.mRcc.setMetadataUpdateListener(r3);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi18, android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase
        int getRccTransportControlFlagsFromActions(long r3) {
            int r2 = super.getRccTransportControlFlagsFromActions(r3);
            if ((r3 & 128) != 0) goto L5;
            return r2;
        L5:
            return r2 | 512;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplBase
        RemoteControlClient.MetadataEditor buildRccMetadata(Bundle r9) {
            RemoteControlClient.MetadataEditor r0 = super.buildRccMetadata(r9);
            if (this.mState != null) goto L5;
            long r4 = 0;
        L7:
            if ((r4 & 128) == 0) goto L9;
            r0.addEditableKey(268435457);
        L9:
            if (r9 != null) goto L12;
            return r0;
        L12:
            if (r9.containsKey(MediaMetadataCompat.METADATA_KEY_YEAR) == false) goto L15;
            r0.putLong(8, r9.getLong(MediaMetadataCompat.METADATA_KEY_YEAR));
        L15:
            if (r9.containsKey(MediaMetadataCompat.METADATA_KEY_RATING) == false) goto L18;
            r0.putObject(101, r9.getParcelable(MediaMetadataCompat.METADATA_KEY_RATING));
        L18:
            if (r9.containsKey(MediaMetadataCompat.METADATA_KEY_USER_RATING) == false) goto L20;
            r0.putObject(268435457, r9.getParcelable(MediaMetadataCompat.METADATA_KEY_USER_RATING));
        L20:
            return r0;
        L5:
            r4 = this.mState.getActions();
            goto L7
        }
    }

    static class MediaSessionImplApi21 implements MediaSessionImpl {
        boolean mCaptioningEnabled;
        boolean mDestroyed;
        final RemoteCallbackList<IMediaControllerCallback> mExtraControllerCallbacks;
        MediaMetadataCompat mMetadata;
        PlaybackStateCompat mPlaybackState;
        List<QueueItem> mQueue;
        int mRatingType;
        int mRepeatMode;
        final Object mSessionObj;
        int mShuffleMode;
        final Token mToken;

        class ExtraSession extends IMediaSession.Stub {
            final /* synthetic */ MediaSessionImplApi21 this$0;

            @Override // android.support.v4.media.session.IMediaSession
            public List<QueueItem> getQueue() {
                return null;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isShuffleModeEnabledRemoved() {
                return false;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setShuffleModeEnabledRemoved(boolean r1) throws RemoteException {
            }

            ExtraSession(MediaSessionImplApi21 r1) {
                this.this$0 = r1;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void sendCommand(String r1, Bundle r2, ResultReceiverWrapper r3) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean sendMediaButton(KeyEvent r1) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void registerCallbackListener(IMediaControllerCallback r5) {
                if (this.this$0.mDestroyed == true) goto L9;
                String r0 = this.this$0.getCallingPackage();
                if (r0 != null) goto L7;
                r0 = MediaSessionManager.RemoteUserInfo.LEGACY_CONTROLLER;
            L7:
                MediaSessionManager.RemoteUserInfo r1 = new MediaSessionManager.RemoteUserInfo(r0, getCallingPid(), getCallingUid());
                this.this$0.mExtraControllerCallbacks.register(r5, r1);
                return;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void unregisterCallbackListener(IMediaControllerCallback r1) {
                this.this$0.mExtraControllerCallbacks.unregister(r1);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public String getPackageName() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public String getTag() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public PendingIntent getLaunchPendingIntent() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public long getFlags() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public ParcelableVolumeInfo getVolumeAttributes() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void adjustVolume(int r1, int r2, String r3) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setVolumeTo(int r1, int r2, String r3) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepare() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromMediaId(String r1, Bundle r2) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromSearch(String r1, Bundle r2) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromUri(Uri r1, Bundle r2) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void play() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromMediaId(String r1, Bundle r2) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromSearch(String r1, Bundle r2) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromUri(Uri r1, Bundle r2) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void skipToQueueItem(long r1) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void pause() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void stop() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void next() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void previous() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void fastForward() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rewind() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void seekTo(long r1) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rate(RatingCompat r1) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rateWithExtras(RatingCompat r1, Bundle r2) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setCaptioningEnabled(boolean r1) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setRepeatMode(int r1) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setShuffleMode(int r1) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void sendCustomAction(String r1, Bundle r2) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public MediaMetadataCompat getMetadata() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public PlaybackStateCompat getPlaybackState() {
                return MediaSessionCompat.getStateWithUpdatedPosition(this.this$0.mPlaybackState, this.this$0.mMetadata);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void addQueueItem(MediaDescriptionCompat r1) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void addQueueItemAt(MediaDescriptionCompat r1, int r2) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void removeQueueItem(MediaDescriptionCompat r1) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void removeQueueItemAt(int r1) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public CharSequence getQueueTitle() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public Bundle getExtras() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getRatingType() {
                return this.this$0.mRatingType;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isCaptioningEnabled() {
                return this.this$0.mCaptioningEnabled;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getRepeatMode() {
                return this.this$0.mRepeatMode;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getShuffleMode() {
                return this.this$0.mShuffleMode;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isTransportControlEnabled() {
                throw new AssertionError();
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public MediaSessionManager.RemoteUserInfo getCurrentControllerInfo() {
            return null;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public Object getRemoteControlClient() {
            return null;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCurrentControllerInfo(MediaSessionManager.RemoteUserInfo r1) {
        }

        MediaSessionImplApi21(Context r2, String r3, Bundle r4) {
            this.mDestroyed = false;
            this.mExtraControllerCallbacks = new RemoteCallbackList();
            Object r5 = MediaSessionCompatApi21.createSession(r2, r3);
            this.mSessionObj = r5;
            this.mToken = new Token(MediaSessionCompatApi21.getSessionToken(r5), new ExtraSession(this), r4);
        }

        MediaSessionImplApi21(Object r3) {
            this.mDestroyed = false;
            this.mExtraControllerCallbacks = new RemoteCallbackList();
            Object r4 = MediaSessionCompatApi21.verifySession(r3);
            this.mSessionObj = r4;
            this.mToken = new Token(MediaSessionCompatApi21.getSessionToken(r4), new ExtraSession(this));
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCallback(Callback r3, Handler r4) {
            Object r0 = this.mSessionObj;
            if (r3 != null) goto L5;
            Object r1 = null;
        L6:
            MediaSessionCompatApi21.setCallback(r0, r1, r4);
            if (r3 == null) goto L10;
            r3.setSessionImpl(this, r4);
            return;
        L10:
            return;
        L5:
            r1 = r3.mCallbackObj;
            goto L6
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setFlags(int r1) {
            MediaSessionCompatApi21.setFlags(this.mSessionObj, r1);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setPlaybackToLocal(int r1) {
            MediaSessionCompatApi21.setPlaybackToLocal(this.mSessionObj, r1);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setPlaybackToRemote(VolumeProviderCompat r1) {
            MediaSessionCompatApi21.setPlaybackToRemote(this.mSessionObj, r1.getVolumeProvider());
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setActive(boolean r1) {
            MediaSessionCompatApi21.setActive(this.mSessionObj, r1);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public boolean isActive() {
            return MediaSessionCompatApi21.isActive(this.mSessionObj);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void sendSessionEvent(String r1, Bundle r2) {
            MediaSessionCompatApi21.sendSessionEvent(this.mSessionObj, r1, r2);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void release() {
            this.mDestroyed = true;
            MediaSessionCompatApi21.release(this.mSessionObj);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public Token getSessionToken() {
            return this.mToken;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setPlaybackState(PlaybackStateCompat r3) {
            this.mPlaybackState = r3;
            int r0 = this.mExtraControllerCallbacks.beginBroadcast() - 1;
        L3:
            if (r0 < 0) goto L7;
            ((IMediaControllerCallback) this.mExtraControllerCallbacks.getBroadcastItem(r0)).onPlaybackStateChanged(r3);     // Catch: RemoteException -> L13
        L6:
            r0 = r0 - 1;
            goto L3
        L7:
            this.mExtraControllerCallbacks.finishBroadcast();
            Object r2 = this.mSessionObj;
            if (r3 != null) goto L10;
            Object r4 = null;
        L11:
            MediaSessionCompatApi21.setPlaybackState(r2, r4);
            return;
        L10:
            r4 = r3.getPlaybackState();
            goto L11
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public PlaybackStateCompat getPlaybackState() {
            return this.mPlaybackState;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setMetadata(MediaMetadataCompat r1) {
            this.mMetadata = r1;
            Object r0 = this.mSessionObj;
            if (r1 != null) goto L5;
            Object r2 = null;
        L6:
            MediaSessionCompatApi21.setMetadata(r0, r2);
            return;
        L5:
            r2 = r1.getMediaMetadata();
            goto L6
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setSessionActivity(PendingIntent r1) {
            MediaSessionCompatApi21.setSessionActivity(this.mSessionObj, r1);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setMediaButtonReceiver(PendingIntent r1) {
            MediaSessionCompatApi21.setMediaButtonReceiver(this.mSessionObj, r1);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setQueue(List<QueueItem> r3) {
            this.mQueue = r3;
            if (r3 == null) goto L8;
            ArrayList r0 = new ArrayList();
            Iterator<QueueItem> r4 = r3.iterator();
        L6:
            if (r4.hasNext() == false) goto L9;
            r0.add(r4.next().getQueueItem());
        L9:
            MediaSessionCompatApi21.setQueue(this.mSessionObj, r0);
            return;
        L8:
            r0 = null;
            goto L9
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setQueueTitle(CharSequence r1) {
            MediaSessionCompatApi21.setQueueTitle(this.mSessionObj, r1);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setRatingType(int r1) {
            MediaSessionCompatApi22.setRatingType(this.mSessionObj, r1);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCaptioningEnabled(boolean r3) {
            if (this.mCaptioningEnabled == r3) goto L16;
            this.mCaptioningEnabled = r3;
            int r0 = this.mExtraControllerCallbacks.beginBroadcast() - 1;
        L5:
            if (r0 < 0) goto L9;
            ((IMediaControllerCallback) this.mExtraControllerCallbacks.getBroadcastItem(r0)).onCaptioningEnabledChanged(r3);     // Catch: RemoteException -> L11
        L8:
            r0 = r0 - 1;
            goto L5
        L9:
            this.mExtraControllerCallbacks.finishBroadcast();
            return;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setRepeatMode(int r3) {
            if (this.mRepeatMode == r3) goto L16;
            this.mRepeatMode = r3;
            int r0 = this.mExtraControllerCallbacks.beginBroadcast() - 1;
        L5:
            if (r0 < 0) goto L9;
            ((IMediaControllerCallback) this.mExtraControllerCallbacks.getBroadcastItem(r0)).onRepeatModeChanged(r3);     // Catch: RemoteException -> L11
        L8:
            r0 = r0 - 1;
            goto L5
        L9:
            this.mExtraControllerCallbacks.finishBroadcast();
            return;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setShuffleMode(int r3) {
            if (this.mShuffleMode == r3) goto L16;
            this.mShuffleMode = r3;
            int r0 = this.mExtraControllerCallbacks.beginBroadcast() - 1;
        L5:
            if (r0 < 0) goto L9;
            ((IMediaControllerCallback) this.mExtraControllerCallbacks.getBroadcastItem(r0)).onShuffleModeChanged(r3);     // Catch: RemoteException -> L11
        L8:
            r0 = r0 - 1;
            goto L5
        L9:
            this.mExtraControllerCallbacks.finishBroadcast();
            return;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setExtras(Bundle r1) {
            MediaSessionCompatApi21.setExtras(this.mSessionObj, r1);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public Object getMediaSession() {
            return this.mSessionObj;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public String getCallingPackage() {
            return MediaSessionCompatApi24.getCallingPackage(this.mSessionObj);
        }
    }

    static class MediaSessionImplApi28 extends MediaSessionImplApi21 {
        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21, android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCurrentControllerInfo(MediaSessionManager.RemoteUserInfo r1) {
        }

        MediaSessionImplApi28(Context r1, String r2, Bundle r3) {
            super(r1, r2, r3);
        }

        MediaSessionImplApi28(Object r1) {
            super(r1);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImplApi21, android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public final MediaSessionManager.RemoteUserInfo getCurrentControllerInfo() {
            return new MediaSessionManager.RemoteUserInfo(((MediaSession) this.mSessionObj).getCurrentControllerInfo());
        }
    }

    static class MediaSessionImplBase implements MediaSessionImpl {
        static final int RCC_PLAYSTATE_NONE = 0;
        final AudioManager mAudioManager;
        volatile Callback mCallback;
        boolean mCaptioningEnabled;
        private final Context mContext;
        final RemoteCallbackList<IMediaControllerCallback> mControllerCallbacks;
        boolean mDestroyed;
        Bundle mExtras;
        int mFlags;
        private MessageHandler mHandler;
        boolean mIsActive;
        private boolean mIsMbrRegistered;
        private boolean mIsRccRegistered;
        int mLocalStream;
        final Object mLock;
        private final ComponentName mMediaButtonReceiverComponentName;
        private final PendingIntent mMediaButtonReceiverIntent;
        MediaMetadataCompat mMetadata;
        final String mPackageName;
        List<QueueItem> mQueue;
        CharSequence mQueueTitle;
        int mRatingType;
        final RemoteControlClient mRcc;
        private MediaSessionManager.RemoteUserInfo mRemoteUserInfo;
        int mRepeatMode;
        PendingIntent mSessionActivity;
        int mShuffleMode;
        PlaybackStateCompat mState;
        private final MediaSessionStub mStub;
        final String mTag;
        private final Token mToken;
        private VolumeProviderCompat.Callback mVolumeCallback;
        VolumeProviderCompat mVolumeProvider;
        int mVolumeType;

        private static final class Command {
            public final String command;
            public final Bundle extras;
            public final ResultReceiver stub;

            public Command(String r1, Bundle r2, ResultReceiver r3) {
                this.command = r1;
                this.extras = r2;
                this.stub = r3;
            }
        }

        class MediaSessionStub extends IMediaSession.Stub {
            final /* synthetic */ MediaSessionImplBase this$0;

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isShuffleModeEnabledRemoved() {
                return false;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setShuffleModeEnabledRemoved(boolean r1) throws RemoteException {
            }

            MediaSessionStub(MediaSessionImplBase r1) {
                this.this$0 = r1;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void sendCommand(String r2, Bundle r3, ResultReceiverWrapper r4) {
                postToHandler(1, new Command(r2, r3, r4.mResultReceiver));
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean sendMediaButton(KeyEvent r3) {
                boolean r1 = true;
                if ((this.this$0.mFlags & 1) != 0) goto L6;
                r1 = false;
            L6:
                if (r1 == false) goto L8;
                postToHandler(21, r3);
            L8:
                return r1;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void registerCallbackListener(IMediaControllerCallback r5) {
                if (this.this$0.mDestroyed == true) goto L9;
                MediaSessionManager.RemoteUserInfo r0 = new MediaSessionManager.RemoteUserInfo(MediaSessionManager.RemoteUserInfo.LEGACY_CONTROLLER, getCallingPid(), getCallingUid());
                this.this$0.mControllerCallbacks.register(r5, r0);
                return;
            L9:
                r5.onSessionDestroyed();     // Catch: Exception -> L8
                return;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void unregisterCallbackListener(IMediaControllerCallback r1) {
                this.this$0.mControllerCallbacks.unregister(r1);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public String getPackageName() {
                return this.this$0.mPackageName;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public String getTag() {
                return this.this$0.mTag;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public PendingIntent getLaunchPendingIntent() {
                Object r0 = this.this$0.mLock;
                monitor-enter(r0);
                PendingIntent r1 = this.this$0.mSessionActivity;     // Catch: Throwable -> L7
                monitor-exit(r0);     // Catch: Throwable -> L7
                return r1;
            L7:
                th = move-exception;
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public long getFlags() {
                Object r0 = this.this$0.mLock;
                monitor-enter(r0);
                long r1 = this.this$0.mFlags;     // Catch: Throwable -> L7
                monitor-exit(r0);     // Catch: Throwable -> L7
                return r1;
            L7:
                th = move-exception;
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public ParcelableVolumeInfo getVolumeAttributes() {
                Object r0 = this.this$0.mLock;
                monitor-enter(r0);
                int r3 = this.this$0.mVolumeType;     // Catch: Throwable -> L11
                int r4 = this.this$0.mLocalStream;     // Catch: Throwable -> L11
                VolumeProviderCompat r1 = this.this$0.mVolumeProvider;     // Catch: Throwable -> L11
                if (r3 != 2) goto L7;
                int r8 = r1.getVolumeControl();     // Catch: Throwable -> L11
                int r2 = r1.getMaxVolume();     // Catch: Throwable -> L11
                int r5 = r8;
                int r7 = r1.getCurrentVolume();     // Catch: Throwable -> L11
                int r6 = r2;
            L8:
                monitor-exit(r0);     // Catch: Throwable -> L11
                return new ParcelableVolumeInfo(r3, r4, r5, r6, r7);
            L7:
                int r9 = this.this$0.mAudioManager.getStreamMaxVolume(r4);     // Catch: Throwable -> L11
                r7 = this.this$0.mAudioManager.getStreamVolume(r4);     // Catch: Throwable -> L11
                r6 = r9;
                r5 = 2;
            L11:
                th = move-exception;
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void adjustVolume(int r1, int r2, String r3) {
                this.this$0.adjustVolume(r1, r2);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setVolumeTo(int r1, int r2, String r3) {
                this.this$0.setVolumeTo(r1, r2);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepare() throws RemoteException {
                postToHandler(3);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromMediaId(String r2, Bundle r3) throws RemoteException {
                postToHandler(4, r2, r3);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromSearch(String r2, Bundle r3) throws RemoteException {
                postToHandler(5, r2, r3);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void prepareFromUri(Uri r2, Bundle r3) throws RemoteException {
                postToHandler(6, r2, r3);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void play() throws RemoteException {
                postToHandler(7);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromMediaId(String r2, Bundle r3) throws RemoteException {
                postToHandler(8, r2, r3);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromSearch(String r2, Bundle r3) throws RemoteException {
                postToHandler(9, r2, r3);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void playFromUri(Uri r2, Bundle r3) throws RemoteException {
                postToHandler(10, r2, r3);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void skipToQueueItem(long r2) {
                postToHandler(11, Long.valueOf(r2));
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void pause() throws RemoteException {
                postToHandler(12);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void stop() throws RemoteException {
                postToHandler(13);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void next() throws RemoteException {
                postToHandler(14);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void previous() throws RemoteException {
                postToHandler(15);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void fastForward() throws RemoteException {
                postToHandler(16);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rewind() throws RemoteException {
                postToHandler(17);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void seekTo(long r2) throws RemoteException {
                postToHandler(18, Long.valueOf(r2));
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rate(RatingCompat r2) throws RemoteException {
                postToHandler(19, r2);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void rateWithExtras(RatingCompat r2, Bundle r3) throws RemoteException {
                postToHandler(31, r2, r3);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setCaptioningEnabled(boolean r2) throws RemoteException {
                postToHandler(29, Boolean.valueOf(r2));
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setRepeatMode(int r2) throws RemoteException {
                postToHandler(23, r2);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void setShuffleMode(int r2) throws RemoteException {
                postToHandler(30, r2);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void sendCustomAction(String r2, Bundle r3) throws RemoteException {
                postToHandler(20, r2, r3);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public MediaMetadataCompat getMetadata() {
                return this.this$0.mMetadata;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public PlaybackStateCompat getPlaybackState() {
                Object r0 = this.this$0.mLock;
                monitor-enter(r0);
                PlaybackStateCompat r1 = this.this$0.mState;     // Catch: Throwable -> L8
                MediaMetadataCompat r2 = this.this$0.mMetadata;     // Catch: Throwable -> L8
                monitor-exit(r0);     // Catch: Throwable -> L8
                return MediaSessionCompat.getStateWithUpdatedPosition(r1, r2);
            L8:
                th = move-exception;
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public List<QueueItem> getQueue() {
                Object r0 = this.this$0.mLock;
                monitor-enter(r0);
                List<QueueItem> r1 = this.this$0.mQueue;     // Catch: Throwable -> L7
                monitor-exit(r0);     // Catch: Throwable -> L7
                return r1;
            L7:
                th = move-exception;
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void addQueueItem(MediaDescriptionCompat r2) {
                postToHandler(25, r2);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void addQueueItemAt(MediaDescriptionCompat r2, int r3) {
                postToHandler(26, r2, r3);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void removeQueueItem(MediaDescriptionCompat r2) {
                postToHandler(27, r2);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public void removeQueueItemAt(int r2) {
                postToHandler(28, r2);
            }

            @Override // android.support.v4.media.session.IMediaSession
            public CharSequence getQueueTitle() {
                return this.this$0.mQueueTitle;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public Bundle getExtras() {
                Object r0 = this.this$0.mLock;
                monitor-enter(r0);
                Bundle r1 = this.this$0.mExtras;     // Catch: Throwable -> L7
                monitor-exit(r0);     // Catch: Throwable -> L7
                return r1;
            L7:
                th = move-exception;
                throw th;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getRatingType() {
                return this.this$0.mRatingType;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isCaptioningEnabled() {
                return this.this$0.mCaptioningEnabled;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getRepeatMode() {
                return this.this$0.mRepeatMode;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public int getShuffleMode() {
                return this.this$0.mShuffleMode;
            }

            @Override // android.support.v4.media.session.IMediaSession
            public boolean isTransportControlEnabled() {
                if ((this.this$0.mFlags & 2) == 0) goto L5;
                return true;
            L5:
                return false;
            }

            void postToHandler(int r7) {
                this.this$0.postToHandler(r7, 0, 0, null, null);
            }

            void postToHandler(int r7, int r8) {
                this.this$0.postToHandler(r7, r8, 0, null, null);
            }

            void postToHandler(int r7, Object r8) {
                this.this$0.postToHandler(r7, 0, 0, r8, null);
            }

            void postToHandler(int r7, Object r8, int r9) {
                this.this$0.postToHandler(r7, r9, 0, r8, null);
            }

            void postToHandler(int r7, Object r8, Bundle r9) {
                this.this$0.postToHandler(r7, 0, 0, r8, r9);
            }
        }

        class MessageHandler extends Handler {
            private static final int KEYCODE_MEDIA_PAUSE = 127;
            private static final int KEYCODE_MEDIA_PLAY = 126;
            private static final int MSG_ADD_QUEUE_ITEM = 25;
            private static final int MSG_ADD_QUEUE_ITEM_AT = 26;
            private static final int MSG_ADJUST_VOLUME = 2;
            private static final int MSG_COMMAND = 1;
            private static final int MSG_CUSTOM_ACTION = 20;
            private static final int MSG_FAST_FORWARD = 16;
            private static final int MSG_MEDIA_BUTTON = 21;
            private static final int MSG_NEXT = 14;
            private static final int MSG_PAUSE = 12;
            private static final int MSG_PLAY = 7;
            private static final int MSG_PLAY_MEDIA_ID = 8;
            private static final int MSG_PLAY_SEARCH = 9;
            private static final int MSG_PLAY_URI = 10;
            private static final int MSG_PREPARE = 3;
            private static final int MSG_PREPARE_MEDIA_ID = 4;
            private static final int MSG_PREPARE_SEARCH = 5;
            private static final int MSG_PREPARE_URI = 6;
            private static final int MSG_PREVIOUS = 15;
            private static final int MSG_RATE = 19;
            private static final int MSG_RATE_EXTRA = 31;
            private static final int MSG_REMOVE_QUEUE_ITEM = 27;
            private static final int MSG_REMOVE_QUEUE_ITEM_AT = 28;
            private static final int MSG_REWIND = 17;
            private static final int MSG_SEEK_TO = 18;
            private static final int MSG_SET_CAPTIONING_ENABLED = 29;
            private static final int MSG_SET_REPEAT_MODE = 23;
            private static final int MSG_SET_SHUFFLE_MODE = 30;
            private static final int MSG_SET_VOLUME = 22;
            private static final int MSG_SKIP_TO_ITEM = 11;
            private static final int MSG_STOP = 13;
            final /* synthetic */ MediaSessionImplBase this$0;

            public MessageHandler(MediaSessionImplBase r1, Looper r2) {
                this.this$0 = r1;
                super(r2);
            }

            @Override // android.os.Handler
            public void handleMessage(Message r8) {
                Callback r0 = this.this$0.mCallback;
                if (r0 != null) goto L5;
                return;
            L5:
                Bundle r1 = r8.getData();
                MediaSessionCompat.ensureClassLoader(r1);
                this.this$0.setCurrentControllerInfo(new MediaSessionManager.RemoteUserInfo(r1.getString(MediaSessionCompat.DATA_CALLING_PACKAGE), r1.getInt("data_calling_pid"), r1.getInt("data_calling_uid")));
                Bundle r2 = r1.getBundle(MediaSessionCompat.DATA_EXTRAS);
                MediaSessionCompat.ensureClassLoader(r2);
            L52:
                th = move-exception;
                this.this$0.setCurrentControllerInfo(null);
                throw th;
            L7:
                switch(r8.what) {
                    case 1: goto L49;
                    case 2: goto L48;
                    case 3: goto L47;
                    case 4: goto L46;
                    case 5: goto L45;
                    case 6: goto L44;
                    case 7: goto L43;
                    case 8: goto L42;
                    case 9: goto L41;
                    case 10: goto L40;
                    case 11: goto L39;
                    case 12: goto L38;
                    case 13: goto L37;
                    case 14: goto L36;
                    case 15: goto L35;
                    case 16: goto L34;
                    case 17: goto L33;
                    case 18: goto L32;
                    case 19: goto L31;
                    case 20: goto L30;
                    case 21: goto L27;
                    case 22: goto L26;
                    case 23: goto L25;
                    case 24: goto L50;
                    case 25: goto L24;
                    case 26: goto L23;
                    case 27: goto L22;
                    case 28: goto L13;
                    case 29: goto L11;
                    case 30: goto L10;
                    case 31: goto L9;
                    default: goto L50;
                };     // Catch: Throwable -> L52
            L9:
                r0.onSetRating((RatingCompat) r8.obj, r2);     // Catch: Throwable -> L52
                goto L50
            L10:
                r0.onSetShuffleMode(r8.arg1);     // Catch: Throwable -> L52
                goto L50
            L11:
                r0.onSetCaptioningEnabled(((Boolean) r8.obj).booleanValue());     // Catch: Throwable -> L52
                goto L50
            L22:
                r0.onRemoveQueueItem((MediaDescriptionCompat) r8.obj);     // Catch: Throwable -> L52
                goto L50
            L23:
                r0.onAddQueueItem((MediaDescriptionCompat) r8.obj, r8.arg1);     // Catch: Throwable -> L52
                goto L50
            L24:
                r0.onAddQueueItem((MediaDescriptionCompat) r8.obj);     // Catch: Throwable -> L52
                goto L50
            L25:
                r0.onSetRepeatMode(r8.arg1);     // Catch: Throwable -> L52
                goto L50
            L26:
                this.this$0.setVolumeTo(r8.arg1, 0);     // Catch: Throwable -> L52
                goto L50
            L27:
                KeyEvent r9 = (KeyEvent) r8.obj;     // Catch: Throwable -> L52
                Intent r3 = new Intent("android.intent.action.MEDIA_BUTTON");     // Catch: Throwable -> L52
                r3.putExtra("android.intent.extra.KEY_EVENT", r9);     // Catch: Throwable -> L52
                if (r0.onMediaButtonEvent(r3) == true) goto L50;
                onMediaButtonEvent(r9, r0);     // Catch: Throwable -> L52
                goto L50
            L30:
                r0.onCustomAction((String) r8.obj, r2);     // Catch: Throwable -> L52
                goto L50
            L31:
                r0.onSetRating((RatingCompat) r8.obj);     // Catch: Throwable -> L52
                goto L50
            L32:
                r0.onSeekTo(((Long) r8.obj).longValue());     // Catch: Throwable -> L52
                goto L50
            L33:
                r0.onRewind();     // Catch: Throwable -> L52
                goto L50
            L34:
                r0.onFastForward();     // Catch: Throwable -> L52
                goto L50
            L35:
                r0.onSkipToPrevious();     // Catch: Throwable -> L52
                goto L50
            L36:
                r0.onSkipToNext();     // Catch: Throwable -> L52
                goto L50
            L37:
                r0.onStop();     // Catch: Throwable -> L52
                goto L50
            L38:
                r0.onPause();     // Catch: Throwable -> L52
                goto L50
            L39:
                r0.onSkipToQueueItem(((Long) r8.obj).longValue());     // Catch: Throwable -> L52
                goto L50
            L40:
                r0.onPlayFromUri((Uri) r8.obj, r2);     // Catch: Throwable -> L52
                goto L50
            L41:
                r0.onPlayFromSearch((String) r8.obj, r2);     // Catch: Throwable -> L52
                goto L50
            L42:
                r0.onPlayFromMediaId((String) r8.obj, r2);     // Catch: Throwable -> L52
                goto L50
            L43:
                r0.onPlay();     // Catch: Throwable -> L52
                goto L50
            L44:
                r0.onPrepareFromUri((Uri) r8.obj, r2);     // Catch: Throwable -> L52
                goto L50
            L45:
                r0.onPrepareFromSearch((String) r8.obj, r2);     // Catch: Throwable -> L52
                goto L50
            L46:
                r0.onPrepareFromMediaId((String) r8.obj, r2);     // Catch: Throwable -> L52
                goto L50
            L47:
                r0.onPrepare();     // Catch: Throwable -> L52
                goto L50
            L48:
                this.this$0.adjustVolume(r8.arg1, 0);     // Catch: Throwable -> L52
                goto L50
            L49:
                Command r10 = (Command) r8.obj;     // Catch: Throwable -> L52
                r0.onCommand(r10.command, r10.extras, r10.stub);     // Catch: Throwable -> L52
            L50:
                this.this$0.setCurrentControllerInfo(null);
                return;
            L13:
                if (this.this$0.mQueue == null) goto L50;
                if (r8.arg1 >= 0) goto L17;
            L19:
                QueueItem r11 = null;
            L20:
                if (r11 == null) goto L50;
                r0.onRemoveQueueItem(r11.getDescription());     // Catch: Throwable -> L52
                goto L50
            L17:
                if (r8.arg1 >= this.this$0.mQueue.size()) goto L19;
                r11 = this.this$0.mQueue.get(r8.arg1);     // Catch: Throwable -> L52
                goto L20
            }

            private void onMediaButtonEvent(KeyEvent r6, Callback r7) {
                if (r6 != null) goto L4;
                return;
            L4:
                if (r6.getAction() == 0) goto L7;
                return;
            L7:
                if (this.this$0.mState != null) goto L9;
                long r3 = 0;
            L10:
                int r5 = r6.getKeyCode();
                if (r5 != 79) goto L13;
            L39:
                Log.w(MediaSessionCompat.TAG, "KEYCODE_MEDIA_PLAY_PAUSE and KEYCODE_HEADSETHOOK are handled already");
                return;
            L13:
                if (r5 == 126) goto L37;
                if (r5 == 127) goto L34;
                switch(r5) {
                    case 85: goto L39;
                    case 86: goto L31;
                    case 87: goto L28;
                    case 88: goto L25;
                    case 89: goto L22;
                    case 90: goto L19;
                    default: goto L57;
                };
            L57:
                return;
            L19:
                if ((64 & r3) == 0) goto L42;
                r7.onFastForward();
                return;
            L42:
                return;
            L22:
                if ((8 & r3) == 0) goto L44;
                r7.onRewind();
                return;
            L44:
                return;
            L25:
                if ((16 & r3) == 0) goto L46;
                r7.onSkipToPrevious();
                return;
            L46:
                return;
            L28:
                if ((32 & r3) == 0) goto L48;
                r7.onSkipToNext();
                return;
            L48:
                return;
            L31:
                if ((1 & r3) == 0) goto L50;
                r7.onStop();
                return;
            L50:
                return;
            L34:
                if ((2 & r3) == 0) goto L52;
                r7.onPause();
                return;
            L52:
                return;
            L37:
                if ((4 & r3) == 0) goto L54;
                r7.onPlay();
                return;
            L54:
                return;
            L9:
                r3 = this.this$0.mState.getActions();
                goto L10
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public String getCallingPackage() {
            return null;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public Object getMediaSession() {
            return null;
        }

        int getRccStateFromState(int r1) {
            switch(r1) {
                case 0: goto L23;
                case 1: goto L21;
                case 2: goto L19;
                case 3: goto L17;
                case 4: goto L15;
                case 5: goto L13;
                case 6: goto L11;
                case 7: goto L9;
                case 8: goto L11;
                case 9: goto L7;
                case 10: goto L5;
                case 11: goto L5;
                default: goto L3;
            };
        L3:
            return -1;
        L5:
            return 6;
        L7:
            return 7;
        L9:
            return 9;
        L11:
            return 8;
        L13:
            return 5;
        L15:
            return 4;
        L17:
            return 3;
        L19:
            return 2;
        L21:
            return 1;
        L23:
            return 0;
        }

        int getRccTransportControlFlagsFromActions(long r5) {
            if ((1 & r5) == 0) goto L5;
            int r4 = 32;
        L7:
            if ((2 & r5) == 0) goto L10;
            r4 = r4 | 16;
        L10:
            if ((4 & r5) == 0) goto L13;
            r4 = r4 | 4;
        L13:
            if ((8 & r5) == 0) goto L16;
            r4 = r4 | 2;
        L16:
            if ((16 & r5) == 0) goto L19;
            r4 = r4 | 1;
        L19:
            if ((32 & r5) == 0) goto L22;
            r4 = r4 | 128;
        L22:
            if ((64 & r5) == 0) goto L25;
            r4 = r4 | 64;
        L25:
            if ((r5 & 512) != 0) goto L27;
            return r4;
        L27:
            return r4 | 8;
        L5:
            r4 = 0;
            goto L7
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public Object getRemoteControlClient() {
            return null;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setMediaButtonReceiver(PendingIntent r1) {
        }

        public MediaSessionImplBase(Context r3, String r4, ComponentName r5, PendingIntent r6) {
            this.mLock = new Object();
            this.mControllerCallbacks = new RemoteCallbackList();
            this.mDestroyed = false;
            this.mIsActive = false;
            this.mIsMbrRegistered = false;
            this.mIsRccRegistered = false;
            this.mVolumeCallback = new AnonymousClass1(this);
            if (r5 == null) goto L7;
            this.mContext = r3;
            this.mPackageName = r3.getPackageName();
            this.mAudioManager = (AudioManager) r3.getSystemService("audio");
            this.mTag = r4;
            this.mMediaButtonReceiverComponentName = r5;
            this.mMediaButtonReceiverIntent = r6;
            MediaSessionStub r7 = new MediaSessionStub(this);
            this.mStub = r7;
            this.mToken = new Token(r7);
            this.mRatingType = 0;
            this.mVolumeType = 1;
            this.mLocalStream = 3;
            this.mRcc = new RemoteControlClient(r6);
            return;
        L7:
            throw new IllegalArgumentException("MediaButtonReceiver component may not be null.");
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCallback(Callback r3, Handler r4) {
            this.mCallback = r3;
            if (r3 == null) goto L17;
            if (r4 != null) goto L6;
            r4 = new Handler();
        L6:
            Object r5 = this.mLock;
            monitor-enter(r5);
            MessageHandler r0 = this.mHandler;     // Catch: Throwable -> L14
            if (r0 == null) goto L11;
            r0.removeCallbacksAndMessages(null);     // Catch: Throwable -> L14
        L11:
            this.mHandler = new MessageHandler(this, r4.getLooper());     // Catch: Throwable -> L14
            this.mCallback.setSessionImpl(this, r4);     // Catch: Throwable -> L14
            monitor-exit(r5);     // Catch: Throwable -> L14
            return;
        L14:
            th = move-exception;
            throw th;
        }

        void postToHandler(int r2, int r3, int r4, Object r5, Bundle r6) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            MessageHandler r1 = this.mHandler;     // Catch: Throwable -> L12
            if (r1 == null) goto L10;
            Message r7 = r1.obtainMessage(r2, r3, r4, r5);     // Catch: Throwable -> L12
            Bundle r8 = new Bundle();     // Catch: Throwable -> L12
            r8.putString(MediaSessionCompat.DATA_CALLING_PACKAGE, MediaSessionManager.RemoteUserInfo.LEGACY_CONTROLLER);     // Catch: Throwable -> L12
            r8.putInt("data_calling_pid", Binder.getCallingPid());     // Catch: Throwable -> L12
            r8.putInt("data_calling_uid", Binder.getCallingUid());     // Catch: Throwable -> L12
            if (r6 == null) goto L9;
            r8.putBundle(MediaSessionCompat.DATA_EXTRAS, r6);     // Catch: Throwable -> L12
        L9:
            r7.setData(r8);     // Catch: Throwable -> L12
            r7.sendToTarget();     // Catch: Throwable -> L12
        L10:
            monitor-exit(r0);     // Catch: Throwable -> L12
            return;
        L12:
            th = move-exception;
            throw th;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setFlags(int r2) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            this.mFlags = r2;     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            update();
            return;
        L8:
            th = move-exception;
            throw th;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setPlaybackToLocal(int r7) {
            VolumeProviderCompat r0 = this.mVolumeProvider;
            if (r0 == null) goto L5;
            r0.setCallback(null);
        L5:
            this.mLocalStream = r7;
            this.mVolumeType = 1;
            int r1 = this.mVolumeType;
            int r2 = this.mLocalStream;
            sendVolumeInfoChanged(new ParcelableVolumeInfo(r1, r2, 2, this.mAudioManager.getStreamMaxVolume(r2), this.mAudioManager.getStreamVolume(this.mLocalStream)));
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setPlaybackToRemote(VolumeProviderCompat r8) {
            if (r8 == null) goto L9;
            VolumeProviderCompat r0 = this.mVolumeProvider;
            if (r0 == null) goto L6;
            r0.setCallback(null);
        L6:
            this.mVolumeType = 2;
            this.mVolumeProvider = r8;
            sendVolumeInfoChanged(new ParcelableVolumeInfo(this.mVolumeType, this.mLocalStream, this.mVolumeProvider.getVolumeControl(), this.mVolumeProvider.getMaxVolume(), this.mVolumeProvider.getCurrentVolume()));
            r8.setCallback(this.mVolumeCallback);
            return;
        L9:
            throw new IllegalArgumentException("volumeProvider may not be null");
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setActive(boolean r2) {
            if (r2 != this.mIsActive) goto L5;
            return;
        L5:
            this.mIsActive = r2;
            if (update() == false) goto L9;
            setMetadata(this.mMetadata);
            setPlaybackState(this.mState);
            return;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public boolean isActive() {
            return this.mIsActive;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void sendSessionEvent(String r1, Bundle r2) {
            sendEvent(r1, r2);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void release() {
            this.mIsActive = false;
            this.mDestroyed = true;
            update();
            sendSessionDestroyed();
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public Token getSessionToken() {
            return this.mToken;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setPlaybackState(PlaybackStateCompat r4) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            this.mState = r4;     // Catch: Throwable -> L13
            monitor-exit(r0);     // Catch: Throwable -> L13
            sendState(r4);
            if (this.mIsActive == true) goto L9;
            return;
        L9:
            if (r4 != null) goto L11;
            this.mRcc.setPlaybackState(0);
            this.mRcc.setTransportControlFlags(0);
            return;
        L11:
            setRccState(r4);
            this.mRcc.setTransportControlFlags(getRccTransportControlFlagsFromActions(r4.getActions()));
            return;
        L13:
            th = move-exception;
            throw th;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public PlaybackStateCompat getPlaybackState() {
            Object r0 = this.mLock;
            monitor-enter(r0);
            PlaybackStateCompat r1 = this.mState;     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        void setRccState(PlaybackStateCompat r2) {
            this.mRcc.setPlaybackState(getRccStateFromState(r2.getState()));
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setMetadata(MediaMetadataCompat r3) {
            if (r3 == null) goto L4;
            r3 = new MediaMetadataCompat.Builder(r3, MediaSessionCompat.sMaxBitmapSize).build();
        L4:
            Object r0 = this.mLock;
            monitor-enter(r0);
            this.mMetadata = r3;     // Catch: Throwable -> L16
            monitor-exit(r0);     // Catch: Throwable -> L16
            sendMetadata(r3);
            if (this.mIsActive == true) goto L11;
            return;
        L11:
            if (r3 != null) goto L13;
            Bundle r4 = null;
        L14:
            buildRccMetadata(r4).apply();
            return;
        L13:
            r4 = r3.getBundle();
        L16:
            th = move-exception;
            throw th;
        }

        RemoteControlClient.MetadataEditor buildRccMetadata(Bundle r6) {
            RemoteControlClient.MetadataEditor r5 = this.mRcc.editMetadata(true);
            if (r6 != null) goto L6;
            return r5;
        L6:
            if (r6.containsKey(MediaMetadataCompat.METADATA_KEY_ART) == false) goto L12;
            Bitmap r1 = (Bitmap) r6.getParcelable(MediaMetadataCompat.METADATA_KEY_ART);
            if (r1 == null) goto L10;
            r1 = r1.copy(r1.getConfig(), false);
        L10:
            r5.putBitmap(100, r1);
        L18:
            if (r6.containsKey(MediaMetadataCompat.METADATA_KEY_ALBUM) == false) goto L21;
            r5.putString(1, r6.getString(MediaMetadataCompat.METADATA_KEY_ALBUM));
        L21:
            if (r6.containsKey(MediaMetadataCompat.METADATA_KEY_ALBUM_ARTIST) == false) goto L24;
            r5.putString(13, r6.getString(MediaMetadataCompat.METADATA_KEY_ALBUM_ARTIST));
        L24:
            if (r6.containsKey(MediaMetadataCompat.METADATA_KEY_ARTIST) == false) goto L27;
            r5.putString(2, r6.getString(MediaMetadataCompat.METADATA_KEY_ARTIST));
        L27:
            if (r6.containsKey(MediaMetadataCompat.METADATA_KEY_AUTHOR) == false) goto L30;
            r5.putString(3, r6.getString(MediaMetadataCompat.METADATA_KEY_AUTHOR));
        L30:
            if (r6.containsKey(MediaMetadataCompat.METADATA_KEY_COMPILATION) == false) goto L33;
            r5.putString(15, r6.getString(MediaMetadataCompat.METADATA_KEY_COMPILATION));
        L33:
            if (r6.containsKey(MediaMetadataCompat.METADATA_KEY_COMPOSER) == false) goto L36;
            r5.putString(4, r6.getString(MediaMetadataCompat.METADATA_KEY_COMPOSER));
        L36:
            if (r6.containsKey(MediaMetadataCompat.METADATA_KEY_DATE) == false) goto L39;
            r5.putString(5, r6.getString(MediaMetadataCompat.METADATA_KEY_DATE));
        L39:
            if (r6.containsKey(MediaMetadataCompat.METADATA_KEY_DISC_NUMBER) == false) goto L42;
            r5.putLong(14, r6.getLong(MediaMetadataCompat.METADATA_KEY_DISC_NUMBER));
        L42:
            if (r6.containsKey(MediaMetadataCompat.METADATA_KEY_DURATION) == false) goto L45;
            r5.putLong(9, r6.getLong(MediaMetadataCompat.METADATA_KEY_DURATION));
        L45:
            if (r6.containsKey(MediaMetadataCompat.METADATA_KEY_GENRE) == false) goto L48;
            r5.putString(6, r6.getString(MediaMetadataCompat.METADATA_KEY_GENRE));
        L48:
            if (r6.containsKey(MediaMetadataCompat.METADATA_KEY_TITLE) == false) goto L51;
            r5.putString(7, r6.getString(MediaMetadataCompat.METADATA_KEY_TITLE));
        L51:
            if (r6.containsKey(MediaMetadataCompat.METADATA_KEY_TRACK_NUMBER) == false) goto L54;
            r5.putLong(0, r6.getLong(MediaMetadataCompat.METADATA_KEY_TRACK_NUMBER));
        L54:
            if (r6.containsKey(MediaMetadataCompat.METADATA_KEY_WRITER) == false) goto L56;
            r5.putString(11, r6.getString(MediaMetadataCompat.METADATA_KEY_WRITER));
        L56:
            return r5;
        L12:
            if (r6.containsKey(MediaMetadataCompat.METADATA_KEY_ALBUM_ART) == false) goto L18;
            Bitmap r2 = (Bitmap) r6.getParcelable(MediaMetadataCompat.METADATA_KEY_ALBUM_ART);
            if (r2 == null) goto L16;
            r2 = r2.copy(r2.getConfig(), false);
        L16:
            r5.putBitmap(100, r2);
            goto L18
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setSessionActivity(PendingIntent r2) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            this.mSessionActivity = r2;     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setQueue(List<QueueItem> r1) {
            this.mQueue = r1;
            sendQueue(r1);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setQueueTitle(CharSequence r1) {
            this.mQueueTitle = r1;
            sendQueueTitle(r1);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setRatingType(int r1) {
            this.mRatingType = r1;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCaptioningEnabled(boolean r2) {
            if (this.mCaptioningEnabled == r2) goto L6;
            this.mCaptioningEnabled = r2;
            sendCaptioningEnabled(r2);
            return;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setRepeatMode(int r2) {
            if (this.mRepeatMode == r2) goto L6;
            this.mRepeatMode = r2;
            sendRepeatMode(r2);
            return;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setShuffleMode(int r2) {
            if (this.mShuffleMode == r2) goto L6;
            this.mShuffleMode = r2;
            sendShuffleMode(r2);
            return;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setExtras(Bundle r1) {
            this.mExtras = r1;
            sendExtras(r1);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public MediaSessionManager.RemoteUserInfo getCurrentControllerInfo() {
            Object r0 = this.mLock;
            monitor-enter(r0);
            MediaSessionManager.RemoteUserInfo r1 = this.mRemoteUserInfo;     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.MediaSessionImpl
        public void setCurrentControllerInfo(MediaSessionManager.RemoteUserInfo r2) {
            Object r0 = this.mLock;
            monitor-enter(r0);
            this.mRemoteUserInfo = r2;     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            throw th;
        }

        boolean update() {
            if (this.mIsActive == false) goto L23;
            boolean r0 = this.mIsMbrRegistered;
            if (r0 == false) goto L7;
        L9:
            if (r0 == true) goto L11;
        L13:
            boolean r1 = this.mIsRccRegistered;
            if (r1 == false) goto L16;
        L18:
            if (r1 == true) goto L20;
            return false;
        L20:
            if ((this.mFlags & 2) != 0) goto L31;
            this.mRcc.setPlaybackState(0);
            this.mAudioManager.unregisterRemoteControlClient(this.mRcc);
            this.mIsRccRegistered = false;
            return false;
        L31:
            return false;
        L16:
            if ((this.mFlags & 2) == 0) goto L18;
            this.mAudioManager.registerRemoteControlClient(this.mRcc);
            this.mIsRccRegistered = true;
            return true;
        L11:
            if ((this.mFlags & 1) != 0) goto L13;
            unregisterMediaButtonEventReceiver(this.mMediaButtonReceiverIntent, this.mMediaButtonReceiverComponentName);
            this.mIsMbrRegistered = false;
            goto L13
        L7:
            if ((this.mFlags & 1) == 0) goto L9;
            registerMediaButtonEventReceiver(this.mMediaButtonReceiverIntent, this.mMediaButtonReceiverComponentName);
            this.mIsMbrRegistered = true;
            goto L13
        L23:
            if (this.mIsMbrRegistered == false) goto L26;
            unregisterMediaButtonEventReceiver(this.mMediaButtonReceiverIntent, this.mMediaButtonReceiverComponentName);
            this.mIsMbrRegistered = false;
        L26:
            if (this.mIsRccRegistered == false) goto L33;
            this.mRcc.setPlaybackState(0);
            this.mAudioManager.unregisterRemoteControlClient(this.mRcc);
            this.mIsRccRegistered = false;
            return false;
        L33:
            return false;
        }

        void registerMediaButtonEventReceiver(PendingIntent r1, ComponentName r2) {
            this.mAudioManager.registerMediaButtonEventReceiver(r2);
        }

        void unregisterMediaButtonEventReceiver(PendingIntent r1, ComponentName r2) {
            this.mAudioManager.unregisterMediaButtonEventReceiver(r2);
        }

        void adjustVolume(int r3, int r4) {
            if (this.mVolumeType != 2) goto L7;
            VolumeProviderCompat r2 = this.mVolumeProvider;
            if (r2 == null) goto L9;
            r2.onAdjustVolume(r3);
            return;
        L9:
            return;
        L7:
            this.mAudioManager.adjustStreamVolume(this.mLocalStream, r3, r4);
        }

        void setVolumeTo(int r3, int r4) {
            if (this.mVolumeType != 2) goto L7;
            VolumeProviderCompat r2 = this.mVolumeProvider;
            if (r2 == null) goto L9;
            r2.onSetVolumeTo(r3);
            return;
        L9:
            return;
        L7:
            this.mAudioManager.setStreamVolume(this.mLocalStream, r3, r4);
        }

        void sendVolumeInfoChanged(ParcelableVolumeInfo r3) {
            int r0 = this.mControllerCallbacks.beginBroadcast() - 1;
        L3:
            if (r0 < 0) goto L7;
            ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(r0)).onVolumeInfoChanged(r3);     // Catch: RemoteException -> L9
        L6:
            r0 = r0 - 1;
            goto L3
        L7:
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendSessionDestroyed() {
            int r0 = this.mControllerCallbacks.beginBroadcast() - 1;
        L3:
            if (r0 < 0) goto L7;
            ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(r0)).onSessionDestroyed();     // Catch: RemoteException -> L9
        L6:
            r0 = r0 - 1;
            goto L3
        L7:
            this.mControllerCallbacks.finishBroadcast();
            this.mControllerCallbacks.kill();
        }

        private void sendEvent(String r3, Bundle r4) {
            int r0 = this.mControllerCallbacks.beginBroadcast() - 1;
        L3:
            if (r0 < 0) goto L7;
            ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(r0)).onEvent(r3, r4);     // Catch: RemoteException -> L9
        L6:
            r0 = r0 - 1;
            goto L3
        L7:
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendState(PlaybackStateCompat r3) {
            int r0 = this.mControllerCallbacks.beginBroadcast() - 1;
        L3:
            if (r0 < 0) goto L7;
            ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(r0)).onPlaybackStateChanged(r3);     // Catch: RemoteException -> L9
        L6:
            r0 = r0 - 1;
            goto L3
        L7:
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendMetadata(MediaMetadataCompat r3) {
            int r0 = this.mControllerCallbacks.beginBroadcast() - 1;
        L3:
            if (r0 < 0) goto L7;
            ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(r0)).onMetadataChanged(r3);     // Catch: RemoteException -> L9
        L6:
            r0 = r0 - 1;
            goto L3
        L7:
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendQueue(List<QueueItem> r3) {
            int r0 = this.mControllerCallbacks.beginBroadcast() - 1;
        L3:
            if (r0 < 0) goto L7;
            ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(r0)).onQueueChanged(r3);     // Catch: RemoteException -> L9
        L6:
            r0 = r0 - 1;
            goto L3
        L7:
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendQueueTitle(CharSequence r3) {
            int r0 = this.mControllerCallbacks.beginBroadcast() - 1;
        L3:
            if (r0 < 0) goto L7;
            ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(r0)).onQueueTitleChanged(r3);     // Catch: RemoteException -> L9
        L6:
            r0 = r0 - 1;
            goto L3
        L7:
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendCaptioningEnabled(boolean r3) {
            int r0 = this.mControllerCallbacks.beginBroadcast() - 1;
        L3:
            if (r0 < 0) goto L7;
            ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(r0)).onCaptioningEnabledChanged(r3);     // Catch: RemoteException -> L9
        L6:
            r0 = r0 - 1;
            goto L3
        L7:
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendRepeatMode(int r3) {
            int r0 = this.mControllerCallbacks.beginBroadcast() - 1;
        L3:
            if (r0 < 0) goto L7;
            ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(r0)).onRepeatModeChanged(r3);     // Catch: RemoteException -> L9
        L6:
            r0 = r0 - 1;
            goto L3
        L7:
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendShuffleMode(int r3) {
            int r0 = this.mControllerCallbacks.beginBroadcast() - 1;
        L3:
            if (r0 < 0) goto L7;
            ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(r0)).onShuffleModeChanged(r3);     // Catch: RemoteException -> L9
        L6:
            r0 = r0 - 1;
            goto L3
        L7:
            this.mControllerCallbacks.finishBroadcast();
        }

        private void sendExtras(Bundle r3) {
            int r0 = this.mControllerCallbacks.beginBroadcast() - 1;
        L3:
            if (r0 < 0) goto L7;
            ((IMediaControllerCallback) this.mControllerCallbacks.getBroadcastItem(r0)).onExtrasChanged(r3);     // Catch: RemoteException -> L9
        L6:
            r0 = r0 - 1;
            goto L3
        L7:
            this.mControllerCallbacks.finishBroadcast();
        }
    }

    public interface OnActiveChangeListener {
        void onActiveChanged();
    }

    public static final class QueueItem implements Parcelable {
        public static final Parcelable.Creator<QueueItem> CREATOR = null;
        public static final int UNKNOWN_ID = -1;
        private final MediaDescriptionCompat mDescription;
        private final long mId;
        private Object mItem;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public QueueItem(MediaDescriptionCompat r2, long r3) {
            this(null, r2, r3);
        }

        private QueueItem(Object r3, MediaDescriptionCompat r4, long r5) {
            if (r4 == null) goto L11;
            if (r5 == (-1)) goto L9;
            this.mDescription = r4;
            this.mId = r5;
            this.mItem = r3;
            return;
        L9:
            throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
        L11:
            throw new IllegalArgumentException("Description cannot be null.");
        }

        QueueItem(Parcel r3) {
            this.mDescription = MediaDescriptionCompat.CREATOR.createFromParcel(r3);
            this.mId = r3.readLong();
        }

        public MediaDescriptionCompat getDescription() {
            return this.mDescription;
        }

        public long getQueueId() {
            return this.mId;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r3, int r4) {
            this.mDescription.writeToParcel(r3, r4);
            r3.writeLong(this.mId);
        }

        public Object getQueueItem() {
            Object r0 = this.mItem;
            if (r0 != null) goto L6;
            Object r1 = MediaSessionCompatApi21.QueueItem.createItem(this.mDescription.getMediaDescription(), this.mId);
            this.mItem = r1;
            return r1;
        L6:
            return r0;
        }

        public static QueueItem fromQueueItem(Object r4) {
            if (r4 != null) goto L4;
            return null;
        L4:
            return new QueueItem(r4, MediaDescriptionCompat.fromMediaDescription(MediaSessionCompatApi21.QueueItem.getDescription(r4)), MediaSessionCompatApi21.QueueItem.getQueueId(r4));
        }

        public static List<QueueItem> fromQueueItemList(List<?> r2) {
            if (r2 == null) goto L8;
            ArrayList r0 = new ArrayList();
            Iterator<?> r3 = r2.iterator();
        L5:
            if (r3.hasNext() == false) goto L7;
            r0.add(fromQueueItem(r3.next()));
            goto L5
        L7:
            return r0;
        L8:
            return null;
        }

        static {
            CREATOR = new AnonymousClass1();
        }

        public String toString() {
            return "MediaSession.QueueItem {Description=" + this.mDescription + ", Id=" + this.mId + " }";
        }
    }

    public static final class ResultReceiverWrapper implements Parcelable {
        public static final Parcelable.Creator<ResultReceiverWrapper> CREATOR = null;
        ResultReceiver mResultReceiver;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public ResultReceiverWrapper(ResultReceiver r1) {
            this.mResultReceiver = r1;
        }

        ResultReceiverWrapper(Parcel r2) {
            this.mResultReceiver = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(r2);
        }

        static {
            CREATOR = new AnonymousClass1();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            this.mResultReceiver.writeToParcel(r1, r2);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SessionFlags {
    }

    public static final class Token implements Parcelable {
        public static final Parcelable.Creator<Token> CREATOR = null;
        private IMediaSession mExtraBinder;
        private final Object mInner;
        private Bundle mSessionToken2Bundle;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        Token(Object r2) {
            this(r2, null, null);
        }

        Token(Object r2, IMediaSession r3) {
            this(r2, r3, null);
        }

        Token(Object r1, IMediaSession r2, Bundle r3) {
            this.mInner = r1;
            this.mExtraBinder = r2;
            this.mSessionToken2Bundle = r3;
        }

        public static Token fromToken(Object r1) {
            return fromToken(r1, null);
        }

        public static Token fromToken(Object r1, IMediaSession r2) {
            if (r1 != null) goto L4;
            return null;
        L4:
            return new Token(MediaSessionCompatApi21.verifyToken(r1), r2);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            r1.writeParcelable((Parcelable) this.mInner, r2);
        }

        public int hashCode() {
            Object r0 = this.mInner;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof Token) == true) goto L8;
            return false;
        L8:
            Token r5 = (Token) r4;
            Object r3 = this.mInner;
            if (r3 == null) goto L11;
            Object r6 = r5.mInner;
            if (r6 != null) goto L19;
            return false;
        L19:
            return r3.equals(r6);
        L11:
            if (r5.mInner != null) goto L14;
            return true;
        L14:
            return false;
        }

        public Object getToken() {
            return this.mInner;
        }

        public IMediaSession getExtraBinder() {
            return this.mExtraBinder;
        }

        public void setExtraBinder(IMediaSession r1) {
            this.mExtraBinder = r1;
        }

        public Bundle getSessionToken2Bundle() {
            return this.mSessionToken2Bundle;
        }

        public void setSessionToken2Bundle(Bundle r1) {
            this.mSessionToken2Bundle = r1;
        }

        public Bundle toBundle() {
            Bundle r0 = new Bundle();
            r0.putParcelable(MediaSessionCompat.KEY_TOKEN, this);
            IMediaSession r1 = this.mExtraBinder;
            if (r1 == null) goto L5;
            BundleCompat.putBinder(r0, MediaSessionCompat.KEY_EXTRA_BINDER, r1.asBinder());
        L5:
            Bundle r3 = this.mSessionToken2Bundle;
            if (r3 == null) goto L8;
            r0.putBundle(MediaSessionCompat.KEY_SESSION_TOKEN2_BUNDLE, r3);
        L8:
            return r0;
        }

        public static Token fromBundle(Bundle r4) {
            if (r4 != null) goto L5;
            return null;
        L5:
            IMediaSession r1 = IMediaSession.Stub.asInterface(BundleCompat.getBinder(r4, MediaSessionCompat.KEY_EXTRA_BINDER));
            Bundle r2 = r4.getBundle(MediaSessionCompat.KEY_SESSION_TOKEN2_BUNDLE);
            Token r5 = (Token) r4.getParcelable(MediaSessionCompat.KEY_TOKEN);
            if (r5 != null) goto L9;
            return null;
        L9:
            return new Token(r5.mInner, r1, r2);
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    public MediaSessionCompat(Context r2, String r3) {
        this(r2, r3, null, null);
    }

    public MediaSessionCompat(Context r7, String r8, ComponentName r9, PendingIntent r10) {
        this(r7, r8, r9, r10, null);
    }

    public MediaSessionCompat(Context r7, String r8, Bundle r9) {
        this(r7, r8, null, null, r9);
    }

    private MediaSessionCompat(Context r3, String r4, ComponentName r5, PendingIntent r6, Bundle r7) {
        this.mActiveListeners = new ArrayList();
        if (r3 == null) goto L20;
        if (TextUtils.isEmpty(r4) == true) goto L18;
        if (r5 != null) goto L10;
        r5 = MediaButtonReceiver.getMediaButtonReceiverComponent(r3);
        if (r5 != null) goto L10;
        Log.w(TAG, "Couldn't find a unique registered media button receiver in the given context.");
    L10:
        if (r5 == null) goto L13;
        if (r6 != null) goto L13;
        Intent r8 = new Intent("android.intent.action.MEDIA_BUTTON");
        r8.setComponent(r5);
        r6 = PendingIntent.getBroadcast(r3, 0, r8, 0);
    L13:
        MediaSessionImplApi28 r9 = new MediaSessionImplApi28(r3, r4, r7);
        this.mImpl = r9;
        setCallback(new AnonymousClass1(this));
        r9.setMediaButtonReceiver(r6);
        this.mController = new MediaControllerCompat(r3, this);
        if (sMaxBitmapSize != 0) goto L21;
        sMaxBitmapSize = (int) (TypedValue.applyDimension(1, 320.0f, r3.getResources().getDisplayMetrics()) + 0.5f);
        return;
    L21:
        return;
    L18:
        throw new IllegalArgumentException("tag must not be null or empty");
    L20:
        throw new IllegalArgumentException("context must not be null");
    }

    private MediaSessionCompat(Context r2, MediaSessionImpl r3) {
        this.mActiveListeners = new ArrayList();
        this.mImpl = r3;
        if (MediaSessionCompatApi21.hasCallback(r3.getMediaSession()) == true) goto L5;
        setCallback(new AnonymousClass3(this));
    L5:
        this.mController = new MediaControllerCompat(r2, this);
    }

    public void setCallback(Callback r2) {
        setCallback(r2, null);
    }

    public void setCallback(Callback r1, Handler r2) {
        if (r1 != null) goto L4;
        this.mImpl.setCallback(null, null);
        return;
    L4:
        MediaSessionImpl r0 = this.mImpl;
        if (r2 != null) goto L8;
        r2 = new Handler();
    L8:
        r0.setCallback(r1, r2);
    }

    public void setSessionActivity(PendingIntent r1) {
        this.mImpl.setSessionActivity(r1);
    }

    public void setMediaButtonReceiver(PendingIntent r1) {
        this.mImpl.setMediaButtonReceiver(r1);
    }

    public void setFlags(int r1) {
        this.mImpl.setFlags(r1);
    }

    public void setPlaybackToLocal(int r1) {
        this.mImpl.setPlaybackToLocal(r1);
    }

    public void setPlaybackToRemote(VolumeProviderCompat r1) {
        if (r1 == null) goto L6;
        this.mImpl.setPlaybackToRemote(r1);
        return;
    L6:
        throw new IllegalArgumentException("volumeProvider may not be null!");
    }

    public void setActive(boolean r2) {
        this.mImpl.setActive(r2);
        Iterator<OnActiveChangeListener> r1 = this.mActiveListeners.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().onActiveChanged();
        goto L4
    }

    public boolean isActive() {
        return this.mImpl.isActive();
    }

    public void sendSessionEvent(String r2, Bundle r3) {
        if (TextUtils.isEmpty(r2) == true) goto L7;
        this.mImpl.sendSessionEvent(r2, r3);
        return;
    L7:
        throw new IllegalArgumentException("event cannot be null or empty");
    }

    public void release() {
        this.mImpl.release();
    }

    public Token getSessionToken() {
        return this.mImpl.getSessionToken();
    }

    public MediaControllerCompat getController() {
        return this.mController;
    }

    public void setPlaybackState(PlaybackStateCompat r1) {
        this.mImpl.setPlaybackState(r1);
    }

    public void setMetadata(MediaMetadataCompat r1) {
        this.mImpl.setMetadata(r1);
    }

    public void setQueue(List<QueueItem> r1) {
        this.mImpl.setQueue(r1);
    }

    public void setQueueTitle(CharSequence r1) {
        this.mImpl.setQueueTitle(r1);
    }

    public void setRatingType(int r1) {
        this.mImpl.setRatingType(r1);
    }

    public void setCaptioningEnabled(boolean r1) {
        this.mImpl.setCaptioningEnabled(r1);
    }

    public void setRepeatMode(int r1) {
        this.mImpl.setRepeatMode(r1);
    }

    public void setShuffleMode(int r1) {
        this.mImpl.setShuffleMode(r1);
    }

    public void setExtras(Bundle r1) {
        this.mImpl.setExtras(r1);
    }

    public Object getMediaSession() {
        return this.mImpl.getMediaSession();
    }

    public Object getRemoteControlClient() {
        return this.mImpl.getRemoteControlClient();
    }

    public final MediaSessionManager.RemoteUserInfo getCurrentControllerInfo() {
        return this.mImpl.getCurrentControllerInfo();
    }

    public String getCallingPackage() {
        return this.mImpl.getCallingPackage();
    }

    public void addOnActiveChangeListener(OnActiveChangeListener r1) {
        if (r1 == null) goto L6;
        this.mActiveListeners.add(r1);
        return;
    L6:
        throw new IllegalArgumentException("Listener may not be null");
    }

    public void removeOnActiveChangeListener(OnActiveChangeListener r1) {
        if (r1 == null) goto L6;
        this.mActiveListeners.remove(r1);
        return;
    L6:
        throw new IllegalArgumentException("Listener may not be null");
    }

    public static MediaSessionCompat fromMediaSession(Context r2, Object r3) {
        if (r2 == null) goto L6;
        if (r3 != null) goto L5;
        return null;
    L5:
        return new MediaSessionCompat(r2, new MediaSessionImplApi21(r3));
    L6:
        return null;
    }

    public static void ensureClassLoader(Bundle r1) {
        if (r1 == null) goto L5;
        r1.setClassLoader(MediaSessionCompat.class.getClassLoader());
        return;
    }

    static PlaybackStateCompat getStateWithUpdatedPosition(PlaybackStateCompat r14, MediaMetadataCompat r15) {
        if (r14 == null) goto L30;
        long r2 = -1;
        if (r14.getPosition() != (-1)) goto L7;
        return r14;
    L7:
        if (r14.getState() != 3) goto L9;
    L12:
        long r0 = r14.getLastPositionUpdateTime();
        if (r0 <= 0) goto L32;
        long r12 = SystemClock.elapsedRealtime();
        long r1 = ((long) (r14.getPlaybackSpeed() * (r12 - r0))) + r14.getPosition();
        if (r15 == null) goto L20;
        if (r15.containsKey(MediaMetadataCompat.METADATA_KEY_DURATION) == false) goto L20;
        r2 = r15.getLong(MediaMetadataCompat.METADATA_KEY_DURATION);
    L20:
        if (r2 < 0) goto L25;
        if (r1 <= r2) goto L25;
        long r9 = r2;
    L29:
        return new PlaybackStateCompat.Builder(r14).setState(r14.getState(), r9, r14.getPlaybackSpeed(), r12).build();
    L25:
        if (r1 >= 0) goto L27;
        r9 = 0;
        goto L29
    L27:
        r9 = r1;
        goto L29
    L32:
        return r14;
    L9:
        if (r14.getState() == 4) goto L12;
        if (r14.getState() == 5) goto L12;
        return r14;
    L30:
        return r14;
    }
}

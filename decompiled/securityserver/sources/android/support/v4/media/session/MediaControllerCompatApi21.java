package android.support.v4.media.session;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.MediaMetadata;
import android.media.Rating;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.view.KeyEvent;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
class MediaControllerCompatApi21 {

    public interface Callback {
        void onAudioInfoChanged(int r1, int r2, int r3, int r4, int r5);

        void onExtrasChanged(Bundle r1);

        void onMetadataChanged(Object r1);

        void onPlaybackStateChanged(Object r1);

        void onQueueChanged(List<?> r1);

        void onQueueTitleChanged(CharSequence r1);

        void onSessionDestroyed();

        void onSessionEvent(String r1, Bundle r2);
    }

    public static class CallbackProxy<T extends Callback> extends MediaController.Callback {
        protected final T mCallback;

        public CallbackProxy(T r1) {
            this.mCallback = r1;
        }

        @Override // android.media.session.MediaController.Callback
        public void onAudioInfoChanged(MediaController.PlaybackInfo r7) {
            this.mCallback.onAudioInfoChanged(r7.getPlaybackType(), PlaybackInfo.getLegacyAudioStream(r7), r7.getVolumeControl(), r7.getMaxVolume(), r7.getCurrentVolume());
        }

        @Override // android.media.session.MediaController.Callback
        public void onExtrasChanged(Bundle r1) {
            MediaSessionCompat.ensureClassLoader(r1);
            this.mCallback.onExtrasChanged(r1);
        }

        @Override // android.media.session.MediaController.Callback
        public void onMetadataChanged(MediaMetadata r1) {
            this.mCallback.onMetadataChanged(r1);
        }

        @Override // android.media.session.MediaController.Callback
        public void onPlaybackStateChanged(PlaybackState r1) {
            this.mCallback.onPlaybackStateChanged(r1);
        }

        @Override // android.media.session.MediaController.Callback
        public void onQueueChanged(List<MediaSession.QueueItem> r1) {
            this.mCallback.onQueueChanged(r1);
        }

        @Override // android.media.session.MediaController.Callback
        public void onQueueTitleChanged(CharSequence r1) {
            this.mCallback.onQueueTitleChanged(r1);
        }

        @Override // android.media.session.MediaController.Callback
        public void onSessionDestroyed() {
            this.mCallback.onSessionDestroyed();
        }

        @Override // android.media.session.MediaController.Callback
        public void onSessionEvent(String r1, Bundle r2) {
            MediaSessionCompat.ensureClassLoader(r2);
            this.mCallback.onSessionEvent(r1, r2);
        }
    }

    public static class PlaybackInfo {
        private static final int FLAG_SCO = 4;
        private static final int STREAM_BLUETOOTH_SCO = 6;
        private static final int STREAM_SYSTEM_ENFORCED = 7;

        private PlaybackInfo() {
        }

        public static AudioAttributes getAudioAttributes(Object r0) {
            return ((MediaController.PlaybackInfo) r0).getAudioAttributes();
        }

        public static int getCurrentVolume(Object r0) {
            return ((MediaController.PlaybackInfo) r0).getCurrentVolume();
        }

        public static int getLegacyAudioStream(Object r0) {
            return toLegacyStreamType(getAudioAttributes(r0));
        }

        public static int getMaxVolume(Object r0) {
            return ((MediaController.PlaybackInfo) r0).getMaxVolume();
        }

        public static int getPlaybackType(Object r0) {
            return ((MediaController.PlaybackInfo) r0).getPlaybackType();
        }

        public static int getVolumeControl(Object r0) {
            return ((MediaController.PlaybackInfo) r0).getVolumeControl();
        }

        private static int toLegacyStreamType(AudioAttributes r3) {
            if ((r3.getFlags() & 1) != 1) goto L7;
            return 7;
        L7:
            if ((r3.getFlags() & 4) != 4) goto L10;
            return 6;
        L10:
            int r4 = r3.getUsage();
            if (r4 == 13) goto L24;
            switch(r4) {
                case 2: goto L22;
                case 3: goto L20;
                case 4: goto L19;
                case 5: goto L17;
                case 6: goto L15;
                case 7: goto L17;
                case 8: goto L17;
                case 9: goto L17;
                case 10: goto L17;
                default: goto L13;
            };
        L13:
            return 3;
        L15:
            return 2;
        L17:
            return 5;
        L19:
            return 4;
        L20:
            return 8;
        L22:
            return 0;
        L24:
            return 1;
        }
    }

    public static class TransportControls {
        private TransportControls() {
        }

        public static void fastForward(Object r0) {
            ((MediaController.TransportControls) r0).fastForward();
        }

        public static void pause(Object r0) {
            ((MediaController.TransportControls) r0).pause();
        }

        public static void play(Object r0) {
            ((MediaController.TransportControls) r0).play();
        }

        public static void playFromMediaId(Object r0, String r1, Bundle r2) {
            ((MediaController.TransportControls) r0).playFromMediaId(r1, r2);
        }

        public static void playFromSearch(Object r0, String r1, Bundle r2) {
            ((MediaController.TransportControls) r0).playFromSearch(r1, r2);
        }

        public static void rewind(Object r0) {
            ((MediaController.TransportControls) r0).rewind();
        }

        public static void seekTo(Object r0, long r1) {
            ((MediaController.TransportControls) r0).seekTo(r1);
        }

        public static void sendCustomAction(Object r0, String r1, Bundle r2) {
            ((MediaController.TransportControls) r0).sendCustomAction(r1, r2);
        }

        public static void setRating(Object r0, Object r1) {
            ((MediaController.TransportControls) r0).setRating((Rating) r1);
        }

        public static void skipToNext(Object r0) {
            ((MediaController.TransportControls) r0).skipToNext();
        }

        public static void skipToPrevious(Object r0) {
            ((MediaController.TransportControls) r0).skipToPrevious();
        }

        public static void skipToQueueItem(Object r0, long r1) {
            ((MediaController.TransportControls) r0).skipToQueueItem(r1);
        }

        public static void stop(Object r0) {
            ((MediaController.TransportControls) r0).stop();
        }
    }

    private MediaControllerCompatApi21() {
    }

    public static void adjustVolume(Object r0, int r1, int r2) {
        ((MediaController) r0).adjustVolume(r1, r2);
    }

    public static Object createCallback(Callback r1) {
        return new CallbackProxy(r1);
    }

    public static boolean dispatchMediaButtonEvent(Object r0, KeyEvent r1) {
        return ((MediaController) r0).dispatchMediaButtonEvent(r1);
    }

    public static Object fromToken(Context r1, Object r2) {
        return new MediaController(r1, (MediaSession.Token) r2);
    }

    public static Bundle getExtras(Object r0) {
        return ((MediaController) r0).getExtras();
    }

    public static long getFlags(Object r2) {
        return ((MediaController) r2).getFlags();
    }

    public static Object getMediaController(Activity r0) {
        return r0.getMediaController();
    }

    public static Object getMetadata(Object r0) {
        return ((MediaController) r0).getMetadata();
    }

    public static String getPackageName(Object r0) {
        return ((MediaController) r0).getPackageName();
    }

    public static Object getPlaybackInfo(Object r0) {
        return ((MediaController) r0).getPlaybackInfo();
    }

    public static Object getPlaybackState(Object r0) {
        return ((MediaController) r0).getPlaybackState();
    }

    public static List<Object> getQueue(Object r1) {
        List<MediaSession.QueueItem> r2 = ((MediaController) r1).getQueue();
        if (r2 != null) goto L7;
        return null;
    L7:
        return new ArrayList(r2);
    }

    public static CharSequence getQueueTitle(Object r0) {
        return ((MediaController) r0).getQueueTitle();
    }

    public static int getRatingType(Object r0) {
        return ((MediaController) r0).getRatingType();
    }

    public static PendingIntent getSessionActivity(Object r0) {
        return ((MediaController) r0).getSessionActivity();
    }

    public static Object getSessionToken(Object r0) {
        return ((MediaController) r0).getSessionToken();
    }

    public static Object getTransportControls(Object r0) {
        return ((MediaController) r0).getTransportControls();
    }

    public static void registerCallback(Object r0, Object r1, Handler r2) {
        ((MediaController) r0).registerCallback((MediaController.Callback) r1, r2);
    }

    public static void sendCommand(Object r0, String r1, Bundle r2, ResultReceiver r3) {
        ((MediaController) r0).sendCommand(r1, r2, r3);
    }

    public static void setMediaController(Activity r0, Object r1) {
        r0.setMediaController((MediaController) r1);
    }

    public static void setVolumeTo(Object r0, int r1, int r2) {
        ((MediaController) r0).setVolumeTo(r1, r2);
    }

    public static void unregisterCallback(Object r0, Object r1) {
        ((MediaController) r0).unregisterCallback((MediaController.Callback) r1);
    }
}

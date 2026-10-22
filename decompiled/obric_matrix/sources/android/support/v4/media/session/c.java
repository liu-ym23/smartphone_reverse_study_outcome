package android.support.v4.media.session;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.MediaMetadata;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.KeyEvent;
import androidx.annotation.RequiresApi;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
class c {

    public interface a {
        void a(Object r1);

        void b(int r1, int r2, int r3, int r4, int r5);

        void c(Object r1);

        void d(Bundle r1);

        void e(List<?> r1);

        void f(String r1, Bundle r2);

        void g(CharSequence r1);

        void h();
    }

    static class b<T extends a> extends MediaController.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final T f214a;

        public b(T r1) {
            this.f214a = r1;
        }

        @Override // android.media.session.MediaController.Callback
        public void onAudioInfoChanged(MediaController.PlaybackInfo r7) {
            this.f214a.b(r7.getPlaybackType(), C0012c.b(r7), r7.getVolumeControl(), r7.getMaxVolume(), r7.getCurrentVolume());
        }

        @Override // android.media.session.MediaController.Callback
        public void onExtrasChanged(Bundle r1) {
            MediaSessionCompat.a(r1);
            this.f214a.d(r1);
        }

        @Override // android.media.session.MediaController.Callback
        public void onMetadataChanged(MediaMetadata r1) {
            this.f214a.a(r1);
        }

        @Override // android.media.session.MediaController.Callback
        public void onPlaybackStateChanged(PlaybackState r1) {
            this.f214a.c(r1);
        }

        @Override // android.media.session.MediaController.Callback
        public void onQueueChanged(List<MediaSession.QueueItem> r1) {
            this.f214a.e(r1);
        }

        @Override // android.media.session.MediaController.Callback
        public void onQueueTitleChanged(CharSequence r1) {
            this.f214a.g(r1);
        }

        @Override // android.media.session.MediaController.Callback
        public void onSessionDestroyed() {
            this.f214a.h();
        }

        @Override // android.media.session.MediaController.Callback
        public void onSessionEvent(String r1, Bundle r2) {
            MediaSessionCompat.a(r2);
            this.f214a.f(r1, r2);
        }
    }

    /* JADX INFO: renamed from: android.support.v4.media.session.c$c, reason: collision with other inner class name */
    public static class C0012c {
        public static AudioAttributes a(Object r0) {
            return ((MediaController.PlaybackInfo) r0).getAudioAttributes();
        }

        public static int b(Object r0) {
            return c(a(r0));
        }

        private static int c(AudioAttributes r3) {
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

    public static Object a(a r1) {
        return new b(r1);
    }

    public static boolean b(Object r0, KeyEvent r1) {
        return ((MediaController) r0).dispatchMediaButtonEvent(r1);
    }

    public static Object c(Context r1, Object r2) {
        return new MediaController(r1, (MediaSession.Token) r2);
    }

    public static void d(Object r0, String r1, Bundle r2, ResultReceiver r3) {
        ((MediaController) r0).sendCommand(r1, r2, r3);
    }
}

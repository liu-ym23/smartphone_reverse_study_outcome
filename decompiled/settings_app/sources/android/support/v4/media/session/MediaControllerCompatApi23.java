package android.support.v4.media.session;

import android.media.session.MediaController;
import android.net.Uri;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
class MediaControllerCompatApi23 {

    public static class TransportControls {
        public static void playFromUri(Object r0, Uri r1, Bundle r2) {
            ((MediaController.TransportControls) r0).playFromUri(r1, r2);
        }

        private TransportControls() {
        }
    }

    private MediaControllerCompatApi23() {
    }
}

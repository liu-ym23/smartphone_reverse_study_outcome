package android.support.v4.media;

import android.media.MediaDescription;
import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
class MediaDescriptionCompatApi23 {

    static class Builder {
        public static void setMediaUri(Object r0, Uri r1) {
            ((MediaDescription.Builder) r0).setMediaUri(r1);
        }

        private Builder() {
        }
    }

    public static Uri getMediaUri(Object r0) {
        return ((MediaDescription) r0).getMediaUri();
    }

    private MediaDescriptionCompatApi23() {
    }
}

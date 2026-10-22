package android.support.v4.media;

import android.media.MediaDescription;
import android.net.Uri;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(23)
class d {

    static class a {
        public static void a(Object r0, Uri r1) {
            ((MediaDescription.Builder) r0).setMediaUri(r1);
        }
    }

    public static Uri a(Object r0) {
        return ((MediaDescription) r0).getMediaUri();
    }
}

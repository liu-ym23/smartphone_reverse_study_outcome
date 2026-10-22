package android.support.v4.media;

import android.media.MediaMetadata;
import android.os.Parcel;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
class e {
    public static void a(Object r0, Parcel r1, int r2) {
        ((MediaMetadata) r0).writeToParcel(r1, r2);
    }
}

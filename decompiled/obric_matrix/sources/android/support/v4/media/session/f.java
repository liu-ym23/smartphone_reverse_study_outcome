package android.support.v4.media.session;

import android.media.session.PlaybackState;
import android.os.Bundle;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(22)
class f {
    public static Bundle a(Object r0) {
        return ((PlaybackState) r0).getExtras();
    }
}

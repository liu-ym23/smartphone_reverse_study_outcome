package android.support.v4.media;

import android.media.browse.MediaBrowser;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Constructor;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
class ParceledListSliceAdapterApi21 {
    private static Constructor sConstructor;

    static {
        sConstructor = Class.forName("android.content.pm.ParceledListSlice").getConstructor(new Class[]{List.class});     // Catch: Throwable -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    private ParceledListSliceAdapterApi21() {
    }

    public static Object newInstance(List<MediaBrowser.MediaItem> r1) {
        return sConstructor.newInstance(new Object[]{r1});
    L4:
        e = move-exception;
        e.printStackTrace();
        return null;
    }
}

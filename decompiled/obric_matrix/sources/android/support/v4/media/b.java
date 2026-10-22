package android.support.v4.media;

import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(26)
class b {

    interface a extends android.support.v4.media.a.d {
        void a(@NonNull String r1, @NonNull Bundle r2);

        void b(@NonNull String r1, List<?> r2, @NonNull Bundle r3);
    }

    /* JADX INFO: renamed from: android.support.v4.media.b$b, reason: collision with other inner class name */
    static class C0008b<T extends a> extends android.support.v4.media.a.e<T> {
        C0008b(T r1) {
            super(r1);
        }

        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onChildrenLoaded(@NonNull String r1, List<MediaBrowser.MediaItem> r2, @NonNull Bundle r3) {
            MediaSessionCompat.a(r3);
            ((a) this.f175a).b(r1, r2, r3);
        }

        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onError(@NonNull String r1, @NonNull Bundle r2) {
            MediaSessionCompat.a(r2);
            ((a) this.f175a).a(r1, r2);
        }
    }

    static Object a(a r1) {
        return new C0008b(r1);
    }
}

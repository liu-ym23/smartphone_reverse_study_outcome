package androidx.media;

import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Parcel;
import android.service.media.MediaBrowserService;

/* JADX INFO: loaded from: classes.dex */
class MediaBrowserServiceCompatApi23 {

    static class MediaBrowserServiceAdaptor extends MediaBrowserServiceCompatApi21.MediaBrowserServiceAdaptor {
        MediaBrowserServiceAdaptor(Context r1, ServiceCompatProxy r2) {
            super(r1, r2);
        }

        @Override // android.service.media.MediaBrowserService
        public void onLoadItem(String r2, MediaBrowserService.Result<MediaBrowser.MediaItem> r3) {
            ((ServiceCompatProxy) this.mServiceProxy).onLoadItem(r2, new MediaBrowserServiceCompatApi21.ResultWrapper(r3));
        }
    }

    public interface ServiceCompatProxy extends MediaBrowserServiceCompatApi21.ServiceCompatProxy {
        void onLoadItem(String r1, MediaBrowserServiceCompatApi21.ResultWrapper<Parcel> r2);
    }

    public static Object createService(Context r1, ServiceCompatProxy r2) {
        return new MediaBrowserServiceAdaptor(r1, r2);
    }

    private MediaBrowserServiceCompatApi23() {
    }
}

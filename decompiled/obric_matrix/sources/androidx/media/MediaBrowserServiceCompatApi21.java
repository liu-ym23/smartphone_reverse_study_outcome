package androidx.media;

import android.content.Context;
import android.content.Intent;
import android.media.browse.MediaBrowser;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
class MediaBrowserServiceCompatApi21 {

    static class BrowserRoot {
        final Bundle mExtras;
        final String mRootId;

        BrowserRoot(String r1, Bundle r2) {
            this.mRootId = r1;
            this.mExtras = r2;
        }
    }

    static class MediaBrowserServiceAdaptor extends MediaBrowserService {
        final ServiceCompatProxy mServiceProxy;

        MediaBrowserServiceAdaptor(Context r1, ServiceCompatProxy r2) {
            attachBaseContext(r1);
            this.mServiceProxy = r2;
        }

        @Override // android.service.media.MediaBrowserService
        public MediaBrowserService.BrowserRoot onGetRoot(String r3, int r4, Bundle r5) {
            MediaSessionCompat.a(r5);
            ServiceCompatProxy r2 = this.mServiceProxy;
            if (r5 != null) goto L5;
            Bundle r1 = null;
        L6:
            BrowserRoot r6 = r2.onGetRoot(r3, r4, r1);
            if (r6 != null) goto L10;
            return null;
        L10:
            return new MediaBrowserService.BrowserRoot(r6.mRootId, r6.mExtras);
        L5:
            r1 = new Bundle(r5);
            goto L6
        }

        @Override // android.service.media.MediaBrowserService
        public void onLoadChildren(String r2, MediaBrowserService.Result<List<MediaBrowser.MediaItem>> r3) {
            this.mServiceProxy.onLoadChildren(r2, new ResultWrapper(r3));
        }
    }

    static class ResultWrapper<T> {
        MediaBrowserService.Result mResultObj;

        ResultWrapper(MediaBrowserService.Result r1) {
            this.mResultObj = r1;
        }

        public void detach() {
            this.mResultObj.detach();
        }

        List<MediaBrowser.MediaItem> parcelListToItemList(List<Parcel> r3) {
            if (r3 != null) goto L5;
            return null;
        L5:
            ArrayList r2 = new ArrayList();
            Iterator<Parcel> r4 = r3.iterator();
        L7:
            if (r4.hasNext() == false) goto L9;
            Parcel r0 = r4.next();
            r0.setDataPosition(0);
            r2.add(MediaBrowser.MediaItem.CREATOR.createFromParcel(r0));
            r0.recycle();
            goto L7
        L9:
            return r2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void sendResult(T r2) {
            if ((r2 instanceof List) == false) goto L6;
            this.mResultObj.sendResult(parcelListToItemList((List) r2));
            return;
        L6:
            if ((r2 instanceof Parcel) == false) goto L8;
            Parcel r3 = (Parcel) r2;
            r3.setDataPosition(0);
            this.mResultObj.sendResult(MediaBrowser.MediaItem.CREATOR.createFromParcel(r3));
            r3.recycle();
            return;
        L8:
            this.mResultObj.sendResult(null);
        }
    }

    public interface ServiceCompatProxy {
        BrowserRoot onGetRoot(String r1, int r2, Bundle r3);

        void onLoadChildren(String r1, ResultWrapper<List<Parcel>> r2);
    }

    private MediaBrowserServiceCompatApi21() {
    }

    public static Object createService(Context r1, ServiceCompatProxy r2) {
        return new MediaBrowserServiceAdaptor(r1, r2);
    }

    public static void notifyChildrenChanged(Object r0, String r1) {
        ((MediaBrowserService) r0).notifyChildrenChanged(r1);
    }

    public static IBinder onBind(Object r0, Intent r1) {
        return ((MediaBrowserService) r0).onBind(r1);
    }

    public static void onCreate(Object r0) {
        ((MediaBrowserService) r0).onCreate();
    }

    public static void setSessionToken(Object r0, Object r1) {
        ((MediaBrowserService) r0).setSessionToken((MediaSession.Token) r1);
    }
}

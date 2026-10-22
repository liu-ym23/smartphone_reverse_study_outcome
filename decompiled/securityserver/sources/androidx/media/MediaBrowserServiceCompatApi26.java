package androidx.media;

import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(26)
class MediaBrowserServiceCompatApi26 {
    private static final String TAG = "MBSCompatApi26";
    static Field sResultFlags;

    public static class MediaBrowserServiceAdaptor extends MediaBrowserServiceCompatApi23.MediaBrowserServiceAdaptor {
        public MediaBrowserServiceAdaptor(Context r1, ServiceCompatProxy r2) {
            super(r1, r2);
        }

        @Override // android.service.media.MediaBrowserService
        public void onLoadChildren(String r2, MediaBrowserService.Result<List<MediaBrowser.MediaItem>> r3, Bundle r4) {
            MediaSessionCompat.ensureClassLoader(r4);
            ((ServiceCompatProxy) this.mServiceProxy).onLoadChildren(r2, new ResultWrapper(r3), r4);
        }
    }

    public static class ResultWrapper {
        MediaBrowserService.Result mResultObj;

        public ResultWrapper(MediaBrowserService.Result r1) {
            this.mResultObj = r1;
        }

        public void detach() {
            this.mResultObj.detach();
        }

        public List<MediaBrowser.MediaItem> parcelListToItemList(List<Parcel> r3) {
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

        public void sendResult(List<Parcel> r3, int r4) {
            MediaBrowserServiceCompatApi26.sResultFlags.setInt(this.mResultObj, r4);     // Catch: IllegalAccessException -> L4
        L6:
            this.mResultObj.sendResult(parcelListToItemList(r3));
            return;
        L4:
            e = move-exception;
            Log.w(MediaBrowserServiceCompatApi26.TAG, e);
            goto L6
        }
    }

    public interface ServiceCompatProxy extends MediaBrowserServiceCompatApi23.ServiceCompatProxy {
        void onLoadChildren(String r1, ResultWrapper r2, Bundle r3);
    }

    static {
        Field r0 = MediaBrowserService.Result.class.getDeclaredField("mFlags");     // Catch: NoSuchFieldException -> L4
        sResultFlags = r0;     // Catch: NoSuchFieldException -> L4
        r0.setAccessible(true);     // Catch: NoSuchFieldException -> L4
        return;
    L4:
        e = move-exception;
        Log.w(TAG, e);
    }

    private MediaBrowserServiceCompatApi26() {
    }

    public static Object createService(Context r1, ServiceCompatProxy r2) {
        return new MediaBrowserServiceAdaptor(r1, r2);
    }

    public static Bundle getBrowserRootHints(Object r0) {
        return ((MediaBrowserService) r0).getBrowserRootHints();
    }

    public static void notifyChildrenChanged(Object r0, String r1, Bundle r2) {
        ((MediaBrowserService) r0).notifyChildrenChanged(r1, r2);
    }
}

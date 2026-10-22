package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(21)
class a {

    /* JADX INFO: renamed from: android.support.v4.media.a$a, reason: collision with other inner class name */
    interface InterfaceC0007a {
        void a();

        void b();

        void c();
    }

    static class b<T extends InterfaceC0007a> extends MediaBrowser.ConnectionCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final T f174a;

        public b(T r1) {
            this.f174a = r1;
        }

        @Override // android.media.browse.MediaBrowser.ConnectionCallback
        public void onConnected() {
            this.f174a.b();
        }

        @Override // android.media.browse.MediaBrowser.ConnectionCallback
        public void onConnectionFailed() {
            this.f174a.c();
        }

        @Override // android.media.browse.MediaBrowser.ConnectionCallback
        public void onConnectionSuspended() {
            this.f174a.a();
        }
    }

    static class c {
        public static Object a(Object r0) {
            return ((MediaBrowser.MediaItem) r0).getDescription();
        }

        public static int b(Object r0) {
            return ((MediaBrowser.MediaItem) r0).getFlags();
        }
    }

    interface d {
        void c(@NonNull String r1, List<?> r2);

        void onError(@NonNull String r1);
    }

    static class e<T extends d> extends MediaBrowser.SubscriptionCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final T f175a;

        public e(T r1) {
            this.f175a = r1;
        }

        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onChildrenLoaded(@NonNull String r1, List<MediaBrowser.MediaItem> r2) {
            this.f175a.c(r1, r2);
        }

        @Override // android.media.browse.MediaBrowser.SubscriptionCallback
        public void onError(@NonNull String r1) {
            this.f175a.onError(r1);
        }
    }

    public static void a(Object r0) {
        ((MediaBrowser) r0).connect();
    }

    public static Object b(Context r1, ComponentName r2, Object r3, Bundle r4) {
        return new MediaBrowser(r1, r2, (MediaBrowser.ConnectionCallback) r3, r4);
    }

    public static Object c(InterfaceC0007a r1) {
        return new b(r1);
    }

    public static Object d(d r1) {
        return new e(r1);
    }

    public static void e(Object r0) {
        ((MediaBrowser) r0).disconnect();
    }

    public static Bundle f(Object r0) {
        return ((MediaBrowser) r0).getExtras();
    }

    public static Object g(Object r0) {
        return ((MediaBrowser) r0).getSessionToken();
    }
}

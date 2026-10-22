package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.collection.ArrayMap;
import androidx.core.app.BundleCompat;
import androidx.media.MediaBrowserCompatUtils;
import androidx.media.MediaBrowserProtocol;
import androidx.media.MediaBrowserServiceCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class MediaBrowserCompat {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final boolean f102b = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final e f103a;

    private static class CustomActionResultReceiver extends ResultReceiver {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final String f104i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final Bundle f105j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final c f106k;

        @Override // android.support.v4.os.ResultReceiver
        protected void b(int r3, Bundle r4) {
            if (this.f106k != null) goto L5;
            return;
        L5:
            MediaSessionCompat.a(r4);
            if (r3 == (-1)) goto L13;
            if (r3 != 0) goto L9;
            this.f106k.c(this.f104i, this.f105j, r4);
            return;
        L9:
            if (r3 == 1) goto L11;
            Log.w("MediaBrowserCompat", "Unknown result code: " + r3 + " (extras=" + this.f105j + ", resultData=" + r4 + ")");
            return;
        L11:
            this.f106k.b(this.f104i, this.f105j, r4);
            return;
        L13:
            this.f106k.a(this.f104i, this.f105j, r4);
        }
    }

    private static class ItemReceiver extends ResultReceiver {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final String f107i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final d f108j;

        @Override // android.support.v4.os.ResultReceiver
        protected void b(int r2, Bundle r3) {
            MediaSessionCompat.a(r3);
            if (r2 != 0) goto L16;
            if (r3 == null) goto L16;
            if (r3.containsKey(MediaBrowserServiceCompat.KEY_MEDIA_ITEM) == false) goto L16;
            Parcelable r4 = r3.getParcelable(MediaBrowserServiceCompat.KEY_MEDIA_ITEM);
            if (r4 != null) goto L11;
        L14:
            this.f108j.b((MediaItem) r4);
            return;
        L11:
            if ((r4 instanceof MediaItem) == true) goto L14;
            this.f108j.a(this.f107i);
            return;
        L16:
            this.f108j.a(this.f107i);
        }
    }

    public static class MediaItem implements Parcelable {
        public static final Parcelable.Creator<MediaItem> CREATOR = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f109f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final MediaDescriptionCompat f110g;

        static class a implements Parcelable.Creator<MediaItem> {
            a() {
            }

            public MediaItem a(Parcel r1) {
                return new MediaItem(r1);
            }

            public MediaItem[] b(int r1) {
                return new MediaItem[r1];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ MediaItem createFromParcel(Parcel r1) {
                return a(r1);
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ MediaItem[] newArray(int r1) {
                return b(r1);
            }
        }

        static {
            CREATOR = new a();
        }

        MediaItem(Parcel r2) {
            this.f109f = r2.readInt();
            this.f110g = MediaDescriptionCompat.CREATOR.createFromParcel(r2);
        }

        public MediaItem(@NonNull MediaDescriptionCompat r2, int r3) {
            if (r2 == null) goto L11;
            if (TextUtils.isEmpty(r2.e()) == true) goto L9;
            this.f109f = r3;
            this.f110g = r2;
            return;
        L9:
            throw new IllegalArgumentException("description must have a non-empty media id");
        L11:
            throw new IllegalArgumentException("description cannot be null");
        }

        public static MediaItem b(Object r2) {
            if (r2 != null) goto L4;
            return null;
        L4:
            if (Build.VERSION.SDK_INT < 21) goto L10;
            int r0 = android.support.v4.media.a.c.b(r2);
            return new MediaItem(MediaDescriptionCompat.b(android.support.v4.media.a.c.a(r2)), r0);
        L10:
            return null;
        }

        public static List<MediaItem> d(List<?> r2) {
            if (r2 != null) goto L4;
            return null;
        L4:
            if (Build.VERSION.SDK_INT < 21) goto L14;
            ArrayList r0 = new ArrayList(r2.size());
            Iterator<?> r3 = r2.iterator();
        L8:
            if (r3.hasNext() == false) goto L10;
            r0.add(b(r3.next()));
            goto L8
        L10:
            return r0;
        L14:
            return null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "MediaItem{mFlags=" + this.f109f + ", mDescription=" + this.f110g + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r2, int r3) {
            r2.writeInt(this.f109f);
            this.f110g.writeToParcel(r2, r3);
        }
    }

    private static class SearchResultReceiver extends ResultReceiver {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final String f111i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final Bundle f112j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final k f113k;

        @Override // android.support.v4.os.ResultReceiver
        protected void b(int r4, Bundle r5) {
            MediaSessionCompat.a(r5);
            if (r4 != 0) goto L15;
            if (r5 == null) goto L15;
            if (r5.containsKey(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS) == false) goto L15;
            Parcelable[] r6 = r5.getParcelableArray(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS);
            ArrayList r7 = null;
            if (r6 == null) goto L13;
            r7 = new ArrayList();
            int r0 = r6.length;
            int r1 = 0;
        L11:
            if (r1 >= r0) goto L13;
            r7.add((MediaItem) r6[r1]);
            r1 = r1 + 1;
        L13:
            this.f113k.b(this.f111i, this.f112j, r7);
            return;
        L15:
            this.f113k.a(this.f111i, this.f112j);
        }
    }

    private static class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference<j> f114a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private WeakReference<Messenger> f115b;

        a(j r2) {
            this.f114a = new WeakReference(r2);
        }

        void a(Messenger r2) {
            this.f115b = new WeakReference(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r11) {
            WeakReference<Messenger> r1 = this.f115b;
            if (r1 != null) goto L5;
            return;
        L5:
            if (r1.get() != null) goto L7;
            return;
        L7:
            if (this.f114a.get() == null) goto L33;
            Bundle r2 = r11.getData();
            MediaSessionCompat.a(r2);
            j r3 = this.f114a.get();
            Messenger r10 = this.f115b.get();
            int r4 = r11.what;     // Catch: BadParcelableException -> L22
            if (r4 != 1) goto L14;
            Bundle r5 = r2.getBundle(MediaBrowserProtocol.DATA_ROOT_HINTS);     // Catch: BadParcelableException -> L22
            MediaSessionCompat.a(r5);     // Catch: BadParcelableException -> L22
            r3.e(r10, r2.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), (MediaSessionCompat.Token) r2.getParcelable(MediaBrowserProtocol.DATA_MEDIA_SESSION_TOKEN), r5);     // Catch: BadParcelableException -> L22
        L26:
            return;
        L14:
            if (r4 != 2) goto L16;
            r3.i(r10);     // Catch: BadParcelableException -> L22
            goto L26
        L16:
            if (r4 == 3) goto L18;
            Log.w("MediaBrowserCompat", "Unhandled message: " + r11 + "\n  Client version: 1\n  Service version: " + r11.arg1);     // Catch: BadParcelableException -> L22
            goto L26
        L18:
            Bundle r7 = r2.getBundle(MediaBrowserProtocol.DATA_OPTIONS);     // Catch: BadParcelableException -> L22
            MediaSessionCompat.a(r7);     // Catch: BadParcelableException -> L22
            Bundle r8 = r2.getBundle(MediaBrowserProtocol.DATA_NOTIFY_CHILDREN_CHANGED_OPTIONS);     // Catch: BadParcelableException -> L22
            MediaSessionCompat.a(r8);     // Catch: BadParcelableException -> L22
            r3.f(r10, r2.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), r2.getParcelableArrayList(MediaBrowserProtocol.DATA_MEDIA_ITEM_LIST), r7, r8);     // Catch: BadParcelableException -> L22
        L22:
            Log.e("MediaBrowserCompat", "Could not unparcel the data.");
            if (r11.what != 1) goto L32;
            r3.i(r10);
            return;
        L32:
            return;
        }
    }

    public static class b {
        a mConnectionCallbackInternal;
        final Object mConnectionCallbackObj;

        interface a {
            void a();

            void b();

            void c();
        }

        /* JADX INFO: renamed from: android.support.v4.media.MediaBrowserCompat$b$b, reason: collision with other inner class name */
        private class C0006b implements android.support.v4.media.a.InterfaceC0007a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ b f116a;

            C0006b(b r1) {
                this.f116a = r1;
            }

            @Override // android.support.v4.media.a.InterfaceC0007a
            public void a() {
                a r0 = this.f116a.mConnectionCallbackInternal;
                if (r0 == null) goto L5;
                r0.a();
            L5:
                this.f116a.onConnectionSuspended();
            }

            @Override // android.support.v4.media.a.InterfaceC0007a
            public void b() {
                a r0 = this.f116a.mConnectionCallbackInternal;
                if (r0 == null) goto L5;
                r0.b();
            L5:
                this.f116a.onConnected();
            }

            @Override // android.support.v4.media.a.InterfaceC0007a
            public void c() {
                a r0 = this.f116a.mConnectionCallbackInternal;
                if (r0 == null) goto L5;
                r0.c();
            L5:
                this.f116a.onConnectionFailed();
            }
        }

        public b() {
            if (Build.VERSION.SDK_INT < 21) goto L5;
            Object r0 = android.support.v4.media.a.c(new C0006b(this));
        L6:
            this.mConnectionCallbackObj = r0;
            return;
        L5:
            r0 = null;
            goto L6
        }

        public void onConnected() {
            throw null;
        }

        public void onConnectionFailed() {
            throw null;
        }

        public void onConnectionSuspended() {
            throw null;
        }

        void setInternalConnectionCallback(a r1) {
            this.mConnectionCallbackInternal = r1;
        }
    }

    public static abstract class c {
        public abstract void a(String r1, Bundle r2, Bundle r3);

        public abstract void b(String r1, Bundle r2, Bundle r3);

        public abstract void c(String r1, Bundle r2, Bundle r3);
    }

    public static abstract class d {
        public abstract void a(@NonNull String r1);

        public abstract void b(MediaItem r1);
    }

    interface e {
        @NonNull
        MediaSessionCompat.Token d();

        void g();

        void h();
    }

    @RequiresApi(21)
    static class f implements e, j, b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Context f117a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected final Object f118b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        protected final Bundle f119c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        protected final a f120d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final ArrayMap<String, m> f121e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        protected l f122f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        protected Messenger f123g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private MediaSessionCompat.Token f124h;

        f(Context r3, ComponentName r4, b r5, Bundle r6) {
            this.f120d = new a(this);
            this.f121e = new ArrayMap();
            this.f117a = r3;
            if (r6 == null) goto L5;
            Bundle r0 = new Bundle(r6);
        L6:
            this.f119c = r0;
            r0.putInt(MediaBrowserProtocol.EXTRA_CLIENT_VERSION, 1);
            r5.setInternalConnectionCallback(this);
            this.f118b = android.support.v4.media.a.b(r3, r4, r5.mConnectionCallbackObj, r0);
            return;
        L5:
            r0 = new Bundle();
            goto L6
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b.a
        public void a() {
            this.f122f = null;
            this.f123g = null;
            this.f124h = null;
            this.f120d.a(null);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b.a
        public void b() {
            Bundle r0 = android.support.v4.media.a.f(this.f118b);
            if (r0 != null) goto L5;
            return;
        L5:
            r0.getInt(MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 0);
            IBinder r1 = BundleCompat.getBinder(r0, MediaBrowserProtocol.EXTRA_MESSENGER_BINDER);
            if (r1 == null) goto L11;
            this.f122f = new l(r1, this.f119c);
            Messenger r2 = new Messenger(this.f120d);
            this.f123g = r2;
            this.f120d.a(r2);
            this.f122f.d(this.f117a, this.f123g);     // Catch: RemoteException -> L10
        L10:
            Log.i("MediaBrowserCompat", "Remote error registering client messenger.");
        L11:
            android.support.v4.media.session.b r3 = android.support.v4.media.session.b.a.a(BundleCompat.getBinder(r0, MediaBrowserProtocol.EXTRA_SESSION_BINDER));
            if (r3 == null) goto L17;
            this.f124h = MediaSessionCompat.Token.d(android.support.v4.media.a.g(this.f118b), r3);
            return;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.b.a
        public void c() {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        @NonNull
        public MediaSessionCompat.Token d() {
            if (this.f124h != null) goto L6;
            this.f124h = MediaSessionCompat.Token.b(android.support.v4.media.a.g(this.f118b));
        L6:
            return this.f124h;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.j
        public void e(Messenger r1, String r2, MediaSessionCompat.Token r3, Bundle r4) {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.j
        public void f(Messenger r1, String r2, List r3, Bundle r4, Bundle r5) {
            if (this.f123g == r1) goto L5;
            return;
        L5:
            m r0 = this.f121e.get(r2);
            if (r0 == null) goto L8;
            n r6 = r0.a(r4);
            if (r6 == null) goto L22;
            if (r4 != null) goto L17;
            if (r3 != null) goto L16;
            r6.c(r2);
            return;
        L16:
            r6.a(r2, r3);
            return;
        L17:
            if (r3 != null) goto L19;
            r6.d(r2, r4);
            return;
        L19:
            r6.b(r2, r3, r4);
            return;
        L22:
            return;
        L8:
            if (MediaBrowserCompat.f102b == false) goto L21;
            Log.d("MediaBrowserCompat", "onLoadChildren for id that isn't subscribed id=" + r2);
            return;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        public void g() {
            l r0 = this.f122f;
            if (r0 == null) goto L9;
            Messenger r1 = this.f123g;
            if (r1 == null) goto L9;
            r0.f(r1);     // Catch: RemoteException -> L8
        L8:
            Log.i("MediaBrowserCompat", "Remote error unregistering client messenger.");
        L9:
            android.support.v4.media.a.e(this.f118b);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        public void h() {
            android.support.v4.media.a.a(this.f118b);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.j
        public void i(Messenger r1) {
        }
    }

    @RequiresApi(23)
    static class g extends f {
        g(Context r1, ComponentName r2, b r3, Bundle r4) {
            super(r1, r2, r3, r4);
        }
    }

    @RequiresApi(26)
    static class h extends g {
        h(Context r1, ComponentName r2, b r3, Bundle r4) {
            super(r1, r2, r3, r4);
        }
    }

    static class i implements e, j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Context f125a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ComponentName f126b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final b f127c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Bundle f128d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final a f129e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final ArrayMap<String, m> f130f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f131g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        c f132h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        l f133i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Messenger f134j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private String f135k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private MediaSessionCompat.Token f136l;

        class a implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ i f137f;

            a(i r1) {
                this.f137f = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                i r1 = this.f137f;
                if (r1.f131g != 0) goto L5;
                return;
            L5:
                r1.f131g = 2;
                if (MediaBrowserCompat.f102b == false) goto L13;
                if (r1.f132h == null) goto L13;
                throw new RuntimeException("mServiceConnection should be null. Instead it is " + this.f137f.f132h);
            L13:
                if (r1.f133i != null) goto L29;
                if (r1.f134j != null) goto L27;
                Intent r2 = new Intent(MediaBrowserServiceCompat.SERVICE_INTERFACE);
                r2.setComponent(this.f137f.f126b);
                i r3 = this.f137f;
                c r4 = new c(r3);
                r3.f132h = r4;
                boolean r5 = false;
                r5 = r3.f125a.bindService(r2, r4, 1);     // Catch: Exception -> L19
            L20:
                if (r5 == true) goto L23;
                this.f137f.b();
                this.f137f.f127c.onConnectionFailed();
            L23:
                if (MediaBrowserCompat.f102b == false) goto L32;
                Log.d("MediaBrowserCompat", "connect...");
                this.f137f.a();
                return;
            L32:
                return;
            L19:
                Log.e("MediaBrowserCompat", "Failed binding to service " + this.f137f.f126b);
                goto L20
            L27:
                throw new RuntimeException("mCallbacksMessenger should be null. Instead it is " + this.f137f.f134j);
            L29:
                throw new RuntimeException("mServiceBinderWrapper should be null. Instead it is " + this.f137f.f133i);
            }
        }

        class b implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ i f138f;

            b(i r1) {
                this.f138f = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                i r0 = this.f138f;
                Messenger r1 = r0.f134j;
                if (r1 != null) goto L14;
            L7:
                i r2 = this.f138f;
                int r3 = r2.f131g;
                r2.b();
                if (r3 == 0) goto L11;
                this.f138f.f131g = r3;
            L11:
                if (MediaBrowserCompat.f102b == false) goto L16;
                Log.d("MediaBrowserCompat", "disconnect...");
                this.f138f.a();
                return;
            L16:
                return;
            L14:
                r0.f133i.c(r1);     // Catch: RemoteException -> L6
            L6:
                Log.w("MediaBrowserCompat", "RemoteException during connect for " + this.f138f.f126b);
                goto L7
            }
        }

        private class c implements ServiceConnection {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ i f139f;

            class a implements Runnable {

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                final /* synthetic */ ComponentName f140f;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                final /* synthetic */ IBinder f141g;

                /* JADX INFO: renamed from: h, reason: collision with root package name */
                final /* synthetic */ c f142h;

                a(c r1, ComponentName r2, IBinder r3) {
                    this.f142h = r1;
                    this.f140f = r2;
                    this.f141g = r3;
                }

                @Override // java.lang.Runnable
                public void run() {
                    boolean r0 = MediaBrowserCompat.f102b;
                    if (r0 == false) goto L6;
                    Log.d("MediaBrowserCompat", "MediaServiceConnection.onServiceConnected name=" + this.f140f + " binder=" + this.f141g);
                    this.f142h.f139f.a();
                L6:
                    if (this.f142h.a("onServiceConnected") == true) goto L8;
                    return;
                L8:
                    i r2 = this.f142h.f139f;
                    r2.f133i = new l(this.f141g, r2.f128d);
                    this.f142h.f139f.f134j = new Messenger(this.f142h.f139f.f129e);
                    i r3 = this.f142h.f139f;
                    r3.f129e.a(r3.f134j);
                    this.f142h.f139f.f131g = 2;
                    if (r0 == true) goto L17;
                L11:
                    i r1 = this.f142h.f139f;     // Catch: RemoteException -> L13
                    r1.f133i.b(r1.f125a, r1.f134j);     // Catch: RemoteException -> L13
                    return;
                L13:
                    Log.w("MediaBrowserCompat", "RemoteException during connect for " + this.f142h.f139f.f126b);
                    if (MediaBrowserCompat.f102b == false) goto L19;
                    Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
                    this.f142h.f139f.a();
                    return;
                L19:
                    return;
                L17:
                    Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");     // Catch: RemoteException -> L13
                    this.f142h.f139f.a();     // Catch: RemoteException -> L13
                    goto L11
                }
            }

            class b implements Runnable {

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                final /* synthetic */ ComponentName f143f;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                final /* synthetic */ c f144g;

                b(c r1, ComponentName r2) {
                    this.f144g = r1;
                    this.f143f = r2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (MediaBrowserCompat.f102b == false) goto L6;
                    Log.d("MediaBrowserCompat", "MediaServiceConnection.onServiceDisconnected name=" + this.f143f + " this=" + this + " mServiceConnection=" + this.f144g.f139f.f132h);
                    this.f144g.f139f.a();
                L6:
                    if (this.f144g.a("onServiceDisconnected") == true) goto L8;
                    return;
                L8:
                    i r0 = this.f144g.f139f;
                    r0.f133i = null;
                    r0.f134j = null;
                    r0.f129e.a(null);
                    i r2 = this.f144g.f139f;
                    r2.f131g = 4;
                    r2.f127c.onConnectionSuspended();
                }
            }

            c(i r1) {
                this.f139f = r1;
            }

            private void b(Runnable r3) {
                if (Thread.currentThread() != this.f139f.f129e.getLooper().getThread()) goto L5;
                r3.run();
                return;
            L5:
                this.f139f.f129e.post(r3);
            }

            boolean a(String r4) {
                i r0 = this.f139f;
                if (r0.f132h != this) goto L9;
                int r1 = r0.f131g;
                if (r1 == 0) goto L9;
                if (r1 == 1) goto L9;
                return true;
            L9:
                int r2 = r0.f131g;
                if (r2 == 0) goto L15;
                if (r2 == 1) goto L16;
                Log.i("MediaBrowserCompat", r4 + " for " + this.f139f.f126b + " with mServiceConnection=" + this.f139f.f132h + " this=" + this);
                return false;
            L16:
                return false;
            L15:
                return false;
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName r2, IBinder r3) {
                b(new a(this, r2, r3));
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName r2) {
                b(new b(this, r2));
            }
        }

        public i(Context r2, ComponentName r3, b r4, Bundle r5) {
            this.f129e = new a(this);
            this.f130f = new ArrayMap();
            this.f131g = 1;
            if (r2 == null) goto L17;
            if (r3 == null) goto L15;
            if (r4 == null) goto L13;
            this.f125a = r2;
            this.f126b = r3;
            this.f127c = r4;
            if (r5 != null) goto L9;
            Bundle r6 = null;
        L10:
            this.f128d = r6;
            return;
        L9:
            r6 = new Bundle(r5);
            goto L10
        L13:
            throw new IllegalArgumentException("connection callback must not be null");
        L15:
            throw new IllegalArgumentException("service component must not be null");
        L17:
            throw new IllegalArgumentException("context must not be null");
        }

        private static String c(int r2) {
            if (r2 != 0) goto L4;
            return "CONNECT_STATE_DISCONNECTING";
        L4:
            if (r2 != 1) goto L6;
            return "CONNECT_STATE_DISCONNECTED";
        L6:
            if (r2 != 2) goto L8;
            return "CONNECT_STATE_CONNECTING";
        L8:
            if (r2 != 3) goto L10;
            return "CONNECT_STATE_CONNECTED";
        L10:
            if (r2 != 4) goto L12;
            return "CONNECT_STATE_SUSPENDED";
        L12:
            return "UNKNOWN/" + r2;
        }

        private boolean k(Messenger r3, String r4) {
            if (this.f134j != r3) goto L9;
            int r5 = this.f131g;
            if (r5 == 0) goto L9;
            if (r5 == 1) goto L9;
            return true;
        L9:
            int r6 = this.f131g;
            if (r6 == 0) goto L15;
            if (r6 == 1) goto L16;
            Log.i("MediaBrowserCompat", r4 + " for " + this.f126b + " with mCallbacksMessenger=" + this.f134j + " this=" + this);
            return false;
        L16:
            return false;
        L15:
            return false;
        }

        void a() {
            Log.d("MediaBrowserCompat", "MediaBrowserCompat...");
            Log.d("MediaBrowserCompat", "  mServiceComponent=" + this.f126b);
            Log.d("MediaBrowserCompat", "  mCallback=" + this.f127c);
            Log.d("MediaBrowserCompat", "  mRootHints=" + this.f128d);
            Log.d("MediaBrowserCompat", "  mState=" + c(this.f131g));
            Log.d("MediaBrowserCompat", "  mServiceConnection=" + this.f132h);
            Log.d("MediaBrowserCompat", "  mServiceBinderWrapper=" + this.f133i);
            Log.d("MediaBrowserCompat", "  mCallbacksMessenger=" + this.f134j);
            Log.d("MediaBrowserCompat", "  mRootId=" + this.f135k);
            Log.d("MediaBrowserCompat", "  mMediaSessionToken=" + this.f136l);
        }

        void b() {
            c r0 = this.f132h;
            if (r0 == null) goto L5;
            this.f125a.unbindService(r0);
        L5:
            this.f131g = 1;
            this.f132h = null;
            this.f133i = null;
            this.f134j = null;
            this.f129e.a(null);
            this.f135k = null;
            this.f136l = null;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        @NonNull
        public MediaSessionCompat.Token d() {
            if (j() == false) goto L7;
            return this.f136l;
        L7:
            throw new IllegalStateException("getSessionToken() called while not connected(state=" + this.f131g + ")");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.j
        public void e(Messenger r7, String r8, MediaSessionCompat.Token r9, Bundle r10) {
            if (k(r7, "onConnect") == true) goto L6;
            return;
        L6:
            if (this.f131g == 2) goto L9;
            Log.w("MediaBrowserCompat", "onConnect from service while mState=" + c(this.f131g) + "... ignoring");
            return;
        L9:
            this.f135k = r8;
            this.f136l = r9;
            this.f131g = 3;
            if (MediaBrowserCompat.f102b == false) goto L12;
            Log.d("MediaBrowserCompat", "ServiceCallbacks.onConnect...");
            a();
        L12:
            this.f127c.onConnected();
            Iterator<Map.Entry<String, m>> r11 = this.f130f.entrySet().iterator();     // Catch: RemoteException -> L21
        L15:
            if (r11.hasNext() == false) goto L27;
            Map.Entry<String, m> r12 = r11.next();     // Catch: RemoteException -> L21
            String r13 = r12.getKey();     // Catch: RemoteException -> L21
            m r14 = r12.getValue();     // Catch: RemoteException -> L21
            List<n> r15 = r14.b();     // Catch: RemoteException -> L21
            List<Bundle> r16 = r14.c();     // Catch: RemoteException -> L21
            int r1 = 0;
        L18:
            if (r1 >= r15.size()) goto L15;
            this.f133i.a(r13, r15.get(r1).f150b, r16.get(r1), this.f134j);     // Catch: RemoteException -> L21
            r1 = r1 + 1;
            goto L18
        L27:
            return;
        L21:
            Log.d("MediaBrowserCompat", "addSubscription failed with RemoteException.");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.j
        public void f(Messenger r3, String r4, List r5, Bundle r6, Bundle r7) {
            if (k(r3, "onLoadChildren") == true) goto L5;
            return;
        L5:
            boolean r8 = MediaBrowserCompat.f102b;
            if (r8 == false) goto L8;
            Log.d("MediaBrowserCompat", "onLoadChildren for " + this.f126b + " id=" + r4);
        L8:
            m r2 = this.f130f.get(r4);
            if (r2 != null) goto L13;
            if (r8 == false) goto L23;
            Log.d("MediaBrowserCompat", "onLoadChildren for id that isn't subscribed id=" + r4);
            return;
        L23:
            return;
        L13:
            n r9 = r2.a(r6);
            if (r9 == null) goto L24;
            if (r6 != null) goto L19;
            if (r5 != null) goto L18;
            r9.c(r4);
            return;
        L18:
            r9.a(r4, r5);
            return;
        L19:
            if (r5 != null) goto L21;
            r9.d(r4, r6);
            return;
        L21:
            r9.b(r4, r5, r6);
            return;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        public void g() {
            this.f131g = 0;
            this.f129e.post(new b(this));
        }

        @Override // android.support.v4.media.MediaBrowserCompat.e
        public void h() {
            int r0 = this.f131g;
            if (r0 != 0) goto L5;
        L9:
            this.f131g = 2;
            this.f129e.post(new a(this));
            return;
        L5:
            if (r0 == 1) goto L9;
            throw new IllegalStateException("connect() called while neigther disconnecting nor disconnected (state=" + c(this.f131g) + ")");
        }

        @Override // android.support.v4.media.MediaBrowserCompat.j
        public void i(Messenger r3) {
            Log.e("MediaBrowserCompat", "onConnectFailed for " + this.f126b);
            if (k(r3, "onConnectFailed") == true) goto L6;
            return;
        L6:
            if (this.f131g == 2) goto L9;
            Log.w("MediaBrowserCompat", "onConnect from service while mState=" + c(this.f131g) + "... ignoring");
            return;
        L9:
            b();
            this.f127c.onConnectionFailed();
        }

        public boolean j() {
            if (this.f131g != 3) goto L5;
            return true;
        L5:
            return false;
        }
    }

    interface j {
        void e(Messenger r1, String r2, MediaSessionCompat.Token r3, Bundle r4);

        void f(Messenger r1, String r2, List r3, Bundle r4, Bundle r5);

        void i(Messenger r1);
    }

    public static abstract class k {
        public abstract void a(@NonNull String r1, Bundle r2);

        public abstract void b(@NonNull String r1, Bundle r2, @NonNull List<MediaItem> r3);
    }

    private static class l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Messenger f145a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Bundle f146b;

        public l(IBinder r2, Bundle r3) {
            this.f145a = new Messenger(r2);
            this.f146b = r3;
        }

        private void e(int r2, Bundle r3, Messenger r4) {
            Message r0 = Message.obtain();
            r0.what = r2;
            r0.arg1 = 1;
            r0.setData(r3);
            r0.replyTo = r4;
            this.f145a.send(r0);
        }

        void a(String r3, IBinder r4, Bundle r5, Messenger r6) {
            Bundle r0 = new Bundle();
            r0.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, r3);
            BundleCompat.putBinder(r0, MediaBrowserProtocol.DATA_CALLBACK_TOKEN, r4);
            r0.putBundle(MediaBrowserProtocol.DATA_OPTIONS, r5);
            e(3, r0, r6);
        }

        void b(Context r3, Messenger r4) {
            Bundle r0 = new Bundle();
            r0.putString(MediaBrowserProtocol.DATA_PACKAGE_NAME, r3.getPackageName());
            r0.putBundle(MediaBrowserProtocol.DATA_ROOT_HINTS, this.f146b);
            e(1, r0, r4);
        }

        void c(Messenger r3) {
            e(2, null, r3);
        }

        void d(Context r3, Messenger r4) {
            Bundle r0 = new Bundle();
            r0.putString(MediaBrowserProtocol.DATA_PACKAGE_NAME, r3.getPackageName());
            r0.putBundle(MediaBrowserProtocol.DATA_ROOT_HINTS, this.f146b);
            e(6, r0, r4);
        }

        void f(Messenger r3) {
            e(7, null, r3);
        }
    }

    private static class m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List<n> f147a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List<Bundle> f148b;

        public m() {
            this.f147a = new ArrayList();
            this.f148b = new ArrayList();
        }

        public n a(Bundle r3) {
            int r0 = 0;
        L4:
            if (r0 >= this.f148b.size()) goto L10;
            if (MediaBrowserCompatUtils.areSameOptions(this.f148b.get(r0), r3) == true) goto L8;
            r0 = r0 + 1;
            goto L4
        L8:
            return this.f147a.get(r0);
        L10:
            return null;
        }

        public List<n> b() {
            return this.f147a;
        }

        public List<Bundle> c() {
            return this.f148b;
        }
    }

    public static abstract class n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f149a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final IBinder f150b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        WeakReference<m> f151c;

        private class a implements android.support.v4.media.a.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ n f152a;

            a(n r1) {
                this.f152a = r1;
            }

            @Override // android.support.v4.media.a.d
            public void c(@NonNull String r7, List<?> r8) {
                WeakReference<m> r0 = this.f152a.f151c;
                if (r0 != null) goto L5;
                m r1 = null;
            L6:
                if (r1 != null) goto L8;
                this.f152a.a(r7, MediaItem.d(r8));
                return;
            L8:
                List<MediaItem> r9 = MediaItem.d(r8);
                List<n> r2 = r1.b();
                List<Bundle> r3 = r1.c();
                int r4 = 0;
            L10:
                if (r4 >= r2.size()) goto L20;
                Bundle r5 = r3.get(r4);
                if (r5 != null) goto L14;
                this.f152a.a(r7, r9);
            L15:
                r4 = r4 + 1;
                goto L10
            L14:
                this.f152a.b(r7, d(r9, r5), r5);
                goto L15
            L20:
                return;
            L5:
                r1 = r0.get();
                goto L6
            }

            List<MediaItem> d(List<MediaItem> r3, Bundle r4) {
                if (r3 != null) goto L5;
                return null;
            L5:
                int r2 = r4.getInt("android.media.browse.extra.PAGE", -1);
                int r5 = r4.getInt("android.media.browse.extra.PAGE_SIZE", -1);
                if (r2 != (-1)) goto L9;
                if (r5 != (-1)) goto L9;
                return r3;
            L9:
                int r0 = r5 * r2;
                int r1 = r0 + r5;
                if (r2 < 0) goto L22;
                if (r5 < 1) goto L22;
                if (r0 >= r3.size()) goto L22;
                if (r1 <= r3.size()) goto L20;
                r1 = r3.size();
            L20:
                return r3.subList(r0, r1);
            L22:
                return Collections.emptyList();
            }

            @Override // android.support.v4.media.a.d
            public void onError(@NonNull String r1) {
                this.f152a.c(r1);
            }
        }

        private class b extends a implements android.support.v4.media.b.a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ n f153b;

            b(n r1) {
                this.f153b = r1;
                super(r1);
            }

            @Override // android.support.v4.media.b.a
            public void a(@NonNull String r1, @NonNull Bundle r2) {
                this.f153b.d(r1, r2);
            }

            @Override // android.support.v4.media.b.a
            public void b(@NonNull String r1, List<?> r2, @NonNull Bundle r3) {
                this.f153b.b(r1, MediaItem.d(r2), r3);
            }
        }

        public n() {
            this.f150b = new Binder();
            int r0 = Build.VERSION.SDK_INT;
            if (r0 < 26) goto L7;
            Object r1 = android.support.v4.media.b.a(new b(this));
        L5:
            this.f149a = r1;
            return;
        L7:
            if (r0 < 21) goto L10;
            r1 = android.support.v4.media.a.d(new a(this));
            goto L5
        }

        public void a(@NonNull String r1, @NonNull List<MediaItem> r2) {
        }

        public void b(@NonNull String r1, @NonNull List<MediaItem> r2, @NonNull Bundle r3) {
        }

        public void c(@NonNull String r1) {
        }

        public void d(@NonNull String r1, @NonNull Bundle r2) {
        }
    }

    static {
        f102b = Log.isLoggable("MediaBrowserCompat", 3);
    }

    public MediaBrowserCompat(Context r3, ComponentName r4, b r5, Bundle r6) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 26) goto L7;
        e r1 = new h(r3, r4, r5, r6);
    L5:
        this.f103a = r1;
        return;
    L7:
        if (r0 < 23) goto L10;
        r1 = new g(r3, r4, r5, r6);
        goto L5
    L10:
        if (r0 < 21) goto L12;
        r1 = new f(r3, r4, r5, r6);
        goto L5
    L12:
        r1 = new i(r3, r4, r5, r6);
        goto L5
    }

    public void a() {
        this.f103a.h();
    }

    public void b() {
        this.f103a.g();
    }

    @NonNull
    public MediaSessionCompat.Token c() {
        return this.f103a.d();
    }
}

package android.support.v4.media.session;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaMetadataCompat;
import android.util.Log;
import android.view.KeyEvent;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.app.BundleCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class MediaControllerCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f176a;

    @RequiresApi(21)
    static class MediaControllerImplApi21 implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final Object f177a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Object f178b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @GuardedBy("mLock")
        private final List<a> f179c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private HashMap<a, a> f180d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final MediaSessionCompat.Token f181e;

        private static class ExtraBinderRequestResultReceiver extends ResultReceiver {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private WeakReference<MediaControllerImplApi21> f182f;

            ExtraBinderRequestResultReceiver(MediaControllerImplApi21 r2) {
                super(null);
                this.f182f = new WeakReference(r2);
            }

            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int r3, Bundle r4) {
                MediaControllerImplApi21 r2 = this.f182f.get();
                if (r2 == null) goto L14;
                if (r4 == null) goto L17;
                Object r5 = r2.f178b;
                monitor-enter(r5);
                r2.f181e.g(android.support.v4.media.session.b.a.a(BundleCompat.getBinder(r4, "android.support.v4.media.session.EXTRA_BINDER")));     // Catch: Throwable -> L11
                r2.f181e.h(r4.getBundle("android.support.v4.media.session.SESSION_TOKEN2_BUNDLE"));     // Catch: Throwable -> L11
                r2.b();     // Catch: Throwable -> L11
                monitor-exit(r5);     // Catch: Throwable -> L11
                return;
            L11:
                th = move-exception;
                throw th;
            L17:
                return;
            }
        }

        private static class a extends a.c {
            a(a r1) {
                super(r1);
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.a.c, android.support.v4.media.session.a
            public void L(MediaMetadataCompat r1) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.a.c, android.support.v4.media.session.a
            public void d(Bundle r1) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.a.c, android.support.v4.media.session.a
            public void e(List<MediaSessionCompat.QueueItem> r1) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.a.c, android.support.v4.media.session.a
            public void g(CharSequence r1) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.a.c, android.support.v4.media.session.a
            public void h() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.a.c, android.support.v4.media.session.a
            public void i0(ParcelableVolumeInfo r1) {
                throw new AssertionError();
            }
        }

        public MediaControllerImplApi21(Context r2, MediaSessionCompat.Token r3) {
            this.f178b = new Object();
            this.f179c = new ArrayList();
            this.f180d = new HashMap();
            this.f181e = r3;
            Object r4 = android.support.v4.media.session.c.c(r2, r3.f());
            this.f177a = r4;
            if (r4 == null) goto L9;
            if (r3.e() != null) goto L10;
            c();
            return;
        L10:
            return;
        L9:
            throw new RemoteException();
        }

        private void c() {
            d("android.support.v4.media.session.command.GET_EXTRA_BINDER", null, new ExtraBinderRequestResultReceiver(this));
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public boolean a(KeyEvent r1) {
            return android.support.v4.media.session.c.b(this.f177a, r1);
        }

        @GuardedBy("mLock")
        void b() {
            if (this.f181e.e() != null) goto L5;
            return;
        L5:
            Iterator<a> r0 = this.f179c.iterator();
        L7:
            if (r0.hasNext() == false) goto L13;
            a r1 = r0.next();
            a r2 = new a(r1);
            this.f180d.put(r1, r2);
            r1.f185c = r2;
            this.f181e.e().i(r2);     // Catch: RemoteException -> L11
            r1.i(13, null, null);
        L11:
            e = move-exception;
            Log.e("MediaControllerCompat", "Dead object in registerCallback.", e);
        L13:
            this.f179c.clear();
        }

        public void d(String r1, Bundle r2, ResultReceiver r3) {
            android.support.v4.media.session.c.d(this.f177a, r1, r2, r3);
        }
    }

    public static abstract class a implements IBinder.DeathRecipient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f183a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        HandlerC0009a f184b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        android.support.v4.media.session.a f185c;

        /* JADX INFO: renamed from: android.support.v4.media.session.MediaControllerCompat$a$a, reason: collision with other inner class name */
        private class HandlerC0009a extends Handler {
        }

        private static class b implements android.support.v4.media.session.c.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final WeakReference<a> f186a;

            b(a r2) {
                this.f186a = new WeakReference(r2);
            }

            @Override // android.support.v4.media.session.c.a
            public void a(Object r1) {
                a r0 = this.f186a.get();
                if (r0 == null) goto L6;
                r0.c(MediaMetadataCompat.b(r1));
                return;
            }

            @Override // android.support.v4.media.session.c.a
            public void b(int r8, int r9, int r10, int r11, int r12) {
                a r7 = this.f186a.get();
                if (r7 == null) goto L6;
                r7.a(new f(r8, r9, r10, r11, r12));
                return;
            }

            @Override // android.support.v4.media.session.c.a
            public void c(Object r2) {
                a r1 = this.f186a.get();
                if (r1 != null) goto L5;
                return;
            L5:
                if (r1.f185c != null) goto L10;
                r1.d(PlaybackStateCompat.b(r2));
                return;
            }

            @Override // android.support.v4.media.session.c.a
            public void d(Bundle r1) {
                a r0 = this.f186a.get();
                if (r0 == null) goto L6;
                r0.b(r1);
                return;
            }

            @Override // android.support.v4.media.session.c.a
            public void e(List<?> r1) {
                a r0 = this.f186a.get();
                if (r0 == null) goto L6;
                r0.e(MediaSessionCompat.QueueItem.d(r1));
                return;
            }

            @Override // android.support.v4.media.session.c.a
            public void f(String r3, Bundle r4) {
                a r2 = this.f186a.get();
                if (r2 != null) goto L5;
                return;
            L5:
                if (r2.f185c != null) goto L7;
            L9:
                r2.h(r3, r4);
                return;
            L7:
                if (Build.VERSION.SDK_INT >= 23) goto L9;
            }

            @Override // android.support.v4.media.session.c.a
            public void g(CharSequence r1) {
                a r0 = this.f186a.get();
                if (r0 == null) goto L6;
                r0.f(r1);
                return;
            }

            @Override // android.support.v4.media.session.c.a
            public void h() {
                a r0 = this.f186a.get();
                if (r0 == null) goto L6;
                r0.g();
                return;
            }
        }

        private static class c extends android.support.v4.media.session.a.AbstractBinderC0010a {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final WeakReference<a> f187f;

            c(a r2) {
                this.f187f = new WeakReference(r2);
            }

            @Override // android.support.v4.media.session.a
            public void C(boolean r3) {
                a r2 = this.f187f.get();
                if (r2 == null) goto L6;
                r2.i(11, Boolean.valueOf(r3), null);
                return;
            }

            @Override // android.support.v4.media.session.a
            public void H(boolean r1) {
            }

            public void L(MediaMetadataCompat r3) {
                a r2 = this.f187f.get();
                if (r2 == null) goto L6;
                r2.i(3, r3, null);
                return;
            }

            @Override // android.support.v4.media.session.a
            public void O(int r3) {
                a r2 = this.f187f.get();
                if (r2 == null) goto L6;
                r2.i(9, Integer.valueOf(r3), null);
                return;
            }

            @Override // android.support.v4.media.session.a
            public void U(int r3) {
                a r2 = this.f187f.get();
                if (r2 == null) goto L6;
                r2.i(12, Integer.valueOf(r3), null);
                return;
            }

            public void d(Bundle r3) {
                a r2 = this.f187f.get();
                if (r2 == null) goto L6;
                r2.i(7, r3, null);
                return;
            }

            public void e(List<MediaSessionCompat.QueueItem> r3) {
                a r2 = this.f187f.get();
                if (r2 == null) goto L6;
                r2.i(5, r3, null);
                return;
            }

            @Override // android.support.v4.media.session.a
            public void e0(PlaybackStateCompat r3) {
                a r2 = this.f187f.get();
                if (r2 == null) goto L6;
                r2.i(2, r3, null);
                return;
            }

            public void g(CharSequence r3) {
                a r2 = this.f187f.get();
                if (r2 == null) goto L6;
                r2.i(6, r3, null);
                return;
            }

            @Override // android.support.v4.media.session.a
            public void g0(String r2, Bundle r3) {
                a r1 = this.f187f.get();
                if (r1 == null) goto L6;
                r1.i(1, r2, r3);
                return;
            }

            public void h() {
                a r2 = this.f187f.get();
                if (r2 == null) goto L6;
                r2.i(8, null, null);
                return;
            }

            public void i0(ParcelableVolumeInfo r9) {
                a r8 = this.f187f.get();
                if (r8 != null) goto L5;
                return;
            L5:
                if (r9 == null) goto L7;
                f r7 = new f(r9.f196f, r9.f197g, r9.f198h, r9.f199i, r9.f200j);
            L8:
                r8.i(4, r7, null);
                return;
            L7:
                r7 = null;
                goto L8
            }

            @Override // android.support.v4.media.session.a
            public void p() {
                a r2 = this.f187f.get();
                if (r2 == null) goto L6;
                r2.i(13, null, null);
                return;
            }
        }

        public a() {
            if (Build.VERSION.SDK_INT < 21) goto L5;
            this.f183a = android.support.v4.media.session.c.a(new b(this));
            return;
        L5:
            this.f185c = new c(this);
        }

        public void a(f r1) {
        }

        public void b(Bundle r1) {
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            i(8, null, null);
        }

        public void c(MediaMetadataCompat r1) {
        }

        public void d(PlaybackStateCompat r1) {
        }

        public void e(List<MediaSessionCompat.QueueItem> r1) {
        }

        public void f(CharSequence r1) {
        }

        public void g() {
        }

        public void h(String r1, Bundle r2) {
        }

        void i(int r1, Object r2, Bundle r3) {
            HandlerC0009a r0 = this.f184b;
            if (r0 == null) goto L6;
            Message r4 = r0.obtainMessage(r1, r2);
            r4.setData(r3);
            r4.sendToTarget();
            return;
        }
    }

    interface b {
        boolean a(KeyEvent r1);
    }

    @RequiresApi(23)
    static class c extends MediaControllerImplApi21 {
        public c(Context r1, MediaSessionCompat.Token r2) {
            super(r1, r2);
        }
    }

    @RequiresApi(24)
    static class d extends c {
        public d(Context r1, MediaSessionCompat.Token r2) {
            super(r1, r2);
        }
    }

    static class e implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private android.support.v4.media.session.b f188a;

        public e(MediaSessionCompat.Token r1) {
            this.f188a = android.support.v4.media.session.b.a.a((IBinder) r1.f());
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.b
        public boolean a(KeyEvent r2) {
            if (r2 == null) goto L10;
            this.f188a.G(r2);     // Catch: RemoteException -> L5
            return false;
        L5:
            e = move-exception;
            Log.e("MediaControllerCompat", "Dead object in dispatchMediaButtonEvent.", e);
            return false;
        L10:
            throw new IllegalArgumentException("event may not be null.");
        }
    }

    public static final class f {
        f(int r1, int r2, int r3, int r4, int r5) {
        }
    }

    public MediaControllerCompat(Context r3, @NonNull MediaSessionCompat.Token r4) {
        new HashSet();
        if (r4 == null) goto L17;
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 24) goto L9;
        b r1 = new d(r3, r4);
    L7:
        this.f176a = r1;
        return;
    L9:
        if (r0 < 23) goto L12;
        r1 = new c(r3, r4);
        goto L7
    L12:
        if (r0 < 21) goto L14;
        r1 = new MediaControllerImplApi21(r3, r4);
        goto L7
    L14:
        this.f176a = new e(r4);
        return;
    L17:
        throw new IllegalArgumentException("sessionToken must not be null");
    }

    public boolean a(KeyEvent r1) {
        if (r1 == null) goto L6;
        return this.f176a.a(r1);
    L6:
        throw new IllegalArgumentException("KeyEvent may not be null");
    }
}

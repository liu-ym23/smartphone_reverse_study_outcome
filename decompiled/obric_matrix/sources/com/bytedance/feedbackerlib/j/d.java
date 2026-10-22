package com.bytedance.feedbackerlib.j;

import android.content.Context;
import android.graphics.Bitmap;
import android.hardware.display.VirtualDisplay;
import android.media.Image;
import android.media.ImageReader;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.bytedance.feedbackerlib.activity.TranslucentOnePixelActivity;
import com.bytedance.feedbackerlib.m.j;
import com.ss.ttuploader.TTVideoUploader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
class d {
    private static volatile d o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f4195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private MediaProjection f4196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private MediaProjectionManager f4197c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private VirtualDisplay f4198d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private WindowManager f4199e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ImageReader f4200f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Handler f4201g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f4202h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f4203i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final File f4204j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f4205k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f4206l;
    private final int m;
    private final Handler n;

    class a implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f4207a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f4208b;

        a(d r1, f r2) {
            this.f4208b = r1;
            this.f4207a = r2;
        }

        @Override // com.bytedance.feedbackerlib.j.d.g
        public void a(boolean r1) {
            if (r1 == true) goto L4;
            this.f4207a.a(null);
            return;
        L4:
            this.f4208b.n(this.f4207a);
        }
    }

    class b extends VirtualDisplay.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f4209a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ f f4210b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d f4211c;

        b(d r1, f r2) {
            this.f4211c = r1;
            this.f4210b = r2;
            this.f4209a = true;
        }

        @Override // android.hardware.display.VirtualDisplay.Callback
        public void onPaused() {
            super.onPaused();
            d.a(this.f4211c, false);
        }

        @Override // android.hardware.display.VirtualDisplay.Callback
        public void onResumed() {
            super.onResumed();
            d.a(this.f4211c, true);
            if (this.f4209a == false) goto L6;
            this.f4209a = false;
            d.b(this.f4211c, this.f4210b);
            return;
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ f f4212f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ d f4213g;

        class a implements ImageReader.OnImageAvailableListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ c f4214a;

            a(c r1) {
                this.f4214a = r1;
            }

            @Override // android.media.ImageReader.OnImageAvailableListener
            public void onImageAvailable(ImageReader r2) {
                d.e(this.f4214a.f4213g).setOnImageAvailableListener(null, null);
                Image r3 = d.e(this.f4214a.f4213g).acquireLatestImage();
                c r1 = this.f4214a;
                d.f(r1.f4213g, r3, r1.f4212f);
            }
        }

        c(d r1, f r2) {
            this.f4213g = r1;
            this.f4212f = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Image r0 = d.e(this.f4213g).acquireLatestImage();
            if (r0 != null) goto L5;
            d.e(this.f4213g).setOnImageAvailableListener(new a(this), null);
            return;
        L5:
            d.f(this.f4213g, r0, this.f4212f);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.feedbackerlib.j.d$d, reason: collision with other inner class name */
    class RunnableC0125d implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Image f4215f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ f f4216g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ d f4217h;

        /* JADX INFO: renamed from: com.bytedance.feedbackerlib.j.d$d$a */
        class a implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ RunnableC0125d f4218f;

            a(RunnableC0125d r1) {
                this.f4218f = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f4218f.f4216g.a(null);
            }
        }

        /* JADX INFO: renamed from: com.bytedance.feedbackerlib.j.d$d$b */
        class b implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ Uri f4219f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ RunnableC0125d f4220g;

            b(RunnableC0125d r1, Uri r2) {
                this.f4220g = r1;
                this.f4219f = r2;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f4220g.f4216g.a(this.f4219f);
            }
        }

        /* JADX INFO: renamed from: com.bytedance.feedbackerlib.j.d$d$c */
        class c implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ RunnableC0125d f4221f;

            c(RunnableC0125d r1) {
                this.f4221f = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f4221f.f4216g.a(null);
            }
        }

        /* JADX INFO: renamed from: com.bytedance.feedbackerlib.j.d$d$d, reason: collision with other inner class name */
        class RunnableC0126d implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ RunnableC0125d f4222f;

            RunnableC0126d(RunnableC0125d r1) {
                this.f4222f = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f4222f.f4216g.a(null);
            }
        }

        /* JADX INFO: renamed from: com.bytedance.feedbackerlib.j.d$d$e */
        class e implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ RunnableC0125d f4223f;

            e(RunnableC0125d r1) {
                this.f4223f = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f4223f.f4216g.a(null);
            }
        }

        RunnableC0125d(d r1, Image r2, f r3) {
            this.f4217h = r1;
            this.f4215f = r2;
            this.f4216g = r3;
        }

        @Override // java.lang.Runnable
        @RequiresApi(api = 21)
        public void run() {
            int r0 = this.f4215f.getWidth();
            int r1 = this.f4215f.getHeight();
            Image.Plane[] r2 = this.f4215f.getPlanes();
            ByteBuffer r4 = r2[0].getBuffer();
            int r5 = r2[0].getPixelStride();
            Bitmap r3 = Bitmap.createBitmap(((r2[0].getRowStride() - (r5 * r0)) / r5) + r0, r1, Bitmap.Config.ARGB_8888);
            r3.copyPixelsFromBuffer(r4);
            Bitmap r6 = Bitmap.createBitmap(r3, 0, 0, r0, r1);
            this.f4215f.close();
            File r7 = new File(d.g(this.f4217h).getPath() + "/" + System.currentTimeMillis() + ".jpeg");
            if (r7.exists() == true) goto L49;
            FileOutputStream r8 = null;
        L24:
            th = th;
        L25:
            if (r8 != null) goto L57;
            Handler r9 = d.h(this.f4217h);
            Runnable r10 = new RunnableC0126d(this);
        L36:
            r9.post(r10);
            throw th;
        L57:
            r8.flush();     // Catch: IOException -> L33
            r8.close();     // Catch: IOException -> L33
            if (d.i(this.f4217h) == true) goto L29;
            d.h(this.f4217h).post(new b(this, j.e(d.k(this.f4217h), r7, System.currentTimeMillis(), d.l(this.f4217h), d.m(this.f4217h))));     // Catch: IOException -> L33
        L56:
            throw th;
        L29:
            d.j(this.f4217h, false);     // Catch: IOException -> L33
            r7.delete();     // Catch: Throwable -> L53
        L31:
            this.f4217h.n(this.f4216g);     // Catch: IOException -> L33
        L33:
            e = move-exception;
            e.printStackTrace();
            r9 = d.h(this.f4217h);
            r10 = new c(this);
            goto L36
        L6:
            if (r7.createNewFile() == true) goto L10;
            d.h(this.f4217h).post(new a(this));     // Catch: Throwable -> L24 IOException -> L54
            d.h(this.f4217h).post(new RunnableC0126d(this));
            return;
        L10:
            FileOutputStream r11 = new FileOutputStream(r7);     // Catch: Throwable -> L24 IOException -> L54
            r6.compress(Bitmap.CompressFormat.JPEG, 100, r11);     // Catch: Throwable -> L21 IOException -> L23
            r11.flush();     // Catch: IOException -> L19
            r11.close();     // Catch: IOException -> L19
            if (d.i(this.f4217h) == true) goto L15;
            d.h(this.f4217h).post(new b(this, j.e(d.k(this.f4217h), r7, System.currentTimeMillis(), d.l(this.f4217h), d.m(this.f4217h))));     // Catch: IOException -> L19
        L59:
            return;
        L15:
            d.j(this.f4217h, false);     // Catch: IOException -> L19
            r7.delete();     // Catch: Throwable -> L52
        L17:
            this.f4217h.n(this.f4216g);     // Catch: IOException -> L19
        L19:
            e = move-exception;
            e.printStackTrace();
            Handler r12 = d.h(this.f4217h);
            Runnable r13 = new c(this);
        L50:
            r12.post(r13);
            return;
        L23:
            r8 = r11;
        L21:
            th = th;
            r8 = r11;
        L38:
            if (r8 != null) goto L65;
            r12 = d.h(this.f4217h);
            r13 = new RunnableC0126d(this);
            goto L50
        L65:
            r8.flush();     // Catch: IOException -> L46
            r8.close();     // Catch: IOException -> L46
            if (d.i(this.f4217h) == true) goto L42;
            d.h(this.f4217h).post(new b(this, j.e(d.k(this.f4217h), r7, System.currentTimeMillis(), d.l(this.f4217h), d.m(this.f4217h))));     // Catch: IOException -> L46
        L64:
            return;
        L42:
            d.j(this.f4217h, false);     // Catch: IOException -> L46
            r7.delete();     // Catch: Throwable -> L55
        L44:
            this.f4217h.n(this.f4216g);     // Catch: IOException -> L46
        L46:
            e = move-exception;
            e.printStackTrace();
            r12 = d.h(this.f4217h);
            r13 = new c(this);
            goto L50
        L49:
            r12 = d.h(this.f4217h);
            r13 = new e(this);
            goto L50
        }
    }

    class e implements TranslucentOnePixelActivity.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f4224a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f4225b;

        class a implements com.bytedance.feedbackerlib.model.b.InterfaceC0144b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ e f4226a;

            a(e r1) {
                this.f4226a = r1;
            }

            @Override // com.bytedance.feedbackerlib.model.b.InterfaceC0144b
            public void a(MediaProjection r2) {
                d.d(this.f4226a.f4225b, r2);
                e r1 = this.f4226a;
                g r3 = r1.f4224a;
                if (d.c(r1.f4225b) == null) goto L5;
                boolean r4 = true;
            L6:
                r3.a(r4);
                return;
            L5:
                r4 = false;
                goto L6
            }
        }

        e(d r1, g r2) {
            this.f4225b = r1;
            this.f4224a = r2;
        }

        @Override // com.bytedance.feedbackerlib.activity.TranslucentOnePixelActivity.b
        @RequiresApi(api = 21)
        public void onRequestPermissionResult(String[] r3, int[] r4) {
            if (r4.length == 2) goto L5;
        L13:
            this.f4224a.a(false);
            return;
        L5:
            if (r4[0] != 0) goto L13;
            if (r4[1] != 0) goto L13;
            d r5 = this.f4225b;
            d.d(r5, com.bytedance.feedbackerlib.model.b.e(d.k(r5)).f(new a(this)));
            if (d.c(this.f4225b) == null) goto L15;
            this.f4224a.a(true);
            return;
        }
    }

    interface f {
        void a(Uri r1);
    }

    interface g {
        void a(boolean r1);
    }

    @RequiresApi(api = 21)
    private d(@NonNull Context r8) {
        this.f4202h = false;
        this.f4203i = true;
        this.f4195a = r8.getApplicationContext();
        q();
        if (r() == false) goto L11;
        int r9 = this.f4195a.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (r9 <= 0) goto L7;
        this.f4195a.getResources().getDimensionPixelSize(r9);
    L7:
        DisplayMetrics r10 = new DisplayMetrics();
        Display r4 = this.f4199e.getDefaultDisplay();
        if (r4 == null) goto L11;
        r4.getRealMetrics(r10);
        this.f4206l = r10.heightPixels;
        this.f4205k = r10.widthPixels;
        this.m = r10.densityDpi;
    L12:
        this.f4200f = ImageReader.newInstance(this.f4205k, this.f4206l, 1, 3);
        File r11 = new File(this.f4195a.getFilesDir(), "ScreenShot");
        this.f4204j = r11;
        if (r11.exists() == true) goto L15;
        r11.mkdirs();
    L15:
        HandlerThread r12 = new HandlerThread("ScreenShot");
        r12.start();
        this.f4201g = new Handler(r12.getLooper());
        this.n = new Handler(Looper.getMainLooper());
        return;
    L11:
        this.f4205k = 1080;
        this.f4206l = 1920;
        this.m = TTVideoUploader.KeyIsGetTosKey;
        goto L12
    }

    static /* synthetic */ boolean a(d r0, boolean r1) {
        r0.f4202h = r1;
        return r1;
    }

    static /* synthetic */ void b(d r0, f r1) {
        r0.o(r1);
    }

    static /* synthetic */ MediaProjection c(d r0) {
        return r0.f4196b;
    }

    static /* synthetic */ MediaProjection d(d r0, MediaProjection r1) {
        r0.f4196b = r1;
        return r1;
    }

    static /* synthetic */ ImageReader e(d r0) {
        return r0.f4200f;
    }

    static /* synthetic */ void f(d r0, Image r1, f r2) {
        r0.t(r1, r2);
    }

    static /* synthetic */ File g(d r0) {
        return r0.f4204j;
    }

    static /* synthetic */ Handler h(d r0) {
        return r0.n;
    }

    static /* synthetic */ boolean i(d r0) {
        return r0.f4203i;
    }

    static /* synthetic */ boolean j(d r0, boolean r1) {
        r0.f4203i = r1;
        return r1;
    }

    static /* synthetic */ Context k(d r0) {
        return r0.f4195a;
    }

    static /* synthetic */ int l(d r0) {
        return r0.f4205k;
    }

    static /* synthetic */ int m(d r0) {
        return r0.f4206l;
    }

    @RequiresApi(api = 19)
    private void o(f r3) {
        if (this.f4202h == true) goto L6;
        r3.a(null);
        return;
    L6:
        this.f4201g.postDelayed(new c(this, r3), 100);
    }

    @RequiresApi(api = 16)
    private boolean p(g r4) {
        if (this.f4196b == null) goto L7;
        return true;
    L7:
        if (r4 != null) goto L9;
        return false;
    L9:
        TranslucentOnePixelActivity.D(this.f4195a, new e(this, r4), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"});
        return false;
    }

    @RequiresApi(api = 21)
    private boolean q() {
        if (this.f4197c == null) goto L5;
        return true;
    L5:
        MediaProjectionManager r0 = (MediaProjectionManager) this.f4195a.getSystemService("media_projection");
        this.f4197c = r0;
        if (r0 != null) goto L10;
        return false;
    L10:
        return true;
    }

    private boolean r() {
        if (this.f4199e == null) goto L5;
        return true;
    L5:
        WindowManager r0 = (WindowManager) this.f4195a.getSystemService("window");
        this.f4199e = r0;
        if (r0 != null) goto L10;
        return false;
    L10:
        return true;
    }

    @RequiresApi(api = 21)
    static d s(@NonNull Context r2) {
        if (o != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (o != null) goto L9;
        o = new d(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return o;
    }

    private void t(Image r3, f r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r3 != null) goto L7;
        r4.a(null);
        return;
    L7:
        this.f4201g.post(new RunnableC0125d(this, r3, r4));
    }

    @RequiresApi(api = 21)
    void n(f r12) {
        if (r12 != null) goto L5;
        return;
    L5:
        if (q() == true) goto L9;
        r12.a(null);
        return;
    L9:
        if (p(new a(this, r12)) == true) goto L12;
        return;
    L12:
        if (this.f4198d == null) goto L18;
        o(r12);
        return;
    L18:
        this.f4198d = this.f4196b.createVirtualDisplay("ScreenShotManager", this.f4205k, this.f4206l, this.m, 16, this.f4200f.getSurface(), new b(this, r12), null);     // Catch: Throwable -> L15
        return;
    L15:
        this.f4198d = null;
        this.f4196b = null;
        com.bytedance.feedbackerlib.model.b.e(this.f4195a).g();
        n(r12);
    }
}

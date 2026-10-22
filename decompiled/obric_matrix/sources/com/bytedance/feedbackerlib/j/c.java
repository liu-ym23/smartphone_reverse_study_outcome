package com.bytedance.feedbackerlib.j;

import android.content.Context;
import android.hardware.display.VirtualDisplay;
import android.media.AudioRecord;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.media.projection.MediaProjection;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Surface;
import android.view.WindowManager;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.feedbackerlib.activity.TranslucentOnePixelActivity;
import com.bytedance.feedbackerlib.m.j;
import com.bytedance.feedbackerlib.m.r;
import com.bytedance.feedbackerlib.m.t;
import com.ttnet.org.chromium.base.TimeUtils;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
@RequiresApi(api = 16)
class c {
    private static volatile c A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f4152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f4153b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HandlerThread f4154c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Handler f4155d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final HandlerThread f4156e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Handler f4157f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f4158g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f4159h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f4160i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private MediaProjection f4161j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private g f4162k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private i f4163l;
    private VirtualDisplay m;
    private AudioRecord n;
    private MediaCodec o;
    private MediaCodec p;
    private MediaMuxer q;
    private Surface r;
    private MediaFormat s;
    private MediaFormat t;
    private int u;
    private int v;
    private String w;
    private long x;
    private boolean y;
    private boolean z;

    class a implements TranslucentOnePixelActivity.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4164a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f4165b;

        /* JADX INFO: renamed from: com.bytedance.feedbackerlib.j.c$a$a, reason: collision with other inner class name */
        class RunnableC0119a implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ int[] f4166f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ a f4167g;

            /* JADX INFO: renamed from: com.bytedance.feedbackerlib.j.c$a$a$a, reason: collision with other inner class name */
            class C0120a implements com.bytedance.feedbackerlib.model.b.InterfaceC0144b {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ RunnableC0119a f4168a;

                /* JADX INFO: renamed from: com.bytedance.feedbackerlib.j.c$a$a$a$a, reason: collision with other inner class name */
                class RunnableC0121a implements Runnable {

                    /* JADX INFO: renamed from: f, reason: collision with root package name */
                    final /* synthetic */ MediaProjection f4169f;

                    /* JADX INFO: renamed from: g, reason: collision with root package name */
                    final /* synthetic */ C0120a f4170g;

                    RunnableC0121a(C0120a r1, MediaProjection r2) {
                        this.f4170g = r1;
                        this.f4169f = r2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        MediaProjection r0 = this.f4169f;
                        if (r0 != null) goto L6;
                        com.bytedance.feedbackerlib.m.c.b("ScreenRecordManagerExt record", "onMediaProjectionAvailiable: 用户没有同意录屏");
                        r.j(this.f4170g.f4168a.f4167g.f4164a, "onMediaProjectionAvailiable: 用户没有同意录屏", new String[0]);
                        Log.e("ScreenRecordManagerExt", "onMediaProjectionAvailiable: 用户没有同意录屏");
                        c.a(this.f4170g.f4168a.f4167g.f4165b).c(-1, null);
                        c.b(this.f4170g.f4168a.f4167g.f4165b, null);
                        this.f4170g.f4168a.f4167g.f4165b.X();
                        return;
                    L6:
                        c.e(this.f4170g.f4168a.f4167g.f4165b, r0);
                        a r4 = this.f4170g.f4168a.f4167g;
                        c.q(r4.f4165b, r4.f4164a);
                    }
                }

                C0120a(RunnableC0119a r1) {
                    this.f4168a = r1;
                }

                @Override // com.bytedance.feedbackerlib.model.b.InterfaceC0144b
                public void a(MediaProjection r3) {
                    c.D(this.f4168a.f4167g.f4165b).post(new RunnableC0121a(this, r3));
                }
            }

            RunnableC0119a(a r1, int[] r2) {
                this.f4167g = r1;
                this.f4166f = r2;
            }

            @Override // java.lang.Runnable
            public void run() {
                int[] r0 = this.f4166f;
                if (r0.length >= 1) goto L5;
            L19:
                String r1 = "onRequestPermissionResult: 用户没有授予写文件权限";
                com.bytedance.feedbackerlib.m.c.b("ScreenRecordManagerExt record", "onRequestPermissionResult: 用户没有授予写文件权限");
                r.j(this.f4167g.f4164a, "onRequestPermissionResult: 用户没有授予写文件权限", new String[0]);
            L17:
                Log.e("ScreenRecordManagerExt", r1);
                c.a(this.f4167g.f4165b).c(-1, null);
                c.b(this.f4167g.f4165b, null);
                this.f4167g.f4165b.X();
                return;
            L5:
                if (r0[0] != 0) goto L19;
                if (r0.length >= 2) goto L10;
            L16:
                r1 = "onRequestPermissionResult: 用户没有授予录音权限";
                com.bytedance.feedbackerlib.m.c.b("ScreenRecordManagerExt record", "onRequestPermissionResult: 用户没有授予录音权限");
                r.j(this.f4167g.f4164a, "onRequestPermissionResult: 用户没有授予录音权限", new String[0]);
                goto L17
            L10:
                if (r0[1] != 0) goto L16;
                c r2 = this.f4167g.f4165b;
                c.e(r2, com.bytedance.feedbackerlib.model.b.e(c.E(r2)).f(new C0120a(this)));
                if (c.c(this.f4167g.f4165b) == null) goto L20;
                a r10 = this.f4167g;
                c.q(r10.f4165b, r10.f4164a);
                return;
            }
        }

        a(c r1, String r2) {
            this.f4165b = r1;
            this.f4164a = r2;
        }

        @Override // com.bytedance.feedbackerlib.activity.TranslucentOnePixelActivity.b
        @RequiresApi(api = 21)
        public void onRequestPermissionResult(String[] r2, int[] r3) {
            c.D(this.f4165b).post(new RunnableC0119a(this, r3));
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f4171f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ c f4172g;

        b(c r1, String r2) {
            this.f4172g = r1;
            this.f4171f = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.feedbackerlib.m.c.b("ScreenRecordManagerExt record", "startRecordAfterPermissionGranted is invoked");     // Catch: Throwable -> L13 MediaCodec.CodecException -> L16 SecurityException -> L21
            r.j(this.f4171f, "startRecordAfterPermissionGranted is invoked", new String[0]);     // Catch: Throwable -> L13 MediaCodec.CodecException -> L16 SecurityException -> L21
            c.F(this.f4172g, this.f4171f);     // Catch: Throwable -> L13 MediaCodec.CodecException -> L16 SecurityException -> L21
            if (c.G(this.f4172g) == true) goto L6;
        L11:
            com.bytedance.feedbackerlib.m.c.b("ScreenRecordManagerExt record", "createAndPrepareVideoEncoder() is " + c.G(this.f4172g) + ", createAndPrepareAudioEncoder() is " + c.H(this.f4172g) + ", createAndPrepareAudioRecord() is " + c.I(this.f4172g));     // Catch: Throwable -> L13 MediaCodec.CodecException -> L16 SecurityException -> L21
            r.j(this.f4171f, "startRecordAfterPermissionGranted is invoked", new String[]{"createAndPrepareVideoEncoder() is " + c.G(this.f4172g) + ", createAndPrepareAudioEncoder() is " + c.H(this.f4172g) + ", createAndPrepareAudioRecord() is " + c.I(this.f4172g)});     // Catch: Throwable -> L13 MediaCodec.CodecException -> L16 SecurityException -> L21
            this.f4172g.X();     // Catch: Throwable -> L13 MediaCodec.CodecException -> L16 SecurityException -> L21
            return;
        L6:
            if (c.H(this.f4172g) == false) goto L11;
            if (c.I(this.f4172g) == false) goto L11;
            c.J(this.f4172g);     // Catch: Throwable -> L13 MediaCodec.CodecException -> L16 SecurityException -> L21
            c.d(this.f4172g);     // Catch: Throwable -> L13 MediaCodec.CodecException -> L16 SecurityException -> L21
            return;
        L16:
            e = move-exception;
            if (c.i(this.f4172g) == false) goto L20;
            com.bytedance.feedbackerlib.m.c.b("ScreenRecordManagerExt record", "startRecordAfterPermissionGranted failed: " + e.toString());
            r.j(this.f4171f, "startRecordAfterPermissionGranted failed: " + e.toString(), new String[0]);
            Throwable r0 = e;
        L15:
            com.bytedance.feedbackerlib.m.c.a("ScreenRecordManagerExt", "startRecordAfterPermissionGranted failed", r0);
            this.f4172g.X();
            return;
        L20:
            c.j(this.f4172g, true);
            c.k(this.f4172g, TypedValues.Custom.TYPE_INT);
            c.l(this.f4172g, 1600);
            c.q(this.f4172g, this.f4171f);
            return;
        L21:
            e = move-exception;
            if (c.f(this.f4172g) == false) goto L25;
            com.bytedance.feedbackerlib.m.c.b("ScreenRecordManagerExt record", "startRecordAfterPermissionGranted failed: " + e.toString());
            r.j(this.f4171f, "startRecordAfterPermissionGranted failed: " + e.toString(), new String[0]);
            r0 = e;
            goto L15
        L25:
            c.g(this.f4172g, true);
            com.bytedance.feedbackerlib.model.b.e(c.E(this.f4172g)).h();
            c.h(this.f4172g, this.f4171f);
            return;
        L13:
            th = move-exception;
            com.bytedance.feedbackerlib.m.c.b("ScreenRecordManagerExt record", "startRecordAfterPermissionGranted failed: " + th.toString());
            r.j(this.f4171f, "startRecordAfterPermissionGranted failed: " + th.toString(), new String[0]);
            r0 = th;
            goto L15
        }
    }

    /* JADX INFO: renamed from: com.bytedance.feedbackerlib.j.c$c, reason: collision with other inner class name */
    class C0122c extends MediaCodec.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f4173a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f4174b;

        C0122c(c r3) {
            this.f4174b = r3;
            this.f4173a = -1;
        }

        @Override // android.media.MediaCodec.Callback
        public void onError(@NonNull MediaCodec r2, @NonNull MediaCodec.CodecException r3) {
            com.bytedance.feedbackerlib.m.c.b("ScreenRecordManagerExt record", "mVideoEncoder callback error: " + r3.toString());
            this.f4174b.X();
        }

        @Override // android.media.MediaCodec.Callback
        public void onInputBufferAvailable(@NonNull MediaCodec r1, int r2) {
        }

        @Override // android.media.MediaCodec.Callback
        public void onOutputBufferAvailable(@NonNull MediaCodec r6, int r7, @NonNull MediaCodec.BufferInfo r8) {
            int r0 = r8.flags;
            if ((r0 & 1) == 1) goto L6;
            if (r0 == 0) goto L6;
        L15:
            r6.releaseOutputBuffer(r7, false);
            if ((r8.flags & 4) != 4) goto L19;
            this.f4174b.X();
            Toast.makeText(c.E(this.f4174b), "视频流终结，停止录屏", 0).show();
            return;
        L19:
            return;
        L6:
            if (c.m(this.f4174b) == false) goto L15;
            if (this.f4173a != (-1)) goto L10;
            this.f4173a = r8.presentationTimeUs;
        L10:
            r8.presentationTimeUs -= this.f4173a;
            ByteBuffer r1 = r6.getOutputBuffer(r7);
            if (r1 == null) goto L15;
            r1.position(r8.offset);
            r1.limit(r8.offset + r8.size);
            c.o(this.f4174b).writeSampleData(c.n(this.f4174b), r1, r8);
            c.a(this.f4174b).b(r8.presentationTimeUs / 1000);
            if ((r8.presentationTimeUs / 1000) < 30000) goto L15;
            this.f4174b.X();
            goto L15
        }

        @Override // android.media.MediaCodec.Callback
        public void onOutputFormatChanged(@NonNull MediaCodec r1, @NonNull MediaFormat r2) {
            c.p(this.f4174b, r2);
            if (c.r(this.f4174b) == true) goto L6;
            this.f4174b.X();
            return;
        }
    }

    class d extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f4175a;

        d(c r1, Looper r2) {
            this.f4175a = r1;
            super(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r2) {
            int r0 = r2.what;
            if (r0 != 0) goto L5;
            c.s(this.f4175a, (h) r2.obj);
            return;
        L5:
            if (r0 != 5) goto L11;
            c.t(this.f4175a);
            return;
        }
    }

    class e extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private long f4176a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f4177b;

        class a implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ ByteBuffer f4178f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ MediaCodec.BufferInfo f4179g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ int f4180h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            final /* synthetic */ e f4181i;

            a(e r1, ByteBuffer r2, MediaCodec.BufferInfo r3, int r4) {
                this.f4181i = r1;
                this.f4178f = r2;
                this.f4179g = r3;
                this.f4180h = r4;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (c.y(this.f4181i.f4177b) == g.f4186g) goto L6;
                return;
            L6:
                if (c.m(this.f4181i.f4177b) == false) goto L8;
                c.o(this.f4181i.f4177b).writeSampleData(c.z(this.f4181i.f4177b), this.f4178f, this.f4179g);
            L8:
                Message r0 = Message.obtain();
                r0.what = 6;
                r0.arg1 = this.f4180h;
                c.A(this.f4181i.f4177b).sendMessage(r0);
            }
        }

        class b implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ MediaFormat f4182f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ e f4183g;

            b(e r1, MediaFormat r2) {
                this.f4183g = r1;
                this.f4182f = r2;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (c.y(this.f4183g.f4177b) == g.f4186g) goto L5;
                return;
            L5:
                c.B(this.f4183g.f4177b, this.f4182f);
                if (c.r(this.f4183g.f4177b) == true) goto L9;
                this.f4183g.f4177b.X();
                return;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.feedbackerlib.j.c$e$c, reason: collision with other inner class name */
        class RunnableC0123c implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ e f4184f;

            RunnableC0123c(e r1) {
                this.f4184f = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.C(this.f4184f.f4177b);
            }
        }

        e(c r1, Looper r2) {
            this.f4177b = r1;
            super(r2);
            this.f4176a = 0;
        }

        @Override // android.os.Handler
        public void handleMessage(Message r14) {
            int r0 = r14.what;
            if (r0 != 1) goto L5;
        L37:
            int r7 = c.u(this.f4177b).dequeueInputBuffer(0);
            c r15 = this.f4177b;
            if (r7 < 0) goto L44;
            ByteBuffer r16 = c.u(r15).getInputBuffer(r7);
            if (r16 == null) goto L45;
            int r8 = r16.position();
            int r9 = c.w(this.f4177b).read(r16, r16.limit() - r8);
            if (r9 <= 0) goto L45;
            long r1 = (((long) ((r9 << 3) >> 4)) * TimeUtils.NANOSECONDS_PER_MILLISECOND) / 44100;
            c.u(this.f4177b).queueInputBuffer(r7, r8, r9, this.f4176a, 1);
            this.f4176a += r1;
        L35:
            sendEmptyMessage(3);
            return;
        L45:
            sendEmptyMessage(1);
            return;
        L44:
            r15.X();
            goto L45
        L5:
            if (r0 != 2) goto L7;
            this.f4176a = 0;
            goto L37
        L7:
            if (r0 != 3) goto L9;
            MediaCodec.BufferInfo r17 = new MediaCodec.BufferInfo();
            int r2 = c.u(this.f4177b).dequeueOutputBuffer(r17, 0);
            if (r2 < 0) goto L33;
            int r3 = r17.flags;
            if ((r3 & 4) != 4) goto L25;
            this.f4177b.X();
            c.u(this.f4177b).releaseOutputBuffer(r2, false);
            return;
        L25:
            if (r3 != 0) goto L27;
        L28:
            ByteBuffer r4 = c.u(this.f4177b).getOutputBuffer(r2);
            if (r4 == null) goto L31;
            r4.position(r17.offset);
            r4.limit(r17.offset + r17.size);
            c.D(this.f4177b).post(new a(this, r4, r17, r2));
            goto L35
        L31:
            c.u(this.f4177b).releaseOutputBuffer(r2, false);
            goto L35
        L27:
            if ((r3 & 1) != 1) goto L35;
        L33:
            if (r2 != (-2)) goto L45;
            c.D(this.f4177b).post(new b(this, c.u(this.f4177b).getOutputFormat()));
            goto L35
        L9:
            if (r0 == 4) goto L14;
            if (r0 != 6) goto L51;
            c.u(this.f4177b).releaseOutputBuffer(r14.arg1, false);
            return;
        L51:
            return;
        L14:
            if (c.u(this.f4177b) == null) goto L17;
            c.u(this.f4177b).stop();
            c.u(this.f4177b).release();
            c.v(this.f4177b, null);
        L17:
            if (c.w(this.f4177b) == null) goto L19;
            c.w(this.f4177b).release();
            c.x(this.f4177b, null);
        L19:
            c.A(this.f4177b).removeMessages(1);
            c.A(this.f4177b).removeMessages(3);
            c.A(this.f4177b).removeMessages(2);
            c.A(this.f4177b).removeMessages(4);
            c.A(this.f4177b).removeMessages(6);
            c.D(this.f4177b).post(new RunnableC0123c(this));
        }
    }

    static class f extends Exception {
        f(@Nullable String r1) {
            if (r1 != null) goto L4;
            r1 = "";
        L4:
            super(r1);
        }
    }

    private static final enum g extends Enum<g> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final g f4185f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final g f4186g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final /* synthetic */ g[] f4187h = null;

        static {
            g r0 = new g("STOPPED", 0);
            f4185f = r0;
            g r1 = new g("STARTED", 1);
            f4186g = r1;
            f4187h = new g[]{r0, r1};
        }

        private g(String r1, int r2) {
            super(r1, r2);
        }

        public static g valueOf(String r1) {
            return (g) Enum.valueOf(g.class, r1);
        }

        public static g[] values() {
            return (g[]) f4187h.clone();
        }
    }

    public interface h {
        void a();

        void b(long r1);

        void c(long r1, @Nullable Uri r3);
    }

    private class i implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        private h f4188a;

        class a implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ i f4189f;

            a(i r1) {
                this.f4189f = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                i.d(this.f4189f).a();
            }
        }

        class b implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ long f4190f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ i f4191g;

            b(i r1, long r2) {
                this.f4191g = r1;
                this.f4190f = r2;
            }

            @Override // java.lang.Runnable
            public void run() {
                i.d(this.f4191g).b(this.f4190f);
            }
        }

        /* JADX INFO: renamed from: com.bytedance.feedbackerlib.j.c$i$c, reason: collision with other inner class name */
        class RunnableC0124c implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ long f4192f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ Uri f4193g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ i f4194h;

            RunnableC0124c(i r1, long r2, Uri r4) {
                this.f4194h = r1;
                this.f4192f = r2;
                this.f4193g = r4;
            }

            @Override // java.lang.Runnable
            public void run() {
                i.d(this.f4194h).c(this.f4192f, this.f4193g);
            }
        }

        i(@NonNull c r1, h r2) {
            this.f4188a = r2;
        }

        static /* synthetic */ h d(i r0) {
            return r0.f4188a;
        }

        @Override // com.bytedance.feedbackerlib.j.c.h
        public void a() {
            t.a(new a(this));
        }

        @Override // com.bytedance.feedbackerlib.j.c.h
        public void b(long r2) {
            t.a(new b(this, r2));
        }

        @Override // com.bytedance.feedbackerlib.j.c.h
        public void c(long r2, @Nullable Uri r4) {
            t.a(new RunnableC0124c(this, r2, r4));
        }
    }

    @RequiresApi(api = 21)
    private c(@NonNull Context r4) {
        this.y = false;
        this.z = false;
        Context r5 = r4.getApplicationContext();
        this.f4153b = r5;
        if (Build.VERSION.SDK_INT < 29) goto L5;
        File r0 = new File(r5.getFilesDir(), "ScreenRecord");
    L7:
        if (r0.exists() == true) goto L10;
        r0.mkdirs();
    L10:
        if (r0.exists() == false) goto L20;
        if (r0.isDirectory() == false) goto L20;
        this.f4152a = r0.getPath();
        WindowManager r6 = (WindowManager) r5.getSystemService("window");
        if (r6 == null) goto L18;
        DisplayMetrics r1 = new DisplayMetrics();
        r6.getDefaultDisplay().getRealMetrics(r1);
        this.f4160i = r1.densityDpi;
        int r7 = r1.heightPixels;
        this.f4158g = r1.widthPixels;
        this.f4159h = r7;
        HandlerThread r8 = new HandlerThread("screen_record_ext_handler_thread");
        this.f4154c = r8;
        r8.start();
        this.f4155d = new d(this, r8.getLooper());
        HandlerThread r9 = new HandlerThread("audio_process_handler_thread");
        this.f4156e = r9;
        r9.start();
        this.f4157f = new e(this, r9.getLooper());
        this.f4162k = g.f4185f;
        return;
    L18:
        throw new f("获取WindowManager失败");
    L20:
        throw new f("创建录屏存储路径失败");
    L5:
        r0 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES);
        goto L7
    }

    static /* synthetic */ Handler A(c r0) {
        return r0.f4157f;
    }

    static /* synthetic */ MediaFormat B(c r0, MediaFormat r1) {
        r0.t = r1;
        return r1;
    }

    static /* synthetic */ void C(c r0) {
        r0.Z();
    }

    static /* synthetic */ Handler D(c r0) {
        return r0.f4155d;
    }

    static /* synthetic */ Context E(c r0) {
        return r0.f4153b;
    }

    static /* synthetic */ void F(c r0, String r1) {
        r0.Q(r1);
    }

    static /* synthetic */ boolean G(c r0) {
        return r0.N();
    }

    static /* synthetic */ boolean H(c r0) {
        return r0.K();
    }

    static /* synthetic */ boolean I(c r0) {
        return r0.L();
    }

    static /* synthetic */ void J(c r0) {
        r0.W();
    }

    @RequiresApi(api = 21)
    private boolean K() {
        this.p = MediaCodec.createEncoderByType("audio/mp4a-latm");     // Catch: IOException -> L6
        MediaFormat r0 = MediaFormat.createAudioFormat("audio/mp4a-latm", 44100, 1);
        r0.setInteger("aac-profile", 1);
        r0.setInteger("bitrate", 320);
        this.p.configure(r0, null, null, 1);
        this.p.start();
        return true;
    L6:
        e = move-exception;
        com.bytedance.feedbackerlib.m.c.b("ScreenRecordManagerExt record", "createAndPrepareAudioEncoder failed: " + e.toString());
        com.bytedance.feedbackerlib.m.c.a("ScreenRecordManagerExt", "createAndPrepareAudioEncoder failed", e);
        this.p = null;
        return false;
    }

    private boolean L() {
        int r0 = AudioRecord.getMinBufferSize(44100, 16, 2);
        if (r0 > 0) goto L6;
        com.bytedance.feedbackerlib.m.c.b("ScreenRecordManagerExt record", "startRecordInner: 获取minBuffer失败");
        Log.e("ScreenRecordManagerExt", "startRecordInner: 获取minBuffer失败");
        return false;
    L6:
        AudioRecord r11 = new AudioRecord(1, 44100, 16, 2, r0 * 2);
        this.n = r11;
        if (r11.getState() != 0) goto L10;
        com.bytedance.feedbackerlib.m.c.b("ScreenRecordManagerExt record", "startRecordInner: 创建AudioRecord失败");
        Log.e("ScreenRecordManagerExt", "startRecordInner: 创建AudioRecord失败");
        this.n = null;
        return false;
    L10:
        this.n.startRecording();
        return true;
    }

    @RequiresApi(api = 18)
    private boolean M() {
        if (this.s != null) goto L5;
    L18:
        Log.d("ScreenRecordManagerExt", "createAndPrepareMediaMuxerIfReady: outputFormat not ready");
        return true;
    L5:
        if (this.t == null) goto L18;
        this.w = this.f4152a + "/" + ("screen_record_" + System.currentTimeMillis() + ".mp4");
        MediaMuxer r4 = new MediaMuxer(this.w, 0);     // Catch: IOException -> L15
        this.q = r4;     // Catch: IOException -> L15
        this.u = r4.addTrack(this.s);
        this.v = this.q.addTrack(this.t);
        this.q.start();
        this.x = System.currentTimeMillis();
        if (P() == false) goto L13;
        this.f4163l.a();
        return true;
    L13:
        Log.e("ScreenRecordManagerExt", "createAndPrepareMediaMuxerIfReady: 创建MediaMuxer失败");
        this.q = null;
        this.w = null;
        this.u = -1;
        this.v = -1;
        this.x = 0;
        return false;
    L15:
        e = move-exception;
        com.bytedance.feedbackerlib.m.c.a("ScreenRecordManagerExt", "createAndPrepareMediaMuxerIfReady: create MediaMuxer failed", e);
        this.q = null;
        this.w = null;
        return false;
    }

    @RequiresApi(api = 21)
    private boolean N() {
        this.o = MediaCodec.createEncoderByType("video/avc");     // Catch: IOException -> L6
        MediaFormat r0 = MediaFormat.createVideoFormat("video/avc", this.f4158g, this.f4159h);
        r0.setInteger("color-format", 2130708361);
        r0.setInteger("bitrate", 12582912);
        r0.setInteger("frame-rate", 30);
        r0.setInteger("i-frame-interval", 1);
        this.o.configure(r0, null, null, 1);
        this.r = this.o.createInputSurface();
        this.o.setCallback(new C0122c(this));
        this.o.start();
        return true;
    L6:
        e = move-exception;
        com.bytedance.feedbackerlib.m.c.a("ScreenRecordManagerExt", "createAndPrepareVideoEncoder: create VideoEncoder failed", e);
        this.o = null;
        return false;
    }

    @RequiresApi(api = 21)
    public static c O(@NonNull Context r2) {
        if (A != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (A != null) goto L9;
        A = new c(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return A;
    }

    private boolean P() {
        if (this.u != (-1)) goto L5;
    L13:
        return false;
    L5:
        if (this.v == (-1)) goto L13;
        if (this.s == null) goto L13;
        if (this.t == null) goto L13;
        if (this.q == null) goto L13;
        return true;
    }

    @RequiresApi(api = 21)
    private void Q(String r12) {
        com.bytedance.feedbackerlib.m.c.b("ScreenRecordManagerExt record", "prepareVirtualDisplay is invoked");
        r.j(r12, "prepareVirtualDisplay is invoked", new String[0]);
        this.m = this.f4161j.createVirtualDisplay("feedbackerlib_screen_record_manager_ext", this.f4158g, this.f4159h, this.f4160i, 1, null, null, null);
    }

    private void R(String r3) {
        TranslucentOnePixelActivity.D(this.f4153b, new a(this, r3), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.RECORD_AUDIO"});
    }

    @RequiresApi(api = 21)
    private void T(String r3) {
        b r0 = new b(this, r3);
        if (Looper.myLooper() != this.f4154c.getLooper()) goto L5;
        r0.run();
        return;
    L5:
        this.f4155d.post(r0);
    }

    private void U() {
        this.f4157f.sendEmptyMessage(2);
    }

    @RequiresApi(api = 21)
    private void V(@NonNull h r6) {
        com.bytedance.feedbackerlib.m.c.b("ScreenRecordManagerExt record", "startRecordInner start");
        String r2 = "record->" + System.currentTimeMillis();
        r.j(r2, "startRecordInner start", new String[0]);
        this.f4163l = new i(this, r6);
        if (this.f4162k == g.f4185f) goto L6;
        com.bytedance.feedbackerlib.m.c.b("ScreenRecordManagerExt record", "handleMessage: 调用了startRecord，但是当前状态并不是Stopped");
        r.j(r2, "handleMessage: 调用了startRecord，但是当前状态并不是Stopped", new String[0]);
        Log.e("ScreenRecordManagerExt", "handleMessage: 调用了startRecord，但是当前状态并不是Stopped");
        this.f4163l.c(-1, null);
        this.f4163l = null;
        return;
    L6:
        this.f4162k = g.f4186g;
        if (this.f4161j != null) goto L10;
        R(r2);
        return;
    L10:
        T(r2);
    }

    @RequiresApi(api = 20)
    private void W() {
        this.m.setSurface(this.r);
    }

    @RequiresApi(api = 20)
    private void Y() {
        if (this.f4162k == g.f4186g) goto L5;
        return;
    L5:
        Message r0 = Message.obtain();
        r0.what = 4;
        this.f4157f.sendMessageAtFrontOfQueue(r0);
        MediaCodec r1 = this.o;
        if (r1 == null) goto L8;
        r1.stop();
    L8:
        MediaCodec.BufferInfo r2 = new MediaCodec.BufferInfo();
        r2.set(0, 0, 0, 4);
        ByteBuffer r3 = ByteBuffer.allocate(0);
        if (P() == false) goto L11;
        this.q.writeSampleData(this.u, r3, r2);
        this.q.writeSampleData(this.v, r3, r2);
    L11:
        this.u = -1;
        this.v = -1;
        this.s = null;
        this.t = null;
        VirtualDisplay r4 = this.m;
        if (r4 == null) goto L14;
        r4.setSurface(null);
        this.m.release();
        this.m = null;
    L14:
        Surface r5 = this.r;
        if (r5 == null) goto L17;
        r5.release();
        this.r = null;
    L17:
        MediaCodec r6 = this.o;
        if (r6 == null) goto L21;
        r6.release();
        this.o = null;
        return;
    }

    @RequiresApi(api = 20)
    private void Z() {
        if (this.f4162k == g.f4186g) goto L5;
        return;
    L5:
        MediaMuxer r0 = this.q;
        if (r0 == null) goto L8;
        r0.stop();
        this.q.release();
        this.q = null;
        long r10 = j.c(this.w);
        Uri r1 = j.f(this.f4153b, new File(this.w), System.currentTimeMillis(), this.f4158g, this.f4159h, r10);
        this.f4163l.c(r10, r1);
    L11:
        this.f4163l = null;
        this.w = null;
        this.x = 0;
        this.f4162k = g.f4185f;
        return;
    L8:
        i r2 = this.f4163l;
        if (r2 == null) goto L11;
        r2.c(-1, null);
        goto L11
    }

    static /* synthetic */ i a(c r0) {
        return r0.f4163l;
    }

    static /* synthetic */ i b(c r0, i r1) {
        r0.f4163l = r1;
        return r1;
    }

    static /* synthetic */ MediaProjection c(c r0) {
        return r0.f4161j;
    }

    static /* synthetic */ void d(c r0) {
        r0.U();
    }

    static /* synthetic */ MediaProjection e(c r0, MediaProjection r1) {
        r0.f4161j = r1;
        return r1;
    }

    static /* synthetic */ boolean f(c r0) {
        return r0.y;
    }

    static /* synthetic */ boolean g(c r0, boolean r1) {
        r0.y = r1;
        return r1;
    }

    static /* synthetic */ void h(c r0, String r1) {
        r0.R(r1);
    }

    static /* synthetic */ boolean i(c r0) {
        return r0.z;
    }

    static /* synthetic */ boolean j(c r0, boolean r1) {
        r0.z = r1;
        return r1;
    }

    static /* synthetic */ int k(c r0, int r1) {
        r0.f4158g = r1;
        return r1;
    }

    static /* synthetic */ int l(c r0, int r1) {
        r0.f4159h = r1;
        return r1;
    }

    static /* synthetic */ boolean m(c r0) {
        return r0.P();
    }

    static /* synthetic */ int n(c r0) {
        return r0.u;
    }

    static /* synthetic */ MediaMuxer o(c r0) {
        return r0.q;
    }

    static /* synthetic */ MediaFormat p(c r0, MediaFormat r1) {
        r0.s = r1;
        return r1;
    }

    static /* synthetic */ void q(c r0, String r1) {
        r0.T(r1);
    }

    static /* synthetic */ boolean r(c r0) {
        return r0.M();
    }

    static /* synthetic */ void s(c r0, h r1) {
        r0.V(r1);
    }

    static /* synthetic */ void t(c r0) {
        r0.Y();
    }

    static /* synthetic */ MediaCodec u(c r0) {
        return r0.p;
    }

    static /* synthetic */ MediaCodec v(c r0, MediaCodec r1) {
        r0.p = r1;
        return r1;
    }

    static /* synthetic */ AudioRecord w(c r0) {
        return r0.n;
    }

    static /* synthetic */ AudioRecord x(c r0, AudioRecord r1) {
        r0.n = r1;
        return r1;
    }

    static /* synthetic */ g y(c r0) {
        return r0.f4162k;
    }

    static /* synthetic */ int z(c r0) {
        return r0.v;
    }

    void S(@NonNull h r3) {
        Message r0 = Message.obtain();
        r0.what = 0;
        r0.obj = r3;
        this.f4155d.sendMessage(r0);
    }

    void X() {
        long r0 = System.currentTimeMillis() - this.x;
        Handler r4 = this.f4155d;
        if (r0 <= 1200) goto L5;
        r4.sendEmptyMessage(5);
        return;
    L5:
        r4.sendEmptyMessageDelayed(5, 1200);
    }
}

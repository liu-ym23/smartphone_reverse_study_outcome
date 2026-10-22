package com.bytedance.feedbackerlib.j;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.MediaStore;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.feedbackerlib.Feedbacker;
import com.bytedance.feedbackerlib.activity.DialogActivity;
import com.bytedance.feedbackerlib.activity.FeedbackActivity;
import com.bytedance.feedbackerlib.activity.RequestOverlayWindowPermissionActivity;
import com.bytedance.feedbackerlib.activity.TranslucentOnePixelActivity;
import com.bytedance.feedbackerlib.matisse.internal.entity.Item;
import com.bytedance.feedbackerlib.view.CustomScrollView;
import com.bytedance.feedbackerlib.view.SupportCustomInterceptLinearLayout;
import com.google.android.material.badge.BadgeDrawable;
import java.util.Arrays;
import java.util.Calendar;

/* JADX INFO: loaded from: classes.dex */
public class a {
    private static volatile a E0;
    private static volatile boolean F0;
    private static volatile boolean G0;
    private TextView A;
    private final Context A0;
    private LinearLayout B;
    private final com.bytedance.feedbackerlib.m.u.c B0;
    private TextView C;
    private final ContentObserver C0;
    private View D;
    private final Handler D0;
    private View E;
    private ImageView F;
    private SupportCustomInterceptLinearLayout G;
    private TextView H;
    private ProgressBar I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private SupportCustomInterceptLinearLayout f4052J;
    private TextView K;
    private ProgressBar L;
    private View M;
    private SupportCustomInterceptLinearLayout N;
    private TextView O;
    private ImageView P;
    private TextView Q;
    private Uri R;
    private boolean S;
    private boolean T;
    private int U;
    private int V;
    private int W;
    private int X;
    private int Y;
    private int Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View f4053a;
    private int a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private WindowManager.LayoutParams f4054b;
    private int b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private WindowManager f4055c;
    private int c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.bytedance.feedbackerlib.j.d f4056d;
    private int d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.bytedance.feedbackerlib.j.c f4057e;
    private int e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.bytedance.feedbackerlib.j.e f4058f;
    private int f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private FrameLayout f4059g;
    private int g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private WindowManager.LayoutParams f4060h;
    private int h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private CustomScrollView f4061i;
    private int i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private LinearLayout f4062j;
    private int j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private k0 f4063k;
    private int k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private LinearLayout f4064l;
    private int l0;
    private TextView m;
    private int m0;
    private LinearLayout n;
    private int n0;
    private TextView o;
    private int o0;
    private LinearLayout p;
    private int p0;
    private TextView q;
    private int q0;
    private LinearLayout r;
    private int r0;
    private TextView s;
    private int s0;
    private LinearLayout t;
    private int t0;
    private TextView u;
    private int u0;
    private LinearLayout v;
    private int v0;
    private TextView w;
    private int w0;
    private LinearLayout x;
    private int x0;
    private TextView y;
    private int y0;
    private LinearLayout z;
    private int z0;

    /* JADX INFO: renamed from: com.bytedance.feedbackerlib.j.a$a, reason: collision with other inner class name */
    class C0115a implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f4065a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f4066b;

        C0115a(a r1, int r2) {
            this.f4066b = r1;
            this.f4065a = r2;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r4) {
            a.h(this.f4066b, 1);
            a.j(this.f4066b, false);
            a.k(this.f4066b);
            a.m(this.f4066b).setText(a.l(this.f4066b).g("packUp"));
            if (this.f4065a != 0) goto L5;
            ImageView r5 = a.o(this.f4066b);
            int r1 = com.bytedance.feedbackerlib.d.f4008j;
        L6:
            r5.setImageResource(r1);
            a.c(this.f4066b, true);
            return;
        L5:
            r5 = a.o(this.f4066b);
            r1 = com.bytedance.feedbackerlib.d.f4005g;
            goto L6
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r1) {
        }
    }

    class a0 implements com.bytedance.feedbackerlib.j.c.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f4067a;

        /* JADX INFO: renamed from: com.bytedance.feedbackerlib.j.a$a0$a, reason: collision with other inner class name */
        class RunnableC0116a implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ a0 f4068f;

            RunnableC0116a(a0 r1) {
                this.f4068f = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.C(this.f4068f.f4067a, 2);
                this.f4068f.f4067a.n1();
            }
        }

        class b implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ long f4069f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ a0 f4070g;

            b(a0 r1, long r2) {
                this.f4070g = r1;
                this.f4069f = r2;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.I(this.f4070g.f4067a).setProgress((int) (this.f4069f / 300.0f));
                a.J(this.f4070g.f4067a).setText((this.f4069f / 1000) + "s");
                if (a.L(this.f4070g.f4067a) != null) goto L5;
                return;
            L5:
                if (a.N(this.f4070g.f4067a) == null) goto L9;
                a.L(this.f4070g.f4067a).setText((this.f4069f / 1000) + "s");
                a.N(this.f4070g.f4067a).setProgress((int) (((float) this.f4069f) / 300.0f));
                return;
            }
        }

        class c implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ Uri f4071f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ long f4072g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ a0 f4073h;

            c(a0 r1, Uri r2, long r3) {
                this.f4073h = r1;
                this.f4071f = r2;
                this.f4072g = r3;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.O(this.f4073h.f4067a, 1);
                Uri r0 = this.f4071f;
                if (r0 == null) goto L11;
                a.F(this.f4073h.f4067a, r0);
                a r1 = this.f4073h.f4067a;
                a.Q(r1, a.P(r1), a.E(this.f4073h.f4067a));
                a.R(this.f4073h.f4067a).setText(a.l(this.f4073h.f4067a).h().f4621a.get("sdk_record_feedback"));
                TextView r2 = a.R(this.f4073h.f4067a);
                a r3 = this.f4073h.f4067a;
                r2.setTextSize(1, a.S(r3, a.R(r3).getText().toString(), a.G(this.f4073h.f4067a).getWidth()));
                long r4 = this.f4072g / 1000;
                if (r4 != 0) goto L8;
                r4 = 1;
            L8:
                if (r4 <= 30) goto L10;
                r4 = 30;
            L10:
                a.T(this.f4073h.f4067a).setText(r4 + "s");
                a.T(this.f4073h.f4067a).setVisibility(0);
                a.C(this.f4073h.f4067a, 3);
                return;
            L11:
                a.C(this.f4073h.f4067a, 1);
                Toast.makeText(a.D(this.f4073h.f4067a), a.l(this.f4073h.f4067a).g("sdk32"), 0).show();
            }
        }

        a0(a r1) {
            this.f4067a = r1;
        }

        @Override // com.bytedance.feedbackerlib.j.c.h
        public void a() {
            com.bytedance.feedbackerlib.m.t.a(new RunnableC0116a(this));
        }

        @Override // com.bytedance.feedbackerlib.j.c.h
        public void b(long r2) {
            com.bytedance.feedbackerlib.m.t.a(new b(this, r2));
        }

        @Override // com.bytedance.feedbackerlib.j.c.h
        public void c(long r2, Uri r4) {
            com.bytedance.feedbackerlib.m.t.a(new c(this, r4, r2));
        }
    }

    class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f4074a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f4075b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f4076c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f4077d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f4078e;

        b(a r1, int r2, int r3, int r4, int r5) {
            this.f4078e = r1;
            this.f4074a = r2;
            this.f4075b = r3;
            this.f4076c = r4;
            this.f4077d = r5;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator r3) {
            float r4 = ((Float) r3.getAnimatedValue()).floatValue();
            com.bytedance.feedbackerlib.m.v.a(a.f(this.f4078e), this.f4074a + ((int) (this.f4075b * r4)));
            a.g(this.f4078e).setTranslationY(this.f4076c + (this.f4077d * r4));
        }
    }

    class b0 implements com.bytedance.feedbackerlib.j.e.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f4079a;

        b0(a r1) {
            this.f4079a = r1;
        }

        @Override // com.bytedance.feedbackerlib.j.e.b
        public void a() {
            a.U(this.f4079a);
        }
    }

    class c implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f4080a;

        c(a r1) {
            this.f4080a = r1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r3) {
            a.h(this.f4080a, 0);
            a.j(this.f4080a, false);
            a.k(this.f4080a);
            a.m(this.f4080a).setText(a.l(this.f4080a).g("sdk2"));
            a.o(this.f4080a).setImageResource(com.bytedance.feedbackerlib.d.f4009k);
            a.c(this.f4080a, true);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r1) {
        }
    }

    class c0 implements View.OnTouchListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f4081f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f4082g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f4083h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f4084i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f4085j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f4086k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f4087l;
        final /* synthetic */ a m;

        c0(a r1) {
            this.m = r1;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View r5, MotionEvent r6) {
            if (r6.getAction() != 0) goto L6;
            this.f4082g = (int) r6.getRawX();
            this.f4083h = (int) r6.getRawY();
            this.f4086k = 0;
            this.f4087l = 0;
            this.f4081f = false;
        L48:
            return false;
        L6:
            if (r6.getAction() != 2) goto L13;
            this.f4084i = (int) r6.getRawX();
            int r7 = (int) r6.getRawY();
            this.f4085j = r7;
            this.f4086k = this.f4084i - this.f4082g;
            this.f4087l = r7 - this.f4083h;
            int r8 = ViewConfiguration.get(a.D(this.m)).getScaledTouchSlop();
            if (Math.abs(this.f4086k) < r8) goto L10;
        L11:
            this.f4081f = true;
            this.f4082g = this.f4084i;
            this.f4083h = this.f4085j;
            a.V(this.m).x += this.f4086k;
            WindowManager.LayoutParams r9 = a.V(this.m);
            int r10 = r9.y + this.f4087l;
        L43:
            r9.y = r10;
            a.Y(this.m).updateViewLayout(a.X(this.m), a.V(this.m));
            goto L48
        L10:
            if (Math.abs(this.f4087l) < r8) goto L48;
        L13:
            if (r6.getAction() != 1) goto L48;
            if (this.f4081f == false) goto L45;
            int r11 = a.V(this.m).x;
            r10 = a.V(this.m).y;
            if (a.d(this.m) != 0) goto L23;
            if (r11 < (a.Z(this.m) / 2.0f)) goto L24;
            int r12 = a.Z(this.m) - a.a0(this.m);
            int r1 = a.b0(this.m);
        L26:
            int r13 = r12 - r1;
        L28:
            if (a.d(this.m) != 0) goto L36;
            if (r10 >= a.d0(this.m)) goto L33;
        L37:
            r10 = a.d0(this.m);
        L42:
            a.V(this.m).x = r13;
            r9 = a.V(this.m);
            goto L43
        L33:
            if ((a.f(this.m).getHeight() + r10) <= (a.e0(this.m) - a.f0(this.m))) goto L42;
            int r14 = a.e0(this.m) - a.f0(this.m);
            int r2 = a.f(this.m).getHeight();
        L41:
            r10 = r14 - r2;
            goto L42
        L36:
            if (r10 < a.d0(this.m)) goto L37;
            if ((a.c0(this.m).getHeight() + r10) <= (a.e0(this.m) - a.f0(this.m))) goto L42;
            r14 = a.e0(this.m) - a.f0(this.m);
            r2 = a.c0(this.m).getHeight();
        L24:
            r13 = a.a0(this.m);
            goto L28
        L23:
            if ((r11 + (a.c0(this.m).getWidth() / 2)) < (a.Z(this.m) / 2.0f)) goto L24;
            r12 = a.Z(this.m) - a.a0(this.m);
            r1 = a.c0(this.m).getWidth();
            goto L26
        L45:
            if (a.d(this.m) != 0) goto L47;
            this.m.f1(true);
            goto L48
        L47:
            this.m.f1(false);
            a.B(this.m);
            goto L48
        }
    }

    class d implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f4088f;

        d(a r1) {
            this.f4088f = r1;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r1) {
            a.p(this.f4088f);
        }
    }

    class d0 extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f4089a;

        d0(a r1, Looper r2) {
            this.f4089a = r1;
            super(r2);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message r1) {
            super.handleMessage(r1);
            a.n(this.f4089a, r1);
        }
    }

    class e implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f4090f;

        e(a r1) {
            this.f4090f = r1;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r1) {
            a.p(this.f4090f);
        }
    }

    class e0 implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f4091f;

        e0(a r1) {
            this.f4091f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.y(this.f4091f);
        }
    }

    class f implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f4092f;

        f(a r1) {
            this.f4092f = r1;
        }

        @Override // android.view.View.OnClickListener
        @RequiresApi(api = 21)
        public void onClick(View r1) {
            a.q(this.f4092f);
        }
    }

    class f0 implements ViewTreeObserver.OnGlobalLayoutListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f4093f;

        f0(a r1) {
            this.f4093f = r1;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (a.K(this.f4093f) == false) goto L6;
            a.M(this.f4093f, false);
            a r0 = this.f4093f;
            a.g0(r0, a.W(r0));
            a.h0(this.f4093f);
            return;
        }
    }

    class g implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f4094f;

        g(a r1) {
            this.f4094f = r1;
        }

        @Override // android.view.View.OnClickListener
        @RequiresApi(api = 21)
        public void onClick(View r1) {
            a.q(this.f4094f);
        }
    }

    class g0 implements TranslucentOnePixelActivity.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f4095a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Uri f4096b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ a f4097c;

        g0(a r1, boolean r2, Uri r3) {
            this.f4097c = r1;
            this.f4095a = r2;
            this.f4096b = r3;
        }

        @Override // com.bytedance.feedbackerlib.activity.TranslucentOnePixelActivity.b
        public void onRequestPermissionResult(String[] r3, int[] r4) {
            if (r3.length > 0) goto L6;
            return;
        L6:
            if ("android.permission.READ_EXTERNAL_STORAGE".equals(r3[0]) == true) goto L9;
            return;
        L9:
            if (r4.length > 0) goto L12;
            return;
        L12:
            if (r4[0] == 0) goto L14;
            return;
        L14:
            a.i0(this.f4097c, this.f4095a, this.f4096b);
        }
    }

    class h implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f4098f;

        h(a r1) {
            this.f4098f = r1;
        }

        @Override // android.view.View.OnClickListener
        @RequiresApi(api = 19)
        public void onClick(View r1) {
            a.r(this.f4098f);
        }
    }

    class h0 implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f4099f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f4100g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ a f4101h;

        /* JADX INFO: renamed from: com.bytedance.feedbackerlib.j.a$h0$a, reason: collision with other inner class name */
        class RunnableC0117a implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ h0 f4102f;

            RunnableC0117a(h0 r1) {
                this.f4102f = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.c(this.f4102f.f4101h, true);
                h0 r0 = this.f4102f;
                if (r0.f4100g == false) goto L9;
                int r1 = a.d(r0.f4101h);
                a r2 = this.f4102f.f4101h;
                if (r1 != 0) goto L7;
                r2.m1();
                return;
            L7:
                r2.n1();
                return;
            }
        }

        h0(a r1, String r2, boolean r3) {
            this.f4101h = r1;
            this.f4099f = r2;
            this.f4100g = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.j0(this.f4101h);
            this.f4101h.k1(this.f4099f);
            a.e(this.f4101h).postDelayed(new RunnableC0117a(this), 200);
        }
    }

    class i implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f4103f;

        i(a r1) {
            this.f4103f = r1;
        }

        @Override // android.view.View.OnClickListener
        @RequiresApi(api = 19)
        public void onClick(View r1) {
            a.r(this.f4103f);
        }
    }

    class i0 implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f4104f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ a f4105g;

        i0(a r1, int r2) {
            this.f4105g = r1;
            this.f4104f = r2;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.f(this.f4105g).setY(this.f4104f);
        }
    }

    class j implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f4106f;

        j(a r1) {
            this.f4106f = r1;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r1) {
            a.s(this.f4106f);
        }
    }

    class j0 implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f4107a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f4108b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f4109c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f4110d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f4111e;

        j0(a r1, int r2, int r3, int r4, int r5) {
            this.f4111e = r1;
            this.f4107a = r2;
            this.f4108b = r3;
            this.f4109c = r4;
            this.f4110d = r5;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator r3) {
            float r4 = ((Float) r3.getAnimatedValue()).floatValue();
            com.bytedance.feedbackerlib.m.v.a(a.f(this.f4111e), this.f4107a + ((int) (this.f4108b * r4)));
            a.g(this.f4111e).setTranslationY(this.f4109c + (this.f4110d * r4));
        }
    }

    class k implements com.bytedance.feedbackerlib.m.u.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f4112a;

        k(a r1) {
            this.f4112a = r1;
        }

        @Override // com.bytedance.feedbackerlib.m.u.c
        public void a(com.bytedance.feedbackerlib.m.u.b r1) {
            a.a(this.f4112a, r1);
        }
    }

    private static final class k0 extends GestureDetector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private C0118a f4113a;

        /* JADX INFO: renamed from: com.bytedance.feedbackerlib.j.a$k0$a, reason: collision with other inner class name */
        static class C0118a extends GestureDetector.SimpleOnGestureListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private boolean f4114a;

            C0118a() {
                this.f4114a = false;
            }

            public boolean a() {
                return this.f4114a;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent r1) {
                this.f4114a = false;
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent r1, MotionEvent r2, float r3, float r4) {
                this.f4114a = true;
                return true;
            }
        }

        k0(Context r1, C0118a r2) {
            super(r1, r2);
            this.f4113a = r2;
            setOnDoubleTapListener(null);
        }

        boolean a() {
            C0118a r0 = this.f4113a;
            if (r0 != null) goto L7;
            return false;
        L7:
            return r0.a();
        }
    }

    class l implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f4115f;

        l(a r1) {
            this.f4115f = r1;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r1) {
            a.s(this.f4115f);
        }
    }

    class m implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f4116f;

        m(a r1) {
            this.f4116f = r1;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r1) {
            a.t(this.f4116f);
        }
    }

    class n extends k0.C0118a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f4117b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f4118c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f4119d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f4120e;

        n(a r1) {
            this.f4120e = r1;
            this.f4117b = -1.0f;
            this.f4118c = -1.0f;
            this.f4119d = false;
        }

        @Override // com.bytedance.feedbackerlib.j.a.k0.C0118a, android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent r2) {
            this.f4119d = true;
            this.f4117b = r2.getX();
            this.f4118c = r2.getY();
            return super.onDown(r2);
        }

        @Override // com.bytedance.feedbackerlib.j.a.k0.C0118a, android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent r5, MotionEvent r6, float r7, float r8) {
            if (a.i(this.f4120e) == false) goto L5;
            return false;
        L5:
            if (this.f4119d == false) goto L11;
            int r0 = (int) (r6.getRawX() - this.f4117b);
            int r1 = (int) ((r6.getRawY() - a.u(this.f4120e)) - this.f4118c);
            a.f(this.f4120e).setX(r0);
            a.f(this.f4120e).setY(r1);
            a.v(this.f4120e, r0);
            a.w(this.f4120e, r1);
            return super.onScroll(r5, r6, r7, r8);
        L11:
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent r2) {
            this.f4119d = false;
            return super.onSingleTapUp(r2);
        }
    }

    class o implements CustomScrollView.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f4121a;

        o(a r1) {
            this.f4121a = r1;
        }

        @Override // com.bytedance.feedbackerlib.view.CustomScrollView.a
        public boolean a(MotionEvent r2) {
            a.x(this.f4121a, r2);
            if (a.i(this.f4121a) == false) goto L6;
            return false;
        L6:
            a.z(this.f4121a).onTouchEvent(r2);
            return a.z(this.f4121a).a();
        }
    }

    class p implements View.OnTouchListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f4122f;

        p(a r1) {
            this.f4122f = r1;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View r1, MotionEvent r2) {
            a.x(this.f4122f, r2);
            if (a.i(this.f4122f) == false) goto L7;
            return false;
        L7:
            return a.z(this.f4122f).onTouchEvent(r2);
        }
    }

    class q extends k0.C0118a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private float f4123b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private float f4124c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f4125d;

        q(a r1) {
            this.f4125d = r1;
        }

        @Override // com.bytedance.feedbackerlib.j.a.k0.C0118a, android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent r2) {
            super.onDown(r2);
            this.f4123b = r2.getX();
            this.f4124c = r2.getY();
            return true;
        }

        @Override // com.bytedance.feedbackerlib.j.a.k0.C0118a, android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent r4, MotionEvent r5, float r6, float r7) {
            float r0 = r5.getRawX() - this.f4123b;
            float r1 = (r5.getRawY() - a.u(this.f4125d)) - this.f4124c;
            a.A(this.f4125d).setX(r0);
            a.A(this.f4125d).setY(r1);
            return super.onScroll(r4, r5, r6, r7);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent r2) {
            a.B(this.f4125d);
            return super.onSingleTapUp(r2);
        }
    }

    class r implements SupportCustomInterceptLinearLayout.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ k0 f4126a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f4127b;

        r(a r1, k0 r2) {
            this.f4127b = r1;
            this.f4126a = r2;
        }

        @Override // com.bytedance.feedbackerlib.view.SupportCustomInterceptLinearLayout.a
        public boolean a(MotionEvent r2) {
            a.x(this.f4127b, r2);
            this.f4126a.onTouchEvent(r2);
            return this.f4126a.a();
        }
    }

    class s implements View.OnTouchListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ k0 f4128f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ a f4129g;

        s(a r1, k0 r2) {
            this.f4129g = r1;
            this.f4128f = r2;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View r1, MotionEvent r2) {
            a.x(this.f4129g, r2);
            return this.f4128f.onTouchEvent(r2);
        }
    }

    class t implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f4130f;

        t(a r1) {
            this.f4130f = r1;
        }

        @Override // android.view.View.OnClickListener
        @RequiresApi(api = 19)
        public void onClick(View r5) {
            a.C(this.f4130f, 1);
            a.C(this.f4130f, 0);
            Item r6 = new Item(a.D(this.f4130f), a.E(this.f4130f));
            FeedbackActivity.M0(a.D(this.f4130f), Arrays.asList(new Item[]{r6}));
            if (com.bytedance.feedbackerlib.m.j.h(a.E(this.f4130f)) == false) goto L5;
            String r4 = "screenShot_and_reportBug";
        L6:
            com.bytedance.feedbackerlib.m.r.f(r4, null);
            return;
        L5:
            r4 = "screenRecord_and_reportBug";
            goto L6
        }
    }

    class u implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f4131a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f4132b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f4133c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f4134d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f4135e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f4136f;

        u(a r1, int r2, int r3, int r4, boolean r5, int r6) {
            this.f4136f = r1;
            this.f4131a = r2;
            this.f4132b = r3;
            this.f4133c = r4;
            this.f4134d = r5;
            this.f4135e = r6;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator r4) {
            float r5 = ((Float) r4.getAnimatedValue()).floatValue();
            if (this.f4131a == 0) goto L8;
            if (a.z(this.f4136f).a() == false) goto L8;
            a.f(this.f4136f).setX(this.f4132b + (this.f4131a * r5));
            a r0 = this.f4136f;
            a.v(r0, (int) a.f(r0).getX());
        L8:
            if (this.f4133c != 0) goto L10;
            return;
        L10:
            if (a.z(this.f4136f).a() == false) goto L12;
        L13:
            a.f(this.f4136f).setY(this.f4135e + (this.f4133c * r5));
            a r3 = this.f4136f;
            a.w(r3, (int) a.f(r3).getY());
            return;
        L12:
            if (this.f4134d == true) goto L13;
        }
    }

    class v extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f4137a;

        v(a r1, Handler r2) {
            this.f4137a = r1;
            super(r2);
        }

        @Override // android.database.ContentObserver
        @RequiresApi(api = 16)
        public void onChange(boolean r3, Uri r4) {
            super.onChange(r3, r4);
            if (Feedbacker.isFeedbackFunctionEnabled() == false) goto L6;
            this.f4137a.f1(false);
            a.b(this.f4137a, r3, r4);
            return;
        }
    }

    class w implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f4138a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f4139b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f4140c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f4141d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f4142e;

        w(a r1, int r2, int r3, int r4, int r5) {
            this.f4142e = r1;
            this.f4138a = r2;
            this.f4139b = r3;
            this.f4140c = r4;
            this.f4141d = r5;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator r4) {
            float r5 = ((Float) r4.getAnimatedValue()).floatValue();
            if (this.f4138a == 0) goto L6;
            a.A(this.f4142e).setX(this.f4139b + (this.f4138a * r5));
        L6:
            if (this.f4140c == 0) goto L9;
            a.A(this.f4142e).setY(this.f4141d + (this.f4140c * r5));
            return;
        }
    }

    class x implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f4143a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f4144b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f4145c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f4146d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f4147e;

        x(a r1, int r2, int r3, int r4, int r5) {
            this.f4147e = r1;
            this.f4143a = r2;
            this.f4144b = r3;
            this.f4145c = r4;
            this.f4146d = r5;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator r4) {
            float r5 = ((Float) r4.getAnimatedValue()).floatValue();
            if (this.f4143a == 0) goto L6;
            a.G(this.f4147e).setX(this.f4144b + (this.f4143a * r5));
        L6:
            if (this.f4145c == 0) goto L9;
            a.G(this.f4147e).setY(this.f4146d + (this.f4145c * r5));
            return;
        }
    }

    class y implements com.bytedance.feedbackerlib.j.d.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4148a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f4149b;

        y(a r1, String r2) {
            this.f4149b = r1;
            this.f4148a = r2;
        }

        @Override // com.bytedance.feedbackerlib.j.d.f
        @RequiresApi(api = 21)
        public void a(Uri r2) {
            if (r2 != null) goto L5;
            this.f4149b.k1(this.f4148a);
            Toast.makeText(a.D(this.f4149b), a.l(this.f4149b).g("sdk31"), 0).show();
            return;
        L5:
            a.H(this.f4149b, r2);
        }
    }

    class z implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ a f4150f;

        z(a r1) {
            this.f4150f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f4150f.C0();
        }
    }

    static {
    }

    private a(@NonNull Context r6) {
        this.S = false;
        this.T = true;
        this.U = -1;
        this.V = -1;
        this.W = -1;
        this.X = -1;
        this.B0 = new k(this);
        this.C0 = new v(this, new Handler(Looper.getMainLooper()));
        this.D0 = new d0(this, Looper.getMainLooper());
        Context r2 = r6.getApplicationContext();
        this.A0 = r2;
        this.V = 0;
        this.W = 1;
        Resources r1 = r2.getResources();
        this.e0 = r1.getDimensionPixelSize(com.bytedance.feedbackerlib.c.f3993g);
        this.n0 = r1.getDimensionPixelSize(com.bytedance.feedbackerlib.c.f3994h);
        this.o0 = r1.getDimensionPixelSize(com.bytedance.feedbackerlib.c.f3995i);
        this.v0 = r1.getDimensionPixelSize(com.bytedance.feedbackerlib.c.f3996j);
        this.w0 = r1.getDimensionPixelSize(com.bytedance.feedbackerlib.c.f3997k);
        this.b0 = r1.getDimensionPixelSize(com.bytedance.feedbackerlib.c.o);
        this.c0 = r1.getDimensionPixelSize(com.bytedance.feedbackerlib.c.f3988b);
        this.d0 = r1.getDimensionPixelSize(com.bytedance.feedbackerlib.c.f3998l);
        this.z0 = r1.getDimensionPixelSize(com.bytedance.feedbackerlib.c.f3992f);
        com.bytedance.feedbackerlib.j.e r3 = com.bytedance.feedbackerlib.j.e.e();
        this.f4058f = r3;
        r3.k(new b0(this));
        int r4 = Build.VERSION.SDK_INT;
        if (r4 < 21) goto L5;
        this.f4056d = com.bytedance.feedbackerlib.j.d.s(r2);
    L5:
        if (r4 >= 21) goto L13;
    L9:
        F0();
        G0();
        E0();
        d1();
        if (Feedbacker.isFeedbackFunctionEnabled() == false) goto L15;
        e1();
        return;
    L15:
        return;
    L13:
        this.f4057e = com.bytedance.feedbackerlib.j.c.O(r2);     // Catch: com.bytedance.feedbackerlib.j.c.f -> L8
    L8:
        Toast.makeText(r6, this.f4058f.g("sdk33"), 0).show();
        goto L9
    }

    static /* synthetic */ SupportCustomInterceptLinearLayout A(a r0) {
        return r0.G;
    }

    static /* synthetic */ void B(a r0) {
        r0.c1();
    }

    private void B0(@NonNull Message r2) {
        switch(r2.what) {
            case 1024: goto L10;
            case 1025: goto L8;
            case 1026: goto L6;
            default: goto L14;
        };
    L8:
        int r3 = this.X;
    L9:
        u1(r3);
        return;
    L10:
        o0();
        m1();
        return;
    L14:
        return;
    L6:
        if (this.V != 1) goto L12;
        r3 = 0;
        goto L9
    }

    static /* synthetic */ void C(a r0, int r1) {
        r0.u1(r1);
    }

    static /* synthetic */ Context D(a r0) {
        return r0.A0;
    }

    private void D0() {
        if (N0() == false) goto L5;
    L7:
        ViewTreeObserver r0 = this.f4059g.getViewTreeObserver();
        if (r0.isAlive() == false) goto L11;
        com.bytedance.feedbackerlib.m.u.b(r0, this.B0);
    L11:
        if (F0 == true) goto L13;
        WindowManager r1 = this.f4055c;
        View r2 = this.f4059g;
    L16:
        r1.removeView(r2);
        return;
    L13:
        if (O0() == false) goto L18;
        r1 = this.f4055c;
        r2 = this.f4053a;
        goto L16
    L18:
        return;
    L5:
        if (F0 == true) goto L7;
    }

    static /* synthetic */ Uri E(a r0) {
        return r0.R;
    }

    private void E0() {
        this.f4059g = (FrameLayout) LayoutInflater.from(this.A0).inflate(com.bytedance.feedbackerlib.f.m, null);
        this.f4060h = y0();
        this.f4061i = (CustomScrollView) this.f4059g.findViewById(com.bytedance.feedbackerlib.e.k0);
        LinearLayout r0 = (LinearLayout) this.f4059g.findViewById(com.bytedance.feedbackerlib.e.H);
        this.f4062j = r0;
        this.f4064l = (LinearLayout) r0.findViewById(com.bytedance.feedbackerlib.e.O);
        this.m = (TextView) this.f4062j.findViewById(com.bytedance.feedbackerlib.e.h1);
        this.n = (LinearLayout) this.f4062j.findViewById(com.bytedance.feedbackerlib.e.N);
        this.o = (TextView) this.f4062j.findViewById(com.bytedance.feedbackerlib.e.g1);
        this.p = (LinearLayout) this.f4062j.findViewById(com.bytedance.feedbackerlib.e.L);
        this.q = (TextView) this.f4062j.findViewById(com.bytedance.feedbackerlib.e.e1);
        this.r = (LinearLayout) this.f4062j.findViewById(com.bytedance.feedbackerlib.e.M);
        this.s = (TextView) this.f4062j.findViewById(com.bytedance.feedbackerlib.e.f1);
        this.t = (LinearLayout) this.f4062j.findViewById(com.bytedance.feedbackerlib.e.E);
        this.u = (TextView) this.f4062j.findViewById(com.bytedance.feedbackerlib.e.G0);
        this.v = (LinearLayout) this.f4062j.findViewById(com.bytedance.feedbackerlib.e.C);
        this.w = (TextView) this.f4062j.findViewById(com.bytedance.feedbackerlib.e.B0);
        this.x = (LinearLayout) this.f4062j.findViewById(com.bytedance.feedbackerlib.e.B);
        this.y = (TextView) this.f4062j.findViewById(com.bytedance.feedbackerlib.e.A0);
        this.z = (LinearLayout) this.f4062j.findViewById(com.bytedance.feedbackerlib.e.z);
        this.A = (TextView) this.f4062j.findViewById(com.bytedance.feedbackerlib.e.y0);
        this.B = (LinearLayout) this.f4062j.findViewById(com.bytedance.feedbackerlib.e.A);
        this.C = (TextView) this.f4062j.findViewById(com.bytedance.feedbackerlib.e.z0);
        this.D = this.f4062j.findViewById(com.bytedance.feedbackerlib.e.n1);
        this.E = this.f4062j.findViewById(com.bytedance.feedbackerlib.e.m1);
        this.F = (ImageView) this.f4062j.findViewById(com.bytedance.feedbackerlib.e.v);
        this.f4064l.setOnClickListener(new d(this));
        this.v.setOnClickListener(new e(this));
        this.n.setOnClickListener(new f(this));
        this.x.setOnClickListener(new g(this));
        this.p.setOnClickListener(new h(this));
        this.z.setOnClickListener(new i(this));
        this.r.setOnClickListener(new j(this));
        this.B.setOnClickListener(new l(this));
        this.f4062j.findViewById(com.bytedance.feedbackerlib.e.F).setOnClickListener(new m(this));
        this.f4062j.findViewById(com.bytedance.feedbackerlib.e.G).setVisibility(8);
        this.f4063k = new k0(this.A0, new n(this));
        this.f4061i.setOnInterceptTouchEventListener(new o(this));
        this.f4061i.setOnTouchListener(new p(this));
        SupportCustomInterceptLinearLayout r1 = (SupportCustomInterceptLinearLayout) this.f4059g.findViewById(com.bytedance.feedbackerlib.e.I);
        this.G = r1;
        this.H = (TextView) r1.findViewById(com.bytedance.feedbackerlib.e.U0);
        this.I = (ProgressBar) this.G.findViewById(com.bytedance.feedbackerlib.e.U);
        k0 r2 = new k0(this.A0, new q(this));
        this.G.setOnInterceptTouchEventListener(new r(this, r2));
        this.G.setOnTouchListener(new s(this, r2));
        SupportCustomInterceptLinearLayout r3 = (SupportCustomInterceptLinearLayout) this.f4059g.findViewById(com.bytedance.feedbackerlib.e.D);
        this.N = r3;
        this.O = (TextView) r3.findViewById(com.bytedance.feedbackerlib.e.l0);
        this.P = (ImageView) this.N.findViewById(com.bytedance.feedbackerlib.e.s);
        this.Q = (TextView) this.N.findViewById(com.bytedance.feedbackerlib.e.i1);
        this.N.setOnClickListener(new t(this));
    }

    static /* synthetic */ Uri F(a r0, Uri r1) {
        r0.R = r1;
        return r1;
    }

    private void F0() {
        this.Y = -1;
        this.Z = -1;
        if (t0() == true) goto L5;
        return;
    L5:
        DisplayMetrics r0 = new DisplayMetrics();
        this.f4055c.getDefaultDisplay().getMetrics(r0);
        this.Y = r0.widthPixels;
        this.Z = r0.heightPixels;
    }

    static /* synthetic */ SupportCustomInterceptLinearLayout G(a r0) {
        return r0.N;
    }

    private void G0() {
        Resources r0 = this.A0.getResources();
        int r1 = r0.getIdentifier("status_bar_height", "dimen", "android");
        if (r1 <= 0) goto L5;
        int r2 = r0.getDimensionPixelSize(r1);
    L6:
        this.a0 = r2;
        return;
    L5:
        r2 = 80;
        goto L6
    }

    static /* synthetic */ void H(a r0, Uri r1) {
        r0.b1(r1);
    }

    private boolean H0() {
        if (com.bytedance.feedbackerlib.model.a.I().C() == 1) goto L6;
        return false;
    L6:
        if (Feedbacker.isFloatWindowEnable() == true) goto L9;
        return false;
    L9:
        if (Feedbacker.isFirstLaunchAfterUpgrade() == false) goto L12;
        return true;
    L12:
        if (Calendar.getInstance().get(7) == 1) goto L16;
        if (com.bytedance.feedbackerlib.m.q.a.f4298i.a(false) == false) goto L16;
        return false;
    L16:
        return true;
    }

    static /* synthetic */ ProgressBar I(a r0) {
        return r0.I;
    }

    private boolean I0(String r7) {
        com.bytedance.feedbackerlib.m.c.b("FloatWindowManagerExt show", "isFloatWindowCloudShow() is invoked");
        if (Feedbacker.isFeedbackFunctionEnabled() == true) goto L7;
        com.bytedance.feedbackerlib.m.c.b("FloatWindowManagerExt show", "Feedback function is closed");
        com.bytedance.feedbackerlib.m.r.h(r7, "Feedback function is closed", new String[0]);
        return false;
    L7:
        if (H0() == true) goto L13;
        if (K0() == true) goto L13;
        com.bytedance.feedbackerlib.m.c.b("FloatWindowManagerExt show", "isDailyFeedbackEnabled() is " + H0() + ", isLimitedFeedbackEnabled() is " + K0());
        com.bytedance.feedbackerlib.m.r.h(r7, "isFloatWindowCloudShow is invoked", new String[]{"isDailyFeedbackEnabled() is " + H0() + ", isLimitedFeedbackEnabled() is " + K0()});
        return false;
    L13:
        if (com.bytedance.feedbackerlib.model.a.I().S() == true) goto L16;
        com.bytedance.feedbackerlib.m.c.b("FloatWindowManagerExt show", "FeedbackModel.getInstance().isSSOVerified() is false");
        com.bytedance.feedbackerlib.m.r.h(r7, "FeedbackModel.getInstance().isSSOVerified() is false", new String[0]);
        return false;
    L16:
        com.bytedance.feedbackerlib.m.c.b("FloatWindowManagerExt show", "isApplicationForegroundLogic() is " + Feedbacker.isApplicationForegroundLogic());
        com.bytedance.feedbackerlib.m.r.h(r7, "isApplicationForegroundLogic() is " + Feedbacker.isApplicationForegroundLogic(), new String[0]);
        return Feedbacker.isApplicationForegroundLogic();
    }

    static /* synthetic */ TextView J(a r0) {
        return r0.H;
    }

    static /* synthetic */ boolean K(a r0) {
        return r0.T;
    }

    private boolean K0() {
        if (Build.VERSION.SDK_INT < 17) goto L15;
        ContentResolver r1 = Feedbacker.getApplicationContext().getContentResolver();
        if (r1 == null) goto L7;
        String r2 = Settings.Global.getString(r1, "feedbacker_force_float_window_token");
    L9:
        if (TextUtils.isEmpty(r2) == true) goto L15;
        if ("default_force_float_window_token".equals(r2) == false) goto L15;
        return true;
    L7:
        r2 = "";
    L15:
        return com.bytedance.feedbackerlib.model.a.I().R();
    }

    static /* synthetic */ TextView L(a r0) {
        return r0.K;
    }

    public static boolean L0() {
        if (Build.VERSION.SDK_INT < 31) goto L5;
        return true;
    L5:
        return false;
    }

    static /* synthetic */ boolean M(a r0, boolean r1) {
        r0.T = r1;
        return r1;
    }

    private boolean M0() {
        if (this.Y > 0) goto L5;
    L7:
        return false;
    L5:
        if (this.Z <= 0) goto L7;
        return true;
    }

    static /* synthetic */ ProgressBar N(a r0) {
        return r0.L;
    }

    static /* synthetic */ int O(a r0, int r1) {
        r0.X = r1;
        return r1;
    }

    static /* synthetic */ ImageView P(a r0) {
        return r0.P;
    }

    private Rect P0(@NonNull String r3, float r4) {
        Paint r2 = new Paint();
        Rect r0 = new Rect();
        r2.setTextSize(r4);
        r2.getTextBounds(r3, 0, r3.length(), r0);
        return r0;
    }

    static /* synthetic */ void Q(a r0, ImageView r1, Uri r2) {
        r0.g1(r1, r2);
    }

    private void Q0(com.bytedance.feedbackerlib.m.u.b r6) {
        int r0 = this.V;
        if (r0 != 0) goto L5;
    L11:
        int r1 = (int) this.f4061i.getX();
        int r2 = (int) this.f4061i.getY();
        int r3 = this.f4061i.getWidth() + r1;
        int r5 = this.f4061i.getHeight();
    L12:
        r6.e(new Region(r1, r2, r3, r5 + r2));
        r6.d(3);
        return;
    L5:
        if (r0 == 1) goto L11;
        if (r0 != 3) goto L9;
        r1 = (int) this.N.getX();
        r2 = (int) this.N.getY();
        r3 = this.N.getWidth() + r1;
        SupportCustomInterceptLinearLayout r7 = this.N;
    L10:
        r5 = r7.getHeight();
        goto L12
    L9:
        r1 = (int) this.G.getX();
        r2 = (int) this.G.getY();
        r3 = this.G.getWidth() + r1;
        r7 = this.G;
        goto L10
    }

    static /* synthetic */ TextView R(a r0) {
        return r0.O;
    }

    private void R0(boolean r4, Uri r5) {
        if (Build.VERSION.SDK_INT >= 20) goto L6;
        return;
    L6:
        if (H0() == false) goto L8;
    L10:
        if (r5 != null) goto L13;
        return;
    L13:
        if (r5.toString().contains(MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString()) == true) goto L15;
        return;
    L15:
        PackageManager r0 = this.A0.getPackageManager();
        if (r0 != null) goto L19;
        return;
    L19:
        if (r0.checkPermission("android.permission.READ_EXTERNAL_STORAGE", this.A0.getPackageName()) != 0) goto L21;
        V0(r4, r5);
        return;
    L21:
        TranslucentOnePixelActivity.D(this.A0, new g0(this, r4, r5), new String[]{"android.permission.READ_EXTERNAL_STORAGE"});
        return;
    L8:
        if (K0() == true) goto L10;
    }

    static /* synthetic */ int S(a r0, String r1, int r2) {
        return r0.v0(r1, r2);
    }

    @RequiresApi(api = 19)
    private void S0() {
        if (this.S == false) goto L6;
        return;
    L6:
        if (this.V != 1) goto L8;
        u1(0);
    L8:
        FeedbackActivity.M0(this.A0, null);
        com.bytedance.feedbackerlib.m.r.f("report_bug", null);
    }

    static /* synthetic */ TextView T(a r0) {
        return r0.Q;
    }

    private void T0() {
        int r0 = this.V;
        if (r0 != 0) goto L5;
        u1(1);
        return;
    L5:
        if (r0 != 1) goto L9;
        u1(0);
        return;
    }

    static /* synthetic */ void U(a r0) {
        r0.d1();
    }

    private void U0() {
        DialogActivity.e(this.A0);
        if (this.V != 1) goto L6;
        u1(0);
        return;
    }

    static /* synthetic */ WindowManager.LayoutParams V(a r0) {
        return r0.f4054b;
    }

    private void V0(boolean r11, Uri r12) {
        int r13 = this.V;
        if (r13 != 0) goto L5;
    L9:
        ContentResolver r14 = this.A0.getContentResolver();
        if (r14 != null) goto L58;
        return;
    L58:
        Cursor r7 = r14.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[0], null, null, "date_added desc limit 1");     // Catch: Throwable -> L54
        if (r7 != null) goto L57;
        return;
    L57:
    L51:
        th = move-exception;
        r7.close();
        throw th;
    L16:
        if (r7.moveToFirst() == true) goto L19;
        r7.close();
        return;
    L19:
        String r0 = r7.getString(r7.getColumnIndex("_display_name"));     // Catch: Throwable -> L51
        if (TextUtils.isEmpty(r0) == false) goto L23;
        r7.close();
        return;
    L23:
        String r1 = r0.toLowerCase();     // Catch: Throwable -> L51
        if (r1.contains("screen") == true) goto L26;
    L49:
        r7.close();
        return;
    L26:
        if (r1.contains("shot") == false) goto L49;
        if (r7.getInt(r7.getColumnIndex("width")) == this.Y) goto L32;
        r7.close();
        return;
    L32:
        long r8 = r7.getLong(r7.getColumnIndex("date_added"));     // Catch: Throwable -> L51
        Cursor r15 = r14.query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, new String[0], null, null, "date_added desc limit 1");     // Catch: Throwable -> L51
        if (r15 != null) goto L55;
    L46:
        int r16 = r7.getColumnIndex("_id");     // Catch: Throwable -> L51
        b1(ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, r7.getLong(r16)));     // Catch: Throwable -> L51
        r7.close();
        return;
    L55:
    L43:
        th = move-exception;
        r15.close();     // Catch: Throwable -> L51
        throw th;     // Catch: Throwable -> L51
    L35:
        if (r15.moveToFirst() == false) goto L42;
    L38:
        if (r15.getLong(r15.getColumnIndex("date_added")) <= r8) goto L42;
        r15.close();     // Catch: Throwable -> L51
        r7.close();
        return;
    L42:
        r15.close();     // Catch: Throwable -> L51
    L54:
        return;
    L5:
        if (r13 == 3) goto L9;
        if (r13 == 1) goto L9;
    }

    static /* synthetic */ int W(a r0) {
        return r0.W;
    }

    private void W0() {
        this.D0.removeMessages(1026);
        this.D0.removeMessages(1024);
        p0();
    }

    static /* synthetic */ View X(a r0) {
        return r0.f4053a;
    }

    private void X0() {
        this.D0.removeMessages(1024);
        this.D0.sendEmptyMessageDelayed(1024, WsConstants.EXIT_DELAY_TIME);
        this.D0.removeMessages(1026);
        this.D0.sendEmptyMessageDelayed(1026, 2500);
        x1(false);
    }

    static /* synthetic */ WindowManager Y(a r0) {
        return r0.f4055c;
    }

    static /* synthetic */ int Z(a r0) {
        return r0.Y;
    }

    @RequiresApi(api = 21)
    private void Z0() {
        if (this.S == false) goto L5;
        return;
    L5:
        this.D0.removeMessages(InputDeviceCompat.SOURCE_GAMEPAD);
        this.D0.removeMessages(1026);
        this.f4057e.S(new a0(this));
        com.bytedance.feedbackerlib.m.r.f("screen_record", null);
        com.bytedance.feedbackerlib.m.r.a("click", "recording");
    }

    static /* synthetic */ void a(a r0, com.bytedance.feedbackerlib.m.u.b r1) {
        r0.Q0(r1);
    }

    static /* synthetic */ int a0(a r0) {
        return r0.d0;
    }

    private void a1() {
        String r0 = "ScreenShotClick->" + System.currentTimeMillis();
        if (this.S == false) goto L5;
        return;
    L5:
        C0();
        this.D0.removeMessages(InputDeviceCompat.SOURCE_GAMEPAD);
        this.D0.removeMessages(1026);
        com.bytedance.feedbackerlib.m.r.f("screen_shot", null);
        com.bytedance.feedbackerlib.m.r.a("click", "screenshot");
        this.f4056d.n(new y(this, r0));
    }

    static /* synthetic */ void b(a r0, boolean r1, Uri r2) {
        r0.R0(r1, r2);
    }

    static /* synthetic */ int b0(a r0) {
        return r0.e0;
    }

    private void b1(Uri r5) {
        String r0 = "ScreenShotSucceed->" + System.currentTimeMillis();
        if (Feedbacker.getApplicationContext() != null) goto L6;
        k1(r0);
        return;
    L6:
        this.R = r5;
        g1(this.P, r5);
        this.O.setText(this.f4058f.h().f4621a.get("sdk_screenshot_feedback"));
        TextView r6 = this.O;
        r6.setTextSize(1, v0(r6.getText().toString(), this.N.getWidth()));
        this.Q.setVisibility(8);
        int r7 = this.V;
        if (r7 == 3) goto L9;
        this.X = r7;
    L9:
        u1(3);
        if (I0(r0) == false) goto L12;
        k1(r0);
        return;
    L12:
        w0();
    }

    static /* synthetic */ void c(a r0, boolean r1) {
        r0.x1(r1);
    }

    static /* synthetic */ SupportCustomInterceptLinearLayout c0(a r0) {
        return r0.f4052J;
    }

    private void c1() {
        this.f4057e.X();
    }

    static /* synthetic */ int d(a r0) {
        return r0.U;
    }

    static /* synthetic */ int d0(a r0) {
        return r0.b0;
    }

    private void d1() {
        this.T = true;
        this.u.setText(this.f4058f.g("sdk2"));
        this.o.setText(this.f4058f.g("sdk3"));
        this.m.setText(this.f4058f.g("sdk4"));
        this.q.setText(this.f4058f.g("sdk2"));
        this.s.setText(this.f4058f.g("hide_float_window"));
        this.C.setText(this.f4058f.g("hide_float_window"));
        this.w.setText(this.f4058f.g("sdk4"));
        this.y.setText(this.f4058f.g("sdk3"));
        this.A.setText(this.f4058f.g("sdk2"));
        float r1 = v0(this.u.getText().toString(), this.z0);
        this.u.setTextSize(1, r1);
        this.o.setTextSize(1, r1);
        this.m.setTextSize(1, r1);
        this.q.setTextSize(1, r1);
        this.s.setTextSize(1, r1);
        this.C.setTextSize(1, r1);
        this.w.setTextSize(1, r1);
        this.y.setTextSize(1, r1);
        this.A.setTextSize(1, r1);
    }

    static /* synthetic */ Handler e(a r0) {
        return r0.D0;
    }

    static /* synthetic */ int e0(a r0) {
        return r0.Z;
    }

    private void e1() {
        this.A0.getContentResolver().registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, this.C0);     // Catch: SecurityException -> L5
        return;
    L5:
        e = move-exception;
        com.bytedance.feedbackerlib.m.r.k("SecurityException", "registerSystemScreenShotListener fails", new String[]{"exception=" + e.toString()});
    }

    static /* synthetic */ CustomScrollView f(a r0) {
        return r0.f4061i;
    }

    static /* synthetic */ int f0(a r0) {
        return r0.c0;
    }

    static /* synthetic */ LinearLayout g(a r0) {
        return r0.f4062j;
    }

    static /* synthetic */ void g0(a r0, int r1) {
        r0.l0(r1);
    }

    private void g1(@NonNull ImageView r2, @NonNull Uri r3) {
        d.b.k.a.t r1 = d.b.k.a.q.f(r3);
        r1.a(d.b.k.a.u.f14079l);
        d.b.k.a.e.b r4 = new d.b.k.a.e.b();
        r4.j(5.0f);
        r1.e(r4.i());
        r1.d("FeedbackActivity");
        r1.S(r2);
        r1.g();
    }

    static /* synthetic */ int h(a r0, int r1) {
        r0.V = r1;
        return r1;
    }

    static /* synthetic */ void h0(a r0) {
        r0.v1();
    }

    public static void h1(boolean r0) {
        G0 = r0;
    }

    static /* synthetic */ boolean i(a r0) {
        return r0.S;
    }

    static /* synthetic */ void i0(a r0, boolean r1, Uri r2) {
        r0.V0(r1, r2);
    }

    private void i1(@NonNull View r1, int r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        LinearLayout.LayoutParams r0 = (LinearLayout.LayoutParams) r1.getLayoutParams();
        r0.bottomMargin = r2;
        r1.setLayoutParams(r0);
    }

    static /* synthetic */ boolean j(a r0, boolean r1) {
        r0.S = r1;
        return r1;
    }

    static /* synthetic */ void j0(a r0) {
        r0.F0();
    }

    private void j1(@NonNull View r1, int r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        LinearLayout.LayoutParams r0 = (LinearLayout.LayoutParams) r1.getLayoutParams();
        r0.topMargin = r2;
        r1.setLayoutParams(r0);
    }

    static /* synthetic */ void k(a r0) {
        r0.w1();
    }

    private int k0() {
        int r0 = this.V;
        if (r0 == 0) goto L10;
        if (r0 == 1) goto L10;
        int r3 = this.X;
        if (r3 == 0) goto L10;
        if (r3 == 1) goto L10;
        return -1;
    L10:
        if (r0 != 0) goto L12;
    L28:
        int r1 = this.f0 + ((int) this.f4061i.getY());
        int r2 = this.W;
        int r4 = r2 & 1;
        int r5 = r2 & 4;
        if (r4 <= 0) goto L33;
        if (r5 <= 0) goto L32;
        int r6 = this.p0;
    L36:
        if (r6 >= r1) goto L38;
        return 0;
    L38:
        return 1;
    L32:
        r6 = this.g0;
        goto L36
    L33:
        if (r5 <= 0) goto L35;
        r6 = this.q0;
        goto L36
    L35:
        r6 = this.h0;
        goto L36
    L12:
        if (this.X == 0) goto L28;
        int r7 = (int) this.f4062j.getTranslationY();
        if (r7 != this.k0) goto L18;
        return 0;
    L18:
        if (r7 != this.m0) goto L20;
    L27:
        return 1;
    L20:
        if (r7 == this.l0) goto L27;
        if (r7 == this.u0) goto L27;
        if (r7 == this.t0) goto L27;
        return -1;
    }

    static /* synthetic */ com.bytedance.feedbackerlib.j.e l(a r0) {
        return r0.f4058f;
    }

    private void l0(int r4) {
        Resources r0 = this.A0.getResources();
        this.f0 = this.t.getHeight() + (r0.getDimensionPixelSize(com.bytedance.feedbackerlib.c.f3990d) * 2);
        this.k0 = 0;
        if ((r4 & 4) <= 0) goto L5;
        this.g0 = (this.t.getTop() + this.t.getHeight()) + this.w0;
        int r5 = -this.t.getTop();
        int r1 = this.w0;
    L6:
        this.l0 = r5 + r1;
        int r6 = this.g0;
        this.h0 = r6;
        this.p0 = r6;
        this.q0 = r6;
        int r7 = this.l0;
        this.m0 = r7;
        this.t0 = r7;
        this.u0 = r7;
        int r8 = (-this.t.getTop()) + r0.getDimensionPixelSize(com.bytedance.feedbackerlib.c.f3991e);
        this.i0 = r8;
        this.j0 = r8;
        this.r0 = r8;
        this.s0 = r8;
        return;
    L5:
        this.g0 = (this.t.getTop() + this.t.getHeight()) + this.o0;
        r5 = -this.t.getTop();
        r1 = this.o0;
        goto L6
    }

    private void l1(String r6) {
        if (N0() == true) goto L5;
    L8:
        w1();
        ViewTreeObserver r0 = this.f4059g.getViewTreeObserver();
        if (r0.isAlive() == true) goto L12;
        Toast.makeText(this.A0, "observer is not alive", 0).show();
        return;
    L12:
        com.bytedance.feedbackerlib.m.u.b(r0, this.B0);
        com.bytedance.feedbackerlib.m.u.a(r0, this.B0);
        r0.addOnGlobalLayoutListener(new f0(this));
        if (F0 == true) goto L15;
        WindowManager r1 = this.f4055c;
        View r4 = this.f4059g;
        WindowManager.LayoutParams r5 = this.f4060h;
    L21:
        r1.addView(r4, r5);
    L22:
        com.bytedance.feedbackerlib.m.c.b("FloatWindowManagerExt show", "mWindowManager.addView");
        com.bytedance.feedbackerlib.m.r.h(r6, "showFloatWindowRootView() is Shown()", new String[0]);
        return;
    L15:
        if (this.f4053a != null) goto L18;
        r0();
    L18:
        if (O0() == true) goto L22;
        r1 = this.f4055c;
        r4 = this.f4053a;
        r5 = this.f4054b;
        goto L21
    L5:
        if (F0 == true) goto L8;
        com.bytedance.feedbackerlib.m.c.b("FloatWindowManagerExt show", "showFloatWindowRootView() is Shown()");
        com.bytedance.feedbackerlib.m.r.h(r6, "showFloatWindowRootView() is Shown()", new String[0]);
    }

    static /* synthetic */ TextView m(a r0) {
        return r0.u;
    }

    private int m0() {
        if (K0() == false) goto L6;
        int r0 = 2;
    L10:
        if (this.Y < this.Z) goto L13;
        return r0 | 4;
    L13:
        return r0 | 8;
    L6:
        if (H0() == false) goto L8;
        r0 = 1;
        goto L10
    L8:
        r0 = 0;
        goto L10
    }

    static /* synthetic */ void n(a r0, Message r1) {
        r0.B0(r1);
    }

    private void n0(int r2, int r3) {
        FrameLayout.LayoutParams r0 = (FrameLayout.LayoutParams) this.f4061i.getLayoutParams();
        r0.gravity = r2;
        this.f4061i.setLayoutParams(r0);
        this.f4061i.post(new i0(this, r3));
    }

    static /* synthetic */ ImageView o(a r0) {
        return r0.F;
    }

    private void o0() {
        if (this.V != 0) goto L6;
        this.f4061i.setBackgroundResource(com.bytedance.feedbackerlib.d.f4000b);
        return;
    }

    private void o1() {
        if (k0() != (-1)) goto L5;
        return;
    L5:
        int r3 = this.f4061i.getHeight();
        int r5 = (int) this.f4062j.getTranslationY();
        int r4 = this.f0 - r3;
        int r0 = this.W;
        int r1 = r0 & 1;
        int r2 = r0 & 4;
        if (r1 <= 0) goto L10;
        if (r2 <= 0) goto L9;
        int r6 = this.r0;
    L13:
        int r7 = r6 - r5;
        ValueAnimator r8 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r8.setDuration(256);
        r8.addUpdateListener(new b(this, r3, r4, r5, r7));
        r8.addListener(new c(this));
        r8.start();
        return;
    L9:
        r6 = this.i0;
        goto L13
    L10:
        if (r2 <= 0) goto L12;
        r6 = this.s0;
        goto L13
    L12:
        r6 = this.j0;
        goto L13
    }

    static /* synthetic */ void p(a r0) {
        r0.a1();
    }

    private void p0() {
        this.f4061i.setBackgroundResource(com.bytedance.feedbackerlib.d.f3999a);
    }

    private void p1() {
        j1(this.f4064l, this.w0);
        j1(this.n, this.v0);
        j1(this.p, this.v0);
        j1(this.D, this.w0);
        j1(this.r, this.w0);
        j1(this.B, this.v0);
        j1(this.E, this.w0);
        j1(this.v, this.w0);
        j1(this.x, this.v0);
        j1(this.z, this.v0);
        i1(this.z, this.w0);
    }

    static /* synthetic */ void q(a r0) {
        r0.Z0();
    }

    private boolean q0(String r3) {
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        return true;
    L5:
        if (com.bytedance.feedbackerlib.m.w.b(this.A0) == true) goto L11;
        RequestOverlayWindowPermissionActivity.j(this.A0, RequestOverlayWindowPermissionActivity.e.f3977f, r3);
        return false;
    L11:
        return true;
    }

    private void q1() {
        this.r.setVisibility(8);
        this.B.setVisibility(8);
    }

    static /* synthetic */ void r(a r0) {
        r0.S0();
    }

    private void r0() {
        if (this.f4054b != null) goto L10;
        WindowManager.LayoutParams r0 = new WindowManager.LayoutParams();
        this.f4054b = r0;
        if (Build.VERSION.SDK_INT < 26) goto L7;
        int r1 = 2038;
    L8:
        r0.type = r1;
        r0.format = 1;
        r0.flags = 40;
        r0.width = -2;
        r0.height = -2;
        r0.gravity = BadgeDrawable.TOP_START;
        goto L10
    L7:
        r1 = 2002;
    L10:
        if (this.U != 0) goto L12;
        WindowManager.LayoutParams r2 = this.f4054b;
        r2.x = (int) this.f4061i.getX();
        WindowManager.LayoutParams r3 = this.f4054b;
        float r4 = this.f4061i.getY();
    L13:
        r3.y = (int) r4;
        if (this.f4053a != null) goto L17;
        View r5 = LayoutInflater.from(this.A0).inflate(com.bytedance.feedbackerlib.f.s, null);
        this.f4053a = r5;
        this.M = r5.findViewById(com.bytedance.feedbackerlib.e.f4011J);
        SupportCustomInterceptLinearLayout r6 = (SupportCustomInterceptLinearLayout) this.f4053a.findViewById(com.bytedance.feedbackerlib.e.K);
        this.f4052J = r6;
        this.K = (TextView) r6.findViewById(com.bytedance.feedbackerlib.e.Y0);
        this.L = (ProgressBar) this.f4052J.findViewById(com.bytedance.feedbackerlib.e.i0);
        this.f4053a.setOnTouchListener(new c0(this));
        return;
    L17:
        return;
    L12:
        WindowManager.LayoutParams r7 = this.f4054b;
        r7.x = (int) this.G.getX();
        r3 = this.f4054b;
        r4 = this.G.getY();
        goto L13
    }

    private void r1() {
        this.r.setVisibility(0);
        this.B.setVisibility(0);
    }

    static /* synthetic */ void s(a r0) {
        r0.U0();
    }

    private void s0(MotionEvent r2) {
        if (r2.getAction() != 0) goto L6;
        W0();
    L6:
        if (r2.getAction() != 1) goto L9;
        X0();
        return;
    }

    private void s1() {
        j1(this.f4064l, this.o0);
        j1(this.n, this.n0);
        j1(this.p, this.n0);
        j1(this.D, this.o0);
        j1(this.r, this.o0);
        j1(this.B, this.n0);
        j1(this.E, this.o0);
        j1(this.v, this.o0);
        j1(this.x, this.n0);
        j1(this.z, this.n0);
        i1(this.z, this.o0);
    }

    static /* synthetic */ void t(a r0) {
        r0.T0();
    }

    private boolean t0() {
        if (this.f4055c == null) goto L5;
        return true;
    L5:
        WindowManager r0 = (WindowManager) this.A0.getSystemService("window");
        this.f4055c = r0;
        if (r0 != null) goto L10;
        return false;
    L10:
        return true;
    }

    private void t1(int r4) {
        if (this.W != r4) goto L5;
        return;
    L5:
        if (this.S == true) goto L36;
        this.T = true;
        int r0 = r4 & 2;
        if (r0 <= 0) goto L11;
        q1();
    L13:
        int r1 = r4 & 4;
        if (r1 <= 0) goto L17;
        p1();
    L19:
        if (r0 <= 0) goto L27;
        if (r1 <= 0) goto L24;
        LinearLayout r2 = this.t;
        int r3 = this.w0;
    L22:
        j1(r2, r3);
    L33:
        this.W = r4;
        return;
    L24:
        if ((r4 & 8) <= 0) goto L33;
        r2 = this.t;
        r3 = this.o0;
        goto L22
    L27:
        if ((r4 & 1) <= 0) goto L33;
        if (r1 <= 0) goto L31;
        r2 = this.t;
        r3 = this.v0;
        goto L22
    L31:
        if ((r4 & 8) <= 0) goto L33;
        r2 = this.t;
        r3 = this.n0;
        goto L22
    L17:
        if ((r4 & 8) <= 0) goto L19;
        s1();
        goto L19
    L11:
        if ((r4 & 1) <= 0) goto L13;
        r1();
        goto L13
    }

    static /* synthetic */ int u(a r0) {
        return r0.a0;
    }

    private void u0() {
        int r0 = k0();
        if (r0 != (-1)) goto L5;
        return;
    L5:
        int r1 = (int) this.f4061i.getY();
        int r5 = this.f4061i.getHeight();
        int r7 = (int) this.f4062j.getTranslationY();
        if (r0 != 0) goto L16;
        n0(BadgeDrawable.BOTTOM_END, r1);
        int r2 = this.W;
        int r3 = r2 & 1;
        int r4 = r2 & 4;
        if (r3 <= 0) goto L12;
        if (r4 <= 0) goto L11;
        int r6 = this.p0;
    L15:
        int r8 = this.k0;
    L24:
        ValueAnimator r9 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r9.setDuration(256);
        r9.addUpdateListener(new j0(this, r5, r6 - r5, r7, r8 - r7));
        r9.addListener(new C0115a(this, r0));
        r9.start();
        return;
    L11:
        r6 = this.g0;
        goto L15
    L12:
        if (r4 <= 0) goto L14;
        r6 = this.q0;
        goto L15
    L14:
        r6 = this.h0;
        goto L15
    L16:
        n0(BadgeDrawable.TOP_END, r1);
        int r10 = this.W;
        int r11 = r10 & 1;
        int r12 = r10 & 4;
        if (r11 <= 0) goto L21;
        if (r12 <= 0) goto L20;
        r6 = this.p0;
        r8 = this.t0;
        goto L24
    L20:
        r6 = this.g0;
        r8 = this.l0;
        goto L24
    L21:
        if (r12 <= 0) goto L23;
        r6 = this.q0;
        r8 = this.u0;
        goto L24
    L23:
        r6 = this.h0;
        r8 = this.m0;
        goto L24
    }

    private void u1(int r12) {
        int r0 = this.V;
        if (r12 != r0) goto L6;
        return;
    L6:
        if (this.S == false) goto L9;
        if (r12 == 2) goto L9;
        return;
    L9:
        this.S = true;
        if (r0 == 0) goto L58;
        if (r0 == 1) goto L36;
        if (r0 == 2) goto L25;
        if (r0 != 3) goto L73;
        if (r12 == 0) goto L23;
        if (r12 == 1) goto L22;
        if (r12 == 2) goto L22;
        if (r12 != 3) goto L74;
        this.D0.removeMessages(InputDeviceCompat.SOURCE_GAMEPAD);
        this.D0.sendEmptyMessageDelayed(InputDeviceCompat.SOURCE_GAMEPAD, WsConstants.EXIT_DELAY_TIME);
    L21:
        this.S = false;
        w1();
        return;
    L74:
        return;
    L22:
        this.N.setVisibility(4);
        this.f4061i.setVisibility(0);
        this.V = 1;
    L24:
        this.S = false;
        w1();
        X0();
        return;
    L23:
        this.N.setVisibility(4);
        this.f4061i.setVisibility(0);
        this.V = 0;
        goto L24
    L73:
        return;
    L25:
        if (r12 != 3) goto L75;
        int r13 = (int) this.G.getX();
        int r1 = (int) this.G.getY();
        int r2 = this.Y;
        if (r13 <= (r2 / 2)) goto L30;
        int r3 = (r2 - this.d0) - this.N.getWidth();
    L31:
        int r14 = this.N.getHeight() + r1;
        int r4 = this.Z;
        int r9 = this.d0;
        if (r14 <= (r4 - r9)) goto L34;
        r1 = ((r4 - this.a0) - r9) - this.N.getHeight();
    L34:
        this.N.setX(r3);
        this.N.setY(r1);
        this.G.setVisibility(4);
    L35:
        this.N.setVisibility(0);
        this.V = 3;
        this.S = false;
        w1();
    L66:
        this.D0.removeMessages(InputDeviceCompat.SOURCE_GAMEPAD);
        this.D0.sendEmptyMessageDelayed(InputDeviceCompat.SOURCE_GAMEPAD, WsConstants.EXIT_DELAY_TIME);
        return;
    L30:
        r3 = this.d0;
        goto L31
    L75:
        return;
    L36:
        int r5 = k0();
        if (r12 == 0) goto L57;
        if (r12 == 2) goto L49;
        if (r12 != 3) goto L76;
        if (r5 != 0) goto L43;
        int r15 = ((int) this.f4064l.getY()) + ((int) this.f4061i.getY());
    L44:
        int r6 = (int) this.f4061i.getX();
        int r7 = this.Y;
        if (r6 <= (r7 / 2)) goto L47;
        int r8 = (r7 - this.d0) - this.N.getWidth();
    L48:
        this.N.setX(r8);
        this.N.setY(r15);
        this.f4061i.setVisibility(4);
        goto L35
    L47:
        r8 = this.d0;
        goto L48
    L43:
        r15 = (((int) this.v.getY()) + ((int) this.f4061i.getY())) - this.h0;
        goto L44
    L76:
        return;
    L49:
        if (r5 != 0) goto L51;
        int r16 = ((int) this.f4064l.getY()) + ((int) this.f4061i.getY());
    L52:
        int r10 = (int) this.f4061i.getX();
        int r11 = this.Y;
        if (r10 <= (r11 / 2)) goto L55;
        int r17 = (r11 - this.d0) - this.N.getWidth();
    L56:
        this.G.setX(r17);
        this.G.setY(r16);
        this.f4061i.setVisibility(4);
        this.G.setVisibility(0);
        this.V = 2;
        goto L21
    L55:
        r17 = this.d0;
        goto L56
    L51:
        r16 = (((int) this.v.getY()) + ((int) this.f4061i.getY())) - this.h0;
        goto L52
    L57:
        o1();
        return;
    L58:
        if (r12 == 1) goto L67;
        if (r12 != 3) goto L77;
        int r18 = (int) this.f4061i.getX();
        int r19 = (int) this.f4061i.getY();
        int r20 = this.Y;
        if (r18 <= (r20 / 2)) goto L64;
        int r21 = (r20 - this.d0) - this.N.getWidth();
    L65:
        this.N.setX(r21);
        this.N.setY(r19);
        this.f4061i.setVisibility(4);
        this.N.setVisibility(0);
        this.V = 3;
        this.S = false;
        goto L66
    L64:
        r21 = this.d0;
        goto L65
    L77:
        return;
    L67:
        u0();
    }

    static /* synthetic */ int v(a r0, int r1) {
        r0.x0 = r1;
        return r1;
    }

    private int v0(@NonNull String r7, int r8) {
        TextView r0 = new TextView(this.A0);
        int r1 = 12;
        int r2 = 12;
    L4:
        if (r2 < 7) goto L9;
        r0.setTextSize(1, r2);
        if (P0(r7, r0.getTextSize()).width() < (r8 - 1)) goto L7;
        r2 = r2 - 1;
        goto L4
    L7:
        return r2;
    L9:
        if (r1 < 7) goto L14;
        r0.setTextSize(1, r1);
        if (P0(r7.substring(r7.length() / 2), r0.getTextSize()).width() < (r8 - 5)) goto L12;
        r1 = r1 - 1;
        goto L9
    L12:
        return r1;
    L14:
        return 7;
    }

    private void v1() {
        int r0 = this.V;
        if (r0 == 0) goto L38;
        int r1 = this.X;
        if (r1 == 0) goto L38;
        if (r0 == 1) goto L10;
        if (r1 == 1) goto L10;
        return;
    L10:
        int r2 = k0();
        int r3 = this.W;
        if ((r3 & 1) <= 0) goto L25;
        if ((r3 & 4) <= 0) goto L19;
        com.bytedance.feedbackerlib.m.v.a(this.f4061i, this.p0);
        if (r2 != 0) goto L17;
    L16:
        LinearLayout r4 = this.f4062j;
        int r5 = this.k0;
    L43:
        r4.setTranslationY(r5);
        return;
    L17:
        r4 = this.f4062j;
        r5 = this.t0;
        goto L43
    L19:
        if ((r3 & 8) <= 0) goto L56;
        com.bytedance.feedbackerlib.m.v.a(this.f4061i, this.g0);
        if (r2 == 0) goto L16;
        r4 = this.f4062j;
        r5 = this.l0;
        goto L43
    L56:
        return;
    L25:
        if ((r3 & 2) > 0) goto L27;
        return;
    L27:
        if ((r3 & 4) <= 0) goto L33;
        com.bytedance.feedbackerlib.m.v.a(this.f4061i, this.q0);
        if (r2 == 0) goto L16;
        r4 = this.f4062j;
        r5 = this.u0;
        goto L43
    L33:
        if ((r3 & 8) <= 0) goto L58;
        com.bytedance.feedbackerlib.m.v.a(this.f4061i, this.h0);
        if (r2 == 0) goto L16;
        r4 = this.f4062j;
        r5 = this.m0;
        goto L43
    L58:
        return;
    L38:
        com.bytedance.feedbackerlib.m.v.a(this.f4061i, this.f0);
        int r6 = this.W;
        if ((r6 & 1) <= 0) goto L48;
        if ((r6 & 4) <= 0) goto L45;
        r4 = this.f4062j;
        r5 = this.r0;
        goto L43
    L45:
        if ((r6 & 8) <= 0) goto L60;
        r4 = this.f4062j;
        r5 = this.i0;
        goto L43
    L60:
        return;
    L48:
        if ((r6 & 2) > 0) goto L50;
        return;
    L50:
        if ((r6 & 4) <= 0) goto L53;
        r4 = this.f4062j;
        r5 = this.s0;
        goto L43
    L53:
        if ((r6 & 8) <= 0) goto L62;
        r4 = this.f4062j;
        r5 = this.j0;
        goto L43
    }

    static /* synthetic */ int w(a r0, int r1) {
        r0.y0 = r1;
        return r1;
    }

    private void w0() {
        if (com.bytedance.feedbackerlib.model.a.I().Q() == true) goto L6;
        return;
    L6:
        if (Feedbacker.isApplicationForegroundLogic() == true) goto L8;
        return;
    L8:
        if (com.bytedance.feedbackerlib.model.a.I().S() == false) goto L17;
        ViewTreeObserver r0 = this.f4059g.getViewTreeObserver();
        if (r0.isAlive() == true) goto L14;
        Toast.makeText(this.A0, "observer is not alive", 0).show();
        return;
    L14:
        com.bytedance.feedbackerlib.m.u.b(r0, this.B0);
        com.bytedance.feedbackerlib.m.u.a(r0, this.B0);
        SupportCustomInterceptLinearLayout r1 = this.N;
        r1.setX((this.Y - this.d0) - r1.getWidth());
        SupportCustomInterceptLinearLayout r2 = this.N;
        r2.setY(((this.Z - this.a0) - this.c0) - r2.getHeight());
        this.f4055c.addView(this.f4059g, this.f4060h);
        this.D0.postDelayed(new z(this), 2900);
        return;
    }

    private void w1() {
        int r0 = m0();
        if ((r0 & 2) == 0) goto L5;
    L8:
        t1(r0);
        return;
    L5:
        if ((r0 & 1) != 0) goto L8;
        com.bytedance.feedbackerlib.m.c.b("FloatWindowManagerExt show", "(windowMode & WindowMode.MODE_LIMITED) == 0 && (windowMode & WindowMode.MODE_NORMAL) == 0");
        C0();
    }

    static /* synthetic */ void x(a r0, MotionEvent r1) {
        r0.s0(r1);
    }

    private WindowManager.LayoutParams x0() {
        WindowManager.LayoutParams r2 = new WindowManager.LayoutParams();
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        int r0 = 2003;
    L6:
        r2.type = r0;
        int r1 = r2.flags | 8;
        r2.flags = r1;
        r2.flags = r1 | 32;
        r2.format = -3;
        r2.gravity = BadgeDrawable.TOP_START;
        return r2;
    L5:
        r0 = 2038;
        goto L6
    }

    private void x1(boolean r13) {
        int r0 = this.V;
        if (r0 != 2) goto L5;
    L29:
        if (r0 != 2) goto L45;
        int r8 = (int) this.G.getX();
        int r10 = (int) this.G.getY();
        float r14 = this.G.getX() + (this.G.getWidth() / 2);
        int r1 = this.Y;
        if (r14 >= (r1 / 2.0f)) goto L33;
        int r15 = this.d0;
    L34:
        float r2 = this.G.getY();
        int r3 = this.b0;
        if (r2 < r3) goto L41;
        float r4 = this.G.getY() + this.G.getHeight();
        int r5 = this.Z;
        int r6 = this.c0;
        if (r4 <= (r5 - r6)) goto L40;
        r3 = (r5 - r6) - this.G.getHeight();
        goto L41
    L40:
        r3 = r10;
    L41:
        ValueAnimator r16 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r16.setDuration(50);
        ValueAnimator.AnimatorUpdateListener r7 = new w(this, r15 - r8, r8, r3 - r10, r10);
    L42:
        r16.addUpdateListener(r7);
        r16.start();     // Catch: RuntimeException -> L58
    L59:
        return;
    L33:
        r15 = (r1 - this.d0) - this.G.getWidth();
        goto L34
    L45:
        int r9 = (int) this.N.getX();
        int r11 = (int) this.N.getY();
        float r17 = this.N.getX() + (this.N.getWidth() / 2);
        int r12 = this.Y;
        if (r17 >= (r12 / 2.0f)) goto L48;
        int r18 = this.d0;
    L49:
        float r19 = this.N.getY();
        int r20 = this.b0;
        if (r19 < r20) goto L56;
        float r21 = this.N.getY() + this.N.getHeight();
        int r22 = this.Z;
        int r23 = this.c0;
        if (r21 <= (r22 - r23)) goto L55;
        r20 = (r22 - r23) - this.N.getHeight();
        goto L56
    L55:
        r20 = r11;
    L56:
        r16 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r16.setDuration(50);
        r7 = new x(this, r18 - r9, r9, r20 - r11, r11);
        goto L42
    L48:
        r18 = (r12 - this.d0) - this.N.getWidth();
        goto L49
    L5:
        if (r0 == 3) goto L29;
        int r24 = (int) this.f4061i.getX();
        int r110 = (int) this.f4061i.getY();
        float r25 = this.f4061i.getX();
        int r26 = this.Y;
        if (r25 >= (r26 / 2.0f)) goto L9;
        int r27 = this.d0;
    L11:
        if (this.V != 0) goto L18;
        float r28 = this.f4061i.getY();
        int r29 = this.b0;
        if (r28 < r29) goto L26;
        float r30 = this.f4061i.getY() + this.f4061i.getHeight();
        int r31 = this.Z;
        int r32 = this.c0;
        if (r30 > (r31 - r32)) goto L24;
    L25:
        r29 = r110;
    L24:
        r29 = (r31 - r32) - this.f4061i.getHeight();
    L26:
        ValueAnimator r33 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r33.setDuration(50);
        r33.addUpdateListener(new u(this, r27 - r24, r24, r29 - r110, r13, r110));
        r33.start();     // Catch: RuntimeException -> L58
        goto L59
    L18:
        float r34 = this.f4061i.getY();
        r29 = this.d0;
        if (r34 < r29) goto L26;
        float r35 = this.f4061i.getY() + this.f4061i.getHeight();
        int r36 = this.Z;
        r32 = this.a0;
        int r37 = this.d0;
        if (r35 <= ((r36 - r32) - r37)) goto L25;
        r31 = r36 - r37;
        goto L24
    L9:
        r27 = (r26 - this.d0) - this.e0;
    }

    static /* synthetic */ void y(a r0) {
        r0.X0();
    }

    private WindowManager.LayoutParams y0() {
        WindowManager.LayoutParams r1 = x0();
        r1.width = -1;
        r1.height = -1;
        return r1;
    }

    static /* synthetic */ k0 z(a r0) {
        return r0.f4063k;
    }

    @RequiresApi(api = 21)
    public static a z0(@NonNull Context r2) {
        if (E0 != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (E0 != null) goto L9;
        E0 = new a(r2);     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return E0;
    }

    public String A0() {
        return this.Y + "*" + (this.Z + this.a0);
    }

    public void C0() {
        if (Build.VERSION.SDK_INT >= 21) goto L5;
        return;
    L5:
        D0();
        com.bytedance.feedbackerlib.m.r.c();
    }

    public boolean J0() {
        int r1 = this.V;
        if (r1 != 0) goto L5;
    L10:
        return true;
    L5:
        if (r1 == 3) goto L10;
        if (r1 == 2) goto L10;
        return false;
    }

    public boolean N0() {
        if (this.f4059g.getParent() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean O0() {
        View r1 = this.f4053a;
        if (r1 != null) goto L6;
        return false;
    L6:
        if (r1.getParent() == null) goto L9;
        return true;
    L9:
        return false;
    }

    public void Y0(String r4) {
        boolean r0 = F0;
        if (r0 == false) goto L5;
        f1(false);
    L5:
        C0();
        this.D0.post(new h0(this, r4, r0));
    }

    public void f1(boolean r4) {
        if (F0 == true) goto L5;
        return;
    L5:
        if (L0() == false) goto L20;
        boolean r0 = O0();
        F0 = false;
        if (r0 == true) goto L10;
        return;
    L10:
        this.f4055c.removeView(this.f4053a);
        if (this.U != 0) goto L13;
        this.f4061i.setX(this.f4054b.x);
        this.f4061i.setY(this.f4054b.y);
    L14:
        p0();
        l1("show original float window");
        if (r4 == false) goto L19;
        u1(0);
        T0();
        return;
    L19:
        return;
    L13:
        this.G.setX(this.f4054b.x);
        this.G.setY(this.f4054b.y);
        goto L14
    }

    public void k1(String r6) {
        com.bytedance.feedbackerlib.m.c.b("FloatWindowManagerExt show", "FloatWindowService show() is invoked");
        com.bytedance.feedbackerlib.m.r.h(r6, "FloatWindowService show() is invoked", new String[0]);
        if (Build.VERSION.SDK_INT >= 21) goto L6;
        return;
    L6:
        if (I0(r6) == true) goto L9;
        com.bytedance.feedbackerlib.m.c.b("FloatWindowManagerExt show", "isFloatWindowCloudShow() is false");
        com.bytedance.feedbackerlib.m.r.h(r6, "FloatWindowService show(): isFloatWindowCloudShow() is false", new String[0]);
        C0();
        return;
    L9:
        boolean r1 = q0(r6);
        com.bytedance.feedbackerlib.m.c.b("FloatWindowManagerExt show", "hasPermission is " + r1);
        com.bytedance.feedbackerlib.m.r.h(r6, "FloatWindowService show(): hasPermission is " + r1, new String[0]);
        if (r1 == true) goto L13;
        return;
    L13:
        if (t0() == true) goto L17;
        Toast.makeText(this.A0, this.f4058f.g("sdk29"), 0).show();
        return;
    L17:
        if (M0() == true) goto L20;
        Toast.makeText(this.A0, this.f4058f.g("sdk30"), 0).show();
        return;
    L20:
        l1(r6);
        this.f4061i.post(new e0(this));
        com.bytedance.feedbackerlib.m.r.d();
    }

    public void m1() {
        if (F0 == false) goto L5;
        return;
    L5:
        if (L0() == true) goto L7;
        return;
    L7:
        if (G0 == false) goto L10;
        return;
    L10:
        if (N0() == true) goto L12;
        return;
    L12:
        this.U = 0;
        int r1 = this.V;
        if (r1 != 2) goto L15;
        return;
    L15:
        if (r1 == 3) goto L23;
        D0();
        r0();
        this.M.setVisibility(0);
        this.f4052J.setVisibility(8);
        this.f4055c.addView(this.f4053a, this.f4054b);
        F0 = true;
        return;
    }

    public void n1() {
        if (this.W != 2) goto L5;
        return;
    L5:
        if (L0() == false) goto L10;
        this.U = 2;
        D0();
        r0();
        this.M.setVisibility(8);
        this.f4052J.setVisibility(0);
        this.f4055c.addView(this.f4053a, this.f4054b);
        F0 = true;
        return;
    }
}

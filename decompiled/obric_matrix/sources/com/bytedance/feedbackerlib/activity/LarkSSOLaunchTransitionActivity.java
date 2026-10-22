package com.bytedance.feedbackerlib.activity;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.window.embedding.EmbeddingCompat;
import com.bytedance.feedbackerlib.Feedbacker;
import com.bytedance.feedbackerlib.m.q;
import com.bytedance.feedbackerlib.m.r;
import com.bytedance.feedbackerlib.m.v;
import com.bytedance.feedbackerlib.service.FloatWindowService;
import com.bytedance.feedbackerlib.view.CancledUndlineSpan;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import java.util.List;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class LarkSSOLaunchTransitionActivity extends AppCompatActivity {
    private static final Handler t = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.bytedance.feedbackerlib.j.e f3926f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private TextView f3927g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private TextView f3928h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private TextView f3929i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ImageView f3930j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private TextView f3931k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private TextView f3932l;
    private TextView m;
    private LinearLayout n;
    private TextView o;
    private RelativeLayout p;
    private TextView q;
    private final com.bytedance.feedbackerlib.j.e.b r;
    private final Feedbacker.m s;

    class a implements com.bytedance.feedbackerlib.model.a.v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3933a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f3934b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ LarkSSOLaunchTransitionActivity f3935c;

        /* JADX INFO: renamed from: com.bytedance.feedbackerlib.activity.LarkSSOLaunchTransitionActivity$a$a, reason: collision with other inner class name */
        class C0113a implements com.bytedance.feedbackerlib.model.a.u {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ a f3936a;

            /* JADX INFO: renamed from: com.bytedance.feedbackerlib.activity.LarkSSOLaunchTransitionActivity$a$a$a, reason: collision with other inner class name */
            class C0114a implements com.bytedance.feedbackerlib.model.a.v {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ C0113a f3937a;

                C0114a(C0113a r1) {
                    this.f3937a = r1;
                }

                @Proxy("getApplicationContext")
                @TargetClass(scope = Scope.ALL, value = "android.content.Context")
                public static Context b(LarkSSOLaunchTransitionActivity r2) {
                    return r2.getApplicationContext();
                L4:
                    e = move-exception;
                    com.obric.matrix.r.c.c.g("hookGetApplicationContext", "getApplicationContext error", e);
                    return com.bytedance.mpaas.app.a.a();
                }

                @Override // com.bytedance.feedbackerlib.model.a.v
                public void a(int r6, String r7) {
                    r.k(this.f3937a.f3936a.f3933a, "onRequestFinished invoked", new String[]{"resultCode=" + r6, "msg=" + r7});
                    StringBuilder r0 = new StringBuilder();
                    r0.append("request user profile from server, resultCode: ");
                    r0.append(r6);
                    r0.append(", msg: ");
                    r0.append(r7);
                    com.bytedance.feedbackerlib.m.c.b("LarkSSOLaunchTransition", r0.toString());
                    if (r6 != 1) goto L5;
                    a r5 = this.f3937a.f3936a;
                    LarkSSOLaunchTransitionActivity.C(r5.f3935c, r5.f3934b, r5.f3933a);
                    return;
                L5:
                    com.bytedance.feedbackerlib.model.e.e r8 = com.bytedance.feedbackerlib.model.a.I().P();
                    if (r8 != null) goto L11;
                    r.k(this.f3937a.f3936a.f3933a, "userProfileInfo==null", new String[0]);
                L8:
                    a r9 = this.f3937a.f3936a;
                    LarkSSOLaunchTransitionActivity.C(r9.f3935c, r9.f3934b, r9.f3933a);
                    com.bytedance.feedbackerlib.j.b.a();
                    return;
                L11:
                    if (TextUtils.isEmpty(r8.f4623b) == false) goto L13;
                    r.k(this.f3937a.f3936a.f3933a, "email is empty", new String[0]);
                    goto L8
                L13:
                    LarkSSOLaunchTransitionActivity.x(this.f3937a.f3936a.f3935c).setText(LarkSSOLaunchTransitionActivity.H(this.f3937a.f3936a.f3935c).g("authority_success"));
                    LarkSSOLaunchTransitionActivity.x(this.f3937a.f3936a.f3935c).setEnabled(false);
                    LarkSSOLaunchTransitionActivity.x(this.f3937a.f3936a.f3935c).setVisibility(0);
                    LarkSSOLaunchTransitionActivity.x(this.f3937a.f3936a.f3935c).setBackgroundDrawable(ContextCompat.getDrawable(b(this.f3937a.f3936a.f3935c), com.bytedance.feedbackerlib.d.f4002d));
                    v.a(LarkSSOLaunchTransitionActivity.D(this.f3937a.f3936a.f3935c), 0);
                    r.k(this.f3937a.f3936a.f3933a, "callback lark sso success", new String[0]);
                    com.bytedance.feedbackerlib.l.a.d(b(this.f3937a.f3936a.f3935c), this.f3937a.f3936a.f3933a);
                    LarkSSOLaunchTransitionActivity r10 = this.f3937a.f3936a.f3935c;
                    Toast.makeText(r10, LarkSSOLaunchTransitionActivity.H(r10).g("sso_verify_success"), 1).show();
                    LarkSSOLaunchTransitionActivity.E(this.f3937a.f3936a.f3935c);
                    com.bytedance.feedbackerlib.j.b.a();
                }
            }

            C0113a(a r1) {
                this.f3936a = r1;
            }

            @Override // com.bytedance.feedbackerlib.model.a.u
            public void a(@NonNull Boolean r5) {
                r.k(this.f3936a.f3933a, "onNetworkStateRequestFinish invoked", new String[]{"isInternalNetwork=" + r5});
                r.k(this.f3936a.f3933a, "start request user profile from server", new String[0]);
                com.bytedance.feedbackerlib.model.a.I().b0(r5.booleanValue(), new C0114a(this));
            }
        }

        a(LarkSSOLaunchTransitionActivity r1, String r2, String r3) {
            this.f3935c = r1;
            this.f3933a = r2;
            this.f3934b = r3;
        }

        @Override // com.bytedance.feedbackerlib.model.a.v
        public void a(int r7, String r8) {
            r.k(this.f3933a, "onRequestFinished invoked", new String[]{"msg: " + r8 + ", resultCode: " + r7});
            com.bytedance.feedbackerlib.m.c.b("LarkSSOLaunchTransition", "onRequestFinished: msg: " + r8 + ", resultCode: " + r7);
            if (r7 != 1) goto L5;
            com.bytedance.feedbackerlib.m.c.a("LarkSSOLaunchTransition", "requestAccessCredentialsFromServer failed, code: " + this.f3934b, new RuntimeException());
            LarkSSOLaunchTransitionActivity.C(this.f3935c, this.f3934b, this.f3933a);
            return;
        L5:
            r.k(this.f3933a, "start request network state from server", new String[0]);
            com.bytedance.feedbackerlib.model.a.I().W(new C0113a(this));
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ LarkSSOLaunchTransitionActivity f3938f;

        class a implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ b f3939f;

            a(b r1) {
                this.f3939f = r1;
            }

            @Proxy("getApplicationContext")
            @TargetClass(scope = Scope.ALL, value = "android.content.Context")
            public static Context a(LarkSSOLaunchTransitionActivity r2) {
                return r2.getApplicationContext();
            L4:
                e = move-exception;
                com.obric.matrix.r.c.c.g("hookGetApplicationContext", "getApplicationContext error", e);
                return com.bytedance.mpaas.app.a.a();
            }

            @Override // java.lang.Runnable
            public void run() {
                FloatWindowService.R("ShowFloatWindowAfterSSO->" + System.currentTimeMillis(), a(this.f3939f.f3938f));
            }
        }

        b(LarkSSOLaunchTransitionActivity r1) {
            this.f3938f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f3938f.finish();
            LarkSSOLaunchTransitionActivity.M().removeMessages(0);
            LarkSSOLaunchTransitionActivity.M().postDelayed(new a(this), 1000);
        }
    }

    class c implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f3940a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f3941b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ LarkSSOLaunchTransitionActivity f3942c;

        class a implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ c f3943f;

            a(c r1) {
                this.f3943f = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                c r3 = this.f3943f;
                LarkSSOLaunchTransitionActivity.F(r3.f3942c, r3.f3940a);
            }
        }

        c(LarkSSOLaunchTransitionActivity r1, long r2, long r4) {
            this.f3942c = r1;
            this.f3940a = r2;
            this.f3941b = r4;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation r4) {
            LarkSSOLaunchTransitionActivity.M().removeMessages(1024);
            Message r5 = Message.obtain(LarkSSOLaunchTransitionActivity.M(), new a(this));
            r5.what = 1024;
            LarkSSOLaunchTransitionActivity.M().sendMessageDelayed(r5, this.f3941b);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation r1) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation r1) {
        }
    }

    class d implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ LarkSSOLaunchTransitionActivity f3944a;

        d(LarkSSOLaunchTransitionActivity r1) {
            this.f3944a = r1;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation r1) {
            LarkSSOLaunchTransitionActivity.G(this.f3944a).setVisibility(8);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation r1) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation r1) {
        }
    }

    class e implements com.bytedance.feedbackerlib.j.e.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ LarkSSOLaunchTransitionActivity f3945a;

        e(LarkSSOLaunchTransitionActivity r1) {
            this.f3945a = r1;
        }

        @Override // com.bytedance.feedbackerlib.j.e.b
        public void a() {
            LarkSSOLaunchTransitionActivity.w(this.f3945a);
        }
    }

    class f implements Feedbacker.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ LarkSSOLaunchTransitionActivity f3946a;

        f(LarkSSOLaunchTransitionActivity r1) {
            this.f3946a = r1;
        }

        @Override // com.bytedance.feedbackerlib.Feedbacker.m
        public void a() {
            if (this.f3946a.isDestroyed() == false) goto L5;
            return;
        L5:
            if (this.f3946a.isFinishing() == true) goto L9;
            this.f3946a.finish();
            return;
        }

        @Override // com.bytedance.feedbackerlib.Feedbacker.m
        public void b(@NonNull String r1) {
        }

        @Override // com.bytedance.feedbackerlib.Feedbacker.m
        public void c() {
        }
    }

    class g implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ LarkSSOLaunchTransitionActivity f3947f;

        g(LarkSSOLaunchTransitionActivity r1) {
            this.f3947f = r1;
        }

        @Proxy("getApplicationContext")
        @TargetClass(scope = Scope.ALL, value = "android.content.Context")
        public static Context a(LarkSSOLaunchTransitionActivity r2) {
            return r2.getApplicationContext();
        L4:
            e = move-exception;
            com.obric.matrix.r.c.c.g("hookGetApplicationContext", "getApplicationContext error", e);
            return com.bytedance.mpaas.app.a.a();
        }

        @Override // java.lang.Runnable
        public void run() {
            if (LarkSSOLaunchTransitionActivity.x(this.f3947f).getVisibility() == 0) goto L6;
            LarkSSOLaunchTransitionActivity.x(this.f3947f).setText(LarkSSOLaunchTransitionActivity.H(this.f3947f).g("start_sso"));
            LarkSSOLaunchTransitionActivity.x(this.f3947f).setVisibility(0);
            LarkSSOLaunchTransitionActivity.x(this.f3947f).setEnabled(true);
            LarkSSOLaunchTransitionActivity.x(this.f3947f).setBackgroundDrawable(ContextCompat.getDrawable(a(this.f3947f), com.bytedance.feedbackerlib.d.f4001c));
            LarkSSOLaunchTransitionActivity.I(this.f3947f);
            return;
        }
    }

    class h implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ LarkSSOLaunchTransitionActivity f3948f;

        class a implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f3949f;

            a(h r1, String r2) {
                this.f3949f = r2;
            }

            @Override // java.lang.Runnable
            public void run() {
                List<String> r0 = com.bytedance.feedbackerlib.model.e.b.d().c();
                r.m(this.f3949f, r0);
                com.bytedance.feedbackerlib.j.b.a();
                com.bytedance.feedbackerlib.model.e.b.d().b();
            }
        }

        class b implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ h f3950f;

            b(h r1) {
                this.f3950f = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                String r0 = LarkSSOLaunchTransitionActivity.H(this.f3950f.f3948f).g("sso_network_request_failed");
                boolean r1 = com.bytedance.common.utility.k.b(r0, "no translation");
                TextView r2 = LarkSSOLaunchTransitionActivity.J(this.f3950f.f3948f);
                if (r1 == false) goto L6;
                r0 = "网络较差，努力加载中";
            L6:
                r2.setText(r0);
            }
        }

        h(LarkSSOLaunchTransitionActivity r1) {
            this.f3948f = r1;
        }

        @Proxy("getApplicationContext")
        @TargetClass(scope = Scope.ALL, value = "android.content.Context")
        public static Context a(LarkSSOLaunchTransitionActivity r2) {
            return r2.getApplicationContext();
        L4:
            e = move-exception;
            com.obric.matrix.r.c.c.g("hookGetApplicationContext", "getApplicationContext error", e);
            return com.bytedance.mpaas.app.a.a();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r4) {
            LarkSSOLaunchTransitionActivity.J(this.f3948f).setText(LarkSSOLaunchTransitionActivity.H(this.f3948f).g("sso_retrying"));
            LarkSSOLaunchTransitionActivity.K(this.f3948f).setVisibility(0);
            String r5 = "sso_retry_on_click->" + System.currentTimeMillis();
            r.k(r5, "mSSORetryTV.onClick", new String[0]);
            if (LarkSSOLaunchTransitionActivity.L(this.f3948f) == false) goto L6;
            r.k(r5, "finishSelfAfter2SecondsIfSSOVerified", new String[0]);
            return;
        L6:
            FloatWindowService.U(false);
            FloatWindowService.k(a(this.f3948f), r5);
            Message r6 = Message.obtain(LarkSSOLaunchTransitionActivity.M(), new a(this, r5));
            r6.what = 1;
            LarkSSOLaunchTransitionActivity.M().sendMessageDelayed(r6, 2000);
            Message r7 = Message.obtain(LarkSSOLaunchTransitionActivity.M(), new b(this));
            r7.what = 2;
            LarkSSOLaunchTransitionActivity.M().sendMessageDelayed(r7, 1000);
            LarkSSOLaunchTransitionActivity.y(this.f3948f);
        }
    }

    class i implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ LarkSSOLaunchTransitionActivity f3951f;

        class a implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ i f3952f;

            a(i r1) {
                this.f3952f = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                String r0 = LarkSSOLaunchTransitionActivity.H(this.f3952f.f3951f).g("sso_network_request_failed");
                boolean r1 = com.bytedance.common.utility.k.b(r0, "no translation");
                TextView r2 = LarkSSOLaunchTransitionActivity.J(this.f3952f.f3951f);
                if (r1 == false) goto L6;
                r0 = "网络较差，努力加载中";
            L6:
                r2.setText(r0);
            }
        }

        i(LarkSSOLaunchTransitionActivity r1) {
            this.f3951f = r1;
        }

        @Proxy("getApplicationContext")
        @TargetClass(scope = Scope.ALL, value = "android.content.Context")
        public static Context a(LarkSSOLaunchTransitionActivity r2) {
            return r2.getApplicationContext();
        L4:
            e = move-exception;
            com.obric.matrix.r.c.c.g("hookGetApplicationContext", "getApplicationContext error", e);
            return com.bytedance.mpaas.app.a.a();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r5) {
            String r6 = "sso_h5_on_click->" + System.currentTimeMillis();
            r.k(r6, "mSSOH5TV onClick", new String[0]);
            LarkSSOLaunchTransitionActivity.J(this.f3951f).setText(LarkSSOLaunchTransitionActivity.H(this.f3951f).g("sso_retrying"));
            LarkSSOLaunchTransitionActivity.K(this.f3951f).setVisibility(0);
            FloatWindowService.U(false);
            FloatWindowService.l(a(this.f3951f), true, true, r6);
            Message r7 = Message.obtain(LarkSSOLaunchTransitionActivity.M(), new a(this));
            r7.what = 2;
            LarkSSOLaunchTransitionActivity.M().sendMessageDelayed(r7, 1000);
            LarkSSOLaunchTransitionActivity.y(this.f3951f);
        }
    }

    class j extends ClickableSpan {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ LarkSSOLaunchTransitionActivity f3953f;

        j(LarkSSOLaunchTransitionActivity r1) {
            this.f3953f = r1;
        }

        @Proxy("getApplicationContext")
        @TargetClass(scope = Scope.ALL, value = "android.content.Context")
        public static Context a(LarkSSOLaunchTransitionActivity r2) {
            return r2.getApplicationContext();
        L4:
            e = move-exception;
            com.obric.matrix.r.c.c.g("hookGetApplicationContext", "getApplicationContext error", e);
            return com.bytedance.mpaas.app.a.a();
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View r4) {
            if (com.bytedance.feedbackerlib.m.h.a(a(this.f3953f)) == true) goto L5;
            String r0 = LarkSSOLaunchTransitionActivity.H(this.f3953f).g("sdk_feedback_toast");
            LarkSSOLaunchTransitionActivity.z(this.f3953f, r0);
        L7:
            if ((r4 instanceof TextView) == false) goto L10;
            ((TextView) r4).setHighlightColor(this.f3953f.getResources().getColor(R.color.transparent));
            return;
        L10:
            return;
        L5:
            Intent r1 = new Intent("android.intent.action.VIEW", Uri.parse("https://applink.feishu.cn/client/bot/open?appId=cli_a0bdad723f38500d"));
            this.f3953f.startActivity(r1);
            goto L7
        }
    }

    class k implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f3954f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f3955g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ LarkSSOLaunchTransitionActivity f3956h;

        k(LarkSSOLaunchTransitionActivity r1, boolean r2, String r3) {
            this.f3956h = r1;
            this.f3954f = r2;
            this.f3955g = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            LarkSSOLaunchTransitionActivity.A(this.f3956h, this.f3954f, this.f3955g);
        }
    }

    class l implements com.ss.android.larksso.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f3957a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ LarkSSOLaunchTransitionActivity f3958b;

        l(LarkSSOLaunchTransitionActivity r1, String r2) {
            this.f3958b = r1;
            this.f3957a = r2;
        }

        @Override // com.ss.android.larksso.b
        public void a(com.ss.android.larksso.a r4) {
            r.k(this.f3957a, "startSSOVerify.onSuccess invoked", new String[0]);
            LarkSSOLaunchTransitionActivity.B(this.f3958b, r4.f12013a, this.f3957a);
        }

        @Override // com.ss.android.larksso.b
        public void b(com.ss.android.larksso.a r5) {
            r.k(this.f3957a, "startSSOVerify.onError invoked", new String[]{"code: " + r5.f12013a + ", codeVerifier: " + r5.f12014b});
            LarkSSOLaunchTransitionActivity.C(this.f3958b, r5.f12013a, this.f3957a);
        }
    }

    private static final enum m extends Enum<m> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final m f3959h = null;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final m f3960i = null;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final m f3961j = null;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final m f3962k = null;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final m f3963l = null;
        public static final m m = null;
        private static final /* synthetic */ m[] n = null;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @NonNull
        private final String f3964f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @NonNull
        private final String f3965g;

        static {
            m r0 = new m("ERROR_STATE_CODE_VERIFY_FAILED", 0, "-1", "状态码校验失败，非当前SDK请求的响应");
            f3959h = r0;
            m r1 = new m("ERROR_NOT_GET_VALID_VERIFY_CODE", 1, "-2", "没有获得有效的授权码");
            f3960i = r1;
            m r3 = new m("ERROR_USER_CANCEL_VERIFY", 2, "-3", "用户取消授权");
            f3961j = r3;
            m r5 = new m("ERROR_JUMP_TO_LARK_FAILED", 3, "-4", "跳转到Lark失败");
            f3962k = r5;
            m r7 = new m("ERROR_VERIFY_FAILED", 4, "-5", "授权失败");
            f3963l = r7;
            m r9 = new m("ERROR_REQUEST_PARAMS_INCORRECT", 5, "-6", "请求参数错误");
            m = r9;
            n = new m[]{r0, r1, r3, r5, r7, r9};
        }

        private m(@NonNull String r1, @NonNull int r2, String r3, String r4) {
            super(r1, r2);
            this.f3964f = r3;
            this.f3965g = r4;
        }

        public static m valueOf(String r1) {
            return (m) Enum.valueOf(m.class, r1);
        }

        public static m[] values() {
            return (m[]) n.clone();
        }

        public String a() {
            return this.f3964f;
        }

        @NonNull
        public String b() {
            return this.f3965g;
        }

        @Override // java.lang.Enum
        @NonNull
        public String toString() {
            return b();
        }
    }

    static {
        t = new Handler(Looper.getMainLooper());
    }

    public LarkSSOLaunchTransitionActivity() {
        this.r = new e(this);
        this.s = new f(this);
    }

    static /* synthetic */ void A(LarkSSOLaunchTransitionActivity r0, boolean r1, String r2) {
        r0.V(r1, r2);
    }

    static /* synthetic */ void B(LarkSSOLaunchTransitionActivity r0, String r1, String r2) {
        r0.U(r1, r2);
    }

    static /* synthetic */ void C(LarkSSOLaunchTransitionActivity r0, String r1, String r2) {
        r0.T(r1, r2);
    }

    static /* synthetic */ TextView D(LarkSSOLaunchTransitionActivity r0) {
        return r0.f3932l;
    }

    static /* synthetic */ void E(LarkSSOLaunchTransitionActivity r0) {
        r0.O();
    }

    static /* synthetic */ void F(LarkSSOLaunchTransitionActivity r0, long r1) {
        r0.W(r1);
    }

    static /* synthetic */ RelativeLayout G(LarkSSOLaunchTransitionActivity r0) {
        return r0.p;
    }

    static /* synthetic */ com.bytedance.feedbackerlib.j.e H(LarkSSOLaunchTransitionActivity r0) {
        return r0.f3926f;
    }

    static /* synthetic */ void I(LarkSSOLaunchTransitionActivity r0) {
        r0.b0();
    }

    static /* synthetic */ TextView J(LarkSSOLaunchTransitionActivity r0) {
        return r0.o;
    }

    static /* synthetic */ LinearLayout K(LarkSSOLaunchTransitionActivity r0) {
        return r0.n;
    }

    static /* synthetic */ boolean L(LarkSSOLaunchTransitionActivity r0) {
        return r0.P();
    }

    static /* synthetic */ Handler M() {
        return t;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = EmbeddingCompat.DEBUG, value = "onStop")
    public static void N(LarkSSOLaunchTransitionActivity r2) {
        r2.v();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT < 21) goto L12;
        r2.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L8
        return;
    L13:
        return;
    }

    private void O() {
        Handler r0 = t;
        r0.removeMessages(0);
        Message r3 = Message.obtain(r0, new b(this));
        r3.what = 0;
        r0.sendMessageDelayed(r3, 2000);
    }

    private boolean P() {
        if (TextUtils.isEmpty(Feedbacker.getUserAccessToken()) == false) goto L5;
        return false;
    L5:
        com.bytedance.feedbackerlib.model.e.e r0 = com.bytedance.feedbackerlib.model.a.I().P();
        if (r0 != null) goto L8;
        return false;
    L8:
        if (TextUtils.isEmpty(r0.f4623b) == true) goto L12;
        this.f3931k.setText(this.f3926f.g("authority_success"));
        this.f3931k.setEnabled(false);
        this.f3931k.setVisibility(0);
        this.f3931k.setBackgroundDrawable(ContextCompat.getDrawable(u(this), com.bytedance.feedbackerlib.d.f4002d));
        v.a(this.f3932l, 0);
        Toast.makeText(this, this.f3926f.g("sso_verify_success"), 1).show();
        O();
        return true;
    L12:
        return false;
    }

    private SpannableString Q() {
        String r0 = this.f3926f.g("sdk_permission_check");
        String r1 = this.f3926f.g("onCall_number");
        SpannableString r2 = new SpannableString(r0);
        int r3 = r0.indexOf(r1);
        int r4 = r1.length() + r3;
        if (r3 >= 0) goto L5;
    L7:
        return r2;
    L5:
        if (r4 >= r0.length()) goto L7;
        r2.setSpan(new j(this), r3, r4, 33);
        r2.setSpan(new ForegroundColorSpan(Color.parseColor("#436ef6")), r3, r4, 33);
        r2.setSpan(new CancledUndlineSpan(), r3, r4, 33);
        goto L7
    }

    private void R() {
        q.c.f4307g.b(-1);
        q.d.n.c(null);
        com.bytedance.feedbackerlib.model.a.I().z();
        Toast.makeText(this, "认证已过期，重启应用可再次触发鉴权流程", 1).show();
        finish();
    }

    private void S(@Nullable Intent r3) {
        if (r3 != null) goto L17;
        return;
    L17:
        com.ss.android.larksso.c.x().A(this, r3);     // Catch: Throwable -> L16
    L5:
        String r0 = r3.getAction();
        if (TextUtils.isEmpty(r0) == false) goto L8;
        return;
    L8:
        r0.hashCode();
        if (r0.equals("action_clear_sso_state") == false) goto L11;
        R();
        return;
    L11:
        if (r0.equals("action_sso_verify") == false) goto L20;
        V(r3.getBooleanExtra("extra_force_h5", false), r3.getStringExtra("extra_log_id"));
        return;
    }

    private void T(@Nullable String r7, String r8) {
        com.bytedance.feedbackerlib.j.b.a();
        r.k(r8, "handleSSOFailed invoked", new String[]{"code=" + r7, "logId=" + r8});
        StringBuilder r0 = new StringBuilder();
        r0.append("startSSOVerify failed, error code: ");
        r0.append(r7);
        com.bytedance.feedbackerlib.m.c.a("LarkSSOLaunchTransition", r0.toString(), new RuntimeException());
        com.bytedance.feedbackerlib.l.a.c(u(this));
        this.f3931k.setVisibility(0);
        this.n.setVisibility(8);
        this.f3931k.setBackgroundDrawable(getResources().getDrawable(com.bytedance.feedbackerlib.d.f4001c));
        this.f3931k.setEnabled(true);
        this.f3931k.setText(this.f3926f.g("sso_retry"));
        b0();
        if (m.f3961j.a().equals(r7) == false) goto L5;
        Toast.makeText(this, this.f3926f.g("toast_cancel_sso_verify"), 0).show();
    L11:
        if (com.bytedance.feedbackerlib.model.e.a.a() <= 0) goto L13;
        this.m.setText(com.bytedance.feedbackerlib.model.e.a.a() + " " + this.f3926f.g("failed_message"));
        com.bytedance.feedbackerlib.model.e.a.d(0);
    L13:
        this.m.setVisibility(0);
        com.bytedance.feedbackerlib.j.b.a();
        return;
    L5:
        long r1 = FloatWindowService.o();
        long r3 = 0;
        if (r1 == 0) goto L9;
        r3 = System.currentTimeMillis() - r1;
    L9:
        r.l(r8, r7, r3);
        goto L11
    }

    private void U(@Nullable String r5, String r6) {
        r.k(r6, "handleSSOSuccess invoked", new String[]{"code=" + r5});
        com.bytedance.feedbackerlib.m.c.b("LarkSSOLaunchTransition", "handleSSOSuccess, code: " + r5);
        this.f3931k.setVisibility(0);
        this.n.setVisibility(8);
        this.f3931k.setEnabled(false);
        this.f3931k.setBackgroundDrawable(ContextCompat.getDrawable(u(this), com.bytedance.feedbackerlib.d.f4002d));
        String r0 = this.f3926f.g("key_authorizing");
        if (com.bytedance.common.utility.k.b(r0, "no Translation") == false) goto L5;
        r0 = "授权中...";
    L5:
        this.f3931k.setText(r0);
        v.a(this.f3932l, 0);
        this.m.setVisibility(4);
        r.k(r6, "start request access credentials from server", new String[0]);
        com.bytedance.feedbackerlib.model.a.I().T(r5, r6, new a(this, r6, r5));
    }

    private void V(boolean r20, String r21) {
        r.k(r21, "handleSSOVerify invoked", new String[]{"forceH5=" + r20, "logId=" + r21});
        String r4 = com.bytedance.feedbackerlib.m.i.a(u(this));
        if (TextUtils.isEmpty(r4) == true) goto L5;
        r4 = r4.toUpperCase();
    L5:
        String r5 = Feedbacker.getAppId();
        String r8 = getPackageName();
        String r9 = Feedbacker.getDid() + "";
        String r10 = Feedbacker.getAid() + "";
        if (TextUtils.isEmpty(r4) == false) goto L8;
    L18:
        com.bytedance.feedbackerlib.m.c.a("LarkSSOLaunchTransition", "handleSSOVerify: appId: " + r5 + ", signature: " + r4 + ", packageName: " + r8 + ", aid: " + r10 + ", did: " + r9, new RuntimeException());
        r.k(r21, "sso args not complete", new String[]{"signatureMd5String=" + r4, "appId=" + r5, "packageName=" + r8, "did=" + r9, "aid=" + r10});
        t.postDelayed(new k(this, r20, r21), 2000);
        com.bytedance.feedbackerlib.j.b.a();
        return;
    L8:
        if (TextUtils.isEmpty(r5) == true) goto L18;
        if (TextUtils.isEmpty(r8) == true) goto L18;
        if (TextUtils.isEmpty(r9) == true) goto L18;
        if (TextUtils.isEmpty(r10) == true) goto L18;
        com.ss.android.larksso.c.b r11 = new com.ss.android.larksso.c.b();
        r11.j(r5);
        r11.n("Feishu");
        r11.l(r9);
        r11.m(r20);
        r11.k(this);
        com.bytedance.feedbackerlib.m.c.b("LarkSSOLaunchTransition", "start sso: appId: " + r5 + ", server: Feishu, packageId: " + r8 + ", signature: " + r4 + ", did: " + r9 + ", aid: " + r10);
        r.k(r21, "startSSOVerify", new String[]{"signatureMd5String=" + r4, "appId=" + r5, "packageName=" + r8, "did=" + r9, "aid=" + r10});
        com.bytedance.feedbackerlib.j.b.a();
        com.ss.android.larksso.c.x().D(r11, new l(this, r21));
        b0();
    }

    private void W(long r4) {
        AlphaAnimation r0 = new AlphaAnimation(1.0f, 0.0f);
        r0.setDuration(r4);
        r0.setFillAfter(true);
        r0.setAnimationListener(new d(this));
        this.p.clearAnimation();
        this.p.startAnimation(r0);
    }

    private void X() {
        com.bytedance.feedbackerlib.j.e r0 = com.bytedance.feedbackerlib.j.e.e();
        this.f3926f = r0;
        r0.k(this.r);
    }

    public static void Y(@Nullable Context r9, boolean r10, String r11) {
        r.k(r11, "launchForSSOVerify invoked", new String[]{"context=" + r9, "forceH5=" + r10, "logId=" + r11});
        if (r9 != null) goto L5;
    L10:
        r.k(r11, "args illegal", new String[]{"context=" + r9, "forceH5=" + r10, "logId=" + r11});
        return;
    L5:
        if (r9.getApplicationContext() == null) goto L10;
        Intent r0 = new Intent(r9.getApplicationContext(), LarkSSOLaunchTransitionActivity.class);
        r0.addFlags(268435456);
        r0.setAction("action_sso_verify");
        r0.putExtra("extra_force_h5", r10);
        r0.putExtra("extra_log_id", r11);
        r9.getApplicationContext().startActivity(r0);     // Catch: Throwable -> L12
        return;
    }

    private void Z() {
        this.f3928h.setText(this.f3926f.g("guidepage_title_detail"));
        this.f3927g.setText(this.f3926f.g("guidepage_title"));
        this.m.setText(this.f3926f.g("failed_message"));
        this.f3931k.setText(this.f3926f.g("sso_retry"));
        this.f3932l.setText(this.f3926f.g("sso_h5"));
        this.f3929i.setText(Q());
        this.f3929i.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void a0() {
        this.f3927g = (TextView) findViewById(com.bytedance.feedbackerlib.e.K0);
        this.f3928h = (TextView) findViewById(com.bytedance.feedbackerlib.e.J0);
        this.f3929i = (TextView) findViewById(com.bytedance.feedbackerlib.e.T0);
        this.f3930j = (ImageView) findViewById(com.bytedance.feedbackerlib.e.w);
        this.f3931k = (TextView) findViewById(com.bytedance.feedbackerlib.e.a1);
        this.m = (TextView) findViewById(com.bytedance.feedbackerlib.e.D0);
        this.f3932l = (TextView) findViewById(com.bytedance.feedbackerlib.e.Z0);
        this.p = (RelativeLayout) findViewById(com.bytedance.feedbackerlib.e.Q);
        this.q = (TextView) findViewById(com.bytedance.feedbackerlib.e.M0);
        this.n = (LinearLayout) findViewById(com.bytedance.feedbackerlib.e.X);
        this.o = (TextView) findViewById(com.bytedance.feedbackerlib.e.Y);
        this.f3931k.setOnClickListener(new h(this));
        this.f3932l.setOnClickListener(new i(this));
    }

    private void b0() {
        if (com.bytedance.feedbackerlib.m.e.b(u(this), "com.ss.android.lark") == false) goto L5;
    L10:
        v.a(this.f3932l, -2);
        return;
    L5:
        if (com.bytedance.feedbackerlib.m.e.b(u(this), "com.ss.android.lark.debug") == true) goto L10;
        if (com.bytedance.feedbackerlib.m.e.b(u(this), "com.larksuite.suite.debug") == true) goto L10;
        if (com.bytedance.feedbackerlib.m.e.b(u(this), "com.larksuite.suite") == true) goto L10;
    }

    private void c0(@NonNull String r7) {
        d0(r7, 2000, 150);
    }

    private void d0(@NonNull String r8, long r9, long r11) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
    L11:
        com.bytedance.feedbackerlib.m.c.b("LarkSSOLaunchTransition", "want to show toast, but: content: " + r8 + ", duringTime: " + r9 + ", animTime: " + r11);
        return;
    L5:
        if (r9 < 0) goto L11;
        if (r11 < 0) goto L11;
        this.p.clearAnimation();
        this.q.setText(r8);
        this.p.setVisibility(0);
        AlphaAnimation r10 = new AlphaAnimation(0.0f, 1.0f);
        r10.setDuration(r11);
        r10.setFillAfter(true);
        r10.setAnimationListener(new c(this, r11, r9));
        this.p.startAnimation(r10);
    }

    private void e0() {
        if (Feedbacker.isFeedbackCommonInfoSetted() == true) goto L9;
        String r0 = this.f3926f.g("sso_network_request_failed");
        if (com.bytedance.common.utility.k.b(r0, "no translation") == true) goto L7;
        r0 = "应用异常，请重新启动应用";
    L7:
        Toast.makeText(this, r0, 1).show();
        return;
    }

    private void f0() {
        PackageManager r0 = getPackageManager();
        Drawable r1 = getApplicationInfo().loadIcon(r0);
        if (r1 == null) goto L6;
        this.f3930j.setImageDrawable(r1);
        return;
    }

    private void g0() {
        Z();
        f0();
    }

    @Proxy("getApplicationContext")
    @TargetClass(scope = Scope.ALL, value = "android.content.Context")
    public static Context u(LarkSSOLaunchTransitionActivity r2) {
        return r2.getApplicationContext();
    L4:
        e = move-exception;
        com.obric.matrix.r.c.c.g("hookGetApplicationContext", "getApplicationContext error", e);
        return com.bytedance.mpaas.app.a.a();
    }

    static /* synthetic */ void w(LarkSSOLaunchTransitionActivity r0) {
        r0.Z();
    }

    static /* synthetic */ TextView x(LarkSSOLaunchTransitionActivity r0) {
        return r0.f3931k;
    }

    static /* synthetic */ void y(LarkSSOLaunchTransitionActivity r0) {
        r0.e0();
    }

    static /* synthetic */ void z(LarkSSOLaunchTransitionActivity r0, String r1) {
        r0.c0(r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int r1, int r2, @Nullable Intent r3) {
        super.onActivityResult(r1, r2, r3);
        com.ss.android.larksso.c.x().A(this, r3);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(@Nullable Bundle r3) {
        super.onCreate(r3);
        setContentView(com.bytedance.feedbackerlib.f.f4025b);
        Feedbacker.init(getApplication(), false);
        a0();
        X();
        g0();
        if (r3 != null) goto L5;
        S(getIntent());
    L5:
        Feedbacker.registerLarkSSOCallback(this.s);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        FloatWindowService.U(false);
        this.f3926f.l(this.r);
        Feedbacker.unregisterLarkSSOCallback(this.s);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent r1) {
        super.onNewIntent(r1);
        S(r1);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        this.f3931k.setVisibility(0);
        Handler r1 = t;
        r1.removeMessages(1);
        r1.removeMessages(2);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        t.postDelayed(new g(this), 2500);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        N(this);
    }

    public void v() {
        super.onStop();
    }
}

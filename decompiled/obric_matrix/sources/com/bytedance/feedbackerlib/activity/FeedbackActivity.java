package com.bytedance.feedbackerlib.activity;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.window.embedding.EmbeddingCompat;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.feedbackerlib.Feedbacker;
import com.bytedance.feedbackerlib.matisse.internal.entity.Item;
import com.bytedance.feedbackerlib.service.FloatWindowService;
import com.bytedance.feedbackerlib.view.CancledUndlineSpan;
import com.bytedance.feedbackerlib.view.CustomEditText;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class FeedbackActivity extends BaseActivity {
    private static final Handler T = null;
    private ImageView A;
    private FrameLayout B;
    private TextView C;
    private RelativeLayout D;
    private TextView E;
    private TextView F;
    private RelativeLayout G;
    private TextView H;
    private j0 I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private j0 f3845J;
    private j0 K;
    private j0 L;
    private j0 M;
    private j0 N;
    private k0 O;
    private final List<Item> P;
    private String Q;
    private boolean R;
    private com.bytedance.feedbackerlib.j.e.b S;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f3846f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f3847g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private com.bytedance.feedbackerlib.model.a f3848h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final com.bytedance.feedbackerlib.j.e f3849i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private RecyclerView f3850j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private RecyclerView f3851k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private RecyclerView f3852l;
    private RecyclerView m;
    private RecyclerView n;
    private RecyclerView o;
    private CustomEditText p;
    private TextView q;
    private TextView r;
    private TextView s;
    private TextView t;
    private TextView u;
    private TextView v;
    private TextView w;
    private TextView x;
    private TextView y;
    private TextView z;

    class a extends RecyclerView.ItemDecoration {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedbackActivity f3853a;

        a(FeedbackActivity r1) {
            this.f3853a = r1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect r1, @NonNull View r2, @NonNull RecyclerView r3, @NonNull RecyclerView.State r4) {
            super.getItemOffsets(r1, r2, r3, r4);
            Resources r0 = this.f3853a.getResources();
            int r5 = r3.getChildAdapterPosition(r2) % 3;
            if (r5 != 0) goto L7;
            int r6 = com.bytedance.feedbackerlib.c.f3989c;
        L5:
            r1.right = r0.getDimensionPixelSize(r6);
        L10:
            int r7 = com.bytedance.feedbackerlib.c.f3989c;
            r1.top = r0.getDimensionPixelSize(r7);
            r1.bottom = r0.getDimensionPixelSize(r7);
            return;
        L7:
            if (r5 != 1) goto L9;
            r6 = com.bytedance.feedbackerlib.c.f3989c;
            r1.left = r0.getDimensionPixelSize(r6);
            goto L5
        L9:
            r1.left = r0.getDimensionPixelSize(com.bytedance.feedbackerlib.c.f3989c);
            goto L10
        }
    }

    class a0 implements com.bytedance.feedbackerlib.model.a.v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedbackActivity f3854a;

        a0(FeedbackActivity r1) {
            this.f3854a = r1;
        }

        @Override // com.bytedance.feedbackerlib.model.a.v
        public void a(int r1, String r2) {
            FeedbackActivity r0 = this.f3854a;
            if (r1 != 0) goto L5;
            FeedbackActivity.g0(r0);
            return;
        L5:
            FeedbackActivity.o0(r0, FeedbackActivity.n0(r0).g("sdk14"));
        }
    }

    class b implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ FeedbackActivity f3855f;

        class a implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ b f3856f;

            a(b r1) {
                this.f3856f = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                FeedbackActivity.J(this.f3856f.f3855f, true);
            }
        }

        /* JADX INFO: renamed from: com.bytedance.feedbackerlib.activity.FeedbackActivity$b$b, reason: collision with other inner class name */
        class C0109b implements com.bytedance.feedbackerlib.model.a.w {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f3857a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f3858b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ b f3859c;

            /* JADX INFO: renamed from: com.bytedance.feedbackerlib.activity.FeedbackActivity$b$b$a */
            class a implements Runnable {

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                final /* synthetic */ String f3860f;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                final /* synthetic */ C0109b f3861g;

                /* JADX INFO: renamed from: com.bytedance.feedbackerlib.activity.FeedbackActivity$b$b$a$a, reason: collision with other inner class name */
                class ViewOnClickListenerC0110a implements View.OnClickListener {

                    /* JADX INFO: renamed from: f, reason: collision with root package name */
                    final /* synthetic */ a f3862f;

                    ViewOnClickListenerC0110a(a r1) {
                        this.f3862f = r1;
                    }

                    @Override // android.view.View.OnClickListener
                    public void onClick(View r1) {
                        FeedbackActivity.N(this.f3862f.f3861g.f3859c.f3855f).performClick();
                    }
                }

                a(C0109b r1, String r2) {
                    this.f3861g = r1;
                    this.f3860f = r2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    FeedbackActivity.H(this.f3861g.f3859c.f3855f).setVisibility(8);
                    com.bytedance.feedbackerlib.m.c.b("FeedbackActivity", "onUploadFinished, failed: " + this.f3860f);
                    com.bytedance.feedbackerlib.m.r.o(this.f3861g.f3857a, "onUploadFinished, failed: " + this.f3860f, new String[0]);
                    if ("create native uploader fail".equals(this.f3860f) == false) goto L6;
                    FeedbackActivity r3 = this.f3861g.f3859c.f3855f;
                    FeedbackActivity.o0(r3, FeedbackActivity.n0(r3).g("sdk20"));
                    return;
                L6:
                    FeedbackActivity.O(this.f3861g.f3859c.f3855f, this.f3860f, new ViewOnClickListenerC0110a(this));
                }
            }

            C0109b(b r1, String r2, String r3) {
                this.f3859c = r1;
                this.f3857a = r2;
                this.f3858b = r3;
            }

            @Override // com.bytedance.feedbackerlib.model.a.w
            @RequiresApi(api = 21)
            public void a(int r5, @Nullable String r6, List<String> r7, List<String> r8) {
                if (r5 != 1) goto L9;
                a r9 = new a(this, r6);
                if (FeedbackActivity.I(this.f3859c.f3855f) == false) goto L7;
                r9.run();
                return;
            L7:
                FeedbackActivity.M().postDelayed(r9, 800 - (System.currentTimeMillis() - FeedbackActivity.K(this.f3859c.f3855f)));
                return;
            L9:
                FeedbackActivity.P(this.f3859c.f3855f, r7, r8, this.f3858b, this.f3857a);
            }
        }

        b(FeedbackActivity r1) {
            this.f3855f = r1;
        }

        @Override // android.view.View.OnClickListener
        @RequiresApi(api = 21)
        public void onClick(View r6) {
            if (FeedbackActivity.m0(this.f3855f).h() != null) goto L7;
            FeedbackActivity r5 = this.f3855f;
            FeedbackActivity.o0(r5, FeedbackActivity.n0(r5).g("sdk15"));
            return;
        L7:
            if (FeedbackActivity.m0(this.f3855f).h().equals(BDLocationException.ERROR_TIMEOUT) == false) goto L21;
            if (FeedbackActivity.w(this.f3855f).h() != null) goto L13;
            FeedbackActivity r7 = this.f3855f;
            FeedbackActivity.o0(r7, FeedbackActivity.n0(r7).g("sdk16"));
            return;
        L13:
            if (FeedbackActivity.x(this.f3855f).h() != null) goto L17;
            FeedbackActivity r8 = this.f3855f;
            FeedbackActivity.o0(r8, FeedbackActivity.n0(r8).g("sdk17"));
            return;
        L17:
            if (FeedbackActivity.y(this.f3855f).h() != null) goto L33;
            FeedbackActivity r9 = this.f3855f;
            FeedbackActivity.o0(r9, FeedbackActivity.n0(r9).g("key_please_select_priori"));
            return;
        L33:
            if (FeedbackActivity.B(this.f3855f).getText() != null) goto L35;
            String r10 = "";
        L37:
            if (r10.length() >= 5) goto L40;
            FeedbackActivity r11 = this.f3855f;
            FeedbackActivity.o0(r11, FeedbackActivity.n0(r11).g("sdk_feedback_character_number_limited"));
            return;
        L40:
            String r12 = "submitFeedback->" + System.currentTimeMillis();
            String r0 = FeedbackActivity.C(this.f3855f);
            if (TextUtils.isEmpty(r0) == false) goto L45;
            com.bytedance.feedbackerlib.m.r.o(r12, "ssoEmail is null", new String[0]);
            com.bytedance.feedbackerlib.m.c.b("FeedbackActivity", "ssoEmail is null");
            FeedbackActivity.D(this.f3855f);
            return;
        L45:
            if (FeedbackActivity.E(this.f3855f) != null) goto L47;
        L53:
            FeedbackActivity.P(this.f3855f, new ArrayList(), new ArrayList(), r0, r12);
            return;
        L47:
            if (FeedbackActivity.E(this.f3855f).size() <= 0) goto L53;
            FeedbackActivity.F(this.f3855f).setText(FeedbackActivity.n0(this.f3855f).g("sdk19"));
            FeedbackActivity.H(this.f3855f).setVisibility(0);
            FeedbackActivity.J(this.f3855f, false);
            FeedbackActivity.L(this.f3855f, System.currentTimeMillis());
            FeedbackActivity.M().postDelayed(new a(this), 800);
            ArrayList r1 = new ArrayList();
            Iterator r2 = FeedbackActivity.E(this.f3855f).iterator();
        L50:
            if (r2.hasNext() == false) goto L52;
            r1.add(((Item) r2.next()).f4335h);
            goto L50
        L52:
            FeedbackActivity.Q(this.f3855f).h0(r1, new C0109b(this, r12, r0), r12);
            return;
        L35:
            r10 = FeedbackActivity.B(this.f3855f).getText().toString();
            goto L37
        L21:
            if (FeedbackActivity.m0(this.f3855f).h().equals(LocationInfoConst.ALLOW_USE_LOCATION) == false) goto L27;
            if (FeedbackActivity.z(this.f3855f).h() != null) goto L33;
            FeedbackActivity.o0(this.f3855f, "请选择模块");
            return;
        L27:
            if (FeedbackActivity.m0(this.f3855f).h().equals("7") == false) goto L33;
            if (FeedbackActivity.A(this.f3855f).h() != null) goto L33;
            FeedbackActivity.o0(this.f3855f, "请选择模块");
        }
    }

    class b0 implements com.bytedance.feedbackerlib.model.a.v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedbackActivity f3863a;

        b0(FeedbackActivity r1) {
            this.f3863a = r1;
        }

        @Override // com.bytedance.feedbackerlib.model.a.v
        public void a(int r1, String r2) {
            FeedbackActivity r0 = this.f3863a;
            if (r1 != 0) goto L5;
            FeedbackActivity.h0(r0);
            return;
        L5:
            FeedbackActivity.o0(r0, FeedbackActivity.n0(r0).g("sdk14"));
        }
    }

    class c implements j0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedbackActivity f3864a;

        c(FeedbackActivity r1) {
            this.f3864a = r1;
        }

        @Override // com.bytedance.feedbackerlib.activity.FeedbackActivity.j0.a
        public void a(String r1, boolean r2) {
            FeedbackActivity.R(this.f3864a);
        }
    }

    class c0 implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ FeedbackActivity f3865f;

        c0(FeedbackActivity r1) {
            this.f3865f = r1;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r1) {
            FeedbackActivity.e0(this.f3865f);
            FeedbackActivity.l0(this.f3865f);
        }
    }

    class d implements j0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedbackActivity f3866a;

        d(FeedbackActivity r1) {
            this.f3866a = r1;
        }

        @Override // com.bytedance.feedbackerlib.activity.FeedbackActivity.j0.a
        public void a(String r1, boolean r2) {
            FeedbackActivity.R(this.f3866a);
        }
    }

    class d0 extends RecyclerView.ItemDecoration {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedbackActivity f3867a;

        d0(FeedbackActivity r1) {
            this.f3867a = r1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect r1, @NonNull View r2, @NonNull RecyclerView r3, @NonNull RecyclerView.State r4) {
            super.getItemOffsets(r1, r2, r3, r4);
            Resources r0 = this.f3867a.getResources();
            int r5 = r3.getChildAdapterPosition(r2) % 3;
            if (r5 != 0) goto L7;
            int r6 = com.bytedance.feedbackerlib.c.f3989c;
        L5:
            r1.right = r0.getDimensionPixelSize(r6);
        L10:
            int r7 = com.bytedance.feedbackerlib.c.f3989c;
            r1.top = r0.getDimensionPixelSize(r7);
            r1.bottom = r0.getDimensionPixelSize(r7);
            return;
        L7:
            if (r5 != 1) goto L9;
            r6 = com.bytedance.feedbackerlib.c.f3989c;
            r1.left = r0.getDimensionPixelSize(r6);
            goto L5
        L9:
            r1.left = r0.getDimensionPixelSize(com.bytedance.feedbackerlib.c.f3989c);
            goto L10
        }
    }

    class e implements j0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedbackActivity f3868a;

        e(FeedbackActivity r1) {
            this.f3868a = r1;
        }

        @Override // com.bytedance.feedbackerlib.activity.FeedbackActivity.j0.a
        public void a(String r1, boolean r2) {
            FeedbackActivity.R(this.f3868a);
        }
    }

    class e0 extends RecyclerView.ItemDecoration {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedbackActivity f3869a;

        e0(FeedbackActivity r1) {
            this.f3869a = r1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect r1, @NonNull View r2, @NonNull RecyclerView r3, @NonNull RecyclerView.State r4) {
            super.getItemOffsets(r1, r2, r3, r4);
            Resources r0 = this.f3869a.getResources();
            int r5 = r3.getChildAdapterPosition(r2) % 3;
            if (r5 != 0) goto L7;
            int r6 = com.bytedance.feedbackerlib.c.f3989c;
        L5:
            r1.right = r0.getDimensionPixelSize(r6);
        L10:
            int r7 = com.bytedance.feedbackerlib.c.f3989c;
            r1.top = r0.getDimensionPixelSize(r7);
            r1.bottom = r0.getDimensionPixelSize(r7);
            return;
        L7:
            if (r5 != 1) goto L9;
            r6 = com.bytedance.feedbackerlib.c.f3989c;
            r1.left = r0.getDimensionPixelSize(r6);
            goto L5
        L9:
            r1.left = r0.getDimensionPixelSize(com.bytedance.feedbackerlib.c.f3989c);
            goto L10
        }
    }

    class f implements j0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedbackActivity f3870a;

        f(FeedbackActivity r1) {
            this.f3870a = r1;
        }

        @Override // com.bytedance.feedbackerlib.activity.FeedbackActivity.j0.a
        public void a(String r1, boolean r2) {
            FeedbackActivity.R(this.f3870a);
        }
    }

    class f0 extends RecyclerView.ItemDecoration {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedbackActivity f3871a;

        f0(FeedbackActivity r1) {
            this.f3871a = r1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect r1, @NonNull View r2, @NonNull RecyclerView r3, @NonNull RecyclerView.State r4) {
            super.getItemOffsets(r1, r2, r3, r4);
            Resources r0 = this.f3871a.getResources();
            int r5 = r3.getChildAdapterPosition(r2) % 3;
            if (r5 != 0) goto L7;
            int r6 = com.bytedance.feedbackerlib.c.f3989c;
        L5:
            r1.right = r0.getDimensionPixelSize(r6);
        L10:
            int r7 = com.bytedance.feedbackerlib.c.f3989c;
            r1.top = r0.getDimensionPixelSize(r7);
            r1.bottom = r0.getDimensionPixelSize(r7);
            return;
        L7:
            if (r5 != 1) goto L9;
            r6 = com.bytedance.feedbackerlib.c.f3989c;
            r1.left = r0.getDimensionPixelSize(r6);
            goto L5
        L9:
            r1.left = r0.getDimensionPixelSize(com.bytedance.feedbackerlib.c.f3989c);
            goto L10
        }
    }

    class g implements j0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedbackActivity f3872a;

        g(FeedbackActivity r1) {
            this.f3872a = r1;
        }

        @Override // com.bytedance.feedbackerlib.activity.FeedbackActivity.j0.a
        public void a(String r1, boolean r2) {
            FeedbackActivity.R(this.f3872a);
        }
    }

    class g0 extends RecyclerView.ItemDecoration {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedbackActivity f3873a;

        g0(FeedbackActivity r1) {
            this.f3873a = r1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect r1, @NonNull View r2, @NonNull RecyclerView r3, @NonNull RecyclerView.State r4) {
            super.getItemOffsets(r1, r2, r3, r4);
            Resources r0 = this.f3873a.getResources();
            int r5 = r3.getChildAdapterPosition(r2) % 3;
            if (r5 != 0) goto L7;
            int r6 = com.bytedance.feedbackerlib.c.f3989c;
        L5:
            r1.right = r0.getDimensionPixelSize(r6);
        L10:
            int r7 = com.bytedance.feedbackerlib.c.f3989c;
            r1.top = r0.getDimensionPixelSize(r7);
            r1.bottom = r0.getDimensionPixelSize(r7);
            return;
        L7:
            if (r5 != 1) goto L9;
            r6 = com.bytedance.feedbackerlib.c.f3989c;
            r1.left = r0.getDimensionPixelSize(r6);
            goto L5
        L9:
            r1.left = r0.getDimensionPixelSize(com.bytedance.feedbackerlib.c.f3989c);
            goto L10
        }
    }

    class h implements j0.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedbackActivity f3874a;

        h(FeedbackActivity r1) {
            this.f3874a = r1;
        }

        @Override // com.bytedance.feedbackerlib.activity.FeedbackActivity.j0.a
        public void a(String r1, boolean r2) {
            FeedbackActivity.R(this.f3874a);
            if (TextUtils.isEmpty(r1) == false) goto L5;
            return;
        L5:
            FeedbackActivity.S(this.f3874a);
        }
    }

    class h0 extends RecyclerView.ItemDecoration {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedbackActivity f3875a;

        h0(FeedbackActivity r1) {
            this.f3875a = r1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect r1, @NonNull View r2, @NonNull RecyclerView r3, @NonNull RecyclerView.State r4) {
            super.getItemOffsets(r1, r2, r3, r4);
            Resources r0 = this.f3875a.getResources();
            int r5 = r3.getChildAdapterPosition(r2) % 3;
            if (r5 != 0) goto L7;
            int r6 = com.bytedance.feedbackerlib.c.f3989c;
        L5:
            r1.right = r0.getDimensionPixelSize(r6);
        L10:
            int r7 = com.bytedance.feedbackerlib.c.f3989c;
            r1.top = r0.getDimensionPixelSize(r7);
            r1.bottom = r0.getDimensionPixelSize(r7);
            return;
        L7:
            if (r5 != 1) goto L9;
            r6 = com.bytedance.feedbackerlib.c.f3989c;
            r1.left = r0.getDimensionPixelSize(r6);
            goto L5
        L9:
            r1.left = r0.getDimensionPixelSize(com.bytedance.feedbackerlib.c.f3989c);
            goto L10
        }
    }

    class i implements TextWatcher {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ FeedbackActivity f3876f;

        i(FeedbackActivity r1) {
            this.f3876f = r1;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable r1) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence r1, int r2, int r3, int r4) {
            FeedbackActivity.U(this.f3876f).setText(r1.length() + "/200");
            if (r1.length() <= 200) goto L5;
            FeedbackActivity.B(this.f3876f).setText(FeedbackActivity.B(this.f3876f).getText().toString().substring(0, 200));
            FeedbackActivity.B(this.f3876f).setSelection(200);
            FeedbackActivity.V(this.f3876f);
        L5:
            FeedbackActivity.R(this.f3876f);
        }
    }

    class i0 extends RecyclerView.ItemDecoration {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedbackActivity f3877a;

        i0(FeedbackActivity r1) {
            this.f3877a = r1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NonNull Rect r1, @NonNull View r2, @NonNull RecyclerView r3, @NonNull RecyclerView.State r4) {
            super.getItemOffsets(r1, r2, r3, r4);
            Resources r0 = this.f3877a.getResources();
            int r5 = r3.getChildAdapterPosition(r2) % 3;
            if (r5 != 0) goto L7;
            int r6 = com.bytedance.feedbackerlib.c.f3989c;
        L5:
            r1.right = r0.getDimensionPixelSize(r6);
        L10:
            int r7 = com.bytedance.feedbackerlib.c.f3989c;
            r1.top = r0.getDimensionPixelSize(r7);
            r1.bottom = r0.getDimensionPixelSize(r7);
            return;
        L7:
            if (r5 != 1) goto L9;
            r6 = com.bytedance.feedbackerlib.c.f3989c;
            r1.left = r0.getDimensionPixelSize(r6);
            goto L5
        L9:
            r1.left = r0.getDimensionPixelSize(com.bytedance.feedbackerlib.c.f3989c);
            goto L10
        }
    }

    class j implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ FeedbackActivity f3878f;

        j(FeedbackActivity r1) {
            this.f3878f = r1;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r1) {
            this.f3878f.onBackPressed();
        }
    }

    private static class j0 extends RecyclerView.Adapter<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f3879a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<com.bytedance.feedbackerlib.model.e.c> f3880b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private a f3881c;

        interface a {
            void a(String r1, boolean r2);
        }

        class b extends RecyclerView.ViewHolder {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private com.bytedance.feedbackerlib.model.e.c f3882a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private TextView f3883b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ j0 f3884c;

            class a implements View.OnClickListener {

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                final /* synthetic */ b f3885f;

                a(b r1, j0 r2) {
                    this.f3885f = r1;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View r4) {
                    j0.d(this.f3885f.f3884c, b.b(this.f3885f).f4617a + "");
                    this.f3885f.f3884c.notifyDataSetChanged();
                    if (j0.e(this.f3885f.f3884c) == null) goto L6;
                    j0.e(this.f3885f.f3884c).a(j0.c(this.f3885f.f3884c), true);
                    return;
                }
            }

            b(@NonNull j0 r2, View r3) {
                this.f3884c = r2;
                super(r3);
                this.f3883b = (TextView) r3.findViewById(com.bytedance.feedbackerlib.e.l0);
                r3.setOnClickListener(new a(this, r2));
            }

            static /* synthetic */ void a(b r0, com.bytedance.feedbackerlib.model.e.c r1) {
                r0.c(r1);
            }

            static /* synthetic */ com.bytedance.feedbackerlib.model.e.c b(b r0) {
                return r0.f3882a;
            }

            private void c(com.bytedance.feedbackerlib.model.e.c r3) {
                this.f3882a = r3;
                this.f3883b.setText(r3.f4618b);
                if ((this.f3882a.f4617a + "").equals(j0.c(this.f3884c)) == false) goto L5;
                this.f3883b.setTextColor(ContextCompat.getColor(this.itemView.getContext().getApplicationContext(), com.bytedance.feedbackerlib.b.f3984a));
                return;
            L5:
                this.f3883b.setTextColor(Color.rgb(34, 34, 34));
            }
        }

        private j0() {
            this.f3879a = null;
            this.f3880b = new ArrayList();
        }

        /* synthetic */ j0(k r1) {
            this();
        }

        static /* synthetic */ String c(j0 r0) {
            return r0.f3879a;
        }

        static /* synthetic */ String d(j0 r0, String r1) {
            r0.f3879a = r1;
            return r1;
        }

        static /* synthetic */ a e(j0 r0) {
            return r0.f3881c;
        }

        private com.bytedance.feedbackerlib.model.e.c f(int r1) {
            return this.f3880b.get(r1);
        }

        com.bytedance.feedbackerlib.model.e.c g(String r6) {
            if (TextUtils.isEmpty(r6) == true) goto L13;
            List<com.bytedance.feedbackerlib.model.e.c> r5 = this.f3880b;
            if (r5 == null) goto L13;
            Iterator<com.bytedance.feedbackerlib.model.e.c> r7 = r5.iterator();
        L9:
            if (r7.hasNext() == false) goto L13;
            com.bytedance.feedbackerlib.model.e.c r0 = r7.next();
            if (r6.equals(r0.f4617a + "") == false) goto L9;
            return r0;
        L13:
            return null;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f3880b.size();
        }

        String h() {
            return this.f3879a;
        }

        public void i(@NonNull b r1, int r2) {
            b.a(r1, f(r2));
        }

        @NonNull
        public b j(@NonNull ViewGroup r3, int r4) {
            return new b(this, LayoutInflater.from(r3.getContext()).inflate(com.bytedance.feedbackerlib.f.v, r3, false));
        }

        public void k(List<com.bytedance.feedbackerlib.model.e.c> r1) {
            if (r1 != null) goto L4;
            this.f3880b.clear();
        L5:
            notifyDataSetChanged();
            return;
        L4:
            this.f3880b = r1;
            goto L5
        }

        void l(a r1) {
            this.f3881c = r1;
        }

        void m(String r1) {
            this.f3879a = r1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ void onBindViewHolder(@NonNull RecyclerView.ViewHolder r1, int r2) {
            i((b) r1, r2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup r1, int r2) {
            return j(r1, r2);
        }
    }

    class k implements com.bytedance.feedbackerlib.j.e.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedbackActivity f3886a;

        k(FeedbackActivity r1) {
            this.f3886a = r1;
        }

        @Override // com.bytedance.feedbackerlib.j.e.b
        public void a() {
            FeedbackActivity.G(this.f3886a);
        }
    }

    private class k0 extends RecyclerView.Adapter<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedbackActivity f3887a;

        class a extends RecyclerView.ViewHolder {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final ImageView f3888a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final ImageView f3889b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final TextView f3890c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            final /* synthetic */ k0 f3891d;

            /* JADX INFO: renamed from: com.bytedance.feedbackerlib.activity.FeedbackActivity$k0$a$a, reason: collision with other inner class name */
            class ViewOnClickListenerC0111a implements View.OnClickListener {

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                final /* synthetic */ a f3892f;

                ViewOnClickListenerC0111a(a r1, k0 r2) {
                    this.f3892f = r1;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View r1) {
                    int r2 = this.f3892f.getAdapterPosition();
                    k0.c(this.f3892f.f3891d, r2);
                }
            }

            class b implements View.OnClickListener {

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                final /* synthetic */ a f3893f;

                b(a r1, k0 r2) {
                    this.f3893f = r1;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View r4) {
                    if (this.f3893f.getAdapterPosition() != FeedbackActivity.E(this.f3893f.f3891d.f3887a).size()) goto L6;
                    com.bytedance.feedbackerlib.k.c r5 = com.bytedance.feedbackerlib.k.a.b(this.f3893f.f3891d.f3887a).a(com.bytedance.feedbackerlib.k.b.k(), false);
                    r5.f(true);
                    r5.e(true);
                    r5.m(com.bytedance.feedbackerlib.h.f4046a);
                    r5.k(true);
                    r5.h(new com.bytedance.feedbackerlib.k.d.b.a());
                    r5.i(6);
                    r5.j(1);
                    r5.l(4);
                    r5.d(FeedbackActivity.E(this.f3893f.f3891d.f3887a));
                    r5.c(FeedbackActivity.i0(this.f3893f.f3891d.f3887a));
                    r5.g(0);
                    return;
                }
            }

            public a(@NonNull k0 r4, View r5) {
                this.f3891d = r4;
                super(r5);
                ImageView r0 = (ImageView) r5.findViewById(com.bytedance.feedbackerlib.e.u);
                this.f3888a = r0;
                ImageView r1 = (ImageView) r5.findViewById(com.bytedance.feedbackerlib.e.x);
                this.f3889b = r1;
                this.f3890c = (TextView) r5.findViewById(com.bytedance.feedbackerlib.e.i1);
                r0.setOnClickListener(new ViewOnClickListenerC0111a(this, r4));
                r1.setOnClickListener(new b(this, r4));
            }

            @Proxy("getApplicationContext")
            @TargetClass(scope = Scope.ALL, value = "android.content.Context")
            public static Context a(FeedbackActivity r2) {
                return r2.getApplicationContext();
            L4:
                e = move-exception;
                com.obric.matrix.r.c.c.g("hookGetApplicationContext", "getApplicationContext error", e);
                return com.bytedance.mpaas.app.a.a();
            }

            static /* synthetic */ void b(a r0, Uri r1) {
                r0.c(r1);
            }

            private void c(@Nullable Uri r7) {
                if (r7 == null) goto L12;
                this.f3888a.setVisibility(0);
                d.b.k.a.t r2 = d.b.k.a.q.f(r7);
                r2.a(d.b.k.a.u.f14079l);
                d.b.k.a.e.b r4 = d.b.k.a.e.i();
                r4.j(6.0f);
                r2.e(r4.i());
                r2.d("FeedbackActivity");
                r2.S(this.f3889b);
                r2.g();
                long r0 = com.bytedance.feedbackerlib.m.j.d(a(this.f3891d.f3887a), r7);
                if (r0 <= 0) goto L11;
                this.f3890c.setVisibility(0);
                TextView r6 = this.f3890c;
                if (r0 < 1000) goto L9;
                StringBuilder r8 = new StringBuilder();
                r8.append("");
                r8.append(r0 / 1000);
            L10:
                r8.append("s");
                r6.setText(r8.toString());
                return;
            L9:
                r8 = new StringBuilder();
                r8.append("");
                r8.append(Math.round(r0 / 100.0f) / 10.0f);
                goto L10
            L11:
                this.f3890c.setVisibility(4);
                return;
            L12:
                this.f3888a.setVisibility(8);
                this.f3890c.setVisibility(8);
                d.b.k.a.t r9 = d.b.k.a.q.e(com.bytedance.feedbackerlib.d.f4006h);
                r9.a(d.b.k.a.u.f14079l);
                d.b.k.a.e.b r3 = d.b.k.a.e.i();
                r3.j(6.0f);
                r9.e(r3.i());
                r9.d("FeedbackActivity");
                r9.S(this.f3889b);
                r9.g();
            }
        }

        private k0(FeedbackActivity r1) {
            this.f3887a = r1;
        }

        /* synthetic */ k0(FeedbackActivity r1, k r2) {
            this(r1);
        }

        static /* synthetic */ void c(k0 r0, int r1) {
            r0.g(r1);
        }

        @Nullable
        private Uri d(int r2) {
            if (r2 < FeedbackActivity.E(this.f3887a).size()) goto L5;
            return null;
        L5:
            return ((Item) FeedbackActivity.E(this.f3887a).get(r2)).f4335h;
        }

        private void g(int r2) {
            if (r2 >= 0) goto L4;
            return;
        L4:
            if (r2 >= FeedbackActivity.E(this.f3887a).size()) goto L10;
            FeedbackActivity.E(this.f3887a).remove(r2);
            notifyItemRemoved(r2);
            if (FeedbackActivity.E(this.f3887a).size() > 0) goto L11;
            FeedbackActivity.j0(this.f3887a, false);
            return;
        L11:
            return;
        }

        public void e(@NonNull a r1, int r2) {
            a.b(r1, d(r2));
        }

        @NonNull
        public a f(@NonNull ViewGroup r3, int r4) {
            Context r5 = r3.getContext();
            if (r5 == null) goto L5;
            r5 = r5.getApplicationContext();
        L5:
            if (r5 != null) goto L9;
            return null;
        L9:
            return new a(this, LayoutInflater.from(r5).inflate(com.bytedance.feedbackerlib.f.t, r3, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            int r0 = FeedbackActivity.E(this.f3887a).size();
            int r2 = FeedbackActivity.E(this.f3887a).size();
            if (r0 < 6) goto L5;
            return r2;
        L5:
            return r2 + 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public /* bridge */ /* synthetic */ void onBindViewHolder(@NonNull RecyclerView.ViewHolder r1, int r2) {
            e((a) r1, r2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        @NonNull
        public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup r1, int r2) {
            return f(r1, r2);
        }
    }

    class l implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ FeedbackActivity f3894f;

        l(FeedbackActivity r1) {
            this.f3894f = r1;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r1) {
            FeedbackActivity.W(this.f3894f);
        }
    }

    class m extends ClickableSpan {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ FeedbackActivity f3895f;

        m(FeedbackActivity r1) {
            this.f3895f = r1;
        }

        @Proxy("getApplicationContext")
        @TargetClass(scope = Scope.ALL, value = "android.content.Context")
        public static Context a(FeedbackActivity r2) {
            return r2.getApplicationContext();
        L4:
            e = move-exception;
            com.obric.matrix.r.c.c.g("hookGetApplicationContext", "getApplicationContext error", e);
            return com.bytedance.mpaas.app.a.a();
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View r4) {
            if (com.bytedance.feedbackerlib.m.h.a(a(this.f3895f)) == true) goto L5;
            String r0 = FeedbackActivity.n0(this.f3895f).g("sdk_feedback_toast");
            FeedbackActivity.o0(this.f3895f, r0);
        L7:
            if ((r4 instanceof TextView) == false) goto L10;
            ((TextView) r4).setHighlightColor(this.f3895f.getResources().getColor(R.color.transparent));
            return;
        L10:
            return;
        L5:
            Intent r1 = new Intent("android.intent.action.VIEW", Uri.parse("https://applink.feishu.cn/client/bot/open?appId=cli_a0bdad723f38500d"));
            this.f3895f.startActivity(r1);
            goto L7
        }
    }

    class n implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ FeedbackActivity f3896f;

        n(FeedbackActivity r1) {
            this.f3896f = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            FeedbackActivity.J(this.f3896f, true);
        }
    }

    class o implements com.bytedance.feedbackerlib.model.a.v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f3897a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ List f3898b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f3899c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f3900d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ FeedbackActivity f3901e;

        class a implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f3902f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ String f3903g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ o f3904h;

            /* JADX INFO: renamed from: com.bytedance.feedbackerlib.activity.FeedbackActivity$o$a$a, reason: collision with other inner class name */
            class ViewOnClickListenerC0112a implements View.OnClickListener {

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                final /* synthetic */ a f3905f;

                ViewOnClickListenerC0112a(a r1) {
                    this.f3905f = r1;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View r5) {
                    o r6 = this.f3905f.f3904h;
                    FeedbackActivity.P(r6.f3901e, r6.f3897a, r6.f3898b, r6.f3899c, r6.f3900d);
                    com.bytedance.feedbackerlib.m.r.o(this.f3905f.f3904h.f3900d, "uploadFailed_and_retry", new String[0]);
                }
            }

            class b implements Runnable {

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                final /* synthetic */ a f3906f;

                b(a r1) {
                    this.f3906f = r1;
                }

                @Override // java.lang.Runnable
                public void run() {
                    FeedbackActivity.H(this.f3906f.f3904h.f3901e).setVisibility(8);
                    FeedbackActivity.T(this.f3906f.f3904h.f3901e);
                    FeedbackActivity.e0(this.f3906f.f3904h.f3901e);
                    FeedbackActivity.X(this.f3906f.f3904h.f3901e);
                    this.f3906f.f3904h.f3901e.finish();
                }
            }

            a(o r1, int r2, String r3) {
                this.f3904h = r1;
                this.f3902f = r2;
                this.f3903g = r3;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f3902f != 1) goto L6;
                com.bytedance.feedbackerlib.m.r.f("upload_fail", null);
                FeedbackActivity.H(this.f3904h.f3901e).setVisibility(8);
                FeedbackActivity.O(this.f3904h.f3901e, this.f3903g, new ViewOnClickListenerC0112a(this));
                return;
            L6:
                FeedbackActivity.F(this.f3904h.f3901e).setText(FeedbackActivity.n0(this.f3904h.f3901e).g("sdk_submit_feedback_succeed"));
                FeedbackActivity.H(this.f3904h.f3901e).setVisibility(0);
                com.bytedance.feedbackerlib.m.c.b("FeedbackActivity", "upload succeed");
                com.bytedance.feedbackerlib.m.r.o(this.f3904h.f3900d, "upload succeed", new String[0]);
                com.bytedance.feedbackerlib.m.r.b();
                FeedbackActivity.M().postDelayed(new b(this), 500);
            }
        }

        o(FeedbackActivity r1, List r2, List r3, String r4, String r5) {
            this.f3901e = r1;
            this.f3897a = r2;
            this.f3898b = r3;
            this.f3899c = r4;
            this.f3900d = r5;
        }

        @Override // com.bytedance.feedbackerlib.model.a.v
        public void a(int r8, String r9) {
            a r0 = new a(this, r8, r9);
            if (FeedbackActivity.I(this.f3901e) == false) goto L5;
            r0.run();
            return;
        L5:
            FeedbackActivity.M().postDelayed(r0, 500 - (System.currentTimeMillis() - FeedbackActivity.K(this.f3901e)));
        }
    }

    class p implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ AlertDialog f3907f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ View.OnClickListener f3908g;

        p(FeedbackActivity r1, AlertDialog r2, View.OnClickListener r3) {
            this.f3907f = r2;
            this.f3908g = r3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r2) {
            this.f3907f.dismiss();
            View.OnClickListener r1 = this.f3908g;
            if (r1 == null) goto L6;
            r1.onClick(r2);
            return;
        }
    }

    class q implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f3909a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f3910b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ FeedbackActivity f3911c;

        class a implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ q f3912f;

            a(q r1) {
                this.f3912f = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                q r3 = this.f3912f;
                FeedbackActivity.Y(r3.f3911c, r3.f3909a);
            }
        }

        q(FeedbackActivity r1, long r2, long r4) {
            this.f3911c = r1;
            this.f3909a = r2;
            this.f3910b = r4;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation r4) {
            FeedbackActivity.M().removeMessages(1024);
            Message r5 = Message.obtain(FeedbackActivity.M(), new a(this));
            r5.what = 1024;
            FeedbackActivity.M().sendMessageDelayed(r5, this.f3910b);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation r1) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation r1) {
        }
    }

    class r implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedbackActivity f3913a;

        r(FeedbackActivity r1) {
            this.f3913a = r1;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation r1) {
            FeedbackActivity.Z(this.f3913a).setVisibility(8);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation r1) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation r1) {
        }
    }

    class s implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ AlertDialog f3914f;

        s(FeedbackActivity r1, AlertDialog r2) {
            this.f3914f = r2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r1) {
            this.f3914f.dismiss();
        }
    }

    class t implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f3915a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f3916b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ FeedbackActivity f3917c;

        class a implements Runnable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ t f3918f;

            a(t r1) {
                this.f3918f = r1;
            }

            @Override // java.lang.Runnable
            public void run() {
                t r3 = this.f3918f;
                FeedbackActivity.a0(r3.f3917c, r3.f3915a);
            }
        }

        t(FeedbackActivity r1, long r2, long r4) {
            this.f3917c = r1;
            this.f3915a = r2;
            this.f3916b = r4;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation r4) {
            FeedbackActivity.M().removeMessages(1024);
            Message r5 = Message.obtain(FeedbackActivity.M(), new a(this));
            r5.what = 1024;
            FeedbackActivity.M().sendMessageDelayed(r5, this.f3916b);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation r1) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation r1) {
        }
    }

    class u implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedbackActivity f3919a;

        u(FeedbackActivity r1) {
            this.f3919a = r1;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation r1) {
            FeedbackActivity.b0(this.f3919a).setVisibility(8);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation r1) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation r1) {
        }
    }

    class v implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ AlertDialog f3920f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ FeedbackActivity f3921g;

        v(FeedbackActivity r1, AlertDialog r2) {
            this.f3921g = r1;
            this.f3920f = r2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r1) {
            this.f3920f.dismiss();
            FeedbackActivity.T(this.f3921g);
            FeedbackActivity.e0(this.f3921g);
            FeedbackActivity.k0(this.f3921g);
        }
    }

    class w implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ AlertDialog f3922f;

        w(FeedbackActivity r1, AlertDialog r2) {
            this.f3922f = r2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r1) {
            this.f3922f.dismiss();
        }
    }

    class x extends ClickableSpan {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ FeedbackActivity f3923f;

        x(FeedbackActivity r1) {
            this.f3923f = r1;
        }

        @Proxy("getApplicationContext")
        @TargetClass(scope = Scope.ALL, value = "android.content.Context")
        public static Context a(FeedbackActivity r2) {
            return r2.getApplicationContext();
        L4:
            e = move-exception;
            com.obric.matrix.r.c.c.g("hookGetApplicationContext", "getApplicationContext error", e);
            return com.bytedance.mpaas.app.a.a();
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View r4) {
            if (com.bytedance.feedbackerlib.m.h.a(a(this.f3923f)) == true) goto L5;
            String r0 = FeedbackActivity.n0(this.f3923f).g("sdk_feedback_toast");
            FeedbackActivity.c0(this.f3923f, r0);
        L7:
            if ((r4 instanceof TextView) == false) goto L10;
            ((TextView) r4).setHighlightColor(this.f3923f.getResources().getColor(R.color.transparent));
            return;
        L10:
            return;
        L5:
            Intent r1 = new Intent("android.intent.action.VIEW", Uri.parse("https://applink.feishu.cn/client/bot/open?appId=cli_a0bdad723f38500d"));
            this.f3923f.startActivity(r1);
            goto L7
        }
    }

    class y implements com.bytedance.feedbackerlib.model.a.v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedbackActivity f3924a;

        y(FeedbackActivity r1) {
            this.f3924a = r1;
        }

        @Override // com.bytedance.feedbackerlib.model.a.v
        public void a(int r1, String r2) {
            FeedbackActivity r0 = this.f3924a;
            if (r1 != 0) goto L5;
            FeedbackActivity.d0(r0);
            return;
        L5:
            FeedbackActivity.o0(r0, FeedbackActivity.n0(r0).g("sdk14"));
        }
    }

    class z implements com.bytedance.feedbackerlib.model.a.v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ FeedbackActivity f3925a;

        z(FeedbackActivity r1) {
            this.f3925a = r1;
        }

        @Override // com.bytedance.feedbackerlib.model.a.v
        public void a(int r1, String r2) {
            FeedbackActivity r0 = this.f3925a;
            if (r1 != 0) goto L5;
            FeedbackActivity.f0(r0);
            return;
        L5:
            FeedbackActivity.o0(r0, FeedbackActivity.n0(r0).g("sdk14"));
        }
    }

    static {
        T = new Handler(Looper.getMainLooper());
    }

    public FeedbackActivity() {
        this.f3847g = false;
        this.f3848h = com.bytedance.feedbackerlib.model.a.I();
        this.f3849i = com.bytedance.feedbackerlib.j.e.e();
        k r1 = null;
        this.I = new j0(r1);
        this.f3845J = new j0(r1);
        this.K = new j0(r1);
        this.L = new j0(r1);
        this.M = new j0(r1);
        this.N = new j0(r1);
        this.O = new k0(this, r1);
        this.P = new ArrayList();
        this.S = new k(this);
    }

    static /* synthetic */ j0 A(FeedbackActivity r0) {
        return r0.N;
    }

    private void A0() {
        List<com.bytedance.feedbackerlib.model.e.c> r0 = this.f3848h.D();
        if (r0 == null) goto L6;
        this.M.k(r0);
        return;
    L6:
        this.f3848h.Y(new a0(this));
    }

    static /* synthetic */ CustomEditText B(FeedbackActivity r0) {
        return r0.p;
    }

    private void B0() {
        Iterator<Item> r0 = com.bytedance.feedbackerlib.m.q.d.o.b().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        p0(r0.next());
        goto L4
    L6:
        String r1 = com.bytedance.feedbackerlib.m.q.d.f4312g.a(null);
        this.K.m(r1);
        String r2 = com.bytedance.feedbackerlib.m.q.d.f4314i.a(null);
        this.f3845J.m(r2);
        String r3 = com.bytedance.feedbackerlib.m.q.d.f4313h.a(null);
        this.I.m(r3);
        String r4 = com.bytedance.feedbackerlib.m.q.d.f4315j.a(null);
        this.L.m(r4);
        String r5 = com.bytedance.feedbackerlib.m.q.d.f4316k.a(null);
        this.M.m(r5);
        String r6 = com.bytedance.feedbackerlib.m.q.d.f4317l.a(null);
        this.N.m(r6);
        this.p.setText(com.bytedance.feedbackerlib.m.q.d.m.a(""));
        this.R = com.bytedance.feedbackerlib.m.q.a.f4296g.a(false);
    }

    static /* synthetic */ String C(FeedbackActivity r0) {
        return r0.t0();
    }

    private void C0() {
        List<com.bytedance.feedbackerlib.model.e.c> r0 = this.f3848h.H();
        if (r0 == null) goto L6;
        this.N.k(r0);
        return;
    L6:
        this.f3848h.Y(new z(this));
    }

    static /* synthetic */ void D(FeedbackActivity r0) {
        r0.E0();
    }

    private void D0() {
        J0();
        G0();
        A0();
        C0();
        H0();
        F0();
        K0();
        B0();
        I0();
    }

    static /* synthetic */ List E(FeedbackActivity r0) {
        return r0.P;
    }

    private void E0() {
        if (TextUtils.isEmpty(t0()) == true) goto L5;
        return;
    L5:
        FloatWindowService.k(v(this), "feedback_activity_init_lark_sso->" + System.currentTimeMillis());
    }

    static /* synthetic */ TextView F(FeedbackActivity r0) {
        return r0.C;
    }

    private void F0() {
        List<com.bytedance.feedbackerlib.model.e.c> r0 = this.f3848h.K();
        this.L.k(r0);
    }

    static /* synthetic */ void G(FeedbackActivity r0) {
        r0.P0();
    }

    private void G0() {
        List<com.bytedance.feedbackerlib.model.e.c> r0 = this.f3848h.G();
        if (r0 == null) goto L6;
        Q0(r0);
        this.f3845J.k(r0);
        return;
    L6:
        this.f3848h.Y(new b0(this));
    }

    static /* synthetic */ FrameLayout H(FeedbackActivity r0) {
        return r0.B;
    }

    private void H0() {
        List<com.bytedance.feedbackerlib.model.e.c> r0 = this.f3848h.L();
        this.I.k(r0);
    }

    static /* synthetic */ boolean I(FeedbackActivity r0) {
        return r0.f3847g;
    }

    private void I0() {
        Parcelable[] r0 = getIntent().getParcelableArrayExtra("extra_selected_items");
        if (r0 != null) goto L5;
        return;
    L5:
        int r2 = 0;
        if (r0.length > 0) goto L8;
    L16:
        int r1 = r0.length;
        int r3 = 0;
        int r4 = 0;
    L17:
        if (r3 >= r1) goto L22;
        if (this.P.contains((Item) r0[r3]) == true) goto L21;
        r4 = r4 + 1;
    L21:
        r3 = r3 + 1;
        goto L17
    L22:
        int r5 = 6;
        int r6 = 6 - this.P.size();
        if (r4 > r6) goto L25;
        int r7 = 0;
    L26:
        if (r7 > 6) goto L29;
        r5 = r7;
    L29:
        if (r5 <= 0) goto L35;
        int r8 = 1;
    L31:
        if (r8 > r5) goto L35;
        if (this.P.size() <= 0) goto L35;
        this.P.remove(0);
        r8 = r8 + 1;
    L35:
        int r9 = r0.length;
    L36:
        if (r2 >= r9) goto L38;
        p0((Item) r0[r2]);
        r2 = r2 + 1;
        goto L36
    L38:
        d1();
        return;
    L25:
        r7 = r4 - r6;
        goto L26
    L8:
        if (com.bytedance.feedbackerlib.m.j.i(((Item) r0[0]).f4335h) == false) goto L16;
        int r10 = 0;
    L11:
        if (r10 >= this.P.size()) goto L16;
        if (com.bytedance.feedbackerlib.m.j.i(this.P.get(r10).f4335h) == true) goto L14;
        r10 = r10 + 1;
        goto L11
    L14:
        this.P.remove(r10);
        goto L16
    }

    static /* synthetic */ boolean J(FeedbackActivity r0, boolean r1) {
        r0.f3847g = r1;
        return r1;
    }

    private void J0() {
        this.f3849i.k(this.S);
    }

    static /* synthetic */ long K(FeedbackActivity r2) {
        return r2.f3846f;
    }

    private void K0() {
        List<com.bytedance.feedbackerlib.model.e.c> r0 = this.f3848h.N();
        if (r0 != null) goto L5;
    L8:
        this.f3848h.U(new y(this));
        return;
    L5:
        if (r0.size() <= 0) goto L8;
        this.K.k(r0);
    }

    static /* synthetic */ long L(FeedbackActivity r0, long r1) {
        r0.f3846f = r1;
        return r1;
    }

    private boolean L0() {
        List<Item> r0 = com.bytedance.feedbackerlib.m.q.d.o.b();
        String r1 = com.bytedance.feedbackerlib.m.q.d.f4312g.a(null);
        String r3 = com.bytedance.feedbackerlib.m.q.d.f4314i.a(null);
        String r4 = com.bytedance.feedbackerlib.m.q.d.f4313h.a(null);
        String r5 = com.bytedance.feedbackerlib.m.q.d.f4315j.a(null);
        String r6 = com.bytedance.feedbackerlib.m.q.d.f4316k.a(null);
        String r2 = com.bytedance.feedbackerlib.m.q.d.f4317l.a(null);
        String r8 = "";
        String r7 = com.bytedance.feedbackerlib.m.q.d.m.a("");
        if (this.R == com.bytedance.feedbackerlib.m.q.a.f4296g.a(false)) goto L6;
        return true;
    L6:
        if (this.P.equals(r0) == true) goto L8;
        return true;
    L8:
        if (r1 != null) goto L10;
    L11:
        if (r1 == null) goto L13;
    L15:
        if (r3 != null) goto L17;
    L18:
        if (r3 == null) goto L20;
    L22:
        if (r4 != null) goto L24;
    L25:
        if (r4 == null) goto L27;
    L29:
        if (r5 != null) goto L31;
    L32:
        if (r5 == null) goto L34;
    L36:
        if (r6 != null) goto L38;
    L39:
        if (r6 == null) goto L41;
    L43:
        if (r2 != null) goto L45;
    L46:
        if (r2 != null) goto L51;
        if (this.N.h() == null) goto L51;
    L49:
        return true;
    L51:
        if (this.p.getText() == null) goto L55;
        r8 = this.p.getText().toString();
    L55:
        return !r8.equals(r7);
    L45:
        if (r2.equals(this.N.h()) == false) goto L49;
    L41:
        if (this.M.h() == null) goto L43;
    L42:
        return true;
    L38:
        if (r6.equals(this.M.h()) == false) goto L42;
    L34:
        if (this.L.h() == null) goto L36;
    L35:
        return true;
    L31:
        if (r5.equals(this.L.h()) == false) goto L35;
    L27:
        if (this.I.h() == null) goto L29;
    L28:
        return true;
    L24:
        if (r4.equals(this.I.h()) == false) goto L28;
    L20:
        if (this.f3845J.h() == null) goto L22;
    L21:
        return true;
    L17:
        if (r3.equals(this.f3845J.h()) == false) goto L21;
    L13:
        if (this.K.h() == null) goto L15;
    L14:
        return true;
    L10:
        if (r1.equals(this.K.h()) == false) goto L14;
        goto L11
    }

    static /* synthetic */ Handler M() {
        return T;
    }

    @RequiresApi(api = 19)
    public static void M0(@NonNull Context r2, @Nullable List<Item> r3) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.getApplicationContext() != null) goto L7;
        return;
    L7:
        if (r2.getResources().getConfiguration().orientation != 2) goto L12;
        com.bytedance.feedbackerlib.j.a.h1(true);
    L12:
        r2.getApplicationContext().startActivity(N0(r2, r3));     // Catch: Throwable -> L11
        return;
    }

    static /* synthetic */ TextView N(FeedbackActivity r0) {
        return r0.t;
    }

    @NonNull
    public static Intent N0(@NonNull Context r2, @Nullable List<Item> r3) {
        Intent r0 = new Intent(r2, FeedbackActivity.class);
        if (r3 != null) goto L5;
    L7:
        r0.addFlags(268435456);
        return r0;
    L5:
        if (r3.size() <= 0) goto L7;
        r0.putExtra("extra_selected_items", (Item[]) r3.toArray());
        goto L7
    }

    static /* synthetic */ void O(FeedbackActivity r0, String r1, View.OnClickListener r2) {
        r0.V0(r1, r2);
    }

    private void O0() {
        if (this.K.h() == null) goto L9;
        if (this.K.h().equals(BDLocationException.ERROR_TIMEOUT) == false) goto L9;
        this.q.setVisibility(0);
        this.f3850j.setVisibility(0);
        this.r.setVisibility(0);
        this.f3851k.setVisibility(0);
        this.A.setVisibility(0);
        this.u.setVisibility(0);
        this.n.setVisibility(0);
    L7:
        this.x.setVisibility(8);
        this.f3852l.setVisibility(8);
        this.y.setVisibility(8);
        this.m.setVisibility(8);
        this.s.setText(w0("sdk11"));
        this.p.setHint(w0("sdk13"));
        return;
    L9:
        if (this.K.h() == null) goto L15;
        if (this.K.h().equals(LocationInfoConst.ALLOW_USE_LOCATION) == false) goto L15;
        this.q.setVisibility(8);
        this.f3850j.setVisibility(8);
        this.r.setVisibility(8);
        this.f3851k.setVisibility(8);
        this.A.setVisibility(8);
        this.u.setVisibility(8);
        this.n.setVisibility(8);
        this.x.setVisibility(0);
        this.f3852l.setVisibility(0);
        this.y.setVisibility(8);
        this.m.setVisibility(8);
        this.p.setHint(w0("sdk_suggestion_3"));
        TextView r0 = this.s;
        String r6 = w0("sdk_suggestion_2");
    L13:
        r0.setText(r6);
        return;
    L15:
        if (this.K.h() != null) goto L17;
    L19:
        this.q.setVisibility(8);
        this.f3850j.setVisibility(8);
        this.r.setVisibility(8);
        this.f3851k.setVisibility(8);
        this.A.setVisibility(8);
        this.n.setVisibility(8);
        this.u.setVisibility(8);
        goto L7
    L17:
        if (this.K.h().equals("7") == false) goto L19;
        this.q.setVisibility(8);
        this.f3850j.setVisibility(8);
        this.r.setVisibility(8);
        this.f3851k.setVisibility(8);
        this.A.setVisibility(8);
        this.u.setVisibility(8);
        this.n.setVisibility(8);
        this.x.setVisibility(8);
        this.f3852l.setVisibility(8);
        this.y.setVisibility(0);
        this.m.setVisibility(0);
        this.p.setHint(w0("sdk13"));
        r0 = this.s;
        r6 = w0("sdk11");
        goto L13
    }

    static /* synthetic */ void P(FeedbackActivity r0, List r1, List r2, String r3, String r4) {
        r0.c1(r1, r2, r3, r4);
    }

    private void P0() {
        this.w.setText(w0("sdk8"));
        this.z.setText(w0("sdk7"));
        this.q.setText(w0("sdk9"));
        this.r.setText(w0("sdk10"));
        this.s.setText(w0("sdk11"));
        this.p.setHint(w0("sdk13"));
        this.t.setText(w0("sdk_submit_feedback"));
        this.u.setText(w0("key_priori_title"));
        this.x.setText(w0("sdk_suggestion_1"));
        this.y.setText(w0("sdk_suggestion_1"));
        this.F.setText(v0());
        this.F.setMovementMethod(LinkMovementMethod.getInstance());
        O0();
    }

    static /* synthetic */ com.bytedance.feedbackerlib.model.a Q(FeedbackActivity r0) {
        return r0.f3848h;
    }

    private void Q0(List<com.bytedance.feedbackerlib.model.e.c> r2) {
        LinkedHashSet r1 = new LinkedHashSet(r2.size());
        r1.addAll(r2);
        r2.clear();
        r2.addAll(r1);
    }

    static /* synthetic */ void R(FeedbackActivity r0) {
        r0.e1();
    }

    private void R0() {
        com.bytedance.feedbackerlib.m.q.d.r.c(com.bytedance.feedbackerlib.j.e.f());
        com.bytedance.feedbackerlib.m.q.d.m.c(this.p.getText() + "");
        com.bytedance.feedbackerlib.m.q.d.f4314i.c(this.f3845J.h());
        com.bytedance.feedbackerlib.m.q.d.f4313h.c(this.I.h());
        com.bytedance.feedbackerlib.m.q.d.f4312g.c(this.K.h());
        com.bytedance.feedbackerlib.m.q.d.o.g(this.P);
        com.bytedance.feedbackerlib.m.q.d.f4315j.c(this.L.h());
        com.bytedance.feedbackerlib.m.q.d.f4316k.c(this.M.h());
        com.bytedance.feedbackerlib.m.q.d.f4317l.c(this.N.h());
        com.bytedance.feedbackerlib.m.q.a.f4296g.b(this.R);
    }

    static /* synthetic */ void S(FeedbackActivity r0) {
        r0.O0();
    }

    @RequiresApi(api = 19)
    private void S0() {
        this.o = (RecyclerView) findViewById(com.bytedance.feedbackerlib.e.d0);
        this.f3850j = (RecyclerView) findViewById(com.bytedance.feedbackerlib.e.f0);
        this.f3851k = (RecyclerView) findViewById(com.bytedance.feedbackerlib.e.b0);
        this.n = (RecyclerView) findViewById(com.bytedance.feedbackerlib.e.e0);
        RecyclerView r0 = (RecyclerView) findViewById(com.bytedance.feedbackerlib.e.g0);
        this.p = (CustomEditText) findViewById(com.bytedance.feedbackerlib.e.f4022k);
        this.t = (TextView) findViewById(com.bytedance.feedbackerlib.e.b1);
        this.u = (TextView) findViewById(com.bytedance.feedbackerlib.e.Q0);
        this.v = (TextView) findViewById(com.bytedance.feedbackerlib.e.j1);
        this.w = (TextView) findViewById(com.bytedance.feedbackerlib.e.R0);
        this.z = (TextView) findViewById(com.bytedance.feedbackerlib.e.c1);
        ImageView r1 = (ImageView) findViewById(com.bytedance.feedbackerlib.e.t);
        this.q = (TextView) findViewById(com.bytedance.feedbackerlib.e.V0);
        this.r = (TextView) findViewById(com.bytedance.feedbackerlib.e.s0);
        this.s = (TextView) findViewById(com.bytedance.feedbackerlib.e.W0);
        this.B = (FrameLayout) findViewById(com.bytedance.feedbackerlib.e.n);
        this.C = (TextView) findViewById(com.bytedance.feedbackerlib.e.S0);
        this.A = (ImageView) findViewById(com.bytedance.feedbackerlib.e.y);
        this.f3852l = (RecyclerView) findViewById(com.bytedance.feedbackerlib.e.a0);
        this.x = (TextView) findViewById(com.bytedance.feedbackerlib.e.p0);
        this.m = (RecyclerView) findViewById(com.bytedance.feedbackerlib.e.c0);
        this.y = (TextView) findViewById(com.bytedance.feedbackerlib.e.w0);
        this.D = (RelativeLayout) findViewById(com.bytedance.feedbackerlib.e.Z);
        this.E = (TextView) findViewById(com.bytedance.feedbackerlib.e.d1);
        this.F = (TextView) findViewById(com.bytedance.feedbackerlib.e.H0);
        this.o.setAdapter(this.O);
        this.o.setLayoutManager(new GridLayoutManager(this, 3));
        this.o.addItemDecoration(new d0(this));
        this.f3852l.setAdapter(this.M);
        this.f3852l.setLayoutManager(new GridLayoutManager(this, 3));
        this.f3852l.addItemDecoration(new e0(this));
        this.m.setAdapter(this.N);
        this.m.setLayoutManager(new GridLayoutManager(this, 3));
        this.m.addItemDecoration(new f0(this));
        this.f3850j.setAdapter(this.I);
        this.f3850j.setLayoutManager(new GridLayoutManager(this, 3));
        this.f3850j.addItemDecoration(new g0(this));
        this.f3851k.setAdapter(this.f3845J);
        this.f3851k.setLayoutManager(new GridLayoutManager(this, 3));
        this.f3851k.addItemDecoration(new h0(this));
        this.n.setAdapter(this.L);
        this.n.setLayoutManager(new GridLayoutManager(this, 3));
        this.n.addItemDecoration(new i0(this));
        r0.setAdapter(this.K);
        r0.setLayoutManager(new GridLayoutManager(this, 3));
        r0.addItemDecoration(new a(this));
        this.t.setOnClickListener(new b(this));
        this.I.l(new c(this));
        this.f3845J.l(new d(this));
        this.L.l(new e(this));
        this.M.l(new f(this));
        this.N.l(new g(this));
        this.K.l(new h(this));
        this.p.addTextChangedListener(new i(this));
        r1.setOnClickListener(new j(this));
        this.A.setOnClickListener(new l(this));
    }

    static /* synthetic */ void T(FeedbackActivity r0) {
        r0.q0();
    }

    private void T0() {
        ViewGroup r0 = (ViewGroup) LayoutInflater.from(this).inflate(com.bytedance.feedbackerlib.f.f4028e, null);
        AlertDialog r1 = new AlertDialog.Builder(this, com.bytedance.feedbackerlib.h.f4048c).setView(r0).setCancelable(false).create();
        TextView r2 = (TextView) r0.findViewById(com.bytedance.feedbackerlib.e.t0);
        r2.setText("OK");
        r2.setOnClickListener(new w(this, r1));
        TextView r3 = (TextView) r0.findViewById(com.bytedance.feedbackerlib.e.u0);
        TextView r4 = (TextView) r0.findViewById(com.bytedance.feedbackerlib.e.c1);
        r4.getPaint().setFakeBoldText(true);
        r4.setText(this.f3849i.g("sdk39"));
        r3.setText(this.f3849i.g("sdk40"));
        if (isFinishing() == false) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT >= 17) goto L7;
    L8:
        r1.show();
        return;
    L7:
        if (isDestroyed() == false) goto L8;
    }

    static /* synthetic */ TextView U(FeedbackActivity r0) {
        return r0.v;
    }

    private void U0(int r5, @NonNull String r6, @NonNull String r7, @NonNull String r8, @Nullable View.OnClickListener r9) {
        if (TextUtils.isEmpty(r6) == false) goto L5;
    L15:
        com.bytedance.feedbackerlib.m.c.b("FeedbackActivity", "want to show dialog but, title=" + r6 + ", content=" + r7);
        return;
    L5:
        if (TextUtils.isEmpty(r7) == true) goto L15;
        ViewGroup r0 = (ViewGroup) LayoutInflater.from(this).inflate(com.bytedance.feedbackerlib.f.f4027d, null);
        TextView r1 = (TextView) r0.findViewById(com.bytedance.feedbackerlib.e.c1);
        TextView r2 = (TextView) r0.findViewById(com.bytedance.feedbackerlib.e.x0);
        TextView r3 = (TextView) r0.findViewById(com.bytedance.feedbackerlib.e.q0);
        r1.setText(r6);
        r2.setMovementMethod(LinkMovementMethod.getInstance());
        r2.setText(u0(r7));
        r2.setGravity(r5);
        r3.setText(r8);
        AlertDialog r10 = new AlertDialog.Builder(this, com.bytedance.feedbackerlib.h.f4048c).setView(r0).setCancelable(false).create();
        r3.setOnClickListener(new p(this, r10, r9));
        if (isFinishing() == false) goto L10;
        return;
    L10:
        if (Build.VERSION.SDK_INT >= 17) goto L12;
    L13:
        r10.show();
        return;
    L12:
        if (isDestroyed() == false) goto L13;
    }

    static /* synthetic */ void V(FeedbackActivity r0) {
        r0.T0();
    }

    private void V0(String r6, View.OnClickListener r7) {
        ViewGroup r8 = (ViewGroup) LayoutInflater.from(this).inflate(com.bytedance.feedbackerlib.f.f4026c, null);
        AlertDialog r0 = new AlertDialog.Builder(this, com.bytedance.feedbackerlib.h.f4048c).setView(r8).setCancelable(false).create();
        TextView r2 = (TextView) r8.findViewById(com.bytedance.feedbackerlib.e.E0);
        this.G = (RelativeLayout) r8.findViewById(com.bytedance.feedbackerlib.e.f4023l);
        this.H = (TextView) r8.findViewById(com.bytedance.feedbackerlib.e.F0);
        if (com.bytedance.feedbackerlib.model.e.a.b() <= 0) goto L5;
        r6 = com.bytedance.feedbackerlib.model.e.a.b() + " " + r6;
        com.bytedance.feedbackerlib.model.e.a.d(0);
    L5:
        r2.setText(s0(r6));
        r2.setMovementMethod(LinkMovementMethod.getInstance());
        ((TextView) r8.findViewById(com.bytedance.feedbackerlib.e.c1)).setText(this.f3849i.g("sdk37"));
        int r9 = com.bytedance.feedbackerlib.e.t0;
        r8.findViewById(r9).setOnClickListener(new s(this, r0));
        ((TextView) r8.findViewById(r9)).setText(this.f3849i.g("sdk_feedback_popup_button"));
        if (isFinishing() == false) goto L8;
        return;
    L8:
        if (Build.VERSION.SDK_INT >= 17) goto L10;
    L11:
        r0.show();
        return;
    L10:
        if (isDestroyed() == false) goto L11;
    }

    static /* synthetic */ void W(FeedbackActivity r0) {
        r0.X0();
    }

    private void W0() {
        ViewGroup r0 = (ViewGroup) LayoutInflater.from(this).inflate(com.bytedance.feedbackerlib.f.f4030g, null);
        TextView r1 = (TextView) r0.findViewById(com.bytedance.feedbackerlib.e.c1);
        TextView r2 = (TextView) r0.findViewById(com.bytedance.feedbackerlib.e.o0);
        TextView r3 = (TextView) r0.findViewById(com.bytedance.feedbackerlib.e.X0);
        r1.setText(this.f3849i.g("sdk24"));
        r2.setText(this.f3849i.g("sdk26"));
        r3.setText(this.f3849i.g("sdk25"));
        AlertDialog r4 = new AlertDialog.Builder(this, com.bytedance.feedbackerlib.h.f4048c).setView(r0).setCancelable(false).create();
        r2.setOnClickListener(new v(this, r4));
        r3.setOnClickListener(new c0(this));
        r4.show();
    }

    static /* synthetic */ void X(FeedbackActivity r0) {
        r0.x0();
    }

    private void X0() {
        U0(3, this.f3849i.g("key_priori_title"), this.f3849i.g("key_priority_description"), this.f3849i.g("key_i_know"), null);
    }

    static /* synthetic */ void Y(FeedbackActivity r0, long r1) {
        r0.y0(r1);
    }

    private void Y0(@NonNull String r7) {
        Z0(r7, 2000, 150);
    }

    static /* synthetic */ RelativeLayout Z(FeedbackActivity r0) {
        return r0.D;
    }

    private void Z0(@NonNull String r8, long r9, long r11) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
    L11:
        com.bytedance.feedbackerlib.m.c.b("FeedbackActivity", "want to show toast, but: content: " + r8 + ", duringTime: " + r9 + ", animTime: " + r11);
        return;
    L5:
        if (r9 < 0) goto L11;
        if (r11 < 0) goto L11;
        this.D.clearAnimation();
        this.E.setText(r8);
        this.D.setVisibility(0);
        AlphaAnimation r10 = new AlphaAnimation(0.0f, 1.0f);
        r10.setDuration(r11);
        r10.setFillAfter(true);
        r10.setAnimationListener(new q(this, r11, r9));
        this.D.startAnimation(r10);
    }

    static /* synthetic */ void a0(FeedbackActivity r0, long r1) {
        r0.z0(r1);
    }

    private void a1(@NonNull String r7) {
        b1(r7, 2000, 150);
    }

    static /* synthetic */ RelativeLayout b0(FeedbackActivity r0) {
        return r0.G;
    }

    private void b1(@NonNull String r8, long r9, long r11) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
    L18:
        com.bytedance.feedbackerlib.m.c.b("FeedbackActivity", "want to show toast, but: content: " + r8 + ", duringTime: " + r9 + ", animTime: " + r11);
        return;
    L5:
        if (r9 < 0) goto L18;
        if (r11 < 0) goto L18;
        RelativeLayout r0 = this.G;
        if (r0 != null) goto L12;
    L16:
        com.bytedance.feedbackerlib.m.c.b("FeedbackActivity", "want to show toast, but: FeedbackFailToastContainer or FeedbackFailToastTv is null");
        return;
    L12:
        if (this.H == null) goto L16;
        r0.clearAnimation();
        this.H.setText(r8);
        this.G.setVisibility(0);
        AlphaAnimation r10 = new AlphaAnimation(0.0f, 1.0f);
        r10.setDuration(r11);
        r10.setFillAfter(true);
        r10.setAnimationListener(new t(this, r11, r9));
        this.G.startAnimation(r10);
    }

    static /* synthetic */ void c0(FeedbackActivity r0, String r1) {
        r0.a1(r1);
    }

    @RequiresApi(api = 21)
    private void c1(List<String> r23, List<String> r24, String r25, String r26) {
        com.bytedance.feedbackerlib.m.r.o(r26, "submitFeedback start", new String[]{"picUrls = " + r23 + ", videoUrls = " + r24 + ", ssoEmail = " + r25});
        com.bytedance.feedbackerlib.m.r.a("click", "feedback");
        this.B.setVisibility(0);
        this.C.setText(this.f3849i.g("sdk27"));
        this.f3846f = System.currentTimeMillis();
        this.f3847g = false;
        T.postDelayed(new n(this), 500);
        String r12 = this.I.h();
        if (this.p.getText() != null) goto L5;
        String r0 = "";
    L6:
        String r16 = r0;
        com.bytedance.feedbackerlib.model.a r7 = this.f3848h;
        String r8 = getPackageName();
        j0 r1 = this.K;
        com.bytedance.feedbackerlib.model.e.c r9 = r1.g(r1.h());
        j0 r2 = this.L;
        com.bytedance.feedbackerlib.model.e.c r10 = r2.g(r2.h());
        j0 r3 = this.f3845J;
        com.bytedance.feedbackerlib.model.e.c r11 = r3.g(r3.h());
        j0 r4 = this.M;
        com.bytedance.feedbackerlib.model.e.c r17 = r4.g(r4.h());
        j0 r5 = this.N;
        r7.e0(r26, r8, r9, r10, r11, r17, r5.g(r5.h()), r12, r16, r25, com.bytedance.feedbackerlib.m.l.b(this), com.bytedance.feedbackerlib.j.a.z0(this).A0(), r23, r24, new o(this, r23, r24, r25, r26));
        return;
    L5:
        r0 = this.p.getText().toString();
        goto L6
    }

    static /* synthetic */ void d0(FeedbackActivity r0) {
        r0.K0();
    }

    private void d1() {
        this.O.notifyDataSetChanged();
    }

    static /* synthetic */ void e0(FeedbackActivity r0) {
        r0.R0();
    }

    private void e1() {
        if (this.K.h() != null) goto L7;
        this.t.setBackgroundResource(com.bytedance.feedbackerlib.d.f4004f);
        return;
    L7:
        if (this.K.h().equals(BDLocationException.ERROR_TIMEOUT) == false) goto L21;
        if (this.I.h() != null) goto L13;
        this.t.setBackgroundResource(com.bytedance.feedbackerlib.d.f4004f);
        return;
    L13:
        if (this.f3845J.h() != null) goto L17;
        this.t.setBackgroundResource(com.bytedance.feedbackerlib.d.f4004f);
        return;
    L17:
        if (this.L.h() != null) goto L21;
        this.t.setBackgroundResource(com.bytedance.feedbackerlib.d.f4004f);
        return;
    L21:
        if (this.K.h().equals(LocationInfoConst.ALLOW_USE_LOCATION) == false) goto L27;
        if (this.M.h() != null) goto L27;
        this.t.setBackgroundResource(com.bytedance.feedbackerlib.d.f4004f);
        return;
    L27:
        if (this.K.h().equals("7") == false) goto L33;
        if (this.N.h() != null) goto L33;
        this.t.setBackgroundResource(com.bytedance.feedbackerlib.d.f4004f);
        return;
    L33:
        if (this.p.getText() != null) goto L35;
        String r0 = "";
    L37:
        if (r0.length() >= 5) goto L40;
        this.t.setBackgroundResource(com.bytedance.feedbackerlib.d.f4004f);
        return;
    L40:
        this.t.setBackgroundResource(com.bytedance.feedbackerlib.d.f4003e);
        this.t.setTextColor(-1);
        return;
    L35:
        r0 = this.p.getText().toString();
        goto L37
    }

    static /* synthetic */ void f0(FeedbackActivity r0) {
        r0.C0();
    }

    private void f1() {
        d1();
        e1();
        O0();
        P0();
    }

    static /* synthetic */ void g0(FeedbackActivity r0) {
        r0.A0();
    }

    static /* synthetic */ void h0(FeedbackActivity r0) {
        r0.G0();
    }

    static /* synthetic */ boolean i0(FeedbackActivity r0) {
        return r0.R;
    }

    static /* synthetic */ boolean j0(FeedbackActivity r0, boolean r1) {
        r0.R = r1;
        return r1;
    }

    static /* synthetic */ void k0(FeedbackActivity r0) {
        super.onBackPressed();
    }

    static /* synthetic */ void l0(FeedbackActivity r0) {
        super.onBackPressed();
    }

    static /* synthetic */ j0 m0(FeedbackActivity r0) {
        return r0.K;
    }

    static /* synthetic */ com.bytedance.feedbackerlib.j.e n0(FeedbackActivity r0) {
        return r0.f3849i;
    }

    static /* synthetic */ void o0(FeedbackActivity r0, String r1) {
        r0.Y0(r1);
    }

    private void p0(Item r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (this.P.size() < 6) goto L7;
        return;
    L7:
        if (this.P.contains(r3) == false) goto L9;
        return;
    L9:
        this.P.add(r3);
    }

    private void q0() {
        this.K.m(null);
        this.I.m(null);
        this.f3845J.m(null);
        this.L.m(null);
        this.M.m(null);
        this.N.m(null);
        this.p.setText("");
        this.P.clear();
        this.R = false;
        com.bytedance.feedbackerlib.m.q.d.q.c("");
        com.bytedance.feedbackerlib.m.q.d.p.c("");
        com.bytedance.feedbackerlib.m.q.d.r.c(com.bytedance.feedbackerlib.j.e.f());
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = EmbeddingCompat.DEBUG, value = "onStop")
    public static void r0(FeedbackActivity r2) {
        r2.u();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT < 21) goto L12;
        r2.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L8
        return;
    L13:
        return;
    }

    private SpannableString s0(String r6) {
        if (TextUtils.isEmpty(r6) == false) goto L5;
    L7:
        String r7 = this.f3849i.g("sdk_feedback_popup_content");
    L8:
        SpannableString r0 = new SpannableString(r7);
        String r1 = this.f3849i.g("onCall_number");
        int r2 = r7.indexOf(r1);
        int r3 = r1.length() + r2;
        if (r2 >= 0) goto L11;
    L13:
        return r0;
    L11:
        if (r3 >= r7.length()) goto L13;
        r0.setSpan(new UnderlineSpan(), r2, r3, 33);
        r0.setSpan(new x(this), r2, r3, 33);
        r0.setSpan(new ForegroundColorSpan(Color.parseColor("#436ef6")), r2, r3, 33);
        r0.setSpan(new CancledUndlineSpan(), r2, r3, 33);
        Drawable r5 = getResources().getDrawable(com.bytedance.feedbackerlib.d.f4010l);
        r5.setBounds(0, 0, r5.getIntrinsicWidth(), r5.getIntrinsicHeight());
        r0.setSpan(new com.bytedance.feedbackerlib.matisse.internal.ui.widget.b(r5, 2), r2 - 1, r2, 17);
        goto L13
    L5:
        if ("null".equals(r6) == true) goto L7;
        r7 = r6 + ", " + this.f3849i.g("sdk_feedback_popup_content");
        goto L8
    }

    private String t0() {
        if (TextUtils.isEmpty(this.Q) == false) goto L5;
        String r0 = Feedbacker.getLarkSSOEmail();
        this.Q = r0;
        return r0;
    L5:
        return this.Q;
    }

    private SpannableString u0(String r7) {
        if (TextUtils.isEmpty(r7) == false) goto L6;
        return null;
    L6:
        SpannableString r0 = new SpannableString(r7);
        String r1 = this.f3849i.g("key_p0_priority");
        String r2 = this.f3849i.g("key_p1_priority");
        String r3 = this.f3849i.g("key_p2_priority");
        String r4 = this.f3849i.g("key_p3_priority");
        String r6 = this.f3849i.g("key_p4_priority");
        ArrayList r5 = new ArrayList();
        r5.add(r1);
        r5.add(r2);
        r5.add(r3);
        r5.add(r4);
        r5.add(r6);
        int r8 = 0;
    L8:
        if (r8 >= r5.size()) goto L15;
        int r9 = r7.indexOf((String) r5.get(r8));
        int r10 = ((String) r5.get(r8)).length() + r9;
        if (r9 < 0) goto L14;
        if (r10 >= r7.length()) goto L14;
        r0.setSpan(new ForegroundColorSpan(Color.parseColor("#14171A")), r9, r10, 33);
    L14:
        r8 = r8 + 1;
        goto L8
    L15:
        return r0;
    }

    @Proxy("getApplicationContext")
    @TargetClass(scope = Scope.ALL, value = "android.content.Context")
    public static Context v(FeedbackActivity r2) {
        return r2.getApplicationContext();
    L4:
        e = move-exception;
        com.obric.matrix.r.c.c.g("hookGetApplicationContext", "getApplicationContext error", e);
        return com.bytedance.mpaas.app.a.a();
    }

    private SpannableString v0() {
        String r0 = this.f3849i.g("sdk_feedback_remind");
        SpannableString r1 = new SpannableString(r0);
        String r2 = this.f3849i.g("onCall_number");
        int r3 = r0.indexOf(r2);
        int r4 = r2.length() + r3;
        if (r3 >= 0) goto L5;
    L7:
        return r1;
    L5:
        if (r4 >= r0.length()) goto L7;
        r1.setSpan(new UnderlineSpan(), r3, r4, 33);
        r1.setSpan(new m(this), r3, r4, 33);
        r1.setSpan(new ForegroundColorSpan(Color.parseColor("#c9c9c9")), r3, r4, 33);
        goto L7
    }

    static /* synthetic */ j0 w(FeedbackActivity r0) {
        return r0.I;
    }

    @Nullable
    private String w0(@NonNull String r1) {
        return this.f3849i.g(r1);
    }

    static /* synthetic */ j0 x(FeedbackActivity r0) {
        return r0.f3845J;
    }

    private void x0() {
        InputMethodManager r0 = (InputMethodManager) getSystemService("input_method");
        if (r0 == null) goto L6;
        r0.hideSoftInputFromWindow(this.t.getWindowToken(), 0);
        return;
    }

    static /* synthetic */ j0 y(FeedbackActivity r0) {
        return r0.L;
    }

    private void y0(long r4) {
        AlphaAnimation r0 = new AlphaAnimation(1.0f, 0.0f);
        r0.setDuration(r4);
        r0.setFillAfter(true);
        r0.setAnimationListener(new r(this));
        this.D.clearAnimation();
        this.D.startAnimation(r0);
    }

    static /* synthetic */ j0 z(FeedbackActivity r0) {
        return r0.M;
    }

    private void z0(long r4) {
        AlphaAnimation r0 = new AlphaAnimation(1.0f, 0.0f);
        r0.setDuration(r4);
        r0.setFillAfter(true);
        r0.setAnimationListener(new u(this));
        this.G.clearAnimation();
        this.G.startAnimation(r0);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int r2, int r3, @Nullable Intent r4) {
        super.onActivityResult(r2, r3, r4);
        if (r3 != (-1)) goto L18;
        if (r4 == null) goto L19;
        if (r2 == 0) goto L8;
        return;
    L8:
        this.R = com.bytedance.feedbackerlib.k.a.f(r4);
        this.P.clear();
        ArrayList<Item> r5 = com.bytedance.feedbackerlib.k.a.e(r4);
        if (r5 != null) goto L11;
        return;
    L11:
        Iterator<Item> r6 = r5.iterator();
    L13:
        if (r6.hasNext() == false) goto L15;
        p0(r6.next());
        goto L13
    L15:
        d1();
        return;
    L19:
        return;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        x0();
        if (L0() == false) goto L5;
        W0();
        return;
    L5:
        super.onBackPressed();
    }

    @Override // com.bytedance.feedbackerlib.activity.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @RequiresApi(api = 19)
    protected void onCreate(Bundle r1) {
        super.onCreate(r1);
        setContentView(com.bytedance.feedbackerlib.f.f4024a);
        S0();
        D0();
        f1();
        E0();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        com.bytedance.feedbackerlib.j.a.h1(false);
        this.f3849i.l(this.S);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        r0(this);
    }

    public void u() {
        super.onStop();
    }
}

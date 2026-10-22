package com.obric.matrix.account.ui;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.navigation.ActivityKt;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.matrix.account.databinding.AccountLarkssoCheckPageBinding;
import com.obric.matrix.account.larksso.LarkSSOChecker;
import com.obric.matrix.common_ui.widget.UrlSpanTextView;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.n0.d.a0;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0002\n\u0013\u0018\u0000 02\u00020\u0001:\u00010B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\n\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002J\b\u0010\u001e\u001a\u00020\u001aH\u0002J&\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010'\u001a\u00020\u001aH\u0016J\b\u0010(\u001a\u00020\u001aH\u0016J\u001a\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020 2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010+\u001a\u00020\u001aH\u0002J\b\u0010,\u001a\u00020\u001aH\u0002J\b\u0010-\u001a\u00020\u001aH\u0002J\b\u0010.\u001a\u00020\u001aH\u0002J\b\u0010/\u001a\u00020\u001aH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/obric/matrix/account/ui/LarkSSOCheckFragment;", "Landroidx/fragment/app/Fragment;", "()V", "binding", "Lcom/obric/matrix/account/databinding/AccountLarkssoCheckPageBinding;", "checkDelay", "", "handler", "Landroid/os/Handler;", "larkSSOCheckCallback", "com/obric/matrix/account/ui/LarkSSOCheckFragment$larkSSOCheckCallback$1", "Lcom/obric/matrix/account/ui/LarkSSOCheckFragment$larkSSOCheckCallback$1;", "larkSSOChecker", "Lcom/obric/matrix/account/larksso/LarkSSOChecker;", "larkSSOChecking", "", "loadingAnimator", "Landroid/animation/AnimatorSet;", "networkObserver", "com/obric/matrix/account/ui/LarkSSOCheckFragment$networkObserver$1", "Lcom/obric/matrix/account/ui/LarkSSOCheckFragment$networkObserver$1;", "netwrokDialog", "Lcom/obric/oui/dialog/OCommonDialog;", "netwrokViewModel", "Lcom/obric/matrix/account/util/NetworkViewModel;", "cancelCheck", "", "getDelayAnimator", "Landroid/animation/ValueAnimator;", "getLoadingAnimator", "goPhoneLoginFragment", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onResume", "onViewCreated", "view", "openPrivacyLink", "openTermsLink", "setTextHighLight", "showLoading", "showNetworkDialog", "Companion", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LarkSSOCheckFragment extends Fragment {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private AccountLarkssoCheckPageBinding f8752f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private AnimatorSet f8753g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f8754h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final LarkSSOChecker f8755i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final a f8756j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private com.obric.matrix.account.r.d f8757k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private d.g.d.c.c f8758l;
    private final LarkSSOCheckFragment$networkObserver$1 m;
    private final Handler n;
    private final long o;
    public Map<Integer, View> p;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/obric/matrix/account/ui/LarkSSOCheckFragment$larkSSOCheckCallback$1", "Lcom/obric/matrix/account/larksso/LarkSSOChecker$ICheckResultCallback;", "onCheckCancel", "", "onCheckSuccess", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a implements LarkSSOChecker.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ LarkSSOCheckFragment f8759a;

        a(LarkSSOCheckFragment r1) {
            this.f8759a = r1;
        }

        @Override // com.obric.matrix.account.larksso.LarkSSOChecker.a
        public void a() {
            LarkSSOCheckFragment.q(this.f8759a, false);
            LarkSSOCheckFragment.n(this.f8759a);
        }

        @Override // com.obric.matrix.account.larksso.LarkSSOChecker.a
        public void b() {
            LarkSSOCheckFragment.q(this.f8759a, false);
            LarkSSOCheckFragment.c(this.f8759a);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/matrix/account/ui/LarkSSOCheckFragment$setTextHighLight$1", "Lcom/obric/matrix/common_ui/widget/UrlSpanTextView$OnClickListener;", "onUrlClick", "", WsConstants.KEY_CONNECTION_URL, "", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class b implements UrlSpanTextView.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ LarkSSOCheckFragment f8760a;

        b(LarkSSOCheckFragment r1) {
            this.f8760a = r1;
        }

        @Override // com.obric.matrix.common_ui.widget.UrlSpanTextView.a
        public void a(String r2) {
            kotlin.n0.d.o.f(r2, WsConstants.KEY_CONNECTION_URL);
            if (kotlin.n0.d.o.a(r2, "tos") == false) goto L6;
            LarkSSOCheckFragment.p(this.f8760a);
            return;
        L6:
            if (kotlin.n0.d.o.a(r2, "pp") == false) goto L10;
            LarkSSOCheckFragment.o(this.f8760a);
            return;
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"com/obric/matrix/account/ui/LarkSSOCheckFragment$showLoading$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class c implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AnimatorSet f8761a;

        c(AnimatorSet r1) {
            this.f8761a = r1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r1) {
            kotlin.n0.d.o.f(r1, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r2) {
            kotlin.n0.d.o.f(r2, "animation");
            this.f8761a.start();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator r1) {
            kotlin.n0.d.o.f(r1, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r1) {
            kotlin.n0.d.o.f(r1, "animation");
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/matrix/account/ui/LarkSSOCheckFragment$showNetworkDialog$1", "Lcom/obric/oui/dialog/CancelClickListener;", "cancel", "", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class d implements d.g.d.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ LarkSSOCheckFragment f8762a;

        d(LarkSSOCheckFragment r1) {
            this.f8762a = r1;
        }

        @Override // d.g.d.c.a
        public void cancel() {
            com.obric.matrix.r.c.c.b("LarkSSOCheckFragment", "netwrokDialog cancel.");
            LarkSSOCheckFragment.c(this.f8762a);
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/matrix/account/ui/LarkSSOCheckFragment$showNetworkDialog$2", "Lcom/obric/oui/dialog/ConfirmClickListener;", "confirm", "", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class e implements d.g.d.c.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ LarkSSOCheckFragment f8763a;

        e(LarkSSOCheckFragment r1) {
            this.f8763a = r1;
        }

        @Override // d.g.d.c.b
        public void a() {
            com.obric.matrix.r.c.c.b("LarkSSOCheckFragment", "netwrokDialog confirm.");
            com.obric.matrix.account.r.d r2 = LarkSSOCheckFragment.m(this.f8763a);
            if (r2 == null) goto L6;
            r2.b();
            return;
        L6:
            kotlin.n0.d.o.v("netwrokViewModel");
            throw null;
        }
    }

    static {
    }

    public LarkSSOCheckFragment() {
        this.p = new LinkedHashMap();
        this.f8755i = new LarkSSOChecker();
        this.f8756j = new a(this);
        this.m = new LarkSSOCheckFragment$networkObserver$1(this);
        this.n = new Handler(Looper.getMainLooper());
        this.o = 1000;
    }

    public static /* synthetic */ void A(LarkSSOCheckFragment r0, View r1) {
        C(r0, r1);
    }

    private static final void B(View r0) {
    }

    private static final void C(LarkSSOCheckFragment r0, View r1) {
        kotlin.n0.d.o.f(r0, "this$0");
        r0.s();
    }

    private final void D() {
    }

    private final void E() {
    }

    private final void F() {
        final a0 r0 = new a0();
        r0.f18427f = true;
        String r1 = getResources().getString(com.obric.matrix.account.j.t);
        kotlin.n0.d.o.e(r1, "resources.getString(R.st…g.account_privacy_select)");
        AccountLarkssoCheckPageBinding r2 = this.f8752f;
        if (r2 == null) goto L7;
        UrlSpanTextView r3 = r2.f8459d;
        if (r3 == null) goto L7;
        r3.setUrlSpannedText(r1);
    L7:
        AccountLarkssoCheckPageBinding r4 = this.f8752f;
        if (r4 == null) goto L12;
        UrlSpanTextView r5 = r4.f8459d;
        if (r5 == null) goto L12;
        r5.setOnClickListener(new b(this));
    L12:
        AccountLarkssoCheckPageBinding r6 = this.f8752f;
        if (r6 == null) goto L18;
        UrlSpanTextView r7 = r6.f8459d;
        if (r7 == null) goto L19;
        r7.setOnClickListener(new f(r0));
        return;
    L19:
        return;
    }

    private static final void G(a0 r0, View r1) {
        kotlin.n0.d.o.f(r0, "$enableSelect");
        boolean r2 = r0.f18427f;
    }

    private final void H() {
        AnimatorSet r0 = new AnimatorSet();
        r0.playSequentially(new Animator[]{u(), t()});
        this.f8753g = r0;
        r0.addListener(new c(r0));
        r0.start();
    }

    private final void I() {
        if (this.f8758l != null) goto L5;
        d.g.d.c.c.a r0 = new d.g.d.c.c.a();
        r0.c(false);
        String r1 = getString(com.obric.matrix.account.j.s);
        kotlin.n0.d.o.e(r1, "getString(R.string.accou…ork_invalid_dialog_title)");
        r0.f(r1);
        String r2 = getString(com.obric.matrix.account.j.r);
        kotlin.n0.d.o.e(r2, "getString(R.string.accou…twork_invalid_dialog_msg)");
        r0.e(true, r2);
        r0.b(new d(this), getString(com.obric.matrix.account.j.p));
        r0.d(new e(this), getString(com.obric.matrix.account.j.q));
        Context r3 = requireContext();
        kotlin.n0.d.o.e(r3, "this@LarkSSOCheckFragment.requireContext()");
        this.f8758l = r0.a(r3);
    L5:
        d.g.d.c.c r4 = this.f8758l;
        if (r4 == null) goto L9;
        r4.show();
        return;
    }

    public static final /* synthetic */ void c(LarkSSOCheckFragment r0) {
        r0.s();
    }

    public static final /* synthetic */ long d(LarkSSOCheckFragment r2) {
        return r2.o;
    }

    public static final /* synthetic */ Handler g(LarkSSOCheckFragment r0) {
        return r0.n;
    }

    public static final /* synthetic */ a i(LarkSSOCheckFragment r0) {
        return r0.f8756j;
    }

    public static final /* synthetic */ LarkSSOChecker j(LarkSSOCheckFragment r0) {
        return r0.f8755i;
    }

    public static final /* synthetic */ boolean k(LarkSSOCheckFragment r0) {
        return r0.f8754h;
    }

    public static final /* synthetic */ d.g.d.c.c l(LarkSSOCheckFragment r0) {
        return r0.f8758l;
    }

    public static final /* synthetic */ com.obric.matrix.account.r.d m(LarkSSOCheckFragment r0) {
        return r0.f8757k;
    }

    public static final /* synthetic */ void n(LarkSSOCheckFragment r0) {
        r0.w();
    }

    public static final /* synthetic */ void o(LarkSSOCheckFragment r0) {
        r0.D();
    }

    public static final /* synthetic */ void p(LarkSSOCheckFragment r0) {
        r0.E();
    }

    public static final /* synthetic */ void q(LarkSSOCheckFragment r0, boolean r1) {
        r0.f8754h = r1;
    }

    public static final /* synthetic */ void r(LarkSSOCheckFragment r0) {
        r0.I();
    }

    private final void s() {
        FragmentActivity r1 = getActivity();
        if ((r1 instanceof LoginActivity) == false) goto L5;
        LoginActivity r2 = (LoginActivity) r1;
    L6:
        if (r2 == null) goto L9;
        r2.w();
        return;
    L9:
        return;
    L5:
        r2 = null;
        goto L6
    }

    private final ValueAnimator t() {
        ValueAnimator r2 = ValueAnimator.ofInt(new int[]{0, 1});
        r2.setDuration(500);
        return r2;
    }

    private final ValueAnimator u() {
        final String r0 = getString(com.obric.matrix.account.j.f8543l);
        kotlin.n0.d.o.e(r0, "getString(R.string.account_larksso_loading)");
        ValueAnimator r1 = ValueAnimator.ofInt(new int[]{0, 40});
        r1.setDuration(1200);
        r1.addUpdateListener(new com.obric.matrix.account.ui.e(this, r0));
        return r1;
    }

    private static final void v(LarkSSOCheckFragment r5, String r6, ValueAnimator r7) {
        kotlin.n0.d.o.f(r5, "this$0");
        kotlin.n0.d.o.f(r6, "$loadingMsg");
        kotlin.n0.d.o.f(r7, "animator");
        Object r8 = r7.getAnimatedValue();
        Objects.requireNonNull(r8, "null cannot be cast to non-null type kotlin.Int");
        int r9 = ((Integer) r8).intValue();
        boolean r1 = true;
        if (r9 < 0) goto L6;
        if (r9 >= 11) goto L6;
        boolean r3 = true;
    L7:
        TextView r4 = null;
        if (r3 == false) goto L16;
        AccountLarkssoCheckPageBinding r10 = r5.f8752f;
        if (r10 == null) goto L12;
        r4 = r10.f8457b;
    L12:
        if (r4 == null) goto L56;
        r4.setText(r6);
        return;
    L56:
        return;
    L16:
        if (11 > r9) goto L19;
        if (r9 >= 21) goto L19;
        boolean r0 = true;
    L20:
        if (r0 == false) goto L29;
        AccountLarkssoCheckPageBinding r11 = r5.f8752f;
        if (r11 == null) goto L24;
        r4 = r11.f8457b;
    L24:
        if (r4 == null) goto L57;
        StringBuilder r12 = new StringBuilder();
        r12.append(r6);
        r12.append('.');
    L27:
        r4.setText(r12.toString());
        return;
    L57:
        return;
    L29:
        if (21 > r9) goto L32;
        if (r9 >= 31) goto L32;
        boolean r13 = true;
    L33:
        if (r13 == false) goto L41;
        AccountLarkssoCheckPageBinding r14 = r5.f8752f;
        if (r14 == null) goto L37;
        r4 = r14.f8457b;
    L37:
        if (r4 == null) goto L58;
        r12 = new StringBuilder();
        r12.append(r6);
        String r15 = "..";
    L40:
        r12.append(r15);
        goto L27
    L58:
        return;
    L41:
        if (31 <= r9) goto L43;
    L45:
        r1 = false;
    L46:
        if (r1 == false) goto L55;
        AccountLarkssoCheckPageBinding r16 = r5.f8752f;
        if (r16 == null) goto L50;
        r4 = r16.f8457b;
    L50:
        if (r4 == null) goto L59;
        r12 = new StringBuilder();
        r12.append(r6);
        r15 = "...";
        goto L40
    L59:
        return;
    L55:
        return;
    L43:
        if (r9 >= 41) goto L45;
    L32:
        r13 = false;
    L19:
        r0 = false;
    L6:
        r3 = false;
        goto L7
    }

    private final void w() {
        FragmentActivity r1 = requireActivity();
        kotlin.n0.d.o.e(r1, "requireActivity()");
        ActivityKt.findNavController(r1, com.obric.matrix.account.g.o).popBackStack();
    }

    public static /* synthetic */ void x(View r0) {
        B(r0);
    }

    public static /* synthetic */ void y(LarkSSOCheckFragment r0, String r1, ValueAnimator r2) {
        v(r0, r1, r2);
    }

    public static /* synthetic */ void z(a0 r0, View r1) {
        G(r0, r1);
    }

    public void b() {
        this.p.clear();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        kotlin.n0.d.o.f(r1, "inflater");
        this.f8752f = AccountLarkssoCheckPageBinding.c(r1, r2, false);
        F();
        H();
        AccountLarkssoCheckPageBinding r4 = this.f8752f;
        if (r4 == null) goto L5;
        CheckBox r5 = r4.f8460e;
    L6:
        if (r5 == null) goto L9;
        r5.setVisibility(0);
    L9:
        AccountLarkssoCheckPageBinding r6 = this.f8752f;
        if (r6 == null) goto L12;
        CheckBox r7 = r6.f8460e;
    L13:
        if (r7 == null) goto L16;
        r7.setChecked(true);
    L16:
        AccountLarkssoCheckPageBinding r8 = this.f8752f;
        if (r8 == null) goto L21;
        LinearLayout r9 = r8.f8461f;
        if (r9 == null) goto L21;
        r9.setOnClickListener(com.obric.matrix.account.ui.d.f8790f);
    L21:
        AccountLarkssoCheckPageBinding r10 = this.f8752f;
        if (r10 == null) goto L26;
        ImageView r11 = r10.f8458c;
        if (r11 == null) goto L26;
        r11.setOnClickListener(new h(this));
    L26:
        AccountLarkssoCheckPageBinding r0 = this.f8752f;
        if (r0 != null) goto L29;
        return null;
    L29:
        return r0.b();
    L12:
        r7 = null;
        goto L13
    L5:
        r5 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f8755i.y();
        this.f8754h = false;
        AnimatorSet r0 = this.f8753g;
        if (r0 == null) goto L5;
        r0.removeAllListeners();
    L5:
        AnimatorSet r1 = this.f8753g;
        if (r1 == null) goto L8;
        r1.end();
    L8:
        com.obric.matrix.account.r.d r2 = this.f8757k;
        if (r2 == null) goto L16;
        r2.d();
        com.obric.matrix.account.r.d r3 = this.f8757k;
        if (r3 == null) goto L14;
        r3.a().removeObserver(this.m);
        b();
        return;
    L14:
        kotlin.n0.d.o.v("netwrokViewModel");
        throw null;
    L16:
        kotlin.n0.d.o.v("netwrokViewModel");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        com.obric.matrix.account.r.d r0 = this.f8757k;
        if (r0 == null) goto L6;
        MutableLiveData<Boolean> r1 = r0.a();
        r1.removeObserver(this.m);
        r1.observe(getViewLifecycleOwner(), this.m);
        return;
    L6:
        kotlin.n0.d.o.v("netwrokViewModel");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r2, Bundle r3) {
        kotlin.n0.d.o.f(r2, "view");
        super.onViewCreated(r2, r3);
        Context r4 = requireContext();
        kotlin.n0.d.o.e(r4, "this.requireContext()");
        com.obric.matrix.account.r.d r5 = new com.obric.matrix.account.r.d(r4);
        this.f8757k = r5;
        if (r5 == null) goto L6;
        r5.c();
        return;
    L6:
        kotlin.n0.d.o.v("netwrokViewModel");
        throw null;
    }
}

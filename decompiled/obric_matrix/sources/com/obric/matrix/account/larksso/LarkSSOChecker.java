package com.obric.matrix.account.larksso;

import android.app.Dialog;
import android.os.CountDownTimer;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.obric.matrix.account.j;
import com.obric.matrix.larksso_api.ILarkSSOService;
import h.a.b1;
import h.a.q1;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a0;
import kotlin.f0;
import kotlin.i0.m0;
import kotlin.k0.j.a.l;
import kotlin.n0.c.p;
import kotlin.n0.d.o;
import kotlin.w;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0002\u000f\u0012\u0018\u0000 (2\u00020\u0001:\u0002()B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0002J\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0002J\n\u0010\u0019\u001a\u0004\u0018\u00010\u0005H\u0002J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u001a\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007JE\u0010\u001f\u001a\u0004\u0018\u00010\u000521\u0010 \u001a-\b\u0001\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0$\u0012\u0006\u0012\u0004\u0018\u00010\u00010!H\u0002ø\u0001\u0000¢\u0006\u0002\u0010%J\u001a\u0010&\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u0018H\u0002J\u0006\u0010'\u001a\u00020\u001cR\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u0010\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006*"}, d2 = {"Lcom/obric/matrix/account/larksso/LarkSSOChecker;", "", "()V", "activityRef", "Ljava/lang/ref/WeakReference;", "Landroidx/fragment/app/FragmentActivity;", "callback", "Lcom/obric/matrix/account/larksso/LarkSSOChecker$ICheckResultCallback;", "checkFailedDialog", "Landroid/app/Dialog;", "checking", "", "didCountDownTimer", "Landroid/os/CountDownTimer;", "didObserver", "com/obric/matrix/account/larksso/LarkSSOChecker$didObserver$1", "Lcom/obric/matrix/account/larksso/LarkSSOChecker$didObserver$1;", "larkSSOAccountObserver", "com/obric/matrix/account/larksso/LarkSSOChecker$larkSSOAccountObserver$1", "Lcom/obric/matrix/account/larksso/LarkSSOChecker$larkSSOAccountObserver$1;", "showRetrying", "checkWhiteList", "checkWhiteListFail", "scene", "", "checkWhiteListSuccess", "goLarkSsoIfNeed", "goLarkSsoInternal", "", "init", "activity", "runInActivityScope", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function2;)Landroidx/fragment/app/FragmentActivity;", "showRetry", "unInit", "Companion", "ICheckResultCallback", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LarkSSOChecker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeakReference<FragmentActivity> f8548a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f8549b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Dialog f8550c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private CountDownTimer f8551d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f8552e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f8553f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final LarkSSOChecker$larkSSOAccountObserver$1 f8554g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final LarkSSOChecker$didObserver$1 f8555h;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/obric/matrix/account/larksso/LarkSSOChecker$ICheckResultCallback;", "", "onCheckCancel", "", "onCheckSuccess", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface a {
        void a();

        void b();
    }

    @kotlin.k0.j.a.f(c = "com.obric.matrix.account.larksso.LarkSSOChecker$checkWhiteList$1", f = "LarkSSOChecker.kt", l = {184}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Landroidx/fragment/app/FragmentActivity;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class b extends l implements p<FragmentActivity, kotlin.k0.d<? super f0>, Object> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f8556f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        /* synthetic */ Object f8557g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ LarkSSOChecker f8558h;

        b(LarkSSOChecker r1, kotlin.k0.d<? super b> r2) {
            this.f8558h = r1;
            super(2, r2);
        }

        public final Object b(FragmentActivity r1, kotlin.k0.d<? super f0> r2) {
            return ((b) create(r1, r2)).invokeSuspend(f0.f18324a);
        }

        @Override // kotlin.k0.j.a.a
        public final kotlin.k0.d<f0> create(Object r2, kotlin.k0.d<?> r3) {
            b r0 = new b(this.f8558h, r3);
            r0.f8557g = r2;
            return r0;
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ Object invoke(FragmentActivity r1, kotlin.k0.d<? super f0> r2) {
            return b(r1, r2);
        }

        @Override // kotlin.k0.j.a.a
        public final Object invokeSuspend(Object r15) {
            Object r0 = kotlin.k0.i.b.c();
            int r1 = this.f8556f;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            FragmentActivity r2 = (FragmentActivity) this.f8557g;
            w.b(r15);
        L27:
            com.obric.matrix.account.http.b r16 = (com.obric.matrix.account.http.b) r15;
            StringBuilder r3 = new StringBuilder();
            r3.append(r2.hashCode());
            r3.append(" checkWhiteList result ");
            r3.append(r16 instanceof com.obric.matrix.account.http.l);
            r3.append(' ');
            InnerSSOToken r4 = (InnerSSOToken) r16.a();
            if (r4 == null) goto L30;
            String r5 = r4.b();
        L31:
            r3.append(r5);
            com.obric.matrix.r.c.c.j("LarkSSOChecker", r3.toString());
            com.obric.matrix.account.a r6 = com.obric.matrix.account.a.f8438a;
            InnerSSOToken r7 = (InnerSSOToken) r16.a();
            if (r7 == null) goto L35;
            String r8 = r7.b();
            if (r8 == null) goto L35;
        L36:
            r6.x(r8);
            if ((r16 instanceof com.obric.matrix.account.http.g) == false) goto L40;
            com.obric.matrix.r.c.c.j("LarkSSOChecker", "checkWhiteList get sso_token fail");
            LarkSSOChecker.r(this.f8558h, null, 1, null);
        L39:
            LarkSSOChecker.m(this.f8558h, false);
        L12:
            return f0.f18324a;
        L40:
            LarkSSOChecker.c(this.f8558h);
        L35:
            r8 = r6.g();
            goto L36
        L30:
            r5 = null;
            goto L31
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            w.b(r15);
            FragmentActivity r17 = (FragmentActivity) this.f8557g;
            com.obric.matrix.r.c.c.b("LarkSSOChecker", "checkWhiteList.");
            if (LarkSSOChecker.i(this.f8558h) == false) goto L14;
            com.obric.matrix.r.c.c.j("LarkSSOChecker", r17.hashCode() + " checkWhiteList is showRetrying");
            goto L12
        L14:
            if (LarkSSOChecker.f(this.f8558h) == false) goto L16;
            com.obric.matrix.r.c.c.s("LarkSSOChecker", r17.hashCode() + " checkWhiteList is checking");
            goto L12
        L16:
            LarkSSOChecker.m(this.f8558h, true);
            com.obric.matrix.account.c r9 = com.obric.matrix.account.c.f8441a;
            String r10 = r9.b();
            StringBuilder r11 = new StringBuilder();
            r11.append("Token is empty :");
            if (r10 != null) goto L19;
        L22:
            boolean r12 = true;
        L23:
            r11.append(r12);
            com.obric.matrix.r.c.c.f("LarkSSOChecker", r11.toString());
            JSONObject r13 = new JSONObject();
            Map r14 = m0.e(a0.a("X-Common-Inner-Access-Token", r9.b()));
            this.f8557g = r17;
            this.f8556f = 1;
            Object r18 = com.obric.matrix.account.http.i.g(InnerSSOToken.class, "/cloud/os/api/inner_sso_token", r13, r14, null, this, 16, null);
            if (r18 != r0) goto L26;
            return r0;
        L26:
            r2 = r17;
            r15 = r18;
            goto L27
        L19:
            if (r10.length() == 0) goto L22;
            r12 = false;
            goto L23
        }
    }

    @kotlin.k0.j.a.f(c = "com.obric.matrix.account.larksso.LarkSSOChecker$checkWhiteListFail$1", f = "LarkSSOChecker.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Landroidx/fragment/app/FragmentActivity;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class c extends l implements p<FragmentActivity, kotlin.k0.d<? super f0>, Object> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f8559f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        /* synthetic */ Object f8560g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f8561h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ LarkSSOChecker f8562i;

        c(String r1, LarkSSOChecker r2, kotlin.k0.d<? super c> r3) {
            this.f8561h = r1;
            this.f8562i = r2;
            super(2, r3);
        }

        public final Object b(FragmentActivity r1, kotlin.k0.d<? super f0> r2) {
            return ((c) create(r1, r2)).invokeSuspend(f0.f18324a);
        }

        @Override // kotlin.k0.j.a.a
        public final kotlin.k0.d<f0> create(Object r3, kotlin.k0.d<?> r4) {
            c r0 = new c(this.f8561h, this.f8562i, r4);
            r0.f8560g = r3;
            return r0;
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ Object invoke(FragmentActivity r1, kotlin.k0.d<? super f0> r2) {
            return b(r1, r2);
        }

        @Override // kotlin.k0.j.a.a
        public final Object invokeSuspend(Object r3) {
            kotlin.k0.i.b.c();
            if (this.f8559f != 0) goto L7;
            w.b(r3);
            FragmentActivity r4 = (FragmentActivity) this.f8560g;
            com.obric.matrix.r.c.c.j("LarkSSOChecker", "checkWhiteList fail, scene = " + this.f8561h);
            LarkSSOChecker.o(this.f8562i, r4, this.f8561h);
            return f0.f18324a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.k0.j.a.f(c = "com.obric.matrix.account.larksso.LarkSSOChecker$checkWhiteListSuccess$1", f = "LarkSSOChecker.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Landroidx/fragment/app/FragmentActivity;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class d extends l implements p<FragmentActivity, kotlin.k0.d<? super f0>, Object> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f8563f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ LarkSSOChecker f8564g;

        d(LarkSSOChecker r1, kotlin.k0.d<? super d> r2) {
            this.f8564g = r1;
            super(2, r2);
        }

        public final Object b(FragmentActivity r1, kotlin.k0.d<? super f0> r2) {
            return ((d) create(r1, r2)).invokeSuspend(f0.f18324a);
        }

        @Override // kotlin.k0.j.a.a
        public final kotlin.k0.d<f0> create(Object r1, kotlin.k0.d<?> r2) {
            return new d(this.f8564g, r2);
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ Object invoke(FragmentActivity r1, kotlin.k0.d<? super f0> r2) {
            return b(r1, r2);
        }

        @Override // kotlin.k0.j.a.a
        public final Object invokeSuspend(Object r2) {
            kotlin.k0.i.b.c();
            if (this.f8563f != 0) goto L10;
            w.b(r2);
            com.obric.matrix.r.c.c.j("LarkSSOChecker", "checkWhiteList success");
            a r1 = LarkSSOChecker.d(this.f8564g);
            if (r1 == null) goto L8;
            r1.a();
        L8:
            return f0.f18324a;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.k0.j.a.f(c = "com.obric.matrix.account.larksso.LarkSSOChecker$goLarkSsoIfNeed$1", f = "LarkSSOChecker.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "it", "Landroidx/fragment/app/FragmentActivity;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class e extends l implements p<FragmentActivity, kotlin.k0.d<? super f0>, Object> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f8566f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ LarkSSOChecker f8567g;

        e(LarkSSOChecker r1, kotlin.k0.d<? super e> r2) {
            this.f8567g = r1;
            super(2, r2);
        }

        public final Object b(FragmentActivity r1, kotlin.k0.d<? super f0> r2) {
            return ((e) create(r1, r2)).invokeSuspend(f0.f18324a);
        }

        @Override // kotlin.k0.j.a.a
        public final kotlin.k0.d<f0> create(Object r1, kotlin.k0.d<?> r2) {
            return new e(this.f8567g, r2);
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ Object invoke(FragmentActivity r1, kotlin.k0.d<? super f0> r2) {
            return b(r1, r2);
        }

        @Override // kotlin.k0.j.a.a
        public final Object invokeSuspend(Object r4) {
            kotlin.k0.i.b.c();
            if (this.f8566f != 0) goto L30;
            w.b(r4);
            String r5 = com.obric.matrix.account.c.f8441a.b();
            boolean r0 = false;
            if (r5 != null) goto L7;
        L10:
            boolean r6 = true;
        L11:
            if (r6 == true) goto L14;
            LarkSSOChecker.a(this.f8567g);
            return f0.f18324a;
        L14:
            com.obric.matrix.account.r.c r7 = com.obric.matrix.account.r.c.f8617a;
            String r2 = r7.a().getValue();
            if (r2 != null) goto L17;
        L18:
            r0 = true;
        L20:
            if (r0 == false) goto L26;
            com.obric.matrix.r.c.c.b("LarkSSOChecker", "did is null: observeForever");
            CountDownTimer r1 = LarkSSOChecker.g(this.f8567g);
            if (r1 == null) goto L24;
            r1.start();
            r7.a().removeObserver(LarkSSOChecker.h(this.f8567g));
            r7.a().observeForever(LarkSSOChecker.h(this.f8567g));
        L28:
            return f0.f18324a;
        L24:
            o.v("didCountDownTimer");
            throw null;
        L26:
            com.obric.matrix.r.c.c.b("LarkSSOChecker", "did: " + r7.a().getValue());
            LarkSSOChecker.k(this.f8567g);
            goto L28
        L17:
            if (r2.length() != 0) goto L20;
        L7:
            if (r5.length() == 0) goto L10;
            r6 = false;
            goto L11
        L30:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.k0.j.a.f(c = "com.obric.matrix.account.larksso.LarkSSOChecker$goLarkSsoInternal$1", f = "LarkSSOChecker.kt", l = {145}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class f extends l implements p<h.a.m0, kotlin.k0.d<? super f0>, Object> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f8568f;

        f(kotlin.k0.d<? super f> r2) {
            super(2, r2);
        }

        @Override // kotlin.k0.j.a.a
        public final kotlin.k0.d<f0> create(Object r1, kotlin.k0.d<?> r2) {
            return new f(r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(h.a.m0 r1, kotlin.k0.d<? super f0> r2) {
            return ((f) create(r1, r2)).invokeSuspend(f0.f18324a);
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ Object invoke(h.a.m0 r1, kotlin.k0.d<? super f0> r2) {
            return invoke2(r1, r2);
        }

        @Override // kotlin.k0.j.a.a
        public final Object invokeSuspend(Object r12) {
            Object r0 = kotlin.k0.i.b.c();
            int r1 = this.f8568f;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            w.b(r12);
        L11:
            CheckDidResult r11 = (CheckDidResult) ((com.obric.matrix.account.http.b) r12).a();
            if (r11 == null) goto L14;
            Boolean r13 = kotlin.k0.j.a.b.a(r11.b());
        L15:
            com.obric.matrix.r.c.c.b("LarkSSOChecker", "isNeedCheck:" + r13);
            if (o.a(r13, kotlin.k0.j.a.b.a(false)) == false) goto L20;
            com.obric.matrix.r.c.c.b("LarkSSOChecker", "match did, pass lark sso");
            com.obric.matrix.account.c.f8441a.c().postValue(com.obric.matrix.account.larksso.a.C0220a.f8581c.b());
        L19:
            return f0.f18324a;
        L20:
            ILarkSSOService r14 = com.obric.matrix.account.c.f8441a.d();
            r14.init();
            ILarkSSOService.a.a(r14, false, 1, null);
            goto L19
        L14:
            r13 = null;
            goto L15
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            w.b(r12);
            JSONObject r5 = new JSONObject();
            this.f8568f = 1;
            r12 = com.obric.matrix.account.http.i.g(CheckDidResult.class, "/assistant/user/need_inner_test", r5, null, null, this, 24, null);
            if (r12 != r0) goto L11;
            return r0;
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/obric/matrix/account/larksso/LarkSSOChecker$init$1", "Landroid/os/CountDownTimer;", "onFinish", "", "onTick", "millisUntilFinished", "", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class g extends CountDownTimer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ LarkSSOChecker f8569a;

        g(LarkSSOChecker r3) {
            this.f8569a = r3;
            super(BDLocationConfig.sScanBleMaxInterval, BDLocationConfig.sScanBleMaxInterval);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            com.obric.matrix.account.r.c.f8617a.a().removeObserver(LarkSSOChecker.h(this.f8569a));
            LarkSSOChecker.r(this.f8569a, null, 1, null);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long r1) {
        }
    }

    @kotlin.k0.j.a.f(c = "com.obric.matrix.account.larksso.LarkSSOChecker$runInActivityScope$1$1", f = "LarkSSOChecker.kt", l = {259}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class h extends l implements p<h.a.m0, kotlin.k0.d<? super f0>, Object> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f8570f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ p<FragmentActivity, kotlin.k0.d<? super f0>, Object> f8571g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ FragmentActivity f8572h;

        /* JADX WARN: Multi-variable type inference failed */
        h(p<? super FragmentActivity, ? super kotlin.k0.d<? super f0>, ? extends Object> r1, FragmentActivity r2, kotlin.k0.d<? super h> r3) {
            this.f8571g = r1;
            this.f8572h = r2;
            super(2, r3);
        }

        @Override // kotlin.k0.j.a.a
        public final kotlin.k0.d<f0> create(Object r2, kotlin.k0.d<?> r3) {
            return new h(this.f8571g, this.f8572h, r3);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(h.a.m0 r1, kotlin.k0.d<? super f0> r2) {
            return ((h) create(r1, r2)).invokeSuspend(f0.f18324a);
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ Object invoke(h.a.m0 r1, kotlin.k0.d<? super f0> r2) {
            return invoke2(r1, r2);
        }

        @Override // kotlin.k0.j.a.a
        public final Object invokeSuspend(Object r4) {
            Object r0 = kotlin.k0.i.b.c();
            int r1 = this.f8570f;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            w.b(r4);
        L12:
            return f0.f18324a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            w.b(r4);
            p<FragmentActivity, kotlin.k0.d<? super f0>, Object> r5 = this.f8571g;
            FragmentActivity r2 = this.f8572h;
            this.f8570f = 1;
            if (r5.invoke(r2, this) != r0) goto L12;
            return r0;
        }
    }

    @kotlin.k0.j.a.f(c = "com.obric.matrix.account.larksso.LarkSSOChecker$showRetry$1$1", f = "LarkSSOChecker.kt", l = {}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class i extends l implements p<h.a.m0, kotlin.k0.d<? super f0>, Object> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f8573f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f8574g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ LarkSSOChecker f8575h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ FragmentActivity f8576i;

        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/matrix/account/larksso/LarkSSOChecker$showRetry$1$1$1", "Lcom/obric/oui/dialog/ConfirmClickListener;", "confirm", "", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class a implements d.g.d.c.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ LarkSSOChecker f8577a;

            a(LarkSSOChecker r1) {
                this.f8577a = r1;
            }

            @Override // d.g.d.c.b
            public void a() {
                LarkSSOChecker.l(this.f8577a, null);
                LarkSSOChecker.n(this.f8577a, false);
                LarkSSOChecker.j(this.f8577a);
            }
        }

        @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/matrix/account/larksso/LarkSSOChecker$showRetry$1$1$2", "Lcom/obric/oui/dialog/CancelClickListener;", "cancel", "", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class b implements d.g.d.c.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ LarkSSOChecker f8578a;

            b(LarkSSOChecker r1) {
                this.f8578a = r1;
            }

            @Override // d.g.d.c.a
            public void cancel() {
                LarkSSOChecker.l(this.f8578a, null);
                LarkSSOChecker.n(this.f8578a, false);
                a r2 = LarkSSOChecker.d(this.f8578a);
                if (r2 == null) goto L6;
                r2.b();
                return;
            }
        }

        i(String r1, LarkSSOChecker r2, FragmentActivity r3, kotlin.k0.d<? super i> r4) {
            this.f8574g = r1;
            this.f8575h = r2;
            this.f8576i = r3;
            super(2, r4);
        }

        @Override // kotlin.k0.j.a.a
        public final kotlin.k0.d<f0> create(Object r3, kotlin.k0.d<?> r4) {
            return new i(this.f8574g, this.f8575h, this.f8576i, r4);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(h.a.m0 r1, kotlin.k0.d<? super f0> r2) {
            return ((i) create(r1, r2)).invokeSuspend(f0.f18324a);
        }

        @Override // kotlin.n0.c.p
        public /* bridge */ /* synthetic */ Object invoke(h.a.m0 r1, kotlin.k0.d<? super f0> r2) {
            return invoke2(r1, r2);
        }

        @Override // kotlin.k0.j.a.a
        public final Object invokeSuspend(Object r7) {
            kotlin.k0.i.b.c();
            if (this.f8573f != 0) goto L15;
            w.b(r7);
            if (o.a(this.f8574g, "larkErrorScene") == false) goto L10;
            com.obric.matrix.account.c.f8441a.c().getValue();
            com.obric.matrix.r.c.c.j("LarkSSOChecker", "scene = larkErrorScene, but larkAccount has resumed.");
        L8:
            return f0.f18324a;
        L10:
            if (LarkSSOChecker.i(this.f8575h) == true) goto L12;
            LarkSSOChecker r8 = this.f8575h;
            d.g.d.c.c.a r1 = new d.g.d.c.c.a();
            r1.c(false);
            String r2 = this.f8576i.getString(j.f8538g);
            o.e(r2, "activity.getString(R.str…inner_verify_error_title)");
            r1.f(r2);
            String r3 = this.f8576i.getString(j.f8536e);
            o.e(r3, "activity.getString(R.str…ner_verify_error_message)");
            r1.e(true, r3);
            r1.d(new a(this.f8575h), this.f8576i.getString(j.f8537f));
            r1.b(new b(this.f8575h), this.f8576i.getString(j.f8535d));
            LarkSSOChecker.l(r8, r1.a(this.f8576i));
            Dialog r9 = LarkSSOChecker.e(this.f8575h);
            o.c(r9);
            r9.show();
            com.obric.matrix.r.c.c.j("LarkSSOChecker", "checkFailedDialog show. activity = " + this.f8576i.hashCode());
            LarkSSOChecker.n(this.f8575h, true);
            goto L8
        L12:
            return f0.f18324a;
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.obric.matrix.account.larksso.LarkSSOChecker$larkSSOAccountObserver$1] */
    /* JADX WARN: Type inference failed for: r0v1, types: [com.obric.matrix.account.larksso.LarkSSOChecker$didObserver$1] */
    public LarkSSOChecker() {
        this.f8554g = new LarkSSOChecker$larkSSOAccountObserver$1(this);
        this.f8555h = new LarkSSOChecker$didObserver$1(this);
    }

    public static final /* synthetic */ FragmentActivity a(LarkSSOChecker r0) {
        return r0.p();
    }

    public static final /* synthetic */ FragmentActivity b(LarkSSOChecker r0, String r1) {
        return r0.q(r1);
    }

    public static final /* synthetic */ FragmentActivity c(LarkSSOChecker r0) {
        return r0.s();
    }

    public static final /* synthetic */ a d(LarkSSOChecker r0) {
        return r0.f8549b;
    }

    public static final /* synthetic */ Dialog e(LarkSSOChecker r0) {
        return r0.f8550c;
    }

    public static final /* synthetic */ boolean f(LarkSSOChecker r0) {
        return r0.f8552e;
    }

    public static final /* synthetic */ CountDownTimer g(LarkSSOChecker r0) {
        return r0.f8551d;
    }

    public static final /* synthetic */ LarkSSOChecker$didObserver$1 h(LarkSSOChecker r0) {
        return r0.f8555h;
    }

    public static final /* synthetic */ boolean i(LarkSSOChecker r0) {
        return r0.f8553f;
    }

    public static final /* synthetic */ FragmentActivity j(LarkSSOChecker r0) {
        return r0.t();
    }

    public static final /* synthetic */ void k(LarkSSOChecker r0) {
        r0.u();
    }

    public static final /* synthetic */ void l(LarkSSOChecker r0, Dialog r1) {
        r0.f8550c = r1;
    }

    public static final /* synthetic */ void m(LarkSSOChecker r0, boolean r1) {
        r0.f8552e = r1;
    }

    public static final /* synthetic */ void n(LarkSSOChecker r0, boolean r1) {
        r0.f8553f = r1;
    }

    public static final /* synthetic */ void o(LarkSSOChecker r0, FragmentActivity r1, String r2) {
        r0.x(r1, r2);
    }

    private final FragmentActivity p() {
        return w(new b(this, null));
    }

    private final FragmentActivity q(String r3) {
        return w(new c(r3, this, null));
    }

    static /* synthetic */ FragmentActivity r(LarkSSOChecker r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = "";
    L6:
        return r0.q(r1);
    }

    private final FragmentActivity s() {
        return w(new d(this, null));
    }

    private final FragmentActivity t() {
        return w(new e(this, null));
    }

    private final void u() {
        h.a.h.b(q1.f17560f, b1.b(), null, new f(null), 2, null);
    }

    private final FragmentActivity w(p<? super FragmentActivity, ? super kotlin.k0.d<? super f0>, ? extends Object> r8) {
        WeakReference<FragmentActivity> r7 = this.f8548a;
        if (r7 == null) goto L8;
        FragmentActivity r9 = r7.get();
        if (r9 == null) goto L9;
        h.a.h.b(LifecycleOwnerKt.getLifecycleScope(r9), null, null, new h(r8, r9, null), 3, null);
        return r9;
    L9:
        return null;
    L8:
        return null;
    }

    private final void x(FragmentActivity r4, String r5) {
        LifecycleOwnerKt.getLifecycleScope(r4).launchWhenResumed(new i(r5, this, r4, null));
    }

    public final void v(FragmentActivity r3, a r4) {
        o.f(r3, "activity");
        WeakReference<FragmentActivity> r0 = this.f8548a;
        if (r0 == null) goto L5;
        FragmentActivity r1 = r0.get();
    L6:
        if (r1 == null) goto L8;
        return;
    L8:
        com.obric.matrix.r.c.c.b("LarkSSOChecker", "init");
        this.f8548a = new WeakReference(r3);
        this.f8549b = r4;
        this.f8551d = new g(this);
        com.obric.matrix.account.c r5 = com.obric.matrix.account.c.f8441a;
        r5.c().removeObserver(this.f8554g);
        r5.c().observe(r3, this.f8554g);
        t();
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void y() {
        com.obric.matrix.r.c.c.b("LarkSSOChecker", "unInit");
        this.f8548a = null;
        this.f8549b = null;
        com.obric.matrix.account.c.f8441a.c().removeObserver(this.f8554g);
        com.obric.matrix.account.r.c.f8617a.a().removeObserver(this.f8555h);
        Dialog r2 = this.f8550c;
        if (r2 == null) goto L6;
        r2.dismiss();
        return;
    }
}

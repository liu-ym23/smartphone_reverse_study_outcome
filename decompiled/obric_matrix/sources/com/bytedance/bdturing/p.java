package com.bytedance.bdturing;

import android.app.Dialog;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.client.BDLocationConfig;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class p extends Dialog {
    private com.bytedance.bdturing.u.a A;
    private r B;
    private ComponentCallbacks C;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.bytedance.bdturing.u.b f3112f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ImageView f3113g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private VerifyWebView f3114h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ViewGroup f3115i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Button f3116j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Button f3117k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Context f3118l;
    private FrameLayout m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private String r;
    private String s;
    private com.bytedance.bdturing.c t;
    private i u;
    private DialogInterface.OnDismissListener v;
    private com.bytedance.bdturing.h w;
    private com.bytedance.bdturing.e.a x;
    private int y;
    private com.bytedance.bdturing.verify.b.a z;

    class a implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ p f3119f;

        a(p r1) {
            this.f3119f = r1;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r2) {
            int r3 = r2.getId();
            if (r3 != l.f3095c) goto L7;
            p r4 = this.f3119f;
            com.bytedance.bdturing.e.a r0 = com.bytedance.bdturing.e.a.f3050l;
        L5:
            p.a(r4, r0);
        L9:
            this.f3119f.dismiss();
            return;
        L7:
            if (r3 != l.f3094b) goto L9;
            r4 = this.f3119f;
            r0 = com.bytedance.bdturing.e.a.m;
            goto L5
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ ViewGroup.LayoutParams f3120f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f3121g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f3122h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ p f3123i;

        b(p r1, ViewGroup.LayoutParams r2, int r3, int r4) {
            this.f3123i = r1;
            this.f3120f = r2;
            this.f3121g = r3;
            this.f3122h = r4;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (p.b(this.f3123i) == false) goto L5;
            return;
        L5:
            p.i(this.f3123i);
            ViewGroup.LayoutParams r0 = this.f3120f;
            r0.width = this.f3121g;
            r0.height = this.f3122h;
            p.j(this.f3123i).setLayoutParams(this.f3120f);
            p.j(this.f3123i).setVisibility(0);
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private WebView f3124f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ p f3125g;

        c(p r1) {
            this.f3125g = r1;
            this.f3124f = p.j(r1);
        }

        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.bdturing.g.f("VerifyDialog", "remove webview");
            WebView r0 = this.f3124f;
            if (r0 != null) goto L5;
            return;
        L5:
            ViewParent r1 = r0.getParent();
            if (r1 != null) goto L8;
            return;
        L8:
            if ((r1 instanceof ViewGroup) == false) goto L12;
            ((ViewGroup) r1).removeView(this.f3124f);
            return;
        }
    }

    class d implements DialogInterface.OnKeyListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ p f3126f;

        d(p r1) {
            this.f3126f = r1;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public boolean onKey(DialogInterface r1, int r2, KeyEvent r3) {
            int r4 = r3.getKeyCode();
            int r5 = r3.getAction();
            if (r4 == 4) goto L5;
            return false;
        L5:
            if (r5 == 1) goto L7;
            return false;
        L7:
            if (p.k(this.f3126f).getVisibility() != 0) goto L11;
            p r0 = this.f3126f;
            com.bytedance.bdturing.e.a r6 = com.bytedance.bdturing.e.a.n;
        L9:
            p.a(r0, r6);
            return false;
        L11:
            if (p.j(this.f3126f) != null) goto L13;
        L16:
            r0 = this.f3126f;
            r6 = com.bytedance.bdturing.e.a.f3046h;
            goto L9
        L13:
            if (p.j(this.f3126f).canGoBack() == false) goto L16;
            p.j(this.f3126f).goBack();
            return true;
        }
    }

    class e extends com.bytedance.bdturing.u.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ p f3127a;

        e(p r1) {
            this.f3127a = r1;
        }

        @Override // com.bytedance.bdturing.u.e
        public void c() {
            this.f3127a.u();
        }

        @Override // com.bytedance.bdturing.u.e
        public void d(com.bytedance.bdturing.u.c r2) {
            if (com.bytedance.bdturing.b.f().e() == null) goto L5;
            JSONObject r1 = com.bytedance.bdturing.b.f().e().getTheme(p.q(this.f3127a));
        L6:
            r2.d(1, r1);
            return;
        L5:
            r1 = null;
            goto L6
        }

        @Override // com.bytedance.bdturing.u.e
        public void f(int r2, int r3) {
            p.o(this.f3127a, r2, r3, false);
        }

        @Override // com.bytedance.bdturing.u.e
        public void g(int r1, int r2) {
            p.p(this.f3127a, r1, r2);
        }

        @Override // com.bytedance.bdturing.u.e
        public void h(String r3, com.bytedance.bdturing.c r4) {
            com.bytedance.bdturing.verify.b.i r0 = new com.bytedance.bdturing.verify.b.i(r3);
            r0.n(false);
            r0.p(false);
            p.c(this.f3127a).onDismiss(this.f3127a);
            com.bytedance.bdturing.b.f().i(p.d(this.f3127a).b(), r0, r4);
        }

        @Override // com.bytedance.bdturing.u.e
        public void i(int r3, String r4, String r5, String r6, String r7) {
            if (r3 != 0) goto L5;
            boolean r8 = true;
        L6:
            com.bytedance.bdturing.e.t(r3);
            if (p.l(this.f3127a) != null) goto L9;
        L18:
            p.n(this.f3127a, true);
            this.f3127a.dismiss();
            return;
        L9:
            if (r8 == false) goto L16;
            JSONObject r9 = new JSONObject();
            r9.put("token", r6);     // Catch: JSONException -> L13
            r9.put("mobile", r7);     // Catch: JSONException -> L13
        L15:
            p.l(this.f3127a).b(r3, r9);
        L17:
            p.m(this.f3127a, null);
        L13:
            e = move-exception;
            com.bytedance.bdturing.g.e(e);
            goto L15
        L16:
            p.l(this.f3127a).a(r3, null);
            goto L17
        L5:
            r8 = false;
            goto L6
        }

        @Override // com.bytedance.bdturing.u.e
        public void k() {
            if ((p.d(this.f3127a) instanceof com.bytedance.bdturing.verify.b.j) == false) goto L8;
            JSONObject r0 = ((com.bytedance.bdturing.verify.b.j) p.d(this.f3127a)).q();
            if (r0 == null) goto L9;
            String r1 = com.bytedance.bdturing.u.c.b(1, "bytedcert.verifyData", NotificationCompat.CATEGORY_CALL, r0, "bytedcert.verifyData");
            this.f3127a.r(r1);
            return;
        L9:
            return;
        }
    }

    class f implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ ViewGroup.LayoutParams f3128f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ int f3129g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f3130h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ p f3131i;

        f(p r1, ViewGroup.LayoutParams r2, int r3, int r4) {
            this.f3131i = r1;
            this.f3128f = r2;
            this.f3129g = r3;
            this.f3130h = r4;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (p.b(this.f3131i) == false) goto L5;
            return;
        L5:
            p.i(this.f3131i);
            ViewGroup.LayoutParams r0 = this.f3128f;
            r0.width = this.f3129g;
            r0.height = this.f3130h;
            p.j(this.f3131i).setLayoutParams(this.f3128f);
            p.j(this.f3131i).setVisibility(0);
        }
    }

    class g implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ p f3132a;

        g(p r1) {
            this.f3132a = r1;
        }

        @Override // com.bytedance.bdturing.r
        public void a(int r2, String r3) {
            p.e(this.f3132a, false);
            if (p.b(this.f3132a) == true) goto L5;
            p r4 = this.f3132a;
            p.f(r4, p.g(r4, r2));
        L5:
            p.a(this.f3132a, com.bytedance.bdturing.e.a.f3048j);
            this.f3132a.dismiss();
        }

        @Override // com.bytedance.bdturing.r
        public void b() {
            p.e(this.f3132a, true);
        }

        @Override // com.bytedance.bdturing.r
        public void c(int r1, String r2, String r3) {
        }
    }

    class h implements ComponentCallbacks {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ p f3133f;

        h(p r1) {
            this.f3133f = r1;
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration r5) {
            int r6 = r5.orientation;
            if (r6 == 1) goto L6;
            if (r6 == 2) goto L6;
            return;
        L6:
            if (r6 != 1) goto L8;
            int r7 = 2;
        L10:
            if (p.d(this.f3133f).j() != 2) goto L12;
            boolean r0 = true;
        L13:
            com.bytedance.bdturing.g.a("VerifyDialog", "canOrientation: " + r0);
            if (r0 == true) goto L16;
            return;
        L16:
            JSONObject r1 = new JSONObject();
            r1.put("orientation", r7);     // Catch: JSONException -> L19
        L21:
            String r2 = com.bytedance.bdturing.u.c.b(1, "bytedcert.orientation_changing", NotificationCompat.CATEGORY_CALL, r1, "bytedcert.orientation_changing");
            p.h(this.f3133f, true);
            this.f3133f.r(r2);
            com.bytedance.bdturing.e.n(r7);
            return;
        L19:
            e = move-exception;
            e.printStackTrace();
            goto L21
        L12:
            r0 = false;
            goto L13
        L8:
            r7 = 1;
            goto L10
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
        }
    }

    public p(com.bytedance.bdturing.verify.b.a r3, com.bytedance.bdturing.c r4) {
        super(r3.b(), n.f3109b);
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = false;
        this.u = null;
        this.x = com.bytedance.bdturing.e.a.f3047i;
        this.A = new e(this);
        this.B = new g(this);
        this.C = new h(this);
        this.z = r3;
        this.y = r3.j();
        this.r = this.z.k();
        this.t = r4;
        com.bytedance.bdturing.x.e.f(this.z.b());
        this.w = new com.bytedance.bdturing.h(this.z.b());
        this.f3118l = r3.b();
        A();
    }

    private void A() {
        setOnKeyListener(new d(this));
    }

    private void B() {
        if (this.z.e() == false) goto L5;
        RotateAnimation r0 = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        r0.setDuration(1000);
        r0.setRepeatCount(-1);
        r0.setInterpolator(new LinearInterpolator());
        this.f3113g.startAnimation(r0);
        this.m.setBackgroundColor(-2013265920);
        return;
    L5:
        this.f3113g.setVisibility(8);
    }

    private void C() {
        if (this.z.e() == false) goto L6;
        this.f3113g.clearAnimation();
        this.f3113g.setVisibility(8);
    L6:
        if (this.z.g() == false) goto L9;
        this.m.setBackgroundColor(-2013265920);
        return;
    }

    static /* synthetic */ com.bytedance.bdturing.e.a a(p r0, com.bytedance.bdturing.e.a r1) {
        r0.x = r1;
        return r1;
    }

    static /* synthetic */ boolean b(p r0) {
        return r0.p;
    }

    static /* synthetic */ DialogInterface.OnDismissListener c(p r0) {
        return r0.v;
    }

    static /* synthetic */ com.bytedance.bdturing.verify.b.a d(p r0) {
        return r0.z;
    }

    static /* synthetic */ boolean e(p r0, boolean r1) {
        r0.n = r1;
        return r1;
    }

    static /* synthetic */ String f(p r0, String r1) {
        r0.s = r1;
        return r1;
    }

    static /* synthetic */ String g(p r0, int r1) {
        return r0.v(r1);
    }

    static /* synthetic */ boolean h(p r0, boolean r1) {
        r0.q = r1;
        return r1;
    }

    static /* synthetic */ void i(p r0) {
        r0.C();
    }

    static /* synthetic */ VerifyWebView j(p r0) {
        return r0.f3114h;
    }

    static /* synthetic */ ViewGroup k(p r0) {
        return r0.f3115i;
    }

    static /* synthetic */ com.bytedance.bdturing.c l(p r0) {
        return r0.t;
    }

    static /* synthetic */ com.bytedance.bdturing.c m(p r0, com.bytedance.bdturing.c r1) {
        r0.t = r1;
        return r1;
    }

    static /* synthetic */ boolean n(p r0, boolean r1) {
        r0.o = r1;
        return r1;
    }

    static /* synthetic */ void o(p r0, int r1, int r2, boolean r3) {
        r0.s(r1, r2, r3);
    }

    static /* synthetic */ void p(p r0, int r1, int r2) {
        r0.t(r1, r2);
    }

    static /* synthetic */ int q(p r0) {
        return r0.y;
    }

    private void s(int r4, int r5, boolean r6) {
        com.bytedance.bdturing.g.a("VerifyDialog", "changeDialog width = " + r4 + ", height = " + r5);
        if (this.p == false) goto L5;
        return;
    L5:
        if (isShowing() == true) goto L8;
        return;
    L8:
        if (this.z.d() == false) goto L10;
        r4 = -1;
        r5 = -1;
    L10:
        float r7 = com.bytedance.bdturing.x.e.g(this.f3118l);
        if (r4 <= 0) goto L14;
        if (r5 <= 0) goto L14;
        r4 = Math.round(r4 * r7);
        r5 = Math.round(r5 * r7);
    L14:
        com.bytedance.bdturing.e.l(0, "web_become_visible width=" + r4 + ":height=" + r5 + ":density=" + r7);
        ViewGroup.LayoutParams r8 = this.f3114h.getLayoutParams();
        if (this.q == false) goto L22;
        int r1 = r8.width;
        if (r1 <= 0) goto L22;
        int r2 = r8.height;
        if (r2 <= 0) goto L22;
        this.f3114h.j(r4, r5, r1, r2);
        this.q = false;
        return;
    L22:
        this.f3114h.post(new b(this, r8, r4, r5));
    }

    private void t(int r5, int r6) {
        com.bytedance.bdturing.g.a("VerifyDialog", "changeDialogV2 webContentWidth = " + r5 + ", webContentHeight = " + r6);
        if (this.p == false) goto L5;
        return;
    L5:
        if (isShowing() == false) goto L22;
        int r1 = -1;
        if (this.z.d() == false) goto L10;
        int r0 = -1;
    L11:
        com.bytedance.bdturing.e.l(0, "web_become_visible webContentWidth=" + r5 + ":webContentHeight=" + r6);
        ViewGroup.LayoutParams r7 = this.f3114h.getLayoutParams();
        if (this.q == false) goto L19;
        int r2 = r7.width;
        if (r2 <= 0) goto L19;
        int r3 = r7.height;
        if (r3 <= 0) goto L19;
        this.f3114h.j(r0, r1, r2, r3);
        this.q = false;
        return;
    L19:
        this.f3114h.post(new f(this, r7, r0, r1));
        return;
    L10:
        r0 = r5;
        r1 = r6;
        goto L11
    }

    private String v(int r2) {
        return "Service error" + r2 + ", Please feed back to us";
    }

    private void x() {
        this.f3115i = (ViewGroup) findViewById(l.p);
        TextView r0 = (TextView) findViewById(l.f3099g);
        this.f3116j = (Button) findViewById(l.f3094b);
        this.f3117k = (Button) findViewById(l.f3095c);
        this.f3113g = (ImageView) findViewById(l.f3097e);
        this.f3114h = (VerifyWebView) findViewById(l.o);
        this.m = (FrameLayout) findViewById(l.f3096d);
        a r1 = new a(this);
        this.f3116j.setOnClickListener(r1);
        this.f3117k.setOnClickListener(r1);
        this.f3114h.g(this.B);
        i r2 = new i(this.z.c());
        this.u = r2;
        this.f3114h.setOnTouchListener(r2);
    }

    private void y() {
        WindowManager.LayoutParams r0 = getWindow().getAttributes();
        r0.width = -1;
        r0.height = -1;
        getWindow().setAttributes(r0);
    }

    private void z(String r4) {
        JSONObject r0 = new JSONObject();
        r0.put("style", r4);     // Catch: JSONException -> L5
    L7:
        r(com.bytedance.bdturing.u.c.b(1, "bytedcert.goToClose", NotificationCompat.CATEGORY_CALL, r0, "bytedcert.goToClose"));
        return;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (this.f3114h == null) goto L6;
        getWindow().getDecorView().post(new c(this));
        this.f3114h = null;
    L6:
        if (this.p == false) goto L8;
        return;
    L8:
        this.p = true;
        if (isShowing() == false) goto L14;
        super.dismiss();     // Catch: Exception -> L12
    L12:
        com.bytedance.bdturing.g.f("BdTuring", "an exception caught in the stage of VerifyDialog dismissing.");
    L14:
        if (this.z.b() == null) goto L16;
        this.z.b().unregisterComponentCallbacks(this.C);
    L16:
        com.bytedance.bdturing.h r2 = this.w;
        if (r2 == null) goto L19;
        r2.b();
        this.w = null;
    L19:
        DialogInterface.OnDismissListener r3 = this.v;
        if (r3 == null) goto L22;
        r3.onDismiss(this);
    L22:
        q.c().i(1, this, BDLocationConfig.sScanBleMaxInterval);
        com.bytedance.bdturing.c r0 = this.t;
        if (r0 == null) goto L28;
        if (this.n == true) goto L28;
        r0.a(3, null);
        this.t = null;
    L28:
        if (this.o == true) goto L31;
        z(this.x.a());
    L31:
        if (this.n == true) goto L33;
        com.bytedance.bdturing.e.i(this.x);
        u();
    L33:
        q.c().h(3, null);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle r3) {
        super.onCreate(r3);
        setContentView(LayoutInflater.from(this.f3118l).inflate(m.f3107c, null));
        y();
        x();
        B();
        if (this.z.b() == null) goto L5;
        this.z.b().registerComponentCallbacks(this.C);
    L5:
        this.w.a();
        setCanceledOnTouchOutside(this.z.h());
        setCancelable(true);
        this.f3112f = new com.bytedance.bdturing.u.b(this.A, this.f3114h);
        com.bytedance.bdturing.g.c("VerifyDialog", "loadUrl = " + this.r);
        this.f3114h.loadUrl(this.r);
        if (this.z.d() == false) goto L9;
        DisplayMetrics r4 = this.f3118l.getResources().getDisplayMetrics();
        ViewGroup.LayoutParams r0 = this.f3114h.getLayoutParams();
        r0.width = r4.widthPixels;
        r0.height = r4.heightPixels;
        this.f3114h.setLayoutParams(r0);
        this.f3114h.setVisibility(0);
        return;
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(MotionEvent r2) {
        this.u.c(r2);
        if (this.z.h() == false) goto L10;
        if (this.f3115i.getVisibility() != 0) goto L7;
        com.bytedance.bdturing.e.a r0 = com.bytedance.bdturing.e.a.f3049k;
    L8:
        this.x = r0;
        goto L10
    L7:
        r0 = com.bytedance.bdturing.e.a.f3045g;
    L10:
        return super.onTouchEvent(r2);
    }

    public boolean r(String r1) {
        com.bytedance.bdturing.u.b r0 = this.f3112f;
        if (r0 != null) goto L6;
        com.bytedance.bdturing.g.b("VerifyDialog", "(mJsBridge == null) ");
        return false;
    L6:
        r0.c(r1);
        return true;
    }

    @Override // android.app.Dialog
    public void setOnDismissListener(DialogInterface.OnDismissListener r1) {
        this.v = r1;
    }

    public synchronized void u() {
        monitor-enter(this);
        com.bytedance.bdturing.g.c("VerifyDialog", "clearResource()");     // Catch: Throwable -> L13
        if (this.f3118l != null) goto L10;
        if (this.f3112f != null) goto L10;
        monitor-exit(this);
        return;
    L10:
        this.f3118l = null;     // Catch: Throwable -> L13
        this.f3112f.d();     // Catch: Throwable -> L13
        this.f3112f = null;     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public com.bytedance.bdturing.verify.b.a w() {
        return this.z;
    }
}

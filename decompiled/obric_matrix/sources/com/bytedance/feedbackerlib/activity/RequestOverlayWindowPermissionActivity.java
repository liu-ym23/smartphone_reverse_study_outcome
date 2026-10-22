package com.bytedance.feedbackerlib.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.window.embedding.EmbeddingCompat;
import com.bytedance.feedbackerlib.Feedbacker;
import com.bytedance.feedbackerlib.f;
import com.bytedance.feedbackerlib.m.q;
import com.bytedance.feedbackerlib.m.r;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class RequestOverlayWindowPermissionActivity extends Activity {
    private static boolean m = false;
    private static String n = "RequestOverlayWindowPermissionActivity show";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private e f3966f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private TextView f3967g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private TextView f3968h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private TextView f3969i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private TextView f3970j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final com.bytedance.feedbackerlib.j.e f3971k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private com.bytedance.feedbackerlib.j.e.b f3972l;

    class a implements com.bytedance.feedbackerlib.j.e.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ RequestOverlayWindowPermissionActivity f3973a;

        a(RequestOverlayWindowPermissionActivity r1) {
            this.f3973a = r1;
        }

        @Override // com.bytedance.feedbackerlib.j.e.b
        public void a() {
            RequestOverlayWindowPermissionActivity.b(this.f3973a);
        }
    }

    class b implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ RequestOverlayWindowPermissionActivity f3974f;

        b(RequestOverlayWindowPermissionActivity r1) {
            this.f3974f = r1;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r3) {
            if (RequestOverlayWindowPermissionActivity.c(this.f3974f) != e.f3977f) goto L6;
            RequestOverlayWindowPermissionActivity.d(this.f3974f);
            return;
        L6:
            if (RequestOverlayWindowPermissionActivity.c(this.f3974f) != e.f3978g) goto L10;
            RequestOverlayWindowPermissionActivity r4 = this.f3974f;
            Toast.makeText(r4, RequestOverlayWindowPermissionActivity.e(r4).g("sdk34"), 0).show();
            this.f3974f.finish();
            q.a.f4297h.b(true);
            com.bytedance.feedbackerlib.m.c.b(RequestOverlayWindowPermissionActivity.f(), "HAS_DENIED_OVERLAY_PERMISSION set true");
            return;
        }
    }

    class c implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ RequestOverlayWindowPermissionActivity f3975f;

        c(RequestOverlayWindowPermissionActivity r1) {
            this.f3975f = r1;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r1) {
            RequestOverlayWindowPermissionActivity.g(this.f3975f);
        }
    }

    class d implements TranslucentOnePixelActivity.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ RequestOverlayWindowPermissionActivity f3976a;

        d(RequestOverlayWindowPermissionActivity r1) {
            this.f3976a = r1;
        }

        @Override // com.bytedance.feedbackerlib.activity.TranslucentOnePixelActivity.a
        public void a(boolean r3) {
            if (r3 == false) goto L4;
            Feedbacker.showFeedbackFloatWindow();
            this.f3976a.finish();
            return;
        L4:
            if (RequestOverlayWindowPermissionActivity.c(this.f3976a) != e.f3977f) goto L7;
            RequestOverlayWindowPermissionActivity.d(this.f3976a);
            return;
        L7:
            if (RequestOverlayWindowPermissionActivity.c(this.f3976a) != e.f3978g) goto L12;
            RequestOverlayWindowPermissionActivity r4 = this.f3976a;
            Toast.makeText(r4, RequestOverlayWindowPermissionActivity.e(r4).g("sdk34"), 0).show();
            this.f3976a.finish();
            q.a.f4297h.b(true);
            return;
        }
    }

    public static final enum e extends Enum<e> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final e f3977f = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final e f3978g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final /* synthetic */ e[] f3979h = null;

        static {
            e r0 = new e("ASK", 0);
            f3977f = r0;
            e r1 = new e("CONFIRM", 1);
            f3978g = r1;
            f3979h = new e[]{r0, r1};
        }

        private e(String r1, int r2) {
            super(r1, r2);
        }

        public static e valueOf(String r1) {
            return (e) Enum.valueOf(e.class, r1);
        }

        public static e[] values() {
            return (e[]) f3979h.clone();
        }
    }

    static {
    }

    public RequestOverlayWindowPermissionActivity() {
        this.f3971k = com.bytedance.feedbackerlib.j.e.e();
        this.f3972l = new a(this);
    }

    static /* synthetic */ void b(RequestOverlayWindowPermissionActivity r0) {
        r0.n();
    }

    static /* synthetic */ e c(RequestOverlayWindowPermissionActivity r0) {
        return r0.f3966f;
    }

    static /* synthetic */ void d(RequestOverlayWindowPermissionActivity r0) {
        r0.m();
    }

    static /* synthetic */ com.bytedance.feedbackerlib.j.e e(RequestOverlayWindowPermissionActivity r0) {
        return r0.f3971k;
    }

    static /* synthetic */ String f() {
        return n;
    }

    static /* synthetic */ void g(RequestOverlayWindowPermissionActivity r0) {
        r0.k();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = EmbeddingCompat.DEBUG, value = "onStop")
    public static void h(RequestOverlayWindowPermissionActivity r2) {
        r2.a();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT < 21) goto L12;
        r2.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L8
        return;
    L13:
        return;
    }

    private void i() {
        e r0 = (e) getIntent().getSerializableExtra("extra_state");
        this.f3966f = r0;
        if (r0 != null) goto L6;
        this.f3966f = e.f3977f;
        return;
    }

    public static synchronized void j(@NonNull Context r4, @NonNull e r5, String r6) {
        monitor-enter(RequestOverlayWindowPermissionActivity.class);
        r.h(r6, "RequestOverlayWindowPermissionActivity launchActivity invoked", new String[0]);     // Catch: Throwable -> L13
        com.bytedance.feedbackerlib.m.c.b(n, "launchActivity invoked");     // Catch: Throwable -> L13
        if (q.a.f4297h.a(false) == false) goto L9;
        com.bytedance.feedbackerlib.m.c.b(n, "HAS_DENIED_OVERLAY_PERMISSION is true");     // Catch: Throwable -> L13
        r.h(r6, "RequestOverlayWindowPermissionActivity HAS_DENIED_OVERLAY_PERMISSION is true", new String[0]);     // Catch: Throwable -> L13
        monitor-exit(RequestOverlayWindowPermissionActivity.class);
        return;
    L9:
        Intent r1 = new Intent(r4, RequestOverlayWindowPermissionActivity.class);     // Catch: Throwable -> L13
        r1.putExtra("extra_state", r5);     // Catch: Throwable -> L13
        r1.putExtra("extra_log_id", r6);     // Catch: Throwable -> L13
        r1.addFlags(268435456);     // Catch: Throwable -> L13
        r4.startActivity(r1);     // Catch: Throwable -> L16
    L11:
        monitor-exit(RequestOverlayWindowPermissionActivity.class);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    private void k() {
        TranslucentOnePixelActivity.C(this, new d(this));
    }

    private void l() {
        this.f3967g = (TextView) findViewById(com.bytedance.feedbackerlib.e.c1);
        this.f3968h = (TextView) findViewById(com.bytedance.feedbackerlib.e.u0);
        this.f3969i = (TextView) findViewById(com.bytedance.feedbackerlib.e.r0);
        this.f3970j = (TextView) findViewById(com.bytedance.feedbackerlib.e.N0);
        this.f3969i.setOnClickListener(new b(this));
        this.f3970j.setOnClickListener(new c(this));
        this.f3971k.k(this.f3972l);
    }

    private void m() {
        this.f3966f = e.f3978g;
        n();
    }

    private void n() {
        e r0 = this.f3966f;
        if (r0 != e.f3977f) goto L7;
        this.f3967g.setText(this.f3971k.g("Floating-window-permission-application"));
        this.f3968h.setText(this.f3971k.g("Pop-ups1"));
        TextView r1 = this.f3969i;
        com.bytedance.feedbackerlib.j.e r2 = this.f3971k;
        String r3 = "cancel";
    L5:
        r1.setText(r2.g(r3));
    L9:
        this.f3970j.setText(this.f3971k.g("Open"));
        return;
    L7:
        if (r0 != e.f3978g) goto L9;
        this.f3967g.setText(this.f3971k.g("Permission-not-granted"));
        this.f3968h.setText(this.f3971k.g("Pop-ups2-1") + "\n" + this.f3971k.g("Pop-ups2-2"));
        r1 = this.f3969i;
        r2 = this.f3971k;
        r3 = "confirm-cancel";
        goto L5
    }

    public void a() {
        super.onStop();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle r4) {
        super.onCreate(r4);
        setContentView(f.f4031h);
        String r5 = getIntent().getStringExtra("extra_log_id");
        r.h(r5, "RequestOverlayWindowPermissionActivity onCreate invoked", new String[0]);
        com.bytedance.feedbackerlib.m.c.b(n, "onCreate invoked");
        if (m == false) goto L5;
    L9:
        finish();
        return;
    L5:
        if (q.a.f4297h.a(false) == true) goto L9;
        com.bytedance.feedbackerlib.m.c.b(n, "not finish yet");
        r.h(r5, "RequestOverlayWindowPermissionActivity not finish yet", new String[0]);
        m = true;
        i();
        l();
        n();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.f3971k.l(this.f3972l);
        com.bytedance.feedbackerlib.m.c.b(n, "onDestroy invoked");
    }

    @Override // android.app.Activity
    protected void onStop() {
        h(this);
    }
}

package com.bytedance.bdturing.twiceverify;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.window.embedding.EmbeddingCompat;
import com.bytedance.bdturing.VerifyWebView;
import com.bytedance.bdturing.k;
import com.bytedance.bdturing.l;
import com.bytedance.bdturing.m;
import com.bytedance.bdturing.r;
import com.bytedance.bdturing.u.d;
import com.bytedance.bdturing.verify.b.g;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import java.util.HashMap;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class TwiceVerifyWebActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private VerifyWebView f3149f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private View f3150g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private com.bytedance.bdturing.verify.b.a f3151h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private r f3152i;

    class a implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ TwiceVerifyWebActivity f3153a;

        a(TwiceVerifyWebActivity r1) {
            this.f3153a = r1;
        }

        @Override // com.bytedance.bdturing.r
        public void a(int r4, String r5) {
            Toast.makeText(this.f3153a, "ERROR:" + r4 + ";MSG:" + r5, 1).show();
            if (c.d().c() == null) goto L5;
            c.d().c().f();
        L5:
            TwiceVerifyWebActivity.x(this.f3153a, 3, "web page load failed");
        }

        @Override // com.bytedance.bdturing.r
        public void b() {
            TwiceVerifyWebActivity.v(this.f3153a);
        }

        @Override // com.bytedance.bdturing.r
        public void c(int r1, String r2, String r3) {
            TwiceVerifyWebActivity.w(this.f3153a);
        }
    }

    public TwiceVerifyWebActivity() {
        this.f3149f = null;
        this.f3150g = null;
        this.f3152i = new a(this);
    }

    private void A() {
        VerifyWebView r0 = this.f3149f;
        if (r0 == null) goto L5;
        r0.setVisibility(4);
    L5:
        View r2 = this.f3150g;
        if (r2 == null) goto L9;
        r2.setVisibility(4);
        return;
    }

    private void C() {
        VerifyWebView r0 = this.f3149f;
        if (r0 == null) goto L5;
        r0.setVisibility(0);
    L5:
        View r2 = this.f3150g;
        if (r2 == null) goto L9;
        r2.setVisibility(0);
        return;
    }

    static /* synthetic */ void v(TwiceVerifyWebActivity r0) {
        r0.C();
    }

    static /* synthetic */ void w(TwiceVerifyWebActivity r0) {
        r0.A();
    }

    static /* synthetic */ void x(TwiceVerifyWebActivity r0, int r1, String r2) {
        r0.y(r1, r2);
    }

    private void y(int r1, String r2) {
        finish();
        c.b r0 = c.d().f();
        if (r0 == null) goto L6;
        r0.a(r1, r2);
        return;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = EmbeddingCompat.DEBUG, value = "onStop")
    public static void z(TwiceVerifyWebActivity r2) {
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

    void B() {
        if (this.f3149f != null) goto L5;
        VerifyWebView r0 = (VerifyWebView) findViewById(l.f3093a);
        this.f3149f = r0;
        r0.g(this.f3152i);
    L5:
        A();
        this.f3149f.getSettings().setJavaScriptEnabled(true);
        new com.bytedance.bdturing.u.b(new d(this), this.f3149f);
        HashMap r1 = new HashMap();
        com.bytedance.bdturing.verify.b.a r2 = this.f3151h;
        if (r2 == null) goto L8;
        String r3 = r2.k();
    L9:
        this.f3149f.loadUrl(r3, r1);
        return;
    L8:
        r3 = "";
        goto L9
    }

    @Override // android.app.Activity, android.view.Window.Callback
    @RequiresApi(api = 11)
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        View r0 = getWindow().getDecorView();
        setFinishOnTouchOutside(false);
        WindowManager.LayoutParams r1 = (WindowManager.LayoutParams) r0.getLayoutParams();
        r1.gravity = 80;
        r1.width = com.bytedance.common.utility.l.e(this);
        if (c.d().b() != null) goto L18;
        float r2 = 304.0f;
        r1.height = (int) com.bytedance.common.utility.l.a(this, 304.0f);
        com.bytedance.bdturing.verify.b.a r3 = this.f3151h;
        if (r3 != null) goto L7;
    L16:
        getWindowManager().updateViewLayout(r0, r1);
        return;
    L7:
        if ((r3 instanceof com.bytedance.bdturing.verify.b.b) == false) goto L11;
        r2 = 290.0f;
    L9:
        r1.height = (int) com.bytedance.common.utility.l.a(this, r2);
        goto L16
    L11:
        if ((r3 instanceof com.bytedance.bdturing.verify.b.l) == true) goto L9;
        if ((r3 instanceof g) == false) goto L16;
        r2 = 272.0f;
        goto L9
    L18:
        c.d().b().b();
        throw null;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        y(2, "user close");
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(@Nullable Bundle r2) {
        super.onCreate(r2);
        setContentView(m.f3106b);
        c.d().c().d(this, "");
        this.f3151h = c.d().e();
        this.f3150g = findViewById(l.f3100h);
        B();
        if (c.d().b() != null) goto L5;
        return;
    L5:
        DrawableCompat.wrap(getResources().getDrawable(k.f3092a));
        c.d().b().a();
        throw null;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.f3149f = null;
        c.d().h();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        z(this);
    }

    public void u() {
        super.onStop();
    }
}

package com.bytedance.feedbackerlib.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.window.embedding.EmbeddingCompat;
import com.bytedance.feedbackerlib.f;
import com.bytedance.feedbackerlib.j.e;
import com.bytedance.feedbackerlib.m.q;
import com.bytedance.feedbackerlib.service.FloatWindowService;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.matrix.r.c.c;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class DialogActivity extends Activity {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TextView f3838f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private TextView f3839g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private TextView f3840h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private TextView f3841i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private e f3842j;

    class a implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ DialogActivity f3843f;

        a(DialogActivity r1) {
            this.f3843f = r1;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r1) {
            this.f3843f.finish();
        }
    }

    class b implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ DialogActivity f3844f;

        b(DialogActivity r1) {
            this.f3844f = r1;
        }

        @Proxy("getApplicationContext")
        @TargetClass(scope = Scope.ALL, value = "android.content.Context")
        public static Context a(DialogActivity r2) {
            return r2.getApplicationContext();
        L4:
            e = move-exception;
            c.g("hookGetApplicationContext", "getApplicationContext error", e);
            return com.bytedance.mpaas.app.a.a();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r2) {
            q.a.f4298i.b(true);
            FloatWindowService.G(a(this.f3844f));
            this.f3844f.finish();
        }
    }

    public DialogActivity() {
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = EmbeddingCompat.DEBUG, value = "onStop")
    public static void b(DialogActivity r2) {
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

    private void c(@NonNull Intent r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.getAction() == null) goto L12;
        String r3 = r2.getAction();
        r3.hashCode();
        if (r3.equals("action_show_hide_hide_float_window_dialog") == false) goto L13;
        d();
        return;
    L13:
        return;
    }

    private void d() {
        this.f3838f.setText(this.f3842j.g("hide_float_window_title"));
        this.f3839g.setText(this.f3842j.g("hide_float_window_content"));
        this.f3840h.setText(this.f3842j.g("cancel"));
        this.f3841i.setText(this.f3842j.g("hide_float_window"));
        this.f3840h.setOnClickListener(new a(this));
        this.f3841i.setOnClickListener(new b(this));
    }

    public static void e(@NonNull Context r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.getApplicationContext() == null) goto L9;
        Intent r0 = new Intent(r3.getApplicationContext(), DialogActivity.class);
        r0.setAction("action_show_hide_hide_float_window_dialog");
        r0.addFlags(268435456);
        r3.getApplicationContext().startActivity(r0);
        return;
    }

    public void a() {
        super.onStop();
    }

    @Override // android.app.Activity
    protected void onCreate(@Nullable Bundle r1) {
        super.onCreate(r1);
        setContentView(f.f4032i);
        this.f3838f = (TextView) findViewById(com.bytedance.feedbackerlib.e.c1);
        this.f3839g = (TextView) findViewById(com.bytedance.feedbackerlib.e.u0);
        this.f3840h = (TextView) findViewById(com.bytedance.feedbackerlib.e.L0);
        this.f3841i = (TextView) findViewById(com.bytedance.feedbackerlib.e.P0);
        this.f3842j = e.e();
        c(getIntent());
    }

    @Override // android.app.Activity
    protected void onStop() {
        b(this);
    }
}

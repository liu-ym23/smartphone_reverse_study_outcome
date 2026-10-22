package com.bytedance.bdturing.identityverify;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bytedance.bdturing.l;
import com.bytedance.bdturing.m;
import com.bytedance.bdturing.n;

/* JADX INFO: loaded from: classes.dex */
public class c extends Dialog {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected Activity f3077f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private d f3078g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private TextView f3079h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private TextView f3080i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private TextView f3081j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private TextView f3082k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private View f3083l;
    private View m;
    private View n;

    class a implements DialogInterface.OnCancelListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ c f3084f;

        a(c r1) {
            this.f3084f = r1;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface r1) {
            if (c.a(this.f3084f) == null) goto L6;
            c.a(this.f3084f).onCancel();
            return;
        }
    }

    class b implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ c f3085f;

        b(c r1) {
            this.f3085f = r1;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r1) {
            if (c.a(this.f3085f) == null) goto L5;
            c.a(this.f3085f).onCancel();
        L5:
            c.b(this.f3085f);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.bdturing.identityverify.c$c, reason: collision with other inner class name */
    class ViewOnClickListenerC0084c implements View.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ c f3086f;

        ViewOnClickListenerC0084c(c r1) {
            this.f3086f = r1;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r1) {
            if (c.a(this.f3086f) == null) goto L6;
            c.a(this.f3086f).a();
            c.b(this.f3086f);
            return;
        }
    }

    public interface d {
        void a();

        void onCancel();
    }

    public c(@NonNull Activity r2, d r3) {
        super(r2, n.f3108a);
        this.f3077f = r2;
        this.f3078g = r3;
    }

    static /* synthetic */ d a(c r0) {
        return r0.f3078g;
    }

    static /* synthetic */ void b(c r0) {
        r0.g();
    }

    private void c() {
        if (com.bytedance.bdturing.b.f().e() == null) goto L5;
        com.bytedance.bdturing.w.c r1 = com.bytedance.bdturing.b.f().e().getThemeConfig();
    L6:
        if (r1 != null) goto L8;
        return;
    L8:
        r1.a();
        throw null;
    L5:
        r1 = null;
        goto L6
    }

    private void d() {
        setOnCancelListener(new a(this));
        this.f3081j.setOnClickListener(new b(this));
        this.f3082k.setOnClickListener(new ViewOnClickListenerC0084c(this));
    }

    private void e() {
        this.m = findViewById(l.m);
        this.n = findViewById(l.n);
        this.f3079h = (TextView) findViewById(l.f3104l);
        this.f3080i = (TextView) findViewById(l.f3103k);
        this.f3081j = (TextView) findViewById(l.f3101i);
        this.f3082k = (TextView) findViewById(l.f3102j);
        this.f3083l = findViewById(l.f3098f);
    }

    private void g() {
        dismiss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
    }

    public boolean f() {
        return !this.f3077f.isFinishing();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle r1) {
        super.onCreate(r1);
        setContentView(m.f3105a);
        e();
        c();
        d();
    }

    @Override // android.app.Dialog
    public void show() {
        if (f() == true) goto L5;
        return;
    L5:
        super.show();
    }
}

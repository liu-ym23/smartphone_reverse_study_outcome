package com.ss.android;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.window.embedding.EmbeddingCompat;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.ss.android.i.j;
import d.b.s.a.m;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
public class ShowDialogActivity extends Activity {

    class a implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ ShowDialogActivity f11723f;

        a(ShowDialogActivity r1) {
            this.f11723f = r1;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface r1, int r2) {
            this.f11723f.finish();
        }
    }

    public ShowDialogActivity() {
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = EmbeddingCompat.DEBUG, value = "onStop")
    public static void b(ShowDialogActivity r2) {
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

    private void c() {
        Intent r0 = getIntent();
        if (TextUtils.equals(r0.getStringExtra(NotificationCompat.CATEGORY_EVENT), "event_dialog") == false) goto L6;
        e(r0.getStringExtra("title"), r0.getStringExtra("message"));
        return;
    }

    public static void d(Context r3, String r4, String r5) {
        d r0 = j.l();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.g() == false) goto L10;
        Intent r1 = new Intent(r3, ShowDialogActivity.class);
        r1.addFlags(268435456);
        r1.putExtra(NotificationCompat.CATEGORY_EVENT, "event_dialog");
        r1.putExtra("title", r4);
        r1.putExtra("message", r5);
        r3.startActivity(r1);
        return;
    }

    private void e(String r2, String r3) {
        new AlertDialog.Builder(this).setTitle(r2).setMessage(r3 + "\nPlease confirm that account adk is initialized correctly.").setPositiveButton("ok", new a(this)).setCancelable(false).show();
    }

    public void a() {
        super.onStop();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle r1) {
        super.onCreate(r1);
        setContentView(m.f14867b);
        if (j.k().g() == true) goto L6;
        finish();
        return;
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        c();
    }

    @Override // android.app.Activity
    protected void onStop() {
        b(this);
    }
}

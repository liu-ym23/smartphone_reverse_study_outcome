package com.bytedance.mpaas.activity;

import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.internal.view.SupportMenu;
import androidx.window.embedding.EmbeddingCompat;
import com.bytedance.mpaas.applog.IBdtrackerService;
import com.bytedance.news.common.service.manager.d;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.ss.android.k.b.a.e;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private IBdtrackerService f5241f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f5242g;

    public BaseActivity() {
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = EmbeddingCompat.DEBUG, value = "onStop")
    public static void w(BaseActivity r2) {
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

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(@Nullable Bundle r1) {
        super.onCreate(r1);
        this.f5241f = (IBdtrackerService) d.a(IBdtrackerService.class);
        this.f5242g = getComponentName().getShortClassName();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        if (this.f5241f != null) goto L5;
        return;
    L5:
        if (v() == false) goto L9;
        this.f5241f.onActivityPaused();
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int r2, @NonNull String[] r3, @NonNull int[] r4) {
        super.onRequestPermissionsResult(r2, r3, r4);
        if (((r2 >> 16) & SupportMenu.USER_MASK) != 0) goto L6;
        e.b().i(this, r3, r4);
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.f5241f != null) goto L5;
        return;
    L5:
        if (v() == false) goto L9;
        this.f5241f.onActivityResume(this.f5242g, hashCode());
        return;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        w(this);
    }

    public void u() {
        super.onStop();
    }

    protected boolean v() {
        return true;
    }
}

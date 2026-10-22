package com.obric.matrix.auth;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import androidx.window.embedding.EmbeddingCompat;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.matrix.account.a;
import com.obric.matrix.r.c.c;
import com.ss.android.account.group_onekey.b;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.n0.d.e0;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\tH\u0016J\u0012\u0010\u000b\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\tH\u0002J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\u0012\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/matrix/auth/AccountGroupAuthActivity;", "Lcom/ss/android/account/group_onekey/BaseAccountGroupAuthActivity;", "()V", "TAG", "", "finish", "", "hideLoading", "isLightStatusBar", "", "isLogin", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setLightStatusBarIcon", "lightMode", "showLoading", "startActivity", "intent", "Landroid/content/Intent;", "app_matrix_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AccountGroupAuthActivity extends b {
    private final String z;

    public AccountGroupAuthActivity() {
        new LinkedHashMap();
        this.z = e0.b(AccountGroupAuthActivity.class).h();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = EmbeddingCompat.DEBUG, value = "onStop")
    public static void u(AccountGroupAuthActivity r2) {
        r2.t();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT < 21) goto L12;
        r2.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L8
        return;
    L13:
        return;
    }

    private final boolean v() {
        if ((getResources().getConfiguration().uiMode & 48) != 32) goto L5;
        boolean r2 = true;
    L7:
        return !r2;
    L5:
        r2 = false;
        goto L7
    }

    private final void w(boolean r2) {
        int r0 = getWindow().getDecorView().getSystemUiVisibility();
        if (r2 == false) goto L5;
        int r3 = r0 | 8192;
    L6:
        getWindow().getDecorView().setSystemUiVisibility(r3);
        return;
    L5:
        r3 = r0 & (-8193);
        goto L6
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    @Override // com.ss.android.account.group_onekey.b
    public void o() {
    }

    @Override // com.ss.android.account.group_onekey.b, android.app.Activity
    protected void onCreate(Bundle r4) {
        overridePendingTransition(0, 0);
        getWindow().getDecorView().setSystemUiVisibility(3840);
        Window r1 = getWindow();
        if (r1 == null) goto L5;
        r1.addFlags(Integer.MIN_VALUE);
    L5:
        Window r2 = getWindow();
        if (r2 == null) goto L9;
        r2.setStatusBarColor(0);
    L9:
        Window r3 = getWindow();
        if (r3 == null) goto L13;
        r3.setNavigationBarColor(0);
    L13:
        super.onCreate(r4);
        w(v());
        c.j(this.z, "onCreate, callingPackage=" + getCallingPackage() + ", callingActivity=" + getCallingActivity());
    }

    @Override // android.app.Activity
    protected void onStop() {
        u(this);
    }

    @Override // com.ss.android.account.group_onekey.b
    public boolean r() {
        return a.f8438a.v();
    }

    @Override // com.ss.android.account.group_onekey.b
    public void s() {
    }

    @Override // android.app.Activity, android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent r1) {
        super.startActivity(r1);
        overridePendingTransition(0, 0);
    }

    public void t() {
        super.onStop();
    }
}

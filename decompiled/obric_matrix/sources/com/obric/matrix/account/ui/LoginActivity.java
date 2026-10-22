package com.obric.matrix.account.ui;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.window.embedding.EmbeddingCompat;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.matrix.account_api.OAccount;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\b\u0010\f\u001a\u00020\bH\u0014J\u0006\u0010\r\u001a\u00020\bJ\b\u0010\u000e\u001a\u00020\bH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/matrix/account/ui/LoginActivity;", "Landroidx/fragment/app/FragmentActivity;", "()V", "loginViewModel", "Lcom/obric/matrix/account/ui/LoginViewModel;", "navHostFragment", "Landroidx/fragment/app/Fragment;", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onLoginFinished", "onResume", "Companion", "account_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LoginActivity extends FragmentActivity {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Fragment f8765f;

    static {
    }

    public LoginActivity() {
        new LinkedHashMap();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = EmbeddingCompat.DEBUG, value = "onStop")
    public static void v(LoginActivity r2) {
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

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        Fragment r0 = this.f8765f;
        if (r0 == null) goto L7;
        FragmentManager r1 = r0.getChildFragmentManager();
        if (r1 == null) goto L7;
        Integer r2 = Integer.valueOf(r1.getBackStackEntryCount());
    L8:
        com.obric.matrix.r.c.c.b("LoginActivity", "onBackPressed count = " + r2 + '.');
        if (r2 != null) goto L12;
    L14:
        super.onBackPressed();
        return;
    L12:
        if (r2.intValue() != 0) goto L14;
        w();
        return;
    L7:
        r2 = null;
        goto L8
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r3) {
        super.onCreate(r3);
        com.obric.matrix.r.c.c.b("LoginActivity", "onCreate.");
        com.obric.matrix.common_ui.utils.d.b(this, true);
        com.obric.matrix.common_ui.utils.d.a(this, true);
        Window r4 = getWindow();
        if (r4 == null) goto L5;
        r4.setBackgroundDrawable(new ColorDrawable(-1));
    L5:
        setContentView(com.obric.matrix.account.h.f8486a);
        this.f8765f = getSupportFragmentManager().findFragmentById(com.obric.matrix.account.g.o);
        LoginViewModel r2 = (LoginViewModel) new ViewModelProvider(this).get(LoginViewModel.class);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        com.obric.matrix.r.c.c.b("LoginActivity", "onDestroy.");
        if (com.obric.matrix.account.a.f8438a.v() == true) goto L6;
        com.obric.matrix.r.c.c.s("LoginActivity", "Login cancel.");
        com.obric.matrix.account.c.f8441a.a();
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (com.obric.matrix.account.a.f8438a.v() == false) goto L6;
        com.obric.matrix.r.c.c.s("LoginActivity", "onResume account isLogin");
        w();
        return;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        v(this);
    }

    public void u() {
        super.onStop();
    }

    public final void w() {
        OAccount.INSTANCE.loginFinished();
        finishAndRemoveTask();
        com.obric.matrix.r.c.c.j("LoginActivity", "onLoginFinished.");
    }
}

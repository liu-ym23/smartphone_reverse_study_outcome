package com.ss.android.account.group_onekey;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.window.embedding.EmbeddingCompat;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import kotlin.Metadata;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/ss/android/account/group_onekey/AccountGroupAuthCallbackActivity;", "Landroid/app/Activity;", "Landroid/os/Bundle;", "savedInstanceState", "Lkotlin/f0;", "onCreate", "(Landroid/os/Bundle;)V", "<init>", "()V", "account-sdk-group-onekey_release"}, k = 1, mv = {1, 1, 15})
public class AccountGroupAuthCallbackActivity extends Activity {
    public AccountGroupAuthCallbackActivity() {
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = EmbeddingCompat.DEBUG, value = "onStop")
    public static void b(AccountGroupAuthCallbackActivity r2) {
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

    public void a() {
        super.onStop();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle r7) {
        super.onCreate(r7);
        Intent r2 = getIntent();
        if (r2 == null) goto L7;
        String r1 = r2.getStringExtra("challenge");
        if (r1 == null) goto L7;
        a.b(a.f11729f, r1, r2, false, 4, null);
    L7:
        finish();
    }

    @Override // android.app.Activity
    protected void onStop() {
        b(this);
    }
}

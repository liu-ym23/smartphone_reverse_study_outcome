package com.ss.android.account.share.data.write.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.window.embedding.EmbeddingCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.ss.android.i.n.a.c;
import com.ss.android.i.n.a.e.a;
import com.ss.android.i.n.a.e.b;
import kotlin.Metadata;
import kotlin.n0.d.o;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/ss/android/account/share/data/write/activity/ShareDataActivity;", "Landroid/app/Activity;", "Landroid/os/Bundle;", "savedInstanceState", "Lkotlin/f0;", "onCreate", "(Landroid/os/Bundle;)V", "<init>", "()V", "sec_share_data_release"}, k = 1, mv = {1, 1, 15})
public final class ShareDataActivity extends Activity {
    public ShareDataActivity() {
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = EmbeddingCompat.DEBUG, value = "onStop")
    public static void b(ShareDataActivity r2) {
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
    protected void onCreate(Bundle r9) {
        super.onCreate(r9);
        Intent r10 = new Intent();
    L14:
        e = move-exception;
        c r5 = c.d();
        r5.b("share_sdk_activity_read_local_data_failed");
        r5.a(LocationMonitorConst.ERR_MSG, e.getMessage());
        r5.a("err_msg_stack", Log.getStackTraceString(e));
        r5.c();
        r10.putExtra("EXTRA_IS_SUCCESS", 0);
        r10.removeExtra("EXTRA_VALUE");
        setResult(-1, r10);
        finish();
        return;
    L4:
        if (b.f11939f.b(getCallingPackage()) == true) goto L7;
        r10.putExtra("EXTRA_IS_SUCCESS", 0);     // Catch: Exception -> L14
    L6:
        setResult(-1, r10);     // Catch: Exception -> L14
        finish();     // Catch: Exception -> L14
        return;
    L7:
        r10.putExtra("EXTRA_IS_SUCCESS", 1);     // Catch: Exception -> L14
        String r4 = getIntent().getStringExtra("EXTRA_KEY");     // Catch: Exception -> L14
        if (r4 != null) goto L11;
        r4 = "";
    L11:
        o.b(r4, "intent.getStringExtra(EXTRA_KEY) ?: \"\"");     // Catch: Exception -> L14
        r10.putExtra("EXTRA_VALUE", a.f11931d.a(this).d(r4));     // Catch: Exception -> L14
        goto L6
    }

    @Override // android.app.Activity
    protected void onStop() {
        b(this);
    }
}

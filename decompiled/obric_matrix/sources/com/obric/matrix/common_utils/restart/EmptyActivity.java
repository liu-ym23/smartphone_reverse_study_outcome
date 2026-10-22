package com.obric.matrix.common_utils.restart;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import androidx.window.embedding.EmbeddingCompat;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014¨\u0006\u0007"}, d2 = {"Lcom/obric/matrix/common_utils/restart/EmptyActivity;", "Landroid/app/Activity;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "common_utils_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class EmptyActivity extends Activity {
    public EmptyActivity() {
        new LinkedHashMap();
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = EmbeddingCompat.DEBUG, value = "onStop")
    public static void b(EmptyActivity r2) {
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
    protected void onCreate(Bundle r1) {
        super.onCreate(r1);
        finish();
    }

    @Override // android.app.Activity
    protected void onStop() {
        b(this);
    }
}

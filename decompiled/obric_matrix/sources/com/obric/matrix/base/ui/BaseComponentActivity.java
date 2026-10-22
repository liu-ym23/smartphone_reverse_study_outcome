package com.obric.matrix.base.ui;

import android.os.Build;
import android.view.KeyEvent;
import androidx.activity.ComponentActivity;
import androidx.core.app.NotificationCompat;
import androidx.window.embedding.EmbeddingCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.n0.d.g;
import kotlin.n0.d.o;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0015H\u0014J\b\u0010\u001c\u001a\u00020\u0015H\u0014R\u001a\u0010\u0005\u001a\u00020\u0006X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u0006X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0004¨\u0006\u001d"}, d2 = {"Lcom/obric/matrix/base/ui/BaseComponentActivity;", "Landroidx/activity/ComponentActivity;", LocationMonitorConst.TAG, "", "(Ljava/lang/String;)V", "mExitedAbnormalCausedByPhoenix", "", "getMExitedAbnormalCausedByPhoenix", "()Z", "setMExitedAbnormalCausedByPhoenix", "(Z)V", "mExitedByBackButtonOnMenu", "getMExitedByBackButtonOnMenu", "setMExitedByBackButtonOnMenu", "mExitedByExitButtonOnMenu", "getMExitedByExitButtonOnMenu", "setMExitedByExitButtonOnMenu", "getTag", "()Ljava/lang/String;", "setTag", "finish", "", "onKeyDown", "keyCode", "", NotificationCompat.CATEGORY_EVENT, "Landroid/view/KeyEvent;", "onPause", "onStop", "internal_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class BaseComponentActivity extends ComponentActivity {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f8889f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile boolean f8890g;

    /* JADX WARN: Multi-variable type inference failed */
    public BaseComponentActivity() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public BaseComponentActivity(String r2) {
        o.f(r2, LocationMonitorConst.TAG);
        new LinkedHashMap();
        this.f8889f = r2;
        this.f8890g = true;
    }

    public /* synthetic */ BaseComponentActivity(String r1, int r2, g r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = "BaseComponentActivity";
    L5:
        this(r1);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = EmbeddingCompat.DEBUG, value = "onStop")
    public static void n(BaseComponentActivity r2) {
        r2.m();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT < 21) goto L12;
        r2.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L8
        return;
    L13:
        return;
    }

    @Override // android.app.Activity
    public void finish() {
        com.obric.matrix.r.c.c.b(this.f8889f, "finish is invoked.");
        this.f8890g = false;
        super.finish();
    }

    public void m() {
        com.obric.matrix.r.c.c.b(this.f8889f, "onStop is invoked.");
        super.onStop();
        if (this.f8890g == true) goto L5;
        return;
    L5:
        if (isFinishing() == true) goto L9;
        super.finish();
        return;
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int r4, KeyEvent r5) {
        com.obric.matrix.r.c.c.b(this.f8889f, "onKeyDown is invoked and keyCode is " + r4 + ", event is " + r5 + '.');
        if (4 != r4) goto L6;
        this.f8890g = false;
    L6:
        return super.onKeyDown(r4, r5);
    }

    @Override // android.app.Activity
    protected void onPause() {
        com.obric.matrix.r.c.c.b(this.f8889f, "onPause is invoked.");
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onStop() {
        n(this);
    }
}

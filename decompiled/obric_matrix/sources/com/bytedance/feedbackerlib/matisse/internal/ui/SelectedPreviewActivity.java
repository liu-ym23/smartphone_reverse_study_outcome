package com.bytedance.feedbackerlib.matisse.internal.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.window.embedding.EmbeddingCompat;
import com.bytedance.feedbackerlib.matisse.internal.entity.Item;
import com.bytedance.feedbackerlib.matisse.internal.entity.c;
import com.bytedance.sysoptimizer.BadParcelableCrashOptimizer;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import java.util.ArrayList;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class SelectedPreviewActivity extends BasePreviewActivity {
    public SelectedPreviewActivity() {
    }

    @Proxy("getBundleExtra")
    @TargetClass("android.content.Intent")
    public static Bundle K(Intent r0, String r1) {
        Bundle r2 = r0.getBundleExtra(r1);
        Context r3 = BadParcelableCrashOptimizer.getContext();
        if (r2 == null) goto L6;
        if (r3 == null) goto L6;
        r2.setClassLoader(r3.getClassLoader());
    L6:
        return r2;
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = EmbeddingCompat.DEBUG, value = "onStop")
    public static void M(SelectedPreviewActivity r2) {
        r2.L();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT < 21) goto L12;
        r2.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L8
        return;
    L13:
        return;
    }

    public void L() {
        super.onStop();
    }

    @Override // com.bytedance.feedbackerlib.matisse.internal.ui.BasePreviewActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(@Nullable Bundle r4) {
        super.onCreate(r4);
        if (c.b().q == true) goto L6;
        setResult(0);
        finish();
        return;
    L6:
        ArrayList r5 = K(getIntent(), "extra_default_bundle").getParcelableArrayList("state_selection");
        this.f4382i.a(r5);
        this.f4382i.notifyDataSetChanged();
        if (this.f4380g.f4350f == false) goto L9;
        this.f4383j.setCheckedNum(1);
    L10:
        this.n = 0;
        J((Item) r5.get(0));
        return;
    L9:
        this.f4383j.setChecked(true);
        goto L10
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        M(this);
    }
}

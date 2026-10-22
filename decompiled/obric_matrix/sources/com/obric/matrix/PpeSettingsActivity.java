package com.obric.matrix;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import androidx.window.embedding.EmbeddingCompat;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.matrix.base.ui.CommonEmptyActivity;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.d.d0;
import kotlin.n0.d.q;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014¨\u0006\t"}, d2 = {"Lcom/obric/matrix/PpeSettingsActivity;", "Lcom/obric/matrix/base/ui/CommonEmptyActivity;", "()V", "addBoeSetting", "", "addPPESetting", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_matrix_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PpeSettingsActivity extends CommonEmptyActivity {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Map<Integer, View> f8367h;

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class a extends q implements kotlin.n0.c.a<f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ d0<Switch> f8368f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ EditText f8369g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ PpeSettingsActivity f8370h;

        a(d0<Switch> r1, EditText r2, PpeSettingsActivity r3) {
            this.f8368f = r1;
            this.f8369g = r2;
            this.f8370h = r3;
            super(0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private static final void a(d0 r1, EditText r2, PpeSettingsActivity r3) {
            kotlin.n0.d.o.f(r1, "$switch");
            kotlin.n0.d.o.f(r2, "$editText");
            kotlin.n0.d.o.f(r3, "this$0");
            com.obric.matrix.account.a.f8438a.a();
            com.obric.matrix.base.env.d.f8838a.h(((Switch) r1.f18431f).isChecked(), r2.getText().toString());
            com.obric.matrix.base.env.f.f8844a.i(r3);
        }

        public static /* synthetic */ void b(d0 r0, EditText r1, PpeSettingsActivity r2) {
            a(r0, r1, r2);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ f0 invoke() {
            invoke2();
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            final d0<Switch> r0 = this.f8368f;
            final EditText r1 = this.f8369g;
            final PpeSettingsActivity r3 = this.f8370h;
            com.bytedance.common.utility.m.c.c(new j(r0, r1, r3));
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class b extends q implements kotlin.n0.c.a<f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ PpeSettingsActivity f8371f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ d0<Switch> f8372g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ EditText f8373h;

        b(PpeSettingsActivity r1, d0<Switch> r2, EditText r3) {
            this.f8371f = r1;
            this.f8372g = r2;
            this.f8373h = r3;
            super(0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private static final void a(PpeSettingsActivity r1, d0 r2, EditText r3) {
            kotlin.n0.d.o.f(r1, "this$0");
            kotlin.n0.d.o.f(r2, "$switch");
            kotlin.n0.d.o.f(r3, "$editText");
            com.obric.matrix.account.a.f8438a.a();
            com.obric.matrix.base.env.f.f8844a.i(r1);
            com.obric.matrix.base.env.d r4 = com.obric.matrix.base.env.d.f8838a;
            r4.i(((Switch) r2.f18431f).isChecked());
            r4.j(r3.getText().toString());
        }

        public static /* synthetic */ void b(PpeSettingsActivity r0, d0 r1, EditText r2) {
            a(r0, r1, r2);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ f0 invoke() {
            invoke2();
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            final PpeSettingsActivity r0 = this.f8371f;
            final d0<Switch> r1 = this.f8372g;
            final EditText r3 = this.f8373h;
            com.bytedance.common.utility.m.c.c(new k(r0, r1, r3));
        }
    }

    public PpeSettingsActivity() {
        this.f8367h = new LinkedHashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [T, android.widget.Switch] */
    private final void A() {
        d0 r0 = new d0();
        r0.f18431f = u("是否开启Boe");
        EditText r1 = t();
        com.obric.matrix.base.env.d r2 = com.obric.matrix.base.env.d.f8838a;
        if (TextUtils.isEmpty(r2.b()) == true) goto L5;
        String r3 = r2.b();
    L6:
        r1.setText(r3);
        ((Switch) r0.f18431f).setChecked(r2.e());
        o("更新BOE", "boe开关变化，或则环境变化之后都需要点击这个btn 生效, 点击之后会重启 app", new a(r0, r1, this));
        return;
    L5:
        r3 = "boe_pico";
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [T, android.widget.Switch] */
    private final void B() {
        d0 r0 = new d0();
        r0.f18431f = u("是否开启PPE");
        EditText r1 = t();
        com.obric.matrix.base.env.d r2 = com.obric.matrix.base.env.d.f8838a;
        if (TextUtils.isEmpty(r2.d()) == true) goto L5;
        String r3 = r2.d();
    L6:
        r1.setText(r3);
        ((Switch) r0.f18431f).setChecked(r2.f());
        o("更新PPE", "ppe开关变化，或则环境变化之后都需要点击这个btn 生效, 点击之后会重启 app", new b(this, r0, r1));
        return;
    L5:
        r3 = "";
        goto L6
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = EmbeddingCompat.DEBUG, value = "onStop")
    public static void C(PpeSettingsActivity r2) {
        r2.z();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT < 21) goto L12;
        r2.getWindow().getDecorView().getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L8
        return;
    L13:
        return;
    }

    @Override // com.obric.matrix.base.ui.CommonEmptyActivity
    public View m(int r3) {
        Map<Integer, View> r0 = this.f8367h;
        View r1 = r0.get(Integer.valueOf(r3));
        if (r1 != null) goto L9;
        View r2 = findViewById(r3);
        if (r2 == null) goto L7;
        r0.put(Integer.valueOf(r3), r2);
        return r2;
    L7:
        return null;
    L9:
        return r1;
    }

    @Override // com.obric.matrix.base.ui.CommonEmptyActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        super.onCreate(r1);
        B();
        A();
    }

    @Override // android.app.Activity
    protected void onStop() {
        C(this);
    }

    public void z() {
        super.onStop();
    }
}

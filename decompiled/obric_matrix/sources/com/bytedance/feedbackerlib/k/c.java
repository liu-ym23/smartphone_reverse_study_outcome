package com.bytedance.feedbackerlib.k;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;
import androidx.fragment.app.Fragment;
import com.bytedance.feedbackerlib.activity.TranslucentOnePixelActivity;
import com.bytedance.feedbackerlib.matisse.internal.entity.Item;
import com.bytedance.feedbackerlib.matisse.ui.MatisseActivity;
import java.util.List;
import java.util.Set;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.feedbackerlib.k.a f4242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bytedance.feedbackerlib.matisse.internal.entity.c f4243b;

    class a implements TranslucentOnePixelActivity.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Activity f4244a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f4245b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f4246c;

        a(c r1, Activity r2, int r3) {
            this.f4246c = r1;
            this.f4244a = r2;
            this.f4245b = r3;
        }

        @Override // com.bytedance.feedbackerlib.activity.TranslucentOnePixelActivity.b
        public void onRequestPermissionResult(String[] r3, int[] r4) {
            if (r4.length == 2) goto L5;
        L14:
            Toast.makeText(this.f4244a, "权限申请失败", 0).show();
            return;
        L5:
            if (r4[0] != 0) goto L14;
            if (r4[1] != 0) goto L14;
            Intent r5 = new Intent(this.f4244a, MatisseActivity.class);
            Fragment r6 = c.b(this.f4246c).d();
            if (r6 == null) goto L12;
            r6.startActivityForResult(r5, this.f4245b);     // Catch: Throwable -> L16
        L17:
            return;
        L12:
            this.f4244a.startActivityForResult(r5, this.f4245b);     // Catch: Throwable -> L16
        }
    }

    c(com.bytedance.feedbackerlib.k.a r1, @NonNull Set<b> r2, boolean r3) {
        this.f4242a = r1;
        com.bytedance.feedbackerlib.matisse.internal.entity.c r4 = com.bytedance.feedbackerlib.matisse.internal.entity.c.a();
        this.f4243b = r4;
        r4.f4345a = r2;
        r4.f4346b = r3;
        r4.f4349e = -1;
    }

    @Proxy("getApplicationContext")
    @TargetClass(scope = Scope.ALL, value = "android.content.Context")
    public static Context a(Activity r2) {
        return r2.getApplicationContext();
    L4:
        e = move-exception;
        com.obric.matrix.r.c.c.g("hookGetApplicationContext", "getApplicationContext error", e);
        return com.bytedance.mpaas.app.a.a();
    }

    static /* synthetic */ com.bytedance.feedbackerlib.k.a b(c r0) {
        return r0.f4242a;
    }

    public c c(boolean r2) {
        this.f4243b.t = r2;
        return this;
    }

    public c d(List<Item> r2) {
        this.f4243b.y = r2;
        return this;
    }

    public c e(boolean r2) {
        this.f4243b.u = r2;
        return this;
    }

    public c f(boolean r2) {
        this.f4243b.f4350f = r2;
        return this;
    }

    public void g(int r4) {
        Activity r0 = this.f4242a.c();
        if (r0 != null) goto L5;
        return;
    L5:
        TranslucentOnePixelActivity.D(a(r0), new a(this, r0, r4), new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"});
    }

    public c h(com.bytedance.feedbackerlib.k.d.a r2) {
        this.f4243b.p = r2;
        return this;
    }

    public c i(int r3) {
        if (r3 < 1) goto L13;
        com.bytedance.feedbackerlib.matisse.internal.entity.c r0 = this.f4243b;
        if (r0.f4352h > 0) goto L11;
        if (r0.f4353i > 0) goto L11;
        r0.f4351g = r3;
        return this;
    L11:
        throw new IllegalStateException("already set maxImageSelectable and maxVideoSelectable");
    L13:
        throw new IllegalArgumentException("maxSelectable must be greater than or equal to one");
    }

    public c j(int r2) {
        this.f4243b.f4353i = r2;
        return this;
    }

    public c k(boolean r2) {
        this.f4243b.s = r2;
        return this;
    }

    public c l(int r2) {
        if (r2 < 1) goto L7;
        this.f4243b.m = r2;
        return this;
    L7:
        throw new IllegalArgumentException("spanCount cannot be less than 1");
    }

    public c m(@StyleRes int r2) {
        this.f4243b.f4348d = r2;
        return this;
    }
}

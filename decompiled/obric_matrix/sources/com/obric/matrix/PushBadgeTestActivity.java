package com.obric.matrix;

import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.window.embedding.EmbeddingCompat;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.obric.matrix.base.ui.CommonEmptyActivity;
import com.obric.matrix.common_api.IBadgeApi;
import com.obric.matrix.opush_api.IPush;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.d.q;
import kotlin.v;
import kotlin.w;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Insert;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014J+\u0010\t\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/matrix/PushBadgeTestActivity;", "Lcom/obric/matrix/base/ui/CommonEmptyActivity;", "()V", "resultTextView", "Landroid/widget/TextView;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "updateBadge", "rawInput", "", "setNum", "", "addNum", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "Companion", "app_matrix_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PushBadgeTestActivity extends CommonEmptyActivity {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private TextView f8374h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Map<Integer, View> f8375i;

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class a extends q implements kotlin.n0.c.a<f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ PushBadgeTestActivity f8376f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ EditText f8377g;

        a(PushBadgeTestActivity r1, EditText r2) {
            this.f8376f = r1;
            this.f8377g = r2;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ f0 invoke() {
            invoke2();
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            PushBadgeTestActivity r0 = this.f8376f;
            Editable r3 = this.f8377g.getText();
            if (r3 == null) goto L5;
            String r4 = r3.toString();
        L6:
            PushBadgeTestActivity.A(r0, r4, -1, null);
            return;
        L5:
            r4 = null;
            goto L6
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class b extends q implements kotlin.n0.c.a<f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ PushBadgeTestActivity f8378f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ EditText f8379g;

        b(PushBadgeTestActivity r1, EditText r2) {
            this.f8378f = r1;
            this.f8379g = r2;
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ f0 invoke() {
            invoke2();
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            PushBadgeTestActivity r0 = this.f8378f;
            Editable r3 = this.f8379g.getText();
            if (r3 == null) goto L5;
            String r4 = r3.toString();
        L6:
            PushBadgeTestActivity.A(r0, r4, null, -1);
            return;
        L5:
            r4 = null;
            goto L6
        }
    }

    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class c extends q implements kotlin.n0.c.a<f0> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final c f8380f = null;

        static {
            f8380f = new c();
        }

        c() {
            super(0);
        }

        @Override // kotlin.n0.c.a
        public /* bridge */ /* synthetic */ f0 invoke() {
            invoke2();
            return f0.f18324a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((IPush) com.bytedance.news.common.service.manager.d.a(IPush.class)).sendTestNotification();
        }
    }

    static {
    }

    public PushBadgeTestActivity() {
        this.f8375i = new LinkedHashMap();
    }

    public static final /* synthetic */ void A(PushBadgeTestActivity r0, String r1, Integer r2, Integer r3) {
        r0.C(r1, r2, r3);
    }

    @TargetClass(scope = Scope.LEAF, value = "android.app.Activity")
    @Insert(mayCreateSuper = EmbeddingCompat.DEBUG, value = "onStop")
    public static void B(PushBadgeTestActivity r2) {
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

    private final void C(String r10, Integer r11, Integer r12) {
        if (r10 == null) goto L5;
        String r13 = kotlin.u0.k.G0(r10).toString();
    L6:
        if (r13 != null) goto L9;
        r13 = "";
    L9:
        if (r13.length() != 0) goto L11;
        boolean r1 = true;
    L13:
        if (r1 == false) goto L21;
        TextView r9 = this.f8374h;
        if (r9 == null) goto L19;
        String r14 = "输入无效：请输入整数";
    L17:
        r9.setText(r14);
        return;
    L19:
        kotlin.n0.d.o.v("resultTextView");
        throw null;
    L21:
        Integer r2 = kotlin.u0.k.i(r13);
        if (r2 != null) goto L28;
        r9 = this.f8374h;
        if (r9 == null) goto L26;
        r14 = "输入无效：" + r13 + " 不是合法整数";
        goto L17
    L26:
        kotlin.n0.d.o.v("resultTextView");
        throw null;
    L28:
        IBadgeApi r3 = (IBadgeApi) com.bytedance.news.common.service.manager.d.a(IBadgeApi.class);
        if (r3 != null) goto L35;
        r9 = this.f8374h;
        if (r9 == null) goto L33;
        r14 = "调用失败：IBadgeApi 服务不存在";
        goto L17
    L33:
        kotlin.n0.d.o.v("resultTextView");
        throw null;
    L35:
        if (r11 == null) goto L37;
        int r15 = r11.intValue();
    L38:
        if (r12 == null) goto L40;
        int r16 = r12.intValue();
    L63:
        v.a r17 = v.f21457g;     // Catch: Throwable -> L43
        r3.updateBadge(this, "com.obric.matrix_demo", r15, r16, "Matrix_Push");     // Catch: Throwable -> L43
        Object r18 = f0.f18324a;     // Catch: Throwable -> L43
        v.b(r18);     // Catch: Throwable -> L43
    L46:
        if (v.g(r18) == false) goto L52;
        f0 r4 = (f0) r18;
        TextView r5 = this.f8374h;
        if (r5 == null) goto L50;
        r5.setText("调用成功：pkg=com.obric.matrix_demo, setNum=" + r15 + ", addNum=" + r16 + ", from=Matrix_Push");
        goto L52
    L50:
        kotlin.n0.d.o.v("resultTextView");
        throw null;
    L52:
        Throwable r19 = v.d(r18);
        if (r19 == null) goto L62;
        TextView r20 = this.f8374h;
        if (r20 == null) goto L60;
        StringBuilder r110 = new StringBuilder();
        r110.append("调用失败：");
        String r111 = r19.getMessage();
        if (r111 != null) goto L59;
        r111 = r19.getClass().getSimpleName();
    L59:
        r110.append(r111);
        r20.setText(r110.toString());
        return;
    L60:
        kotlin.n0.d.o.v("resultTextView");
        throw null;
    L62:
        return;
    L43:
        th = move-exception;
        v.a r6 = v.f21457g;
        r18 = w.a(th);
        v.b(r18);
        goto L46
    L40:
        r16 = r2.intValue();
        goto L63
    L37:
        r15 = r2.intValue();
        goto L38
    L11:
        r1 = false;
        goto L13
    L5:
        r13 = null;
        goto L6
    }

    @Override // com.obric.matrix.base.ui.CommonEmptyActivity
    public View m(int r3) {
        Map<Integer, View> r0 = this.f8375i;
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
    protected void onCreate(Bundle r4) {
        super.onCreate(r4);
        v("输入角标数字，点击按钮后调用 IBadgeApi.updateBadge");
        EditText r5 = t();
        r5.setHint("请输入整数");
        r5.setInputType(InputDeviceCompat.SOURCE_TOUCHSCREEN);
        this.f8374h = v("");
        o("addNum", "", new a(this, r5));
        o("setNum", "", new b(this, r5));
        o("发送通知", "", c.f8380f);
    }

    @Override // android.app.Activity
    protected void onStop() {
        B(this);
    }

    public void z() {
        super.onStop();
    }
}

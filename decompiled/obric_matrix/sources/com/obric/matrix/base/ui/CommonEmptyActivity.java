package com.obric.matrix.base.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import com.bytedance.common.utility.l;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.f0;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tJ$\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fJ$\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\n\u001a\u00020\u0004JJ\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u00042\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u0012\u0010\u001f\u001a\u00020\r2\b\u0010 \u001a\u0004\u0018\u00010!H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/obric/matrix/base/ui/CommonEmptyActivity;", "Landroidx/activity/ComponentActivity;", "()V", "TAG", "", "addBtn", "Landroid/widget/Button;", "btnName", "clazz", "Ljava/lang/Class;", "desc", "onClick", "Lkotlin/Function0;", "", "addBtnWithId", "id", "", "addEditTxt", "Landroid/widget/EditText;", "addSwitch", "Landroid/widget/Switch;", "addTxtView", "Landroid/widget/TextView;", "makeDialog", "Landroid/app/AlertDialog;", "title", "message", "positiveText", "negativeText", "onPositive", "onNegative", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "internal_cnRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class CommonEmptyActivity extends ComponentActivity {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f8891f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Map<Integer, View> f8892g;

    public CommonEmptyActivity() {
        this.f8892g = new LinkedHashMap();
        this.f8891f = "CommonEmptyActivity";
    }

    private static final void p(CommonEmptyActivity r0, String r1, kotlin.n0.c.a r2, View r3) {
        o.f(r0, "this$0");
        o.f(r1, "$btnName");
        o.f(r2, "$onClick");
        Log.d(r0.f8891f, r1 + " click");
        r2.invoke();
    }

    private static final void q(CommonEmptyActivity r0, Class r1, View r2) {
        o.f(r0, "this$0");
        o.f(r1, "$clazz");
        r0.startActivity(new Intent(r0, r1));
    }

    private static final void s(CommonEmptyActivity r0, String r1, kotlin.n0.c.a r2, View r3) {
        o.f(r0, "this$0");
        o.f(r1, "$btnName");
        o.f(r2, "$onClick");
        Log.d(r0.f8891f, r1 + " click");
        r2.invoke();
    }

    public static /* synthetic */ void w(CommonEmptyActivity r0, String r1, kotlin.n0.c.a r2, View r3) {
        s(r0, r1, r2, r3);
    }

    public static /* synthetic */ void x(CommonEmptyActivity r0, Class r1, View r2) {
        q(r0, r1, r2);
    }

    public static /* synthetic */ void y(CommonEmptyActivity r0, String r1, kotlin.n0.c.a r2, View r3) {
        p(r0, r1, r2, r3);
    }

    public View m(int r3) {
        Map<Integer, View> r0 = this.f8892g;
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

    public final Button n(String r3, final Class<?> r4) {
        o.f(r3, "btnName");
        o.f(r4, "clazz");
        Button r0 = new Button(this);
        r0.setText(r3);
        r0.setOnClickListener(new b(this, r4));
        LinearLayout.LayoutParams r5 = new LinearLayout.LayoutParams(-1, -2);
        LinearLayout r2 = (LinearLayout) m(com.obric.matrix.q.d.a.f9847a);
        o.c(r2);
        r2.addView(r0, r5);
        return r0;
    }

    public final Button o(final String r4, String r5, final kotlin.n0.c.a<f0> r6) {
        o.f(r4, "btnName");
        o.f(r5, "desc");
        o.f(r6, "onClick");
        Button r0 = new Button(this);
        r0.setText(r4);
        r0.setOnClickListener(new c(this, r4, r6));
        LinearLayout.LayoutParams r7 = new LinearLayout.LayoutParams(-1, -2);
        int r1 = com.obric.matrix.q.d.a.f9847a;
        LinearLayout r2 = (LinearLayout) m(r1);
        o.c(r2);
        r2.addView(r0, r7);
        if (TextUtils.isEmpty(r5) == true) goto L5;
        TextView r3 = new TextView(this);
        r3.setText(r5);
        LinearLayout r8 = (LinearLayout) m(r1);
        o.c(r8);
        r8.addView(r3, r7);
    L5:
        LinearLayout r9 = (LinearLayout) m(r1);
        o.c(r9);
        r9.addView(new View(this), new LinearLayout.LayoutParams(-1, 24));
        return r0;
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle r1) {
        super.onCreate(r1);
        setContentView(com.obric.matrix.q.d.b.f9848a);
    }

    public final Button r(final String r3, int r4, final kotlin.n0.c.a<f0> r5) {
        o.f(r3, "btnName");
        o.f(r5, "onClick");
        Button r0 = new Button(this);
        r0.setText(r3);
        r0.setId(r4);
        r0.setOnClickListener(new a(this, r3, r5));
        LinearLayout.LayoutParams r6 = new LinearLayout.LayoutParams(-1, -2);
        int r7 = com.obric.matrix.q.d.a.f9847a;
        LinearLayout r1 = (LinearLayout) m(r7);
        o.c(r1);
        r1.addView(r0, r6);
        LinearLayout r8 = (LinearLayout) m(r7);
        o.c(r8);
        r8.addView(new View(this), new LinearLayout.LayoutParams(-1, 24));
        return r0;
    }

    public final EditText t() {
        EditText r0 = new EditText(this);
        LinearLayout.LayoutParams r1 = new LinearLayout.LayoutParams(-1, -2);
        LinearLayout r4 = (LinearLayout) m(com.obric.matrix.q.d.a.f9847a);
        o.c(r4);
        r4.addView(r0, r1);
        return r0;
    }

    public final Switch u(String r6) {
        o.f(r6, "desc");
        LayoutInflater r0 = LayoutInflater.from(this);
        int r1 = com.obric.matrix.q.d.b.f9849b;
        int r2 = com.obric.matrix.q.d.a.f9847a;
        View r3 = r0.inflate(r1, (LinearLayout) m(r2), false);
        Objects.requireNonNull(r3, "null cannot be cast to non-null type android.widget.Switch");
        Switch r4 = (Switch) r3;
        r4.setText(r6);
        int r7 = (int) l.a(this, 8.0f);
        r4.setPadding(r7, r7, r7, r7);
        LinearLayout.LayoutParams r5 = new LinearLayout.LayoutParams(-1, -2);
        r5.leftMargin = r7;
        r5.rightMargin = r7;
        r5.topMargin = r7;
        r5.bottomMargin = r7;
        LinearLayout r8 = (LinearLayout) m(r2);
        o.c(r8);
        r8.addView(r4, r5);
        return r4;
    }

    public final TextView v(String r5) {
        o.f(r5, "desc");
        LinearLayout.LayoutParams r0 = new LinearLayout.LayoutParams(-1, -2);
        TextView r2 = new TextView(this);
        r2.setText(r5);
        int r6 = com.obric.matrix.q.d.a.f9847a;
        LinearLayout r3 = (LinearLayout) m(r6);
        o.c(r3);
        r3.addView(r2, r0);
        LinearLayout r7 = (LinearLayout) m(r6);
        o.c(r7);
        r7.addView(new View(this), new LinearLayout.LayoutParams(-1, 24));
        return r2;
    }
}

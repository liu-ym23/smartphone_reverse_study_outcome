package com.obric.oui.radio;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.appcompat.widget.AppCompatRadioButton;
import com.obric.common.oui.R;
import com.obric.oui.common.util.ViewExtensionsKt;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
@Metadata
public class ORadio extends AppCompatRadioButton {
    public final boolean b;
    public final boolean c;
    public int e;
    public final boolean f;

    @JvmOverloads
    public ORadio(@NotNull Context r4, @Nullable AttributeSet r5) {
        Intrinsics.f(r4, "context");
        super(r4, r5, 0);
        this.f = false;
        this.c = true;
        if (r5 == null) goto L6;
        TypedArray r6 = r4.obtainStyledAttributes(r5, R.styleable.o, 0, 0);
        Intrinsics.e(r6, "context.obtainStyledAttr….ORadio, defStyleAttr, 0)");
        this.f = r6.getBoolean(1, false);
        this.e = r6.getInt(3, 0);
        this.c = r6.getBoolean(0, true);
        this.b = r6.getBoolean(2, false);
        r6.recycle();
    L6:
        if (this.f == true) goto L8;
        a();
        return;
    L8:
        setClickable(true);
    }

    public final void a() {
        if (this.f == false) goto L6;
        return;
    L6:
        if (this.e != 1) goto L9;
        setButtonDrawable(com.bytedance.securityserver.R.drawable.o_ic_radio_tick_checked);
    L13:
        setChecked(isChecked());
        return;
    L9:
        if (this.b == false) goto L11;
        int r0 = com.bytedance.securityserver.R.drawable.o_radio_round_always_light;
    L12:
        setButtonDrawable(r0);
        goto L13
    L11:
        r0 = com.bytedance.securityserver.R.drawable.o_radio_round;
        goto L12
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f == false) goto L6;
        return;
    L6:
        if (this.c == false) goto L9;
        Resources r1 = Resources.getSystem();
        Intrinsics.e(r1, "Resources.getSystem()");
        ViewExtensionsKt.a(this, MathKt.a(TypedValue.applyDimension(1, 44, r1.getDisplayMetrics())));
        return;
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean r3) {
        super.setChecked(r3);
        if (this.f == false) goto L6;
        return;
    L6:
        if (this.e != 1) goto L12;
        if (r3 == false) goto L9;
        int r4 = 0;
    L10:
        setVisibility(r4);
        return;
    L9:
        r4 = 4;
        goto L10
    }

    public final void setStyle(int r2) {
        if (this.f == false) goto L5;
        return;
    L5:
        this.e = r2;
        a();
    }
}

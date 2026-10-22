package com.obric.oui.popover.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.bytedance.securityserver.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class PopoverMenuLinearLayout extends LinearLayout {
    public float b;
    public Index c;
    public Function2 e;
    public int f;
    public boolean i;

    @Metadata
    public static final enum Index extends Enum<Index> {
        public static final Index b = null;
        public static final /* synthetic */ Index[] c = null;

        static {
            Index r0 = new Index("FIRST", 0);
            Index r1 = new Index("LAST", 1);
            Index r2 = new Index("OTHER", 2);
            b = r2;
            c = new Index[]{r0, r1, r2, new Index("ONLY_ONE", 3)};
        }

        public static Index valueOf(String r1) {
            return (Index) Enum.valueOf(Index.class, r1);
        }

        public static Index[] values() {
            return (Index[]) c.clone();
        }
    }

    @JvmOverloads
    public PopoverMenuLinearLayout(@NotNull Context r3, @Nullable AttributeSet r4) {
        Intrinsics.f(r3, "context");
        super(r3, r4, 0);
        Resources r0 = Resources.getSystem();
        Intrinsics.e(r0, "Resources.getSystem()");
        this.b = TypedValue.applyDimension(1, 20, r0.getDisplayMetrics());
        this.c = Index.b;
        this.f = ContextCompat.getColor(r3, R.color.oui_state_overlay_pressed);
    }

    public final boolean getForceDark() {
        return this.i;
    }

    @NotNull
    public final Index getIndexPos() {
        return this.c;
    }

    @Nullable
    public final Function2<Boolean, Integer, Unit> getNotifyPressedCallback() {
        return this.e;
    }

    public final float getPressedCornerRadius() {
        return this.b;
    }

    public final void setForceDark(boolean r3) {
        if (r3 == false) goto L4;
        this.f = Color.parseColor("#FF45474F");
    L5:
        this.i = r3;
        return;
    L4:
        this.f = ContextCompat.getColor(getContext(), R.color.oui_state_overlay_pressed);
        goto L5
    }

    public final void setIndexPos(@NotNull Index r2) {
        Intrinsics.f(r2, "<set-?>");
        this.c = r2;
    }

    public final void setNotifyPressedCallback(@Nullable Function2<? super Boolean, ? super Integer, Unit> r1) {
        this.e = r1;
    }

    @Override // android.view.View
    public void setPressed(boolean r5) {
        super.setPressed(r5);
        Function2 r1 = this.e;
        if (r1 == null) goto L5;
        Unit r2 = (Unit) r1.mo7invoke(Boolean.valueOf(r5), Integer.valueOf(this.f));
    L5:
        if (r5 == false) goto L7;
        GradientDrawable r6 = new GradientDrawable();
        r6.setColor(this.f);
        float r3 = this.b;
        r6.setCornerRadii(new float[]{r3, r3, r3, r3, r3, r3, r3, r3});
        setBackground(r6);
        return;
    L7:
        setBackgroundColor(0);
    }

    public final void setPressedCornerRadius(float r1) {
        this.b = r1;
    }
}

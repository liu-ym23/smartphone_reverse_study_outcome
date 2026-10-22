package com.obric.oui.forms;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatEditText;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OFormEditText extends AppCompatEditText {
    public boolean b;
    public boolean c;
    public boolean e;
    public boolean f;

    @JvmOverloads
    public OFormEditText(@NotNull Context r3, @Nullable AttributeSet r4) {
        Intrinsics.f(r3, "context");
        super(r3, r4, 0);
    }

    @Override // android.view.View
    public float getBottomFadingEdgeStrength() {
        if (this.f == true) goto L7;
        return 0.0f;
    L7:
        return super.getBottomFadingEdgeStrength();
    }

    @Override // android.widget.TextView, android.view.View
    public float getLeftFadingEdgeStrength() {
        if (this.b == true) goto L7;
        return 0.0f;
    L7:
        return super.getLeftFadingEdgeStrength();
    }

    @Override // android.widget.TextView, android.view.View
    public float getRightFadingEdgeStrength() {
        if (this.c == true) goto L7;
        return 0.0f;
    L7:
        return super.getRightFadingEdgeStrength();
    }

    @Override // android.view.View
    public float getTopFadingEdgeStrength() {
        if (this.e == true) goto L7;
        return 0.0f;
    L7:
        return super.getTopFadingEdgeStrength();
    }

    public final void setBottomFading(boolean r1) {
        this.f = r1;
    }

    public final void setLeftFading(boolean r1) {
        this.b = r1;
    }

    public final void setRightFading(boolean r1) {
        this.c = r1;
    }

    public final void setTopFading(boolean r1) {
        this.e = r1;
    }
}

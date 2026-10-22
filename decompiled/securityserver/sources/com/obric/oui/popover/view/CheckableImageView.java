package com.obric.oui.popover.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class CheckableImageView extends AppCompatImageView implements Checkable {
    public boolean b;

    public CheckableImageView(@NotNull Context r2, @Nullable AttributeSet r3) {
        Intrinsics.f(r2, "context");
        super(r2, r3);
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.b;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r2) {
        if (this.b == false) goto L6;
        super.onDraw(r2);
        return;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r1) {
        this.b = r1;
        invalidate();
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.b);
    }
}

package com.obric.oui.checkbox;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Checkable;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.securityserver.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class OCheckMark extends AppCompatImageView implements Checkable {
    public final Drawable b;
    public boolean c;

    public OCheckMark(@NotNull Context r2, @NotNull AttributeSet r3) {
        Intrinsics.f(r2, "context");
        Intrinsics.f(r3, "attrs");
        super(r2, r3);
        Drawable r4 = getResources().getDrawable(R.drawable.o_card_list_item_tail_icon_mark);
        this.b = r4;
        this.c = true;
        Intrinsics.e(r4, "markDrawable");
        setMinimumWidth(r4.getMinimumWidth());
        setMinimumHeight(r4.getMinimumHeight());
        setBackgroundDrawable(r4);
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.c;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean r2) {
        if (this.c != r2) goto L5;
        return;
    L5:
        this.c = r2;
        if (r2 == false) goto L8;
        Drawable r3 = this.b;
    L9:
        setBackgroundDrawable(r3);
        invalidate();
        return;
    L8:
        r3 = null;
        goto L9
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.c);
    }
}

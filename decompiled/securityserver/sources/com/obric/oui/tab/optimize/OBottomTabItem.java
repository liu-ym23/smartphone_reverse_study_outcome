package com.obric.oui.tab.optimize;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.securityserver.R;
import com.obric.oui.utils.log.L;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class OBottomTabItem extends RelativeLayout {
    public Drawable b;
    public Drawable c;

    @Metadata
    public static final class Companion {
    }

    @NotNull
    public final ImageView getIcon() {
        return null;
    }

    @Nullable
    public final Drawable getSelectedIconDrawable() {
        return this.b;
    }

    @NotNull
    public final TextView getTitle() {
        return null;
    }

    @Nullable
    public final Drawable getUnselectedIconDrawable() {
        return this.c;
    }

    @JvmOverloads
    public final void setImageAndTextTintColor(int r4) {
        int r0 = ContextCompat.getColor(getContext(), R.color.oui_text_3b);
        ContextCompat.getColor(getContext(), R.color.oui_accent_bg_low_contrast);
        new ColorStateList(new int[][]{new int[]{android.R.attr.state_selected}, new int[0]}, new int[]{r4, r0});
        throw null;
    }

    @Override // android.view.View
    public void setSelected(boolean r3) {
        super.setSelected(r3);
        if (this.b != null) goto L5;
    L10:
        L.g("optimize.OBottomTabItem", "please set selectedIconDrawable and unselectedIconDrawable");
        if (r3 == false) goto L13;
        throw null;
    L13:
        throw null;
    L5:
        if (this.c == null) goto L10;
        if (r3 == false) goto L9;
        throw null;
    L9:
        throw null;
    }

    public final void setSelectedIconDrawable(@Nullable Drawable r1) {
        this.b = r1;
    }

    public final void setUnselectedIconDrawable(@Nullable Drawable r1) {
        this.c = r1;
    }
}

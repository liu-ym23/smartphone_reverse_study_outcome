package com.google.android.material.internal;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class ToolbarUtils {
    private ToolbarUtils() {
    }

    @Nullable
    public static ActionMenuItemView getActionMenuItemView(@NonNull Toolbar r3, @IdRes int r4) {
        ActionMenuView r5 = getActionMenuView(r3);
        if (r5 == null) goto L13;
        int r0 = 0;
    L6:
        if (r0 >= r5.getChildCount()) goto L19;
        View r1 = r5.getChildAt(r0);
        if ((r1 instanceof ActionMenuItemView) == false) goto L12;
        ActionMenuItemView r2 = (ActionMenuItemView) r1;
        if (r2.getItemData().getItemId() != r4) goto L12;
        return r2;
    L12:
        r0 = r0 + 1;
        goto L6
    L19:
        return null;
    L13:
        return null;
    }

    @Nullable
    public static ActionMenuView getActionMenuView(@NonNull Toolbar r3) {
        int r0 = 0;
    L4:
        if (r0 >= r3.getChildCount()) goto L10;
        View r1 = r3.getChildAt(r0);
        if ((r1 instanceof ActionMenuView) == true) goto L8;
        r0 = r0 + 1;
        goto L4
    L8:
        return (ActionMenuView) r1;
    L10:
        return null;
    }

    @Nullable
    public static ImageButton getNavigationIconButton(@NonNull Toolbar r5) {
        Drawable r0 = r5.getNavigationIcon();
        if (r0 != null) goto L5;
        return null;
    L5:
        int r2 = 0;
    L7:
        if (r2 >= r5.getChildCount()) goto L14;
        View r3 = r5.getChildAt(r2);
        if ((r3 instanceof ImageButton) == false) goto L13;
        ImageButton r4 = (ImageButton) r3;
        if (r4.getDrawable() != r0) goto L13;
        return r4;
    L13:
        r2 = r2 + 1;
        goto L7
    L14:
        return null;
    }

    @Nullable
    public static View getSecondaryActionMenuItemView(@NonNull Toolbar r2) {
        ActionMenuView r3 = getActionMenuView(r2);
        if (r3 != null) goto L5;
        return null;
    L5:
        if (r3.getChildCount() > 1) goto L7;
        return null;
    L7:
        return r3.getChildAt(0);
    }

    @Nullable
    public static TextView getSubtitleTextView(@NonNull Toolbar r1) {
        return getTextView(r1, r1.getSubtitle());
    }

    @Nullable
    private static TextView getTextView(@NonNull Toolbar r3, CharSequence r4) {
        int r0 = 0;
    L4:
        if (r0 >= r3.getChildCount()) goto L11;
        View r1 = r3.getChildAt(r0);
        if ((r1 instanceof TextView) == false) goto L10;
        TextView r2 = (TextView) r1;
        if (TextUtils.equals(r2.getText(), r4) == false) goto L10;
        return r2;
    L10:
        r0 = r0 + 1;
        goto L4
    L11:
        return null;
    }

    @Nullable
    public static TextView getTitleTextView(@NonNull Toolbar r1) {
        return getTextView(r1, r1.getTitle());
    }
}

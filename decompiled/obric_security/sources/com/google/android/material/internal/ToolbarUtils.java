package com.google.android.material.internal;

import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;

/* JADX INFO: loaded from: classes2.dex */
public class ToolbarUtils {
    private ToolbarUtils() {
    }

    public static View getSecondaryActionMenuItemView(Toolbar r2) {
        ActionMenuView r3 = getActionMenuView(r2);
        if (r3 != null) goto L5;
        return null;
    L5:
        if (r3.getChildCount() > 1) goto L7;
        return null;
    L7:
        return r3.getChildAt(0);
    }

    public static ActionMenuView getActionMenuView(Toolbar r3) {
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

    public static ImageButton getNavigationIconButton(Toolbar r1) {
        if (r1.getChildCount() <= 0) goto L8;
        View r2 = r1.getChildAt(0);
        if ((r2 instanceof ImageButton) == true) goto L7;
        return null;
    L7:
        return (ImageButton) r2;
    L8:
        return null;
    }

    public static ActionMenuItemView getActionMenuItemView(Toolbar r3, int r4) {
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
}

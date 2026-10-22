package com.google.android.material.badge;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.R;
import com.google.android.material.internal.ParcelableSparseArray;
import com.google.android.material.internal.ToolbarUtils;

/* JADX INFO: loaded from: classes2.dex */
@ExperimentalBadgeUtils
public class BadgeUtils {
    private static final String LOG_TAG = "BadgeUtils";
    public static final boolean USE_COMPAT_PARENT = false;

    static {
        if (Build.VERSION.SDK_INT >= 18) goto L5;
        boolean r0 = true;
    L6:
        USE_COMPAT_PARENT = r0;
        return;
    L5:
        r0 = false;
        goto L6
    }

    private BadgeUtils() {
    }

    public static void attachBadgeDrawable(@NonNull BadgeDrawable r1, @NonNull View r2) {
        attachBadgeDrawable(r1, r2, null);
    }

    public static void attachBadgeDrawable(@NonNull BadgeDrawable r0, @NonNull View r1, @Nullable FrameLayout r2) {
        setBadgeDrawableBounds(r0, r1, r2);
        if (r0.getCustomBadgeParent() == null) goto L6;
        r0.getCustomBadgeParent().setForeground(r0);
        return;
    L6:
        if (USE_COMPAT_PARENT == true) goto L10;
        r1.getOverlay().add(r0);
        return;
    L10:
        throw new IllegalArgumentException("Trying to reference null customBadgeParent");
    }

    public static void attachBadgeDrawable(@NonNull BadgeDrawable r1, @NonNull Toolbar r2, @IdRes int r3) {
        attachBadgeDrawable(r1, r2, r3, null);
    }

    public static void attachBadgeDrawable(@NonNull final BadgeDrawable r1, @NonNull final Toolbar r2, @IdRes final int r3, @Nullable final FrameLayout r4) {
        r2.post(new AnonymousClass1(r2, r3, r1, r4));
    }

    @NonNull
    public static SparseArray<BadgeDrawable> createBadgeDrawablesFromSavedStates(Context r4, @NonNull ParcelableSparseArray r5) {
        SparseArray<BadgeDrawable> r0 = new SparseArray(r5.size());
        int r1 = 0;
    L4:
        if (r1 >= r5.size()) goto L10;
        int r2 = r5.keyAt(r1);
        BadgeDrawable.SavedState r3 = (BadgeDrawable.SavedState) r5.valueAt(r1);
        if (r3 == null) goto L9;
        r0.put(r2, BadgeDrawable.createFromSavedState(r4, r3));
        r1 = r1 + 1;
        goto L4
    L9:
        throw new IllegalArgumentException("BadgeDrawable's savedState cannot be null");
    L10:
        return r0;
    }

    @NonNull
    public static ParcelableSparseArray createParcelableBadgeStates(@NonNull SparseArray<BadgeDrawable> r4) {
        ParcelableSparseArray r0 = new ParcelableSparseArray();
        int r1 = 0;
    L4:
        if (r1 >= r4.size()) goto L10;
        int r2 = r4.keyAt(r1);
        BadgeDrawable r3 = r4.valueAt(r1);
        if (r3 == null) goto L9;
        r0.put(r2, r3.getSavedState());
        r1 = r1 + 1;
        goto L4
    L9:
        throw new IllegalArgumentException("badgeDrawable cannot be null");
    L10:
        return r0;
    }

    public static void detachBadgeDrawable(@Nullable BadgeDrawable r1, @NonNull View r2) {
        if (r1 != null) goto L5;
        return;
    L5:
        if (USE_COMPAT_PARENT == false) goto L7;
    L10:
        r1.getCustomBadgeParent().setForeground(null);
        return;
    L7:
        if (r1.getCustomBadgeParent() != null) goto L10;
        r2.getOverlay().remove(r1);
    }

    public static void detachBadgeDrawable(@Nullable BadgeDrawable r0, @NonNull Toolbar r1, @IdRes int r2) {
        if (r0 != null) goto L4;
        return;
    L4:
        ActionMenuItemView r3 = ToolbarUtils.getActionMenuItemView(r1, r2);
        if (r3 == null) goto L7;
        removeToolbarOffset(r0);
        detachBadgeDrawable(r0, r3);
        return;
    L7:
        Log.w(LOG_TAG, "Trying to remove badge from a null menuItemView: " + r2);
    }

    @VisibleForTesting
    static void removeToolbarOffset(BadgeDrawable r1) {
        r1.setAdditionalHorizontalOffset(0);
        r1.setAdditionalVerticalOffset(0);
    }

    public static void setBadgeDrawableBounds(@NonNull BadgeDrawable r1, @NonNull View r2, @Nullable FrameLayout r3) {
        Rect r0 = new Rect();
        r2.getDrawingRect(r0);
        r1.setBounds(r0);
        r1.updateBadgeCoordinates(r2, r3);
    }

    @VisibleForTesting
    static void setToolbarOffset(BadgeDrawable r1, Resources r2) {
        r1.setAdditionalHorizontalOffset(r2.getDimensionPixelOffset(R.dimen.mtrl_badge_toolbar_action_menu_item_horizontal_offset));
        r1.setAdditionalVerticalOffset(r2.getDimensionPixelOffset(R.dimen.mtrl_badge_toolbar_action_menu_item_vertical_offset));
    }

    public static void updateBadgeBounds(@NonNull Rect r2, float r3, float r4, float r5, float r6) {
        r2.set((int) (r3 - r5), (int) (r4 - r6), (int) (r3 + r5), (int) (r4 + r6));
    }
}

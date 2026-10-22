package com.google.android.material.badge;

import android.content.Context;
import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.material.internal.ParcelableSparseArray;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class BadgeUtils {
    public static final boolean USE_COMPAT_PARENT = false;

    static {
        USE_COMPAT_PARENT = false;
    }

    private BadgeUtils() {
    }

    public static void attachBadgeDrawable(@NonNull BadgeDrawable r1, @NonNull View r2, @NonNull FrameLayout r3) {
        setBadgeDrawableBounds(r1, r2, r3);
        if (USE_COMPAT_PARENT == false) goto L5;
        r3.setForeground(r1);
        return;
    L5:
        r2.getOverlay().add(r1);
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

    public static void detachBadgeDrawable(@Nullable BadgeDrawable r1, @NonNull View r2, @NonNull FrameLayout r3) {
        if (r1 != null) goto L5;
        return;
    L5:
        if (USE_COMPAT_PARENT == false) goto L7;
        r3.setForeground(null);
        return;
    L7:
        r2.getOverlay().remove(r1);
    }

    public static void setBadgeDrawableBounds(@NonNull BadgeDrawable r2, @NonNull View r3, @NonNull FrameLayout r4) {
        Rect r0 = new Rect();
        if (USE_COMPAT_PARENT == false) goto L5;
        View r1 = r4;
    L6:
        r1.getDrawingRect(r0);
        r2.setBounds(r0);
        r2.updateBadgeCoordinates(r3, r4);
        return;
    L5:
        r1 = r3;
        goto L6
    }

    public static void updateBadgeBounds(@NonNull Rect r2, float r3, float r4, float r5, float r6) {
        r2.set((int) (r3 - r5), (int) (r4 - r6), (int) (r3 + r5), (int) (r4 + r6));
    }
}

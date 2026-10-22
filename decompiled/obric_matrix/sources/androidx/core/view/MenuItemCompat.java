package androidx.core.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.internal.view.SupportMenuItem;

/* JADX INFO: loaded from: classes.dex */
public final class MenuItemCompat {

    @Deprecated
    public static final int SHOW_AS_ACTION_ALWAYS = 2;

    @Deprecated
    public static final int SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW = 8;

    @Deprecated
    public static final int SHOW_AS_ACTION_IF_ROOM = 1;

    @Deprecated
    public static final int SHOW_AS_ACTION_NEVER = 0;

    @Deprecated
    public static final int SHOW_AS_ACTION_WITH_TEXT = 4;
    private static final String TAG = "MenuItemCompat";

    @RequiresApi(26)
    static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        static int getAlphabeticModifiers(MenuItem r0) {
            return r0.getAlphabeticModifiers();
        }

        @DoNotInline
        static CharSequence getContentDescription(MenuItem r0) {
            return r0.getContentDescription();
        }

        @DoNotInline
        static ColorStateList getIconTintList(MenuItem r0) {
            return r0.getIconTintList();
        }

        @DoNotInline
        static PorterDuff.Mode getIconTintMode(MenuItem r0) {
            return r0.getIconTintMode();
        }

        @DoNotInline
        static int getNumericModifiers(MenuItem r0) {
            return r0.getNumericModifiers();
        }

        @DoNotInline
        static CharSequence getTooltipText(MenuItem r0) {
            return r0.getTooltipText();
        }

        @DoNotInline
        static MenuItem setAlphabeticShortcut(MenuItem r0, char r1, int r2) {
            return r0.setAlphabeticShortcut(r1, r2);
        }

        @DoNotInline
        static MenuItem setContentDescription(MenuItem r0, CharSequence r1) {
            return r0.setContentDescription(r1);
        }

        @DoNotInline
        static MenuItem setIconTintList(MenuItem r0, ColorStateList r1) {
            return r0.setIconTintList(r1);
        }

        @DoNotInline
        static MenuItem setIconTintMode(MenuItem r0, PorterDuff.Mode r1) {
            return r0.setIconTintMode(r1);
        }

        @DoNotInline
        static MenuItem setNumericShortcut(MenuItem r0, char r1, int r2) {
            return r0.setNumericShortcut(r1, r2);
        }

        @DoNotInline
        static MenuItem setShortcut(MenuItem r0, char r1, char r2, int r3, int r4) {
            return r0.setShortcut(r1, r2, r3, r4);
        }

        @DoNotInline
        static MenuItem setTooltipText(MenuItem r0, CharSequence r1) {
            return r0.setTooltipText(r1);
        }
    }

    @Deprecated
    public interface OnActionExpandListener {
        boolean onMenuItemActionCollapse(MenuItem r1);

        boolean onMenuItemActionExpand(MenuItem r1);
    }

    private MenuItemCompat() {
    }

    @Deprecated
    public static boolean collapseActionView(MenuItem r0) {
        return r0.collapseActionView();
    }

    @Deprecated
    public static boolean expandActionView(MenuItem r0) {
        return r0.expandActionView();
    }

    @Nullable
    public static ActionProvider getActionProvider(@NonNull MenuItem r1) {
        if ((r1 instanceof SupportMenuItem) == true) goto L5;
        Log.w(TAG, "getActionProvider: item does not implement SupportMenuItem; returning null");
        return null;
    L5:
        return ((SupportMenuItem) r1).getSupportActionProvider();
    }

    @Deprecated
    public static View getActionView(MenuItem r0) {
        return r0.getActionView();
    }

    public static int getAlphabeticModifiers(@NonNull MenuItem r2) {
        if ((r2 instanceof SupportMenuItem) == false) goto L7;
        return ((SupportMenuItem) r2).getAlphabeticModifiers();
    L7:
        if (Build.VERSION.SDK_INT >= 26) goto L9;
        return 0;
    L9:
        return Api26Impl.getAlphabeticModifiers(r2);
    }

    @Nullable
    public static CharSequence getContentDescription(@NonNull MenuItem r2) {
        if ((r2 instanceof SupportMenuItem) == false) goto L7;
        return ((SupportMenuItem) r2).getContentDescription();
    L7:
        if (Build.VERSION.SDK_INT >= 26) goto L9;
        return null;
    L9:
        return Api26Impl.getContentDescription(r2);
    }

    @Nullable
    public static ColorStateList getIconTintList(@NonNull MenuItem r2) {
        if ((r2 instanceof SupportMenuItem) == false) goto L7;
        return ((SupportMenuItem) r2).getIconTintList();
    L7:
        if (Build.VERSION.SDK_INT >= 26) goto L9;
        return null;
    L9:
        return Api26Impl.getIconTintList(r2);
    }

    @Nullable
    public static PorterDuff.Mode getIconTintMode(@NonNull MenuItem r2) {
        if ((r2 instanceof SupportMenuItem) == false) goto L7;
        return ((SupportMenuItem) r2).getIconTintMode();
    L7:
        if (Build.VERSION.SDK_INT >= 26) goto L9;
        return null;
    L9:
        return Api26Impl.getIconTintMode(r2);
    }

    public static int getNumericModifiers(@NonNull MenuItem r2) {
        if ((r2 instanceof SupportMenuItem) == false) goto L7;
        return ((SupportMenuItem) r2).getNumericModifiers();
    L7:
        if (Build.VERSION.SDK_INT >= 26) goto L9;
        return 0;
    L9:
        return Api26Impl.getNumericModifiers(r2);
    }

    @Nullable
    public static CharSequence getTooltipText(@NonNull MenuItem r2) {
        if ((r2 instanceof SupportMenuItem) == false) goto L7;
        return ((SupportMenuItem) r2).getTooltipText();
    L7:
        if (Build.VERSION.SDK_INT >= 26) goto L9;
        return null;
    L9:
        return Api26Impl.getTooltipText(r2);
    }

    @Deprecated
    public static boolean isActionViewExpanded(MenuItem r0) {
        return r0.isActionViewExpanded();
    }

    @Nullable
    public static MenuItem setActionProvider(@NonNull MenuItem r1, @Nullable ActionProvider r2) {
        if ((r1 instanceof SupportMenuItem) == true) goto L5;
        Log.w(TAG, "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return r1;
    L5:
        return ((SupportMenuItem) r1).setSupportActionProvider(r2);
    }

    @Deprecated
    public static MenuItem setActionView(MenuItem r0, int r1) {
        return r0.setActionView(r1);
    }

    @Deprecated
    public static MenuItem setActionView(MenuItem r0, View r1) {
        return r0.setActionView(r1);
    }

    public static void setAlphabeticShortcut(@NonNull MenuItem r2, char r3, int r4) {
        if ((r2 instanceof SupportMenuItem) == false) goto L6;
        ((SupportMenuItem) r2).setAlphabeticShortcut(r3, r4);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 26) goto L10;
        Api26Impl.setAlphabeticShortcut(r2, r3, r4);
        return;
    }

    public static void setContentDescription(@NonNull MenuItem r2, @Nullable CharSequence r3) {
        if ((r2 instanceof SupportMenuItem) == false) goto L6;
        ((SupportMenuItem) r2).setContentDescription(r3);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 26) goto L10;
        Api26Impl.setContentDescription(r2, r3);
        return;
    }

    public static void setIconTintList(@NonNull MenuItem r2, @Nullable ColorStateList r3) {
        if ((r2 instanceof SupportMenuItem) == false) goto L6;
        ((SupportMenuItem) r2).setIconTintList(r3);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 26) goto L10;
        Api26Impl.setIconTintList(r2, r3);
        return;
    }

    public static void setIconTintMode(@NonNull MenuItem r2, @Nullable PorterDuff.Mode r3) {
        if ((r2 instanceof SupportMenuItem) == false) goto L6;
        ((SupportMenuItem) r2).setIconTintMode(r3);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 26) goto L10;
        Api26Impl.setIconTintMode(r2, r3);
        return;
    }

    public static void setNumericShortcut(@NonNull MenuItem r2, char r3, int r4) {
        if ((r2 instanceof SupportMenuItem) == false) goto L6;
        ((SupportMenuItem) r2).setNumericShortcut(r3, r4);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 26) goto L10;
        Api26Impl.setNumericShortcut(r2, r3, r4);
        return;
    }

    @Deprecated
    public static MenuItem setOnActionExpandListener(MenuItem r1, final OnActionExpandListener r2) {
        return r1.setOnActionExpandListener(new AnonymousClass1(r2));
    }

    public static void setShortcut(@NonNull MenuItem r2, char r3, char r4, int r5, int r6) {
        if ((r2 instanceof SupportMenuItem) == false) goto L6;
        ((SupportMenuItem) r2).setShortcut(r3, r4, r5, r6);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 26) goto L10;
        Api26Impl.setShortcut(r2, r3, r4, r5, r6);
        return;
    }

    @Deprecated
    public static void setShowAsAction(MenuItem r0, int r1) {
        r0.setShowAsAction(r1);
    }

    public static void setTooltipText(@NonNull MenuItem r2, @Nullable CharSequence r3) {
        if ((r2 instanceof SupportMenuItem) == false) goto L6;
        ((SupportMenuItem) r2).setTooltipText(r3);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 26) goto L10;
        Api26Impl.setTooltipText(r2, r3);
        return;
    }
}

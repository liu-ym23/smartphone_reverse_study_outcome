package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SpinnerAdapter;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.appcompat.R;
import androidx.appcompat.view.ActionMode;
import androidx.fragment.app.FragmentTransaction;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public abstract class ActionBar {
    public static final int DISPLAY_HOME_AS_UP = 4;
    public static final int DISPLAY_SHOW_CUSTOM = 16;
    public static final int DISPLAY_SHOW_HOME = 2;
    public static final int DISPLAY_SHOW_TITLE = 8;
    public static final int DISPLAY_USE_LOGO = 1;

    @Deprecated
    public static final int NAVIGATION_MODE_LIST = 1;

    @Deprecated
    public static final int NAVIGATION_MODE_STANDARD = 0;

    @Deprecated
    public static final int NAVIGATION_MODE_TABS = 2;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface DisplayOptions {
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int gravity;

        public LayoutParams(@NonNull Context r3, AttributeSet r4) {
            super(r3, r4);
            this.gravity = 0;
            TypedArray r5 = r3.obtainStyledAttributes(r4, R.styleable.ActionBarLayout);
            this.gravity = r5.getInt(R.styleable.ActionBarLayout_android_layout_gravity, 0);
            r5.recycle();
        }

        public LayoutParams(int r1, int r2) {
            super(r1, r2);
            this.gravity = 8388627;
        }

        public LayoutParams(int r1, int r2, int r3) {
            super(r1, r2);
            this.gravity = r3;
        }

        public LayoutParams(int r3) {
            this(-2, -1, r3);
        }

        public LayoutParams(LayoutParams r2) {
            super(r2);
            this.gravity = 0;
            this.gravity = r2.gravity;
        }

        public LayoutParams(ViewGroup.LayoutParams r1) {
            super(r1);
            this.gravity = 0;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface NavigationMode {
    }

    public interface OnMenuVisibilityListener {
        void onMenuVisibilityChanged(boolean r1);
    }

    @Deprecated
    public interface OnNavigationListener {
        boolean onNavigationItemSelected(int r1, long r2);
    }

    @Deprecated
    public static abstract class Tab {
        public static final int INVALID_POSITION = -1;

        public Tab() {
        }

        public abstract CharSequence getContentDescription();

        public abstract View getCustomView();

        public abstract Drawable getIcon();

        public abstract int getPosition();

        public abstract Object getTag();

        public abstract CharSequence getText();

        public abstract void select();

        public abstract Tab setContentDescription(@StringRes int r1);

        public abstract Tab setContentDescription(CharSequence r1);

        public abstract Tab setCustomView(int r1);

        public abstract Tab setCustomView(View r1);

        public abstract Tab setIcon(@DrawableRes int r1);

        public abstract Tab setIcon(Drawable r1);

        public abstract Tab setTabListener(TabListener r1);

        public abstract Tab setTag(Object r1);

        public abstract Tab setText(int r1);

        public abstract Tab setText(CharSequence r1);
    }

    @Deprecated
    public interface TabListener {
        void onTabReselected(Tab r1, FragmentTransaction r2);

        void onTabSelected(Tab r1, FragmentTransaction r2);

        void onTabUnselected(Tab r1, FragmentTransaction r2);
    }

    public ActionBar() {
    }

    public abstract void addOnMenuVisibilityListener(OnMenuVisibilityListener r1);

    @Deprecated
    public abstract void addTab(Tab r1);

    @Deprecated
    public abstract void addTab(Tab r1, int r2);

    @Deprecated
    public abstract void addTab(Tab r1, int r2, boolean r3);

    @Deprecated
    public abstract void addTab(Tab r1, boolean r2);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean closeOptionsMenu() {
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean collapseActionView() {
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void dispatchMenuVisibilityChanged(boolean r1) {
    }

    public abstract View getCustomView();

    public abstract int getDisplayOptions();

    public float getElevation() {
        return 0.0f;
    }

    public abstract int getHeight();

    public int getHideOffset() {
        return 0;
    }

    @Deprecated
    public abstract int getNavigationItemCount();

    @Deprecated
    public abstract int getNavigationMode();

    @Deprecated
    public abstract int getSelectedNavigationIndex();

    @Nullable
    @Deprecated
    public abstract Tab getSelectedTab();

    @Nullable
    public abstract CharSequence getSubtitle();

    @Deprecated
    public abstract Tab getTabAt(int r1);

    @Deprecated
    public abstract int getTabCount();

    public Context getThemedContext() {
        return null;
    }

    @Nullable
    public abstract CharSequence getTitle();

    public abstract void hide();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean invalidateOptionsMenu() {
        return false;
    }

    public boolean isHideOnContentScrollEnabled() {
        return false;
    }

    public abstract boolean isShowing();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean isTitleTruncated() {
        return false;
    }

    @Deprecated
    public abstract Tab newTab();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void onConfigurationChanged(Configuration r1) {
    }

    public void onDestroy() {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean onKeyShortcut(int r1, KeyEvent r2) {
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean onMenuKeyEvent(KeyEvent r1) {
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean openOptionsMenu() {
        return false;
    }

    @Deprecated
    public abstract void removeAllTabs();

    public abstract void removeOnMenuVisibilityListener(OnMenuVisibilityListener r1);

    @Deprecated
    public abstract void removeTab(Tab r1);

    @Deprecated
    public abstract void removeTabAt(int r1);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean requestFocus() {
        return false;
    }

    @Deprecated
    public abstract void selectTab(Tab r1);

    public abstract void setBackgroundDrawable(@Nullable Drawable r1);

    public abstract void setCustomView(int r1);

    public abstract void setCustomView(View r1);

    public abstract void setCustomView(View r1, LayoutParams r2);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setDefaultDisplayHomeAsUpEnabled(boolean r1) {
    }

    public abstract void setDisplayHomeAsUpEnabled(boolean r1);

    public abstract void setDisplayOptions(int r1);

    public abstract void setDisplayOptions(int r1, int r2);

    public abstract void setDisplayShowCustomEnabled(boolean r1);

    public abstract void setDisplayShowHomeEnabled(boolean r1);

    public abstract void setDisplayShowTitleEnabled(boolean r1);

    public abstract void setDisplayUseLogoEnabled(boolean r1);

    public void setElevation(float r1) {
        if (r1 != 0.0f) goto L6;
        return;
    L6:
        throw new UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
    }

    public void setHideOffset(int r1) {
        if (r1 != 0) goto L5;
        return;
    L5:
        throw new UnsupportedOperationException("Setting an explicit action bar hide offset is not supported in this action bar configuration.");
    }

    public void setHideOnContentScrollEnabled(boolean r1) {
        if (r1 == true) goto L5;
        return;
    L5:
        throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
    }

    public void setHomeActionContentDescription(@StringRes int r1) {
    }

    public void setHomeAsUpIndicator(@DrawableRes int r1) {
    }

    public void setHomeButtonEnabled(boolean r1) {
    }

    public abstract void setIcon(@DrawableRes int r1);

    public abstract void setIcon(Drawable r1);

    @Deprecated
    public abstract void setListNavigationCallbacks(SpinnerAdapter r1, OnNavigationListener r2);

    public abstract void setLogo(@DrawableRes int r1);

    public abstract void setLogo(Drawable r1);

    @Deprecated
    public abstract void setNavigationMode(int r1);

    @Deprecated
    public abstract void setSelectedNavigationItem(int r1);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setShowHideAnimationEnabled(boolean r1) {
    }

    public void setSplitBackgroundDrawable(Drawable r1) {
    }

    public void setStackedBackgroundDrawable(Drawable r1) {
    }

    public abstract void setSubtitle(int r1);

    public abstract void setSubtitle(CharSequence r1);

    public abstract void setTitle(@StringRes int r1);

    public abstract void setTitle(CharSequence r1);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void setWindowTitle(CharSequence r1) {
    }

    public abstract void show();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public ActionMode startActionMode(ActionMode.Callback r1) {
        return null;
    }

    public void setHomeActionContentDescription(@Nullable CharSequence r1) {
    }

    public void setHomeAsUpIndicator(@Nullable Drawable r1) {
    }
}

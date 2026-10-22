package androidx.legacy.app;

import android.R;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class ActionBarDrawerToggle implements DrawerLayout.DrawerListener {
    private static final int ID_HOME = 16908332;
    private static final String TAG = "ActionBarDrawerToggle";
    private static final int[] THEME_ATTRS = null;
    private static final float TOGGLE_DRAWABLE_OFFSET = 0.33333334f;
    final Activity mActivity;
    private final Delegate mActivityImpl;
    private final int mCloseDrawerContentDescRes;
    private Drawable mDrawerImage;
    private final int mDrawerImageResource;
    private boolean mDrawerIndicatorEnabled;
    private final DrawerLayout mDrawerLayout;
    private boolean mHasCustomUpIndicator;
    private Drawable mHomeAsUpIndicator;
    private final int mOpenDrawerContentDescRes;
    private SetIndicatorInfo mSetIndicatorInfo;
    private SlideDrawable mSlider;

    @Deprecated
    public interface Delegate {
        @Nullable
        Drawable getThemeUpIndicator();

        void setActionBarDescription(@StringRes int r1);

        void setActionBarUpIndicator(Drawable r1, @StringRes int r2);
    }

    @Deprecated
    public interface DelegateProvider {
        @Nullable
        Delegate getDrawerToggleDelegate();
    }

    private static class SetIndicatorInfo {
        Method mSetHomeActionContentDescription;
        Method mSetHomeAsUpIndicator;
        ImageView mUpIndicatorView;

        SetIndicatorInfo(Activity r7) {
            this.mSetHomeAsUpIndicator = ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", new Class[]{Drawable.class});     // Catch: NoSuchMethodException -> L5
            this.mSetHomeActionContentDescription = ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", new Class[]{Integer.TYPE});     // Catch: NoSuchMethodException -> L5
            return;
        L5:
            View r8 = r7.findViewById(16908332);
            if (r8 != null) goto L8;
            return;
        L8:
            ViewGroup r9 = (ViewGroup) r8.getParent();
            if (r9.getChildCount() == 2) goto L11;
            return;
        L11:
            View r0 = r9.getChildAt(0);
            View r10 = r9.getChildAt(1);
            if (r0.getId() != 16908332) goto L15;
            r0 = r10;
        L15:
            if ((r0 instanceof ImageView) == false) goto L20;
            this.mUpIndicatorView = (ImageView) r0;
            return;
        }
    }

    private class SlideDrawable extends InsetDrawable implements Drawable.Callback {
        private final boolean mHasMirroring;
        private float mOffset;
        private float mPosition;
        private final Rect mTmpRect;
        final /* synthetic */ ActionBarDrawerToggle this$0;

        SlideDrawable(ActionBarDrawerToggle r2, Drawable r3) {
            this.this$0 = r2;
            boolean r4 = false;
            super(r3, 0);
            if (Build.VERSION.SDK_INT <= 18) goto L5;
            r4 = true;
        L5:
            this.mHasMirroring = r4;
            this.mTmpRect = new Rect();
        }

        @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public void draw(@NonNull Canvas r6) {
            copyBounds(this.mTmpRect);
            r6.save();
            int r1 = 1;
            if (ViewCompat.getLayoutDirection(this.this$0.mActivity.getWindow().getDecorView()) != 1) goto L5;
            boolean r0 = true;
        L6:
            if (r0 == false) goto L8;
            r1 = -1;
        L8:
            float r2 = this.mTmpRect.width();
            r6.translate((((-this.mOffset) * r2) * this.mPosition) * r1, 0.0f);
            if (r0 == true) goto L11;
        L13:
            super.draw(r6);
            r6.restore();
            return;
        L11:
            if (this.mHasMirroring == true) goto L13;
            r6.translate(r2, 0.0f);
            r6.scale(-1.0f, 1.0f);
            goto L13
        L5:
            r0 = false;
            goto L6
        }

        public float getPosition() {
            return this.mPosition;
        }

        public void setOffset(float r1) {
            this.mOffset = r1;
            invalidateSelf();
        }

        public void setPosition(float r1) {
            this.mPosition = r1;
            invalidateSelf();
        }
    }

    static {
        THEME_ATTRS = new int[]{R.attr.homeAsUpIndicator};
    }

    public ActionBarDrawerToggle(Activity r9, DrawerLayout r10, @DrawableRes int r11, @StringRes int r12, @StringRes int r13) {
        this(r9, r10, !assumeMaterial(r9), r11, r12, r13);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ActionBarDrawerToggle(Activity r2, DrawerLayout r3, boolean r4, @DrawableRes int r5, @StringRes int r6, @StringRes int r7) {
        this.mDrawerIndicatorEnabled = true;
        this.mActivity = r2;
        if ((r2 instanceof DelegateProvider) == false) goto L5;
        Delegate r0 = ((DelegateProvider) r2).getDrawerToggleDelegate();
    L6:
        this.mActivityImpl = r0;
        this.mDrawerLayout = r3;
        this.mDrawerImageResource = r5;
        this.mOpenDrawerContentDescRes = r6;
        this.mCloseDrawerContentDescRes = r7;
        this.mHomeAsUpIndicator = getThemeUpIndicator();
        this.mDrawerImage = ContextCompat.getDrawable(r2, r5);
        SlideDrawable r8 = new SlideDrawable(this, this.mDrawerImage);
        this.mSlider = r8;
        if (r4 == false) goto L9;
        float r1 = TOGGLE_DRAWABLE_OFFSET;
    L10:
        r8.setOffset(r1);
        return;
    L9:
        r1 = 0.0f;
        goto L10
    L5:
        r0 = null;
        goto L6
    }

    private static boolean assumeMaterial(Context r1) {
        if (r1.getApplicationInfo().targetSdkVersion >= 21) goto L5;
    L7:
        return false;
    L5:
        if (Build.VERSION.SDK_INT < 21) goto L7;
        return true;
    }

    private Drawable getThemeUpIndicator() {
        Delegate r0 = this.mActivityImpl;
        if (r0 == null) goto L7;
        return r0.getThemeUpIndicator();
    L7:
        if (Build.VERSION.SDK_INT < 18) goto L15;
        ActionBar r1 = this.mActivity.getActionBar();
        if (r1 == null) goto L11;
        Context r4 = r1.getThemedContext();
    L12:
        TypedArray r5 = r4.obtainStyledAttributes(null, THEME_ATTRS, R.attr.actionBarStyle, 0);
    L13:
        Drawable r2 = r5.getDrawable(0);
        r5.recycle();
        return r2;
    L11:
        r4 = this.mActivity;
        goto L12
    L15:
        r5 = this.mActivity.obtainStyledAttributes(THEME_ATTRS);
        goto L13
    }

    private void setActionBarDescription(int r4) {
        Delegate r0 = this.mActivityImpl;
        if (r0 == null) goto L7;
        r0.setActionBarDescription(r4);
        return;
    L7:
        if (Build.VERSION.SDK_INT < 18) goto L12;
        ActionBar r3 = this.mActivity.getActionBar();
        if (r3 == null) goto L23;
        r3.setHomeActionContentDescription(r4);
        return;
    L23:
        return;
    L12:
        if (this.mSetIndicatorInfo != null) goto L15;
        this.mSetIndicatorInfo = new SetIndicatorInfo(this.mActivity);
    L15:
        if (this.mSetIndicatorInfo.mSetHomeAsUpIndicator == null) goto L25;
        ActionBar r1 = this.mActivity.getActionBar();     // Catch: Exception -> L18
        this.mSetIndicatorInfo.mSetHomeActionContentDescription.invoke(r1, new Object[]{Integer.valueOf(r4)});     // Catch: Exception -> L18
        r1.setSubtitle(r1.getSubtitle());     // Catch: Exception -> L18
        return;
    L18:
        e = move-exception;
        Log.w(TAG, "Couldn't set content description via JB-MR2 API", e);
        return;
    }

    private void setActionBarUpIndicator(Drawable r7, int r8) {
        Delegate r0 = this.mActivityImpl;
        if (r0 == null) goto L7;
        r0.setActionBarUpIndicator(r7, r8);
        return;
    L7:
        if (Build.VERSION.SDK_INT < 18) goto L12;
        ActionBar r6 = this.mActivity.getActionBar();
        if (r6 == null) goto L27;
        r6.setHomeAsUpIndicator(r7);
        r6.setHomeActionContentDescription(r8);
        return;
    L27:
        return;
    L12:
        if (this.mSetIndicatorInfo != null) goto L14;
        this.mSetIndicatorInfo = new SetIndicatorInfo(this.mActivity);
    L14:
        SetIndicatorInfo r1 = this.mSetIndicatorInfo;
        if (r1.mSetHomeAsUpIndicator != null) goto L25;
        ImageView r9 = r1.mUpIndicatorView;
        if (r9 == null) goto L23;
        r9.setImageDrawable(r7);
        return;
    L23:
        Log.w(TAG, "Couldn't set home-as-up indicator");
        return;
    L25:
        ActionBar r2 = this.mActivity.getActionBar();     // Catch: Exception -> L18
        this.mSetIndicatorInfo.mSetHomeAsUpIndicator.invoke(r2, new Object[]{r7});     // Catch: Exception -> L18
        this.mSetIndicatorInfo.mSetHomeActionContentDescription.invoke(r2, new Object[]{Integer.valueOf(r8)});     // Catch: Exception -> L18
        return;
    L18:
        e = move-exception;
        Log.w(TAG, "Couldn't set home-as-up indicator via JB-MR2 API", e);
    }

    public boolean isDrawerIndicatorEnabled() {
        return this.mDrawerIndicatorEnabled;
    }

    public void onConfigurationChanged(Configuration r2) {
        if (this.mHasCustomUpIndicator == true) goto L5;
        this.mHomeAsUpIndicator = getThemeUpIndicator();
    L5:
        this.mDrawerImage = ContextCompat.getDrawable(this.mActivity, this.mDrawerImageResource);
        syncState();
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerClosed(View r2) {
        this.mSlider.setPosition(0.0f);
        if (this.mDrawerIndicatorEnabled == false) goto L6;
        setActionBarDescription(this.mOpenDrawerContentDescRes);
        return;
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerOpened(View r2) {
        this.mSlider.setPosition(1.0f);
        if (this.mDrawerIndicatorEnabled == false) goto L6;
        setActionBarDescription(this.mCloseDrawerContentDescRes);
        return;
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerSlide(View r4, float r5) {
        float r6 = this.mSlider.getPosition();
        if (r5 <= 0.5f) goto L5;
        float r7 = Math.max(r6, Math.max(0.0f, r5 - 0.5f) * 2.0f);
    L6:
        this.mSlider.setPosition(r7);
        return;
    L5:
        r7 = Math.min(r6, r5 * 2.0f);
        goto L6
    }

    @Override // androidx.drawerlayout.widget.DrawerLayout.DrawerListener
    public void onDrawerStateChanged(int r1) {
    }

    public boolean onOptionsItemSelected(MenuItem r2) {
        if (r2 != null) goto L4;
        return false;
    L4:
        if (r2.getItemId() == 16908332) goto L6;
        return false;
    L6:
        if (this.mDrawerIndicatorEnabled == false) goto L17;
        boolean r3 = this.mDrawerLayout.isDrawerVisible(GravityCompat.START);
        DrawerLayout r1 = this.mDrawerLayout;
        if (r3 == false) goto L10;
        r1.closeDrawer(GravityCompat.START);
        return true;
    L10:
        r1.openDrawer(GravityCompat.START);
        return true;
    L17:
        return false;
    }

    public void setDrawerIndicatorEnabled(boolean r4) {
        if (r4 == this.mDrawerIndicatorEnabled) goto L12;
        if (r4 == false) goto L9;
        Drawable r0 = this.mSlider;
        if (this.mDrawerLayout.isDrawerOpen(GravityCompat.START) == false) goto L8;
        int r1 = this.mCloseDrawerContentDescRes;
    L10:
        setActionBarUpIndicator(r0, r1);
        this.mDrawerIndicatorEnabled = r4;
        return;
    L8:
        r1 = this.mOpenDrawerContentDescRes;
        goto L10
    L9:
        r0 = this.mHomeAsUpIndicator;
        r1 = 0;
        goto L10
    }

    public void setHomeAsUpIndicator(int r2) {
        if (r2 == 0) goto L4;
        Drawable r3 = ContextCompat.getDrawable(this.mActivity, r2);
    L5:
        setHomeAsUpIndicator(r3);
        return;
    L4:
        r3 = null;
        goto L5
    }

    public void setHomeAsUpIndicator(Drawable r2) {
        if (r2 != null) goto L5;
        this.mHomeAsUpIndicator = getThemeUpIndicator();
        this.mHasCustomUpIndicator = false;
    L7:
        if (this.mDrawerIndicatorEnabled == true) goto L10;
        setActionBarUpIndicator(this.mHomeAsUpIndicator, 0);
        return;
    L10:
        return;
    L5:
        this.mHomeAsUpIndicator = r2;
        this.mHasCustomUpIndicator = true;
        goto L7
    }

    public void syncState() {
        if (this.mDrawerLayout.isDrawerOpen(GravityCompat.START) == false) goto L5;
        SlideDrawable r0 = this.mSlider;
        float r2 = 1.0f;
    L6:
        r0.setPosition(r2);
        if (this.mDrawerIndicatorEnabled == false) goto L14;
        SlideDrawable r1 = this.mSlider;
        if (this.mDrawerLayout.isDrawerOpen(GravityCompat.START) == false) goto L11;
        int r3 = this.mCloseDrawerContentDescRes;
    L12:
        setActionBarUpIndicator(r1, r3);
        return;
    L11:
        r3 = this.mOpenDrawerContentDescRes;
        goto L12
    L14:
        return;
    L5:
        r0 = this.mSlider;
        r2 = 0.0f;
        goto L6
    }
}

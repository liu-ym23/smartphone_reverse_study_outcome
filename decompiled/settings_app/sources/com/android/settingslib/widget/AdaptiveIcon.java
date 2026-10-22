package com.android.settingslib.widget;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import com.GlobalProxyLancet;
import com.android.settingslib.R;
import com.android.settingslib.drawer.Tile;
import com.android.settingslib.drawer.TileUtils;

/* JADX INFO: loaded from: classes.dex */
public class AdaptiveIcon extends LayerDrawable {
    private static final String TAG = "AdaptiveHomepageIcon";
    private AdaptiveConstantState mAdaptiveConstantState;
    int mBackgroundColor;

    static class AdaptiveConstantState extends Drawable.ConstantState {
        int mColor;
        Context mContext;
        Drawable mDrawable;

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        AdaptiveConstantState(Context r1, Drawable r2) {
            this.mContext = r1;
            this.mDrawable = r2;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            AdaptiveIcon r0 = new AdaptiveIcon(this.mContext, this.mDrawable);
            r0.setBackgroundColor(this.mColor);
            return r0;
        }
    }

    public AdaptiveIcon(Context r2, Drawable r3) {
        this(r2, r3, R.dimen.dashboard_tile_foreground_image_inset);
    }

    public AdaptiveIcon(Context r8, Drawable r9, int r10) {
        super(new Drawable[]{new AdaptiveIconShapeDrawable(r8.getResources()), r9});
        this.mBackgroundColor = -1;
        int r6 = r8.getResources().getDimensionPixelSize(r10);
        setLayerInset(1, r6, r6, r6, r6);
        this.mAdaptiveConstantState = new AdaptiveConstantState(r8, r9);
    }

    public void setBackgroundColor(Context r5, Tile r6) {
        Bundle r0 = r6.getMetaData();
        if (r0 != null) goto L15;
    L13:
        setBackgroundColor(r5.getColor(R.color.homepage_generic_icon_background));
        return;
    L15:
        int r1 = r0.getInt(TileUtils.META_DATA_PREFERENCE_ICON_BACKGROUND_ARGB, 0);     // Catch: PackageManager.NameNotFoundException -> L12
        if (r1 != 0) goto L9;
        int r2 = r0.getInt(TileUtils.META_DATA_PREFERENCE_ICON_BACKGROUND_HINT, 0);     // Catch: PackageManager.NameNotFoundException -> L12
        if (r2 == 0) goto L9;
        r1 = r5.getPackageManager().getResourcesForApplication(r6.getPackageName()).getColor(r2, null);     // Catch: PackageManager.NameNotFoundException -> L12
    L9:
        if (r1 == 0) goto L13;
        setBackgroundColor(r1);     // Catch: PackageManager.NameNotFoundException -> L12
        return;
    L12:
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_e(TAG, "Failed to set background color for " + r6.getPackageName());
        goto L13
    }

    public void setBackgroundColor(int r3) {
        this.mBackgroundColor = r3;
        getDrawable(0).setColorFilter(r3, PorterDuff.Mode.SRC_ATOP);
        GlobalProxyLancet.com_obric_hook_lancet_LogLancet_d(TAG, "Setting background color " + this.mBackgroundColor);
        this.mAdaptiveConstantState.mColor = r3;
    }

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.mAdaptiveConstantState;
    }
}

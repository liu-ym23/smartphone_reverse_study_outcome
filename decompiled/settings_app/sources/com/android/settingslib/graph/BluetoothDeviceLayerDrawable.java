package com.android.settingslib.graph;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.core.view.GravityCompat;
import com.android.settingslib.R;
import com.android.settingslib.Utils;

/* JADX INFO: loaded from: classes.dex */
public class BluetoothDeviceLayerDrawable extends LayerDrawable {
    private BluetoothDeviceLayerDrawableState mState;

    static class BatteryMeterDrawable extends BatteryMeterDrawableBase {
        private final float mAspectRatio;
        int mFrameColor;

        @Override // com.android.settingslib.graph.BatteryMeterDrawableBase
        protected float getRadiusRatio() {
            return 0.0f;
        }

        public BatteryMeterDrawable(Context r4, int r5, int r6) {
            super(r4, r5);
            Resources r0 = r4.getResources();
            this.mButtonHeightFraction = r0.getFraction(R.fraction.bt_battery_button_height_fraction, 1, 1);
            this.mAspectRatio = r0.getFraction(R.fraction.bt_battery_ratio_fraction, 1, 1);
            setColorFilter(new PorterDuffColorFilter(Utils.getColorAttrDefaultColor(r4, android.R.attr.colorControlNormal), PorterDuff.Mode.SRC_IN));
            setBatteryLevel(r6);
            this.mFrameColor = r5;
        }

        @Override // com.android.settingslib.graph.BatteryMeterDrawableBase
        protected float getAspectRatio() {
            return this.mAspectRatio;
        }
    }

    private static class BluetoothDeviceLayerDrawableState extends Drawable.ConstantState {
        int batteryLevel;
        Context context;
        float iconScale;
        int resId;

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        public BluetoothDeviceLayerDrawableState(Context r1, int r2, int r3, float r4) {
            this.context = r1;
            this.resId = r2;
            this.batteryLevel = r3;
            this.iconScale = r4;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return BluetoothDeviceLayerDrawable.createLayerDrawable(this.context, this.resId, this.batteryLevel, this.iconScale);
        }
    }

    private BluetoothDeviceLayerDrawable(Drawable[] r1) {
        super(r1);
    }

    public static BluetoothDeviceLayerDrawable createLayerDrawable(Context r1, int r2, int r3) {
        return createLayerDrawable(r1, r2, r3, 1.0f);
    }

    public static BluetoothDeviceLayerDrawable createLayerDrawable(Context r6, int r7, int r8, float r9) {
        Drawable r0 = r6.getDrawable(r7);
        BatteryMeterDrawable r1 = new BatteryMeterDrawable(r6, r6.getColor(R.color.meter_background_color), r8);
        int r2 = r6.getResources().getDimensionPixelSize(R.dimen.bt_battery_padding);
        r1.setPadding(r2, r2, r2, r2);
        BluetoothDeviceLayerDrawable r3 = new BluetoothDeviceLayerDrawable(new Drawable[]{r0, r1});
        r3.setLayerGravity(0, GravityCompat.START);
        r3.setLayerInsetStart(1, r0.getIntrinsicWidth());
        r3.setLayerInsetTop(1, (int) (r0.getIntrinsicHeight() * (1.0f - r9)));
        r3.setConstantState(r6, r7, r8, r9);
        return r3;
    }

    public void setConstantState(Context r2, int r3, int r4, float r5) {
        this.mState = new BluetoothDeviceLayerDrawableState(r2, r3, r4, r5);
    }

    @Override // android.graphics.drawable.LayerDrawable, android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.mState;
    }
}

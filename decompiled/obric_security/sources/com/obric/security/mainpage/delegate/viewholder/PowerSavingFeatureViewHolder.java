package com.obric.security.mainpage.delegate.viewholder;

import android.os.PowerManager;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedanceos.powerusage.PowerSaveModeActivity;
import com.bytedanceos.security.widget.SecurityItemText2;
import com.obric.security.R;
import com.obric.security.mainpage.delegate.data.PowerSavingData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PowerSavingFeatureViewHolder.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\nJ\u0006\u0010\u000e\u001a\u00020\nR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/security/mainpage/delegate/viewholder/PowerSavingFeatureViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "mPowerLowView", "Lcom/bytedanceos/security/widget/SecurityItemText2;", "mPowerManager", "Landroid/os/PowerManager;", "onBind", "", "appInfo", "Lcom/obric/security/mainpage/delegate/data/PowerSavingData;", "onViewAttachedToWindow", "onViewDetachedFromWindow", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class PowerSavingFeatureViewHolder extends RecyclerView.ViewHolder {
    private SecurityItemText2 mPowerLowView;
    private PowerManager mPowerManager;

    public final void onViewAttachedToWindow() {
    }

    public final void onViewDetachedFromWindow() {
    }

    public PowerSavingFeatureViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
    }

    public static final /* synthetic */ PowerManager access$getMPowerManager$p(PowerSavingFeatureViewHolder r0) {
        return r0.mPowerManager;
    }

    public static final /* synthetic */ void access$setMPowerManager$p(PowerSavingFeatureViewHolder r0, PowerManager r1) {
        r0.mPowerManager = r1;
    }

    public final void onBind(PowerSavingData r4) {
        Intrinsics.checkNotNullParameter(r4, "appInfo");
        View r5 = this.itemView;
        Intrinsics.checkNotNullExpressionValue(r5, "itemView");
        Object r6 = r5.getContext().getSystemService(BatteryTypeInf.BATTERY_POWER_LOCK);
        if (r6 == null) goto L22;
        this.mPowerManager = (PowerManager) r6;
        View r7 = this.itemView.findViewById(R.id.battery_status_low);
        if (r7 == null) goto L20;
        SecurityItemText2 r8 = (SecurityItemText2) r7;
        this.mPowerLowView = r8;
        if (r8 == null) goto L9;
        r8.setRightLayout(3);
    L9:
        SecurityItemText2 r9 = this.mPowerLowView;
        if (r9 == null) goto L12;
        View r1 = this.itemView;
        Intrinsics.checkNotNullExpressionValue(r1, "itemView");
        r9.setContentImage(r1.getContext().getResources().getDrawable(R.drawable.oic_low_battery));
    L12:
        SecurityItemText2 r10 = this.mPowerLowView;
        if (r10 == null) goto L15;
        r10.setOnCheckedChangeListener(new AnonymousClass1(this));
    L15:
        SecurityItemText2 r11 = this.mPowerLowView;
        if (r11 == null) goto L23;
        View r3 = this.itemView;
        Intrinsics.checkNotNullExpressionValue(r3, "itemView");
        r11.setChecked(PowerSaveModeActivity.isLowBatteryMode(r3.getContext()));
        return;
    L23:
        return;
    L20:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedanceos.security.widget.SecurityItemText2");
    L22:
        throw new NullPointerException("null cannot be cast to non-null type android.os.PowerManager");
    }
}

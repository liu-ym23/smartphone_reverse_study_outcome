package com.obric.security.mainpage.delegate.viewholder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.android.calendar.privacy.GrantUtil;
import com.bytedanceos.appmanager.ApplicationManagerActivity;
import com.bytedanceos.cleaner.CleanerActivity;
import com.bytedanceos.clearmemory.ManagerApplicationsRunningActivity;
import com.bytedanceos.datausage.DataUsageActivity;
import com.bytedanceos.powerusage.BatteryEntry;
import com.bytedanceos.preventdisturb.DisturbActivity;
import com.bytedanceos.storage.StorageActivity;
import com.obric.common.oea.style.scene.transition.TransitionAnimHelper;
import com.obric.common.oea.style.scene.transition.TransitionAnimStyle;
import com.obric.security.R;
import com.obric.security.battertpower.BatteryPowerActivity;
import com.obric.security.mainpage.delegate.data.KeyFeatureData;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: KeyFeatureViewHolder.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0012\u0010\n\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/security/mainpage/delegate/viewholder/KeyFeatureViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "onBind", "", "appInfo", "Lcom/obric/security/mainpage/delegate/data/KeyFeatureData;", "onClick", BaseSwitches.V, "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class KeyFeatureViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private final View itemView;

    public KeyFeatureViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.itemView = r2;
    }

    public final void onBind(KeyFeatureData r2) {
        Intrinsics.checkNotNullParameter(r2, "appInfo");
        View r3 = this.itemView.findViewById(R.id.junk_files_cleanup);
        if (r3 == null) goto L5;
        r3.setOnClickListener(this);
    L5:
        View r4 = this.itemView.findViewById(R.id.memory_completely_cleanup);
        if (r4 == null) goto L8;
        r4.setOnClickListener(this);
    L8:
        View r5 = this.itemView.findViewById(R.id.battery_optimization);
        if (r5 == null) goto L11;
        r5.setOnClickListener(this);
    L11:
        View r6 = this.itemView.findViewById(R.id.application_manager);
        if (r6 == null) goto L14;
        r6.setOnClickListener(this);
    L14:
        View r7 = this.itemView.findViewById(R.id.item_storage);
        if (r7 == null) goto L17;
        r7.setOnClickListener(this);
    L17:
        View r8 = this.itemView.findViewById(R.id.prevent_disturb);
        if (r8 == null) goto L20;
        r8.setOnClickListener(this);
    L20:
        View r9 = this.itemView.findViewById(R.id.item_data_usage);
        if (r9 == null) goto L23;
        r9.setOnClickListener(this);
    L23:
        View r10 = this.itemView.findViewById(R.id.item_advanced);
        if (r10 == null) goto L27;
        r10.setOnClickListener(this);
        return;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r6) {
        if (r6 != null) goto L5;
        return;
    L5:
        switch(r6.getId()) {
            case 2131296447: goto L42;
            case 2131296498: goto L37;
            case 2131297152: goto L32;
            case 2131297157: goto L27;
            case 2131297168: goto L22;
            case 2131297223: goto L17;
            case 2131297344: goto L12;
            case 2131297669: goto L7;
            default: goto L47;
        };
    L7:
        Intent r5 = new Intent(r6.getContext(), DisturbActivity.class);
        r5.putExtra("from", GrantUtil.securitymanager);
        Context r0 = r6.getContext();
        if (r0 == null) goto L11;
        ((Activity) r0).startActivity(r5);
        goto L47
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L12:
        Intent r7 = new Intent(r6.getContext(), ManagerApplicationsRunningActivity.class);
        r7.putExtra("from", GrantUtil.securitymanager);
        Context r1 = r6.getContext();
        if (r1 == null) goto L16;
        ((Activity) r1).startActivityForResult(r7, 1002);
        goto L47
    L16:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L17:
        Intent r8 = new Intent(r6.getContext(), CleanerActivity.class);
        r8.putExtra("from", GrantUtil.securitymanager);
        Context r2 = r6.getContext();
        if (r2 == null) goto L21;
        ((Activity) r2).startActivityForResult(r8, 1001);
        goto L47
    L21:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L22:
        Intent r9 = new Intent(r6.getContext(), StorageActivity.class);
        Context r3 = r6.getContext();
        if (r3 == null) goto L26;
        ((Activity) r3).startActivity(r9);
        goto L47
    L26:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L27:
        Intent r10 = new Intent(r6.getContext(), DataUsageActivity.class);
        Context r4 = r6.getContext();
        if (r4 == null) goto L31;
        ((Activity) r4).startActivity(r10);
        goto L47
    L31:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L32:
        Intent r11 = new Intent();
        r11.setClassName(BatteryEntry.SETTING_PACKAGE, "com.android.settings.SecuritySettingsActivity");
        Context r12 = r6.getContext();
        if (r12 == null) goto L36;
        ((Activity) r12).startActivity(r11);
        goto L47
    L36:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L37:
        Intent r13 = new Intent(r6.getContext(), BatteryPowerActivity.class);
        r13.putExtra("from", GrantUtil.securitymanager);
        Context r14 = r6.getContext();
        if (r14 == null) goto L41;
        ((Activity) r14).startActivity(r13);
        goto L47
    L41:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L42:
        Intent r15 = new Intent(r6.getContext(), ApplicationManagerActivity.class);
        Context r16 = r6.getContext();
        if (r16 == null) goto L46;
        ((Activity) r16).startActivity(r15);
        goto L47
    L46:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L47:
        Context r17 = r6.getContext();
        if (r17 == null) goto L52;
        TransitionAnimHelper.overrideEnterAnim((Activity) r17, TransitionAnimStyle.SubpageInOut);
        return;
    L52:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    }
}

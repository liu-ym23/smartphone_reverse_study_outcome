package com.obric.security.mainpage.delegate.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedanceos.security.widget.SecurityItemTextNeutral;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.security.R;
import com.obric.security.battertpower.AppPowerProfileData;
import com.obric.security.battertpower.BatteryPowerActivityViewModel;
import com.obric.security.battertpower.PercentAdapter;
import com.obric.security.mainpage.MainViewModel;
import com.obric.security.mainpage.delegate.data.PowerRankFeatureData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PowerRankFeatureViewHolder.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u0017H\u0007J\b\u0010\u001b\u001a\u00020\u0017H\u0007J\b\u0010\u001c\u001a\u00020\u0017H\u0007J\u0006\u0010\u001d\u001a\u00020\u0017J\u0006\u0010\u001e\u001a\u00020\u0017R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/obric/security/mainpage/delegate/viewholder/PowerRankFeatureViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroidx/lifecycle/LifecycleObserver;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "adapter", "Lcom/obric/security/battertpower/PercentAdapter;", "batteryPowerViewModel", "Lcom/obric/security/battertpower/BatteryPowerActivityViewModel;", "mainViewModel", "Lcom/obric/security/mainpage/MainViewModel;", "observer", "Landroidx/lifecycle/Observer;", "", "Lcom/obric/security/battertpower/AppPowerProfileData;", "powerRankHead", "Lcom/bytedanceos/security/widget/SecurityItemTextNeutral;", "powerRankRoot", "Landroid/widget/LinearLayout;", "recyclerView", "Lcom/obric/oui/orecyclerview/widget/RecyclerView;", "onBind", "", "appInfo", "Lcom/obric/security/mainpage/delegate/data/PowerRankFeatureData;", "onDestory", "onPause", "onResume", "onViewAttachedToWindow", "onViewDetachedFromWindow", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class PowerRankFeatureViewHolder extends RecyclerView.ViewHolder implements LifecycleObserver {
    private PercentAdapter adapter;
    private BatteryPowerActivityViewModel batteryPowerViewModel;
    private MainViewModel mainViewModel;
    private Observer<List<AppPowerProfileData>> observer;
    private SecurityItemTextNeutral powerRankHead;
    private LinearLayout powerRankRoot;
    private com.obric.oui.orecyclerview.widget.RecyclerView recyclerView;

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestory() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
    }

    public PowerRankFeatureViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.observer = new PowerRankFeatureViewHolder$observer$1(this);
    }

    public static final /* synthetic */ PercentAdapter access$getAdapter$p(PowerRankFeatureViewHolder r0) {
        return r0.adapter;
    }

    public static final /* synthetic */ LinearLayout access$getPowerRankRoot$p(PowerRankFeatureViewHolder r0) {
        return r0.powerRankRoot;
    }

    public static final /* synthetic */ void access$setAdapter$p(PowerRankFeatureViewHolder r0, PercentAdapter r1) {
        r0.adapter = r1;
    }

    public static final /* synthetic */ void access$setPowerRankRoot$p(PowerRankFeatureViewHolder r0, LinearLayout r1) {
        r0.powerRankRoot = r1;
    }

    public final void onBind(PowerRankFeatureData r5) {
        Intrinsics.checkNotNullParameter(r5, "appInfo");
        this.adapter = new PercentAdapter();
        this.powerRankRoot = (LinearLayout) this.itemView.findViewById(R.id.power_rank_root);
        SecurityItemTextNeutral r6 = (SecurityItemTextNeutral) this.itemView.findViewById(R.id.power_rank_head_item);
        this.powerRankHead = r6;
        if (r6 == null) goto L5;
        View r2 = this.itemView;
        Intrinsics.checkNotNullExpressionValue(r2, "itemView");
        Context r3 = r2.getContext();
        Intrinsics.checkNotNullExpressionValue(r3, "itemView.context");
        r6.setTitleString(r3.getResources().getString(R.string.power_rank2));
    L5:
        SecurityItemTextNeutral r7 = this.powerRankHead;
        if (r7 == null) goto L8;
        View r4 = this.itemView;
        Intrinsics.checkNotNullExpressionValue(r4, "itemView");
        Context r8 = r4.getContext();
        Intrinsics.checkNotNullExpressionValue(r8, "itemView.context");
        r7.setBtnText(r8.getResources().getString(R.string.see));
    L8:
        SecurityItemTextNeutral r9 = this.powerRankHead;
        if (r9 == null) goto L11;
        r9.setBtnClickListener(new AnonymousClass1(this));
    L11:
        SecurityItemTextNeutral r10 = this.powerRankHead;
        if (r10 == null) goto L14;
        View r0 = this.itemView;
        Intrinsics.checkNotNullExpressionValue(r0, "itemView");
        r10.setContentImage(AppCompatResources.getDrawable(r0.getContext(), R.drawable.power_rank));
    L14:
        com.obric.oui.orecyclerview.widget.RecyclerView r11 = (com.obric.oui.orecyclerview.widget.RecyclerView) this.itemView.findViewById(R.id.recyclerView);
        this.recyclerView = r11;
        if (r11 == null) goto L17;
        View r12 = this.itemView;
        Intrinsics.checkNotNullExpressionValue(r12, "itemView");
        r11.setLayoutManager(new LinearLayoutManager(r12.getContext()));
    L17:
        com.obric.oui.orecyclerview.widget.RecyclerView r13 = this.recyclerView;
        if (r13 == null) goto L20;
        r13.setAdapter(this.adapter);
    L20:
        com.obric.oui.orecyclerview.widget.RecyclerView r14 = this.recyclerView;
        if (r14 == null) goto L23;
        com.obric.oui.orecyclerview.widget.RecyclerView.ItemAnimator r15 = (com.obric.oui.orecyclerview.widget.RecyclerView.ItemAnimator) null;
        r14.setItemAnimator(null);
    L23:
        MainViewModel.Companion r16 = MainViewModel.Companion;
        View r1 = this.itemView;
        Intrinsics.checkNotNullExpressionValue(r1, "itemView");
        this.mainViewModel = r16.getMainViewModel(r1.getContext());
        MainViewModel.Companion r17 = MainViewModel.Companion;
        View r18 = this.itemView;
        Intrinsics.checkNotNullExpressionValue(r18, "itemView");
        this.batteryPowerViewModel = r17.getBatteryPowerViewModel(r18.getContext());
    }

    public final void onViewAttachedToWindow() {
        BatteryPowerActivityViewModel r0 = this.batteryPowerViewModel;
        if (r0 == null) goto L11;
        MutableLiveData<List<AppPowerProfileData>> r1 = r0.getAppPowerProfileData();
        if (r1 == null) goto L11;
        View r2 = this.itemView;
        Intrinsics.checkNotNullExpressionValue(r2, "itemView");
        Context r3 = r2.getContext();
        if (r3 == null) goto L10;
        r1.observe((FragmentActivity) r3, this.observer);
        goto L11
    L10:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L11:
        View r4 = this.itemView;
        Intrinsics.checkNotNullExpressionValue(r4, "itemView");
        Context r5 = r4.getContext();
        if ((r5 instanceof FragmentActivity) == true) goto L14;
        r5 = null;
    L14:
        FragmentActivity r6 = (FragmentActivity) r5;
        if (r6 == null) goto L20;
        Lifecycle r7 = r6.getLifecycle();
        if (r7 == null) goto L21;
        r7.addObserver(this);
        return;
    L21:
        return;
    }

    public final void onViewDetachedFromWindow() {
        BatteryPowerActivityViewModel r0 = this.batteryPowerViewModel;
        if (r0 == null) goto L7;
        MutableLiveData<List<AppPowerProfileData>> r1 = r0.getAppPowerProfileData();
        if (r1 == null) goto L7;
        r1.removeObserver(this.observer);
    L7:
        View r2 = this.itemView;
        Intrinsics.checkNotNullExpressionValue(r2, "itemView");
        Context r3 = r2.getContext();
        if ((r3 instanceof FragmentActivity) == true) goto L10;
        r3 = null;
    L10:
        FragmentActivity r4 = (FragmentActivity) r3;
        if (r4 == null) goto L16;
        Lifecycle r5 = r4.getLifecycle();
        if (r5 == null) goto L17;
        r5.removeObserver(this);
        return;
    L17:
        return;
    }
}

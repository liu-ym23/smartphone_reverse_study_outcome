package com.obric.security.mainpage.delegate.viewholder;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.obric.security.R;
import com.obric.security.mainpage.MainViewModel;
import com.obric.security.mainpage.delegate.data.OtaFeatureData;
import com.obric.security.mainpage.view.OTAUpdateView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OtaFeatureViewHolder.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0011\u001a\u00020\u000eH\u0007J\b\u0010\u0012\u001a\u00020\u000eH\u0007J\b\u0010\u0013\u001a\u00020\u000eH\u0007J\u0006\u0010\u0014\u001a\u00020\u000eJ\u0006\u0010\u0015\u001a\u00020\u000eR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/obric/security/mainpage/delegate/viewholder/OtaFeatureViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroidx/lifecycle/LifecycleObserver;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "agreeGrantObserver", "Landroidx/lifecycle/Observer;", "", "mainViewModel", "Lcom/obric/security/mainpage/MainViewModel;", "oTAUpdateView", "Lcom/obric/security/mainpage/view/OTAUpdateView;", "onBind", "", "appInfo", "Lcom/obric/security/mainpage/delegate/data/OtaFeatureData;", "onDestory", "onPause", "onResume", "onViewAttachedToWindow", "onViewDetachedFromWindow", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class OtaFeatureViewHolder extends RecyclerView.ViewHolder implements LifecycleObserver {
    private Observer<Boolean> agreeGrantObserver;
    private final View itemView;
    private MainViewModel mainViewModel;
    private OTAUpdateView oTAUpdateView;

    public OtaFeatureViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.itemView = r2;
        this.agreeGrantObserver = new OtaFeatureViewHolder$agreeGrantObserver$1(this);
    }

    public static final /* synthetic */ OTAUpdateView access$getOTAUpdateView$p(OtaFeatureViewHolder r0) {
        return r0.oTAUpdateView;
    }

    public static final /* synthetic */ void access$setOTAUpdateView$p(OtaFeatureViewHolder r0, OTAUpdateView r1) {
        r0.oTAUpdateView = r1;
    }

    public final void onBind(OtaFeatureData r3) {
        Intrinsics.checkNotNullParameter(r3, "appInfo");
        View r4 = this.itemView.findViewById(R.id.ota_update);
        if (r4 == null) goto L7;
        this.oTAUpdateView = (OTAUpdateView) r4;
        MainViewModel.Companion r5 = MainViewModel.Companion;
        View r0 = this.itemView;
        Intrinsics.checkNotNullExpressionValue(r0, "itemView");
        this.mainViewModel = r5.getMainViewModel(r0.getContext());
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.security.mainpage.view.OTAUpdateView");
    }

    public final void onViewAttachedToWindow() {
        MainViewModel r0 = this.mainViewModel;
        if (r0 == null) goto L11;
        MutableLiveData<Boolean> r1 = r0.getAgreeGrant();
        if (r1 == null) goto L11;
        View r2 = this.itemView;
        Intrinsics.checkNotNullExpressionValue(r2, "itemView");
        Context r3 = r2.getContext();
        if (r3 == null) goto L10;
        r1.observe((FragmentActivity) r3, this.agreeGrantObserver);
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
        MainViewModel r0 = this.mainViewModel;
        if (r0 == null) goto L7;
        MutableLiveData<Boolean> r1 = r0.getAgreeGrant();
        if (r1 == null) goto L7;
        r1.removeObserver(this.agreeGrantObserver);
    L7:
        View r2 = this.itemView;
        Intrinsics.checkNotNullExpressionValue(r2, "itemView");
        Context r3 = r2.getContext();
        if ((r3 instanceof FragmentActivity) == true) goto L10;
        r3 = null;
    L10:
        FragmentActivity r4 = (FragmentActivity) r3;
        if (r4 == null) goto L15;
        Lifecycle r5 = r4.getLifecycle();
        if (r5 == null) goto L15;
        r5.removeObserver(this);
    L15:
        OTAUpdateView r6 = this.oTAUpdateView;
        if (r6 == null) goto L19;
        r6.doDestory();
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        OTAUpdateView r0 = this.oTAUpdateView;
        if (r0 == null) goto L6;
        r0.doResume();
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        OTAUpdateView r0 = this.oTAUpdateView;
        if (r0 == null) goto L6;
        r0.doPause();
        return;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestory() {
        OTAUpdateView r0 = this.oTAUpdateView;
        if (r0 == null) goto L6;
        r0.doDestory();
        return;
    }
}

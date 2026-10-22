package com.tt.skin.sdk.android;

import android.graphics.Paint;
import androidx.lifecycle.LifecycleOwner;
import com.android.launcher3.icons.cache.BaseIconCache;
import com.tt.skin.sdk.SkinManagerAdapter;
import com.tt.skin.sdk.api.ISkinChangeListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SkinPaint.kt */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0007\b\u0016¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016J\u0012\u0010\u0010\u001a\u00020\n2\b\b\u0001\u0010\u0011\u001a\u00020\u0006H\u0016J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/tt/skin/sdk/android/SkinPaint;", "Landroid/graphics/Paint;", "Lcom/tt/skin/sdk/api/ISkinChangeListener;", "Lcom/tt/skin/sdk/android/ISkinPaint;", "()V", BaseIconCache.IconDB.COLUMN_FLAGS, "", "(I)V", "curColorRes", "destroy", "", "onSkinChanged", "isDefaultTheme", "", "onSkinPreChange", "setAppChangeListener", "setColorRes", "colorRes", "setLifecyclerOnwer", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "api_release"}, k = 1, mv = {1, 1, 15})
public final class SkinPaint extends Paint implements ISkinChangeListener, ISkinPaint {
    private int curColorRes;

    @Override // com.tt.skin.sdk.api.ISkinChangeListener
    public void onSkinPreChange() {
    }

    public SkinPaint() {
    }

    public SkinPaint(int r1) {
        super(r1);
    }

    @Override // com.tt.skin.sdk.android.ISkinPaint
    public void setLifecyclerOnwer(LifecycleOwner r2) {
        Intrinsics.checkParameterIsNotNull(r2, "lifecycleOwner");
        SkinManagerAdapter.INSTANCE.addLifeCycleSkinChangeListener(r2, this);
    }

    @Override // com.tt.skin.sdk.android.ISkinPaint
    public void destroy() {
        SkinManagerAdapter.INSTANCE.removeSkinChangeListener(this);
    }

    @Override // com.tt.skin.sdk.android.ISkinPaint
    public void setAppChangeListener() {
        SkinManagerAdapter.INSTANCE.addSkinChangeListener(this);
    }

    @Override // com.tt.skin.sdk.android.ISkinPaint
    public void setColorRes(int r2) {
        this.curColorRes = r2;
        setColor(SkinManagerAdapter.INSTANCE.refreshNewColor(r2));
    }

    @Override // com.tt.skin.sdk.api.ISkinChangeListener
    public void onSkinChanged(boolean r1) {
        int r2 = this.curColorRes;
        if (r2 == 0) goto L6;
        setColorRes(r2);
        return;
    }
}

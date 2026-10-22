package com.tt.skin.sdk.android;

import android.graphics.Paint;
import androidx.annotation.ColorRes;
import androidx.lifecycle.LifecycleOwner;
import com.tt.skin.sdk.SkinManagerAdapter;
import com.tt.skin.sdk.api.ISkinChangeListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class SkinPaint extends Paint implements ISkinChangeListener, ISkinPaint {
    private int curColorRes;

    public SkinPaint() {
    }

    @Override // com.tt.skin.sdk.android.ISkinPaint
    public void destroy() {
        SkinManagerAdapter.INSTANCE.removeSkinChangeListener(this);
    }

    @Override // com.tt.skin.sdk.api.ISkinChangeListener
    public void onSkinChanged(boolean r1) {
        int r2 = this.curColorRes;
        if (r2 == 0) goto L6;
        setColorRes(r2);
        return;
    }

    @Override // com.tt.skin.sdk.api.ISkinChangeListener
    public void onSkinPreChange() {
    }

    @Override // com.tt.skin.sdk.android.ISkinPaint
    public void setAppChangeListener() {
        SkinManagerAdapter.INSTANCE.addSkinChangeListener(this);
    }

    @Override // com.tt.skin.sdk.android.ISkinPaint
    public void setColorRes(@ColorRes int r2) {
        this.curColorRes = r2;
        setColor(SkinManagerAdapter.INSTANCE.refreshNewColor(r2));
    }

    @Override // com.tt.skin.sdk.android.ISkinPaint
    public void setLifecyclerOnwer(@NotNull LifecycleOwner r2) {
        Intrinsics.g(r2, "lifecycleOwner");
        SkinManagerAdapter.INSTANCE.addLifeCycleSkinChangeListener(r2, this);
    }

    public SkinPaint(int r1) {
        super(r1);
    }
}

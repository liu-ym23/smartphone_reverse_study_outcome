package com.obric.oui.orecyclerview.base;

import android.view.MotionEvent;
import com.bytedance.apm.constant.SlardarConfigConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SystemVelocityTrackerAdapter.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\rH\u0016J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\rH\u0016R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/oui/orecyclerview/base/SystemVelocityTrackerAdapter;", "Lcom/obric/oui/orecyclerview/base/VelocityTracker;", "()V", "velocityTracker", "Landroid/view/VelocityTracker;", "kotlin.jvm.PlatformType", "addMovement", "", "event", "Landroid/view/MotionEvent;", "clear", "computeCurrentVelocity", "units", "", "maxVelocity", "", "getXVelocity", SlardarConfigConsts.CONFIG_ID, "getYVelocity", "OUIRecyclerView_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SystemVelocityTrackerAdapter implements VelocityTracker {
    private final android.view.VelocityTracker velocityTracker;

    public SystemVelocityTrackerAdapter() {
        this.velocityTracker = android.view.VelocityTracker.obtain();
    }

    @Override // com.obric.oui.orecyclerview.base.VelocityTracker
    public void addMovement(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        this.velocityTracker.addMovement(r2);
    }

    @Override // com.obric.oui.orecyclerview.base.VelocityTracker
    public void clear() {
        this.velocityTracker.clear();
    }

    @Override // com.obric.oui.orecyclerview.base.VelocityTracker
    public void computeCurrentVelocity(int r1, float r2) {
        this.velocityTracker.computeCurrentVelocity(r1, r2);
    }

    @Override // com.obric.oui.orecyclerview.base.VelocityTracker
    public float getXVelocity(int r1) {
        return this.velocityTracker.getXVelocity(r1);
    }

    @Override // com.obric.oui.orecyclerview.base.VelocityTracker
    public float getYVelocity(int r1) {
        return this.velocityTracker.getYVelocity(r1);
    }
}

package androidx.work.impl.constraints.controllers;

import androidx.exifinterface.media.ExifInterface;
import androidx.work.impl.constraints.ConstraintListener;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConstraintController.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001c\n\u0002\b\u0005\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001%B\u0015\b\u0000\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0013H&J\u0015\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0018J\u000e\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0011J\u0015\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001eJ\u0014\u0010\u001f\u001a\u00020\u001c2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00130!J\u0006\u0010\"\u001a\u00020\u001cJ!\u0010#\u001a\u00020\u001c2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00018\u0000H\u0002¢\u0006\u0002\u0010$R(\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0012\u0010\r\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Landroidx/work/impl/constraints/controllers/ConstraintController;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/work/impl/constraints/ConstraintListener;", "tracker", "Landroidx/work/impl/constraints/trackers/ConstraintTracker;", "(Landroidx/work/impl/constraints/trackers/ConstraintTracker;)V", "value", "Landroidx/work/impl/constraints/controllers/ConstraintController$OnConstraintUpdatedCallback;", "callback", "getCallback", "()Landroidx/work/impl/constraints/controllers/ConstraintController$OnConstraintUpdatedCallback;", "setCallback", "(Landroidx/work/impl/constraints/controllers/ConstraintController$OnConstraintUpdatedCallback;)V", "currentValue", "Ljava/lang/Object;", "matchingWorkSpecIds", "", "", "matchingWorkSpecs", "Landroidx/work/impl/model/WorkSpec;", "hasConstraint", "", "workSpec", "isConstrained", "(Ljava/lang/Object;)Z", "isWorkSpecConstrained", "workSpecId", "onConstraintChanged", "", "newValue", "(Ljava/lang/Object;)V", "replace", "workSpecs", "", "reset", "updateCallback", "(Landroidx/work/impl/constraints/controllers/ConstraintController$OnConstraintUpdatedCallback;Ljava/lang/Object;)V", "OnConstraintUpdatedCallback", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class ConstraintController<T> implements ConstraintListener<T> {
    private OnConstraintUpdatedCallback callback;
    private T currentValue;
    private final List<String> matchingWorkSpecIds;
    private final List<WorkSpec> matchingWorkSpecs;
    private final ConstraintTracker<T> tracker;

    /* JADX INFO: compiled from: ConstraintController.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0016\u0010\u0007\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¨\u0006\b"}, d2 = {"Landroidx/work/impl/constraints/controllers/ConstraintController$OnConstraintUpdatedCallback;", "", "onConstraintMet", "", "workSpecs", "", "Landroidx/work/impl/model/WorkSpec;", "onConstraintNotMet", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface OnConstraintUpdatedCallback {
        void onConstraintMet(List<WorkSpec> r1);

        void onConstraintNotMet(List<WorkSpec> r1);
    }

    public abstract boolean hasConstraint(WorkSpec r1);

    public abstract boolean isConstrained(T r1);

    public ConstraintController(ConstraintTracker<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "tracker");
        this.tracker = r2;
        this.matchingWorkSpecs = new ArrayList();
        this.matchingWorkSpecIds = new ArrayList();
    }

    public final OnConstraintUpdatedCallback getCallback() {
        return this.callback;
    }

    public final void setCallback(OnConstraintUpdatedCallback r2) {
        if (this.callback == r2) goto L6;
        this.callback = r2;
        updateCallback(r2, this.currentValue);
        return;
    }

    public final void replace(Iterable<WorkSpec> r4) {
        Intrinsics.checkNotNullParameter(r4, "workSpecs");
        this.matchingWorkSpecs.clear();
        this.matchingWorkSpecIds.clear();
        List<WorkSpec> r0 = this.matchingWorkSpecs;
        Iterator<WorkSpec> r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        WorkSpec r1 = r5.next();
        if (hasConstraint(r1) == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        List<WorkSpec> r6 = this.matchingWorkSpecs;
        List<String> r2 = this.matchingWorkSpecIds;
        Iterator<T> r7 = r6.iterator();
    L10:
        if (r7.hasNext() == false) goto L13;
        r2.add(((WorkSpec) r7.next()).id);
        goto L10
    L13:
        if (this.matchingWorkSpecs.isEmpty() == false) goto L15;
        this.tracker.removeListener(this);
    L16:
        updateCallback(this.callback, this.currentValue);
        return;
    L15:
        this.tracker.addListener(this);
        goto L16
    }

    public final void reset() {
        if ((!this.matchingWorkSpecs.isEmpty()) == false) goto L6;
        this.matchingWorkSpecs.clear();
        this.tracker.removeListener(this);
        return;
    }

    public final boolean isWorkSpecConstrained(String r2) {
        Intrinsics.checkNotNullParameter(r2, "workSpecId");
        T r0 = this.currentValue;
        if (r0 != null) goto L5;
    L9:
        return false;
    L5:
        if (isConstrained(r0) == false) goto L9;
        if (this.matchingWorkSpecIds.contains(r2) == false) goto L9;
        return true;
    }

    private final void updateCallback(OnConstraintUpdatedCallback r2, T r3) {
        if (this.matchingWorkSpecs.isEmpty() == true) goto L13;
        if (r2 == null) goto L15;
        if (r3 != null) goto L8;
    L11:
        r2.onConstraintNotMet(this.matchingWorkSpecs);
        return;
    L8:
        if (isConstrained(r3) == true) goto L11;
        r2.onConstraintMet(this.matchingWorkSpecs);
        return;
    L15:
        return;
    }

    @Override // androidx.work.impl.constraints.ConstraintListener
    public void onConstraintChanged(T r2) {
        this.currentValue = r2;
        updateCallback(this.callback, r2);
    }
}

package androidx.customview.poolingcontainer;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.ViewGroupKt;
import androidx.core.view.ViewKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PoolingContainer.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u000f\u001a\u00020\u0010*\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0007\u001a\n\u0010\u0013\u001a\u00020\u0010*\u00020\u0006\u001a\n\u0010\u0014\u001a\u00020\u0010*\u00020\u0015\u001a\u0014\u0010\u0016\u001a\u00020\u0010*\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"(\u0010\u0005\u001a\u00020\u0004*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\t\"\u0015\u0010\n\u001a\u00020\u0004*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\n\u0010\u0007\"\u0018\u0010\u000b\u001a\u00020\f*\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"IsPoolingContainerTag", "", "PoolingContainerListenerHolderTag", "value", "", "isPoolingContainer", "Landroid/view/View;", "(Landroid/view/View;)Z", "setPoolingContainer", "(Landroid/view/View;Z)V", "isWithinPoolingContainer", "poolingContainerListenerHolder", "Landroidx/customview/poolingcontainer/PoolingContainerListenerHolder;", "getPoolingContainerListenerHolder", "(Landroid/view/View;)Landroidx/customview/poolingcontainer/PoolingContainerListenerHolder;", "addPoolingContainerListener", "", "listener", "Landroidx/customview/poolingcontainer/PoolingContainerListener;", "callPoolingContainerOnRelease", "callPoolingContainerOnReleaseForChildren", "Landroid/view/ViewGroup;", "removePoolingContainerListener", "customview-poolingcontainer_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class PoolingContainer {
    private static final int IsPoolingContainerTag = 0;
    private static final int PoolingContainerListenerHolderTag = 0;

    public static final void addPoolingContainerListener(View r1, PoolingContainerListener r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "listener");
        getPoolingContainerListenerHolder(r1).addListener(r2);
    }

    public static final void removePoolingContainerListener(View r1, PoolingContainerListener r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "listener");
        getPoolingContainerListenerHolder(r1).removeListener(r2);
    }

    public static final boolean isPoolingContainer(View r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Object r2 = r1.getTag(IsPoolingContainerTag);
        if ((r2 instanceof Boolean) == false) goto L5;
        Boolean r3 = (Boolean) r2;
    L6:
        if (r3 != null) goto L10;
        return false;
    L10:
        return r3.booleanValue();
    L5:
        r3 = null;
        goto L6
    }

    public static final void setPoolingContainer(View r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        r1.setTag(IsPoolingContainerTag, Boolean.valueOf(r2));
    }

    public static final boolean isWithinPoolingContainer(View r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Iterator<ViewParent> r3 = ViewKt.getAncestors(r2).iterator();
    L4:
        if (r3.hasNext() == false) goto L11;
        Object r0 = (ViewParent) r3.next();
        if ((r0 instanceof View) == false) goto L4;
        if (isPoolingContainer((View) r0) == false) goto L4;
        return true;
    L11:
        return false;
    }

    public static final void callPoolingContainerOnRelease(View r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Iterator<View> r2 = ViewKt.getAllViews(r1).iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        getPoolingContainerListenerHolder(r2.next()).onRelease();
        goto L4
    }

    public static final void callPoolingContainerOnReleaseForChildren(ViewGroup r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Iterator<View> r2 = ViewGroupKt.getChildren(r1).iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        getPoolingContainerListenerHolder(r2.next()).onRelease();
        goto L4
    }

    static {
        PoolingContainerListenerHolderTag = R.id.pooling_container_listener_holder_tag;
        IsPoolingContainerTag = R.id.is_pooling_container_tag;
    }

    private static final PoolingContainerListenerHolder getPoolingContainerListenerHolder(View r2) {
        int r0 = PoolingContainerListenerHolderTag;
        PoolingContainerListenerHolder r1 = (PoolingContainerListenerHolder) r2.getTag(r0);
        if (r1 != null) goto L6;
        PoolingContainerListenerHolder r3 = new PoolingContainerListenerHolder();
        r2.setTag(r0, r3);
        return r3;
    L6:
        return r1;
    }
}

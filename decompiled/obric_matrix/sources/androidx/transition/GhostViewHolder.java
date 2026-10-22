package androidx.transition;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"ViewConstructor"})
class GhostViewHolder extends FrameLayout {
    private boolean mAttached;

    @NonNull
    private ViewGroup mParent;

    GhostViewHolder(ViewGroup r2) {
        super(r2.getContext());
        setClipChildren(false);
        this.mParent = r2;
        r2.setTag(R.id.ghost_view_holder, this);
        ViewGroupUtils.getOverlay(this.mParent).add(this);
        this.mAttached = true;
    }

    static GhostViewHolder getHolder(@NonNull ViewGroup r1) {
        return (GhostViewHolder) r1.getTag(R.id.ghost_view_holder);
    }

    private int getInsertIndex(ArrayList<View> r6) {
        ArrayList r0 = new ArrayList();
        int r1 = getChildCount() - 1;
        int r2 = 0;
    L3:
        if (r2 > r1) goto L9;
        int r3 = (r2 + r1) / 2;
        getParents(((GhostViewPort) getChildAt(r3)).mView, r0);
        if (isOnTop(r6, r0) == false) goto L7;
        r2 = r3 + 1;
    L8:
        r0.clear();
        goto L3
    L7:
        r1 = r3 - 1;
        goto L8
    L9:
        return r2;
    }

    private static void getParents(View r2, ArrayList<View> r3) {
        Object r0 = r2.getParent();
        if ((r0 instanceof ViewGroup) == false) goto L5;
        getParents((View) r0, r3);
    L5:
        r3.add(r2);
    }

    private static boolean isOnTop(View r6, View r7) {
        ViewGroup r0 = (ViewGroup) r6.getParent();
        int r1 = r0.getChildCount();
        if (Build.VERSION.SDK_INT >= 21) goto L5;
    L10:
        int r2 = 0;
    L11:
        if (r2 >= r1) goto L19;
        View r5 = r0.getChildAt(ViewGroupUtils.getChildDrawingOrder(r0, r2));
        if (r5 == r6) goto L24;
        if (r5 == r7) goto L19;
        r2 = r2 + 1;
        goto L11
    L24:
        return false;
    L19:
        return true;
    L5:
        if (r6.getZ() == r7.getZ()) goto L10;
        if (r6.getZ() > r7.getZ()) goto L9;
        return false;
    L9:
        return true;
    }

    private static boolean isOnTop(ArrayList<View> r6, ArrayList<View> r7) {
        if (r6.isEmpty() == false) goto L5;
        return true;
    L5:
        if (r7.isEmpty() == false) goto L7;
        return true;
    L7:
        if (r6.get(0) != r7.get(0)) goto L25;
        int r2 = Math.min(r6.size(), r7.size());
        int r3 = 1;
    L10:
        if (r3 >= r2) goto L17;
        View r4 = r6.get(r3);
        View r5 = r7.get(r3);
        if (r4 != r5) goto L14;
        r3 = r3 + 1;
        goto L10
    L14:
        return isOnTop(r4, r5);
    L17:
        if (r7.size() != r2) goto L20;
        return true;
    L20:
        return false;
    L25:
        return true;
    }

    void addGhostView(GhostViewPort r3) {
        ArrayList<View> r0 = new ArrayList();
        getParents(r3.mView, r0);
        int r1 = getInsertIndex(r0);
        if (r1 >= 0) goto L5;
    L8:
        addView(r3);
        return;
    L5:
        if (r1 >= getChildCount()) goto L8;
        addView(r3, r1);
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View r2) {
        if (this.mAttached == false) goto L7;
        super.onViewAdded(r2);
        return;
    L7:
        throw new IllegalStateException("This GhostViewHolder is detached!");
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View r4) {
        super.onViewRemoved(r4);
        if (getChildCount() != 1) goto L7;
        if (getChildAt(0) != r4) goto L7;
    L8:
        this.mParent.setTag(R.id.ghost_view_holder, null);
        ViewGroupUtils.getOverlay(this.mParent).remove(this);
        this.mAttached = false;
        return;
    L7:
        if (getChildCount() == 0) goto L8;
    }

    void popToOverlayTop() {
        if (this.mAttached == false) goto L7;
        ViewGroupUtils.getOverlay(this.mParent).remove(this);
        ViewGroupUtils.getOverlay(this.mParent).add(this);
        return;
    L7:
        throw new IllegalStateException("This GhostViewHolder is detached!");
    }
}

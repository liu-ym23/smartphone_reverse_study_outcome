package android.view;

import android.app.clickviewtree.ClickViewTraceContext;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.autofill.Helper;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class ObricViewGroupImpl implements IObricViewGroup {
    private static final String TAG = "ObricViewGroupImpl";
    private ViewGroup mBase;

    public ObricViewGroupImpl(ViewGroup base) {
        this.mBase = base;
    }

    public void dispatchProvideStructure(ViewStructure structure) {
        if (this.mBase.isAssistBlocked() == false) goto L5;
        return;
    L5:
        if (structure.getChildCount() != 0) goto L88;
        int childrenCount = this.mBase.getChildCount();
        if (childrenCount > 0) goto L11;
        return;
    L11:
        if (this.mBase.isLaidOut() == false) goto L13;
    L18:
        ArrayList<View> tempPreorderedList = this.mBase.buildOrderedChildList();
        if (tempPreorderedList == null) goto L21;
        ArrayList<View> preorderedList = new ArrayList(tempPreorderedList);
    L22:
        boolean r6 = true;
        if (preorderedList == null) goto L25;
    L27:
        boolean customOrder = false;
    L28:
        int childrenCountVisibile = 0;
        int i = 0;
    L29:
        if (i >= childrenCount) goto L36;
        View view = this.mBase.getChildAt(i);
        if (view == null) goto L35;
        if (view.getVisibility() != 0) goto L35;
        childrenCountVisibile = childrenCountVisibile + 1;
    L35:
        i = i + 1;
        goto L29
    L36:
        structure.setChildCount(childrenCountVisibile);
        int i2 = 0;
        int iVisible = 0;
        boolean customOrder2 = customOrder;
        ArrayList<View> preorderedList2 = preorderedList;
    L37:
        if (i2 >= childrenCount) goto L67;
        int childIndex = this.mBase.getAndVerifyPreorderedIndex(childrenCount, i2, customOrder2);     // Catch: IndexOutOfBoundsException -> L40
    L59:
        View child = ViewGroup.getAndVerifyPreorderedView(preorderedList2, this.mBase.mChildren, childIndex);
        if (child.getVisibility() != 0) goto L65;
        if (iVisible >= childrenCountVisibile) goto L67;
        int iVisible2 = iVisible + 1;
        ViewStructure cstructure = structure.newChild(iVisible);
        child.dispatchProvideStructure(cstructure);
        iVisible = iVisible2;
    L65:
        i2 = i2 + 1;
        r6 = true;
    L40:
        e = move-exception;
        int childIndex2 = i2;
        if (this.mBase.mContext.getApplicationInfo().targetSdkVersion >= 23) goto L66;
        Log.w(TAG, "Bad getChildDrawingOrder while collecting assist @ " + i2 + " of " + childrenCount, e);
        customOrder2 = false;
        if (i2 <= 0) goto L58;
        int[] permutation = new int[childrenCount];
        SparseBooleanArray usedIndices = new SparseBooleanArray();
        int j = 0;
    L46:
        if (j >= i2) goto L48;
        permutation[j] = this.mBase.getChildDrawingOrder(childrenCount, j);
        usedIndices.put(permutation[j], r6);
        j = j + 1;
        goto L46
    L48:
        int nextIndex = 0;
        int j2 = i2;
    L49:
        if (j2 >= childrenCount) goto L54;
    L51:
        if (usedIndices.get(nextIndex, false) == false) goto L53;
        nextIndex = nextIndex + 1;
        goto L51
    L53:
        permutation[j2] = nextIndex;
        nextIndex = nextIndex + 1;
        j2 = j2 + 1;
        goto L49
    L54:
        ArrayList<View> preorderedList3 = new ArrayList(childrenCount);
        int j3 = 0;
    L55:
        if (j3 >= childrenCount) goto L57;
        int index = permutation[j3];
        preorderedList3.add(this.mBase.mChildren[index]);
        j3 = j3 + 1;
        goto L55
    L57:
        childIndex = childIndex2;
        preorderedList2 = preorderedList3;
        goto L59
    L58:
        childIndex = childIndex2;
        goto L59
    L66:
        throw e;
    L67:
        if (preorderedList2 == null) goto L87;
        preorderedList2.clear();
        return;
    L87:
        return;
    L25:
        if (this.mBase.isChildrenDrawingOrderEnabled() == false) goto L27;
        customOrder = true;
        goto L28
    L21:
        preorderedList = null;
        goto L22
    L13:
        if (this.mBase.isAttachedToWindow() == true) goto L18;
        if (Helper.sVerbose == false) goto L86;
        Log.v("View", "dispatchProvideStructure(): not laid out, ignoring " + childrenCount + " children of " + this.mBase.getAccessibilityViewId());
        return;
    L86:
        return;
    }

    public void beginTouchDispatch(MotionEvent event) {
        ClickViewTraceContext.onViewGroupDispatchStart(this.mBase, event);     // Catch: Throwable -> L4
        return;
    L4:
        t = move-exception;
        Log.w(TAG, "beginTouchDispatch: click viewtree trace failed", t);
    }

    public void finishTouchDispatch(MotionEvent event, boolean handled) {
        ClickViewTraceContext.onViewGroupDispatchEnd(this.mBase, event, handled);     // Catch: Throwable -> L4
        return;
    L4:
        t = move-exception;
        Log.w(TAG, "finishTouchDispatch: click viewtree trace failed", t);
    }

    public void recordIntercept(MotionEvent event, boolean intercepted) {
        ClickViewTraceContext.onViewGroupIntercept(this.mBase, event, intercepted);     // Catch: Throwable -> L4
        return;
    L4:
        t = move-exception;
        Log.w(TAG, "recordIntercept: click viewtree trace failed", t);
    }

    public void recordChildDispatchResult(View child, MotionEvent event, boolean cancel, boolean handled) {
        ClickViewTraceContext.onViewGroupChildDispatchResult(this.mBase, child, event, cancel, handled);     // Catch: Throwable -> L4
        return;
    L4:
        t = move-exception;
        Log.w(TAG, "recordChildDispatchResult: click viewtree trace failed", t);
    }
}

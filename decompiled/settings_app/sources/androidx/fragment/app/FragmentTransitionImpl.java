package androidx.fragment.app;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.CancellationSignal;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class FragmentTransitionImpl {
    public abstract void addTarget(Object r1, View r2);

    public abstract void addTargets(Object r1, ArrayList<View> r2);

    public abstract void beginDelayedTransition(ViewGroup r1, Object r2);

    public abstract boolean canHandle(Object r1);

    public abstract Object cloneTransition(Object r1);

    public abstract Object mergeTransitionsInSequence(Object r1, Object r2, Object r3);

    public abstract Object mergeTransitionsTogether(Object r1, Object r2, Object r3);

    public abstract void removeTarget(Object r1, View r2);

    public abstract void replaceTargets(Object r1, ArrayList<View> r2, ArrayList<View> r3);

    public abstract void scheduleHideFragmentView(Object r1, View r2, ArrayList<View> r3);

    public abstract void scheduleRemoveTargets(Object r1, Object r2, ArrayList<View> r3, Object r4, ArrayList<View> r5, Object r6, ArrayList<View> r7);

    public abstract void setEpicenter(Object r1, Rect r2);

    public abstract void setEpicenter(Object r1, View r2);

    public abstract void setSharedElementTargets(Object r1, View r2, ArrayList<View> r3);

    public abstract void swapSharedElementTargets(Object r1, ArrayList<View> r2, ArrayList<View> r3);

    public abstract Object wrapTransitionInSet(Object r1);

    public FragmentTransitionImpl() {
    }

    protected void getBoundsOnScreen(View r4, Rect r5) {
        if (ViewCompat.isAttachedToWindow(r4) == true) goto L5;
        return;
    L5:
        RectF r3 = new RectF();
        r3.set(0.0f, 0.0f, r4.getWidth(), r4.getHeight());
        r4.getMatrix().mapRect(r3);
        r3.offset(r4.getLeft(), r4.getTop());
        Object r0 = r4.getParent();
    L7:
        if ((r0 instanceof View) == false) goto L9;
        View r1 = (View) r0;
        r3.offset(-r1.getScrollX(), -r1.getScrollY());
        r1.getMatrix().mapRect(r3);
        r3.offset(r1.getLeft(), r1.getTop());
        r0 = r1.getParent();
        goto L7
    L9:
        int[] r2 = new int[2];
        r4.getRootView().getLocationOnScreen(r2);
        r3.offset(r2[0], r2[1]);
        r5.set(Math.round(r3.left), Math.round(r3.top), Math.round(r3.right), Math.round(r3.bottom));
    }

    ArrayList<String> prepareSetNameOverridesReordered(ArrayList<View> r5) {
        ArrayList<String> r4 = new ArrayList();
        int r0 = r5.size();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        View r2 = r5.get(r1);
        r4.add(ViewCompat.getTransitionName(r2));
        ViewCompat.setTransitionName(r2, null);
        r1 = r1 + 1;
        goto L3
    L5:
        return r4;
    }

    void setNameOverridesReordered(View r9, final ArrayList<View> r10, final ArrayList<View> r11, final ArrayList<String> r12, Map<String, String> r13) {
        final int r2 = r11.size();
        final ArrayList r6 = new ArrayList();
        int r1 = 0;
    L3:
        if (r1 >= r2) goto L14;
        View r3 = r10.get(r1);
        String r4 = ViewCompat.getTransitionName(r3);
        r6.add(r4);
        if (r4 == null) goto L13;
        ViewCompat.setTransitionName(r3, null);
        String r5 = r13.get(r4);
        int r7 = 0;
    L8:
        if (r7 >= r2) goto L13;
        if (r5.equals(r12.get(r7)) == true) goto L11;
        r7 = r7 + 1;
        goto L8
    L11:
        ViewCompat.setTransitionName(r11.get(r7), r4);
    L13:
        r1 = r1 + 1;
        goto L3
    L14:
        OneShotPreDrawListener.add(r9, new AnonymousClass1(this, r2, r11, r12, r10, r6));
    }

    public void setListenerForTransitionEnd(Fragment r1, Object r2, CancellationSignal r3, Runnable r4) {
        r4.run();
    }

    protected static void bfsAddViewChildren(List<View> r6, View r7) {
        int r0 = r6.size();
        if (containedBeforeIndex(r6, r7, r0) == false) goto L6;
        return;
    L6:
        if (ViewCompat.getTransitionName(r7) == null) goto L8;
        r6.add(r7);
    L8:
        int r8 = r0;
    L10:
        if (r8 >= r6.size()) goto L22;
        View r1 = r6.get(r8);
        if ((r1 instanceof ViewGroup) == false) goto L21;
        ViewGroup r2 = (ViewGroup) r1;
        int r3 = r2.getChildCount();
        int r4 = 0;
    L14:
        if (r4 >= r3) goto L21;
        View r5 = r2.getChildAt(r4);
        if (containedBeforeIndex(r6, r5, r0) == true) goto L20;
        if (ViewCompat.getTransitionName(r5) == null) goto L20;
        r6.add(r5);
    L20:
        r4 = r4 + 1;
    L21:
        r8 = r8 + 1;
        goto L10
    }

    private static boolean containedBeforeIndex(List<View> r3, View r4, int r5) {
        int r1 = 0;
    L3:
        if (r1 >= r5) goto L9;
        if (r3.get(r1) == r4) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    protected static boolean isNullOrEmpty(List r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.isEmpty() == true) goto L7;
        return false;
    }
}

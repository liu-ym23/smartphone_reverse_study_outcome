package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"UnknownNullness"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class FragmentTransitionImpl {
    public FragmentTransitionImpl() {
    }

    public static void bfsAddViewChildren(List<View> r6, View r7) {
        int r0 = r6.size();
        if (containedBeforeIndex(r6, r7, r0) == false) goto L5;
        return;
    L5:
        r6.add(r7);
        int r8 = r0;
    L7:
        if (r8 >= r6.size()) goto L17;
        View r1 = r6.get(r8);
        if ((r1 instanceof ViewGroup) == false) goto L16;
        ViewGroup r2 = (ViewGroup) r1;
        int r3 = r2.getChildCount();
        int r4 = 0;
    L11:
        if (r4 >= r3) goto L16;
        View r5 = r2.getChildAt(r4);
        if (containedBeforeIndex(r6, r5, r0) == true) goto L15;
        r6.add(r5);
    L15:
        r4 = r4 + 1;
    L16:
        r8 = r8 + 1;
        goto L7
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

    public static String findKeyForValue(Map<String, String> r2, String r3) {
        Iterator<Map.Entry<String, String>> r4 = r2.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L9;
        Map.Entry<String, String> r0 = r4.next();
        if (r3.equals(r0.getValue()) == false) goto L4;
        return r0.getKey();
    L9:
        return null;
    }

    public static boolean isNullOrEmpty(List r0) {
        if (r0 != null) goto L4;
    L7:
        return true;
    L4:
        if (r0.isEmpty() == true) goto L7;
        return false;
    }

    public abstract void addTarget(Object r1, View r2);

    public abstract void addTargets(Object r1, ArrayList<View> r2);

    public abstract void beginDelayedTransition(ViewGroup r1, Object r2);

    public abstract boolean canHandle(Object r1);

    public void captureTransitioningViews(ArrayList<View> r4, View r5) {
        if (r5.getVisibility() == 0) goto L5;
        return;
    L5:
        if ((r5 instanceof ViewGroup) == false) goto L12;
        ViewGroup r6 = (ViewGroup) r5;
        if (ViewGroupCompat.isTransitionGroup(r6) == false) goto L9;
        r4.add(r6);
        return;
    L9:
        int r0 = r6.getChildCount();
        int r1 = 0;
    L10:
        if (r1 >= r0) goto L17;
        captureTransitioningViews(r4, r6.getChildAt(r1));
        r1 = r1 + 1;
        goto L10
    L17:
        return;
    L12:
        r4.add(r5);
    }

    public abstract Object cloneTransition(Object r1);

    public void findNamedViews(Map<String, View> r4, @NonNull View r5) {
        if (r5.getVisibility() != 0) goto L12;
        String r0 = ViewCompat.getTransitionName(r5);
        if (r0 == null) goto L8;
        r4.put(r0, r5);
    L8:
        if ((r5 instanceof ViewGroup) == false) goto L14;
        ViewGroup r6 = (ViewGroup) r5;
        int r1 = r6.getChildCount();
        int r2 = 0;
    L10:
        if (r2 >= r1) goto L15;
        findNamedViews(r4, r6.getChildAt(r2));
        r2 = r2 + 1;
        goto L10
    L15:
        return;
    L14:
        return;
    }

    public void getBoundsOnScreen(View r5, Rect r6) {
        int[] r4 = new int[2];
        r5.getLocationOnScreen(r4);
        int r0 = r4[0];
        int r2 = r4[1];
        int r3 = r5.getWidth() + r0;
        int r7 = r4[1];
        r6.set(r0, r2, r3, r5.getHeight() + r7);
    }

    public abstract Object mergeTransitionsInSequence(Object r1, Object r2, Object r3);

    public abstract Object mergeTransitionsTogether(Object r1, Object r2, Object r3);

    public ArrayList<String> prepareSetNameOverridesReordered(ArrayList<View> r5) {
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

    public abstract void removeTarget(Object r1, View r2);

    public abstract void replaceTargets(Object r1, ArrayList<View> r2, ArrayList<View> r3);

    public abstract void scheduleHideFragmentView(Object r1, View r2, ArrayList<View> r3);

    public void scheduleNameReset(ViewGroup r2, final ArrayList<View> r3, final Map<String, String> r4) {
        OneShotPreDrawListener.add(r2, new AnonymousClass3(this, r3, r4));
    }

    public abstract void scheduleRemoveTargets(Object r1, Object r2, ArrayList<View> r3, Object r4, ArrayList<View> r5, Object r6, ArrayList<View> r7);

    public abstract void setEpicenter(Object r1, Rect r2);

    public abstract void setEpicenter(Object r1, View r2);

    public void setNameOverridesOrdered(View r2, final ArrayList<View> r3, final Map<String, String> r4) {
        OneShotPreDrawListener.add(r2, new AnonymousClass2(this, r3, r4));
    }

    public void setNameOverridesReordered(View r9, final ArrayList<View> r10, final ArrayList<View> r11, final ArrayList<String> r12, Map<String, String> r13) {
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

    public abstract void setSharedElementTargets(Object r1, View r2, ArrayList<View> r3);

    public abstract void swapSharedElementTargets(Object r1, ArrayList<View> r2, ArrayList<View> r3);

    public abstract Object wrapTransitionInSet(Object r1);
}

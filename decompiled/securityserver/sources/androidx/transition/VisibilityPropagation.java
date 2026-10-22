package androidx.transition;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class VisibilityPropagation extends TransitionPropagation {
    private static final String PROPNAME_VIEW_CENTER = "android:visibilityPropagation:center";
    private static final String PROPNAME_VISIBILITY = "android:visibilityPropagation:visibility";
    private static final String[] VISIBILITY_PROPAGATION_VALUES = null;

    static {
        VISIBILITY_PROPAGATION_VALUES = new String[]{PROPNAME_VISIBILITY, PROPNAME_VIEW_CENTER};
    }

    public VisibilityPropagation() {
    }

    private static int getViewCoordinate(TransitionValues r2, int r3) {
        if (r2 != null) goto L5;
        return -1;
    L5:
        int[] r4 = (int[]) r2.values.get(PROPNAME_VIEW_CENTER);
        if (r4 != null) goto L9;
        return -1;
    L9:
        return r4[r3];
    }

    @Override // androidx.transition.TransitionPropagation
    public void captureValues(TransitionValues r6) {
        View r5 = r6.view;
        Integer r0 = (Integer) r6.values.get("android:visibility:visibility");
        if (r0 != null) goto L5;
        r0 = Integer.valueOf(r5.getVisibility());
    L5:
        r6.values.put(PROPNAME_VISIBILITY, r0);
        int[] r1 = {r4, 0};
        r5.getLocationOnScreen(r1);
        int r4 = Math.round(r5.getTranslationX()) + r1[0];
        r1[0] = (r5.getWidth() / 2) + r4;
        int r7 = Math.round(r5.getTranslationY()) + r1[1];
        r1[1] = r7;
        r1[1] = (r5.getHeight() / 2) + r7;
        r6.values.put(PROPNAME_VIEW_CENTER, r1);
    }

    @Override // androidx.transition.TransitionPropagation
    public String[] getPropagationProperties() {
        return VISIBILITY_PROPAGATION_VALUES;
    }

    public int getViewVisibility(TransitionValues r2) {
        if (r2 != null) goto L5;
        return 8;
    L5:
        Integer r3 = (Integer) r2.values.get(PROPNAME_VISIBILITY);
        if (r3 != null) goto L9;
        return 8;
    L9:
        return r3.intValue();
    }

    public int getViewX(TransitionValues r1) {
        return getViewCoordinate(r1, 0);
    }

    public int getViewY(TransitionValues r1) {
        return getViewCoordinate(r1, 1);
    }
}

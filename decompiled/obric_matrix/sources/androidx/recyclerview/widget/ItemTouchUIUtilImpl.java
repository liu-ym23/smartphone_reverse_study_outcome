package androidx.recyclerview.widget;

import android.graphics.Canvas;
import android.os.Build;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.R;

/* JADX INFO: loaded from: classes.dex */
class ItemTouchUIUtilImpl implements ItemTouchUIUtil {
    static final ItemTouchUIUtil INSTANCE = null;

    static {
        INSTANCE = new ItemTouchUIUtilImpl();
    }

    ItemTouchUIUtilImpl() {
    }

    private static float findMaxElevation(RecyclerView r5, View r6) {
        int r0 = r5.getChildCount();
        float r1 = 0.0f;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L11;
        View r3 = r5.getChildAt(r2);
        if (r3 == r6) goto L10;
        float r4 = ViewCompat.getElevation(r3);
        if (r4 <= r1) goto L10;
        r1 = r4;
    L10:
        r2 = r2 + 1;
        goto L3
    L11:
        return r1;
    }

    @Override // androidx.recyclerview.widget.ItemTouchUIUtil
    public void clearView(View r3) {
        if (Build.VERSION.SDK_INT < 21) goto L8;
        int r2 = R.id.item_touch_helper_previous_elevation;
        Object r0 = r3.getTag(r2);
        if ((r0 instanceof Float) == false) goto L7;
        ViewCompat.setElevation(r3, ((Float) r0).floatValue());
    L7:
        r3.setTag(r2, null);
    L8:
        r3.setTranslationX(0.0f);
        r3.setTranslationY(0.0f);
    }

    @Override // androidx.recyclerview.widget.ItemTouchUIUtil
    public void onDraw(Canvas r1, RecyclerView r2, View r3, float r4, float r5, int r6, boolean r7) {
        if (Build.VERSION.SDK_INT < 21) goto L8;
        if (r7 == false) goto L8;
        int r0 = R.id.item_touch_helper_previous_elevation;
        if (r3.getTag(r0) != null) goto L8;
        Float r8 = Float.valueOf(ViewCompat.getElevation(r3));
        ViewCompat.setElevation(r3, findMaxElevation(r2, r3) + 1.0f);
        r3.setTag(r0, r8);
    L8:
        r3.setTranslationX(r4);
        r3.setTranslationY(r5);
    }

    @Override // androidx.recyclerview.widget.ItemTouchUIUtil
    public void onDrawOver(Canvas r1, RecyclerView r2, View r3, float r4, float r5, int r6, boolean r7) {
    }

    @Override // androidx.recyclerview.widget.ItemTouchUIUtil
    public void onSelected(View r1) {
    }
}

package com.obric.oui.scrollbar;

import android.util.Log;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ListViewScrollBarHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tJ\f\u0010\n\u001a\u00020\u000b*\u00020\u0007H\u0002J\u0014\u0010\f\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/oui/scrollbar/ListViewScrollBarHelper;", "", "()V", "TAG", "", "adjustScrollBarVisibility", "", "Landroid/widget/ListView;", "maxScreens", "", "calculateTotalHeight", "", "updateScrollBarVisibility", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ListViewScrollBarHelper {
    public static final ListViewScrollBarHelper INSTANCE = null;
    private static final String TAG = "ListViewScrollBarHelper";

    static {
        INSTANCE = new ListViewScrollBarHelper();
    }

    private ListViewScrollBarHelper() {
    }

    public static final /* synthetic */ void access$updateScrollBarVisibility(ListViewScrollBarHelper r0, ListView r1, float r2) {
        r0.updateScrollBarVisibility(r1, r2);
    }

    public static /* synthetic */ void adjustScrollBarVisibility$default(ListViewScrollBarHelper r0, ListView r1, float r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L5;
        r2 = 3.0f;
    L5:
        r0.adjustScrollBarVisibility(r1, r2);
    }

    public final void adjustScrollBarVisibility(final ListView r2, final float r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        r2.setVerticalScrollBarEnabled(false);
        r2.getViewTreeObserver().addOnGlobalLayoutListener(new AnonymousClass1(r2, r3));
        r2.setOnScrollListener(new AnonymousClass2(r2, r3));
    }

    private final void updateScrollBarVisibility(ListView r5, float r6) {
        ListAdapter r0 = r5.getAdapter();
        if (r0 != null) goto L5;
        return;
    L5:
        boolean r1 = false;
        if (r0.getCount() != 0) goto L9;
        r5.setVerticalScrollBarEnabled(false);
        return;
    L9:
        int r2 = r5.getHeight();
        int r4 = calculateTotalHeight(r5);
        if (r4 <= 0) goto L13;
        if (r2 <= 0) goto L13;
        float r3 = r4 / r2;
    L15:
        if (r3 <= r6) goto L17;
        r1 = true;
    L17:
        r5.setVerticalScrollBarEnabled(r1);
        Log.d(TAG, "ListView updateScrollBarVisibility, isVerticalScrollBarEnabled: " + r5.isVerticalScrollBarEnabled() + ", contentScreens: " + r3 + ", totalHeight: " + r4 + ", visibleHeight: " + r2);
        return;
    L13:
        r3 = 0.0f;
        goto L15
    }

    private final int calculateTotalHeight(ListView r10) {
        ListAdapter r9 = r10.getAdapter();
        if (r9 != null) goto L5;
        return 0;
    L5:
        LinkedHashMap r1 = new LinkedHashMap();
        int r2 = r9.getCount();
        int r3 = 0;
        int r4 = 0;
    L6:
        if (r3 >= r2) goto L11;
        int r5 = r3 + 1;
        int r6 = r9.getItemViewType(r3);
        View r7 = (View) r1.get(Integer.valueOf(r6));
        View r8 = r9.getView(r3, r7, r10);
        if (r7 != null) goto L10;
        Integer r11 = Integer.valueOf(r6);
        Intrinsics.checkNotNullExpressionValue(r8, "view");
        r1.put(r11, r8);
    L10:
        r8.measure(View.MeasureSpec.makeMeasureSpec(r10.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        r4 = r4 + r8.getMeasuredHeight();
        r3 = r5;
        goto L6
    L11:
        int r12 = r10.getDividerHeight();
        if (r12 > 0) goto L14;
        return r4;
    L14:
        return r4 + (r12 * (r9.getCount() - 1));
    }
}

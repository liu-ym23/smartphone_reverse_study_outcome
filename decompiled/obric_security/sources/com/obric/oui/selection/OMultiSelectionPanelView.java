package com.obric.oui.selection;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedanceos.security.Utils;
import com.obric.common.oui.R;
import com.obric.oui.common.util.OUnitExtensionKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OMultiSelectionPanelView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated(message = "This class has been deprecated. Please use OListItemGeneral instead. For usage examples, refer to the ListItemActivity class in the example.")
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001:\u0001\u0014B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\nJ\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0014J\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0007H\u0016¨\u0006\u0015"}, d2 = {"Lcom/obric/oui/selection/OMultiSelectionPanelView;", "Lcom/obric/oui/selection/OSelectionPanelView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "theme", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getSelectedItems", "", "initHeight", "", "isMultiSelect", "", "registerMultiItemSelectListener", "listener", "Lcom/obric/oui/selection/OMultiSelectionPanelView$OnMultiItemSelectListener;", "select", Utils.INTENT_KEY_INDEX, "OnMultiItemSelectListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OMultiSelectionPanelView extends OSelectionPanelView {

    /* JADX INFO: compiled from: OMultiSelectionPanelView.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J$\u0010\u0006\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\bH&¨\u0006\u000b"}, d2 = {"Lcom/obric/oui/selection/OMultiSelectionPanelView$OnMultiItemSelectListener;", "", "onConcreteItemSelected", "", "position", "", "onItemsSelected", "views", "", "Lcom/obric/oui/selection/OSelectionPanelItemView;", "positions", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnMultiItemSelectListener {
        void onConcreteItemSelected(int r1);

        void onItemsSelected(List<OSelectionPanelItemView> r1, List<Integer> r2);
    }

    @Override // com.obric.oui.selection.OSelectionPanelView
    protected boolean isMultiSelect() {
        return true;
    }

    public /* synthetic */ OMultiSelectionPanelView(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = R.style.OSelectionPanel;
    L8:
        this(r1, r2, r3);
    }

    public OMultiSelectionPanelView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    @Override // com.obric.oui.selection.OSelectionPanelView
    public void select(int r3) {
        boolean r0 = false;
        if (r3 >= 0) goto L5;
    L7:
        if (r0 == false) goto L10;
        getItemViews().get(r3).select();
        return;
    L10:
        return;
    L5:
        if (r3 >= getItemViews().size()) goto L7;
        r0 = true;
        goto L7
    }

    @Override // com.obric.oui.selection.OSelectionPanelView
    public void initHeight() {
        if (getItemViews().size() <= 7) goto L5;
        setScrollViewHeight(OUnitExtensionKt.vdp(this, 424));
        return;
    L5:
        setScrollViewHeight(-2);
    }

    public final List<Integer> getSelectedItems() {
        ArrayList r0 = new ArrayList();
        Iterator<T> r4 = getItemViews().iterator();
        int r1 = 0;
    L4:
        if (r4.hasNext() == false) goto L12;
        Object r2 = r4.next();
        int r3 = r1 + 1;
        if (r1 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();
    L9:
        if (((OSelectionPanelItemView) r2).isItemSelected() == false) goto L11;
        r0.add(Integer.valueOf(r1));
    L11:
        r1 = r3;
        goto L4
    L12:
        return r0;
    }

    public final void registerMultiItemSelectListener(OnMultiItemSelectListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        setOnMultiItemSelectListener(r2);
    }
}

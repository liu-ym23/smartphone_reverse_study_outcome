package com.obric.oui.selection;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedanceos.security.Utils;
import com.obric.common.oui.R;
import com.obric.oui.common.util.OUnitExtensionKt;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OSingleSelectionPanelView.kt */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated(message = "This class has been deprecated. Please use OListItemGeneral instead. For usage examples, refer to the ListItemActivity class in the example.")
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001:\u0001\u0013B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\t\u001a\u00020\u0007J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0014J\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0007H\u0016¨\u0006\u0014"}, d2 = {"Lcom/obric/oui/selection/OSingleSelectionPanelView;", "Lcom/obric/oui/selection/OSelectionPanelView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "theme", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getSelectedItem", "initHeight", "", "isMultiSelect", "", "registerItemSelectListener", "listener", "Lcom/obric/oui/selection/OSingleSelectionPanelView$OnItemSelectListener;", "select", Utils.INTENT_KEY_INDEX, "OnItemSelectListener", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class OSingleSelectionPanelView extends OSelectionPanelView {

    /* JADX INFO: compiled from: OSingleSelectionPanelView.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/obric/oui/selection/OSingleSelectionPanelView$OnItemSelectListener;", "", "onItemSelected", "", "view", "Lcom/obric/oui/selection/OSelectionPanelItemView;", "position", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnItemSelectListener {
        void onItemSelected(OSelectionPanelItemView r1, int r2);
    }

    @Override // com.obric.oui.selection.OSelectionPanelView
    protected boolean isMultiSelect() {
        return false;
    }

    public /* synthetic */ OSingleSelectionPanelView(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = R.style.OSelectionPanel;
    L8:
        this(r1, r2, r3);
    }

    public OSingleSelectionPanelView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    @Override // com.obric.oui.selection.OSelectionPanelView
    public void select(int r4) {
        int r0 = 0;
        if (r4 >= 0) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L20;
        Iterator<T> r3 = getItemViews().iterator();
    L11:
        if (r3.hasNext() == false) goto L24;
        Object r2 = r3.next();
        int r5 = r0 + 1;
        if (r0 >= 0) goto L15;
        CollectionsKt.throwIndexOverflow();
    L15:
        OSelectionPanelItemView r6 = (OSelectionPanelItemView) r2;
        if (r0 != r4) goto L18;
        r6.select();
    L19:
        r0 = r5;
        goto L11
    L18:
        r6.unSelect();
        goto L19
    L24:
        return;
    L20:
        return;
    L5:
        if (r4 >= getItemViews().size()) goto L7;
        r1 = true;
        goto L8
    }

    @Override // com.obric.oui.selection.OSelectionPanelView
    public void initHeight() {
        if (getContext().getResources().getConfiguration().orientation != 2) goto L5;
        boolean r0 = true;
    L7:
        if (r0 == true) goto L13;
        if (getItemViews().size() <= 7) goto L11;
        setScrollViewHeight(OUnitExtensionKt.vdp(this, 424));
        return;
    L11:
        setScrollViewHeight(-2);
        return;
    L13:
        if (getItemViews().size() <= 2) goto L15;
        setScrollViewHeight(OUnitExtensionKt.vdp(this, 112));
        return;
    L15:
        setScrollViewHeight(-2);
        return;
    L5:
        r0 = false;
        goto L7
    }

    public final void registerItemSelectListener(OnItemSelectListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        setOnItemSelectListener(r2);
    }

    public final int getSelectedItem() {
        Iterator<T> r3 = getItemViews().iterator();
        int r0 = 0;
    L4:
        if (r3.hasNext() == false) goto L12;
        Object r1 = r3.next();
        int r2 = r0 + 1;
        if (r0 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();
    L9:
        if (((OSelectionPanelItemView) r1).isItemSelected() == true) goto L10;
        r0 = r2;
        goto L4
    L10:
        return r0;
    L12:
        return -1;
    }
}

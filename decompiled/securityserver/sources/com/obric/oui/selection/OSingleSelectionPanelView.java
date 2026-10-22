package com.obric.oui.selection;

import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
@Metadata
public class OSingleSelectionPanelView extends OSelectionPanelView {

    @Metadata
    public interface OnItemSelectListener {
    }

    @Override // com.obric.oui.selection.OSelectionPanelView
    public final boolean a() {
        return false;
    }

    public final int getSelectedItem() {
        Iterator<T> r3 = getItemViews().iterator();
        int r0 = 0;
    L4:
        if (r3.hasNext() == false) goto L13;
        Object r1 = r3.next();
        int r2 = r0 + 1;
        if (r0 < 0) goto L11;
        if (((OSelectionPanelItemView) r1).g() == true) goto L9;
        r0 = r2;
        goto L4
    L9:
        return r0;
    L11:
        CollectionsKt.p();
        throw null;
    L13:
        return -1;
    }
}

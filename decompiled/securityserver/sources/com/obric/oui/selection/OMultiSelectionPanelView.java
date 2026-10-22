package com.obric.oui.selection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
@Metadata
public class OMultiSelectionPanelView extends OSelectionPanelView {

    @Metadata
    public interface OnMultiItemSelectListener {
        void a();
    }

    @Override // com.obric.oui.selection.OSelectionPanelView
    public final boolean a() {
        return true;
    }

    @NotNull
    public final List<Integer> getSelectedItems() {
        ArrayList r0 = new ArrayList();
        Iterator<T> r4 = getItemViews().iterator();
        int r1 = 0;
    L4:
        if (r4.hasNext() == false) goto L13;
        Object r2 = r4.next();
        int r3 = r1 + 1;
        if (r1 < 0) goto L11;
        if (((OSelectionPanelItemView) r2).g() == false) goto L10;
        r0.add(Integer.valueOf(r1));
    L10:
        r1 = r3;
        goto L4
    L11:
        CollectionsKt.p();
        throw null;
    L13:
        return r0;
    }
}

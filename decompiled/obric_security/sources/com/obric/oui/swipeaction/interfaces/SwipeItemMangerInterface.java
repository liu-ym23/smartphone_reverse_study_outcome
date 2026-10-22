package com.obric.oui.swipeaction.interfaces;

import com.obric.oui.swipeaction.OSwipeLayout;
import com.obric.oui.swipeaction.util.Attributes;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface SwipeItemMangerInterface {
    void closeAllExcept(OSwipeLayout r1);

    void closeAllItems();

    void closeItem(int r1);

    Attributes.Mode getMode();

    List<Integer> getOpenItems();

    List<OSwipeLayout> getOpenLayouts();

    boolean isOpen(int r1);

    void openItem(int r1);

    void removeShownLayouts(OSwipeLayout r1);

    void setMode(Attributes.Mode r1);
}

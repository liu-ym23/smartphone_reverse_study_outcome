package com.obric.oui.swipeaction.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.obric.oui.swipeaction.interfaces.SwipeAdapterInterface;
import com.obric.oui.swipeaction.interfaces.SwipeItemMangerInterface;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseSwipeAdapter extends BaseAdapter implements SwipeItemMangerInterface, SwipeAdapterInterface {
    public abstract View a();

    @Override // android.widget.Adapter
    public final View getView(int r1, View r2, ViewGroup r3) {
        if (r2 != null) goto L5;
        a();
    L5:
        throw null;
    }
}

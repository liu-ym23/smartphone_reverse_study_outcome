package com.obric.oui.swipeaction.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.obric.oui.swipeaction.interfaces.SwipeAdapterInterface;
import com.obric.oui.swipeaction.interfaces.SwipeItemMangerInterface;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ArraySwipeAdapter<T> extends ArrayAdapter implements SwipeItemMangerInterface, SwipeAdapterInterface {
    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final View getView(int r1, View r2, ViewGroup r3) {
        super.getView(r1, r2, r3);
        throw null;
    }
}

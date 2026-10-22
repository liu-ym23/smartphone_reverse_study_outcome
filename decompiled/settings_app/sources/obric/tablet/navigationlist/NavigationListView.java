package obric.tablet.navigationlist;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Adapter;
import android.widget.ListAdapter;
import obric.tablet.dslv.DragSortListView;

/* JADX INFO: loaded from: classes5.dex */
public class NavigationListView extends DragSortListView {
    private NavListDragSortController mDragController;

    @Override // obric.tablet.dslv.DragSortListView, android.widget.AdapterView
    public /* bridge */ /* synthetic */ void setAdapter(Adapter r1) {
        setAdapter((ListAdapter) r1);
    }

    public NavigationListView(Context r8, AttributeSet r9) {
        super(r8, r9);
        NavListDragSortController r10 = new NavListDragSortController(this, 0, 2, 1, 0, 0);
        this.mDragController = r10;
        r10.setRemoveEnabled(true);
        this.mDragController.setSortEnabled(true);
        this.mDragController.setBackgroundColor(0);
        setFloatViewManager(this.mDragController);
        setOnTouchListener(this.mDragController);
    }

    @Override // obric.tablet.dslv.DragSortListView, android.widget.ListView, android.widget.AbsListView
    public void setAdapter(ListAdapter r2) {
        if ((r2 instanceof HeaderListAdapter) == false) goto L7;
        super.setAdapter(r2);
        HeaderListAdapter r3 = (HeaderListAdapter) r2;
        this.mDragController.setDragPolicy(r3);
        r3.setListView(this);
        return;
    L7:
        throw new UnsupportedOperationException("the listview only support HeaderListAdapter");
    }
}

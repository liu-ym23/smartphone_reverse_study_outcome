package obric.tablet.navigationlist;

import android.content.Context;
import android.database.Observable;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.android.settings.R;
import java.util.ArrayList;
import java.util.Iterator;
import obric.tablet.dslv.DragSortListView;

/* JADX INFO: loaded from: classes5.dex */
public class HeaderListAdapter extends BaseAdapter implements DragSortListView.DropListener, DragSortListView.RemoveListener, NavListDragSortController.DragPolicy {
    private ArrayList<ViewHolder> mData;
    private int mHeaderPadingTop;
    private LayoutInflater mInflater;
    private ArrayList<HeaderViewHolder> mItemGroups;
    private int mListBottomPadding;
    private final AdapterDataObservable mObservable;
    private OnExpandableArrowClickListener mOnExpandableArrowListener;
    private OnExpandableIconClickListener mOnExpandableIconListener;
    private OnItemClickListener mOnItemClickListener;
    private OnItemDragListener mOnItemDragListener;
    private ItemViewHolder mSelectedItem;

    class AdapterDataObservable extends Observable<AdapterDataObserver> {
        final /* synthetic */ HeaderListAdapter this$0;

        AdapterDataObservable(HeaderListAdapter r1) {
            this.this$0 = r1;
        }

        public boolean hasObservers() {
            return !this.mObservers.isEmpty();
        }

        public void notifyItemChanged(int r4) {
            int r0 = this.mObservers.size() - 1;
        L3:
            if (r0 < 0) goto L8;
            ViewHolder r1 = (ViewHolder) HeaderListAdapter.access$000(this.this$0).get(r4);
            if ((r1 instanceof ItemViewHolder) == false) goto L7;
            ((AdapterDataObserver) this.mObservers.get(r0)).onItemChanged((ItemViewHolder) r1);
        L7:
            r0 = r0 - 1;
            goto L3
        }

        public void notifyItemRemoved(int r4) {
            int r0 = this.mObservers.size() - 1;
        L3:
            if (r0 < 0) goto L8;
            ViewHolder r1 = (ViewHolder) HeaderListAdapter.access$000(this.this$0).get(r4);
            if ((r1 instanceof ItemViewHolder) == false) goto L7;
            ((AdapterDataObserver) this.mObservers.get(r0)).onItemRemoved((ItemViewHolder) r1);
        L7:
            r0 = r0 - 1;
            goto L3
        }

        public void notifyItemMoved(int r1, int r2) {
            int r0 = this.mObservers.size() - 1;
        L3:
            if (r0 < 0) goto L5;
            r0 = r0 - 1;
            goto L3
        }
    }

    public static abstract class AdapterDataObserver {
        public void onItemChanged(ItemViewHolder r1) {
        }

        public void onItemMoved(ItemViewHolder r1, int r2, int r3) {
        }

        public void onItemRemoved(ItemViewHolder r1) {
        }

        public AdapterDataObserver() {
        }
    }

    public interface OnExpandableArrowClickListener {
        void onArrowClick(View r1, ExpandableItemViewHolder r2);
    }

    public interface OnExpandableIconClickListener {
        void onIconClick(View r1, ExpandableItemViewHolder r2);
    }

    public interface OnItemClickListener {
        void onItemClicked(View r1, ItemViewHolder r2);
    }

    public interface OnItemDragListener {
        boolean onItemDrag(View r1, ItemViewHolder r2, DragEvent r3);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public CharSequence[] getAutofillOptions() {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int r1) {
        return r1;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 6;
    }

    static /* synthetic */ ArrayList access$000(HeaderListAdapter r0) {
        return r0.mData;
    }

    static /* synthetic */ OnItemDragListener access$100(HeaderListAdapter r0) {
        return r0.mOnItemDragListener;
    }

    static /* synthetic */ AdapterDataObservable access$200(HeaderListAdapter r0) {
        return r0.mObservable;
    }

    static /* synthetic */ OnExpandableArrowClickListener access$300(HeaderListAdapter r0) {
        return r0.mOnExpandableArrowListener;
    }

    static /* synthetic */ OnExpandableIconClickListener access$400(HeaderListAdapter r0) {
        return r0.mOnExpandableIconListener;
    }

    static /* synthetic */ ItemViewHolder access$500(HeaderListAdapter r0) {
        return r0.mSelectedItem;
    }

    static /* synthetic */ ItemViewHolder access$502(HeaderListAdapter r0, ItemViewHolder r1) {
        r0.mSelectedItem = r1;
        return r1;
    }

    static /* synthetic */ OnItemClickListener access$600(HeaderListAdapter r0) {
        return r0.mOnItemClickListener;
    }

    public HeaderListAdapter(Context r2) {
        this.mData = new ArrayList();
        this.mObservable = new AdapterDataObservable(this);
        this.mInflater = LayoutInflater.from(r2);
        int r3 = (int) r2.getResources().getDimension(R.dimen.nav_list_header_padding_top);
        this.mHeaderPadingTop = r3;
        this.mListBottomPadding = r3;
    }

    public HeaderListAdapter(Context r1, ArrayList<HeaderViewHolder> r2, OnItemClickListener r3) {
        this(r1);
        this.mOnItemClickListener = r3;
        this.mItemGroups = r2;
        updateData();
    }

    @Override // obric.tablet.dslv.DragSortListView.DropListener
    public void drop(int r2, int r3) {
        if (this.mObservable.hasObservers() == false) goto L6;
        this.mObservable.notifyItemMoved(r2, r3);
        return;
    }

    @Override // obric.tablet.dslv.DragSortListView.RemoveListener
    public void remove(int r2) {
        if (this.mObservable.hasObservers() == false) goto L6;
        this.mObservable.notifyItemRemoved(r2);
        return;
    }

    public void registerAdapterDataObserver(AdapterDataObserver r1) {
        this.mObservable.registerObserver(r1);
    }

    public void unregisterAdapterDataObserver(AdapterDataObserver r1) {
        this.mObservable.unregisterObserver(r1);
    }

    @Override // obric.tablet.navigationlist.NavListDragSortController.DragPolicy
    public boolean canDrag(int r2) {
        if (r2 < this.mData.size()) goto L5;
        return false;
    L5:
        return this.mData.get(r2).canDragged();
    }

    public void setListBottomPadding(int r1) {
        this.mListBottomPadding = r1;
    }

    public void setItemClickListener(OnItemClickListener r1) {
        this.mOnItemClickListener = r1;
    }

    public void setItemDragListener(OnItemDragListener r1) {
        this.mOnItemDragListener = r1;
    }

    public void setExpandableItemArrowClickListener(OnExpandableArrowClickListener r1) {
        this.mOnExpandableArrowListener = r1;
    }

    public void setOnExpandableIconListener(OnExpandableIconClickListener r1) {
        this.mOnExpandableIconListener = r1;
    }

    public void setData(ArrayList<HeaderViewHolder> r1) {
        this.mItemGroups = r1;
        notifyDataSetChanged();
    }

    public void setSelectedItem(ItemViewHolder r1) {
        this.mSelectedItem = r1;
        r1.setSelected(true);
    }

    public ItemViewHolder getSelectedItem() {
        return this.mSelectedItem;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        updateData();
        super.notifyDataSetChanged();
    }

    public void updateData() {
        this.mData.clear();
        int r0 = this.mItemGroups.size();
        this.mData.add(new EmptyViewHolder(-1, this.mHeaderPadingTop));
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L15;
        if (r1 <= 0) goto L6;
        this.mData.add(new EmptyViewHolder(-1, this.mHeaderPadingTop * 2));
    L6:
        HeaderViewHolder r2 = this.mItemGroups.get(r1);
        this.mData.add(r2);
        if (r2.mShowChildren == false) goto L14;
        if (r2.mChildren == null) goto L14;
        Iterator<ViewHolder> r3 = r2.mChildren.iterator();
    L12:
        if (r3.hasNext() == false) goto L14;
        updateItem(r3.next());
    L14:
        r1 = r1 + 1;
        goto L3
    L15:
        this.mData.add(new EmptyViewHolder(-1, this.mListBottomPadding));
    }

    private void updateItem(ViewHolder r2) {
        this.mData.add(r2);
        if ((r2 instanceof ExpandableItemViewHolder) == false) goto L12;
        ExpandableItemViewHolder r3 = (ExpandableItemViewHolder) r2;
        if (r3.mChildren != null) goto L7;
        return;
    L7:
        if (r3.mChildren.isEmpty() == true) goto L15;
        Iterator<ViewHolder> r4 = r3.mChildren.iterator();
    L10:
        if (r4.hasNext() == false) goto L16;
        updateItem(r4.next());
        goto L10
    L16:
        return;
    L15:
        return;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int r2) {
        if (r2 < this.mData.size()) goto L5;
        return 0;
    L5:
        return this.mData.get(r2).getType();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mData.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int r1) {
        return this.mData.get(r1);
    }

    @Override // android.widget.Adapter
    public View getView(int r4, View r5, ViewGroup r6) {
        ViewHolder r0 = (ViewHolder) getItem(r4);
        if (r5 != null) goto L5;
    L6:
        r5 = r0.createView(this.mInflater, r6);
        r5.setOnDragListener(new AnonymousClass1(this));
    L7:
        r5.setTag(r0);
        r0.bindView(r4, r5);
        if ((r0 instanceof ItemViewHolder) == false) goto L11;
        ((ItemViewHolder) r0).setOnItemChangedListener(new AnonymousClass2(this));
    L11:
        if ((r0 instanceof ExpandableItemViewHolder) == false) goto L13;
        final ExpandableItemViewHolder r1 = (ExpandableItemViewHolder) r0;
        r1.getArrowView().setOnClickListener(new AnonymousClass3(this, r1));
        r1.getIconView().setOnClickListener(new AnonymousClass4(this, r1));
    L13:
        return r5;
    L5:
        if (((ViewHolder) r5.getTag()).getType() == r0.getType()) goto L7;
        goto L6
    }

    public void expand(ExpandableItemViewHolder r2, ArrayList<ViewHolder> r3) {
        r2.setState(true);
        r2.setChildren(r3);
        notifyDataSetChanged();
    }

    public void fold(ExpandableItemViewHolder r2) {
        r2.setState(false);
        notifyDataSetChanged();
    }

    void setListView(ListView r2) {
        r2.setOnItemClickListener(new AnonymousClass5(this));
    }
}

package com.qihoo360.mobilesafe.common.ui.list;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import com.qihoo360.mobilesafe.common.ui.R;
import com.qihoo360.mobilesafe.common.ui.utils.CommonUtils;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class TreeViewWrapper {
    private static final boolean DEBUG = false;
    public static final int INVALID_TREEITEMPOS = -1;
    private static final String TAG = "TreeViewWrapper";
    private Context mContext;
    private TreeView mTreeView;

    protected static abstract class BaseAdapterExt extends BaseAdapter {
        public boolean nextPositionIsDivider(int r1) {
            return false;
        }

        protected BaseAdapterExt() {
        }
    }

    public interface OnHeaderUpdateListener {
        View getPinnedHeader();

        void updatePinnedHeader(View r1, int r2);
    }

    public interface OnTreeItemClickListener {
        void onTreeElementClick(View r1, TreeElement r2, int r3);
    }

    public static class TreeElement {
        protected static final int DEPTH_MASK = 7;
        protected static final int EXPAND_MASK = 8;
        protected static final int LEAF_NODE_MASK = 16;
        protected final List<TreeElement> mChildList;
        protected Object mData;
        protected TreeElement mDividerOwner;
        protected int mFlags;
        protected TreeElement mParent;

        public void finalize() {
        }

        protected TreeElement(Object r2, TreeElement r3) {
            this.mFlags = 0;
            this.mChildList = new ArrayList();
            this.mData = r2;
            this.mParent = r3;
            if (r3 == null) goto L6;
            setDepth(r3.getDepth() + 1);
            this.mParent.addChild(this);
            return;
        }

        public TreeElement getParent() {
            return this.mParent;
        }

        public Object getData() {
            return this.mData;
        }

        public void setData(Object r1) {
            this.mData = r1;
        }

        public int getDepth() {
            return this.mFlags & 7;
        }

        public boolean isExpand() {
            if ((this.mFlags & 8) != 8) goto L5;
            return true;
        L5:
            return false;
        }

        public boolean isLeaf() {
            if (this.mDividerOwner == null) goto L6;
            return true;
        L6:
            if ((this.mFlags & 16) == 16) goto L10;
            return false;
        L10:
            return true;
        }

        public boolean isDivider() {
            if (this.mDividerOwner == null) goto L5;
            return true;
        L5:
            return false;
        }

        public void setLeaf(boolean r1) {
            if (r1 == false) goto L4;
            this.mFlags |= 16;
            return;
        L4:
            this.mFlags &= -17;
        }

        public boolean hasChild() {
            if (childCount() <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        public int childCount() {
            return this.mChildList.size();
        }

        public TreeElement getChildAt(int r2) {
            if (r2 >= 0) goto L4;
            return null;
        L4:
            if (r2 < childCount()) goto L7;
            return null;
        L7:
            return this.mChildList.get(r2);
        }

        public int getInParentPosition() {
            if (this.mParent == null) goto L11;
            int r0 = 0;
        L6:
            if (r0 >= this.mParent.mChildList.size()) goto L15;
            if (this.mParent.mChildList.get(r0) == this) goto L9;
            r0 = r0 + 1;
            goto L6
        L9:
            return r0;
        L15:
            return -1;
        L11:
            return -1;
        }

        public boolean isParentFirstChild() {
            TreeElement r0 = this.mParent;
            if (r0 != null) goto L5;
            return false;
        L5:
            if (r0.mChildList.isEmpty() == false) goto L8;
            return false;
        L8:
            if (this != this.mParent.mChildList.get(0)) goto L12;
            return true;
        L12:
            return false;
        }

        public boolean isParentLastChild() {
            TreeElement r0 = this.mParent;
            if (r0 == null) goto L11;
            int r1 = r0.mChildList.size();
            if (r1 != 0) goto L8;
            return false;
        L8:
            if (this == this.mParent.mChildList.get(r1 - 1)) goto L10;
            return false;
        L10:
            return true;
        L11:
            return false;
        }

        protected void setDividerOwner(TreeElement r1) {
            this.mDividerOwner = r1;
        }

        protected boolean isParentsExpand() {
            TreeElement r1 = getParent();
        L3:
            if (r1 == null) goto L9;
            if (r1.isExpand() == false) goto L6;
            r1 = r1.getParent();
            goto L3
        L6:
            return false;
        L9:
            return true;
        }

        protected void addChild(TreeElement r2) {
            r2.mParent = this;
            r2.setDepth(getDepth() + 1);
            this.mChildList.add(r2);
        }

        protected void setDepth(int r2) {
            int r3 = r2 & 7;
            this.mFlags = r3 | (this.mFlags & (-8));
        }

        protected void toggleExpand() {
            this.mFlags ^= 8;
        }

        protected void getExpandList(List<TreeElement> r3) {
            Iterator<TreeElement> r2 = this.mChildList.iterator();
        L4:
            if (r2.hasNext() == false) goto L8;
            TreeElement r0 = r2.next();
            r3.add(r0);
            if (r0.isExpand() == false) goto L4;
            r0.getExpandList(r3);
            goto L4
        }

        protected int deleteChildRecursionByData(Object r6) {
            int r0 = this.mChildList.size() - 1;
            int r1 = 0;
        L3:
            if (r0 < 0) goto L21;
            TreeElement r2 = this.mChildList.get(r0);
            Object r3 = r2.getData();
            if (r2.isDivider() == false) goto L12;
            Object r4 = r2.mDividerOwner.getData();
            if (r4 == r6) goto L11;
            if (r4 == null) goto L20;
            if (r4.equals(r6) == true) goto L11;
        L20:
            r0 = r0 - 1;
        L11:
            this.mChildList.remove(r0);
            goto L20
        L12:
            if (r3 == r6) goto L18;
            if (r3 != null) goto L15;
        L17:
            int r5 = r2.deleteChildRecursionByData(r6);
        L19:
            r1 = r1 + r5;
            goto L20
        L15:
            if (r3.equals(r6) == false) goto L17;
        L18:
            this.mChildList.remove(r0);
            r1 = r1 + 1;
            r5 = getChildRecursionCount();
            goto L19
        L21:
            return r1;
        }

        protected int deleteChildRecursion(TreeElement r4) {
            int r0 = this.mChildList.size() - 1;
            int r1 = 0;
        L3:
            if (r0 < 0) goto L15;
            TreeElement r2 = this.mChildList.get(r0);
            if (r2 == r4) goto L6;
            r1 = r1 + r2.deleteChildRecursion(r4);
            if (r1 > 0) goto L16;
            r0 = r0 - 1;
            goto L3
        L16:
            return r1;
        L6:
            this.mChildList.remove(r0);
            return (r1 + 1) + getChildRecursionCount();
        L15:
            return r1;
        }

        protected int deleteChildRecursionByComparator(Comparator<TreeElement> r5) {
            int r0 = this.mChildList.size() - 1;
            int r1 = 0;
        L3:
            if (r0 < 0) goto L15;
            TreeElement r2 = this.mChildList.get(r0);
            if (r2.isDivider() == false) goto L10;
            if (r5.equals(r2.mDividerOwner) == false) goto L14;
            this.mChildList.remove(r0);
        L14:
            r0 = r0 - 1;
            goto L3
        L10:
            if (r5.equals(r2) == false) goto L12;
            this.mChildList.remove(r0);
            r1 = r1 + 1;
            int r3 = getChildRecursionCount();
        L13:
            r1 = r1 + r3;
            goto L14
        L12:
            r3 = r2.deleteChildRecursionByData(r5);
            goto L13
        L15:
            return r1;
        }

        protected boolean isParentData(Object r2) {
            TreeElement r1 = getParent();
        L3:
            if (r1 == null) goto L13;
            Object r0 = r1.getData();
            if (r0 == r2) goto L11;
            if (r0 == null) goto L10;
            if (r0.equals(r2) == false) goto L10;
            return true;
        L10:
            r1 = r1.getParent();
            goto L3
        L11:
            return true;
        L13:
            return false;
        }

        protected boolean isParentEquals(Comparator<TreeElement> r2) {
            TreeElement r1 = getParent();
        L3:
            if (r1 == null) goto L9;
            if (r2.equals(r1) == true) goto L6;
            r1 = r1.getParent();
            goto L3
        L6:
            return true;
        L9:
            return false;
        }

        protected int getChildRecursionCount() {
            Iterator<TreeElement> r3 = this.mChildList.iterator();
            int r0 = 0;
        L4:
            if (r3.hasNext() == false) goto L8;
            TreeElement r1 = r3.next();
            if (r1.isDivider() == true) goto L4;
            r0 = (r0 + 1) + r1.getChildRecursionCount();
            goto L4
        L8:
            return r0;
        }

        protected void findChildRecursionByComparator(Comparator<TreeElement> r3, List<TreeElement> r4) {
            Iterator<TreeElement> r2 = this.mChildList.iterator();
        L4:
            if (r2.hasNext() == false) goto L11;
            TreeElement r0 = r2.next();
            if (r0.isDivider() == true) goto L4;
            if (r3.equals(r0) == false) goto L10;
            r4.add(r0);
        L10:
            r0.findChildRecursionByComparator(r3, r4);
            goto L4
        }
    }

    public static abstract class TreeViewAdapter {
        public static final int DIVIDERVIEW_NONE = 0;
        public static final int DIVIDERVIEW_TOPDIVIDER = 1;
        public static final int DIVIDERVIEW_TOPDIVIDER_BOTTOMDIVIDER = 4;
        public static final int DIVIDERVIEW_TOPDIVIDER_TOPMARGIN = 3;
        public static final int DIVIDERVIEW_TOPMARGIN = 2;
        protected BaseAdapterExt mBaseAdapter;
        private int mDividerViewMode;

        private static class DividerViewLayout extends RelativeLayout {
            private View mBottomDivider;
            private View mTopDivider;
            private View mTopMargin;

            public DividerViewLayout(Context r2) {
                super(r2, null);
                init();
            }

            public void setBottomDividerVisible(int r1) {
                this.mBottomDivider.setVisibility(r1);
            }

            public void setBottomDividerMargin(int r1) {
                this.mBottomDivider.setVisibility(r1);
            }

            public void setTopDividerVisible(int r1) {
                this.mTopDivider.setVisibility(r1);
            }

            private void init() {
                Context r0 = getContext();
                View r1 = new View(r0);
                this.mTopMargin = r1;
                r1.setId(R.id.treeview_divider_top_margin);
                this.mTopMargin.setBackgroundResource(R.color.inner_common_bg_color_1);
                RelativeLayout.LayoutParams r2 = new RelativeLayout.LayoutParams(-1, CommonUtils.dip2px(r0, 10.0f));
                r2.addRule(10);
                addView(this.mTopMargin, r2);
                View r3 = new View(r0);
                this.mBottomDivider = r3;
                r3.setId(R.id.treeview_divider_top_line);
                this.mBottomDivider.setBackgroundResource(R.color.inner_common_bg_color_7);
                RelativeLayout.LayoutParams r4 = new RelativeLayout.LayoutParams(-1, 1);
                r4.addRule(8, this.mTopMargin.getId());
                addView(this.mBottomDivider, r4);
                View r5 = new View(r0);
                this.mTopDivider = r5;
                r5.setBackgroundResource(R.color.inner_common_bg_color_7);
                RelativeLayout.LayoutParams r6 = new RelativeLayout.LayoutParams(-1, 1);
                r6.addRule(6, this.mTopMargin.getId());
                addView(this.mTopDivider, r6);
            }
        }

        public int getDividerTypeCount() {
            return 1;
        }

        public abstract int getItemViewType(TreeElement r1);

        public abstract View getView(int r1, View r2, ViewGroup r3, TreeElement r4);

        public abstract int getViewTypeCount();

        public TreeViewAdapter() {
            this.mDividerViewMode = 2;
        }

        public final int getCount() {
            return this.mBaseAdapter.getCount();
        }

        public final Object getItem(int r1) {
            return this.mBaseAdapter.getItem(r1);
        }

        public final long getItemId(int r1) {
            return this.mBaseAdapter.getItemId(r1);
        }

        public void notifyDataSetChanged() {
            this.mBaseAdapter.notifyDataSetChanged();
        }

        public void notifyDataSetInvalidated() {
            this.mBaseAdapter.notifyDataSetInvalidated();
        }

        public final void setDividerViewType(int r1) {
            this.mDividerViewMode = r1;
        }

        public int getDividerViewType(TreeElement r1) {
            return getViewTypeCount();
        }

        public final boolean nextPositionIsDivider(int r1) {
            return this.mBaseAdapter.nextPositionIsDivider(r1);
        }

        protected final View getViewInternal(int r2, View r3, ViewGroup r4, TreeElement r5) {
            if (r5.isDivider() == false) goto L7;
            return getDividerView(r2, r3, r4, r5);
        L7:
            return getView(r2, r3, r4, r5);
        }

        protected final int getItemViewTypeInternal(TreeElement r2) {
            if (r2.isDivider() == false) goto L7;
            return getDividerViewType(r2);
        L7:
            return getItemViewType(r2);
        }

        protected final int getViewTypeCountInternal() {
            return getViewTypeCount() + getDividerTypeCount();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public View getDividerView(int r2, View r3, ViewGroup r4, TreeElement r5) {
            DividerViewLayout r6 = (DividerViewLayout) r3;
            DividerViewLayout r7 = r6;
            if (r6 != null) goto L5;
            r3 = new DividerViewLayout(getDividerViewLayoutContext(r4));
            r7 = r3;
        L5:
            int r1 = this.mDividerViewMode;
            if (r1 != 1) goto L9;
            r7.setBottomDividerVisible(0);
            r7.setBottomDividerMargin(8);
        L18:
            return r3;
        L9:
            if (r1 != 2) goto L12;
            r7.setBottomDividerVisible(8);
            r7.setBottomDividerMargin(0);
            goto L18
        L12:
            if (r1 != 3) goto L15;
            r7.setBottomDividerVisible(0);
            r7.setBottomDividerMargin(0);
            goto L18
        L15:
            if (r1 != 4) goto L17;
            r7.setBottomDividerVisible(0);
            r7.setBottomDividerMargin(0);
            r7.setTopDividerVisible(0);
            goto L18
        L17:
            r7.setBottomDividerVisible(8);
            r7.setBottomDividerMargin(8);
            goto L18
        }

        protected Context getDividerViewLayoutContext(ViewGroup r1) {
            return r1.getContext().getApplicationContext();
        }
    }

    public TreeViewWrapper(Context r2) {
        this.mTreeView = null;
        this.mContext = r2;
    }

    public boolean attachTreeView(TreeView r2) {
        if (this.mTreeView == null) goto L7;
        if (r2 != null) goto L7;
        return false;
    L7:
        this.mTreeView = r2;
        return true;
    }

    public TreeView getTreeView() {
        return this.mTreeView;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener r1) {
        this.mTreeView.setOnItemClickListener(r1);
    }

    public void setOnTreeItemClickListener(OnTreeItemClickListener r1) {
        this.mTreeView.setOnTreeItemClickListener(r1);
    }

    public void setVisibility(int r1) {
        this.mTreeView.setVisibility(r1);
    }

    public void setMaxDepth(int r1) {
        this.mTreeView.setMaxDepth(r1);
    }

    public void setAdapter(TreeViewAdapter r1) {
        this.mTreeView.setAdapter(r1);
    }

    public TreeElement getRootElement(boolean r1) {
        return this.mTreeView.getRootElement(r1);
    }

    public void resetAllElements() {
        this.mTreeView.refreshAllElements();
    }

    public TreeElement insertElementByData(Object r1, TreeElement r2) {
        return this.mTreeView.insertElementByData(r1, r2);
    }

    public TreeElement insertElementByData(Object r1, TreeElement r2, boolean r3) {
        return this.mTreeView.insertElementByData(r1, r2, r3);
    }

    public TreeElement insertElementByData(Object r1, TreeElement r2, boolean r3, boolean r4) {
        return this.mTreeView.insertElementByData(r1, r2, r3, r4);
    }

    public int deleteElement(TreeElement r1) {
        return this.mTreeView.deleteElement(r1);
    }

    public int deleteElementByData(Object r1) {
        return this.mTreeView.deleteElementByData(r1);
    }

    public int deleteElementByComparator(Comparator<TreeElement> r1) {
        return this.mTreeView.deleteElementByComparator(r1);
    }

    public List<TreeElement> findElementByComparator(Comparator<TreeElement> r1, boolean r2) {
        return this.mTreeView.findElementByComparator(r1, r2);
    }

    public boolean expandElement(TreeElement r1) {
        return this.mTreeView.expandElement(r1);
    }

    public boolean collapseElement(TreeElement r1) {
        return this.mTreeView.collapseElement(r1);
    }

    public int getTreeItemPosition(int r1) {
        return this.mTreeView.getTreeItemPosition(r1);
    }

    public void setClickItemEnableExpand(boolean r1) {
        this.mTreeView.setClickItemEnableExpand(r1);
    }

    public boolean isClickItemEnableExpand() {
        return this.mTreeView.isClickItemEnableExpand();
    }

    public void setScroll(boolean r1) {
        this.mTreeView.setScroll(r1);
    }

    public void setOnScrollListener(AbsListView.OnScrollListener r1) {
        this.mTreeView.setOnScrollListener(r1);
    }

    public void setHeaderCanCollapse(boolean r1) {
        this.mTreeView.setHeaderCanCollapse(r1);
    }

    public void setOnHeaderUpdateListener(OnHeaderUpdateListener r1) {
        this.mTreeView.setOnHeaderUpdateListener(r1);
    }

    public void requestRefreshHeader() {
        this.mTreeView.requestRefreshHeader();
    }
}

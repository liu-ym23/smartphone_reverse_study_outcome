package com.qihoo360.mobilesafe.common.ui.recyclerview;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
class CommonTreeProxyAdapter extends RecyclerView.Adapter<CommonTreeViewHolder> {
    private CommonTreeAdapter adapter;
    private List<CommonTreeNode> expandedNodeList;
    private CommonTreeView.OnTreeNodeListener listener;
    private Map<Object, CommonTreeNode> nodeMap;
    private CommonTreeNode root;
    private List<CommonTreeNode> visibleNodeList;

    static class CommonTreeViewHolder extends RecyclerView.ViewHolder {
        CommonTreeNode node;

        CommonTreeViewHolder(View r1) {
            super(r1);
        }
    }

    static /* synthetic */ CommonTreeView.OnTreeNodeListener access$000(CommonTreeProxyAdapter r0) {
        return r0.listener;
    }

    static /* synthetic */ void access$100(CommonTreeProxyAdapter r0, CommonTreeNode r1) {
        r0.toggleNode(r1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r1, int r2) {
        onBindViewHolder((CommonTreeViewHolder) r1, r2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r1, int r2) {
        return onCreateViewHolder(r1, r2);
    }

    CommonTreeProxyAdapter() {
        this.expandedNodeList = new ArrayList();
        this.visibleNodeList = new ArrayList();
        this.nodeMap = new HashMap();
        this.root = CommonTreeNode.obtainRoot();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public CommonTreeViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
        return new CommonTreeViewHolder(createView(r2, r3));
    }

    View createView(ViewGroup r1, int r2) {
        return this.adapter.onCreateView(r1, r2);
    }

    public void onBindViewHolder(CommonTreeViewHolder r3, int r4) {
        CommonTreeNode r5 = this.expandedNodeList.get(r4);
        if (r3.node == null) goto L5;
        this.visibleNodeList.remove(r3.node);
    L5:
        r3.node = r5;
        this.visibleNodeList.add(r3.node);
        bindView(r3.itemView, r5, r3.getItemViewType());
    }

    void bindView(final View r2, final CommonTreeNode r3, int r4) {
        this.adapter.onBindView(r2, r3, r4);
        r2.setOnClickListener(new AnonymousClass1(this, r2, r3));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.expandedNodeList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int r2) {
        return getItemViewType(this.expandedNodeList.get(r2));
    }

    int getItemViewType(CommonTreeNode r1) {
        return this.adapter.getItemViewType(r1);
    }

    void setRoot(CommonTreeNode r1) {
        this.root = r1;
        refreshTree();
    }

    void setAdapter(CommonTreeAdapter r1) {
        this.adapter = r1;
    }

    void setOnTreeNodeListener(CommonTreeView.OnTreeNodeListener r1) {
        this.listener = r1;
    }

    void refreshTree() {
        buildExpandedNodeList();
        notifyDataSetChanged();
    }

    void refreshNode(CommonTreeNode r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.isVisible() == true) goto L7;
        return;
    L7:
        if (this.visibleNodeList.contains(r2) == false) goto L13;
        int r3 = this.expandedNodeList.indexOf(r2);
        if (r3 == (-1)) goto L14;
        notifyItemChanged(r3);
        return;
    L14:
        return;
    }

    void refreshNodeByData(Object r1) {
        refreshNode(getNodeByData(r1));
    }

    void expandNode(CommonTreeNode r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        int r0 = this.expandedNodeList.indexOf(r4);
        if (r0 >= 0) goto L7;
        return;
    L7:
        if (r0 > (this.expandedNodeList.size() - 1)) goto L15;
        insertNodesAtIndex(r0 + 1, expandNodeWithoutRefresh(r4, false));
        notifyItemChanged(r0);
        CommonTreeView.OnTreeNodeListener r3 = this.listener;
        if (r3 == null) goto L14;
        r3.onTreeNodeExpand(r4);
        return;
    L14:
        return;
    }

    void expandNodeByData(Object r1) {
        expandNode(getNodeByData(r1));
    }

    void collapseNode(CommonTreeNode r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        int r0 = this.expandedNodeList.indexOf(r4);
        if (r0 >= 0) goto L7;
        return;
    L7:
        if (r0 > (this.expandedNodeList.size() - 1)) goto L15;
        removeNodesAtIndex(r0 + 1, collapseNodeWithoutRefresh(r4, false));
        notifyItemChanged(r0);
        CommonTreeView.OnTreeNodeListener r3 = this.listener;
        if (r3 == null) goto L14;
        r3.onTreeNodeCollapse(r4);
        return;
    L14:
        return;
    }

    void collapseNodeByData(Object r1) {
        collapseNode(getNodeByData(r1));
    }

    void addNode(CommonTreeNode r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        this.nodeMap.put(r4.getData(), r4);
        if (r4.isVisible() == false) goto L15;
        int r0 = r4.getParent().getChildren().size() - 1;
        if (r0 != 0) goto L11;
        int r1 = this.expandedNodeList.indexOf(r4.getParent());
        if (r1 == (-1)) goto L16;
        insertNodeAtIndex(r1 + 1, r4);
        return;
    L16:
        return;
    L11:
        int r2 = this.expandedNodeList.indexOf(r4.getParent().getChildren().get(r0 - 1).getLastVisibleDescendant());
        if (r2 == (-1)) goto L18;
        insertNodeAtIndex(r2 + 1, r4);
        return;
    L18:
        return;
    }

    void deleteNode(CommonTreeNode r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        collapseNode(r3);
        if (r3.isVisible() == false) goto L9;
        int r0 = this.expandedNodeList.indexOf(r3);
        if (r0 == (-1)) goto L9;
        removeNodeAtIndex(r0, r3);
    L9:
        r3.getParent().removeChild(r3);
        removeNodeInMap(r3);
    }

    void deleteNodeByData(Object r1) {
        deleteNode(getNodeByData(r1));
    }

    CommonTreeNode getNodeByData(Object r1) {
        return this.nodeMap.get(r1);
    }

    CommonTreeNode getNodeAtPosition(int r2) {
        if (r2 >= 0) goto L4;
        return null;
    L4:
        if (r2 < this.expandedNodeList.size()) goto L7;
        return null;
    L7:
        return this.expandedNodeList.get(r2);
    }

    private void buildExpandedNodeList() {
        this.expandedNodeList.clear();
        this.nodeMap.clear();
        Iterator<CommonTreeNode> r0 = this.root.getChildren().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        insertNodeWithoutRefresh(r0.next());
        goto L4
    }

    private void insertNodeWithoutRefresh(CommonTreeNode r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        this.expandedNodeList.add(r3);
        this.nodeMap.put(r3.getData(), r3);
        if (r3.hasChild() == true) goto L8;
        return;
    L8:
        if (r3.isExpanded() == false) goto L13;
        Iterator<CommonTreeNode> r4 = r3.getChildren().iterator();
    L11:
        if (r4.hasNext() == false) goto L17;
        insertNodeWithoutRefresh(r4.next());
        goto L11
    L17:
        return;
    L13:
        Iterator<CommonTreeNode> r5 = r3.getChildren().iterator();
    L15:
        if (r5.hasNext() == false) goto L20;
        insertNodeInMap(r5.next());
        goto L15
    }

    private void insertNodeInMap(CommonTreeNode r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        this.nodeMap.put(r3.getData(), r3);
        if (r3.getChildren().isEmpty() == false) goto L7;
        return;
    L7:
        Iterator<CommonTreeNode> r4 = r3.getChildren().iterator();
    L9:
        if (r4.hasNext() == false) goto L11;
        insertNodeInMap(r4.next());
        goto L9
    }

    private void insertNodeAtIndex(int r2, CommonTreeNode r3) {
        this.expandedNodeList.add(r2, r3);
        notifyItemInserted(r2);
    }

    private void insertNodesAtIndex(int r2, List<CommonTreeNode> r3) {
        this.expandedNodeList.addAll(r2, r3);
        notifyItemRangeInserted(r2, r3.size());
    }

    private void removeNodeAtIndex(int r2, CommonTreeNode r3) {
        this.expandedNodeList.remove(r3);
        notifyItemRemoved(r2);
    }

    private void removeNodesAtIndex(int r3, int r4) {
        this.expandedNodeList.subList(r3, r3 + r4).clear();
        notifyItemRangeRemoved(r3, r4);
    }

    private void removeNodeInMap(CommonTreeNode r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        this.nodeMap.remove(r3.getData());
        if (r3.getChildren().isEmpty() == false) goto L7;
        return;
    L7:
        Iterator<CommonTreeNode> r4 = r3.getChildren().iterator();
    L9:
        if (r4.hasNext() == false) goto L11;
        removeNodeInMap(r4.next());
        goto L9
    }

    private void toggleNode(CommonTreeNode r2) {
        if (r2 != null) goto L5;
        return;
    L5:
        if (r2.isExpanded() == false) goto L7;
        collapseNode(r2);
        return;
    L7:
        expandNode(r2);
    }

    private List<CommonTreeNode> expandNodeWithoutRefresh(CommonTreeNode r4, boolean r5) {
        ArrayList r0 = new ArrayList();
        r4.setExpanded(true);
        Iterator<CommonTreeNode> r6 = r4.getChildren().iterator();
    L4:
        if (r6.hasNext() == false) goto L10;
        CommonTreeNode r1 = r6.next();
        r0.add(r1);
        if (r5 == true) goto L9;
        if (r1.isExpanded() == false) goto L4;
    L9:
        r0.addAll(expandNodeWithoutRefresh(r1, r5));
        goto L4
    L10:
        return r0;
    }

    private int collapseNodeWithoutRefresh(CommonTreeNode r1, boolean r2) {
        int r0 = performCollapseNodeWithoutRefresh(r1, r2);
        r1.setExpanded(false);
        return r0;
    }

    private int performCollapseNodeWithoutRefresh(CommonTreeNode r4, boolean r5) {
        int r0 = 0;
        if (r5 == false) goto L5;
        r4.setExpanded(false);
    L5:
        Iterator<CommonTreeNode> r6 = r4.getChildren().iterator();
    L7:
        if (r6.hasNext() == false) goto L13;
        CommonTreeNode r1 = r6.next();
        r0 = r0 + 1;
        if (r1.isExpanded() == true) goto L10;
        if (r5 == false) goto L7;
        performCollapseNodeWithoutRefresh(r1, true);
        goto L7
    L10:
        r0 = r0 + performCollapseNodeWithoutRefresh(r1, r5);
        goto L7
    L13:
        return r0;
    }
}

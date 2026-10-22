package com.qihoo360.mobilesafe.common.ui.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes4.dex */
public class CommonTreeView extends RecyclerView {
    private CommonTreeProxyAdapter adapter;
    private CommonTreeViewStickyHeader stickyHeaderDecoration;

    public interface OnTreeNodeListener {
        boolean onTreeNodeClick(View r1, CommonTreeNode r2);

        void onTreeNodeCollapse(CommonTreeNode r1);

        void onTreeNodeExpand(CommonTreeNode r1);
    }

    public CommonTreeView(Context r2) {
        this(r2, null);
    }

    public CommonTreeView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public CommonTreeView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        CommonTreeProxyAdapter r4 = new CommonTreeProxyAdapter();
        this.adapter = r4;
        super.setAdapter(r4);
        setLayoutManager(new LinearLayoutManager(r1));
        RecyclerView.ItemAnimator r5 = new DefaultItemAnimator();
        r5.setChangeDuration(0);
        setItemAnimator(r5);
        setOverScrollMode(2);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter r1) {
        throw new RuntimeException("use setAdapter(CommonTreeAdapter) instead");
    }

    void setAdapter(CommonTreeAdapter r1) {
        this.adapter.setAdapter(r1);
    }

    void setRoot(CommonTreeNode r1) {
        this.adapter.setRoot(r1);
    }

    void setOnTreeNodeListener(OnTreeNodeListener r1) {
        this.adapter.setOnTreeNodeListener(r1);
    }

    void refreshTreeView() {
        this.adapter.refreshTree();
    }

    void refreshNode(CommonTreeNode r1) {
        this.adapter.refreshNode(r1);
    }

    void refreshNodeByData(Object r1) {
        this.adapter.refreshNodeByData(r1);
    }

    void expandNode(CommonTreeNode r1) {
        this.adapter.expandNode(r1);
    }

    void expandNodeByData(Object r1) {
        this.adapter.expandNodeByData(r1);
    }

    void collapseNode(CommonTreeNode r1) {
        this.adapter.collapseNode(r1);
    }

    void collapseNodeByData(Object r1) {
        this.adapter.collapseNodeByData(r1);
    }

    void addNode(CommonTreeNode r1) {
        this.adapter.addNode(r1);
    }

    void deleteNode(CommonTreeNode r1) {
        this.adapter.deleteNode(r1);
    }

    void deleteNodeByData(Object r1) {
        this.adapter.deleteNodeByData(r1);
    }

    void setStickyHeaderEnabled(boolean r2) {
        if (r2 == true) goto L4;
    L6:
        if (r2 == true) goto L12;
        RecyclerView.ItemDecoration r3 = this.stickyHeaderDecoration;
        if (r3 == null) goto L13;
        removeItemDecoration(r3);
        this.stickyHeaderDecoration = null;
        return;
    L13:
        return;
    L12:
        return;
    L4:
        if (this.stickyHeaderDecoration != null) goto L6;
        CommonTreeViewStickyHeader r4 = new CommonTreeViewStickyHeader(this);
        this.stickyHeaderDecoration = r4;
        addItemDecoration(r4);
    }

    CommonTreeNode getNodeByData(Object r1) {
        return this.adapter.getNodeByData(r1);
    }

    CommonTreeNode getNodeAtPosition(int r1) {
        return this.adapter.getNodeAtPosition(r1);
    }
}

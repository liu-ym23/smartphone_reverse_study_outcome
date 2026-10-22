package com.qihoo360.mobilesafe.common.ui.recyclerview;

/* JADX INFO: loaded from: classes4.dex */
public class CommonTreeViewHelper {
    private final CommonTreeView treeView;

    public CommonTreeViewHelper(CommonTreeView r1) {
        this.treeView = r1;
    }

    public void setAdapter(CommonTreeAdapter r1) {
        this.treeView.setAdapter(r1);
    }

    public void setRoot(CommonTreeNode r1) {
        this.treeView.setRoot(r1);
    }

    public void setOnTreeNodeListener(CommonTreeView.OnTreeNodeListener r1) {
        this.treeView.setOnTreeNodeListener(r1);
    }

    public void refreshTreeView() {
        this.treeView.refreshTreeView();
    }

    public void refreshNode(CommonTreeNode r1) {
        this.treeView.refreshNode(r1);
    }

    public void refreshNodeByData(Object r1) {
        this.treeView.refreshNodeByData(r1);
    }

    public void expandNode(CommonTreeNode r1) {
        this.treeView.expandNode(r1);
    }

    public void expandNodeByData(Object r1) {
        this.treeView.expandNodeByData(r1);
    }

    public void collapseNode(CommonTreeNode r1) {
        this.treeView.collapseNode(r1);
    }

    public void collapseNodeByData(Object r1) {
        this.treeView.collapseNodeByData(r1);
    }

    public void addNode(CommonTreeNode r1) {
        this.treeView.addNode(r1);
    }

    public void deleteNode(CommonTreeNode r1) {
        this.treeView.deleteNode(r1);
    }

    public void deleteNodeByData(Object r1) {
        this.treeView.deleteNodeByData(r1);
    }

    public void setStickyHeaderEnabled(boolean r1) {
        this.treeView.setStickyHeaderEnabled(r1);
    }

    public CommonTreeNode getNodeByData(Object r1) {
        return this.treeView.getNodeByData(r1);
    }

    public CommonTreeNode getNodeAtPosition(int r1) {
        return this.treeView.getNodeAtPosition(r1);
    }

    public CommonTreeView getTreeView() {
        return this.treeView;
    }
}

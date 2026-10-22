package com.qihoo360.mobilesafe.common.ui.recyclerview;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class CommonTreeNode {
    private List<CommonTreeNode> children;
    private Object data;
    private int depth;
    private boolean expanded;
    private CommonTreeNode parent;

    public static CommonTreeNode obtainRoot() {
        return new CommonTreeNode(null, null, true);
    }

    public CommonTreeNode(CommonTreeNode r2, Object r3, boolean r4) {
        this.parent = r2;
        this.children = new ArrayList();
        this.data = r3;
        if (r2 != null) goto L5;
        this.depth = 0;
    L6:
        this.expanded = r4;
        return;
    L5:
        r2.getChildren().add(this);
        this.depth = r2.depth + 1;
        goto L6
    }

    public CommonTreeNode getParent() {
        return this.parent;
    }

    public List<CommonTreeNode> getChildren() {
        return this.children;
    }

    public boolean hasChild() {
        if (this.children.size() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public Object getData() {
        return this.data;
    }

    public int getDepth() {
        return this.depth;
    }

    public boolean isExpanded() {
        return this.expanded;
    }

    public boolean isFirstChildOfParent() {
        CommonTreeNode r0 = this.parent;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.getChildren().get(0) != this) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean isLastChildOfParent() {
        CommonTreeNode r0 = this.parent;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.getChildren().get(this.parent.getChildren().size() - 1) != this) goto L7;
        return true;
    }

    void setExpanded(boolean r1) {
        this.expanded = r1;
    }

    void removeChild(CommonTreeNode r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (hasChild() == false) goto L9;
        this.children.remove(r2);
        return;
    }

    void removeAllChildren() {
        this.children.clear();
    }

    boolean isVisible() {
    L2:
        CommonTreeNode r0 = this.parent;
        if (r0 == null) goto L9;
        if (r0.isExpanded() == false) goto L6;
        CommonTreeNode this = this.parent;
        goto L2
    L6:
        return false;
    L9:
        return true;
    }

    CommonTreeNode getLastVisibleDescendant() {
        if (isExpanded() == true) goto L5;
        return this;
    L5:
        if (hasChild() == false) goto L10;
        List<CommonTreeNode> r1 = this.children;
        return r1.get(r1.size() - 1).getLastVisibleDescendant();
    L10:
        return this;
    }
}

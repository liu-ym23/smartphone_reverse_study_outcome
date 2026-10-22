package obric.tablet.navigationlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ViewHolder {
    public static final int TYPE_CHECKABLE_ITEM = 1;
    public static final int TYPE_COLLAPSIBLE_HEADER = 5;
    public static final int TYPE_COUNT = 6;
    public static final int TYPE_CUSTOM_ITEM = 2;
    public static final int TYPE_EMPTY_ITEM = 3;
    public static final int TYPE_ITEM = 0;
    public static final int TYPE_SIMPLE_HEADER = 4;
    protected Object mTag;

    public abstract void bindView(int r1, View r2);

    public boolean canAcceptDragEvent() {
        return false;
    }

    public boolean canDragged() {
        return false;
    }

    public abstract View createView(LayoutInflater r1, ViewGroup r2);

    public abstract int getId();

    public abstract int getType();

    public abstract void onItemClicked(View r1);

    public ViewHolder() {
    }

    public void setTag(Object r1) {
        this.mTag = r1;
    }

    public Object getTag() {
        return this.mTag;
    }
}

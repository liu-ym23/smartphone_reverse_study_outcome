package obric.widget.support;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class ListPopMenuStandardAdapter extends ArrayAdapter<IMenuItem> {
    public static final int STYLE_REMOVABLE = 2;
    public static final int STYLE_SELECTED = 1;
    private View.OnClickListener mCloseIconClickListener;
    private boolean mCloseIconVisible;
    private int mItemStyle;

    public ListPopMenuStandardAdapter(Context context, List<IMenuItem> objects) {
        super(context, 0, objects);
        this.mItemStyle = 1;
        this.mCloseIconVisible = true;
    }

    public ListPopMenuStandardAdapter(Context context, int resource, List<IMenuItem> objects) {
        super(context, resource, objects);
        this.mItemStyle = 1;
        this.mCloseIconVisible = true;
    }

    public ListPopMenuStandardAdapter(Context context, IMenuItem[] objects) {
        super(context, 0, objects);
        this.mItemStyle = 1;
        this.mCloseIconVisible = true;
    }

    public ListPopMenuStandardAdapter(Context context, int resource, IMenuItem[] objects) {
        super(context, resource, objects);
        this.mItemStyle = 1;
        this.mCloseIconVisible = true;
    }

    public void setMenuItemStyle(int style) {
        this.mItemStyle = style;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        if (this.mItemStyle != 2) goto L7;
        return getRemovableItemView(position, convertView, parent);
    L7:
        return getSelectedItemView(position, convertView, parent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private View getSelectedItemView(int r2, View r3, ViewGroup r4) {
        if (r3 != null) goto L4;
        r3 = new PopupMenuStandardListItem(getContext());
        PopupMenuStandardListItem r5 = r3;
    L5:
        r3.setEnabled(isEnabled(r2));
        IMenuItem r1 = getItem(r2);
        if (r1 != null) goto L8;
    L16:
        return r3;
    L8:
        if (r1.hasMenuIcon() == false) goto L10;
        r5.getIconView().setVisibility(0);
        r1.setMenuIcon(r5.getIconView());
    L11:
        r5.setChecked(r1.isSelected());
        r5.setMenuTitle(r1.getTitle());
        if ((r1 instanceof AbsMenuItem) == false) goto L16;
        String r6 = ((AbsMenuItem) r1).getSubtitle();
        if (r6 == null) goto L16;
        r5.setMenuSubtitle(r6);
        goto L16
    L10:
        r5.setMenuIcon(null);
        goto L11
    L4:
        r5 = (PopupMenuStandardListItem) r3;
        goto L5
    }

    private View getRemovableItemView(int position, View view, ViewGroup parent) {
        if (view != null) goto L4;
        PopupMenuRemovableListItem r5 = new PopupMenuRemovableListItem(getContext());
        View r6 = r5;
    L6:
        if (this.mCloseIconVisible == false) goto L8;
        r5.setCloseIconVisibility(0);
    L9:
        IMenuItem r4 = getItem(position);
        if (r4 != null) goto L12;
    L19:
        return r6;
    L12:
        if (r4.hasMenuIcon() == false) goto L14;
        r5.getIconView().setVisibility(0);
        r4.setMenuIcon(r5.getIconView());
    L15:
        View r0 = r5.getCloseIconView();
        if (r0 == null) goto L18;
        r0.setTag(r4);
    L18:
        r5.setMenuTitle(r4.getTitle());
        r5.setOnCloseIconClickListener(this.mCloseIconClickListener);
        goto L19
    L14:
        r5.setMenuIcon(null);
        goto L15
    L8:
        r5.setCloseIconVisibility(8);
        goto L9
    L4:
        r6 = view;
        r5 = (PopupMenuRemovableListItem) view;
        goto L6
    }

    public void setCloseIconClickListener(View.OnClickListener listener) {
        this.mCloseIconClickListener = listener;
    }

    public void setCloseIconVisible(boolean visible) {
        this.mCloseIconVisible = visible;
    }
}

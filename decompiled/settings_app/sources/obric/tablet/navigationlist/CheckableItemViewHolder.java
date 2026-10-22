package obric.tablet.navigationlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import com.android.settings.R;

/* JADX INFO: loaded from: classes5.dex */
public class CheckableItemViewHolder extends ItemViewHolder {
    public static final int STYLE_MULTI_CHOICE = 0;
    public static final int STYLE_SINGLE_CHOICE = 1;
    boolean mChecked;
    int mStyle;

    @Override // obric.tablet.navigationlist.ItemViewHolder, obric.tablet.navigationlist.ViewHolder
    public int getType() {
        return 1;
    }

    public CheckableItemViewHolder(int r1, int r2, int r3, boolean r4) {
        super(r1, r2, r3);
        this.mStyle = 0;
        this.mChecked = r4;
    }

    public CheckableItemViewHolder(int r1, String r2, int r3, boolean r4) {
        super(r1, r2, r3);
        this.mStyle = 0;
        this.mChecked = r4;
    }

    public void setCheckBoxStyle(int r1) {
        this.mStyle = r1;
    }

    public void setChecked(boolean r3) {
        this.mChecked = r3;
        if (this.mBindView != null) goto L5;
        return;
    L5:
        if (this.mBindView.getTag() != this) goto L16;
        CheckBox r4 = (CheckBox) this.mBindView.findViewById(R.id.right_icon);
        if (this.mStyle == 1) goto L9;
        r4.setChecked(this.mChecked);
        return;
    L9:
        if (this.mChecked == false) goto L11;
        int r2 = 0;
    L12:
        r4.setVisibility(r2);
        return;
    L11:
        r2 = 4;
        goto L12
    }

    @Override // obric.tablet.navigationlist.ItemViewHolder, obric.tablet.navigationlist.ViewHolder
    public void bindView(int r3, View r4) {
        bindCommonView(r3, r4);
        CheckBox r5 = (CheckBox) r4.findViewById(R.id.right_icon);
        int r1 = 0;
        if (this.mStyle != 1) goto L9;
        r5.setButtonDrawable(R.drawable.icon_check_confirm_rounded);
        if (this.mChecked == true) goto L8;
        r1 = 4;
    L8:
        r5.setVisibility(r1);
        return;
    L9:
        r5.setButtonDrawable(R.drawable.selector_check_box_mini);
        r5.setVisibility(0);
        r5.setChecked(this.mChecked);
    }

    @Override // obric.tablet.navigationlist.ItemViewHolder, obric.tablet.navigationlist.ViewHolder
    public View createView(LayoutInflater r2, ViewGroup r3) {
        return r2.inflate(R.layout.nav_checkable_list_item_layout, r3, false);
    }

    @Override // obric.tablet.navigationlist.ItemViewHolder, obric.tablet.navigationlist.ViewHolder
    public void onItemClicked(View r3) {
        this.mChecked = !this.mChecked;
        CheckBox r4 = (CheckBox) r3.findViewById(R.id.right_icon);
        if (this.mStyle != 1) goto L5;
        r4.setVisibility(0);
        return;
    L5:
        r4.setChecked(this.mChecked);
    }

    public boolean isChecked() {
        return this.mChecked;
    }
}

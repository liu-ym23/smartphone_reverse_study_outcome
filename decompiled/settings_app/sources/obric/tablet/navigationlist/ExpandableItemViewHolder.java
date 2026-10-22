package obric.tablet.navigationlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.android.settings.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public class ExpandableItemViewHolder extends ItemViewHolder {
    static int sLeftPaddingOffset;
    ImageView mArrowView;
    ArrayList<ViewHolder> mChildren;
    boolean mExpandable;
    boolean mExpanded;
    ImageView mIconView;
    int mLevel;

    static {
    }

    @Override // obric.tablet.navigationlist.ItemViewHolder, obric.tablet.navigationlist.ViewHolder
    public int getType() {
        return 2;
    }

    public ExpandableItemViewHolder(int r1, int r2, int r3, int r4, boolean r5) {
        super(r1, r2, r3);
        this.mLevel = r4;
        this.mExpandable = r5;
    }

    public ExpandableItemViewHolder(int r1, String r2, int r3, int r4, boolean r5) {
        super(r1, r2, r3);
        this.mLevel = r4;
        this.mExpandable = r5;
    }

    public void setState(boolean r1) {
        this.mExpanded = r1;
        if (r1 == true) goto L6;
        this.mChildren = null;
        return;
    }

    public void setChildren(ArrayList<ViewHolder> r1) {
        this.mChildren = r1;
    }

    public ArrayList<ViewHolder> getChildren() {
        return this.mChildren;
    }

    @Override // obric.tablet.navigationlist.ItemViewHolder, obric.tablet.navigationlist.ViewHolder
    public View createView(LayoutInflater r2, ViewGroup r3) {
        return r2.inflate(R.layout.nav_expandable_list_item_layout, r3, false);
    }

    @Override // obric.tablet.navigationlist.ItemViewHolder, obric.tablet.navigationlist.ViewHolder
    public void bindView(int r2, View r3) {
        bindCommonView(r2, r3);
        if (sLeftPaddingOffset != 0) goto L5;
        sLeftPaddingOffset = r3.getContext().getResources().getDimensionPixelSize(R.dimen.nav_list_expandable_offset);
    L5:
        int r4 = sLeftPaddingOffset * this.mLevel;
        int r0 = 0;
        r3.setPadding(r4, 0, 0, 0);
        this.mIconView = (ImageView) r3.findViewById(R.id.left_icon);
        ImageView r5 = (ImageView) r3.findViewById(R.id.arrow);
        this.mArrowView = r5;
        if (this.mExpanded == false) goto L8;
        r5.setImageResource(R.drawable.nav_item_expanded_selector);
    L9:
        ImageView r6 = this.mArrowView;
        if (this.mExpandable == true) goto L13;
        r0 = 4;
    L13:
        r6.setVisibility(r0);
        return;
    L8:
        r5.setImageResource(R.drawable.nav_item_folded_selector);
        goto L9
    }

    public int getLevel() {
        return this.mLevel;
    }

    public boolean isExpandable() {
        return this.mExpandable;
    }

    public boolean isExpanded() {
        return this.mExpanded;
    }

    public ImageView getArrowView() {
        return this.mArrowView;
    }

    public ImageView getIconView() {
        return this.mIconView;
    }
}

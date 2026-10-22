package obric.tablet.navigationlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.android.settings.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes5.dex */
public class HeaderViewHolder extends ViewHolder {
    ArrayList<ViewHolder> mChildren;
    int mId;
    boolean mIsSingleChoice;
    String mName;
    int mNameResId;
    protected boolean mShowChildren;

    @Override // obric.tablet.navigationlist.ViewHolder
    public int getType() {
        return 4;
    }

    @Override // obric.tablet.navigationlist.ViewHolder
    public void onItemClicked(View r1) {
    }

    public HeaderViewHolder(String r2) {
        this.mShowChildren = true;
        this.mName = r2;
    }

    public HeaderViewHolder(int r2) {
        this.mShowChildren = true;
        this.mNameResId = r2;
    }

    public void setChildren(ArrayList<ViewHolder> r1) {
        this.mChildren = r1;
    }

    public ArrayList<ViewHolder> getChildren() {
        return this.mChildren;
    }

    public int getChildrenCount() {
        return this.mChildren.size();
    }

    public void setIsSingleChoice(boolean r1) {
        this.mIsSingleChoice = r1;
    }

    @Override // obric.tablet.navigationlist.ViewHolder
    public void bindView(int r2, View r3) {
        TextView r4 = (TextView) r3.findViewById(R.id.text);
        int r0 = this.mNameResId;
        if (r0 <= 0) goto L5;
        r4.setText(r0);
    L6:
        r3.findViewById(R.id.arrow).setVisibility(8);
        return;
    L5:
        r4.setText(this.mName);
        goto L6
    }

    @Override // obric.tablet.navigationlist.ViewHolder
    public View createView(LayoutInflater r2, ViewGroup r3) {
        View r1 = r2.inflate(R.layout.nav_collapsible_header, r3, false);
        r1.findViewById(R.id.arrow).setVisibility(8);
        return r1;
    }

    @Override // obric.tablet.navigationlist.ViewHolder
    public int getId() {
        return this.mId;
    }

    public boolean isShowChildren() {
        return this.mShowChildren;
    }
}

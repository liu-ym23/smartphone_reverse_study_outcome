package obric.tablet.navigationlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.settings.R;

/* JADX INFO: loaded from: classes5.dex */
public class CollapsibleHeaderViewHolder extends HeaderViewHolder {
    @Override // obric.tablet.navigationlist.HeaderViewHolder, obric.tablet.navigationlist.ViewHolder
    public int getType() {
        return 5;
    }

    public CollapsibleHeaderViewHolder(String r1) {
        super(r1);
    }

    public CollapsibleHeaderViewHolder(int r1) {
        super(r1);
    }

    @Override // obric.tablet.navigationlist.HeaderViewHolder, obric.tablet.navigationlist.ViewHolder
    public void bindView(int r3, View r4) {
        r4.findViewById(R.id.arrow).setVisibility(0);
        TextView r0 = (TextView) r4.findViewById(R.id.text);
        if (this.mNameResId <= 0) goto L5;
        r0.setText(this.mNameResId);
    L6:
        ImageView r5 = (ImageView) r4.findViewById(R.id.arrow);
        if (this.mShowChildren == false) goto L9;
        r5.setImageResource(R.drawable.nav_group_fold);
        return;
    L9:
        r5.setImageResource(R.drawable.nav_group_expand);
        return;
    L5:
        r0.setText(this.mName);
        goto L6
    }

    @Override // obric.tablet.navigationlist.HeaderViewHolder, obric.tablet.navigationlist.ViewHolder
    public View createView(LayoutInflater r2, ViewGroup r3) {
        return r2.inflate(R.layout.nav_collapsible_header, r3, false);
    }

    @Override // obric.tablet.navigationlist.HeaderViewHolder, obric.tablet.navigationlist.ViewHolder
    public void onItemClicked(View r2) {
        this.mShowChildren = !this.mShowChildren;
        ImageView r3 = (ImageView) r2.findViewById(R.id.arrow);
        if (this.mShowChildren == false) goto L5;
        r3.setImageResource(R.drawable.nav_group_fold);
        return;
    L5:
        r3.setImageResource(R.drawable.nav_group_expand);
    }
}

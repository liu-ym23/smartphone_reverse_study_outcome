package com.obric.oui.simplified;

import android.content.Context;
import android.util.AttributeSet;
import com.android.settings.R;
import com.obric.oui.layout.OUIRelativeLayout;

/* JADX INFO: loaded from: classes5.dex */
public class ORoundedListItemFooter extends OUIRelativeLayout {
    public ORoundedListItemFooter(Context r2) {
        super(r2);
        init(r2, null);
    }

    public ORoundedListItemFooter(Context r1, AttributeSet r2) {
        super(r1, r2);
        init(r1, r2);
    }

    void init(Context r2, AttributeSet r3) {
        inflate(r2, R.layout.app_management_list_hidden_packages_view, this);
        setRadius(getResources().getDimensionPixelSize(R.dimen.dimen_16));
        setBackgroundColor(r2.getColor(R.color.oui_fill_list_item_card));
    }

    @Override // com.obric.oui.layout.OUIRelativeLayout, android.view.View
    public void setSelected(boolean r2) {
        super.setSelected(r2);
        getAlphaHelper().onSelectedChanged(this, r2);
    }
}

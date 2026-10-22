package com.android.setupwizardlib;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListAdapter;
import com.android.setupwizardlib.items.ItemAdapter;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class SetupWizardItemsLayout extends SetupWizardListLayout {
    @Override // com.android.setupwizardlib.SetupWizardListLayout
    public /* bridge */ /* synthetic */ ListAdapter getAdapter() {
        return getAdapter();
    }

    public SetupWizardItemsLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
    }

    public SetupWizardItemsLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
    }

    @Override // com.android.setupwizardlib.SetupWizardListLayout
    public ItemAdapter getAdapter() {
        ListAdapter r1 = super.getAdapter();
        if ((r1 instanceof ItemAdapter) == true) goto L5;
        return null;
    L5:
        return (ItemAdapter) r1;
    }
}

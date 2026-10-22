package com.android.settings.wifi.p2p;

import android.net.wifi.p2p.WifiP2pGroup;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.obric.oui.lisitem.OCardListItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class WifiP2pPersistentGroupAdapter extends BaseAdapter {
    private List<WifiP2pGroup> mPersistentGroups;

    @Override // android.widget.Adapter
    public long getItemId(int r1) {
        return r1;
    }

    public WifiP2pPersistentGroupAdapter() {
        this.mPersistentGroups = new ArrayList();
    }

    @Override // android.widget.Adapter
    public /* bridge */ /* synthetic */ Object getItem(int r1) {
        return getItem(r1);
    }

    public void clearData() {
        this.mPersistentGroups.clear();
        notifyDataSetChanged();
    }

    public void setData(Collection<WifiP2pGroup> r1) {
        clearData();
        addData(r1);
    }

    public void addData(Collection<WifiP2pGroup> r2) {
        this.mPersistentGroups.addAll(r2);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.mPersistentGroups.size();
    }

    @Override // android.widget.Adapter
    public WifiP2pGroup getItem(int r1) {
        return this.mPersistentGroups.get(r1);
    }

    @Override // android.widget.Adapter
    public View getView(int r4, View r5, ViewGroup r6) {
        int r0 = 1;
        if (r5 != null) goto L5;
    L7:
        OCardListItem r7 = new OCardListItem(r6.getContext());
        r7.setShowCardBg(true);
        r7.setCardType(0);
        OCardListItem r8 = r7;
    L8:
        WifiP2pGroup r9 = getItem(r4);
        if (r9 == null) goto L11;
        r8.setTitle(r9.getNetworkName());
        r8.showTitle(true);
    L11:
        r8.showIcon(false);
        r8.showSubTitle(false);
        r8.showTailIcon(false);
        r8.showCustomEnd(false);
        if (getCount() != 1) goto L14;
        r0 = 0;
    L20:
        r8.setCardPosition(r0);
        return r8;
    L14:
        if (r4 == 0) goto L20;
        if (r4 != (getCount() - 1)) goto L19;
        r0 = 3;
        goto L20
    L19:
        r0 = 2;
        goto L20
    L5:
        if ((r5 instanceof OCardListItem) == false) goto L7;
        r8 = (OCardListItem) r5;
        goto L8
    }
}

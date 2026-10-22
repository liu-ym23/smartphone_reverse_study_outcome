package com.android.settings.wifi.p2p;

import android.net.wifi.p2p.WifiP2pDevice;
import androidx.preference.Preference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class WifiP2pSettinsAdapter {
    private OnItemClickListener mListener;
    private List<WifiP2pDevice> mWifiP2pDevices;

    interface OnItemClickListener {
        boolean onPreferenceTreeClick(Preference r1);
    }

    public WifiP2pSettinsAdapter(OnItemClickListener r2) {
        this.mWifiP2pDevices = new ArrayList();
        this.mListener = r2;
    }

    public void clearData() {
        this.mWifiP2pDevices.clear();
    }

    public void setData(Collection<WifiP2pDevice> r1) {
        clearData();
        addData(r1);
    }

    public void addData(Collection<WifiP2pDevice> r1) {
        this.mWifiP2pDevices.addAll(r1);
    }

    public int getCount() {
        return this.mWifiP2pDevices.size();
    }

    public WifiP2pDevice getItem(int r1) {
        return this.mWifiP2pDevices.get(r1);
    }
}

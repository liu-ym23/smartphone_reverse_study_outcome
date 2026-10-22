package com.obric.cae.libs.wifi.basicInfo;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.obric.cae.libs.utils.LogUtil;
import com.obric.cae.libs.utils.WifiUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ScanResultBean {
    public final WifiManager a;
    public List<ScanResult> b;
    public WifiInfo c;
    public String d;
    public boolean e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public final Context k;

    public ScanResultBean(Context r2, WifiManager r3) {
        this.i = Integer.MIN_VALUE;
        this.j = Integer.MIN_VALUE;
        this.k = r2;
        this.a = r3;
        if (r3.isWifiEnabled() == false) goto L5;
        r3.startScan();
    L5:
        update();
    }

    public int getBandwidth() {
        int r7 = this.f;
        if (r7 != 4) goto L5;
    L19:
        double r3 = Math.pow(2.0d, r7 - 1);
    L18:
        return (int) (r3 * 20.0d);
    L5:
        if (r7 == 5) goto L19;
        if (r7 == 0) goto L16;
        if (r7 == 1) goto L16;
        if (r7 == 2) goto L16;
        if (r7 == 3) goto L16;
        return -1;
    L16:
        r3 = Math.pow(2.0d, r7);
        goto L18
    }

    public int getCurrentChannelUsedCount() {
        if (this.e == false) goto L5;
        int r0 = this.i;
        int r1 = this.j;
        if (r0 >= r1) goto L10;
        return r0;
    L10:
        return r1;
    L5:
        return this.i;
    }

    public List<ScanResult> getLastScanResults() {
        return this.b;
    }

    public boolean startScan() {
        WifiManager r0 = this.a;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.startScan();
    }

    public void update() {
        this.b = WifiUtils.getWifiScanResults(this.k, this.a);
        WifiInfo r0 = this.a.getConnectionInfo();
        this.c = r0;
        if (this.b == null) goto L31;
        if (r0 == null) goto L42;
        this.d = r0.getBSSID();
        this.g = this.c.getFrequency();
        Iterator<ScanResult> r1 = this.b.iterator();
    L8:
        if (r1.hasNext() == false) goto L17;
        ScanResult r2 = r1.next();
        if (r2.BSSID.equals(this.d) == false) goto L8;
        this.f = r2.channelWidth;
        if (LogUtil.isLoggable(3) == false) goto L15;
        LogUtil.d("ScanResultBean", "match bssid!, channelWidth:" + this.f);
    L15:
        if (this.f != 4) goto L17;
        this.e = true;
        this.g = r2.centerFreq0;
        this.h = r2.centerFreq1;
    L17:
        this.i = 0;
        if (this.e == false) goto L20;
        this.j = 0;
    L20:
        Iterator<ScanResult> r3 = this.b.iterator();
    L22:
        if (r3.hasNext() == false) goto L43;
        int r4 = r3.next().frequency;
        if (r4 != this.g) goto L27;
        this.i++;
    L27:
        if (this.e == false) goto L22;
        if (r4 != this.h) goto L22;
        this.j++;
        goto L22
    L43:
        return;
    L42:
        return;
    }

    public ScanResultBean(List<ScanResult> r2, WifiInfo r3) {
        this.i = Integer.MIN_VALUE;
        this.j = Integer.MIN_VALUE;
        this.b = r2;
        this.c = r3;
    }
}

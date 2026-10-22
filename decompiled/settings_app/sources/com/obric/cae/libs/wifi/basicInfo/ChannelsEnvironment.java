package com.obric.cae.libs.wifi.basicInfo;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import com.obric.cae.libs.utils.WifiUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class ChannelsEnvironment {
    public static final int BAND_24_GHZ_END_FREQ_MHZ = 2484;
    public static final int BAND_24_GHZ_FIRST_CH_NUM = 1;
    public static final int BAND_24_GHZ_LAST_CH_NUM = 14;
    public static final int BAND_24_GHZ_START_FREQ_MHZ = 2412;
    public static final int BAND_5_GHZ_END_FREQ_MHZ = 5865;
    public static final int BAND_5_GHZ_FIRST_CH_NUM = 32;
    public static final int BAND_5_GHZ_LAST_CH_NUM = 173;
    public static final int BAND_5_GHZ_START_FREQ_MHZ = 5160;
    public static final int BAND_6_GHZ_END_FREQ_MHZ = 7105;
    public static final int BAND_6_GHZ_FIRST_CH_NUM = 1;
    public static final int BAND_6_GHZ_LAST_CH_NUM = 233;
    public static final int BAND_6_GHZ_START_FREQ_MHZ = 5945;
    public static final int UNSPECIFIED = -1;
    public final Context a;
    public final WifiManager b;
    public final HashMap<Integer, a> c;

    public class a {
        public int a;
        public int b;

        public a(int r2) {
            this.a = 1;
            this.b = r2;
        }
    }

    public ChannelsEnvironment(Context r1, WifiManager r2) {
        this.a = r1;
        this.b = r2;
        this.c = new HashMap();
        update();
    }

    public final void a(int r3) {
        if (this.c.containsKey(Integer.valueOf(r3)) == false) goto L5;
        this.c.put(Integer.valueOf(r3), new a(0));
        return;
    L5:
        a r2 = this.c.get(Integer.valueOf(r3));
        if (r2 == null) goto L10;
        r2.a++;
        return;
    }

    public final void b(int r3) {
        if (this.c.containsKey(Integer.valueOf(r3)) == true) goto L5;
        this.c.put(Integer.valueOf(r3), new a(1));
        return;
    L5:
        a r2 = this.c.get(Integer.valueOf(r3));
        r2.a++;
        r2.b++;
    }

    public int getCenterChannelUsedNum(int r1, int r2) {
        int r3 = WifiUtils.convertChannelToFrequencyMhz(r1, r2);
        a r0 = this.c.get(Integer.valueOf(r3));
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.b;
    }

    public int getChannelOverlapNum(int r1, int r2) {
        int r3 = WifiUtils.convertChannelToFrequencyMhz(r1, r2);
        a r0 = this.c.get(Integer.valueOf(r3));
        if (r0 != null) goto L5;
        return 0;
    L5:
        return r0.a;
    }

    public void update() {
        List<ScanResult> r0 = WifiUtils.getWifiScanResults(this.a, this.b);
        if (r0 != null) goto L5;
        return;
    L5:
        Iterator<ScanResult> r1 = r0.iterator();
    L7:
        if (r1.hasNext() == false) goto L37;
        ScanResult r2 = r1.next();
        if (WifiUtils.is24GHz(r2.frequency) == true) goto L10;
        if (WifiUtils.is6GHz(r2.frequency) == true) goto L7;
        int r3 = r2.channelWidth;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L34;
        if (r3 == 2) goto L34;
        if (r3 == 3) goto L34;
        if (r3 != 4) goto L7;
        b(r2.centerFreq0);
        b(r2.centerFreq1);
        int r4 = r2.centerFreq0 - 80;
    L28:
        if (r4 > (r2.centerFreq0 + 80)) goto L30;
        a(r4);
        r4 = r4 + 10;
        goto L28
    L30:
        int r5 = r2.centerFreq1 - 80;
    L32:
        if (r5 > (r2.centerFreq1 + 80)) goto L7;
        a(r5);
        r5 = r5 + 10;
    L34:
        b(r2.centerFreq0);
        int r6 = r2.centerFreq0;
        int r7 = r6 - 60;
        int r8 = r6 + 60;
    L35:
        if (r7 > r8) goto L7;
        a(r7);
        r7 = r7 + 10;
        goto L35
    L16:
        b(r2.frequency);
        a(r2.frequency - 10);
        a(r2.frequency + 10);
        goto L7
    L10:
        b(r2.frequency);
        a(r2.frequency - 5);
        a(r2.frequency - 10);
        a(r2.frequency + 5);
        a(r2.frequency + 10);
        goto L7
    }
}

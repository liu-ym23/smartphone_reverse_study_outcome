package com.bytedance.ttnet.tnc;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class TNCConfig {
    public String httpCodeBlack;
    public boolean localEnable;
    public Map<String, Integer> localHostFilterList;
    public int probeCmd;
    public boolean probeEnable;
    public long probeVersion;
    public int reqErrApiCnt;
    public int reqErrCnt;
    public int reqErrIpCnt;
    public int reqToApiCnt;
    public int reqToCnt;
    public int reqToIpCnt;
    public int updateInterval;
    public int updateRandomRange;

    public TNCConfig() {
        this.localEnable = false;
        this.probeEnable = true;
        this.localHostFilterList = null;
        this.reqToCnt = 10;
        this.reqToApiCnt = 3;
        this.reqToIpCnt = 3;
        this.reqErrCnt = 10;
        this.reqErrApiCnt = 3;
        this.reqErrIpCnt = 3;
        this.updateInterval = TypedValues.Custom.TYPE_INT;
        this.updateRandomRange = 120;
        this.httpCodeBlack = null;
        this.probeCmd = 0;
        this.probeVersion = 0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder(" localEnable: ");
        r0.append(this.localEnable);
        r0.append(" probeEnable: ");
        r0.append(this.probeEnable);
        r0.append(" hostFilter: ");
        Map<String, Integer> r1 = this.localHostFilterList;
        if (r1 == null) goto L5;
        int r2 = r1.size();
    L6:
        r0.append(r2);
        r0.append(" reqTo: ");
        r0.append(this.reqToCnt);
        r0.append("#");
        r0.append(this.reqToApiCnt);
        r0.append("#");
        r0.append(this.reqToIpCnt);
        r0.append(" reqErr: ");
        r0.append(this.reqErrCnt);
        r0.append("#");
        r0.append(this.reqErrApiCnt);
        r0.append("#");
        r0.append(this.reqErrIpCnt);
        r0.append(" updateInterval: ");
        r0.append(this.updateInterval);
        r0.append(" updateRandom: ");
        r0.append(this.updateRandomRange);
        r0.append(" httpBlack: ");
        r0.append(this.httpCodeBlack);
        return r0.toString();
    L5:
        r2 = 0;
        goto L6
    }
}

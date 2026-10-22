package com.bytedance.ttnet.tnc;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
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
        this.updateInterval = 900;
        this.updateRandomRange = 120;
        this.httpCodeBlack = null;
        this.probeCmd = 0;
        this.probeVersion = 0;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder(" localEnable: ");
        r0.append(this.localEnable);
        r0.append(" probeEnable: ").append(this.probeEnable);
        StringBuilder r1 = r0.append(" hostFilter: ");
        Map<String, Integer> r2 = this.localHostFilterList;
        if (r2 == null) goto L5;
        int r3 = r2.size();
    L6:
        r1.append(r3);
        r0.append(" reqTo: ").append(this.reqToCnt).append("#").append(this.reqToApiCnt).append("#").append(this.reqToIpCnt);
        r0.append(" reqErr: ").append(this.reqErrCnt).append("#").append(this.reqErrApiCnt).append("#").append(this.reqErrIpCnt);
        r0.append(" updateInterval: ").append(this.updateInterval);
        r0.append(" updateRandom: ").append(this.updateRandomRange);
        r0.append(" httpBlack: ").append(this.httpCodeBlack);
        return r0.toString();
    L5:
        r3 = 0;
        goto L6
    }
}

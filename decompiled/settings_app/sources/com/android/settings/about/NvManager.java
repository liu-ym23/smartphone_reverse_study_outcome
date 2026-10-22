package com.android.settings.about;

import com.bytedance.custcfg_mgr.CustcfgMgr;
import com.obric.olog.OLog;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes2.dex */
public class NvManager {
    private static final int ID_BSN = 1;
    private static final int ID_EID = 6;
    private static final int ID_FLAG = 2;
    private static final int ID_PSN = 5;
    private static volatile NvManager INSTANCE;
    private CustcfgMgr mCustcfgMgr;

    private NvManager() {
        this.mCustcfgMgr = new CustcfgMgr();
    }

    public static NvManager getInstance() {
        if (INSTANCE != null) goto L15;
        monitor-enter(NvManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (INSTANCE != null) goto L9;
        INSTANCE = new NvManager();     // Catch: Throwable -> L11
    L9:
        monitor-exit(NvManager.class);     // Catch: Throwable -> L11
    L15:
        return INSTANCE;
    }

    public String readBSN() {
        return readFactoryData(1);
    }

    public String readPSN() {
        return readFactoryData(5);
    }

    public String readEID() {
        return readFactoryData(6);
    }

    public static String bytesToHex(byte[] r6) {
        StringBuilder r0 = new StringBuilder();
        int r1 = r6.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L6;
        r0.append(String.format("%02X", new Object[]{Byte.valueOf(r6[r3])}));
        r3 = r3 + 1;
        goto L3
    L6:
        return r0.toString();
    }

    public byte[] readFactoryFlag() {
        byte[] r0 = this.mCustcfgMgr.ReadNv(2);
        if (r0 != null) goto L6;
        return null;
    L6:
        new String(r0, StandardCharsets.UTF_8);
        log("readFactoryFlag str:" + bytesToHex(r0));
        return r0;
    }

    public String readFactoryData(int r4) {
        byte[] r0 = this.mCustcfgMgr.ReadNv(r4);
        if (r0 != null) goto L6;
        return "";
    L6:
        String r1 = new String(r0, StandardCharsets.UTF_8);
        log("readFactoryData id:" + r4 + ", value:" + r1);
        return r1;
    }

    public int writeFactoryData(int r4, String r5) {
        int r0 = this.mCustcfgMgr.WriteNv(r4, r5.getBytes());
        log("writeFactoryData id:" + r4 + ", value:" + r5 + ",status:" + r0);
        return r0;
    }

    public int eraseFactoryData(int r4) {
        int r0 = this.mCustcfgMgr.EraseNv(r4);
        log("eraseFactoryData id:" + r4 + ",status:" + r0);
        return r0;
    }

    private void log(String r1) {
        OLog.i("NvManager", r1);
    }
}

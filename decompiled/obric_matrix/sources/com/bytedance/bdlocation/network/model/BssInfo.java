package com.bytedance.bdlocation.network.model;

import com.bytedance.common.wschannel.WsConstants;
import com.google.gson.y.c;

/* JADX INFO: loaded from: classes.dex */
public class BssInfo {

    @c("bid")
    public int bid;

    @c("bsss")
    public long bsss;

    @c("bw")
    public int bw;

    @c("ci")
    public int ci;

    @c("cid")
    public long cid;

    @c("cpid")
    public int cpid;

    @c("earfcn")
    public int earfcn;

    @c("is_registered")
    public boolean isRegistered;

    @c("lac")
    public long lac;

    @c("lat")
    public int lat;

    @c("longi")
    public int longi;

    @c("mcc")
    public long mcc;

    @c("mnc")
    public long mnc;

    @c("nci")
    public long nci;

    @c("nid")
    public int nid;

    @c("pci")
    public int pci;

    @c("psc")
    public long psc;

    @c("radio_type")
    public String radioType;

    @c("rssi")
    public long rssi;

    @c(WsConstants.KEY_SESSION_ID)
    public int sid;

    @c("tac")
    public int tac;

    @c("timestamp")
    public long timestamp;

    public BssInfo() {
    }
}

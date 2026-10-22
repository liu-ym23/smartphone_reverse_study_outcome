package com.qualcomm.qti.internal.nrNetworkService.hidl;

import org.codeaurora.internal.BearerAllocationStatus;
import org.codeaurora.internal.DcParam;
import org.codeaurora.internal.NrConfig;
import org.codeaurora.internal.NrConfigType;
import org.codeaurora.internal.NrIconType;
import org.codeaurora.internal.SignalStrength;
import org.codeaurora.internal.Status;
import org.codeaurora.internal.Token;
import org.codeaurora.internal.UpperLayerIndInfo;

/* JADX INFO: loaded from: classes4.dex */
public interface IHidlConnectionCallback {
    void on5gConfigInfo(int r1, Token r2, Status r3, NrConfigType r4);

    void on5gStatus(int r1, Token r2, Status r3, boolean r4);

    void onAnyNrBearerAllocation(int r1, Token r2, Status r3, BearerAllocationStatus r4);

    void onEnableEndc(int r1, Token r2, Status r3);

    void onEndcStatus(int r1, Token r2, Status r3, boolean r4);

    void onNrConfigStatus(int r1, Token r2, Status r3, NrConfig r4);

    void onNrDcParam(int r1, Token r2, Status r3, DcParam r4);

    void onNrIconType(int r1, Token r2, Status r3, NrIconType r4);

    void onSignalStrength(int r1, Token r2, Status r3, SignalStrength r4);

    void onUpperLayerIndInfo(int r1, Token r2, Status r3, UpperLayerIndInfo r4);

    void setNrConfigStatus(int r1, Token r2, Status r3);
}

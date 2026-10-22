package com.qualcomm.qti.internal.nrNetworkService.hidl;

import android.os.RemoteException;
import org.codeaurora.internal.NrConfig;
import org.codeaurora.internal.Token;

/* JADX INFO: loaded from: classes4.dex */
public interface IHidlConnectionInterface {
    void disable5g(int r1, Token r2) throws RemoteException;

    void enable5g(int r1, Token r2) throws RemoteException;

    void enable5gOnly(int r1, Token r2) throws RemoteException;

    void enableEndc(int r1, boolean r2, Token r3) throws RemoteException;

    Token generateNextToken();

    void query5gConfigInfo(int r1, Token r2) throws RemoteException;

    void query5gStatus(int r1, Token r2) throws RemoteException;

    void queryEndcStatus(int r1, Token r2) throws RemoteException;

    void queryNrBearerAllocation(int r1, Token r2) throws RemoteException;

    void queryNrConfig(int r1, Token r2) throws RemoteException;

    void queryNrDcParam(int r1, Token r2) throws RemoteException;

    void queryNrIconType(int r1, Token r2) throws RemoteException;

    void queryNrSignalStrength(int r1, Token r2) throws RemoteException;

    void queryUpperLayerIndInfo(int r1, Token r2) throws RemoteException;

    void registerCallback(IHidlConnectionCallback r1);

    void setNrConfig(int r1, NrConfig r2, Token r3) throws RemoteException;

    void unRegisterCallback(IHidlConnectionCallback r1);
}

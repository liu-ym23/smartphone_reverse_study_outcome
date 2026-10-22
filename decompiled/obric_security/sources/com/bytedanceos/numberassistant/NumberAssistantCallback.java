package com.bytedanceos.numberassistant;

import android.os.RemoteException;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class NumberAssistantCallback extends INumberAssistantCallback.Stub {
    @Override // com.bytedanceos.numberassistant.INumberAssistantCallback
    public void executeBaseInfo(List<NumberBaseInfo> baseInfoList) throws RemoteException {
    }

    @Override // com.bytedanceos.numberassistant.INumberAssistantCallback
    public void executeLogoInfo(List<NumberLogoInfo> logoInfoList) throws RemoteException {
    }

    @Override // com.bytedanceos.numberassistant.INumberAssistantCallback
    public void executeMarkInfo(List<NumberMarkInfo> markInfoList) throws RemoteException {
    }

    @Override // com.bytedanceos.numberassistant.INumberAssistantCallback
    public void executeUploadMarkInfo(boolean success) throws RemoteException {
    }

    public NumberAssistantCallback() {
    }
}

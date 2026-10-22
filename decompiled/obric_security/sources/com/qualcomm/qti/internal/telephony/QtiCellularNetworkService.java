package com.qualcomm.qti.internal.telephony;

import android.telephony.NetworkRegistrationInfo;
import android.util.Log;
import com.android.internal.telephony.CellularNetworkService;

/* JADX INFO: loaded from: classes4.dex */
public class QtiCellularNetworkService extends CellularNetworkService {
    private static final String TAG = "QtiCellularNetworkService";
    protected QtiCellularNetworkProvider mProvider;
    private int mSlotId;

    private class QtiCellularNetworkProvider extends CellularNetworkService.CellularNetworkServiceProvider {
        final /* synthetic */ QtiCellularNetworkService this$0;

        public QtiCellularNetworkProvider(QtiCellularNetworkService r2, int r3) {
            this.this$0 = r2;
            super(r2, r3, false);
        }

        protected NetworkRegistrationInfo getRegistrationStateFromResult(Object r2, int r3) {
            NetworkRegistrationInfo r1 = super.getRegistrationStateFromResult(r2, r3);
            Log.d(QtiCellularNetworkService.TAG, "Domain: " + r3 + ", NRI: " + r1);
            return r1;
        }
    }

    public QtiCellularNetworkService(int r1) {
        this.mSlotId = r1;
    }

    private QtiCellularNetworkProvider getCellularNetworkServiceProvider() {
        if (this.mProvider != null) goto L6;
        Log.d(TAG, "Initiate cellular network service provider for slotId: " + this.mSlotId);
        this.mProvider = new QtiCellularNetworkProvider(this, this.mSlotId);
    L6:
        return this.mProvider;
    }

    NetworkRegistrationInfo getRegistrationStateFromResult(Object r3, int r4) {
        Log.d(TAG, "getRegistrationStateFromResult, domain: " + r4);
        QtiCellularNetworkProvider r2 = getCellularNetworkServiceProvider();
        if (r2 != null) goto L6;
        return null;
    L6:
        return r2.getRegistrationStateFromResult(r3, r4);
    }
}

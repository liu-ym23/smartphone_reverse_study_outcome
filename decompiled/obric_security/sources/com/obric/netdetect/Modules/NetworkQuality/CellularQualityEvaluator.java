package com.obric.netdetect.Modules.NetworkQuality;

import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoNr;
import android.telephony.CellInfoTdscdma;
import android.telephony.CellInfoWcdma;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthNr;
import android.telephony.CellSignalStrengthTdscdma;
import android.telephony.TelephonyManager;
import com.obric.netdetect.Modules.DnsProbe.DnsResolverService$$ExternalSyntheticLambda0;
import com.obric.netdetect.Utils.NetDetectLog;
import com.ttnet.org.chromium.net.NetError;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class CellularQualityEvaluator {
    private static final String TAG = "CellularQualityEvaluator";
    private final CellularQualityListener mListener;
    private int[] mRsrpLteThresholds;
    private int[] mRsrpNrThresholds;
    private final TelephonyManager mTelephonyManager;

    public interface CellularQualityListener {
        void onCellularQualityReceived(int r1, int r2, int r3, int r4, int r5, int r6, int r7);
    }

    static /* synthetic */ void access$000(CellularQualityEvaluator r0, List r1) {
        r0.getCellSignalInfo(r1);
    }

    public CellularQualityEvaluator(TelephonyManager r3, CellularQualityListener r4) {
        this.mRsrpNrThresholds = new int[]{NetError.ERR_SSL_CLIENT_AUTH_CERT_NO_PRIVATE_KEY, NetError.ERR_SSL_DECOMPRESSION_FAILURE_ALERT, NetError.ERR_PROXY_AUTH_UNSUPPORTED, NetError.ERR_NAME_NOT_RESOLVED};
        this.mRsrpLteThresholds = new int[]{-128, NetError.ERR_CONNECTION_TIMED_OUT, NetError.ERR_ADDRESS_INVALID, -98};
        this.mTelephonyManager = r3;
        this.mListener = r4;
    }

    public void start() {
        this.mTelephonyManager.requestCellInfoUpdate(new DnsResolverService$$ExternalSyntheticLambda0(), new AnonymousClass1(this));
    }

    private void getCellSignalInfo(List<CellInfo> r12) {
        Iterator<CellInfo> r13 = r12.iterator();
    L4:
        if (r13.hasNext() == false) goto L28;
        CellInfo r0 = r13.next();
        if (r0.isRegistered() == false) goto L4;
        if ((r0 instanceof CellInfoNr) == false) goto L13;
        CellSignalStrengthNr r14 = (CellSignalStrengthNr) ((CellInfoNr) r0).getCellSignalStrength();
        int r1 = r14.getSsRsrp();
        int r2 = r14.getSsRsrq();
        int r15 = r14.getSsSinr();
        int r3 = updateLevelWithMeasure(r1, this.mRsrpNrThresholds);
        int r4 = 6;
        int r10 = r15;
        int r8 = r1;
        int r6 = 0;
        int r7 = 0;
        int r9 = r2;
    L11:
        int r5 = r4;
        int r11 = r3;
    L29:
        NetDetectLog.d(TAG, "onCellInfo: level=" + r11 + ", type=" + r5 + ", rssi=" + r6 + ", rscp=" + r7 + ", rsrp=" + r8 + ", rsrq=" + r9 + ", sinr=" + r10);
        this.mListener.onCellularQualityReceived(r11, r5, r6, r7, r8, r9, r10);
        return;
    L13:
        if ((r0 instanceof CellInfoLte) == false) goto L16;
        CellSignalStrengthLte r16 = ((CellInfoLte) r0).getCellSignalStrength();
        int r17 = r16.getDbm();
        int r18 = r16.getRsrp();
        int r19 = r16.getRssnr();
        r3 = updateLevelWithMeasure(r18, this.mRsrpLteThresholds);
        r4 = 3;
        r10 = r19;
        r6 = r17;
        r7 = 0;
        r9 = 0;
        r8 = r18;
        goto L11
    L16:
        if ((r0 instanceof CellInfoWcdma) == false) goto L20;
        r7 = ((CellInfoWcdma) r0).getCellSignalStrength().getDbm();
        r5 = 4;
        r6 = 0;
        r8 = 0;
    L18:
        r9 = r8;
        r10 = r9;
        r11 = 1;
        goto L29
    L20:
        if ((r0 instanceof CellInfoTdscdma) == false) goto L23;
        CellSignalStrengthTdscdma r110 = ((CellInfoTdscdma) r0).getCellSignalStrength();
        int r20 = r110.getDbm();
        r7 = r110.getRscp();
        r6 = r20;
        r8 = 0;
        r9 = 0;
        r10 = 0;
        r11 = 1;
        r5 = 5;
        goto L29
    L23:
        if ((r0 instanceof CellInfoCdma) == false) goto L26;
        r6 = ((CellInfoCdma) r0).getCellSignalStrength().getDbm();
        r5 = 2;
        r7 = 0;
        r8 = 0;
        goto L18
    L26:
        if ((r0 instanceof CellInfoGsm) == false) goto L28;
        r6 = ((CellInfoGsm) r0).getCellSignalStrength().getDbm();
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r10 = 0;
        r11 = 1;
        r5 = 1;
    L28:
        r11 = 0;
        r5 = 0;
        r6 = 0;
        r7 = 0;
        r8 = 0;
        r9 = 0;
        r10 = 0;
        goto L29
    }

    private int updateLevelWithMeasure(int r4, int[] r5) {
        if (r4 == Integer.MAX_VALUE) goto L21;
        int r3 = 3;
        if (r4 < r5[3]) goto L9;
        return 4;
    L9:
        if (r4 >= r5[2]) goto L18;
        r3 = 1;
        if (r4 < r5[1]) goto L15;
        return 2;
    L15:
        if (r4 >= r5[0]) goto L18;
        return 0;
    L18:
        return r3;
    L21:
        return 0;
    }
}

package com.obric.netdetect.Modules.NetworkInfo;

import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityNr;
import android.telephony.CellIdentityTdscdma;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoNr;
import android.telephony.CellInfoTdscdma;
import android.telephony.CellInfoWcdma;
import android.telephony.CellSignalStrengthCdma;
import android.telephony.CellSignalStrengthGsm;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthNr;
import android.telephony.CellSignalStrengthTdscdma;
import android.telephony.CellSignalStrengthWcdma;
import android.telephony.TelephonyManager;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class CellularNetworkProvider {
    private static final String TAG = "CellularNetworkProvider";
    private final IpInfoProvider mIpInfoProvider;
    private final LinkInfoProvider mLinkInfoProvider;
    private final CellularNetworkListener mListener;
    private final TelephonyManager mTelephonyManager;

    public interface CellularNetworkListener {
        void onCellularNetworkInfoReceived(NetworkInfoResult.CellularInfo r1, NetworkInfoResult.LinkInfo r2, NetworkInfoResult.IpInfo r3);
    }

    public CellularNetworkProvider(TelephonyManager r1, IpInfoProvider r2, LinkInfoProvider r3, CellularNetworkListener r4) {
        this.mTelephonyManager = r1;
        this.mListener = r4;
        this.mIpInfoProvider = r2;
        this.mLinkInfoProvider = r3;
    }

    public void start() {
        NetworkInfoResult.CellularInfo r0 = getCellularInfo();
        NetworkInfoResult.LinkInfo r1 = this.mLinkInfoProvider.getLinkInfo();
        this.mListener.onCellularNetworkInfoReceived(r0, r1, null);
    }

    private NetworkInfoResult.CellularInfo getCellularInfo() {
        int[] r1 = new int[0];
        Iterator<CellInfo> r2 = this.mTelephonyManager.getAllCellInfo().iterator();
    L4:
        if (r2.hasNext() == false) goto L27;
        CellInfo r3 = r2.next();
        if (r3.isRegistered() == false) goto L4;
        if ((r3 instanceof CellInfoNr) == false) goto L12;
        CellInfoNr r4 = (CellInfoNr) r3;
        CellSignalStrengthNr r5 = (CellSignalStrengthNr) r4.getCellSignalStrength();
        CellIdentityNr r6 = (CellIdentityNr) r4.getCellIdentity();
        int r7 = r5.getLevel();
        int r8 = r5.getSsRsrp();
        int r9 = r5.getSsRsrq();
        int r10 = r5.getSsSinr();
        long r11 = r6.getNci();
        int r12 = r6.getTac();
        int r13 = r6.getNrarfcn();
        int r15 = 0;
        int r16 = 0;
        int r18 = 0;
        int r20 = 0;
        int r21 = 0;
        int r24 = r10;
        int r22 = r8;
        int r23 = r9;
        long r14 = r11;
        int r17 = r12;
        int r19 = r13;
        r1 = r6.getBands();
        int r25 = 6;
        String r110 = r6.getMccString();
        int r111 = r7;
    L30:
        return new NetworkInfoResult.CellularInfo(r25, r111, r110, r14, r17, r15, r16, r19, r18, r1, r20, r21, r22, r23, r24);
    L12:
        if ((r3 instanceof CellInfoLte) == false) goto L15;
        CellInfoLte r26 = (CellInfoLte) r3;
        CellSignalStrengthLte r27 = r26.getCellSignalStrength();
        CellIdentityLte r28 = r26.getCellIdentity();
        int r29 = r27.getLevel();
        int r30 = r27.getDbm();
        int r31 = r27.getRsrp();
        int r32 = r27.getRssnr();
        long r33 = r28.getCi();
        int r34 = r28.getTac();
        int r35 = r28.getEarfcn();
        int r112 = r28.getBandwidth();
        r110 = r28.getMccString();
        r15 = 0;
        r16 = 0;
        r21 = 0;
        r23 = 0;
        r24 = r32;
        r1 = r28.getBands();
        r20 = r30;
        r22 = r31;
        r17 = r34;
        r19 = r35;
        r18 = r112;
        r25 = 3;
        r111 = r29;
    L28:
        r14 = r33;
        goto L30
    L15:
        if ((r3 instanceof CellInfoWcdma) == false) goto L19;
        CellInfoWcdma r36 = (CellInfoWcdma) r3;
        CellSignalStrengthWcdma r37 = r36.getCellSignalStrength();
        CellIdentityWcdma r38 = r36.getCellIdentity();
        int r39 = r37.getLevel();
        int r40 = r37.getDbm();
        long r41 = r38.getCid();
        int r42 = r38.getUarfcn();
        String r43 = r38.getMccString();
        int r44 = r38.getLac();
        r25 = 4;
        r15 = 0;
        r16 = 0;
        r18 = 0;
        r20 = 0;
        r22 = 0;
        r23 = 0;
        r24 = 0;
        r21 = r40;
    L17:
        r17 = r44;
        r111 = r39;
        r19 = r42;
        r14 = r41;
        r110 = r43;
        goto L30
    L19:
        if ((r3 instanceof CellInfoTdscdma) == false) goto L22;
        CellInfoTdscdma r45 = (CellInfoTdscdma) r3;
        CellSignalStrengthTdscdma r46 = r45.getCellSignalStrength();
        CellIdentityTdscdma r47 = r45.getCellIdentity();
        int r48 = r46.getLevel();
        int r49 = r46.getDbm();
        int r50 = r46.getRscp();
        long r51 = r47.getCid();
        int r52 = r47.getUarfcn();
        String r53 = r47.getMccString();
        r15 = 0;
        r16 = 0;
        r18 = 0;
        r22 = 0;
        r23 = 0;
        r24 = 0;
        r1 = r1;
        r21 = r50;
        r17 = r47.getLac();
        r20 = r49;
        r14 = r51;
        r19 = r52;
        r110 = r53;
        r25 = 5;
        r111 = r48;
        goto L30
    L22:
        if ((r3 instanceof CellInfoCdma) == false) goto L25;
        CellInfoCdma r54 = (CellInfoCdma) r3;
        CellSignalStrengthCdma r55 = r54.getCellSignalStrength();
        CellIdentityCdma r56 = r54.getCellIdentity();
        int r57 = r55.getLevel();
        int r58 = r55.getDbm();
        long r59 = r56.getBasestationId();
        int r60 = r56.getLatitude();
        r25 = 2;
        r17 = 0;
        r19 = 0;
        r18 = 0;
        r21 = 0;
        r22 = 0;
        r23 = 0;
        r24 = 0;
        r1 = r1;
        r20 = r58;
        r15 = r56.getLongitude();
        r110 = null;
        r111 = r57;
        r14 = r59;
        r16 = r60;
        goto L30
    L25:
        if ((r3 instanceof CellInfoGsm) == false) goto L27;
        CellInfoGsm r61 = (CellInfoGsm) r3;
        CellSignalStrengthGsm r62 = r61.getCellSignalStrength();
        CellIdentityGsm r63 = r61.getCellIdentity();
        r39 = r62.getLevel();
        int r64 = r62.getDbm();
        r41 = r63.getCid();
        r42 = r63.getArfcn();
        r43 = r63.getMccString();
        r44 = r63.getLac();
        r25 = 1;
        r15 = 0;
        r16 = 0;
        r18 = 0;
        r21 = 0;
        r22 = 0;
        r23 = 0;
        r24 = 0;
        r20 = r64;
    L27:
        r33 = 0;
        r25 = 0;
        r111 = 0;
        r17 = 0;
        r15 = 0;
        r16 = 0;
        r19 = 0;
        r18 = 0;
        r20 = 0;
        r21 = 0;
        r22 = 0;
        r23 = 0;
        r24 = 0;
        r1 = r1;
        r110 = null;
        goto L28
    }
}

package com.bytedance.bdlocation.utils.cell;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
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
import android.telephony.CellLocation;
import android.telephony.CellSignalStrengthCdma;
import android.telephony.CellSignalStrengthGsm;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthNr;
import android.telephony.CellSignalStrengthTdscdma;
import android.telephony.CellSignalStrengthWcdma;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.network.model.BaseStation;
import com.bytedance.bdlocation.network.model.BssInfo;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import com.ttnet.org.chromium.base.TimeUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class BaseStationHelper {
    private final TelephonyManager mTelephonyManager;

    public BaseStationHelper(Context r2) {
        this.mTelephonyManager = (TelephonyManager) r2.getSystemService("phone");
    }

    @RequiresApi(api = 17)
    private void addCellInfo(BssInfo r7, CellInfo r8, int r9, int r10, Object r11) {
        int r6 = Build.VERSION.SDK_INT;
        if (r7 == null) goto L7;
        if (r8 == null) goto L7;
        r7.timestamp = ((System.currentTimeMillis() - SystemClock.elapsedRealtime()) + (r8.getTimeStamp() / TimeUtils.NANOSECONDS_PER_MILLISECOND)) / 1000;
        r7.isRegistered = r8.isRegistered();
    L7:
        if ((r8 instanceof CellInfoGsm) == false) goto L13;
        CellInfoGsm r12 = (CellInfoGsm) r8;
        CellIdentityGsm r13 = r12.getCellIdentity();
        CellSignalStrengthGsm r14 = r12.getCellSignalStrength();
        r7.radioType = LocationInfoConst.GSM;
        r7.lac = r13.getLac();
        r7.cid = r13.getCid();
        r7.psc = r13.getPsc();
        r7.bsss = r14.getDbm();
        r7.mcc = doCheckAndReturnBackup(r13.getMcc(), r9);
        int r15 = r13.getMnc();
    L9:
        int r16 = doCheckAndReturnBackup(r15, r10);
    L10:
        long r17 = r16;
    L11:
        r7.mnc = r17;
        return;
    L13:
        if ((r8 instanceof CellInfoCdma) == false) goto L16;
        CellInfoCdma r18 = (CellInfoCdma) r8;
        CellIdentityCdma r19 = r18.getCellIdentity();
        CellSignalStrengthCdma r20 = r18.getCellSignalStrength();
        r7.radioType = LocationInfoConst.CDMA;
        r7.bid = r19.getBasestationId();
        r7.lat = r19.getLatitude();
        r7.longi = r19.getLongitude();
        r7.nid = r19.getNetworkId();
        r7.sid = r19.getSystemId();
        r7.bsss = r20.getDbm();
        r7.mcc = r9;
        r17 = r10;
        goto L11
    L16:
        if ((r8 instanceof CellInfoLte) == false) goto L25;
        CellInfoLte r21 = (CellInfoLte) r8;
        CellIdentityLte r0 = r21.getCellIdentity();
        CellSignalStrengthLte r22 = r21.getCellSignalStrength();
        if (r6 < 28) goto L20;
        r7.bw = r0.getBandwidth();
    L20:
        r7.ci = r0.getCi();
        if (r6 < 24) goto L23;
        r7.earfcn = r0.getEarfcn();
    L23:
        r7.radioType = LocationInfoConst.LTE;
        r7.pci = r0.getPci();
        r7.tac = BDLocationExtrasService.getBPEAManager().getTac(r0, r11);
        r7.bsss = r22.getDbm();
        r7.mcc = doCheckAndReturnBackup(r0.getMcc(), r9);
        r15 = r0.getMnc();
        goto L9
    L25:
        if (r6 < 18) goto L30;
        if ((r8 instanceof CellInfoWcdma) == false) goto L30;
        CellInfoWcdma r23 = (CellInfoWcdma) r8;
        CellIdentityWcdma r24 = r23.getCellIdentity();
        CellSignalStrengthWcdma r25 = r23.getCellSignalStrength();
        r7.radioType = LocationInfoConst.WCDMA;
        r7.cid = r24.getCid();
        r7.lac = r24.getLac();
        r7.psc = r24.getPsc();
        r7.bsss = r25.getDbm();
        r7.mcc = doCheckAndReturnBackup(r24.getMcc(), r9);
        r15 = r24.getMnc();
    L30:
        if (r6 >= 29) goto L32;
    L42:
        if (r6 >= 29) goto L44;
        return;
    L44:
        if ((r8 instanceof CellInfoTdscdma) == false) goto L55;
        CellInfoTdscdma r26 = (CellInfoTdscdma) r8;
        CellSignalStrengthTdscdma r27 = r26.getCellSignalStrength();
        if (r27 == null) goto L48;
        r7.bsss = r27.getDbm();
    L48:
        CellIdentityTdscdma r28 = r26.getCellIdentity();
        r7.radioType = LocationInfoConst.WCDMA;
        r7.lac = r28.getLac();
        r7.cid = r28.getCid();
        r7.cpid = r28.getCpid();
        r7.mcc = doCheckAndReturnBackup(r28.getMccString(), r9);
        r16 = doCheckAndReturnBackup(r28.getMncString(), r10);
        goto L10
    L55:
        return;
    L32:
        if ((r8 instanceof CellInfoNr) == false) goto L42;
        CellInfoNr r29 = (CellInfoNr) r8;     // Catch: Exception -> L40
        CellSignalStrengthNr r30 = (CellSignalStrengthNr) r29.getCellSignalStrength();     // Catch: Exception -> L40
        if (r30 == null) goto L36;
        r7.bsss = r30.getSsRsrp();     // Catch: Exception -> L40
    L36:
        CellIdentityNr r31 = (CellIdentityNr) r29.getCellIdentity();     // Catch: Exception -> L40
        if (r31 == null) goto L52;
        r7.radioType = LocationInfoConst.NR;     // Catch: Exception -> L40
        r7.tac = r31.getTac();     // Catch: Exception -> L40
        r7.pci = r31.getPci();     // Catch: Exception -> L40
        r7.nci = r31.getNci();     // Catch: Exception -> L40
        r7.mcc = doCheckAndReturnBackup(r31.getMccString(), r9);     // Catch: Exception -> L40
        r7.mnc = doCheckAndReturnBackup(r31.getMncString(), r10);     // Catch: Exception -> L40
        return;
    L52:
        return;
    L40:
        e = move-exception;
        Logger.i("CellInfoNr error:" + e.toString());
    }

    private void addCurrentCellInfo(BaseStation r3, CellLocation r4, Object r5) {
        if ((r4 instanceof GsmCellLocation) == false) goto L6;
        GsmCellLocation r6 = (GsmCellLocation) r4;
        BssInfo r2 = r3.current;
        r2.radioType = LocationInfoConst.GSM;
        r2.cid = BDLocationExtrasService.getBPEAManager().getCid(r6, r5);
        r3.current.lac = BDLocationExtrasService.getBPEAManager().getLac(r6, r5);
        r3.current.psc = BDLocationExtrasService.getBPEAManager().getPsc(r6, r5);
        return;
    L6:
        if ((r4 instanceof CdmaCellLocation) == false) goto L10;
        CdmaCellLocation r7 = (CdmaCellLocation) r4;
        BssInfo r8 = r3.current;
        r8.radioType = LocationInfoConst.CDMA;
        r8.bid = BDLocationExtrasService.getBPEAManager().getBaseStationId(r7, r5);
        r3.current.lat = BDLocationExtrasService.getBPEAManager().getBaseStationLatitude(r7, r5);
        r3.current.longi = BDLocationExtrasService.getBPEAManager().getBaseStationLongitude(r7, r5);
        r3.current.nid = BDLocationExtrasService.getBPEAManager().getNetworkId(r7, r5);
        r3.current.sid = BDLocationExtrasService.getBPEAManager().getSystemId(r7, r5);
        return;
    }

    private static int doCheckAndReturnBackup(int r1, int r2) {
        if (r1 != Integer.MAX_VALUE) goto L5;
        return r2;
    L5:
        return r1;
    }

    private static int doCheckAndReturnBackup(String r1, int r2) {
        if (TextUtils.isEmpty(r1) == false) goto L8;
        return r2;
    L8:
        return Integer.parseInt(r1);
    L7:
        return r2;
    }

    public static int[] getMccMncPair(String r3) {
        if (TextUtils.isEmpty(r3) == false) goto L5;
        return null;
    L5:
        if (r3.length() > 3) goto L12;
        return null;
    L12:
        return new int[]{Integer.parseInt(r3.substring(0, 3)), Integer.parseInt(r3.substring(3))};
    L15:
        return null;
    }

    public BaseStation getBaseStation(Object r13) {
        BaseStation r0 = new BaseStation();
        TelephonyManager r1 = this.mTelephonyManager;
        if (r1 == null) goto L25;
        int r4 = Integer.MAX_VALUE;
        int[] r2 = getMccMncPair(r1.getNetworkOperator());     // Catch: Exception -> L11
        if (r2 == null) goto L10;
        int r5 = r2[0];     // Catch: Exception -> L11
        int r3 = r2[1];     // Catch: Exception -> L26
    L13:
        r4 = r5;
    L14:
        r0.current = new BssInfo();
        r0.neighboring = new ArrayList();
        if (Build.VERSION.SDK_INT < 17) goto L24;
        List<CellInfo> r6 = CellInfoUtil.getAllCellInfo(this.mTelephonyManager, r13, true);
        if (r6 == null) goto L25;
        if (r6.isEmpty() == true) goto L25;
        addCellInfo(r0.current, r6.get(0), r4, r3, r13);
        Iterator<CellInfo> r7 = r6.iterator();
    L22:
        if (r7.hasNext() == false) goto L25;
        CellInfo r8 = r7.next();
        BssInfo r9 = new BssInfo();
        addCellInfo(r9, r8, r4, r3, r13);
        r0.neighboring.add(r9);
        goto L22
    L24:
        addCurrentCellInfo(r0, CellInfoUtil.getCellLocation(this.mTelephonyManager, r13), r13);
    L12:
        r3 = Integer.MAX_VALUE;
        goto L13
    L10:
        r3 = Integer.MAX_VALUE;
    L11:
        r5 = Integer.MAX_VALUE;
    L25:
        return r0;
    }

    public BaseStation getCurrentStation(Object r12) {
        BaseStation r0 = new BaseStation();
        TelephonyManager r1 = this.mTelephonyManager;
        if (r1 == null) goto L32;
        int r3 = Integer.MAX_VALUE;
        int[] r2 = getMccMncPair(r1.getNetworkOperator());     // Catch: Exception -> L13
        if (r2 == null) goto L11;
        int r4 = r2[0];     // Catch: Exception -> L13
        int r5 = r2[1];     // Catch: Exception -> L34
        r3 = r4;
    L12:
        int r9 = r5;
        int r8 = r3;
    L16:
        if (Build.VERSION.SDK_INT < 17) goto L30;
        List<CellInfo> r6 = CellInfoUtil.getAllCellInfo(this.mTelephonyManager, r12, false);
        if (r6 != null) goto L20;
        return null;
    L20:
        if (r6.isEmpty() == true) goto L46;
        Iterator<CellInfo> r7 = r6.iterator();
    L23:
        if (r7.hasNext() == false) goto L47;
        CellInfo r10 = r7.next();
        if (r10 == null) goto L23;
        if (r10.isRegistered() == false) goto L23;
        BssInfo r11 = new BssInfo();
        r0.current = r11;
        addCellInfo(r11, r10, r8, r9, r12);
        return r0;
    L47:
        return null;
    L46:
        return null;
    L30:
        addCurrentCellInfo(r0, CellInfoUtil.getCellLocation(this.mTelephonyManager, r12), r12);
        return r0;
    L14:
        r9 = Integer.MAX_VALUE;
        r8 = r4;
        goto L16
    L11:
        r5 = Integer.MAX_VALUE;
    L13:
        r4 = Integer.MAX_VALUE;
        goto L14
    L32:
        return null;
    }
}

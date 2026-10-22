package com.qualcomm.qti.internal.telephony.data;

import android.telephony.data.EpsQos;
import android.telephony.data.Qos;
import android.telephony.data.QosBearerFilter;
import android.telephony.data.QosBearerSession;
import android.util.Log;
import com.qti.extphone.NrQos;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class QosParametersUtils {
    public static final int QOS_TYPE_EPS = 1;
    public static final int QOS_TYPE_NR = 2;
    public static final String TAG = "QosParametersUtils";

    public QosParametersUtils() {
    }

    public static Qos convertToFrameworkQos(com.qti.extphone.Qos r9) {
        Qos r0 = null;
        if (r9 != null) goto L6;
        Log.e(TAG, "convertToFrameworkQos, sourceQos is null");
        return null;
    L6:
        Qos.QosBandwidth r3 = new Qos.QosBandwidth(r9.getDownlinkBandwidth().getMaxBitrateKbps(), r9.getDownlinkBandwidth().getGuaranteedBitrateKbps());
        Qos.QosBandwidth r4 = new Qos.QosBandwidth(r9.getUplinkBandwidth().getMaxBitrateKbps(), r9.getUplinkBandwidth().getGuaranteedBitrateKbps());
        int r2 = r9.getType();
        if (r2 != 1) goto L9;
        r0 = new EpsQos(r3, r4, ((com.qti.extphone.EpsQos) r9).getQci());
    L13:
        Log.d(TAG, "convertToFrameworkQos: source: " + r9 + ", target: " + r0);
        return r0;
    L9:
        if (r2 == 2) goto L11;
        Log.d(TAG, "convertToFrameworkQos, unknown QoS type: " + r9.getType());
        goto L13
    L11:
        NrQos r1 = (NrQos) r9;
        r0 = new android.telephony.data.NrQos(r3, r4, r1.getQfi(), r1.get5Qi(), r1.getAveragingWindow());
        goto L13
    }

    public static QosBearerFilter convertToFrameworkQosBearerFilter(com.qti.extphone.QosBearerFilter r18) {
        QosBearerFilter.PortRange r0 = null;
        if (r18 != null) goto L6;
        Log.e(TAG, "convertToFrameworkQosBearerFilter, sourceQosFilter is null");
        return null;
    L6:
        com.qti.extphone.QosBearerFilter.PortRange r1 = r18.getLocalPortRange();
        com.qti.extphone.QosBearerFilter.PortRange r2 = r18.getRemotePortRange();
        if (r1 == null) goto L9;
        QosBearerFilter.PortRange r8 = new QosBearerFilter.PortRange(r1.getStart(), r1.getEnd());
    L10:
        if (r2 == null) goto L13;
        r0 = new QosBearerFilter.PortRange(r2.getStart(), r2.getEnd());
    L13:
        return new QosBearerFilter(r18.getLocalAddresses(), r18.getRemoteAddresses(), r8, r0, r18.getProtocol(), r18.getTypeOfServiceMask(), r18.getFlowLabel(), r18.getSpi(), r18.getDirection(), r18.getPrecedence());
    L9:
        r8 = null;
        goto L10
    }

    public static List<QosBearerFilter> convertToFrameworkQosFilterList(List<com.qti.extphone.QosBearerFilter> r2) {
        ArrayList r0 = new ArrayList();
        if (r2 != null) goto L5;
        return r0;
    L5:
        Iterator<com.qti.extphone.QosBearerFilter> r3 = r2.iterator();
    L7:
        if (r3.hasNext() == false) goto L11;
        QosBearerFilter r1 = convertToFrameworkQosBearerFilter(r3.next());
        if (r1 == null) goto L7;
        r0.add(r1);
        goto L7
    L11:
        return r0;
    }

    public static QosBearerSession convertToFrameworkQosBearerSession(com.qti.extphone.QosBearerSession r3) {
        if (r3 != null) goto L6;
        return null;
    L6:
        return new QosBearerSession(r3.getQosBearerSessionId(), convertToFrameworkQos(r3.getQos()), convertToFrameworkQosFilterList(r3.getQosBearerFilterList()));
    }

    public static List<QosBearerSession> convertToFrameworkQosBearerSessionsList(List<com.qti.extphone.QosBearerSession> r2) {
        ArrayList r0 = new ArrayList();
        if (r2 != null) goto L5;
        return r0;
    L5:
        Iterator<com.qti.extphone.QosBearerSession> r3 = r2.iterator();
    L7:
        if (r3.hasNext() == false) goto L11;
        QosBearerSession r1 = convertToFrameworkQosBearerSession(r3.next());
        if (r1 == null) goto L7;
        r0.add(r1);
        goto L7
    L11:
        return r0;
    }
}

package com.qualcomm.qti.internal.telephony.data;

import android.telephony.data.Qos;
import android.telephony.data.QosBearerSession;
import com.qti.extphone.QosParametersResult;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class FrameworkQosParameters {
    Qos mDefaultQos;
    List<QosBearerSession> mQosBearerSessions;

    public FrameworkQosParameters() {
        this.mDefaultQos = null;
        this.mQosBearerSessions = new ArrayList();
    }

    public FrameworkQosParameters(QosParametersResult r2) {
        this.mDefaultQos = QosParametersUtils.convertToFrameworkQos(r2.getDefaultQos());
        this.mQosBearerSessions = QosParametersUtils.convertToFrameworkQosBearerSessionsList(r2.getQosBearerSessions());
    }

    public FrameworkQosParameters(Qos r1, List<QosBearerSession> r2) {
        this.mDefaultQos = r1;
        this.mQosBearerSessions = r2;
    }

    public Qos getDefaultQos() {
        return this.mDefaultQos;
    }

    public List<QosBearerSession> getQosBearerSessions() {
        return this.mQosBearerSessions;
    }

    public String toString() {
        StringBuffer r0 = new StringBuffer("FrameworkQosParameters: { defaultQos=");
        r0.append(this.mDefaultQos).append(" qosBearerSessions=").append(this.mQosBearerSessions).append("}");
        return r0.toString();
    }
}

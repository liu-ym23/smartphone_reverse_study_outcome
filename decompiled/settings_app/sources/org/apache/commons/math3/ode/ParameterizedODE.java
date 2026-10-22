package org.apache.commons.math3.ode;

/* JADX INFO: loaded from: classes6.dex */
public interface ParameterizedODE extends Parameterizable {
    double getParameter(String r1) throws UnknownParameterException;

    void setParameter(String r1, double r2) throws UnknownParameterException;
}

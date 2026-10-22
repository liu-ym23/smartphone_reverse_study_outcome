package org.apache.commons.math3.ode.sampling;

import java.io.Externalizable;
import org.apache.commons.math3.exception.MaxCountExceededException;

/* JADX INFO: loaded from: classes6.dex */
public interface StepInterpolator extends Externalizable {
    StepInterpolator copy() throws MaxCountExceededException;

    double getCurrentTime();

    double[] getInterpolatedDerivatives() throws MaxCountExceededException;

    double[] getInterpolatedSecondaryDerivatives(int r1) throws MaxCountExceededException;

    double[] getInterpolatedSecondaryState(int r1) throws MaxCountExceededException;

    double[] getInterpolatedState() throws MaxCountExceededException;

    double getInterpolatedTime();

    double getPreviousTime();

    boolean isForward();

    void setInterpolatedTime(double r1);
}

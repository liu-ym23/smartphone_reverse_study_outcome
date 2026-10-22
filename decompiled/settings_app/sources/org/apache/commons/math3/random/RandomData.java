package org.apache.commons.math3.random;

import java.util.Collection;
import org.apache.commons.math3.exception.NotANumberException;
import org.apache.commons.math3.exception.NotFiniteNumberException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public interface RandomData {
    double nextExponential(double r1) throws NotStrictlyPositiveException;

    double nextGaussian(double r1, double r3) throws NotStrictlyPositiveException;

    String nextHexString(int r1) throws NotStrictlyPositiveException;

    int nextInt(int r1, int r2) throws NumberIsTooLargeException;

    long nextLong(long r1, long r3) throws NumberIsTooLargeException;

    int[] nextPermutation(int r1, int r2) throws NumberIsTooLargeException, NotStrictlyPositiveException;

    long nextPoisson(double r1) throws NotStrictlyPositiveException;

    Object[] nextSample(Collection<?> r1, int r2) throws NumberIsTooLargeException, NotStrictlyPositiveException;

    String nextSecureHexString(int r1) throws NotStrictlyPositiveException;

    int nextSecureInt(int r1, int r2) throws NumberIsTooLargeException;

    long nextSecureLong(long r1, long r3) throws NumberIsTooLargeException;

    double nextUniform(double r1, double r3) throws NumberIsTooLargeException, NotFiniteNumberException, NotANumberException;

    double nextUniform(double r1, double r3, boolean r5) throws NumberIsTooLargeException, NotFiniteNumberException, NotANumberException;
}

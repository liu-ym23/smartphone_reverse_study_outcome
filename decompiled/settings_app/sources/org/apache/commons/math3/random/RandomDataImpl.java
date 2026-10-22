package org.apache.commons.math3.random;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Collection;
import org.apache.commons.math3.distribution.IntegerDistribution;
import org.apache.commons.math3.distribution.RealDistribution;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.NotANumberException;
import org.apache.commons.math3.exception.NotFiniteNumberException;
import org.apache.commons.math3.exception.NotPositiveException;
import org.apache.commons.math3.exception.NotStrictlyPositiveException;
import org.apache.commons.math3.exception.NumberIsTooLargeException;
import org.apache.commons.math3.exception.OutOfRangeException;

/* JADX INFO: loaded from: classes6.dex */
@Deprecated
public class RandomDataImpl implements RandomData, Serializable {
    private static final long serialVersionUID = -626730818244969716L;
    private final RandomDataGenerator delegate;

    public RandomDataImpl() {
        this.delegate = new RandomDataGenerator();
    }

    public RandomDataImpl(RandomGenerator r2) {
        this.delegate = new RandomDataGenerator(r2);
    }

    @Deprecated
    RandomDataGenerator getDelegate() {
        return this.delegate;
    }

    @Override // org.apache.commons.math3.random.RandomData
    public String nextHexString(int r1) throws NotStrictlyPositiveException {
        return this.delegate.nextHexString(r1);
    }

    @Override // org.apache.commons.math3.random.RandomData
    public int nextInt(int r1, int r2) throws NumberIsTooLargeException {
        return this.delegate.nextInt(r1, r2);
    }

    @Override // org.apache.commons.math3.random.RandomData
    public long nextLong(long r1, long r3) throws NumberIsTooLargeException {
        return this.delegate.nextLong(r1, r3);
    }

    @Override // org.apache.commons.math3.random.RandomData
    public String nextSecureHexString(int r1) throws NotStrictlyPositiveException {
        return this.delegate.nextSecureHexString(r1);
    }

    @Override // org.apache.commons.math3.random.RandomData
    public int nextSecureInt(int r1, int r2) throws NumberIsTooLargeException {
        return this.delegate.nextSecureInt(r1, r2);
    }

    @Override // org.apache.commons.math3.random.RandomData
    public long nextSecureLong(long r1, long r3) throws NumberIsTooLargeException {
        return this.delegate.nextSecureLong(r1, r3);
    }

    @Override // org.apache.commons.math3.random.RandomData
    public long nextPoisson(double r1) throws NotStrictlyPositiveException {
        return this.delegate.nextPoisson(r1);
    }

    @Override // org.apache.commons.math3.random.RandomData
    public double nextGaussian(double r1, double r3) throws NotStrictlyPositiveException {
        return this.delegate.nextGaussian(r1, r3);
    }

    @Override // org.apache.commons.math3.random.RandomData
    public double nextExponential(double r1) throws NotStrictlyPositiveException {
        return this.delegate.nextExponential(r1);
    }

    @Override // org.apache.commons.math3.random.RandomData
    public double nextUniform(double r1, double r3) throws NumberIsTooLargeException, NotFiniteNumberException, NotANumberException {
        return this.delegate.nextUniform(r1, r3);
    }

    @Override // org.apache.commons.math3.random.RandomData
    public double nextUniform(double r7, double r9, boolean r11) throws NumberIsTooLargeException, NotFiniteNumberException, NotANumberException {
        return this.delegate.nextUniform(r7, r9, r11);
    }

    public double nextBeta(double r1, double r3) {
        return this.delegate.nextBeta(r1, r3);
    }

    public int nextBinomial(int r1, double r2) {
        return this.delegate.nextBinomial(r1, r2);
    }

    public double nextCauchy(double r1, double r3) {
        return this.delegate.nextCauchy(r1, r3);
    }

    public double nextChiSquare(double r1) {
        return this.delegate.nextChiSquare(r1);
    }

    public double nextF(double r1, double r3) throws NotStrictlyPositiveException {
        return this.delegate.nextF(r1, r3);
    }

    public double nextGamma(double r1, double r3) throws NotStrictlyPositiveException {
        return this.delegate.nextGamma(r1, r3);
    }

    public int nextHypergeometric(int r1, int r2, int r3) throws NotPositiveException, NotStrictlyPositiveException, NumberIsTooLargeException {
        return this.delegate.nextHypergeometric(r1, r2, r3);
    }

    public int nextPascal(int r1, double r2) throws NotStrictlyPositiveException, OutOfRangeException {
        return this.delegate.nextPascal(r1, r2);
    }

    public double nextT(double r1) throws NotStrictlyPositiveException {
        return this.delegate.nextT(r1);
    }

    public double nextWeibull(double r1, double r3) throws NotStrictlyPositiveException {
        return this.delegate.nextWeibull(r1, r3);
    }

    public int nextZipf(int r1, double r2) throws NotStrictlyPositiveException {
        return this.delegate.nextZipf(r1, r2);
    }

    public void reSeed(long r1) {
        this.delegate.reSeed(r1);
    }

    public void reSeedSecure() {
        this.delegate.reSeedSecure();
    }

    public void reSeedSecure(long r1) {
        this.delegate.reSeedSecure(r1);
    }

    public void reSeed() {
        this.delegate.reSeed();
    }

    public void setSecureAlgorithm(String r1, String r2) throws NoSuchAlgorithmException, NoSuchProviderException {
        this.delegate.setSecureAlgorithm(r1, r2);
    }

    @Override // org.apache.commons.math3.random.RandomData
    public int[] nextPermutation(int r1, int r2) throws NotStrictlyPositiveException, NumberIsTooLargeException {
        return this.delegate.nextPermutation(r1, r2);
    }

    @Override // org.apache.commons.math3.random.RandomData
    public Object[] nextSample(Collection<?> r1, int r2) throws NotStrictlyPositiveException, NumberIsTooLargeException {
        return this.delegate.nextSample(r1, r2);
    }

    @Deprecated
    public double nextInversionDeviate(RealDistribution r5) throws MathIllegalArgumentException {
        return r5.inverseCumulativeProbability(nextUniform(0.0d, 1.0d));
    }

    @Deprecated
    public int nextInversionDeviate(IntegerDistribution r5) throws MathIllegalArgumentException {
        return r5.inverseCumulativeProbability(nextUniform(0.0d, 1.0d));
    }
}

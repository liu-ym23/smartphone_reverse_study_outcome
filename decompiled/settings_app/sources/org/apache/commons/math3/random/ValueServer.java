package org.apache.commons.math3.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.commons.math3.exception.MathIllegalArgumentException;
import org.apache.commons.math3.exception.MathIllegalStateException;
import org.apache.commons.math3.exception.NullArgumentException;
import org.apache.commons.math3.exception.ZeroException;
import org.apache.commons.math3.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes6.dex */
public class ValueServer {
    public static final int CONSTANT_MODE = 5;
    public static final int DIGEST_MODE = 0;
    public static final int EXPONENTIAL_MODE = 3;
    public static final int GAUSSIAN_MODE = 4;
    public static final int REPLAY_MODE = 1;
    public static final int UNIFORM_MODE = 2;
    private EmpiricalDistribution empiricalDistribution;
    private BufferedReader filePointer;
    private int mode;
    private double mu;
    private final RandomDataGenerator randomData;
    private double sigma;
    private URL valuesFileURL;

    public ValueServer() {
        this.mode = 5;
        this.valuesFileURL = null;
        this.mu = 0.0d;
        this.sigma = 0.0d;
        this.empiricalDistribution = null;
        this.filePointer = null;
        this.randomData = new RandomDataGenerator();
    }

    @Deprecated
    public ValueServer(RandomDataImpl r4) {
        this.mode = 5;
        this.valuesFileURL = null;
        this.mu = 0.0d;
        this.sigma = 0.0d;
        this.empiricalDistribution = null;
        this.filePointer = null;
        this.randomData = r4.getDelegate();
    }

    public ValueServer(RandomGenerator r4) {
        this.mode = 5;
        this.valuesFileURL = null;
        this.mu = 0.0d;
        this.sigma = 0.0d;
        this.empiricalDistribution = null;
        this.filePointer = null;
        this.randomData = new RandomDataGenerator(r4);
    }

    public double getNext() throws IOException, MathIllegalStateException, MathIllegalArgumentException {
        int r0 = this.mode;
        if (r0 == 0) goto L27;
        if (r0 == 1) goto L25;
        if (r0 == 2) goto L23;
        if (r0 == 3) goto L21;
        if (r0 == 4) goto L19;
        if (r0 != 5) goto L17;
        return this.mu;
    L17:
        throw new MathIllegalStateException(LocalizedFormats.UNKNOWN_MODE, new Object[]{Integer.valueOf(this.mode), "DIGEST_MODE", 0, "REPLAY_MODE", 1, "UNIFORM_MODE", 2, "EXPONENTIAL_MODE", 3, "GAUSSIAN_MODE", 4, "CONSTANT_MODE", 5});
    L19:
        return getNextGaussian();
    L21:
        return getNextExponential();
    L23:
        return getNextUniform();
    L25:
        return getNextReplay();
    L27:
        return getNextDigest();
    }

    public void fill(double[] r4) throws IOException, MathIllegalStateException, MathIllegalArgumentException {
        int r0 = 0;
    L4:
        if (r0 >= r4.length) goto L6;
        r4[r0] = getNext();
        r0 = r0 + 1;
        goto L4
    }

    public double[] fill(int r5) throws IOException, MathIllegalStateException, MathIllegalArgumentException {
        double[] r0 = new double[r5];
        int r1 = 0;
    L3:
        if (r1 >= r5) goto L5;
        r0[r1] = getNext();
        r1 = r1 + 1;
        goto L3
    L5:
        return r0;
    }

    public void computeDistribution() throws IOException, ZeroException, NullArgumentException {
        computeDistribution(1000);
    }

    public void computeDistribution(int r3) throws NullArgumentException, IOException, ZeroException {
        EmpiricalDistribution r0 = new EmpiricalDistribution(r3, this.randomData.getRandomGenerator());
        this.empiricalDistribution = r0;
        r0.load(this.valuesFileURL);
        this.mu = this.empiricalDistribution.getSampleStats().getMean();
        this.sigma = this.empiricalDistribution.getSampleStats().getStandardDeviation();
    }

    public int getMode() {
        return this.mode;
    }

    public void setMode(int r1) {
        this.mode = r1;
    }

    public URL getValuesFileURL() {
        return this.valuesFileURL;
    }

    public void setValuesFileURL(String r2) throws MalformedURLException {
        this.valuesFileURL = new URL(r2);
    }

    public void setValuesFileURL(URL r1) {
        this.valuesFileURL = r1;
    }

    public EmpiricalDistribution getEmpiricalDistribution() {
        return this.empiricalDistribution;
    }

    public void resetReplayFile() throws IOException {
        BufferedReader r0 = this.filePointer;
        if (r0 != null) goto L8;
    L5:
        this.filePointer = new BufferedReader(new InputStreamReader(this.valuesFileURL.openStream(), "UTF-8"));
        return;
    L8:
        r0.close();     // Catch: IOException -> L7
        this.filePointer = null;     // Catch: IOException -> L7
        goto L5
    }

    public void closeReplayFile() throws IOException {
        BufferedReader r0 = this.filePointer;
        if (r0 == null) goto L6;
        r0.close();
        this.filePointer = null;
        return;
    }

    public double getMu() {
        return this.mu;
    }

    public void setMu(double r1) {
        this.mu = r1;
    }

    public double getSigma() {
        return this.sigma;
    }

    public void setSigma(double r1) {
        this.sigma = r1;
    }

    public void reSeed(long r1) {
        this.randomData.reSeed(r1);
    }

    private double getNextDigest() throws MathIllegalStateException {
        EmpiricalDistribution r0 = this.empiricalDistribution;
        if (r0 == null) goto L9;
        if (r0.getBinStats().size() == 0) goto L9;
        return this.empiricalDistribution.getNextValue();
    L9:
        throw new MathIllegalStateException(LocalizedFormats.DIGEST_NOT_INITIALIZED, new Object[0]);
    }

    private double getNextReplay() throws IOException, MathIllegalStateException {
        if (this.filePointer != null) goto L5;
        resetReplayFile();
    L5:
        String r0 = this.filePointer.readLine();
        if (r0 != null) goto L13;
        closeReplayFile();
        resetReplayFile();
        r0 = this.filePointer.readLine();
        if (r0 != null) goto L13;
        throw new MathIllegalStateException(LocalizedFormats.URL_CONTAINS_NO_DATA, new Object[]{this.valuesFileURL});
    L13:
        return Double.parseDouble(r0);
    }

    private double getNextUniform() throws MathIllegalArgumentException {
        return this.randomData.nextUniform(0.0d, this.mu * 2.0d);
    }

    private double getNextExponential() throws MathIllegalArgumentException {
        return this.randomData.nextExponential(this.mu);
    }

    private double getNextGaussian() throws MathIllegalArgumentException {
        return this.randomData.nextGaussian(this.mu, this.sigma);
    }
}

package org.apache.commons.math3.ml.neuralnet.sofm;

import java.util.Iterator;
import org.apache.commons.math3.ml.neuralnet.Network;

/* JADX INFO: loaded from: classes6.dex */
public class KohonenTrainingTask implements Runnable {
    private final Iterator<double[]> featuresIterator;
    private final Network net;
    private final KohonenUpdateAction updateAction;

    public KohonenTrainingTask(Network r1, Iterator<double[]> r2, KohonenUpdateAction r3) {
        this.net = r1;
        this.featuresIterator = r2;
        this.updateAction = r3;
    }

    @Override // java.lang.Runnable
    public void run() {
    L3:
        if (this.featuresIterator.hasNext() == false) goto L5;
        this.updateAction.update(this.net, this.featuresIterator.next());
        goto L3
    }
}

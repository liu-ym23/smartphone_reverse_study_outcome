package org.apache.commons.math3.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.commons.math3.exception.MaxCountExceededException;

/* JADX INFO: loaded from: classes6.dex */
public class IterationManager {
    private IntegerSequence.Incrementor iterations;
    private final Collection<IterationListener> listeners;

    public IterationManager(int r2) {
        this.iterations = IntegerSequence.Incrementor.create().withMaximalCount(r2);
        this.listeners = new CopyOnWriteArrayList();
    }

    @Deprecated
    public IterationManager(int r2, final Incrementor.MaxCountExceededCallback r3) {
        this(r2, new AnonymousClass1(r3));
    }

    public IterationManager(int r2, IntegerSequence.Incrementor.MaxCountExceededCallback r3) {
        this.iterations = IntegerSequence.Incrementor.create().withMaximalCount(r2).withCallback(r3);
        this.listeners = new CopyOnWriteArrayList();
    }

    public void addIterationListener(IterationListener r1) {
        this.listeners.add(r1);
    }

    public void fireInitializationEvent(IterationEvent r2) {
        Iterator<IterationListener> r1 = this.listeners.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().initializationPerformed(r2);
        goto L4
    }

    public void fireIterationPerformedEvent(IterationEvent r2) {
        Iterator<IterationListener> r1 = this.listeners.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().iterationPerformed(r2);
        goto L4
    }

    public void fireIterationStartedEvent(IterationEvent r2) {
        Iterator<IterationListener> r1 = this.listeners.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().iterationStarted(r2);
        goto L4
    }

    public void fireTerminationEvent(IterationEvent r2) {
        Iterator<IterationListener> r1 = this.listeners.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().terminationPerformed(r2);
        goto L4
    }

    public int getIterations() {
        return this.iterations.getCount();
    }

    public int getMaxIterations() {
        return this.iterations.getMaximalCount();
    }

    public void incrementIterationCount() throws MaxCountExceededException {
        this.iterations.increment();
    }

    public void removeIterationListener(IterationListener r1) {
        this.listeners.remove(r1);
    }

    public void resetIterationCount() {
        this.iterations = this.iterations.withStart(0);
    }
}

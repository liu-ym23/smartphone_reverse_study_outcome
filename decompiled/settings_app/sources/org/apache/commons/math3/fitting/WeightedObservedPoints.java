package org.apache.commons.math3.fitting;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class WeightedObservedPoints implements Serializable {
    private static final long serialVersionUID = 20130813;
    private final List<WeightedObservedPoint> observations;

    public WeightedObservedPoints() {
        this.observations = new ArrayList();
    }

    public void add(double r8, double r10) {
        add(1.0d, r8, r10);
    }

    public void add(double r9, double r11, double r13) {
        this.observations.add(new WeightedObservedPoint(r9, r11, r13));
    }

    public void add(WeightedObservedPoint r1) {
        this.observations.add(r1);
    }

    public List<WeightedObservedPoint> toList() {
        return new ArrayList(this.observations);
    }

    public void clear() {
        this.observations.clear();
    }
}

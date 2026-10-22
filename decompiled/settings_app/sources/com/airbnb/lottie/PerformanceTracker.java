package com.airbnb.lottie;

import android.util.Log;
import androidx.collection.ArraySet;
import androidx.core.util.Pair;
import com.airbnb.lottie.utils.MeanCalculator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class PerformanceTracker {
    private boolean enabled;
    private final Comparator<Pair<String, Float>> floatComparator;
    private final Set<FrameListener> frameListeners;
    private final Map<String, MeanCalculator> layerRenderTimes;

    public interface FrameListener {
        void onFrameRendered(float r1);
    }

    public PerformanceTracker() {
        this.enabled = false;
        this.frameListeners = new ArraySet();
        this.layerRenderTimes = new HashMap();
        this.floatComparator = new AnonymousClass1(this);
    }

    void setEnabled(boolean r1) {
        this.enabled = r1;
    }

    public void recordRenderTime(String r3, float r4) {
        if (this.enabled == true) goto L5;
        return;
    L5:
        MeanCalculator r0 = this.layerRenderTimes.get(r3);
        if (r0 != null) goto L8;
        r0 = new MeanCalculator();
        this.layerRenderTimes.put(r3, r0);
    L8:
        r0.add(r4);
        if (r3.equals("__container") == false) goto L14;
        Iterator<FrameListener> r2 = this.frameListeners.iterator();
    L12:
        if (r2.hasNext() == false) goto L16;
        r2.next().onFrameRendered(r4);
        goto L12
    L16:
        return;
    }

    public void addFrameListener(FrameListener r1) {
        this.frameListeners.add(r1);
    }

    public void removeFrameListener(FrameListener r1) {
        this.frameListeners.remove(r1);
    }

    public void clearRenderTimes() {
        this.layerRenderTimes.clear();
    }

    public void logRenderTimes() {
        if (this.enabled == true) goto L5;
        return;
    L5:
        List<Pair<String, Float>> r6 = getSortedRenderTimes();
        Log.d(L.TAG, "Render times:");
        int r2 = 0;
    L7:
        if (r2 >= r6.size()) goto L9;
        Pair<String, Float> r3 = r6.get(r2);
        Log.d(L.TAG, String.format("\t\t%30s:%.2f", new Object[]{r3.first, r3.second}));
        r2 = r2 + 1;
        goto L7
    }

    public List<Pair<String, Float>> getSortedRenderTimes() {
        if (this.enabled == false) goto L5;
        ArrayList r0 = new ArrayList(this.layerRenderTimes.size());
        Iterator<Map.Entry<String, MeanCalculator>> r1 = this.layerRenderTimes.entrySet().iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        Map.Entry<String, MeanCalculator> r2 = r1.next();
        r0.add(new Pair(r2.getKey(), Float.valueOf(r2.getValue().getMean())));
        goto L8
    L10:
        Collections.sort(r0, this.floatComparator);
        return r0;
    L5:
        return Collections.emptyList();
    }
}

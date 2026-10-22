package org.apache.commons.math3.geometry.partitioning;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.math3.geometry.Space;

/* JADX INFO: loaded from: classes6.dex */
public class NodesSet<S extends Space> implements Iterable<BSPTree<S>> {
    private List<BSPTree<S>> list;

    public NodesSet() {
        this.list = new ArrayList();
    }

    public void add(BSPTree<S> r3) {
        Iterator<BSPTree<S>> r0 = this.list.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        if (r3 != r0.next()) goto L4;
        return;
    L8:
        this.list.add(r3);
    }

    public void addAll(Iterable<BSPTree<S>> r2) {
        Iterator<BSPTree<S>> r3 = r2.iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        add(r3.next());
        goto L4
    }

    @Override // java.lang.Iterable
    public Iterator<BSPTree<S>> iterator() {
        return this.list.iterator();
    }
}

package cz.msebera.android.httpclient.impl.client;

import java.net.URI;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public class RedirectLocations extends AbstractList<Object> {
    private final List<URI> all;
    private final Set<URI> unique;

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object get(int r1) {
        return get(r1);
    }

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object remove(int r1) {
        return remove(r1);
    }

    public RedirectLocations() {
        this.unique = new HashSet();
        this.all = new ArrayList();
    }

    public boolean contains(URI r1) {
        return this.unique.contains(r1);
    }

    public void add(URI r2) {
        this.unique.add(r2);
        this.all.add(r2);
    }

    public boolean remove(URI r3) {
        boolean r0 = this.unique.remove(r3);
        if (r0 == false) goto L10;
        Iterator<URI> r2 = this.all.iterator();
    L6:
        if (r2.hasNext() == false) goto L10;
        if (r2.next().equals(r3) == false) goto L6;
        r2.remove();
    L10:
        return r0;
    }

    public List<URI> getAll() {
        return new ArrayList(this.all);
    }

    @Override // java.util.AbstractList, java.util.List
    public URI get(int r1) {
        return this.all.get(r1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.all.size();
    }

    @Override // java.util.AbstractList, java.util.List
    public Object set(int r2, Object r3) {
        URI r4 = (URI) r3;
        URI r5 = this.all.set(r2, r4);
        this.unique.remove(r5);
        this.unique.add(r4);
        if (this.all.size() == this.unique.size()) goto L5;
        this.unique.addAll(this.all);
    L5:
        return r5;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int r2, Object r3) {
        URI r4 = (URI) r3;
        this.all.add(r2, r4);
        this.unique.add(r4);
    }

    @Override // java.util.AbstractList, java.util.List
    public URI remove(int r3) {
        URI r4 = this.all.remove(r3);
        this.unique.remove(r4);
        if (this.all.size() == this.unique.size()) goto L5;
        this.unique.addAll(this.all);
    L5:
        return r4;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object r1) {
        return this.unique.contains(r1);
    }
}

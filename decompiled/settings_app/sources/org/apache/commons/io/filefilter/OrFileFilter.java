package org.apache.commons.io.filefilter;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class OrFileFilter extends AbstractFileFilter implements ConditionalFileFilter {
    private List fileFilters;

    public OrFileFilter() {
        this.fileFilters = new ArrayList();
    }

    public OrFileFilter(List r2) {
        if (r2 != null) goto L5;
        this.fileFilters = new ArrayList();
        return;
    L5:
        this.fileFilters = new ArrayList(r2);
    }

    public OrFileFilter(IOFileFilter r2, IOFileFilter r3) {
        if (r2 == null) goto L8;
        if (r3 == null) goto L8;
        this.fileFilters = new ArrayList();
        addFileFilter(r2);
        addFileFilter(r3);
        return;
    L8:
        throw new IllegalArgumentException("The filters must not be null");
    }

    @Override // org.apache.commons.io.filefilter.ConditionalFileFilter
    public void addFileFilter(IOFileFilter r1) {
        this.fileFilters.add(r1);
    }

    @Override // org.apache.commons.io.filefilter.ConditionalFileFilter
    public List getFileFilters() {
        return Collections.unmodifiableList(this.fileFilters);
    }

    @Override // org.apache.commons.io.filefilter.ConditionalFileFilter
    public boolean removeFileFilter(IOFileFilter r1) {
        return this.fileFilters.remove(r1);
    }

    @Override // org.apache.commons.io.filefilter.ConditionalFileFilter
    public void setFileFilters(List r1) {
        this.fileFilters = r1;
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File r2) {
        Iterator r1 = this.fileFilters.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        if (((IOFileFilter) r1.next()).accept(r2) == false) goto L4;
        return true;
    L9:
        return false;
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FilenameFilter
    public boolean accept(File r2, String r3) {
        Iterator r1 = this.fileFilters.iterator();
    L4:
        if (r1.hasNext() == false) goto L9;
        if (((IOFileFilter) r1.next()).accept(r2, r3) == false) goto L4;
        return true;
    L9:
        return false;
    }
}

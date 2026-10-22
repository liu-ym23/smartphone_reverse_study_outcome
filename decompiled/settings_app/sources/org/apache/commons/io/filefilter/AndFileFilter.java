package org.apache.commons.io.filefilter;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class AndFileFilter extends AbstractFileFilter implements ConditionalFileFilter {
    private List fileFilters;

    public AndFileFilter() {
        this.fileFilters = new ArrayList();
    }

    public AndFileFilter(List r2) {
        if (r2 != null) goto L5;
        this.fileFilters = new ArrayList();
        return;
    L5:
        this.fileFilters = new ArrayList(r2);
    }

    public AndFileFilter(IOFileFilter r2, IOFileFilter r3) {
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
    public void setFileFilters(List r2) {
        this.fileFilters = new ArrayList(r2);
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File r3) {
        if (this.fileFilters.size() != 0) goto L5;
        return false;
    L5:
        Iterator r2 = this.fileFilters.iterator();
    L7:
        if (r2.hasNext() == false) goto L11;
        if (((IOFileFilter) r2.next()).accept(r3) == true) goto L7;
        return false;
    L11:
        return true;
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FilenameFilter
    public boolean accept(File r3, String r4) {
        if (this.fileFilters.size() != 0) goto L5;
        return false;
    L5:
        Iterator r2 = this.fileFilters.iterator();
    L7:
        if (r2.hasNext() == false) goto L11;
        if (((IOFileFilter) r2.next()).accept(r3, r4) == true) goto L7;
        return false;
    L11:
        return true;
    }
}

package org.apache.commons.io.filefilter;

import java.io.File;

/* JADX INFO: loaded from: classes5.dex */
public class NotFileFilter extends AbstractFileFilter {
    private IOFileFilter filter;

    public NotFileFilter(IOFileFilter r1) {
        if (r1 == null) goto L7;
        this.filter = r1;
        return;
    L7:
        throw new IllegalArgumentException("The filter must not be null");
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File r1) {
        return !this.filter.accept(r1);
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FilenameFilter
    public boolean accept(File r1, String r2) {
        return !this.filter.accept(r1, r2);
    }
}

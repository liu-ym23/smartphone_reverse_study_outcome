package org.apache.commons.io.filefilter;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

/* JADX INFO: loaded from: classes5.dex */
public class DelegateFileFilter extends AbstractFileFilter {
    private FileFilter fileFilter;
    private FilenameFilter filenameFilter;

    public DelegateFileFilter(FilenameFilter r1) {
        if (r1 == null) goto L7;
        this.filenameFilter = r1;
        return;
    L7:
        throw new IllegalArgumentException("The FilenameFilter must not be null");
    }

    public DelegateFileFilter(FileFilter r1) {
        if (r1 == null) goto L7;
        this.fileFilter = r1;
        return;
    L7:
        throw new IllegalArgumentException("The FileFilter must not be null");
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File r2) {
        FileFilter r0 = this.fileFilter;
        if (r0 == null) goto L7;
        return r0.accept(r2);
    L7:
        return super.accept(r2);
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FilenameFilter
    public boolean accept(File r2, String r3) {
        FilenameFilter r0 = this.filenameFilter;
        if (r0 == null) goto L7;
        return r0.accept(r2, r3);
    L7:
        return super.accept(r2, r3);
    }
}

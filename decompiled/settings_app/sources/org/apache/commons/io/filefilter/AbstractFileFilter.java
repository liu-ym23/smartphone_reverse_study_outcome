package org.apache.commons.io.filefilter;

import java.io.File;

/* JADX INFO: loaded from: classes6.dex */
public abstract class AbstractFileFilter implements IOFileFilter {
    public AbstractFileFilter() {
    }

    @Override // org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File r2) {
        return accept(r2.getParentFile(), r2.getName());
    }

    @Override // org.apache.commons.io.filefilter.IOFileFilter, java.io.FilenameFilter
    public boolean accept(File r2, String r3) {
        return accept(new File(r2, r3));
    }
}

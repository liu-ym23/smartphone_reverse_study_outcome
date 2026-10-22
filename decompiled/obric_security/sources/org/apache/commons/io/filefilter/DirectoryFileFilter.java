package org.apache.commons.io.filefilter;

import java.io.File;

/* JADX INFO: loaded from: classes5.dex */
public class DirectoryFileFilter extends AbstractFileFilter {
    public static final IOFileFilter DIRECTORY = null;
    public static final IOFileFilter INSTANCE = null;

    static {
        DirectoryFileFilter r0 = new DirectoryFileFilter();
        DIRECTORY = r0;
        INSTANCE = r0;
    }

    protected DirectoryFileFilter() {
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File r1) {
        return r1.isDirectory();
    }
}

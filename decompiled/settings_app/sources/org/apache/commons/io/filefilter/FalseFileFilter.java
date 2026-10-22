package org.apache.commons.io.filefilter;

import java.io.File;

/* JADX INFO: loaded from: classes6.dex */
public class FalseFileFilter implements IOFileFilter {
    public static final IOFileFilter FALSE = null;
    public static final IOFileFilter INSTANCE = null;

    @Override // org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File r1) {
        return false;
    }

    @Override // org.apache.commons.io.filefilter.IOFileFilter, java.io.FilenameFilter
    public boolean accept(File r1, String r2) {
        return false;
    }

    static {
        FalseFileFilter r0 = new FalseFileFilter();
        FALSE = r0;
        INSTANCE = r0;
    }

    protected FalseFileFilter() {
    }
}

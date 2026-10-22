package org.apache.commons.io.filefilter;

import java.io.File;

/* JADX INFO: loaded from: classes5.dex */
public class TrueFileFilter implements IOFileFilter {
    public static final IOFileFilter INSTANCE = null;
    public static final IOFileFilter TRUE = null;

    @Override // org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File r1) {
        return true;
    }

    @Override // org.apache.commons.io.filefilter.IOFileFilter, java.io.FilenameFilter
    public boolean accept(File r1, String r2) {
        return true;
    }

    static {
        TrueFileFilter r0 = new TrueFileFilter();
        TRUE = r0;
        INSTANCE = r0;
    }

    protected TrueFileFilter() {
    }
}

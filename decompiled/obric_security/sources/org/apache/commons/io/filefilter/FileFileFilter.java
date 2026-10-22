package org.apache.commons.io.filefilter;

import java.io.File;

/* JADX INFO: loaded from: classes5.dex */
public class FileFileFilter extends AbstractFileFilter {
    public static final IOFileFilter FILE = null;

    static {
        FILE = new FileFileFilter();
    }

    protected FileFileFilter() {
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File r1) {
        return r1.isFile();
    }
}

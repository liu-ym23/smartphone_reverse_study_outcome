package org.apache.commons.io.filefilter;

import java.io.File;

/* JADX INFO: loaded from: classes5.dex */
public class CanReadFileFilter extends AbstractFileFilter {
    public static final IOFileFilter CANNOT_READ = null;
    public static final IOFileFilter CAN_READ = null;
    public static final IOFileFilter READ_ONLY = null;

    static {
        CanReadFileFilter r0 = new CanReadFileFilter();
        CAN_READ = r0;
        CANNOT_READ = new NotFileFilter(r0);
        READ_ONLY = new AndFileFilter(r0, CanWriteFileFilter.CANNOT_WRITE);
    }

    protected CanReadFileFilter() {
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File r1) {
        return r1.canRead();
    }
}

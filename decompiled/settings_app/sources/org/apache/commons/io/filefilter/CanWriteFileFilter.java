package org.apache.commons.io.filefilter;

import java.io.File;

/* JADX INFO: loaded from: classes6.dex */
public class CanWriteFileFilter extends AbstractFileFilter {
    public static final IOFileFilter CANNOT_WRITE = null;
    public static final IOFileFilter CAN_WRITE = null;

    static {
        CanWriteFileFilter r0 = new CanWriteFileFilter();
        CAN_WRITE = r0;
        CANNOT_WRITE = new NotFileFilter(r0);
    }

    protected CanWriteFileFilter() {
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File r1) {
        return r1.canWrite();
    }
}

package org.apache.commons.io.filefilter;

import java.io.File;

/* JADX INFO: loaded from: classes6.dex */
public class EmptyFileFilter extends AbstractFileFilter {
    public static final IOFileFilter EMPTY = null;
    public static final IOFileFilter NOT_EMPTY = null;

    static {
        EmptyFileFilter r0 = new EmptyFileFilter();
        EMPTY = r0;
        NOT_EMPTY = new NotFileFilter(r0);
    }

    protected EmptyFileFilter() {
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File r5) {
        if (r5.isDirectory() == false) goto L12;
        File[] r4 = r5.listFiles();
        if (r4 != null) goto L7;
        return true;
    L7:
        if (r4.length != 0) goto L10;
        return true;
    L10:
        return false;
    L12:
        if (r5.length() != 0) goto L15;
        return true;
    L15:
        return false;
    }
}

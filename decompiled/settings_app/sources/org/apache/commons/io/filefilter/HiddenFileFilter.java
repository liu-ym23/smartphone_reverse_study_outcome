package org.apache.commons.io.filefilter;

import java.io.File;

/* JADX INFO: loaded from: classes6.dex */
public class HiddenFileFilter extends AbstractFileFilter {
    public static final IOFileFilter HIDDEN = null;
    public static final IOFileFilter VISIBLE = null;

    static {
        HiddenFileFilter r0 = new HiddenFileFilter();
        HIDDEN = r0;
        VISIBLE = new NotFileFilter(r0);
    }

    protected HiddenFileFilter() {
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File r1) {
        return r1.isHidden();
    }
}

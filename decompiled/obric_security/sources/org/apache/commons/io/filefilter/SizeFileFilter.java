package org.apache.commons.io.filefilter;

import java.io.File;

/* JADX INFO: loaded from: classes5.dex */
public class SizeFileFilter extends AbstractFileFilter {
    private boolean acceptLarger;
    private long size;

    public SizeFileFilter(long r2) {
        this(r2, true);
    }

    public SizeFileFilter(long r3, boolean r5) {
        if (r3 < 0) goto L7;
        this.size = r3;
        this.acceptLarger = r5;
        return;
    L7:
        throw new IllegalArgumentException("The size must be non-negative");
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File r5) {
        if (r5.length() >= this.size) goto L5;
        boolean r6 = true;
    L7:
        if (this.acceptLarger == false) goto L12;
        if (r6 == true) goto L13;
        return true;
    L13:
        return false;
    L12:
        return r6;
    L5:
        r6 = false;
        goto L7
    }
}

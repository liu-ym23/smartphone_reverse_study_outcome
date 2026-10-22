package org.apache.commons.io.filefilter;

import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class SuffixFileFilter extends AbstractFileFilter {
    private String[] suffixes;

    public SuffixFileFilter(String r3) {
        if (r3 == null) goto L7;
        this.suffixes = new String[]{r3};
        return;
    L7:
        throw new IllegalArgumentException("The suffix must not be null");
    }

    public SuffixFileFilter(String[] r1) {
        if (r1 == null) goto L7;
        this.suffixes = r1;
        return;
    L7:
        throw new IllegalArgumentException("The array of suffixes must not be null");
    }

    public SuffixFileFilter(List r2) {
        if (r2 == null) goto L7;
        this.suffixes = (String[]) r2.toArray(new String[r2.size()]);
        return;
    L7:
        throw new IllegalArgumentException("The list of suffixes must not be null");
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File r5) {
        String r6 = r5.getName();
        int r1 = 0;
    L3:
        String[] r2 = this.suffixes;
        if (r1 >= r2.length) goto L10;
        if (r6.endsWith(r2[r1]) == true) goto L7;
        r1 = r1 + 1;
        goto L3
    L7:
        return true;
    L10:
        return false;
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FilenameFilter
    public boolean accept(File r4, String r5) {
        int r0 = 0;
    L3:
        String[] r1 = this.suffixes;
        if (r0 >= r1.length) goto L10;
        if (r5.endsWith(r1[r0]) == true) goto L7;
        r0 = r0 + 1;
        goto L3
    L7:
        return true;
    L10:
        return false;
    }
}

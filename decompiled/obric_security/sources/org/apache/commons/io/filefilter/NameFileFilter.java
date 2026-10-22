package org.apache.commons.io.filefilter;

import java.io.File;
import java.util.List;
import org.apache.commons.io.IOCase;

/* JADX INFO: loaded from: classes5.dex */
public class NameFileFilter extends AbstractFileFilter {
    private IOCase caseSensitivity;
    private String[] names;

    public NameFileFilter(String r2) {
        this(r2, null);
    }

    public NameFileFilter(String r3, IOCase r4) {
        if (r3 == null) goto L10;
        this.names = new String[]{r3};
        if (r4 != null) goto L7;
        r4 = IOCase.SENSITIVE;
    L7:
        this.caseSensitivity = r4;
        return;
    L10:
        throw new IllegalArgumentException("The wildcard must not be null");
    }

    public NameFileFilter(String[] r2) {
        this(r2, null);
    }

    public NameFileFilter(String[] r1, IOCase r2) {
        if (r1 == null) goto L10;
        this.names = r1;
        if (r2 != null) goto L7;
        r2 = IOCase.SENSITIVE;
    L7:
        this.caseSensitivity = r2;
        return;
    L10:
        throw new IllegalArgumentException("The array of names must not be null");
    }

    public NameFileFilter(List r2) {
        this(r2, null);
    }

    public NameFileFilter(List r2, IOCase r3) {
        if (r2 == null) goto L10;
        this.names = (String[]) r2.toArray(new String[r2.size()]);
        if (r3 != null) goto L7;
        r3 = IOCase.SENSITIVE;
    L7:
        this.caseSensitivity = r3;
        return;
    L10:
        throw new IllegalArgumentException("The list of names must not be null");
    }

    @Override // org.apache.commons.io.filefilter.AbstractFileFilter, org.apache.commons.io.filefilter.IOFileFilter, java.io.FileFilter
    public boolean accept(File r5) {
        String r6 = r5.getName();
        int r1 = 0;
    L3:
        String[] r2 = this.names;
        if (r1 >= r2.length) goto L10;
        if (this.caseSensitivity.checkEquals(r6, r2[r1]) == true) goto L7;
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
        String[] r1 = this.names;
        if (r0 >= r1.length) goto L10;
        if (this.caseSensitivity.checkEquals(r5, r1[r0]) == true) goto L7;
        r0 = r0 + 1;
        goto L3
    L7:
        return true;
    L10:
        return false;
    }
}

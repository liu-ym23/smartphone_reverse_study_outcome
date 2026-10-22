package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class PatternFilenameFilter implements FilenameFilter {
    private final Pattern pattern;

    public PatternFilenameFilter(String r1) {
        this(Pattern.compile(r1));
    }

    public PatternFilenameFilter(Pattern r1) {
        this.pattern = (Pattern) Preconditions.checkNotNull(r1);
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File r1, String r2) {
        return this.pattern.matcher(r2).matches();
    }
}

package com.ss.android.http.legacy;

import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public interface HeaderIterator extends Iterator {
    @Override // java.util.Iterator
    boolean hasNext();

    Header nextHeader();
}

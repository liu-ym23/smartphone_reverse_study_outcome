package org.apache.commons.io.filefilter;

import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface ConditionalFileFilter {
    void addFileFilter(IOFileFilter r1);

    List getFileFilters();

    boolean removeFileFilter(IOFileFilter r1);

    void setFileFilters(List r1);
}

package com.google.common.io;

import java.nio.file.FileSystemException;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes3.dex */
@ElementTypesAreNonnullByDefault
public final class InsecureRecursiveDeleteException extends FileSystemException {
    public InsecureRecursiveDeleteException(@CheckForNull String r3) {
        super(r3, null, "unable to guarantee security of recursive delete");
    }
}

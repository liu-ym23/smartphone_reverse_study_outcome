package ms.bd.c;

import java.io.File;
import java.io.FilenameFilter;

/* JADX INFO: loaded from: classes2.dex */
class a0 implements FilenameFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f22314a;

    a0(z r1, String r2) {
        this.f22314a = r2;
    }

    @Override // java.io.FilenameFilter
    public boolean accept(File r1, String r2) {
        return r2.startsWith(this.f22314a);
    }
}

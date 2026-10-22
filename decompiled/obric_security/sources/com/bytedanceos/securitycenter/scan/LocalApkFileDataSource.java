package com.bytedanceos.securitycenter.scan;

import com.bytedance.librarian.LibrarianImpl;
import java.io.File;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: LocalApkFileDataSource.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J4\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002¨\u0006\u0012"}, d2 = {"Lcom/bytedanceos/securitycenter/scan/LocalApkFileDataSource;", "Lcom/bytedanceos/securitycenter/scan/ApkFileDataSource;", "()V", "getLocalApkPaths", "", "", "isCanceled", "Lkotlin/Function0;", "", "scanApksRecursively", "", "file", "Ljava/io/File;", "paths", "", "depth", "", "Companion", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class LocalApkFileDataSource implements ApkFileDataSource {
    private static final Companion Companion = null;

    @Deprecated
    public static final int MAX_DEPTH = 3;

    @Deprecated
    public static final String STORAGE_ROOT = "/storage/emulated/0";

    /* JADX INFO: compiled from: LocalApkFileDataSource.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/bytedanceos/securitycenter/scan/LocalApkFileDataSource$Companion;", "", "()V", "MAX_DEPTH", "", "STORAGE_ROOT", "", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public LocalApkFileDataSource() {
    }

    @Override // com.bytedanceos.securitycenter.scan.ApkFileDataSource
    public List<String> getLocalApkPaths(Function0<Boolean> r4) {
        Intrinsics.checkNotNullParameter(r4, "isCanceled");
        ArrayList r0 = new ArrayList();
        File r1 = new File(STORAGE_ROOT);     // Catch: Exception -> L9
        if (r1.exists() == true) goto L6;
    L11:
        return r0;
    L6:
        if (r1.isDirectory() == false) goto L11;
        scanApksRecursively(r1, r0, 0, r4);     // Catch: Exception -> L9
    L9:
        e = move-exception;
        e.printStackTrace();
        goto L11
    }

    private final void scanApksRecursively(File r9, List<String> r10, int r11, Function0<Boolean> r12) {
        if (r12.invoke().booleanValue() == false) goto L6;
        return;
    L6:
        if (r11 <= 3) goto L36;
        return;
    L36:
        DirectoryStream<Path> r13 = Files.newDirectoryStream(r9.toPath());     // Catch: Exception -> L35
        Iterator<Path> r0 = r13.iterator();     // Catch: Throwable -> L30
    L11:
        if (r0.hasNext() == false) goto L27;
        Path r1 = r0.next();     // Catch: Throwable -> L30
        if (r12.invoke().booleanValue() == true) goto L14;
        File r2 = r1.toFile();     // Catch: Throwable -> L30
        Intrinsics.checkNotNullExpressionValue(r2, "f");     // Catch: Throwable -> L30
        if (r2.isDirectory() == true) goto L19;
        String r3 = r2.getName();     // Catch: Throwable -> L30
        Intrinsics.checkNotNullExpressionValue(r3, "f.name");     // Catch: Throwable -> L30
        if (StringsKt.endsWith(r3, ".apk", true) == false) goto L11;
        String r4 = r2.getAbsolutePath();     // Catch: Throwable -> L30
        Intrinsics.checkNotNullExpressionValue(r4, "f.absolutePath");     // Catch: Throwable -> L30
        r10.add(r4);     // Catch: Throwable -> L30
        goto L11
    L19:
        String r5 = r2.getName();     // Catch: Throwable -> L30
        Intrinsics.checkNotNullExpressionValue(r5, "f.name");     // Catch: Throwable -> L30
        if (StringsKt.startsWith$default(r5, LibrarianImpl.Constants.DOT, false, 2, null) == true) goto L11;
        if ((!Intrinsics.areEqual(r2.getName(), "Android")) == false) goto L11;
        scanApksRecursively(r2, r10, 1 + r11, r12);     // Catch: Throwable -> L30
        goto L11
    L14:
        CloseableKt.closeFinally(r13, null);     // Catch: Exception -> L35
        return;
    L27:
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L30
        CloseableKt.closeFinally(r13, null);     // Catch: Exception -> L35
        return;
    L30:
        th = move-exception;
        throw th;     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        CloseableKt.closeFinally(r13, th);     // Catch: Exception -> L35
        throw th;     // Catch: Exception -> L35
    }
}

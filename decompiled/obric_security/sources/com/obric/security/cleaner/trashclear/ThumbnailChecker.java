package com.obric.security.cleaner.trashclear;

import android.content.Context;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ThumbnailChecker.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0005H\u0002¨\u0006\f"}, d2 = {"Lcom/obric/security/cleaner/trashclear/ThumbnailChecker;", "", "()V", "checkThumbnailImages", "Ljava/util/ArrayList;", "Ljava/io/File;", "Lkotlin/collections/ArrayList;", "context", "Landroid/content/Context;", "isImageFile", "", "file", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class ThumbnailChecker {
    public static final ThumbnailChecker INSTANCE = null;

    static {
        INSTANCE = new ThumbnailChecker();
    }

    private ThumbnailChecker() {
    }

    public final ArrayList<File> checkThumbnailImages(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        File r4 = new File("/storage/emulated/0/Pictures/.thumbnails");
        ArrayList<File> r0 = new ArrayList();
        if (r4.exists() == true) goto L5;
    L25:
        return r0;
    L5:
        if (r4.isDirectory() == false) goto L25;
        DirectoryStream<Path> r6 = Files.newDirectoryStream(r4.toPath());     // Catch: Exception -> L26
        Iterator<Path> r1 = r6.iterator();     // Catch: Throwable -> L20
    L10:
        if (r1.hasNext() == false) goto L16;
        File r2 = r1.next().toFile();     // Catch: Throwable -> L20
        Intrinsics.checkNotNullExpressionValue(r2, "file");     // Catch: Throwable -> L20
        if (r2.isFile() == false) goto L10;
        if (INSTANCE.isImageFile(r5, r2) == false) goto L10;
        r0.add(r2);     // Catch: Throwable -> L20
        goto L10
    L16:
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L20
        goto L25
    L18:
        CloseableKt.closeFinally(r6, null);     // Catch: Exception -> L26
        return r0;
    L20:
        th = move-exception;
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        CloseableKt.closeFinally(r6, th);     // Catch: Exception -> L26
        throw th;     // Catch: Exception -> L26
    }

    private final boolean isImageFile(Context r3, File r4) {
        String r2 = MimeTypeMap.getFileExtensionFromUrl(r4.getAbsolutePath());
        String r5 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(r2);
        if (r5 != null) goto L5;
        return false;
    L5:
        if (StringsKt.startsWith$default(r5, "image/", false, 2, null) == true) goto L7;
        return false;
    L7:
        return true;
    }
}

package coil.map;

import android.net.Uri;
import coil.request.Options;
import coil.util.Utils;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.io.IOUtils;

/* JADX INFO: compiled from: FileUriMapper.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0002J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcoil/map/FileUriMapper;", "Lcoil/map/Mapper;", "Landroid/net/Uri;", "Ljava/io/File;", "()V", "isApplicable", "", "data", "map", "options", "Lcoil/request/Options;", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FileUriMapper implements Mapper<Uri, File> {
    public FileUriMapper() {
    }

    @Override // coil.map.Mapper
    public /* bridge */ /* synthetic */ File map(Uri r1, Options r2) {
        return map2(r1, r2);
    }

    /* JADX INFO: renamed from: map, reason: avoid collision after fix types in other method */
    public File map2(Uri r2, Options r3) {
        if (isApplicable(r2) == true) goto L6;
        return null;
    L6:
        if (Intrinsics.areEqual(r2.getScheme(), "file") == false) goto L12;
        String r1 = r2.getPath();
        if (r1 != null) goto L10;
        return null;
    L10:
        return new File(r1);
    L12:
        return new File(r2.toString());
    }

    private final boolean isApplicable(Uri r6) {
        if (Utils.isAssetUri(r6) == true) goto L21;
        String r5 = r6.getScheme();
        if (r5 != null) goto L7;
    L10:
        boolean r7 = true;
    L11:
        if (r7 == false) goto L22;
        String r8 = r6.getPath();
        if (r8 != null) goto L16;
        r8 = "";
    L16:
        if (StringsKt.startsWith$default(r8, IOUtils.DIR_SEPARATOR_UNIX, false, 2, null) == true) goto L18;
        return false;
    L18:
        if (Utils.getFirstPathSegment(r6) != null) goto L20;
        return false;
    L20:
        return true;
    L22:
        return false;
    L7:
        if (Intrinsics.areEqual(r5, "file") == true) goto L10;
        r7 = false;
        goto L11
    L21:
        return false;
    }
}

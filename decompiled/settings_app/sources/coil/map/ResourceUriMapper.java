package coil.map;

import android.content.res.Resources;
import android.net.Uri;
import coil.request.Options;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.commons.io.IOUtils;

/* JADX INFO: compiled from: ResourceUriMapper.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcoil/map/ResourceUriMapper;", "Lcoil/map/Mapper;", "Landroid/net/Uri;", "()V", "isApplicable", "", "data", "map", "options", "Lcoil/request/Options;", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ResourceUriMapper implements Mapper<Uri, Uri> {
    public ResourceUriMapper() {
    }

    @Override // coil.map.Mapper
    public /* bridge */ /* synthetic */ Uri map(Uri r1, Options r2) {
        return map2(r1, r2);
    }

    /* JADX INFO: renamed from: map, reason: avoid collision after fix types in other method */
    public Uri map2(Uri r5, Options r6) {
        if (isApplicable(r5) == true) goto L6;
        return null;
    L6:
        String r4 = r5.getAuthority();
        if (r4 != null) goto L9;
        r4 = "";
    L9:
        Resources r7 = r6.getContext().getPackageManager().getResourcesForApplication(r4);
        List<String> r0 = r5.getPathSegments();
        boolean r1 = false;
        int r8 = r7.getIdentifier(r0.get(1), r0.get(0), r4);
        if (r8 == 0) goto L12;
        r1 = true;
    L12:
        if (r1 == false) goto L16;
        Uri r9 = Uri.parse("android.resource://" + r4 + IOUtils.DIR_SEPARATOR_UNIX + r8);
        Intrinsics.checkNotNullExpressionValue(r9, "parse(this)");
        return r9;
    L16:
        throw new IllegalStateException(("Invalid android.resource URI: " + r5).toString());
    }

    private final boolean isApplicable(Uri r3) {
        if (Intrinsics.areEqual(r3.getScheme(), "android.resource") == false) goto L16;
        String r2 = r3.getAuthority();
        if (r2 != null) goto L7;
    L10:
        boolean r4 = true;
    L11:
        if (r4 == false) goto L13;
        return false;
    L13:
        if (r3.getPathSegments().size() == 2) goto L15;
        return false;
    L15:
        return true;
    L7:
        if (StringsKt.isBlank(r2) == true) goto L10;
        r4 = false;
        goto L11
    L16:
        return false;
    }
}

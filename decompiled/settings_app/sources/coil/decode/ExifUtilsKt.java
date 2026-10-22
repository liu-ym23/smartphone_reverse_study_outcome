package coil.decode;

import coil.util.Utils;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.SetsKt;

/* JADX INFO: compiled from: ExifUtils.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\b\u001a\u00020\u0004*\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0000\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0018\u0010\u0003\u001a\u00020\u0004*\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0006\"\u0018\u0010\u0007\u001a\u00020\u0004*\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0006¨\u0006\u000b"}, d2 = {"RESPECT_PERFORMANCE_MIME_TYPES", "", "", "isRotated", "", "Lcoil/decode/ExifData;", "(Lcoil/decode/ExifData;)Z", "isSwapped", "supports", "Lcoil/decode/ExifOrientationPolicy;", "mimeType", "coil-base_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ExifUtilsKt {
    private static final Set<String> RESPECT_PERFORMANCE_MIME_TYPES = null;

    /* JADX INFO: compiled from: ExifUtils.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[ExifOrientationPolicy.values().length];
            r0[ExifOrientationPolicy.RESPECT_PERFORMANCE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[ExifOrientationPolicy.IGNORE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[ExifOrientationPolicy.RESPECT_ALL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public static final boolean isSwapped(ExifData r2) {
        if (r2.getRotationDegrees() != 90) goto L5;
    L8:
        return true;
    L5:
        if (r2.getRotationDegrees() == 270) goto L8;
        return false;
    }

    public static final boolean isRotated(ExifData r0) {
        if (r0.getRotationDegrees() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    static {
        RESPECT_PERFORMANCE_MIME_TYPES = SetsKt.setOf(new String[]{Utils.MIME_TYPE_JPEG, Utils.MIME_TYPE_WEBP, Utils.MIME_TYPE_HEIC, Utils.MIME_TYPE_HEIF});
    }

    public static final boolean supports(ExifOrientationPolicy r2, String r3) {
        int r4 = WhenMappings.$EnumSwitchMapping$0[r2.ordinal()];
        if (r4 != 1) goto L5;
        if (r3 != null) goto L13;
        return false;
    L13:
        if (RESPECT_PERFORMANCE_MIME_TYPES.contains(r3) == true) goto L16;
        return false;
    L16:
        return true;
    L5:
        if (r4 != 2) goto L7;
        return false;
    L7:
        if (r4 == 3) goto L16;
        throw new NoWhenBranchMatchedException();
    }
}

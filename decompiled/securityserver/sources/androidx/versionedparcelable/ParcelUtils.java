package androidx.versionedparcelable;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ParcelUtils {
    private static final String INNER_BUNDLE_KEY = "a";

    private ParcelUtils() {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static <T extends VersionedParcelable> T fromInputStream(InputStream r2) {
        return (T) new VersionedParcelStream(r2, null).readVersionedParcelable();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static <T extends VersionedParcelable> T fromParcelable(Parcelable r1) {
        if ((r1 instanceof ParcelImpl) == false) goto L7;
        return (T) ((ParcelImpl) r1).getVersionedParcel();
    L7:
        throw new IllegalArgumentException("Invalid parcel");
    }

    @Nullable
    public static <T extends VersionedParcelable> T getVersionedParcelable(@NonNull Bundle r1, @NonNull String r2) {
        Bundle r3 = (Bundle) r1.getParcelable(r2);     // Catch: RuntimeException -> L8
        if (r3 != null) goto L6;
        return null;
    L6:
        r3.setClassLoader(ParcelUtils.class.getClassLoader());     // Catch: RuntimeException -> L8
        return (T) fromParcelable(r3.getParcelable(INNER_BUNDLE_KEY));
    L8:
        return null;
    }

    @Nullable
    public static <T extends VersionedParcelable> List<T> getVersionedParcelableList(Bundle r1, String r2) {
        ArrayList r0 = new ArrayList();
        Bundle r3 = (Bundle) r1.getParcelable(r2);     // Catch: RuntimeException -> L9
        r3.setClassLoader(ParcelUtils.class.getClassLoader());     // Catch: RuntimeException -> L9
        Iterator r4 = r3.getParcelableArrayList(INNER_BUNDLE_KEY).iterator();     // Catch: RuntimeException -> L9
    L5:
        if (r4.hasNext() == false) goto L8;
        r0.add(fromParcelable((Parcelable) r4.next()));     // Catch: RuntimeException -> L9
        goto L5
    L8:
        return r0;
    L9:
        return null;
    }

    public static void putVersionedParcelable(@NonNull Bundle r2, @NonNull String r3, @Nullable VersionedParcelable r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        Bundle r0 = new Bundle();
        r0.putParcelable(INNER_BUNDLE_KEY, toParcelable(r4));
        r2.putParcelable(r3, r0);
    }

    public static void putVersionedParcelableList(@NonNull Bundle r3, @NonNull String r4, @NonNull List<? extends VersionedParcelable> r5) {
        Bundle r0 = new Bundle();
        ArrayList<? extends Parcelable> r1 = new ArrayList();
        Iterator<? extends VersionedParcelable> r6 = r5.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        r1.add(toParcelable(r6.next()));
        goto L4
    L6:
        r0.putParcelableArrayList(INNER_BUNDLE_KEY, r1);
        r3.putParcelable(r4, r0);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static void toOutputStream(VersionedParcelable r2, OutputStream r3) {
        VersionedParcelStream r0 = new VersionedParcelStream(null, r3);
        r0.writeVersionedParcelable(r2);
        r0.closeField();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Parcelable toParcelable(VersionedParcelable r1) {
        return new ParcelImpl(r1);
    }
}

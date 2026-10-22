package androidx.core.content;

import android.content.LocusId;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;

/* JADX INFO: loaded from: classes.dex */
public final class LocusIdCompat {
    private final String mId;
    private final LocusId mWrapped;

    @RequiresApi(29)
    private static class Api29Impl {
        private Api29Impl() {
        }

        @NonNull
        static LocusId create(@NonNull String r1) {
            return new LocusId(r1);
        }

        @NonNull
        static String getId(@NonNull LocusId r0) {
            return r0.getId();
        }
    }

    public LocusIdCompat(@NonNull String r3) {
        this.mId = (String) Preconditions.checkStringNotEmpty(r3, "id cannot be empty");
        if (Build.VERSION.SDK_INT < 29) goto L5;
        LocusId r4 = Api29Impl.create(r3);
    L6:
        this.mWrapped = r4;
        return;
    L5:
        r4 = null;
        goto L6
    }

    @NonNull
    private String getSanitizedId() {
        return this.mId.length() + "_chars";
    }

    @NonNull
    @RequiresApi(29)
    public static LocusIdCompat toLocusIdCompat(@NonNull LocusId r2) {
        Preconditions.checkNotNull(r2, "locusId cannot be null");
        return new LocusIdCompat((String) Preconditions.checkStringNotEmpty(Api29Impl.getId(r2), "id cannot be empty"));
    }

    public boolean equals(@Nullable Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (LocusIdCompat.class == r5.getClass()) goto L11;
        return false;
    L11:
        LocusIdCompat r6 = (LocusIdCompat) r5;
        String r4 = this.mId;
        if (r4 != null) goto L19;
        if (r6.mId != null) goto L17;
        return true;
    L17:
        return false;
    L19:
        return r4.equals(r6.mId);
    }

    @NonNull
    public String getId() {
        return this.mId;
    }

    public int hashCode() {
        String r1 = this.mId;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return 31 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    @NonNull
    @RequiresApi(29)
    public LocusId toLocusId() {
        return this.mWrapped;
    }

    @NonNull
    public String toString() {
        return "LocusIdCompat[" + getSanitizedId() + "]";
    }
}

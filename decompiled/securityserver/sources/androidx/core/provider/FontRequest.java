package androidx.core.provider;

import android.util.Base64;
import androidx.annotation.ArrayRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class FontRequest {
    private final List<List<byte[]>> mCertificates;
    private final int mCertificatesArray;
    private final String mIdentifier;
    private final String mProviderAuthority;
    private final String mProviderPackage;
    private final String mQuery;

    public FontRequest(@NonNull String r1, @NonNull String r2, @NonNull String r3, @NonNull List<List<byte[]>> r4) {
        String r5 = (String) Preconditions.checkNotNull(r1);
        this.mProviderAuthority = r5;
        String r6 = (String) Preconditions.checkNotNull(r2);
        this.mProviderPackage = r6;
        String r7 = (String) Preconditions.checkNotNull(r3);
        this.mQuery = r7;
        this.mCertificates = (List) Preconditions.checkNotNull(r4);
        this.mCertificatesArray = 0;
        this.mIdentifier = r5 + "-" + r6 + "-" + r7;
    }

    @Nullable
    public List<List<byte[]>> getCertificates() {
        return this.mCertificates;
    }

    @ArrayRes
    public int getCertificatesArrayResId() {
        return this.mCertificatesArray;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public String getIdentifier() {
        return this.mIdentifier;
    }

    @NonNull
    public String getProviderAuthority() {
        return this.mProviderAuthority;
    }

    @NonNull
    public String getProviderPackage() {
        return this.mProviderPackage;
    }

    @NonNull
    public String getQuery() {
        return this.mQuery;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("FontRequest {mProviderAuthority: " + this.mProviderAuthority + ", mProviderPackage: " + this.mProviderPackage + ", mQuery: " + this.mQuery + ", mCertificates:");
        int r2 = 0;
    L4:
        if (r2 >= this.mCertificates.size()) goto L10;
        r0.append(" [");
        List<byte[]> r3 = this.mCertificates.get(r2);
        int r4 = 0;
    L7:
        if (r4 >= r3.size()) goto L9;
        r0.append(" \"");
        r0.append(Base64.encodeToString(r3.get(r4), 0));
        r0.append("\"");
        r4 = r4 + 1;
        goto L7
    L9:
        r0.append(" ]");
        r2 = r2 + 1;
        goto L4
    L10:
        r0.append("}");
        r0.append("mCertificatesArray: " + this.mCertificatesArray);
        return r0.toString();
    }

    public FontRequest(@NonNull String r2, @NonNull String r3, @NonNull String r4, @ArrayRes int r5) {
        String r6 = (String) Preconditions.checkNotNull(r2);
        this.mProviderAuthority = r6;
        String r7 = (String) Preconditions.checkNotNull(r3);
        this.mProviderPackage = r7;
        String r8 = (String) Preconditions.checkNotNull(r4);
        this.mQuery = r8;
        this.mCertificates = null;
        if (r5 == 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0);
        this.mCertificatesArray = r5;
        this.mIdentifier = r6 + "-" + r7 + "-" + r8;
        return;
    L5:
        r0 = false;
        goto L6
    }
}

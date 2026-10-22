package androidx.core.provider;

import android.util.Base64;
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

    public FontRequest(String r2, String r3, String r4, List<List<byte[]>> r5) {
        this.mProviderAuthority = (String) Preconditions.checkNotNull(r2);
        this.mProviderPackage = (String) Preconditions.checkNotNull(r3);
        this.mQuery = (String) Preconditions.checkNotNull(r4);
        this.mCertificates = (List) Preconditions.checkNotNull(r5);
        this.mCertificatesArray = 0;
        this.mIdentifier = createIdentifier(r2, r3, r4);
    }

    public FontRequest(String r2, String r3, String r4, int r5) {
        this.mProviderAuthority = (String) Preconditions.checkNotNull(r2);
        this.mProviderPackage = (String) Preconditions.checkNotNull(r3);
        this.mQuery = (String) Preconditions.checkNotNull(r4);
        this.mCertificates = null;
        if (r5 == 0) goto L5;
        boolean r0 = true;
    L6:
        Preconditions.checkArgument(r0);
        this.mCertificatesArray = r5;
        this.mIdentifier = createIdentifier(r2, r3, r4);
        return;
    L5:
        r0 = false;
        goto L6
    }

    private String createIdentifier(String r1, String r2, String r3) {
        return r1 + "-" + r2 + "-" + r3;
    }

    public String getProviderAuthority() {
        return this.mProviderAuthority;
    }

    public String getProviderPackage() {
        return this.mProviderPackage;
    }

    public String getQuery() {
        return this.mQuery;
    }

    public List<List<byte[]>> getCertificates() {
        return this.mCertificates;
    }

    public int getCertificatesArrayResId() {
        return this.mCertificatesArray;
    }

    @Deprecated
    public String getIdentifier() {
        return this.mIdentifier;
    }

    String getId() {
        return this.mIdentifier;
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
}

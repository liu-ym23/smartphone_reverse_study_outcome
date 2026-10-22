package coil.fetch;

import android.icu.text.PluralRules;
import coil.decode.DataSource;
import coil.decode.ImageSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FetchResult.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ&\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0016"}, d2 = {"Lcoil/fetch/SourceResult;", "Lcoil/fetch/FetchResult;", "source", "Lcoil/decode/ImageSource;", "mimeType", "", "dataSource", "Lcoil/decode/DataSource;", "(Lcoil/decode/ImageSource;Ljava/lang/String;Lcoil/decode/DataSource;)V", "getDataSource", "()Lcoil/decode/DataSource;", "getMimeType", "()Ljava/lang/String;", "getSource", "()Lcoil/decode/ImageSource;", "copy", "equals", "", PluralRules.KEYWORD_OTHER, "", "hashCode", "", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SourceResult extends FetchResult {
    private final DataSource dataSource;
    private final String mimeType;
    private final ImageSource source;

    public final ImageSource getSource() {
        return this.source;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final DataSource getDataSource() {
        return this.dataSource;
    }

    public SourceResult(ImageSource r2, String r3, DataSource r4) {
        super(null);
        this.source = r2;
        this.mimeType = r3;
        this.dataSource = r4;
    }

    public static /* synthetic */ SourceResult copy$default(SourceResult r0, ImageSource r1, String r2, DataSource r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.source;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.mimeType;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.dataSource;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final SourceResult copy(ImageSource r1, String r2, DataSource r3) {
        return new SourceResult(r1, r2, r3);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof SourceResult) == false) goto L14;
        SourceResult r5 = (SourceResult) r4;
        if (Intrinsics.areEqual(this.source, r5.source) == false) goto L14;
        if (Intrinsics.areEqual(this.mimeType, r5.mimeType) == false) goto L14;
        if (this.dataSource != r5.dataSource) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        int r0 = this.source.hashCode() * 31;
        String r1 = this.mimeType;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L7:
        return ((r0 + r2) * 31) + this.dataSource.hashCode();
    L5:
        r2 = 0;
        goto L7
    }
}

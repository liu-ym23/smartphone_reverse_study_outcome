package androidx.slice;

import androidx.versionedparcelable.VersionedParcelable;

/* JADX INFO: loaded from: classes.dex */
public final class SliceSpec implements VersionedParcelable {
    int mRevision;
    String mType;

    public SliceSpec() {
    }

    public SliceSpec(String r1, int r2) {
        this.mType = r1;
        this.mRevision = r2;
    }

    public String getType() {
        return this.mType;
    }

    public int getRevision() {
        return this.mRevision;
    }

    public boolean canRender(SliceSpec r3) {
        if (this.mType.equals(r3.mType) == true) goto L6;
        return false;
    L6:
        if (this.mRevision < r3.mRevision) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean equals(Object r4) {
        if ((r4 instanceof SliceSpec) == true) goto L5;
        return false;
    L5:
        SliceSpec r5 = (SliceSpec) r4;
        if (this.mType.equals(r5.mType) == true) goto L8;
        return false;
    L8:
        if (this.mRevision != r5.mRevision) goto L12;
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        return this.mType.hashCode() + this.mRevision;
    }

    public String toString() {
        return String.format("SliceSpec{%s,%d}", new Object[]{this.mType, Integer.valueOf(this.mRevision)});
    }
}

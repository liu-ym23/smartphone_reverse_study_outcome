package com.obric.capabilitykit.common.intent;

import android.icu.text.PluralRules;
import android.os.Parcel;
import android.os.Parcelable;
import com.android.launcher3.icons.cache.BaseIconCache;
import com.obric.capabilitykit.common.execution.urishare.IUriSharableParams;
import com.obric.capabilitykit.entity.app.AlbumEntity;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import com.obric.versionedparcelable.ParcelUtils;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PhotoRemovePhotosFromAlbumParams.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B#\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0016\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ,\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0016J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\u0010\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001eH\u0016J\t\u0010\u001f\u001a\u00020\u0018HÖ\u0001J\b\u0010 \u001a\u00020\u001aH\u0016J\u0012\u0010!\u001a\u00020\u00012\b\u0010\"\u001a\u0004\u0018\u00010\u001cH\u0016J\t\u0010#\u001a\u00020$HÖ\u0001J\u0019\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0018HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006*"}, d2 = {"Lcom/obric/capabilitykit/common/intent/PhotoRemovePhotosFromAlbumParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharableParams;", "album", "Lcom/obric/capabilitykit/entity/app/AlbumEntity;", "photos", "", "Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "(Lcom/obric/capabilitykit/entity/app/AlbumEntity;[Lcom/obric/capabilitykit/entity/app/PhotoEntity;)V", "getAlbum", "()Lcom/obric/capabilitykit/entity/app/AlbumEntity;", "setAlbum", "(Lcom/obric/capabilitykit/entity/app/AlbumEntity;)V", "getPhotos", "()[Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "setPhotos", "([Lcom/obric/capabilitykit/entity/app/PhotoEntity;)V", "[Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "component1", "component2", "copy", "(Lcom/obric/capabilitykit/entity/app/AlbumEntity;[Lcom/obric/capabilitykit/entity/app/PhotoEntity;)Lcom/obric/capabilitykit/common/intent/PhotoRemovePhotosFromAlbumParams;", "describeContents", "", "equals", "", PluralRules.KEYWORD_OTHER, "", "getUriSharableParams", "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", BaseIconCache.IconDB.COLUMN_FLAGS, "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PhotoRemovePhotosFromAlbumParams implements IntentParams, Parcelable, IUriSharableParams {
    public static final Parcelable.Creator<PhotoRemovePhotosFromAlbumParams> CREATOR = null;
    private AlbumEntity album;
    private PhotoEntity[] photos;

    /* JADX INFO: compiled from: PhotoRemovePhotosFromAlbumParams.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PhotoRemovePhotosFromAlbumParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PhotoRemovePhotosFromAlbumParams createFromParcel(Parcel r8) {
            int r0 = r8.readInt();
            Intrinsics.checkNotNullParameter(r8, "parcel");
            AlbumEntity r1 = (AlbumEntity) r8.readParcelable(PhotoRemovePhotosFromAlbumParams.class.getClassLoader());
            if (r8.readInt() != 0) goto L5;
            PhotoEntity[] r2 = null;
        L9:
            PhotoRemovePhotosFromAlbumParams r4 = new PhotoRemovePhotosFromAlbumParams(r1, r2);
            int r3 = Math.min(r0, 0);
            ClassLoader r7 = getClass().getClassLoader();
            int r5 = 1;
        L10:
            if (r5 > r3) goto L12;
            r5 = r5 + 1;
        L12:
            if (r5 > r0) goto L14;
            ParcelUtils.skipValueSafely(r8, r7);
            r5 = r5 + 1;
            goto L12
        L14:
            return r4;
        L5:
            int r6 = r8.readInt();
            PhotoEntity[] r9 = new PhotoEntity[r6];
            int r10 = 0;
        L6:
            if (r10 == r6) goto L8;
            r9[r10] = (PhotoEntity) r8.readParcelable(PhotoRemovePhotosFromAlbumParams.class.getClassLoader());
            r10 = r10 + 1;
            goto L6
        L8:
            r2 = r9;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PhotoRemovePhotosFromAlbumParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PhotoRemovePhotosFromAlbumParams[] newArray(int r1) {
            return new PhotoRemovePhotosFromAlbumParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PhotoRemovePhotosFromAlbumParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new Creator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PhotoRemovePhotosFromAlbumParams() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ PhotoRemovePhotosFromAlbumParams copy$default(PhotoRemovePhotosFromAlbumParams r0, AlbumEntity r1, PhotoEntity[] r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.album;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.photos;
    L9:
        return r0.copy(r1, r2);
    }

    public final AlbumEntity component1() {
        return this.album;
    }

    public final PhotoEntity[] component2() {
        return this.photos;
    }

    public final PhotoRemovePhotosFromAlbumParams copy(AlbumEntity r1, PhotoEntity[] r2) {
        return new PhotoRemovePhotosFromAlbumParams(r1, r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PhotoRemovePhotosFromAlbumParams) == true) goto L8;
        return false;
    L8:
        PhotoRemovePhotosFromAlbumParams r6 = (PhotoRemovePhotosFromAlbumParams) r5;
        if (Intrinsics.areEqual(this.album, r6.album) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.photos, r6.photos) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        AlbumEntity r0 = this.album;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        PhotoEntity[] r4 = this.photos;
        if (r4 == null) goto L11;
        r1 = Arrays.hashCode(r4);
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "PhotoRemovePhotosFromAlbumParams(album=" + this.album + ", photos=" + Arrays.toString(this.photos) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r4, int r5) {
        int r0 = 0;
        r4.writeInt(0);
        Intrinsics.checkNotNullParameter(r4, "out");
        r4.writeParcelable(this.album, r5);
        PhotoEntity[] r3 = this.photos;
        if (r3 != null) goto L5;
        r4.writeInt(0);
        return;
    L5:
        r4.writeInt(1);
        int r1 = r3.length;
        r4.writeInt(r1);
    L6:
        if (r0 == r1) goto L10;
        r4.writeParcelable(r3[r0], r5);
        r0 = r0 + 1;
        goto L6
    }

    public PhotoRemovePhotosFromAlbumParams(AlbumEntity r1, PhotoEntity[] r2) {
        this.album = r1;
        this.photos = r2;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    public /* synthetic */ PhotoRemovePhotosFromAlbumParams(AlbumEntity r2, PhotoEntity[] r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    public final AlbumEntity getAlbum() {
        return this.album;
    }

    public final void setAlbum(AlbumEntity r1) {
        this.album = r1;
    }

    public final PhotoEntity[] getPhotos() {
        return this.photos;
    }

    public final void setPhotos(PhotoEntity[] r1) {
        this.photos = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        if (this.album == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r2) {
        if ((r2 instanceof PhotoRemovePhotosFromAlbumParams) == false) goto L5;
        AlbumEntity r0 = this.album;
        if (r0 != null) goto L9;
        r0 = ((PhotoRemovePhotosFromAlbumParams) r2).album;
    L9:
        PhotoEntity[] r1 = this.photos;
        if (r1 != null) goto L13;
        r1 = ((PhotoRemovePhotosFromAlbumParams) r2).photos;
    L13:
        return new PhotoRemovePhotosFromAlbumParams(r0, r1);
    L5:
        return this;
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharableParams
    public List<Object> getUriSharableParams() {
        return CollectionsKt.listOf(new Object[]{this.album, this.photos});
    }
}

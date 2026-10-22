package androidx.core.os;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class ParcelableCompat {

    static class ParcelableCompatCreatorHoneycombMR2<T> implements Parcelable.ClassLoaderCreator<T> {
        private final ParcelableCompatCreatorCallbacks<T> mCallbacks;

        ParcelableCompatCreatorHoneycombMR2(ParcelableCompatCreatorCallbacks<T> r1) {
            this.mCallbacks = r1;
        }

        @Override // android.os.Parcelable.Creator
        public T createFromParcel(Parcel r2) {
            return this.mCallbacks.createFromParcel(r2, null);
        }

        @Override // android.os.Parcelable.ClassLoaderCreator
        public T createFromParcel(Parcel r1, ClassLoader r2) {
            return this.mCallbacks.createFromParcel(r1, r2);
        }

        @Override // android.os.Parcelable.Creator
        public T[] newArray(int r1) {
            return this.mCallbacks.newArray(r1);
        }
    }

    @Deprecated
    public static <T> Parcelable.Creator<T> newCreator(ParcelableCompatCreatorCallbacks<T> r1) {
        return new ParcelableCompatCreatorHoneycombMR2(r1);
    }

    private ParcelableCompat() {
    }
}

package androidx.core.os;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class ParcelCompat {

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static final <T extends Parcelable> List<T> readParcelableList(@NonNull Parcel r0, @NonNull List<T> r1, @Nullable ClassLoader r2) {
            return r0.readParcelableList(r1, r2);
        }
    }

    @RequiresApi(30)
    static class Api30Impl {
        private Api30Impl() {
        }

        @DoNotInline
        static final Parcelable.Creator<?> readParcelableCreator(@NonNull Parcel r0, @Nullable ClassLoader r1) {
            return r0.readParcelableCreator(r1);
        }
    }

    @RequiresApi(33)
    static class TiramisuImpl {
        private TiramisuImpl() {
        }

        @DoNotInline
        public static <T> T[] readArray(Parcel r0, ClassLoader r1, Class<T> r2) {
            return (T[]) r0.readArray(r1, r2);
        }

        @DoNotInline
        public static <T> ArrayList<T> readArrayList(Parcel r0, ClassLoader r1, Class<? extends T> r2) {
            return r0.readArrayList(r1, r2);
        }

        @DoNotInline
        public static <V, K> HashMap<K, V> readHashMap(Parcel r0, ClassLoader r1, Class<? extends K> r2, Class<? extends V> r3) {
            return r0.readHashMap(r1, r2, r3);
        }

        @DoNotInline
        public static <T> void readList(@NonNull Parcel r0, @NonNull List<? super T> r1, @Nullable ClassLoader r2, @NonNull Class<T> r3) {
            r0.readList(r1, r2, r3);
        }

        @DoNotInline
        public static <K, V> void readMap(Parcel r0, Map<? super K, ? super V> r1, ClassLoader r2, Class<K> r3, Class<V> r4) {
            r0.readMap(r1, r2, r3, r4);
        }

        @DoNotInline
        static <T extends Parcelable> T readParcelable(@NonNull Parcel r0, @Nullable ClassLoader r1, @NonNull Class<T> r2) {
            return (T) r0.readParcelable(r1, r2);
        }

        @DoNotInline
        static <T> T[] readParcelableArray(@NonNull Parcel r0, @Nullable ClassLoader r1, @NonNull Class<T> r2) {
            return (T[]) r0.readParcelableArray(r1, r2);
        }

        @DoNotInline
        public static <T> Parcelable.Creator<T> readParcelableCreator(Parcel r0, ClassLoader r1, Class<T> r2) {
            return r0.readParcelableCreator(r1, r2);
        }

        @DoNotInline
        static <T> List<T> readParcelableList(@NonNull Parcel r0, @NonNull List<T> r1, @Nullable ClassLoader r2, @NonNull Class<T> r3) {
            return r0.readParcelableList(r1, r2, r3);
        }

        @DoNotInline
        static <T extends Serializable> T readSerializable(@NonNull Parcel r0, @Nullable ClassLoader r1, @NonNull Class<T> r2) {
            return (T) r0.readSerializable(r1, r2);
        }

        @DoNotInline
        public static <T> SparseArray<T> readSparseArray(Parcel r0, ClassLoader r1, Class<? extends T> r2) {
            return r0.readSparseArray(r1, r2);
        }
    }

    private ParcelCompat() {
    }

    @Nullable
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    @SuppressLint({"ArrayReturn", "NullableCollection"})
    public static <T> T[] readArray(@NonNull Parcel r1, @Nullable ClassLoader r2, @NonNull Class<T> r3) {
        if (BuildCompat.isAtLeastT() == false) goto L7;
        return (T[]) TiramisuImpl.readArray(r1, r2, r3);
    L7:
        return (T[]) r1.readArray(r2);
    }

    @Nullable
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    @SuppressLint({"ConcreteCollection", "NullableCollection"})
    public static <T> ArrayList<T> readArrayList(@NonNull Parcel r1, @Nullable ClassLoader r2, @NonNull Class<? extends T> r3) {
        if (BuildCompat.isAtLeastT() == false) goto L7;
        return TiramisuImpl.readArrayList(r1, r2, r3);
    L7:
        return r1.readArrayList(r2);
    }

    public static boolean readBoolean(@NonNull Parcel r0) {
        if (r0.readInt() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Nullable
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    @SuppressLint({"ConcreteCollection", "NullableCollection"})
    public static <K, V> HashMap<K, V> readHashMap(@NonNull Parcel r1, @Nullable ClassLoader r2, @NonNull Class<? extends K> r3, @NonNull Class<? extends V> r4) {
        if (BuildCompat.isAtLeastT() == false) goto L7;
        return TiramisuImpl.readHashMap(r1, r2, r3, r4);
    L7:
        return r1.readHashMap(r2);
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public static <T> void readList(@NonNull Parcel r1, @NonNull List<? super T> r2, @Nullable ClassLoader r3, @NonNull Class<T> r4) {
        if (BuildCompat.isAtLeastT() == false) goto L5;
        TiramisuImpl.readList(r1, r2, r3, r4);
        return;
    L5:
        r1.readList(r2, r3);
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public static <K, V> void readMap(@NonNull Parcel r1, @NonNull Map<? super K, ? super V> r2, @Nullable ClassLoader r3, @NonNull Class<K> r4, @NonNull Class<V> r5) {
        if (BuildCompat.isAtLeastT() == false) goto L5;
        TiramisuImpl.readMap(r1, r2, r3, r4, r5);
        return;
    L5:
        r1.readMap(r2, r3);
    }

    @Nullable
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public static <T extends Parcelable> T readParcelable(@NonNull Parcel r1, @Nullable ClassLoader r2, @NonNull Class<T> r3) {
        if (BuildCompat.isAtLeastT() == false) goto L7;
        return (T) TiramisuImpl.readParcelable(r1, r2, r3);
    L7:
        return (T) r1.readParcelable(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    @SuppressLint({"ArrayReturn", "NullableCollection"})
    public static <T> T[] readParcelableArray(@NonNull Parcel r1, @Nullable ClassLoader r2, @NonNull Class<T> r3) {
        if (BuildCompat.isAtLeastT() == false) goto L7;
        return (T[]) TiramisuImpl.readParcelableArray(r1, r2, r3);
    L7:
        return (T[]) r1.readParcelableArray(r2);
    }

    @Nullable
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    @RequiresApi(30)
    public static <T> Parcelable.Creator<T> readParcelableCreator(@NonNull Parcel r1, @Nullable ClassLoader r2, @NonNull Class<T> r3) {
        if (BuildCompat.isAtLeastT() == false) goto L7;
        return TiramisuImpl.readParcelableCreator(r1, r2, r3);
    L7:
        return (Parcelable.Creator<T>) Api30Impl.readParcelableCreator(r1, r2);
    }

    @NonNull
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    @RequiresApi(api = 29)
    public static <T> List<T> readParcelableList(@NonNull Parcel r1, @NonNull List<T> r2, @Nullable ClassLoader r3, @NonNull Class<T> r4) {
        if (BuildCompat.isAtLeastT() == false) goto L7;
        return TiramisuImpl.readParcelableList(r1, r2, r3, r4);
    L7:
        return Api29Impl.readParcelableList(r1, r2, r3);
    }

    @Nullable
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public static <T extends Serializable> T readSerializable(@NonNull Parcel r1, @Nullable ClassLoader r2, @NonNull Class<T> r3) {
        if (BuildCompat.isAtLeastT() == false) goto L7;
        return (T) TiramisuImpl.readSerializable(r1, r2, r3);
    L7:
        return (T) r1.readSerializable();
    }

    @Nullable
    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public static <T> SparseArray<T> readSparseArray(@NonNull Parcel r1, @Nullable ClassLoader r2, @NonNull Class<? extends T> r3) {
        if (BuildCompat.isAtLeastT() == false) goto L7;
        return TiramisuImpl.readSparseArray(r1, r2, r3);
    L7:
        return r1.readSparseArray(r2);
    }

    public static void writeBoolean(@NonNull Parcel r0, boolean r1) {
        r0.writeInt(r1 ? 1 : 0);
    }
}

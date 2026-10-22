package androidx.customview.view;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public abstract class AbsSavedState implements Parcelable {
    public static final Parcelable.Creator<AbsSavedState> CREATOR = null;
    public static final AbsSavedState EMPTY_STATE = null;
    private final Parcelable mSuperState;

    static {
        EMPTY_STATE = new AnonymousClass1();
        CREATOR = new AnonymousClass2();
    }

    private AbsSavedState() {
        this.mSuperState = null;
    }

    protected AbsSavedState(@NonNull Parcel r2) {
        this(r2, null);
    }

    protected AbsSavedState(@NonNull Parcel r1, @Nullable ClassLoader r2) {
        Parcelable r3 = r1.readParcelable(r2);
        if (r3 != null) goto L6;
        r3 = EMPTY_STATE;
    L6:
        this.mSuperState = r3;
    }

    protected AbsSavedState(@NonNull Parcelable r2) {
        if (r2 == null) goto L11;
        if (r2 != EMPTY_STATE) goto L8;
        r2 = null;
    L8:
        this.mSuperState = r2;
        return;
    L11:
        throw new IllegalArgumentException("superState must not be null");
    }

    /* synthetic */ AbsSavedState(AnonymousClass1 r1) {
        this();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final Parcelable getSuperState() {
        return this.mSuperState;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeParcelable(this.mSuperState, r2);
    }
}

package com.obric.oui.progress;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

/* JADX INFO: loaded from: classes2.dex */
class OProgressView$SavedState extends View.BaseSavedState {
    public static final Parcelable.Creator<OProgressView$SavedState> CREATOR = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f11309f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f11310g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f11311h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f11312i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    int f11313j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    int f11314k;

    class a implements Parcelable.Creator<OProgressView$SavedState> {
        a() {
        }

        public OProgressView$SavedState a(Parcel r2) {
            return new OProgressView$SavedState(r2, null);
        }

        public OProgressView$SavedState[] b(int r1) {
            return new OProgressView$SavedState[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OProgressView$SavedState createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OProgressView$SavedState[] newArray(int r1) {
            return b(r1);
        }
    }

    static {
        CREATOR = new a();
    }

    private OProgressView$SavedState(Parcel r2) {
        super(r2);
        this.f11309f = r2.readInt();
        this.f11310g = r2.readInt();
        this.f11311h = r2.readInt();
        this.f11312i = r2.readInt();
        this.f11313j = r2.readInt();
        this.f11314k = r2.readInt();
    }

    /* synthetic */ OProgressView$SavedState(Parcel r1, com.obric.oui.progress.a r2) {
        this(r1);
    }

    @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        super.writeToParcel(r1, r2);
        r1.writeInt(this.f11309f);
        r1.writeInt(this.f11310g);
        r1.writeInt(this.f11311h);
        r1.writeInt(this.f11312i);
        r1.writeInt(this.f11313j);
        r1.writeInt(this.f11314k);
    }
}

package androidx.viewpager2.adapter;

import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public interface StatefulAdapter {
    void restoreState(Parcelable r1);

    Parcelable saveState();
}

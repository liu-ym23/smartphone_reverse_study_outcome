package com.android.settingslib.drawer;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DashboardCategory implements Parcelable {
    public static final Parcelable.Creator<DashboardCategory> CREATOR = null;
    public final String key;
    private List<Tile> mTiles;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public DashboardCategory(String r2) {
        this.mTiles = new ArrayList();
        this.key = r2;
    }

    DashboardCategory(Parcel r5) {
        this.mTiles = new ArrayList();
        this.key = r5.readString();
        int r0 = r5.readInt();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        Tile r2 = Tile.CREATOR.createFromParcel(r5);
        this.mTiles.add(r2);
        r1 = r1 + 1;
        goto L3
    }

    public synchronized List<Tile> getTiles() {
        monitor-enter(this);
        ArrayList r0 = new ArrayList(this.mTiles.size());     // Catch: Throwable -> L10
        Iterator<Tile> r1 = this.mTiles.iterator();     // Catch: Throwable -> L10
    L5:
        if (r1.hasNext() == false) goto L8;
        r0.add(r1.next());     // Catch: Throwable -> L10
        goto L5
    L8:
        monitor-exit(this);
        return r0;
    L10:
        th = move-exception;
        throw th;
    }

    public synchronized void addTile(Tile r2) {
        monitor-enter(this);
        this.mTiles.add(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void removeTile(int r2) {
        monitor-enter(this);
        this.mTiles.remove(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public int getTilesCount() {
        return this.mTiles.size();
    }

    public Tile getTile(int r1) {
        return this.mTiles.get(r1);
    }

    public void sortTiles() {
        Collections.sort(this.mTiles, Tile.TILE_COMPARATOR);
    }

    public synchronized void sortTiles(final String r3) {
        monitor-enter(this);
        Collections.sort(this.mTiles, new DashboardCategory$$ExternalSyntheticLambda0(r3));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ int lambda$sortTiles$0(String r2, Tile r3, Tile r4) {
        int r0 = r4.getOrder() - r3.getOrder();
        if (r0 == 0) goto L5;
        return r0;
    L5:
        String r5 = r3.getPackageName();
        String r6 = r4.getPackageName();
        int r1 = String.CASE_INSENSITIVE_ORDER.compare(r5, r6);
        if (r1 != 0) goto L8;
    L15:
        return r1;
    L8:
        if (TextUtils.equals(r5, r2) == false) goto L12;
        return -1;
    L12:
        if (TextUtils.equals(r6, r2) == false) goto L15;
        return 1;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r4, int r5) {
        r4.writeString(this.key);
        int r0 = this.mTiles.size();
        r4.writeInt(r0);
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L5;
        this.mTiles.get(r1).writeToParcel(r4, r5);
        r1 = r1 + 1;
        goto L3
    }

    static {
        CREATOR = new AnonymousClass1();
    }
}

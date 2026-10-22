package androidx.recyclerview.widget;

import android.util.SparseArray;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes.dex */
class TileList<T> {
    Tile<T> mLastAccessedTile;
    final int mTileSize;
    private final SparseArray<Tile<T>> mTiles;

    public static class Tile<T> {
        public int mItemCount;
        public final T[] mItems;
        Tile<T> mNext;
        public int mStartPosition;

        Tile(Class<T> r1, int r2) {
            this.mItems = (T[]) ((Object[]) Array.newInstance(r1, r2));
        }

        boolean containsPosition(int r2) {
            int r0 = this.mStartPosition;
            if (r0 <= r2) goto L5;
        L7:
            return false;
        L5:
            if (r2 >= (r0 + this.mItemCount)) goto L7;
            return true;
        }

        T getByPosition(int r2) {
            return this.mItems[r2 - this.mStartPosition];
        }
    }

    public TileList(int r3) {
        this.mTiles = new SparseArray(10);
        this.mTileSize = r3;
    }

    public T getItemAt(int r3) {
        Tile<T> r0 = this.mLastAccessedTile;
        if (r0 != null) goto L5;
    L6:
        int r1 = r3 - (r3 % this.mTileSize);
        int r2 = this.mTiles.indexOfKey(r1);
        if (r2 >= 0) goto L10;
        return null;
    L10:
        this.mLastAccessedTile = this.mTiles.valueAt(r2);
    L12:
        return this.mLastAccessedTile.getByPosition(r3);
    L5:
        if (r0.containsPosition(r3) == true) goto L12;
        goto L6
    }

    public int size() {
        return this.mTiles.size();
    }

    public void clear() {
        this.mTiles.clear();
    }

    public Tile<T> getAtIndex(int r2) {
        if (r2 >= 0) goto L4;
        return null;
    L4:
        if (r2 < this.mTiles.size()) goto L7;
        return null;
    L7:
        return this.mTiles.valueAt(r2);
    }

    public Tile<T> addOrReplace(Tile<T> r4) {
        int r0 = this.mTiles.indexOfKey(r4.mStartPosition);
        if (r0 >= 0) goto L6;
        this.mTiles.put(r4.mStartPosition, r4);
        return null;
    L6:
        Tile<T> r1 = this.mTiles.valueAt(r0);
        this.mTiles.setValueAt(r0, r4);
        if (this.mLastAccessedTile != r1) goto L9;
        this.mLastAccessedTile = r4;
    L9:
        return r1;
    }

    public Tile<T> removeAtPos(int r3) {
        Tile<T> r0 = this.mTiles.get(r3);
        if (this.mLastAccessedTile != r0) goto L5;
        this.mLastAccessedTile = null;
    L5:
        this.mTiles.delete(r3);
        return r0;
    }
}

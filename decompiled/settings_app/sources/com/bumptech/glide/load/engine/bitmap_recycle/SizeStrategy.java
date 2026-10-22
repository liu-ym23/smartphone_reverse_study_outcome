package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import com.bumptech.glide.util.Util;
import java.util.NavigableMap;

/* JADX INFO: loaded from: classes3.dex */
final class SizeStrategy implements LruPoolStrategy {
    private static final int MAX_SIZE_MULTIPLE = 8;
    private final GroupedLinkedMap<Key, Bitmap> groupedMap;
    private final KeyPool keyPool;
    private final NavigableMap<Integer, Integer> sortedSizes;

    static final class Key implements Poolable {
        private final KeyPool pool;
        int size;

        Key(KeyPool r1) {
            this.pool = r1;
        }

        public void init(int r1) {
            this.size = r1;
        }

        public boolean equals(Object r3) {
            if ((r3 instanceof Key) == true) goto L5;
            return false;
        L5:
            if (this.size != ((Key) r3).size) goto L9;
            return true;
        L9:
            return false;
        }

        public int hashCode() {
            return this.size;
        }

        public String toString() {
            return SizeStrategy.getBitmapString(this.size);
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.Poolable
        public void offer() {
            this.pool.offer(this);
        }
    }

    static class KeyPool extends BaseKeyPool<Key> {
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool
        protected /* bridge */ /* synthetic */ Poolable create() {
            return create();
        }

        KeyPool() {
        }

        public Key get(int r1) {
            Key r0 = (Key) super.get();
            r0.init(r1);
            return r0;
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool
        protected Key create() {
            return new Key(this);
        }
    }

    SizeStrategy() {
        this.keyPool = new KeyPool();
        this.groupedMap = new GroupedLinkedMap();
        this.sortedSizes = new PrettyPrintTreeMap();
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public void put(Bitmap r3) {
        int r0 = Util.getBitmapByteSize(r3);
        Key r1 = this.keyPool.get(r0);
        this.groupedMap.put(r1, r3);
        Integer r4 = (Integer) this.sortedSizes.get(Integer.valueOf(r1.size));
        NavigableMap<Integer, Integer> r2 = this.sortedSizes;
        Integer r5 = Integer.valueOf(r1.size);
        int r6 = 1;
        if (r4 == null) goto L6;
        r6 = 1 + r4.intValue();
    L6:
        r2.put(r5, Integer.valueOf(r6));
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public Bitmap get(int r5, int r6, Bitmap.Config r7) {
        int r0 = Util.getBitmapByteSize(r5, r6, r7);
        Key r1 = this.keyPool.get(r0);
        Integer r2 = this.sortedSizes.ceilingKey(Integer.valueOf(r0));
        if (r2 != null) goto L5;
    L9:
        Bitmap r3 = this.groupedMap.get(r1);
        if (r3 == null) goto L12;
        r3.reconfigure(r5, r6, r7);
        decrementBitmapOfSize(r2);
    L12:
        return r3;
    L5:
        if (r2.intValue() == r0) goto L9;
        if (r2.intValue() > (r0 * 8)) goto L9;
        this.keyPool.offer(r1);
        r1 = this.keyPool.get(r2.intValue());
        goto L9
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public Bitmap removeLast() {
        Bitmap r0 = this.groupedMap.removeLast();
        if (r0 == null) goto L5;
        decrementBitmapOfSize(Integer.valueOf(Util.getBitmapByteSize(r0)));
    L5:
        return r0;
    }

    private void decrementBitmapOfSize(Integer r4) {
        Integer r0 = (Integer) this.sortedSizes.get(r4);
        if (r0.intValue() != 1) goto L5;
        this.sortedSizes.remove(r4);
        return;
    L5:
        this.sortedSizes.put(r4, Integer.valueOf(r0.intValue() - 1));
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public String logBitmap(Bitmap r1) {
        return getBitmapString(r1);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public String logBitmap(int r1, int r2, Bitmap.Config r3) {
        return getBitmapString(Util.getBitmapByteSize(r1, r2, r3));
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public int getSize(Bitmap r1) {
        return Util.getBitmapByteSize(r1);
    }

    public String toString() {
        return "SizeStrategy:\n  " + this.groupedMap + "\n  SortedSizes" + this.sortedSizes;
    }

    private static String getBitmapString(Bitmap r0) {
        return getBitmapString(Util.getBitmapByteSize(r0));
    }

    static String getBitmapString(int r2) {
        return "[" + r2 + "]";
    }
}

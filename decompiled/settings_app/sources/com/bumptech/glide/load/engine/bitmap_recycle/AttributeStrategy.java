package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import com.bumptech.glide.util.Util;
import com.obric.oui.material.MaterialConfigFormatNames;

/* JADX INFO: loaded from: classes3.dex */
class AttributeStrategy implements LruPoolStrategy {
    private final GroupedLinkedMap<Key, Bitmap> groupedMap;
    private final KeyPool keyPool;

    static class Key implements Poolable {
        private Bitmap.Config config;
        private int height;
        private final KeyPool pool;
        private int width;

        public Key(KeyPool r1) {
            this.pool = r1;
        }

        public void init(int r1, int r2, Bitmap.Config r3) {
            this.width = r1;
            this.height = r2;
            this.config = r3;
        }

        public boolean equals(Object r4) {
            if ((r4 instanceof Key) == false) goto L12;
            Key r5 = (Key) r4;
            if (this.width == r5.width) goto L7;
            return false;
        L7:
            if (this.height == r5.height) goto L9;
            return false;
        L9:
            if (this.config != r5.config) goto L15;
            return true;
        L15:
            return false;
        L12:
            return false;
        }

        public int hashCode() {
            int r0 = ((this.width * 31) + this.height) * 31;
            Bitmap.Config r2 = this.config;
            if (r2 == null) goto L5;
            int r3 = r2.hashCode();
        L7:
            return r0 + r3;
        L5:
            r3 = 0;
            goto L7
        }

        public String toString() {
            return AttributeStrategy.getBitmapString(this.width, this.height, this.config);
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

        Key get(int r1, int r2, Bitmap.Config r3) {
            Key r0 = get();
            r0.init(r1, r2, r3);
            return r0;
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool
        protected Key create() {
            return new Key(this);
        }
    }

    AttributeStrategy() {
        this.keyPool = new KeyPool();
        this.groupedMap = new GroupedLinkedMap();
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public void put(Bitmap r5) {
        Key r0 = this.keyPool.get(r5.getWidth(), r5.getHeight(), r5.getConfig());
        this.groupedMap.put(r0, r5);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public Bitmap get(int r2, int r3, Bitmap.Config r4) {
        Key r5 = this.keyPool.get(r2, r3, r4);
        return this.groupedMap.get(r5);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public Bitmap removeLast() {
        return this.groupedMap.removeLast();
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public String logBitmap(Bitmap r1) {
        return getBitmapString(r1);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public String logBitmap(int r1, int r2, Bitmap.Config r3) {
        return getBitmapString(r1, r2, r3);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public int getSize(Bitmap r1) {
        return Util.getBitmapByteSize(r1);
    }

    public String toString() {
        return "AttributeStrategy:\n  " + this.groupedMap;
    }

    private static String getBitmapString(Bitmap r2) {
        return getBitmapString(r2.getWidth(), r2.getHeight(), r2.getConfig());
    }

    static String getBitmapString(int r2, int r3, Bitmap.Config r4) {
        return "[" + r2 + MaterialConfigFormatNames.X + r3 + "], " + r4;
    }
}

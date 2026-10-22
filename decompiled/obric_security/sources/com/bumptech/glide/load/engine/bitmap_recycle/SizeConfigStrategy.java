package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import com.bumptech.glide.util.Util;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public class SizeConfigStrategy implements LruPoolStrategy {
    private static final Bitmap.Config[] ALPHA_8_IN_CONFIGS = null;
    private static final Bitmap.Config[] ARGB_4444_IN_CONFIGS = null;
    private static final Bitmap.Config[] ARGB_8888_IN_CONFIGS = null;
    private static final int MAX_SIZE_MULTIPLE = 8;
    private static final Bitmap.Config[] RGBA_F16_IN_CONFIGS = null;
    private static final Bitmap.Config[] RGB_565_IN_CONFIGS = null;
    private final GroupedLinkedMap<Key, Bitmap> groupedMap;
    private final KeyPool keyPool;
    private final Map<Bitmap.Config, NavigableMap<Integer, Integer>> sortedSizes;

    /* JADX INFO: renamed from: com.bumptech.glide.load.engine.bitmap_recycle.SizeConfigStrategy$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$Config = null;

        static {
            int[] r0 = new int[Bitmap.Config.values().length];
            $SwitchMap$android$graphics$Bitmap$Config = r0;
            r0[Bitmap.Config.ARGB_8888.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.RGB_565.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ARGB_4444.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ALPHA_8.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    static final class Key implements Poolable {
        private Bitmap.Config config;
        private final KeyPool pool;
        int size;

        public Key(KeyPool r1) {
            this.pool = r1;
        }

        Key(KeyPool r1, int r2, Bitmap.Config r3) {
            this(r1);
            init(r2, r3);
        }

        public void init(int r1, Bitmap.Config r2) {
            this.size = r1;
            this.config = r2;
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.Poolable
        public void offer() {
            this.pool.offer(this);
        }

        public String toString() {
            return SizeConfigStrategy.getBitmapString(this.size, this.config);
        }

        public boolean equals(Object r4) {
            if ((r4 instanceof Key) == false) goto L10;
            Key r5 = (Key) r4;
            if (this.size == r5.size) goto L7;
            return false;
        L7:
            if (Util.bothNullOrEqual(this.config, r5.config) == false) goto L12;
            return true;
        L12:
            return false;
        L10:
            return false;
        }

        public int hashCode() {
            int r0 = this.size * 31;
            Bitmap.Config r1 = this.config;
            if (r1 == null) goto L5;
            int r2 = r1.hashCode();
        L7:
            return r0 + r2;
        L5:
            r2 = 0;
            goto L7
        }
    }

    static class KeyPool extends BaseKeyPool<Key> {
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool
        protected /* bridge */ /* synthetic */ Poolable create() {
            return create();
        }

        KeyPool() {
        }

        public Key get(int r1, Bitmap.Config r2) {
            Key r0 = get();
            r0.init(r1, r2);
            return r0;
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool
        protected Key create() {
            return new Key(this);
        }
    }

    public SizeConfigStrategy() {
        this.keyPool = new KeyPool();
        this.groupedMap = new GroupedLinkedMap();
        this.sortedSizes = new HashMap();
    }

    static {
        Bitmap.Config[] r0 = (Bitmap.Config[]) Arrays.copyOf(new Bitmap.Config[]{Bitmap.Config.ARGB_8888, null}, 3);
        r0[r0.length - 1] = Bitmap.Config.RGBA_F16;
        ARGB_8888_IN_CONFIGS = r0;
        RGBA_F16_IN_CONFIGS = r0;
        RGB_565_IN_CONFIGS = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        ARGB_4444_IN_CONFIGS = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        ALPHA_8_IN_CONFIGS = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public void put(Bitmap r4) {
        int r0 = Util.getBitmapByteSize(r4);
        Key r1 = this.keyPool.get(r0, r4.getConfig());
        this.groupedMap.put(r1, r4);
        NavigableMap<Integer, Integer> r3 = getSizesForConfig(r4.getConfig());
        Integer r5 = (Integer) r3.get(Integer.valueOf(r1.size));
        Integer r2 = Integer.valueOf(r1.size);
        int r6 = 1;
        if (r5 == null) goto L6;
        r6 = 1 + r5.intValue();
    L6:
        r3.put(r2, Integer.valueOf(r6));
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public Bitmap get(int r3, int r4, Bitmap.Config r5) {
        Key r0 = findBestKey(Util.getBitmapByteSize(r3, r4, r5), r5);
        Bitmap r1 = this.groupedMap.get(r0);
        if (r1 == null) goto L5;
        decrementBitmapOfSize(Integer.valueOf(r0.size), r1);
        r1.reconfigure(r3, r4, r5);
    L5:
        return r1;
    }

    private Key findBestKey(int r9, Bitmap.Config r10) {
        Key r0 = this.keyPool.get(r9, r10);
        Bitmap.Config[] r1 = getInConfigs(r10);
        int r2 = r1.length;
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L24;
        Bitmap.Config r4 = r1[r3];
        Integer r5 = getSizesForConfig(r4).ceilingKey(Integer.valueOf(r9));
        if (r5 == null) goto L16;
        if (r5.intValue() > (r9 * 8)) goto L16;
        if (r5.intValue() != r9) goto L15;
        if (r4 != null) goto L14;
        if (r10 != null) goto L15;
        return r0;
    L14:
        if (r4.equals(r10) == false) goto L15;
        return r0;
    L15:
        this.keyPool.offer(r0);
        return this.keyPool.get(r5.intValue(), r4);
    L16:
        r3 = r3 + 1;
        goto L3
    L24:
        return r0;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public Bitmap removeLast() {
        Bitmap r0 = this.groupedMap.removeLast();
        if (r0 == null) goto L5;
        decrementBitmapOfSize(Integer.valueOf(Util.getBitmapByteSize(r0)), r0);
    L5:
        return r0;
    }

    private void decrementBitmapOfSize(Integer r4, Bitmap r5) {
        NavigableMap<Integer, Integer> r0 = getSizesForConfig(r5.getConfig());
        Integer r1 = (Integer) r0.get(r4);
        if (r1 == null) goto L10;
        if (r1.intValue() != 1) goto L7;
        r0.remove(r4);
        return;
    L7:
        r0.put(r4, Integer.valueOf(r1.intValue() - 1));
        return;
    L10:
        throw new NullPointerException("Tried to decrement empty size, size: " + r4 + ", removed: " + logBitmap(r5) + ", this: " + this);
    }

    private NavigableMap<Integer, Integer> getSizesForConfig(Bitmap.Config r2) {
        NavigableMap<Integer, Integer> r0 = this.sortedSizes.get(r2);
        if (r0 != null) goto L6;
        TreeMap r1 = new TreeMap();
        this.sortedSizes.put(r2, r1);
        return r1;
    L6:
        return r0;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public String logBitmap(Bitmap r1) {
        return getBitmapString(Util.getBitmapByteSize(r1), r1.getConfig());
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public String logBitmap(int r1, int r2, Bitmap.Config r3) {
        return getBitmapString(Util.getBitmapByteSize(r1, r2, r3), r3);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    public int getSize(Bitmap r1) {
        return Util.getBitmapByteSize(r1);
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder().append("SizeConfigStrategy{groupedMap=").append(this.groupedMap).append(", sortedSizes=(");
        Iterator<Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>>> r1 = this.sortedSizes.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>> r2 = r1.next();
        r0.append(r2.getKey()).append('[').append(r2.getValue()).append("], ");
        goto L4
    L7:
        if (this.sortedSizes.isEmpty() == true) goto L10;
        r0.replace(r0.length() - 2, r0.length(), "");
    L10:
        return r0.append(")}").toString();
    }

    static String getBitmapString(int r2, Bitmap.Config r3) {
        return "[" + r2 + "](" + r3 + ")";
    }

    private static Bitmap.Config[] getInConfigs(Bitmap.Config r3) {
        if (Bitmap.Config.RGBA_F16.equals(r3) == true) goto L5;
        int r0 = AnonymousClass1.$SwitchMap$android$graphics$Bitmap$Config[r3.ordinal()];
        if (r0 == 1) goto L23;
        if (r0 == 2) goto L21;
        if (r0 == 3) goto L19;
        if (r0 == 4) goto L17;
        return new Bitmap.Config[]{r3};
    L17:
        return ALPHA_8_IN_CONFIGS;
    L19:
        return ARGB_4444_IN_CONFIGS;
    L21:
        return RGB_565_IN_CONFIGS;
    L23:
        return ARGB_8888_IN_CONFIGS;
    L5:
        return RGBA_F16_IN_CONFIGS;
    }
}

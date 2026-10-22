package com.github.mikephil.charting.utils;

import com.github.mikephil.charting.utils.ObjectPool.Poolable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ObjectPool<T extends Poolable> {
    private static int ids;
    private int desiredCapacity;
    private T modelObject;
    private Object[] objects;
    private int objectsPointer;
    private int poolId;
    private float replenishPercentage;

    public static abstract class Poolable {
        public static int NO_OWNER = -1;
        int currentOwnerId;

        static {
        }

        protected abstract Poolable instantiate();

        public Poolable() {
            this.currentOwnerId = NO_OWNER;
        }
    }

    static {
    }

    public int getPoolId() {
        return this.poolId;
    }

    public static synchronized ObjectPool create(int r2, Poolable r3) {
        monitor-enter(ObjectPool.class);
        ObjectPool r1 = new ObjectPool(r2, r3);     // Catch: Throwable -> L7
        int r4 = ids;     // Catch: Throwable -> L7
        r1.poolId = r4;     // Catch: Throwable -> L7
        ids = r4 + 1;     // Catch: Throwable -> L7
        monitor-exit(ObjectPool.class);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    private ObjectPool(int r1, T r2) {
        if (r1 <= 0) goto L7;
        this.desiredCapacity = r1;
        this.objects = new Object[r1];
        this.objectsPointer = 0;
        this.modelObject = r2;
        this.replenishPercentage = 1.0f;
        refillPool();
        return;
    L7:
        throw new IllegalArgumentException("Object Pool must be instantiated with a capacity greater than 0!");
    }

    public void setReplenishPercentage(float r3) {
        float r0 = 1.0f;
        if (r3 <= 1.0f) goto L5;
    L4:
        r3 = r0;
    L8:
        this.replenishPercentage = r3;
        return;
    L5:
        r0 = 0.0f;
        if (r3 >= 0.0f) goto L8;
        goto L8
    }

    public float getReplenishPercentage() {
        return this.replenishPercentage;
    }

    private void refillPool() {
        refillPool(this.replenishPercentage);
    }

    private void refillPool(float r5) {
        int r0 = this.desiredCapacity;
        int r6 = (int) (r0 * r5);
        if (r6 >= 1) goto L5;
        r0 = 1;
    L8:
        int r7 = 0;
    L9:
        if (r7 >= r0) goto L11;
        this.objects[r7] = this.modelObject.instantiate();
        r7 = r7 + 1;
        goto L9
    L11:
        this.objectsPointer = r0 - 1;
        return;
    L5:
        if (r6 > r0) goto L8;
        r0 = r6;
        goto L8
    }

    public synchronized T get() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.objectsPointer == (-1)) goto L6;
    L8:
        T r0 = (T) this.objects[this.objectsPointer];     // Catch: Throwable -> L11
        r0.currentOwnerId = Poolable.NO_OWNER;     // Catch: Throwable -> L11
        this.objectsPointer--;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r0;
    L6:
        if (this.replenishPercentage <= 0.0f) goto L8;
        refillPool();     // Catch: Throwable -> L11
        goto L8
    }

    public synchronized void recycle(T r4) {
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (r4.currentOwnerId != Poolable.NO_OWNER) goto L7;
        int r0 = this.objectsPointer + 1;     // Catch: Throwable -> L18
        this.objectsPointer = r0;     // Catch: Throwable -> L18
        if (r0 < this.objects.length) goto L15;
        resizePool();     // Catch: Throwable -> L18
    L15:
        r4.currentOwnerId = this.poolId;     // Catch: Throwable -> L18
        this.objects[this.objectsPointer] = r4;     // Catch: Throwable -> L18
        monitor-exit(this);
        return;
    L7:
        if (r4.currentOwnerId != this.poolId) goto L11;
        throw new IllegalArgumentException("The object passed is already stored in this pool!");     // Catch: Throwable -> L18
    L11:
        throw new IllegalArgumentException("The object to recycle already belongs to poolId " + r4.currentOwnerId + ".  Object cannot belong to two different pool instances simultaneously!");     // Catch: Throwable -> L18
    }

    public synchronized void recycle(List<T> r6) {
        monitor-enter(this);
    L23:
    L20:
        th = move-exception;
        throw th;
    L4:
        if (((r6.size() + this.objectsPointer) + 1) <= this.desiredCapacity) goto L6;
        resizePool();     // Catch: Throwable -> L20
        goto L23
    L6:
        int r0 = r6.size();     // Catch: Throwable -> L20
        int r1 = 0;
    L7:
        if (r1 >= r0) goto L17;
        T r2 = r6.get(r1);     // Catch: Throwable -> L20
        if (r2.currentOwnerId != Poolable.NO_OWNER) goto L11;
        r2.currentOwnerId = this.poolId;     // Catch: Throwable -> L20
        this.objects[(this.objectsPointer + 1) + r1] = r2;     // Catch: Throwable -> L20
        r1 = r1 + 1;     // Catch: Throwable -> L20
        goto L7
    L11:
        if (r2.currentOwnerId != this.poolId) goto L15;
        throw new IllegalArgumentException("The object passed is already stored in this pool!");     // Catch: Throwable -> L20
    L15:
        throw new IllegalArgumentException("The object to recycle already belongs to poolId " + r2.currentOwnerId + ".  Object cannot belong to two different pool instances simultaneously!");     // Catch: Throwable -> L20
    L17:
        this.objectsPointer += r0;     // Catch: Throwable -> L20
        monitor-exit(this);
    }

    private void resizePool() {
        int r0 = this.desiredCapacity;
        int r1 = r0 * 2;
        this.desiredCapacity = r1;
        Object[] r2 = new Object[r1];
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L5;
        r2[r3] = this.objects[r3];
        r3 = r3 + 1;
        goto L3
    L5:
        this.objects = r2;
    }

    public int getPoolCapacity() {
        return this.objects.length;
    }

    public int getPoolCount() {
        return this.objectsPointer + 1;
    }
}

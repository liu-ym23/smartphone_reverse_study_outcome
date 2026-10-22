package com.ttnet.org.chromium.base.task;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class TaskTraits {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final TaskTraits BEST_EFFORT = null;
    public static final TaskTraits BEST_EFFORT_MAY_BLOCK = null;
    public static final TaskTraits CHOREOGRAPHER_FRAME = null;
    public static final int EXTENSION_STORAGE_SIZE = 8;
    public static final byte INVALID_EXTENSION_ID = 0;
    public static final int MAX_EXTENSION_ID = 4;
    public static final TaskTraits THREAD_POOL = null;
    public static final TaskTraits THREAD_POOL_BEST_EFFORT = null;
    public static final TaskTraits THREAD_POOL_USER_BLOCKING = null;
    public static final TaskTraits THREAD_POOL_USER_VISIBLE = null;
    public static final TaskTraits USER_BLOCKING = null;
    public static final TaskTraits USER_BLOCKING_MAY_BLOCK = null;
    public static final TaskTraits USER_VISIBLE = null;
    public static final TaskTraits USER_VISIBLE_MAY_BLOCK = null;
    byte[] mExtensionData;
    byte mExtensionId;
    boolean mIsChoreographerFrame;
    boolean mMayBlock;
    int mPriority;
    boolean mUseThreadPool;

    static {
        TaskTraits r0 = new TaskTraits().taskPriority(0);
        BEST_EFFORT = r0;
        BEST_EFFORT_MAY_BLOCK = r0.mayBlock();
        TaskTraits r1 = new TaskTraits().taskPriority(1);
        USER_VISIBLE = r1;
        USER_VISIBLE_MAY_BLOCK = r1.mayBlock();
        TaskTraits r2 = new TaskTraits().taskPriority(2);
        USER_BLOCKING = r2;
        USER_BLOCKING_MAY_BLOCK = r2.mayBlock();
        TaskTraits r3 = new TaskTraits();
        CHOREOGRAPHER_FRAME = r3;
        r3.mIsChoreographerFrame = true;
        TaskTraits r4 = new TaskTraits().threadPool().taskPriority(2);
        THREAD_POOL = r4;
        THREAD_POOL_USER_BLOCKING = r4.taskPriority(2);
        THREAD_POOL_USER_VISIBLE = r4.taskPriority(1);
        THREAD_POOL_BEST_EFFORT = r4.taskPriority(0);
    }

    private TaskTraits() {
        this.mPriority = 2;
    }

    private TaskTraits(TaskTraits r2) {
        this.mPriority = r2.mPriority;
        this.mMayBlock = r2.mMayBlock;
        this.mUseThreadPool = r2.mUseThreadPool;
        this.mExtensionId = r2.mExtensionId;
        this.mExtensionData = r2.mExtensionData;
    }

    public boolean equals(@Nullable Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if ((r5 instanceof TaskTraits) == false) goto L22;
        TaskTraits r6 = (TaskTraits) r5;
        if (this.mPriority != r6.mPriority) goto L21;
        if (this.mMayBlock != r6.mMayBlock) goto L21;
        if (this.mUseThreadPool != r6.mUseThreadPool) goto L21;
        if (this.mExtensionId != r6.mExtensionId) goto L21;
        if (Arrays.equals(this.mExtensionData, r6.mExtensionData) == false) goto L21;
        if (this.mIsChoreographerFrame != r6.mIsChoreographerFrame) goto L21;
        return true;
    L21:
        return false;
    L22:
        return false;
    }

    public <Extension> Extension getExtension(TaskTraitsExtensionDescriptor<Extension> r3) {
        if (this.mExtensionId == r3.getId()) goto L5;
        return null;
    L5:
        return r3.fromSerializedData(this.mExtensionData);
    }

    public boolean hasExtension() {
        if (this.mExtensionId == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public int hashCode() {
        return ((((((((((1147 + this.mPriority) * 37) + (!this.mMayBlock ? 1 : 0)) * 37) + (!this.mUseThreadPool ? 1 : 0)) * 37) + this.mExtensionId) * 37) + Arrays.hashCode(this.mExtensionData)) * 37) + (!this.mIsChoreographerFrame ? 1 : 0);
    }

    public TaskTraits mayBlock() {
        TaskTraits r0 = new TaskTraits(this);
        r0.mMayBlock = true;
        return r0;
    }

    public TaskTraits taskPriority(int r2) {
        TaskTraits r0 = new TaskTraits(this);
        r0.mPriority = r2;
        return r0;
    }

    public TaskTraits threadPool() {
        TaskTraits r0 = new TaskTraits(this);
        r0.mUseThreadPool = true;
        return r0;
    }

    public TaskTraits withExplicitDestination() {
        if (this.mUseThreadPool == false) goto L5;
        return this;
    L5:
        if (hasExtension() == false) goto L7;
        return this;
    L7:
        return threadPool();
    }

    public <Extension> TaskTraits withExtension(TaskTraitsExtensionDescriptor<Extension> r2, Extension r3) {
        int r0 = r2.getId();
        byte[] r4 = r2.toSerializedData(r3);
        TaskTraits r5 = new TaskTraits(this);
        r5.mExtensionId = (byte) r0;
        r5.mExtensionData = r4;
        return r5;
    }
}

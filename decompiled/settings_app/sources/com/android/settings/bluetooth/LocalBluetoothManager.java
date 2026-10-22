package com.android.settings.bluetooth;

import android.content.Context;
import com.obric.olog.OLog;
import obric.bluetooth.SmartBluetoothBinderClient;

/* JADX INFO: loaded from: classes2.dex */
public final class LocalBluetoothManager {
    private static final String TAG = "LocalBluetoothManager";
    private static volatile LocalBluetoothManager sInstance;
    private final CachedBluetoothDeviceManager mCachedDeviceManager;
    private final Context mContext;
    private BluetoothDiscoverableEnabler mDiscoverableEnabler;
    private final BluetoothEventManager mEventManager;
    private Context mForegroundActivity;
    private final LocalBluetoothAdapter mLocalAdapter;
    private final LocalBluetoothProfileManager mProfileManager;
    private SmartBluetoothBinderClient mSmartBluetoothBinderClient;

    public static synchronized LocalBluetoothManager getInstance(Context r4) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            java.lang.Class<com.android.settings.bluetooth.LocalBluetoothManager> r0 = com.android.settings.bluetooth.LocalBluetoothManager.class
            monitor-enter(r0)
            com.android.settings.bluetooth.LocalBluetoothManager r1 = com.android.settings.bluetooth.LocalBluetoothManager.sInstance     // Catch: java.lang.Throwable -> L26
            if (r1 != 0) goto L22
            java.lang.Class<com.android.settings.bluetooth.LocalBluetoothManager> r1 = com.android.settings.bluetooth.LocalBluetoothManager.class
            monitor-enter(r1)     // Catch: java.lang.Throwable -> L26
            com.android.settings.bluetooth.LocalBluetoothManager r2 = com.android.settings.bluetooth.LocalBluetoothManager.sInstance     // Catch: java.lang.Throwable -> L1f
            if (r2 != 0) goto L1d
            com.android.settings.bluetooth.LocalBluetoothAdapter r2 = com.android.settings.bluetooth.LocalBluetoothAdapter.getInstance()     // Catch: java.lang.Throwable -> L1f
            android.content.Context r4 = r4.getApplicationContext()     // Catch: java.lang.Throwable -> L1f
            com.android.settings.bluetooth.LocalBluetoothManager r3 = new com.android.settings.bluetooth.LocalBluetoothManager     // Catch: java.lang.Throwable -> L1f
            r3.<init>(r2, r4)     // Catch: java.lang.Throwable -> L1f
            com.android.settings.bluetooth.LocalBluetoothManager.sInstance = r3     // Catch: java.lang.Throwable -> L1f
        L1d:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L1f
            goto L22
        L1f:
            r4 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L1f
            throw r4     // Catch: java.lang.Throwable -> L26
        L22:
            com.android.settings.bluetooth.LocalBluetoothManager r4 = com.android.settings.bluetooth.LocalBluetoothManager.sInstance     // Catch: java.lang.Throwable -> L26
            monitor-exit(r0)
            return r4
        L26:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.settings.bluetooth.LocalBluetoothManager.getInstance(android.content.Context):com.android.settings.bluetooth.LocalBluetoothManager");
    }

    public SmartBluetoothBinderClient getSmartBluetoothBinderClient() {
        return this.mSmartBluetoothBinderClient;
    }

    public void setSmartBluetoothBinderClient(SmartBluetoothBinderClient r1) {
        this.mSmartBluetoothBinderClient = r1;
    }

    public void setDiscoverableEnabler(BluetoothDiscoverableEnabler r1) {
        this.mDiscoverableEnabler = r1;
    }

    public BluetoothDiscoverableEnabler getDiscoverableEnabler() {
        return this.mDiscoverableEnabler;
    }

    private LocalBluetoothManager(LocalBluetoothAdapter r4, Context r5) {
        this.mContext = r5;
        this.mLocalAdapter = r4;
        CachedBluetoothDeviceManager r0 = new CachedBluetoothDeviceManager(r5);
        this.mCachedDeviceManager = r0;
        BluetoothEventManager r1 = new BluetoothEventManager(r4, r0, r5);
        this.mEventManager = r1;
        this.mProfileManager = new LocalBluetoothProfileManager(r5, r4, r0, r1);
    }

    public LocalBluetoothAdapter getBluetoothAdapter() {
        return this.mLocalAdapter;
    }

    public Context getContext() {
        return this.mContext;
    }

    public Context getForegroundActivity() {
        return this.mForegroundActivity;
    }

    boolean isForegroundActivity() {
        if (this.mForegroundActivity == null) goto L5;
        return true;
    L5:
        return false;
    }

    synchronized void setForegroundActivity(Context r3) {
        monitor-enter(this);
        if (r3 == null) goto L6;
        OLog.d(TAG, "setting foreground activity to non-null context");     // Catch: Throwable -> L10
        this.mForegroundActivity = r3;     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
        return;
    L6:
        if (this.mForegroundActivity == null) goto L8;
        OLog.d(TAG, "setting foreground activity to null");     // Catch: Throwable -> L10
        this.mForegroundActivity = null;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public CachedBluetoothDeviceManager getCachedDeviceManager() {
        return this.mCachedDeviceManager;
    }

    BluetoothEventManager getEventManager() {
        return this.mEventManager;
    }

    LocalBluetoothProfileManager getProfileManager() {
        return this.mProfileManager;
    }
}

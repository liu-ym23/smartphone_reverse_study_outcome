package com.ss.android.pushmanager.setting;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.ss.android.message.AppProvider;
import com.ss.android.pushmanager.PushCommonConstants;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class PushCommonSetting {
    private static final String SP_CONFIG_NAME = "push_multi_process_config";
    public static final String SSIDS = "ssids";
    private static PushCommonSetting sPushSetting;
    private PushMultiProcessSharedProvider.MultiProcessShared multiProcessShared;
    private SharedPreferences prefs;

    public static synchronized void init(Context r1) {
        monitor-enter(PushCommonSetting.class);
        AppProvider.initApp((Application) r1.getApplicationContext());     // Catch: Throwable -> L7
        monitor-exit(PushCommonSetting.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized PushCommonSetting getInstance() {
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
            java.lang.Class<com.ss.android.pushmanager.setting.PushCommonSetting> r0 = com.ss.android.pushmanager.setting.PushCommonSetting.class
            monitor-enter(r0)
            com.ss.android.pushmanager.setting.PushCommonSetting r1 = com.ss.android.pushmanager.setting.PushCommonSetting.sPushSetting     // Catch: java.lang.Throwable -> L1e
            if (r1 != 0) goto L1a
            java.lang.Class<com.ss.android.pushmanager.setting.PushCommonSetting> r1 = com.ss.android.pushmanager.setting.PushCommonSetting.class
            monitor-enter(r1)     // Catch: java.lang.Throwable -> L1e
            com.ss.android.pushmanager.setting.PushCommonSetting r2 = com.ss.android.pushmanager.setting.PushCommonSetting.sPushSetting     // Catch: java.lang.Throwable -> L17
            if (r2 != 0) goto L15
            com.ss.android.pushmanager.setting.PushCommonSetting r2 = new com.ss.android.pushmanager.setting.PushCommonSetting     // Catch: java.lang.Throwable -> L17
            r2.<init>()     // Catch: java.lang.Throwable -> L17
            com.ss.android.pushmanager.setting.PushCommonSetting.sPushSetting = r2     // Catch: java.lang.Throwable -> L17
        L15:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L17
            goto L1a
        L17:
            r2 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L17
            throw r2     // Catch: java.lang.Throwable -> L1e
        L1a:
            com.ss.android.pushmanager.setting.PushCommonSetting r1 = com.ss.android.pushmanager.setting.PushCommonSetting.sPushSetting     // Catch: java.lang.Throwable -> L1e
            monitor-exit(r0)
            return r1
        L1e:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.pushmanager.setting.PushCommonSetting.getInstance():com.ss.android.pushmanager.setting.PushCommonSetting");
    }

    private PushCommonSetting() {
        this.prefs = null;
        Application r0 = AppProvider.getApp();
        this.multiProcessShared = PushMultiProcessSharedProvider.getMultiprocessShared(r0);
        this.prefs = r0.getSharedPreferences("push_multi_process_config", 4);
    }

    public void saveSSIDs(Map<String, String> r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (Logger.debug() == false) goto L10;
        Logger.d("PushService", "saveSSIDs start");
    L10:
        String r4 = StringUtils.mapToString(r3);     // Catch: Exception -> L9
        this.multiProcessShared.edit().putString("ssids", r4).apply();     // Catch: Exception -> L9
        return;
    }

    public String getSsids() {
        return this.multiProcessShared.getString("ssids", "");
    }

    public void getSSIDs(Map<String, String> r3) {
        if (r3 != null) goto L5;
        return;
    L5:
        if (Logger.debug() == false) goto L13;
        Logger.d("PushService", "getSSIDs start");
    L13:
        String r2 = getSsids();     // Catch: Exception -> L12
        if (StringUtils.isEmpty(r2) == false) goto L10;
        return;
    L10:
        StringUtils.stringToMap(r2, r3);     // Catch: Exception -> L12
        return;
    }

    public String getDeviceId() {
        HashMap r0 = new HashMap();
        getSSIDs(r0);
        return r0.get(PushCommonConstants.KEY_DEVICE_ID);
    }

    public void setPref(String r1, boolean r2) {
        SharedPreferences.Editor r0 = this.prefs.edit();
        r0.putBoolean(r1, r2);
        r0.apply();
    }

    public void setPref(String r1, String r2) {
        SharedPreferences.Editor r0 = this.prefs.edit();
        r0.putString(r1, r2);
        r0.apply();
    }

    public void setPref(String r1, Set<String> r2) {
        SharedPreferences.Editor r0 = this.prefs.edit();
        r0.putStringSet(r1, r2);
        r0.apply();
    }

    public void setPref(String r1, float r2) {
        SharedPreferences.Editor r0 = this.prefs.edit();
        r0.putFloat(r1, r2);
        r0.apply();
    }

    public void setPref(String r1, int r2) {
        SharedPreferences.Editor r0 = this.prefs.edit();
        r0.putInt(r1, r2);
        r0.apply();
    }

    public void setPref(String r1, long r2) {
        SharedPreferences.Editor r0 = this.prefs.edit();
        r0.putLong(r1, r2);
        r0.apply();
    }

    public boolean getPref(String r1, Boolean r2) {
        return this.prefs.getBoolean(r1, r2.booleanValue());
    }

    public String getPref(String r1, String r2) {
        return this.prefs.getString(r1, r2);
    }

    public Set<String> getPref(String r1, Set<String> r2) {
        return this.prefs.getStringSet(r1, r2);
    }

    public int getPref(String r1, int r2) {
        return this.prefs.getInt(r1, r2);
    }

    public long getPref(String r1, long r2) {
        return this.prefs.getLong(r1, r2);
    }

    public float getPref(String r1, float r2) {
        return this.prefs.getFloat(r1, r2);
    }

    public boolean hasPrefWithKey(String r1) {
        return this.prefs.contains(r1);
    }

    public boolean removePref(String r1) {
        SharedPreferences.Editor r0 = this.prefs.edit();
        r0.remove(r1);
        return r0.commit();
    }

    public void clear() {
        SharedPreferences.Editor r0 = this.prefs.edit();
        r0.clear();
        r0.commit();
    }

    public boolean isApplicationActive() {
        return this.multiProcessShared.isApplicationActive();
    }
}

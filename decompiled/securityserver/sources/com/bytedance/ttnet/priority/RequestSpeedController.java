package com.bytedance.ttnet.priority;

import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.BaseRequestContext;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.ttnet.http.RequestContext;
import com.bytedance.ttnet.throttle.TTNetThrottle;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class RequestSpeedController {
    private static final String[] EMPTY_STRING_ARRAY = null;
    private static String TAG = "RequestSpeedController";
    private Set<String> mNormalDownHosts;
    private long mNormalDownSpeed;
    private Set<String> mNormalUpHosts;
    private long mNormalUpSpeed;
    private final Map<String, Integer> mRequestThrottleMap;
    private Set<String> mWsDownHosts;
    private long mWsDownSpeed;
    private Set<String> mWsUpHosts;
    private long mWsUpSpeed;

    static {
        EMPTY_STRING_ARRAY = new String[0];
    }

    public RequestSpeedController() {
        this.mRequestThrottleMap = new ConcurrentHashMap();
        this.mNormalUpHosts = new CopyOnWriteArraySet();
        this.mNormalDownHosts = new CopyOnWriteArraySet();
        this.mWsUpHosts = new CopyOnWriteArraySet();
        this.mWsDownHosts = new CopyOnWriteArraySet();
        this.mNormalUpSpeed = -1;
        this.mNormalDownSpeed = -1;
        this.mWsUpSpeed = -1;
        this.mWsDownSpeed = -1;
    }

    public void connectionThrottleStart() {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "connectionThrottleStart");
        Logger.d(TAG, "normal_up throttle " + this.mNormalUpHosts.size() + " speed " + this.mNormalUpSpeed);
        Logger.d(TAG, "normal_down throttle " + this.mNormalDownHosts.size() + " speed " + this.mNormalDownSpeed);
        Logger.d(TAG, "ws_up throttle " + this.mWsUpHosts.size() + " speed " + this.mWsUpSpeed);
        Logger.d(TAG, "ws_down throttle " + this.mWsDownHosts.size() + " speed " + this.mWsDownSpeed);
    L6:
        if (this.mNormalUpHosts.size() <= 0) goto L11;
        if (this.mNormalUpSpeed <= 0) goto L11;
        TTNetThrottle.start((String[]) this.mNormalUpHosts.toArray(EMPTY_STRING_ARRAY), 1, this.mNormalUpSpeed);
    L11:
        if (this.mNormalDownHosts.size() <= 0) goto L16;
        if (this.mNormalDownSpeed <= 0) goto L16;
        TTNetThrottle.start((String[]) this.mNormalDownHosts.toArray(EMPTY_STRING_ARRAY), 2, this.mNormalDownSpeed);
    L16:
        if (this.mWsUpHosts.size() <= 0) goto L21;
        if (this.mWsUpSpeed <= 0) goto L21;
        TTNetThrottle.start((String[]) this.mWsUpHosts.toArray(EMPTY_STRING_ARRAY), 4, this.mWsUpSpeed);
    L21:
        if (this.mWsDownHosts.size() > 0) goto L23;
        return;
    L23:
        if (this.mWsDownSpeed <= 0) goto L27;
        TTNetThrottle.start((String[]) this.mWsDownHosts.toArray(EMPTY_STRING_ARRAY), 8, this.mWsDownSpeed);
        return;
    }

    public void connectionThrottleStop() {
        Set<String> r0 = this.mNormalUpHosts;
        String[] r1 = EMPTY_STRING_ARRAY;
        TTNetThrottle.stop((String[]) r0.toArray(r1), 1);
        TTNetThrottle.stop((String[]) this.mNormalDownHosts.toArray(r1), 2);
        TTNetThrottle.stop((String[]) this.mWsUpHosts.toArray(r1), 4);
        TTNetThrottle.stop((String[]) this.mWsDownHosts.toArray(r1), 8);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.util.ConcurrentModificationException
    	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1104)
    	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:1058)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:358)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*  JADX ERROR: JadxRuntimeException in pass: FinishTypeInference
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r1v5 java.util.Collection<? extends java.lang.String>
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
        */
    public void initWithLocal(java.util.Map<java.lang.String, java.lang.Integer> r1, java.util.Set<java.lang.String> r2, java.util.Set<java.lang.String> r3, java.util.Set<java.lang.String> r4, java.util.Set<java.lang.String> r5, long r6, long r8, long r10, long r12) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r1v5 java.util.Collection<? extends java.lang.String>
            	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:341)
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
            r0 = this;
            java.util.Map<java.lang.String, java.lang.Integer> r5 = r0.mRequestThrottleMap
            r5.clear()
            java.util.Set<java.lang.String> r5 = r0.mNormalUpHosts
            r5.clear()
            java.util.Set<java.lang.String> r5 = r0.mNormalDownHosts
            r5.clear()
            java.util.Set<java.lang.String> r5 = r0.mWsUpHosts
            r5.clear()
            java.util.Set<java.lang.String> r5 = r0.mWsDownHosts
            r5.clear()
            java.util.Map<java.lang.String, java.lang.Integer> r5 = r0.mRequestThrottleMap
            r5.putAll(r1)
            java.util.Set<java.lang.String> r1 = r0.mNormalUpHosts
            r1.addAll(r2)
            java.util.Set<java.lang.String> r1 = r0.mNormalDownHosts
            r1.addAll(r3)
            java.util.Set<java.lang.String> r1 = r0.mWsUpHosts
            r1.addAll(r4)
            java.util.Set<java.lang.String> r1 = r0.mWsDownHosts
            r1.addAll(r1)
            r0.mNormalUpSpeed = r6
            r0.mNormalDownSpeed = r8
            r0.mWsUpSpeed = r10
            r0.mWsDownSpeed = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.ttnet.priority.RequestSpeedController.initWithLocal(java.util.Map, java.util.Set, java.util.Set, java.util.Set, java.util.Set, long, long, long, long):void");
    }

    public boolean initWithTncConfig(JSONObject r7) {
        connectionThrottleStop();
        this.mRequestThrottleMap.clear();
        JSONObject r8 = r7.optJSONObject("throttle");
        if (r8 != null) goto L6;
        return false;
    L6:
        JSONObject r0 = r8.optJSONObject("request_throttle");
        if (r0 == null) goto L12;
        Iterator<String> r1 = r0.keys();
    L10:
        if (r1.hasNext() == false) goto L12;
        String r2 = r1.next();
        this.mRequestThrottleMap.put(r2, Integer.valueOf(r0.optInt(r2)));
    L12:
        JSONObject r9 = r8.optJSONObject("connection_throttle");
        if (r9 == null) goto L29;
        JSONObject r3 = r9.optJSONObject("normal_up");
        if (r3 == null) goto L17;
        this.mNormalUpHosts = TTHttpCallPriorityControl.getSetFromJSONArray(r3, SlardarSettingsConsts.SETTING_GENERAL_API_REPORT_HOSTS);
        this.mNormalUpSpeed = r3.optInt("speed", -1);
    L17:
        JSONObject r4 = r9.optJSONObject("normal_down");
        if (r4 == null) goto L20;
        this.mNormalDownHosts = TTHttpCallPriorityControl.getSetFromJSONArray(r4, SlardarSettingsConsts.SETTING_GENERAL_API_REPORT_HOSTS);
        this.mNormalDownSpeed = r4.optInt("speed", -1);
    L20:
        JSONObject r5 = r9.optJSONObject("ws_up");
        if (r5 == null) goto L23;
        this.mWsUpHosts = TTHttpCallPriorityControl.getSetFromJSONArray(r5, SlardarSettingsConsts.SETTING_GENERAL_API_REPORT_HOSTS);
        this.mWsUpSpeed = r5.optInt("speed", -1);
    L23:
        JSONObject r10 = r9.optJSONObject("ws_down");
        if (r10 == null) goto L30;
        this.mWsDownHosts = TTHttpCallPriorityControl.getSetFromJSONArray(r10, SlardarSettingsConsts.SETTING_GENERAL_API_REPORT_HOSTS);
        this.mWsDownSpeed = r10.optInt("speed", -1);
        return true;
    L30:
        return true;
    L29:
        return true;
    }

    public Request setThrottleSpeedToRequest(Request r5) {
        Integer r4 = TTHttpCallPriorityControl.getMapValueIfMatch(this.mRequestThrottleMap, r5.getPath());
        if (r4 != null) goto L5;
        return r5;
    L5:
        Request.Builder r0 = r5.newBuilder();
        Object r6 = r5.getExtraInfo();
        if (r6 != null) goto L9;
        r6 = new RequestContext();
        r0.setExtraInfo(r6);
    L9:
        if ((r6 instanceof BaseRequestContext) == false) goto L11;
        long r2 = r4.longValue();
        ((BaseRequestContext) r6).throttle_net_speed = r2;
    L11:
        r0.setExtraInfo(r6);
        return r0.build();
    }
}

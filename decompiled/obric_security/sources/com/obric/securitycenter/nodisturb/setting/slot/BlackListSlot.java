package com.obric.securitycenter.nodisturb.setting.slot;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.view.View;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedanceos.security.Utils;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.securitycenter.nodisturb.R;
import com.obric.securitycenter.nodisturb.black.BlackListActivity;
import com.obric.slot.Slot;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BlackListSlot.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J \u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/securitycenter/nodisturb/setting/slot/BlackListSlot;", "Lcom/obric/slot/Slot;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "cardItem", "Lcom/obric/oui/lisitem/OCardListItem;", "bindView", "", "view", "Landroid/view/View;", "createView", "onPositioned", Utils.INTENT_KEY_INDEX, "", PerfConsts.PERF_DISK_TOTAL, "queryBlackListCount", "contentResolver", "Landroid/content/ContentResolver;", "nodisturb_neridaCnRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class BlackListSlot extends Slot {
    private OCardListItem cardItem;

    public static /* synthetic */ void $r8$lambda$jcrEqXd8GYDbt1svZNuRwgcBo2c(OCardListItem r0, View r1) {
        createView$lambda$1$lambda$0(r0, r1);
    }

    public BlackListSlot(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
    }

    @Override // com.obric.slot.Slot
    public View createView() {
        final OCardListItem r6 = new OCardListItem(getContext(), null, 0, 6, null);
        this.cardItem = r6;
        r6.setTitle(r6.getContext().getString(R.string.blacklist_numbers_title));
        r6.setSubTitle(r6.getContext().getString(R.string.network_optimization_subtitle_blacklist));
        r6.showSubTitle(true);
        r6.setDefaultTailIcon(0);
        r6.showTailIcon(true);
        r6.setOnContentClickListener(new BlackListSlot$$ExternalSyntheticLambda0(r6));
        return r6;
    }

    private static final void createView$lambda$1$lambda$0(OCardListItem r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "$this_apply");
        r2.getContext().startActivity(new Intent(r2.getContext(), BlackListActivity.class));
    }

    @Override // com.obric.slot.Slot
    public void onPositioned(View r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "view");
        OCardListItem r1 = this.cardItem;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("cardItem");
        r1 = null;
    L5:
        OCardListItem.setCardPosition$default(r1, SlotExtKt.cardPositionOf(r3, r4), false, 2, null);
    }

    @Override // com.obric.slot.Slot
    public void bindView(View r10) {
        Intrinsics.checkNotNullParameter(r10, "view");
        ContentResolver r11 = getContext().getContentResolver();
        Intrinsics.checkNotNullExpressionValue(r11, "context.contentResolver");
        int r12 = queryBlackListCount(r11);
        OCardListItem r3 = null;
        if (r12 <= 0) goto L12;
        OCardListItem r4 = this.cardItem;
        if (r4 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("cardItem");
        r4 = null;
    L7:
        OCardListItem.setEndDetailText$default(r4, getContext().getString(R.string.list_total_count, new Object[]{String.valueOf(r12)}), 0, 2, null);
        OCardListItem r9 = this.cardItem;
        if (r9 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("cardItem");
    L11:
        r3.showCustomEnd(true);
        return;
    L10:
        r3 = r9;
        goto L11
    L12:
        OCardListItem r13 = this.cardItem;
        if (r13 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("cardItem");
        r13 = null;
    L15:
        OCardListItem.setEndDetailText$default(r13, "", 0, 2, null);
    }

    private final int queryBlackListCount(ContentResolver r7) {
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
            this = this;
            java.lang.String r6 = "content://com.obric.nodisturb.provider/blacklistcount"
            android.net.Uri r1 = android.net.Uri.parse(r6)
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r0 = r7
            android.database.Cursor r6 = r0.query(r1, r2, r3, r4, r5)
            r7 = -1
            if (r6 == 0) goto L30
            boolean r0 = r6.moveToFirst()     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L2a
            if (r0 == 0) goto L30
            java.lang.String r0 = "bl_count"
            int r0 = r6.getColumnIndex(r0)     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L2a
            int r7 = r6.getInt(r0)     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L2a
            goto L30
        L23:
            r7 = move-exception
            if (r6 == 0) goto L29
            r6.close()
        L29:
            throw r7
        L2a:
            if (r6 == 0) goto L33
        L2c:
            r6.close()
            goto L33
        L30:
            if (r6 == 0) goto L33
            goto L2c
        L33:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.obric.securitycenter.nodisturb.setting.slot.BlackListSlot.queryBlackListCount(android.content.ContentResolver):int");
    }
}

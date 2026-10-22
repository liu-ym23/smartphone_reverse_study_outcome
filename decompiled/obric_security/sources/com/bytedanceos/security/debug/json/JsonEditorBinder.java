package com.bytedanceos.security.debug.json;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.bytedance.apm.battery.dao.DBHelper;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.obric.security.R;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: JsonEditorBinder.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\fJ\u0010\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f¨\u0006\u0010"}, d2 = {"Lcom/bytedanceos/security/debug/json/JsonEditorBinder;", "", "()V", "bind", "", "rootView", "Landroid/view/View;", DBHelper.BATTERY_COL_SOURCE, "Lcom/google/gson/JsonElement;", "valueType", "Ljava/lang/reflect/Type;", "editable", "", "getEditedJson", "setEditable", "State", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class JsonEditorBinder {
    public static final JsonEditorBinder INSTANCE = null;

    /* JADX INFO: compiled from: JsonEditorBinder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\nHÆ\u0003JA\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010!\u001a\u00020\b2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\u0006\u0010%\u001a\u00020&J\t\u0010'\u001a\u00020&HÖ\u0001R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019¨\u0006("}, d2 = {"Lcom/bytedanceos/security/debug/json/JsonEditorBinder$State;", "", "root", "Lcom/google/gson/JsonElement;", "rootValueType", "Ljava/lang/reflect/Type;", "rootArrayElementType", "editable", "", "rootAdapter", "Lcom/bytedanceos/security/debug/json/JsonEditAdapter;", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Ljava/lang/reflect/Type;ZLcom/bytedanceos/security/debug/json/JsonEditAdapter;)V", "getEditable", "()Z", "setEditable", "(Z)V", "getRoot", "()Lcom/google/gson/JsonElement;", "setRoot", "(Lcom/google/gson/JsonElement;)V", "getRootAdapter", "()Lcom/bytedanceos/security/debug/json/JsonEditAdapter;", "setRootAdapter", "(Lcom/bytedanceos/security/debug/json/JsonEditAdapter;)V", "getRootArrayElementType", "()Ljava/lang/reflect/Type;", "getRootValueType", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toJsonString", "", "toString", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class State {
        private boolean editable;
        private JsonElement root;
        private JsonEditAdapter rootAdapter;
        private final Type rootArrayElementType;
        private final Type rootValueType;

        public static /* synthetic */ State copy$default(State r3, JsonElement r4, Type r5, Type r6, boolean r7, JsonEditAdapter r8, int r9, Object r10) {
            if ((r9 & 1) == 0) goto L6;
            r4 = r3.root;
        L6:
            if ((r9 & 2) == 0) goto L8;
            r5 = r3.rootValueType;
        L8:
            Type r11 = r5;
            if ((r9 & 4) == 0) goto L11;
            r6 = r3.rootArrayElementType;
        L11:
            Type r0 = r6;
            if ((r9 & 8) == 0) goto L14;
            r7 = r3.editable;
        L14:
            boolean r1 = r7;
            if ((r9 & 16) == 0) goto L17;
            r8 = r3.rootAdapter;
        L17:
            JsonElement r12 = r4;
            return r3.copy(r12, r11, r0, r1, r8);
        }

        public final JsonElement component1() {
            return this.root;
        }

        public final Type component2() {
            return this.rootValueType;
        }

        public final Type component3() {
            return this.rootArrayElementType;
        }

        public final boolean component4() {
            return this.editable;
        }

        public final JsonEditAdapter component5() {
            return this.rootAdapter;
        }

        public final State copy(JsonElement r7, Type r8, Type r9, boolean r10, JsonEditAdapter r11) {
            Intrinsics.checkNotNullParameter(r7, "root");
            return new State(r7, r8, r9, r10, r11);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof State) == false) goto L16;
            State r4 = (State) r3;
            if (Intrinsics.areEqual(this.root, r4.root) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.rootValueType, r4.rootValueType) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.rootArrayElementType, r4.rootArrayElementType) == true) goto L12;
            return false;
        L12:
            if (this.editable == r4.editable) goto L14;
            return false;
        L14:
            if (Intrinsics.areEqual(this.rootAdapter, r4.rootAdapter) == true) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v8, types: [int] */
        /* JADX WARN: Type inference failed for: r2v11 */
        /* JADX WARN: Type inference failed for: r2v7, types: [int] */
        /* JADX WARN: Type inference failed for: r2v8 */
        public int hashCode() {
            JsonElement r0 = this.root;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            Type r4 = this.rootValueType;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            Type r7 = this.rootArrayElementType;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            boolean r10 = this.editable;
            ?? r11 = r10;
            if (r10 == false) goto L17;
            r11 = 1;
        L17:
            int r12 = (r9 + r11) * 31;
            JsonEditAdapter r13 = this.rootAdapter;
            if (r13 == null) goto L21;
            r1 = r13.hashCode();
        L21:
            return r12 + r1;
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return "State(root=" + this.root + ", rootValueType=" + this.rootValueType + ", rootArrayElementType=" + this.rootArrayElementType + ", editable=" + this.editable + ", rootAdapter=" + this.rootAdapter + ")";
        }

        public State(JsonElement r2, Type r3, Type r4, boolean r5, JsonEditAdapter r6) {
            Intrinsics.checkNotNullParameter(r2, "root");
            this.root = r2;
            this.rootValueType = r3;
            this.rootArrayElementType = r4;
            this.editable = r5;
            this.rootAdapter = r6;
        }

        public final JsonElement getRoot() {
            return this.root;
        }

        public final void setRoot(JsonElement r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.root = r2;
        }

        public /* synthetic */ State(JsonElement r8, Type r9, Type r10, boolean r11, JsonEditAdapter r12, int r13, DefaultConstructorMarker r14) {
            if ((r13 & 2) == 0) goto L5;
            Type r15 = (Type) null;
            Type r3 = null;
        L7:
            if ((r13 & 4) == 0) goto L9;
            Type r16 = (Type) null;
            Type r4 = null;
        L11:
            if ((r13 & 8) == 0) goto L13;
            r11 = true;
        L13:
            boolean r5 = r11;
            if ((r13 & 16) == 0) goto L16;
            JsonEditAdapter r17 = (JsonEditAdapter) null;
            JsonEditAdapter r6 = null;
        L17:
            this(r8, r3, r4, r5, r6);
            return;
        L16:
            r6 = r12;
            goto L17
        L9:
            r4 = r10;
            goto L11
        L5:
            r3 = r9;
            goto L7
        }

        public final Type getRootValueType() {
            return this.rootValueType;
        }

        public final Type getRootArrayElementType() {
            return this.rootArrayElementType;
        }

        public final boolean getEditable() {
            return this.editable;
        }

        public final void setEditable(boolean r1) {
            this.editable = r1;
        }

        public final JsonEditAdapter getRootAdapter() {
            return this.rootAdapter;
        }

        public final void setRootAdapter(JsonEditAdapter r1) {
            this.rootAdapter = r1;
        }

        public final String toJsonString() {
            String r1 = new Gson().toJson(this.root);
            Intrinsics.checkNotNullExpressionValue(r1, "Gson().toJson(root)");
            return r1;
        }
    }

    /* JADX INFO: renamed from: com.bytedanceos.security.debug.json.JsonEditorBinder$bind$5, reason: invalid class name */
    /* JADX INFO: compiled from: JsonEditorBinder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"adjustHorizontalMinWidth", "", "invoke"}, k = 3, mv = {1, 4, 3})
    static final class AnonymousClass5 extends Lambda implements Function0<Unit> {
        final /* synthetic */ View $contentView;
        final /* synthetic */ int $indentPerLevelPx;
        final /* synthetic */ View $rootView;
        final /* synthetic */ State $state;

        AnonymousClass5(View r1, State r2, int r3, View r4) {
            this.$rootView = r1;
            this.$state = r2;
            this.$indentPerLevelPx = r3;
            this.$contentView = r4;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Integer r0 = Integer.valueOf(this.$rootView.getWidth());
            if (r0.intValue() <= 0) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == true) goto L9;
            r0 = null;
        L9:
            if (r0 == null) goto L11;
            int r2 = r0.intValue();
        L12:
            int r3 = r2 + (RangesKt.coerceAtLeast(JsonEditorBinderKt.access$maxContainerDepth(this.$state.getRoot()) - 1, 0) * this.$indentPerLevelPx);
            if (this.$contentView.getMinimumWidth() >= r3) goto L16;
            this.$contentView.setMinimumWidth(r3);
            return;
        L16:
            return;
        L11:
            Resources r4 = this.$rootView.getResources();
            Intrinsics.checkNotNullExpressionValue(r4, "rootView.resources");
            r2 = r4.getDisplayMetrics().widthPixels;
            goto L12
        L5:
            r1 = false;
            goto L6
        }
    }

    /* JADX INFO: renamed from: com.bytedanceos.security.debug.json.JsonEditorBinder$bind$6, reason: invalid class name */
    /* JADX INFO: compiled from: JsonEditorBinder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"refreshSummary", "", "invoke"}, k = 3, mv = {1, 4, 3})
    static final class AnonymousClass6 extends Lambda implements Function0<Unit> {
        final /* synthetic */ View $rootContainer;
        final /* synthetic */ State $state;
        final /* synthetic */ TextView $tvRootAddItem;
        final /* synthetic */ TextView $tvRootSummary;

        AnonymousClass6(TextView r1, State r2, View r3, TextView r4) {
            this.$tvRootSummary = r1;
            this.$state = r2;
            this.$rootContainer = r3;
            this.$tvRootAddItem = r4;
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            TextView r0 = this.$tvRootSummary;
            Intrinsics.checkNotNullExpressionValue(r0, "tvRootSummary");
            r0.setText(JsonEditorBinderKt.access$summaryLabel(this.$state.getRoot()));
            if (this.$state.getRoot().isJsonObject() == false) goto L5;
            this.$rootContainer.setBackgroundResource(R.drawable.pm_bg_json_object_container);
        L6:
            TextView r1 = this.$tvRootAddItem;
            Intrinsics.checkNotNullExpressionValue(r1, "tvRootAddItem");
            if (this.$state.getRoot().isJsonArray() == true) goto L9;
        L11:
            int r3 = 8;
        L12:
            r1.setVisibility(r3);
            return;
        L9:
            if (this.$state.getEditable() == false) goto L11;
            r3 = 0;
            goto L12
        L5:
            View r2 = this.$rootContainer;
            Intrinsics.checkNotNullExpressionValue(r2, "rootContainer");
            Drawable r4 = (Drawable) null;
            r2.setBackground(null);
            goto L6
        }
    }

    static {
        INSTANCE = new JsonEditorBinder();
    }

    private JsonEditorBinder() {
    }

    public static /* synthetic */ void bind$default(JsonEditorBinder r0, View r1, JsonElement r2, Type r3, boolean r4, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = null;
        Type r7 = (Type) null;
    L6:
        if ((r5 & 8) == 0) goto L8;
        r4 = true;
    L8:
        r0.bind(r1, r2, r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v9, types: [T, com.bytedanceos.security.debug.json.JsonEditAdapter] */
    public final void bind(final View r22, JsonElement r23, Type r24, boolean r25) {
        Intrinsics.checkNotNullParameter(r22, "rootView");
        Intrinsics.checkNotNullParameter(r23, DBHelper.BATTERY_COL_SOURCE);
        JsonElement r3 = JsonParser.parseString(new Gson().toJson(r23));
        Intrinsics.checkNotNullExpressionValue(r3, "editableRoot");
        if (r24 == null) goto L5;
        Type r5 = JsonEditorBinderKt.access$arrayElementTypeOrNull(r24);
    L6:
        final State r1 = new State(r3, r24, r5, r25, null, 16, null);
        r22.setTag(R.id.json_editor_state, r1);
        final View r2 = r22.getRootView();
        if ((r22 instanceof ViewGroup) == true) goto L9;
        View r4 = null;
    L10:
        ViewGroup r6 = (ViewGroup) r4;
        if (r6 == null) goto L13;
        r6.setDescendantFocusability(131072);
    L13:
        r22.setFocusable(true);
        r22.setFocusableInTouchMode(true);
        r22.post(new AnonymousClass1(r22));
        ViewCompat.setOnApplyWindowInsetsListener(r2, new AnonymousClass2(r22));
        ViewCompat.requestApplyInsets(r2);
        final ViewTreeObserver.OnGlobalLayoutListener r7 = new JsonEditorBinder$bind$keyboardListener$1(r2, r22);
        r22.getViewTreeObserver().addOnGlobalLayoutListener(r7);
        r22.addOnAttachStateChangeListener(new AnonymousClass3(r2, r7));
        r22.setOnTouchListener(AnonymousClass4.INSTANCE);
        TextView r8 = (TextView) r22.findViewById(R.id.tv_root_summary);
        TextView r9 = (TextView) r22.findViewById(R.id.tv_root_add_item);
        View r10 = r22.findViewById(R.id.root_container);
        ExpandedListView r11 = (ExpandedListView) r22.findViewById(R.id.lv_root);
        View r12 = r22.findViewById(R.id.json_editor_content);
        if (r12 != null) goto L16;
        r12 = r22;
    L16:
        Resources r13 = r22.getResources();
        Intrinsics.checkNotNullExpressionValue(r13, "rootView.resources");
        final AnonymousClass5 r14 = new AnonymousClass5(r22, r1, (int) (r13.getDisplayMetrics().density * 12.0f), r12);
        final AnonymousClass6 r15 = new AnonymousClass6(r8, r1, r10, r9);
        r15.invoke2();
        r22.post(new AnonymousClass7(r14));
        final Function1<JsonElement, Unit> r16 = new JsonEditorBinder$bind$rootReplaceCb$1(r1, r15, r14);
        final Ref.ObjectRef r17 = new Ref.ObjectRef();
        JsonEditAdapter r18 = (JsonEditAdapter) null;
        r17.element = null;
        Function1<Integer, Unit> r20 = new JsonEditorBinder$bind$removeCb$1(r1, r15, r14, r17, r16);
        Context r0 = r22.getContext();
        Intrinsics.checkNotNullExpressionValue(r0, "rootView.context");
        r17.element = new JsonEditAdapter(r0, JsonEditAdapter.Companion.buildEntries(r1.getRoot(), r16), r1.getEditable(), r16, new AnonymousClass8(r15, r14), r20);
        r1.setRootAdapter((JsonEditAdapter) r17.element);
        Intrinsics.checkNotNullExpressionValue(r11, "listView");
        r11.setAdapter((JsonEditAdapter) r17.element);
        r9.setOnClickListener(new AnonymousClass9(r1, r15, r14, r17, r16));
        return;
    L9:
        r4 = r22;
        goto L10
    L5:
        r5 = null;
        goto L6
    }

    public final void setEditable(View r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        Object r1 = r2.getTag(R.id.json_editor_state);
        if ((r1 instanceof State) == true) goto L5;
        r1 = null;
    L5:
        State r4 = (State) r1;
        if (r4 != null) goto L9;
        return;
    L9:
        if (r4.getEditable() != r3) goto L11;
        return;
    L11:
        r4.setEditable(r3);
        TextView r5 = (TextView) r2.findViewById(R.id.tv_root_add_item);
        Intrinsics.checkNotNullExpressionValue(r5, "tvRootAddItem");
        if (r4.getRoot().isJsonArray() == true) goto L14;
    L16:
        int r0 = 8;
    L17:
        r5.setVisibility(r0);
        JsonEditAdapter r6 = r4.getRootAdapter();
        if (r6 == null) goto L21;
        r6.updateEditable(r3);
        return;
    L21:
        return;
    L14:
        if (r4.getEditable() == false) goto L16;
        r0 = 0;
        goto L17
    }

    public final JsonElement getEditedJson(View r2) {
        Intrinsics.checkNotNullParameter(r2, "rootView");
        Object r1 = r2.getTag(R.id.json_editor_state);
        if ((r1 instanceof State) == true) goto L5;
        r1 = null;
    L5:
        State r3 = (State) r1;
        if (r3 != null) goto L9;
        return null;
    L9:
        return r3.getRoot();
    }
}

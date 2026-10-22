package com.bytedanceos.security.debug.json;

import android.content.Context;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.obric.security.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: JsonEditAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u0000 22\u00020\u0001:\u0003234Bg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\n\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000e\u0012\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\f\u0018\u00010\n¢\u0006\u0002\u0010\u0011J\"\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\"\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0013H\u0002J\"\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u001a\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J\"\u0010!\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\"\u0010\"\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u001a\u0010#\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00132\b\u0010$\u001a\u0004\u0018\u00010 H\u0002J\b\u0010%\u001a\u00020\u0010H\u0016J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0010H\u0016J\u0010\u0010)\u001a\u00020*2\u0006\u0010(\u001a\u00020\u0010H\u0016J\u0010\u0010+\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u0010H\u0016J\"\u0010,\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010-\u001a\u00020\u0010H\u0016J\u000e\u0010.\u001a\u00020\f2\u0006\u0010/\u001a\u00020\bJ\u0014\u00100\u001a\u00020\f2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\f\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/bytedanceos/security/debug/json/JsonEditAdapter;", "Landroid/widget/BaseAdapter;", "context", "Landroid/content/Context;", "entries", "", "Lcom/bytedanceos/security/debug/json/JsonEditAdapter$Entry;", "editable", "", "onRootReplace", "Lkotlin/Function1;", "Lcom/google/gson/JsonElement;", "", "onRootChanged", "Lkotlin/Function0;", "onRemoveArrayItem", "", "(Landroid/content/Context;Ljava/util/List;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "bindArrayContainerView", "Landroid/view/View;", "entry", "convertView", "parent", "Landroid/view/ViewGroup;", "bindCheckBoxView", "bindContainerCommon", "view", "bindEditView", "bindKey", "tvKey", "Landroid/widget/TextView;", "key", "", "bindNullView", "bindObjectContainerView", "bindRemove", "displayKey", "getCount", "getItem", "", "position", "getItemId", "", "getItemViewType", "getView", "getViewTypeCount", "updateEditable", "newEditable", "updateEntries", "newEntries", "Companion", "Entry", "Type", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class JsonEditAdapter extends BaseAdapter {
    public static final Companion Companion = null;
    private final Context context;
    private boolean editable;
    private List<Entry> entries;
    private final Function1<Integer, Unit> onRemoveArrayItem;
    private final Function0<Unit> onRootChanged;
    private final Function1<JsonElement, Unit> onRootReplace;

    /* JADX INFO: compiled from: JsonEditAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J,\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\t\u001a\u00020\n2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fJ\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0002¨\u0006\u0011"}, d2 = {"Lcom/bytedanceos/security/debug/json/JsonEditAdapter$Companion;", "", "()V", "buildArrayEntries", "", "Lcom/bytedanceos/security/debug/json/JsonEditAdapter$Entry;", "arr", "Lcom/google/gson/JsonArray;", "buildEntries", "root", "Lcom/google/gson/JsonElement;", "onRootReplace", "Lkotlin/Function1;", "", "buildObjectEntries", "obj", "Lcom/google/gson/JsonObject;", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ List buildEntries$default(Companion r0, JsonElement r1, Function1 r2, int r3, Object r4) {
            if ((r3 & 2) == 0) goto L6;
            r2 = null;
            Function1 r5 = (Function1) null;
        L6:
            return r0.buildEntries(r1, r2);
        }

        public final List<Entry> buildEntries(JsonElement r2, final Function1<? super JsonElement, Unit> r3) {
            Intrinsics.checkNotNullParameter(r2, "root");
            if (r2.isJsonObject() == false) goto L6;
            JsonObject r4 = r2.getAsJsonObject();
            Intrinsics.checkNotNullExpressionValue(r4, "root.asJsonObject");
            return buildObjectEntries(r4);
        L6:
            if (r2.isJsonArray() == false) goto L9;
            JsonArray r5 = r2.getAsJsonArray();
            Intrinsics.checkNotNullExpressionValue(r5, "root.asJsonArray");
            return buildArrayEntries(r5);
        L9:
            return CollectionsKt.listOf(new Entry(null, r2, new JsonEditAdapter$Companion$buildEntries$1(r3)));
        }

        private final List<Entry> buildObjectEntries(final JsonObject r6) {
            Set<Map.Entry<String, JsonElement>> r5 = r6.entrySet();
            Intrinsics.checkNotNullExpressionValue(r5, "obj.entrySet()");
            Set<Map.Entry<String, JsonElement>> r7 = r5;
            ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r7, 10));
            Iterator<T> r8 = r7.iterator();
        L4:
            if (r8.hasNext() == false) goto L7;
            Map.Entry r1 = (Map.Entry) r8.next();
            final String r2 = (String) r1.getKey();
            JsonElement r3 = (JsonElement) r1.getValue();
            Intrinsics.checkNotNullExpressionValue(r3, "value");
            r0.add(new Entry(r2, r3, new JsonEditAdapter$Companion$buildObjectEntries$$inlined$map$lambda$1(r2, r6)));
            goto L4
        L7:
            return CollectionsKt.sortedWith(r0, new JsonEditAdapter$Companion$buildObjectEntries$$inlined$sortedBy$1());
        }

        private final List<Entry> buildArrayEntries(final JsonArray r7) {
            IntRange r6 = RangesKt.until(0, r7.size());
            ArrayList r0 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
            Iterator<Integer> r8 = r6.iterator();
        L4:
            if (r8.hasNext() == false) goto L7;
            final int r1 = ((IntIterator) r8).nextInt();
            JsonElement r2 = r7.get(r1);
            Intrinsics.checkNotNullExpressionValue(r2, "value");
            r0.add(new Entry("[" + r1 + ']', r2, new JsonEditAdapter$Companion$buildArrayEntries$$inlined$map$lambda$1(r1, r7)));
            goto L4
        L7:
            return r0;
        }
    }

    /* JADX INFO: compiled from: JsonEditAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\u0015\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J5\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/bytedanceos/security/debug/json/JsonEditAdapter$Entry;", "", "displayKey", "", "element", "Lcom/google/gson/JsonElement;", "replace", "Lkotlin/Function1;", "", "(Ljava/lang/String;Lcom/google/gson/JsonElement;Lkotlin/jvm/functions/Function1;)V", "getDisplayKey", "()Ljava/lang/String;", "getElement", "()Lcom/google/gson/JsonElement;", "setElement", "(Lcom/google/gson/JsonElement;)V", "getReplace", "()Lkotlin/jvm/functions/Function1;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Entry {
        private final String displayKey;
        private JsonElement element;
        private final Function1<JsonElement, Unit> replace;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Entry copy$default(Entry r0, String r1, JsonElement r2, Function1 r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.displayKey;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.element;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.replace;
        L12:
            return r0.copy(r1, r2, r3);
        }

        public final String component1() {
            return this.displayKey;
        }

        public final JsonElement component2() {
            return this.element;
        }

        public final Function1<JsonElement, Unit> component3() {
            return this.replace;
        }

        public final Entry copy(String r1, JsonElement r2, Function1<? super JsonElement, Unit> r3) {
            Intrinsics.checkNotNullParameter(r2, "element");
            Intrinsics.checkNotNullParameter(r3, "replace");
            return new Entry(r1, r2, r3);
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof Entry) == false) goto L12;
            Entry r4 = (Entry) r3;
            if (Intrinsics.areEqual(this.displayKey, r4.displayKey) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.element, r4.element) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.replace, r4.replace) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            String r0 = this.displayKey;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            JsonElement r4 = this.element;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            Function1<JsonElement, Unit> r7 = this.replace;
            if (r7 == null) goto L14;
            r1 = r7.hashCode();
        L14:
            return r6 + r1;
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public String toString() {
            return "Entry(displayKey=" + this.displayKey + ", element=" + this.element + ", replace=" + this.replace + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Entry(String r2, JsonElement r3, Function1<? super JsonElement, Unit> r4) {
            Intrinsics.checkNotNullParameter(r3, "element");
            Intrinsics.checkNotNullParameter(r4, "replace");
            this.displayKey = r2;
            this.element = r3;
            this.replace = r4;
        }

        public final String getDisplayKey() {
            return this.displayKey;
        }

        public final JsonElement getElement() {
            return this.element;
        }

        public final void setElement(JsonElement r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.element = r2;
        }

        public final Function1<JsonElement, Unit> getReplace() {
            return this.replace;
        }
    }

    /* JADX INFO: compiled from: JsonEditAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedanceos/security/debug/json/JsonEditAdapter$Type;", "", "(Ljava/lang/String;I)V", "EDIT", "CHECKBOX", "NULL", "OBJECT_CONTAINER", "ARRAY_CONTAINER", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
    private static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type ARRAY_CONTAINER = null;
        public static final Type CHECKBOX = null;
        public static final Type EDIT = null;
        public static final Type NULL = null;
        public static final Type OBJECT_CONTAINER = null;

        static {
            Type r1 = new Type("EDIT", 0);
            EDIT = r1;
            Type r2 = new Type("CHECKBOX", 1);
            CHECKBOX = r2;
            Type r3 = new Type("NULL", 2);
            NULL = r3;
            Type r4 = new Type("OBJECT_CONTAINER", 3);
            OBJECT_CONTAINER = r4;
            Type r5 = new Type("ARRAY_CONTAINER", 4);
            ARRAY_CONTAINER = r5;
            $VALUES = new Type[]{r1, r2, r3, r4, r5};
        }

        public static Type valueOf(String r1) {
            return (Type) Enum.valueOf(Type.class, r1);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        private Type(String r1, int r2) {
            super(r1, r2);
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[Type.values().length];
            $EnumSwitchMapping$0 = r0;
            r0[Type.EDIT.ordinal()] = 1;
            r0[Type.CHECKBOX.ordinal()] = 2;
            r0[Type.NULL.ordinal()] = 3;
            r0[Type.OBJECT_CONTAINER.ordinal()] = 4;
            r0[Type.ARRAY_CONTAINER.ordinal()] = 5;
        }
    }

    static {
        Companion = new Companion(null);
    }

    @Override // android.widget.Adapter
    public long getItemId(int r1) {
        return r1;
    }

    public static final /* synthetic */ boolean access$getEditable$p(JsonEditAdapter r0) {
        return r0.editable;
    }

    public static final /* synthetic */ Function1 access$getOnRemoveArrayItem$p(JsonEditAdapter r0) {
        return r0.onRemoveArrayItem;
    }

    public static final /* synthetic */ Function0 access$getOnRootChanged$p(JsonEditAdapter r0) {
        return r0.onRootChanged;
    }

    public static final /* synthetic */ Function1 access$getOnRootReplace$p(JsonEditAdapter r0) {
        return r0.onRootReplace;
    }

    public static final /* synthetic */ void access$setEditable$p(JsonEditAdapter r0, boolean r1) {
        r0.editable = r1;
    }

    public /* synthetic */ JsonEditAdapter(Context r8, List r9, boolean r10, Function1 r11, Function0 r12, Function1 r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 4) == 0) goto L5;
        r10 = true;
    L5:
        boolean r3 = r10;
        if ((r14 & 8) == 0) goto L8;
        Function1 r16 = (Function1) null;
        Function1 r4 = null;
    L10:
        if ((r14 & 16) == 0) goto L12;
        Function0 r17 = (Function0) null;
        Function0 r5 = null;
    L14:
        if ((r14 & 32) == 0) goto L16;
        Function1 r18 = (Function1) null;
        Function1 r6 = null;
    L17:
        this(r8, r9, r3, r4, r5, r6);
        return;
    L16:
        r6 = r13;
        goto L17
    L12:
        r5 = r12;
        goto L14
    L8:
        r4 = r11;
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public JsonEditAdapter(Context r2, List<Entry> r3, boolean r4, Function1<? super JsonElement, Unit> r5, Function0<Unit> r6, Function1<? super Integer, Unit> r7) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "entries");
        this.context = r2;
        this.entries = r3;
        this.editable = r4;
        this.onRootReplace = r5;
        this.onRootChanged = r6;
        this.onRemoveArrayItem = r7;
    }

    public final void updateEntries(List<Entry> r2) {
        Intrinsics.checkNotNullParameter(r2, "newEntries");
        this.entries = r2;
        notifyDataSetChanged();
    }

    public final void updateEditable(boolean r2) {
        if (this.editable != r2) goto L5;
        return;
    L5:
        this.editable = r2;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.entries.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int r1) {
        return this.entries.get(r1);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return Type.values().length;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int r1) {
        JsonElement r0 = this.entries.get(r1).getElement();
        if (r0.isJsonObject() == false) goto L6;
        return Type.OBJECT_CONTAINER.ordinal();
    L6:
        if (r0.isJsonArray() == false) goto L9;
        return Type.ARRAY_CONTAINER.ordinal();
    L9:
        if (r0.isJsonNull() == false) goto L12;
        return Type.NULL.ordinal();
    L12:
        if (r0.isJsonPrimitive() == false) goto L17;
        JsonPrimitive r2 = r0.getAsJsonPrimitive();
        Intrinsics.checkNotNullExpressionValue(r2, "el.asJsonPrimitive");
        if (r2.isBoolean() == false) goto L17;
        return Type.CHECKBOX.ordinal();
    L17:
        return Type.EDIT.ordinal();
    }

    @Override // android.widget.Adapter
    public View getView(int r3, View r4, ViewGroup r5) {
        Intrinsics.checkNotNullParameter(r5, "parent");
        Entry r0 = this.entries.get(r3);
        Type r6 = Type.values()[getItemViewType(r3)];
        int r7 = WhenMappings.$EnumSwitchMapping$0[r6.ordinal()];
        if (r7 == 1) goto L19;
        if (r7 == 2) goto L23;
        if (r7 == 3) goto L22;
        if (r7 == 4) goto L21;
        if (r7 != 5) goto L14;
        return bindArrayContainerView(r0, r4, r5);
    L14:
        throw new NoWhenBranchMatchedException();
    L21:
        return bindObjectContainerView(r0, r4, r5);
    L22:
        return bindNullView(r0, r4, r5);
    L23:
        return bindCheckBoxView(r0, r4, r5);
    L19:
        return bindEditView(r0, r4, r5);
    }

    private final View bindEditView(final Entry r7, View r8, ViewGroup r9) {
        if (r8 != null) goto L5;
        r8 = LayoutInflater.from(this.context).inflate(R.layout.pm_item_json_kv_edit, r9, false);
    L5:
        TextView r10 = (TextView) r8.findViewById(R.id.tv_key);
        EditText r1 = (EditText) r8.findViewById(R.id.et_value);
        Intrinsics.checkNotNullExpressionValue(r10, "tvKey");
        bindKey(r10, r7.getDisplayKey());
        JsonPrimitive r11 = JsonEditAdapterKt.access$asJsonPrimitiveOrNull(r7.getElement());
        int r2 = 1;
        if (r11 != null) goto L8;
    L10:
        final boolean r12 = false;
    L11:
        Intrinsics.checkNotNullExpressionValue(r1, "etValue");
        if (r12 == false) goto L14;
        r2 = 12290;
    L14:
        r1.setInputType(r2);
        Object r3 = r1.getTag(R.id.json_editor_watcher);
        if ((r3 instanceof TextWatcher) == true) goto L17;
        r3 = null;
    L17:
        TextWatcher r4 = (TextWatcher) r3;
        if (r4 == null) goto L20;
        r1.removeTextChangedListener(r4);
    L20:
        r1.setText(JsonEditAdapterKt.access$asDisplayString(r7.getElement()));
        if (r1.hasFocus() == true) goto L23;
        r1.setSelection(0);
    L23:
        r1.setEnabled(this.editable);
        r1.setFocusable(this.editable);
        r1.setFocusableInTouchMode(this.editable);
        if (this.editable == false) goto L26;
        TextWatcher r0 = new JsonEditAdapter$bindEditView$watcher$1(this, r12, r7);
        r1.addTextChangedListener(r0);
        r1.setTag(R.id.json_editor_watcher, r0);
    L27:
        Intrinsics.checkNotNullExpressionValue(r8, "view");
        bindRemove(r8, r7.getDisplayKey());
        return r8;
    L26:
        r1.setTag(R.id.json_editor_watcher, null);
        goto L27
    L8:
        if (r11.isNumber() != true) goto L10;
        r12 = true;
        goto L11
    }

    private final View bindCheckBoxView(final Entry r4, View r5, ViewGroup r6) {
        boolean r0 = false;
        if (r5 != null) goto L5;
        r5 = LayoutInflater.from(this.context).inflate(R.layout.pm_item_json_kv_checkbox, r6, false);
    L5:
        TextView r7 = (TextView) r5.findViewById(R.id.tv_key);
        CheckBox r1 = (CheckBox) r5.findViewById(R.id.cb_value);
        Intrinsics.checkNotNullExpressionValue(r7, "tvKey");
        bindKey(r7, r4.getDisplayKey());
        r1.setOnCheckedChangeListener(null);
        JsonPrimitive r8 = JsonEditAdapterKt.access$asJsonPrimitiveOrNull(r4.getElement());
        if (r8 == null) goto L8;
        r0 = r8.getAsBoolean();
    L8:
        Intrinsics.checkNotNullExpressionValue(r1, "cbValue");
        r1.setChecked(r0);
        r1.setEnabled(this.editable);
        if (this.editable == false) goto L11;
        r1.setOnCheckedChangeListener(new AnonymousClass1(this, r4));
    L11:
        Intrinsics.checkNotNullExpressionValue(r5, "view");
        bindRemove(r5, r4.getDisplayKey());
        return r5;
    }

    private final View bindNullView(Entry r3, View r4, ViewGroup r5) {
        if (r4 != null) goto L4;
        r4 = LayoutInflater.from(this.context).inflate(R.layout.pm_item_json_kv_null, r5, false);
    L4:
        TextView r6 = (TextView) r4.findViewById(R.id.tv_key);
        Intrinsics.checkNotNullExpressionValue(r6, "tvKey");
        bindKey(r6, r3.getDisplayKey());
        Intrinsics.checkNotNullExpressionValue(r4, "view");
        bindRemove(r4, r3.getDisplayKey());
        return r4;
    }

    private final View bindObjectContainerView(Entry r3, View r4, ViewGroup r5) {
        if (r4 != null) goto L4;
        r4 = LayoutInflater.from(this.context).inflate(R.layout.pm_item_json_kv_object_container, r5, false);
    L4:
        Intrinsics.checkNotNullExpressionValue(r4, "view");
        return bindContainerCommon(r3, r4);
    }

    private final View bindArrayContainerView(Entry r3, View r4, ViewGroup r5) {
        if (r4 != null) goto L4;
        r4 = LayoutInflater.from(this.context).inflate(R.layout.pm_item_json_kv_container, r5, false);
    L4:
        Intrinsics.checkNotNullExpressionValue(r4, "view");
        return bindContainerCommon(r3, r4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [T, com.bytedanceos.security.debug.json.JsonEditAdapter] */
    private final View bindContainerCommon(final Entry r23, View r24) {
        TextView r0 = (TextView) r24.findViewById(R.id.tv_key);
        final TextView r9 = (TextView) r24.findViewById(R.id.tv_type);
        ExpandedListView r10 = (ExpandedListView) r24.findViewById(R.id.lv_children);
        Intrinsics.checkNotNullExpressionValue(r0, "tvKey");
        bindKey(r0, r23.getDisplayKey());
        Intrinsics.checkNotNullExpressionValue(r9, "tvType");
        r9.setText(JsonEditAdapterKt.access$containerLabel(r23.getElement()));
        final Function1<JsonElement, Unit> r12 = new JsonEditAdapter$bindContainerCommon$childOnRootReplace$1(this, r23);
        JsonElement r1 = r23.getElement();
        Function1<Integer, Unit> r2 = null;
        if (r1.isJsonArray() == true) goto L6;
        r1 = null;
    L6:
        if (r1 == null) goto L8;
        JsonArray r13 = r1.getAsJsonArray();
    L9:
        final Ref.ObjectRef r14 = new Ref.ObjectRef();
        JsonEditAdapter r3 = (JsonEditAdapter) null;
        r14.element = null;
        if (r13 == null) goto L12;
        final JsonArray r4 = r13;
        r2 = new JsonEditAdapter$bindContainerCommon$removeCb$1(this, r4, r9, r23, r14, r12);
    L12:
        r14.element = new JsonEditAdapter(this.context, Companion.buildEntries(r23.getElement(), r12), this.editable, this.onRootReplace, this.onRootChanged, r2);
        Intrinsics.checkNotNullExpressionValue(r10, "lvChildren");
        r10.setAdapter((JsonEditAdapter) r14.element);
        TextView r11 = (TextView) r24.findViewById(R.id.tv_add_item);
        if (r13 == null) goto L19;
        Intrinsics.checkNotNullExpressionValue(r11, "tvAddItem");
        if (this.editable == false) goto L17;
        int r5 = 0;
    L18:
        r11.setVisibility(r5);
        final JsonArray r6 = r13;
        r11.setOnClickListener(new ViewOnClickListenerC01421(this, r6, r9, r23, r14, r12));
        goto L19
    L17:
        r5 = 8;
    L19:
        bindRemove(r24, r23.getDisplayKey());
        return r24;
    L8:
        r13 = null;
        goto L9
    }

    private final void bindKey(TextView r2, String r3) {
        String r1 = r3;
        if (r1 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == false) goto L11;
        r2.setVisibility(8);
        return;
    L11:
        r2.setVisibility(0);
        r2.setText(r3 + " :");
        return;
    L5:
        if (r1.length() == 0) goto L8;
        r4 = false;
        goto L9
    }

    private final void bindRemove(View r3, String r4) {
        TextView r5 = (TextView) r3.findViewById(R.id.tv_remove);
        if (r5 != null) goto L6;
        return;
    L6:
        if (r4 == null) goto L8;
        final Integer r6 = JsonEditAdapterKt.access$arrayIndexOrNull(r4);
    L10:
        if (this.editable == true) goto L12;
    L15:
        r5.setVisibility(8);
        r5.setOnClickListener(null);
        return;
    L12:
        if (this.onRemoveArrayItem == null) goto L15;
        if (r6 == null) goto L15;
        r5.setVisibility(0);
        r5.setOnClickListener(new ViewOnClickListenerC01431(this, r6));
        return;
    L8:
        r6 = null;
        goto L10
    }
}

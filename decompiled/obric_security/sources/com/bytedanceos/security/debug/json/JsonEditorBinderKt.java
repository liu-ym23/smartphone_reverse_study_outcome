package com.bytedanceos.security.debug.json;

import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import androidx.core.os.EnvironmentCompat;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.annotations.SerializedName;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JsonEditorBinder.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0002\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a\u000e\u0010\u0007\u001a\u0004\u0018\u00010\u0006*\u00020\u0006H\u0002\u001a\f\u0010\b\u001a\u00020\t*\u00020\nH\u0002\u001a\f\u0010\u000b\u001a\u00020\t*\u00020\nH\u0002\u001a\f\u0010\f\u001a\u00020\r*\u00020\u0001H\u0002\u001a\f\u0010\u000e\u001a\u00020\u000f*\u00020\u0001H\u0002¨\u0006\u0010"}, d2 = {"defaultFromClass", "Lcom/google/gson/JsonElement;", "clazz", "Ljava/lang/Class;", "defaultFromType", "type", "Ljava/lang/reflect/Type;", "arrayElementTypeOrNull", "clearEditorFocus", "", "Landroid/view/View;", "hideKeyboard", "maxContainerDepth", "", "summaryLabel", "", "app_neridaCnRelease"}, k = 2, mv = {1, 4, 3})
public final class JsonEditorBinderKt {
    public static final /* synthetic */ Type access$arrayElementTypeOrNull(Type r0) {
        return arrayElementTypeOrNull(r0);
    }

    public static final /* synthetic */ void access$clearEditorFocus(View r0) {
        clearEditorFocus(r0);
    }

    public static final /* synthetic */ JsonElement access$defaultFromType(Type r0) {
        return defaultFromType(r0);
    }

    public static final /* synthetic */ void access$hideKeyboard(View r0) {
        hideKeyboard(r0);
    }

    public static final /* synthetic */ int access$maxContainerDepth(JsonElement r0) {
        return maxContainerDepth(r0);
    }

    public static final /* synthetic */ String access$summaryLabel(JsonElement r0) {
        return summaryLabel(r0);
    }

    private static final void hideKeyboard(View r2) {
        Object r0 = r2.getContext().getSystemService("input_method");
        if ((r0 instanceof InputMethodManager) == true) goto L5;
        r0 = null;
    L5:
        InputMethodManager r1 = (InputMethodManager) r0;
        if (r1 != null) goto L8;
        return;
    L8:
        r1.hideSoftInputFromWindow(r2.getWindowToken(), 0);
    }

    private static final void clearEditorFocus(final View r4) {
        final View r0 = r4.findFocus();
        if ((r0 instanceof EditText) == false) goto L5;
    L6:
        r0.clearFocus();
        final boolean r1 = r0.isFocusable();
        final boolean r2 = r0.isFocusableInTouchMode();
        r0.setFocusable(false);
        r0.setFocusableInTouchMode(false);
        r0.post(new AnonymousClass1(r0, r1, r2));
    L7:
        r4.clearFocus();
        r4.setFocusable(true);
        r4.setFocusableInTouchMode(true);
        final Integer r3 = null;
        if ((r4 instanceof ViewGroup) == true) goto L10;
        View r5 = null;
    L11:
        final ViewGroup r6 = (ViewGroup) r5;
        if (r6 == null) goto L14;
        r3 = Integer.valueOf(r6.getDescendantFocusability());
    L14:
        if (r6 == null) goto L16;
        r6.setDescendantFocusability(393216);
    L16:
        r4.requestFocus();
        r4.post(new AnonymousClass2(r4));
        if (r6 == null) goto L21;
        if (r3 == null) goto L22;
        r4.post(new AnonymousClass3(r6, r3));
        return;
    L22:
        return;
    L21:
        return;
    L10:
        r5 = r4;
        goto L11
    L5:
        if ((r0 instanceof CheckBox) == false) goto L7;
        goto L6
    }

    private static final String summaryLabel(JsonElement r2) {
        if (r2.isJsonObject() == false) goto L6;
        return "object {" + r2.getAsJsonObject().entrySet().size() + '}';
    L6:
        if (r2.isJsonArray() == false) goto L9;
        return "array [" + r2.getAsJsonArray().size() + ']';
    L9:
        if (r2.isJsonNull() == false) goto L12;
        return "null";
    L12:
        if (r2.isJsonPrimitive() == false) goto L23;
        JsonPrimitive r3 = r2.getAsJsonPrimitive();
        Intrinsics.checkNotNullExpressionValue(r3, "p");
        if (r3.isBoolean() == false) goto L17;
        return "boolean";
    L17:
        if (r3.isNumber() == false) goto L20;
        return "number";
    L20:
        if (r3.isString() == false) goto L22;
        return "string";
    L22:
        return "primitive";
    L23:
        return EnvironmentCompat.MEDIA_UNKNOWN;
    }

    private static final int maxContainerDepth(JsonElement r3) {
        int r1 = 0;
        if (r3.isJsonObject() == false) goto L10;
        Iterator<Map.Entry<String, JsonElement>> r4 = r3.getAsJsonObject().entrySet().iterator();
    L6:
        if (r4.hasNext() == false) goto L15;
        JsonElement r0 = r4.next().getValue();
        Intrinsics.checkNotNullExpressionValue(r0, "entry.value");
        r1 = Math.max(r1, maxContainerDepth(r0));
    L15:
        return r1 + 1;
    L10:
        if (r3.isJsonArray() == false) goto L18;
        Iterator<JsonElement> r5 = r3.getAsJsonArray().iterator();
    L13:
        if (r5.hasNext() == false) goto L15;
        JsonElement r2 = r5.next();
        Intrinsics.checkNotNullExpressionValue(r2, "e");
        r1 = Math.max(r1, maxContainerDepth(r2));
        goto L13
    L18:
        return 0;
    }

    private static final Type arrayElementTypeOrNull(Type r3) {
        Class<?> r1 = null;
        if ((r3 instanceof Class) == false) goto L9;
        Class r4 = (Class) r3;
        if (r4.isArray() == false) goto L28;
        r1 = r4.getComponentType();
    L28:
        return r1;
    L9:
        if ((r3 instanceof GenericArrayType) == false) goto L12;
        return ((GenericArrayType) r3).getGenericComponentType();
    L12:
        if ((r3 instanceof ParameterizedType) == false) goto L23;
        ParameterizedType r5 = (ParameterizedType) r3;
        Type r0 = r5.getRawType();
        if ((r0 instanceof Class) == true) goto L16;
        r0 = null;
    L16:
        Class r2 = (Class) r0;
        if (r2 != null) goto L20;
        return null;
    L20:
        if (Collection.class.isAssignableFrom(r2) == false) goto L30;
        Type[] r6 = r5.getActualTypeArguments();
        Intrinsics.checkNotNullExpressionValue(r6, "actualTypeArguments");
        return (Type) ArraysKt.firstOrNull(r6);
    L30:
        return null;
    L23:
        if ((r3 instanceof WildcardType) == false) goto L32;
        Type[] r7 = ((WildcardType) r3).getUpperBounds();
        Intrinsics.checkNotNullExpressionValue(r7, "upperBounds");
        Type r8 = (Type) ArraysKt.firstOrNull(r7);
        if (r8 != null) goto L27;
        return null;
    L27:
        return arrayElementTypeOrNull(r8);
    L32:
        return null;
    }

    private static final JsonElement defaultFromType(Type r4) {
        if ((r4 instanceof WildcardType) == false) goto L9;
        Type[] r5 = ((WildcardType) r4).getUpperBounds();
        Intrinsics.checkNotNullExpressionValue(r5, "type.upperBounds");
        Class r6 = (Type) ArraysKt.firstOrNull(r5);
        if (r6 != null) goto L66;
    L66:
        return defaultFromType(r6);
    L9:
        if ((r4 instanceof GenericArrayType) == false) goto L12;
        return new JsonArray();
    L12:
        if ((r4 instanceof ParameterizedType) == false) goto L28;
        Type r7 = ((ParameterizedType) r4).getRawType();
        if ((r7 instanceof Class) == true) goto L16;
        r7 = null;
    L16:
        Class r8 = (Class) r7;
        if (r8 != null) goto L21;
        JsonNull r9 = JsonNull.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(r9, "JsonNull.INSTANCE");
        return r9;
    L21:
        if (Collection.class.isAssignableFrom(r8) == false) goto L24;
        return new JsonArray();
    L24:
        if (Map.class.isAssignableFrom(r8) == false) goto L70;
        return new JsonObject();
    L70:
        return defaultFromClass(r8);
    L28:
        if ((r4 instanceof Class) == false) goto L64;
        Class r0 = (Class) r4;
        if (r0.isArray() == false) goto L33;
        return new JsonArray();
    L33:
        if (Intrinsics.areEqual(r4, String.class) == true) goto L78;
        if (CharSequence.class.isAssignableFrom(r0) == true) goto L78;
        if (Intrinsics.areEqual(r4, Boolean.TYPE) == true) goto L77;
        if (Intrinsics.areEqual(r4, Boolean.TYPE) == true) goto L77;
        if (Number.class.isAssignableFrom(r0) == true) goto L76;
        if (r0.isPrimitive() == false) goto L52;
        if ((!Intrinsics.areEqual(r4, Boolean.TYPE)) == false) goto L52;
        if ((!Intrinsics.areEqual(r4, Character.TYPE)) == true) goto L76;
    L52:
        if (r0.isEnum() == false) goto L55;
        return new JsonPrimitive("");
    L55:
        if (Collection.class.isAssignableFrom(r0) == false) goto L58;
        return new JsonArray();
    L58:
        if (Map.class.isAssignableFrom(r0) == false) goto L75;
        return new JsonObject();
    L75:
        return defaultFromClass(r0);
    L76:
        return new JsonPrimitive((Number) 0);
    L77:
        return new JsonPrimitive(false);
    L78:
        return new JsonPrimitive("");
    L64:
        JsonNull r10 = JsonNull.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(r10, "JsonNull.INSTANCE");
        return r10;
    }

    private static final JsonElement defaultFromClass(Class<?> r6) {
        if (Intrinsics.areEqual(r6, Object.class) == true) goto L5;
        JsonObject r0 = new JsonObject();
        Field[] r7 = r6.getDeclaredFields();
        int r1 = r7.length;
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L22;
        Field r3 = r7[r2];
        Intrinsics.checkNotNullExpressionValue(r3, "field");
        if (r3.isSynthetic() == true) goto L20;
        if (Modifier.isStatic(r3.getModifiers()) == true) goto L20;
        if (Modifier.isTransient(r3.getModifiers()) == true) goto L20;
        SerializedName r4 = (SerializedName) r3.getAnnotation(SerializedName.class);
        if (r4 == null) goto L18;
        String r5 = r4.value();
        if (r5 == null) goto L18;
    L19:
        Type r8 = r3.getGenericType();
        Intrinsics.checkNotNullExpressionValue(r8, "field.genericType");
        r0.add(r5, defaultFromType(r8));
    L18:
        r5 = r3.getName();
    L20:
        r2 = r2 + 1;
        goto L7
    L22:
        return r0;
    L5:
        return new JsonObject();
    }
}

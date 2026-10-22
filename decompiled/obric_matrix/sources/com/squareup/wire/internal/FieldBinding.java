package com.squareup.wire.internal;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.wschannel.WsConstants;
import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireField;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.b0;
import kotlin.i0.m0;
import kotlin.i0.r;
import kotlin.n0.d.j0;
import kotlin.n0.d.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\u0014\b\u0000\u0010\u0002*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001*\u0014\b\u0001\u0010\u0004*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u00020\u0005B'\b\u0000\u0012\u0006\u0010?\u001a\u00020>\u0012\u0006\u0010;\u001a\u00020\n\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b@\u0010AJ#\u0010\u000b\u001a\u00020\n2\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ/\u0010\u000f\u001a\u00020\u000e2\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\t\u001a\u00020\b2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0011\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0011\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\u0011¢\u0006\u0004\b\u0014\u0010\u0013J\u0015\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011H\u0000¢\u0006\u0004\b\u0015\u0010\u0013J\u001f\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00028\u00012\u0006\u0010\u0018\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\"\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00028\u00012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005H\u0086\u0002¢\u0006\u0004\b\u001c\u0010\u001bJ\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001d\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0019\u0010\"\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0017\u001a\u00028\u0001H\u0000¢\u0006\u0004\b \u0010!R\u001c\u0010\u0014\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010#R\u001e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010#R\u0019\u0010%\u001a\u00020$8\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0019\u0010\t\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010)\u001a\u0004\b*\u0010+R\u0019\u0010-\u001a\u00020,8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0013\u00102\u001a\u0002018F@\u0006¢\u0006\u0006\u001a\u0004\b2\u00103R\u0016\u00104\u001a\u00020\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00106\u001a\u00020\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u0010)R\u0019\u00107\u001a\u0002018\u0006@\u0006¢\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u00103R\u001c\u0010\u0012\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010#R\u0016\u0010:\u001a\u00020\b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010)R\u0016\u0010;\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010=\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010<¨\u0006B"}, d2 = {"Lcom/squareup/wire/internal/FieldBinding;", "Lcom/squareup/wire/Message;", "M", "Lcom/squareup/wire/Message$Builder;", "B", "", "Ljava/lang/Class;", "builderType", "", "name", "Ljava/lang/reflect/Field;", "getBuilderField", "(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/reflect/Field;", WsConstants.KEY_CONNECTION_TYPE, "Ljava/lang/reflect/Method;", "getBuilderMethod", "(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/reflect/Method;", "Lcom/squareup/wire/ProtoAdapter;", "singleAdapter", "()Lcom/squareup/wire/ProtoAdapter;", "keyAdapter", "adapter$wire_runtime", "adapter", "builder", "value", "Lkotlin/f0;", "value$wire_runtime", "(Lcom/squareup/wire/Message$Builder;Ljava/lang/Object;)V", "set", "message", "get", "(Lcom/squareup/wire/Message;)Ljava/lang/Object;", "getFromBuilder$wire_runtime", "(Lcom/squareup/wire/Message$Builder;)Ljava/lang/Object;", "getFromBuilder", "Lcom/squareup/wire/ProtoAdapter;", "", LocationMonitorConst.TAG, "I", "getTag", "()I", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "Lcom/squareup/wire/WireField$Label;", "label", "Lcom/squareup/wire/WireField$Label;", "getLabel", "()Lcom/squareup/wire/WireField$Label;", "", "isMap", "()Z", "builderMethod", "Ljava/lang/reflect/Method;", "adapterString", "redacted", "Z", "getRedacted", "keyAdapterString", "messageField", "Ljava/lang/reflect/Field;", "builderField", "Lcom/squareup/wire/WireField;", "wireField", "<init>", "(Lcom/squareup/wire/WireField;Ljava/lang/reflect/Field;Ljava/lang/Class;)V", "wire-runtime"}, k = 1, mv = {1, 1, 15})
public final class FieldBinding<M extends Message<M, B>, B extends Message.Builder<M, B>> {
    private ProtoAdapter<Object> adapter;
    private final String adapterString;
    private final Field builderField;
    private final Method builderMethod;
    private ProtoAdapter<?> keyAdapter;
    private final String keyAdapterString;
    private final WireField.Label label;
    private final Field messageField;
    private final String name;
    private final boolean redacted;
    private ProtoAdapter<?> singleAdapter;
    private final int tag;

    public FieldBinding(WireField r3, Field r4, Class<B> r5) {
        o.g(r3, "wireField");
        o.g(r4, "messageField");
        o.g(r5, "builderType");
        this.messageField = r4;
        this.label = r3.label();
        String r0 = r4.getName();
        o.b(r0, "messageField.name");
        this.name = r0;
        this.tag = r3.tag();
        this.keyAdapterString = r3.keyAdapter();
        this.adapterString = r3.adapter();
        this.redacted = r3.redacted();
        this.builderField = getBuilderField(r5, r0);
        Class<?> r6 = r4.getType();
        o.b(r6, "messageField.type");
        this.builderMethod = getBuilderMethod(r5, r0, r6);
    }

    private final Field getBuilderField(Class<?> r3, String r4) {
        Field r2 = r3.getField(r4);     // Catch: NoSuchFieldException -> L4
        o.b(r2, "builderType.getField(name)");     // Catch: NoSuchFieldException -> L4
        return r2;
    L5:
        throw new AssertionError("No builder field " + r3.getName() + '.' + r4);
    }

    private final Method getBuilderMethod(Class<?> r3, String r4, Class<?> r5) {
        Method r2 = r3.getMethod(r4, new Class[]{r5});     // Catch: NoSuchMethodException -> L5
        o.b(r2, "builderType.getMethod(name, type)");     // Catch: NoSuchMethodException -> L5
        return r2;
    L6:
        throw new AssertionError("No builder method " + r3.getName() + '.' + r4 + '(' + r5.getName() + ')');
    }

    public final ProtoAdapter<Object> adapter$wire_runtime() {
        ProtoAdapter<Object> r0 = this.adapter;
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (isMap() == false) goto L21;
        ProtoAdapter<?> r1 = keyAdapter();
        if (r1 == null) goto L20;
        ProtoAdapter<?> r2 = singleAdapter();
        if (r2 == null) goto L18;
        ProtoAdapter<Object> r3 = ProtoAdapter.Companion.newMapAdapter(r1, r2);
        if (r3 == null) goto L16;
        this.adapter = r3;
        return r3;
    L16:
        throw new b0("null cannot be cast to non-null type com.squareup.wire.ProtoAdapter<kotlin.Any>");
    L18:
        throw new b0("null cannot be cast to non-null type com.squareup.wire.ProtoAdapter<kotlin.Any>");
    L20:
        throw new b0("null cannot be cast to non-null type com.squareup.wire.ProtoAdapter<kotlin.Any>");
    L21:
        ProtoAdapter<?> r4 = singleAdapter().withLabel$wire_runtime(this.label);
        if (r4 == null) goto L26;
        this.adapter = r4;
        return r4;
    L26:
        throw new b0("null cannot be cast to non-null type com.squareup.wire.ProtoAdapter<kotlin.Any>");
    }

    public final Object get(M r2) {
        o.g(r2, "message");
        return this.messageField.get(r2);
    }

    public final Object getFromBuilder$wire_runtime(B r2) {
        o.g(r2, "builder");
        return this.builderField.get(r2);
    }

    public final WireField.Label getLabel() {
        return this.label;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean getRedacted() {
        return this.redacted;
    }

    public final int getTag() {
        return this.tag;
    }

    public final boolean isMap() {
        if (this.keyAdapterString.length() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final ProtoAdapter<?> keyAdapter() {
        ProtoAdapter<?> r0 = this.keyAdapter;
        if (r0 != null) goto L7;
        ProtoAdapter<?> r1 = ProtoAdapter.Companion.get(this.keyAdapterString);
        this.keyAdapter = r1;
        return r1;
    L7:
        return r0;
    }

    public final void set(B r3, Object r4) {
        o.g(r3, "builder");
        if (this.label.isOneOf() == false) goto L5;
        this.builderMethod.invoke(r3, new Object[]{r4});
        return;
    L5:
        this.builderField.set(r3, r4);
    }

    public final ProtoAdapter<?> singleAdapter() {
        ProtoAdapter<?> r0 = this.singleAdapter;
        if (r0 != null) goto L7;
        ProtoAdapter<?> r1 = ProtoAdapter.Companion.get(this.adapterString);
        this.singleAdapter = r1;
        return r1;
    L7:
        return r0;
    }

    public final void value$wire_runtime(B r5, Object r6) {
        o.g(r5, "builder");
        o.g(r6, "value");
        Class<?> r2 = null;
        if (this.label.isRepeated() == false) goto L19;
        Object r0 = getFromBuilder$wire_runtime(r5);
        if (j0.l(r0) == false) goto L11;
        if (r0 == null) goto L9;
        j0.b(r0).add(r6);
        return;
    L9:
        throw new b0("null cannot be cast to non-null type kotlin.collections.MutableList<kotlin.Any>");
    L11:
        if ((r0 instanceof List) == false) goto L14;
        List r1 = r.B0((Collection) r0);
        r1.add(r6);
        Object r3 = r1;
    L13:
        set(r5, r3);
        return;
    L14:
        if (r0 == null) goto L17;
        r2 = r0.getClass();
    L17:
        throw new ClassCastException("Expected a list type, got " + r2 + '.');
    L19:
        if (this.keyAdapterString.length() <= 0) goto L21;
        boolean r4 = true;
    L22:
        if (r4 == false) goto L33;
        Object r7 = getFromBuilder$wire_runtime(r5);
        if (j0.m(r7) == false) goto L27;
        ((Map) r7).putAll((Map) r6);
        return;
    L27:
        if ((r7 instanceof Map) == false) goto L29;
        Map r8 = m0.u((Map) r7);
        r8.putAll((Map) r6);
        r3 = r8;
        goto L13
    L29:
        if (r7 == null) goto L32;
        r2 = r7.getClass();
    L32:
        throw new ClassCastException("Expected a map type, got " + r2 + '.');
    L33:
        set(r5, r6);
        return;
    L21:
        r4 = false;
        goto L22
    }
}

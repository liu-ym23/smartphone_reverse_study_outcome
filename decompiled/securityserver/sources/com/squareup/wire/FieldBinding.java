package com.squareup.wire;

import com.bytedance.librarian.LibrarianImpl;
import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class FieldBinding<M extends Message<M, B>, B extends Message.Builder<M, B>> {
    private ProtoAdapter<Object> adapter;
    private final String adapterString;
    private final Field builderField;
    private final Method builderMethod;
    private ProtoAdapter<?> keyAdapter;
    private final String keyAdapterString;
    public final WireField.Label label;
    private final Field messageField;
    public final String name;
    public final boolean redacted;
    private ProtoAdapter<?> singleAdapter;
    public final int tag;

    public FieldBinding(WireField r3, Field r4, Class<B> r5) {
        this.label = r3.label();
        String r0 = r4.getName();
        this.name = r0;
        this.tag = r3.tag();
        this.keyAdapterString = r3.keyAdapter();
        this.adapterString = r3.adapter();
        this.redacted = r3.redacted();
        this.messageField = r4;
        this.builderField = getBuilderField(r5, r0);
        this.builderMethod = getBuilderMethod(r5, r0, r4.getType());
    }

    private static Field getBuilderField(Class<?> r3, String r4) {
        return r3.getField(r4);
    L5:
        throw new AssertionError("No builder field " + r3.getName() + LibrarianImpl.Constants.DOT + r4);
    }

    private static Method getBuilderMethod(Class<?> r3, String r4, Class<?> r5) {
        return r3.getMethod(r4, new Class[]{r5});
    L5:
        throw new AssertionError("No builder method " + r3.getName() + LibrarianImpl.Constants.DOT + r4 + "(" + r5.getName() + ")");
    }

    public ProtoAdapter<Object> adapter() {
        ProtoAdapter<Object> r0 = this.adapter;
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (isMap() == false) goto L9;
        ProtoAdapter<Object> r1 = ProtoAdapter.newMapAdapter(keyAdapter(), singleAdapter());
        this.adapter = r1;
        return r1;
    L9:
        ProtoAdapter<?> r2 = singleAdapter().withLabel(this.label);
        this.adapter = r2;
        return r2;
    }

    public Object get(M r1) {
        return this.messageField.get(r1);
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }

    public Object getFromBuilder(B r1) {
        return this.builderField.get(r1);
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }

    public boolean isMap() {
        return !this.keyAdapterString.isEmpty();
    }

    public ProtoAdapter<?> keyAdapter() {
        ProtoAdapter<?> r0 = this.keyAdapter;
        if (r0 == null) goto L5;
        return r0;
    L5:
        ProtoAdapter<?> r1 = ProtoAdapter.get(this.keyAdapterString);
        this.keyAdapter = r1;
        return r1;
    }

    public void set(B r2, Object r3) {
    L5:
        e = move-exception;
        throw new AssertionError(e);
    L3:
        if (this.label.isOneOf() == false) goto L7;
        this.builderMethod.invoke(r2, new Object[]{r3});     // Catch: Throwable -> L5
        return;
    L7:
        this.builderField.set(r2, r3);     // Catch: Throwable -> L5
    }

    public ProtoAdapter<?> singleAdapter() {
        ProtoAdapter<?> r0 = this.singleAdapter;
        if (r0 == null) goto L5;
        return r0;
    L5:
        ProtoAdapter<?> r1 = ProtoAdapter.get(this.adapterString);
        this.singleAdapter = r1;
        return r1;
    }

    public void value(B r2, Object r3) {
        if (this.label.isRepeated() == false) goto L6;
        ((List) getFromBuilder(r2)).add(r3);
        return;
    L6:
        if (this.keyAdapterString.isEmpty() == true) goto L8;
        ((Map) getFromBuilder(r2)).putAll((Map) r3);
        return;
    L8:
        set(r2, r3);
    }
}

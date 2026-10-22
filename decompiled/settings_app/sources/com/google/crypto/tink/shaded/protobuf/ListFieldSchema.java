package com.google.crypto.tink.shaded.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
@CheckReturnValue
abstract class ListFieldSchema {
    private static final ListFieldSchema FULL_INSTANCE = null;
    private static final ListFieldSchema LITE_INSTANCE = null;

    /* JADX INFO: renamed from: com.google.crypto.tink.shaded.protobuf.ListFieldSchema$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class ListFieldSchemaFull extends ListFieldSchema {
        private static final Class<?> UNMODIFIABLE_LIST_CLASS = null;

        private ListFieldSchemaFull() {
            super(null);
        }

        /* synthetic */ ListFieldSchemaFull(AnonymousClass1 r1) {
            this();
        }

        static {
            UNMODIFIABLE_LIST_CLASS = Collections.unmodifiableList(Collections.emptyList()).getClass();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ListFieldSchema
        <L> List<L> mutableListAt(Object message, long offset) {
            return mutableListAt(message, offset, 10);
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ListFieldSchema
        void makeImmutableListAt(Object message, long offset) {
            List r2 = (List) UnsafeUtil.getObject(message, offset);
            if ((r2 instanceof LazyStringList) == false) goto L6;
            Object r3 = ((LazyStringList) r2).getUnmodifiableView();
        L17:
            UnsafeUtil.putObject(message, offset, r3);
            return;
        L6:
            if (UNMODIFIABLE_LIST_CLASS.isAssignableFrom(r2.getClass()) == false) goto L9;
            return;
        L9:
            if ((r2 instanceof PrimitiveNonBoxingCollection) == true) goto L11;
        L16:
            r3 = Collections.unmodifiableList(r2);
            goto L17
        L11:
            if ((r2 instanceof Internal.ProtobufList) == false) goto L16;
            Internal.ProtobufList r4 = (Internal.ProtobufList) r2;
            if (r4.isModifiable() == false) goto L19;
            r4.makeImmutable();
            return;
        }

        private static <L> List<L> mutableListAt(Object r3, long r4, int r6) {
            List<L> r0 = getList(r3, r4);
            if (r0.isEmpty() == false) goto L15;
            if ((r0 instanceof LazyStringList) == false) goto L8;
            List<L> r1 = new LazyStringArrayList(r6);
        L13:
            UnsafeUtil.putObject(r3, r4, r1);
            return r1;
        L8:
            if ((r0 instanceof PrimitiveNonBoxingCollection) == true) goto L10;
        L12:
            r1 = new ArrayList(r6);
            goto L13
        L10:
            if ((r0 instanceof Internal.ProtobufList) == false) goto L12;
            r1 = ((Internal.ProtobufList) r0).mutableCopyWithCapacity(r6);
            goto L13
        L15:
            if (UNMODIFIABLE_LIST_CLASS.isAssignableFrom(r0.getClass()) == false) goto L19;
            ArrayList r2 = new ArrayList(r0.size() + r6);
            r2.addAll(r0);
            UnsafeUtil.putObject(r3, r4, r2);
            Object r5 = r2;
        L30:
            return (List<L>) r5;
        L19:
            if ((r0 instanceof UnmodifiableLazyStringList) == false) goto L22;
            LazyStringArrayList r7 = new LazyStringArrayList(r0.size() + r6);
            r7.addAll((UnmodifiableLazyStringList) r0);
            UnsafeUtil.putObject(r3, r4, r7);
            r5 = r7;
            goto L30
        L22:
            if ((r0 instanceof PrimitiveNonBoxingCollection) == true) goto L24;
            return r0;
        L24:
            if ((r0 instanceof Internal.ProtobufList) == false) goto L32;
            Internal.ProtobufList r8 = (Internal.ProtobufList) r0;
            if (r8.isModifiable() == true) goto L33;
            Internal.ProtobufList r9 = r8.mutableCopyWithCapacity(r0.size() + r6);
            UnsafeUtil.putObject(r3, r4, r9);
            return r9;
        L33:
            return r0;
        L32:
            return r0;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ListFieldSchema
        <E> void mergeListsAt(Object msg, Object otherMsg, long offset) {
            List r2 = getList(otherMsg, offset);
            List r4 = mutableListAt(msg, offset, r2.size());
            int r0 = r4.size();
            int r1 = r2.size();
            if (r0 <= 0) goto L6;
            if (r1 <= 0) goto L6;
            r4.addAll(r2);
        L6:
            if (r0 <= 0) goto L8;
            r2 = r4;
        L8:
            UnsafeUtil.putObject(msg, offset, r2);
        }

        static <E> List<E> getList(Object message, long offset) {
            return (List) UnsafeUtil.getObject(message, offset);
        }
    }

    private static final class ListFieldSchemaLite extends ListFieldSchema {
        private ListFieldSchemaLite() {
            super(null);
        }

        /* synthetic */ ListFieldSchemaLite(AnonymousClass1 r1) {
            this();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ListFieldSchema
        <L> List<L> mutableListAt(Object message, long offset) {
            Internal.ProtobufList r1 = getProtobufList(message, offset);
            if (r1.isModifiable() == true) goto L10;
            int r0 = r1.size();
            if (r0 != 0) goto L7;
            int r2 = 10;
        L8:
            Internal.ProtobufList r3 = r1.mutableCopyWithCapacity(r2);
            UnsafeUtil.putObject(message, offset, r3);
            return r3;
        L7:
            r2 = r0 * 2;
            goto L8
        L10:
            return r1;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ListFieldSchema
        void makeImmutableListAt(Object message, long offset) {
            getProtobufList(message, offset).makeImmutable();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.ListFieldSchema
        <E> void mergeListsAt(Object msg, Object otherMsg, long offset) {
            Internal.ProtobufList r3 = getProtobufList(msg, offset);
            Internal.ProtobufList r5 = getProtobufList(otherMsg, offset);
            int r0 = r3.size();
            int r1 = r5.size();
            if (r0 <= 0) goto L9;
            if (r1 <= 0) goto L9;
            if (r3.isModifiable() == true) goto L8;
            r3 = r3.mutableCopyWithCapacity(r1 + r0);
        L8:
            r3.addAll(r5);
        L9:
            if (r0 <= 0) goto L11;
            r5 = r3;
        L11:
            UnsafeUtil.putObject(msg, offset, r5);
        }

        static <E> Internal.ProtobufList<E> getProtobufList(Object message, long offset) {
            return (Internal.ProtobufList) UnsafeUtil.getObject(message, offset);
        }
    }

    abstract void makeImmutableListAt(Object msg, long offset);

    abstract <L> void mergeListsAt(Object msg, Object otherMsg, long offset);

    abstract <L> List<L> mutableListAt(Object msg, long offset);

    /* synthetic */ ListFieldSchema(AnonymousClass1 r1) {
        this();
    }

    private ListFieldSchema() {
    }

    static {
        AnonymousClass1 r1 = null;
        FULL_INSTANCE = new ListFieldSchemaFull(r1);
        LITE_INSTANCE = new ListFieldSchemaLite(r1);
    }

    static ListFieldSchema full() {
        return FULL_INSTANCE;
    }

    static ListFieldSchema lite() {
        return LITE_INSTANCE;
    }
}

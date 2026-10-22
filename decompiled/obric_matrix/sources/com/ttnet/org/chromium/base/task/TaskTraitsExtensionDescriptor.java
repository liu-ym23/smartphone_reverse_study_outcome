package com.ttnet.org.chromium.base.task;

/* JADX INFO: loaded from: classes2.dex */
public interface TaskTraitsExtensionDescriptor<Extension> {
    Extension fromSerializedData(byte[] r1);

    int getId();

    byte[] toSerializedData(Extension r1);
}

package com.obric.capabilitykit.common;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/capabilitykit/common/MemoryActionType;", "", "()V", "MEMORY_ACTION_TYPE_ADD_CONTACT", "", "MEMORY_ACTION_TYPE_ADD_NOTE", "MEMORY_ACTION_TYPE_ADD_SCHEDULE", "MEMORY_ACTION_TYPE_ADD_TODO", "MEMORY_ACTION_TYPE_CHOOSE_ADDRESS_OR_PHONE", "MEMORY_ACTION_TYPE_CHOOSE_CONTACT", "MEMORY_ACTION_TYPE_DELETE_TODO", "MEMORY_ACTION_TYPE_FINISH_TODO", "MEMORY_ACTION_TYPE_LIST_CONTACT", "MEMORY_ACTION_TYPE_LIST_NOTE", "MEMORY_ACTION_TYPE_LIST_TODO", "MEMORY_ACTION_TYPE_UPDATE_CONTACT", "MEMORY_ACTION_TYPE_UPDATE_TODO", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MemoryActionType {
    public static final MemoryActionType INSTANCE = null;
    public static final int MEMORY_ACTION_TYPE_ADD_CONTACT = 64;
    public static final int MEMORY_ACTION_TYPE_ADD_NOTE = 32;
    public static final int MEMORY_ACTION_TYPE_ADD_SCHEDULE = 2048;
    public static final int MEMORY_ACTION_TYPE_ADD_TODO = 1;
    public static final int MEMORY_ACTION_TYPE_CHOOSE_ADDRESS_OR_PHONE = 256;
    public static final int MEMORY_ACTION_TYPE_CHOOSE_CONTACT = 128;
    public static final int MEMORY_ACTION_TYPE_DELETE_TODO = 8;
    public static final int MEMORY_ACTION_TYPE_FINISH_TODO = 16;
    public static final int MEMORY_ACTION_TYPE_LIST_CONTACT = 2048;
    public static final int MEMORY_ACTION_TYPE_LIST_NOTE = 512;
    public static final int MEMORY_ACTION_TYPE_LIST_TODO = 2;
    public static final int MEMORY_ACTION_TYPE_UPDATE_CONTACT = 1024;
    public static final int MEMORY_ACTION_TYPE_UPDATE_TODO = 4;

    static {
        INSTANCE = new MemoryActionType();
    }

    private MemoryActionType() {
    }
}

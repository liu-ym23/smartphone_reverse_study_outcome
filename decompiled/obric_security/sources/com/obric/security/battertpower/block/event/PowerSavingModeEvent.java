package com.obric.security.battertpower.block.event;

import com.bytedance.blockframework.interaction.Event;
import kotlin.Metadata;

/* JADX INFO: compiled from: ChangFontThemeEvent.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/security/battertpower/block/event/PowerSavingModeEvent;", "Lcom/bytedance/blockframework/interaction/Event;", "isPowerSavingMode", "", "(Z)V", "()Z", "app_neridaCnRelease"}, k = 1, mv = {1, 4, 3})
public final class PowerSavingModeEvent extends Event {
    private final boolean isPowerSavingMode;

    public PowerSavingModeEvent(boolean r4) {
        super(false, 1, null);
        this.isPowerSavingMode = r4;
    }

    public final boolean isPowerSavingMode() {
        return this.isPowerSavingMode;
    }
}

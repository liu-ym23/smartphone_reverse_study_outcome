package com.obric.oui.panel.anim;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class AnimController {

    @Metadata
    public static final enum AnimProcessType extends Enum<AnimProcessType> {
        public static final AnimProcessType b = null;
        public static final AnimProcessType c = null;
        public static final /* synthetic */ AnimProcessType[] e = null;

        static {
            AnimProcessType r0 = new AnimProcessType("NONE", 0);
            AnimProcessType r1 = new AnimProcessType("DOING", 1);
            b = r1;
            AnimProcessType r2 = new AnimProcessType("DONE", 2);
            c = r2;
            e = new AnimProcessType[]{r0, r1, r2};
        }

        public static AnimProcessType valueOf(String r1) {
            return (AnimProcessType) Enum.valueOf(AnimProcessType.class, r1);
        }

        public static AnimProcessType[] values() {
            return (AnimProcessType[]) e.clone();
        }
    }
}

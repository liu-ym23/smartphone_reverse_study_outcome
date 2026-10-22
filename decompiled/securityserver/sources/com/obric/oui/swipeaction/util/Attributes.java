package com.obric.oui.swipeaction.util;

/* JADX INFO: loaded from: classes2.dex */
public class Attributes {

    public static final enum Mode extends Enum<Mode> {
        public static final /* synthetic */ Mode[] b = null;

        static {
            b = new Mode[]{new Mode("Single", 0), new Mode("Multiple", 1)};
        }

        public static Mode valueOf(String r1) {
            return (Mode) Enum.valueOf(Mode.class, r1);
        }

        public static Mode[] values() {
            return (Mode[]) b.clone();
        }
    }
}

package com.bytedanceos.rotateview;

import android.content.Context;
import android.graphics.Color;
import com.bytedanceos.security.Utils;
import com.obric.olog.OLog;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ControllPositionData {
    private static final long DEFAULT_DELAY_TIME = 0;
    private static final String TAG = "ControllPositionData";
    private long mAnimDelayTime;
    private int mColor;
    private List<Position> mPositions;
    private boolean mRepeat;
    private TYPE mType;

    public static class Position {
        public float x;
        public float y;

        public Position(float x, float y) {
            this.x = x;
            this.y = y;
        }
    }

    public static final enum TYPE extends Enum<TYPE> {
        private static final /* synthetic */ TYPE[] $VALUES = null;
        public static final TYPE APP = null;
        public static final TYPE DISTRUB = null;
        public static final TYPE MEMORY = null;
        public static final TYPE NET = null;
        public static final TYPE POWER = null;
        public static final TYPE SETTING = null;
        public static final TYPE STORAGE = null;
        public static final TYPE TRASH = null;

        private static /* synthetic */ TYPE[] $values() {
            return new TYPE[]{TRASH, MEMORY, POWER, APP, DISTRUB, NET, STORAGE, SETTING};
        }

        private TYPE(String $enum$name, int $enum$ordinal) {
            super($enum$name, $enum$ordinal);
        }

        public static TYPE valueOf(String name) {
            return (TYPE) Enum.valueOf(TYPE.class, name);
        }

        public static TYPE[] values() {
            return (TYPE[]) $VALUES.clone();
        }

        static {
            TRASH = new TYPE("TRASH", 0);
            MEMORY = new TYPE("MEMORY", 1);
            POWER = new TYPE("POWER", 2);
            APP = new TYPE("APP", 3);
            DISTRUB = new TYPE("DISTRUB", 4);
            NET = new TYPE("NET", 5);
            STORAGE = new TYPE("STORAGE", 6);
            SETTING = new TYPE("SETTING", 7);
            $VALUES = $values();
        }
    }

    public ControllPositionData() {
        this.mRepeat = false;
        this.mAnimDelayTime = 0;
        this.mPositions = new ArrayList();
    }

    public static ControllPositionData getByConfig(Context context, String[] configdatas) {
        ControllPositionData r0 = new ControllPositionData();
        if (configdatas != null) goto L16;
        return r0;
    L16:
    L13:
        e = move-exception;
        OLog.d(TAG, "ControllPositionData getByString exception=" + e);
    L15:
        return r0;
    L6:
        if (configdatas.length <= 0) goto L8;
        r0.setColor(Color.parseColor(configdatas[0].trim()));     // Catch: Exception -> L13
    L8:
        int r3 = 1;
    L9:
        if (r3 >= configdatas.length) goto L15;
        String[] r4 = configdatas[r3].trim().split("\\s*,\\s*");     // Catch: Exception -> L13
        r0.addPosition(new Position(Utils.dp2Pixels(context, Float.parseFloat(r4[0])), Utils.dp2Pixels(context, Float.parseFloat(r4[1]))));     // Catch: Exception -> L13
        r3 = r3 + 1;
        goto L9
    }

    public int getColor() {
        return this.mColor;
    }

    public void setColor(int color) {
        this.mColor = color;
    }

    public boolean isRepeat() {
        return this.mRepeat;
    }

    public void setRepeat(boolean repeat) {
        this.mRepeat = repeat;
    }

    public long getAnimDelayTime() {
        return this.mAnimDelayTime;
    }

    public void addPosition(Position position) {
        if (position != null) goto L4;
        return;
    L4:
        this.mPositions.add(position);
    }

    public List<Position> getPostions() {
        return this.mPositions;
    }

    public void setmAnimDelayTime(long animDelayTime) {
        this.mAnimDelayTime = animDelayTime;
    }

    public TYPE getType() {
        return this.mType;
    }

    public void setType(TYPE type) {
        this.mType = type;
    }
}

package androidx.slice.widget;

import com.android.vcard.VCardConstants;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public class EventInfo {
    public static final int ACTION_TYPE_BUTTON = 1;
    public static final int ACTION_TYPE_CONTENT = 3;
    public static final int ACTION_TYPE_SEE_MORE = 4;
    public static final int ACTION_TYPE_SLIDER = 2;
    public static final int ACTION_TYPE_TOGGLE = 0;
    public static final int POSITION_CELL = 2;
    public static final int POSITION_END = 1;
    public static final int POSITION_START = 0;
    public static final int ROW_TYPE_GRID = 1;
    public static final int ROW_TYPE_LIST = 0;
    public static final int ROW_TYPE_MESSAGING = 2;
    public static final int ROW_TYPE_PROGRESS = 5;
    public static final int ROW_TYPE_SHORTCUT = -1;
    public static final int ROW_TYPE_SLIDER = 4;
    public static final int ROW_TYPE_TOGGLE = 3;
    public static final int STATE_OFF = 0;
    public static final int STATE_ON = 1;
    public int actionCount;
    public int actionIndex;
    public int actionPosition;
    public int actionType;
    public int rowIndex;
    public int rowTemplateType;
    public int sliceMode;
    public int state;

    @Retention(RetentionPolicy.SOURCE)
    public @interface SliceActionType {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SliceButtonPosition {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SliceRowType {
    }

    public EventInfo(int r1, int r2, int r3, int r4) {
        this.sliceMode = r1;
        this.actionType = r2;
        this.rowTemplateType = r3;
        this.rowIndex = r4;
        this.actionPosition = -1;
        this.actionIndex = -1;
        this.actionCount = -1;
        this.state = -1;
    }

    public void setPosition(int r1, int r2, int r3) {
        this.actionPosition = r1;
        this.actionIndex = r2;
        this.actionCount = r3;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("mode=");
        r0.append(SliceView.modeToString(this.sliceMode));
        r0.append(", actionType=").append(actionToString(this.actionType));
        r0.append(", rowTemplateType=").append(rowTypeToString(this.rowTemplateType));
        r0.append(", rowIndex=").append(this.rowIndex);
        r0.append(", actionPosition=").append(positionToString(this.actionPosition));
        r0.append(", actionIndex=").append(this.actionIndex);
        r0.append(", actionCount=").append(this.actionCount);
        r0.append(", state=").append(this.state);
        return r0.toString();
    }

    private static String positionToString(int r2) {
        if (r2 != 0) goto L4;
        return "START";
    L4:
        if (r2 != 1) goto L6;
        return VCardConstants.PROPERTY_END;
    L6:
        if (r2 != 2) goto L8;
        return VCardConstants.PARAM_TYPE_CELL;
    L8:
        return "unknown position: " + r2;
    }

    private static String actionToString(int r2) {
        if (r2 != 0) goto L4;
        return "TOGGLE";
    L4:
        if (r2 != 1) goto L6;
        return "BUTTON";
    L6:
        if (r2 != 2) goto L8;
        return "SLIDER";
    L8:
        if (r2 != 3) goto L10;
        return "CONTENT";
    L10:
        if (r2 != 4) goto L12;
        return "SEE MORE";
    L12:
        return "unknown action: " + r2;
    }

    private static String rowTypeToString(int r2) {
        switch(r2) {
            case -1: goto L17;
            case 0: goto L15;
            case 1: goto L13;
            case 2: goto L11;
            case 3: goto L9;
            case 4: goto L7;
            case 5: goto L5;
            default: goto L4;
        };
    L5:
        return "PROGRESS";
    L7:
        return "SLIDER";
    L9:
        return "TOGGLE";
    L11:
        return "MESSAGING";
    L13:
        return "GRID";
    L15:
        return "LIST";
    L17:
        return "SHORTCUT";
    L4:
        return "unknown row type: " + r2;
    }
}

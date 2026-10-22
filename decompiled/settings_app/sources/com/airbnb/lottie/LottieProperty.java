package com.airbnb.lottie;

import android.graphics.ColorFilter;
import android.graphics.PointF;
import com.airbnb.lottie.value.ScaleXY;

/* JADX INFO: loaded from: classes.dex */
public interface LottieProperty {
    public static final Integer COLOR = null;
    public static final ColorFilter COLOR_FILTER = null;
    public static final Float CORNER_RADIUS = null;
    public static final PointF ELLIPSE_SIZE = null;
    public static final Integer[] GRADIENT_COLOR = null;
    public static final Integer OPACITY = null;
    public static final Float POLYSTAR_INNER_RADIUS = null;
    public static final Float POLYSTAR_INNER_ROUNDEDNESS = null;
    public static final Float POLYSTAR_OUTER_RADIUS = null;
    public static final Float POLYSTAR_OUTER_ROUNDEDNESS = null;
    public static final Float POLYSTAR_POINTS = null;
    public static final Float POLYSTAR_ROTATION = null;
    public static final PointF POSITION = null;
    public static final PointF RECTANGLE_SIZE = null;
    public static final Float REPEATER_COPIES = null;
    public static final Float REPEATER_OFFSET = null;
    public static final Integer STROKE_COLOR = null;
    public static final Float STROKE_WIDTH = null;
    public static final Float TEXT_SIZE = null;
    public static final Float TEXT_TRACKING = null;
    public static final Float TIME_REMAP = null;
    public static final PointF TRANSFORM_ANCHOR_POINT = null;
    public static final Float TRANSFORM_END_OPACITY = null;
    public static final Integer TRANSFORM_OPACITY = null;
    public static final PointF TRANSFORM_POSITION = null;
    public static final Float TRANSFORM_ROTATION = null;
    public static final ScaleXY TRANSFORM_SCALE = null;
    public static final Float TRANSFORM_SKEW = null;
    public static final Float TRANSFORM_SKEW_ANGLE = null;
    public static final Float TRANSFORM_START_OPACITY = null;

    static {
        COLOR = 1;
        STROKE_COLOR = 2;
        TRANSFORM_OPACITY = 3;
        OPACITY = 4;
        TRANSFORM_ANCHOR_POINT = new PointF();
        TRANSFORM_POSITION = new PointF();
        ELLIPSE_SIZE = new PointF();
        RECTANGLE_SIZE = new PointF();
        Float r0 = Float.valueOf(0.0f);
        CORNER_RADIUS = r0;
        POSITION = new PointF();
        TRANSFORM_SCALE = new ScaleXY();
        TRANSFORM_ROTATION = Float.valueOf(1.0f);
        TRANSFORM_SKEW = r0;
        TRANSFORM_SKEW_ANGLE = r0;
        STROKE_WIDTH = Float.valueOf(2.0f);
        TEXT_TRACKING = Float.valueOf(3.0f);
        REPEATER_COPIES = Float.valueOf(4.0f);
        REPEATER_OFFSET = Float.valueOf(5.0f);
        POLYSTAR_POINTS = Float.valueOf(6.0f);
        POLYSTAR_ROTATION = Float.valueOf(7.0f);
        POLYSTAR_INNER_RADIUS = Float.valueOf(8.0f);
        POLYSTAR_OUTER_RADIUS = Float.valueOf(9.0f);
        POLYSTAR_INNER_ROUNDEDNESS = Float.valueOf(10.0f);
        POLYSTAR_OUTER_ROUNDEDNESS = Float.valueOf(11.0f);
        Float r1 = Float.valueOf(12.0f);
        TRANSFORM_START_OPACITY = r1;
        TRANSFORM_END_OPACITY = r1;
        TIME_REMAP = Float.valueOf(13.0f);
        TEXT_SIZE = Float.valueOf(14.0f);
        COLOR_FILTER = new ColorFilter();
        GRADIENT_COLOR = new Integer[0];
    }
}

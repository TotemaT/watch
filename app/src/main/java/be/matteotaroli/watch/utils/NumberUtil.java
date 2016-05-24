package be.matteotaroli.watch.utils;

/**
 * Created by matt on 24/05/16.
 */
public class NumberUtil {
    public static float roundToNearestHalf(float number) {
        return Math.round(number * 2) / 2.0f;
    }
}

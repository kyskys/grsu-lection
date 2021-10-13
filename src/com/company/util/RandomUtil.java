package com.company.util;

import java.util.Random;

public class RandomUtil {
    public static int randomInt(int max, int min) {
        return new Random().nextInt(max - min) + min;
    }
}

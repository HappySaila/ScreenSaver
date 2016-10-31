package com.mygdx.game;

import java.util.Random;

/**
 * Created by HappySaila on 10/31/16.
 */
public class Utils {
    public static int generate(int i){
        Random random = new Random();
        return random.nextInt(i);
    }

    public static int generate(int i, int j){
        Random random = new Random();
        return random.nextInt(j-i)+i;
    }
}

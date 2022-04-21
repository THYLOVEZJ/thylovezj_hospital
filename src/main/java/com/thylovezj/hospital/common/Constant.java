package com.thylovezj.hospital.common;

import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Component
public class Constant {
    public static final String salt = "98scc2154545";
    public static String FILE_UPLOAD_DIR;
    //客观题type
    public static final Integer subType = 0;
    //主观题type
    public static final Integer objType = 1;


    public static List<Integer> randomNumberGenerator(int num, int size) {
        List<Integer> res = new ArrayList<>();
        Random random = new Random();
        while (true) {
            int number = random.nextInt(size);
            if (!res.contains(number+1)) {
                res.add(number+1);
            }
            if (res.size() == num) {
                break;
            }
        }
        return res;
    }
}

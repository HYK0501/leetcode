package org.example;

import java.lang.reflect.Array;
import java.util.*;

public class KClostestPoint {
    public int[][]  kClosest(int[][] points , int kNum) {
        HashMap<Integer, Integer> distanceMap = new HashMap<>();
        int[][] res = new int[kNum][2];
        int max = -1;
        int total = 0;
        for (int i = 0; i < points.length; i++) {
            int dis = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            //System.out.println( max );
            if (distanceMap.isEmpty()) {
                max = dis;
                distanceMap.put(max, 1);
                total++;
            } else {
                if (total < kNum) {
                    if (distanceMap.keySet().contains(dis)) {
                        distanceMap.replace(dis, distanceMap.get(dis) + 1);
                        //total++;
                    } else {
                        distanceMap.put(dis, 1);
                        if (dis > max) {
                            max = dis;
                        }
                    }
                    total++;
                } else {
                    if (dis < max) {
                        //System.out.println( dis );
                        if (distanceMap.keySet().contains(dis)) {
                            distanceMap.replace(dis, distanceMap.get(dis) + 1);
                        } else {
                            distanceMap.put(dis, 1);
                        }
                        total = total - distanceMap.get(max) + 1;
                        distanceMap.remove(max);
                        //System.out.println( "max" );
                        //System.out.println( max );
                        max = Collections.max(distanceMap.keySet());
                    }
                }
            }
        }
        //System.out.println( distanceMap.keySet() );
        int index = 0;
        for (int i = 0; i < points.length; i++) {
            int dis = points[i][0] * points[i][0] + points[i][1] * points[i][1];
            //System.out.println( dis );
            if (distanceMap.keySet().contains(dis)) {
                //System.out.println( dis );
                res[index] = points[i];
                index++;
            }

            if (index == kNum) {
                break;
            }
            //index++;
        }
        return res;
    }
}

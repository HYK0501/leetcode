package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class CheapestFlightsWithinKStops {


    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer , List<int[]> > flightAnsPriceMap = new HashMap<>();
        HashMap<Integer , Integer> miniPrices = new HashMap<>();
        HashSet<Integer> srcs = new HashSet<>();
        for (int[] ints : flights) {
            int[] temp = new int[2];temp[0] = ints[1];temp[1] = ints[2];
            flightAnsPriceMap.computeIfAbsent(ints[0], k1 -> new ArrayList<int[]>());
            flightAnsPriceMap.get(ints[0]).add(temp);
        }
        srcs.add( src );
        miniPrices.put( src , 0);
        for(int stop = 0 ; stop < k ; stop++){
            HashSet<Integer> nextSrcs = new HashSet<>();
            HashMap<Integer,Integer> prePrices = new HashMap<>();
            for(Integer nowLocation : srcs) prePrices.put( nowLocation , miniPrices.get(nowLocation) );
            for(Integer nowLocation : srcs){
                List<int[]> nextFlights = flightAnsPriceMap.get( nowLocation );int preNeedPrice = prePrices.get(nowLocation);
                if( nextFlights == null ) continue;
                for( int[] flight : nextFlights){
                    miniPrices.merge( flight[0] , preNeedPrice + flight[1] , ( oldV , newV ) -> {
                            if( oldV > newV ) return newV;
                            return oldV;
                        }
                    );
                    nextSrcs.add( flight[0] );
                }
            }
            srcs = nextSrcs;
        }
        if( miniPrices.get(dst) == null) return -1;
        else return miniPrices.get(dst);
    }
}

package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BusRoutes {
        HashSet<Integer> visited;
        public int numBusesToDestination(int[][] routes, int source, int target) {
                visited = new HashSet<>();
                ArrayList<Integer> buses = new ArrayList<>();
                HashMap<Integer , Set<Integer> > routesVisitMap = new HashMap<>();
                for(int i = 0 ; i < routes.length ; i++){
                        routesVisitMap.put( i , IntStream.of(routes[i]).boxed().collect(Collectors.toSet() ) );
                }
                visited.add( source );
                if( source == target ) return 0;
                int step = 0;
                while( !routesVisitMap.keySet().isEmpty() ){
                        int nowBusNum = routesVisitMap.keySet().size();
                        step++;
                        HashSet<Integer> nextVisited = new HashSet<>();
                        for( Integer bus : routesVisitMap.keySet() ){
                                boolean contain = false;
                                for( Integer sign : routesVisitMap.get( bus ) ){
                                        if( visited.contains( sign ) ){
                                                contain = true;
                                                break;
                                        }
                                }
                                if( contain ){
                                        nextVisited.addAll( routesVisitMap.get( bus ) );
                                        buses.add( bus );
                                }
                        }
                        visited.addAll(nextVisited);
                        if( visited.contains( target ) ) return step;
                        for( Integer bus : buses ) routesVisitMap.remove(bus);
                        if( routesVisitMap.keySet().size() == nowBusNum ) return -1;
                }
                return -1;
        }

}

package org.example;

import java.util.*;

public class CourseSchedule {
    public boolean dfs( LinkedList<Integer> stack , Set<Integer> visited , int point ,  Map<Integer , HashSet<Integer>> graph){
        HashSet<Integer> nexts = graph.get( point );
        stack.addLast( point );
        if(nexts == null){
            stack.removeLast();
            return true;
        }
        for( Integer next : nexts ){
            if( stack.contains( next ) ){
                return false;
            }else{
                if( !visited.contains( next ) ){
                    boolean pointRes = dfs( stack , visited , next , graph);
                    if(!pointRes){
                        return false;
                    }
                }
            }
        }
        stack.removeLast();
        visited.add( point );
        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //point to it's prerequisites
        Map<Integer , HashSet<Integer>> pointAndNext = new HashMap<>();
        for( int i = 0 ; i < prerequisites.length ; i++ ){
            if( pointAndNext.keySet().contains(prerequisites[i][0]) ){
                Set<Integer> nexts = pointAndNext.get( prerequisites[i][0] );
                nexts.add( prerequisites[i][1] );
            }else{
                HashSet<Integer> nexts = new HashSet<>();
                nexts.add( prerequisites[i][1] );
                pointAndNext.put( prerequisites[i][0] , nexts);
            }
        }
        LinkedList<Integer> stack = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        for( Integer point : pointAndNext.keySet() ){
            if( !visited.contains(point) ){
                boolean res = dfs( stack , visited , point , pointAndNext);
                if(!res){
                    return res;
                }
                stack.clear();
            }
        }
        return true;
    }
}

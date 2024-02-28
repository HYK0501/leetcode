package org.example;

import java.util.*;

public class AccountMerge {
    public void dfs( String email, Map<String , Set<String>> graph , HashSet<String> visited , LinkedList<String> emails ){
        emails.add( email );
        visited.add( email );
        for( String related : graph.get( email ) ){
            if( !visited.contains( related ) ) {
                dfs( related , graph , visited , emails );
            }
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String , Set<String>> graph = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        //build graph
        for( List<String> info : accounts ){
            for( int i = 1 ; i < info.size() ; i++ ){
                if( graph.get( info.get(i) ) == null ) graph.put( info.get(i) , new HashSet<>() );
                if( i != 1 ) {
                    graph.get( info.get(i) ).add( info.get( i - 1 ) );
                    graph.get( info.get(i-1) ).add( info.get( i ) );
                }
            }
        }
        HashSet<String> visited = new HashSet<>();
        for( List<String> info : accounts ){
            if( visited.contains( info.get(1) ) ) continue;
            else{
                LinkedList<String> emails = new LinkedList<>();
                dfs( info.get(1) , graph , visited , emails );
                Collections.sort( emails );
                emails.addFirst( info.get(0) );
                res.add( emails );
            }
        }
        return res;
    }
}

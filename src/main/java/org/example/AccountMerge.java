package org.example;

import java.util.*;

public class AccountMerge {

    public static void main(String[] arg){
        int res =0;
        int total = 0;
        for( int i = 777 ; i >=1 ; i--){
            total = total + i;
            if( total > 5000){
                res++;
                total = i;
                System.out.println(i);
            }
        }
        System.out.println(res);
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String , List<Set<String>> > nameMap = new HashMap<>();
        for(List<String> account : accounts){
            List<Set<String>> emailGroups = nameMap.get( account.get(0) );
            if( emailGroups != null ){
                boolean newSameNameUser = true;
                Set<String> emailSet = new HashSet<>();
                emailSet.addAll( account.subList(1 ,  account.size() ) );
                List<Set<String>> removes = new ArrayList<>();
                for( Set<String> emailGroup : emailGroups ){
                    for( int i = 1 ; i < account.size() ; i++){
                        if( emailGroup.contains( account.get(i) ) ){
                            removes.add( emailGroup );
                            emailSet.addAll( emailGroup );
                            newSameNameUser = false;
                            break;
                        }
                    }
                }
                if( newSameNameUser ){
                    emailGroups.add( emailSet );
                }else{
                    emailGroups.removeAll( removes );
                    emailGroups.add( emailSet );
                }
            }else{
                List<Set<String>> newEmailGroups = new ArrayList<>();
                Set<String> emailSet = new HashSet<>();
                emailSet.addAll( account.subList(1 ,  account.size() ) );
                newEmailGroups.add( emailSet );
                nameMap.put( account.get(0) , newEmailGroups );
            }
        }
        List<List<String>> res = new ArrayList<>();
        for( String name : nameMap.keySet() ){
            List<Set<String>> emailGroups = nameMap.get(name);
            for( Set<String> emailGroup : emailGroups ){
                List<String> account = new ArrayList<>();
                account.addAll( emailGroup );
                Collections.sort( account );
                account.add( 0 ,  name);
                res.add( account );
            }
        }
        return res;
    }
}

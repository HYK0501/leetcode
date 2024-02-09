package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GenerateParentheses {

    public List<StringBuilder> generateParenthesis(int left , int right ){//remain left and right number
        List<StringBuilder> tempRes = new ArrayList<>();
        if( right == 1 && left == 0){
            StringBuilder sb = new StringBuilder().append( ")" );
            tempRes.add( sb );
        }else{
            if( left < right){
                List<StringBuilder> rightRes =  generateParenthesis( left , right - 1);
                for( StringBuilder sb : rightRes ) sb.append( ")" );
                tempRes.addAll( rightRes );
            }
            if( left > 0) {
                List<StringBuilder> leftRes =  generateParenthesis(left - 1, right);
                for (StringBuilder sb : leftRes) sb.append("(");
                tempRes.addAll(leftRes);
            }
        }
        return tempRes;
    }

    public List<String> generateParenthesis(int n) {
        List<StringBuilder> res = generateParenthesis( n , n);
        return res.stream().map( sb -> sb.reverse().toString() ).collect(Collectors.toList());
    }
}

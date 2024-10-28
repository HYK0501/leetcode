package org.example;

public class ConstructtheLongestNewString {
    public int build(int x, int y, int z,char type){
        if( type == 'x' ){
            if( y > 0 ) return build( x , y-1 , z , 'y' ) + 1;
        }else if( type == 'y' ) {
            int xNum = 0; int zNum = 0;
            if( x > 0 ) xNum = build( x-1 , y , z , 'x' ) + 1;
            if( z > 0 ) zNum = build( x , y , z-1 , 'z' ) + 1;
            if( x > 0 || z > 0 ) return Math.max( xNum , zNum );
        }else if( type == 'z' ){
            if( x > 0 ) return build( x-1 , y , z , 'x' ) + 1;
        }
        return 1;
    }
    public int longestString(int x, int y, int z) {
        int xNum = 0; int yNum = 0; int zNum = 0;
        if( x > 0 ) xNum = build( x-1 , y , z , 'x' );
        if( y > 0 ) yNum = build( x , y-1 , z , 'y' );
        if( z > 0 ) zNum = build( x , y , z-1 , 'z' );
        return Math.max( xNum , Math.max( yNum , zNum ) );
    }
}

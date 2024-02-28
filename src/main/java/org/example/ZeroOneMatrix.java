package org.example;

import java.util.ArrayList;

public class ZeroOneMatrix {

    public int[][] updateMatrix(int[][] mat) {
        int[][] res = new int[mat.length][mat[0].length];
        ArrayList<int[]> indexes = new ArrayList<>();
        for(int i = 0  ; i < mat.length ; i++) {
            for(int j=0 ; j < mat[0].length ; j++) {
                if( mat[i][j] == 0 ){
                    indexes.add(new int[] {i , j});
                    res[i][j] = 0;
                }
                else res[i][j] = -1;
            }
        }
        while( !indexes.isEmpty() ){
            ArrayList<int[]> nextIndexes = new ArrayList<>();
            for( int[] index : indexes ){
                int i = index[0]; int j = index[1];
                if( i > 0 ) {
                    if( res[i-1][j] == -1){
                        nextIndexes.add(new int[] {i-1 , j});
                        res[i-1][j] = res[i][j] + 1;
                    }
                }
                if( i < mat.length-1 ) {
                    if( res[i+1][j] == -1 ){
                        nextIndexes.add(new int[] {i+1 , j});
                        res[i+1][j] = res[i][j] + 1;
                    }
                }
                if( j < mat[0].length-1 ) {
                    if( res[i][j+1] == -1 ){
                        nextIndexes.add(new int[] {i , j+1});
                        res[i][j+1] = res[i][j] + 1;
                    }
                }
                if( j > 0 ) {
                    if( res[i][j-1] == -1 ){
                        nextIndexes.add(new int[] {i , j-1});
                        res[i][j-1] = res[i][j] + 1;
                    }
                }
            }
            indexes = nextIndexes;
        }
        return res;
    }

    /*
    class Solution {
    int[] DIR = new int[]{0, 1, 0, -1, 0}; //範圍檢查 絕活！！
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length; // The distance of cells is up to (M+N)
        Queue<int[]> q = new ArrayDeque<>();
        for (int r = 0; r < m; ++r)
            for (int c = 0; c < n; ++c)
                if (mat[r][c] == 0) q.offer(new int[]{r, c});
                else mat[r][c] = -1; // Marked as not processed yet!

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0], c = curr[1];
            for (int i = 0; i < 4; ++i) {
                int nr = r + DIR[i], nc = c + DIR[i+1];
                if (nr < 0 || nr == m || nc < 0 || nc == n || mat[nr][nc] != -1) continue;
                mat[nr][nc] = mat[r][c] + 1;
                q.offer(new int[]{nr, nc});
            }
        }
        return mat;
    }
}
     */
}

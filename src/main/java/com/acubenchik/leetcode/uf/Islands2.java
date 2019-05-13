package com.acubenchik.leetcode.uf;

public class Islands2 {

    public static void main(String[] args) {
        int res = new Islands2().numIslands(new char[][]{
                {'1', '1', '0', '1'},
                {'1', '1', '0', '0'},
                {'1', '1', '0', '1'},
                {'1', '1', '0', '1'}

        });
        System.out.println(res);
    }

    public  int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        UF uf = new UF(m*n);
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<m; j++)
            {
                if (grid[i][j] == '0') {
                    uf.sets[ i*(m)+j] = Integer.MIN_VALUE;
                    continue;
                }

                if (i+1 < n && grid[i+1][j]=='1')
                    uf.union(i*(m)+j, (i+1)*(m)+j);
                if (i-1 >= 0 && grid[i-1][j]=='1')
                    uf.union(i*(m)+j, (i-1)*(m)+j);
                if (j+1 < m && grid[i][j+1]=='1')
                    uf.union(i*(m)+j, (i)*(m)+j+1);
                if (j-1 >= 0 && grid[i][j-1]=='1')
                    uf.union(i*(m)+j, (i)*(m)+j-1);

            }
        }
        int res =  0;
        for (int i = 0; i < uf.sets.length; i++) {
            if(uf.sets[i] == i)
                res++;
        }

        return res;
    }

    class UF {
        public int[] sets;
        public int [] sz ;

        public UF(int sizeM) {
            sets = new int[sizeM];
            for(int i = 0; i < sets.length; i++) {
                sets[i] = i;
            }
            sz = new int[sizeM];
        }


        public void union(int i, int j) {
            int iRoot = root( i);
            int jRoot = root( j);
            if(sz[iRoot] < sz[jRoot]) { sets[iRoot] = jRoot; sz[iRoot] += sz[jRoot];}
            else { sets[jRoot] = iRoot; sz[jRoot] += sz[iRoot];}


        }


        public int root(int source){
            while(sets[source] != source) {
                sets[source] = sets[sets[source]];
                source = sets[source];}

            return source;
        }
    }
}

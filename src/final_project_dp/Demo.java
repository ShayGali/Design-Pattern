package final_project_dp;


import final_project_dp.q1.DfsConnectedComponents;
import final_project_dp.q2.ShortsPath;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Demo {
    public static void main(String[] args) {
        int[][] mat = {
             //  0  1  2
                {1, 0, 0}, // 0
                {1, 1, 0}, // 1
                {0, 1, 0}, // 2
                {1, 0, 1}, // 3
                {1, 1, 1}, // 4
        };

        MatrixAsGraph matrixAsGraph = new MatrixAsGraph(new Matrix(mat));
        ShortsPath<Index> bfs = new ShortsPath<>();
        DfsConnectedComponents<Index> dfsConnectedComponents = new DfsConnectedComponents<>();

        Set<Index> cc = bfs.bfs(matrixAsGraph, new Index(2,1));
//        Set<Index> cc = bfs.shortsPath(matrixAsGraph, new Index(0,0), new Index(4,2));
//        Set<Set<Index>> cc2 = dfsConnectedComponents.allConnectedComponents(matrixAsGraph);

        System.out.println(cc);
//        System.out.println(cc2);

    }

}

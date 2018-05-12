package com.company.others;

/**
 * ISM算法，邻接矩阵求可达矩阵
 */
public class ISM {

    public static void main(String[] args) {
        // 邻接矩阵
        int adjacency[][] = {
                {0, 0, 0, 1, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 1, 1, 0, 0, 0},
                {1, 0, 1, 0, 1, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 0, 1, 1, 1, 0, 0, 0}
//                {0,0,1,1,0,1,0,1,1,0,0,1},
//                {0,0,1,0,0,0,0,1,0,0,0,0},
//                {0,0,0,0,0,1,1,1,0,0,0,0},
//                {1,0,1,0,0,0,0,1,0,1,0,0},
//                {0,0,0,0,0,1,0,0,0,1,0,0},
//                {0,0,1,0,0,0,0,1,1,0,0,0},
//                {0,0,0,0,0,1,0,1,1,0,0,0},
//                {0,0,0,0,0,1,1,0,1,0,0,0},
//                {0,0,0,0,0,0,0,0,0,0,0,0},
//                {0,0,0,0,0,0,0,0,1,0,1,1},
//                {0,0,0,0,0,0,0,0,1,1,0,1},
//                {0,0,0,0,0,0,0,0,1,0,0,0}
        };
        // 可达矩阵
        int reachability[][] = null;

        System.out.println("邻接矩阵：");
        show(adjacency);
        reachability = addUnit(adjacency);
        System.out.println("可达矩阵：");
        show(reachability);
        int n = 0;
        do {
            n++;
            reachability = square(reachability);
            reachability = format(reachability);
            System.out.println("第" + n + "次布尔运算");
            show(reachability);
        } while (!equals(reachability, format(square(reachability))));

        System.out.println("可达矩阵：");
        show(reachability);

    }

    // 矩阵+单位矩阵
    public static int[][] addUnit(int primitive[][]) {
        int[][] result = new int[primitive.length][primitive.length];
        for (int x = 0; x < primitive.length; x++) {
            for (int y = 0; y < primitive[x].length; y++) {
                result[x][y] = primitive[x][y];
            }
        }
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                if (i == j) {
                    result[i][j] = 1;
                }
            }
        }
        return result;
    }

    // 打印矩阵
    public static void show(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + ",");
            }
            System.out.println();
        }
        System.out.println();
    }

    // 矩阵是否相等
    public static boolean equals(int a[][], int b[][]) {
        if (a.length != b.length) {// 行数是否相等
            return false;
        } else {
            for (int i = 0; i < a.length; i++) {
                if (a[i].length != b[i].length) {// i行列数是否相等
                    return false;
                } else {
                    for (int j = 0; j < a[i].length; j++) {
                        if (a[i][j] != b[i][j]) {// i行j列的数值是否相等
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    // 矩阵自乘
    public static int[][] square(int primitive[][]) {
        int[][] result = new int[primitive.length][primitive.length];
        int[][] list = new int[primitive.length][primitive.length];
        for (int x = 0; x < primitive.length; x++) {
            for (int y = 0; y < primitive[x].length; y++) {
                result[x][y] = primitive[x][y];
            }
        }
        int temp;
        for (int i = 0; i < result.length; i++) {
            for (int n = 0; n < result[i].length; n++) {
                temp = 0;
                for (int j = 0; j < result[i].length; j++) {
                    temp += result[i][j] * result[j][n];
                }
                list[i][n] = temp;
            }
        }
        return list;
    }

    // 格式化
    public static int[][] format(int primitive[][]) {
        int[][] result = new int[primitive.length][primitive.length];
        for (int x = 0; x < primitive.length; x++) {
            for (int y = 0; y < primitive[x].length; y++) {
                result[x][y] = primitive[x][y];
            }
        }
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                if (result[i][j] > 0) {
                    result[i][j] = 1;
                }
            }
        }
        return result;
    }
}

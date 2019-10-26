import java.util.*;

public class DijkstraShortReach {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = scanner.nextInt();
        for (int i = 0; i < input; i++) {
            int nodes = scanner.nextInt();
            int edges = scanner.nextInt();

            int[][] array = new int[nodes][nodes];
            for (int j = 0; j < nodes; j++) {
                for (int k = 0; k < nodes; k++) {
                    array[j][k] = 0;
                }
            }

            for (int j = 0; j < edges; j++) {
                int n = scanner.nextInt();
                int y = scanner.nextInt();
                int price = scanner.nextInt();
                if (array[n - 1][y - 1] != 0) {
                    if (price < array[n - 1][y - 1]) {
                        array[n - 1][y - 1] = price;
                        array[y - 1][n - 1] = price;
                    }
                } else {
                    array[n - 1][y - 1] = price;
                    array[y - 1][n - 1] = price;
                }
            }

            int start = scanner.nextInt() - 1;
            Map<Integer, Integer> visited = new HashMap<>();
            List<Integer> front = new ArrayList<>();
            visited.put(start, 0);
            front.add(start);
            while (!front.isEmpty()) {
                int cur = front.remove(0);
                for (int k = 0; k < nodes; k++) {
                    int cost = array[cur][k];
                    if (cost == 0) {
                        continue;
                    } else {
                        cost += visited.get(cur);
                        if (visited.containsKey(k)) {
                            if (visited.get(k) > cost) {
                                visited.put(k, cost);
                                front.add(k);
                            }
                        } else {
                            visited.put(k, cost);
                            front.add(k);
                        }
                    }
                }
            }

            print(nodes, visited, start);

        }
    }


    static void print(int nodes, Map<Integer, Integer> visited, int start) {

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < nodes; j++) {
            if (j == start) {
                continue;
            }
            if (!(sb.length() == 0)) {
                sb.append(" ");
            }
            if (visited.containsKey(j)) {
                sb.append("" + visited.get(j));
            } else {
                sb.append("-1");
            }
        }
        System.out.println(sb.toString());

    }

}
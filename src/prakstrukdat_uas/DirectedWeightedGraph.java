package prakstrukdat_uas;

import java.util.ArrayList;

public class DirectedWeightedGraph {

    private final int MAX_VERTS = 20;
    private Vertex vertexList[];
    private int adjMat[][];
    private int nVerts;

    private static final int TEMPORARY = 1;
    private static final int PERMANENT = 2;
    private static final int NULL = -1;
    private static final int INFINITY = 99999;

    public DirectedWeightedGraph() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for (int i = 0; i < MAX_VERTS; i++) {
            for (int j = 0; j < MAX_VERTS; j++) {
                adjMat[i][j] = 0;
            }
        }
    }

    public void addVertex(String label) {
        vertexList[nVerts++] = new Vertex(label);
    }

    public void addEdge(String start, String end, int length) {
        int intStart = findName(start);
        int intEnd = findName(end);
        if (intStart < 0 || intEnd < 0) {
            System.out.println("\n!! Gagal Menambahkan Jalur !!\n");
        } else {
            adjMat[intStart][intEnd] = length;
            System.out.println("Jalur Berhasil Ditambahkan : \n" + start + " --> " + end + " : " + length + " km\n");
        }
    }

    public void removeVertex(String cityName) {
        int index = findName(cityName);
        if (index >= 0) {
            // Remove the vertex and its associated edges
            vertexList[index] = null;
            for (int i = 0; i < nVerts; i++) {
                adjMat[index][i] = 0;
                adjMat[i][index] = 0;
            }
            displayResult("City removed: " + cityName);
        } else {
            displayResult("City not found: " + cityName);
        }
    }

    public void removeEdge(String start, String end) {
        int intStart = findName(start);
        int intEnd = findName(end);
        if (intStart >= 0 && intEnd >= 0) {
            // Remove the edge
            adjMat[intStart][intEnd] = 0;
            displayResult("Path removed: " + start + " to " + end);
        } else {
            displayResult("Invalid input. Please provide valid starting and ending cities.");
        }
    }

    private int findName(String name) {
        int status = -1;
        for (int i = 0; i < nVerts; i++) {
            if (vertexList[i].toString().equals(name)) {
                status = i;
            }
        }
        return status;
    }

    private void dijkstra(int intSource) {
        int v, c;

        for (v = 0; v < nVerts; v++) {
            vertexList[v].status = TEMPORARY;
            vertexList[v].pathLength = INFINITY;
            vertexList[v].predecessors = NULL;
        }

        vertexList[intSource].pathLength = 0;

        while (true) {
            c = tempVertexMinPL();

            if (c == NULL) {
                return;
            }
            vertexList[c].status = PERMANENT;

            for (v = 0; v < nVerts; v++) {
                if (isAdjacent(c, v) && vertexList[v].status == TEMPORARY) {
                    if (vertexList[c].pathLength + adjMat[c][v] < vertexList[v].pathLength) {
                        vertexList[v].predecessors = c;
                        vertexList[v].pathLength = vertexList[c].pathLength + adjMat[c][v];
                    }
                }
            }
        }
    }

    public String findPaths(String source) {
        int intSource = findName(source);
        if (intSource < 0) {
            return "\n!! Kota tidak ditemukan !!\n";
        } else {
            dijkstra(intSource);
            StringBuilder result = new StringBuilder("-------------------------------------------");
            result.append("\nKota Asal : ").append(source).append("\n");
            for (int v = 0; v < nVerts; v++) {
                result.append("Kota Tujuan : ").append(vertexList[v].toString());
                if (vertexList[v].pathLength == INFINITY) {
                    result.append("Tidak ada jalur yang tersedia dari ").append(source)
                            .append(" ke ").append(vertexList[v].toString()).append("\n");
                } else {
                    result.append(findPath(intSource, v));
                }
            }
            return result.toString();
        }
    }

    public String findPaths(String kotaAsal, String kotaTujuan) {
        int intAsal = findName(kotaAsal);
        int intTujuan = findName(kotaTujuan);
        dijkstra(intAsal);
        if (vertexList[intAsal].pathLength == INFINITY) {
            return "Tidak ada jalur yang tersedia dari " + kotaAsal + " ke " + vertexList[intTujuan].toString() + "\n";
        } else {
            return findPath(intAsal, intTujuan);
        }
    }

    private String findPath(int source, int end) {
        int i, u;
        int[] path = new int[nVerts];
        int length = 0;
        int count = 0;

        while (source != end) {
            count++;
            path[count] = end;
            u = vertexList[end].predecessors;
            length += adjMat[u][end];
            end = u;
        }
        count++;
        path[count] = source;

        StringBuilder result = new StringBuilder("Jalur Terdekat : ");
        for (i = count; i > 0; i--) {
            result.append(vertexList[path[i]].toString());
            if (i - 1 == 0) {
                result.append(".");
            } else {
                result.append(" --> ");
            }
        }
        result.append("\nJarak : ").append(length).append("\n");

        return result.toString();
    }

    private boolean isAdjacent(int start, int end) {
        return adjMat[start][end] != 0;
    }

    private int tempVertexMinPL() {
        int min = INFINITY;
        int index = NULL;
        for (int v = 0; v < nVerts; v++) {
            if (vertexList[v].status == TEMPORARY && vertexList[v].pathLength < min) {
                min = vertexList[v].pathLength;
                index = v;
            }
        }
        return index;
    }

    public ArrayList<String> getVertexList() {
        ArrayList<String> cities = new ArrayList<>();
        for (int i = 0; i < nVerts; i++) {
            cities.add(vertexList[i].toString());
        }
        return cities;
    }

    public ArrayList<String> getEdges() {
        ArrayList<String> edges = new ArrayList<>();
        for (int row = 0; row < nVerts; row++) {
            for (int col = 0; col < nVerts; col++) {
                if (adjMat[row][col] != 0) {
                    edges.add(vertexList[row].name + " --> " + vertexList[col].name + " = " + adjMat[row][col]);
                }
            }
        }
        return edges;
    }

    private void displayResult(String result) {
        System.out.println(result);
    }
}

package DataStructures.Lesson7;

import java.util.*;

public class Graph {

    private final List<Vertex> vertexList;
    private final boolean [][] adjMat;
    private int size;

    public Graph(int maxVertexCount) {
        this.vertexList = new ArrayList<>(maxVertexCount);
        this.adjMat = new boolean[maxVertexCount][maxVertexCount];
        this.size = 0;
    }

    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
        size++;
    }

    public int getSize() {
        return size;
    }

    public void addEdges(String startLabel, String secondLabel, String... others) {
        addEdge(startLabel, secondLabel);
        for (String anotherLabel : others) {
            addEdge(startLabel, anotherLabel);
        }
    }

    public void addEdge(String startLabel, String finishLabel) {
        int startIndex  = indexOf(startLabel);
        int finishIndex = indexOf(finishLabel);

        if (startIndex == -1 || finishIndex == -1) {
            throw new IllegalArgumentException(String.format("Invalid labels for vertexes: %s; %s",
                    startLabel, finishLabel));
        }

        adjMat[startIndex][finishIndex] = true;
        adjMat[finishIndex][startIndex] = true;
    }

    private int indexOf(String label) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).getLabel().equals(label)) {
                return i;
            }
        }
        return -1;
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(vertexList.get(i));
            for (int j = 0; j < size; j++) {
                if(adjMat[i][j]) {
                    System.out.print(" -> " + vertexList.get(j));
                }
            }
            System.out.println();
        }
    }

    public void dfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if(startIndex == 1) {
            throw new IllegalArgumentException("Invalid startLabel:" + startLabel);
        }
        Stack<Vertex> stack = new Stack<>();
        Vertex vertex = vertexList.get(startIndex);
        visitVertex(stack, vertex);

        while ((!stack.empty())) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if(vertex != null) {
                visitVertex(stack, vertex);
            }
            else {
                stack.pop();
            }
        }
        resetVertexState();
    }
    //Поиск в ширину
    public void bfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if(startIndex == 1) {
            throw new IllegalArgumentException("Invalid startLabel:" + startLabel);
        }
        Queue<Vertex> queue = new LinkedList<>();
        Vertex vertex = vertexList.get(startIndex);
        visitVertex(queue, vertex);

        while ((!queue.isEmpty())) {
            vertex = getNearUnvisitedVertex(queue.peek());
            if(vertex != null) {
                visitVertex(queue, vertex);
            }
            else {
                queue.remove();
            }
        }
        resetVertexState();
    }
    // Поиск кратчайшего пути
    public void shortestWay(String startLabel, String finishLabel ) {
        int startIndex = indexOf(startLabel);
        Vertex backWay = null;
        if(startIndex == -1) {
            throw new IllegalArgumentException("Invalid startLabel:" + startLabel);
        }
        Queue<Vertex> queue = new LinkedList<>();
        Stack<Vertex> stack = new Stack<>();
        Vertex vertex = vertexList.get(startIndex);
        visitVertex(queue, vertex);
        while ((!queue.isEmpty())) {
            vertex = getNearUnvisitedVertex(queue.peek());
            if(vertex != null) {
                vertex.setPrevious(queue.peek());
                visitVertex(queue, vertex);
                if(vertex.getLabel().equals(finishLabel)) {
                    backWay = vertex;
                    stack.push(backWay);
                    while (!backWay.getLabel().equals(startLabel)) {
                        stack.push(backWay.getPrevious());
                        backWay = backWay.getPrevious();
                    }
                    displayShortestWay(finishLabel, stack);
                    break;
                }
            }
            else {
                queue.remove();
            }
        }
        resetVertexState();
    }

    private void displayShortestWay(String finishLabel, Stack<Vertex> stack) {
        System.out.println();
        for (int i = 0; i < stack.size();) {
            if(!stack.peek().getLabel().equals(finishLabel)) {
                System.out.print(stack.pop().getLabel() + " --> ");
            }
            else {
                System.out.print(stack.pop().getLabel());
            }
        }
    }

    private void resetVertexState() {
        for (Vertex vertex : vertexList) {
            vertex.setVisited(false);
        }
    }

    private Vertex getNearUnvisitedVertex(Vertex peek) {
        int peekIndex = vertexList.indexOf(peek);
        for (int i = 0; i < size; i++) {
            if(adjMat[peekIndex][i] && !vertexList.get(i).isVisited()) {
                return vertexList.get(i);
            }
        }
        return null;
    }

    private void visitVertex(Stack<Vertex> stack, Vertex vertex) {
        System.out.println(vertex.getLabel());
        stack.push(vertex);
        vertex.setVisited(true);
    }

    private void visitVertex(Queue<Vertex> queue, Vertex vertex) {
        System.out.println(vertex.getLabel());
        queue.add(vertex);
        vertex.setVisited(true);
    }

}

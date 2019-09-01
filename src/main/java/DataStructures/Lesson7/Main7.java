package DataStructures.Lesson7;

public class Main7 {
    public static void main(String[] args) {
        Graph graph = new Graph(10);
        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Рязань");
        graph.addVertex("Калуга");
        graph.addVertex("Липецк");
        graph.addVertex("Тамбов");
        graph.addVertex("Орел");
        graph.addVertex("Саратов");
        graph.addVertex("Курск");
        graph.addVertex("Воронеж");

        graph.addEdges("Москва", "Тула", "Рязань", "Калуга");
        graph.addEdge("Тула", "Липецк");
        graph.addEdges("Липецк", "Воронеж");
        graph.addEdge("Рязань", "Тамбов");
        graph.addEdge("Тамбов", "Саратов");
        graph.addEdges("Саратов", "Воронеж");
        graph.addEdge("Калуга", "Орел");
        graph.addEdges("Орел", "Курск");
        graph.addEdges("Курск", "Воронеж");

        System.out.println("Vertex count: " + graph.getSize());
        graph.display();
    }
}

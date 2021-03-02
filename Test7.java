package lesson7;

public class Test7 {

    public static void main(String[] args) {
        testGraph();
    }

    private static void testGraph() {
        IGraph graph = new Graph(10);
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
        graph.addEdges("Тула", "Липецк");
        graph.addEdges("Рязань", "Тамбов");
        graph.addEdges("Калуга", "Орел");
        graph.addEdges("Липецк", "Воронеж");
        graph.addEdges("Тамбов", "Саратов");
        graph.addEdges("Орел", "Курск");
        graph.addEdges("Саратов", "Воронеж");
        graph.addEdges("Курск", "Воронеж");

        System.out.println("Size of graph is " + graph.getSize());
        graph.display();

        graph.getDistance("Москва","Воронеж");
    }
}

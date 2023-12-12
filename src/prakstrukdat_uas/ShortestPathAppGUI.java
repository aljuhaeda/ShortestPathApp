package prakstrukdat_uas;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.ActionListener;

public class ShortestPathAppGUI extends JFrame {

    private final DirectedWeightedGraph graph;
    private final JTextArea outputArea = new JTextArea(); // Initialize outputArea

    public ShortestPathAppGUI() {
        graph = new DirectedWeightedGraph();

        setTitle("Jalur Kurir Terpendek Project Akhir Struktur Data");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        add(createTitlePanel(), BorderLayout.NORTH);
        add(createOutputPanel(), BorderLayout.CENTER);
        add(createButtonPanel(), BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createOutputPanel() {
        JPanel outputPanel = new JPanel(new BorderLayout());
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Arial", Font.PLAIN, 18)); // Set font size
        JScrollPane scrollPane = new JScrollPane(outputArea);
        outputPanel.add(scrollPane, BorderLayout.CENTER);
        return outputPanel;
    }

    private JPanel createTitlePanel() {
        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("JALUR KURIR TERPENDEK");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titlePanel.add(titleLabel);
        return titlePanel;
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel();
        addButton("Bersihkan", e -> clearResults(), buttonPanel);
        addButton("Remove Kota", e -> removeCity(), buttonPanel);
        addButton("Remove Jalur", e -> removePath(), buttonPanel);
        addButton("Lihat Kota", e -> displayResult(graph.getVertexList()), buttonPanel);
        addButton("Lihat Jarak", e -> displayResult(graph.getEdges()), buttonPanel);

        JButton addCityButton = addButton("Tambah Kota", e -> addCity(), buttonPanel);
        JButton addPathButton = addButton("Tambah Jalur", e -> addPath(), buttonPanel);
        JButton findPathButton = addButton("Cari Jalur", e -> findPath(), buttonPanel);
        JButton findPathBetweenCitiesButton = addButton("Cari Jalur Antar Kota", e -> findPathBetweenCities(), buttonPanel);

        // Set colors for some buttons
        addCityButton.setBackground(Color.GREEN);
        addPathButton.setBackground(Color.BLUE);
        findPathButton.setBackground(Color.ORANGE);
        findPathBetweenCitiesButton.setBackground(Color.RED);

        return buttonPanel;
    }

    private JButton addButton(String label, ActionListener actionListener, JPanel panel) {
        JButton button = new JButton(label);
        button.addActionListener(actionListener);
        panel.add(button);
        return button;
    }

    private void displayResult(Object result) {
        if (result instanceof String) {
            outputArea.append((String) result + "\n");
        } else if (result instanceof ArrayList) {
            ArrayList<String> resultList = (ArrayList<String>) result;
            for (String line : resultList) {
                outputArea.append(line + "\n");
            }
        }
    }

    private void clearResults() {
        outputArea.setText("");
    }

    private void removeCity() {
        String cityName = JOptionPane.showInputDialog("Masukkan Kota untuk di remove:");
        if (cityName != null && !cityName.isEmpty()) {
            graph.removeVertex(cityName);
            displayResult("Kota removed: " + cityName);
        } else {
            displayResult("Invalid input. Tolong input nama kota yang benar.");
        }
    }

    private void removePath() {
        String startCity = JOptionPane.showInputDialog("Masukkan Kota Awal:");
        String endCity = JOptionPane.showInputDialog("Masukkan Kota Akhir:");

        if (startCity != null && endCity != null && !startCity.isEmpty() && !endCity.isEmpty()) {
            graph.removeEdge(startCity, endCity);
            displayResult("Jalur removed: " + startCity + " ke " + endCity);
        } else {
            displayResult("Invalid input. Tolong input kota awal dan akhir yang ada.");
        }
    }

    private void addCity() {
        String cityName = JOptionPane.showInputDialog("Masukkan nama kota:");
        if (cityName != null && !cityName.isEmpty()) {
            graph.addVertex(cityName);
            displayResult("Kota ditambah: " + cityName);
        } else {
            displayResult("Invalid input. Tolong input nama kota yang valid.");
        }
    }

    private void addPath() {
        String startCity = JOptionPane.showInputDialog("Masukkan kota awal:");
        String endCity = JOptionPane.showInputDialog("Masukkan kota akhir:");
        int distance = Integer.parseInt(JOptionPane.showInputDialog("Input jarak:"));

        if (startCity != null && endCity != null && distance > 0) {
            graph.addEdge(startCity, endCity, distance);
            displayResult("Jalur ditambah: " + startCity + " ke " + endCity + " (" + distance + " km)");
        } else {
            displayResult("Invalid input. tolong input kota dan jarak yang valid.");
        }
    }

    private void findPath() {
        String sourceCity = JOptionPane.showInputDialog("Masukkan kota sumber:");
        if (sourceCity != null && !sourceCity.isEmpty()) {
            displayResult(graph.findPaths(sourceCity));
        } else {
            displayResult("Invalid input. Tolong input kota sumber yang valid.");
        }
    }

    private void findPathBetweenCities() {
        String sourceCity = JOptionPane.showInputDialog("Masukkan kota asal:");
        String destinationCity = JOptionPane.showInputDialog("Masukkan kota tujuan:");

        if (sourceCity != null && destinationCity != null && !sourceCity.isEmpty() && !destinationCity.isEmpty()) {
            displayResult(graph.findPaths(sourceCity, destinationCity));
        } else {
            displayResult("Invalid input. Tolong input kot asal dan tujuan yang valid.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ShortestPathAppGUI());
    }
}

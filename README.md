# ShortestPathApp

ShortestPathApp is a Java application implementing the Dijkstra Algorithm. The app is designed to find and display the shortest paths between cities. The project includes a GUI (Graphical User Interface) to provide a user-friendly experience.

## Project Structure

```
ShortestPathApp/
│
├── build/
│
├── nbproject/
│
├── src/
│   ├── DirectedWeightedGraph.java
│   ├── ShortestPathAppGUI.java
│   ├── Vertex.java
│
├── test/
│
├── build.xml
├── LICENSE
└── README.md
```

- **`src/`**: Contains the main Java program files.
  - `DirectedWeightedGraph.java`: Implementation of the directed weighted graph.
  - `ShortestPathAppGUI.java`: Graphical User Interface for the ShortestPathApp.
  - `Vertex.java`: Class representing a vertex in the graph.

- **`build/`**: Directory for build-related files.

- **`nbproject/`**: NetBeans project files.

- **`test/`**: Directory for test-related files.

## Getting Started

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/your-username/ShortestPathApp.git
   ```

2. **Navigate to the Project Directory:**

   ```bash
   cd ShortestPathApp
   ```

3. **Open the Project in NetBeans:**

   Open NetBeans and select "Open Project." Navigate to the ShortestPathApp project directory and open it.

4. **Run the Application:**

   Find the main class (e.g., `ShortestPathAppGUI`) and run it.

## Usage

- Launch the application.
- Input the cities or vertices.
- Define the weighted edges between cities.
- Click on the "Find Shortest Path" button to calculate and display the shortest paths between specified cities.

## Contributing

Feel free to contribute to the project. If you have suggestions, improvements, or found a bug, please open an issue or create a pull request.

## License

ShortestPathApp is licensed under the [MIT License](LICENSE).

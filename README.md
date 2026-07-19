# ShortestPathApp — Dijkstra's Algorithm with a Java GUI

A Java desktop application that finds and displays the shortest path between cities using **Dijkstra's algorithm** on a directed weighted graph, wrapped in a Swing GUI.

[![Java](https://img.shields.io/badge/Java-ED8B00?logo=openjdk&logoColor=white)](https://openjdk.org/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

## Overview

Built as a data-structures course project. Given a set of cities and weighted edges (distances or costs) between them, the app computes and visualizes the shortest path between any two cities using Dijkstra's algorithm.

## Features

- Interactive Swing GUI for adding vertices and weighted edges
- Directed weighted graph implementation from scratch
- Dijkstra's shortest-path algorithm
- Displays computed shortest path and total cost

## Project Structure

```
ShortestPathApp/
├── src/prakstrukdat_uas/
│   ├── DirectedWeightedGraph.java   # Graph data structure
│   ├── Vertex.java                  # Vertex class
│   └── ShortestPathAppGUI.java      # Swing GUI + Dijkstra runner
├── build.xml                         # Ant build file
├── manifest.mf
├── LICENSE
└── README.md
```

## Getting Started

**Prerequisites** — JDK 8+ and NetBeans (or any Java IDE with Ant support).

**1. Clone the repo**

```bash
git clone https://github.com/aljuhaeda/ShortestPathApp.git
```

**2. Open in NetBeans**

`File → Open Project` and select the `ShortestPathApp` folder.

**3. Run**

Right-click `ShortestPathAppGUI.java` → `Run File`, or press `F6` to run the project.

## Usage

1. Add vertices (cities) via the GUI.
2. Add directed weighted edges (e.g., `A → B: 5`).
3. Select a source and destination.
4. Click **Find Shortest Path** — the app displays the path and total distance.

## License

MIT. See [LICENSE](LICENSE).

## Author

**Zul Iflah Al Juhaeda** — [LinkedIn](https://linkedin.com/in/aljuhaeda) · [GitHub](https://github.com/aljuhaeda)

# ShortestPathApp — Progress

## Status
Stable. Java Swing desktop app, no hosted demo — runs via NetBeans/Ant
or direct `javac`/`java`.

## Done
- Dijkstra's shortest-path algorithm on a directed weighted graph,
  Swing GUI for adding vertices/edges and finding paths.
- 4 real crash bugs fixed since original coursework submission:
  1. Removing a city left a null hole in the vertex list, crashing on
     the very next action.
  2. Path lookup between disconnected cities crashed instead of
     reporting "no path available" (checked source reachability instead
     of destination's).
  3. `Tambah Jalur` crashed on a cancelled/non-numeric distance dialog
     (unguarded `Integer.parseInt`) — now shows an error message.
  4. A shortest path touching every vertex could overflow its result
     array (off-by-one) — fixed.
- NetBeans project config was pointing at a class that no longer
  existed, meaning the README's own "press F6 to run" instructions
  would have failed — fixed.

## In progress
- Nothing currently active.

## Known issues / honest limitations
- Desktop-only (Swing), no packaged distributable — requires a JDK and
  either NetBeans/Ant or manual `javac`/`java` to run.
- `ShortestPathAppGUI.java` uses unchecked/unsafe generic operations
  (compiler warning, not an error) — cosmetic type-safety gap, not a
  functional bug.

## Verification log
- 2026-07-23: git working tree clean, no pending diff. `/security-review`
  skill checked — N/A, diff-based and nothing to review. Actually
  compiled `src/prakstrukdat_uas/*.java` with a real JDK (23.0.2) —
  succeeded with only an unchecked-operations warning, no errors.

## Next up
- Nothing scheduled.

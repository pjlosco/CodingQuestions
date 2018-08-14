import java.util.ArrayList;

/**
 * Given a boolean 2D matrix consisting only of 1's and 0's, find the number of islands.
 * A group of connected 1s forms an island.
 */
public class Islands {

    class Location {
        final int row;
        final int column;

        Location(int row, int column) {
            this.row = row;
            this.column = column;
        }

        public int getRow() {
            return row;
        }

        public int getColumn() {
            return column;
        }

        @Override
        public boolean equals(Object o) {
            Location location = (Location) o;
            return row == location.row &&
                    column == location.column;
        }
    }

    ArrayList<ArrayList<Location>> mapped;

    Islands() {
        mapped = new ArrayList<>();
    }

    public int NumberOfIslands(int[][] mat) {
        int islands = 0;
        int landPieces = 0;
        if (mat.length != 0) {
            // look at each row
            for (int row = 0; row < mat.length; row++) {
                // look at each column in row
                System.out.println("Looking at row: " + row);
                for (int column = 0; column < mat[0].length; column++) {
                    System.out.println("Looking at column: " + column);
                    if (mat[row][column] == 1) {
                        landPieces++;
                        System.out.println("** Land found at ["+ row +"][" + column + "]");
                        Location currentLocation = new Location(row, column);
                        this.evaluateIsland(mat, currentLocation);
                    }
                }
            }
            islands = mapped.size();
        }
        System.out.println("Land pieces = " + landPieces);
        return islands;
    }

    private void evaluateIsland(int[][] mat, Location currentLocation) {
        // edge case for top left square
        if (currentLocation.getRow() == 0 && currentLocation.getColumn() == 0) {
            addNewIsland(currentLocation);
        } else {
            // north
            boolean northResult = false;
            Location north = new Location(currentLocation.getRow() - 1, currentLocation.column);
            if (currentLocation.getRow() != 0) {
                northResult = checkConnection(mat, currentLocation, north);
            }

            // west
            boolean westResult = false;
            Location west = new Location(currentLocation.getRow(), currentLocation.column - 1);
            if (currentLocation.getColumn() != 0) {
                westResult = checkConnection(mat, currentLocation, west);
            }

            if (!northResult && !westResult) {
                addNewIsland(currentLocation);
            } else if (northResult && westResult){
                mergeIslands(north,west);
            }
        }
    }

    private void mergeIslands(Location north, Location west) {
        ArrayList<Location> first = popIsland(north);
        ArrayList<Location> second = popIsland(west);
        mapped.remove(first);
        mapped.remove(second);
        first.addAll(second);
        mapped.add(first);
        System.out.println("-+ Island merged");
    }

    private ArrayList<Location> popIsland(Location land) {
        for (ArrayList<Location> island : mapped) {
            if (island.contains(land)) {
                return island;
            }
        }
        throw new RuntimeException("Error");
    }

    private boolean checkConnection(int[][] mat, Location currentLocation, Location neighbor) {
        try {
            // if neighbor is out of bounds or 0 we skip
            if (mat[neighbor.getRow()][neighbor.getColumn()] == 1) {
                for (ArrayList<Location> innerIsland : mapped) {
                    if (listContainsLocation(innerIsland, neighbor)) {
                        innerIsland.add(currentLocation);
                        System.out.println("+ Island Attached!");
                        return true;
                    }
                }
                return true;
            }
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
        return false;
    }

    private boolean listContainsLocation(ArrayList<Location> theList, Location location) {
        for (Location entry : theList) {
            if (entry.equals(location)) {
                return true;
            }
        }
        return false;
    }

    private boolean addNewIsland(Location currentLocation) {
        ArrayList<Location> innerIsland = new ArrayList<>();
        innerIsland.add(currentLocation);
        mapped.add(innerIsland);
        System.out.println("+ Island Created!");
        return true;
    }
}

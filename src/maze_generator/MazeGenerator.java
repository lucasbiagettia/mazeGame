package maze_generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

import game.MazeGameConfiguration;

public class MazeGenerator {

	private Stack<Node> stack = new Stack<>();
	private Random rand = new Random();
	private Block[][] maze;
	private Integer rows;
	private Integer columns;

	public MazeGenerator() {
		rows = MazeGameConfiguration.rows;
		columns = MazeGameConfiguration.columns;
		maze = new Block[rows][columns];
	}

	public void generateMaze() {
		stack.push(new Node(0, 0));
		while (!stack.empty()) {
			Node next = stack.pop();
			if (validNextNode(next)) {
				maze[next.y][next.x] = Block.WALL;

				ArrayList<Node> neighbors = findNeighbors(next);
				randomlyAddNodesToStack(neighbors);
			}
		}
	}

	public Block[][] getMaze() {
		return maze;
	}

	private boolean validNextNode(Node node) {
		int numNeighboringOnes = 0;
		for (int y = node.y - 1; y < node.y + 2; y++) {
			for (int x = node.x - 1; x < node.x + 2; x++) {
				if (pointOnGrid(x, y) && pointNotNode(node, x, y) && maze[y][x] == Block.WALL) {
					numNeighboringOnes++;
				}
			}
		}
		return (numNeighboringOnes < 3) && maze[node.y][node.x] != Block.WALL;
	}

	private void randomlyAddNodesToStack(ArrayList<Node> nodes) {
		int targetIndex;
		while (!nodes.isEmpty()) {
			targetIndex = rand.nextInt(nodes.size());
			stack.push(nodes.remove(targetIndex));
		}
	}

	private ArrayList<Node> findNeighbors(Node node) {
		ArrayList<Node> neighbors = new ArrayList<>();
		for (int y = node.y - 1; y < node.y + 2; y++) {
			for (int x = node.x - 1; x < node.x + 2; x++) {
				if (pointOnGrid(x, y) && pointNotCorner(node, x, y) && pointNotNode(node, x, y)) {
					neighbors.add(new Node(x, y));
				}
			}
		}
		return neighbors;
	}

	private Boolean pointOnGrid(int x, int y) {
		return x >= 0 && y >= 0 && x < columns && y < rows;
	}

	private Boolean pointNotCorner(Node node, int x, int y) {
		return (x == node.x || y == node.y);
	}

	private Boolean pointNotNode(Node node, int x, int y) {
		return !(x == node.x && y == node.y);
	}
}
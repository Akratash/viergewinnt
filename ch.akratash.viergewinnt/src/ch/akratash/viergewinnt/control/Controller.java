package ch.akratash.viergewinnt.control;

import ch.akratash.viergewinnt.model.Board;
import ch.akratash.viergewinnt.model.Color;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class Controller {

	private Board m_board = new Board();

	public Label PlayerLabel = null;
	public Label WinnerLabel = null;

	public GridPane grid = null;

	@FXML
	private void handleTestButtonAction(ActionEvent event) {

		/**
		 * Alle Nodes zu Circles umwandeln da erweiterte Programmierung möglich.
		 */
		m_board = new Board();

		for (int i = 0; i < 7; i++) {
			renderColumn(i);
		}
	}

	private void renderColumn(final int columnIndex) {
		for (Node node : grid.getChildren()) {
			if (node instanceof Circle && GridPane.getColumnIndex(node) == columnIndex) {
				Circle circle = (Circle) node;

				/**
				 * Invertieren der Rows des Grids da der Index sonst nicht für den Code passt
				 */

				int convertedRowIndex = (GridPane.getRowIndex(node) - 5) * -1;

				if (Color.RED == m_board.getColor(columnIndex, convertedRowIndex)) {
					circle.setFill(Paint.valueOf("red"));
				} else if (Color.YELLOW == m_board.getColor(columnIndex, convertedRowIndex)) {
					circle.setFill(Paint.valueOf("yellow"));
				} else {
					circle.setFill(Paint.valueOf("grey"));
				}
			}
		}
	}

	private void renderLabels() {
		PlayerLabel.setText(m_board.getActivePlayer().toString());
		WinnerLabel.setText(m_board.getWinner().toString());
	}

	/**
	 * Buttons zum Steine setzen in der GUI mit der MAKEMOVE Methode
	 * @param event m_board.makeMove();
	 */
	@FXML
	private void handleSetCol0Action(ActionEvent event) {
		m_board.makeMove(0);
		renderColumn(0);
		renderLabels();
	}

	@FXML
	private void handleSetCol1Action(ActionEvent event) {
		m_board.makeMove(1);
		renderColumn(1);
		renderLabels();
	}

	@FXML
	private void handleSetCol2Action(ActionEvent event) {
		m_board.makeMove(2);
		renderColumn(2);
		renderLabels();
	}

	@FXML
	private void handleSetCol3Action(ActionEvent event) {
		m_board.makeMove(3);
		renderColumn(3);
		renderLabels();
	}

	@FXML
	private void handleSetCol4Action(ActionEvent event) {
		m_board.makeMove(4);
		renderColumn(4);
		renderLabels();
	}

	@FXML
	private void handleSetCol5Action(ActionEvent event) {
		m_board.makeMove(5);
		renderColumn(5);
		renderLabels();
	}

	@FXML
	private void handleSetCol6Action(ActionEvent event) {
		m_board.makeMove(6);
		renderColumn(6);
		renderLabels();
	}

}

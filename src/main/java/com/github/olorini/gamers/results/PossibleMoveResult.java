package com.github.olorini.gamers.results;

public class PossibleMoveResult {

	int symbolCounter = 0;
	Integer[] emptyCellCoordinate = null;

	public Integer[] getEmptyCellCoordinate() {
		return emptyCellCoordinate;
	}

	public void setEmptyCellCoordinate(Integer[] emptyCellCoordinate) {
		this.emptyCellCoordinate = emptyCellCoordinate;
	}

	public void incrementSymbolCounter() {
		symbolCounter ++;
	}

	public boolean isVictoryMove() {
		return symbolCounter == 2 && emptyCellCoordinate != null;
	}
}

package com.hph.algorithm;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CrossRiver {
	// The visited status set
	private Set visitedStatusSet = new HashSet();

	// The steps that need to be visited later.
	private LinkedList toVisitSteps = new LinkedList();

	private Status startStatus = new Status();
	private Status endStatus = new Status(true, true, true, true);

	// Available actions
	private static final int MAN_GO = 0;
	private static final int MAN_GO_WITH_WOLF = 1;
	private static final int MAN_GO_WITH_SHEEP = 2;
	private static final int MAN_GO_WITH_VEGETABLE = 3;
	private static final int MAN_BACK = 4;
	private static final int MAN_BACK_WITH_WOLF = 5;
	private static final int MAN_BACK_WITH_SHEEP = 6;
	private static final int MAN_BACK_WITH_VEGETABLE = 7;

	private boolean changeStatus(Status cur, int action, Status next) {
		next.man = cur.man;
		next.wolf = cur.wolf;
		next.sheep = cur.sheep;
		next.vegatable = cur.vegatable;

		switch (action) {
		case MAN_GO: {
			if (!cur.man) {
				next.man = true;
				return true;
			}
			break;
		}
		case MAN_GO_WITH_WOLF: {
			if (!cur.man && !cur.wolf) {
				next.man = true;
				next.wolf = true;
				return true;
			}
			break;
		}
		case MAN_GO_WITH_SHEEP: {
			if (!cur.man && !cur.sheep) {
				next.man = true;
				next.sheep = true;
				return true;
			}
			break;
		}
		case MAN_GO_WITH_VEGETABLE: {
			if (!cur.man && !cur.vegatable) {
				next.man = true;
				next.vegatable = true;
				return true;
			}
			break;
		}

		case MAN_BACK: {
			if (cur.man) {
				next.man = false;
				return true;
			}
			break;
		}
		case MAN_BACK_WITH_WOLF: {
			if (cur.man && cur.wolf) {
				next.man = false;
				next.wolf = false;
				return true;
			}
			break;
		}
		case MAN_BACK_WITH_SHEEP: {
			if (cur.man && cur.sheep) {
				next.man = false;
				next.sheep = false;
				return true;
			}
			break;
		}
		case MAN_BACK_WITH_VEGETABLE: {
			if (cur.man && cur.vegatable) {
				next.man = false;
				next.vegatable = false;
				return true;
			}
			break;
		}
		}
		return false;
	}

	public boolean isValid(Status status) {
		// MAN has crossed river, wolf and sheep havn't or sheep and vegetable
		// havn't yet
		if (status.man) {
			if ((!status.wolf && !status.sheep) || (!status.sheep && !status.vegatable)) {
				return false;
			}
		}
		if (!status.man) {
			if ((status.wolf && status.sheep) || (status.sheep && status.vegatable)) {
				return false;
			}
		}
		return true;
	}

	private void printSteps(List stepList) {
		for (Iterator iter = stepList.iterator(); iter.hasNext();) {
			Step step = (Step) iter.next();

			showStatus(step.curLoc);
		}
	}

	private void showStatus(Status status) {
		StringBuffer strBuf = new StringBuffer();

		if (!status.man) {
			strBuf.append("[M]");
		} else {
			strBuf.append("[ ]");
		}

		if (!status.wolf) {
			strBuf.append("[W]");
		} else {
			strBuf.append("[ ]");
		}

		if (!status.sheep) {
			strBuf.append("[S]");
		} else {
			strBuf.append("[ ]");
		}

		if (!status.vegatable) {
			strBuf.append("[V]");
		} else {
			strBuf.append("[ ]");
		}

		strBuf.append(" <=====> ");

		if (status.man) {
			strBuf.append("[M]");
		} else {
			strBuf.append("[ ]");
		}

		if (status.wolf) {
			strBuf.append("[W]");
		} else {
			strBuf.append("[ ]");
		}

		if (status.sheep) {
			strBuf.append("[S]");
		} else {
			strBuf.append("[ ]");
		}

		if (status.vegatable) {
			strBuf.append("[V]");
		} else {
			strBuf.append("[ ]");
		}

		System.out.println(strBuf.toString());
	}

	public void go() {
		visitedStatusSet.clear();
		toVisitSteps.clear();

		// init the status to be visited
		visitedStatusSet.add(startStatus);

		Step startStep = new Step(startStatus, null);
		toVisitSteps.addLast(startStep);

		boolean found = false;
		Step lastStep = null;
		// BFS, find the shortest path
		while (!toVisitSteps.isEmpty()) {
			Step step = (Step) toVisitSteps.removeFirst();

			// the end status, found it
			if (endStatus.equals(step.curLoc)) {
				found = true;
				lastStep = step;
				break;
			}

			for (int i = MAN_GO; i <= MAN_BACK_WITH_VEGETABLE; i++) {
				Status tempStatus = new Status();

				// 1. the current status can be changed via this action
				// 2. the changed status is valid
				// 3. the changed status is a new one. If not, ignore it
				if (changeStatus(step.curLoc, i, tempStatus) && isValid(tempStatus) && !visitedStatusSet.contains(tempStatus)) {
					visitedStatusSet.add(tempStatus);

					Step tempStep = new Step(tempStatus, step);
					toVisitSteps.addLast(tempStep);
				}
			}
		}

		if (!found) {
			System.out.println("Not found");
		} else {
			toVisitSteps.clear();

			Step step = lastStep;
			while (step != null) {
				toVisitSteps.addFirst(step);
				step = step.prevStep;
			}

			printSteps(toVisitSteps);
		}
	}

	private static class Status {
		public boolean man = false;
		public boolean wolf = false;
		public boolean sheep = false;
		public boolean vegatable = false;

		public Status() {
			this(false, false, false, false);
		}

		public Status(boolean man, boolean wolf, boolean sheep, boolean vegetable) {
			this.man = man;
			this.wolf = wolf;
			this.sheep = sheep;
			this.vegatable = vegetable;
		}

		public boolean equals(Object obj) {
			if (!(obj instanceof Status)) {
				return false;
			}
			Status other = (Status) obj;
			return man == other.man && wolf == other.wolf && sheep == other.sheep && vegatable == other.vegatable;
		}

		public int hashCode() {
			int hashCode = 0;
			if (man) {
				hashCode |= 1;
			}
			if (wolf) {
				hashCode |= 2;
			}
			if (sheep) {
				hashCode |= 4;
			}
			if (vegatable) {
				hashCode |= 8;
			}
			return hashCode;
		}
	}

	private static class Step {
		public Status curLoc = null;
		public Step prevStep = null;

		public Step(Status status, Step prev) {
			curLoc = status;
			prevStep = prev;
		}
	}

	public static void main(String[] args) {
		CrossRiver cr = new CrossRiver();
		cr.go();
	}
}

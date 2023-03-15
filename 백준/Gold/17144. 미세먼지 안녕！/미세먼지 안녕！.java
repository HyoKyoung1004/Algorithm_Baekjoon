import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int R, C, T;
	static int[][] arr;
	static int[][] visit;
	static ArrayList<Point> al;
	static Point airPoint;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		arr = new int[R][C];
		al = new ArrayList<>();
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] > 0)
					al.add(new Point(i, j));
				if (arr[i][j] == -1 && airPoint == null)
					airPoint = new Point(i, j);
			}
		}

		for (int i = 0; i < T; i++) {

			// 1.미세먼지 퍼트리기
			mimon();

			// 2. 공기청정기 작동

			left();
			visit[airPoint.x][airPoint.y ] = 0;
			visit[airPoint.x][airPoint.y + 1] = 0;

			right();
			visit[airPoint.x + 1][airPoint.y] = 0;
			visit[airPoint.x + 1][airPoint.y + 1] = 0;

			// 3.다음 시도를 위해 미세먼지 다시 al에 넣기, visit초기화
			if (i != T - 1) {
				
				intserMimon();
				arr = visit;
			} else {// 마지막 합 구하기

				System.out.println(totalSum());
			}

		}

	}
	

	private static int totalSum() {
		int sum=0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (visit[i][j] > 0)
					sum+= visit[i][j];
			}
		}
		
		return sum;
	}


	private static void intserMimon() {

		al.clear();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (visit[i][j] > 0)
					al.add(new Point(i, j));
			}
		}
	}


	private static void right() {

		int si = airPoint.x + 1, sj = 0, ei = R - 1, ej = C - 1;
		// 위
		int tmp = visit[si][ej];
		
		for (int j = ej; j > 0; j--) {
			visit[si][j] = visit[si][j - 1];
		}
		// 왼쪽
		for (int i = si; i < ei; i++) {
			visit[i][sj] = visit[i + 1][sj];
		}
		for (int j = 0; j < ej; j++) {
			visit[ei][j] = visit[ei][j + 1];
		}
		// 오른쪽
		for (int i = ei; i > si; i--) {
			visit[i][ej] = visit[i - 1][ej];
		}
		visit[si+1][ej]=tmp;
	}

	private static void left() {
		int si = 0, sj = 0, ei = airPoint.x, ej = C - 1;

		int tmp = visit[si][sj];
		// 위
		for (int j = 0; j < ej; j++) {
			visit[si][j] = visit[si][j + 1];
		}

		// 오른쪽
		for (int i = 0; i < ei; i++) {
			visit[i][ej] = visit[i + 1][ej];
		}

		// 아래
		for (int j = ej; j > 0; j--) {
			visit[ei][j] = visit[ei][j - 1];
		}

		// 왼쪽
		for (int i = ei; i > 0; i--) {
			visit[i][sj] = visit[i - 1][sj];
		}

		visit[si + 1][sj] = tmp;

	}

	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	private static void mimon() {
		visit = new int[R][C];

		for (int i = 0; i < al.size(); i++) {

			Point now = al.get(i);
			int dCount = 0;

			for (int d = 0; d < 4; d++) {
				int nextX = now.x + dx[d];
				int nextY = now.y + dy[d];

				if (nextX >= 0 && nextX < R && nextY >= 0 && nextY < C && !(nextX == airPoint.x && nextY == airPoint.y)
						&& !(nextX == airPoint.x + 1 && nextY == airPoint.y)) {
					dCount++;
				}
			}

			visit[now.x][now.y] += arr[now.x][now.y] - (arr[now.x][now.y] / 5) * dCount;

			for (int d = 0; d < 4; d++) {
				int nextX = now.x + dx[d];
				int nextY = now.y + dy[d];

				if (nextX >= 0 && nextX < R && nextY >= 0 && nextY < C && !(nextX == airPoint.x && nextY == airPoint.y)
						&& !(nextX == airPoint.x + 1 && nextY == airPoint.y)) {
					visit[nextX][nextY] += (arr[now.x][now.y] / 5);
				}
			}
		}

	}

}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, X, arr[][], ans;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();

		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());

			arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			ans=0;

			// 가로 먼저 확인
			for (int i = 0; i < N; i++) {
				// 평평한지 확인
				if (flat(i, true)) {
					ans++;
					continue;
				}

				boolean isOk = true;
				boolean[] visit = new boolean[N]; //
				for (int j = 1; j < N; j++) {

					if (arr[i][j - 1] == arr[i][j])
						continue;

					// 오름세이다.
					if (arr[i][j - 1] + 1 == arr[i][j]) {
						for (int k = j - X; k < j; k++) {
							if (k < 0 || visit[k] || arr[i][k] != arr[i][j - 1]) {
								isOk = false;
								break;
							} else
								visit[k] = true;
						}
					}

					// 내림새이다.
					else if (arr[i][j - 1] - 1 == arr[i][j]) {
						for (int k = j; k < j + X; k++) {
							if (k >= N || visit[k] || arr[i][k] != arr[i][j]) {
								isOk = false;
								break;
							} else
								visit[k] = true;
						}
					} else { // 오름세 내림새가 1칸 이상인 경우
						isOk = false;
						break;
					}
				}

				if (isOk) {
					ans++;
					// System.out.println(i);
				}

			}

			// 세로
			for (int j = 0; j < N; j++) {
				// 평평한지 확인
				if (flat(j, false)) {
					ans++;
					continue;
				}

				boolean isOk = true;
				boolean[] visit = new boolean[N]; //
				for (int i = 1; i < N; i++) {

					if (arr[i - 1][j] == arr[i][j])
						continue;

					// 오름세이다.
					if (arr[i - 1][j] + 1 == arr[i][j]) {
						for (int k = i - X; k < i; k++) {
							if (k < 0 || visit[k] || arr[k][j] != arr[i - 1][j]) {
								isOk = false;
								break;
							} else
								visit[k] = true;
						}
					}

					// 내림새이다.
					else if (arr[i - 1][j] - 1 == arr[i][j]) {
						for (int k = i; k < i + X; k++) {
							if (k >= N || visit[k] || arr[k][j] != arr[i][j]) {
								isOk = false;
								break;
							} else
								visit[k] = true;
						}
					} else { // 오름세 내림새가 1칸 이상인 경우
						isOk = false;
						break;
					}
				}

				if (isOk) {
					ans++;
					// System.out.println(i);
				}

			}

			sb.append("#"+tc+" "+ans+"\n");
		}
		System.out.println(sb);
	}

	static boolean flat(int n, boolean isrow) {
		if (isrow) {
			int tmp = arr[n][0];
			for (int j = 1; j < N; j++) {
				if (tmp != arr[n][j])
					return false;
			}
			return true;
		} else {
			int tmp = arr[0][n];
			for (int i = 1; i < N; i++) {
				if (tmp != arr[i][n])
					return false;
			}
			return true;
		}
	}

}

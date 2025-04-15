
import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Culc
 */
@WebServlet("/Culc")
public class Culc extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Culc() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("imput2.html");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 計算結果を表示する為のString ans。エラー表示にも使うためStringで定義
		String ans = null;
		// 入力値を取得
		String x1 = request.getParameter("one");
		String y1 = request.getParameter("twice");

		// 入力値が空欄の場合の処理
		if (x1.equals(null) || y1.equals(null) || x1.isEmpty() || y1.isEmpty()) {
			ans = "空欄があります。";

		} else {

			/*
			 * 入力値が正常の場合 計算を開始
			 */
			int x = Integer.parseInt(x1);
			int y = Integer.parseInt(y1);

			/*
			 * 四則演算子を取得
			 * Switch文にて演算方法により処理を分ける
			 */
			String z = request.getParameter("culc1");
			switch (z) {
			case "+":
				ans = String.valueOf(x + y);
				break;
			case "-":
				ans = String.valueOf(x - y);
				break;
			case "*":
				ans = String.valueOf(x * y);
				break;

			//割り算の場合0が分母に入力された場合のエラーを表示
			case "/":
				if (y == 0) {
					ans = "０で割ることはできません。";

					//分母　＞　分子の場合のエラーを表示
				} else if (y < x) {
					ans = ":0 割れない数値が入力されました。";

				} else {
					ans = String.valueOf(x / y);
				}
				break;
			default:
				ans = "無効な演算子です。";
			}
		}
		request.setAttribute("ans", ans);

		RequestDispatcher rd = request.getRequestDispatcher("output2.jsp");
		rd.forward(request, response);

	}
}

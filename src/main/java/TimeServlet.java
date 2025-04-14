
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TimeServlet
 */
@WebServlet("/TimeServlet")
public class TimeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TimeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		/*
		 * output.jsp から戻るボタンからの処理。
		 * input.htmlへ戻る処理を追加
		 */
		RequestDispatcher returnRd = request.getRequestDispatcher("input.html");
		returnRd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//●時間後の数値を取得してint化
		String num1 = request.getParameter("num1");
		int calcHour = Integer.parseInt(num1);

		//現在時刻を取得
		Calendar calendar = Calendar.getInstance();

		//時刻の表示するシンプルデータフォーマットを生成
		SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");
		//年月日の表示するシンプルデータフォーマットを生成
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy/MM/dd");
		//現在時刻のSDFに変換
		Date d1 = calendar.getTime();
		calendar.add(Calendar.HOUR_OF_DAY, calcHour);

		Date d2 = calendar.getTime();

		/*
		 * カウントダウン用
		 * 入力された時間で現在時間を引いた残り時間を計算
		 */

		long d3 = (d2.getTime() - d1.getTime());
		// longをデータ型に変換
		Date d4 = new Date(d3 - 9 * 60 * 60 * 1000);

		//●時間後を計算

		//nowtimeに時:分:秒の形にSDF形式で引き渡し
		request.setAttribute("nowtime", sdfTime.format(d1));
		//nowdateに年/月/日の形にSDF形式で引き渡し
		request.setAttribute("nowdate", sdfDate.format(d1));
		// 計算後の時間表示
		request.setAttribute("afterCalcHour", sdfTime.format(d2));
		//何時間後かの表示
		request.setAttribute("num1", num1);
		// カウントダウン
		request.setAttribute("d4", sdfTime.format(d4));

		//出力結果へ
		RequestDispatcher rd = request.getRequestDispatcher("output.jsp");
		rd.forward(request, response);
	}

}

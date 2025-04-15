<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>＜output＞プログラミング課題中級演習02</title>

</head>
<body>
	<!-- 現在の日付を取得-->
	<p>
		現在の日付:
		<%=request.getAttribute("nowdate")%></p>
	<!--現在の時間を取得-->
	<p>
		現在の時刻:
		<%=request.getAttribute("nowtime")%></p>
	<!-- 指定時間後の時刻 ""-->
	<p><%=request.getAttribute("num1")%>時間後の時刻:
		<%=request.getAttribute("afterCalcHour")%>
	</p>

	<p>
		残り時間: <span id="countdown"></span>
	</p>

	<!-- 戻るボタン -->
	<form action="TimeServlet" method="get">
		<input type="submit" value="戻る">
	</form>
	<script>
		//残り時間を取得し targetに格納
		const targetMillis =
	<%=request.getAttribute("d4")%>
		;
		// 終了時のメッセージを設定 
		const message = "時間が経過しました！";
		// countダウンの要素を取得
		const elmid = document.getElementById("countdown");

		//
		let remain = targetMillis;

		const timer = setInterval(function() {

			if (remain < 0) {
				clearInterval(timer); //タイマーを止める
				elmid.innerHTML = message; //終了メッセージを表示
				return;
			}
			//時間
			const hours = Math.floor((remain / (1000 * 60 * 60)) % 24);
			//分
			const minutes = Math.floor((remain / (1000 * 60)) % 60);
			//秒
			const seconds = Math.floor((remain / (1000)) % 60);

			//タイマーの時間の表示を整える
			elmid.innerHTML = hours + "時" + minutes + "分" + seconds + "秒";
			remain -= 1000;
		}, 1000); //毎秒実行
	</script>
</body>
</html>
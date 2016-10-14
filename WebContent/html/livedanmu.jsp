<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>live</title>
		<link rel="stylesheet" href="../css/bootstrap.css">
		<script src="../js/jquery-1.11.0.min.js"></script>
		<script src="../js/bootstrap.min.js"></script>
		<link rel="stylesheet" href="../css/danmuplayer.css">
		<script src="../js/jquery-1.11.1.min.js"></script>
		<script src="../js/jquery.danmu.js"></script>
		<script src="../js/danmu_player_core.js"></script>
		<script src="../js/video1.js"></script>
		<script src="../js/colpick.js"></script>
		<script src="../js/sco.tooltip.js"></script>
	</head>
	<body>
		<div style="width:100%"><h2 style="text-align: center;color:#DE6C6C">μ's Final LoveLive! 〜μ'sic forever</h2></div>
		<ul class="nav nav-pills">
			<li class="dropdown active" id="day01">
				<a class="dropdown-toggle" data-toggle="dropdown">day01<span class="caret"></a>
				<ul class="dropdown-menu">
					<li class="active"><a>part1</a></li>
					<li><a>part2</a></li>
					<li><a>part3</a></li>
				</ul>
			</li>
			<li class="" id="day02">
				<a class="dropdown-toggle" data-toggle="dropdown">day02<span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li class="active"><a>part1</a></li>
					<li><a>part2</a></li>
					<li><a>part3</a></li>
				</ul>
			</li>
		</ul>
		<div id="danmu">
		</div>
		<div><video src="http://localhost:8080/lovelive.beta/getLLLive.lovelive" autoplay="autoplay" controls="controls"></video></div>
	</body>
	<script>
		$("#day01").click(function(){
			$("#day02").removeClass("active");
			$(this).addClass("active");
			$("#day02").children("ul").children("li").removeClass("active");
			$("#day02").children("ul").children(":first").addClass("active");
		});
		$("#day02").click(function(){
			$("#day01").removeClass("active");
			$(this).addClass("active");
			$("#day01").children("ul").children("li").removeClass("active");
			$("#day01").children("ul").children(":first").addClass("active");
		});
		$("#day01 ul li").click(function(){
			$("#day01 ul li").removeClass("active");
			$(this).addClass("active");
		});
		$("#day02 ul li").click(function(){
			$("#day02 ul li").removeClass("active");
			$(this).addClass("active");
		});
	
		$("#danmu").danmuplayer({
			src:"http://localhost:8080/lovelive.beta/getLLLive.lovelive",
			width:800,
			height:450,
			speed:20000,
			danmuList:{},
			opacity:"1"
		});
// 		$("#danmu .danmu-div").danmu("addDanmu",[{text:"这是滚动弹幕" ,color:"white",size:1,position:0,time:50}
// 			,{text:"这是顶部弹幕" ,color:"yellow" ,size:1,position:1,time:50}
// 			,{text:"这是底部弹幕" , color:"red" ,size:1,position:2,time:50}]);
	</script>
</html>
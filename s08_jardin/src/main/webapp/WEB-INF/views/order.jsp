<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="description" content="JARDIN SHOP" />
<meta name="keywords" content="JARDIN SHOP" />
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scaleable=no" />
<link rel="stylesheet" type="text/css" href="/css/reset.css?v=Y" />
<link rel="stylesheet" type="text/css" href="/css/layout.css?v=Y" />
<link rel="stylesheet" type="text/css" href="/css/content.css?v=Y" />
<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript" src="/js/top_navi.js"></script>
<script type="text/javascript" src="/js/left_navi.js"></script>
<script type="text/javascript" src="/js/main.js"></script>
<script type="text/javascript" src="/js/common.js"></script>
<script type="text/javascript" src="/js/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="/js/idangerous.swiper-2.1.min.js"></script>
<script type="text/javascript" src="/js/jquery.anchor.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
    

	<!-- container -->
	<div id="container">

		

	
	
	<script type="text/javascript">initSubmenu(1,0);</script>

			<!-- contents -->
			<div id="contents">
				<div id="mypage">
					<h2><strong>주문/배송 조회</strong><span>회원님이 구매하신 주문내역 및 배송정보를 확인하실 수 있습니다.</span></h2>
					
		

					<h3>주문/배송 조회</h3>
					<div class="checkDiv">
						<table height="30" summary="기간별, 상태별, 단어검색별로 주문/배송 조회를 하실수 있습니다." class="checkTable" border="1" cellspacing="0">
							<caption>주문/배송 조회</caption>
							<colgroup>
							<col width="22%" class="tw30" />
							<col width="*" />
							</colgroup>
							<tbody height="30">
						
								<tr height="30">
									<th scope="row"  ><span>상태별 검색</span></th>
									<td >
										<select>
										    <option value="product">전체</option>
											<option value="medicine">의약품</option>
											<option value="daily_product">생필품</option>
										</select>
									</td>
								</tr>
								<tr>
									<th scope="row"><span>단어 검색</span></th>
									<td>
										<ul class="pta">
											<li class="or10"><input type="text" class="w186" /></li>
											<li><a href="#" class="nbtnMini iw56">검색</a></li>
										</ul>
									</td>
								</tr>
							</tbody>
						</table>
					</div>


					<div class="orderDiv">
						<table summary="주문일자/주문번호, 상품명, 가격, 수량, 주문상태 순으로 조회를 하실수 있습니다." class="orderTable" border="1" cellspacing="0">
							<caption>주문게시판</caption>
							<colgroup>
							<col width="25%" class="tw28" />
							<col width="*" />
							<col width="15%" class="tnone" />
							<col width="8%" class="tnone" />
							<col width="18%" class="tw30" />
							</colgroup>
							<thead>
								<th scope="col">주문일자 <span>/ 주문번호</span></th>
								<th scope="col">상품명</th>
								<th scope="col" class="tnone">가격</th>
								<th scope="col" class="tnone">수량</th>
								<th scope="col">주문상태</th>
							</thead>
							<tbody>
							<c:forEach var="order" items="${list }">
								<tr>
									<td>
										<p class="day">${order.order_date}</p>
										<p class="orderNum">${order.order_no}</p>
									</td>
									<td class="left">
								<%-- ${order. } (상품 이름) --%>
									</td>
									<td class="tnone"><%-- ${order. } 원 --%></td>
									<td class="tnone"><%-- ${order.item_count }개 --%></td>
									<td>
										<span class="heavygray">${order.order_status}</span>
										<ul class="state">	
											<li><a href="#" class="reviewbtn">리뷰작성</a></li>
										</ul>										
									</td>
								</tr>
							</c:forEach>

			
							
							</tbody>
						</table>

						<div class="noData">
							등록된 상품이 없습니다.
						</div>
					</div>
					
					<div >
						<ul>	
													<li><a href="return.html" class="nbtnMini iw40">반품</a></li>
						</ul>
					</div>
					
					<div class="btnAreaList">
						<!-- 페이징이동1 -->
						<div class="allPageMoving1">

						<a href="#" class="n"><img src="../images/btn/btn_pre2.gif" alt="처음으로"/></a><a href="#" class="pre"><img src="../images/btn/btn_pre1.gif" alt="앞페이지로"/></a>
						<c:forEach var="num" begin="${pageDto.startPage }" 
											end="${pageDto.maxPage }" step="1">
						<c:if test="${num != pageDto.page }">
							<a href="/mypage/order?page=${num }">${num }</a>
						</c:if>
						<c:if test="${num == pageDto.page }">
							<strong>${num }</strong>
						</c:if>
					</c:forEach>
						<a href="#" class="next"><img src="../images/btn/btn_next1.gif" alt="뒤페이지로"/></a><a href="#" class="n"><img src="../images/btn/btn_next2.gif" alt="마지막페이지로"/></a>

						</div>
						<!-- //페이징이동1 -->
					</div>


					


<script type="text/javascript" src="../js/jquery.fancybox-1.3.4.pack.js"></script>
<link rel="stylesheet" type="text/css" href="../css/jquery.fancybox-1.3.4.css" />
<script type="text/javascript">
$(function(){
	function distance(){
		var winWidth = $(window).width();
		if(winWidth > 767){
			$(".productList ul li:nth-child(4n+4)").css("padding","0 0 0 0");
		}else{
			$(".productList ul li:nth-child(4n+4)").css("padding","0 10px");
		}
	}
	distance();
	$(window).resize(function(){distance();});


	// layer popup
	var winWidth = $(window).width();
	if(winWidth > 767){
		var layerCheck = 760;
	}else{
		var layerCheck = 320;
	}

	$(".iw40").fancybox({
		'autoDimensions'    : false,
		'showCloseButton'	: false,
		'width' : layerCheck,
		'padding' : 0,
		'type'			: 'iframe',
		'onComplete' : function() {
			$('#fancybox-frame').load(function() { // wait for frame to load and then gets it's height
			$('#fancybox-content').height($(this).contents().find('body').height());
			});
		}
	});

});
</script>



				</div>
			</div>
			<!-- //contents -->


		</div>
	</div>
	<!-- //container -->





</div>
</div>
</body>
</html>
/*
	글작성시 첨부파일 관리 JS
*/

	let count=0;

function fileAddInit(c) {
	count = c;
	$("#fileAdd").click(

		function() {
			if (count > 4) {
				alert('최대 5개만 가능');
				return;
			}
			let result = '<div class="input-group mt-2">';
			result = result + '<input class="form-control files" type="file" name="files">';
			result = result + '<button class="btn btn-outline-secondary del" type="button">delete</button>';
			result = result + '</div>';
			$("#fileResult").append(result);
			count++;
		});

	$('#fileResult').on("click", ".del", function() {
		$(this).parent().remove();
		count--;
	});

}
function fileDeleteInit() {
	$(".del").click(function() {
		let check = window.confirm("정말로 삭제하시겠습니까?");
		if(!check){
			return;
		}
		let fileNum = $(this).attr("data-num");
		let selector = $(this);
		console.log(this);
		console.log(selector);
		$.ajax({
			type: "POST",
			url: "./fileDelete",
			data: {
				fileNum: fileNum
			},
			success: function(data) {
				if(data.trim()=='1'){					
				$(selector).parent().remove();
				count--;
				}
				else{
					alert("삭제 실패2");
				}
			},
			error: function() {
				alert("삭제 실패1");
			}
		})

	});
}
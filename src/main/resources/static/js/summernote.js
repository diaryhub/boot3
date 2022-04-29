/*
	summernote JS
*/

function summernoteInit(selector, code) {
	$('#'+selector).summernote({
		height: 400,
		placeholder:'내용을 입력하세요.',
			callbacks: {
				onImageUpload: function(files) {
				// upload image to server and create imgNode...
					let formData = new FormData();
					formData.append("files",files[0]);
					$.ajax({
						type:"POST",
						url:"./summerFileUpload",
						data:formData,
						contentType:false,
						processData:false,
						success:function(data){
							$('.note-image-input').val('');
							console.log(data.trim());
							$("#contents").summernote('editor.insertImage',data.trim());
						},
						error: function(){
							alert("에러");
						}
				
					});
				},
				onMediaDelete:function(files){
					let fileName = $(files[0]).attr("src");
					$.ajax({
						type:"GET",
						url:"./summerFileDelete",
						data:{
							fileName:fileName
						},
						success:function(data){
							console.log(data);
						}
					});
				}//onMediaDelete 끝
			}
	});
	$('#'+selector).summernote('code',code);

}

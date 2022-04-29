
		$('#contents').summernote({
			height:400,
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
			let count=0;
		$("#fileAdd").click(function() {
			if(count>4){
				alert('최대 5개만 가능');
				return;
			}
			let result = '<div class="input-group mt-2">';
			result = result + '<input class="form-control" type="file" id="formFileMultiple" name="files">';
			result = result + '<button class="btn btn-outline-secondary del" type="button">delete</button>';
			result = result + '</div>';
			$("#fileResult").append(result);
			count++;
		});
		
		$('#fileResult').on("click",".del",function(){
			$(this).parent().remove();
			count--;
		});
		
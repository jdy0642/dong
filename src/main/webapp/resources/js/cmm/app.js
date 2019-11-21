var app = app || {}
app =(()=>{
	let _,js
	let run =x=> 
		$.when(
				$.getScript(x+'/resources/js/cmm/router.js',()=>{
					$.extend(new Session(x))
					}),
				$.getScript(x+'/resources/js/cmm/pop.js')
		).done(()=>{
				init()
				onCreate()
		}).fail(()=>{
				alert('실패')
		})
	
	let init=()=>{
		_=$.ctx();
		js= $.js();
	}
	let onCreate =()=>{
		$(pop.view()).appendTo('#wrapper')
		.css({
			height:'120px'
		})
		pop.open()
			setContentView()
	}
	let setContentView = ()=>{
		$('<table id="tab"><tr></tr></table>')
		.css({
			width:'80%',
			height: '400px',
			border:'1px solid black',
			margin:'0 auto'
		})
		.appendTo('body')
		$('<td/>',{id:'left'})
		.css({
			width:'20%',
			height: '100%',
			border:'1px solid black',
			'vertical-align':'top'
		})
		.appendTo('tr')
		$('<td/>',{id:'right'})
		.css({
			width: '80%',
			height:'100%',
			border:'1px solid black',
			'vertical-align':'top'
		})
		.appendTo('tr')
		$.each(['NAVER','CGV','BUGS'],(i,j)=>{
			$('<div/>')
			.text(j)
			.css({
				width:'100%',
				height:'50px',
				border: '1px solid black',
				'text-align': 'center'
			})
			.appendTo('#left')
			.click(function(){
				$(this).css({'background-color':'skyblue'})
				$(this).siblings().css({'background-color':'white'})
				alert($(this).text())
			switch ($(this).text()) {
			case 'NAVER':
				$.getJSON(_+'/crawl/naver',d=>{
					$('#right').empty()
					$.each(d,(i,j)=>{
						$('<div/>')
						.css({
							width: '45%',
							height:'50%',
							border:'3px solid red',
							float:'left',
							'text-align': 'center'
						})
						.html('<h3>'+j.word+'</h3>'+'</br>'+j.mean)
						.appendTo('#right')
					})
				})
				break;
			case 'CGV':
				$.getJSON(_+'/crawl/cgv',d=>{
					$('#right').empty()
					$.each(d,(i,j)=>{
						$('<div/>')
						.css({
							width: '32%',
							height:'400px',
							border:'2px solid black',
							float:'left',
							'text-align': 'center'
						})
						.html(j.title+'</br></br>'+j.percent+'</br></br>'+j.textinfo+'</br></br>'+j.img)
						.appendTo('#right')
					})
				})
				break;
			case 'BUGS':
					list(0)
					break;
			}
		})
	})
}
	let list =x=>{
		$.getJSON(_+'/crawl/bugs/page/'+x,d=>{
			
			let list = d.list
			let pager = d.pager
			
			$('#right').empty()
		$('<table id = "content"><tr id="head"></tr></table>')
        .css({width:'99%',
           height:'80px',
           border:'1px solid black'})
        .appendTo('#right')
        
        $.each(['No.','가수','제목','표지'],(i,j)=>{
           $('<th/>')
           .html('<b>'+j+'</b>')
           .css({width:'25%',
              height:'100%',
              border:'1px solid black',
              })
           .appendTo('#head')
        })

		$.each(list,(i,j)=>{
			$('<tr><td>'+j.seq+'</td><td>'+j.artist+'</td><td>'+j.title+'</td><td><img src="'+j.thumbnail+'"/></td></tr>')
			.css({
				width: '25%',
				height:'100%',
				border:'1px solid black',
				'text-align-last':'center'
			})
			.appendTo('#content tbody')
		})
		$('#content tr td')
		.css({
			border:'1px solid black'
		})
		$('<div/>',{
			id:'pagination'
		})
		.css({
			width: '20%',
			height:'50px',
			margin:'20px auto'
				})
		.appendTo('#right')
		
		if(pager.existPrev){
			$('<span/>')
			.css({
				width: '50px',
				height:'30px',
				border:'1px solid black',
				display: 'inline-block',
				'text-align':'center',
			})
			.text('Prev')
			.appendTo('#pagination')
			.click(()=>{
				alert('하위1')
				app.list(pager.prevBlock)
			})
		}
		
		let i = pager.startPage
		for(; i<=pager.endPage;i++) {
			$('<span/>')
			.css({
				width: '30px',
				height:'30px',
				border:'1px solid black',
				display: 'inline-block',
				'text-align':'center',
			})
			.text(i+1)
			.appendTo('#pagination')
			.click(function(){
				app.list(parseInt($(this).text())-1)
			})
			
		}	
		if(pager.existNext){
			$('<span/>')
			.css({
				width: '50px',
				height:'30px',
				border:'1px solid black',
				display: 'inline-block',
				'text-align':'center',
			})
			.text('Next')
			.appendTo('#pagination')
			.click(()=>{
				alert('하위2')
				app.list(pager.nextBlock)
			})
		}
	})
}
		
	return{run, list}
})()